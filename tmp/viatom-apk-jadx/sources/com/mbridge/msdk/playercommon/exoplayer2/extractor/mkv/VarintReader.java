package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class VarintReader {
    private static final int STATE_BEGIN_READING = 0;
    private static final int STATE_READ_CONTENTS = 1;
    private static final long[] VARINT_LENGTH_MASKS = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private final byte[] scratch = new byte[8];
    private int state;

    public static long assembleVarint(byte[] bArr, int i10, boolean z9) {
        long j10 = bArr[0] & 255;
        if (z9) {
            j10 &= ~VARINT_LENGTH_MASKS[i10 - 1];
        }
        for (int i11 = 1; i11 < i10; i11++) {
            j10 = (j10 << 8) | (bArr[i11] & 255);
        }
        return j10;
    }

    public static int parseUnsignedVarintLength(int i10) {
        int i11 = 0;
        while (true) {
            long[] jArr = VARINT_LENGTH_MASKS;
            if (i11 >= jArr.length) {
                return -1;
            }
            if ((jArr[i11] & i10) != 0) {
                return i11 + 1;
            }
            i11++;
        }
    }

    public final int getLastLength() {
        return this.length;
    }

    public final long readUnsignedVarint(ExtractorInput extractorInput, boolean z9, boolean z10, int i10) throws InterruptedException, IOException {
        if (this.state == 0) {
            if (!extractorInput.readFully(this.scratch, 0, 1, z9)) {
                return -1L;
            }
            int unsignedVarintLength = parseUnsignedVarintLength(this.scratch[0] & 255);
            this.length = unsignedVarintLength;
            if (unsignedVarintLength == -1) {
                c.g("No valid varint length mask found");
                return 0L;
            }
            this.state = 1;
        }
        int i11 = this.length;
        if (i11 > i10) {
            this.state = 0;
            return -2L;
        }
        if (i11 != 1) {
            extractorInput.readFully(this.scratch, 1, i11 - 1);
        }
        this.state = 0;
        return assembleVarint(this.scratch, this.length, z10);
    }

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }
}

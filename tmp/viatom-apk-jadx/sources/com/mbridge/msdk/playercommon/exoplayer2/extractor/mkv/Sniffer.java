package com.mbridge.msdk.playercommon.exoplayer2.extractor.mkv;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Sniffer {
    private static final int ID_EBML = 440786851;
    private static final int SEARCH_LENGTH = 1024;
    private int peekLength;
    private final ParsableByteArray scratch = new ParsableByteArray(8);

    private long readUint(ExtractorInput extractorInput) throws InterruptedException, IOException {
        int i10 = 0;
        extractorInput.peekFully(this.scratch.data, 0, 1);
        int i11 = this.scratch.data[0] & 255;
        if (i11 == 0) {
            return Long.MIN_VALUE;
        }
        int i12 = 128;
        int i13 = 0;
        while ((i11 & i12) == 0) {
            i12 >>= 1;
            i13++;
        }
        int i14 = i11 & (~i12);
        extractorInput.peekFully(this.scratch.data, 1, i13);
        while (i10 < i13) {
            i10++;
            i14 = (this.scratch.data[i10] & 255) + (i14 << 8);
        }
        this.peekLength = i13 + 1 + this.peekLength;
        return i14;
    }

    public final boolean sniff(ExtractorInput extractorInput) throws InterruptedException, IOException {
        long length = extractorInput.getLength();
        long j10 = 1024;
        if (length != -1 && length <= 1024) {
            j10 = length;
        }
        int i10 = (int) j10;
        extractorInput.peekFully(this.scratch.data, 0, 4);
        long unsignedInt = this.scratch.readUnsignedInt();
        this.peekLength = 4;
        while (unsignedInt != 440786851) {
            int i11 = this.peekLength + 1;
            this.peekLength = i11;
            if (i11 == i10) {
                return false;
            }
            extractorInput.peekFully(this.scratch.data, 0, 1);
            unsignedInt = ((unsignedInt << 8) & (-256)) | (this.scratch.data[0] & 255);
        }
        long uint = readUint(extractorInput);
        long j11 = this.peekLength;
        if (uint != Long.MIN_VALUE && (length == -1 || j11 + uint < length)) {
            while (true) {
                int i12 = this.peekLength;
                long j12 = j11 + uint;
                if (i12 < j12) {
                    if (readUint(extractorInput) == Long.MIN_VALUE) {
                        return false;
                    }
                    long uint2 = readUint(extractorInput);
                    if (uint2 < 0 || uint2 > 2147483647L) {
                        break;
                    }
                    if (uint2 != 0) {
                        int i13 = (int) uint2;
                        extractorInput.advancePeekPosition(i13);
                        this.peekLength += i13;
                    }
                } else if (i12 == j12) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.ts;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i10, int i11) {
        this.targetType = i10;
        byte[] bArr = new byte[i11 + 3];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public final void appendToNalUnit(byte[] bArr, int i10, int i11) {
        if (this.isFilling) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i13 = this.nalLength;
            if (length < i13 + i12) {
                this.nalData = Arrays.copyOf(bArr2, (i13 + i12) * 2);
            }
            System.arraycopy(bArr, i10, this.nalData, this.nalLength, i12);
            this.nalLength += i12;
        }
    }

    public final boolean endNalUnit(int i10) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i10;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public final void startNalUnit(int i10) {
        Assertions.checkState(!this.isFilling);
        boolean z9 = i10 == this.targetType;
        this.isFilling = z9;
        if (z9) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}

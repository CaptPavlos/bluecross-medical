package com.mbridge.msdk.playercommon.exoplayer2.util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ParsableNalUnitBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    private byte[] data;

    public ParsableNalUnitBitArray(byte[] bArr, int i10, int i11) {
        reset(bArr, i10, i11);
    }

    private void assertValidOffset() {
        int i10;
        int i11 = this.byteOffset;
        Assertions.checkState(i11 >= 0 && (i11 < (i10 = this.byteLimit) || (i11 == i10 && this.bitOffset == 0)));
    }

    private int readExpGolombCodeNum() {
        int i10 = 0;
        while (!readBit()) {
            i10++;
        }
        return ((1 << i10) - 1) + (i10 > 0 ? readBits(i10) : 0);
    }

    private boolean shouldSkipByte(int i10) {
        if (2 > i10 || i10 >= this.byteLimit) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i10] == 3 && bArr[i10 + (-2)] == 0 && bArr[i10 - 1] == 0;
    }

    public final boolean canReadBits(int i10) {
        int i11 = this.byteOffset;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        int i14 = (this.bitOffset + i10) - (i12 * 8);
        if (i14 > 7) {
            i13++;
            i14 -= 8;
        }
        while (true) {
            i11++;
            if (i11 > i13 || i13 >= this.byteLimit) {
                break;
            }
            if (shouldSkipByte(i11)) {
                i13++;
                i11 += 2;
            }
        }
        int i15 = this.byteLimit;
        if (i13 >= i15) {
            return i13 == i15 && i14 == 0;
        }
        return true;
    }

    public final boolean canReadExpGolombCodedNum() {
        int i10 = this.byteOffset;
        int i11 = this.bitOffset;
        int i12 = 0;
        while (this.byteOffset < this.byteLimit && !readBit()) {
            i12++;
        }
        boolean z9 = this.byteOffset == this.byteLimit;
        this.byteOffset = i10;
        this.bitOffset = i11;
        return !z9 && canReadBits((i12 * 2) + 1);
    }

    public final boolean readBit() {
        boolean z9 = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z9;
    }

    public final int readBits(int i10) {
        int i11;
        this.bitOffset += i10;
        int i12 = 0;
        while (true) {
            i11 = this.bitOffset;
            if (i11 <= 8) {
                break;
            }
            int i13 = i11 - 8;
            this.bitOffset = i13;
            byte[] bArr = this.data;
            int i14 = this.byteOffset;
            i12 |= (bArr[i14] & 255) << i13;
            if (!shouldSkipByte(i14 + 1)) {
                i = 1;
            }
            this.byteOffset = i14 + i;
        }
        byte[] bArr2 = this.data;
        int i15 = this.byteOffset;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i15 + (shouldSkipByte(i15 + 1) ? 2 : 1);
        }
        assertValidOffset();
        return i16;
    }

    public final int readSignedExpGolombCodedInt() {
        int expGolombCodeNum = readExpGolombCodeNum();
        return ((expGolombCodeNum + 1) / 2) * (expGolombCodeNum % 2 == 0 ? -1 : 1);
    }

    public final int readUnsignedExpGolombCodedInt() {
        return readExpGolombCodeNum();
    }

    public final void reset(byte[] bArr, int i10, int i11) {
        this.data = bArr;
        this.byteOffset = i10;
        this.byteLimit = i11;
        this.bitOffset = 0;
        assertValidOffset();
    }

    public final void skipBit() {
        int i10 = this.bitOffset + 1;
        this.bitOffset = i10;
        if (i10 == 8) {
            this.bitOffset = 0;
            int i11 = this.byteOffset;
            this.byteOffset = i11 + (shouldSkipByte(i11 + 1) ? 2 : 1);
        }
        assertValidOffset();
    }

    public final void skipBits(int i10) {
        int i11 = this.byteOffset;
        int i12 = i10 / 8;
        int i13 = i11 + i12;
        this.byteOffset = i13;
        int i14 = (i10 - (i12 * 8)) + this.bitOffset;
        this.bitOffset = i14;
        if (i14 > 7) {
            this.byteOffset = i13 + 1;
            this.bitOffset = i14 - 8;
        }
        while (true) {
            i11++;
            if (i11 > this.byteOffset) {
                assertValidOffset();
                return;
            } else if (shouldSkipByte(i11)) {
                this.byteOffset++;
                i11 += 2;
            }
        }
    }
}

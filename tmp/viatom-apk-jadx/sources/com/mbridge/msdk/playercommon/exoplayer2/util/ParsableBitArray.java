package com.mbridge.msdk.playercommon.exoplayer2.util;

import androidx.core.view.MotionEventCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ParsableBitArray {
    private int bitOffset;
    private int byteLimit;
    private int byteOffset;
    public byte[] data;

    public ParsableBitArray(byte[] bArr, int i10) {
        this.data = bArr;
        this.byteLimit = i10;
    }

    private void assertValidOffset() {
        int i10;
        int i11 = this.byteOffset;
        Assertions.checkState(i11 >= 0 && (i11 < (i10 = this.byteLimit) || (i11 == i10 && this.bitOffset == 0)));
    }

    public final int bitsLeft() {
        return ((this.byteLimit - this.byteOffset) * 8) - this.bitOffset;
    }

    public final void byteAlign() {
        if (this.bitOffset == 0) {
            return;
        }
        this.bitOffset = 0;
        this.byteOffset++;
        assertValidOffset();
    }

    public final int getBytePosition() {
        Assertions.checkState(this.bitOffset == 0);
        return this.byteOffset;
    }

    public final int getPosition() {
        return (this.byteOffset * 8) + this.bitOffset;
    }

    public final void putInt(int i10, int i11) {
        if (i11 < 32) {
            i10 &= (1 << i11) - 1;
        }
        int iMin = Math.min(8 - this.bitOffset, i11);
        int i12 = this.bitOffset;
        int i13 = (8 - i12) - iMin;
        int i14 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i12) | ((1 << i13) - 1);
        byte[] bArr = this.data;
        int i15 = this.byteOffset;
        byte b10 = (byte) (i14 & bArr[i15]);
        bArr[i15] = b10;
        int i16 = i11 - iMin;
        bArr[i15] = (byte) (b10 | ((i10 >>> i16) << i13));
        int i17 = i15 + 1;
        while (true) {
            byte[] bArr2 = this.data;
            if (i16 <= 8) {
                int i18 = 8 - i16;
                byte b11 = (byte) (bArr2[i17] & ((1 << i18) - 1));
                bArr2[i17] = b11;
                bArr2[i17] = (byte) (((i10 & ((1 << i16) - 1)) << i18) | b11);
                skipBits(i11);
                assertValidOffset();
                return;
            }
            bArr2[i17] = (byte) (i10 >>> (i16 - 8));
            i16 -= 8;
            i17++;
        }
    }

    public final boolean readBit() {
        boolean z9 = (this.data[this.byteOffset] & (128 >> this.bitOffset)) != 0;
        skipBit();
        return z9;
    }

    public final void readBits(byte[] bArr, int i10, int i11) {
        int i12 = (i11 >> 3) + i10;
        while (i10 < i12) {
            byte[] bArr2 = this.data;
            int i13 = this.byteOffset;
            int i14 = i13 + 1;
            this.byteOffset = i14;
            byte b10 = bArr2[i13];
            int i15 = this.bitOffset;
            byte b11 = (byte) (b10 << i15);
            bArr[i10] = b11;
            bArr[i10] = (byte) (((255 & bArr2[i14]) >> (8 - i15)) | b11);
            i10++;
        }
        int i16 = i11 & 7;
        if (i16 == 0) {
            return;
        }
        byte b12 = (byte) (bArr[i12] & (255 >> i16));
        bArr[i12] = b12;
        int i17 = this.bitOffset;
        if (i17 + i16 > 8) {
            byte[] bArr3 = this.data;
            int i18 = this.byteOffset;
            this.byteOffset = i18 + 1;
            bArr[i12] = (byte) (b12 | ((bArr3[i18] & 255) << i17));
            this.bitOffset = i17 - 8;
        }
        int i19 = this.bitOffset + i16;
        this.bitOffset = i19;
        byte[] bArr4 = this.data;
        int i20 = this.byteOffset;
        bArr[i12] = (byte) (((byte) (((255 & bArr4[i20]) >> (8 - i19)) << (8 - i16))) | bArr[i12]);
        if (i19 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i20 + 1;
        }
        assertValidOffset();
    }

    public final void readBytes(byte[] bArr, int i10, int i11) {
        Assertions.checkState(this.bitOffset == 0);
        System.arraycopy(this.data, this.byteOffset, bArr, i10, i11);
        this.byteOffset += i11;
        assertValidOffset();
    }

    public final void reset(ParsableByteArray parsableByteArray) {
        reset(parsableByteArray.data, parsableByteArray.limit());
        setPosition(parsableByteArray.getPosition() * 8);
    }

    public final void setPosition(int i10) {
        int i11 = i10 / 8;
        this.byteOffset = i11;
        this.bitOffset = i10 - (i11 * 8);
        assertValidOffset();
    }

    public final void skipBit() {
        int i10 = this.bitOffset + 1;
        this.bitOffset = i10;
        if (i10 == 8) {
            this.bitOffset = 0;
            this.byteOffset++;
        }
        assertValidOffset();
    }

    public final void skipBits(int i10) {
        int i11 = i10 / 8;
        int i12 = this.byteOffset + i11;
        this.byteOffset = i12;
        int i13 = (i10 - (i11 * 8)) + this.bitOffset;
        this.bitOffset = i13;
        if (i13 > 7) {
            this.byteOffset = i12 + 1;
            this.bitOffset = i13 - 8;
        }
        assertValidOffset();
    }

    public final void skipBytes(int i10) {
        Assertions.checkState(this.bitOffset == 0);
        this.byteOffset += i10;
        assertValidOffset();
    }

    public ParsableBitArray(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public ParsableBitArray() {
    }

    public final void reset(byte[] bArr) {
        reset(bArr, bArr.length);
    }

    public final void reset(byte[] bArr, int i10) {
        this.data = bArr;
        this.byteOffset = 0;
        this.bitOffset = 0;
        this.byteLimit = i10;
    }

    public final int readBits(int i10) {
        int i11;
        if (i10 == 0) {
            return 0;
        }
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
            this.byteOffset = i14 + 1;
            i12 |= (bArr[i14] & 255) << i13;
        }
        byte[] bArr2 = this.data;
        int i15 = this.byteOffset;
        int i16 = ((-1) >>> (32 - i10)) & (i12 | ((bArr2[i15] & 255) >> (8 - i11)));
        if (i11 == 8) {
            this.bitOffset = 0;
            this.byteOffset = i15 + 1;
        }
        assertValidOffset();
        return i16;
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.util;

import a3.a;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ParsableByteArray {
    public byte[] data;
    private int limit;
    private int position;

    public ParsableByteArray(int i10) {
        this.data = new byte[i10];
        this.limit = i10;
    }

    public final int bytesLeft() {
        return this.limit - this.position;
    }

    public final int capacity() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int limit() {
        return this.limit;
    }

    public final char peekChar() {
        byte[] bArr = this.data;
        int i10 = this.position;
        return (char) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public final int peekUnsignedByte() {
        return this.data[this.position] & 255;
    }

    public final void readBytes(byte[] bArr, int i10, int i11) {
        System.arraycopy(this.data, this.position, bArr, i10, i11);
        this.position += i11;
    }

    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 16) | i12;
        int i15 = i10 + 3;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.position = i10 + 4;
        return (bArr[i15] & 255) | i16;
    }

    public final int readInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = ((bArr[i10] & 255) << 24) >> 8;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return (bArr[i13] & 255) | i14;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String readLine() {
        /*
            r6 = this;
            int r0 = r6.bytesLeft()
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            int r0 = r6.position
        La:
            int r1 = r6.limit
            if (r0 >= r1) goto L1b
            byte[] r1 = r6.data
            r1 = r1[r0]
            boolean r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.isLinebreak(r1)
            if (r1 != 0) goto L1b
            int r0 = r0 + 1
            goto La
        L1b:
            int r1 = r6.position
            int r2 = r0 - r1
            r3 = 3
            if (r2 < r3) goto L3d
            byte[] r2 = r6.data
            r4 = r2[r1]
            r5 = -17
            if (r4 != r5) goto L3d
            int r4 = r1 + 1
            r4 = r2[r4]
            r5 = -69
            if (r4 != r5) goto L3d
            int r4 = r1 + 2
            r2 = r2[r4]
            r4 = -65
            if (r2 != r4) goto L3d
            int r1 = r1 + r3
            r6.position = r1
        L3d:
            byte[] r1 = r6.data
            int r2 = r6.position
            int r3 = r0 - r2
            java.lang.String r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.fromUtf8Bytes(r1, r2, r3)
            r6.position = r0
            int r2 = r6.limit
            if (r0 != r2) goto L4e
            goto L69
        L4e:
            byte[] r3 = r6.data
            r4 = r3[r0]
            r5 = 13
            if (r4 != r5) goto L5d
            int r0 = r0 + 1
            r6.position = r0
            if (r0 != r2) goto L5d
            goto L69
        L5d:
            int r0 = r6.position
            r2 = r3[r0]
            r3 = 10
            if (r2 != r3) goto L69
            int r0 = r0 + 1
            r6.position = r0
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray.readLine():java.lang.String");
    }

    public final int readLittleEndianInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        int i15 = i10 + 3;
        this.position = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.position = i10 + 4;
        return ((bArr[i15] & 255) << 24) | i16;
    }

    public final int readLittleEndianInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public final long readLittleEndianLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        this.position = i10 + 3;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8) | ((bArr[r7] & 255) << 16);
        this.position = i10 + 4;
        long j11 = j10 | ((bArr[r8] & 255) << 24);
        this.position = i10 + 5;
        long j12 = j11 | ((bArr[r7] & 255) << 32);
        this.position = i10 + 6;
        long j13 = j12 | ((bArr[r8] & 255) << 40);
        this.position = i10 + 7;
        long j14 = j13 | ((bArr[r7] & 255) << 48);
        this.position = i10 + 8;
        return ((bArr[r8] & 255) << 56) | j14;
    }

    public final short readLittleEndianShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i10 + 2;
        return (short) (((bArr[i11] & 255) << 8) | i12);
    }

    public final long readLittleEndianUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        long j10 = (bArr[i10] & 255) | ((bArr[r2] & 255) << 8);
        this.position = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 16);
        this.position = i10 + 4;
        return ((bArr[r2] & 255) << 24) | j11;
    }

    public final int readLittleEndianUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return ((bArr[i13] & 255) << 16) | i14;
    }

    public final int readLittleEndianUnsignedIntToInt() {
        int littleEndianInt = readLittleEndianInt();
        if (littleEndianInt >= 0) {
            return littleEndianInt;
        }
        c.g(a.f(littleEndianInt, "Top bit not zero: "));
        return 0;
    }

    public final int readLittleEndianUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = bArr[i10] & 255;
        this.position = i10 + 2;
        return ((bArr[i11] & 255) << 8) | i12;
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        long j10 = ((bArr[i10] & 255) << 56) | ((bArr[r2] & 255) << 48);
        this.position = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 40);
        this.position = i10 + 4;
        long j12 = j11 | ((bArr[r2] & 255) << 32);
        this.position = i10 + 5;
        long j13 = j12 | ((bArr[r7] & 255) << 24);
        this.position = i10 + 6;
        long j14 = j13 | ((bArr[r2] & 255) << 16);
        this.position = i10 + 7;
        long j15 = j14 | ((bArr[r7] & 255) << 8);
        this.position = i10 + 8;
        return (bArr[r2] & 255) | j15;
    }

    public final String readNullTerminatedString() {
        if (bytesLeft() == 0) {
            return null;
        }
        int i10 = this.position;
        while (i10 < this.limit && this.data[i10] != 0) {
            i10++;
        }
        byte[] bArr = this.data;
        int i11 = this.position;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(bArr, i11, i10 - i11);
        this.position = i10;
        if (i10 < this.limit) {
            this.position = i10 + 1;
        }
        return strFromUtf8Bytes;
    }

    public final short readShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        return (short) ((bArr[i11] & 255) | i12);
    }

    public final String readString(int i10, Charset charset) {
        String str = new String(this.data, this.position, i10, charset);
        this.position += i10;
        return str;
    }

    public final int readSynchSafeInt() {
        return (readUnsignedByte() << 21) | (readUnsignedByte() << 14) | (readUnsignedByte() << 7) | readUnsignedByte();
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        return bArr[i10] & 255;
    }

    public final int readUnsignedFixedPoint1616() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        int i13 = (bArr[i11] & 255) | i12;
        this.position = i10 + 4;
        return i13;
    }

    public final long readUnsignedInt() {
        byte[] bArr = this.data;
        int i10 = this.position;
        this.position = i10 + 1;
        this.position = i10 + 2;
        long j10 = ((bArr[i10] & 255) << 24) | ((bArr[r2] & 255) << 16);
        this.position = i10 + 3;
        long j11 = j10 | ((bArr[r7] & 255) << 8);
        this.position = i10 + 4;
        return (bArr[r2] & 255) | j11;
    }

    public final int readUnsignedInt24() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 16;
        int i13 = i10 + 2;
        this.position = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        this.position = i10 + 3;
        return (bArr[i13] & 255) | i14;
    }

    public final int readUnsignedIntToInt() {
        int i10 = readInt();
        if (i10 >= 0) {
            return i10;
        }
        c.g(a.f(i10, "Top bit not zero: "));
        return 0;
    }

    public final long readUnsignedLongToLong() {
        long j10 = readLong();
        if (j10 >= 0) {
            return j10;
        }
        c.g(a.h(j10, "Top bit not zero: "));
        return 0L;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i10 = this.position;
        int i11 = i10 + 1;
        this.position = i11;
        int i12 = (bArr[i10] & 255) << 8;
        this.position = i10 + 2;
        return (bArr[i11] & 255) | i12;
    }

    public final long readUtf8EncodedLong() {
        int i10;
        int i11;
        long j10 = this.data[this.position];
        int i12 = 7;
        while (true) {
            if (i12 < 0) {
                break;
            }
            if (((1 << i12) & j10) != 0) {
                i12--;
            } else if (i12 < 6) {
                j10 &= r6 - 1;
                i11 = 7 - i12;
            } else if (i12 == 7) {
                i11 = 1;
            }
        }
        i11 = 0;
        if (i11 == 0) {
            throw new NumberFormatException(a.h(j10, "Invalid UTF-8 sequence first byte: "));
        }
        for (i10 = 1; i10 < i11; i10++) {
            if ((this.data[this.position + i10] & 192) != 128) {
                throw new NumberFormatException(a.h(j10, "Invalid UTF-8 sequence continuation byte: "));
            }
            j10 = (j10 << 6) | (r3 & 63);
        }
        this.position += i11;
        return j10;
    }

    public final void reset(int i10) {
        reset(capacity() < i10 ? new byte[i10] : this.data, i10);
    }

    public final void setLimit(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.data.length);
        this.limit = i10;
    }

    public final void setPosition(int i10) {
        Assertions.checkArgument(i10 >= 0 && i10 <= this.limit);
        this.position = i10;
    }

    public final void skipBytes(int i10) {
        setPosition(this.position + i10);
    }

    public ParsableByteArray() {
    }

    public ParsableByteArray(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public final void readBytes(ParsableBitArray parsableBitArray, int i10) {
        readBytes(parsableBitArray.data, 0, i10);
        parsableBitArray.setPosition(0);
    }

    public ParsableByteArray(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
    }

    public final void readBytes(ByteBuffer byteBuffer, int i10) {
        byteBuffer.put(this.data, this.position, i10);
        this.position += i10;
    }

    public final String readString(int i10) {
        return readString(i10, Charset.forName(C.UTF8_NAME));
    }

    public final void reset(byte[] bArr, int i10) {
        this.data = bArr;
        this.limit = i10;
        this.position = 0;
    }

    public final void reset() {
        this.position = 0;
        this.limit = 0;
    }

    public final String readNullTerminatedString(int i10) {
        if (i10 == 0) {
            return "";
        }
        int i11 = this.position;
        int i12 = (i11 + i10) - 1;
        String strFromUtf8Bytes = Util.fromUtf8Bytes(this.data, i11, (i12 >= this.limit || this.data[i12] != 0) ? i10 : i10 - 1);
        this.position += i10;
        return strFromUtf8Bytes;
    }
}

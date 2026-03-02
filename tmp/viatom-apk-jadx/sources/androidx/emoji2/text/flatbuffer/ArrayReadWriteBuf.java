package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i10) {
        return this.buffer[i10];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i10) {
        return this.buffer[i10] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i10) {
        byte[] bArr = this.buffer;
        return (bArr[i10] & 255) | (bArr[i10 + 3] << 24) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i10) {
        byte[] bArr = this.buffer;
        return (bArr[i10 + 7] << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((255 & bArr[i10 + 6]) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i10) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i10] & 255) | (bArr[i10 + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i10, int i11) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b10) {
        set(this.writePos, b10);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z9) {
        setBoolean(this.writePos, z9);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d8) {
        setDouble(this.writePos, d8);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f) {
        setFloat(this.writePos, f);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i10) {
        setInt(this.writePos, i10);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j10) {
        setLong(this.writePos, j10);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s9) {
        setShort(this.writePos, s9);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i10) {
        byte[] bArr = this.buffer;
        if (bArr.length > i10) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i10, byte[] bArr, int i11, int i12) {
        requestCapacity((i12 - i11) + i10);
        System.arraycopy(bArr, i11, this.buffer, i10, i12);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i10, boolean z9) {
        set(i10, z9 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i10, double d8) {
        requestCapacity(i10 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d8);
        int i11 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (jDoubleToRawLongBits >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i10, float f) {
        requestCapacity(i10 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (iFloatToRawIntBits & 255);
        bArr[i10 + 1] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i10 + 2] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i10 + 3] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i10, int i11) {
        requestCapacity(i10 + 4);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i10, long j10) {
        requestCapacity(i10 + 8);
        int i11 = (int) j10;
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (i11 & 255);
        bArr[i10 + 1] = (byte) ((i11 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((i11 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((i11 >> 24) & 255);
        int i12 = (int) (j10 >> 32);
        bArr[i10 + 4] = (byte) (i12 & 255);
        bArr[i10 + 5] = (byte) ((i12 >> 8) & 255);
        bArr[i10 + 6] = (byte) ((i12 >> 16) & 255);
        bArr[i10 + 7] = (byte) ((i12 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i10, short s9) {
        requestCapacity(i10 + 2);
        byte[] bArr = this.buffer;
        bArr[i10] = (byte) (s9 & 255);
        bArr[i10 + 1] = (byte) ((s9 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i10) {
        this(new byte[i10]);
    }

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i10) {
        this.buffer = bArr;
        this.writePos = i10;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i10, int i11) {
        set(this.writePos, bArr, i10, i11);
        this.writePos += i11;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i10, byte b10) {
        requestCapacity(i10 + 1);
        this.buffer[i10] = b10;
    }
}

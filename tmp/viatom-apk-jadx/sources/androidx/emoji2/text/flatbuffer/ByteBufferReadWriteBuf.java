package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ByteBufferReadWriteBuf implements ReadWriteBuf {
    private final ByteBuffer buffer;

    public ByteBufferReadWriteBuf(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i10) {
        return this.buffer.get(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i10) {
        return get(i10) != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i10) {
        return this.buffer.getDouble(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i10) {
        return this.buffer.getFloat(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i10) {
        return this.buffer.getInt(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i10) {
        return this.buffer.getLong(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i10) {
        return this.buffer.getShort(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i10, int i11) {
        return Utf8Safe.decodeUtf8Buffer(this.buffer, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i10, int i11) {
        this.buffer.put(bArr, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z9) {
        this.buffer.put(z9 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d8) {
        this.buffer.putDouble(d8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f) {
        this.buffer.putFloat(f);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i10) {
        this.buffer.putInt(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j10) {
        this.buffer.putLong(j10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s9) {
        this.buffer.putShort(s9);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i10) {
        return i10 <= this.buffer.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i10, byte[] bArr, int i11, int i12) {
        requestCapacity((i12 - i11) + i10);
        int iPosition = this.buffer.position();
        this.buffer.position(i10);
        this.buffer.put(bArr, i11, i12);
        this.buffer.position(iPosition);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i10, boolean z9) {
        set(i10, z9 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i10, double d8) {
        requestCapacity(i10 + 8);
        this.buffer.putDouble(i10, d8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i10, float f) {
        requestCapacity(i10 + 4);
        this.buffer.putFloat(i10, f);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i10, int i11) {
        requestCapacity(i10 + 4);
        this.buffer.putInt(i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i10, long j10) {
        requestCapacity(i10 + 8);
        this.buffer.putLong(i10, j10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i10, short s9) {
        requestCapacity(i10 + 2);
        this.buffer.putShort(i10, s9);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.buffer.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b10) {
        this.buffer.put(b10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i10, byte b10) {
        requestCapacity(i10 + 1);
        this.buffer.put(i10, b10);
    }
}

package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b10);

    void put(byte[] bArr, int i10, int i11);

    void putBoolean(boolean z9);

    void putDouble(double d8);

    void putFloat(float f);

    void putInt(int i10);

    void putLong(long j10);

    void putShort(short s9);

    boolean requestCapacity(int i10);

    void set(int i10, byte b10);

    void set(int i10, byte[] bArr, int i11, int i12);

    void setBoolean(int i10, boolean z9);

    void setDouble(int i10, double d8);

    void setFloat(int i10, float f);

    void setInt(int i10, int i11);

    void setLong(int i10, long j10);

    void setShort(int i10, short s9);

    int writePosition();
}

package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i10);

    boolean getBoolean(int i10);

    double getDouble(int i10);

    float getFloat(int i10);

    int getInt(int i10);

    long getLong(int i10);

    short getShort(int i10);

    String getString(int i10, int i11);

    int limit();
}

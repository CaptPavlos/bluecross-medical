package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f, float f10) {
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final long packInts(int i10, int i11) {
        return (i11 & 4294967295L) | (i10 << 32);
    }
}

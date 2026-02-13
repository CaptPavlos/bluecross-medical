package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FloatSetKt {
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);
    private static final float[] EmptyFloatArray = new float[0];

    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf(float... fArr) {
        fArr.getClass();
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final int hash(float f) {
        int iFloatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        return iFloatToIntBits ^ (iFloatToIntBits << 16);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f, float f10, float f11) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f10);
        mutableFloatSet.plusAssign(f11);
        return mutableFloatSet;
    }

    public static final FloatSet floatSetOf(float f) {
        return mutableFloatSetOf(f);
    }

    public static final FloatSet floatSetOf(float f, float f10) {
        return mutableFloatSetOf(f, f10);
    }

    public static final FloatSet floatSetOf(float f, float f10, float f11) {
        return mutableFloatSetOf(f, f10, f11);
    }

    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f, float f10) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f10);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, null);
    }

    public static final MutableFloatSet mutableFloatSetOf(float... fArr) {
        fArr.getClass();
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }
}

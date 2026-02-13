package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FloatFloatPair {
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long j10) {
        this.packedValue = j10;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m6boximpl(long j10) {
        return new FloatFloatPair(j10);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m7component1impl(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m8component2impl(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m9constructorimpl(float f, float f10) {
        return m10constructorimpl((Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m11equalsimpl(long j10, Object obj) {
        return (obj instanceof FloatFloatPair) && j10 == ((FloatFloatPair) obj).m17unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final float m13getFirstimpl(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final float m14getSecondimpl(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m15hashCodeimpl(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m16toStringimpl(long j10) {
        return "(" + Float.intBitsToFloat((int) (j10 >> 32)) + ", " + Float.intBitsToFloat((int) (j10 & 4294967295L)) + ')';
    }

    public boolean equals(Object obj) {
        return m11equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m15hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m16toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m17unboximpl() {
        return this.packedValue;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m10constructorimpl(long j10) {
        return j10;
    }
}

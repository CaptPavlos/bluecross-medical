package androidx.collection;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j10) {
        this.packedValue = j10;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m18boximpl(long j10) {
        return new IntIntPair(j10);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m19component1impl(long j10) {
        return (int) (j10 >> 32);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m20component2impl(long j10) {
        return (int) (j10 & 4294967295L);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m21constructorimpl(int i10, int i11) {
        return m22constructorimpl((i11 & 4294967295L) | (i10 << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m23equalsimpl(long j10, Object obj) {
        return (obj instanceof IntIntPair) && j10 == ((IntIntPair) obj).m29unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m24equalsimpl0(long j10, long j11) {
        return j10 == j11;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m25getFirstimpl(long j10) {
        return (int) (j10 >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m26getSecondimpl(long j10) {
        return (int) (j10 & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m27hashCodeimpl(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m28toStringimpl(long j10) {
        return "(" + m25getFirstimpl(j10) + ", " + m26getSecondimpl(j10) + ')';
    }

    public boolean equals(Object obj) {
        return m23equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m27hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m28toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m29unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m22constructorimpl(long j10) {
        return j10;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}

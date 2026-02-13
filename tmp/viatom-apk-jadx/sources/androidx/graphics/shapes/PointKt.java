package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PointKt {
    /* renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m50clockwiseybeJwSQ(long j10, long j11) {
        return (m60getYDnnuFBc(j11) * m59getXDnnuFBc(j10)) - (m59getXDnnuFBc(j11) * m60getYDnnuFBc(j10)) > 0.0f;
    }

    /* renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m51copy5P9i7ZU(long j10, float f, float f10) {
        return FloatFloatPair.m9constructorimpl(f, f10);
    }

    /* renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m52copy5P9i7ZU$default(long j10, float f, float f10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f = Float.intBitsToFloat((int) (j10 >> 32));
        }
        if ((i10 & 2) != 0) {
            f10 = Float.intBitsToFloat((int) (4294967295L & j10));
        }
        return m51copy5P9i7ZU(j10, f, f10);
    }

    /* renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m53divso9K2fw(long j10, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j10) / f, m60getYDnnuFBc(j10) / f);
    }

    /* renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m54dotProduct5P9i7ZU(long j10, float f, float f10) {
        return (m60getYDnnuFBc(j10) * f10) + (m59getXDnnuFBc(j10) * f);
    }

    /* renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m55dotProductybeJwSQ(long j10, long j11) {
        return (m60getYDnnuFBc(j11) * m60getYDnnuFBc(j10)) + (m59getXDnnuFBc(j11) * m59getXDnnuFBc(j10));
    }

    /* renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m56getDirectionDnnuFBc(long j10) {
        float fM57getDistanceDnnuFBc = m57getDistanceDnnuFBc(j10);
        if (fM57getDistanceDnnuFBc > 0.0f) {
            return m53divso9K2fw(j10, fM57getDistanceDnnuFBc);
        }
        com.google.gson.internal.a.n("Can't get the direction of a 0-length vector");
        return 0L;
    }

    /* renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m57getDistanceDnnuFBc(long j10) {
        return (float) Math.sqrt((m60getYDnnuFBc(j10) * m60getYDnnuFBc(j10)) + (m59getXDnnuFBc(j10) * m59getXDnnuFBc(j10)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m58getDistanceSquaredDnnuFBc(long j10) {
        return (m60getYDnnuFBc(j10) * m60getYDnnuFBc(j10)) + (m59getXDnnuFBc(j10) * m59getXDnnuFBc(j10));
    }

    /* renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m59getXDnnuFBc(long j10) {
        return Float.intBitsToFloat((int) (j10 >> 32));
    }

    /* renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m60getYDnnuFBc(long j10) {
        return Float.intBitsToFloat((int) (j10 & 4294967295L));
    }

    /* renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m61interpolatedLqxh1s(long j10, long j11, float f) {
        return FloatFloatPair.m9constructorimpl(Utils.interpolate(m59getXDnnuFBc(j10), m59getXDnnuFBc(j11), f), Utils.interpolate(m60getYDnnuFBc(j10), m60getYDnnuFBc(j11), f));
    }

    /* renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m62minusybeJwSQ(long j10, long j11) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j10) - m59getXDnnuFBc(j11), m60getYDnnuFBc(j10) - m60getYDnnuFBc(j11));
    }

    /* renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m63plusybeJwSQ(long j10, long j11) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j11) + m59getXDnnuFBc(j10), m60getYDnnuFBc(j11) + m60getYDnnuFBc(j10));
    }

    /* renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m64remso9K2fw(long j10, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j10) % f, m60getYDnnuFBc(j10) % f);
    }

    /* renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m65timesso9K2fw(long j10, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j10) * f, m60getYDnnuFBc(j10) * f);
    }

    /* renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m66transformedso9K2fw(long j10, PointTransformer pointTransformer) {
        pointTransformer.getClass();
        long jMo68transformXgqJiTY = pointTransformer.mo68transformXgqJiTY(m59getXDnnuFBc(j10), m60getYDnnuFBc(j10));
        return FloatFloatPair.m9constructorimpl(Float.intBitsToFloat((int) (jMo68transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo68transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m67unaryMinusDnnuFBc(long j10) {
        return FloatFloatPair.m9constructorimpl(-m59getXDnnuFBc(j10), -m60getYDnnuFBc(j10));
    }
}

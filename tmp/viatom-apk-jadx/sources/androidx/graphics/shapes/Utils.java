package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Utils {
    public static final float AngleEpsilon = 1.0E-6f;
    public static final boolean DEBUG = false;
    public static final float DistanceEpsilon = 1.0E-4f;
    private static final long Zero = FloatFloatPair.m9constructorimpl(0.0f, 0.0f);
    private static final float FloatPi = 3.1415927f;
    private static final float TwoPi = 6.2831855f;

    public static final float angle(float f, float f10) {
        float fAtan2 = (float) Math.atan2(f10, f);
        float f11 = TwoPi;
        return (fAtan2 + f11) % f11;
    }

    public static final void debugLog(String str, g7.a aVar) {
        str.getClass();
        aVar.getClass();
    }

    public static final long directionVector(float f, float f10) {
        float fDistance = distance(f, f10);
        if (fDistance > 0.0f) {
            return FloatFloatPair.m9constructorimpl(f / fDistance, f10 / fDistance);
        }
        com.google.gson.internal.a.n("Required distance greater than zero");
        return 0L;
    }

    public static final float distance(float f, float f10) {
        return (float) Math.sqrt((f10 * f10) + (f * f));
    }

    public static final float distanceSquared(float f, float f10) {
        return (f10 * f10) + (f * f);
    }

    public static final float findMinimum(float f, float f10, float f11, FindMinimumFunction findMinimumFunction) {
        findMinimumFunction.getClass();
        while (f10 - f > f11) {
            float f12 = 2;
            float f13 = 3;
            float f14 = ((f12 * f) + f10) / f13;
            float f15 = ((f12 * f10) + f) / f13;
            if (findMinimumFunction.invoke(f14) < findMinimumFunction.invoke(f15)) {
                f10 = f15;
            } else {
                f = f14;
            }
        }
        return (f + f10) / 2;
    }

    public static /* synthetic */ float findMinimum$default(float f, float f10, float f11, FindMinimumFunction findMinimumFunction, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f11 = 0.001f;
        }
        return findMinimum(f, f10, f11, findMinimumFunction);
    }

    public static final float getFloatPi() {
        return FloatPi;
    }

    public static final float getTwoPi() {
        return TwoPi;
    }

    public static final long getZero() {
        return Zero;
    }

    public static final float interpolate(float f, float f10, float f11) {
        return (f11 * f10) + ((1 - f11) * f);
    }

    public static final float positiveModulo(float f, float f10) {
        return ((f % f10) + f10) % f10;
    }

    /* renamed from: radialToCartesian-L6JJ3z0, reason: not valid java name */
    public static final long m78radialToCartesianL6JJ3z0(float f, float f10, long j10) {
        return PointKt.m63plusybeJwSQ(PointKt.m65timesso9K2fw(directionVector(f10), f), j10);
    }

    /* renamed from: radialToCartesian-L6JJ3z0$default, reason: not valid java name */
    public static /* synthetic */ long m79radialToCartesianL6JJ3z0$default(float f, float f10, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = Zero;
        }
        return m78radialToCartesianL6JJ3z0(f, f10, j10);
    }

    /* renamed from: rotate90-DnnuFBc, reason: not valid java name */
    public static final long m80rotate90DnnuFBc(long j10) {
        return FloatFloatPair.m9constructorimpl(-PointKt.m60getYDnnuFBc(j10), PointKt.m59getXDnnuFBc(j10));
    }

    public static final float square(float f) {
        return f * f;
    }

    public static final long directionVector(float f) {
        double d8 = f;
        return FloatFloatPair.m9constructorimpl((float) Math.cos(d8), (float) Math.sin(d8));
    }
}

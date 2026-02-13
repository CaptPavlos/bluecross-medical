package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import kotlin.jvm.internal.g;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;

    /* renamed from: d1, reason: collision with root package name */
    private final long f558d1;

    /* renamed from: d2, reason: collision with root package name */
    private final long f559d2;
    private final float expectedRoundCut;

    /* renamed from: p0, reason: collision with root package name */
    private final long f560p0;

    /* renamed from: p1, reason: collision with root package name */
    private final long f561p1;

    /* renamed from: p2, reason: collision with root package name */
    private final long f562p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    private RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding) {
        this.f560p0 = j10;
        this.f561p1 = j11;
        this.f562p2 = j12;
        this.rounding = cornerRounding;
        long jM56getDirectionDnnuFBc = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j10, j11));
        this.f558d1 = jM56getDirectionDnnuFBc;
        long jM56getDirectionDnnuFBc2 = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j12, j11));
        this.f559d2 = jM56getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float fM55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(jM56getDirectionDnnuFBc, jM56getDirectionDnnuFBc2);
        this.cosAngle = fM55dotProductybeJwSQ;
        float f = 1;
        float fSqrt = (float) Math.sqrt(f - Utils.square(fM55dotProductybeJwSQ));
        this.sinAngle = fSqrt;
        this.expectedRoundCut = ((double) fSqrt) > 0.001d ? ((fM55dotProductybeJwSQ + f) * radius) / fSqrt : 0.0f;
        this.center = FloatFloatPair.m9constructorimpl(0.0f, 0.0f);
    }

    private final float calculateActualSmoothingValue(float f) {
        if (f > getExpectedCut()) {
            return this.smoothing;
        }
        float f10 = this.expectedRoundCut;
        if (f <= f10) {
            return 0.0f;
        }
        return ((f - f10) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m69computeFlankingCurveoAJzIJU(float f, float f10, long j10, long j11, long j12, long j13, long j14, float f11) {
        long jM56getDirectionDnnuFBc = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j11, j10));
        long jM63plusybeJwSQ = PointKt.m63plusybeJwSQ(j10, PointKt.m65timesso9K2fw(PointKt.m65timesso9K2fw(jM56getDirectionDnnuFBc, f), 1 + f10));
        long jM17unboximpl = j12;
        long jM61interpolatedLqxh1s = PointKt.m61interpolatedLqxh1s(jM17unboximpl, PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(j12, j13), 2.0f), f10);
        long jM63plusybeJwSQ2 = PointKt.m63plusybeJwSQ(j14, PointKt.m65timesso9K2fw(Utils.directionVector(PointKt.m59getXDnnuFBc(jM61interpolatedLqxh1s) - PointKt.m59getXDnnuFBc(j14), PointKt.m60getYDnnuFBc(jM61interpolatedLqxh1s) - PointKt.m60getYDnnuFBc(j14)), f11));
        FloatFloatPair floatFloatPairM70lineIntersectionCBFvKDc = m70lineIntersectionCBFvKDc(j11, jM56getDirectionDnnuFBc, jM63plusybeJwSQ2, Utils.m80rotate90DnnuFBc(PointKt.m62minusybeJwSQ(jM63plusybeJwSQ2, j14)));
        if (floatFloatPairM70lineIntersectionCBFvKDc != null) {
            jM17unboximpl = floatFloatPairM70lineIntersectionCBFvKDc.m17unboximpl();
        }
        return new Cubic(jM63plusybeJwSQ, PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(jM63plusybeJwSQ, PointKt.m65timesso9K2fw(jM17unboximpl, 2.0f)), 3.0f), jM17unboximpl, jM63plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = f;
        }
        return roundedCorner.getCubics(f, f10);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m70lineIntersectionCBFvKDc(long j10, long j11, long j12, long j13) {
        long jM80rotate90DnnuFBc = Utils.m80rotate90DnnuFBc(j13);
        float fM55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(j11, jM80rotate90DnnuFBc);
        if (Math.abs(fM55dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float fM55dotProductybeJwSQ2 = PointKt.m55dotProductybeJwSQ(PointKt.m62minusybeJwSQ(j12, j10), jM80rotate90DnnuFBc);
        if (Math.abs(fM55dotProductybeJwSQ) < Math.abs(fM55dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m6boximpl(PointKt.m63plusybeJwSQ(j10, PointKt.m65timesso9K2fw(j11, fM55dotProductybeJwSQ2 / fM55dotProductybeJwSQ)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name */
    public final long m71getCenter1ufDz9w() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f, float f10) {
        float fMin = Math.min(f, f10);
        float f11 = this.expectedRoundCut;
        if (f11 < 1.0E-4f || fMin < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j10 = this.f561p1;
            this.center = j10;
            return a4.u(Cubic.Companion.straightLine(PointKt.m59getXDnnuFBc(j10), PointKt.m60getYDnnuFBc(this.f561p1), PointKt.m59getXDnnuFBc(this.f561p1), PointKt.m60getYDnnuFBc(this.f561p1)));
        }
        float fMin2 = Math.min(fMin, f11);
        float fCalculateActualSmoothingValue = calculateActualSmoothingValue(f);
        float fCalculateActualSmoothingValue2 = calculateActualSmoothingValue(f10);
        float f12 = (this.cornerRadius * fMin2) / this.expectedRoundCut;
        this.center = PointKt.m63plusybeJwSQ(this.f561p1, PointKt.m65timesso9K2fw(PointKt.m56getDirectionDnnuFBc(PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(this.f558d1, this.f559d2), 2.0f)), (float) Math.sqrt(Utils.square(fMin2) + Utils.square(f12))));
        long jM63plusybeJwSQ = PointKt.m63plusybeJwSQ(this.f561p1, PointKt.m65timesso9K2fw(this.f558d1, fMin2));
        long jM63plusybeJwSQ2 = PointKt.m63plusybeJwSQ(this.f561p1, PointKt.m65timesso9K2fw(this.f559d2, fMin2));
        Cubic cubicM69computeFlankingCurveoAJzIJU = m69computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue, this.f561p1, this.f560p0, jM63plusybeJwSQ, jM63plusybeJwSQ2, this.center, f12);
        Cubic cubicReverse = m69computeFlankingCurveoAJzIJU(fMin2, fCalculateActualSmoothingValue2, this.f561p1, this.f562p2, jM63plusybeJwSQ2, jM63plusybeJwSQ, this.center, f12).reverse();
        return m.Q(cubicM69computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m59getXDnnuFBc(this.center), PointKt.m60getYDnnuFBc(this.center), cubicM69computeFlankingCurveoAJzIJU.getAnchor1X(), cubicM69computeFlankingCurveoAJzIJU.getAnchor1Y(), cubicReverse.getAnchor0X(), cubicReverse.getAnchor0Y()), cubicReverse);
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name */
    public final long m72getD11ufDz9w() {
        return this.f558d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name */
    public final long m73getD21ufDz9w() {
        return this.f559d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name */
    public final long m74getP01ufDz9w() {
        return this.f560p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name */
    public final long m75getP11ufDz9w() {
        return this.f561p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name */
    public final long m76getP21ufDz9w() {
        return this.f562p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m77setCenterDnnuFBc(long j10) {
        this.center = j10;
    }

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, g gVar) {
        this(j10, j11, j12, cornerRounding);
    }

    public /* synthetic */ RoundedCorner(long j10, long j11, long j12, CornerRounding cornerRounding, int i10, g gVar) {
        this(j10, j11, j12, (i10 & 8) != 0 ? null : cornerRounding, null);
    }

    public final List<Cubic> getCubics(float f) {
        return getCubics$default(this, f, 0.0f, 2, null);
    }
}

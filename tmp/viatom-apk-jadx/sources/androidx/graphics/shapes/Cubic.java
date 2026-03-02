package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import s6.i;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Cubic {
    public static final Companion Companion = new Companion(null);
    private final float[] points;

    private Cubic(long j10, long j11, long j12, long j13) {
        this(new float[]{PointKt.m59getXDnnuFBc(j10), PointKt.m60getYDnnuFBc(j10), PointKt.m59getXDnnuFBc(j11), PointKt.m60getYDnnuFBc(j11), PointKt.m59getXDnnuFBc(j12), PointKt.m60getYDnnuFBc(j12), PointKt.m59getXDnnuFBc(j13), PointKt.m60getYDnnuFBc(j13)});
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z9, int i10, Object obj) {
        if (obj != null) {
            a2.a.m("Super calls with default arguments not supported in this target, function: calculateBounds");
            return;
        }
        if ((i10 & 1) != 0) {
            fArr = new float[4];
        }
        if ((i10 & 2) != 0) {
            z9 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z9);
    }

    public static final Cubic circularArc(float f, float f10, float f11, float f12, float f13, float f14) {
        return Companion.circularArc(f, f10, f11, f12, f13, f14);
    }

    public static final Cubic straightLine(float f, float f10, float f11, float f12) {
        return Companion.straightLine(f, f10, f11, f12);
    }

    private final boolean zeroIsh(float f) {
        return Math.abs(f) < 1.0E-4f;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01c2 A[PHI: r2 r6
      0x01c2: PHI (r2v15 float) = (r2v12 float), (r2v21 float) binds: [B:85:0x0211, B:62:0x01c0] A[DONT_GENERATE, DONT_INLINE]
      0x01c2: PHI (r6v14 float) = (r6v10 float), (r6v16 float) binds: [B:85:0x0211, B:62:0x01c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0214 A[PHI: r8 r12
      0x0214: PHI (r8v5 float) = (r8v2 float), (r8v3 float), (r8v3 float), (r8v2 float), (r8v2 float), (r8v2 float) binds: [B:65:0x01cb, B:77:0x01fa, B:79:0x01fe, B:51:0x019f, B:54:0x01a9, B:56:0x01ad] A[DONT_GENERATE, DONT_INLINE]
      0x0214: PHI (r12v13 float) = (r12v9 float), (r12v10 float), (r12v10 float), (r12v9 float), (r12v9 float), (r12v9 float) binds: [B:65:0x01cb, B:77:0x01fa, B:79:0x01fe, B:51:0x019f, B:54:0x01a9, B:56:0x01ad] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void calculateBounds$graphics_shapes_release(float[] r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float f) {
        return times(1.0f / f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) obj).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic cubic) {
        cubic.getClass();
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] + cubic.points[i10];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m47pointOnCurveOOQOV4g$graphics_shapes_release(float f) {
        float f10 = 1 - f;
        float f11 = f10 * f10 * f10;
        float f12 = 3 * f;
        float f13 = f12 * f10 * f10;
        float f14 = f12 * f * f10;
        float f15 = f * f * f;
        return FloatFloatPair.m9constructorimpl((getAnchor1X() * f15) + (getControl1X() * f14) + (getControl0X() * f13) + (getAnchor0X() * f11), (getAnchor1Y() * f15) + (getControl1Y() * f14) + (getControl0Y() * f13) + (getAnchor0Y() * f11));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final i split(float f) {
        float f10 = 1 - f;
        long jM47pointOnCurveOOQOV4g$graphics_shapes_release = m47pointOnCurveOOQOV4g$graphics_shapes_release(f);
        float f11 = f10 * f10;
        float f12 = 2 * f10 * f;
        float f13 = f * f;
        return new i(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f10) + (getControl0X() * f), (getAnchor0Y() * f10) + (getControl0Y() * f), (getControl1X() * f13) + (getControl0X() * f12) + (getAnchor0X() * f11), (getControl1Y() * f13) + (getControl0Y() * f12) + (getAnchor0Y() * f11), PointKt.m59getXDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m60getYDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m59getXDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m60getYDnnuFBc(jM47pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f13) + (getControl1X() * f12) + (getControl0X() * f11), (getAnchor1Y() * f13) + (getControl1Y() * f12) + (getControl0Y() * f11), (getAnchor1X() * f) + (getControl1X() * f10), (getAnchor1Y() * f) + (getControl1Y() * f10), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float f) {
        float[] fArr = new float[8];
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = this.points[i10] * f;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer pointTransformer) {
        pointTransformer.getClass();
        MutableCubic mutableCubic = new MutableCubic();
        float[] fArr = this.points;
        j.l0(fArr, 0, mutableCubic.getPoints$graphics_shapes_release(), 0, fArr.length);
        mutableCubic.transform(pointTransformer);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Cubic circularArc(float f, float f10, float f11, float f12, float f13, float f14) {
            float f15 = f11 - f;
            float f16 = f12 - f10;
            long jDirectionVector = Utils.directionVector(f15, f16);
            float f17 = f13 - f;
            float f18 = f14 - f10;
            long jDirectionVector2 = Utils.directionVector(f17, f18);
            long jM80rotate90DnnuFBc = Utils.m80rotate90DnnuFBc(jDirectionVector);
            long jM80rotate90DnnuFBc2 = Utils.m80rotate90DnnuFBc(jDirectionVector2);
            boolean z9 = PointKt.m54dotProduct5P9i7ZU(jM80rotate90DnnuFBc, f17, f18) >= 0.0f;
            float fM55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM55dotProductybeJwSQ > 0.999f) {
                return straightLine(f11, f12, f13, f14);
            }
            float fSqrt = (((((float) Math.sqrt(2 * r9)) - ((float) Math.sqrt(r5 - (fM55dotProductybeJwSQ * fM55dotProductybeJwSQ)))) * ((Utils.distance(f15, f16) * 4.0f) / 3.0f)) / (1 - fM55dotProductybeJwSQ)) * (z9 ? 1.0f : -1.0f);
            return CubicKt.Cubic(f11, f12, (PointKt.m59getXDnnuFBc(jM80rotate90DnnuFBc) * fSqrt) + f11, (PointKt.m60getYDnnuFBc(jM80rotate90DnnuFBc) * fSqrt) + f12, f13 - (PointKt.m59getXDnnuFBc(jM80rotate90DnnuFBc2) * fSqrt), f14 - (PointKt.m60getYDnnuFBc(jM80rotate90DnnuFBc2) * fSqrt), f13, f14);
        }

        public final Cubic straightLine(float f, float f10, float f11, float f12) {
            return CubicKt.Cubic(f, f10, Utils.interpolate(f, f11, 0.33333334f), Utils.interpolate(f10, f12, 0.33333334f), Utils.interpolate(f, f11, 0.6666667f), Utils.interpolate(f10, f12, 0.6666667f), f11, f12);
        }

        private Companion() {
        }
    }

    public final Cubic div(int i10) {
        return div(i10);
    }

    public final Cubic times(int i10) {
        return times(i10);
    }

    public /* synthetic */ Cubic(long j10, long j11, long j12, long j13, g gVar) {
        this(j10, j11, j12, j13);
    }

    public Cubic(float[] fArr) {
        fArr.getClass();
        this.points = fArr;
        if (fArr.length == 8) {
            return;
        }
        com.google.gson.internal.a.n("Points array size should be 8");
        throw null;
    }

    public /* synthetic */ Cubic(float[] fArr, int i10, g gVar) {
        this((i10 & 1) != 0 ? new float[8] : fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}

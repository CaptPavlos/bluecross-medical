package androidx.core.content.res;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((CamUtils.yFromLStar(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    private ViewingConditions(float f, float f10, float f11, float f12, float f13, float f14, float[] fArr, float f15, float f16, float f17) {
        this.mN = f;
        this.mAw = f10;
        this.mNbb = f11;
        this.mNcb = f12;
        this.mC = f13;
        this.mNc = f14;
        this.mRgbD = fArr;
        this.mFl = f15;
        this.mFlRoot = f16;
        this.mZ = f17;
    }

    @NonNull
    public static ViewingConditions make(@NonNull float[] fArr, float f, float f10, float f11, boolean z9) {
        float[][] fArr2 = CamUtils.XYZ_TO_CAM16RGB;
        float f12 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f13 = fArr3[0] * f12;
        float f14 = fArr[1];
        float f15 = (fArr3[1] * f14) + f13;
        float f16 = fArr[2];
        float f17 = (fArr3[2] * f16) + f15;
        float[] fArr4 = fArr2[1];
        float f18 = (fArr4[2] * f16) + (fArr4[1] * f14) + (fArr4[0] * f12);
        float[] fArr5 = fArr2[2];
        float f19 = (f16 * fArr5[2]) + (f14 * fArr5[1]) + (f12 * fArr5[0]);
        float f20 = (f11 / 10.0f) + 0.8f;
        float fLerp = ((double) f20) >= 0.9d ? CamUtils.lerp(0.59f, 0.69f, (f20 - 0.9f) * 10.0f) : CamUtils.lerp(0.525f, 0.59f, (f20 - 0.8f) * 10.0f);
        float fExp = z9 ? 1.0f : (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * f20;
        double d8 = fExp;
        if (d8 > 1.0d) {
            fExp = 1.0f;
        } else if (d8 < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f17) * fExp) + 1.0f) - fExp, (((100.0f / f18) * fExp) + 1.0f) - fExp, (((100.0f / f19) * fExp) + 1.0f) - fExp};
        float f21 = 1.0f / ((5.0f * f) + 1.0f);
        float f22 = f21 * f21 * f21 * f21;
        float f23 = 1.0f - f22;
        float fCbrt = (0.1f * f23 * f23 * ((float) Math.cbrt(f * 5.0d))) + (f22 * f);
        float fYFromLStar = CamUtils.yFromLStar(f10) / fArr[1];
        double d10 = fYFromLStar;
        float fSqrt = ((float) Math.sqrt(d10)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d10, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f17) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f18) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f19) / 100.0d, 0.42d)};
        float f24 = fArr7[0];
        float f25 = (f24 * 400.0f) / (f24 + 27.13f);
        float f26 = fArr7[1];
        float f27 = (f26 * 400.0f) / (f26 + 27.13f);
        float f28 = fArr7[2];
        float[] fArr8 = {f25, f27, (400.0f * f28) / (f28 + 27.13f)};
        return new ViewingConditions(fYFromLStar, ((fArr8[2] * 0.05f) + (fArr8[0] * 2.0f) + fArr8[1]) * fPow, fPow, fPow, fLerp, f20, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public float getAw() {
        return this.mAw;
    }

    public float getC() {
        return this.mC;
    }

    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    public float getN() {
        return this.mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    public float getNc() {
        return this.mNc;
    }

    public float getNcb() {
        return this.mNcb;
    }

    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    public float getZ() {
        return this.mZ;
    }
}

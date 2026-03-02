package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    public CamColor(float f, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        this.mHue = f;
        this.mChroma = f10;
        this.mJ = f11;
        this.mQ = f12;
        this.mM = f13;
        this.mS = f14;
        this.mJstar = f15;
        this.mAstar = f16;
        this.mBstar = f17;
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        float f12 = 100.0f;
        float f13 = 1000.0f;
        float f14 = 0.0f;
        CamColor camColor = null;
        float f15 = 1000.0f;
        while (Math.abs(f14 - f12) > LIGHTNESS_SEARCH_ENDPOINT) {
            float f16 = ((f12 - f14) / 2.0f) + f14;
            int iViewedInSrgb = fromJch(f16, f10, f).viewedInSrgb();
            float fLStarFromInt = CamUtils.lStarFromInt(iViewedInSrgb);
            float fAbs = Math.abs(f11 - fLStarFromInt);
            if (fAbs < 0.2f) {
                CamColor camColorFromColor = fromColor(iViewedInSrgb);
                float fDistance = camColorFromColor.distance(fromJch(camColorFromColor.getJ(), camColorFromColor.getChroma(), f));
                if (fDistance <= 1.0f) {
                    camColor = camColorFromColor;
                    f13 = fAbs;
                    f15 = fDistance;
                }
            }
            if (f13 == 0.0f && f15 == 0.0f) {
                return camColor;
            }
            if (fLStarFromInt < f11) {
                f14 = f16;
            } else {
                f12 = f16;
            }
        }
        return camColor;
    }

    @NonNull
    public static CamColor fromColor(@ColorInt int i10) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i10, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void fromColorInViewingConditions(@ColorInt int i10, @NonNull ViewingConditions viewingConditions, @Nullable @Size(7) float[] fArr, @NonNull @Size(3) float[] fArr2) {
        CamUtils.xyzFromInt(i10, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f10 = fArr4[0] * f;
        float f11 = fArr2[1];
        float f12 = (fArr4[1] * f11) + f10;
        float f13 = fArr2[2];
        float f14 = (fArr4[2] * f13) + f12;
        float[] fArr5 = fArr3[1];
        float f15 = (fArr5[2] * f13) + (fArr5[1] * f11) + (fArr5[0] * f);
        float[] fArr6 = fArr3[2];
        float f16 = (f13 * fArr6[2]) + (f11 * fArr6[1]) + (f * fArr6[0]);
        float f17 = viewingConditions.getRgbD()[0] * f14;
        float f18 = viewingConditions.getRgbD()[1] * f15;
        float f19 = viewingConditions.getRgbD()[2] * f16;
        float fPow = (float) Math.pow((Math.abs(f17) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((Math.abs(f18) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((Math.abs(f19) * viewingConditions.getFl()) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f17) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f18) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f19) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d8 = fSignum3;
        float f20 = ((float) (((fSignum2 * (-12.0d)) + (fSignum * 11.0d)) + d8)) / 11.0f;
        float f21 = ((float) ((fSignum + fSignum2) - (d8 * 2.0d))) / 9.0f;
        float f22 = fSignum2 * 20.0f;
        float f23 = ((21.0f * fSignum3) + ((fSignum * 20.0f) + f22)) / 20.0f;
        float f24 = (((fSignum * 40.0f) + f22) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f21, f20)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f25 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f24 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(fPow4 / 100.0f)) * viewingConditions.getFlRoot();
        float fSqrt = ((float) Math.sqrt(fPow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) fAtan2) < 20.14d ? fAtan2 + 360.0f : fAtan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f21 * f21) + (f20 * f20)))) / (f23 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r6 * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f26 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d10 = f25;
        float fCos = ((float) Math.cos(d10)) * fLog;
        float fSin = fLog * ((float) Math.sin(d10));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = aw;
            fArr[2] = flRoot;
            fArr[3] = fSqrt2;
            fArr[4] = f26;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 360.0d) float f11) {
        return fromJchInFrame(f, f10, f11, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 360.0d) float f11, ViewingConditions viewingConditions) {
        float aw = (viewingConditions.getAw() + 4.0f) * (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f / 100.0d)) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f10;
        float fSqrt = ((float) Math.sqrt(((f10 / ((float) Math.sqrt(r4))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f12 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d8 = (3.1415927f * f11) / 180.0f;
        return new CamColor(f11, f10, f, aw, flRoot, fSqrt, f12, ((float) Math.cos(d8)) * fLog, fLog * ((float) Math.sin(d8)));
    }

    public static void getM3HCTfromColor(@ColorInt int i10, @NonNull @Size(3) float[] fArr) {
        fromColorInViewingConditions(i10, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i10);
    }

    @ColorInt
    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11, @NonNull ViewingConditions viewingConditions) {
        if (f10 < 1.0d || Math.round(f11) <= 0.0d || Math.round(f11) >= 100.0d) {
            return CamUtils.intFromLStar(f11);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        CamColor camColor = null;
        boolean z9 = true;
        float f12 = 0.0f;
        float f13 = f10;
        while (Math.abs(f12 - f10) >= CHROMA_SEARCH_ENDPOINT) {
            CamColor camColorFindCamByJ = findCamByJ(fMin, f13, f11);
            if (!z9) {
                if (camColorFindCamByJ == null) {
                    f10 = f13;
                } else {
                    f12 = f13;
                    camColor = camColorFindCamByJ;
                }
                f13 = ((f10 - f12) / 2.0f) + f12;
            } else {
                if (camColorFindCamByJ != null) {
                    return camColorFindCamByJ.viewed(viewingConditions);
                }
                f13 = ((f10 - f12) / 2.0f) + f12;
                z9 = false;
            }
        }
        return camColor == null ? CamUtils.intFromLStar(f11) : camColor.viewed(viewingConditions);
    }

    public float distance(@NonNull CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((bStar * bStar) + (aStar * aStar) + (jStar * jStar)), 0.63d) * 1.41d);
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = Double.NEGATIVE_INFINITY, fromInclusive = false, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJ() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.mM;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.mQ;
    }

    @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.mS;
    }

    @ColorInt
    public int viewed(@NonNull ViewingConditions viewingConditions) {
        float fPow = (float) Math.pow(((((double) getChroma()) == 0.0d || ((double) getJ()) == 0.0d) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float nc = fCos * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float fSin = (float) Math.sin(hue);
        float fCos2 = (float) Math.cos(hue);
        float f = (((0.305f + nbb) * 23.0f) * fPow) / (((fPow * 108.0f) * fSin) + (((11.0f * fPow) * fCos2) + (nc * 23.0f)));
        float f10 = fCos2 * f;
        float f11 = f * fSin;
        float f12 = nbb * 460.0f;
        float f13 = ((288.0f * f11) + ((451.0f * f10) + f12)) / 1403.0f;
        float f14 = ((f12 - (891.0f * f10)) - (261.0f * f11)) / 1403.0f;
        float f15 = ((f12 - (f10 * 220.0f)) - (f11 * 6300.0f)) / 1403.0f;
        float fl = (100.0f / viewingConditions.getFl()) * Math.signum(f13) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f13) * 27.13d) / (400.0d - Math.abs(f13))), 2.380952380952381d));
        float fl2 = (100.0f / viewingConditions.getFl()) * Math.signum(f14) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f14) * 27.13d) / (400.0d - Math.abs(f14))), 2.380952380952381d));
        float fl3 = (100.0f / viewingConditions.getFl()) * Math.signum(f15) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f15) * 27.13d) / (400.0d - Math.abs(f15))), 2.380952380952381d));
        float f16 = fl / viewingConditions.getRgbD()[0];
        float f17 = fl2 / viewingConditions.getRgbD()[1];
        float f18 = fl3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f19 = (fArr2[2] * f18) + (fArr2[1] * f17) + (fArr2[0] * f16);
        float[] fArr3 = fArr[1];
        float f20 = (fArr3[2] * f18) + (fArr3[1] * f17) + (fArr3[0] * f16);
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f19, f20, (f18 * fArr4[2]) + (f17 * fArr4[1]) + (f16 * fArr4[0]));
    }

    @ColorInt
    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = 100.0d) float f11) {
        return toColor(f, f10, f11, ViewingConditions.DEFAULT);
    }
}

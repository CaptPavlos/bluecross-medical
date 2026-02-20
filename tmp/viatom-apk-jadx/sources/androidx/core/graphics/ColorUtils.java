package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ScatterMapKt;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import androidx.window.layout.c;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import com.google.gson.internal.a;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static Color compositeColors(Color color, Color color2) {
            if (!Objects.equals(color.getModel(), color2.getModel())) {
                StringBuilder sb = new StringBuilder("Color models must match (");
                sb.append(color.getModel());
                ColorSpace.Model model = color2.getModel();
                sb.append(" vs. ");
                sb.append(model);
                sb.append(")");
                throw new IllegalArgumentException(sb.toString());
            }
            if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                color = color.convert(color2.getColorSpace());
            }
            float[] components = color.getComponents();
            float[] components2 = color2.getComponents();
            float fAlpha = color.alpha();
            float fAlpha2 = (1.0f - fAlpha) * color2.alpha();
            int componentCount = color2.getComponentCount() - 1;
            float f = fAlpha + fAlpha2;
            components2[componentCount] = f;
            if (f > 0.0f) {
                fAlpha /= f;
                fAlpha2 /= f;
            }
            for (int i10 = 0; i10 < componentCount; i10++) {
                components2[i10] = (components2[i10] * fAlpha2) + (components[i10] * fAlpha);
            }
            return Color.valueOf(components2, color2.getColorSpace());
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int iRound;
        int iRound2;
        int iRound3;
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float fAbs = (1.0f - Math.abs((f11 * 2.0f) - 1.0f)) * f10;
        float f12 = f11 - (0.5f * fAbs);
        float fAbs2 = (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * fAbs;
        switch (((int) f) / 60) {
            case 0:
                iRound = Math.round((fAbs + f12) * 255.0f);
                iRound2 = Math.round((fAbs2 + f12) * 255.0f);
                iRound3 = Math.round(f12 * 255.0f);
                break;
            case 1:
                iRound = Math.round((fAbs2 + f12) * 255.0f);
                iRound2 = Math.round((fAbs + f12) * 255.0f);
                iRound3 = Math.round(f12 * 255.0f);
                break;
            case 2:
                iRound = Math.round(f12 * 255.0f);
                iRound2 = Math.round((fAbs + f12) * 255.0f);
                iRound3 = Math.round((fAbs2 + f12) * 255.0f);
                break;
            case 3:
                iRound = Math.round(f12 * 255.0f);
                iRound2 = Math.round((fAbs2 + f12) * 255.0f);
                iRound3 = Math.round((fAbs + f12) * 255.0f);
                break;
            case 4:
                iRound = Math.round((fAbs2 + f12) * 255.0f);
                iRound2 = Math.round(f12 * 255.0f);
                iRound3 = Math.round((fAbs + f12) * 255.0f);
                break;
            case 5:
            case 6:
                iRound = Math.round((fAbs + f12) * 255.0f);
                iRound2 = Math.round(f12 * 255.0f);
                iRound3 = Math.round((fAbs2 + f12) * 255.0f);
                break;
            default:
                iRound3 = 0;
                iRound = 0;
                iRound2 = 0;
                break;
        }
        return Color.rgb(constrain(iRound, 0, 255), constrain(iRound2, 0, 255), constrain(iRound3, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d8, @FloatRange(from = -128.0d, to = 127.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d8, d10, d11, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d8, @FloatRange(from = -128.0d, to = 127.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @NonNull double[] dArr) {
        double d12 = (d8 + 16.0d) / 116.0d;
        double d13 = (d10 / 500.0d) + d12;
        double d14 = d12 - (d11 / 200.0d);
        double dPow = Math.pow(d13, 3.0d);
        if (dPow <= XYZ_EPSILON) {
            dPow = ((d13 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double dPow2 = d8 > 7.9996247999999985d ? Math.pow(d12, 3.0d) : d8 / XYZ_KAPPA;
        double dPow3 = Math.pow(d14, 3.0d);
        if (dPow3 <= XYZ_EPSILON) {
            dPow3 = ((d14 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = dPow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = dPow2 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = dPow3 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) float f11) {
        return CamColor.toColor(f, f10, f11);
    }

    public static void RGBToHSL(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i12, @NonNull float[] fArr) {
        float f;
        float fAbs;
        float f10 = i10 / 255.0f;
        float f11 = i11 / 255.0f;
        float f12 = i12 / 255.0f;
        float fMax = Math.max(f10, Math.max(f11, f12));
        float fMin = Math.min(f10, Math.min(f11, f12));
        float f13 = fMax - fMin;
        float f14 = (fMax + fMin) / 2.0f;
        if (fMax == fMin) {
            f = 0.0f;
            fAbs = 0.0f;
        } else {
            f = fMax == f10 ? ((f11 - f12) / f13) % 6.0f : fMax == f11 ? ((f12 - f10) / f13) + 2.0f : 4.0f + ((f10 - f11) / f13);
            fAbs = f13 / (1.0f - Math.abs((2.0f * f14) - 1.0f));
        }
        float f15 = (f * 60.0f) % 360.0f;
        if (f15 < 0.0f) {
            f15 += 360.0f;
        }
        fArr[0] = constrain(f15, 0.0f, 360.0f);
        fArr[1] = constrain(fAbs, 0.0f, 1.0f);
        fArr[2] = constrain(f14, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i12, @NonNull double[] dArr) {
        RGBToXYZ(i10, i11, i12, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i12, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            a.n("outXyz must have a length of 3.");
            return;
        }
        double d8 = i10 / 255.0d;
        double dPow = d8 < 0.04045d ? d8 / 12.92d : Math.pow((d8 + 0.055d) / 1.055d, 2.4d);
        double d10 = i11 / 255.0d;
        double dPow2 = d10 < 0.04045d ? d10 / 12.92d : Math.pow((d10 + 0.055d) / 1.055d, 2.4d);
        double d11 = i12 / 255.0d;
        double dPow3 = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * dPow3) + (0.3576d * dPow2) + (0.4124d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[1] = ((0.0722d * dPow3) + (0.7152d * dPow2) + (0.2126d * dPow)) * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = ((dPow3 * 0.9505d) + (dPow2 * 0.1192d) + (dPow * 0.0193d)) * XYZ_WHITE_REFERENCE_Y;
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d8, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d11) {
        double d12 = (((-0.4986d) * d11) + (((-1.5372d) * d10) + (3.2406d * d8))) / XYZ_WHITE_REFERENCE_Y;
        double d13 = ((0.0415d * d11) + ((1.8758d * d10) + ((-0.9689d) * d8))) / XYZ_WHITE_REFERENCE_Y;
        double d14 = ((1.057d * d11) + (((-0.204d) * d10) + (0.0557d * d8))) / XYZ_WHITE_REFERENCE_Y;
        return Color.rgb(constrain((int) Math.round((d12 > 0.0031308d ? (Math.pow(d12, 0.4166666666666667d) * 1.055d) - 0.055d : d12 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d13 > 0.0031308d ? (Math.pow(d13, 0.4166666666666667d) * 1.055d) - 0.055d : d13 * 12.92d) * 255.0d), 0, 255), constrain((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_X) double d8, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Y) double d10, @FloatRange(from = 0.0d, to = XYZ_WHITE_REFERENCE_Z) double d11, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            a.n("outLab must have a length of 3.");
            return;
        }
        double dPivotXyzComponent = pivotXyzComponent(d8 / XYZ_WHITE_REFERENCE_X);
        double dPivotXyzComponent2 = pivotXyzComponent(d10 / XYZ_WHITE_REFERENCE_Y);
        double dPivotXyzComponent3 = pivotXyzComponent(d11 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = Math.max(0.0d, (116.0d * dPivotXyzComponent2) - 16.0d);
        dArr[1] = (dPivotXyzComponent - dPivotXyzComponent2) * 500.0d;
        dArr[2] = (dPivotXyzComponent2 - dPivotXyzComponent3) * 200.0d;
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        float f10 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i11) * f) + (Color.alpha(i10) * f10)), (int) ((Color.red(i11) * f) + (Color.red(i10) * f10)), (int) ((Color.green(i11) * f) + (Color.green(i10) * f10)), (int) ((Color.blue(i11) * f) + (Color.blue(i10) * f10)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, @NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            a.n("result must have a length of 3.");
            return;
        }
        float f10 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr2[1] * f) + (fArr[1] * f10);
        fArr3[2] = (fArr2[2] * f) + (fArr[2] * f10);
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) double d8, @NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            a.n("outResult must have a length of 3.");
            return;
        }
        double d10 = 1.0d - d8;
        dArr3[0] = (dArr2[0] * d8) + (dArr[0] * d10);
        dArr3[1] = (dArr2[1] * d8) + (dArr[1] * d10);
        dArr3[2] = (dArr2[2] * d8) + (dArr[2] * d10);
    }

    public static double calculateContrast(@ColorInt int i10, @ColorInt int i11) {
        if (Color.alpha(i11) != 255) {
            c.f(Integer.toHexString(i11), "background can not be translucent: #");
            return 0.0d;
        }
        if (Color.alpha(i10) < 255) {
            i10 = compositeColors(i10, i11);
        }
        double dCalculateLuminance = calculateLuminance(i10) + 0.05d;
        double dCalculateLuminance2 = calculateLuminance(i11) + 0.05d;
        return Math.max(dCalculateLuminance, dCalculateLuminance2) / Math.min(dCalculateLuminance, dCalculateLuminance2);
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public static double calculateLuminance(@ColorInt int i10) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i10, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i10, @ColorInt int i11, float f) {
        int i12 = 255;
        if (Color.alpha(i11) != 255) {
            c.f(Integer.toHexString(i11), "background can not be translucent: #");
            return 0;
        }
        double d8 = f;
        if (calculateContrast(setAlphaComponent(i10, 255), i11) < d8) {
            return -1;
        }
        int i13 = 0;
        for (int i14 = 0; i14 <= 10 && i12 - i13 > 1; i14++) {
            int i15 = (i13 + i12) / 2;
            if (calculateContrast(setAlphaComponent(i10, i15), i11) < d8) {
                i13 = i15;
            } else {
                i12 = i15;
            }
        }
        return i12;
    }

    @VisibleForTesting
    public static float circularInterpolate(float f, float f10, float f11) {
        if (Math.abs(f10 - f) > 180.0f) {
            if (f10 > f) {
                f += 360.0f;
            } else {
                f10 += 360.0f;
            }
        }
        return (((f10 - f) * f11) + f) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i10, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i10), Color.green(i10), Color.blue(i10), fArr);
    }

    public static void colorToLAB(@ColorInt int i10, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i10, @NonNull @Size(3) float[] fArr) {
        CamColor.getM3HCTfromColor(i10, fArr);
    }

    public static void colorToXYZ(@ColorInt int i10, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    private static int compositeAlpha(int i10, int i11) {
        return 255 - (((255 - i10) * (255 - i11)) / 255);
    }

    public static int compositeColors(@ColorInt int i10, @ColorInt int i11) {
        int iAlpha = Color.alpha(i11);
        int iAlpha2 = Color.alpha(i10);
        int iCompositeAlpha = compositeAlpha(iAlpha2, iAlpha);
        return Color.argb(iCompositeAlpha, compositeComponent(Color.red(i10), iAlpha2, Color.red(i11), iAlpha, iCompositeAlpha), compositeComponent(Color.green(i10), iAlpha2, Color.green(i11), iAlpha, iCompositeAlpha), compositeComponent(Color.blue(i10), iAlpha2, Color.blue(i11), iAlpha, iCompositeAlpha));
    }

    private static int compositeComponent(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((255 - i11) * (i12 * i13)) + ((i10 * 255) * i11)) / (i14 * 255);
    }

    private static float constrain(float f, float f10, float f11) {
        return f < f10 ? f10 : Math.min(f, f11);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[2] - dArr2[2], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[0] - dArr2[0], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d8) {
        return d8 > XYZ_EPSILON ? Math.pow(d8, 0.3333333333333333d) : ((d8 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY, to = ScatterMapKt.Sentinel) int i11) {
        if (i11 >= 0 && i11 <= 255) {
            return (i10 & ViewCompat.MEASURED_SIZE_MASK) | (i11 << 24);
        }
        a.n("alpha must be between 0 and 255.");
        return 0;
    }

    private static int constrain(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : Math.min(i10, i12);
    }

    @NonNull
    @RequiresApi(26)
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.compositeColors(color, color2);
    }
}

package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static double clampDouble(double d8, double d10, double d11) {
        return d11 < d8 ? d8 : d11 > d10 ? d10 : d11;
    }

    public static int clampInt(int i10, int i11, int i12) {
        return i12 < i10 ? i10 : i12 > i11 ? i11 : i12;
    }

    public static double differenceDegrees(double d8, double d10) {
        return 180.0d - Math.abs(Math.abs(d8 - d10) - 180.0d);
    }

    public static double lerp(double d8, double d10, double d11) {
        return (d11 * d10) + ((1.0d - d11) * d8);
    }

    public static double[] matrixMultiply(double[] dArr, double[][] dArr2) {
        double d8 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d10 = dArr3[0] * d8;
        double d11 = dArr[1];
        double d12 = (dArr3[1] * d11) + d10;
        double d13 = dArr[2];
        double d14 = (dArr3[2] * d13) + d12;
        double[] dArr4 = dArr2[1];
        double d15 = (dArr4[2] * d13) + (dArr4[1] * d11) + (dArr4[0] * d8);
        double[] dArr5 = dArr2[2];
        return new double[]{d14, d15, (d13 * dArr5[2]) + (d11 * dArr5[1]) + (d8 * dArr5[0])};
    }

    public static double rotationDirection(double d8, double d10) {
        return sanitizeDegreesDouble(d10 - d8) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double sanitizeDegreesDouble(double d8) {
        double d10 = d8 % 360.0d;
        return d10 < 0.0d ? d10 + 360.0d : d10;
    }

    public static int sanitizeDegreesInt(int i10) {
        int i11 = i10 % 360;
        return i11 < 0 ? i11 + 360 : i11;
    }

    public static int signum(double d8) {
        if (d8 < 0.0d) {
            return -1;
        }
        return d8 == 0.0d ? 0 : 1;
    }
}

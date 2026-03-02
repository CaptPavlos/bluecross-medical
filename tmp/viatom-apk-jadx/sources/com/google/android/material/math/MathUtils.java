package com.google.android.material.math;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static boolean areAllElementsEqual(@NonNull float[] fArr) {
        if (fArr.length <= 1) {
            return true;
        }
        float f = fArr[0];
        for (int i10 = 1; i10 < fArr.length; i10++) {
            if (fArr[i10] != f) {
                return false;
            }
        }
        return true;
    }

    public static float dist(float f, float f10, float f11, float f12) {
        return (float) Math.hypot(f11 - f, f12 - f10);
    }

    public static float distanceToFurthestCorner(float f, float f10, float f11, float f12, float f13, float f14) {
        return max(dist(f, f10, f11, f12), dist(f, f10, f13, f12), dist(f, f10, f13, f14), dist(f, f10, f11, f14));
    }

    public static float floorMod(float f, int i10) {
        float f10 = i10;
        int i11 = (int) (f / f10);
        if (Math.signum(f) * f10 < 0.0f && i11 * i10 != f) {
            i11--;
        }
        return f - (i11 * i10);
    }

    public static boolean geq(float f, float f10, float f11) {
        return f + f11 >= f10;
    }

    public static float lerp(float f, float f10, float f11) {
        return (f11 * f10) + ((1.0f - f11) * f);
    }

    private static float max(float f, float f10, float f11, float f12) {
        return (f <= f10 || f <= f11 || f <= f12) ? (f10 <= f11 || f10 <= f12) ? f11 > f12 ? f11 : f12 : f10 : f;
    }

    public static int floorMod(int i10, int i11) {
        int i12 = i10 / i11;
        if ((i10 ^ i11) < 0 && i12 * i11 != i10) {
            i12--;
        }
        return i10 - (i12 * i11);
    }
}

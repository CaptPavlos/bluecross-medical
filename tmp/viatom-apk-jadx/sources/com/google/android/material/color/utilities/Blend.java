package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int i10, int i11, double d8) {
        Cam16 cam16FromInt = Cam16.fromInt(i10);
        Cam16 cam16FromInt2 = Cam16.fromInt(i11);
        double jstar = cam16FromInt.getJstar();
        double astar = cam16FromInt.getAstar();
        double bstar = cam16FromInt.getBstar();
        return Cam16.fromUcs(((cam16FromInt2.getJstar() - jstar) * d8) + jstar, ((cam16FromInt2.getAstar() - astar) * d8) + astar, ((cam16FromInt2.getBstar() - bstar) * d8) + bstar).toInt();
    }

    public static int harmonize(int i10, int i11) {
        Hct hctFromInt = Hct.fromInt(i10);
        Hct hctFromInt2 = Hct.fromInt(i11);
        double dMin = Math.min(MathUtils.differenceDegrees(hctFromInt.getHue(), hctFromInt2.getHue()) * 0.5d, 15.0d);
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(hctFromInt.getHue(), hctFromInt2.getHue()) * dMin) + hctFromInt.getHue()), hctFromInt.getChroma(), hctFromInt.getTone()).toInt();
    }

    public static int hctHue(int i10, int i11, double d8) {
        return Hct.from(Cam16.fromInt(cam16Ucs(i10, i11, d8)).getHue(), Cam16.fromInt(i10).getChroma(), ColorUtils.lstarFromArgb(i10)).toInt();
    }
}

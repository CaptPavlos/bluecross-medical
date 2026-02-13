package com.google.android.material.transition;

import android.graphics.RectF;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f, float f10, float f11, float f12, float f13, float f14, float f15) {
            float fLerp = TransitionUtils.lerp(f12, f14, f10, f11, f, true);
            float f16 = fLerp / f12;
            float f17 = fLerp / f14;
            return new FitModeResult(f16, f17, fLerp, f13 * f16, fLerp, f15 * f17);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
        @Override // com.google.android.material.transition.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult evaluate(float f, float f10, float f11, float f12, float f13, float f14, float f15) {
            float fLerp = TransitionUtils.lerp(f13, f15, f10, f11, f, true);
            float f16 = fLerp / f13;
            float f17 = fLerp / f15;
            return new FitModeResult(f16, f17, f12 * f16, fLerp, f14 * f17, fLerp);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i10, boolean z9, RectF rectF, RectF rectF2) {
        if (i10 == 0) {
            return shouldAutoFitToWidth(z9, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i10 == 1) {
            return WIDTH;
        }
        if (i10 == 2) {
            return HEIGHT;
        }
        com.google.gson.internal.a.n(a3.a.f(i10, "Invalid fit mode: "));
        return null;
    }

    private static boolean shouldAutoFitToWidth(boolean z9, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        return z9 ? (fHeight2 * fWidth) / fWidth2 >= fHeight : (fWidth2 * fHeight) / fWidth >= fHeight2;
    }
}

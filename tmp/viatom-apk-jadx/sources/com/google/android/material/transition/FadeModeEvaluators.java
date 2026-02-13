package com.google.android.material.transition;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f10, f11, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, f11, f), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, f11, f), TransitionUtils.lerp(0, 255, f10, f11, f));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            float fD = a3.a.d(f11, f10, f12, f10);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, fD, f), TransitionUtils.lerp(0, 255, fD, f11, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i10, boolean z9) {
        if (i10 == 0) {
            return z9 ? IN : OUT;
        }
        if (i10 == 1) {
            return z9 ? OUT : IN;
        }
        if (i10 == 2) {
            return CROSS;
        }
        if (i10 == 3) {
            return THROUGH;
        }
        com.google.gson.internal.a.n(a3.a.f(i10, "Invalid fade mode: "));
        return null;
    }
}

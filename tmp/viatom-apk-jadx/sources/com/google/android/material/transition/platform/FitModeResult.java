package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes3.dex */
class FitModeResult {
    final float currentEndHeight;
    final float currentEndWidth;
    final float currentStartHeight;
    final float currentStartWidth;
    final float endScale;
    final float startScale;

    public FitModeResult(float f, float f10, float f11, float f12, float f13, float f14) {
        this.startScale = f;
        this.endScale = f10;
        this.currentStartWidth = f11;
        this.currentStartHeight = f12;
        this.currentEndWidth = f13;
        this.currentEndHeight = f14;
    }
}

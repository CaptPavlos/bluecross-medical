package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
/* loaded from: classes3.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i10, int i11, boolean z9) {
        this.startAlpha = i10;
        this.endAlpha = i11;
        this.endOnTop = z9;
    }

    public static FadeModeResult endOnTop(int i10, int i11) {
        return new FadeModeResult(i10, i11, true);
    }

    public static FadeModeResult startOnTop(int i10, int i11) {
        return new FadeModeResult(i10, i11, false);
    }
}

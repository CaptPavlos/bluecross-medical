package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2403a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f2404b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i10) {
        this.f2403a = i10;
        this.f2404b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2403a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2404b).lambda$getAlphaAnimator$3(valueAnimator);
                break;
            case 1:
                ((ClearTextEndIconDelegate) this.f2404b).lambda$getScaleAnimator$4(valueAnimator);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f2404b).lambda$getAlphaAnimator$6(valueAnimator);
                break;
        }
    }
}

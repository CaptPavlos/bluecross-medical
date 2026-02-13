package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2361a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2362b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f2361a = i10;
        this.f2362b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2361a) {
            case 0:
                ((View) this.f2362b).setAlpha(0.0f);
                break;
            case 1:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$4((DrawerArrowDrawable) this.f2362b, valueAnimator);
                break;
            case 2:
                SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$5((FadeThroughDrawable) this.f2362b, valueAnimator);
                break;
            case 3:
                ((SearchViewAnimationHelper) this.f2362b).lambda$addTextFadeAnimatorIfNeeded$7(valueAnimator);
                break;
            default:
                SearchViewAnimationHelper.lambda$addBackButtonAnimatorIfNeeded$3((ImageButton) this.f2362b, valueAnimator);
                break;
        }
    }
}

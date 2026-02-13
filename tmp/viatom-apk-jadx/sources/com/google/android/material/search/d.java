package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2368a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2369b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2370c;

    public /* synthetic */ d(int i10, Object obj, Object obj2) {
        this.f2368a = i10;
        this.f2369b = obj;
        this.f2370c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2368a) {
            case 0:
                SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1((MaterialShapeDrawable) this.f2369b, (View) this.f2370c, valueAnimator);
                break;
            default:
                ((SearchViewAnimationHelper) this.f2369b).lambda$addEditTextClipAnimator$6((Rect) this.f2370c, valueAnimator);
                break;
        }
    }
}

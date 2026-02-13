package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2299b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2300c;

    public /* synthetic */ b(int i10, Object obj, Object obj2) {
        this.f2298a = i10;
        this.f2299b = obj;
        this.f2300c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2298a) {
            case 0:
                ((AppBarLayout) this.f2299b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.f2300c, valueAnimator);
                break;
            case 1:
                ((ExpandCollapseAnimationHelper) this.f2299b).lambda$getExpandCollapseAnimator$0((Rect) this.f2300c, valueAnimator);
                break;
            default:
                ((DeterminateDrawable) this.f2299b).lambda$new$0((BaseProgressIndicatorSpec) this.f2300c, valueAnimator);
                break;
        }
    }
}

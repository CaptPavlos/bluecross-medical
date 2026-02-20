package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener, AnimatableView.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2380a;

    public /* synthetic */ i(Object obj) {
        this.f2380a = obj;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f2380a).start();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return ((SearchView) this.f2380a).lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return ((SearchView) this.f2380a).lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}

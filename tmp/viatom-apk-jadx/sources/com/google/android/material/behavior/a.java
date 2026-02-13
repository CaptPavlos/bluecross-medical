package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2301a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2302b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f2303c;

    public /* synthetic */ a(CoordinatorLayout.Behavior behavior, View view, int i10) {
        this.f2301a = i10;
        this.f2303c = behavior;
        this.f2302b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z9) {
        switch (this.f2301a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.f2303c).lambda$disableIfTouchExplorationEnabled$0(this.f2302b, z9);
                break;
            default:
                ((HideViewOnScrollBehavior) this.f2303c).lambda$disableIfTouchExplorationEnabled$0(this.f2302b, z9);
                break;
        }
    }
}

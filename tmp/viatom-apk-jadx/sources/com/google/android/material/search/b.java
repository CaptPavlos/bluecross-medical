package com.google.android.material.search;

import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchBarAnimationHelper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements SearchBarAnimationHelper.OnLoadAnimationInvocation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2363a;

    public /* synthetic */ b(int i10) {
        this.f2363a = i10;
    }

    @Override // com.google.android.material.search.SearchBarAnimationHelper.OnLoadAnimationInvocation
    public final void invoke(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        switch (this.f2363a) {
            case 0:
                onLoadAnimationCallback.onAnimationStart();
                break;
            default:
                onLoadAnimationCallback.onAnimationEnd();
                break;
        }
    }
}

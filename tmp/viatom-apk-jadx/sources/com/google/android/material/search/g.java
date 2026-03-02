package com.google.android.material.search;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f2377b;

    public /* synthetic */ g(SearchView searchView, int i10) {
        this.f2376a = i10;
        this.f2377b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2376a) {
            case 0:
                this.f2377b.lambda$setUpClearButton$2(view);
                break;
            case 1:
                this.f2377b.lambda$setupWithSearchBar$7(view);
                break;
            default:
                this.f2377b.lambda$setUpBackButton$1(view);
                break;
        }
    }
}

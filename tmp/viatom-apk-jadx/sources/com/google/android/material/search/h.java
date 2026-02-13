package com.google.android.material.search;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2378a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f2379b;

    public /* synthetic */ h(SearchView searchView, int i10) {
        this.f2378a = i10;
        this.f2379b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2378a) {
            case 0:
                this.f2379b.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 1:
                this.f2379b.show();
                break;
            case 2:
                this.f2379b.lambda$clearFocusAndHideKeyboard$9();
                break;
            default:
                this.f2379b.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}

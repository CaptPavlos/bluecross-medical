package com.google.android.material.search;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2374a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2375b;

    public /* synthetic */ f(Object obj, int i10) {
        this.f2374a = i10;
        this.f2375b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2374a) {
            case 0:
                ((SearchViewAnimationHelper) this.f2375b).hide();
                break;
            case 1:
                ((SearchViewAnimationHelper) this.f2375b).lambda$startShowAnimationExpand$0();
                break;
            case 2:
                ((SearchViewAnimationHelper) this.f2375b).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) this.f2375b).lambda$startOnLoadAnimation$0();
                break;
        }
    }
}

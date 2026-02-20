package e5;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7764b;

    public h0(View view, j0 j0Var) {
        this.f7763a = view;
        this.f7764b = j0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f7763a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f7764b.startPostponedEnterTransition();
        return true;
    }
}

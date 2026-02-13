package e5;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q1 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1 f7838a;

    public q1(t1 t1Var) {
        this.f7838a = t1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            t1 t1Var = this.f7838a;
            if (t1Var.f7870i || !t1Var.f7871j || recyclerView.canScrollVertically(1)) {
                return;
            }
            r7.y.q(LifecycleOwnerKt.getLifecycleScope(t1Var), null, null, new a6.c(t1Var, null, 8), 3);
        }
    }
}

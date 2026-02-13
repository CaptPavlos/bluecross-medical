package e5;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f7795a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m1 f7796b;

    public j1(LinearLayoutManager linearLayoutManager, m1 m1Var) {
        this.f7795a = linearLayoutManager;
        this.f7796b = m1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f7795a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            m1 m1Var = this.f7796b;
            if (m1Var.b().g || !m1Var.b().f || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.c cVar = m1Var.f7817c;
            if (cVar != null) {
                cVar.a(true);
            }
            l4.f0 f0VarB = m1Var.b();
            Context contextRequireContext = m1Var.requireContext();
            contextRequireContext.getClass();
            f0VarB.a(contextRequireContext);
        }
    }
}

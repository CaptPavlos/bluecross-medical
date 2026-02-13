package e5;

import android.content.Context;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x1 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f7903a;

    public x1(b2 b2Var) {
        this.f7903a = b2Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        b2 b2Var = this.f7903a;
        if (b2Var.f7688c.f8635d) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null) {
                if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                    b2Var.a().f7408i.setVisibility(4);
                } else {
                    b2Var.a().f7408i.setVisibility(0);
                }
            }
        }
        if (i11 <= 0 || b2Var.d().e || recyclerView.getLayoutManager() == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        layoutManager2.getClass();
        int childCount = layoutManager2.getChildCount();
        RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
        layoutManager3.getClass();
        int itemCount = layoutManager3.getItemCount();
        RecyclerView.LayoutManager layoutManager4 = recyclerView.getLayoutManager();
        layoutManager4.getClass();
        int iFindFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager4).findFirstVisibleItemPosition();
        if (b2Var.d().f || childCount + iFindFirstVisibleItemPosition < itemCount - 10 || b2Var.getContext() == null) {
            return;
        }
        f2 f2VarD = b2Var.d();
        Context contextRequireContext = b2Var.requireContext();
        contextRequireContext.getClass();
        h5.k kVar = b2Var.f7688c;
        f2VarD.getClass();
        kVar.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(f2VarD);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, y7.d.f14116a, null, new e2(f2VarD, contextRequireContext, kVar, null, 1), 2);
    }
}

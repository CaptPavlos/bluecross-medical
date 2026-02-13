package l4;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v8 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10921a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10922b;

    public v8(LinearLayoutManager linearLayoutManager, SearchActivity searchActivity) {
        this.f10921a = linearLayoutManager;
        this.f10922b = searchActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10921a;
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int i12 = SearchActivity.Q;
            SearchActivity searchActivity = this.f10922b;
            String strN0 = SearchActivity.n0(searchActivity, ((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).getText().toString());
            if (strN0.length() <= 2 || childCount + iFindFirstVisibleItemPosition < itemCount || searchActivity.p0().f10260c || !searchActivity.M) {
                return;
            }
            r7.o1 o1Var = searchActivity.J;
            if ((o1Var == null || o1Var.N()) && searchActivity.K != null) {
                searchActivity.p0().f10260c = true;
                n4.l0 l0Var = searchActivity.K;
                if (l0Var != null) {
                    l0Var.f11429d = true;
                    l0Var.notifyItemInserted(l0Var.getItemCount());
                }
                searchActivity.J = r7.y.q(LifecycleOwnerKt.getLifecycleScope(searchActivity), null, null, new x8(0, searchActivity, strN0, null), 3);
            }
        }
    }
}

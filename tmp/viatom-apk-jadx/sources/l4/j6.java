package l4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicListActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j6 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10524a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicListActivity f10525b;

    public j6(LinearLayoutManager linearLayoutManager, PublicListActivity publicListActivity) {
        this.f10524a = linearLayoutManager;
        this.f10525b = publicListActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10524a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = PublicListActivity.Y;
            PublicListActivity publicListActivity = this.f10525b;
            if (publicListActivity.C0().e || publicListActivity.C0().f10629d || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.d1 d1Var = publicListActivity.W;
            d1Var.getClass();
            d1Var.d(true);
            m6 m6VarC0 = publicListActivity.C0();
            m6VarC0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(m6VarC0);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new a3.o(m6VarC0, publicListActivity, (w6.c) null, 23), 2);
        }
    }
}

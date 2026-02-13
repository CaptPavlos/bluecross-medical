package l4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.FollowListActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10415a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f10416b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10417c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10418d;

    public g0(LinearLayoutManager linearLayoutManager, FollowListActivity followListActivity, int i10, String str) {
        this.f10415a = linearLayoutManager;
        this.f10416b = followListActivity;
        this.f10417c = i10;
        this.f10418d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10415a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = FollowListActivity.L;
            FollowListActivity followListActivity = this.f10416b;
            if (followListActivity.o0().h || !followListActivity.o0().g || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.d dVar = followListActivity.J;
            if (dVar != null) {
                dVar.f11320c = true;
                dVar.notifyItemInserted(dVar.getItemCount());
            }
            w6.c cVar = null;
            String str = this.f10418d;
            int i13 = this.f10417c;
            if (i13 == 1) {
                n0 n0VarO0 = followListActivity.o0();
                n0VarO0.getClass();
                str.getClass();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(n0VarO0);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new m0(n0VarO0, followListActivity, str, cVar, 0), 2);
                return;
            }
            if (i13 == 2) {
                n0 n0VarO02 = followListActivity.o0();
                n0VarO02.getClass();
                str.getClass();
                r7.w viewModelScope2 = ViewModelKt.getViewModelScope(n0VarO02);
                y7.e eVar2 = r7.i0.f12407a;
                r7.y.q(viewModelScope2, y7.d.f14116a, null, new m0(n0VarO02, followListActivity, str, cVar, 1), 2);
            }
        }
    }
}

package l4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.UserCommentsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class qa extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10772a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserCommentsActivity f10773b;

    public qa(LinearLayoutManager linearLayoutManager, UserCommentsActivity userCommentsActivity) {
        this.f10772a = linearLayoutManager;
        this.f10773b = userCommentsActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10772a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = UserCommentsActivity.L;
            UserCommentsActivity userCommentsActivity = this.f10773b;
            if (userCommentsActivity.o0().h || ((Boolean) userCommentsActivity.o0().f.getValue()).booleanValue() || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.a1 a1Var = userCommentsActivity.J;
            if (a1Var != null) {
                a1Var.f11298c = true;
                a1Var.notifyItemInserted(a1Var.getItemCount());
            }
            wa waVarO0 = userCommentsActivity.o0();
            waVarO0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(waVarO0);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new u4(waVarO0, userCommentsActivity, null, 12), 2);
        }
    }
}

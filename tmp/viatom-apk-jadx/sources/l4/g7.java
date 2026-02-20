package l4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g7 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10432a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f10433b;

    public g7(LinearLayoutManager linearLayoutManager, RecommendedActivity recommendedActivity) {
        this.f10432a = linearLayoutManager;
        this.f10433b = recommendedActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10432a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = RecommendedActivity.Z;
            RecommendedActivity recommendedActivity = this.f10433b;
            if (recommendedActivity.C0().f || recommendedActivity.C0().e || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.d1 d1Var = recommendedActivity.W;
            d1Var.getClass();
            d1Var.d(true);
            l7 l7VarC0 = recommendedActivity.C0();
            l7VarC0.getClass();
            r7.w viewModelScope = ViewModelKt.getViewModelScope(l7VarC0);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new a3.o(l7VarC0, recommendedActivity, (w6.c) null, 24), 2);
        }
    }
}

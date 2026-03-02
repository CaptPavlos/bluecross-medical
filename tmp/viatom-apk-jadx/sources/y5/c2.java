package y5;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c2 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f13833a;

    public c2(d2 d2Var) {
        this.f13833a = d2Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        recyclerView.getClass();
        super.onScrollStateChanged(recyclerView, i10);
        d2 d2Var = this.f13833a;
        LinearLayoutManager linearLayoutManager = d2Var.f13844d;
        n4.k1 k1Var = d2Var.e;
        if (!k1Var.f) {
            k1Var.f = true;
        }
        if (i10 == 0) {
            int iFindFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int iFindLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int i11 = k1Var.f11414k;
            if (iFindLastCompletelyVisibleItemPosition == linearLayoutManager.getItemCount() - 1 && iFindLastCompletelyVisibleItemPosition != k1Var.f11414k) {
                k1Var.f11414k = iFindLastCompletelyVisibleItemPosition;
                ArrayList arrayList = ((h5.h) k1Var.e.get(i11)).P;
                if (arrayList != null && !arrayList.isEmpty()) {
                    k1Var.notifyItemChanged(i11);
                }
                ArrayList arrayList2 = ((h5.h) k1Var.e.get(iFindLastCompletelyVisibleItemPosition)).P;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    return;
                }
                k1Var.notifyItemChanged(iFindLastCompletelyVisibleItemPosition);
                return;
            }
            if (iFindFirstCompletelyVisibleItemPosition == -1 || iFindFirstCompletelyVisibleItemPosition == k1Var.f11414k) {
                return;
            }
            k1Var.f11414k = iFindFirstCompletelyVisibleItemPosition;
            ArrayList arrayList3 = ((h5.h) k1Var.e.get(i11)).P;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                k1Var.notifyItemChanged(i11);
            }
            ArrayList arrayList4 = ((h5.h) k1Var.e.get(iFindFirstCompletelyVisibleItemPosition)).P;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                return;
            }
            k1Var.notifyItemChanged(iFindFirstCompletelyVisibleItemPosition);
        }
    }
}

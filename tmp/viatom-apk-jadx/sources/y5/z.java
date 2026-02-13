package y5;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f14078a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5.m f14079b;

    public z(a0 a0Var, g5.m mVar) {
        this.f14078a = a0Var;
        this.f14079b = mVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i10) {
        View viewFindSnapView;
        int childAdapterPosition;
        a0 a0Var = this.f14078a;
        n4.j jVar = a0Var.f13801d;
        recyclerView.getClass();
        super.onScrollStateChanged(recyclerView, i10);
        if (i10 != 0 || (viewFindSnapView = a0Var.f.findSnapView(recyclerView.getLayoutManager())) == null || (childAdapterPosition = a0Var.f13800c.getChildAdapterPosition(viewFindSnapView) % jVar.f11383c.size()) == -1 || childAdapterPosition == a0Var.h) {
            return;
        }
        a0Var.h = childAdapterPosition;
        Object obj = jVar.f11383c.get(childAdapterPosition);
        obj.getClass();
        h5.h hVar = (h5.h) obj;
        if (!hVar.m() || a0Var.g) {
            return;
        }
        this.f14079b.f(hVar);
        a0Var.g = true;
    }
}

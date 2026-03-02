package y5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f13836a;

    public d0(e0 e0Var) {
        this.f13836a = e0Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();
        e0 e0Var = this.f13836a;
        int spanCount = e0Var.f13852d.getSpanCount();
        if (itemCount <= 0 || childAdapterPosition < ((itemCount - 1) / spanCount) * spanCount) {
            return;
        }
        rect.right = e0Var.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
    }
}

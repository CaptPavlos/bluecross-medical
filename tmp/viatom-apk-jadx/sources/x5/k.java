package x5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import n4.p0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f13713a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13714b;

    public k(boolean z9, boolean z10) {
        this.f13713a = z9;
        this.f13714b = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        rect.top = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
        if ((adapter instanceof p0) && ((p0) adapter).getItemViewType(childAdapterPosition) == 6) {
            rect.left = 0;
            rect.right = 0;
            return;
        }
        if (!this.f13713a) {
            rect.left = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
            rect.right = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
        } else if (this.f13714b && childAdapterPosition == 2) {
            rect.left = 0;
            rect.right = 0;
        } else {
            rect.left = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
            rect.right = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
        }
    }
}

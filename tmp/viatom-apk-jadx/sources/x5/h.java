package x5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13707a;

    public h(int i10) {
        this.f13707a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i10 = this.f13707a;
        if (childLayoutPosition == 1) {
            rect.top = i10 / 2;
        } else if (childLayoutPosition > 1) {
            rect.top = i10;
        }
    }
}

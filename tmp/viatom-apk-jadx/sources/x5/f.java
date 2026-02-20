package x5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13704a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13705b;

    public f(int i10, int i11) {
        this.f13704a = i10;
        this.f13705b = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i10 = this.f13704a;
        rect.left = i10;
        rect.right = i10;
        if (childLayoutPosition == 0) {
            int i11 = this.f13705b;
            rect.top = i11 / 2;
            rect.bottom = i11;
        } else if (childLayoutPosition > 0) {
            rect.top = 0;
            rect.bottom = i10;
        }
    }
}

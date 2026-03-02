package x5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13708a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13709b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13710c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13711d;

    public i(int i10, int i11, int i12, int i13) {
        this.f13708a = i10;
        this.f13709b = i11;
        this.f13710c = i12;
        this.f13711d = i13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        rect.left = this.f13708a;
        rect.right = this.f13709b;
        rect.bottom = this.f13710c;
        rect.top = this.f13711d;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}

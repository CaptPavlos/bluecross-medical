package l4;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends ItemTouchHelper.SimpleCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10701a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(MainActivity mainActivity) {
        super(0, 8);
        this.f10701a = mainActivity;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        recyclerView.getClass();
        viewHolder.getClass();
        viewHolder2.getClass();
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i10) {
        viewHolder.getClass();
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        n4.c0 c0Var = this.f10701a.A;
        if (c0Var != null) {
            c0Var.a(absoluteAdapterPosition);
        }
    }
}

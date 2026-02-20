package x5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f13715a;

    public l(UserAvatarActivity userAvatarActivity) {
        this.f13715a = userAvatarActivity.getResources().getDimensionPixelSize(R.dimen.margin_m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i10 = this.f13715a;
        if (childAdapterPosition != 0) {
            rect.right = i10;
        } else {
            rect.left = i10;
            rect.right = i10;
        }
    }
}

package l4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class lc extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WishlistActivity f10609b;

    public lc(LinearLayoutManager linearLayoutManager, WishlistActivity wishlistActivity) {
        this.f10608a = linearLayoutManager;
        this.f10609b = wishlistActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10608a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = WishlistActivity.Z;
            WishlistActivity wishlistActivity = this.f10609b;
            if (wishlistActivity.C0().f10745d || wishlistActivity.C0().f10744c || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.d1 d1Var = wishlistActivity.W;
            d1Var.getClass();
            d1Var.d(true);
            wishlistActivity.C0().a(wishlistActivity);
        }
    }
}

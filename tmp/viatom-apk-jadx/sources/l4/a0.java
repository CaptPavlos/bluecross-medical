package l4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.FeedActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10205a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f10206b;

    public a0(LinearLayoutManager linearLayoutManager, FeedActivity feedActivity) {
        this.f10205a = linearLayoutManager;
        this.f10206b = feedActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i10, int i11) {
        recyclerView.getClass();
        if (i11 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10205a;
            int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i12 = FeedActivity.L;
            FeedActivity feedActivity = this.f10206b;
            if (feedActivity.o0().g || !feedActivity.o0().f || childCount + iFindFirstVisibleItemPosition < itemCount) {
                return;
            }
            n4.c cVar = feedActivity.J;
            if (cVar != null) {
                cVar.a(true);
            }
            feedActivity.o0().a(feedActivity);
        }
    }
}

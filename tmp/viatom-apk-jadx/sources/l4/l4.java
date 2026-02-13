package l4;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.MyDownloads;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l4 implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f10591a;

    public l4(MyDownloads myDownloads) {
        this.f10591a = myDownloads;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        recyclerView.getClass();
        motionEvent.getClass();
        int action = motionEvent.getAction();
        MyDownloads myDownloads = this.f10591a;
        if (action != 0) {
            return action == 2 && myDownloads.L;
        }
        myDownloads.L = false;
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        recyclerView.getClass();
        motionEvent.getClass();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void onRequestDisallowInterceptTouchEvent(boolean z9) {
    }
}

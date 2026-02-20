package l4;

import com.uptodown.activities.FeedActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f10237a;

    public b0(FeedActivity feedActivity) {
        this.f10237a = feedActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        FeedActivity feedActivity = this.f10237a;
        if (z9) {
            int i10 = FeedActivity.L;
            feedActivity.o0().g = true;
            if (feedActivity.J == null) {
                feedActivity.n0().f7198b.setVisibility(0);
            }
        } else {
            if (mVar instanceof v5.l) {
                int i11 = FeedActivity.L;
                feedActivity.o0().g = false;
                if (feedActivity.J == null) {
                    feedActivity.J = new n4.c((ArrayList) ((v5.l) mVar).f13168a, feedActivity.K);
                    feedActivity.n0().f7199c.setAdapter(feedActivity.J);
                } else {
                    Iterator it = ((ArrayList) ((v5.l) mVar).f13168a).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        n4.c cVar2 = feedActivity.J;
                        cVar2.getClass();
                        cVar2.f11309a.add((h5.v) next);
                        cVar2.notifyItemInserted(cVar2.getItemCount());
                    }
                }
                n4.c cVar3 = feedActivity.J;
                if (cVar3 != null) {
                    cVar3.a(false);
                }
                n4.c cVar4 = feedActivity.J;
                ArrayList arrayList = cVar4 != null ? cVar4.f11309a : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    feedActivity.n0().e.setVisibility(0);
                } else {
                    feedActivity.n0().e.setVisibility(8);
                }
                feedActivity.n0().f7198b.setVisibility(8);
            } else if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}

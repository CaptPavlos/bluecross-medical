package l4;

import com.uptodown.activities.FollowListActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f10448a;

    public h0(FollowListActivity followListActivity) {
        this.f10448a = followListActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        FollowListActivity followListActivity = this.f10448a;
        if (z9) {
            int i10 = FollowListActivity.L;
            followListActivity.o0().h = true;
            if (followListActivity.J == null) {
                followListActivity.n0().f7265b.setVisibility(0);
            }
        } else {
            if (mVar instanceof v5.l) {
                int i11 = FollowListActivity.L;
                followListActivity.o0().h = false;
                if (followListActivity.J == null) {
                    followListActivity.J = new n4.d((ArrayList) ((v5.l) mVar).f13168a, followListActivity.K);
                    followListActivity.n0().f7266c.setAdapter(followListActivity.J);
                } else {
                    Iterator it = ((ArrayList) ((v5.l) mVar).f13168a).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        n4.d dVar = followListActivity.J;
                        dVar.getClass();
                        dVar.f11318a.add((h5.e1) next);
                        dVar.notifyItemInserted(dVar.getItemCount());
                    }
                }
                n4.d dVar2 = followListActivity.J;
                if (dVar2 != null) {
                    dVar2.f11320c = false;
                    dVar2.notifyItemRemoved(dVar2.getItemCount());
                }
                n4.d dVar3 = followListActivity.J;
                ArrayList arrayList = dVar3 != null ? dVar3.f11318a : null;
                if (arrayList == null || arrayList.isEmpty()) {
                    followListActivity.n0().e.setVisibility(0);
                } else {
                    followListActivity.n0().e.setVisibility(8);
                }
                followListActivity.n0().f7265b.setVisibility(8);
            } else if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
        }
        return s6.w.f12711a;
    }
}

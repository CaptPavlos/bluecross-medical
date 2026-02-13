package e5;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f7809a;

    public l1(m1 m1Var) {
        this.f7809a = m1Var;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        m1 m1Var = this.f7809a;
        if (z9) {
            if (m1Var.f7817c == null) {
                m1Var.a().e.setVisibility(0);
            }
            if (m1Var.a().h.isRefreshing()) {
                m1Var.f7817c = null;
                m1Var.a().h.setRefreshing(false);
            }
        } else if (mVar instanceof v5.l) {
            m1Var.b().g = false;
            if (m1Var.f7817c == null) {
                m1Var.f7817c = new n4.c((ArrayList) ((v5.l) mVar).f13168a, m1Var.e);
                m1Var.a().g.setAdapter(m1Var.f7817c);
            } else {
                Iterator it = ((ArrayList) ((v5.l) mVar).f13168a).iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    n4.c cVar2 = m1Var.f7817c;
                    cVar2.getClass();
                    cVar2.f11309a.add((h5.v) next);
                    cVar2.notifyItemInserted(cVar2.getItemCount());
                }
            }
            n4.c cVar3 = m1Var.f7817c;
            if (cVar3 != null) {
                cVar3.a(false);
            }
            n4.c cVar4 = m1Var.f7817c;
            ArrayList arrayList = cVar4 != null ? cVar4.f11309a : null;
            if (arrayList == null || arrayList.isEmpty()) {
                m1Var.a().f7215k.setVisibility(0);
            } else {
                m1Var.a().g.setVisibility(0);
                m1Var.a().f7215k.setVisibility(8);
            }
            m1Var.a().f7212d.setVisibility(8);
            m1Var.a().e.setVisibility(8);
        } else if (!(mVar instanceof v5.k)) {
            androidx.window.layout.c.b();
            return null;
        }
        return s6.w.f12711a;
    }
}

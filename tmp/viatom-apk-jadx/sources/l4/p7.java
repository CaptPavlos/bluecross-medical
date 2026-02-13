package l4;

import android.content.Context;
import com.uptodown.activities.RepliesActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p7 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f10730a;

    public p7(RepliesActivity repliesActivity) {
        this.f10730a = repliesActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean z9 = mVar instanceof v5.j;
        RepliesActivity repliesActivity = this.f10730a;
        if (z9) {
            if (repliesActivity.J == null) {
                repliesActivity.n0().h.setVisibility(0);
            }
        } else if (mVar instanceof v5.l) {
            u7 u7Var = (u7) ((v5.l) mVar).f13168a;
            boolean z10 = u7Var.f10884b;
            ArrayList arrayList = u7Var.f10883a;
            if (z10) {
                n4.h0 h0Var = repliesActivity.J;
                if (h0Var != null) {
                    ArrayList arrayList2 = h0Var.f11363a;
                    arrayList.getClass();
                    Iterator it = arrayList.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        arrayList2.add((h5.m0) next);
                        h0Var.notifyItemInserted(arrayList2.size() - 1);
                    }
                }
            } else if (arrayList.isEmpty()) {
                repliesActivity.n0().f7289q.setVisibility(0);
                repliesActivity.n0().f7285m.setVisibility(8);
            } else {
                Context applicationContext = repliesActivity.getApplicationContext();
                applicationContext.getClass();
                repliesActivity.J = new n4.h0(arrayList, applicationContext, repliesActivity.K);
                repliesActivity.n0().f7285m.setAdapter(repliesActivity.J);
            }
            repliesActivity.n0().f7282j.setVisibility(0);
            repliesActivity.n0().h.setVisibility(8);
            n4.h0 h0Var2 = repliesActivity.J;
            if (h0Var2 != null) {
                h0Var2.a(false);
            }
        } else {
            if (!(mVar instanceof v5.k)) {
                androidx.window.layout.c.b();
                return null;
            }
            n4.h0 h0Var3 = repliesActivity.J;
            if (h0Var3 != null) {
                h0Var3.a(false);
            }
        }
        return s6.w.f12711a;
    }
}

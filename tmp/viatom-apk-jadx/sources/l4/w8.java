package l4;

import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w8 implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f10960a;

    public w8(SearchActivity searchActivity) {
        this.f10960a = searchActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) {
        v5.m mVar = (v5.m) obj;
        boolean zA = kotlin.jvm.internal.l.a(mVar, v5.j.f13166a);
        SearchActivity searchActivity = this.f10960a;
        if (zA) {
            n4.l0 l0Var = searchActivity.K;
            if (l0Var == null || l0Var.f11426a.isEmpty()) {
                searchActivity.o0().f7378c.setVisibility(0);
            }
        } else if (mVar instanceof v5.l) {
            a9 a9Var = (a9) ((v5.l) mVar).f13168a;
            boolean z9 = a9Var.f10227c;
            ArrayList arrayList = a9Var.f10225a;
            searchActivity.M = z9;
            if (searchActivity.K == null) {
                searchActivity.K = new n4.l0(arrayList, searchActivity.N, searchActivity.O);
                searchActivity.o0().f7379d.setAdapter(searchActivity.K);
            } else if (((InstantAutoCompleteTextView) searchActivity.o0().f7377b.f13463c).getText().toString().length() > 0) {
                if (searchActivity.o0().f7379d.getAdapter() == null) {
                    searchActivity.o0().f7379d.setAdapter(searchActivity.K);
                }
                if (a9Var.f10226b) {
                    n4.l0 l0Var2 = searchActivity.K;
                    l0Var2.getClass();
                    l0Var2.f11426a = arrayList;
                    l0Var2.notifyDataSetChanged();
                    searchActivity.o0().f7379d.scrollToPosition(0);
                } else if (arrayList.size() > 0) {
                    n4.l0 l0Var3 = searchActivity.K;
                    l0Var3.getClass();
                    Iterator it = arrayList.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        h5.h hVar = (h5.h) next;
                        if (!l0Var3.f11426a.contains(hVar)) {
                            l0Var3.f11426a.add(hVar);
                        }
                    }
                    l0Var3.notifyDataSetChanged();
                }
                n4.l0 l0Var4 = searchActivity.K;
                l0Var4.getClass();
                if (l0Var4.f11426a.size() == 0) {
                    searchActivity.o0().e.setVisibility(0);
                    searchActivity.o0().f7379d.setVisibility(8);
                } else {
                    searchActivity.o0().e.setVisibility(8);
                    searchActivity.o0().f7379d.setVisibility(0);
                }
            } else {
                n4.l0 l0Var5 = searchActivity.K;
                l0Var5.getClass();
                l0Var5.f11426a = new ArrayList();
                l0Var5.notifyDataSetChanged();
            }
            searchActivity.p0().f10260c = false;
            n4.l0 l0Var6 = searchActivity.K;
            if (l0Var6 != null) {
                l0Var6.f11429d = false;
                l0Var6.notifyItemRemoved(l0Var6.getItemCount());
            }
            searchActivity.o0().f7378c.setVisibility(8);
        } else if (!kotlin.jvm.internal.l.a(mVar, v5.k.f13167a)) {
            androidx.window.layout.c.b();
            return null;
        }
        return s6.w.f12711a;
    }
}

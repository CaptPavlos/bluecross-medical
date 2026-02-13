package s5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRow;
import h5.x0;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements g5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f12655a;

    public n(p pVar) {
        this.f12655a = pVar;
    }

    @Override // g5.h
    public final void a(h5.h hVar) {
        hVar.getClass();
    }

    @Override // g5.h
    public final void b(x0 x0Var) {
        this.f12655a.f12664d.add(x0Var);
    }

    @Override // g5.h
    public final void c(x0 x0Var) {
        p pVar = this.f12655a;
        pVar.f12663c.add(x0Var);
        p.a(pVar);
    }

    @Override // g5.h
    public final void d(ArrayList arrayList) {
        arrayList.getClass();
        boolean zIsEmpty = arrayList.isEmpty();
        p pVar = this.f12655a;
        if (!zIsEmpty) {
            h5.h hVar = (h5.h) t6.l.c0(arrayList);
            pVar.f12661a = hVar;
            hVar.getClass();
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new q5.q());
            arrayObjectAdapter.add(hVar);
            pVar.e.add(new ListRow(arrayObjectAdapter));
        }
        pVar.getMainFragmentAdapter().getFragmentHost().notifyDataReady(pVar.getMainFragmentAdapter());
    }

    @Override // g5.h
    public final void e(ArrayList arrayList) {
        arrayList.getClass();
        p pVar = this.f12655a;
        pVar.f12664d.addAll(arrayList);
        p.a(pVar);
    }

    @Override // g5.h
    public final void h(h5.h hVar) {
        hVar.getClass();
    }

    @Override // g5.h
    public final void i(x0 x0Var) {
        this.f12655a.f12663c.add(x0Var);
    }

    @Override // g5.h
    public final void j(ArrayList arrayList) {
        arrayList.getClass();
        p pVar = this.f12655a;
        pVar.f12663c.addAll(arrayList);
        p.a(pVar);
    }

    @Override // g5.h
    public final void k(x0 x0Var) {
        p pVar = this.f12655a;
        pVar.f12663c.add(x0Var);
        p.a(pVar);
    }

    @Override // g5.h
    public final void l(ArrayList arrayList) {
        arrayList.getClass();
        p pVar = this.f12655a;
        pVar.f12662b = arrayList;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new q5.h());
        arrayObjectAdapter.addAll(0, arrayList);
        pVar.e.add(new ListRow(arrayObjectAdapter));
    }

    @Override // g5.h
    public final void g() {
    }
}

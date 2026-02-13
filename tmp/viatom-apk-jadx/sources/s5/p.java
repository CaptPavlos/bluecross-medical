package s5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import h5.x0;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public h5.h f12661a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f12662b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12663c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f12664d = new ArrayList();
    public final ArrayObjectAdapter e;
    public int f;

    public p() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        this.e = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    public static final void a(p pVar) {
        int i10 = pVar.f;
        if (i10 < 3) {
            pVar.f = i10 + 1;
            return;
        }
        ArrayList arrayList = pVar.f12663c;
        ArrayList arrayList2 = pVar.f12664d;
        if (!arrayList2.isEmpty()) {
            Object obj = arrayList2.get(0);
            obj.getClass();
            pVar.c((x0) obj);
        }
        if (!arrayList.isEmpty()) {
            pVar.b(arrayList, -2);
        }
        if (!arrayList2.isEmpty() && arrayList2.size() > 1) {
            Object obj2 = arrayList2.get(1);
            obj2.getClass();
            pVar.c((x0) obj2);
        }
        if (!arrayList.isEmpty()) {
            pVar.b(arrayList, -1);
        }
        if (!arrayList2.isEmpty() && arrayList2.size() > 2) {
            Object obj3 = arrayList2.get(2);
            obj3.getClass();
            pVar.c((x0) obj3);
        }
        if (!arrayList.isEmpty()) {
            pVar.b(arrayList, 521);
        }
        if (!arrayList.isEmpty()) {
            pVar.b(arrayList, 523);
        }
        if (!arrayList.isEmpty()) {
            pVar.b(arrayList, 524);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x0 x0Var = (x0) next;
            if (pVar.getContext() != null) {
                HeaderItem headerItem = new HeaderItem(x0Var.f8788a.f8633b);
                Context contextRequireContext = pVar.requireContext();
                contextRequireContext.getClass();
                q5.g gVar = new q5.g();
                gVar.f12265a = contextRequireContext;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(gVar);
                arrayObjectAdapter.addAll(0, x0Var.f8789b);
                o5.c cVar = new o5.c();
                cVar.f11734a = x0Var.f8788a;
                arrayObjectAdapter.add(cVar);
                pVar.e.add(new ListRow(headerItem, arrayObjectAdapter));
            }
        }
    }

    public final void b(ArrayList arrayList, int i10) {
        Iterator it = arrayList.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            int i12 = i11 + 1;
            x0 x0Var = (x0) it.next();
            if (x0Var.f8788a.f8632a != i10) {
                i11 = i12;
            } else if (getContext() != null) {
                HeaderItem headerItem = new HeaderItem(x0Var.f8788a.f8633b);
                Context contextRequireContext = requireContext();
                contextRequireContext.getClass();
                q5.j jVar = new q5.j();
                jVar.f12267a = contextRequireContext;
                ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(jVar);
                arrayObjectAdapter.addAll(0, x0Var.f8789b);
                o5.c cVar = new o5.c();
                cVar.f11734a = x0Var.f8788a;
                arrayObjectAdapter.add(cVar);
                this.e.add(new ListRow(headerItem, arrayObjectAdapter));
            }
        }
        if (i11 >= 0) {
            arrayList.remove(i11);
        }
    }

    public final void c(x0 x0Var) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(x0Var.f8788a.f8633b);
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            q5.i iVar = new q5.i();
            iVar.f12266a = contextRequireContext;
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(iVar);
            arrayObjectAdapter.addAll(0, x0Var.f8789b);
            o5.c cVar = new o5.c();
            cVar.f11734a = x0Var.f8788a;
            arrayObjectAdapter.add(cVar);
            this.e.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f12661a != null && !this.f12662b.isEmpty()) {
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
            return;
        }
        n nVar = new n(this);
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            viewLifecycleOwner.getClass();
            new c5.t(contextRequireContext, nVar, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new androidx.core.view.inputmethod.a(this, 27));
    }
}

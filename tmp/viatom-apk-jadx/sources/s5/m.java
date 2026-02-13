package s5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import h5.x0;
import java.util.ArrayList;
import java.util.Iterator;
import l4.kb;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12650a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayObjectAdapter f12651b;

    public m() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(listRowPresenter);
        this.f12651b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    public final void a(ArrayList arrayList, int i10) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x0 x0Var = (x0) next;
            if (x0Var.f8788a.f8632a == i10) {
                if (getContext() != null) {
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
                    this.f12651b.add(new ListRow(headerItem, arrayObjectAdapter));
                } else {
                    this.f12650a = false;
                }
                arrayList.remove(x0Var);
                return;
            }
        }
    }

    public final void b(ArrayList arrayList, int i10) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x0 x0Var = (x0) next;
            if (x0Var.f8788a.f8632a == i10) {
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
                    this.f12651b.add(new ListRow(headerItem, arrayObjectAdapter));
                } else {
                    this.f12650a = false;
                }
                arrayList.remove(x0Var);
                return;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f12650a) {
            return;
        }
        this.f12651b.clear();
        k kVar = new k(this);
        if (getContext() != null) {
            Context contextRequireContext = requireContext();
            contextRequireContext.getClass();
            p2 p2Var = new p2(contextRequireContext, kVar);
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            lifecycleScope.getClass();
            r7.y.q(lifecycleScope, null, null, new kb(p2Var, (w6.c) null, 6), 3);
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new androidx.core.view.inputmethod.a(this, 26));
    }
}

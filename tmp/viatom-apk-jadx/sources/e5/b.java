package e5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements g5.a, g5.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f7679a;

    public /* synthetic */ b(d dVar) {
        this.f7679a = dVar;
    }

    @Override // g5.d
    public void E(h5.h hVar, int i10) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            long j10 = hVar.f8566a;
            String str = hVar.f8595w;
            d dVar = this.f7679a;
            Context contextRequireContext = dVar.requireContext();
            contextRequireContext.getClass();
            l1.b.p(j10, contextRequireContext, str);
            n4.p0 p0Var = dVar.f7719c;
            if (p0Var != null) {
                p0Var.notifyItemChanged(i10);
            }
        }
    }

    @Override // g5.a
    public void b(h5.h hVar) {
        hVar.getClass();
        d dVar = this.f7679a;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(dVar);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(lifecycleScope, w7.n.f13548a, null, new a3.o(dVar, hVar, (w6.c) null, 7), 2);
    }

    @Override // g5.a
    public void c(h5.h hVar) {
        hVar.getClass();
        d dVar = this.f7679a;
        if ((dVar.getActivity() instanceof MainActivity) || (dVar.getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = dVar.getActivity();
            activity.getClass();
            ((l4.w) activity).i0(hVar, new androidx.work.impl.utils.c(2, hVar, dVar));
        }
    }

    @Override // g5.d
    public void m(h5.h hVar, int i10) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            d dVar = this.f7679a;
            if (dVar.getContext() == null || !(dVar.getActivity() instanceof l4.w)) {
                return;
            }
            Context contextRequireContext = dVar.requireContext();
            contextRequireContext.getClass();
            new c1.l(contextRequireContext, hVar.f8566a, new c(dVar), LifecycleOwnerKt.getLifecycleScope(dVar));
        }
    }
}

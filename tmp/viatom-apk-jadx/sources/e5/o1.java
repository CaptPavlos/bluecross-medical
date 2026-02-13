package e5;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o1 implements g5.a, g5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t1 f7827a;

    public /* synthetic */ o1(t1 t1Var) {
        this.f7827a = t1Var;
    }

    @Override // g5.j
    public void A(h5.x0 x0Var) {
        x0Var.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            h5.k kVar = x0Var.f8788a;
            int i10 = kVar.f8632a;
            t1 t1Var = this.f7827a;
            if (i10 == -3 || i10 == -2) {
                FragmentActivity activity = t1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).h1(x0Var.f8788a);
                return;
            }
            if (i10 == -1) {
                FragmentActivity activity2 = t1Var.getActivity();
                activity2.getClass();
                ((MainActivity) activity2).h1(x0Var.f8788a);
                return;
            }
            if (i10 == 523) {
                FragmentActivity activity3 = t1Var.getActivity();
                activity3.getClass();
                ((MainActivity) activity3).C0(1);
            } else if (kVar.f8635d || kVar.e) {
                FragmentActivity activity4 = t1Var.getActivity();
                activity4.getClass();
                ((MainActivity) activity4).h1(x0Var.f8788a);
            } else {
                FragmentActivity activity5 = t1Var.getActivity();
                activity5.getClass();
                ((MainActivity) activity5).C0(2);
                FragmentActivity activity6 = t1Var.getActivity();
                activity6.getClass();
                ((MainActivity) activity6).g1(x0Var.f8788a);
            }
        }
    }

    @Override // g5.e
    public void a(h5.k kVar) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            int i10 = kVar.f8632a;
            t1 t1Var = this.f7827a;
            if (i10 == 523) {
                FragmentActivity activity = t1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).C0(1);
            } else {
                FragmentActivity activity2 = t1Var.getActivity();
                activity2.getClass();
                ((MainActivity) activity2).g1(kVar);
            }
        }
    }

    @Override // g5.a
    public void b(h5.h hVar) {
        hVar.getClass();
    }

    @Override // g5.a
    public void c(h5.h hVar) {
        hVar.getClass();
        t1 t1Var = this.f7827a;
        if (t1Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = t1Var.getActivity();
            activity.getClass();
            RelativeLayout relativeLayout = ((MainActivity) activity).W;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                FragmentActivity activity2 = t1Var.getActivity();
                activity2.getClass();
                ((l4.w) activity2).i0(hVar, new androidx.work.impl.utils.c(5, t1Var, hVar));
            }
        }
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            t1 t1Var = this.f7827a;
            if (t1Var.getActivity() == null || !(t1Var.getActivity() instanceof MainActivity)) {
                return;
            }
            if (hVar.m()) {
                Context contextRequireContext = t1Var.requireContext();
                contextRequireContext.getClass();
                new c1.l(contextRequireContext, hVar.f8566a, new a4.f(t1Var, hVar, 21, false), LifecycleOwnerKt.getLifecycleScope(t1Var));
            } else {
                FragmentActivity activity = t1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).Y(hVar.f8566a);
            }
        }
    }
}

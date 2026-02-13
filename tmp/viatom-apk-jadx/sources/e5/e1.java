package e5;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 implements g5.a, g5.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h1 f7734a;

    public /* synthetic */ e1(h1 h1Var) {
        this.f7734a = h1Var;
    }

    @Override // g5.j
    public void A(h5.x0 x0Var) {
        x0Var.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            String str = x0Var.f8788a.f8633b;
            h1 h1Var = this.f7734a;
            if (kotlin.jvm.internal.l.a(str, h1Var.getString(R.string.top_downloads_title))) {
                x0Var.f8788a.f8633b = h1Var.b();
            }
            h1Var.k(x0Var);
        }
    }

    @Override // g5.e
    public void a(h5.k kVar) {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            this.f7734a.j(kVar);
        }
    }

    @Override // g5.a
    public void b(h5.h hVar) {
        hVar.getClass();
    }

    @Override // g5.a
    public void c(h5.h hVar) {
        hVar.getClass();
        h1 h1Var = this.f7734a;
        if (h1Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = h1Var.getActivity();
            activity.getClass();
            RelativeLayout relativeLayout = ((MainActivity) activity).W;
            if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
                FragmentActivity activity2 = h1Var.getActivity();
                activity2.getClass();
                ((l4.w) activity2).i0(hVar, new androidx.work.impl.utils.c(4, h1Var, hVar));
            }
        }
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            h1 h1Var = this.f7734a;
            if (h1Var.getActivity() == null || !(h1Var.getActivity() instanceof MainActivity)) {
                return;
            }
            if (hVar.m()) {
                Context contextRequireContext = h1Var.requireContext();
                contextRequireContext.getClass();
                new c1.l(contextRequireContext, hVar.f8566a, new a4.f(h1Var, hVar, 20, false), LifecycleOwnerKt.getLifecycleScope(h1Var));
            } else {
                FragmentActivity activity = h1Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).Y(hVar.f8566a);
            }
        }
    }
}

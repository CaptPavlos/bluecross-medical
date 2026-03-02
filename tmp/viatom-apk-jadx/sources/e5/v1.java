package e5;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v1 implements g5.a, g5.e, g5.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f7889a;

    public /* synthetic */ v1(b2 b2Var) {
        this.f7889a = b2Var;
    }

    @Override // g5.d
    public void E(h5.h hVar, int i10) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            long j10 = hVar.f8566a;
            String str = hVar.f8595w;
            b2 b2Var = this.f7889a;
            Context contextRequireContext = b2Var.requireContext();
            contextRequireContext.getClass();
            l1.b.p(j10, contextRequireContext, str);
            n4.p0 p0Var = b2Var.e;
            if (p0Var != null) {
                p0Var.notifyItemChanged(i10);
            }
        }
    }

    @Override // g5.e
    public void a(h5.k kVar) {
        b2 b2Var = this.f7889a;
        FragmentActivity activity = b2Var.getActivity();
        if (activity instanceof AppDetailActivity) {
            FragmentActivity activity2 = b2Var.getActivity();
            activity2.getClass();
            ((AppDetailActivity) activity2).o0(kVar);
            return;
        }
        if (activity instanceof ListsActivity) {
            FragmentActivity activity3 = b2Var.getActivity();
            activity3.getClass();
            ((ListsActivity) activity3).r0(kVar);
            return;
        }
        if (activity instanceof MainActivity) {
            FragmentActivity activity4 = b2Var.getActivity();
            activity4.getClass();
            ((MainActivity) activity4).h1(kVar);
        } else if (activity instanceof MoreInfo) {
            FragmentActivity activity5 = b2Var.getActivity();
            activity5.getClass();
            ((MoreInfo) activity5).r0(kVar);
        } else if (activity instanceof PreregistrationActivity) {
            FragmentActivity activity6 = b2Var.getActivity();
            activity6.getClass();
            ((PreregistrationActivity) activity6).o0(kVar);
        }
    }

    @Override // g5.a
    public void b(h5.h hVar) {
        hVar.getClass();
    }

    @Override // g5.a
    public void c(h5.h hVar) {
        hVar.getClass();
        b2 b2Var = this.f7889a;
        if ((b2Var.getActivity() instanceof MainActivity) || (b2Var.getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = b2Var.getActivity();
            activity.getClass();
            ((l4.w) activity).i0(hVar, new androidx.work.impl.utils.c(6, b2Var, hVar));
        }
    }

    @Override // g5.d
    public void m(h5.h hVar, int i10) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            b2 b2Var = this.f7889a;
            if (b2Var.getContext() != null) {
                if (b2Var.f7688c.f8632a != 1090) {
                    Context contextRequireContext = b2Var.requireContext();
                    contextRequireContext.getClass();
                    new c1.l(contextRequireContext, hVar.f8566a, new w1(b2Var), LifecycleOwnerKt.getLifecycleScope(b2Var));
                    return;
                }
                if (b2Var.getContext() == null || !k4.c.s()) {
                    return;
                }
                Context contextRequireContext2 = b2Var.requireContext();
                contextRequireContext2.getClass();
                if (h5.c1.h(contextRequireContext2) == null) {
                    Intent intent = new Intent(b2Var.requireContext(), (Class<?>) LoginActivity.class);
                    FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    b2Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                    return;
                }
                a2 a2Var = new a2(b2Var, hVar);
                t3.h hVar2 = v5.g.f13148u;
                Context contextRequireContext3 = b2Var.requireContext();
                contextRequireContext3.getClass();
                v5.g gVarL = hVar2.l(contextRequireContext3);
                gVarL.a();
                r7.y.q(LifecycleOwnerKt.getLifecycleScope(b2Var), null, null, new a6.q(b2Var, a2Var, gVarL.I(hVar.f8566a), hVar, null), 3);
            }
        }
    }
}

package e5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w1 implements g5.i, g5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f7896a;

    public /* synthetic */ w1(b2 b2Var) {
        this.f7896a = b2Var;
    }

    public void a(h5.k kVar) {
        b2 b2Var = this.f7896a;
        if (b2Var.getActivity() != null) {
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
    }

    @Override // g5.i
    public void f(int i10) {
        b2 b2Var = this.f7896a;
        if (b2Var.getActivity() instanceof l4.w) {
            FragmentActivity activity = b2Var.getActivity();
            activity.getClass();
            String string = b2Var.getString(R.string.error_generico);
            string.getClass();
            ((l4.w) activity).N(string);
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        b2 b2Var = this.f7896a;
        Context contextRequireContext = b2Var.requireContext();
        contextRequireContext.getClass();
        FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
        fragmentActivityRequireActivity.getClass();
        l1.b.h(contextRequireContext, (l4.w) fragmentActivityRequireActivity, hVar, new a2(b2Var, hVar), true);
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        hVar.getClass();
        float f = UptodownApp.E;
        if (k4.c.s()) {
            boolean zM = hVar.m();
            b2 b2Var = this.f7896a;
            if (zM) {
                Context contextRequireContext = b2Var.requireContext();
                contextRequireContext.getClass();
                new c1.l(contextRequireContext, hVar.f8566a, new a2(b2Var, hVar), LifecycleOwnerKt.getLifecycleScope(b2Var));
            } else if (b2Var.getActivity() != null && (b2Var.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = b2Var.getActivity();
                activity.getClass();
                ((MainActivity) activity).Y(hVar.f8566a);
            } else {
                if (b2Var.getActivity() == null || !(b2Var.getActivity() instanceof l4.w)) {
                    return;
                }
                FragmentActivity activity2 = b2Var.getActivity();
                activity2.getClass();
                ((l4.w) activity2).Y(hVar.f8566a);
            }
        }
    }
}

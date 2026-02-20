package e5;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a2 implements g5.i, g5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f7677a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h5.h f7678b;

    public /* synthetic */ a2(b2 b2Var, h5.h hVar) {
        this.f7677a = b2Var;
        this.f7678b = hVar;
    }

    @Override // g5.g
    public void C(h5.q qVar) {
        this.f7677a.e(this.f7678b.f8595w);
    }

    public void a() {
        b2 b2Var = this.f7677a;
        if (b2Var.getActivity() == null || b2Var.requireActivity().isFinishing()) {
            return;
        }
        FragmentActivity activity = b2Var.getActivity();
        activity.getClass();
        String string = b2Var.getString(R.string.error_generico);
        string.getClass();
        ((l4.w) activity).C(string);
    }

    @Override // g5.i
    public void f(int i10) {
        b2 b2Var = this.f7677a;
        if (b2Var.getActivity() instanceof l4.w) {
            FragmentActivity activity = b2Var.getActivity();
            activity.getClass();
            String string = b2Var.getString(R.string.app_detail_not_found);
            string.getClass();
            ((l4.w) activity).C(string);
        }
    }

    @Override // g5.g
    public void h(h5.q qVar) {
        b2 b2Var = this.f7677a;
        if (b2Var.getContext() != null) {
            float f = UptodownApp.E;
            File fileG = qVar.g();
            fileG.getClass();
            Context contextRequireContext = b2Var.requireContext();
            contextRequireContext.getClass();
            k4.c.p(contextRequireContext, fileG, null);
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        b2 b2Var = this.f7677a;
        if (b2Var.requireActivity().isFinishing()) {
            return;
        }
        hVar.f8592u0 = this.f7678b.f8592u0;
        if (kotlin.jvm.internal.l.a(b2Var.d().b(), "floatingCategory")) {
            hVar.f8594v0 = "floatingCategory";
        } else {
            hVar.f8594v0 = "leafCategory";
        }
        f2 f2VarD = b2Var.d();
        Context contextRequireContext = b2Var.requireContext();
        contextRequireContext.getClass();
        f2VarD.d(contextRequireContext, hVar, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        Intent intent = new Intent(b2Var.requireContext(), (Class<?>) AppDetailActivity.class);
        intent.putExtra("appInfo", hVar);
        float f = UptodownApp.E;
        FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
        fragmentActivityRequireActivity.getClass();
        b2Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
    }

    @Override // g5.g
    public void onError(String str) {
        b2 b2Var = this.f7677a;
        if (b2Var.getActivity() instanceof l4.w) {
            FragmentActivity activity = b2Var.getActivity();
            activity.getClass();
            ((l4.w) activity).N(str);
        }
    }

    @Override // g5.g
    public void x(String str) {
        str.getClass();
        b2 b2Var = this.f7677a;
        if (b2Var.getActivity() instanceof l4.w) {
            FragmentActivity fragmentActivityRequireActivity = b2Var.requireActivity();
            fragmentActivityRequireActivity.getClass();
            v5.c.e((l4.w) fragmentActivityRequireActivity, str, null);
        }
    }
}

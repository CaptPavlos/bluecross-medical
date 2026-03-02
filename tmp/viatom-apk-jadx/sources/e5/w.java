package e5;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.internal.measurement.j4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.views.FullWidthImageView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w implements g5.g, g5.f, t4.b, t4.d, j4.g, g5.z, g5.c, g5.s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7891b;

    public /* synthetic */ w(j0 j0Var, int i10) {
        this.f7890a = i10;
        this.f7891b = j0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f0  */
    @Override // g5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void C(h5.q r13) {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.w.C(h5.q):void");
    }

    @Override // t4.d
    public void a(File file, ArrayList arrayList) throws XmlPullParserException, IOException {
        j0 j0Var = this.f7891b;
        c0 c0Var = new c0(j0Var, 2);
        if (j0Var.getActivity() != null) {
            FragmentActivity activity = j0Var.getActivity();
            activity.getClass();
            if (activity.isFinishing()) {
                return;
            }
            FragmentActivity activity2 = j0Var.getActivity();
            activity2.getClass();
            d5.j jVar = new d5.j(activity2);
            jVar.l(arrayList);
            ArrayList arrayListM = jVar.m();
            FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
            fragmentActivityRequireActivity.getClass();
            new j4(fragmentActivityRequireActivity, c0Var).k(arrayListM, false);
            if (j0Var.getActivity() instanceof l4.w) {
                t3.h hVar = v5.g.f13148u;
                FragmentActivity activity3 = j0Var.getActivity();
                activity3.getClass();
                v5.g gVarL = hVar.l(activity3);
                gVarL.a();
                String name = file.getName();
                name.getClass();
                h5.q qVarW = gVarL.w(name);
                gVarL.b();
                if (qVarW != null) {
                    FragmentActivity activity4 = j0Var.getActivity();
                    activity4.getClass();
                    ((l4.w) activity4).V(qVarW);
                }
            }
        }
    }

    @Override // g5.f
    public void b(long j10) {
        j0 j0Var = this.f7891b;
        if (j0Var.getActivity() != null && (j0Var.getActivity() instanceof MainActivity)) {
            FragmentActivity activity = j0Var.getActivity();
            activity.getClass();
            ((MainActivity) activity).Y(j10);
        } else {
            if (j0Var.getActivity() == null || !(j0Var.getActivity() instanceof AppDetailActivity)) {
                return;
            }
            FragmentActivity activity2 = j0Var.getActivity();
            activity2.getClass();
            ((AppDetailActivity) activity2).Y(j10);
        }
    }

    @Override // t4.d
    public void c(int i10) {
        j0.l(this.f7891b, i10);
    }

    @Override // g5.f
    public void d(h5.k kVar) {
        this.f7891b.R(kVar);
    }

    @Override // t4.d
    public void g() {
        j0 j0Var = this.f7891b;
        if (j0Var.getContext() != null) {
            String string = j0Var.getString(R.string.msg_install_from_unknown_source, j0Var.getString(R.string.app_name));
            string.getClass();
            j0Var.x(string);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a1  */
    @Override // g5.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(h5.q r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.w.h(h5.q):void");
    }

    @Override // t4.b
    public void i() {
        j0 j0Var = this.f7891b;
        String string = j0Var.getString(R.string.installing);
        string.getClass();
        j0.j(j0Var, string);
    }

    @Override // g5.s
    public void j() {
        j0 j0Var = this.f7891b;
        Context contextRequireContext = j0Var.requireContext();
        contextRequireContext.getClass();
        h5.e1 e1VarH = h5.c1.h(contextRequireContext);
        if (e1VarH == null || !e1VarH.d()) {
            return;
        }
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.y.setVisibility(8);
    }

    @Override // t4.b
    public void k(String str) {
        j0 j0Var = this.f7891b;
        if (str != null) {
            j0Var.x(str);
            return;
        }
        String string = j0Var.getString(R.string.error_generico);
        string.getClass();
        j0Var.x(string);
    }

    @Override // t4.d
    public void l() {
        j0 j0Var = this.f7891b;
        if (j0Var.getContext() != null) {
            String string = j0Var.getString(R.string.core_kill_this_app, j0Var.getString(R.string.app_name));
            string.getClass();
            j0Var.x(string);
        }
    }

    @Override // g5.z
    public void m(h5.o0 o0Var) {
        j0 j0Var = this.f7891b;
        j0Var.D().Q = o0Var;
        if (j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
            Intent intent = new Intent(j0Var.requireActivity(), (Class<?>) VirusTotalReport.class);
            intent.putExtra("appInfo", j0Var.D());
            intent.putExtra("appReportVT", o0Var);
            float f = UptodownApp.E;
            FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
            fragmentActivityRequireActivity.getClass();
            j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
        }
        u7.m0 m0Var = j0Var.G().T;
        Boolean bool = Boolean.FALSE;
        m0Var.getClass();
        m0Var.g(null, bool);
    }

    @Override // t4.d
    public void n() {
        j0.l(this.f7891b, 0);
    }

    @Override // t4.d
    public void o() {
        j0 j0Var = this.f7891b;
        if (j0Var.getContext() != null) {
            String string = j0Var.getString(R.string.error_unzipping);
            string.getClass();
            j0Var.x(string);
        }
    }

    @Override // g5.g
    public void onError(String str) {
        this.f7891b.x(str);
    }

    @Override // j4.g
    public void onSuccess() {
        j0 j0Var = this.f7891b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        ((FullWidthImageView) bVar.I.f219c).setVisibility(0);
        if (!((Boolean) j0Var.G().P.getValue()).booleanValue()) {
            d5.b bVar2 = j0Var.f7785b;
            bVar2.getClass();
            bVar2.f6869c.setTitle(j0Var.D().f8567b);
            d5.b bVar3 = j0Var.f7785b;
            bVar3.getClass();
            bVar3.f6868b.setExpanded(false, false);
        }
        String strE = j0Var.D().e();
        if (strE == null || strE.length() == 0) {
            return;
        }
        j0Var.C();
        FragmentActivity activity = j0Var.getActivity();
        if (activity != null) {
            j0Var.t0(activity);
        }
    }

    @Override // j4.g
    public void p(Exception exc) {
        exc.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    @Override // g5.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q() {
        /*
            r5 = this;
            e5.j0 r0 = r5.f7891b
            androidx.fragment.app.FragmentActivity r1 = r0.getActivity()
            if (r1 == 0) goto L72
            androidx.fragment.app.FragmentActivity r1 = r0.requireActivity()
            boolean r1 = r1.isFinishing()
            if (r1 != 0) goto L72
            h5.h r1 = r0.D()
            java.lang.String r1 = r1.g
            if (r1 == 0) goto L60
            int r1 = r1.length()
            if (r1 != 0) goto L21
            goto L60
        L21:
            h5.h r1 = r0.D()
            java.lang.String r1 = r1.g
            r1.getClass()
            long r1 = java.lang.Long.parseLong(r1)
            r3 = 650000000(0x26be3680, double:3.2114267E-315)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L60
            android.content.Intent r1 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r2 = r0.requireActivity()
            java.lang.Class<com.uptodown.activities.VirusTotalReport> r3 = com.uptodown.activities.VirusTotalReport.class
            r1.<init>(r2, r3)
            java.lang.String r2 = "appInfo"
            h5.h r3 = r0.D()
            r1.putExtra(r2, r3)
            java.lang.String r2 = "isVirusTotalReportAvaialable"
            r3 = 0
            r1.putExtra(r2, r3)
            float r2 = com.uptodown.UptodownApp.E
            androidx.fragment.app.FragmentActivity r2 = r0.requireActivity()
            r2.getClass()
            android.os.Bundle r2 = k4.c.a(r2)
            r0.startActivity(r1, r2)
            goto L72
        L60:
            androidx.fragment.app.FragmentActivity r1 = r0.getActivity()
            r1.getClass()
            l4.w r1 = (l4.w) r1
            h5.h r2 = r0.D()
            java.lang.String r2 = r2.G
            r1.c0(r2)
        L72:
            e5.c1 r0 = r0.G()
            u7.m0 r0 = r0.T
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.getClass()
            r2 = 0
            r0.g(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.w.q():void");
    }

    @Override // t4.d
    public void r() {
        j0 j0Var = this.f7891b;
        if (j0Var.getActivity() == null || !(j0Var.getActivity() instanceof l4.w)) {
            return;
        }
        FragmentActivity activity = j0Var.getActivity();
        activity.getClass();
        ((l4.w) activity).k();
    }

    @Override // g5.g
    public void x(String str) {
        str.getClass();
        j0 j0Var = this.f7891b;
        FragmentActivity activity = j0Var.getActivity();
        activity.getClass();
        v5.c.e((l4.w) activity, str, null);
        c1 c1VarG = j0Var.G();
        Context contextRequireContext = j0Var.requireContext();
        contextRequireContext.getClass();
        long j10 = j0Var.D().f8566a;
        c1VarG.getClass();
        r7.w viewModelScope = ViewModelKt.getViewModelScope(c1VarG);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, y7.d.f14116a, null, new r0(contextRequireContext, c1VarG, j10, (w6.c) null), 2);
    }

    @Override // g5.c
    public void z(h5.h hVar) {
        int i10 = this.f7890a;
        j0 j0Var = this.f7891b;
        hVar.getClass();
        switch (i10) {
            case 6:
                float f = UptodownApp.E;
                if (k4.c.s() && j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    j0.d(j0Var, hVar);
                    break;
                }
                break;
            case 7:
                float f10 = UptodownApp.E;
                if (k4.c.s() && j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    j0.d(j0Var, hVar);
                    break;
                }
                break;
            default:
                float f11 = UptodownApp.E;
                if (k4.c.s() && j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    j0.d(j0Var, hVar);
                    break;
                }
                break;
        }
    }

    @Override // t4.d
    public void e(File file) {
    }

    @Override // t4.d
    public void f(File file) {
    }
}

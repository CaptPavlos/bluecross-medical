package e5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import c1.w4;
import com.google.android.gms.internal.measurement.a4;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f2 extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final u7.m0 f7747a;

    /* renamed from: b, reason: collision with root package name */
    public final u7.m0 f7748b;

    /* renamed from: c, reason: collision with root package name */
    public final u7.m0 f7749c;

    /* renamed from: d, reason: collision with root package name */
    public final u7.m0 f7750d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public int f7751i;

    public f2() {
        v5.j jVar = v5.j.f13166a;
        u7.m0 m0VarA = u7.i0.a(jVar);
        this.f7747a = m0VarA;
        this.f7748b = m0VarA;
        u7.m0 m0VarA2 = u7.i0.a(jVar);
        this.f7749c = m0VarA2;
        this.f7750d = m0VarA2;
    }

    public static final h5.x0 a(f2 f2Var, Context context, h5.k kVar) {
        w4 w4Var = new w4(context, 4, false);
        h5.x0 x0Var = new h5.x0(null, null, 7);
        kVar.getClass();
        x0Var.f8788a = kVar;
        int i10 = kVar.f8632a;
        if (i10 > 0) {
            if (kVar.f8635d) {
                int i11 = f2Var.f7751i;
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(40));
                map.put("page[offset]", String.valueOf(i11));
                String strG = a3.a.g(i10, "/eapi/v2/floating-category/", "/data-and-apps-list");
                h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat(strG), ShareTarget.METHOD_GET, map);
                p0VarM.f8699d = w4Var.k(p0VarM, strG);
                x0Var = a4.v(p0VarM, kVar);
            } else {
                int i12 = kVar.f;
                boolean z9 = (i12 == 0 || i12 == 831) ? false : true;
                int i13 = f2Var.f7751i;
                if (z9) {
                    x0Var = a4.v(w4Var.w(i10, 40, i13), kVar);
                } else {
                    x0Var.f8789b = w4.I(w4Var.v(i10, 40, i13));
                }
            }
        } else if (i10 == -1) {
            x0Var.f8789b = w4.I(w4Var.u(40, f2Var.f7751i));
        } else if (i10 == -2) {
            int i14 = kVar.f;
            int i15 = f2Var.f7751i;
            x0Var.f8789b = w4.I(i14 > 0 ? w4Var.r(i14, 40, i15) : w4Var.o(40, i15));
        } else if (i10 == -3) {
            int i16 = f2Var.f7751i;
            HashMap map2 = new HashMap();
            map2.put("page[limit]", String.valueOf(40));
            map2.put("page[offset]", String.valueOf(i16));
            h5.p0 p0VarM2 = w4Var.m("https://www.uptodown.app:443".concat("/eapi/apps/latest-updates"), ShareTarget.METHOD_GET, map2);
            p0VarM2.f8699d = w4Var.k(p0VarM2, "/eapi/apps/latest-updates");
            x0Var.f8789b = w4.I(p0VarM2);
        }
        f2Var.f7751i = x0Var.f8789b.size() + f2Var.f7751i;
        return x0Var;
    }

    public final String b() {
        u7.m0 m0Var = this.f7747a;
        if (!(m0Var.getValue() instanceof v5.l)) {
            return null;
        }
        Object value = m0Var.getValue();
        value.getClass();
        return ((c2) ((v5.l) value).f13168a).f7715a.f8788a.f8635d ? "floatingCategory" : "leafCategory";
    }

    public final void c(Context context, int i10) {
        r7.w viewModelScope = ViewModelKt.getViewModelScope(this);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(viewModelScope, y7.d.f14116a, null, new d2(this, context, i10, null), 2);
    }

    public final void d(Context context, h5.h hVar, String str) {
        if (hVar.m()) {
            r7.w viewModelScope = ViewModelKt.getViewModelScope(this);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new c5.c((Object) this, (Object) context, (Object) hVar, (Object) str, (w6.c) null, 4), 2);
        }
    }
}

package y5;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.lifecycle.ViewModelKt;
import c1.w4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.UserCommentsActivity;
import l4.wa;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14013a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14014b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f14015c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f14016d;

    public /* synthetic */ t(u uVar, h5.e1 e1Var, int i10) {
        this.f14013a = 0;
        this.f14015c = uVar;
        this.f14016d = e1Var;
        this.f14014b = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        n4.d dVar;
        int i10 = this.f14013a;
        Object obj = this.f14016d;
        int i11 = this.f14014b;
        Object obj2 = this.f14015c;
        switch (i10) {
            case 0:
                d0.i iVar = ((u) obj2).f14023b;
                ((h5.e1) obj).f8512a.getClass();
                FollowListActivity followListActivity = (FollowListActivity) iVar.f6781b;
                float f = UptodownApp.E;
                if (k4.c.s() && (dVar = followListActivity.J) != null) {
                    Object obj3 = dVar.f11318a.get(i11);
                    obj3.getClass();
                    h5.e1 e1Var = (h5.e1) obj3;
                    if (e1Var.f8516i == 1) {
                        l4.n0 n0VarO0 = followListActivity.o0();
                        String str = e1Var.f8512a;
                        str.getClass();
                        n0VarO0.getClass();
                        n0VarO0.e = true;
                        r7.w viewModelScope = ViewModelKt.getViewModelScope(n0VarO0);
                        y7.e eVar = r7.i0.f12407a;
                        r7.y.q(viewModelScope, y7.d.f14116a, null, new l4.l0(n0VarO0, followListActivity, str, null, 1), 2);
                        n4.d dVar2 = followListActivity.J;
                        dVar2.getClass();
                        ((h5.e1) dVar2.f11318a.get(i11)).f8516i = 0;
                    } else {
                        l4.n0 n0VarO02 = followListActivity.o0();
                        String str2 = e1Var.f8512a;
                        str2.getClass();
                        n0VarO02.getClass();
                        n0VarO02.e = true;
                        r7.w viewModelScope2 = ViewModelKt.getViewModelScope(n0VarO02);
                        y7.e eVar2 = r7.i0.f12407a;
                        r7.y.q(viewModelScope2, y7.d.f14116a, null, new l4.l0(n0VarO02, followListActivity, str2, null, 0), 2);
                        n4.d dVar3 = followListActivity.J;
                        dVar3.getClass();
                        ((h5.e1) dVar3.f11318a.get(i11)).f8516i = 1;
                    }
                    n4.d dVar4 = followListActivity.J;
                    if (dVar4 != null) {
                        dVar4.notifyItemChanged(i11);
                        break;
                    }
                }
                break;
            case 1:
                u1 u1Var = (u1) obj2;
                h5.t0 t0Var = (h5.t0) obj;
                x4 x4Var = u1Var.f14029a;
                Context context = u1Var.f14030b;
                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) x4Var.f10987b;
                float f10 = UptodownApp.E;
                if (k4.c.s()) {
                    if (h5.c1.h(userCommentsActivity) != null) {
                        n4.a1 a1Var = userCommentsActivity.J;
                        a1Var.getClass();
                        if (!v5.n.f13172d.contains(Long.valueOf(((h5.t0) a1Var.f11296a.get(i11)).f8739a))) {
                            wa waVarO0 = userCommentsActivity.o0();
                            n4.a1 a1Var2 = userCommentsActivity.J;
                            a1Var2.getClass();
                            Object obj4 = a1Var2.f11296a.get(i11);
                            obj4.getClass();
                            h5.t0 t0Var2 = (h5.t0) obj4;
                            waVarO0.getClass();
                            r7.w viewModelScope3 = ViewModelKt.getViewModelScope(waVarO0);
                            y7.e eVar3 = r7.i0.f12407a;
                            r7.y.q(viewModelScope3, y7.d.f14116a, null, new b9.p(t0Var2, userCommentsActivity, waVarO0, (w6.c) null, 19), 2);
                        }
                    } else {
                        String string = userCommentsActivity.getString(R.string.login_required_like_title);
                        string.getClass();
                        String string2 = userCommentsActivity.getString(R.string.login_required_like_msg);
                        string2.getClass();
                        a.a.q(userCommentsActivity, string, string2);
                    }
                }
                if (h5.c1.h(context) != null) {
                    new w4(context, 5, false).F(u1Var.f14036l);
                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                        u1Var.h.setText(String.valueOf(t0Var.f8744j + 1));
                        break;
                    }
                }
                break;
            default:
                ((z5.m) obj2).f14443b.invoke(Integer.valueOf(i11), (String) obj);
                break;
        }
    }

    public /* synthetic */ t(int i10, Object obj, int i11, Object obj2) {
        this.f14013a = i11;
        this.f14015c = obj;
        this.f14014b = i10;
        this.f14016d = obj2;
    }
}

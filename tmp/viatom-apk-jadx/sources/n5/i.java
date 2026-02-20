package n5;

import android.content.Context;
import c1.w4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g7.p;
import h5.k;
import h5.p0;
import h5.x0;
import java.util.ArrayList;
import l4.p2;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11556a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p2 f11557b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w4 f11558c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(w4 w4Var, p2 p2Var, w6.c cVar) {
        super(2, cVar);
        this.f11558c = w4Var;
        this.f11557b = p2Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11556a) {
            case 0:
                return new i(this.f11558c, this.f11557b, cVar);
            default:
                return new i(this.f11557b, this.f11558c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11556a) {
        }
        return ((i) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        String string;
        String string2;
        int i10 = this.f11556a;
        x0 x0Var = null;
        boolean z9 = true;
        p2 p2Var = this.f11557b;
        w4 w4Var = this.f11558c;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                k kVar = (k) p2Var.f10715b;
                p0 p0VarR = w4Var.r(kVar.f8632a, 10, 0);
                if (p0VarR.b() || (str = p0VarR.f8696a) == null || str.length() == 0) {
                    z9 = false;
                } else {
                    ArrayList arrayListI = w4.I(p0VarR);
                    try {
                        string = ((Context) p2Var.f10716c).getString(R.string.the_latest_title);
                        string.getClass();
                    } catch (Exception e) {
                        e.printStackTrace();
                        string = "The latest";
                    }
                    k kVar2 = new k(-2, string, 4);
                    kVar2.f = kVar.f8632a;
                    x0Var = new x0(kVar2, arrayListI, 4);
                    x0Var.f8790c = 1;
                }
                return new d(x0Var, z9);
            default:
                s6.a.e(obj);
                k kVar3 = (k) p2Var.f10715b;
                int i11 = kVar3.f8632a;
                p0 p0VarV = w4Var.v(i11, i11 == 523 ? 8 : 10, 0);
                if (p0VarV.b() || p0VarV.f8699d == null) {
                    z9 = false;
                } else {
                    ArrayList arrayListI2 = w4.I(p0VarV);
                    try {
                        string2 = ((Context) p2Var.f10716c).getString(R.string.top_downloads_title);
                        string2.getClass();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        string2 = "Top Downloads";
                    }
                    k kVar4 = new k(-1, string2, 4);
                    kVar4.f = kVar3.f8632a;
                    x0Var = new x0(kVar4, arrayListI2, 4);
                    if (kVar3.f8632a == 523) {
                        float f = UptodownApp.E;
                        x0Var.f8790c = 4;
                    } else {
                        x0Var.f8790c = 5;
                    }
                }
                return new d(x0Var, z9);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(p2 p2Var, w4 w4Var, w6.c cVar) {
        super(2, cVar);
        this.f11557b = p2Var;
        this.f11558c = w4Var;
    }
}

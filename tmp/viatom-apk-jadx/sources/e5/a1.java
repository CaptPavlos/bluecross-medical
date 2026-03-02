package e5;

import android.content.Context;
import c1.w4;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7673a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f7674b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7675c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f7676d;
    public final /* synthetic */ c1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(Context context, String str, int i10, long j10, c1 c1Var, w6.c cVar) {
        super(2, cVar);
        this.f7673a = context;
        this.f7674b = str;
        this.f7675c = i10;
        this.f7676d = j10;
        this.e = c1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new a1(this.f7673a, this.f7674b, this.f7675c, this.f7676d, this.e, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        a1 a1Var = (a1) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        a1Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10;
        JSONObject jSONObject;
        s6.a.e(obj);
        Context context = this.f7673a;
        String str = this.f7674b;
        boolean z9 = false;
        if (c1.d0.q(context, str)) {
            i10 = 0;
        } else {
            c1.d0.u(context, str, String.valueOf(System.currentTimeMillis()));
            w4 w4Var = new w4(context, 4, false);
            h5.t0 t0Var = new h5.t0();
            t0Var.f = str;
            t0Var.g = this.f7675c;
            h5.p0 p0VarJ = w4Var.J(this.f7676d, t0Var);
            i10 = p0VarJ.f8697b;
            if (!p0VarJ.b() && (jSONObject = p0VarJ.f8699d) != null && jSONObject.optInt("success") == 1) {
                z9 = true;
            }
        }
        u7.m0 m0Var = this.e.f7709s;
        v5.l lVar = new v5.l(new p0(z9, i10));
        m0Var.getClass();
        m0Var.g(null, lVar);
        return s6.w.f12711a;
    }
}

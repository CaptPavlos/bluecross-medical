package l4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y5 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z5 f11025a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11026b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f11027c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f11028d;
    public final /* synthetic */ kotlin.jvm.internal.x e;
    public final /* synthetic */ kotlin.jvm.internal.v f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y5(z5 z5Var, Context context, String str, String str2, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, w6.c cVar) {
        super(2, cVar);
        this.f11025a = z5Var;
        this.f11026b = context;
        this.f11027c = str;
        this.f11028d = str2;
        this.e = xVar;
        this.f = vVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new y5(this.f11025a, this.f11026b, this.f11027c, this.f11028d, this.e, this.f, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        y5 y5Var = (y5) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        y5Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        s6.a.e(obj);
        u7.m0 m0Var = this.f11025a.f11063a;
        m0Var.getClass();
        m0Var.g(null, v5.j.f13166a);
        c1.w4 w4Var = new c1.w4(this.f11026b, 4, false);
        HashMap map = new HashMap();
        map.put("password1", this.f11027c);
        map.put("password2", this.f11028d);
        h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/user/set-new-password"), ShareTarget.METHOD_POST, map);
        if (p0VarM.b()) {
            p0VarM.f8699d = w4Var.l(p0VarM, "/eapi/user/set-new-password");
        } else {
            p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/set-new-password");
        }
        boolean zB = p0VarM.b();
        kotlin.jvm.internal.v vVar = this.f;
        kotlin.jvm.internal.x xVar = this.e;
        if (!zB && (jSONObject = p0VarM.f8699d) != null) {
            xVar.f10138a = h5.p0.c(jSONObject);
            vVar.f10136a = jSONObject.optInt("success");
        }
        v5.l lVar = new v5.l(new x5(vVar.f10136a, (String) xVar.f10138a, p0VarM.b()));
        m0Var.getClass();
        m0Var.g(null, lVar);
        return s6.w.f12711a;
    }
}

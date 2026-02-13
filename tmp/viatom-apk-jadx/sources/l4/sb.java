package l4;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.UserActivity;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class sb extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10829a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f10830b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ tb f10831c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ sb(UserActivity userActivity, tb tbVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10829a = i10;
        this.f10830b = userActivity;
        this.f10831c = tbVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10829a) {
            case 0:
                return new sb(this.f10830b, this.f10831c, cVar, 0);
            default:
                return new sb(this.f10830b, this.f10831c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10829a) {
            case 0:
                sb sbVar = (sb) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                sbVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                sb sbVar2 = (sb) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                sbVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        switch (this.f10829a) {
            case 0:
                s6.a.e(obj);
                UserActivity userActivity = this.f10830b;
                int size = com.google.android.gms.internal.measurement.l5.z(userActivity).size();
                v5.g gVarL = v5.g.f13148u.l(userActivity);
                gVarL.a();
                ArrayList arrayListF = gVarL.F();
                gVarL.b();
                Iterator it = arrayListF.iterator();
                it.getClass();
                int i10 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    h5.q qVar = (h5.q) next;
                    if (qVar.o() && qVar.f8702c == 0 && qVar.c()) {
                        i10++;
                    }
                }
                u7.m0 m0Var = this.f10831c.f10856a;
                v5.l lVar = new v5.l(new rb(i10, size));
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                s6.a.e(obj);
                c1.w4 w4Var = new c1.w4(this.f10830b, 4, false);
                h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/promo-assign/provider/1"), ShareTarget.METHOD_GET, null);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/promo-assign/provider/1");
                if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null && !jSONObjectOptJSONObject.isNull("url")) {
                    String strOptString = jSONObjectOptJSONObject.optString("url");
                    u7.m0 m0Var2 = this.f10831c.e;
                    v5.l lVar2 = new v5.l(strOptString);
                    m0Var2.getClass();
                    m0Var2.g(null, lVar2);
                }
                break;
        }
        return s6.w.f12711a;
    }
}

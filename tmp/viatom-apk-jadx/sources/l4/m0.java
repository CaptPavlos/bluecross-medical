package l4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10612a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f10613b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10614c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10615d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(n0 n0Var, Context context, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10612a = i10;
        this.f10613b = n0Var;
        this.f10614c = context;
        this.f10615d = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10612a) {
            case 0:
                return new m0(this.f10613b, this.f10614c, this.f10615d, cVar, 0);
            default:
                return new m0(this.f10613b, this.f10614c, this.f10615d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10612a) {
            case 0:
                m0 m0Var = (m0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                m0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                m0 m0Var2 = (m0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                m0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        switch (this.f10612a) {
            case 0:
                s6.a.e(obj);
                n0 n0Var = this.f10613b;
                n0Var.h = true;
                ArrayList arrayList = new ArrayList();
                c1.w4 w4Var = new c1.w4(this.f10614c, 4, false);
                int i10 = n0Var.f;
                String str = this.f10615d;
                str.getClass();
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(40));
                map.put("page[offset]", String.valueOf(i10));
                h5.p0 p0VarM = w4Var.m(androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.uptodown.app:443/eapi/user/", str, "/followers"), ShareTarget.METHOD_GET, map);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/userID/followers");
                if (p0VarM.b() || (jSONObject = p0VarM.f8699d) == null) {
                    n0Var.g = false;
                } else {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONArrayOptJSONArray != null) {
                        arrayList.addAll(h5.c1.f(jSONArrayOptJSONArray));
                        n0Var.f = arrayList.size() + n0Var.f;
                    }
                }
                u7.m0 m0Var = n0Var.f10641a;
                v5.l lVar = new v5.l(arrayList);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                s6.a.e(obj);
                n0 n0Var2 = this.f10613b;
                n0Var2.h = true;
                ArrayList arrayList2 = new ArrayList();
                c1.w4 w4Var2 = new c1.w4(this.f10614c, 4, false);
                int i11 = n0Var2.f;
                String str2 = this.f10615d;
                str2.getClass();
                HashMap map2 = new HashMap();
                map2.put("page[limit]", String.valueOf(40));
                map2.put("page[offset]", String.valueOf(i11));
                h5.p0 p0VarM2 = w4Var2.m(androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.uptodown.app:443/eapi/user/", str2, "/followings"), ShareTarget.METHOD_GET, map2);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, "/eapi/user/userID/followings");
                if (p0VarM2.b() || (jSONObject2 = p0VarM2.f8699d) == null) {
                    n0Var2.g = false;
                } else {
                    JSONArray jSONArrayOptJSONArray2 = jSONObject2.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONArrayOptJSONArray2 != null) {
                        arrayList2.addAll(h5.c1.f(jSONArrayOptJSONArray2));
                        n0Var2.f = arrayList2.size() + n0Var2.f;
                    }
                }
                u7.m0 m0Var2 = n0Var2.f10641a;
                v5.l lVar2 = new v5.l(arrayList2);
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

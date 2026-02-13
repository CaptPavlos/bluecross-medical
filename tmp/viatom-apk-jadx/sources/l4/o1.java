package l4;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.ListsActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10677a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f10678b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p1 f10679c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10680d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(ListsActivity listsActivity, ArrayList arrayList, p1 p1Var, w6.c cVar) {
        super(2, cVar);
        this.f10678b = listsActivity;
        this.f10680d = arrayList;
        this.f10679c = p1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10677a) {
            case 0:
                return new o1(this.f10678b, this.f10680d, this.f10679c, cVar);
            default:
                return new o1(this.f10678b, this.f10679c, this.f10680d, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10677a) {
            case 0:
                o1 o1Var = (o1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                o1Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                o1 o1Var2 = (o1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                o1Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        switch (this.f10677a) {
            case 0:
                s6.a.e(obj);
                c1.w4 w4Var = new c1.w4(this.f10678b, 4, false);
                h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/user/categories"), ShareTarget.METHOD_GET, null);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/categories");
                boolean zB = p0VarM.b();
                ArrayList arrayList = this.f10680d;
                if (!zB && (jSONObject = p0VarM.f8699d) != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i10 = 0; i10 < length; i10++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                        jSONObjectOptJSONObject2.getClass();
                        h5.u uVar = new h5.u();
                        uVar.f8752c = new ArrayList();
                        if (!jSONObjectOptJSONObject2.isNull("categoryID")) {
                            uVar.f8750a = jSONObjectOptJSONObject2.optInt("categoryID");
                        }
                        if (!jSONObjectOptJSONObject2.isNull("categoryName")) {
                            uVar.f8751b = jSONObjectOptJSONObject2.optString("categoryName");
                        }
                        if (!jSONObjectOptJSONObject2.isNull("categoryIcons") && (jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("categoryIcons")) != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            for (int i11 = 0; i11 < length2; i11++) {
                                uVar.f8752c.add(jSONArrayOptJSONArray2.optString(i11));
                            }
                        }
                        if (!jSONObjectOptJSONObject2.isNull("categoryAppsCount")) {
                            uVar.f8753d = jSONObjectOptJSONObject2.optInt("categoryAppsCount");
                        }
                        arrayList.add(uVar);
                    }
                }
                u7.m0 m0Var = this.f10679c.f10710j;
                v5.l lVar = new v5.l(arrayList);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                s6.a.e(obj);
                c1.w4 w4Var2 = new c1.w4(this.f10678b, 4, false);
                p1 p1Var = this.f10679c;
                int i12 = p1Var.f10713m;
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(i12));
                map.putAll(w4Var2.i());
                h5.p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443".concat("/eapi/v2/pre-register-apps-by-user"), ShareTarget.METHOD_GET, map);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, "/eapi/v2/pre-register-apps-by-user");
                boolean zB2 = p0VarM2.b();
                ArrayList arrayList2 = this.f10680d;
                int iOptInt = 0;
                if (!zB2 && (jSONObject2 = p0VarM2.f8699d) != null && (jSONObjectOptJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("apps");
                    if (jSONArrayOptJSONArray3 != null) {
                        int length3 = jSONArrayOptJSONArray3.length();
                        while (iOptInt < length3) {
                            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(iOptInt);
                            jSONObjectOptJSONObject3.getClass();
                            h5.g0 g0Var = new h5.g0();
                            if (!jSONObjectOptJSONObject3.isNull("appID")) {
                                g0Var.f8558a = jSONObjectOptJSONObject3.optLong("appID");
                            }
                            if (!jSONObjectOptJSONObject3.isNull(RewardPlus.NAME)) {
                                g0Var.f8559b = jSONObjectOptJSONObject3.optString(RewardPlus.NAME);
                            }
                            if (!jSONObjectOptJSONObject3.isNull("iconURL")) {
                                g0Var.f8560c = jSONObjectOptJSONObject3.optString("iconURL");
                            }
                            if (!jSONObjectOptJSONObject3.isNull("authorName")) {
                                g0Var.f8561d = jSONObjectOptJSONObject3.optString("authorName");
                            }
                            arrayList2.add(g0Var);
                            iOptInt++;
                        }
                    }
                    iOptInt = jSONObjectOptJSONObject.optInt("countApps");
                }
                u7.m0 m0Var2 = p1Var.g;
                v5.l lVar2 = new v5.l(new n1(arrayList2, iOptInt));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(ListsActivity listsActivity, p1 p1Var, ArrayList arrayList, w6.c cVar) {
        super(2, cVar);
        this.f10678b = listsActivity;
        this.f10679c = p1Var;
        this.f10680d = arrayList;
    }
}

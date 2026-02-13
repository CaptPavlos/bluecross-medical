package b9;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.LiveDataScope;
import c1.w4;
import c5.b0;
import c5.g0;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import g5.w;
import h5.p0;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.v;
import org.json.JSONArray;
import org.json.JSONObject;
import r7.i0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f920a;

    /* renamed from: b, reason: collision with root package name */
    public int f921b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f922c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f923d;
    public /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(Object obj, int i10, int i11, w wVar, w6.c cVar, int i12) {
        super(2, cVar);
        this.f920a = i12;
        this.e = obj;
        this.f922c = i10;
        this.f923d = i11;
        this.f = wVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f920a) {
            case 0:
                o oVar = new o((String) this.f, this.f922c, this.f923d, cVar);
                oVar.e = obj;
                return oVar;
            case 1:
                return new o((w4) this.e, this.f922c, this.f923d, (w) this.f, cVar, 1);
            default:
                return new o((b0) this.e, this.f922c, this.f923d, (w) this.f, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f920a) {
        }
        return ((o) create((r7.w) obj, (w6.c) obj2)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        LiveDataScope liveDataScope;
        String str;
        ArrayList arrayList;
        Object objB;
        JSONObject jSONObjectOptJSONObject;
        int i10 = this.f920a;
        s6.w wVar = s6.w.f12711a;
        int i11 = this.f923d;
        int i12 = this.f922c;
        x6.a aVar = x6.a.f13718a;
        Object obj2 = this.f;
        switch (i10) {
            case 0:
                String str2 = (String) obj2;
                int i13 = this.f921b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    liveDataScope = (LiveDataScope) this.e;
                    h hVar = s.f937b;
                    String strT = i9.a.j().t(63);
                    String str3 = str2.equals("STATE_AND_NATIONAL") ? i9.a.f9113m : null;
                    Object obj3 = Boolean.TRUE;
                    this.e = liveDataScope;
                    this.f921b = 1;
                    hVar.getClass();
                    ArrayList arrayList2 = (ArrayList) hVar.h;
                    d0.i iVar = (d0.i) hVar.f;
                    String strE = j.g.e();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(arrayList2);
                    String strK = androidx.constraintlayout.core.widgets.analyzer.a.k(i12);
                    if (i11 == 1) {
                        str = "none";
                    } else if (i11 == 2) {
                        str = "all";
                    } else {
                        if (i11 != 3) {
                            throw null;
                        }
                        str = "Partial";
                    }
                    String str4 = str;
                    if (j.g.f9878a) {
                        ArrayList arrayList4 = new ArrayList();
                        j.g.f9879b.forEach(new j.e(arrayList4, 0));
                        arrayList = arrayList4;
                    } else {
                        arrayList = null;
                    }
                    k kVar = new k(arrayList3, strK, str4, null, strT, str3, str2, null, null, strE, arrayList, null, 2440);
                    if (obj3.equals(obj3)) {
                        iVar.q(74, true);
                    }
                    iVar.p(73, androidx.constraintlayout.core.widgets.analyzer.a.k(i12));
                    if (strE == null) {
                        strE = "";
                    }
                    iVar.p(93, strE);
                    arrayList2.clear();
                    objB = hVar.b(3, kVar, d.MSPA, this);
                    if (objB != aVar) {
                    }
                    return aVar;
                }
                if (i13 != 1) {
                    if (i13 == 2) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                liveDataScope = (LiveDataScope) this.e;
                s6.a.e(obj);
                objB = obj;
                this.e = null;
                this.f921b = 2;
                if (liveDataScope.emit((String) objB, this) != aVar) {
                    return wVar;
                }
                return aVar;
            case 1:
                w wVar2 = (w) obj2;
                int i14 = this.f921b;
                if (i14 != 0) {
                    if (i14 == 1 || i14 == 2) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var = new w4(((w4) this.e).f1555a, 4, false);
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(i12));
                map.put("page[offset]", String.valueOf(i11));
                p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/my-recommended-list"), ShareTarget.METHOD_GET, map);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/my-recommended-list");
                if (p0VarM.b()) {
                    y7.e eVar = i0.f12407a;
                    s7.c cVar = w7.n.f13548a;
                    g0 g0Var = new g0(wVar2, null, 0);
                    this.f921b = 2;
                    if (y.z(g0Var, cVar, this) != aVar) {
                        return wVar;
                    }
                } else {
                    u uVar = new u();
                    uVar.f10135a = true;
                    v vVar = new v();
                    ArrayList arrayList5 = new ArrayList();
                    String str5 = p0VarM.f8696a;
                    if (str5 != null && str5.length() != 0) {
                        String str6 = p0VarM.f8696a;
                        str6.getClass();
                        JSONObject jSONObjectOptJSONObject2 = new JSONObject(str6).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObjectOptJSONObject2 != null) {
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("items");
                            if (jSONArrayOptJSONArray != null) {
                                int length = jSONArrayOptJSONArray.length();
                                for (int i15 = 0; i15 < length; i15++) {
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i15);
                                    jSONObjectOptJSONObject3.getClass();
                                    arrayList5.add(r0.f.y(jSONObjectOptJSONObject3));
                                }
                            }
                            uVar.f10135a = jSONObjectOptJSONObject2.optInt("isPrivate") == 1;
                            vVar.f10136a = jSONObjectOptJSONObject2.optInt("countApps");
                        }
                    }
                    y7.e eVar2 = i0.f12407a;
                    s7.c cVar2 = w7.n.f13548a;
                    c5.c cVar3 = new c5.c((Object) wVar2, (Object) arrayList5, (Object) uVar, (Object) vVar, (w6.c) null, 3);
                    this.f921b = 1;
                    if (y.z(cVar3, cVar2, this) != aVar) {
                        return wVar;
                    }
                }
                return aVar;
            default:
                w wVar3 = (w) obj2;
                int i16 = this.f921b;
                if (i16 != 0) {
                    if (i16 == 1 || i16 == 2) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var2 = new w4(((b0) this.e).f1657a, 4, false);
                HashMap map2 = new HashMap();
                map2.put("page[limit]", String.valueOf(i12));
                map2.put("page[offset]", String.valueOf(i11));
                p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443".concat("/eapi/v2/my-wishlist"), ShareTarget.METHOD_GET, map2);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, "/eapi/v2/my-wishlist");
                w6.c cVar4 = null;
                if (p0VarM2.b()) {
                    y7.e eVar3 = i0.f12407a;
                    s7.c cVar5 = w7.n.f13548a;
                    g0 g0Var2 = new g0(wVar3, null, 1);
                    this.f921b = 2;
                    if (y.z(g0Var2, cVar5, this) != aVar) {
                        return wVar;
                    }
                } else {
                    ArrayList arrayList6 = new ArrayList();
                    v vVar2 = new v();
                    JSONObject jSONObject = p0VarM2.f8699d;
                    if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("apps");
                        if (jSONArrayOptJSONArray2 != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            for (int i17 = 0; i17 < length2; i17++) {
                                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i17);
                                jSONObjectOptJSONObject4.getClass();
                                arrayList6.add(r0.f.y(jSONObjectOptJSONObject4));
                            }
                        }
                        vVar2.f10136a = jSONObjectOptJSONObject.optInt("countApps");
                    }
                    y7.e eVar4 = i0.f12407a;
                    s7.c cVar6 = w7.n.f13548a;
                    c5.m mVar = new c5.m(wVar3, arrayList6, vVar2, cVar4, 1);
                    this.f921b = 1;
                    if (y.z(mVar, cVar6, this) != aVar) {
                        return wVar;
                    }
                }
                return aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, int i10, int i11, w6.c cVar) {
        super(2, cVar);
        this.f920a = 0;
        this.f = str;
        this.f922c = i10;
        this.f923d = i11;
    }
}

package c5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.RepliesActivity;
import e5.x0;
import h5.p0;
import java.util.ArrayList;
import java.util.HashMap;
import l4.u7;
import l4.y7;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1673a;

    /* renamed from: b, reason: collision with root package name */
    public int f1674b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1675c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f1676d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(y7 y7Var, Context context, long j10, int i10, w6.c cVar) {
        super(2, cVar);
        this.f1673a = 5;
        this.f1675c = y7Var;
        this.e = context;
        this.f1676d = j10;
        this.f1674b = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1673a) {
            case 0:
                return new e0((w4) this.f1675c, this.f1676d, (x0) this.e, cVar, 0);
            case 1:
                return new e0((w4) this.f1675c, this.f1676d, (g5.u) this.e, cVar, 1);
            case 2:
                return new e0((b0) this.f1675c, this.f1676d, (g5.t) this.e, cVar, 2);
            case 3:
                return new e0((b0) this.f1675c, this.f1676d, (g5.u) this.e, cVar, 3);
            case 4:
                return new e0((y7) this.f1675c, (RepliesActivity) this.e, this.f1676d, cVar);
            default:
                return new e0((y7) this.f1675c, (Context) this.e, this.f1676d, this.f1674b, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1673a) {
        }
        return ((e0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        String str2;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Object objZ;
        JSONObject jSONObject3;
        int i10 = this.f1673a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        long j10 = this.f1676d;
        Object obj2 = this.e;
        Object obj3 = this.f1675c;
        switch (i10) {
            case 0:
                x0 x0Var = (x0) obj2;
                int i11 = this.f1674b;
                if (i11 != 0) {
                    if (i11 == 1 || i11 == 2 || i11 == 3) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var = new w4(((w4) obj3).f1555a, 4, false);
                String strD = r1.i.d("/eapi/app/", "/recommended/add", j10);
                p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat(strD), ShareTarget.METHOD_POST, null);
                p0VarM.f8699d = w4Var.k(p0VarM, strD);
                if (p0VarM.b() || (str = p0VarM.f8696a) == null || str.length() == 0) {
                    y7.e eVar = r7.i0.f12407a;
                    s7.c cVar = w7.n.f13548a;
                    d0 d0Var = new d0(x0Var, null, 2);
                    this.f1674b = 3;
                    if (r7.y.z(d0Var, cVar, this) != aVar) {
                        return wVar;
                    }
                } else {
                    String str3 = p0VarM.f8696a;
                    str3.getClass();
                    if (new JSONObject(str3).optInt("success") == 1) {
                        y7.e eVar2 = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        d0 d0Var2 = new d0(x0Var, null, 0);
                        this.f1674b = 1;
                        if (r7.y.z(d0Var2, cVar2, this) != aVar) {
                            return wVar;
                        }
                    } else {
                        y7.e eVar3 = r7.i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        d0 d0Var3 = new d0(x0Var, null, 1);
                        this.f1674b = 2;
                        if (r7.y.z(d0Var3, cVar3, this) != aVar) {
                            return wVar;
                        }
                    }
                }
                return aVar;
            case 1:
                g5.u uVar = (g5.u) obj2;
                int i12 = this.f1674b;
                if (i12 != 0) {
                    if (i12 == 1 || i12 == 2 || i12 == 3) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var2 = new w4(((w4) obj3).f1555a, 4, false);
                String strD2 = r1.i.d("/eapi/app/", "/recommended/delete", j10);
                p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443".concat(strD2), ShareTarget.METHOD_POST, null);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, strD2);
                if (p0VarM2.b() || (str2 = p0VarM2.f8696a) == null || str2.length() == 0) {
                    y7.e eVar4 = r7.i0.f12407a;
                    s7.c cVar4 = w7.n.f13548a;
                    f0 f0Var = new f0(uVar, null, 2);
                    this.f1674b = 3;
                    if (r7.y.z(f0Var, cVar4, this) != aVar) {
                        return wVar;
                    }
                } else {
                    String str4 = p0VarM2.f8696a;
                    str4.getClass();
                    if (new JSONObject(str4).optInt("success") == 1) {
                        y7.e eVar5 = r7.i0.f12407a;
                        s7.c cVar5 = w7.n.f13548a;
                        f0 f0Var2 = new f0(uVar, null, 0);
                        this.f1674b = 1;
                        if (r7.y.z(f0Var2, cVar5, this) != aVar) {
                            return wVar;
                        }
                    } else {
                        y7.e eVar6 = r7.i0.f12407a;
                        s7.c cVar6 = w7.n.f13548a;
                        f0 f0Var3 = new f0(uVar, null, 1);
                        this.f1674b = 2;
                        if (r7.y.z(f0Var3, cVar6, this) != aVar) {
                            return wVar;
                        }
                    }
                }
                return aVar;
            case 2:
                g5.t tVar = (g5.t) obj2;
                int i13 = this.f1674b;
                if (i13 != 0) {
                    if (i13 == 1 || i13 == 2 || i13 == 3) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var3 = new w4(((b0) obj3).f1657a, 4, false);
                p0 p0VarM3 = w4Var3.m(r1.i.d("https://www.uptodown.app:443/eapi/app/", "/wishlist/add", j10), ShareTarget.METHOD_POST, null);
                p0VarM3.f8699d = w4Var3.k(p0VarM3, "/eapi/app/appID/wishlist/add");
                if (p0VarM3.b() || (jSONObject = p0VarM3.f8699d) == null) {
                    y7.e eVar7 = r7.i0.f12407a;
                    s7.c cVar7 = w7.n.f13548a;
                    n0 n0Var = new n0(tVar, null, 2);
                    this.f1674b = 3;
                    if (r7.y.z(n0Var, cVar7, this) != aVar) {
                        return wVar;
                    }
                } else if (jSONObject.optInt("success") == 1) {
                    y7.e eVar8 = r7.i0.f12407a;
                    s7.c cVar8 = w7.n.f13548a;
                    n0 n0Var2 = new n0(tVar, null, 0);
                    this.f1674b = 1;
                    if (r7.y.z(n0Var2, cVar8, this) != aVar) {
                        return wVar;
                    }
                } else {
                    y7.e eVar9 = r7.i0.f12407a;
                    s7.c cVar9 = w7.n.f13548a;
                    n0 n0Var3 = new n0(tVar, null, 1);
                    this.f1674b = 2;
                    if (r7.y.z(n0Var3, cVar9, this) != aVar) {
                        return wVar;
                    }
                }
                return aVar;
            case 3:
                g5.u uVar2 = (g5.u) obj2;
                int i14 = this.f1674b;
                if (i14 != 0) {
                    if (i14 == 1 || i14 == 2 || i14 == 3) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                w4 w4Var4 = new w4(((b0) obj3).f1657a, 4, false);
                p0 p0VarM4 = w4Var4.m(r1.i.d("https://www.uptodown.app:443/eapi/app/", "/wishlist/delete", j10), ShareTarget.METHOD_POST, null);
                p0VarM4.f8699d = w4Var4.k(p0VarM4, "/eapi/app/appID/wishlist/delete");
                if (p0VarM4.b() || (jSONObject2 = p0VarM4.f8699d) == null) {
                    y7.e eVar10 = r7.i0.f12407a;
                    s7.c cVar10 = w7.n.f13548a;
                    f0 f0Var4 = new f0(uVar2, null, 5);
                    this.f1674b = 3;
                    if (r7.y.z(f0Var4, cVar10, this) != aVar) {
                        return wVar;
                    }
                } else if (jSONObject2.optInt("success") == 1) {
                    y7.e eVar11 = r7.i0.f12407a;
                    s7.c cVar11 = w7.n.f13548a;
                    f0 f0Var5 = new f0(uVar2, null, 3);
                    this.f1674b = 1;
                    if (r7.y.z(f0Var5, cVar11, this) != aVar) {
                        return wVar;
                    }
                } else {
                    y7.e eVar12 = r7.i0.f12407a;
                    s7.c cVar12 = w7.n.f13548a;
                    f0 f0Var6 = new f0(uVar2, null, 4);
                    this.f1674b = 2;
                    if (r7.y.z(f0Var6, cVar12, this) != aVar) {
                        return wVar;
                    }
                }
                return aVar;
            case 4:
                y7 y7Var = (y7) obj3;
                int i15 = this.f1674b;
                if (i15 == 0) {
                    s6.a.e(obj);
                    y7Var.f11045s = false;
                    this.f1674b = 1;
                    y7.e eVar13 = r7.i0.f12407a;
                    objZ = r7.y.z(new e0(y7Var, (RepliesActivity) obj2, this.f1676d, 0, (w6.c) null), y7.d.f14116a, this);
                    if (objZ == aVar) {
                        return aVar;
                    }
                } else {
                    if (i15 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                    objZ = obj;
                }
                u7.m0 m0Var = y7Var.f11031a;
                v5.l lVar = new v5.l(new u7((ArrayList) objZ, false));
                m0Var.getClass();
                m0Var.g(null, lVar);
                return wVar;
            default:
                s6.a.e(obj);
                y7 y7Var2 = (y7) obj3;
                y7Var2.f11044r = true;
                u7.m0 m0Var2 = y7Var2.f11031a;
                m0Var2.getClass();
                m0Var2.g(null, v5.j.f13166a);
                ArrayList arrayList = new ArrayList();
                w4 w4Var5 = new w4((Context) obj2, 4, false);
                int i16 = this.f1674b;
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(10));
                map.put("page[offset]", String.valueOf(i16));
                p0 p0VarM5 = w4Var5.m(r1.i.d("https://www.uptodown.app:443/eapi/comments/", "/answers", j10), ShareTarget.METHOD_GET, map);
                p0VarM5.f8699d = w4Var5.k(p0VarM5, "/eapi/comments/idReview/answers");
                if (p0VarM5.b() || (jSONObject3 = p0VarM5.f8699d) == null) {
                    y7Var2.f11045s = true;
                } else {
                    JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONObject3.optInt("success") == 1 && jSONArrayOptJSONArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        try {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i17 = 0; i17 < length; i17++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i17);
                                jSONObjectOptJSONObject.getClass();
                                arrayList2.add(c1.d0.o(jSONObjectOptJSONObject));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        arrayList.addAll(arrayList2);
                        if (jSONArrayOptJSONArray.length() == 0) {
                            y7Var2.f11045s = true;
                        }
                    }
                }
                y7Var2.f11044r = false;
                return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(Object obj, long j10, g5.v vVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1673a = i10;
        this.f1675c = obj;
        this.f1676d = j10;
        this.e = vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(y7 y7Var, RepliesActivity repliesActivity, long j10, w6.c cVar) {
        super(2, cVar);
        this.f1673a = 4;
        this.f1675c = y7Var;
        this.e = repliesActivity;
        this.f1676d = j10;
    }
}

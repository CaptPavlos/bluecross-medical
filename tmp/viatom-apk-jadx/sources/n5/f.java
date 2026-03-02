package n5;

import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import g7.p;
import h5.k;
import h5.p0;
import java.util.ArrayList;
import l4.p2;
import org.json.JSONArray;
import org.json.JSONObject;
import r7.i0;
import r7.w;
import r7.y;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11538a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f11539b;

    /* renamed from: c, reason: collision with root package name */
    public int f11540c;

    /* renamed from: d, reason: collision with root package name */
    public int f11541d;
    public final /* synthetic */ w4 e;
    public final /* synthetic */ p2 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i10, w4 w4Var, p2 p2Var, w6.c cVar) {
        super(2, cVar);
        this.f11538a = i10;
        this.e = w4Var;
        this.f = p2Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11538a) {
            case 0:
                return new f(0, this.e, this.f, cVar);
            default:
                return new f(1, this.e, this.f, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11538a) {
        }
        return ((f) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        int i10;
        JSONObject jSONObject;
        ArrayList arrayList2;
        int i11;
        int i12 = this.f11538a;
        x6.a aVar = x6.a.f13718a;
        w4 w4Var = this.e;
        p2 p2Var = this.f;
        switch (i12) {
            case 0:
                k kVar = (k) p2Var.f10715b;
                int i13 = this.f11541d;
                if (i13 == 0) {
                    s6.a.e(obj);
                    p0 p0VarH = w4Var.h(kVar.f8632a);
                    arrayList = new ArrayList();
                    if (p0VarH.b() || (jSONObject = p0VarH.f8699d) == null || jSONObject.optInt("success") != 1) {
                        i10 = 0;
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONArrayOptJSONArray != null) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i14 = 0; i14 < length; i14++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i14);
                                k kVar2 = new k(0, (String) null, 7);
                                jSONObjectOptJSONObject.getClass();
                                kVar2.a(jSONObjectOptJSONObject, kVar.f8632a);
                                arrayList.add(kVar2);
                            }
                            if (!arrayList.isEmpty()) {
                                y7.e eVar = i0.f12407a;
                                s7.c cVar = n.f13548a;
                                e eVar2 = new e(p2Var, arrayList, null, 0);
                                this.f11539b = arrayList;
                                this.f11540c = 1;
                                this.f11541d = 1;
                                if (y.z(eVar2, cVar, this) == aVar) {
                                    return aVar;
                                }
                            }
                        }
                        i10 = 1;
                    }
                } else {
                    if (i13 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i10 = this.f11540c;
                    arrayList = this.f11539b;
                    s6.a.e(obj);
                }
                return new b(arrayList, i10 != 0);
            default:
                int i15 = this.f11541d;
                if (i15 == 0) {
                    s6.a.e(obj);
                    p0 p0VarJ = w4Var.j(((k) p2Var.f10715b).f8632a);
                    if (p0VarJ.b() || p0VarJ.f8699d == null) {
                        arrayList2 = new ArrayList();
                        i11 = 0;
                    } else {
                        arrayList2 = w4.I(p0VarJ);
                        if (!arrayList2.isEmpty()) {
                            y7.e eVar3 = i0.f12407a;
                            s7.c cVar2 = n.f13548a;
                            e eVar4 = new e(p2Var, arrayList2, null, 1);
                            this.f11539b = arrayList2;
                            this.f11540c = 1;
                            this.f11541d = 1;
                            if (y.z(eVar4, cVar2, this) == aVar) {
                                return aVar;
                            }
                        }
                        i11 = 1;
                    }
                } else {
                    if (i15 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    i11 = this.f11540c;
                    arrayList2 = this.f11539b;
                    s6.a.e(obj);
                }
                return new c(arrayList2, i11 != 0);
        }
    }
}

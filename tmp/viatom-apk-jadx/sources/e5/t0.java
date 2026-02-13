package e5;

import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4 f7863b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f7864c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c1 f7865d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(w4 w4Var, long j10, c1 c1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7862a = i10;
        this.f7863b = w4Var;
        this.f7864c = j10;
        this.f7865d = c1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7862a) {
            case 0:
                return new t0(this.f7863b, this.f7864c, this.f7865d, cVar, 0);
            default:
                return new t0(this.f7863b, this.f7864c, this.f7865d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7862a) {
            case 0:
                t0 t0Var = (t0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                t0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                t0 t0Var2 = (t0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                t0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        String str;
        JSONArray jSONArrayOptJSONArray2;
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        JSONArray jSONArrayOptJSONArray3;
        switch (this.f7862a) {
            case 0:
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                String strH = a3.a.h(this.f7864c, "https://www.uptodown.app:443/eapi/floating-categories/app/");
                w4 w4Var = this.f7863b;
                h5.p0 p0VarM = w4Var.m(strH, ShareTarget.METHOD_GET, null);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/floating-categories/app");
                if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null && (jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                    if (jSONArrayOptJSONArray.length() <= 2) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            h5.x0 x0Var = new h5.x0(null, null, 7);
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                            if (jSONObjectOptJSONObject3 != null) {
                                h5.k kVar = new h5.k(0, (String) null, 7);
                                kVar.b(jSONObjectOptJSONObject3);
                                kVar.f8635d = true;
                                x0Var.f8788a = kVar;
                            }
                            JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject2.optJSONArray("apps");
                            if (jSONArrayOptJSONArray4 != null) {
                                int length2 = jSONArrayOptJSONArray4.length();
                                for (int i11 = 0; i11 < length2; i11++) {
                                    h5.h hVar = new h5.h();
                                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray4.optJSONObject(i11);
                                    jSONObjectOptJSONObject4.getClass();
                                    hVar.a(null, jSONObjectOptJSONObject4);
                                    x0Var.f8789b.add(hVar);
                                }
                            }
                            arrayListA.add(x0Var);
                        }
                    } else {
                        int length3 = jSONArrayOptJSONArray.length();
                        for (int i12 = 0; i12 < length3; i12++) {
                            JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i12);
                            h5.k kVar2 = new h5.k(0, (String) null, 7);
                            kVar2.f8635d = true;
                            jSONObjectOptJSONObject5.getClass();
                            kVar2.b(jSONObjectOptJSONObject5);
                            arrayListA.add(kVar2);
                        }
                    }
                }
                if (!arrayListA.isEmpty()) {
                    Object objC0 = t6.l.c0(arrayListA);
                    if (objC0 instanceof h5.k) {
                        arrayList = arrayListA;
                        arrayListA = null;
                    } else if (objC0 instanceof h5.x0) {
                        arrayList = null;
                    } else {
                        arrayListA = null;
                        arrayList = null;
                    }
                    u7.m0 m0Var = this.f7865d.f7699i;
                    v5.l lVar = new v5.l(new l0(arrayListA, arrayList));
                    m0Var.getClass();
                    m0Var.g(null, lVar);
                }
                break;
            default:
                ArrayList arrayListA2 = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                w4 w4Var2 = this.f7863b;
                long j10 = this.f7864c;
                h5.p0 p0VarB = w4Var2.B(j10);
                if (!p0VarB.b() && (jSONObject2 = p0VarB.f8699d) != null && jSONObject2.optInt("success") == 1 && (jSONObjectOptJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null && (jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("videos")) != null) {
                    int length4 = jSONArrayOptJSONArray3.length();
                    for (int i13 = 0; i13 < length4; i13++) {
                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray3.optJSONObject(i13);
                        jSONObjectOptJSONObject6.getClass();
                        h5.l1 l1Var = new h5.l1();
                        if (!jSONObjectOptJSONObject6.isNull("youtubeID")) {
                            l1Var.f8650a = jSONObjectOptJSONObject6.optString("youtubeID");
                        }
                        if (!jSONObjectOptJSONObject6.isNull("image")) {
                            l1Var.f8651b = jSONObjectOptJSONObject6.optString("image");
                        }
                        arrayListA2.add(l1Var);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                h5.p0 p0VarT = w4Var2.t(j10);
                if (!p0VarT.b() && (str = p0VarT.f8696a) != null && str.length() != 0) {
                    String str2 = p0VarT.f8696a;
                    str2.getClass();
                    JSONObject jSONObject3 = new JSONObject(str2);
                    if (jSONObject3.optInt("success") == 1 && (jSONArrayOptJSONArray2 = jSONObject3.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        int length5 = jSONArrayOptJSONArray2.length();
                        for (int i14 = 0; i14 < length5; i14++) {
                            JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray2.optJSONObject(i14);
                            jSONObjectOptJSONObject7.getClass();
                            h5.u0 u0Var = new h5.u0();
                            if (!jSONObjectOptJSONObject7.isNull("screenshotURL")) {
                                u0Var.f8754a = jSONObjectOptJSONObject7.optString("screenshotURL");
                            }
                            if (!jSONObjectOptJSONObject7.isNull("isVertical")) {
                                u0Var.f8757d = jSONObjectOptJSONObject7.optInt("isVertical");
                            }
                            if (!jSONObjectOptJSONObject7.isNull("featured")) {
                                u0Var.f8756c = jSONObjectOptJSONObject7.optInt("featured");
                            }
                            if (u0Var.f8756c == 0) {
                                arrayList2.add(u0Var);
                            }
                            t6.q.W(arrayList2, new com.google.android.material.button.a(new u0(0), 1));
                        }
                    }
                }
                u7.m0 m0Var2 = this.f7865d.g;
                v5.l lVar2 = new v5.l(new k0(arrayList2, arrayListA2));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

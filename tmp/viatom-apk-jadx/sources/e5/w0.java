package e5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7892a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f7893b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7894c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7895d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w0(boolean z9, Object obj, Object obj2, Object obj3, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7892a = i10;
        this.f7893b = z9;
        this.f7894c = obj;
        this.f7895d = obj2;
        this.e = obj3;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7892a) {
            case 0:
                return new w0(this.f7893b, (h5.h) this.f7894c, (w4) this.f7895d, (c1) this.e, cVar, 0);
            default:
                return new w0(this.f7893b, (ArrayList) this.f7894c, (Context) this.f7895d, (kotlin.jvm.internal.u) this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7892a) {
            case 0:
                w0 w0Var = (w0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                w0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                w0 w0Var2 = (w0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                w0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        switch (this.f7892a) {
            case 0:
                c1 c1Var = (c1) this.e;
                w4 w4Var = (w4) this.f7895d;
                h5.h hVar = (h5.h) this.f7894c;
                s6.a.e(obj);
                int i10 = 0;
                if (this.f7893b) {
                    h5.d dVar = new h5.d();
                    dVar.f8493d = hVar;
                    h5.p0 p0VarM = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/app/", "/alternatives", hVar.f8566a), ShareTarget.METHOD_GET, null);
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/app/appID/alternatives");
                    if (!p0VarM.b() && (jSONObject2 = p0VarM.f8699d) != null && jSONObject2.optInt("success") == 1 && (jSONObjectOptJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        if (!jSONObjectOptJSONObject.isNull(CampaignEx.JSON_KEY_TITLE)) {
                            dVar.f8490a = jSONObjectOptJSONObject.optString(CampaignEx.JSON_KEY_TITLE);
                        }
                        if (!jSONObjectOptJSONObject.isNull("description")) {
                            dVar.f8491b = jSONObjectOptJSONObject.optString("description");
                        }
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("apps");
                        if (jSONArrayOptJSONArray != null) {
                            ArrayList arrayList = new ArrayList();
                            int length = jSONArrayOptJSONArray.length();
                            while (i10 < length) {
                                h5.h hVar2 = new h5.h();
                                JSONObject jSONObject3 = jSONArrayOptJSONArray.getJSONObject(i10);
                                jSONObject3.getClass();
                                hVar2.a(null, jSONObject3);
                                arrayList.add(hVar2);
                                i10++;
                            }
                            dVar.f8492c = arrayList;
                        }
                        ArrayList arrayList2 = dVar.f8492c;
                        if (arrayList2 != null && !arrayList2.isEmpty()) {
                            u7.m0 m0Var = c1Var.f7697c;
                            m0Var.getClass();
                            m0Var.g(null, dVar);
                        }
                    }
                } else {
                    ArrayList arrayList3 = new ArrayList();
                    long j10 = hVar.f8566a;
                    HashMap map = new HashMap();
                    map.put("page[limit]", String.valueOf(20));
                    map.put("page[offset]", String.valueOf(0));
                    h5.p0 p0VarM2 = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/", "/similar", j10), ShareTarget.METHOD_GET, map);
                    p0VarM2.f8699d = w4Var.k(p0VarM2, "/eapi/appID/similar");
                    if (!p0VarM2.b() && (jSONObject = p0VarM2.f8699d) != null) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject.optInt("success", 0) == 1 && jSONArrayOptJSONArray2 != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            while (i10 < length2) {
                                h5.h hVar3 = new h5.h();
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i10);
                                jSONObjectOptJSONObject2.getClass();
                                hVar3.a(null, jSONObjectOptJSONObject2);
                                arrayList3.add(hVar3);
                                i10++;
                            }
                            if (!arrayList3.isEmpty()) {
                                u7.m0 m0Var2 = c1Var.f7695a;
                                m0Var2.getClass();
                                m0Var2.g(null, arrayList3);
                            }
                        }
                    }
                }
                break;
            default:
                s6.a.e(obj);
                if (this.f7893b) {
                    Iterator it = ((ArrayList) this.f7894c).iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        h5.q qVarA = ((h5.y0) next).a((Context) this.f7895d);
                        if (qVarA == null || !qVarA.c()) {
                            ((kotlin.jvm.internal.u) this.e).f10135a = false;
                        }
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }
}

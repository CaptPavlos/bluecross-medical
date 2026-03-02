package l4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.MoreInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10422a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f10423b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10424c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3(MoreInfo moreInfo, kotlin.jvm.internal.v vVar, w6.c cVar) {
        super(2, cVar);
        this.f10424c = moreInfo;
        this.f10423b = vVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10422a) {
            case 0:
                return new g3(this.f10424c, this.f10423b, cVar);
            default:
                return new g3(this.f10423b, this.f10424c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10422a) {
            case 0:
                g3 g3Var = (g3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                g3Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                g3 g3Var2 = (g3) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                g3Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        int size;
        int i10 = this.f10422a;
        s6.w wVar = s6.w.f12711a;
        MoreInfo moreInfo = this.f10424c;
        kotlin.jvm.internal.v vVar = this.f10423b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                Context applicationContext = moreInfo.getApplicationContext();
                applicationContext.getClass();
                c1.w4 w4Var = new c1.w4(applicationContext, 4, false);
                h5.h hVar = moreInfo.K;
                hVar.getClass();
                h5.p0 p0VarM = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/apps/", "/permissions", hVar.f8566a), ShareTarget.METHOD_GET, null);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/apps/appId/permissions");
                if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null) {
                    if (!jSONObject.isNull("success")) {
                        vVar.f10136a = jSONObject.optInt("success");
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (vVar.f10136a == 1 && jSONObjectOptJSONObject != null) {
                        moreInfo.M = new ArrayList();
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions_concern");
                        if (jSONArrayOptJSONArray != null) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i11 = 0; i11 < length; i11++) {
                                h5.e0 e0Var = new h5.e0();
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i11);
                                jSONObjectOptJSONObject2.getClass();
                                if (!jSONObjectOptJSONObject2.isNull("permission")) {
                                    e0Var.f8510a = jSONObjectOptJSONObject2.optString("permission");
                                }
                                if (!jSONObjectOptJSONObject2.isNull("description")) {
                                    jSONObjectOptJSONObject2.optString("description");
                                }
                                ArrayList arrayList = moreInfo.M;
                                arrayList.getClass();
                                arrayList.add(e0Var);
                            }
                        }
                        moreInfo.N = new ArrayList();
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("permissions");
                        if (jSONArrayOptJSONArray2 != null) {
                            int length2 = jSONArrayOptJSONArray2.length();
                            for (int i12 = 0; i12 < length2; i12++) {
                                h5.e0 e0Var2 = new h5.e0();
                                JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i12);
                                jSONObjectOptJSONObject3.getClass();
                                if (!jSONObjectOptJSONObject3.isNull("permission")) {
                                    e0Var2.f8510a = jSONObjectOptJSONObject3.optString("permission");
                                }
                                if (!jSONObjectOptJSONObject3.isNull("description")) {
                                    jSONObjectOptJSONObject3.optString("description");
                                }
                                ArrayList arrayList2 = moreInfo.N;
                                arrayList2.getClass();
                                arrayList2.add(e0Var2);
                            }
                            break;
                        }
                    }
                }
                break;
            default:
                s6.a.e(obj);
                if (vVar.f10136a == 1) {
                    int i13 = MoreInfo.P;
                    moreInfo.q0().f7438w.setVisibility(0);
                    ArrayList arrayList3 = moreInfo.M;
                    if (arrayList3 == null || arrayList3.isEmpty()) {
                        moreInfo.q0().f7438w.setVisibility(8);
                        size = 0;
                    } else {
                        MoreInfo.p0(moreInfo, moreInfo.M, moreInfo.q0().f);
                        ArrayList arrayList4 = moreInfo.M;
                        arrayList4.getClass();
                        size = arrayList4.size();
                    }
                    ArrayList arrayList5 = moreInfo.N;
                    if (arrayList5 != null && !arrayList5.isEmpty()) {
                        MoreInfo.p0(moreInfo, moreInfo.N, moreInfo.q0().h);
                        ArrayList arrayList6 = moreInfo.N;
                        arrayList6.getClass();
                        size += arrayList6.size();
                    }
                    h5.h hVar2 = moreInfo.K;
                    if (hVar2 != null && hVar2.y == 0) {
                        moreInfo.q0().f7432s0.setText(String.valueOf(size));
                    }
                } else {
                    int i14 = MoreInfo.P;
                    moreInfo.q0().f7438w.setVisibility(8);
                }
                moreInfo.q0().f7414j.setVisibility(8);
                moreInfo.q0().C.setVisibility(0);
                break;
        }
        return wVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3(kotlin.jvm.internal.v vVar, MoreInfo moreInfo, w6.c cVar) {
        super(2, cVar);
        this.f10423b = vVar;
        this.f10424c = moreInfo;
    }
}

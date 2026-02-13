package e5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.provider.Settings;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModel;
import c1.w4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.HashMap;
import l4.v7;
import l4.y7;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7885a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewModel f7886b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7887c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7888d;
    public final /* synthetic */ long e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(c1 c1Var, Context context, w4 w4Var, long j10, w6.c cVar) {
        super(2, cVar);
        this.f7885a = 1;
        this.f7886b = c1Var;
        this.f7887c = context;
        this.f7888d = w4Var;
        this.e = j10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7885a) {
            case 0:
                return new v0(this.f7887c, (w4) this.f7888d, this.e, (c1) this.f7886b, cVar, 0);
            case 1:
                return new v0((c1) this.f7886b, this.f7887c, (w4) this.f7888d, this.e, cVar);
            default:
                return new v0(this.f7887c, (String) this.f7888d, this.e, (y7) this.f7886b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7885a) {
            case 0:
                v0 v0Var = (v0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                v0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                v0 v0Var2 = (v0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                v0Var2.invokeSuspend(wVar3);
                return wVar3;
            default:
                v0 v0Var3 = (v0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                v0Var3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        h5.t0 t0Var;
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        String str;
        int i10;
        String strC;
        JSONObject jSONObject4;
        switch (this.f7885a) {
            case 0:
                w4 w4Var = (w4) this.f7888d;
                c1 c1Var = (c1) this.f7886b;
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                int i11 = o7.u.Z(this.f7887c.getString(R.string.screen_type), "phone", true) ? 5 : 6;
                HashMap map = new HashMap();
                map.put("page[limit]", String.valueOf(i11));
                map.put("page[offset]", String.valueOf(0));
                long j10 = this.e;
                h5.p0 p0VarM = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/apps/", "/comments-with-text", j10), ShareTarget.METHOD_GET, map);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/apps/appId/comments-with-text");
                if (!p0VarM.b() && (jSONObject2 = p0VarM.f8699d) != null) {
                    int iOptInt = jSONObject2.optInt("success");
                    JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (iOptInt == 1 && jSONArrayOptJSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        try {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i12 = 0; i12 < length; i12++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i12);
                                jSONObjectOptJSONObject2.getClass();
                                arrayList.add(c1.d0.p(jSONObjectOptJSONObject2));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        arrayListA.addAll(arrayList);
                    }
                }
                h5.p0 p0VarM2 = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/app/", "/my-comment", j10), ShareTarget.METHOD_GET, null);
                p0VarM2.f8699d = w4Var.k(p0VarM2, "/eapi/app/appID/my-comment");
                if (!p0VarM2.b() && (jSONObject = p0VarM2.f8699d) != null) {
                    if (jSONObject.optInt("success") == 1 && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        t0Var = new h5.t0();
                        if (!jSONObjectOptJSONObject.isNull(CampaignEx.JSON_KEY_STAR)) {
                            t0Var.g = jSONObjectOptJSONObject.optInt(CampaignEx.JSON_KEY_STAR);
                        }
                        if (!jSONObjectOptJSONObject.isNull(MimeTypes.BASE_TYPE_TEXT)) {
                            t0Var.f = jSONObjectOptJSONObject.optString(MimeTypes.BASE_TYPE_TEXT);
                        }
                    }
                    u7.m0 m0Var = c1Var.f7707q;
                    m0Var.getClass();
                    m0Var.g(null, arrayListA);
                    c1Var.f7710u.f(t0Var);
                    u7.m0 m0Var2 = c1Var.f7701k;
                    v5.l lVar = new v5.l(new m0(arrayListA, t0Var));
                    m0Var2.getClass();
                    m0Var2.g(null, lVar);
                    break;
                } else if (p0VarM2.b()) {
                    int i13 = p0VarM2.f8697b;
                }
                t0Var = null;
                u7.m0 m0Var3 = c1Var.f7707q;
                m0Var3.getClass();
                m0Var3.g(null, arrayListA);
                c1Var.f7710u.f(t0Var);
                u7.m0 m0Var22 = c1Var.f7701k;
                v5.l lVar2 = new v5.l(new m0(arrayListA, t0Var));
                m0Var22.getClass();
                m0Var22.g(null, lVar2);
                break;
            case 1:
                s6.a.e(obj);
                c1 c1Var2 = (c1) this.f7886b;
                u7.m0 m0Var4 = c1Var2.y;
                m0Var4.getClass();
                m0Var4.g(null, v5.j.f13166a);
                ArrayList arrayList2 = new ArrayList();
                if (h5.c1.g(this.f7887c)) {
                    w4 w4Var2 = (w4) this.f7888d;
                    Context context = w4Var2.f1555a;
                    context.getClass();
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    h5.e1 e1VarH = h5.c1.h(context);
                    if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
                        String str2 = e1VarH.f8512a;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
                        if (sharedPreferences.contains("device_rooted")) {
                            sharedPreferences.getBoolean("device_rooted", false);
                        }
                    } catch (Exception unused) {
                    }
                    String str3 = "/eapi/app/" + this.e + "/my-devices/" + string;
                    h5.p0 p0VarM3 = w4Var2.m("https://www.uptodown.app:443".concat(str3), ShareTarget.METHOD_GET, null);
                    p0VarM3.f8699d = w4Var2.k(p0VarM3, str3);
                    if (p0VarM3.b() || (jSONObject3 = p0VarM3.f8699d) == null) {
                        arrayList2 = new ArrayList();
                    } else {
                        JSONArray jSONArrayOptJSONArray2 = jSONObject3.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject3.optInt("success") == 1 && jSONArrayOptJSONArray2 != null) {
                            ArrayList arrayList3 = new ArrayList();
                            try {
                                int length2 = jSONArrayOptJSONArray2.length();
                                for (int i14 = 0; i14 < length2; i14++) {
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i14);
                                    jSONObjectOptJSONObject3.getClass();
                                    arrayList3.add(z1.t1.f(jSONObjectOptJSONObject3));
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            arrayList2 = arrayList3;
                        }
                    }
                }
                if (arrayList2.size() > 1) {
                    u7.m0 m0Var5 = c1Var2.U;
                    Boolean bool = Boolean.TRUE;
                    m0Var5.getClass();
                    m0Var5.g(null, bool);
                    if (arrayList2.size() > 1) {
                        t6.q.W(arrayList2, new a9.i(3));
                    }
                    v5.l lVar3 = new v5.l(arrayList2);
                    m0Var4.getClass();
                    m0Var4.g(null, lVar3);
                }
                break;
            default:
                s6.a.e(obj);
                String str4 = (String) this.f7888d;
                String strValueOf = String.valueOf(System.currentTimeMillis());
                Context context2 = this.f7887c;
                c1.d0.u(context2, str4, strValueOf);
                w4 w4Var3 = new w4(context2, 4, false);
                HashMap map2 = new HashMap();
                map2.put(MimeTypes.BASE_TYPE_TEXT, str4);
                int iOptInt2 = 0;
                try {
                    PackageManager packageManager = context2.getPackageManager();
                    packageManager.getClass();
                    String packageName = context2.getPackageName();
                    packageName.getClass();
                    str = " " + l5.a.f(packageManager, packageName, 0).versionName;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    str = "";
                }
                map2.put("uagent", "uptodownandroid".concat(str));
                h5.p0 p0VarM4 = w4Var3.m(a3.a.l(new StringBuilder("https://www.uptodown.app:443/eapi/comments/"), this.e, "/answers"), ShareTarget.METHOD_POST, map2);
                p0VarM4.f8699d = w4Var3.k(p0VarM4, "/eapi/comments/idReply/answers/post");
                if (p0VarM4.b() || (jSONObject4 = p0VarM4.f8699d) == null || (iOptInt2 = jSONObject4.optInt("success")) != 0) {
                    i10 = iOptInt2;
                    strC = null;
                } else {
                    i10 = iOptInt2;
                    strC = h5.p0.c(jSONObject4);
                }
                u7.m0 m0Var6 = ((y7) this.f7886b).g;
                v5.l lVar4 = new v5.l(new v7(i10, str4, p0VarM4.f8697b, strC, this.e));
                m0Var6.getClass();
                m0Var6.g(null, lVar4);
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v0(Context context, Object obj, long j10, ViewModel viewModel, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7885a = i10;
        this.f7887c = context;
        this.f7888d = obj;
        this.e = j10;
        this.f7886b = viewModel;
    }
}

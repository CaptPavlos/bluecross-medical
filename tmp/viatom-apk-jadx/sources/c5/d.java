package c5;

import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.MainActivity;
import h5.p0;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1664a;

    /* renamed from: b, reason: collision with root package name */
    public int f1665b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a3.x f1666c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(a3.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1664a = i10;
        this.f1666c = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1664a) {
            case 0:
                return new d(this.f1666c, cVar, 0);
            default:
                return new d(this.f1666c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1664a) {
        }
        return ((d) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        int i10 = this.f1664a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        int i11 = 1;
        switch (i10) {
            case 0:
                int i12 = this.f1665b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f1665b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new d(this.f1666c, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i13 = this.f1665b;
                int i14 = 2;
                if (i13 == 0) {
                    s6.a.e(obj);
                    a3.x xVar = this.f1666c;
                    w4 w4Var = new w4((MainActivity) xVar.f181b, 4, false);
                    String str2 = (String) xVar.f182c;
                    HashMap map = new HashMap();
                    map.put("downloadURL", str2);
                    p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/app/get-by-download-url"), ShareTarget.METHOD_GET, map);
                    if (p0VarM.b() || (str = p0VarM.f8696a) == null || str.length() == 0) {
                        y7.e eVar2 = r7.i0.f12407a;
                        s7.c cVar = w7.n.f13548a;
                        a6.n nVar = new a6.n(xVar, cVar, i14);
                        this.f1665b = 2;
                        if (r7.y.z(nVar, cVar, this) != aVar) {
                        }
                    } else {
                        String str3 = p0VarM.f8696a;
                        str3.getClass();
                        JSONObject jSONObjectOptJSONObject = new JSONObject(str3).optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObjectOptJSONObject != null) {
                            long jOptLong = jSONObjectOptJSONObject.optLong("appID", -1L);
                            long jOptLong2 = jSONObjectOptJSONObject.optLong("fileID", -1L);
                            String strOptString = jSONObjectOptJSONObject.optString("sha256");
                            strOptString.getClass();
                            cVar = strOptString.length() > 0 ? strOptString : null;
                            long jOptLong3 = jSONObjectOptJSONObject.optLong("versionCode", -1L);
                            boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("deepLink", false);
                            y7.e eVar3 = r7.i0.f12407a;
                            s7.c cVar2 = w7.n.f13548a;
                            e eVar4 = new e(xVar, jOptLong, jOptLong2, cVar, jOptLong3, zOptBoolean, null);
                            this.f1665b = 1;
                            if (r7.y.z(eVar4, cVar2, this) != aVar) {
                            }
                        }
                    }
                    break;
                } else if (i13 != 1 && i13 != 2) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}

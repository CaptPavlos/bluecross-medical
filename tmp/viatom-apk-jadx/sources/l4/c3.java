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
public final class c3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10282a;

    /* renamed from: b, reason: collision with root package name */
    public int f10283b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f10284c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c3(MoreInfo moreInfo, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10282a = i10;
        this.f10284c = moreInfo;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10282a) {
            case 0:
                return new c3(this.f10284c, cVar, 0);
            case 1:
                return new c3(this.f10284c, cVar, 1);
            case 2:
                return new c3(this.f10284c, cVar, 2);
            case 3:
                return new c3(this.f10284c, cVar, 3);
            default:
                return new c3(this.f10284c, cVar, 4);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10282a) {
        }
        return ((c3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        JSONObject jSONObject;
        JSONArray jSONArrayOptJSONArray;
        int i10 = this.f10282a;
        int i11 = 0;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        MoreInfo moreInfo = this.f10284c;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f10283b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    Context applicationContext = moreInfo.getApplicationContext();
                    applicationContext.getClass();
                    c1.w4 w4Var = new c1.w4(applicationContext, 4, false);
                    h5.h hVar = moreInfo.K;
                    hVar.getClass();
                    h5.p0 p0VarM = w4Var.m(r1.i.d("https://www.uptodown.app:443/eapi/v2/app/", "/abis", hVar.f8566a), ShareTarget.METHOD_GET, null);
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/v2/app/appId/abis");
                    if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null) {
                        if (jSONObject.optInt("success") == 1 && (jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA)) != null) {
                            moreInfo.L = new ArrayList();
                            int length = jSONArrayOptJSONArray.length();
                            for (int i13 = 0; i13 < length; i13++) {
                                ArrayList arrayList = moreInfo.L;
                                arrayList.getClass();
                                arrayList.add(jSONArrayOptJSONArray.get(i13).toString());
                            }
                        }
                        y7.e eVar = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        b3 b3Var = new b3(moreInfo, null, 0);
                        this.f10283b = 1;
                        if (r7.y.z(b3Var, cVar2, this) == aVar) {
                            break;
                        }
                    }
                }
                break;
            case 1:
                int i14 = this.f10283b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    this.f10283b = 1;
                    if (MoreInfo.o0(moreInfo, this) == aVar) {
                        break;
                    }
                }
                break;
            case 2:
                int i15 = this.f10283b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    this.f10283b = 1;
                    int i16 = MoreInfo.P;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ = r7.y.z(new c3(moreInfo, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                }
                break;
            case 3:
                int i17 = this.f10283b;
                if (i17 != 0) {
                    if (i17 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    this.f10283b = 1;
                    if (MoreInfo.n0(moreInfo, this) == aVar) {
                        break;
                    }
                }
                break;
            default:
                int i18 = this.f10283b;
                if (i18 != 0) {
                    if (i18 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    h5.h hVar2 = moreInfo.K;
                    hVar2.getClass();
                    String strValueOf = String.valueOf(hVar2.A);
                    h5.h hVar3 = moreInfo.K;
                    hVar3.getClass();
                    w2.r rVar = new w2.r(moreInfo, strValueOf, hVar3.G, new y2.c(moreInfo, 28));
                    this.f10283b = 1;
                    if (rVar.x(this) == aVar) {
                        break;
                    }
                }
                break;
        }
        return aVar;
    }
}

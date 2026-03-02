package l4;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.uptodown.R;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class hb extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10468a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10469b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f10470c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ib f10471d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(Context context, long j10, String str, ib ibVar, w6.c cVar) {
        super(2, cVar);
        this.f10469b = context;
        this.f10470c = j10;
        this.e = str;
        this.f10471d = ibVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10468a) {
            case 0:
                return new hb(this.f10469b, this.f10470c, this.e, this.f10471d, cVar);
            default:
                return new hb(this.f10469b, this.f10470c, this.f10471d, this.e, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10468a) {
            case 0:
                hb hbVar = (hb) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hbVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                hb hbVar2 = (hb) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                hbVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        switch (this.f10468a) {
            case 0:
                u7.m0 m0Var = this.f10471d.f10506d;
                s6.a.e(obj);
                Context context = this.f10469b;
                c1.w4 w4Var = new c1.w4(context, 4, false);
                String strValueOf = String.valueOf(this.f10470c);
                strValueOf.getClass();
                HashMap map = new HashMap();
                String str = this.e;
                map.put(RewardPlus.NAME, str);
                h5.p0 p0VarM = w4Var.m(androidx.constraintlayout.core.widgets.analyzer.a.x("https://www.uptodown.app:443/eapi/user-data/device/", strValueOf, "/update-name"), ShareTarget.METHOD_POST, map);
                JSONObject jSONObjectK = w4Var.k(p0VarM, "/eapi/user-data/device/deviceID/update-name");
                p0VarM.f8699d = jSONObjectK;
                if (jSONObjectK != null) {
                    int iOptInt = jSONObjectK.optInt("success");
                    if (p0VarM.b()) {
                        v5.l lVar = new v5.l(new fb(this.f10470c, h5.p0.c(jSONObjectK), str, iOptInt));
                        m0Var.getClass();
                        m0Var.g(null, lVar);
                    } else {
                        String string = context.getString(R.string.device_rename);
                        string.getClass();
                        v5.l lVar2 = new v5.l(new fb(this.f10470c, string, str, iOptInt));
                        m0Var.getClass();
                        m0Var.g(null, lVar2);
                    }
                }
                break;
            default:
                u7.m0 m0Var2 = this.f10471d.f;
                s6.a.e(obj);
                Context context2 = this.f10469b;
                c1.w4 w4Var2 = new c1.w4(context2, 4, false);
                String strValueOf2 = String.valueOf(this.f10470c);
                strValueOf2.getClass();
                h5.p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443/eapi/user-data/device/" + strValueOf2 + "/unlink", ShareTarget.METHOD_POST, null);
                JSONObject jSONObjectK2 = w4Var2.k(p0VarM2, "/eapi/user-data/device/deviceID/unlink");
                p0VarM2.f8699d = jSONObjectK2;
                if (jSONObjectK2 != null) {
                    int iOptInt2 = jSONObjectK2.optInt("success");
                    boolean zB = p0VarM2.b();
                    String str2 = this.e;
                    if (zB) {
                        v5.l lVar3 = new v5.l(new gb(iOptInt2, h5.p0.c(jSONObjectK2), str2));
                        m0Var2.getClass();
                        m0Var2.g(null, lVar3);
                    } else {
                        String string2 = context2.getString(R.string.unlinked_device);
                        string2.getClass();
                        v5.l lVar4 = new v5.l(new gb(iOptInt2, string2, str2));
                        m0Var2.getClass();
                        m0Var2.g(null, lVar4);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hb(Context context, long j10, ib ibVar, String str, w6.c cVar) {
        super(2, cVar);
        this.f10469b = context;
        this.f10470c = j10;
        this.f10471d = ibVar;
        this.e = str;
    }
}

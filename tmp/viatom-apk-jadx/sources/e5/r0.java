package e5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7841a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f7842b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f7843c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c1 f7844d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(Context context, c1 c1Var, long j10, w6.c cVar) {
        super(2, cVar);
        this.f7841a = 3;
        this.f7842b = context;
        this.f7844d = c1Var;
        this.f7843c = j10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7841a) {
            case 0:
                return new r0(this.f7844d, this.f7842b, this.f7843c, cVar);
            case 1:
                return new r0(1, this.f7843c, this.f7842b, this.f7844d, cVar);
            case 2:
                return new r0(2, this.f7843c, this.f7842b, this.f7844d, cVar);
            default:
                return new r0(this.f7842b, this.f7844d, this.f7843c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7841a) {
            case 0:
                r0 r0Var = (r0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                r0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                r0 r0Var2 = (r0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                r0Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                r0 r0Var3 = (r0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                r0Var3.invokeSuspend(wVar4);
                return wVar4;
            default:
                r0 r0Var4 = (r0) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                r0Var4.invokeSuspend(wVar5);
                return wVar5;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        String strOptString;
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObject3;
        switch (this.f7841a) {
            case 0:
                s6.a.e(obj);
                u7.m0 m0Var = this.f7844d.f7703m;
                m0Var.getClass();
                m0Var.g(null, v5.j.f13166a);
                Context context = this.f7842b;
                w4 w4Var = new w4(context, 4, false);
                long j10 = this.f7843c;
                h5.p0 p0VarB = w4Var.b(j10);
                if (!p0VarB.b() && (jSONObject = p0VarB.f8699d) != null && jSONObject.optInt("success") == 1) {
                    new t1.c(context, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "removed"), "preregister");
                    v5.g gVarL = v5.g.f13148u.l(context);
                    gVarL.a();
                    String[] strArr = {String.valueOf(j10)};
                    SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("preregistrations", "appId=?", strArr);
                    gVarL.b();
                    v5.l lVar = new v5.l(new n0(false));
                    m0Var.getClass();
                    m0Var.g(null, lVar);
                }
                break;
            case 1:
                s6.a.e(obj);
                w4 w4Var2 = new w4(this.f7842b, 4, false);
                h5.p0 p0VarM = w4Var2.m(r1.i.d("https://www.uptodown.app:443/eapi/app/", "/pre-registered", this.f7843c), ShareTarget.METHOD_GET, w4Var2.i());
                p0VarM.f8699d = w4Var2.k(p0VarM, "/eapi/app/appID/pre-registered");
                boolean z9 = false;
                if (p0VarM.b() || (jSONObject2 = p0VarM.f8699d) == null || (jSONObjectOptJSONObject = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) == null) {
                    strOptString = null;
                } else {
                    strOptString = !jSONObjectOptJSONObject.isNull("message") ? jSONObjectOptJSONObject.optString("message") : null;
                    if (!jSONObjectOptJSONObject.isNull("preRegistered") && jSONObjectOptJSONObject.optInt("preRegistered") != 0) {
                        z9 = true;
                    }
                }
                u7.m0 m0Var2 = this.f7844d.f7705o;
                v5.l lVar2 = new v5.l(new o0(strOptString, z9));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
            case 2:
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                w4 w4Var3 = new w4(this.f7842b, 4, false);
                h5.p0 p0VarM2 = w4Var3.m(r1.i.d("https://www.uptodown.app:443/eapi/v2/apps/", "/promoted", this.f7843c), ShareTarget.METHOD_GET, null);
                p0VarM2.f8699d = w4Var3.k(p0VarM2, "/eapi/v2/apps/appID/promoted");
                if (!p0VarM2.b() && (jSONObject3 = p0VarM2.f8699d) != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObject3.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            h5.h hVar = new h5.h();
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i10);
                            jSONObjectOptJSONObject2.getClass();
                            hVar.a(null, jSONObjectOptJSONObject2);
                            arrayListA.add(hVar);
                        }
                    }
                    if (!arrayListA.isEmpty()) {
                        u7.m0 m0Var3 = this.f7844d.e;
                        m0Var3.getClass();
                        m0Var3.g(null, arrayListA);
                    }
                }
                break;
            default:
                s6.a.e(obj);
                w4 w4Var4 = new w4(this.f7842b, 4, false);
                Object value = this.f7844d.C.getValue();
                long j11 = this.f7843c;
                if (value != null) {
                    h5.p0 p0VarM3 = w4Var4.m(r1.i.d("https://www.uptodown.com:443/dwn/", "/native-external-update/increase", j11), ShareTarget.METHOD_POST, null);
                    p0VarM3.f8699d = w4Var4.k(p0VarM3, "/dwn/appID/native-external-update/increase");
                } else {
                    h5.p0 p0VarM4 = w4Var4.m(r1.i.d("https://www.uptodown.com:443/dwn/", "/native-external/increase", j11), ShareTarget.METHOD_POST, null);
                    p0VarM4.f8699d = w4Var4.k(p0VarM4, "/dwn/appID/native-external/increase");
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r0(int i10, long j10, Context context, c1 c1Var, w6.c cVar) {
        super(2, cVar);
        this.f7841a = i10;
        this.f7842b = context;
        this.f7843c = j10;
        this.f7844d = c1Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0(c1 c1Var, Context context, long j10, w6.c cVar) {
        super(2, cVar);
        this.f7841a = 0;
        this.f7844d = c1Var;
        this.f7842b = context;
        this.f7843c = j10;
    }
}

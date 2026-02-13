package l4;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b7 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10254a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PublicProfileActivity f10255b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10256c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b7(PublicProfileActivity publicProfileActivity, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10254a = i10;
        this.f10255b = publicProfileActivity;
        this.f10256c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10254a) {
            case 0:
                return new b7(this.f10255b, this.f10256c, cVar, 0);
            default:
                return new b7(this.f10255b, this.f10256c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10254a) {
        }
        return ((b7) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        String str;
        JSONObject jSONObject;
        h5.e1 e1Var;
        String str2;
        switch (this.f10254a) {
            case 0:
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                h5.p0 p0VarS = new c1.w4(this.f10255b, 4, false).s(20, 0, this.f10256c);
                if (!p0VarS.b() && (str = p0VarS.f8696a) != null && str.length() != 0) {
                    String str3 = p0VarS.f8696a;
                    str3.getClass();
                    JSONArray jSONArrayOptJSONArray = new JSONObject(str3).optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                            jSONObjectOptJSONObject.getClass();
                            h5.h hVar = new h5.h();
                            hVar.a(null, jSONObjectOptJSONObject);
                            arrayListA.add(hVar);
                        }
                    }
                }
                return arrayListA;
            default:
                ArrayList arrayListA2 = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                h5.p0 p0VarA = new c1.w4(this.f10255b, 4, false).A(10, 0, this.f10256c);
                if (!p0VarA.b() && (jSONObject = p0VarA.f8699d) != null && !jSONObject.isNull(DataSchemeDataSource.SCHEME_DATA)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONObject2.isNull("user")) {
                        e1Var = null;
                    } else {
                        e1Var = new h5.e1();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("user");
                        jSONObject3.getClass();
                        e1Var.c(jSONObject3);
                    }
                    JSONArray jSONArray = jSONObject2.isNull("comments") ? null : jSONObject2.getJSONArray("comments");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        int length2 = jSONArray.length();
                        for (int i11 = 0; i11 < length2; i11++) {
                            JSONObject jSONObject4 = jSONArray.getJSONObject(i11);
                            jSONObject4.getClass();
                            h5.t0 t0VarW = c1.d0.w(jSONObject4);
                            if (e1Var != null && (str2 = e1Var.f8515d) != null && str2.length() != 0) {
                                t0VarW.f8741c = e1Var.f8515d;
                                if (e1Var.f8521n) {
                                    t0VarW.f8747m = 1;
                                }
                            }
                            arrayListA2.add(t0VarW);
                        }
                    }
                }
                return arrayListA2;
        }
    }
}

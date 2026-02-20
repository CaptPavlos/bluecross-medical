package l4;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10349a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f2 f10350b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10351c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10352d;
    public final /* synthetic */ String e;
    public final /* synthetic */ kotlin.jvm.internal.v f;
    public final /* synthetic */ kotlin.jvm.internal.x g;
    public final /* synthetic */ kotlin.jvm.internal.x h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Serializable f10353i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(f2 f2Var, Context context, String str, String str2, String str3, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.x xVar2, w6.c cVar) {
        super(2, cVar);
        this.f10350b = f2Var;
        this.f10351c = context;
        this.f10352d = str;
        this.e = str2;
        this.f10353i = str3;
        this.f = vVar;
        this.g = xVar;
        this.h = xVar2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10349a) {
            case 0:
                return new e2(this.f10350b, this.f10351c, this.f10352d, this.e, this.g, this.f, this.h, (kotlin.jvm.internal.x) this.f10353i, cVar);
            default:
                return new e2(this.f10350b, this.f10351c, this.f10352d, this.e, (String) this.f10353i, this.f, this.g, this.h, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10349a) {
            case 0:
                e2 e2Var = (e2) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                e2Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                e2 e2Var2 = (e2) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                e2Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        SharedPreferences sharedPreferences;
        switch (this.f10349a) {
            case 0:
                kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) this.f10353i;
                s6.a.e(obj);
                u7.m0 m0Var = this.f10350b.f10382a;
                m0Var.getClass();
                m0Var.g(null, v5.j.f13166a);
                Context context = this.f10351c;
                h5.p0 p0VarH = new c1.w4(context, 4, false).H(this.f10352d, this.e);
                JSONObject jSONObject = p0VarH.f8699d;
                kotlin.jvm.internal.x xVar2 = this.h;
                kotlin.jvm.internal.v vVar = this.f;
                kotlin.jvm.internal.x xVar3 = this.g;
                if (jSONObject != null) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONObjectOptJSONObject != null) {
                        h5.e1 e1Var = new h5.e1();
                        e1Var.b(context, jSONObjectOptJSONObject);
                        xVar3.f10138a = e1Var;
                        try {
                            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                        if (string == null || string.length() == 0) {
                            h5.c1.c(context);
                        } else {
                            h5.e1 e1Var2 = (h5.e1) xVar3.f10138a;
                            if (e1Var2 != null) {
                                e1Var2.e(context);
                            }
                            vVar.f10136a = 1;
                        }
                        if (!jSONObjectOptJSONObject.isNull("message")) {
                            xVar2.f10138a = jSONObjectOptJSONObject.optString("message");
                        }
                    }
                    xVar.f10138a = h5.p0.c(jSONObject);
                }
                if (xVar3.f10138a != null) {
                    new t1.c(context, 4).e(r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success", "loginSource", "signin"), "login");
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("responseCode", String.valueOf(p0VarH.f8697b));
                    String str = p0VarH.f8698c;
                    if (str != null && str.length() != 0) {
                        String str2 = p0VarH.f8698c;
                        str2.getClass();
                        bundle.putString("exception", str2);
                    }
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail");
                    bundle.putString("loginSource", "signin");
                    new t1.c(context, 4).e(bundle, "login");
                }
                v5.l lVar = new v5.l(new c2(vVar.f10136a, (String) xVar2.f10138a, (String) xVar.f10138a));
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                s6.a.e(obj);
                u7.m0 m0Var2 = this.f10350b.f10384c;
                m0Var2.getClass();
                m0Var2.g(null, v5.j.f13166a);
                Context context2 = this.f10351c;
                c1.w4 w4Var = new c1.w4(context2, 4, false);
                String str3 = (String) this.f10353i;
                HashMap map = new HashMap();
                map.put("username", this.f10352d);
                byte[] bytes = this.e.getBytes(o7.a.f11749a);
                bytes.getClass();
                String strB = com.google.android.gms.internal.measurement.l5.B(bytes);
                strB.getClass();
                map.put("password", strB);
                map.put(NotificationCompat.CATEGORY_EMAIL, str3);
                map.put("terms", "1");
                h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/user/signup"), ShareTarget.METHOD_POST, map);
                if (p0VarM.b()) {
                    p0VarM.f8699d = w4Var.l(p0VarM, "/eapi/user/signup");
                } else {
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/signup");
                }
                JSONObject jSONObject2 = p0VarM.f8699d;
                kotlin.jvm.internal.x xVar4 = this.h;
                kotlin.jvm.internal.x xVar5 = this.g;
                kotlin.jvm.internal.v vVar2 = this.f;
                if (jSONObject2 != null) {
                    if (!jSONObject2.isNull("success")) {
                        vVar2.f10136a = jSONObject2.optInt("success");
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONObjectOptJSONObject2 != null && !jSONObjectOptJSONObject2.isNull("message")) {
                        xVar5.f10138a = jSONObjectOptJSONObject2.optString("message");
                    }
                    xVar4.f10138a = h5.p0.c(jSONObject2);
                }
                if (vVar2.f10136a == 1) {
                    new t1.c(context2, 4).e(r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success", "loginSource", "signup"), "login");
                } else {
                    Bundle bundleC = r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "loginSource", "signup");
                    bundleC.putString("responseCode", String.valueOf(p0VarM.f8697b));
                    String str4 = p0VarM.f8698c;
                    if (str4 != null) {
                        bundleC.putString("exception", str4);
                    }
                    new t1.c(context2, 4).e(bundleC, "login");
                }
                v5.l lVar2 = new v5.l(new d2(vVar2.f10136a, (String) xVar5.f10138a, (String) xVar4.f10138a));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2(f2 f2Var, Context context, String str, String str2, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.x xVar2, kotlin.jvm.internal.x xVar3, w6.c cVar) {
        super(2, cVar);
        this.f10350b = f2Var;
        this.f10351c = context;
        this.f10352d = str;
        this.e = str2;
        this.g = xVar;
        this.f = vVar;
        this.h = xVar2;
        this.f10353i = xVar3;
    }
}

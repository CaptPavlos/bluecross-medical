package h5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8464a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f8465b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f8466c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f8467d;
    public final /* synthetic */ kotlin.jvm.internal.v e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a1(Context context, String str, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.v vVar2, w6.c cVar, int i10) {
        super(2, cVar);
        this.f8464a = i10;
        this.f8465b = context;
        this.f8466c = str;
        this.f8467d = vVar;
        this.e = vVar2;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f8464a) {
            case 0:
                return new a1(this.f8465b, this.f8466c, this.f8467d, this.e, cVar, 0);
            default:
                return new a1(this.f8465b, this.f8466c, this.f8467d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f8464a) {
            case 0:
                a1 a1Var = (a1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                a1Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                a1 a1Var2 = (a1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                a1Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        switch (this.f8464a) {
            case 0:
                s6.a.e(obj);
                Context context = this.f8465b;
                w4 w4Var = new w4(context, 4, false);
                String str = this.f8466c;
                str.getClass();
                p0 p0VarM = w4Var.m("https://www.uptodown.app:443/eapi/user/follow/".concat(str), ShareTarget.METHOD_POST, null);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/follow/followUserID");
                int i10 = p0VarM.f8697b;
                kotlin.jvm.internal.v vVar = this.f8467d;
                vVar.f10136a = i10;
                if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null && !jSONObject.isNull("success")) {
                    this.e.f10136a = jSONObject.optInt("success");
                }
                if (vVar.f10136a == 401) {
                    c1.b(context);
                }
                break;
            default:
                s6.a.e(obj);
                Context context2 = this.f8465b;
                w4 w4Var2 = new w4(context2, 4, false);
                String str2 = this.f8466c;
                str2.getClass();
                p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443/eapi/user/unfollow/".concat(str2), ShareTarget.METHOD_POST, null);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, "/eapi/user/unfollow/followUserID");
                int i11 = p0VarM2.f8697b;
                kotlin.jvm.internal.v vVar2 = this.f8467d;
                vVar2.f10136a = i11;
                if (!p0VarM2.b() && (jSONObject2 = p0VarM2.f8699d) != null && !jSONObject2.isNull("success")) {
                    this.e.f10136a = jSONObject2.optInt("success");
                }
                if (vVar2.f10136a == 401) {
                    c1.b(context2);
                }
                break;
        }
        return s6.w.f12711a;
    }
}

package e5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7725a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f2 f7726b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7727c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7728d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(f2 f2Var, Context context, int i10, w6.c cVar) {
        super(2, cVar);
        this.f7725a = 1;
        this.f7726b = f2Var;
        this.f7727c = context;
        this.f7728d = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7725a) {
            case 0:
                return new d2(this.f7727c, this.f7728d, this.f7726b, cVar, 0);
            case 1:
                return new d2(this.f7726b, this.f7727c, this.f7728d, cVar);
            default:
                return new d2(this.f7727c, this.f7728d, this.f7726b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7725a) {
            case 0:
                d2 d2Var = (d2) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                d2Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                d2 d2Var2 = (d2) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                d2Var2.invokeSuspend(wVar3);
                return wVar3;
            default:
                d2 d2Var3 = (d2) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                d2Var3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        switch (this.f7725a) {
            case 0:
                s6.a.e(obj);
                Context context = this.f7727c;
                w4 w4Var = new w4(context, 4, false);
                HashMap map = new HashMap();
                int i10 = this.f7728d;
                map.put("floatingCategoryID", String.valueOf(i10));
                h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/user/categories/add"), ShareTarget.METHOD_POST, map);
                p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/user/categories/add");
                if (!p0VarM.b() && p0VarM.f8699d != null) {
                    this.f7726b.c(context, i10);
                }
                break;
            case 1:
                s6.a.e(obj);
                u7.m0 m0Var = this.f7726b.f7749c;
                m0Var.getClass();
                m0Var.g(null, v5.j.f13166a);
                w4 w4Var2 = new w4(this.f7727c, 4, false);
                String strF = a3.a.f(this.f7728d, "/eapi/user/categories/isFavorite/");
                h5.p0 p0VarM2 = w4Var2.m("https://www.uptodown.app:443".concat(strF), ShareTarget.METHOD_GET, null);
                p0VarM2.f8699d = w4Var2.k(p0VarM2, strF);
                if (!p0VarM2.b() && (jSONObject = p0VarM2.f8699d) != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                    v5.l lVar = new v5.l(Boolean.valueOf(jSONObjectOptJSONObject.optInt("isCategoryFavorite") == 1));
                    m0Var.getClass();
                    m0Var.g(null, lVar);
                }
                break;
            default:
                s6.a.e(obj);
                Context context2 = this.f7727c;
                w4 w4Var3 = new w4(context2, 4, false);
                HashMap map2 = new HashMap();
                int i11 = this.f7728d;
                map2.put("floatingCategoryID", String.valueOf(i11));
                h5.p0 p0VarM3 = w4Var3.m("https://www.uptodown.app:443".concat("/eapi/user/categories/delete"), ShareTarget.METHOD_POST, map2);
                p0VarM3.f8699d = w4Var3.k(p0VarM3, "/eapi/user/categories/delete");
                if (!p0VarM3.b() && p0VarM3.f8699d != null) {
                    this.f7726b.c(context2, i11);
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d2(Context context, int i10, f2 f2Var, w6.c cVar, int i11) {
        super(2, cVar);
        this.f7725a = i11;
        this.f7727c = context;
        this.f7728d = i10;
        this.f7726b = f2Var;
    }
}

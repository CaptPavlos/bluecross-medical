package s5;

import android.content.Context;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import l4.u4;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12631a;

    /* renamed from: b, reason: collision with root package name */
    public int f12632b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f12633c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h5.h f12634d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(TvSearchFragment tvSearchFragment, h5.h hVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12631a = i10;
        this.f12633c = tvSearchFragment;
        this.f12634d = hVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12631a) {
            case 0:
                return new g0(this.f12633c, this.f12634d, cVar, 0);
            default:
                return new g0(this.f12633c, this.f12634d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12631a) {
        }
        return ((g0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        int i10 = this.f12631a;
        int i11 = 0;
        h5.h hVar = this.f12634d;
        TvSearchFragment tvSearchFragment = this.f12633c;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f12632b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    Context contextRequireContext = tvSearchFragment.requireContext();
                    contextRequireContext.getClass();
                    h5.p0 p0VarQ = new w4(contextRequireContext, 4, false).q(hVar.f8566a);
                    if (!p0VarQ.b() && (str = p0VarQ.f8696a) != null && str.length() != 0) {
                        String str2 = p0VarQ.f8696a;
                        str2.getClass();
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject.optInt("success") == 1 && jSONObjectOptJSONObject != null) {
                            hVar.a(null, jSONObjectOptJSONObject);
                        }
                    }
                    y7.e eVar = r7.i0.f12407a;
                    s7.c cVar2 = w7.n.f13548a;
                    u4 u4Var = new u4(tvSearchFragment, hVar, null, 29);
                    this.f12632b = 1;
                    if (r7.y.z(u4Var, cVar2, this) == aVar) {
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i13 = this.f12632b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    this.f12632b = 1;
                    int i14 = TvSearchFragment.f6719d;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ = r7.y.z(new g0(tvSearchFragment, hVar, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
        }
        return wVar;
    }
}

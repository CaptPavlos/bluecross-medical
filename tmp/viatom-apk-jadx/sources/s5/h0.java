package s5;

import android.content.Context;
import android.content.res.Resources;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12636a;

    /* renamed from: b, reason: collision with root package name */
    public int f12637b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f12638c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f12639d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(TvSearchFragment tvSearchFragment, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12636a = i10;
        this.f12638c = tvSearchFragment;
        this.f12639d = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12636a) {
            case 0:
                return new h0(this.f12638c, this.f12639d, cVar, 0);
            default:
                return new h0(this.f12638c, this.f12639d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12636a) {
        }
        return ((h0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        Resources resources;
        int i10 = this.f12636a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        w6.c cVar = null;
        int i11 = 1;
        switch (i10) {
            case 0:
                int i12 = this.f12637b;
                if (i12 != 0) {
                    if (i12 != 1) {
                        if (i12 == 2) {
                            s6.a.e(obj);
                            break;
                        } else {
                            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                            break;
                        }
                    } else {
                        s6.a.e(obj);
                    }
                } else {
                    s6.a.e(obj);
                    this.f12637b = 1;
                    if (r7.y.h(300L, this) != aVar) {
                    }
                    break;
                }
                this.f12637b = 2;
                int i13 = TvSearchFragment.f6719d;
                y7.e eVar = r7.i0.f12407a;
                Object objZ = r7.y.z(new h0(this.f12638c, this.f12639d, cVar, i11), y7.d.f14116a, this);
                if (objZ != aVar) {
                    objZ = wVar;
                }
                if (objZ != aVar) {
                }
                break;
            default:
                int i14 = this.f12637b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                    TvSearchFragment tvSearchFragment = this.f12638c;
                    Context contextRequireContext = tvSearchFragment.requireContext();
                    contextRequireContext.getClass();
                    w4 w4Var = new w4(contextRequireContext, 4, false);
                    String str = this.f12639d;
                    h5.p0 p0VarL = w4Var.L(10, 0, str);
                    if (!p0VarL.b() && (jSONObject = p0VarL.f8699d) != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA)) != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("results");
                        if (jSONObject.optInt("success") == 1 && jSONArrayOptJSONArray != null) {
                            Context context = tvSearchFragment.getContext();
                            w6.c cVar2 = null;
                            Integer num = (context == null || (resources = context.getResources()) == null) ? null : new Integer(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                            int length = jSONArrayOptJSONArray.length();
                            for (int i15 = 0; i15 < length; i15++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i15);
                                jSONObjectOptJSONObject2.getClass();
                                h5.h hVar = new h5.h();
                                hVar.a(null, jSONObjectOptJSONObject2);
                                arrayListA.add(hVar);
                                if (num != null) {
                                    j4.y.d().e(hVar.g(num.intValue())).b(null);
                                }
                            }
                            y7.e eVar2 = r7.i0.f12407a;
                            s7.c cVar3 = w7.n.f13548a;
                            c5.m mVar = new c5.m(tvSearchFragment, str, arrayListA, cVar2, 21);
                            this.f12637b = 1;
                            if (r7.y.z(mVar, cVar3, this) == aVar) {
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return aVar;
    }
}

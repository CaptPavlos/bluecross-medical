package s5;

import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.FragmentActivity;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;
import java.util.ArrayList;
import l4.u4;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12640a;

    /* renamed from: b, reason: collision with root package name */
    public int f12641b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f12642c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(TvAppsListFragment tvAppsListFragment, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12640a = i10;
        this.f12642c = tvAppsListFragment;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12640a) {
            case 0:
                return new i(this.f12642c, cVar, 0);
            default:
                return new i(this.f12642c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12640a) {
        }
        return ((i) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        h5.p0 p0VarO;
        JSONObject jSONObject;
        Resources resources;
        int i10 = this.f12640a;
        TvAppsListFragment tvAppsListFragment = this.f12642c;
        x6.a aVar = x6.a.f13718a;
        s6.w wVar = s6.w.f12711a;
        int i11 = 0;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f12641b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                    tvAppsListFragment.f6707d = true;
                    FragmentActivity fragmentActivityRequireActivity = tvAppsListFragment.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    w4 w4Var = new w4(fragmentActivityRequireActivity, 4, false);
                    h5.k kVar = tvAppsListFragment.f6705b;
                    if (kVar != null) {
                        int i13 = kVar.f8632a;
                        if (i13 == -2) {
                            p0VarO = w4Var.o(75, tvAppsListFragment.f6706c);
                        } else if (i13 != -1) {
                            kVar.getClass();
                            boolean z9 = kVar.f8635d;
                            h5.k kVar2 = tvAppsListFragment.f6705b;
                            if (z9) {
                                kVar2.getClass();
                                p0VarO = w4Var.x(kVar2.f8632a, tvAppsListFragment.f6706c);
                            } else {
                                kVar2.getClass();
                                p0VarO = w4Var.v(kVar2.f8632a, 75, tvAppsListFragment.f6706c);
                            }
                        } else {
                            p0VarO = w4Var.u(75, tvAppsListFragment.f6706c);
                        }
                    } else {
                        p0VarO = null;
                    }
                    if (p0VarO != null && !p0VarO.b() && (jSONObject = p0VarO.f8699d) != null) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject.optInt("success") == 1 && jSONArrayOptJSONArray != null) {
                            xVar.f10138a = new ArrayList();
                            Context context = tvAppsListFragment.getContext();
                            Integer num = (context == null || (resources = context.getResources()) == null) ? null : new Integer(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                            int length = jSONArrayOptJSONArray.length();
                            while (i11 < length) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i11);
                                jSONObjectOptJSONObject.getClass();
                                h5.h hVar = new h5.h();
                                hVar.a(null, jSONObjectOptJSONObject);
                                ((ArrayList) xVar.f10138a).add(hVar);
                                if (num != null) {
                                    j4.y.d().e(hVar.g(num.intValue())).b(null);
                                }
                                tvAppsListFragment.f6706c++;
                                i11++;
                            }
                        }
                    }
                    y7.e eVar = r7.i0.f12407a;
                    s7.c cVar2 = w7.n.f13548a;
                    u4 u4Var = new u4(tvAppsListFragment, xVar, cVar, 26);
                    this.f12641b = 1;
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
                int i14 = this.f12641b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    this.f12641b = 1;
                    y7.e eVar2 = r7.i0.f12407a;
                    Object objZ = r7.y.z(new i(tvAppsListFragment, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                    }
                } else if (i14 != 1) {
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

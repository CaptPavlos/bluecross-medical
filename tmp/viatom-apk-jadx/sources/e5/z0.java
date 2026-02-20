package e5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.lifecycle.ViewModelKt;
import c1.w4;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f7916a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7917b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.j1 f7918c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7919d;
    public final /* synthetic */ c1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(Context context, long j10, h5.j1 j1Var, ArrayList arrayList, c1 c1Var, w6.c cVar) {
        super(2, cVar);
        this.f7916a = context;
        this.f7917b = j10;
        this.f7918c = j1Var;
        this.f7919d = arrayList;
        this.e = c1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new z0(this.f7916a, this.f7917b, this.f7918c, this.f7919d, this.e, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        z0 z0Var = (z0) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        z0Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        s6.a.e(obj);
        Context context = this.f7916a;
        int i10 = 0;
        w4 w4Var = new w4(context, 4, false);
        long j10 = this.f7918c.f8628a;
        ArrayList arrayList = this.f7919d;
        ArrayList arrayList2 = new ArrayList(t6.n.V(arrayList, 10));
        int size = arrayList.size();
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            arrayList2.add(new Long(((h5.j1) obj2).f8628a));
        }
        HashMap map = new HashMap();
        map.put("deviceID", String.valueOf(j10));
        map.put("targetDeviceIDs", arrayList2.toString());
        StringBuilder sb = new StringBuilder("/eapi/app/");
        long j11 = this.f7917b;
        String strL = a3.a.l(sb, j11, "/remote-install");
        h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat(strL), ShareTarget.METHOD_POST, map);
        p0VarM.f8699d = w4Var.k(p0VarM, strL);
        if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null && jSONObject.optInt("success") == 1) {
            c1 c1Var = this.e;
            r7.w viewModelScope = ViewModelKt.getViewModelScope(c1Var);
            y7.e eVar = r7.i0.f12407a;
            r7.y.q(viewModelScope, y7.d.f14116a, null, new v0(c1Var, context, w4Var, j11, null), 2);
        }
        return s6.w.f12711a;
    }
}

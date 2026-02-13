package l4;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.AppDetailActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10271a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppDetailActivity f10272b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10273c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(AppDetailActivity appDetailActivity, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10271a = i10;
        this.f10272b = appDetailActivity;
        this.f10273c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10271a) {
            case 0:
                return new c(this.f10272b, this.f10273c, cVar, 0);
            default:
                return new c(this.f10272b, this.f10273c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10271a) {
            case 0:
                c cVar2 = (c) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                cVar2.invokeSuspend(wVar2);
                return wVar2;
            default:
                c cVar3 = (c) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                cVar3.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10271a;
        s6.w wVar = s6.w.f12711a;
        String str = this.f10273c;
        AppDetailActivity appDetailActivity = this.f10272b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                ArrayList arrayList = appDetailActivity.J;
                int i11 = AppDetailActivity.N;
                e5.j0 j0VarN0 = appDetailActivity.n0();
                if (j0VarN0 != null && j0VarN0.isResumed()) {
                    str.getClass();
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(j0VarN0);
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(lifecycleScope, w7.n.f13548a, null, new e5.i0(str, j0VarN0, null, 1), 2);
                    j0VarN0.u0(str);
                }
                if (!arrayList.isEmpty()) {
                    ((e5.b2) t6.l.i0(arrayList)).e(str);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                int i12 = AppDetailActivity.N;
                e5.j0 j0VarN02 = appDetailActivity.n0();
                if (j0VarN02 != null && j0VarN02.isResumed()) {
                    j0VarN02.v0(str);
                    break;
                }
                break;
        }
        return wVar;
    }
}

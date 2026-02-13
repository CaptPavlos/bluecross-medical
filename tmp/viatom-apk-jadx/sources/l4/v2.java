package l4;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10904a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10905b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10906c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v2(MainActivity mainActivity, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10904a = i10;
        this.f10905b = mainActivity;
        this.f10906c = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10904a) {
            case 0:
                return new v2(this.f10905b, this.f10906c, cVar, 0);
            default:
                return new v2(this.f10905b, this.f10906c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10904a) {
            case 0:
                v2 v2Var = (v2) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                v2Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                v2 v2Var2 = (v2) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                v2Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10904a;
        s6.w wVar = s6.w.f12711a;
        String str = this.f10906c;
        MainActivity mainActivity = this.f10905b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                Fragment fragmentG0 = mainActivity.G0();
                if (fragmentG0 instanceof e5.j0) {
                    e5.j0 j0Var = (e5.j0) fragmentG0;
                    str.getClass();
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(j0Var);
                    y7.e eVar = r7.i0.f12407a;
                    r7.y.q(lifecycleScope, w7.n.f13548a, null, new e5.i0(str, j0Var, null, 1), 2);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                Fragment fragmentG02 = mainActivity.G0();
                if (fragmentG02 instanceof e5.j0) {
                    ((e5.j0) fragmentG02).v0(str);
                    break;
                }
                break;
        }
        return wVar;
    }
}

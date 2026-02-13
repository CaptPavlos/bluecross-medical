package l4;

import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o0 extends y6.i implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10673a;

    /* renamed from: b, reason: collision with root package name */
    public int f10674b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ String f10675c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ long f10676d;
    public final /* synthetic */ w e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o0(w wVar, w6.c cVar, int i10) {
        super(3, cVar);
        this.f10673a = i10;
        this.e = wVar;
    }

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        String str = (String) obj;
        Number number = (Number) obj2;
        switch (this.f10673a) {
            case 0:
                long jLongValue = number.longValue();
                o0 o0Var = new o0((FreeUpSpaceActivity) this.e, (w6.c) obj3, 0);
                o0Var.f10675c = str;
                o0Var.f10676d = jLongValue;
                return o0Var.invokeSuspend(s6.w.f12711a);
            case 1:
                long jLongValue2 = number.longValue();
                o0 o0Var2 = new o0((MyApps) this.e, (w6.c) obj3, 1);
                o0Var2.f10675c = str;
                o0Var2.f10676d = jLongValue2;
                return o0Var2.invokeSuspend(s6.w.f12711a);
            default:
                long jLongValue3 = number.longValue();
                o0 o0Var3 = new o0((Updates) this.e, (w6.c) obj3, 2);
                o0Var3.f10675c = str;
                o0Var3.f10676d = jLongValue3;
                return o0Var3.invokeSuspend(s6.w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10673a;
        s6.w wVar = s6.w.f12711a;
        w wVar2 = this.e;
        x6.a aVar = x6.a.f13718a;
        String str = this.f10675c;
        long j10 = this.f10676d;
        switch (i10) {
            case 0:
                int i11 = this.f10674b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    y7.e eVar = r7.i0.f12407a;
                    s7.c cVar = w7.n.f13548a;
                    e5.g1 g1Var = new e5.g1((FreeUpSpaceActivity) wVar2, str, j10, (w6.c) null, 3);
                    this.f10675c = null;
                    this.f10676d = j10;
                    this.f10674b = 1;
                    if (r7.y.z(g1Var, cVar, this) == aVar) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            case 1:
                int i12 = this.f10674b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    y7.e eVar2 = r7.i0.f12407a;
                    s7.c cVar2 = w7.n.f13548a;
                    e5.g1 g1Var2 = new e5.g1((MyApps) wVar2, str, j10, (w6.c) null, 4);
                    this.f10675c = null;
                    this.f10676d = j10;
                    this.f10674b = 1;
                    if (r7.y.z(g1Var2, cVar2, this) == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i13 = this.f10674b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    y7.e eVar3 = r7.i0.f12407a;
                    s7.c cVar3 = w7.n.f13548a;
                    e5.g1 g1Var3 = new e5.g1((Updates) wVar2, str, j10, (w6.c) null, 5);
                    this.f10675c = null;
                    this.f10676d = j10;
                    this.f10674b = 1;
                    if (r7.y.z(g1Var3, cVar3, this) == aVar) {
                        break;
                    }
                } else if (i13 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}

package n5;

import c1.w4;
import g7.p;
import l4.p2;
import r7.i0;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11542a;

    /* renamed from: b, reason: collision with root package name */
    public int f11543b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p2 f11544c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ w4 f11545d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i10, w4 w4Var, p2 p2Var, w6.c cVar) {
        super(2, cVar);
        this.f11542a = i10;
        this.f11544c = p2Var;
        this.f11545d = w4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f11542a) {
            case 0:
                return new g(0, this.f11545d, this.f11544c, cVar);
            case 1:
                return new g(1, this.f11545d, this.f11544c, cVar);
            case 2:
                return new g(2, this.f11545d, this.f11544c, cVar);
            default:
                return new g(3, this.f11545d, this.f11544c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f11542a) {
        }
        return ((g) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f11542a;
        w4 w4Var = this.f11545d;
        p2 p2Var = this.f11544c;
        x6.a aVar = x6.a.f13718a;
        switch (i10) {
            case 0:
                int i11 = this.f11543b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f11543b = 1;
                    y7.e eVar = i0.f12407a;
                    Object objZ = y.z(new f(0, w4Var, p2Var, null), y7.d.f14116a, this);
                    if (objZ == aVar) {
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
                int i12 = this.f11543b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f11543b = 1;
                    y7.e eVar2 = i0.f12407a;
                    Object objZ2 = y.z(new f(1, w4Var, p2Var, null), y7.d.f14116a, this);
                    if (objZ2 == aVar) {
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
            case 2:
                int i13 = this.f11543b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    this.f11543b = 1;
                    y7.e eVar3 = i0.f12407a;
                    Object objZ3 = y.z(new i(w4Var, p2Var, (w6.c) null), y7.d.f14116a, this);
                    if (objZ3 == aVar) {
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
            default:
                int i14 = this.f11543b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    this.f11543b = 1;
                    y7.e eVar4 = i0.f12407a;
                    Object objZ4 = y.z(new i(p2Var, w4Var, (w6.c) null), y7.d.f14116a, this);
                    if (objZ4 == aVar) {
                        break;
                    }
                } else if (i14 != 1) {
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

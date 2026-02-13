package c5;

import l4.l7;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1698a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x4 f1699b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(x4 x4Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1698a = i10;
        this.f1699b = x4Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1698a) {
            case 0:
                return new i0(this.f1699b, cVar, 0);
            case 1:
                return new i0(this.f1699b, cVar, 1);
            case 2:
                return new i0(this.f1699b, cVar, 2);
            default:
                return new i0(this.f1699b, cVar, 3);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1698a) {
            case 0:
                i0 i0Var = (i0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                i0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                i0 i0Var2 = (i0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                i0Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                i0 i0Var3 = (i0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                i0Var3.invokeSuspend(wVar4);
                return wVar4;
            default:
                i0 i0Var4 = (i0) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                i0Var4.invokeSuspend(wVar5);
                return wVar5;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1698a) {
            case 0:
                s6.a.e(obj);
                u7.m0 m0Var = ((l7) this.f1699b.f10987b).f10598c;
                Boolean bool = Boolean.TRUE;
                m0Var.getClass();
                m0Var.g(null, bool);
                break;
            case 1:
                s6.a.e(obj);
                u7.m0 m0Var2 = ((l7) this.f1699b.f10987b).f10598c;
                Boolean bool2 = Boolean.FALSE;
                m0Var2.getClass();
                m0Var2.g(null, bool2);
                break;
            case 2:
                s6.a.e(obj);
                u7.m0 m0Var3 = ((l7) this.f1699b.f10987b).f10598c;
                Boolean bool3 = Boolean.FALSE;
                m0Var3.getClass();
                m0Var3.g(null, bool3);
                break;
            default:
                s6.a.e(obj);
                u7.m0 m0Var4 = ((l7) this.f1699b.f10987b).f10598c;
                Boolean bool4 = Boolean.TRUE;
                m0Var4.getClass();
                m0Var4.g(null, bool4);
                break;
        }
        return s6.w.f12711a;
    }
}

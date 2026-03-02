package c5;

import e5.a2;
import n4.p0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4.f f1663b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c0(a4.f fVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1662a = i10;
        this.f1663b = fVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1662a) {
            case 0:
                return new c0(this.f1663b, cVar, 0);
            case 1:
                return new c0(this.f1663b, cVar, 1);
            case 2:
                return new c0(this.f1663b, cVar, 2);
            case 3:
                return new c0(this.f1663b, cVar, 3);
            case 4:
                return new c0(this.f1663b, cVar, 4);
            case 5:
                return new c0(this.f1663b, cVar, 5);
            default:
                return new c0(this.f1663b, cVar, 6);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1662a) {
            case 0:
                c0 c0Var = (c0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                c0Var.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                c0 c0Var2 = (c0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                c0Var2.invokeSuspend(wVar3);
                return wVar3;
            case 2:
                c0 c0Var3 = (c0) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                c0Var3.invokeSuspend(wVar4);
                return wVar4;
            case 3:
                c0 c0Var4 = (c0) create(wVar, cVar);
                s6.w wVar5 = s6.w.f12711a;
                c0Var4.invokeSuspend(wVar5);
                return wVar5;
            case 4:
                c0 c0Var5 = (c0) create(wVar, cVar);
                s6.w wVar6 = s6.w.f12711a;
                c0Var5.invokeSuspend(wVar6);
                return wVar6;
            case 5:
                c0 c0Var6 = (c0) create(wVar, cVar);
                s6.w wVar7 = s6.w.f12711a;
                c0Var6.invokeSuspend(wVar7);
                return wVar7;
            default:
                c0 c0Var7 = (c0) create(wVar, cVar);
                s6.w wVar8 = s6.w.f12711a;
                c0Var7.invokeSuspend(wVar8);
                return wVar8;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1662a) {
            case 0:
                s6.a.e(obj);
                a2 a2Var = (a2) this.f1663b.f219c;
                p0 p0Var = a2Var.f7677a.e;
                if (p0Var != null) {
                    p0Var.b(a2Var.f7678b);
                }
                break;
            case 1:
                s6.a.e(obj);
                ((a2) this.f1663b.f219c).a();
                break;
            case 2:
                s6.a.e(obj);
                ((a2) this.f1663b.f219c).a();
                break;
            case 3:
                s6.a.e(obj);
                ((a2) this.f1663b.f219c).a();
                break;
            case 4:
                s6.a.e(obj);
                a2 a2Var2 = (a2) this.f1663b.f219c;
                p0 p0Var2 = a2Var2.f7677a.e;
                if (p0Var2 != null) {
                    p0Var2.b(a2Var2.f7678b);
                }
                break;
            case 5:
                s6.a.e(obj);
                ((a2) this.f1663b.f219c).a();
                break;
            default:
                s6.a.e(obj);
                ((a2) this.f1663b.f219c).a();
                break;
        }
        return s6.w.f12711a;
    }
}

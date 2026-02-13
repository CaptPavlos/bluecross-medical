package c5;

import e5.f1;
import h5.x0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1701b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x0 f1702c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(w2.r rVar, x0 x0Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1700a = i10;
        this.f1701b = rVar;
        this.f1702c = x0Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1700a) {
            case 0:
                return new j(this.f1701b, this.f1702c, cVar, 0);
            case 1:
                return new j(this.f1701b, this.f1702c, cVar, 1);
            default:
                return new j(this.f1701b, this.f1702c, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1700a) {
            case 0:
                j jVar = (j) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                jVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                j jVar2 = (j) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                jVar2.invokeSuspend(wVar3);
                return wVar3;
            default:
                j jVar3 = (j) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                jVar3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1700a) {
            case 0:
                s6.a.e(obj);
                f1 f1Var = (f1) this.f1701b.f13463c;
                f1Var.getClass();
                f1Var.f7746a.e = this.f1702c;
                break;
            case 1:
                s6.a.e(obj);
                f1 f1Var2 = (f1) this.f1701b.f13463c;
                f1Var2.getClass();
                f1Var2.f7746a.f = this.f1702c;
                break;
            default:
                s6.a.e(obj);
                w2.r rVar = this.f1701b;
                if (((h5.k) rVar.f13464d).f8632a != 523) {
                    f1 f1Var3 = (f1) rVar.f13463c;
                    f1Var3.getClass();
                    x0 x0Var = this.f1702c;
                    x0Var.getClass();
                    n4.h hVar = f1Var3.f7746a.f7766b;
                    if (hVar != null) {
                        hVar.b(x0Var);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }
}

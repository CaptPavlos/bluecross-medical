package b;

import a3.x;
import a3.z0;
import g7.p;
import java.io.IOException;
import s6.w;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class m extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f798a;

    /* renamed from: b, reason: collision with root package name */
    public int f799b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f800c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(o oVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f798a = i10;
        this.f800c = oVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f798a) {
            case 0:
                return new m(this.f800c, cVar, 0);
            case 1:
                return new m(this.f800c, cVar, 1);
            case 2:
                return new m(this.f800c, cVar, 2);
            case 3:
                return new m(this.f800c, cVar, 3);
            case 4:
                return new m(this.f800c, cVar, 4);
            case 5:
                return new m(this.f800c, cVar, 5);
            default:
                return new m(this.f800c, cVar, 6);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w6.c cVar = (w6.c) obj2;
        switch (this.f798a) {
            case 0:
                return new m(this.f800c, cVar, 0).invokeSuspend(w.f12711a);
            case 1:
                return new m(this.f800c, cVar, 1).invokeSuspend(w.f12711a);
            case 2:
                return new m(this.f800c, cVar, 2).invokeSuspend(w.f12711a);
            case 3:
                return new m(this.f800c, cVar, 3).invokeSuspend(w.f12711a);
            case 4:
                return new m(this.f800c, cVar, 4).invokeSuspend(w.f12711a);
            case 5:
                return new m(this.f800c, cVar, 5).invokeSuspend(w.f12711a);
            default:
                return new m(this.f800c, cVar, 6).invokeSuspend(w.f12711a);
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws IOException {
        switch (this.f798a) {
            case 0:
                int i10 = this.f799b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                r rVar = this.f800c.e;
                this.f799b = 1;
                Object objA = rVar.a(this);
                x6.a aVar = x6.a.f13718a;
                return objA == aVar ? aVar : objA;
            case 1:
                int i11 = this.f799b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                o oVar = this.f800c;
                f9.n nVar = oVar.f808d;
                int i12 = oVar.f807c.f11814b.G;
                this.f799b = 1;
                Object objA2 = nVar.a(i12, this);
                x6.a aVar2 = x6.a.f13718a;
                return objA2 == aVar2 ? aVar2 : objA2;
            case 2:
                int i13 = this.f799b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                z0 z0Var = this.f800c.f;
                this.f799b = 1;
                Object objG = z0Var.g(this);
                x6.a aVar3 = x6.a.f13718a;
                return objG == aVar3 ? aVar3 : objG;
            case 3:
                int i14 = this.f799b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                z0 z0Var2 = this.f800c.f810j;
                this.f799b = 1;
                Object objG2 = z0Var2.g(this);
                x6.a aVar4 = x6.a.f13718a;
                return objG2 == aVar4 ? aVar4 : objG2;
            case 4:
                int i15 = this.f799b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                x xVar = this.f800c.h;
                this.f799b = 1;
                Object objH = xVar.h(this);
                x6.a aVar5 = x6.a.f13718a;
                return objH == aVar5 ? aVar5 : objH;
            case 5:
                int i16 = this.f799b;
                if (i16 != 0) {
                    if (i16 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                r rVar2 = this.f800c.f809i;
                this.f799b = 1;
                Object objA3 = rVar2.a(this);
                x6.a aVar6 = x6.a.f13718a;
                return objA3 == aVar6 ? aVar6 : objA3;
            default:
                int i17 = this.f799b;
                if (i17 != 0) {
                    if (i17 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                d5.n nVar2 = this.f800c.g;
                this.f799b = 1;
                Object objD = nVar2.d(this);
                x6.a aVar7 = x6.a.f13718a;
                return objD == aVar7 ? aVar7 : objD;
        }
    }
}

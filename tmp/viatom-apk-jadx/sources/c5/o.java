package c5;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1737b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f1738c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(kotlin.jvm.internal.x xVar, t tVar, w6.c cVar) {
        super(2, cVar);
        this.f1736a = 1;
        this.f1737b = xVar;
        this.f1738c = tVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1736a) {
            case 0:
                return new o(this.f1738c, this.f1737b, cVar, 0);
            case 1:
                return new o(this.f1737b, this.f1738c, cVar);
            default:
                return new o(this.f1738c, this.f1737b, cVar, 2);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1736a) {
            case 0:
                o oVar = (o) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                oVar.invokeSuspend(wVar2);
                return wVar2;
            case 1:
                o oVar2 = (o) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                oVar2.invokeSuspend(wVar3);
                return wVar3;
            default:
                o oVar3 = (o) create(wVar, cVar);
                s6.w wVar4 = s6.w.f12711a;
                oVar3.invokeSuspend(wVar4);
                return wVar4;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1736a) {
            case 0:
                s6.a.e(obj);
                ((g5.h) this.f1738c.f1758d).d((ArrayList) this.f1737b.f10138a);
                break;
            case 1:
                s6.a.e(obj);
                Object obj2 = this.f1737b.f10138a;
                if (obj2 != null) {
                    ((g5.h) this.f1738c.f1758d).h((h5.h) obj2);
                }
                break;
            default:
                s6.a.e(obj);
                ((g5.h) this.f1738c.f1758d).a((h5.h) this.f1737b.f10138a);
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(t tVar, kotlin.jvm.internal.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1736a = i10;
        this.f1738c = tVar;
        this.f1737b = xVar;
    }
}

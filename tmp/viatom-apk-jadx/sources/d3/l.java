package d3;

import g7.p;
import r7.w;
import u7.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6828a;

    /* renamed from: b, reason: collision with root package name */
    public int f6829b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f6830c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(n nVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f6828a = i10;
        this.f6830c = nVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f6828a) {
            case 0:
                return new l(this.f6830c, cVar, 0);
            default:
                return new l(this.f6830c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f6828a) {
        }
        return ((l) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6828a) {
            case 0:
                int i10 = this.f6829b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    n nVar = this.f6830c;
                    u7.h data = nVar.f6835b.getData();
                    k kVar = new k(nVar.f6836c);
                    this.f6829b = 1;
                    Object objCollect = data.collect(kVar, this);
                    x6.a aVar = x6.a.f13718a;
                    if (objCollect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    s6.a.e(obj);
                }
                return s6.w.f12711a;
            default:
                int i11 = this.f6829b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        s6.a.e(obj);
                        return obj;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                u7.h data2 = this.f6830c.f6835b.getData();
                this.f6829b = 1;
                Object objI = i0.i(data2, this);
                x6.a aVar2 = x6.a.f13718a;
                return objI == aVar2 ? aVar2 : objI;
        }
    }
}

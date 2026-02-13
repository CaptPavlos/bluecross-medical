package l4;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10580a;

    /* renamed from: b, reason: collision with root package name */
    public int f10581b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n0 f10582c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f10583d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l0(n0 n0Var, Context context, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10580a = i10;
        this.f10582c = n0Var;
        this.f10583d = context;
        this.e = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10580a) {
            case 0:
                return new l0(this.f10582c, this.f10583d, this.e, cVar, 0);
            default:
                return new l0(this.f10582c, this.f10583d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10580a) {
        }
        return ((l0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10580a) {
            case 0:
                u7.m0 m0Var = this.f10582c.f10643c;
                int i10 = this.f10581b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    m0Var.getClass();
                    m0Var.g(null, v5.k.f13167a);
                    this.f10581b = 1;
                    obj = h5.e1.f8511q.d(this.f10583d, this.e, this);
                    x6.a aVar = x6.a.f13718a;
                    if (obj == aVar) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                v5.l lVar = new v5.l((h5.d1) obj);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                u7.m0 m0Var2 = this.f10582c.f10643c;
                int i11 = this.f10581b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    m0Var2.getClass();
                    m0Var2.g(null, v5.k.f13167a);
                    this.f10581b = 1;
                    obj = h5.e1.f8511q.i(this.f10583d, this.e, this);
                    x6.a aVar2 = x6.a.f13718a;
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                v5.l lVar2 = new v5.l((h5.d1) obj);
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

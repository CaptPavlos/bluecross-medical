package e5;

import android.content.Context;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7851a;

    /* renamed from: b, reason: collision with root package name */
    public int f7852b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f7853c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7854d;
    public final /* synthetic */ c1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s0(Context context, String str, c1 c1Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f7851a = i10;
        this.f7853c = context;
        this.f7854d = str;
        this.e = c1Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7851a) {
            case 0:
                return new s0(this.f7853c, this.f7854d, this.e, cVar, 0);
            default:
                return new s0(this.f7853c, this.f7854d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7851a) {
        }
        return ((s0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f7851a) {
            case 0:
                int i10 = this.f7852b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    this.f7852b = 1;
                    obj = h5.e1.f8511q.d(this.f7853c, this.f7854d, this);
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
                u7.m0 m0Var = this.e.A;
                v5.l lVar = new v5.l((h5.d1) obj);
                m0Var.getClass();
                m0Var.g(null, lVar);
                break;
            default:
                int i11 = this.f7852b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    this.f7852b = 1;
                    obj = h5.e1.f8511q.i(this.f7853c, this.f7854d, this);
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
                u7.m0 m0Var2 = this.e.A;
                v5.l lVar2 = new v5.l((h5.d1) obj);
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return s6.w.f12711a;
    }
}

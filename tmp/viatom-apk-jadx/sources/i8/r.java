package i8;

import h0.a0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.h implements g7.q {

    /* renamed from: a, reason: collision with root package name */
    public int f9082a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ s6.b f9083b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a0 f9084c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(a0 a0Var, w6.c cVar) {
        super(3, cVar);
        this.f9084c = a0Var;
    }

    @Override // g7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        r rVar = new r(this.f9084c, (w6.c) obj3);
        rVar.f9083b = (s6.b) obj;
        return rVar.invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        a0 a0Var = this.f9084c;
        a6.f fVar = (a6.f) a0Var.f8353c;
        int i10 = this.f9082a;
        if (i10 == 0) {
            s6.a.e(obj);
            s6.b bVar = this.f9083b;
            byte bT = fVar.t();
            if (bT == 1) {
                return a0Var.g(true);
            }
            if (bT == 0) {
                return a0Var.g(false);
            }
            if (bT != 6) {
                if (bT == 8) {
                    return a0Var.e();
                }
                a6.f.o(fVar, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f9082a = 1;
            obj = a0.a(a0Var, bVar, this);
            x6.a aVar = x6.a.f13718a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i10 != 1) {
                androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s6.a.e(obj);
        }
        return (h8.k) obj;
    }
}

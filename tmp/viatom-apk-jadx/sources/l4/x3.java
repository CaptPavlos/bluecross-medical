package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10982a;

    /* renamed from: b, reason: collision with root package name */
    public int f10983b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a4 f10984c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h5.f f10985d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x3(a4 a4Var, h5.f fVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10982a = i10;
        this.f10984c = a4Var;
        this.f10985d = fVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10982a) {
            case 0:
                return new x3(this.f10984c, this.f10985d, cVar, 0);
            default:
                return new x3(this.f10984c, this.f10985d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10982a) {
        }
        return ((x3) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        switch (this.f10982a) {
            case 0:
                int i10 = this.f10983b;
                if (i10 == 0) {
                    s6.a.e(obj);
                    a4 a4Var = this.f10984c;
                    w2.r rVar = new w2.r(a4Var, null, this.f10985d, a4Var.S, 7);
                    this.f10983b = 1;
                    Object objG = rVar.G(this);
                    x6.a aVar = x6.a.f13718a;
                    if (objG == aVar) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
            default:
                int i11 = this.f10983b;
                if (i11 == 0) {
                    s6.a.e(obj);
                    h5.f fVar = this.f10985d;
                    String str = fVar.f8538s;
                    a4 a4Var2 = this.f10984c;
                    w2.r rVar2 = new w2.r(a4Var2, (String) null, str, new z3(a4Var2, fVar));
                    this.f10983b = 1;
                    Object objX = rVar2.x(this);
                    x6.a aVar2 = x6.a.f13718a;
                    if (objX == aVar2) {
                        break;
                    }
                } else if (i11 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                }
                break;
        }
        return s6.w.f12711a;
    }
}

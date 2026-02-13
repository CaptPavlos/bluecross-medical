package u7;

/* loaded from: classes3.dex */
public final class a0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12974a;

    /* renamed from: b, reason: collision with root package name */
    public int f12975b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e5.e0 f12976c;

    /* renamed from: d, reason: collision with root package name */
    public Object f12977d;
    public i e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(e5.e0 e0Var, w6.c cVar) {
        super(cVar);
        this.f12976c = e0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12974a = obj;
        this.f12975b |= Integer.MIN_VALUE;
        return this.f12976c.emit(null, this);
    }
}

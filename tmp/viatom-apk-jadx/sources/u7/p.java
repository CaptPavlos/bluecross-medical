package u7;

/* loaded from: classes3.dex */
public final class p extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13037a;

    /* renamed from: b, reason: collision with root package name */
    public int f13038b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f13039c;

    /* renamed from: d, reason: collision with root package name */
    public o f13040d;
    public i e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(o oVar, w6.c cVar) {
        super(cVar);
        this.f13039c = oVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13037a = obj;
        this.f13038b |= Integer.MIN_VALUE;
        return this.f13039c.collect(null, this);
    }
}

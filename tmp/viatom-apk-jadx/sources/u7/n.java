package u7;

/* loaded from: classes3.dex */
public final class n extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13028a;

    /* renamed from: b, reason: collision with root package name */
    public int f13029b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f13030c;

    /* renamed from: d, reason: collision with root package name */
    public o f13031d;
    public i e;
    public v7.l f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, w6.c cVar) {
        super(cVar);
        this.f13030c = oVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13028a = obj;
        this.f13029b |= Integer.MIN_VALUE;
        return this.f13030c.collect(null, this);
    }
}

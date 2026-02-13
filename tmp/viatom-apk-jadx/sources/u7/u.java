package u7;

/* loaded from: classes3.dex */
public final class u extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13056a;

    /* renamed from: b, reason: collision with root package name */
    public int f13057b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f13058c;

    /* renamed from: d, reason: collision with root package name */
    public e5.e0 f13059d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(o oVar, w6.c cVar) {
        super(cVar);
        this.f13058c = oVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13056a = obj;
        this.f13057b |= Integer.MIN_VALUE;
        return this.f13058c.collect(null, this);
    }
}

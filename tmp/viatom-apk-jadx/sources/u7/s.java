package u7;

/* loaded from: classes3.dex */
public final class s extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13048a;

    /* renamed from: b, reason: collision with root package name */
    public int f13049b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f13050c;

    /* renamed from: d, reason: collision with root package name */
    public o f13051d;
    public i e;
    public Throwable f;
    public long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(o oVar, w6.c cVar) {
        super(cVar);
        this.f13050c = oVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13048a = obj;
        this.f13049b |= Integer.MIN_VALUE;
        return this.f13050c.collect(null, this);
    }
}

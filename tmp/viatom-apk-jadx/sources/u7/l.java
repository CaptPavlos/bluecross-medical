package u7;

/* loaded from: classes3.dex */
public final class l extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13017a;

    /* renamed from: b, reason: collision with root package name */
    public int f13018b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f13019c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13020d;
    public i e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, w6.c cVar) {
        super(cVar);
        this.f13019c = mVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13017a = obj;
        this.f13018b |= Integer.MIN_VALUE;
        return this.f13019c.collect(null, this);
    }
}

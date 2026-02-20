package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public n f8160a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8161b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f8162c;

    /* renamed from: d, reason: collision with root package name */
    public int f8163d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(n nVar, y6.c cVar) {
        super(cVar);
        this.f8162c = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8161b = obj;
        this.f8163d |= Integer.MIN_VALUE;
        return this.f8162c.c(0, this);
    }
}

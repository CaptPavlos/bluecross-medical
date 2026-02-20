package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public d5.n f8132a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8133b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d5.n f8134c;

    /* renamed from: d, reason: collision with root package name */
    public int f8135d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d5.n nVar, y6.c cVar) {
        super(cVar);
        this.f8134c = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8133b = obj;
        this.f8135d |= Integer.MIN_VALUE;
        return this.f8134c.a(this);
    }
}

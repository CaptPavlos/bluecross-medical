package d3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public j f6821a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f6822b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f6823c;

    /* renamed from: d, reason: collision with root package name */
    public int f6824d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, y6.c cVar) {
        super(cVar);
        this.f6823c = jVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f6822b = obj;
        this.f6824d |= Integer.MIN_VALUE;
        return this.f6823c.b(this);
    }
}

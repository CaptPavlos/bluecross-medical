package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public p f8172a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8173b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f8174c;

    /* renamed from: d, reason: collision with root package name */
    public int f8175d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p pVar, y6.c cVar) {
        super(cVar);
        this.f8174c = pVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8173b = obj;
        this.f8175d |= Integer.MIN_VALUE;
        return this.f8174c.a(this);
    }
}

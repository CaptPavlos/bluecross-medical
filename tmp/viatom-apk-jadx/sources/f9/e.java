package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public d5.n f8136a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8137b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d5.n f8138c;

    /* renamed from: d, reason: collision with root package name */
    public int f8139d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d5.n nVar, y6.c cVar) {
        super(cVar);
        this.f8138c = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8137b = obj;
        this.f8139d |= Integer.MIN_VALUE;
        return this.f8138c.d(this);
    }
}

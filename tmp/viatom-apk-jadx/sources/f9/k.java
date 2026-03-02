package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8157a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f8158b;

    /* renamed from: c, reason: collision with root package name */
    public int f8159c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n nVar, y6.c cVar) {
        super(cVar);
        this.f8158b = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8157a = obj;
        this.f8159c |= Integer.MIN_VALUE;
        return this.f8158b.b(0, this);
    }
}

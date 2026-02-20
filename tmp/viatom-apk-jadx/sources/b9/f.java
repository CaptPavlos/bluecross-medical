package b9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f877b;

    /* renamed from: c, reason: collision with root package name */
    public int f878c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, y6.c cVar) {
        super(cVar);
        this.f877b = hVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f876a = obj;
        this.f878c |= Integer.MIN_VALUE;
        return this.f877b.c(0, null, null, this);
    }
}

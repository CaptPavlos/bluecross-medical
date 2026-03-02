package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f28a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f29b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z f30c;

    /* renamed from: d, reason: collision with root package name */
    public int f31d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(z zVar, y6.c cVar) {
        super(cVar);
        this.f30c = zVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f29b = obj;
        this.f31d |= Integer.MIN_VALUE;
        return this.f30c.a(null, this);
    }
}

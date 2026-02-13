package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public n f8153a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8154b;

    /* renamed from: c, reason: collision with root package name */
    public int f8155c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f8156d;
    public final /* synthetic */ n e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n nVar, y6.c cVar) {
        super(cVar);
        this.e = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8156d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(0, this);
    }
}

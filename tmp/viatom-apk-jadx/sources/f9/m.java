package f9;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public n f8164a;

    /* renamed from: b, reason: collision with root package name */
    public String f8165b;

    /* renamed from: c, reason: collision with root package name */
    public int f8166c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f8167d;
    public final /* synthetic */ n e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, y6.c cVar) {
        super(cVar);
        this.e = nVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8167d = obj;
        this.f |= Integer.MIN_VALUE;
        return this.e.d(0, this);
    }
}

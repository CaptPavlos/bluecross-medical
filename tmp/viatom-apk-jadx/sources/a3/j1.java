package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public String f110a;

    /* renamed from: b, reason: collision with root package name */
    public h1 f111b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f112c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ k1 f113d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(k1 k1Var, w6.c cVar) {
        super(cVar);
        this.f113d = k1Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f112c = obj;
        this.e |= Integer.MIN_VALUE;
        return k1.a(this.f113d, null, null, this);
    }
}

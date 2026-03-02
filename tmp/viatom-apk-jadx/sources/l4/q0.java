package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a3.f1 f10748b;

    /* renamed from: c, reason: collision with root package name */
    public int f10749c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(a3.f1 f1Var, w6.c cVar) {
        super(cVar);
        this.f10748b = f1Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10747a = obj;
        this.f10749c |= Integer.MIN_VALUE;
        return this.f10748b.a(null, this);
    }
}

package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public v7.l f12970a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12971b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e0 f12972c;

    /* renamed from: d, reason: collision with root package name */
    public int f12973d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e0 e0Var, w6.c cVar) {
        super(cVar);
        this.f12972c = e0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12971b = obj;
        this.f12973d |= Integer.MIN_VALUE;
        return this.f12972c.collect(null, this);
    }
}

package e5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f7897a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7898b;

    /* renamed from: c, reason: collision with root package name */
    public int f7899c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(j0 j0Var, y6.c cVar) {
        super(cVar);
        this.f7898b = j0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f7897a = obj;
        this.f7899c |= Integer.MIN_VALUE;
        return j0.a(this.f7898b, this);
    }
}

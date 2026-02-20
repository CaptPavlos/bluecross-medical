package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public y0 f184a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f185b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y0 f186c;

    /* renamed from: d, reason: collision with root package name */
    public int f187d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(y0 y0Var, y6.c cVar) {
        super(cVar);
        this.f186c = y0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f185b = obj;
        this.f187d |= Integer.MIN_VALUE;
        return y0.a(this.f186c, this);
    }
}

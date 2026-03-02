package s4;

import c1.g1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12535a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g1 f12536b;

    /* renamed from: c, reason: collision with root package name */
    public int f12537c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g1 g1Var, y6.c cVar) {
        super(cVar);
        this.f12536b = g1Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12535a = obj;
        this.f12537c |= Integer.MIN_VALUE;
        return this.f12536b.b(null, this);
    }
}

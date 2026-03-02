package f9;

import a3.z0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8124a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f8125b;

    /* renamed from: c, reason: collision with root package name */
    public int f8126c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(z0 z0Var, y6.c cVar) {
        super(cVar);
        this.f8125b = z0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8124a = obj;
        this.f8126c |= Integer.MIN_VALUE;
        return this.f8125b.h(this);
    }
}

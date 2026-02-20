package e9;

import c1.d0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f7985a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f7986b;

    /* renamed from: c, reason: collision with root package name */
    public int f7987c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d0 d0Var, y6.c cVar) {
        super(cVar);
        this.f7986b = d0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f7985a = obj;
        this.f7987c |= Integer.MIN_VALUE;
        return this.f7986b.j(null, null, this);
    }
}

package e9;

import c1.d0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f7982a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f7983b;

    /* renamed from: c, reason: collision with root package name */
    public int f7984c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d0 d0Var, y6.c cVar) {
        super(cVar);
        this.f7983b = d0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f7982a = obj;
        this.f7984c |= Integer.MIN_VALUE;
        return this.f7983b.m(null, this);
    }
}

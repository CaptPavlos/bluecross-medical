package f9;

import a3.z0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public z0 f8141a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8142b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z0 f8143c;

    /* renamed from: d, reason: collision with root package name */
    public int f8144d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(z0 z0Var, y6.c cVar) {
        super(cVar);
        this.f8143c = z0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8142b = obj;
        this.f8144d |= Integer.MIN_VALUE;
        return this.f8143c.g(this);
    }
}

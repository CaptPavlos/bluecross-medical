package f9;

import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public r f8149a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8150b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f8151c;

    /* renamed from: d, reason: collision with root package name */
    public int f8152d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(r rVar, y6.c cVar) {
        super(cVar);
        this.f8151c = rVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8150b = obj;
        this.f8152d |= Integer.MIN_VALUE;
        return this.f8151c.a(this);
    }
}

package f9;

import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public r f8127a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f8128b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f8129c;

    /* renamed from: d, reason: collision with root package name */
    public int f8130d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(r rVar, y6.c cVar) {
        super(cVar);
        this.f8129c = rVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f8128b = obj;
        this.f8130d |= Integer.MIN_VALUE;
        return this.f8129c.a(this);
    }
}

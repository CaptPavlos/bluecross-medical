package u7;

import r7.a1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l0 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public m0 f13021a;

    /* renamed from: b, reason: collision with root package name */
    public i f13022b;

    /* renamed from: c, reason: collision with root package name */
    public n0 f13023c;

    /* renamed from: d, reason: collision with root package name */
    public a1 f13024d;
    public Object e;
    public /* synthetic */ Object f;
    public final /* synthetic */ m0 g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(m0 m0Var, w6.c cVar) {
        super(cVar);
        this.g = m0Var;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f = obj;
        this.h |= Integer.MIN_VALUE;
        this.g.collect(null, this);
        return x6.a.f13718a;
    }
}

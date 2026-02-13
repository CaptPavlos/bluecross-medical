package x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public int f13600a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13601b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t3.h f13602c;

    /* renamed from: d, reason: collision with root package name */
    public int f13603d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(t3.h hVar, y6.c cVar) {
        super(cVar);
        this.f13602c = hVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13601b = obj;
        this.f13603d |= Integer.MIN_VALUE;
        return this.f13602c.h(null, null, null, null, this);
    }
}

package l4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class fa extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public v5.l f10403a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10404b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ da f10405c;

    /* renamed from: d, reason: collision with root package name */
    public int f10406d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(da daVar, w6.c cVar) {
        super(cVar);
        this.f10405c = daVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10404b = obj;
        this.f10406d |= Integer.MIN_VALUE;
        return this.f10405c.a(null, this);
    }
}

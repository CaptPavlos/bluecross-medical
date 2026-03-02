package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public t7.s f12978a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f12979b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f12980c;

    /* renamed from: d, reason: collision with root package name */
    public int f12981d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, y6.c cVar2) {
        super(cVar2);
        this.f12980c = cVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12979b = obj;
        this.f12981d |= Integer.MIN_VALUE;
        return this.f12980c.c(null, this);
    }
}

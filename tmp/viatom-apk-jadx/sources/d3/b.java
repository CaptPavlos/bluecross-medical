package d3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f6804a;

    /* renamed from: b, reason: collision with root package name */
    public a8.a f6805b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f6806c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f6807d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar, y6.c cVar2) {
        super(cVar2);
        this.f6807d = cVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f6806c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.f6807d.d(this);
    }
}

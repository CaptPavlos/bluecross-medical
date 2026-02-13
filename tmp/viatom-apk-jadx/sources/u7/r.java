package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public f f13044a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f13045b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f13046c;

    /* renamed from: d, reason: collision with root package name */
    public int f13047d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(f fVar, w6.c cVar) {
        super(cVar);
        this.f13046c = fVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13045b = obj;
        this.f13047d |= Integer.MIN_VALUE;
        return this.f13046c.emit(null, this);
    }
}

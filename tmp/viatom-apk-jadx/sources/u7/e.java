package u7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12987a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f12988b;

    /* renamed from: c, reason: collision with root package name */
    public int f12989c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, w6.c cVar) {
        super(cVar);
        this.f12988b = fVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12987a = obj;
        this.f12989c |= Integer.MIN_VALUE;
        return this.f12988b.emit(null, this);
    }
}

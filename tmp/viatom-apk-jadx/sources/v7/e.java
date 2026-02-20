package v7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f13180a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f13181b;

    /* renamed from: c, reason: collision with root package name */
    public int f13182c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, w6.c cVar) {
        super(cVar);
        this.f13181b = fVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f13180a = obj;
        this.f13182c |= Integer.MIN_VALUE;
        return this.f13181b.emit(null, this);
    }
}

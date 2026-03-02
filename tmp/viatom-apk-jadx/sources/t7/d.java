package t7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12823a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f12824b;

    /* renamed from: c, reason: collision with root package name */
    public int f12825c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, y6.c cVar) {
        super(cVar);
        this.f12824b = eVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12823a = obj;
        this.f12825c |= Integer.MIN_VALUE;
        Object objD = this.f12824b.D(null, 0, 0L, this);
        return objD == x6.a.f13718a ? objD : new l(objD);
    }
}

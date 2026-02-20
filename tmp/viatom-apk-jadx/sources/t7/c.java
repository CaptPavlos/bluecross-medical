package t7;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f12820a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f12821b;

    /* renamed from: c, reason: collision with root package name */
    public int f12822c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, y6.c cVar) {
        super(cVar);
        this.f12821b = eVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f12820a = obj;
        this.f12822c |= Integer.MIN_VALUE;
        Object objC = e.C(this.f12821b, this);
        return objC == x6.a.f13718a ? objC : new l(objC);
    }
}

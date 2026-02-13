package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final h f76a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f77b = j2.c.a("eventType");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f78c = j2.c.a("sessionData");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f79d = j2.c.a("applicationInfo");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        u0 u0Var = (u0) obj;
        j2.e eVar = (j2.e) obj2;
        u0Var.getClass();
        eVar.a(f77b, n.SESSION_START);
        eVar.a(f78c, u0Var.f165a);
        eVar.a(f79d, u0Var.f166b);
    }
}

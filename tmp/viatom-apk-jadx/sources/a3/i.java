package a3;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final i f85a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f86b = j2.c.a("sessionId");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f87c = j2.c.a("firstSessionId");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f88d = j2.c.a("sessionIndex");
    public static final j2.c e = j2.c.a("eventTimestampUs");
    public static final j2.c f = j2.c.a("dataCollectionStatus");
    public static final j2.c g = j2.c.a("firebaseInstallationId");
    public static final j2.c h = j2.c.a("firebaseAuthenticationToken");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        c1 c1Var = (c1) obj;
        j2.e eVar = (j2.e) obj2;
        eVar.a(f86b, c1Var.f40a);
        eVar.a(f87c, c1Var.f41b);
        eVar.d(f88d, c1Var.f42c);
        eVar.e(e, c1Var.f43d);
        eVar.a(f, c1Var.e);
        eVar.a(g, c1Var.f);
        eVar.a(h, c1Var.g);
    }
}

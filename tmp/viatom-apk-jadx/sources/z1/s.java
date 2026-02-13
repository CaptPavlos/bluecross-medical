package z1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final s f14345a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14346b = j2.c.a("batteryLevel");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14347c = j2.c.a("batteryVelocity");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14348d = j2.c.a("proximityOn");
    public static final j2.c e = j2.c.a("orientation");
    public static final j2.c f = j2.c.a("ramUsed");
    public static final j2.c g = j2.c.a("diskUsed");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        b1 b1Var = (b1) ((e2) obj);
        eVar.a(f14346b, b1Var.f14169a);
        eVar.d(f14347c, b1Var.f14170b);
        eVar.g(f14348d, b1Var.f14171c);
        eVar.d(e, b1Var.f14172d);
        eVar.e(f, b1Var.e);
        eVar.e(g, b1Var.f);
    }
}

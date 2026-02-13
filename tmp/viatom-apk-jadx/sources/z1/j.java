package z1;

import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final j f14251a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14252b = j2.c.a("generator");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14253c = j2.c.a("identifier");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14254d = j2.c.a("appQualitySessionId");
    public static final j2.c e = j2.c.a("startedAt");
    public static final j2.c f = j2.c.a("endedAt");
    public static final j2.c g = j2.c.a("crashed");
    public static final j2.c h = j2.c.a(MBridgeConstans.DYNAMIC_VIEW_WX_APP);

    /* renamed from: i, reason: collision with root package name */
    public static final j2.c f14255i = j2.c.a("user");

    /* renamed from: j, reason: collision with root package name */
    public static final j2.c f14256j = j2.c.a("os");

    /* renamed from: k, reason: collision with root package name */
    public static final j2.c f14257k = j2.c.a("device");

    /* renamed from: l, reason: collision with root package name */
    public static final j2.c f14258l = j2.c.a("events");

    /* renamed from: m, reason: collision with root package name */
    public static final j2.c f14259m = j2.c.a("generatorType");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        j0 j0Var = (j0) ((m2) obj);
        eVar.a(f14252b, j0Var.f14260a);
        eVar.a(f14253c, j0Var.f14261b.getBytes(n2.f14312a));
        eVar.a(f14254d, j0Var.f14262c);
        eVar.e(e, j0Var.f14263d);
        eVar.a(f, j0Var.e);
        eVar.g(g, j0Var.f);
        eVar.a(h, j0Var.g);
        eVar.a(f14255i, j0Var.h);
        eVar.a(f14256j, j0Var.f14264i);
        eVar.a(f14257k, j0Var.f14265j);
        eVar.a(f14258l, j0Var.f14266k);
        eVar.d(f14259m, j0Var.f14267l);
    }
}

package z1;

import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final i f14232a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14233b = j2.c.a("arch");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14234c = j2.c.a("model");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14235d = j2.c.a("cores");
    public static final j2.c e = j2.c.a("ram");
    public static final j2.c f = j2.c.a("diskSpace");
    public static final j2.c g = j2.c.a("simulator");
    public static final j2.c h = j2.c.a(MRAIDCommunicatorUtil.KEY_STATE);

    /* renamed from: i, reason: collision with root package name */
    public static final j2.c f14236i = j2.c.a("manufacturer");

    /* renamed from: j, reason: collision with root package name */
    public static final j2.c f14237j = j2.c.a("modelClass");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        n0 n0Var = (n0) ((v1) obj);
        eVar.d(f14233b, n0Var.f14306a);
        eVar.a(f14234c, n0Var.f14307b);
        eVar.d(f14235d, n0Var.f14308c);
        eVar.e(e, n0Var.f14309d);
        eVar.e(f, n0Var.e);
        eVar.g(g, n0Var.f);
        eVar.d(h, n0Var.g);
        eVar.a(f14236i, n0Var.h);
        eVar.a(f14237j, n0Var.f14310i);
    }
}

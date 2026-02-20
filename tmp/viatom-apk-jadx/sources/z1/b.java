package z1;

import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14155a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14156b = j2.c.a("pid");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14157c = j2.c.a("processName");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14158d = j2.c.a("reasonCode");
    public static final j2.c e = j2.c.a("importance");
    public static final j2.c f = j2.c.a("pss");
    public static final j2.c g = j2.c.a("rss");
    public static final j2.c h = j2.c.a(CampaignEx.JSON_KEY_TIMESTAMP);

    /* renamed from: i, reason: collision with root package name */
    public static final j2.c f14159i = j2.c.a("traceFile");

    /* renamed from: j, reason: collision with root package name */
    public static final j2.c f14160j = j2.c.a("buildIdMappingForArch");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        d0 d0Var = (d0) ((p1) obj);
        eVar.d(f14156b, d0Var.f14192a);
        eVar.a(f14157c, d0Var.f14193b);
        eVar.d(f14158d, d0Var.f14194c);
        eVar.d(e, d0Var.f14195d);
        eVar.e(f, d0Var.e);
        eVar.e(g, d0Var.f);
        eVar.e(h, d0Var.g);
        eVar.a(f14159i, d0Var.h);
        eVar.a(f14160j, d0Var.f14196i);
    }
}

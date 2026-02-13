package z1;

import com.mbridge.msdk.foundation.entity.RewardPlus;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final l f14280a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14281b = j2.c.a("baseAddress");

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14282c = j2.c.a("size");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14283d = j2.c.a(RewardPlus.NAME);
    public static final j2.c e = j2.c.a("uuid");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        s0 s0Var = (s0) ((w1) obj);
        eVar.e(f14281b, s0Var.f14349a);
        eVar.e(f14282c, s0Var.f14350b);
        eVar.a(f14283d, s0Var.f14351c);
        String str = s0Var.f14352d;
        eVar.a(e, str != null ? str.getBytes(n2.f14312a) : null);
    }
}

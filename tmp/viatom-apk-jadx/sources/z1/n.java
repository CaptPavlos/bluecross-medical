package z1;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final n f14302a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14303b = j2.c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14304c = j2.c.a("reason");

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14305d = j2.c.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_FRAME_ADS);
    public static final j2.c e = j2.c.a("causedBy");
    public static final j2.c f = j2.c.a("overflowCount");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        t0 t0Var = (t0) ((x1) obj);
        eVar.a(f14303b, t0Var.f14357a);
        eVar.a(f14304c, t0Var.f14358b);
        eVar.a(f14305d, t0Var.f14359c);
        eVar.a(e, t0Var.f14360d);
        eVar.d(f, t0Var.e);
    }
}

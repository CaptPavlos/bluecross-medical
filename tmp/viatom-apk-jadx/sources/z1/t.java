package z1;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t implements j2.d {

    /* renamed from: a, reason: collision with root package name */
    public static final t f14353a = new t();

    /* renamed from: b, reason: collision with root package name */
    public static final j2.c f14354b = j2.c.a(CampaignEx.JSON_KEY_TIMESTAMP);

    /* renamed from: c, reason: collision with root package name */
    public static final j2.c f14355c = j2.c.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);

    /* renamed from: d, reason: collision with root package name */
    public static final j2.c f14356d = j2.c.a(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
    public static final j2.c e = j2.c.a("device");
    public static final j2.c f = j2.c.a("log");
    public static final j2.c g = j2.c.a("rollouts");

    @Override // j2.a
    public final void a(Object obj, Object obj2) {
        j2.e eVar = (j2.e) obj2;
        p0 p0Var = (p0) ((j2) obj);
        eVar.e(f14354b, p0Var.f14325a);
        eVar.a(f14355c, p0Var.f14326b);
        eVar.a(f14356d, p0Var.f14327c);
        eVar.a(e, p0Var.f14328d);
        eVar.a(f, p0Var.e);
        eVar.a(g, p0Var.f);
    }
}

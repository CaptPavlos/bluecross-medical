package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.tracker.network.w;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends i<String> implements w.a {

    /* renamed from: b, reason: collision with root package name */
    private final k<String> f5415b;

    public l(int i10, String str, String str2, long j10, k<String> kVar) {
        super(i10, str, 0, str2, j10);
        this.f5415b = kVar;
        a((w.a) this);
    }

    private void b(w<String> wVar) {
        k<String> kVar = this.f5415b;
        if (kVar != null) {
            try {
                kVar.b(this, wVar, wVar.f5496c.f5383a);
            } catch (Exception e) {
                af.b(i.f5410a, "parseNetworkResponse error: ", e);
            }
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final w<String> a(r rVar) {
        try {
            w<String> wVarA = w.a(new String(rVar.f5444b, StandardCharsets.UTF_8), com.mbridge.msdk.tracker.network.toolbox.f.a(rVar));
            k<String> kVar = this.f5415b;
            if (kVar != null) {
                try {
                    kVar.a(this, wVarA, rVar);
                    return wVarA;
                } catch (Exception e) {
                    af.b(i.f5410a, "parseNetworkResponse error: ", e);
                }
            }
            return wVarA;
        } catch (Throwable th) {
            af.b(i.f5410a, "parseNetworkResponse error: ", th);
            w<String> wVarA2 = w.a(new ac(th));
            b(wVarA2);
            return wVarA2;
        }
    }

    @Override // com.mbridge.msdk.tracker.network.u
    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    @Override // com.mbridge.msdk.tracker.network.w.a
    public final void a(ad adVar) {
        b(w.a(adVar));
    }
}

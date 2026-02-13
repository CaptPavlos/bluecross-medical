package com.mbridge.msdk.newreward.a;

import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends a implements b {

    /* renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.a.a f4626b;

    public g(com.mbridge.msdk.newreward.function.command.c cVar) {
        super(cVar);
    }

    @Override // com.mbridge.msdk.newreward.a.b
    public final void a(e eVar) {
        com.mbridge.msdk.newreward.a.a.b bVar = new com.mbridge.msdk.newreward.a.a.b(this.f4510a);
        this.f4626b = bVar;
        bVar.a(eVar);
    }

    @Override // com.mbridge.msdk.newreward.a.b
    public final void b(e eVar) {
        if (com.mbridge.msdk.e.b.a()) {
            this.f4510a.a(eVar);
            return;
        }
        try {
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        if (eVar.D().b().C() == 501) {
            this.f4510a.a(eVar);
            return;
        }
        if (eVar.D().b().o() == 5002010) {
            this.f4510a.a(eVar);
            return;
        }
        boolean zA = com.mbridge.msdk.foundation.same.b.a().a("new_bridge_reward_show");
        com.mbridge.msdk.newreward.function.command.c cVar = this.f4510a;
        if (zA) {
            cVar.a(eVar, "NewShowReceiver");
        } else {
            cVar.a(eVar);
        }
    }
}

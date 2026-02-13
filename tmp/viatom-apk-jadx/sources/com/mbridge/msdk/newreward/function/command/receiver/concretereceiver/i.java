package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.af;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements com.mbridge.msdk.newreward.function.command.receiver.a {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.foundation.c.b f4864a;

    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        if (bVar == null || bVar.b() == null) {
            a(bVar2, new com.mbridge.msdk.foundation.c.b(-1, "command or object is null"));
            return;
        }
        try {
            Map map = (Map) bVar.b();
            this.f4864a = (com.mbridge.msdk.foundation.c.b) map.get("reason");
            com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) map.get("adapter_model");
            com.mbridge.msdk.newreward.function.command.c cVar = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            map.put("candidate_type", 0);
            map.put("scene", 2);
            com.mbridge.msdk.newreward.function.a.b bVar3 = (com.mbridge.msdk.newreward.function.a.b) cVar.b(map);
            if (!com.mbridge.msdk.newreward.function.h.c.c(eVar.J())) {
                a(bVar2, this.f4864a);
                return;
            }
            eVar.b(true);
            if (bVar3 == null) {
                a(bVar2, this.f4864a);
                return;
            }
            if (bVar3.h() != com.mbridge.msdk.newreward.function.a.b.f4649d) {
                a(bVar2, new com.mbridge.msdk.foundation.c.b(bVar3.g(), bVar3.b()));
                return;
            }
            eVar.D().a(bVar3.a());
            if (bVar2 != null) {
                try {
                    bVar2.reqSuccessful(bVar3.a());
                } catch (Exception e) {
                    af.b("SmartLoadReceiver", "handlerCandidateSuccess", e);
                }
            }
        } catch (Exception e3) {
            af.b("SmartLoadReceiver", "action", e3);
            if (bVar2 != null) {
                com.mbridge.msdk.foundation.c.b bVar4 = this.f4864a;
                if (bVar4 == null) {
                    a(bVar2, new com.mbridge.msdk.foundation.c.b(-1, "SmartLoadReceiver action exception"));
                } else {
                    a(bVar2, bVar4);
                }
            }
        }
    }

    private static void a(com.mbridge.msdk.newreward.a.b.b bVar, com.mbridge.msdk.foundation.c.b bVar2) {
        if (bVar != null) {
            try {
                bVar.reqFailed(bVar2);
            } catch (Exception e) {
                af.b("SmartLoadReceiver", "handlerCandidateFailed", e);
            }
        }
    }
}

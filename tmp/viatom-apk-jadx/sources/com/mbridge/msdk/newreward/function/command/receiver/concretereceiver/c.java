package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.af;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements com.mbridge.msdk.newreward.function.command.receiver.e {

    /* renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.e.b f4834a;

    public final Object a(Object obj) {
        com.mbridge.msdk.newreward.b.b bVar;
        com.mbridge.msdk.newreward.function.command.c cVar;
        com.mbridge.msdk.newreward.a.d dVar;
        if (this.f4834a != null || obj == null) {
            return null;
        }
        try {
            Map map = (Map) obj;
            bVar = (com.mbridge.msdk.newreward.b.b) map.get("controller_model");
            cVar = (com.mbridge.msdk.newreward.function.command.c) map.get("command_manager");
            dVar = (com.mbridge.msdk.newreward.a.d) map.get("adapter_manager");
        } catch (Exception e) {
            af.b("LoadCheckReceiver", "action", e);
        }
        if (bVar != null && cVar != null && dVar != null) {
            com.mbridge.msdk.newreward.function.e.b bVar2 = new com.mbridge.msdk.newreward.function.e.b(bVar.e(), bVar.d(), bVar.c(), bVar.f());
            this.f4834a = bVar2;
            bVar2.a(cVar, dVar);
            return null;
        }
        return null;
    }
}

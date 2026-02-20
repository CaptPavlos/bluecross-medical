package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j implements com.mbridge.msdk.newreward.function.command.receiver.a {
    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(final com.mbridge.msdk.newreward.function.command.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        MBridgeTaskManager.commonExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.j.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.mbridge.msdk.video.bt.module.b.f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (String) ((Map) bVar.b()).get("mb_ad_unit_id"));
                    ad.a();
                    ad.a(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES));
                    ad.a(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML));
                } catch (Exception unused) {
                }
            }
        });
    }
}

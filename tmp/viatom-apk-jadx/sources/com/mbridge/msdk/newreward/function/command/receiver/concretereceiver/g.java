package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements com.mbridge.msdk.newreward.function.command.receiver.a {
    @Override // com.mbridge.msdk.newreward.function.command.receiver.a
    public final void a(com.mbridge.msdk.newreward.function.command.b bVar, final com.mbridge.msdk.newreward.a.b.b bVar2) {
        try {
            Map map = (Map) bVar.b();
            int iIntValue = ((Integer) map.get("mb_ad_type")).intValue();
            String str = (String) map.get("mb_ad_pid");
            String str2 = (String) map.get("mb_ad_unit_id");
            com.mbridge.msdk.newreward.function.d.c.a().b().a(iIntValue, str, str2, ((Boolean) map.get("mb_ad_is_header_bidding")).booleanValue(), MBridgeSharedPreferenceModel.getInstance().getInteger("vcn_" + str2, 1), new com.mbridge.msdk.newreward.function.d.b() { // from class: com.mbridge.msdk.newreward.function.command.receiver.concretereceiver.g.1
                @Override // com.mbridge.msdk.newreward.function.d.b
                public final void a() {
                    try {
                        com.mbridge.msdk.newreward.a.b.b bVar3 = bVar2;
                        if (bVar3 != null) {
                            bVar3.reqFailed(new com.mbridge.msdk.foundation.c.b(880040, "no cached campaign in db"));
                        }
                    } catch (Exception e) {
                        af.b("RestoreFromDBReceiver", "action", e);
                    }
                }

                @Override // com.mbridge.msdk.newreward.function.d.b
                public final void a(List<com.mbridge.msdk.newreward.function.c.a.b> list) {
                    try {
                        com.mbridge.msdk.newreward.a.b.b bVar3 = bVar2;
                        if (bVar3 != null) {
                            bVar3.reqSuccessful(list);
                        }
                    } catch (Exception e) {
                        af.b("RestoreFromDBReceiver", "action", e);
                    }
                }
            });
        } catch (Exception e) {
            af.b("RestoreFromDBReceiver", "action", e);
        }
    }
}

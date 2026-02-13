package com.mbridge.msdk.newreward.function.command.receiver.concretereceiver;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements com.mbridge.msdk.newreward.function.command.receiver.b {
    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) {
        try {
            Map map = (Map) obj;
            com.mbridge.msdk.newreward.function.command.e eVar = (com.mbridge.msdk.newreward.function.command.e) map.get("result");
            Map map2 = (Map) map.get("obj_map");
            String str = (String) map.get(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int iHashCode = str.hashCode();
            if (iHashCode == -2057274110) {
                if (str.equals("bridge_ids") && !a("bridge_ids", eVar, map2)) {
                    MBridgeIds mBridgeIds = new MBridgeIds((String) map.get("mb_ad_pid"), (String) map.get("mb_ad_unit_id"));
                    map2.put("bridge_ids", mBridgeIds);
                    eVar.a(mBridgeIds);
                    return;
                }
                return;
            }
            if (iHashCode == -1019779949) {
                if (str.equals(TypedValues.CycleType.S_WAVE_OFFSET) && !a(TypedValues.CycleType.S_WAVE_OFFSET, eVar, map2)) {
                    MBridgeOffsetManager mBridgeOffsetManager = new MBridgeOffsetManager();
                    map2.put(TypedValues.CycleType.S_WAVE_OFFSET, mBridgeOffsetManager);
                    eVar.a(mBridgeOffsetManager);
                    return;
                }
                return;
            }
            if (iHashCode == 95346201 && str.equals("daily") && !a("daily", eVar, map2)) {
                MBridgeDailyPlayModel mBridgeDailyPlayModel = new MBridgeDailyPlayModel(((Integer) map.get("mb_ad_type")).intValue(), (String) map.get("mb_ad_pid"), (String) map.get("mb_ad_unit_id"));
                map2.put("daily", mBridgeDailyPlayModel);
                eVar.a(mBridgeDailyPlayModel);
            }
        } catch (Exception e) {
            af.b("CreateObjectReceiver", "action", e);
        }
    }

    private boolean a(String str, com.mbridge.msdk.newreward.function.command.e eVar, Map map) {
        if (map.get(str) == null) {
            return false;
        }
        eVar.a(map.get(str));
        return true;
    }
}

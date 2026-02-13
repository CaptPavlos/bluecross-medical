package com.mbridge.msdk.newreward.function.command.receiver.tagreceiver;

import android.text.TextUtils;
import com.mbridge.apt_anotation.ReceiverAction;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.function.command.receiver.b;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.newreward.function.h.c;
import java.io.File;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ReceiverAction(id = "SharePreReceiver", type = b.class)
/* loaded from: classes3.dex */
public class SharePreReceiver implements b {
    @Override // com.mbridge.msdk.newreward.function.command.receiver.b
    public final void a(Object obj) throws Throwable {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (2 != (map.get("resource_type") instanceof Integer ? ((Integer) map.get("resource_type")).intValue() : -1)) {
                return;
            }
            String str = map.get("metrics_config_path") instanceof String ? (String) map.get("metrics_config_path") : "";
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                String strA = c.a(new File(str));
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                MBridgeSharedPreferenceModel.getInstance().putString(MBridgeConstans.SP_DYNAMIC_METRICS_REPORT, strA);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.mbridge.msdk.foundation.same.net.f;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h extends c {
    public h(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.foundation.same.net.f.c
    public void addExtraParams(String str, e eVar) {
        try {
            int iA = ak.a();
            String strC = ak.c();
            if (eVar != null) {
                eVar.a("misk_spt", String.valueOf(iA));
                if (!TextUtils.isEmpty(strC)) {
                    eVar.a("misk_spt_det", strC);
                }
            }
        } catch (Exception e) {
            af.a("CampaignRequest", e.getMessage());
        } finally {
            super.addExtraParams(str, eVar);
        }
    }
}

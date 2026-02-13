package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CampaignUnit extends b implements NoProGuard, Serializable {
    private static final String TAG = "CampaignUnit";

    @Override // com.mbridge.msdk.foundation.entity.b
    public String assembCParams() {
        String str;
        String strValueOf;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String strC = com.mbridge.msdk.foundation.tools.f.c();
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            String strL = ab.l(contextC);
            String strK = ab.k(contextC);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                strValueOf = String.valueOf(ab.m(contextC));
                str = ab.j(contextC) + "x" + ab.h(contextC);
            } else {
                str = "";
                strValueOf = str;
            }
            StringBuffer stringBuffer2 = this.cParams;
            stringBuffer2.append(getAdType());
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty("1"));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Build.VERSION.RELEASE));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(MBConfiguration.SDK_VERSION));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(ab.h()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(str));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(Integer.valueOf(ab.s(com.mbridge.msdk.foundation.controller.c.m().c()))));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(ab.t(com.mbridge.msdk.foundation.controller.c.m().c())));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(strValueOf));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(strK));
            stringBuffer2.append(nullToEmpty(strL));
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(strC));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(ab.x()));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append("");
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(""));
            stringBuffer2.append("|");
            stringBuffer2.append(nullToEmpty(com.mbridge.msdk.foundation.same.a.V + "," + com.mbridge.msdk.foundation.same.a.g));
            stringBuffer2.append("|");
            stringBuffer2.append(ab.i());
            stringBuffer2.append("|");
            this.cParams = stringBuffer2;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, th.getMessage(), th);
            }
        }
        return this.cParams.toString();
    }
}

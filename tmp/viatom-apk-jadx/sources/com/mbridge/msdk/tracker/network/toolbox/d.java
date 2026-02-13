package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {
    public static String a(String str, u<?> uVar) {
        if (TextUtils.isEmpty(str) || uVar == null) {
            return "";
        }
        byte[] bArrP = uVar.p();
        if (bArrP == null || bArrP.length == 0) {
            return str;
        }
        if (str.endsWith("?")) {
            return str.concat(new String(bArrP));
        }
        StringBuilder sbW = a3.a.w(str, "?");
        sbW.append(new String(bArrP));
        return sbW.toString();
    }
}

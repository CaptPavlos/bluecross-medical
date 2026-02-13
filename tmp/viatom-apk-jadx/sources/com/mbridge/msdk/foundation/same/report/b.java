package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f3778a = "DomainReport";

    public static boolean a(com.mbridge.msdk.c.g gVar, String str) {
        if (gVar != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    int iQ = gVar.Q();
                    JSONArray jSONArrayO = gVar.O();
                    JSONArray jSONArrayN = gVar.N();
                    if (jSONArrayN != null) {
                        for (int i10 = 0; i10 < jSONArrayN.length(); i10++) {
                            if (str.contains(jSONArrayN.getString(i10))) {
                                return false;
                            }
                        }
                    }
                    if (iQ == 2) {
                        if (jSONArrayO != null) {
                            for (int i11 = 0; i11 < jSONArrayO.length(); i11++) {
                                if (str.contains(jSONArrayO.getString(i11))) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
            } catch (Exception e) {
                af.b(f3778a, e.getMessage());
            }
        }
        return true;
    }
}

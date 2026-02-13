package com.mbridge.msdk.newreward.function.common;

import com.mbridge.msdk.newreward.function.c.b.b;
import com.mbridge.msdk.tracker.network.ad;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class VolleyErrorUtils {
    public static b parseVolleyError(ad adVar) {
        b bVar = new b(0);
        bVar.b("Network unknown error");
        if (adVar == null) {
            return bVar;
        }
        int iA = adVar.a();
        if (iA == 1) {
            adVar.a("Network error,please check state code " + adVar.b());
            bVar = new b(1);
        } else if (iA == 7) {
            adVar.a("The server returns an exception state code " + adVar.b());
            bVar = new b(2);
        } else if (iA == 2) {
            adVar.a("unSupportEncodingException");
            bVar = new b(8);
        } else if (iA == 8) {
            adVar.a("Network error,timeout exception");
            bVar = new b(4);
        } else if (iA == 3) {
            adVar.a("Network error,I/O exception");
            bVar = new b(3);
        } else if (iA == 4) {
            adVar.a(880041);
            adVar.a("Network error,UnknownHostException");
            bVar = new b(5);
        } else if (iA == 6) {
            adVar.a("Network error,I/O exception response null");
            bVar = new b(7);
        } else if (iA == 5) {
            adVar.a("Network error,I/O exception");
            bVar = new b(6);
        } else if (iA == 0) {
            adVar.a("Network error,I/O exception");
            bVar = new b(0);
        } else if (iA == 9) {
            adVar.a("Network unknown error");
            bVar = new b(1);
        }
        bVar.a(adVar);
        bVar.b(adVar.getMessage());
        return bVar;
    }
}

package com.mbridge.msdk.foundation.controller.authoritycontroller;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c extends b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f3377c;

    private c() {
        c();
    }

    public static c j() {
        if (f3377c == null) {
            synchronized (c.class) {
                try {
                    if (f3377c == null) {
                        f3377c = new c();
                    }
                } finally {
                }
            }
        }
        return f3377c;
    }

    public static boolean k() {
        return true;
    }

    @Override // com.mbridge.msdk.foundation.controller.authoritycontroller.b
    public final int b(String str) {
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return gVarS.aw();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return gVarS.av();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return gVarS.ax();
        }
        return -1;
    }

    public final boolean c(String str) {
        boolean z9;
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
            z9 = true;
        } else {
            z9 = false;
        }
        int iAk = gVarS.ak();
        boolean z10 = iAk != 0 ? iAk == 1 && b(str) == 1 : a(str) == 1 && b(str) == 1;
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z10 = a(str) == 1;
        }
        return (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) && j().g() == 2) ? (gVarS.aH() || z9 || a(str) != 1) ? false : true : z10;
    }

    public static void c(boolean z9) {
    }
}

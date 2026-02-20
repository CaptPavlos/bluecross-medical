package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f4040a;

    public static synchronized ConnectivityManager a() {
        try {
        } catch (Exception e) {
            af.b("NetManager", e.getMessage());
        }
        if (f4040a != null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
        } else {
            f4040a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.c.m().c().getSystemService("connectivity");
        }
        return f4040a;
    }
}

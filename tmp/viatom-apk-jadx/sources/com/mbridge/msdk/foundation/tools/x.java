package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x {
    public static int a(Context context, String str, String str2) {
        String packageName = "";
        try {
            try {
                packageName = com.mbridge.msdk.foundation.controller.c.m().g();
            } catch (Exception unused) {
                af.b("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + str);
            }
            if (ap.a(packageName) && context != null) {
                packageName = context.getPackageName();
            }
            if (ap.a(packageName) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, packageName);
        } catch (Exception unused2) {
            af.b("ResourceUtil", "Resource not found resName:" + str);
            return -1;
        }
    }

    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e) {
                androidx.constraintlayout.core.widgets.analyzer.a.D(e, new StringBuilder("Resource error:"), "ResourceUtil");
            }
        }
        return null;
    }
}

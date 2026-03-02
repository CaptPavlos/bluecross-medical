package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.base.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f4387a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Handler f4388b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f4389c;

    public static boolean a(final Context context) {
        g gVarA;
        try {
            gVarA = h.a().a(c.m().k());
        } catch (Exception unused) {
            gVarA = null;
        }
        if (gVarA != null) {
            f4389c = Boolean.valueOf(gVarA.aF());
        } else {
            f4389c = Boolean.FALSE;
        }
        Boolean bool = f4389c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f4387a == null) {
                try {
                    f4387a = Boolean.valueOf(b(context));
                } catch (Exception unused2) {
                    f4387a = Boolean.FALSE;
                }
            }
            if (f4387a == null) {
                f4387a = new Boolean(false);
            }
            return f4387a.booleanValue();
        }
        if (f4387a == null && f4388b == null) {
            f4388b = new Handler(Looper.getMainLooper());
            f4388b.post(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.f4387a == null) {
                        try {
                            Boolean unused3 = a.f4387a = Boolean.valueOf(a.b(context));
                        } catch (Exception unused4) {
                            Boolean unused5 = a.f4387a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f4387a == null) {
            return true;
        }
        return f4387a.booleanValue();
    }

    public static boolean b(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
            webView.setWebViewClient(new b());
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        try {
            webView.destroy();
            return true;
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            af.b("MBWebViewChecker", "destroy webview error", e);
            return true;
        }
    }
}

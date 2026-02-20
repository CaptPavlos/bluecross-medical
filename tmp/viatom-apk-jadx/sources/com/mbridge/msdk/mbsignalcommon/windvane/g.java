package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static g f4421a = new g();

    private g() {
    }

    public final void a(Object obj, String str) {
        String strX;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                strX = androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.WindVane.onSuccess(", aVar.g, ",'');");
            } else {
                String strC = j.c(str);
                strX = "javascript:window.WindVane.onSuccess(" + aVar.g + ",'" + strC + "');";
            }
            WindVaneWebView windVaneWebView = aVar.f4406b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f4406b.loadUrl(strX);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (!TextUtils.isEmpty(str)) {
                str = j.c(str);
            }
            String str2 = "javascript:window.WindVane.onFailure(" + aVar.g + ",'" + str + "');";
            WindVaneWebView windVaneWebView = aVar.f4406b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f4406b.loadUrl(str2);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str, String str2) {
        String strX;
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str2)) {
                strX = androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.WindVane.fireEvent('", str, "', '');");
            } else {
                strX = "javascript:window.WindVane.fireEvent('" + str + "','" + j.c(str2) + "');";
            }
            WindVaneWebView windVaneWebView = aVar.f4406b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f4406b.loadUrl(strX);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(WebView webView, String str, String str2) {
        String strX;
        if (TextUtils.isEmpty(str2)) {
            strX = androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.WindVane.fireEvent('", str, "', '');");
        } else {
            strX = "javascript:window.WindVane.fireEvent('" + str + "','" + j.c(str2) + "');";
        }
        if (webView != null) {
            if ((webView instanceof WindVaneWebView) && ((WindVaneWebView) webView).isDestoryed()) {
                return;
            }
            try {
                webView.loadUrl(strX);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static g a() {
        return f4421a;
    }

    public final void a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            f4421a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f4325j, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            f4421a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f4325j, "");
        } catch (Throwable unused2) {
            f4421a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f4325j, "");
        }
    }
}

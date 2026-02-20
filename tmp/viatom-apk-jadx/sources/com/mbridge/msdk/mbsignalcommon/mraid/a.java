package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a, reason: collision with other inner class name */
    public static class C0039a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f4379a = new a();
    }

    public final void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String string = jSONObject.toString();
        try {
            string = URLEncoder.encode(string, C.UTF8_NAME);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        c(webView, androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.mraidbridge.fireChangeEvent(", string, ");"));
    }

    public final void b(WebView webView, float f, float f10, float f11, float f12) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)));
    }

    public final void c(WebView webView, float f, float f10) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    private void c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void b(WebView webView, float f, float f10) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    public final void b(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c(webView, androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.mraidbridge.setIsViewable(", str, ");"));
    }

    public final void a(WebView webView) {
        c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public static a a() {
        return C0039a.f4379a;
    }

    public final void a(WebView webView, String str, String str2) throws UnsupportedEncodingException {
        try {
            str2 = URLEncoder.encode(str2, C.UTF8_NAME);
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public final void a(WebView webView, float f, float f10) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10)));
    }

    public final void a(WebView webView, double d8) {
        Locale locale = Locale.CHINA;
        c(webView, "javascript:window.mraidbridge.audioVolumeChange(" + d8 + ");");
    }

    public final void a(WebView webView, float f, float f10, float f11, float f12) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f10), Float.valueOf(f11), Float.valueOf(f12)));
    }

    public final void a(WebView webView, String str) throws UnsupportedEncodingException {
        try {
            str = URLEncoder.encode(str, C.UTF8_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        c(webView, androidx.constraintlayout.core.widgets.analyzer.a.x("javascript:window.mraidbridge.nativeCallComplete('", str, "');"));
    }
}

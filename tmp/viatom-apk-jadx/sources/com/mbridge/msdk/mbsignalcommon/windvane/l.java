package com.mbridge.msdk.mbsignalcommon.windvane;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends com.mbridge.msdk.mbsignalcommon.base.b {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f4435b = true;

    /* renamed from: a, reason: collision with root package name */
    protected String f4436a = null;

    /* renamed from: c, reason: collision with root package name */
    private int f4437c = 0;

    /* renamed from: d, reason: collision with root package name */
    private d f4438d;

    @RequiresApi(api = 11)
    private WebResourceResponse a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !j.d(str)) {
                return null;
            }
            af.c("WindVaneWebViewClient", "is image " + str);
            Bitmap bitmapA = com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str);
            af.c("WindVaneWebViewClient", "find image from cache " + str);
            if (bitmapA == null || bitmapA.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(j.e(str), "utf-8", com.mbridge.msdk.foundation.same.c.a.a(bitmapA));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f4436a = str;
        d dVar = this.f4438d;
        if (dVar != null) {
            dVar.a(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse webResourceResponseA = a(str);
        if (webResourceResponseA == null) {
            return super.shouldInterceptRequest(webView, str);
        }
        af.c("WindVaneWebViewClient", "find WebResourceResponse url is " + str);
        return webResourceResponseA;
    }
}

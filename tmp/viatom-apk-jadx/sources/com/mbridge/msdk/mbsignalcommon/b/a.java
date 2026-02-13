package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a implements com.mbridge.msdk.mbsignalcommon.windvane.b {
    public void a(Object obj) {
        af.a("RVWindVaneWebView", "getEndScreenInfo");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public final boolean b(WebView webView, String str) {
        af.a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public final void c(WebView webView, int i10) {
        af.a("RVWindVaneWebView", "loadingResourceStatus");
    }

    public void a(WebView webView, String str, String str2, int i10, int i11) {
        af.a("RVWindVaneWebView", "loadAds");
    }

    public void a(Object obj, String str) {
        af.a("RVWindVaneWebView", "operateComponent");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public final void b(WebView webView, int i10) {
        af.a("RVWindVaneWebView", "onProgressChanged");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public final void a(WebView webView, String str, Bitmap bitmap) {
        af.a("RVWindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public void a(WebView webView, int i10, String str, String str2) {
        af.a("RVWindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        af.a("RVWindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public void a(WebView webView, String str) {
        af.a("RVWindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public void a(WebView webView, int i10) {
        af.a("RVWindVaneWebView", "readyState");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.d
    public void a(WebView webView) {
        af.a("RVWindVaneWebView", "onRenderProcessGone");
    }
}

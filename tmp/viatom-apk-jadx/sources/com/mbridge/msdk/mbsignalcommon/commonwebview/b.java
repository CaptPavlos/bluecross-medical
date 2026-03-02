package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WebViewClient> f4371a = new CopyOnWriteArrayList<>();

    public final void a(WebViewClient webViewClient) {
        this.f4371a.add(webViewClient);
    }

    public final void b(WebViewClient webViewClient) {
        this.f4371a.remove(webViewClient);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z9) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().doUpdateVisitedHistory(webView, str, z9);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        try {
            Iterator<WebViewClient> it = this.f4371a.iterator();
            while (it.hasNext()) {
                it.next().onPageCommitVisible(webView, str);
            }
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        try {
            Iterator<WebViewClient> it = this.f4371a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedClientCertRequest(webView, clientCertRequest);
            }
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            Iterator<WebViewClient> it = this.f4371a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedError(webView, webResourceRequest, webResourceError);
            }
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            Iterator<WebViewClient> it = this.f4371a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean zOnRenderProcessGone = false;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator<WebViewClient> it = this.f4371a.iterator();
                while (it.hasNext()) {
                    zOnRenderProcessGone = it.next().onRenderProcessGone(webView, renderProcessGoneDetail);
                }
            }
            return zOnRenderProcessGone;
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
            return zOnRenderProcessGone;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i10, SafeBrowsingResponse safeBrowsingResponse) {
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                Iterator<WebViewClient> it = this.f4371a.iterator();
                while (it.hasNext()) {
                    it.next().onSafeBrowsingHit(webView, webResourceRequest, i10, safeBrowsingResponse);
                }
            }
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f, float f10) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onScaleChanged(webView, f, f10);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponseShouldInterceptRequest = null;
        try {
            Iterator<WebViewClient> it = this.f4371a.iterator();
            while (it.hasNext()) {
                webResourceResponseShouldInterceptRequest = it.next().shouldInterceptRequest(webView, webResourceRequest);
            }
            return webResourceResponseShouldInterceptRequest;
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
            return webResourceResponseShouldInterceptRequest;
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        boolean zShouldOverrideKeyEvent = false;
        while (it.hasNext()) {
            zShouldOverrideKeyEvent = it.next().shouldOverrideKeyEvent(webView, keyEvent);
        }
        return zShouldOverrideKeyEvent;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z9 = false;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Iterator<WebViewClient> it = this.f4371a.iterator();
                while (it.hasNext()) {
                    boolean zShouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, webResourceRequest);
                    if (zShouldOverrideUrlLoading) {
                        z9 = zShouldOverrideUrlLoading;
                    }
                }
            }
            return z9;
        } catch (Exception e) {
            af.b("CommonWebViewClient", e.getMessage());
            return z9;
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public final void onReceivedError(WebView webView, int i10, String str, String str2) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(webView, i10, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @Deprecated
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        WebResourceResponse webResourceResponseShouldInterceptRequest = null;
        while (it.hasNext()) {
            webResourceResponseShouldInterceptRequest = it.next().shouldInterceptRequest(webView, str);
        }
        return webResourceResponseShouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f4371a.iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            boolean zShouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, str);
            if (zShouldOverrideUrlLoading) {
                z9 = zShouldOverrideUrlLoading;
            }
        }
        return z9;
    }
}

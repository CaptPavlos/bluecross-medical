package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WebChromeClient> f4370a = new CopyOnWriteArrayList<>();

    public final void a(WebChromeClient webChromeClient) {
        this.f4370a.add(webChromeClient);
    }

    public final void b(WebChromeClient webChromeClient) {
        this.f4370a.remove(webChromeClient);
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        super.getVisitedHistory(valueCallback);
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnConsoleMessage = false;
        while (it.hasNext()) {
            zOnConsoleMessage = it.next().onConsoleMessage(consoleMessage);
        }
        return zOnConsoleMessage;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z9, boolean z10, Message message) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnCreateWindow = false;
        while (it.hasNext()) {
            zOnCreateWindow = it.next().onCreateWindow(webView, z9, z10, message);
        }
        return zOnCreateWindow;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onExceededDatabaseQuota(String str, String str2, long j10, long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onExceededDatabaseQuota(str, str2, j10, j11, j12, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnJsAlert = false;
        while (it.hasNext()) {
            zOnJsAlert = it.next().onJsAlert(webView, str, str2, jsResult);
        }
        return zOnJsAlert;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnJsBeforeUnload = false;
        while (it.hasNext()) {
            zOnJsBeforeUnload = it.next().onJsBeforeUnload(webView, str, str2, jsResult);
        }
        return zOnJsBeforeUnload;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnJsConfirm = false;
        while (it.hasNext()) {
            zOnJsConfirm = it.next().onJsConfirm(webView, str, str2, jsResult);
        }
        return zOnJsConfirm;
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnJsPrompt = false;
        while (it.hasNext()) {
            zOnJsPrompt = it.next().onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }
        return zOnJsPrompt;
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final boolean onJsTimeout() {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        boolean zOnJsTimeout = false;
        while (it.hasNext()) {
            zOnJsTimeout = it.next().onJsTimeout();
        }
        return zOnJsTimeout;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f4370a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequest(permissionRequest);
            }
        } catch (Exception e) {
            af.b("CommonWebChromeClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest permissionRequest) {
        try {
            Iterator<WebChromeClient> it = this.f4370a.iterator();
            while (it.hasNext()) {
                it.next().onPermissionRequestCanceled(permissionRequest);
            }
        } catch (Exception e) {
            af.b("CommonWebChromeClient", e.getMessage());
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i10) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onProgressChanged(webView, i10);
        }
    }

    @Deprecated
    public final void onReachedMaxAppCacheSize(long j10, long j11, WebStorage.QuotaUpdater quotaUpdater) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onReachedMaxAppCacheSize(j10, j11, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView webView, Bitmap bitmap) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView webView, String str, boolean z9) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedTouchIconUrl(webView, str, z9);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView webView) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        boolean zOnShowFileChooser = false;
        try {
            Iterator<WebChromeClient> it = this.f4370a.iterator();
            while (it.hasNext()) {
                zOnShowFileChooser = it.next().onShowFileChooser(webView, valueCallback, fileChooserParams);
            }
            return zOnShowFileChooser;
        } catch (Exception e) {
            af.b("CommonWebChromeClient", e.getMessage());
            return zOnShowFileChooser;
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i10, WebChromeClient.CustomViewCallback customViewCallback) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onShowCustomView(view, i10, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onConsoleMessage(String str, int i10, String str2) {
        Iterator<WebChromeClient> it = this.f4370a.iterator();
        while (it.hasNext()) {
            it.next().onConsoleMessage(str, i10, str2);
        }
    }
}

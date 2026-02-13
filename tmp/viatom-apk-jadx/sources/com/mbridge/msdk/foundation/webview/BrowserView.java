package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BrowserView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private CampaignEx f4047a;

    /* renamed from: b, reason: collision with root package name */
    private String f4048b;

    /* renamed from: c, reason: collision with root package name */
    private a f4049c;

    /* renamed from: d, reason: collision with root package name */
    private WebView f4050d;
    private ProgressBar e;
    private ToolBar f;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a();

        void a(WebView webView, int i10, String str, String str2);

        void a(WebView webView, String str);

        void a(WebView webView, String str, Bitmap bitmap);

        boolean b(WebView webView, String str);

        void c(WebView webView, String str);
    }

    public BrowserView(Context context, CampaignEx campaignEx) throws Resources.NotFoundException {
        super(context);
        this.f4047a = campaignEx;
        init();
    }

    private WebView a() {
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable th) {
                    af.b("BrowserView", th.getMessage());
                }
            }
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            try {
                settings.setMixedContentMode(0);
            } catch (Exception e) {
                af.b("BrowserView", e.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir("database", 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e3) {
                af.b("BrowserView", e3.getMessage());
            }
        } catch (Throwable th2) {
            af.b("BrowserView", th2.getMessage());
        }
        webView.setDownloadListener(new com.mbridge.msdk.foundation.same.g.a(this.f4047a));
        webView.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onLoadResource(WebView webView2, String str) {
                super.onLoadResource(webView2, str);
                af.c("BrowserView", "onLoadResource 开始! = " + str);
                if (BrowserView.this.f4049c != null) {
                    BrowserView.this.f4049c.a(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str) {
                if (BrowserView.this.f4049c != null) {
                    BrowserView.this.f4049c.c(webView2, str);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                af.c("BrowserView", "开始! = " + str);
                BrowserView.this.f4048b = str;
                if (BrowserView.this.f4049c != null) {
                    BrowserView.this.f4049c.a(webView2, str, bitmap);
                }
                BrowserView.this.e.setVisible(true);
                BrowserView.this.e.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i10, String str, String str2) {
                if (BrowserView.this.f4049c != null) {
                    BrowserView.this.f4049c.a(webView2, i10, str, str2);
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (webView2 != null) {
                    try {
                        ViewGroup viewGroup = (ViewGroup) webView2.getParent();
                        if (viewGroup != null) {
                            viewGroup.removeView(webView2);
                        }
                        webView2.destroy();
                    } catch (Throwable th3) {
                        af.b("BrowserView", th3.getMessage());
                        return true;
                    }
                }
                if (BrowserView.this.f4049c != null) {
                    BrowserView.this.f4049c.a();
                }
                return true;
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                af.c("BrowserView", "js大跳! = " + str);
                BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
                if (BrowserView.this.f4049c != null) {
                    return BrowserView.this.f4049c.b(webView2, str);
                }
                return false;
            }
        });
        webView.setWebChromeClient(ab.s() <= 10 ? new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i10) {
                if (i10 == 100) {
                    BrowserView.this.e.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.e.setVisible(false);
                        }
                    }, 200L);
                }
            }
        } : new WebChromeClient() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i10) {
                if (i10 == 100) {
                    BrowserView.this.e.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.e.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        return webView;
    }

    public void destroy() {
        WebView webView = this.f4050d;
        if (webView != null) {
            webView.stopLoading();
            this.f4050d.setWebViewClient(null);
            this.f4050d.destroy();
            this.f4050d = null;
            removeAllViews();
        }
    }

    public void init() throws Resources.NotFoundException {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.e = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.f4050d == null) {
                this.f4050d = a();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.f4050d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            af.b("BrowserView", "webview is error", th);
        }
        this.f = new ToolBar(getContext());
        this.f.setLayoutParams(new LinearLayout.LayoutParams(-1, ak.a(getContext(), 40.0f)));
        this.f.setBackgroundColor(-1);
        addView(this.e);
        WebView webView = this.f4050d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.f);
        this.e.initResource(true);
        this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(false);
        this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(false);
        this.f.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BrowserView.this.f4050d != null) {
                    BrowserView.this.f4050d.stopLoading();
                }
                String str = (String) view.getTag();
                boolean z9 = false;
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD)) {
                    BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD).setEnabled(true);
                    if (BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoBack()) {
                        BrowserView.this.f4050d.goBack();
                    }
                    View item = BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD);
                    if (BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoBack()) {
                        z9 = true;
                    }
                    item.setEnabled(z9);
                    return;
                }
                if (TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD)) {
                    BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(true);
                    if (BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoForward()) {
                        BrowserView.this.f4050d.goForward();
                    }
                    View item2 = BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                    if (BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoForward()) {
                        z9 = true;
                    }
                    item2.setEnabled(z9);
                    return;
                }
                if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.REFRESH)) {
                    if (!TextUtils.equals(str, com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.EXITS) || BrowserView.this.f4049c == null) {
                        return;
                    }
                    BrowserView.this.f4049c.a();
                    return;
                }
                BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.BACKWARD).setEnabled(BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoBack());
                View item3 = BrowserView.this.f.getItem(com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar.FORWARD);
                if (BrowserView.this.f4050d != null && BrowserView.this.f4050d.canGoForward()) {
                    z9 = true;
                }
                item3.setEnabled(z9);
                if (BrowserView.this.f4050d != null) {
                    BrowserView.this.f4050d.loadUrl(BrowserView.this.f4048b);
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.f4050d;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    public void setListener(a aVar) {
        this.f4049c = aVar;
    }

    public void setWebView(WebView webView) {
        this.f4050d = webView;
    }

    public BrowserView(Context context) throws Resources.NotFoundException {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        init();
    }
}

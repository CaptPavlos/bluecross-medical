package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.webview.ProgressBar;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CommonWebView extends LinearLayout {
    public static int DEFAULT_JUMP_TIMEOUT = 10000;

    /* renamed from: a, reason: collision with root package name */
    protected ToolBar f4339a;

    /* renamed from: b, reason: collision with root package name */
    protected ToolBar f4340b;

    /* renamed from: c, reason: collision with root package name */
    protected ProgressBar f4341c;

    /* renamed from: d, reason: collision with root package name */
    protected BaseWebView f4342d;
    private int e;
    private int f;
    private RelativeLayout g;
    private View.OnClickListener h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.b f4343i;

    /* renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.commonwebview.a f4344j;

    /* renamed from: k, reason: collision with root package name */
    private View.OnClickListener f4345k;

    /* renamed from: l, reason: collision with root package name */
    private View.OnClickListener f4346l;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f4347m;

    /* renamed from: n, reason: collision with root package name */
    private View.OnClickListener f4348n;

    /* renamed from: o, reason: collision with root package name */
    private Handler f4349o;

    /* renamed from: p, reason: collision with root package name */
    private int f4350p;

    /* renamed from: q, reason: collision with root package name */
    private WebViewClient f4351q;

    /* renamed from: r, reason: collision with root package name */
    private String f4352r;

    /* renamed from: s, reason: collision with root package name */
    private b f4353s;
    private boolean t;

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f4354u;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b {
        void a(String str);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4354u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                af.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f4350p + "ms");
                if (CommonWebView.this.f4353s != null) {
                    CommonWebView.this.t = false;
                    CommonWebView.this.f4353s.a(CommonWebView.this.f4352r);
                }
            }
        };
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        String str2;
        try {
        } catch (Throwable th) {
            af.b("CommonWebView", th.getMessage());
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        if (!uri.getScheme().equals("http") && !uri.getScheme().equals("https")) {
            if (uri.getScheme().equals("intent")) {
                Intent uri2 = Intent.parseUri(str, 1);
                try {
                    str2 = uri2.getPackage();
                } catch (Throwable th2) {
                    af.b("CommonWebView", th2.getMessage());
                }
                if (!TextUtils.isEmpty(str2) && getContext().getPackageManager().getLaunchIntentForPackage(str2) != null) {
                    uri2.setComponent(null);
                    uri2.setSelector(null);
                    uri2.setFlags(268435456);
                    getContext().startActivity(uri2);
                    return true;
                }
                try {
                    String stringExtra = uri2.getStringExtra("browser_fallback_url");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        Uri uri3 = Uri.parse(str);
                        if (!uri3.getScheme().equals("http") && !uri3.getScheme().equals("https")) {
                            str = stringExtra;
                        }
                        webView.loadUrl(stringExtra);
                        return false;
                    }
                } catch (Throwable th3) {
                    af.b("CommonWebView", th3.getMessage());
                }
                af.b("CommonWebView", th.getMessage());
                return false;
            }
            if (c.e(getContext(), str)) {
                af.b("CommonWebView", "openDeepLink");
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                return !(str.startsWith("http") || str.startsWith("https"));
            }
        }
        return false;
    }

    public static /* synthetic */ void k(CommonWebView commonWebView) {
        commonWebView.f4349o.removeCallbacks(commonWebView.f4354u);
    }

    public void addWebChromeClient(WebChromeClient webChromeClient) {
        this.f4344j.a(webChromeClient);
    }

    public void addWebViewClient(WebViewClient webViewClient) {
        this.f4343i.a(webViewClient);
    }

    public View findToolBarButton(String str) {
        ToolBar toolBar;
        ToolBar toolBar2 = this.f4339a;
        View item = toolBar2 != null ? toolBar2.getItem(str) : null;
        return (item != null || (toolBar = this.f4340b) == null) ? item : toolBar.getItem(str);
    }

    public String getUrl() {
        BaseWebView baseWebView = this.f4342d;
        return baseWebView == null ? "" : baseWebView.getUrl();
    }

    public WebView getWebView() {
        return this.f4342d;
    }

    public void hideCustomizedToolBar() {
        ToolBar toolBar = this.f4339a;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideDefaultToolBar() {
        ToolBar toolBar = this.f4340b;
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }

    public void hideToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(8);
        }
    }

    public void hideToolBarTitle() {
        this.f4339a.hideTitle();
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        this.g = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        addView(this.g, layoutParams);
        this.e = ak.a(getContext(), 40.0f);
        this.f = ak.a(getContext(), 40.0f);
        this.f4343i = new com.mbridge.msdk.mbsignalcommon.commonwebview.b();
        this.f4344j = new com.mbridge.msdk.mbsignalcommon.commonwebview.a();
        initWebview();
    }

    public void initWebview() {
        try {
            if (this.f4342d == null) {
                this.f4342d = new BaseWebView(getContext());
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(10);
            this.f4342d.setLayoutParams(layoutParams);
            BaseWebView baseWebView = this.f4342d;
            com.mbridge.msdk.mbsignalcommon.base.b bVar = baseWebView.mWebViewClient;
            baseWebView.setWebViewClient(this.f4343i);
            this.f4342d.setWebChromeClient(this.f4344j);
            addWebViewClient(bVar);
        } catch (Throwable th) {
            af.b("CommonWebView", "webview is error", th);
        }
        this.g.addView(this.f4342d);
    }

    public void loadUrl(String str) {
        this.f4342d.loadUrl(str);
        if (this.f4351q != null) {
            a();
        }
    }

    public void onBackwardClicked(View.OnClickListener onClickListener) {
        this.f4345k = onClickListener;
    }

    public void onForwardClicked(View.OnClickListener onClickListener) {
        this.f4346l = onClickListener;
    }

    public void onOpenByBrowserClicked(View.OnClickListener onClickListener) {
        this.f4348n = onClickListener;
    }

    public void onRefreshClicked(View.OnClickListener onClickListener) {
        this.f4347m = onClickListener;
    }

    public void removeWebChromeClient(WebChromeClient webChromeClient) {
        this.f4344j.b(webChromeClient);
    }

    public void removeWebViewClient(WebViewClient webViewClient) {
        this.f4343i.b(webViewClient);
    }

    public void setCustomizedToolBarFloating() {
        ((ViewGroup) this.f4339a.getParent()).removeView(this.f4339a);
        this.g.addView(this.f4339a);
    }

    public void setCustomizedToolBarUnfloating() {
        ((ViewGroup) this.f4339a.getParent()).removeView(this.f4339a);
        addView(this.f4339a, 0);
    }

    public void setExitsClickListener(View.OnClickListener onClickListener) {
        this.h = onClickListener;
    }

    public void setPageLoadTimtout(int i10) {
        this.f4350p = i10;
        if (this.f4349o == null) {
            this.f4349o = new Handler(Looper.getMainLooper());
        }
        if (this.f4351q == null) {
            WebViewClient webViewClient = new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.7
                @Override // android.webkit.WebViewClient
                public final void onPageFinished(WebView webView, String str) {
                    CommonWebView.this.t = false;
                    CommonWebView.k(CommonWebView.this);
                }

                @Override // android.webkit.WebViewClient
                public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                    CommonWebView.this.f4352r = str;
                    if (CommonWebView.this.t) {
                        return;
                    }
                    CommonWebView.this.t = true;
                    CommonWebView.this.a();
                }

                @Override // android.webkit.WebViewClient
                public final void onReceivedError(WebView webView, int i11, String str, String str2) {
                    CommonWebView.this.t = false;
                    CommonWebView.k(CommonWebView.this);
                }

                @Override // android.webkit.WebViewClient
                public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    CommonWebView.this.f4352r = str;
                    if (CommonWebView.this.t) {
                        CommonWebView.k(CommonWebView.this);
                    }
                    CommonWebView.this.t = true;
                    CommonWebView.this.a();
                    return false;
                }
            };
            this.f4351q = webViewClient;
            addWebViewClient(webViewClient);
        }
    }

    public void setPageLoadTimtoutListener(b bVar) {
        this.f4353s = bVar;
    }

    public void setToolBarTitle(String str, int i10) {
        this.f4339a.setTitle(str, i10);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        addWebChromeClient(webChromeClient);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        addWebViewClient(webViewClient);
    }

    public void showCustomizedToolBar() {
        ToolBar toolBar = this.f4339a;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showDefaultToolBar() {
        ToolBar toolBar = this.f4340b;
        if (toolBar != null) {
            toolBar.setVisibility(0);
        }
    }

    public void showToolBarButton(String str) {
        View viewFindToolBarButton = findToolBarButton(str);
        if (viewFindToolBarButton != null) {
            viewFindToolBarButton.setVisibility(0);
        }
    }

    public void showToolBarTitle() {
        this.f4339a.showTitle();
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList) {
        a(arrayList, false);
    }

    public void useDeeplink() {
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.6
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (aj.a.b(str)) {
                    aj.a.a(CommonWebView.this.getContext(), str, null);
                }
                return CommonWebView.this.a(webView, str);
            }
        });
    }

    public void useDefaultToolBar() {
        if (this.f4340b != null) {
            return;
        }
        this.f4340b = new ToolBar(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f);
        layoutParams.bottomMargin = 0;
        this.f4340b.setLayoutParams(layoutParams);
        this.f4340b.setBackgroundColor(-1);
        this.f4340b.setOnItemClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseWebView baseWebView = CommonWebView.this.f4342d;
                if (baseWebView != null) {
                    baseWebView.stopLoading();
                    String str = (String) view.getTag();
                    if (TextUtils.equals(str, ToolBar.BACKWARD)) {
                        CommonWebView.this.f4340b.getItem(ToolBar.FORWARD).setEnabled(true);
                        if (CommonWebView.this.f4342d.canGoBack()) {
                            CommonWebView.this.f4342d.goBack();
                        }
                        CommonWebView.this.f4340b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f4342d.canGoBack());
                        if (CommonWebView.this.f4345k != null) {
                            CommonWebView.this.f4345k.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.FORWARD)) {
                        CommonWebView.this.f4340b.getItem(ToolBar.BACKWARD).setEnabled(true);
                        if (CommonWebView.this.f4342d.canGoForward()) {
                            CommonWebView.this.f4342d.goForward();
                        }
                        CommonWebView.this.f4340b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f4342d.canGoForward());
                        if (CommonWebView.this.f4346l != null) {
                            CommonWebView.this.f4346l.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.REFRESH)) {
                        CommonWebView.this.f4340b.getItem(ToolBar.BACKWARD).setEnabled(CommonWebView.this.f4342d.canGoBack());
                        CommonWebView.this.f4340b.getItem(ToolBar.FORWARD).setEnabled(CommonWebView.this.f4342d.canGoForward());
                        CommonWebView.this.f4342d.reload();
                        if (CommonWebView.this.f4347m != null) {
                            CommonWebView.this.f4347m.onClick(view);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(str, ToolBar.EXITS)) {
                        if (CommonWebView.this.h != null) {
                            CommonWebView.this.h.onClick(view);
                        }
                    } else if (TextUtils.equals(str, ToolBar.OPEN_BY_BROWSER)) {
                        if (CommonWebView.this.f4348n != null) {
                            CommonWebView.this.f4348n.onClick(view);
                        }
                        c.d(CommonWebView.this.getContext(), CommonWebView.this.f4342d.getUrl());
                    }
                }
            }
        });
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.5
            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                CommonWebView.this.f4340b.getItem(ToolBar.BACKWARD).setEnabled(true);
                CommonWebView.this.f4340b.getItem(ToolBar.FORWARD).setEnabled(false);
                return false;
            }
        });
        addView(this.f4340b);
    }

    public void useProgressBar() throws Resources.NotFoundException {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f4341c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                af.c("CommonWebView", "newProgress! 开始! = " + str);
                CommonWebView.this.f4341c.setVisible(true);
                CommonWebView.this.f4341c.setProgressState(5);
            }
        });
        addWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.3
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView, int i10) {
                af.c("CommonWebView", "newProgress! = " + i10);
                if (i10 == 100) {
                    CommonWebView.this.f4341c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            CommonWebView.this.f4341c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        addView(this.f4341c);
        this.f4341c.initResource(true);
    }

    public void useCustomizedToolBar(ArrayList<ToolBar.b> arrayList, boolean z9) {
        a(arrayList, z9);
    }

    public void setToolBarTitle(String str) {
        this.f4339a.setTitle(str);
    }

    public CommonWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4354u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                af.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f4350p + "ms");
                if (CommonWebView.this.f4353s != null) {
                    CommonWebView.this.t = false;
                    CommonWebView.this.f4353s.a(CommonWebView.this.f4352r);
                }
            }
        };
        init();
    }

    public CommonWebView(Context context) {
        super(context);
        this.f4354u = new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.1
            @Override // java.lang.Runnable
            public final void run() {
                af.b("CommonWebView", "webview js!！超时上限：" + CommonWebView.this.f4350p + "ms");
                if (CommonWebView.this.f4353s != null) {
                    CommonWebView.this.t = false;
                    CommonWebView.this.f4353s.a(CommonWebView.this.f4352r);
                }
            }
        };
        init();
    }

    private void a(ArrayList<ToolBar.b> arrayList, boolean z9) {
        if (this.f4339a != null) {
            return;
        }
        ToolBar.a aVar = new ToolBar.a();
        aVar.f4365a = 40;
        ToolBar.a.f4363b = 80;
        ToolBar toolBar = new ToolBar(getContext(), aVar, arrayList);
        this.f4339a = toolBar;
        toolBar.setBackgroundColor(Color.argb(153, 255, 255, 255));
        if (z9) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
            layoutParams.addRule(10);
            this.f4339a.setLayoutParams(layoutParams);
            this.g.addView(this.f4339a);
            return;
        }
        this.f4339a.setLayoutParams(new LinearLayout.LayoutParams(-1, this.e));
        addView(this.f4339a, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.f4349o.postDelayed(this.f4354u, this.f4350p);
    }
}

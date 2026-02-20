package com.mbridge.msdk.click;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static long f2837a = 0;

    /* renamed from: d, reason: collision with root package name */
    private static final String f2838d = "m";

    /* renamed from: b, reason: collision with root package name */
    boolean f2839b;

    /* renamed from: c, reason: collision with root package name */
    boolean f2840c;
    private int e;
    private int f;
    private com.mbridge.msdk.c.g h;

    /* renamed from: i, reason: collision with root package name */
    private a f2841i;

    /* renamed from: j, reason: collision with root package name */
    private String f2842j;

    /* renamed from: k, reason: collision with root package name */
    private String f2843k;

    /* renamed from: l, reason: collision with root package name */
    private WebView f2844l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f2845m;

    /* renamed from: n, reason: collision with root package name */
    private String f2846n;

    /* renamed from: o, reason: collision with root package name */
    private int f2847o;

    /* renamed from: q, reason: collision with root package name */
    private boolean f2849q;

    /* renamed from: p, reason: collision with root package name */
    private boolean f2848p = false;

    /* renamed from: r, reason: collision with root package name */
    private final Runnable f2850r = new Runnable() { // from class: com.mbridge.msdk.click.m.4
        @Override // java.lang.Runnable
        public final void run() {
            m.this.f2848p = true;
            m.this.f2847o = 1;
            m.m(m.this);
        }
    };

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f2851s = new Runnable() { // from class: com.mbridge.msdk.click.m.5
        @Override // java.lang.Runnable
        public final void run() {
            m.this.f2848p = true;
            m.this.f2847o = 2;
            m.m(m.this);
        }
    };
    private Handler g = new Handler(Looper.getMainLooper());

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(int i10, String str, String str2, String str3);

        void a(String str, boolean z9, String str2);

        boolean a(String str);

        boolean b(String str);

        boolean c(String str);
    }

    public m() {
        this.e = DefaultLoadControl.DEFAULT_MIN_BUFFER_MS;
        this.f = 3000;
        com.mbridge.msdk.c.g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(com.mbridge.msdk.c.h.a());
        this.h = gVarS;
        if (gVarS == null) {
            com.mbridge.msdk.c.h.a();
            this.h = com.mbridge.msdk.c.i.a();
        }
        this.f2845m = this.h.aJ();
        this.e = (int) this.h.ar();
        this.f = (int) this.h.ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.f2843k)) {
                this.f2844l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f = 2000;
                this.e = 2000;
                af.c(f2838d, this.f2843k);
                this.f2844l.loadDataWithBaseURL(str3, this.f2843k, "*/*", "utf-8", str3);
                return;
            }
            if (!this.f2845m) {
                this.f2844l.loadUrl(str3);
                return;
            }
            HashMap map = new HashMap();
            if (this.f2844l.getUrl() != null) {
                map.put("Referer", this.f2844l.getUrl());
            }
            this.f2844l.loadUrl(str3, map);
        } catch (Throwable th) {
            try {
                a aVar = this.f2841i;
                if (aVar != null) {
                    aVar.a(0, this.f2842j, th.getMessage(), this.f2846n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        d();
        c();
    }

    public static /* synthetic */ void c(m mVar) {
        synchronized (f2838d) {
            try {
                try {
                    try {
                        mVar.b();
                        a aVar = mVar.f2841i;
                        if (aVar != null) {
                            aVar.a(mVar.f2842j, mVar.f2848p, mVar.f2846n);
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    af.b(f2838d, e.getMessage());
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.removeCallbacks(this.f2850r);
    }

    public static /* synthetic */ void e(m mVar) {
        mVar.c();
        mVar.g.postDelayed(mVar.f2851s, mVar.e);
    }

    public static /* synthetic */ void l(m mVar) {
        mVar.d();
        mVar.g.postDelayed(mVar.f2850r, mVar.f);
    }

    public static /* synthetic */ void m(m mVar) {
        synchronized (f2838d) {
            try {
                try {
                    mVar.b();
                    mVar.f2844l.destroy();
                    a aVar = mVar.f2841i;
                    if (aVar != null) {
                        aVar.a(mVar.f2842j, mVar.f2848p, mVar.f2846n);
                    }
                } catch (Exception e) {
                    af.b(f2838d, e.getMessage());
                } catch (Throwable th) {
                    af.b(f2838d, th.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.g.removeCallbacks(this.f2851s);
    }

    public final void a(String str, String str2, Context context, String str3, String str4, a aVar) {
        if (aVar != null) {
            this.f2843k = str4;
            this.f2842j = str3;
            this.f2841i = aVar;
            a(str, str2, context);
            return;
        }
        androidx.window.layout.c.k("OverrideUrlLoadingListener can not be null");
    }

    public final void a(String str, String str2, Context context, String str3, a aVar) {
        if (aVar != null) {
            this.f2842j = str3;
            this.f2841i = aVar;
            a(str, str2, context);
            return;
        }
        androidx.window.layout.c.k("OverrideUrlLoadingListener can not be null");
    }

    private void a(final String str, final String str2, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str, str2, context, this.f2842j);
        } else {
            this.g.post(new Runnable() { // from class: com.mbridge.msdk.click.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    m mVar = m.this;
                    mVar.a(str, str2, context, mVar.f2842j);
                }
            });
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void a(final Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.f2844l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f2844l.getSettings().setCacheMode(2);
        this.f2844l.getSettings().setLoadsImagesAutomatically(false);
        this.f2844l.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.click.m.2
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str3) {
                super.onPageFinished(webView2, str3);
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str3, Bitmap bitmap) {
                try {
                    webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                    boolean z9 = m.this.f2849q;
                    m mVar = m.this;
                    if (z9) {
                        mVar.f2847o = 0;
                        m.c(m.this);
                        return;
                    }
                    mVar.f2840c = false;
                    if (webView2.getTag() == null) {
                        webView2.setTag("has_first_started");
                    } else {
                        m.this.f2839b = true;
                    }
                    synchronized (m.f2838d) {
                        try {
                            m.this.f2842j = str3;
                            if (m.this.f2841i == null || !m.this.f2841i.a(str3)) {
                                m.e(m.this);
                            } else {
                                m.this.f2849q = true;
                                m.c(m.this);
                            }
                        } finally {
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i10, String str3, String str4) {
                synchronized (m.f2838d) {
                    m.this.f2849q = true;
                    m.this.b();
                    m.c(m.this);
                }
                if (m.this.f2841i != null) {
                    m.this.f2841i.a(i10, webView2.getUrl(), str3, m.this.f2846n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) throws JSONException {
                try {
                    if (MBridgeConstans.IS_SP_CBT_CF && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                        return;
                    }
                    new com.mbridge.msdk.foundation.same.report.h(context);
                    String str3 = str;
                    String str4 = str2;
                    String url = webView2.getUrl();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("click_type", "1");
                        jSONObject.put("cid", str3);
                        jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, str4);
                        jSONObject.put("key", "2000027");
                        jSONObject.put("http_url", url);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a(jSONObject);
                    } catch (Exception e) {
                        af.b(com.mbridge.msdk.foundation.same.report.h.f3864a, e.getMessage());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView2, RenderProcessGoneDetail renderProcessGoneDetail) {
                try {
                    synchronized (m.f2838d) {
                        m.this.f2849q = true;
                        m.this.b();
                        m.c(m.this);
                    }
                    if (m.this.f2841i != null) {
                        m.this.f2841i.a(-1, webView2.getUrl(), "WebView render process crash.", m.this.f2846n);
                    }
                    if (webView2 != null) {
                        webView2.destroy();
                    }
                    return true;
                } catch (Throwable th) {
                    af.b(m.f2838d, th.getMessage());
                    return true;
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                synchronized (m.f2838d) {
                    try {
                        m mVar = m.this;
                        mVar.f2840c = true;
                        mVar.d();
                        boolean z9 = m.this.f2849q;
                        m mVar2 = m.this;
                        if (z9) {
                            mVar2.c();
                            m.c(m.this);
                            return true;
                        }
                        mVar2.f2842j = str3;
                        if (m.this.f2841i != null && m.this.f2841i.b(str3)) {
                            m.this.f2849q = true;
                            m.this.c();
                            m.c(m.this);
                            return true;
                        }
                        if (m.this.f2845m) {
                            HashMap map = new HashMap();
                            if (m.this.f2844l.getUrl() != null) {
                                map.put("Referer", m.this.f2844l.getUrl());
                            }
                            m.this.f2844l.loadUrl(str3, map);
                        } else {
                            m.this.f2844l.loadUrl(str3);
                        }
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        this.f2844l.setWebChromeClient(new WebChromeClient() { // from class: com.mbridge.msdk.click.m.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str3, String str4, String str5, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i10) {
                if (i10 == 100) {
                    try {
                        webView2.loadUrl("javascript:window.navigator.vibrate([]);");
                        if (!m.this.f2849q) {
                            m mVar = m.this;
                            if (!mVar.f2840c) {
                                m.l(mVar);
                            }
                        }
                        if (m.this.f2841i != null) {
                            m.this.f2841i.c(webView2.getUrl());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

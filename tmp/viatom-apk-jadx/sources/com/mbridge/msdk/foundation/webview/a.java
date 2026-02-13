package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class a implements BrowserView.a {

    /* renamed from: a, reason: collision with root package name */
    private static String f4078a = "a";

    /* renamed from: b, reason: collision with root package name */
    private int f4079b;

    /* renamed from: d, reason: collision with root package name */
    private String f4081d;
    private boolean e;
    private BaseTrackingListener f;
    private BrowserView g;
    private CampaignEx h;

    /* renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.click.a f4082i;

    /* renamed from: j, reason: collision with root package name */
    private Context f4083j;

    /* renamed from: l, reason: collision with root package name */
    private JumpLoaderResult f4085l;

    /* renamed from: o, reason: collision with root package name */
    private long f4088o;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4080c = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4086m = false;

    /* renamed from: n, reason: collision with root package name */
    private final Runnable f4087n = new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.1
        @Override // java.lang.Runnable
        public final void run() {
            af.b(a.f4078a, "webview js！超时上限：" + a.this.f4079b + "ms");
            if (a.this.f4082i != null && a.this.f4085l != null) {
                a.this.f4085l.setSuccess(false);
                a.this.f4085l.setUrl(a.this.f4081d);
                a.this.f4085l.setType(2);
                a.this.f4085l.setExceptionMsg("linktype 8 time out");
                a.this.f4082i.a(a.this.f4085l, a.this.h, 1, false);
            }
            a aVar = a.this;
            if (aVar.d(null, aVar.f4081d) && !a.this.f4086m) {
                a.this.f4086m = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.f4083j, a.this.f4081d, a.this.h);
            }
            if (a.this.f != null) {
                a.this.f.onFinishRedirection(a.this.h, a.this.f4081d);
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private Handler f4084k = new Handler(Looper.getMainLooper());

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f4079b = 10000;
        this.f4085l = null;
        this.f4083j = context;
        this.h = campaignEx;
        this.g = browserView;
        this.f = baseTrackingListener;
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
        }
        this.f4082i = aVar;
        this.f4085l = new JumpLoaderResult();
        this.f4079b = (int) gVarS.ar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context == null) {
            return;
        }
        if (campaignEx != null) {
            campaignEx.getCurrentLocalRid();
        }
        try {
            int i10 = MBCommonActivity.f2632d;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            b.f4097a.put(str, this.g);
            if (aj.a.a(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            af.c("url", "webview url = " + str);
            intent.setFlags(805306368);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            aj.a(context, str, this.f, campaignEx, new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri uri = Uri.parse(str);
            if (!uri.getScheme().equals("http") && !uri.getScheme().equals("https")) {
                if (uri.getScheme().equals("intent")) {
                    Intent uri2 = Intent.parseUri(str, 1);
                    try {
                        String str2 = uri2.getPackage();
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.f4083j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                                return false;
                            }
                        }
                    } catch (Throwable th) {
                        af.b(f4078a, th.getMessage());
                    }
                    try {
                        String stringExtra = uri2.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri uri3 = Uri.parse(str);
                            if (!uri3.getScheme().equals("http")) {
                                if (!uri3.getScheme().equals("https")) {
                                    str = stringExtra;
                                }
                            }
                            return true;
                        }
                    } catch (Throwable th2) {
                        af.b(f4078a, th2.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.e(this.f4083j, str)) {
                    af.b(f4078a, "openDeepLink");
                    return false;
                }
            }
            return true;
        } catch (Throwable th3) {
            af.b(f4078a, th3.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        String str2;
        try {
        } catch (Throwable th) {
            af.b(f4078a, th.getMessage());
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
                    af.b(f4078a, th2.getMessage());
                }
                if (!TextUtils.isEmpty(str2) && this.f4083j.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                    uri2.setFlags(268435456);
                    this.f4083j.startActivity(uri2);
                    this.f4086m = true;
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
                    af.b(f4078a, th3.getMessage());
                }
                af.b(f4078a, th.getMessage());
                return false;
            }
            if (com.mbridge.msdk.click.c.e(this.f4083j, str)) {
                af.b(f4078a, "openDeepLink");
                this.f4086m = true;
                return true;
            }
        }
        return false;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final boolean b(WebView webView, final String str) {
        af.b(f4078a, "shouldOverrideUrlLoading1  " + str);
        this.f4080c = false;
        if (aj.a.b(str) && aj.a.a(this.f4083j, str, null)) {
            this.f4086m = true;
        }
        boolean zE = e(webView, str);
        if (zE) {
            this.f4088o = 0L;
            this.f4080c = false;
            c();
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f4082i != null && a.this.f4085l != null) {
                        a.this.f4085l.setSuccess(true);
                        a.this.f4085l.setUrl(str);
                        a.this.f4085l.setType(2);
                        a.this.f4082i.a(a.this.f4085l, a.this.h, 1, true);
                    }
                    if (a.this.f != null) {
                        a.this.f.onFinishRedirection(a.this.h, str);
                    }
                }
            });
        }
        return zE;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void c(WebView webView, final String str) {
        af.b(f4078a, "onPageFinished1  " + str);
        if (this.f4080c) {
            this.f4088o = 0L;
            this.f4080c = false;
            com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.f != null) {
                        a.this.f.onFinishRedirection(a.this.h, str);
                    }
                    if (a.this.f4082i == null || a.this.f4085l == null) {
                        return;
                    }
                    a.this.f4085l.setSuccess(true);
                    a.this.f4085l.setUrl(str);
                    a.this.f4085l.setType(2);
                    a.this.f4082i.a(a.this.f4085l, a.this.h, 1, true);
                }
            });
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c();
            Uri uri = Uri.parse(str);
            if ((uri.getScheme().equals("http") || uri.getScheme().equals("https")) && !this.f4086m) {
                this.f4086m = true;
                a(this.f4083j, str, this.h);
            }
        }
    }

    private void c() {
        this.f4084k.removeCallbacks(this.f4087n);
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str) {
        if (this.f4088o == 0) {
            this.f4088o = System.currentTimeMillis();
            if (!this.e) {
                this.e = true;
                d();
            }
        }
        this.f4081d = str;
        this.f4080c = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, String str, Bitmap bitmap) {
        if (this.f4088o == 0) {
            this.f4088o = System.currentTimeMillis();
            if (!this.e) {
                this.e = true;
                d();
            }
            this.f4086m = false;
        }
        this.f4081d = str;
        this.f4080c = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a(WebView webView, int i10, final String str, final String str2) {
        af.d(f4078a, str);
        c();
        com.mbridge.msdk.foundation.same.f.a.e().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.webview.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.f != null) {
                    a.this.f.onFinishRedirection(a.this.h, str2);
                }
                if (a.this.f4082i == null || a.this.f4085l == null) {
                    return;
                }
                a.this.f4085l.setSuccess(false);
                a.this.f4085l.setUrl(str2);
                a.this.f4085l.setType(2);
                a.this.f4085l.setExceptionMsg(str);
                a.this.f4082i.a(a.this.f4085l, a.this.h, 1, true);
            }
        });
        if (!d(webView, str2) || this.f4086m) {
            return;
        }
        this.f4086m = true;
        a(this.f4083j, str2, this.h);
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
    public final void a() {
    }

    private void d() {
        this.f4084k.postDelayed(this.f4087n, this.f4079b);
    }
}

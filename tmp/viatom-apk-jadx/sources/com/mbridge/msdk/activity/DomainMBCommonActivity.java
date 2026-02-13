package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.mbridge.msdk.click.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.tools.at;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class DomainMBCommonActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    String f2623a = "";

    /* renamed from: b, reason: collision with root package name */
    private final BrowserView.a f2624b = new BrowserView.a() { // from class: com.mbridge.msdk.activity.DomainMBCommonActivity.1
        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str, Bitmap bitmap) {
            af.b("MBCommonActivity", "onPageStarted  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final boolean b(WebView webView, String str) {
            af.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (aj.a.b(str) && aj.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void c(WebView webView, String str) {
            af.b("MBCommonActivity", "onPageFinished  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, String str) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
        public final void a(WebView webView, int i10, String str, String str2) {
        }
    };
    protected BrowserView browserView;

    /* renamed from: c, reason: collision with root package name */
    private CampaignEx f2625c;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        String str2;
        try {
        } catch (Throwable th) {
            af.b("MBCommonActivity", th.getMessage());
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        if (!uri.getScheme().equals("http") && !uri.getScheme().equals("https")) {
            if (uri.getScheme().equals("intent") || uri.getScheme().equals("android-app")) {
                Intent uri2 = uri.getScheme().equals("intent") ? Intent.parseUri(str, 1) : uri.getScheme().equals("android-app") ? Intent.parseUri(str, 2) : null;
                if (uri2 != null) {
                    uri2.setComponent(null);
                    uri2.setSelector(null);
                }
                try {
                    str2 = uri2.getPackage();
                } catch (Throwable th2) {
                    af.b("MBCommonActivity", th2.getMessage());
                }
                if (!TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                    uri2.setFlags(268435456);
                    startActivityForResult(uri2, 0);
                    finish();
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
                    af.b("MBCommonActivity", th3.getMessage());
                }
                af.b("MBCommonActivity", th.getMessage());
                return false;
            }
            if (c.e(this, str)) {
                af.b("MBCommonActivity", "openDeepLink");
                finish();
                return true;
            }
            if (!TextUtils.isEmpty(str)) {
                return !(str.startsWith("http") || str.startsWith("https"));
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            af.b("MBCommonActivity", th.getMessage());
        }
        if (com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            com.mbridge.msdk.foundation.controller.c.m().b(getApplicationContext());
        }
        com.mbridge.msdk.foundation.controller.c.m().a(this);
        String stringExtra = getIntent().getStringExtra("url");
        this.f2623a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.f2625c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
        if (b.f4097a.containsKey(this.f2623a)) {
            BrowserView browserView = b.f4097a.get(this.f2623a);
            this.browserView = browserView;
            if (browserView != null) {
                browserView.setListener(this.f2624b);
            }
        } else {
            BrowserView browserView2 = new BrowserView(this, this.f2625c);
            this.browserView = browserView2;
            browserView2.setListener(this.f2624b);
            this.browserView.loadUrl(this.f2623a);
        }
        BrowserView browserView3 = this.browserView;
        if (browserView3 != null) {
            at.a(browserView3);
            setContentView(this.browserView);
        }
    }
}

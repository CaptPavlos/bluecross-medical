package com.mbridge.msdk.mbbanner.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;
import com.mbridge.msdk.mbsignalcommon.base.b;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends b {

    /* renamed from: a, reason: collision with root package name */
    String f4303a;

    /* renamed from: b, reason: collision with root package name */
    List<CampaignEx> f4304b;

    /* renamed from: c, reason: collision with root package name */
    com.mbridge.msdk.mbbanner.common.b.a f4305c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4306d = "BannerWebViewClient";

    public a(String str, List<CampaignEx> list, com.mbridge.msdk.mbbanner.common.b.a aVar) {
        this.f4303a = str;
        this.f4304b = list;
        this.f4305c = aVar;
    }

    private void a(WebView webView, String str) {
        webView.evaluateJavascript(str, new ValueCallback<String>() { // from class: com.mbridge.msdk.mbbanner.view.a.1
            @Override // android.webkit.ValueCallback
            public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
            }
        });
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        CampaignEx campaignEx;
        super.onPageStarted(webView, str, bitmap);
        try {
            a(webView, "javascript:" + com.mbridge.msdk.c.b.a.a().b());
            List<CampaignEx> list = this.f4304b;
            if (list == null || list.isEmpty() || (campaignEx = this.f4304b.get(0)) == null || !campaignEx.isActiveOm()) {
                return;
            }
            a(webView, "javascript:" + MBridgeConstans.OMID_JS_SERVICE_CONTENT);
        } catch (Throwable th) {
            af.b("BannerWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            af.b("BannerWebViewClient", "Use html to open url.");
            BaseWebView baseWebView = (BaseWebView) webView;
            if (System.currentTimeMillis() - baseWebView.lastTouchTime > com.mbridge.msdk.click.b.a.f2793c && com.mbridge.msdk.click.b.a.a(this.f4304b.get(0), baseWebView.getUrl(), com.mbridge.msdk.click.b.a.f2792b)) {
                return false;
            }
            if (this.f4304b.size() > 1) {
                c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                str = null;
            }
            com.mbridge.msdk.mbbanner.common.b.a aVar = this.f4305c;
            if (aVar != null) {
                aVar.a(false, str);
            }
            return true;
        } catch (Throwable th) {
            af.b("BannerWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}

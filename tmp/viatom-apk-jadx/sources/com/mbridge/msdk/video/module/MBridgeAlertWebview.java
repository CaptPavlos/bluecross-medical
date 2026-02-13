package com.mbridge.msdk.video.module;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.g.a;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.download.d;
import com.mbridge.msdk.videocommon.download.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeAlertWebview extends MBridgeH5EndCardView {

    /* renamed from: w, reason: collision with root package name */
    private String f5898w;

    public MBridgeAlertWebview(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final String a() {
        if (TextUtils.isEmpty(this.unitId)) {
            return "";
        }
        b.a().a(c.m().k(), this.unitId, false);
        String str = com.mbridge.msdk.videocommon.d.c.f6516a;
        this.f5898w = str;
        return !TextUtils.isEmpty(str) ? d.a().a(this.f5898w) : "";
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String strA = a();
        if (!this.e || this.f5901b == null || TextUtils.isEmpty(strA)) {
            this.notifyListener.a(101, "");
            return;
        }
        a aVar = new a(this.f5901b);
        aVar.a(this.f5901b.getAppName());
        this.f5945p.setDownloadListener(aVar);
        this.f5945p.setCampaignId(this.f5901b.getId());
        setCloseVisible(8);
        this.f5945p.setApiManagerJSFactory(bVar);
        this.f5945p.setWebViewListener(new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.video.module.MBridgeAlertWebview.1
            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i10) {
                super.a(webView, i10);
                af.b("MBridgeAlertWebview", "readyState  :  " + i10);
                MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                if (mBridgeAlertWebview.t) {
                    return;
                }
                boolean z9 = i10 == 1;
                mBridgeAlertWebview.f5948s = z9;
                String strF = z9 ? a3.a.f(i10, "readyState state is ") : "";
                MBridgeAlertWebview mBridgeAlertWebview2 = MBridgeAlertWebview.this;
                i.a(mBridgeAlertWebview2.f5900a, mBridgeAlertWebview2.f5901b, mBridgeAlertWebview2.f5898w, MBridgeAlertWebview.this.unitId, i10, strF, 1);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, int i10, String str, String str2) {
                super.a(webView, i10, str, str2);
                af.b("MBridgeAlertWebview", "onReceivedError");
                if (MBridgeAlertWebview.this.t) {
                    return;
                }
                androidx.constraintlayout.core.widgets.analyzer.a.E("onReceivedError,url:", str2, MBridgeBaseView.TAG);
                MBridgeAlertWebview mBridgeAlertWebview = MBridgeAlertWebview.this;
                i.a(mBridgeAlertWebview.f5900a, mBridgeAlertWebview.f5901b, mBridgeAlertWebview.f5898w, MBridgeAlertWebview.this.unitId, 2, str, 1);
                MBridgeAlertWebview.this.t = true;
            }

            @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
            public final void a(WebView webView, String str) {
                super.a(webView, str);
                af.b("MBridgeAlertWebview", "finish+" + str);
                g.a().a(webView);
            }
        });
        setHtmlSource(e.a().b(strA));
        this.f5948s = false;
        if (TextUtils.isEmpty(this.f5947r)) {
            androidx.constraintlayout.core.widgets.analyzer.a.E("load url:", strA, MBridgeBaseView.TAG);
            this.f5945p.loadUrl(strA);
        } else {
            af.a(MBridgeBaseView.TAG, "load html...");
            this.f5945p.loadDataWithBaseURL(strA, this.f5947r, "text/html", C.UTF8_NAME, null);
        }
        this.f5945p.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardView
    public void webviewshow() {
        RelativeLayout relativeLayout = this.f5943n;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(0);
        }
        super.webviewshow();
        i.a(this.f5900a, this.f5901b, this.f5898w, this.unitId, 2, 1);
    }

    public MBridgeAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

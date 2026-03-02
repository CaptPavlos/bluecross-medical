package com.uptodown.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import e5.s;
import l4.w;
import l4.z;
import o4.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class CustomWebView extends w {
    public static final /* synthetic */ int J = 0;
    public String H;
    public String I;

    @Override // l4.w, p4.f, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.custom_web_view, (ViewGroup) null);
        viewInflate.getClass();
        setContentView(viewInflate);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.containsKey(CampaignEx.JSON_KEY_TITLE)) {
                this.H = extras.getString(CampaignEx.JSON_KEY_TITLE);
            }
            if (extras.containsKey("url")) {
                this.I = extras.getString("url");
            }
        }
        ((ImageView) findViewById(R.id.iv_back_custom_web_view)).setOnClickListener(new s(this, 6));
        TextView textView = (TextView) findViewById(R.id.tv_title_custom_web_view);
        textView.setTypeface(b.f11720s);
        textView.setText(this.H);
        WebView webView = (WebView) findViewById(R.id.wv_custom_web_view);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setSupportZoom(true);
        webView.setScrollBarStyle(33554432);
        webView.setScrollbarFadingEnabled(true);
        webView.setInitialScale(80);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.setWebViewClient(new z());
        String str = this.I;
        if (str != null) {
            webView.loadUrl(str);
        }
    }
}

package com.mbridge.msdk.foundation.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.fragment.BaseFragment;
import com.mbridge.msdk.foundation.tools.aj;
import com.mbridge.msdk.foundation.webview.BrowserView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WebViewFragment extends BaseFragment {
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        BrowserView browserView = new BrowserView(getActivity());
        browserView.loadUrl(getActivity().getIntent().getExtras().getString(NotificationCompat.CATEGORY_MESSAGE));
        browserView.setListener(new BrowserView.a() { // from class: com.mbridge.msdk.foundation.webview.WebViewFragment.1
            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a(WebView webView, String str, Bitmap bitmap) {
                if (aj.a.b(str) && aj.a.a(WebViewFragment.this.getActivity().getApplicationContext(), str, null)) {
                    WebViewFragment.this.getActivity().finish();
                }
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final boolean b(WebView webView, String str) {
                return false;
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a(WebView webView, String str) {
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a() {
                WebViewFragment.this.getActivity().finish();
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void a(WebView webView, int i10, String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.webview.BrowserView.a
            public final void c(WebView webView, String str) {
            }
        });
        return browserView;
    }
}

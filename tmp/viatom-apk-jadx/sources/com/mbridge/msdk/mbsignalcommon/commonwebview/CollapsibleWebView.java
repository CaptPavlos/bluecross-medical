package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class CollapsibleWebView extends CommonWebView {
    private CopyOnWriteArrayList<CommonWebView.a> e;
    private CopyOnWriteArrayList<CommonWebView.a> f;
    private CopyOnWriteArrayList<a> g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private String f4332i;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(View view, String str);

        void a(View view, Map<String, String> map);

        void b(View view, String str);

        void b(View view, Map<String, String> map);
    }

    public CollapsibleWebView(Context context) {
        super(context);
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.e.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView) {
        Iterator<CommonWebView.a> it = collapsibleWebView.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public String getCollapseIconName() {
        return this.h;
    }

    public String getExpandIconName() {
        return this.f4332i;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView
    public void init() throws Resources.NotFoundException {
        super.init();
        this.e = new CopyOnWriteArrayList<>();
        this.f = new CopyOnWriteArrayList<>();
        this.g = new CopyOnWriteArrayList<>();
        this.h = "mbridge_arrow_down_white_blackbg";
        this.f4332i = "mbridge_arrow_up_white";
        useDeeplink();
        initWebViewListener();
        useProgressBar();
        ArrayList<ToolBar.b> arrayList = new ArrayList<>();
        ToolBar.b bVar = new ToolBar.b("doCollapse");
        bVar.f4368c = false;
        bVar.f4367b = "mbridge_arrow_down_white_blackbg";
        bVar.f4369d = new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doCollapse");
                CollapsibleWebView.this.showToolBarButton("doSpand");
                CollapsibleWebView.a(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar);
        ToolBar.b bVar2 = new ToolBar.b("doSpand");
        bVar2.f4367b = "mbridge_arrow_up_black";
        bVar2.f4369d = new View.OnClickListener() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollapsibleWebView.this.hideToolBarButton("doSpand");
                CollapsibleWebView.this.showToolBarButton("doCollapse");
                CollapsibleWebView.b(CollapsibleWebView.this);
            }
        };
        arrayList.add(bVar2);
        useDefaultToolBar();
        useCustomizedToolBar(arrayList, true);
    }

    public void initWebViewListener() {
        setPageLoadTimtoutListener(new CommonWebView.b() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.3
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.b
            public final void a(String str) {
                CollapsibleWebView collapsibleWebView = CollapsibleWebView.this;
                CollapsibleWebView.a(collapsibleWebView, (View) collapsibleWebView.f4342d, str);
            }
        });
        setPageLoadTimtout(CommonWebView.DEFAULT_JUMP_TIMEOUT);
        addWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.4

            /* renamed from: a, reason: collision with root package name */
            Boolean f4336a = Boolean.FALSE;

            /* renamed from: b, reason: collision with root package name */
            String f4337b = "";

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                if (this.f4336a.booleanValue()) {
                    return;
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, str);
                this.f4336a = Boolean.FALSE;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f4337b = str;
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i10, String str, String str2) {
                HashMap map = new HashMap();
                map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                map.put("url", str2);
                map.put("description", str);
                if (!this.f4336a.booleanValue() && this.f4337b.equals(str2)) {
                    this.f4336a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                HashMap map = new HashMap();
                map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "http");
                String str = webResourceRequest.getUrl() + "";
                map.put("url", str);
                map.put("statusCode", webResourceResponse.getStatusCode() + "");
                map.put("description", "http error");
                if (!this.f4336a.booleanValue() && (this.f4337b.equals(str) || TextUtils.isEmpty(this.f4337b))) {
                    this.f4336a = Boolean.TRUE;
                    CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                HashMap map = new HashMap();
                map.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "ssl");
                map.put("url", sslError.getUrl());
                map.put("description", "ssl error");
                if (!this.f4336a.booleanValue()) {
                    if (this.f4337b.equals(sslError.getUrl() + "")) {
                        this.f4336a = Boolean.TRUE;
                        CollapsibleWebView.a(CollapsibleWebView.this, webView, map);
                    }
                }
                CollapsibleWebView.b(CollapsibleWebView.this, webView, map);
            }

            @Override // android.webkit.WebViewClient
            public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                af.b("CollapsibleWebView", "WebView called onRenderProcessGone");
                return true;
            }
        });
    }

    public void setCollapseIconName(String str) {
        this.h = str;
    }

    public void setCollapseListener(CommonWebView.a aVar) {
        this.e.add(aVar);
    }

    public void setCustomizedToolBarMarginWidthPixel(int i10, int i11, int i12, int i13) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4339a.getLayoutParams();
        layoutParams.setMargins(i10, i11, i12, i13);
        this.f4339a.setLayoutParams(layoutParams);
    }

    public void setExpandIconName(String str) {
        this.f4332i = str;
    }

    public void setExpandListener(CommonWebView.a aVar) {
        this.f.add(aVar);
    }

    public void setPageLoadListener(a aVar) {
        this.g.add(aVar);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public CollapsibleWebView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.g.iterator();
        while (it.hasNext()) {
            it.next().b(view, str);
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, String str) {
        Iterator<a> it = collapsibleWebView.g.iterator();
        while (it.hasNext()) {
            it.next().a(view, str);
        }
    }

    public static /* synthetic */ void a(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.g.iterator();
        while (it.hasNext()) {
            it.next().a(view, (Map<String, String>) map);
        }
    }

    public static /* synthetic */ void b(CollapsibleWebView collapsibleWebView, View view, Map map) {
        Iterator<a> it = collapsibleWebView.g.iterator();
        while (it.hasNext()) {
            it.next().b(view, (Map<String, String>) map);
        }
    }
}

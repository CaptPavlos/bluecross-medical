package com.mbridge.msdk.video.signal.factory;

import android.app.Activity;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.bt.module.MBridgeBTContainer;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.a;
import com.mbridge.msdk.video.signal.a.i;
import com.mbridge.msdk.video.signal.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.a.m;
import com.mbridge.msdk.video.signal.a.n;
import com.mbridge.msdk.video.signal.a.o;
import com.mbridge.msdk.video.signal.a.q;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends a {
    private Activity h;

    /* renamed from: i, reason: collision with root package name */
    private WebView f6467i;

    /* renamed from: j, reason: collision with root package name */
    private MBridgeVideoView f6468j;

    /* renamed from: k, reason: collision with root package name */
    private MBridgeContainerView f6469k;

    /* renamed from: l, reason: collision with root package name */
    private CampaignEx f6470l;

    /* renamed from: m, reason: collision with root package name */
    private MBridgeBTContainer f6471m;

    /* renamed from: n, reason: collision with root package name */
    private a.InterfaceC0069a f6472n;

    /* renamed from: o, reason: collision with root package name */
    private String f6473o;

    /* renamed from: p, reason: collision with root package name */
    private List<CampaignEx> f6474p;

    public b(Activity activity, WebView webView, MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, a.InterfaceC0069a interfaceC0069a) {
        this.h = activity;
        this.f6467i = webView;
        this.f6468j = mBridgeVideoView;
        this.f6469k = mBridgeContainerView;
        this.f6470l = campaignEx;
        this.f6472n = interfaceC0069a;
        this.f6473o = mBridgeVideoView.getUnitId();
    }

    public final void a(k kVar) {
        this.f6464b = kVar;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.b getActivityProxy() {
        WebView webView = this.f6467i;
        if (webView == null) {
            return super.getActivityProxy();
        }
        if (this.f6463a == null) {
            this.f6463a = new i(webView);
        }
        return this.f6463a;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.i getIJSRewardVideoV1() {
        Activity activity;
        MBridgeContainerView mBridgeContainerView = this.f6469k;
        if (mBridgeContainerView == null || (activity = this.h) == null) {
            return super.getIJSRewardVideoV1();
        }
        if (this.f == null) {
            this.f = new o(activity, mBridgeContainerView);
        }
        return this.f;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final c getJSBTModule() {
        if (this.h == null || this.f6471m == null) {
            return super.getJSBTModule();
        }
        if (this.g == null) {
            this.g = new j(this.h, this.f6471m);
        }
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final d getJSCommon() {
        CampaignEx campaignEx;
        List<CampaignEx> list;
        Activity activity = this.h;
        if (activity == null || (campaignEx = this.f6470l) == null) {
            return super.getJSCommon();
        }
        if (this.f6464b == null) {
            this.f6464b = new k(activity, campaignEx);
        }
        if (this.f6470l.getDynamicTempCode() == 5 && (list = this.f6474p) != null) {
            d dVar = this.f6464b;
            if (dVar instanceof k) {
                ((k) dVar).a(list);
            }
        }
        this.f6464b.a(this.h);
        this.f6464b.a(this.f6473o);
        this.f6464b.a(this.f6472n);
        return this.f6464b;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final f getJSContainerModule() {
        MBridgeContainerView mBridgeContainerView = this.f6469k;
        if (mBridgeContainerView == null) {
            return super.getJSContainerModule();
        }
        if (this.e == null) {
            this.e = new m(mBridgeContainerView);
        }
        return this.e;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final g getJSNotifyProxy() {
        WebView webView = this.f6467i;
        if (webView == null) {
            return super.getJSNotifyProxy();
        }
        if (this.f6466d == null) {
            this.f6466d = new n(webView);
        }
        return this.f6466d;
    }

    @Override // com.mbridge.msdk.video.signal.factory.a, com.mbridge.msdk.video.signal.factory.IJSFactory
    public final com.mbridge.msdk.video.signal.j getJSVideoModule() {
        MBridgeVideoView mBridgeVideoView = this.f6468j;
        if (mBridgeVideoView == null) {
            return super.getJSVideoModule();
        }
        if (this.f6465c == null) {
            this.f6465c = new q(mBridgeVideoView);
        }
        return this.f6465c;
    }

    public final void a(List<CampaignEx> list) {
        this.f6474p = list;
    }

    public b(Activity activity, MBridgeBTContainer mBridgeBTContainer, WebView webView) {
        this.h = activity;
        this.f6471m = mBridgeBTContainer;
        this.f6467i = webView;
    }

    public b(Activity activity) {
        this.h = activity;
    }
}

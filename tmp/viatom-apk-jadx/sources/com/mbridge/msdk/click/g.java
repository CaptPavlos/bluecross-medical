package com.mbridge.msdk.click;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends AppletSchemeCallBack {

    /* renamed from: a, reason: collision with root package name */
    private final NativeListener.NativeTrackingListener f2813a;

    /* renamed from: b, reason: collision with root package name */
    private final CampaignEx f2814b;

    /* renamed from: c, reason: collision with root package name */
    private final AppletsModel f2815c;

    /* renamed from: d, reason: collision with root package name */
    private final a f2816d;

    public g(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        this.f2813a = nativeTrackingListener;
        this.f2814b = campaignEx;
        this.f2815c = appletsModel;
        this.f2816d = aVar;
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestFailed(int i10, String str, String str2) {
        CampaignEx campaignEx = this.f2814b;
        if (campaignEx == null || this.f2815c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f2813a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultAppletSchemeCallBack", e.getMessage());
                    }
                }
            }
            this.f2815c.setUserClick(false);
            this.f2815c.setRequestingFinish();
            this.f2814b.setClickURL(str2);
            a aVar = this.f2816d;
            if (aVar != null) {
                try {
                    aVar.a(this.f2814b);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultAppletSchemeCallBack", e3.getMessage());
                    }
                }
            }
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                af.b("DefaultAppletSchemeCallBack", e7.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestSuccess(String str) {
        CampaignEx campaignEx = this.f2814b;
        if (campaignEx == null || this.f2815c == null) {
            return;
        }
        try {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f2813a;
            if (nativeTrackingListener != null) {
                try {
                    nativeTrackingListener.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultAppletSchemeCallBack", e.getMessage());
                    }
                }
            }
            this.f2815c.setUserClick(false);
            this.f2815c.setRequestingFinish();
            this.f2814b.setDeepLinkUrl(str);
            a aVar = this.f2816d;
            if (aVar != null) {
                try {
                    aVar.a(this.f2814b);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultAppletSchemeCallBack", e3.getMessage());
                    }
                }
            }
        } catch (Exception e7) {
            if (MBridgeConstans.DEBUG) {
                af.b("DefaultAppletSchemeCallBack", e7.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
    public final void onRequestStart() {
    }
}

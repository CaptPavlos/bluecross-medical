package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends d {

    /* renamed from: k, reason: collision with root package name */
    private MBridgeVideoView f6077k;

    /* renamed from: l, reason: collision with root package name */
    private MBridgeContainerView f6078l;

    public b(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i10, boolean z9) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i10, z9);
        this.f6077k = mBridgeVideoView;
        this.f6078l = mBridgeContainerView;
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f6088a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.a.a.d, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i10, Object obj) {
        if (this.f6088a) {
            if (i10 == 8) {
                MBridgeContainerView mBridgeContainerView = this.f6078l;
                if (mBridgeContainerView != null) {
                    boolean zShowAlertWebView = mBridgeContainerView.showAlertWebView();
                    MBridgeVideoView mBridgeVideoView = this.f6077k;
                    if (zShowAlertWebView) {
                        if (mBridgeVideoView != null) {
                            mBridgeVideoView.alertWebViewShowed();
                        }
                    } else if (mBridgeVideoView != null) {
                        mBridgeVideoView.showAlertView();
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView2 = this.f6077k;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.showAlertView();
                    }
                }
            } else if (i10 == 107) {
                this.f6078l.showVideoClickView(-1);
                this.f6077k.setCover(false);
                this.f6077k.setMiniEndCardState(false);
                this.f6077k.videoOperate(1);
            } else if (i10 == 112) {
                this.f6077k.setCover(true);
                this.f6077k.setMiniEndCardState(true);
                this.f6077k.videoOperate(2);
            } else if (i10 == 115) {
                this.f6078l.resizeMiniCard(this.f6077k.getBorderViewWidth(), this.f6077k.getBorderViewHeight(), this.f6077k.getBorderViewRadius());
            }
        }
        super.a(i10, obj);
    }
}

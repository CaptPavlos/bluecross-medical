package com.mbridge.msdk.video.module.a.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.video.signal.factory.IJSFactory;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends d {

    /* renamed from: k, reason: collision with root package name */
    private IJSFactory f6079k;

    public c(IJSFactory iJSFactory, CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i10, boolean z9) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i10, z9);
        this.f6079k = iJSFactory;
        if (iJSFactory == null) {
            this.f6088a = false;
        }
    }

    @Override // com.mbridge.msdk.video.module.a.a.d, com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public final void a(int i10, Object obj) {
        if (this.f6088a) {
            if (i10 == 8) {
                boolean zShowAlertWebView = this.f6079k.getJSContainerModule().showAlertWebView();
                IJSFactory iJSFactory = this.f6079k;
                if (zShowAlertWebView) {
                    iJSFactory.getJSVideoModule().alertWebViewShowed();
                } else {
                    iJSFactory.getJSVideoModule().showAlertView();
                }
            } else if (i10 == 105) {
                this.f6079k.getJSNotifyProxy().a(3, obj.toString());
                i10 = -1;
            } else if (i10 == 107) {
                this.f6079k.getJSContainerModule().showVideoClickView(-1);
                this.f6079k.getJSVideoModule().setCover(false);
                this.f6079k.getJSVideoModule().setMiniEndCardState(false);
                this.f6079k.getJSVideoModule().videoOperate(1);
            } else if (i10 == 112) {
                this.f6079k.getJSVideoModule().setCover(true);
                this.f6079k.getJSVideoModule().setMiniEndCardState(true);
                this.f6079k.getJSVideoModule().videoOperate(2);
            } else if (i10 == 115) {
                com.mbridge.msdk.video.signal.j jSVideoModule = this.f6079k.getJSVideoModule();
                this.f6079k.getJSContainerModule().resizeMiniCard(jSVideoModule.getBorderViewWidth(), jSVideoModule.getBorderViewHeight(), jSVideoModule.getBorderViewRadius());
            }
        }
        super.a(i10, obj);
    }
}

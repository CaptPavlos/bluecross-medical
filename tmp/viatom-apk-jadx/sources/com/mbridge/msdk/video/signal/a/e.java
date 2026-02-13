package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class e implements com.mbridge.msdk.video.signal.f, com.mbridge.msdk.video.signal.h {
    @Override // com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        af.a("DefaultJSContainerModule", "endCardShowing");
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        af.a("DefaultJSContainerModule", "hideAlertWebview ,msg=");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        af.a("DefaultJSContainerModule", "ivRewardAdsWithoutVideo,params=");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        af.a("DefaultJSContainerModule", "miniCardShowing");
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "notifyCloseBtn:state = ", "DefaultJSContainerModule");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void readyStatus(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "readyStatus:isReady=", "DefaultJSContainerModule");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i10, int i11, int i12) {
        StringBuilder sbQ = a3.a.q(i10, i11, "showMiniCard width = ", " height = ", " radius = ");
        sbQ.append(i12);
        af.a("DefaultJSContainerModule", sbQ.toString());
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        af.a("DefaultJSContainerModule", "showAlertWebView ,msg=");
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showEndcard(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "showEndcard,type=", "DefaultJSContainerModule");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i10, int i11, int i12, int i13, int i14) {
        StringBuilder sbQ = a3.a.q(i10, i11, "showMiniCard top = ", " left = ", " width = ");
        sbQ.append(i12);
        sbQ.append(" height = ");
        sbQ.append(i13);
        sbQ.append(" radius = ");
        sbQ.append(i14);
        af.a("DefaultJSContainerModule", sbQ.toString());
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "showVideoClickView:", "DefaultJSContainerModule");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        af.a("DefaultJSContainerModule", "showVideoEndCover");
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "toggleCloseBtn:state=", "DefaultJSContainerModule");
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i10, int i11, int i12) {
    }
}

package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h implements com.mbridge.msdk.video.signal.j {
    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        af.a("DefaultJSVideoModule", "alertWebViewShowed:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i10, int i11) {
        af.a("DefaultJSVideoModule", "closeOperte:close=" + i10 + "closeViewVisible=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        af.a("DefaultJSVideoModule", "dismissAllAlert");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        af.a("DefaultJSVideoModule", "getCurrentProgress");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i10) {
        af.a("DefaultJSVideoModule", "hideAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "notifyCloseBtn:", "DefaultJSVideoModule");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "progressBarOperate:progressViewVisible=", "DefaultJSVideoModule");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i10, int i11) {
        af.a("DefaultJSVideoModule", "progressOperate:progress=" + i10 + "progressViewVisible=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z9) {
        af.a("DefaultJSVideoModule", "setCover:" + z9);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z9) {
        af.a("DefaultJSVideoModule", "setMiniEndCardState");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "setScaleFitXY:", "DefaultJSVideoModule");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "setVisible:", "DefaultJSVideoModule");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        af.a("DefaultJSVideoModule", "showAlertView:");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        StringBuilder sbQ = a3.a.q(i10, i11, "showVideoLocation:marginTop=", ",marginLeft=", ",width=");
        sbQ.append(i12);
        sbQ.append(",height=");
        sbQ.append(i13);
        sbQ.append(",radius=");
        sbQ.append(i14);
        sbQ.append(",borderTop=");
        sbQ.append(i15);
        sbQ.append(",borderTop=");
        sbQ.append(i15);
        sbQ.append(",borderLeft=");
        sbQ.append(i16);
        sbQ.append(",borderWidth=");
        sbQ.append(i17);
        sbQ.append(",borderHeight=");
        sbQ.append(i18);
        af.a("DefaultJSVideoModule", sbQ.toString());
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i10, int i11) {
        af.a("DefaultJSVideoModule", "soundOperate:mute=" + i10 + ",soundViewVisible=" + i11);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "videoOperate:", "DefaultJSVideoModule");
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i10, int i11, String str) {
        StringBuilder sbQ = a3.a.q(i10, i11, "soundOperate:mute=", ",soundViewVisible=", ",pt=");
        sbQ.append(str);
        af.a("DefaultJSVideoModule", sbQ.toString());
    }
}

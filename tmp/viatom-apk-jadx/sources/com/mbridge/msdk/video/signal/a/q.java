package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.video.module.MBridgeVideoView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q extends r {
    public q(MBridgeVideoView mBridgeVideoView) {
        this.f6170a = mBridgeVideoView;
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void alertWebViewShowed() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.alertWebViewShowed();
        } else {
            super.alertWebViewShowed();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void closeVideoOperate(int i10, int i11) {
        super.closeVideoOperate(i10, i11);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.closeVideoOperate(i10, i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void dismissAllAlert() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.dismissAllAlert();
        } else {
            super.dismissAllAlert();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewHeight() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewHeight() : super.getBorderViewHeight();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewLeft() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewLeft() : super.getBorderViewLeft();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewRadius() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewRadius() : super.getBorderViewRadius();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewTop() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewTop() : super.getBorderViewTop();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final int getBorderViewWidth() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getBorderViewWidth() : super.getBorderViewWidth();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final String getCurrentProgress() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.getCurrentProgress() : super.getCurrentProgress();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void hideAlertView(int i10) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.hideAlertView(i10);
        } else {
            super.hideAlertView(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final boolean isH5Canvas() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        return mBridgeVideoView != null ? mBridgeVideoView.isH5Canvas() : super.isH5Canvas();
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void progressBarOperate(int i10) {
        super.progressBarOperate(i10);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressBarOperate(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void progressOperate(int i10, int i11) {
        super.progressOperate(i10, i11);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.progressOperate(i10, i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setCover(boolean z9) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(z9);
        } else {
            super.setCover(z9);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setMiniEndCardState(boolean z9) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setMiniEndCardState(z9);
        } else {
            super.setMiniEndCardState(z9);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setScaleFitXY(int i10) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setScaleFitXY(i10);
        } else {
            super.setScaleFitXY(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void setVisible(int i10) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVisible(i10);
        } else {
            super.setVisible(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showAlertView() {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showAlertView();
        } else {
            super.showAlertView();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showIVRewardAlertView(String str) {
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showIVRewardAlertView(str);
        } else {
            super.showIVRewardAlertView(str);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void showVideoLocation(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        super.showVideoLocation(i10, i11, i12, i13, i14, i15, i16, i17, i18);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.showVideoLocation(i10, i11, i12, i13, i14, i15, i16, i17, i18);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void soundOperate(int i10, int i11) {
        super.soundOperate(i10, i11);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i10, i11);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void videoOperate(int i10) {
        super.videoOperate(i10);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.videoOperate(i10);
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.h, com.mbridge.msdk.video.signal.j
    public final void soundOperate(int i10, int i11, String str) {
        super.soundOperate(i10, i11, str);
        MBridgeVideoView mBridgeVideoView = this.f6170a;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.soundOperate(i10, i11, str);
        }
    }
}

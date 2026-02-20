package com.mbridge.msdk.video.signal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface j {
    void alertWebViewShowed();

    void closeVideoOperate(int i10, int i11);

    void dismissAllAlert();

    int getBorderViewHeight();

    int getBorderViewLeft();

    int getBorderViewRadius();

    int getBorderViewTop();

    int getBorderViewWidth();

    String getCurrentProgress();

    void hideAlertView(int i10);

    boolean isH5Canvas();

    void notifyCloseBtn(int i10);

    void progressBarOperate(int i10);

    void progressOperate(int i10, int i11);

    void setCover(boolean z9);

    void setMiniEndCardState(boolean z9);

    void setScaleFitXY(int i10);

    void setVisible(int i10);

    void showAlertView();

    void showIVRewardAlertView(String str);

    void showVideoLocation(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18);

    void soundOperate(int i10, int i11);

    void soundOperate(int i10, int i11, String str);

    void videoOperate(int i10);
}

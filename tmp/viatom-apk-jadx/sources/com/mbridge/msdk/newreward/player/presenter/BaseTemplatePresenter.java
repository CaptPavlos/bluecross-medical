package com.mbridge.msdk.newreward.player.presenter;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.VideoPlayerStatusListener;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseTemplatePresenter extends AbsPresenter implements VideoPlayerStatusListener {
    private static final int AD_SCAPE_VALUE = 1;
    private static final int VIDEO_ERROR_RULE_VALUE = 1;
    private final String TAG;
    boolean closeBtnVisible;
    int currentPlayProgress;
    boolean dialogContinueClicked;
    boolean hasIteratorPercentage;
    IPlayTempleView iView;
    boolean isAlertShowing;
    boolean isCloseBtnClicked;
    private ConcurrentHashMap<Integer, Integer> omsdkPercentageMap;
    private ConcurrentHashMap<Integer, Integer> percentageMap;
    public boolean playTemplateRanderSuccess;
    IPlayModel playTempleModel;
    private boolean progressHasDoAdSuccess;
    int videoCompleteTime;
    int videoSkipTime;
    int videoTotalLength;

    public BaseTemplatePresenter(IBaseView iBaseView) {
        super(iBaseView);
        this.TAG = "BaseTemplatePresenter";
        this.closeBtnVisible = false;
        this.isCloseBtnClicked = false;
        this.hasIteratorPercentage = false;
        this.percentageMap = new ConcurrentHashMap<>();
        this.omsdkPercentageMap = new ConcurrentHashMap<>();
        this.progressHasDoAdSuccess = false;
        this.playTemplateRanderSuccess = true;
        this.isAlertShowing = false;
        this.dialogContinueClicked = false;
    }

    private void advImpList(int i10) {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || campaignEx.getAdvImpList() == null) {
            return;
        }
        try {
            if (this.campaignEx.getAdvImpList().isEmpty()) {
                return;
            }
            this.redirectModel.setCurrPercentAge(i10);
            this.playTempleModel.eventAdvImpList(this.redirectModel);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void callbackAdClose() {
        if (isIVRewardEnable()) {
            this.playTempleModel.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.ivRewardAlertViewStatus);
        }
        adClosed();
        if (this.isCloseBtnClicked) {
            this.playTempleModel.eventTrackingForClose(this.redirectModel);
        }
        if (!this.isIV && !this.adapterModel.X() && this.adapterModel.ab()) {
            this.adapterModel.i(true);
            this.playTempleModel.eventAddReward(this.redirectModel);
        }
        finish(true);
    }

    private void checkOMSdkProgress(int i10, int i11) {
        try {
            if (this.playTempleModel != null) {
                if (this.omsdkPercentageMap.isEmpty()) {
                    for (int i12 = 0; i12 <= 100; i12 += 25) {
                        this.omsdkPercentageMap.put(Integer.valueOf((i11 * i12) / 100), Integer.valueOf(i12));
                    }
                }
                if (i10 == 1 && this.omsdkPercentageMap.contains(0)) {
                    i10 = 0;
                }
                if (this.omsdkPercentageMap.containsKey(Integer.valueOf(i10))) {
                    int iIntValue = this.omsdkPercentageMap.get(Integer.valueOf(i10)).intValue();
                    this.omsdkPercentageMap.remove(Integer.valueOf(i10));
                    this.playTempleModel.checkOMSdkProgress(iIntValue, i11);
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void checkPlayCloseBtnState(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        if (i10 == i11) {
            this.closeBtnVisible = true;
            this.iView.setAdCloseVisibility(true);
        }
        if (!this.adapterModel.ab() && (i14 = this.videoCompleteTime) > 0 && i10 > i14) {
            this.adapterModel.m(true);
        }
        if ((this.closeBtnVisible || (i13 = this.videoSkipTime) < 0 || i10 < i13) && ((i12 = this.videoCompleteTime) <= 0 || i10 <= i12)) {
            return;
        }
        this.closeBtnVisible = true;
        this.iView.setAdCloseVisibility(true);
    }

    private void checkTrackingForPlayPercentage(int i10, int i11) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap;
        ConcurrentHashMap<Integer, Integer> concurrentHashMap2;
        try {
            if (!this.hasIteratorPercentage && (concurrentHashMap2 = this.percentageMap) != null && concurrentHashMap2.isEmpty()) {
                this.hasIteratorPercentage = true;
                Iterator<Map<Integer, String>> it = this.campaignEx.getNativeVideoTracking().i().iterator();
                while (it.hasNext()) {
                    Iterator<Map.Entry<Integer, String>> it2 = it.next().entrySet().iterator();
                    while (it2.hasNext()) {
                        this.percentageMap.put(Integer.valueOf((int) ((r3.getKey().intValue() / 100.0f) * i11)), it2.next().getKey());
                    }
                }
            }
            if (i10 == 1 && (concurrentHashMap = this.percentageMap) != null && concurrentHashMap.containsKey(0)) {
                i10 = 0;
            }
            ConcurrentHashMap<Integer, Integer> concurrentHashMap3 = this.percentageMap;
            if (concurrentHashMap3 == null || !concurrentHashMap3.containsKey(Integer.valueOf(i10))) {
                return;
            }
            int iIntValue = this.percentageMap.get(Integer.valueOf(i10)).intValue();
            this.percentageMap.remove(Integer.valueOf(i10));
            this.redirectModel.setPercentRate(iIntValue);
            this.playTempleModel.eventTrackingForPlayPercentage(this.redirectModel, iIntValue);
        } catch (Exception e) {
            af.b("BaseTemplatePresenter", e.getMessage());
        }
    }

    private void closeOrShowHalfEndCard() {
        c cVar = this.commandManager;
        cVar.g(cVar.a("add_temple", "HALF_TEMPLATE_EC", "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
        this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
    }

    private void doVideoEndTypeLogic() {
        try {
            int i10 = this.videoEndType;
            if (i10 == 1) {
                callbackAdClose();
                return;
            }
            if (i10 == 2) {
                showEndCard("");
                return;
            }
            if (i10 == 3) {
                showEndCard("VAST");
                return;
            }
            if (i10 == 4) {
                showEndCard("SHOW_CLICK_URL");
                IPlayModel iPlayModel = this.playTempleModel;
                if (iPlayModel != null) {
                    iPlayModel.eventTrackingForClick(this.redirectModel);
                    this.playTempleModel.eventNoticeUrl(this.redirectModel, 2);
                    this.playTempleModel.onAdClick(this.mBridgeIds);
                    return;
                }
                return;
            }
            if (i10 != 5) {
                if (i10 != 100) {
                    showEndCard("");
                    return;
                } else {
                    showEndCard("404");
                    return;
                }
            }
            com.mbridge.msdk.click.c.d(this.context, com.mbridge.msdk.click.c.a(this.campaignEx.getClickURL(), "-999", "-999"));
            IPlayModel iPlayModel2 = this.playTempleModel;
            if (iPlayModel2 != null) {
                iPlayModel2.eventTrackingForClick(this.redirectModel);
                this.playTempleModel.eventNoticeUrl(this.redirectModel, 2);
                this.playTempleModel.onAdClick(this.mBridgeIds);
            }
            callbackAdClose();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            finish(true);
        }
    }

    private void initCountDown() {
        c cVar = this.commandManager;
        Object objD = cVar.d(cVar.a("videoCompleteTime", Integer.valueOf(this.videoCompleteTime)), f.TEMP_PLAY_START_COUNT_DOWN);
        if (this.iView.getCountDownView() != null) {
            try {
                if (objD instanceof Map) {
                    Map map = (Map) objD;
                    int iIntValue = ((Integer) map.get("width")).intValue();
                    int iIntValue2 = ((Integer) map.get("height")).intValue();
                    int iIntValue3 = ((Integer) map.get("background")).intValue();
                    int iIntValue4 = ((Integer) map.get("padding")).intValue();
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iView.getCountDownView().getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.width = iIntValue;
                        layoutParams.height = iIntValue2;
                    }
                    this.iView.setCountDown("", iIntValue4, iIntValue3, layoutParams);
                }
            } catch (Throwable th) {
                af.b("BaseTemplatePresenter", th.getMessage());
            }
        }
    }

    private void setCountDownInfo(int i10, int i11) {
        try {
            c cVar = this.commandManager;
            Object objD = cVar.d(cVar.a("campaign", this.campaignEx, "isIV", Boolean.valueOf(this.isIV), "videoCompleteTime", Integer.valueOf(this.videoCompleteTime), "videoSkipTime", Integer.valueOf(this.videoSkipTime), "curPlayPosition", Integer.valueOf(i10), "allDuration", Integer.valueOf(i11)), f.TEMP_PLAY_PROGRESS_COUNT_DOWN);
            if ((objD instanceof Map) && ((Integer) ((Map) objD).get("valueVisible")).intValue() == 0) {
                this.iView.setCountDown((String) ((Map) objD).get("countMsg"), 0, 0, null);
            }
            IPlayTempleView iPlayTempleView = this.iView;
            if (iPlayTempleView == null || iPlayTempleView.getPrivacyButton() == null) {
                return;
            }
            this.iView.getPrivacyButton().setTag(String.valueOf(i10));
        } catch (Exception e) {
            af.b("BaseTemplatePresenter", e.getMessage());
        }
    }

    private void setSegmentsProgressBarState() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null && campaignEx.getProgressBarShow() == 1) {
            this.iView.setSegmentsProgressBar(0);
        }
    }

    private void setSkipAndCompleteTime(int i10) {
        if (this.campaignEx.getVst() > -2) {
            this.videoSkipTime = this.campaignEx.getVst();
        } else if (this.adapterModel.x().b() != null) {
            this.videoSkipTime = this.adapterModel.x().b().e();
        }
        int videoCompleteTime = this.campaignEx.getVideoCompleteTime();
        this.videoCompleteTime = videoCompleteTime;
        if (videoCompleteTime <= 0) {
            this.videoCompleteTime = i10;
        }
    }

    private void showEndCard(String str) {
        try {
            c cVar = this.commandManager;
            if (TextUtils.isEmpty(str)) {
                str = this.adapterModel.aj();
            }
            cVar.g(cVar.a("add_temple", str, "adapter_model", this.adapterModel, "template_type", 18, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
            this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
            finish(false);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void showIVRewardDialogOnPlayMode() {
        if (isIVRewardEnable() && this.ivRewardAlertViewStatus == a.F && this.ivRewardMode == a.I) {
            int i10 = this.ivRewardValueType;
            if (i10 == a.J && ((int) ((this.currentPlayProgress / this.videoTotalLength) * 100.0f)) >= this.ivRewardValue) {
                onPause();
                this.ivRewardAlertViewStatus = a.G;
                this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
                this.iView.alertShow();
                return;
            }
            if (i10 != a.K || this.currentPlayProgress < this.ivRewardValue) {
                return;
            }
            onPause();
            this.ivRewardAlertViewStatus = a.G;
            this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
            this.iView.alertShow();
        }
    }

    private void updatePlayCampaignFrequence() {
        this.commandManager.a(this.adapterModel, "PlayFrequenceReceiver");
    }

    private void updateSegmentsProgressBar(int i10, int i11) {
        try {
            if (this.iView.getSegmentsProgressBar() == null || this.iView.getSegmentsProgressBar().getVisibility() != 0) {
                return;
            }
            this.iView.getSegmentsProgressBar().setProgress((i10 * 100) / i11, 0);
        } catch (Exception e) {
            af.b("BaseTemplatePresenter", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adClosed() {
        if (this.adapterModel.aa()) {
            return;
        }
        this.adapterModel.l(true);
        if (this.reward != null) {
            this.playTempleModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 1);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adShowFail(String str, int i10) {
        if (this.adapterModel.Y()) {
            return;
        }
        this.adapterModel.j(true);
        super.adShowFail(str, i10);
        IPlayModel iPlayModel = this.playTempleModel;
        if (iPlayModel != null) {
            iPlayModel.onShowFail(this.mBridgeIds, str, i10);
        }
        finish(true);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adShowSuccess() {
        if (this.adapterModel.Y()) {
            return;
        }
        super.adShowSuccess();
        if (!this.adapterModel.ah()) {
            this.playTempleModel.onAdShow(this.mBridgeIds);
            this.playTempleModel.eventOnlyImpression(this.redirectModel);
        }
        this.playTempleModel.eventImpression(this.redirectModel);
        updatePlayCampaignFrequence();
        this.playTempleModel.eventPvUrls(this.redirectModel);
        this.playTempleModel.eventTrackingForImpression(this.redirectModel);
        this.playTempleModel.eventAdUrlList(this.redirectModel);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        if (view.getId() == filterFindViewId(false, "mbridge_alertview_close_button")) {
            if (isIVRewardEnable()) {
                this.ivRewardAlertViewStatus = a.D;
            }
            this.isCloseBtnClicked = true;
            this.isAlertShowing = false;
            closeAdOrShowEndCard();
            this.iView.alertDismiss();
            return;
        }
        if (view.getId() == filterFindViewId(false, "mbridge_alertview_continue_button")) {
            if (isIVRewardEnable()) {
                this.ivRewardAlertViewStatus = a.E;
                this.dialogContinueClicked = true;
                this.iView.setAdCloseVisibility(false);
            }
            this.isAlertShowing = false;
            this.iView.alertDismiss();
        }
    }

    public void closeAdOrShowEndCard() {
        if (isIVRewardEnable()) {
            this.adapterModel.b(this.ivRewardAlertViewStatus);
        }
        if (this.videoSkipResult == 2) {
            doVideoEndTypeLogic();
        } else {
            callbackAdClose();
        }
        if (this.isCloseBtnClicked) {
            this.playTempleModel.eventTrackingForClose(this.redirectModel);
        }
    }

    public int getBufferTimeout() {
        try {
            com.mbridge.msdk.videocommon.d.a aVarA = this.adapterModel.x().a();
            if (aVarA != null) {
                return (int) aVarA.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel == null || motionEvent == null) {
            return;
        }
        redirectModel.setxInScreen(motionEvent.getRawX());
        this.redirectModel.setyInScreen(motionEvent.getRawY());
    }

    public boolean isHalfScreenOffer() {
        CampaignEx campaignEx = this.campaignEx;
        return campaignEx != null && campaignEx.getAdSpaceT() == 2;
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingEnd() {
        IPlayModel iPlayModel = this.playTempleModel;
        if (iPlayModel != null) {
            iPlayModel.onBufferingEnd();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onBufferingStart(String str) {
        IPlayModel iPlayModel = this.playTempleModel;
        if (iPlayModel != null) {
            iPlayModel.onBufferingStart(str);
        }
    }

    public void onCloseButtonClick() {
        if (this.isIV) {
            this.isCloseBtnClicked = true;
            if (this.campaignEx.getAdSpaceT() != 2) {
                showIVRewardDialogOnCloseMode();
            }
        } else if (this.adapterModel.ab()) {
            this.isCloseBtnClicked = true;
            closeAdOrShowEndCard();
            return;
        } else if (this.closeAlert == 1) {
            this.isAlertShowing = true;
            this.iView.setAlertViewType(this.adapterModel.H(), 1, -1);
            this.iView.alertShow();
        } else {
            this.isCloseBtnClicked = true;
            closeAdOrShowEndCard();
        }
        if (this.adapterModel.ab()) {
            return;
        }
        this.playTempleModel.skipped();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void onDestroy() {
        IPlayModel iPlayModel;
        super.onDestroy();
        if (!this.adapterModel.Y()) {
            this.adapterModel.j(true);
            super.adShowFail(com.mbridge.msdk.foundation.c.a.a(890003), 890003);
            IPlayModel iPlayModel2 = this.playTempleModel;
            if (iPlayModel2 != null) {
                iPlayModel2.onShowFail(this.mBridgeIds, com.mbridge.msdk.foundation.c.a.a(890003), 890003);
            }
        }
        if (this.adapterModel.aa()) {
            return;
        }
        this.adapterModel.l(true);
        if (this.reward == null || (iPlayModel = this.playTempleModel) == null) {
            return;
        }
        iPlayModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 1);
    }

    public void onPause() {
        this.iView.pause();
        if (this.isCloseBtnClicked || this.adapterModel.ab()) {
            return;
        }
        this.playTempleModel.eventTrackingForPause(this.redirectModel);
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        this.adapterModel.m(true);
        this.playTempleModel.onVideoComplete(this.mBridgeIds);
        if (this.campaignEx.getAdSpaceT() != 1) {
            closeOrShowHalfEndCard();
            return;
        }
        if (isIVRewardEnable()) {
            this.adapterModel.b(this.ivRewardAlertViewStatus);
        }
        doVideoEndTypeLogic();
        if (this.isCloseBtnClicked) {
            this.playTempleModel.eventTrackingForClose(this.redirectModel);
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        this.playTempleModel.eventTrackingForPlayError(this.redirectModel, str);
        if (this.adapterModel.x().b().C() != 1) {
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890004), 890004);
            return;
        }
        if (!this.progressHasDoAdSuccess) {
            this.progressHasDoAdSuccess = true;
            adShowSuccess();
        }
        if (this.campaignEx.getAdSpaceT() == 1) {
            closeAdOrShowEndCard();
        } else {
            closeOrShowHalfEndCard();
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i10, int i11) {
        if (this.iView == null || this.campaignEx == null) {
            return;
        }
        try {
            this.currentPlayProgress = i10;
            this.videoTotalLength = i11 == 0 ? 1 : i11;
            adShowSuccess();
            advImpList(i10);
            setCountDownInfo(i10, i11);
            if (isIVRewardEnable()) {
                showIVRewardDialogOnPlayMode();
            }
            updateSegmentsProgressBar(i10, i11);
            checkOMSdkProgress(i10, i11);
            checkPlayCloseBtnState(i10, i11);
            checkTrackingForPlayPercentage(this.currentPlayProgress, i11);
        } catch (Exception e) {
            af.b("BaseTemplatePresenter", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i10) {
        if (this.iView == null || this.campaignEx == null) {
            return;
        }
        try {
            setSkipAndCompleteTime(i10);
            initCountDown();
            this.iView.setMuteState(this.adapterModel.O() == 2);
            setSegmentsProgressBarState();
        } catch (Exception e) {
            af.b("BaseTemplatePresenter", e.getMessage());
        }
    }

    public void onResume() {
        this.iView.resume();
        this.playTempleModel.eventTrackingForResume(this.redirectModel);
    }

    public void showIVRewardDialogOnCloseMode() {
        if (!isIVRewardEnable()) {
            closeAdOrShowEndCard();
            return;
        }
        if (this.ivRewardMode == a.H) {
            int i10 = this.ivRewardValueType;
            if (i10 == a.J && ((int) ((this.currentPlayProgress / this.videoTotalLength) * 100.0f)) >= this.ivRewardValue) {
                closeAdOrShowEndCard();
            } else if (i10 == a.K && this.currentPlayProgress >= this.ivRewardValue) {
                closeAdOrShowEndCard();
            } else {
                this.iView.setAlertViewType(this.adapterModel.H(), 0, this.ivRewardMode);
                this.iView.alertShow();
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlaySetDataSourceError(String str) {
    }

    @Override // com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgressMS(int i10, int i11) {
    }
}

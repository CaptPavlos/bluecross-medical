package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IWebTemplateView;
import com.mbridge.msdk.newreward.player.model.WebTemplateModel;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayWebPresenter extends BaseTemplatePresenter implements b {
    final int CLOSE_BUILD_TYPE;
    private final String TAG;
    a feedbackDialogEventListener;
    boolean mCanResponseBackPress;
    Handler mHandler;
    boolean mNativeHandleClick;
    float mTouchX;
    float mTouchY;
    IWebTemplateView mWebTemplateView;
    private boolean muteState;
    public Runnable nativeCloseBtnVisibleRunnable;
    int webCloseViewStatus;

    public PlayWebPresenter(IWebTemplateView iWebTemplateView) {
        super(iWebTemplateView);
        this.TAG = "PlayWebPresenter";
        this.muteState = true;
        this.mNativeHandleClick = false;
        this.mCanResponseBackPress = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.webCloseViewStatus = -1;
        this.CLOSE_BUILD_TYPE = 2;
        this.nativeCloseBtnVisibleRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                PlayWebPresenter playWebPresenter = PlayWebPresenter.this;
                if (playWebPresenter.webCloseViewStatus != -1) {
                    return;
                }
                playWebPresenter.mWebTemplateView.setNativeCloseButtonVisibility(0);
            }
        };
        this.feedbackDialogEventListener = new a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter.3
            @Override // com.mbridge.msdk.foundation.d.a
            public void close() {
                PlayWebPresenter.this.firePrivacyFeedbackEvent(2);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void showed() {
                PlayWebPresenter.this.firePrivacyFeedbackEvent(1);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void summit(String str) {
                PlayWebPresenter.this.firePrivacyFeedbackEvent(2);
            }
        };
        IWebTemplateView iWebTemplateView2 = (IWebTemplateView) Proxy.newProxyInstance(iWebTemplateView.getClass().getClassLoader(), new Class[]{IWebTemplateView.class}, new e(iWebTemplateView, this.adapterModel, this.commandManager));
        this.mWebTemplateView = iWebTemplateView2;
        this.iView = iWebTemplateView2;
        this.TEMPLATE_MARK_TYPE = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void firePrivacyFeedbackEvent(int i10) {
        String strEncodeToString;
        try {
            JSONObject jSONObject = new JSONObject();
            if (c.m().c() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, i10);
            }
            strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage(), th);
            strEncodeToString = "";
        }
        MBCommunicatorUtil.fireEvent(this.mWebTemplateView.getWebView(), "onFeedbackAlertStatusNotify", strEncodeToString);
    }

    private void showCTAOrMiniEndCard(int i10) {
        if (i10 == -1) {
            this.mWebTemplateView.hideCTAView();
        }
        if (i10 == 1) {
            this.mWebTemplateView.showCTAView(this.adapterModel.H(), this.adapterModel.U());
        }
        if (i10 == 2) {
            this.mWebTemplateView.showMiniCard();
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adShowSuccess() {
        super.adShowSuccess();
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, cbd * 1000);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        if (view.getId() == filterFindViewId(false, "mbridge_alertview_close_button")) {
            onClick(8);
        } else if (view.getId() == filterFindViewId(false, "mbridge_alertview_continue_button")) {
            onClick(6);
        }
        super.click(view);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void finish(boolean z9) {
        try {
            releaseSource();
            if (z9) {
                ((Activity) this.context).finish();
                d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            }
            d.a().a(this.adapterModel.G());
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
            return 0;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        initDataForView(null);
    }

    public String getWebViewShowExtraData() throws JSONException {
        if (this.reward == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(RewardPlus.NAME, this.reward.a());
            jSONObject2.put(RewardPlus.AMOUNT, this.reward.b());
            jSONObject2.put("id", "");
            jSONObject.put("userId", "");
            jSONObject.put("reward", jSONObject2);
            jSONObject.put("playVideoMute", this.muteState);
            jSONObject.put("extra", this.adapterModel.W());
            return jSONObject.toString();
        } catch (JSONException e) {
            com.google.gson.internal.a.j(e);
            return null;
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter
    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        this.mTouchX = motionEvent.getRawX();
        this.mTouchY = motionEvent.getRawY();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        this.mWebTemplateView.initViews(false);
        if (this.campaignEx.getVideoUrlEncode() != null) {
            File fileG = this.adapterModel.g(this.campaignEx.getRequestIdNotice());
            if (this.campaignEx.getVst() > -2) {
                ((BaseTemplatePresenter) this).videoSkipTime = this.campaignEx.getVst();
            } else {
                ((BaseTemplatePresenter) this).videoSkipTime = this.adapterModel.x().b().e();
            }
            this.videoCompleteTime = this.campaignEx.getVideoCompleteTime();
            if (fileG == null || !fileG.exists()) {
                this.mWebTemplateView.play(this.campaignEx.getVideoUrlEncode(), getBufferTimeout());
            } else {
                this.mWebTemplateView.play(fileG.getAbsolutePath(), getBufferTimeout());
            }
        }
        ak.a(1, this.mWebTemplateView.getPrivacyButton(), this.adapterModel.U(), this.context, false, new a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayWebPresenter.1
            @Override // com.mbridge.msdk.foundation.d.a
            public void close() {
                PlayWebPresenter.this.mWebTemplateView.playOrPauseVideo(1);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void showed() {
                PlayWebPresenter.this.onPause();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void summit(String str) {
                PlayWebPresenter.this.mWebTemplateView.playOrPauseVideo(1);
            }
        });
        com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
        if (eVar == null || !eVar.aj().equals("WEB_EC")) {
            return;
        }
        com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
        cVar.i(cVar.a("web_resource_action", 1, "parent_temple", this.data.getRootViewGroup(), "adapter_model", this.adapterModel, "bridge_ids", this.campaignEx.getRequestIdNotice()), f.SHOW_OR_PRELOAD_WEB_EC);
    }

    public void onBackPressed() {
        if (this.mCanResponseBackPress) {
            onClick(2);
        }
    }

    public void onClick(int i10) {
        if (isIVRewardEnable()) {
            this.adapterModel.b(this.ivRewardAlertViewStatus);
        }
        if (i10 == 2) {
            onCloseButtonClick();
        }
        if (i10 == 5) {
            boolean muteState = this.iView.getMuteState();
            IPlayModel iPlayModel = this.playTempleModel;
            if (muteState) {
                iPlayModel.eventTrackingForUnMute(this.redirectModel);
                this.muteState = false;
            } else {
                iPlayModel.eventTrackingForMute(this.redirectModel);
                this.muteState = true;
            }
            this.mWebTemplateView.setMuteState(this.muteState);
        }
        if ((i10 != 1 && i10 != 3) || !this.mNativeHandleClick) {
            MBCommunicatorUtil.notifyClick(this.mWebTemplateView.getWebView(), i10, com.mbridge.msdk.newreward.function.h.b.a(this.mTouchX, this.mTouchY, 0));
            return;
        }
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null) {
            campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.g);
            CampaignEx campaignEx2 = this.campaignEx;
            if (i10 == 1) {
                campaignEx2.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3809n);
            } else {
                campaignEx2.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3808m);
            }
        }
        this.playTempleModel.onAdClick(this.mBridgeIds);
        this.playTempleModel.eventClickUrl(this.redirectModel);
        this.playTempleModel.eventTrackingForClick(this.redirectModel);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void onDestroy() {
        super.onDestroy();
        try {
            releaseSource();
            d.a().a(this.adapterModel.G());
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public void onDetachedFromWindow() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayCompleted() {
        super.onPlayCompleted();
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 1);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayError(String str) {
        super.onPlayError(str);
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 2);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i10, int i11) {
        super.onPlayProgress(i10, i11);
        try {
            JSONObject jSONObject = new JSONObject();
            if (i11 == 0) {
                i11 = this.campaignEx.getVideoLength();
            }
            if (i11 == 0) {
                i11 = 1;
            }
            jSONObject.put("progress", (int) (i10 / i11));
            jSONObject.put("time", i10);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, i11);
            IPlayModel iPlayModel = this.playTempleModel;
            if (iPlayModel instanceof WebTemplateModel) {
                ((WebTemplateModel) iPlayModel).setVideoProgressString(jSONObject.toString());
            }
            MBCommunicatorUtil.notifyVideoProgress(this.mWebTemplateView.getWebView(), i10, i11);
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i10) {
        super.onPlayStarted(i10);
        MBCommunicatorUtil.notifyVideoStatus(this.mWebTemplateView.getWebView(), 0);
    }

    public void onWebContentError() {
        this.mWebTemplateView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        if (this.adapterModel.Y()) {
            this.webCloseViewStatus = -1;
            this.mNativeHandleClick = true;
            this.mHandler.post(this.nativeCloseBtnVisibleRunnable);
        } else {
            this.mWebTemplateView.removeTempleFromSuperView(this.data.getRootViewGroup());
        }
        d.a().a(this.adapterModel.G());
    }

    public void onWebViewShow() {
        this.mWebTemplateView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
        if (!this.adapterModel.ac()) {
            this.adapterModel.n(true);
            this.playTempleModel.modelReport("2000146");
        }
        this.iView.release();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqSuccessful(Object obj) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONObject jSONObjectOptJSONObject3;
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String string = jSONObject.getString("action");
                    int i10 = 8;
                    switch (string.hashCode()) {
                        case -1765453640:
                            if (string.equals("toggleCloseBtn")) {
                                int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1);
                                this.webCloseViewStatus = iOptInt;
                                this.mHandler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
                                this.mWebTemplateView.setNativeCloseButtonVisibility(iOptInt == 1 ? 0 : 4);
                                break;
                            }
                            break;
                        case -1488920312:
                            if (string.equals("onReceivedError")) {
                                onWebContentError();
                                break;
                            }
                            break;
                        case -1410229111:
                            if (string.equals("videoOperate")) {
                                this.mWebTemplateView.playOrPauseVideo(jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -999));
                                break;
                            }
                            break;
                        case -1258199123:
                            if (string.equals("notifyCloseBtn")) {
                                int iOptInt2 = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1);
                                this.webCloseViewStatus = iOptInt2;
                                if (iOptInt2 == 0 || iOptInt2 == 1) {
                                    this.mHandler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
                                }
                                if (iOptInt2 == 1) {
                                    this.mCanResponseBackPress = true;
                                    break;
                                }
                            }
                            break;
                        case 94750088:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                                CampaignEx campaignEx = this.campaignEx;
                                if (campaignEx != null) {
                                    campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.g);
                                }
                                this.playTempleModel.onAdClick(this.mBridgeIds);
                                this.playTempleModel.eventTrackingForClick(this.redirectModel);
                                break;
                            }
                            break;
                        case 94756344:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                                this.mWebTemplateView.onCloseViewClick(2);
                                break;
                            }
                            break;
                        case 96046965:
                            if (string.equals("readyStatus")) {
                                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1) != 1) {
                                    onWebContentError();
                                    break;
                                } else {
                                    this.mWebTemplateView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
                                    break;
                                }
                            }
                            break;
                        case 131169903:
                            if (string.equals("showVideoClickView")) {
                                showCTAOrMiniEndCard(jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, -999));
                                break;
                            }
                            break;
                        case 181688693:
                            if (string.equals("soundOperate") && (jSONObjectOptJSONObject = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS)) != null) {
                                this.mWebTemplateView.setMuteState(jSONObjectOptJSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_MUTE, 2), jSONObjectOptJSONObject.optInt("view_visible", 2));
                                break;
                            }
                            break;
                        case 1691567443:
                            if (string.equals("showVideoLocation")) {
                                String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                                if (!TextUtils.isEmpty(strOptString)) {
                                    this.mWebTemplateView.changeVideoViewPosition(new JSONObject(strOptString));
                                    break;
                                }
                            }
                            break;
                        case 1779467262:
                            if (string.equals("progressBarOperate") && (jSONObjectOptJSONObject2 = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS)) != null) {
                                int iOptInt3 = jSONObjectOptJSONObject2.optInt("view_visible", 2);
                                IWebTemplateView iWebTemplateView = this.mWebTemplateView;
                                if (iOptInt3 != 1) {
                                    i10 = 0;
                                }
                                iWebTemplateView.setSegmentsProgressBar(i10);
                                break;
                            }
                            break;
                        case 1843897919:
                            if (string.equals("feedbackOperate")) {
                                String strOptString2 = jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "");
                                String strOptString3 = jSONObject.optString(NotificationCompat.CATEGORY_STATUS, "");
                                if (!TextUtils.isEmpty(strOptString2)) {
                                    JSONObject jSONObject2 = new JSONObject(strOptString3);
                                    if (strOptString2.equals("popup")) {
                                        com.mbridge.msdk.foundation.d.b.a().a(jSONObject2.optString("key", ""), jSONObject2.optInt("view_visible", 1), this.feedbackDialogEventListener);
                                    }
                                    if (strOptString2.equals("visibility")) {
                                        int iOptInt4 = jSONObject2.optInt("view_visible", 1);
                                        String strOptString4 = jSONObject2.optString("key", "");
                                        com.mbridge.msdk.foundation.d.b bVarA = com.mbridge.msdk.foundation.d.b.a();
                                        if (iOptInt4 != 1) {
                                            i10 = 0;
                                        }
                                        bVarA.a(strOptString4, i10, this.mWebTemplateView.getWebView());
                                    }
                                    if (strOptString2.equals(TtmlNode.TAG_LAYOUT)) {
                                        com.mbridge.msdk.foundation.d.b.a().a(jSONObject2.optString("key", ""), jSONObject2.optInt("width", -1), jSONObject2.optInt("height", -1), jSONObject2.optInt("radius", 20), jSONObject2.optInt(TtmlNode.LEFT, -1), jSONObject2.optInt("top", -1), (float) jSONObject2.optDouble("opacity", 1.0d), jSONObject2.optString("fontColor", ""), jSONObject2.optString("bgColor", ""), (float) jSONObject2.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d), jSONObject2.optJSONArray("padding"));
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            break;
                        case 1941013143:
                            if (string.equals("progressOperate") && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject(NotificationCompat.CATEGORY_STATUS)) != null) {
                                int iOptInt5 = jSONObjectOptJSONObject3.optInt("progress", -1);
                                int iOptInt6 = jSONObjectOptJSONObject3.optInt("view_visible", 2);
                                if (iOptInt5 != -1) {
                                    this.mWebTemplateView.seekToPlay(iOptInt5);
                                }
                                this.mWebTemplateView.getCountDownView().setVisibility(iOptInt6 == 2 ? 0 : 4);
                                break;
                            }
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            af.b("PlayWebPresenter", th.getMessage());
        }
    }

    public void setCanResponseBack(boolean z9) {
        this.mCanResponseBackPress = z9;
    }

    public void setNotchData(String str) {
        MBCommunicatorUtil.notifyNotchData(this.mWebTemplateView.getWebView(), str);
    }

    public void setTemplateModel(IPlayModel iPlayModel) {
        if (iPlayModel == null) {
            WebTemplateModel webTemplateModel = new WebTemplateModel(this.commandManager, this.adapterModel);
            webTemplateModel.setRenderType(this.TEMPLATE_MARK_TYPE);
            this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(WebTemplateModel.class.getClassLoader(), WebTemplateModel.class.getInterfaces(), new e(webTemplateModel, this.adapterModel, this.commandManager));
        } else {
            if (iPlayModel instanceof WebTemplateModel) {
                WebTemplateModel webTemplateModel2 = (WebTemplateModel) iPlayModel;
                webTemplateModel2.setCommandManager(this.commandManager);
                webTemplateModel2.setCallbackListener(this);
                webTemplateModel2.setRewardVideoListener(this.adapterModel.K());
            }
            this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(iPlayModel.getClass().getClassLoader(), iPlayModel.getClass().getInterfaces(), new e(iPlayModel, this.adapterModel, this.commandManager));
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }
}

package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
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
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.iview.IBaseWebView;
import com.mbridge.msdk.newreward.player.model.WebViewECModel;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MBCommunicatorUtil;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ECWebPresenter extends AbsPresenter implements b {
    final int END_CARD_BUILD_TYPE;
    private final String TAG;
    IECModel ecTempleModel;
    a feedbackDialogEventListener;
    boolean isLoadResourceError;
    boolean isShown;
    boolean isWebContentLoadFinish;
    boolean mCanResponseBackPress;
    Handler mHandler;
    float mTouchX;
    float mTouchY;
    IBaseWebView mWebContentView;
    int muteState;
    public Runnable nativeCloseBtnVisibleRunnable;
    int webCloseViewStatus;

    public ECWebPresenter(IBaseWebView iBaseWebView) {
        super(iBaseWebView);
        this.TAG = "ECWebPresenter";
        this.webCloseViewStatus = -1;
        this.muteState = -1;
        this.isLoadResourceError = false;
        this.isShown = false;
        this.isWebContentLoadFinish = false;
        this.END_CARD_BUILD_TYPE = 2;
        this.mCanResponseBackPress = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.nativeCloseBtnVisibleRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.ECWebPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                CampaignEx campaignEx;
                ECWebPresenter eCWebPresenter = ECWebPresenter.this;
                if (eCWebPresenter.webCloseViewStatus == -1 || (campaignEx = eCWebPresenter.campaignEx) == null || campaignEx.getVideo_end_type() == 4) {
                    ECWebPresenter.this.mWebContentView.setNativeCloseButtonVisibility(0);
                }
            }
        };
        this.feedbackDialogEventListener = new a() { // from class: com.mbridge.msdk.newreward.player.presenter.ECWebPresenter.2
            @Override // com.mbridge.msdk.foundation.d.a
            public void close() {
                ECWebPresenter.this.firePrivacyFeedbackEvent(2);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void showed() {
                ECWebPresenter.this.firePrivacyFeedbackEvent(1);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void summit(String str) {
                ECWebPresenter.this.firePrivacyFeedbackEvent(2);
            }
        };
        this.mWebContentView = (IBaseWebView) Proxy.newProxyInstance(iBaseWebView.getClass().getClassLoader(), new Class[]{IBaseWebView.class}, new e(iBaseWebView, this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 3;
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
            af.b("ECWebPresenter", th.getMessage(), th);
            strEncodeToString = "";
        }
        MBCommunicatorUtil.fireEvent(this.mWebContentView.getWebView(), "onFeedbackAlertStatusNotify", strEncodeToString);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adClosed() {
        if (this.adapterModel.aa()) {
            return;
        }
        this.adapterModel.l(true);
        if (this.reward != null) {
            this.ecTempleModel.onAdClose(this.mBridgeIds, new RewardInfo(this.adapterModel.ab(), this.reward.a(), String.valueOf(this.reward.b())), 2);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adShowSuccess() {
        if (this.adapterModel.Y()) {
            return;
        }
        this.adapterModel.j(true);
        super.adShowSuccess();
        this.ecTempleModel.onAdShow(this.mBridgeIds);
        this.ecTempleModel.eventImpression(this.redirectModel);
        this.ecTempleModel.eventOnlyImpression(this.redirectModel);
        this.ecTempleModel.eventPvUrls(this.redirectModel);
        this.ecTempleModel.eventTrackingForImpression(this.redirectModel);
    }

    public void addECModel() {
        WebViewECModel webViewECModel = new WebViewECModel(this.commandManager, this.adapterModel);
        webViewECModel.setCallbackListener(this);
        webViewECModel.setRenderType(this.TEMPLATE_MARK_TYPE);
        this.mWebContentView.getWebView().setHybridCommunicator(webViewECModel);
        this.mWebContentView.getWebView().setWebViewEventListener(webViewECModel);
        this.ecTempleModel = (IECModel) Proxy.newProxyInstance(WebViewECModel.class.getClassLoader(), new Class[]{IECModel.class}, new e(webViewECModel, this.adapterModel, this.commandManager));
    }

    public void changeNativeCloseButton() {
        int cbd = this.adapterModel.U().getCbd();
        if (cbd < 0) {
            cbd = this.adapterModel.x().b().p();
        }
        this.mHandler.postDelayed(this.nativeCloseBtnVisibleRunnable, cbd * 1000);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
        if (isIVRewardEnable()) {
            this.ecTempleModel.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.adapterModel.w());
        }
        adClosed();
        if (!this.isIV && this.adapterModel.ab()) {
            this.ecTempleModel.eventAddReward(this.redirectModel);
        }
        finish(true);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void finish(boolean z9) {
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        Context context = this.context;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public int getCampaignOrientation() {
        try {
            if (this.adapterModel.U() != null) {
                return this.adapterModel.U().getRewardTemplateMode().b();
            }
            return 0;
        } catch (Throwable th) {
            af.b("ECWebPresenter", th.getMessage());
            return 0;
        }
    }

    public int getRenderStatus() {
        return this.ecTempleModel.getRenderStatus();
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

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        this.mTouchX = motionEvent.getRawX();
        this.mTouchY = motionEvent.getRawY();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        this.mWebContentView.initViews(false);
        ak.a(2, this.mWebContentView.getPrivacyButton(), this.adapterModel.U(), this.context, false, this.feedbackDialogEventListener);
    }

    public void onActivityLifeCycleCallback(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.getClass();
        switch (str) {
            case "onDestroy":
                adClosed();
                finish(false);
                str2 = "onSystemDestory";
                break;
            case "onPause":
                str2 = "onSystemPause";
                break;
            case "onBackPressed":
                str2 = "onSystemBackPressed";
                break;
            case "onResume":
                str2 = "onSystemResume";
                break;
            default:
                str2 = "";
                break;
        }
        if (!TextUtils.isEmpty(str2)) {
            MBCommunicatorUtil.fireEvent(this.mWebContentView.getWebView(), str2, "");
        }
        if (str.equals("onBackPressed") && this.isShown && this.mCanResponseBackPress) {
            click(null);
        }
    }

    public void onDetachedFromWindow() {
        this.mHandler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
    }

    public void onShown() {
        adShowSuccess();
        if (this.ecTempleModel == null || this.adapterModel.Z()) {
            return;
        }
        int i10 = this.videoEndType;
        if (i10 != 4 && i10 != 5) {
            this.ecTempleModel.onEndCardShow(this.mBridgeIds, 2);
            this.ecTempleModel.eventTrackingForEndCardShow(this.redirectModel, 2);
        }
        this.isShown = true;
        if (this.isWebContentLoadFinish) {
            this.mWebContentView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
        }
        this.adapterModel.k(true);
        changeNativeCloseButton();
    }

    public void onWebContentError() {
        if (this.isLoadResourceError) {
            return;
        }
        this.isLoadResourceError = true;
        this.mWebContentView.onDestroyWebContent(this.TEMPLATE_MARK_TYPE);
        if (this.isShown) {
            CampaignEx campaignEx = this.campaignEx;
            long ecTemplateId = campaignEx != null ? campaignEx.getEcTemplateId() : 404L;
            com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
            cVar.g(cVar.a("add_temple", Long.valueOf(ecTemplateId), "template_type", 18, "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
        } else {
            this.ecTempleModel.setRenderStatus(1);
        }
        this.mWebContentView.removeTempleFromSuperView(this.data.getRootViewGroup());
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqSuccessful(Object obj) {
        try {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    String string = jSONObject.getString("action");
                    int i10 = 0;
                    switch (string.hashCode()) {
                        case -1765453640:
                            if (string.equals("toggleCloseBtn")) {
                                int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1);
                                this.webCloseViewStatus = iOptInt;
                                this.mHandler.removeCallbacks(this.nativeCloseBtnVisibleRunnable);
                                IBaseWebView iBaseWebView = this.mWebContentView;
                                if (iOptInt != 1) {
                                    i10 = 4;
                                }
                                iBaseWebView.setNativeCloseButtonVisibility(i10);
                                return;
                            }
                            return;
                        case -1488920312:
                            if (string.equals("onReceivedError")) {
                                onWebContentError();
                                return;
                            }
                            return;
                        case -1289167206:
                            if (string.equals("expand")) {
                                String strOptString = jSONObject.optString("url", "");
                                int iOptInt2 = jSONObject.optInt("shouldUseCustomClose", 1);
                                if (TextUtils.isEmpty(strOptString)) {
                                    return;
                                }
                                this.mWebContentView.showMRAIDExpandView(strOptString, iOptInt2);
                                return;
                            }
                            return;
                        case -1258199123:
                            if (string.equals("notifyCloseBtn")) {
                                int iOptInt3 = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1);
                                if (iOptInt3 == 0 || iOptInt3 == 1) {
                                    this.webCloseViewStatus = iOptInt3;
                                }
                                if (iOptInt3 == 1) {
                                    this.mCanResponseBackPress = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        case -920773881:
                            if (string.equals("ivRewardAdsWithoutVideo")) {
                                int iOptInt4 = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                                int iOptInt5 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                                this.adapterModel.b(iOptInt4 != 2 ? iOptInt4 != 3 ? com.mbridge.msdk.foundation.same.a.F : com.mbridge.msdk.foundation.same.a.E : com.mbridge.msdk.foundation.same.a.D);
                                this.adapterModel.m(iOptInt5 == 1);
                                this.mWebContentView.onCloseViewClick(2);
                                return;
                            }
                            return;
                        case -505277536:
                            if (string.equals("onPageFinished")) {
                                this.isWebContentLoadFinish = true;
                                if (this.isShown) {
                                    this.mWebContentView.onWebViewShow(this.TEMPLATE_MARK_TYPE);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 94750088:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                                CampaignEx campaignEx = this.campaignEx;
                                if (campaignEx != null) {
                                    campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                                }
                                this.ecTempleModel.eventTrackingForClick(this.redirectModel);
                                this.ecTempleModel.onAdClick(this.mBridgeIds);
                                return;
                            }
                            return;
                        case 94756344:
                            if (string.equals(CampaignEx.JSON_NATIVE_VIDEO_CLOSE)) {
                                this.mWebContentView.onCloseViewClick(2);
                                return;
                            }
                            return;
                        case 96046965:
                            if (!string.equals("readyStatus")) {
                                return;
                            }
                            break;
                        case 1639551484:
                            if (string.equals("loadingResourceStatus")) {
                                break;
                            } else {
                                return;
                            }
                        case 1843897919:
                            if (string.equals("feedbackOperate")) {
                                String strOptString2 = jSONObject.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "");
                                String strOptString3 = jSONObject.optString(NotificationCompat.CATEGORY_STATUS, "");
                                if (TextUtils.isEmpty(strOptString2)) {
                                    return;
                                }
                                JSONObject jSONObject2 = new JSONObject(strOptString3);
                                if (strOptString2.equals("popup")) {
                                    com.mbridge.msdk.foundation.d.b.a().a(jSONObject2.optString("key", ""), jSONObject2.optInt("view_visible", 1), this.feedbackDialogEventListener);
                                }
                                if (strOptString2.equals("visibility")) {
                                    com.mbridge.msdk.foundation.d.b.a().a(jSONObject2.optString("key", ""), jSONObject2.optInt("view_visible", 1) == 1 ? 8 : 0, this.mWebContentView.getWebView());
                                }
                                if (strOptString2.equals(TtmlNode.TAG_LAYOUT)) {
                                    com.mbridge.msdk.foundation.d.b.a().a(jSONObject2.optString("key", ""), jSONObject2.optInt("width", -1), jSONObject2.optInt("height", -1), jSONObject2.optInt("radius", 20), jSONObject2.optInt(TtmlNode.LEFT, -1), jSONObject2.optInt("top", -1), (float) jSONObject2.optDouble("opacity", 1.0d), jSONObject2.optString("fontColor", ""), jSONObject2.optString("bgColor", ""), (float) jSONObject2.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, -1.0d), jSONObject2.optJSONArray("padding"));
                                    return;
                                }
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                    if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, 1) == 1) {
                        this.isWebContentLoadFinish = true;
                    }
                }
            }
        } catch (Throwable th) {
            af.b("ECWebPresenter", th.getMessage());
        }
    }

    public void setCanResponseBack(boolean z9) {
        this.mCanResponseBackPress = z9;
    }

    public void setNotchData(String str) {
        MBCommunicatorUtil.notifyNotchData(this.mWebContentView.getWebView(), str);
    }

    public void setRenderError() {
        IECModel iECModel = this.ecTempleModel;
        if (iECModel != null) {
            iECModel.setRenderStatus(1);
        }
    }

    public void onAttachedToWindow() {
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
    }

    @Override // com.mbridge.msdk.newreward.a.b.b
    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
    }
}

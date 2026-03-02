package com.mbridge.msdk.newreward.player.model;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.CommunicatorParameter;
import com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl;
import com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class BaseWebContentModel extends HybridCommunicatorImpl implements WebViewEventListener {
    e mAdapterModel;
    c mCommandManager;
    String mInitCallbackParameter;
    b mReqCallBack;
    int renderStatus;
    int renderType;
    private final String TAG = "BaseWebContentModel";
    String mLifeCycleString = "{}";
    String mVideoProgressString = "{}";

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void click(CommunicatorParameter communicatorParameter) {
        super.click(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(communicatorParameter.getQuery()) && this.mAdapterModel != null) {
                    String strOptString = "";
                    try {
                        strOptString = new JSONObject(communicatorParameter.getQuery()).optString("pt");
                    } catch (Throwable th) {
                        af.b("BaseWebContentModel", th.getMessage());
                    }
                    CampaignEx campaignExA = com.mbridge.msdk.newreward.function.h.b.a(strOptString, this.mAdapterModel.D().a().get(0));
                    campaignExA.setClickTempSource(this.renderType == 3 ? a.h : a.g);
                    campaignExA.setTriggerClickSource(a.f3808m);
                    new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(campaignExA);
                }
            } catch (Throwable th2) {
                af.b("BaseWebContentModel", th2.getMessage());
                return;
            }
        }
        if (this.mReqCallBack != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
            this.mReqCallBack.reqSuccessful(jSONObject);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void close(CommunicatorParameter communicatorParameter) {
        super.close(communicatorParameter);
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", CampaignEx.JSON_NATIVE_VIDEO_CLOSE, th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void expand(CommunicatorParameter communicatorParameter) {
        super.expand(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
            String strOptString = jSONObject.optString("url");
            String strOptString2 = jSONObject.optString("shouldUseCustomClose");
            af.b("BaseWebContentModel", "MRAID expand " + strOptString + " " + strOptString2);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            boolean zEqualsIgnoreCase = strOptString2.equalsIgnoreCase("true");
            if (this.mReqCallBack != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", "expand");
                jSONObject2.put("url", strOptString);
                jSONObject2.put("shouldUseCustomClose", zEqualsIgnoreCase ? 1 : 2);
                this.mReqCallBack.reqSuccessful(jSONObject2);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "MRAID expand", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void feedbackLayoutOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackLayoutOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "feedbackOperate");
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, TtmlNode.TAG_LAYOUT);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "feedbackLayoutOperate", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void feedbackOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "feedbackOperate");
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "visibility");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "feedbackOperate", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void feedbackPopupOperate(CommunicatorParameter communicatorParameter) {
        super.feedbackPopupOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "feedbackOperate");
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "popup");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "feedbackPopupOperate", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void getCurrentProgress(CommunicatorParameter communicatorParameter) {
        super.getCurrentProgress(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (TextUtils.isEmpty(this.mVideoProgressString)) {
                    return;
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(this.mVideoProgressString.getBytes(), 2));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "isSystemResume", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void getEndScreenInfo(CommunicatorParameter communicatorParameter) {
        super.getEndScreenInfo(communicatorParameter);
        String strA = com.mbridge.msdk.newreward.function.h.b.a(this.mAdapterModel.H(), this.mAdapterModel.D().a(), this.mAdapterModel.n(), this.mAdapterModel.O());
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(strA.getBytes(), 2));
    }

    public String getH5InitCallbackParameter() {
        return this.mInitCallbackParameter;
    }

    public int getRenderStatus() {
        return this.renderStatus;
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void handlerH5Exception(CommunicatorParameter communicatorParameter) {
        super.handlerH5Exception(communicatorParameter);
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void init(CommunicatorParameter communicatorParameter) {
        super.init(communicatorParameter);
        String strA = com.mbridge.msdk.newreward.function.h.b.a(this.mAdapterModel.H(), this.mAdapterModel.D().a(), this.mAdapterModel.n(), this.mAdapterModel.O());
        if (!TextUtils.isEmpty(strA)) {
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(strA.getBytes(), 2));
        }
        if (TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            this.mInitCallbackParameter = communicatorParameter.getQuery();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", communicatorParameter.getPath());
            jSONObject.put("parameter", communicatorParameter.getQuery());
            b bVar = this.mReqCallBack;
            if (bVar != null) {
                bVar.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "init", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void install(CommunicatorParameter communicatorParameter) {
        super.install(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (!TextUtils.isEmpty(communicatorParameter.getQuery()) && this.mAdapterModel != null) {
                    CampaignEx campaignExA = com.mbridge.msdk.newreward.function.h.b.a(communicatorParameter.getQuery(), this.mAdapterModel.D().a().get(0));
                    campaignExA.setClickTempSource(this.renderType == 3 ? a.h : a.g);
                    campaignExA.setTriggerClickSource(a.f3808m);
                    new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(campaignExA);
                }
            } catch (Throwable th) {
                af.b("BaseWebContentModel", th.getMessage());
                return;
            }
        }
        if (this.mReqCallBack != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
            this.mReqCallBack.reqSuccessful(jSONObject);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void isSystemResume(CommunicatorParameter communicatorParameter) {
        super.isSystemResume(communicatorParameter);
        if (communicatorParameter != null) {
            try {
                if (TextUtils.isEmpty(this.mLifeCycleString)) {
                    return;
                }
                callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), Base64.encodeToString(this.mLifeCycleString.getBytes(), 2));
            } catch (Throwable th) {
                af.b("BaseWebContentModel", "isSystemResume", th);
                callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void ivRewardAdsWithoutVideo(CommunicatorParameter communicatorParameter) {
        super.ivRewardAdsWithoutVideo(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "ivRewardAdsWithoutVideo");
                if (!TextUtils.isEmpty(communicatorParameter.getQuery())) {
                    JSONObject jSONObject2 = new JSONObject(communicatorParameter.getQuery());
                    int iOptInt = jSONObject2.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    int iOptInt2 = jSONObject2.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, iOptInt);
                    jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, iOptInt2);
                }
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "ivRewardAdsWithoutVideo", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void loadingResourceStatus(CommunicatorParameter communicatorParameter) {
        super.loadingResourceStatus(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt("isReady", 1);
            this.renderStatus = iOptInt == 1 ? 3 : 4;
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", communicatorParameter.getPath());
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "readyStatus", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void notifyCloseBtn(CommunicatorParameter communicatorParameter) {
        super.notifyCloseBtn(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", communicatorParameter.getPath());
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "notifyCloseBtn", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void onJSBridgeConnect(CommunicatorParameter communicatorParameter) {
        super.onJSBridgeConnect(communicatorParameter);
        onSignalCommunicationConnected(communicatorParameter.getWebView());
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onPageFinished(WebView webView, String str) {
        onSignalCommunicationConnected(webView);
        try {
            if (this.renderStatus != 1) {
                this.renderStatus = 2;
            }
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onPageFinished");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onReceivedError(WebView webView, int i10, String str, String str2) {
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onRenderProcessGone(WebView webView) {
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "onReceivedError");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            this.renderStatus = 1;
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void open(CommunicatorParameter communicatorParameter) {
        super.open(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            String strOptString = new JSONObject(communicatorParameter.getQuery()).optString("url");
            if (!TextUtils.isEmpty(strOptString)) {
                if (this.mAdapterModel.D().b().u().size() > 1) {
                    com.mbridge.msdk.foundation.controller.c.m().c().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)));
                } else {
                    JSONObject jSONObjectCampaignToJsonObject = CampaignEx.campaignToJsonObject(this.mAdapterModel.U());
                    if (jSONObjectCampaignToJsonObject != null) {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(jSONObjectCampaignToJsonObject);
                        campaignWithBackData.setClickURL(strOptString);
                        campaignWithBackData.setClickTempSource(a.h);
                        campaignWithBackData.setTriggerClickSource(a.f3809n);
                        new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.mAdapterModel.H()).a(campaignWithBackData);
                    }
                }
            }
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 0);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "open", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void progressBarOperate(CommunicatorParameter communicatorParameter) {
        super.progressBarOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
            if (this.mReqCallBack != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", "progressBarOperate");
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                this.mReqCallBack.reqSuccessful(jSONObject2);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "progressBarOperate", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void progressOperate(CommunicatorParameter communicatorParameter) {
        super.progressOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
            if (this.mReqCallBack != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", "progressOperate");
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                this.mReqCallBack.reqSuccessful(jSONObject2);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "progressOperate", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void readyStatus(CommunicatorParameter communicatorParameter) {
        super.readyStatus(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int i10 = 1;
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt("isReady", 1);
            this.renderStatus = iOptInt == 1 ? 3 : 4;
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", communicatorParameter.getPath());
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            if (iOptInt != 1) {
                i10 = 2;
            }
            eVar.a("result", Integer.valueOf(i10));
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.renderType));
            this.mAdapterModel.z().a(this.mAdapterModel, eVar.a(), "2000155");
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "readyStatus", th);
        }
    }

    public void setAdapterModel(e eVar) {
        this.mAdapterModel = eVar;
    }

    public void setCallbackListener(b bVar) {
        this.mReqCallBack = bVar;
    }

    public void setCommandManager(c cVar) {
        this.mCommandManager = cVar;
    }

    public void setLifeCycleString(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLifeCycleString = str;
    }

    public void setRenderStatus(int i10) {
        this.renderStatus = i10;
    }

    public void setRenderType(int i10) {
        this.renderType = i10;
    }

    public void setVideoProgressString(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mVideoProgressString = str;
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void showVideoClickView(CommunicatorParameter communicatorParameter) {
        super.showVideoClickView(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "showVideoClickView");
                jSONObject.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "showVideoClickView", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void showVideoLocation(CommunicatorParameter communicatorParameter) {
        super.showVideoLocation(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "showVideoLocation");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, communicatorParameter.getQuery());
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "showVideoLocation", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void soundOperate(CommunicatorParameter communicatorParameter) {
        super.soundOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
            if (this.mReqCallBack != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("action", "soundOperate");
                jSONObject2.put(NotificationCompat.CATEGORY_STATUS, jSONObject);
                this.mReqCallBack.reqSuccessful(jSONObject2);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "soundOperate", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void statistics(CommunicatorParameter communicatorParameter) {
        super.statistics(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        try {
            JSONObject jSONObject = new JSONObject(communicatorParameter.getQuery());
            final String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_EVENT, NotificationCompat.CATEGORY_EVENT);
            final String strOptString2 = jSONObject.optString("template", "-1");
            final String strOptString3 = jSONObject.optString(TtmlNode.TAG_LAYOUT, "-1");
            final String strOptString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.mAdapterModel.H());
            final int iM = ab.m(com.mbridge.msdk.foundation.controller.c.m().c());
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() { // from class: com.mbridge.msdk.newreward.player.model.BaseWebContentModel.1
                @Override // java.lang.Runnable
                public void run() {
                    o.a(g.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(new n("2000039", strOptString, strOptString2, strOptString3, strOptString4, BaseWebContentModel.this.mAdapterModel.U().getId(), iM, ab.a(com.mbridge.msdk.foundation.controller.c.m().c(), iM)));
                }
            });
        } catch (Throwable th) {
            af.b("BaseWebContentModel", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void toggleCloseBtn(CommunicatorParameter communicatorParameter) {
        super.toggleCloseBtn(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", communicatorParameter.getPath());
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "toggleCloseBtn", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void triggerCloseBtn(CommunicatorParameter communicatorParameter) {
        super.triggerCloseBtn(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt(MRAIDCommunicatorUtil.KEY_STATE);
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "triggerCloseBtn", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void unload(CommunicatorParameter communicatorParameter) {
        super.unload(communicatorParameter);
        close(communicatorParameter);
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void useCustomClose(CommunicatorParameter communicatorParameter) {
        super.useCustomClose(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            String strOptString = new JSONObject(communicatorParameter.getQuery()).optString("shouldUseCustomClose");
            af.b("BaseWebContentModel", "MRAID useCustomClose " + strOptString);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            boolean zEqualsIgnoreCase = strOptString.equalsIgnoreCase("true");
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "toggleCloseBtn");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, zEqualsIgnoreCase ? 1 : 2);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "MRAID useCustomClose", th);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicatorImpl, com.mbridge.msdk.newreward.player.view.hybrid.communicator.HybridCommunicator
    public void videoOperate(CommunicatorParameter communicatorParameter) {
        super.videoOperate(communicatorParameter);
        if (communicatorParameter == null || TextUtils.isEmpty(communicatorParameter.getQuery())) {
            return;
        }
        try {
            int iOptInt = new JSONObject(communicatorParameter.getQuery()).optInt("pause_or_resume");
            if (this.mReqCallBack != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "videoOperate");
                jSONObject.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                this.mReqCallBack.reqSuccessful(jSONObject);
            }
            callSuccess(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(0));
        } catch (Throwable th) {
            af.b("BaseWebContentModel", "videoOperate", th);
            callFailure(communicatorParameter.getWebView(), communicatorParameter.getToken(), com.mbridge.msdk.newreward.function.h.b.a(1));
        }
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onProgressChanged(WebView webView, int i10) {
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void loadingResourceStatus(WebView webView, int i10) {
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    @Override // com.mbridge.msdk.newreward.player.view.hybrid.listener.WebViewEventListener
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }
}

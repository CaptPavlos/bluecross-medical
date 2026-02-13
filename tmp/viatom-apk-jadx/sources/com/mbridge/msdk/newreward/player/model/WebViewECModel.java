package com.mbridge.msdk.newreward.player.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WebViewECModel extends BaseWebContentModel implements IECModel {
    RewardVideoListener rewardVideoListener;
    private final String TAG = "WebViewECModel";
    boolean adShownState = false;
    boolean videoComPleteState = false;
    boolean adCloseState = false;
    boolean eventImpression = false;
    boolean eventOnlyImpression = false;
    boolean eventPvUrls = false;
    boolean eventTrackingImp = false;
    boolean trackPlayError = false;
    boolean trackPause = false;
    boolean trackResume = false;
    boolean trackClick = false;
    boolean muteState = false;
    boolean addRewardState = false;
    boolean endCardShowState = false;
    boolean trackEndCardShow = false;

    public WebViewECModel(c cVar, e eVar) {
        this.mCommandManager = cVar;
        this.mAdapterModel = eVar;
        this.rewardVideoListener = eVar.K();
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean eventAddReward(RedirectModel redirectModel) {
        if (this.addRewardState) {
            return true;
        }
        this.addRewardState = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADD_REWARD));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IModel
    public boolean eventClickUrl(RedirectModel redirectModel) {
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventImpression(RedirectModel redirectModel) {
        if (this.eventImpression) {
            return;
        }
        this.eventImpression = true;
        af.b("WebViewECModel", "触发了eventImpression，url为--》" + redirectModel.getCampaignEx().getImpressionURL());
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (this.eventOnlyImpression) {
            return;
        }
        this.eventOnlyImpression = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
        af.b("WebViewECModel", "触发了eventOnlyImpression，url为--》" + redirectModel.getCampaignEx().getOnlyImpressionURL());
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventPvUrls(RedirectModel redirectModel) {
        if (this.eventPvUrls) {
            return;
        }
        this.eventPvUrls = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.PV_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean eventTrackingForClick(RedirectModel redirectModel) {
        if (this.trackClick) {
            return true;
        }
        this.trackClick = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLICK_URL));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventTrackingForEndCardShow(RedirectModel redirectModel, @BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        if (this.trackEndCardShow) {
            return;
        }
        this.trackEndCardShow = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_EC_SHOW_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean eventTrackingForImpression(RedirectModel redirectModel) {
        if (this.eventTrackingImp) {
            return true;
        }
        this.eventTrackingImp = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_IMPRESSION_URL));
        return false;
    }

    public void eventTrackingForMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_MUTE_URL));
    }

    public void eventTrackingForUnMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_UN_MUTE_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onAdClick(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo, @BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        if (this.adCloseState) {
            return true;
        }
        this.adCloseState = true;
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return false;
        }
        rewardVideoListener.onAdClose(mBridgeIds, rewardInfo);
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z9, int i10) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z9, i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean onAdShow(MBridgeIds mBridgeIds) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        if (this.rewardVideoListener == null) {
            return false;
        }
        this.mAdapterModel.j(true);
        this.rewardVideoListener.onAdShow(mBridgeIds);
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onEndCardShow(MBridgeIds mBridgeIds, @BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null || this.endCardShowState) {
            return;
        }
        this.endCardShowState = true;
        rewardVideoListener.onEndcardShow(mBridgeIds);
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public boolean onShowFail(MBridgeIds mBridgeIds, String str, int i10) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        if (this.rewardVideoListener == null) {
            return false;
        }
        this.mAdapterModel.j(true);
        this.rewardVideoListener.onShowFail(mBridgeIds, str);
        return false;
    }

    public void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener;
        if (this.videoComPleteState || (rewardVideoListener = this.rewardVideoListener) == null) {
            return;
        }
        this.videoComPleteState = true;
        rewardVideoListener.onVideoComplete(mBridgeIds);
    }

    public void sendDirectEvent(RedirectModel redirectModel) {
        c cVar = this.mCommandManager;
        cVar.f(cVar.a("campaign_redirect", redirectModel), f.CAMPAIGN_REDIRECT);
    }

    public void setRewardVideoListener(RewardVideoListener rewardVideoListener) {
        this.rewardVideoListener = rewardVideoListener;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onCloseViewClick(int i10) {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IModel
    public void eventNoticeUrl(RedirectModel redirectModel, int i10) {
    }
}

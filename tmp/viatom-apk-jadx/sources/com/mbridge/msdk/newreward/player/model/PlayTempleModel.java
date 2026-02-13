package com.mbridge.msdk.newreward.player.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayTempleModel extends BaseModel implements IPlayModel {
    public static String TAG = "com.mbridge.msdk.newreward.player.model.PlayTempleModel";
    boolean adCloseState;
    boolean adShownState;
    boolean adUrlList;
    boolean addRewardState;
    boolean eventImpression;
    boolean eventOnlyImpression;
    boolean eventPvUrls;
    boolean muteState;
    RewardVideoListener rewardVideoListener;
    boolean trackClick;
    boolean trackClose;
    boolean trackImpression;
    boolean trackPause;
    boolean trackPlayError;
    boolean trackResume;
    boolean videoComPleteState;

    public PlayTempleModel(c cVar, RewardVideoListener rewardVideoListener) {
        super(cVar);
        this.adShownState = false;
        this.videoComPleteState = false;
        this.adCloseState = false;
        this.eventImpression = false;
        this.eventOnlyImpression = false;
        this.eventPvUrls = false;
        this.trackClose = false;
        this.trackPlayError = false;
        this.trackPause = false;
        this.trackResume = false;
        this.muteState = false;
        this.addRewardState = false;
        this.trackImpression = false;
        this.trackClick = false;
        this.adUrlList = false;
        this.rewardVideoListener = rewardVideoListener;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventAdUrlList(RedirectModel redirectModel) {
        if (this.adUrlList) {
            return;
        }
        this.adUrlList = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_URL_LIST));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean eventAddReward(RedirectModel redirectModel) {
        if (this.addRewardState) {
            return true;
        }
        this.addRewardState = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADD_REWARD));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventAdvImpList(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ADV_IMP_LIST));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventImpression(RedirectModel redirectModel) {
        if (this.eventImpression) {
            return;
        }
        this.eventImpression = true;
        af.b(TAG, "触发了eventImpression，url为--》" + redirectModel.getCampaignEx().getImpressionURL());
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (this.eventOnlyImpression) {
            return;
        }
        this.eventOnlyImpression = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
        af.b(TAG, "触发了eventOnlyImpression，url为--》" + redirectModel.getCampaignEx().getOnlyImpressionURL());
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventPvUrls(RedirectModel redirectModel) {
        if (this.eventPvUrls) {
            return;
        }
        this.eventPvUrls = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.PV_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean eventTrackingForClick(RedirectModel redirectModel) {
        if (this.trackClick) {
            return true;
        }
        this.trackClick = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLICK_URL));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean eventTrackingForClose(RedirectModel redirectModel) {
        if (this.trackClose) {
            return true;
        }
        this.trackClose = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_CLOSE_URL));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean eventTrackingForImpression(RedirectModel redirectModel) {
        if (this.trackImpression) {
            return true;
        }
        this.trackImpression = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_IMPRESSION_URL));
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_MUTE_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForPause(RedirectModel redirectModel) {
        if (this.trackPause) {
            return;
        }
        this.trackPause = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_PAUSE));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForPlayError(RedirectModel redirectModel, @BridgeParameter(key = "reason") String str) {
        if (this.trackPlayError) {
            return;
        }
        this.trackPlayError = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_ERROR));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForPlayPercentage(RedirectModel redirectModel, @BridgeParameter(key = "percent") int i10) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_PLAY_PERCENTAGE));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForResume(RedirectModel redirectModel) {
        if (this.trackResume) {
            return;
        }
        this.trackResume = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_RESUME));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void eventTrackingForUnMute(RedirectModel redirectModel) {
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.AD_TRACKING_UN_MUTE_URL));
    }

    public boolean isMuteState() {
        return this.muteState;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void onAdClick(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener != null) {
            rewardVideoListener.onVideoAdClicked(mBridgeIds);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
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

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void onAdCloseWithIVReward(MBridgeIds mBridgeIds, boolean z9, int i10) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener != null) {
            rewardVideoListener.onAdCloseWithIVReward(mBridgeIds, z9, i10);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean onAdShow(MBridgeIds mBridgeIds) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return false;
        }
        rewardVideoListener.onAdShow(mBridgeIds);
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public boolean onShowFail(MBridgeIds mBridgeIds, @BridgeParameter(key = "reason") String str, @BridgeParameter(key = "code") int i10) {
        if (this.adShownState) {
            return true;
        }
        this.adShownState = true;
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return false;
        }
        rewardVideoListener.onShowFail(mBridgeIds, str);
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void onVideoComplete(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener;
        if (this.videoComPleteState || (rewardVideoListener = this.rewardVideoListener) == null) {
            return;
        }
        this.videoComPleteState = true;
        rewardVideoListener.onVideoComplete(mBridgeIds);
    }

    public void setMuteState(boolean z9) {
        this.muteState = z9;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void modelReport(String str, @BridgeParameter(key = CampaignEx.JSON_KEY_EXT_DATA) e eVar) {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void historyShowState() {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void onBufferingEnd() {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void skipped() {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void modelReport(String str) {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void onBufferingStart(String str) {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IPlayModel
    public void checkOMSdkProgress(int i10, int i11) {
    }
}

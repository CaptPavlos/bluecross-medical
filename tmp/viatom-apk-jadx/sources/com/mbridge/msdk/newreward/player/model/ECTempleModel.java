package com.mbridge.msdk.newreward.player.model;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ECTempleModel extends BaseModel implements IECModel {
    boolean adCloseState;
    boolean adShownState;
    boolean addRewardState;
    boolean endCardShowState;
    boolean eventImpression;
    boolean eventOnlyImpression;
    boolean eventPvUrls;
    boolean eventTrackingImp;
    RewardVideoListener rewardVideoListener;
    boolean trackClick;
    boolean trackClose;
    boolean trackEndCardShow;

    public ECTempleModel(c cVar, RewardVideoListener rewardVideoListener) {
        super(cVar);
        this.endCardShowState = false;
        this.adCloseState = false;
        this.trackEndCardShow = false;
        this.trackClose = false;
        this.trackClick = false;
        this.addRewardState = false;
        this.adShownState = false;
        this.eventImpression = false;
        this.eventOnlyImpression = false;
        this.eventPvUrls = false;
        this.eventTrackingImp = false;
        this.rewardVideoListener = rewardVideoListener;
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

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventImpression(RedirectModel redirectModel) {
        if (this.eventImpression) {
            return;
        }
        this.eventImpression = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.IMPRESSION_URL));
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void eventOnlyImpression(RedirectModel redirectModel) {
        if (this.eventOnlyImpression) {
            return;
        }
        this.eventOnlyImpression = true;
        sendDirectEvent(redirectModel.setRedirectType(RedirectType.ONLY_IMPRESSION_URL));
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

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public int getRenderStatus() {
        return 0;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onAdClick(MBridgeIds mBridgeIds) {
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return;
        }
        rewardVideoListener.onVideoAdClicked(mBridgeIds);
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
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return false;
        }
        rewardVideoListener.onAdShow(mBridgeIds);
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
        RewardVideoListener rewardVideoListener = this.rewardVideoListener;
        if (rewardVideoListener == null) {
            return false;
        }
        rewardVideoListener.onShowFail(mBridgeIds, str);
        return false;
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void onCloseViewClick(@BridgeParameter(key = ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) int i10) {
    }

    @Override // com.mbridge.msdk.newreward.player.imodel.IECModel
    public void setRenderStatus(int i10) {
    }
}

package com.mbridge.msdk.newreward.player.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IMetaData;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class AbsPresenter {
    int TEMPLATE_MARK_TYPE;
    e adapterModel;
    CampaignEx campaignEx;
    int closeAlert;
    c commandManager;
    Context context;
    IMetaData data;
    boolean isIV;
    boolean is_dy;
    int ivRewardAlertViewStatus = a.F;
    int ivRewardMode;
    int ivRewardValue;
    int ivRewardValueType;
    MBridgeIds mBridgeIds;
    View moreOfferTemp;
    RedirectModel redirectModel;
    com.mbridge.msdk.videocommon.b.c reward;
    RewardVideoListener rewardVideoListener;
    ViewGroup rootParentView;
    int videoEndType;
    int videoSkipResult;
    int videoSkipTime;

    /* JADX WARN: Multi-variable type inference failed */
    public AbsPresenter(IBaseView iBaseView) {
        ViewGroup viewGroup = (ViewGroup) iBaseView;
        this.rootParentView = viewGroup;
        Context context = viewGroup.getContext();
        this.context = context;
        IMetaData iMetaData = (IMetaData) context;
        this.data = iMetaData;
        this.adapterModel = (e) iMetaData.getDate();
        this.commandManager = d.a().b();
        this.campaignEx = this.adapterModel.U();
        this.mBridgeIds = this.adapterModel.S();
        this.rewardVideoListener = this.adapterModel.K();
        RedirectModel redirectModel = new RedirectModel();
        this.redirectModel = redirectModel;
        redirectModel.setCampaignEx(this.campaignEx);
        this.redirectModel.setContext(this.context);
        this.redirectModel.setSettingModel(this.adapterModel.x());
        this.redirectModel.setUnitId(this.adapterModel.H());
        this.redirectModel.setDevExtraData(this.adapterModel.W());
        prepareShowParameter();
        buildReward("");
    }

    private void buildReward(String str) {
        if (this.campaignEx == null) {
            return;
        }
        this.reward = com.mbridge.msdk.videocommon.b.c.b(str);
        com.mbridge.msdk.videocommon.d.c cVarB = this.adapterModel.x().b();
        if (cVarB != null) {
            this.reward.a(cVarB.m());
            this.reward.a(cVarB.n());
        }
        com.mbridge.msdk.videocommon.b.c cVar = this.reward;
        if (cVar != null && cVar.b() <= 0) {
            this.reward.a(1);
        }
        try {
            if (this.campaignEx.getRewardPlus() != null) {
                RewardPlus rewardPlus = this.campaignEx.getRewardPlus();
                if (!TextUtils.isEmpty(rewardPlus.getName()) && rewardPlus.getAmount() > 0) {
                    com.mbridge.msdk.videocommon.b.c cVar2 = new com.mbridge.msdk.videocommon.b.c(rewardPlus.getName(), rewardPlus.getAmount());
                    this.reward = cVar2;
                    if (cVar2.b() < 0) {
                        this.reward.a(1);
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel != null) {
            redirectModel.setReward(this.reward);
        }
    }

    private void prepareShowParameter() {
        if (this.campaignEx == null) {
            return;
        }
        boolean z9 = (this.adapterModel.h() == 0 ? this.campaignEx.getAdType() : this.adapterModel.h()) == 287;
        this.isIV = z9;
        if (z9) {
            this.ivRewardMode = this.adapterModel.L();
            this.ivRewardValueType = this.adapterModel.u();
            this.ivRewardValue = this.adapterModel.v();
        }
        this.closeAlert = this.adapterModel.x().b().i();
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || campaignEx.getVst() <= -2) {
            this.videoSkipTime = this.adapterModel.x().b().e();
        } else {
            this.videoSkipTime = this.campaignEx.getVst();
        }
        this.videoSkipResult = this.adapterModel.x().b().f();
        this.videoEndType = this.campaignEx.getVideo_end_type();
    }

    public void adShowFail(String str, int i10) {
        e eVar = this.adapterModel;
        if (eVar != null) {
            eVar.j(true);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.adapterModel.h(), this.adapterModel.C(), this.adapterModel.H(), this.adapterModel.G(), 7);
        }
    }

    public void adShowSuccess() {
        e eVar = this.adapterModel;
        if (eVar != null) {
            eVar.j(true);
            com.mbridge.msdk.newreward.function.d.c.a().b().a(this.adapterModel.h(), this.adapterModel.C(), this.adapterModel.H(), this.adapterModel.G(), 6);
        }
    }

    public int filterFindViewId(boolean z9, String str) {
        return z9 ? findDyID(str) : findID(str);
    }

    public int findDyID(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    public int findID(String str) {
        return x.a(this.context.getApplicationContext(), str, "id");
    }

    public abstract void finish(boolean z9);

    public abstract void getView();

    public abstract void initDataForView(com.mbridge.msdk.video.dynview.a aVar);

    public boolean isIVRewardEnable() {
        if (!this.isIV) {
            return false;
        }
        int i10 = this.ivRewardMode;
        return i10 == a.I || i10 == a.H;
    }

    public boolean isNotNULL(View... viewArr) {
        if (viewArr == null) {
            return false;
        }
        int length = viewArr.length;
        int i10 = 0;
        boolean z9 = false;
        while (i10 < length) {
            if (viewArr[i10] == null) {
                return false;
            }
            i10++;
            z9 = true;
        }
        return z9;
    }

    public abstract void releaseSource();

    public void adClosed() {
    }

    public void onDestroy() {
    }

    public void click(View view) {
    }
}

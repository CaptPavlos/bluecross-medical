package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayPresenter902 extends PlayTemplePresenter {
    ICusTemplateView iTemplateView;
    int iaTp;
    int interactiveType;
    MBridgeClickCTAView mClickCTAView;
    f settingModel;
    String templateUrl;

    public PlayPresenter902(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        f fVarX = this.adapterModel.x();
        this.settingModel = fVarX;
        this.interactiveType = fVarX.b().g();
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null) {
            this.templateUrl = campaignEx.getRewardTemplateMode().e();
        }
        this.iaTp = ak.a(this.templateUrl, "ia_tp", -5);
    }

    private void addCTAView() {
        if (this.mClickCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
            this.mClickCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.campaignEx);
            this.mClickCTAView.setUnitId(this.adapterModel.H());
            this.mClickCTAView.preLoadData(null);
            this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenter902.1
                @Override // com.mbridge.msdk.video.module.MBridgeClickCTAView.a
                public void ctaClick() {
                    CampaignEx campaignEx = PlayPresenter902.this.campaignEx;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(a.g);
                        PlayPresenter902.this.campaignEx.setTriggerClickSource(a.f3808m);
                    }
                    PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                    playPresenter902.playTempleModel.onAdClick(playPresenter902.mBridgeIds);
                    PlayPresenter902 playPresenter9022 = PlayPresenter902.this;
                    playPresenter9022.playTempleModel.eventClickUrl(playPresenter9022.redirectModel);
                    PlayPresenter902 playPresenter9023 = PlayPresenter902.this;
                    playPresenter9023.playTempleModel.eventTrackingForClick(playPresenter9023.redirectModel);
                }
            });
        }
        int i10 = this.iaTp;
        if (i10 == -5) {
            int cTAViewState = this.iTemplateView.getCTAViewState();
            ICusTemplateView iCusTemplateView = this.iTemplateView;
            if (cTAViewState == 0) {
                iCusTemplateView.addCTAViewToLayout(this.mClickCTAView, 8);
                return;
            } else {
                iCusTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
                this.rootParentView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenter902.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                        playPresenter902.iTemplateView.addCTAViewToLayout(playPresenter902.mClickCTAView, 8);
                    }
                }, 3000L);
                return;
            }
        }
        if (i10 == -3) {
            return;
        }
        if (i10 == -1) {
            int cTAViewState2 = this.iTemplateView.getCTAViewState();
            ICusTemplateView iCusTemplateView2 = this.iTemplateView;
            if (cTAViewState2 != 0) {
                iCusTemplateView2.addCTAViewToLayout(this.mClickCTAView, 0);
                this.rootParentView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenter902.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PlayPresenter902 playPresenter902 = PlayPresenter902.this;
                        playPresenter902.iTemplateView.addCTAViewToLayout(playPresenter902.mClickCTAView, 8);
                    }
                }, 3000L);
            } else {
                iCusTemplateView2.addCTAViewToLayout(this.mClickCTAView, 8);
            }
        }
        if (this.iaTp >= 0) {
            this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter, com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        super.click(view);
        addCTAView();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i10, int i11) {
        super.onPlayProgress(i10, i11);
        int i12 = this.iaTp;
        if (i12 != -5) {
            this.interactiveType = i12;
        }
        int i13 = this.interactiveType;
        if (i13 == -1 || i10 != i13) {
            return;
        }
        addCTAView();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i10) {
        super.onPlayStarted(i10);
        if (this.iaTp == 0 || this.interactiveType == 0) {
            addCTAView();
        }
    }
}

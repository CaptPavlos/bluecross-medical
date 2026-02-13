package com.mbridge.msdk.newreward.player.presenter;

import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.newreward.function.e.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayPresenter202 extends PlayTemplePresenter {
    ICusTemplateView iTemplateView;
    int interactiveType;
    MBridgeClickCTAView mClickCTAView;
    f settingModel;

    public PlayPresenter202(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        f fVarX = this.adapterModel.x();
        this.settingModel = fVarX;
        this.interactiveType = fVarX.b().g();
    }

    private void addCTAView() {
        if (this.interactiveType < -1) {
            return;
        }
        if (this.mClickCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
            this.mClickCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.campaignEx);
            this.mClickCTAView.setUnitId(this.adapterModel.H());
            this.mClickCTAView.preLoadData(null);
            this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenter202.1
                @Override // com.mbridge.msdk.video.module.MBridgeClickCTAView.a
                public void ctaClick() {
                    CampaignEx campaignEx = PlayPresenter202.this.campaignEx;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(a.g);
                        PlayPresenter202.this.campaignEx.setTriggerClickSource(a.f3808m);
                    }
                    PlayPresenter202 playPresenter202 = PlayPresenter202.this;
                    playPresenter202.playTempleModel.onAdClick(playPresenter202.mBridgeIds);
                    PlayPresenter202 playPresenter2022 = PlayPresenter202.this;
                    playPresenter2022.playTempleModel.eventClickUrl(playPresenter2022.redirectModel);
                    PlayPresenter202 playPresenter2023 = PlayPresenter202.this;
                    playPresenter2023.playTempleModel.eventTrackingForClick(playPresenter2023.redirectModel);
                }
            });
        }
        int i10 = this.interactiveType;
        if (i10 >= 0) {
            this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
            return;
        }
        if (i10 == -1) {
            int cTAViewState = this.iTemplateView.getCTAViewState();
            ICusTemplateView iCusTemplateView = this.iTemplateView;
            if (cTAViewState == 0) {
                iCusTemplateView.addCTAViewToLayout(this.mClickCTAView, 8);
            } else {
                iCusTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
                this.rootParentView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenter202.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PlayPresenter202 playPresenter202 = PlayPresenter202.this;
                        playPresenter202.iTemplateView.addCTAViewToLayout(playPresenter202.mClickCTAView, 8);
                    }
                }, 3000L);
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter, com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        super.click(view);
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_vfpv")) {
            addCTAView();
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayProgress(int i10, int i11) {
        super.onPlayProgress(i10, i11);
        int i12 = this.interactiveType;
        if (i12 == -1 || i10 != i12) {
            return;
        }
        addCTAView();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i10) {
        super.onPlayStarted(i10);
        if (this.interactiveType == 0) {
            addCTAView();
        }
    }
}

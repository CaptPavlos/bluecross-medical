package com.mbridge.msdk.newreward.player.presenter;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.iview.ICusTemplateView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.video.dynview.b;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.module.MBridgeClickCTAView;
import java.lang.reflect.Proxy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayPresenterHalf extends PlayTemplePresenter {
    private ICusTemplateView iTemplateView;
    private MBridgeClickCTAView mClickCTAView;
    private String templateUrl;

    public PlayPresenterHalf(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.iTemplateView = (ICusTemplateView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{ICusTemplateView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx != null) {
            this.templateUrl = campaignEx.getRewardTemplateMode().e();
        }
    }

    private void addCTAView() {
        if (this.mClickCTAView == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(this.context);
            this.mClickCTAView = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.campaignEx);
            this.mClickCTAView.setUnitId(this.adapterModel.H());
            this.mClickCTAView.preLoadData(null);
            this.mClickCTAView.setCtaClickCallBack(new MBridgeClickCTAView.a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenterHalf.2
                @Override // com.mbridge.msdk.video.module.MBridgeClickCTAView.a
                public void ctaClick() {
                    CampaignEx campaignEx = PlayPresenterHalf.this.campaignEx;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(a.g);
                        PlayPresenterHalf.this.campaignEx.setTriggerClickSource(a.f3808m);
                    }
                    PlayPresenterHalf playPresenterHalf = PlayPresenterHalf.this;
                    playPresenterHalf.playTempleModel.onAdClick(playPresenterHalf.mBridgeIds);
                    PlayPresenterHalf playPresenterHalf2 = PlayPresenterHalf.this;
                    playPresenterHalf2.playTempleModel.eventClickUrl(playPresenterHalf2.redirectModel);
                    PlayPresenterHalf playPresenterHalf3 = PlayPresenterHalf.this;
                    playPresenterHalf3.playTempleModel.eventTrackingForClick(playPresenterHalf3.redirectModel);
                }
            });
        }
        this.iTemplateView.addCTAViewToLayout(this.mClickCTAView, 0);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter, com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        super.click(view);
        try {
            if (view.getId() == filterFindViewId(this.is_dy, "mbridge_rl_playing_close")) {
                if (this.ivRewardMode == com.mbridge.msdk.foundation.same.a.H) {
                    showIVRewardDialogOnCloseMode();
                    return;
                }
                c cVar = this.commandManager;
                cVar.g(cVar.a("add_temple", "HALF_TEMPLATE_EC", "adapter_model", this.adapterModel, "parent_temple", this.data.getRootViewGroup()), f.SHOW_ADD_TEMPLE);
                this.iView.removeTempleFromSuperView(this.data.getRootViewGroup());
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        b.a().a(new com.mbridge.msdk.video.dynview.j.c().a(this.rootParentView, this.campaignEx, com.mbridge.msdk.newreward.function.h.c.b(this.templateUrl)), new h() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayPresenterHalf.1
            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                PlayPresenterHalf playPresenterHalf = PlayPresenterHalf.this;
                if (playPresenterHalf.playTempleModel == null) {
                    return;
                }
                playPresenterHalf.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                PlayPresenterHalf.this.initDataForView(aVar);
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
    public void onPlayStarted(int i10) {
        super.onPlayStarted(i10);
        addCTAView();
    }

    public void setHalfWH() {
        int iE;
        int iF;
        this.data.getRootViewGroup().setBackgroundColor(-1728053248);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.data.getRootViewGroup().getLayoutParams();
        layoutParams.gravity = 17;
        int iB = this.campaignEx.getRewardTemplateMode() != null ? this.campaignEx.getRewardTemplateMode().b() : x.a(this.context).getConfiguration().orientation;
        Context context = this.context;
        if (iB == 1) {
            iE = (int) (ak.e(context) * 0.55f);
            iF = (int) (ak.f(this.context) * 0.65f);
        } else {
            iE = (int) (ak.e(context) * 0.6f);
            iF = (int) (ak.f(this.context) * 0.6f);
        }
        layoutParams.height = iE;
        layoutParams.width = iF;
        this.iView.setPlayerSize(17, iF, iE);
        this.data.getRootViewGroup().setLayoutParams(layoutParams);
    }
}

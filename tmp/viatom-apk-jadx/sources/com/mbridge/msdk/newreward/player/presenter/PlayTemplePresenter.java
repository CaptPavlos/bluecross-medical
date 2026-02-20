package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.d.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.command.receiver.d;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.function.h.a;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IPlayTempleView;
import com.mbridge.msdk.newreward.player.model.PlayTempleModel;
import com.mbridge.msdk.video.dynview.e.h;
import java.io.File;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class PlayTemplePresenter extends BaseTemplatePresenter implements IPresenter {
    private final String TAG;

    public PlayTemplePresenter(IPlayTempleView iPlayTempleView) {
        super(iPlayTempleView);
        this.TAG = "PlayTemplePresenter";
        this.iView = (IPlayTempleView) Proxy.newProxyInstance(iPlayTempleView.getClass().getClassLoader(), new Class[]{IPlayTempleView.class, IBaseView.class}, new e(iPlayTempleView, this.adapterModel, this.commandManager));
        this.playTempleModel = (IPlayModel) Proxy.newProxyInstance(PlayTempleModel.class.getClassLoader(), new Class[]{IPlayModel.class}, new e(new PlayTempleModel(this.commandManager, this.rewardVideoListener), this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 2;
    }

    private void addPrivacy() {
        ak.a(1, this.iView.getPrivacyButton(), this.campaignEx, this.context, false, new a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.3
            @Override // com.mbridge.msdk.foundation.d.a
            public void close() {
                PlayTemplePresenter.this.resume();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void showed() {
                PlayTemplePresenter.this.onPause();
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void summit(String str) {
                PlayTemplePresenter.this.resume();
            }
        });
    }

    private void initPlayer() {
        try {
            if (this.campaignEx.getVideoUrlEncode() != null) {
                File fileG = this.adapterModel.g(this.campaignEx.getRequestIdNotice());
                c cVar = this.commandManager;
                Object objD = cVar.d(cVar.a("fullScreenWidth", Float.valueOf(ak.j(this.context)), "fullScreenHeight", Float.valueOf(ak.i(this.context)), "campaign", this.campaignEx, "orientation", Integer.valueOf(this.context.getResources().getConfiguration().orientation)), f.TEMP_PLAYER_INIT);
                if (objD instanceof Map) {
                    Map map = (Map) objD;
                    this.iView.setPlayerSize(((Integer) map.get("gravity")).intValue(), ((Integer) map.get("width")).intValue(), ((Integer) map.get("height")).intValue());
                }
                if (fileG == null || !fileG.exists()) {
                    this.iView.play(this.campaignEx.getVideoUrlEncode(), getBufferTimeout());
                } else {
                    this.iView.play(fileG.getAbsolutePath(), getBufferTimeout());
                }
            }
        } catch (Exception e) {
            af.b("PlayTemplePresenter", e.getMessage());
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890004), 890004);
        }
    }

    private boolean parseRemoteViewData(com.mbridge.msdk.video.dynview.a aVar) {
        boolean zInitViews = false;
        if (aVar == null) {
            return false;
        }
        try {
            boolean zC = aVar.c();
            this.is_dy = zC;
            com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
            if (eVar != null) {
                eVar.g(zC);
                this.campaignEx.setTemplateRenderSucc(this.is_dy);
            }
            if (aVar.a() == null) {
                return false;
            }
            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            try {
                this.iView.addViewToCurrentViewGroup(aVar.a());
                if (aVar.b() != null) {
                    Iterator<View> it = aVar.b().iterator();
                    while (it.hasNext()) {
                        it.next().setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.2
                            @Override // com.mbridge.msdk.widget.a
                            public void onNoDoubleClick(View view) {
                                CampaignEx campaignEx = PlayTemplePresenter.this.campaignEx;
                                if (campaignEx != null) {
                                    campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.g);
                                    boolean z9 = view instanceof TextView;
                                    PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                                    if (z9) {
                                        playTemplePresenter.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3808m);
                                    } else {
                                        playTemplePresenter.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3809n);
                                    }
                                }
                                PlayTemplePresenter playTemplePresenter2 = PlayTemplePresenter.this;
                                playTemplePresenter2.playTempleModel.onAdClick(playTemplePresenter2.mBridgeIds);
                                PlayTemplePresenter playTemplePresenter3 = PlayTemplePresenter.this;
                                playTemplePresenter3.playTempleModel.eventClickUrl(playTemplePresenter3.redirectModel);
                                PlayTemplePresenter playTemplePresenter4 = PlayTemplePresenter.this;
                                playTemplePresenter4.playTempleModel.eventTrackingForClick(playTemplePresenter4.redirectModel);
                            }
                        });
                    }
                }
                zInitViews = this.iView.initViews(this.is_dy);
                return zInitViews;
            } catch (Exception e) {
                af.b("PlayTemplePresenter", e.getMessage());
                return false;
            }
        } catch (Exception e3) {
            af.b("PlayTemplePresenter", e3.getMessage());
            return zInitViews;
        }
    }

    private void preLoadECMoreOfferData() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getendcard_url()) || !com.mbridge.msdk.newreward.function.h.c.b(this.campaignEx.getendcard_url())) {
            return;
        }
        String strA = aq.a(this.campaignEx.getendcard_url(), "mof");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            if (Integer.parseInt(strA) == 1) {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("retry", "2");
                this.playTempleModel.modelReport("m_mof_initiate", eVar);
                c cVar = this.commandManager;
                cVar.e(cVar.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 2, "adapter_model", this.adapterModel), new b() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.4
                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                        com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar2.a("result", "2");
                        eVar2.a("code", Integer.valueOf(bVar.a()));
                        eVar2.a("retry", "2");
                        PlayTemplePresenter.this.playTempleModel.modelReport("m_mof_req_result", eVar2);
                    }

                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public void reqSuccessful(Object obj) {
                        PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                        playTemplePresenter.commandManager.a(playTemplePresenter.adapterModel, "MoreOfferPreSendTrackingReceiver");
                        com.mbridge.msdk.foundation.same.report.d.e eVar2 = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar2.a("result", "1");
                        eVar2.a("retry", "2");
                        PlayTemplePresenter.this.playTempleModel.modelReport("m_mof_req_result", eVar2);
                    }
                });
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void preRenderEc() {
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.adapterModel;
            if (eVar == null || !eVar.aj().equals("WEB_EC")) {
                return;
            }
            c cVar = this.commandManager;
            cVar.i(cVar.a("web_resource_action", 1, "parent_temple", this.data.getRootViewGroup(), "adapter_model", this.adapterModel, "bridge_ids", this.campaignEx.getRequestIdNotice()), f.SHOW_OR_PRELOAD_WEB_EC);
        } catch (Exception e) {
            af.b("PlayTemplePresenter", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.iView.resume();
        this.playTempleModel.eventTrackingForResume(this.redirectModel);
    }

    public void addBaitClickView() {
        try {
            IPlayTempleView iPlayTempleView = this.iView;
            if (iPlayTempleView != null && iPlayTempleView.getBaitClickView() != null) {
                c cVar = this.commandManager;
                cVar.e(cVar.a("campaign", this.campaignEx, "template_model", this.playTempleModel, "template_redirect_model", this.redirectModel, "bait_click_view", this.iView.getBaitClickView(), "mbridge_ids", this.mBridgeIds), f.ADD_BAIT_CLICK);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void addMoreOfferView(ViewGroup viewGroup) {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(this.campaignEx.getRewardTemplateMode().e())) {
            return;
        }
        try {
            String strA = aq.a(this.campaignEx.getRewardTemplateMode().e(), "mof");
            if (TextUtils.isEmpty(strA) || Integer.parseInt(strA) != 1) {
                return;
            }
            c cVar = this.commandManager;
            cVar.d(cVar.a("add_temple", 295, "parent_temple", viewGroup, "more_offer_type", 1, "command_type", f.SHOW_ADD_TEMPLE), new b() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.6
                @Override // com.mbridge.msdk.newreward.a.b.b
                public void reqSuccessful(Object obj) {
                    try {
                        View view = (View) obj;
                        PlayTemplePresenter.this.moreOfferTemp = view;
                        view.setVisibility(0);
                        new com.mbridge.msdk.video.dynview.h.b().a(PlayTemplePresenter.this.moreOfferTemp, 0, ak.f(com.mbridge.msdk.foundation.controller.c.m().c()), 0, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f), 500L);
                        PlayTemplePresenter.this.iView.setTemplateWidthAndHeight(ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 100.0f));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        super.click(view);
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_rl_playing_close")) {
            onCloseButtonClick();
            return;
        }
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_sound_switch")) {
            boolean muteState = this.iView.getMuteState();
            IPlayTempleView iPlayTempleView = this.iView;
            if (muteState) {
                iPlayTempleView.setMuteState(false);
                this.playTempleModel.eventTrackingForMute(this.redirectModel);
            } else {
                iPlayTempleView.setMuteState(true);
                this.playTempleModel.eventTrackingForUnMute(this.redirectModel);
            }
        }
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
            af.b("PlayTemplePresenter", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().a(this.rootParentView, this.campaignEx), new h() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.1
            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                PlayTemplePresenter playTemplePresenter = PlayTemplePresenter.this;
                if (playTemplePresenter.playTempleModel == null) {
                    return;
                }
                playTemplePresenter.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                PlayTemplePresenter.this.initDataForView(aVar);
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        try {
            preRenderEc();
            if (!parseRemoteViewData(aVar)) {
                this.playTemplateRanderSuccess = false;
                closeAdOrShowEndCard();
            } else {
                initPlayer();
                addPrivacy();
                preLoadECMoreOfferData();
            }
        } catch (Exception e) {
            af.b("PlayTemplePresenter", e.getMessage());
            adShowFail(com.mbridge.msdk.foundation.c.a.a(890009), 890009);
        }
    }

    public void onBackPressed() {
        if (this.isAlertShowing || this.dialogContinueClicked || !this.closeBtnVisible) {
            return;
        }
        onCloseButtonClick();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.BaseTemplatePresenter, com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void onDestroy() {
        super.onDestroy();
        try {
            releaseSource();
            d.a().d(f.SHOW_OR_PRELOAD_WEB_EC);
            d.a().a(this.adapterModel.G());
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
        if (!this.adapterModel.ac()) {
            this.adapterModel.n(true);
            this.playTempleModel.modelReport("2000146");
        }
        this.iView.release();
    }

    public void removeCurrPlayTemplateMoreOfferView(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.moreOfferTemp) == null) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void setBackGrandImage() {
        try {
            com.mbridge.msdk.foundation.same.c.b.a(this.context.getApplicationContext()).a(this.campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.5
                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    com.mbridge.msdk.newreward.function.h.a.a(bitmap, new a.InterfaceC0048a() { // from class: com.mbridge.msdk.newreward.player.presenter.PlayTemplePresenter.5.1
                        @Override // com.mbridge.msdk.newreward.function.h.a.InterfaceC0048a
                        public void blurSuccessCallBack(Bitmap bitmap2) {
                            PlayTemplePresenter.this.iView.setBackGroundImage(bitmap2);
                        }

                        @Override // com.mbridge.msdk.newreward.function.h.a.InterfaceC0048a
                        public void blurFailCallBack() {
                        }
                    });
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onFailedLoad(String str, String str2) {
                }
            });
        } catch (Exception e) {
            af.b("PlayTemplePresenter", e.getMessage());
        }
    }

    public void windowFocusChanged() {
        int iE;
        int iF;
        try {
            if (!isHalfScreenOffer()) {
                c cVar = this.commandManager;
                Object objD = cVar.d(cVar.a("fullScreenWidth", Float.valueOf(ak.j(this.context)), "fullScreenHeight", Float.valueOf(ak.i(this.context)), "campaign", this.campaignEx, "orientation", Integer.valueOf(this.context.getResources().getConfiguration().orientation)), f.TEMP_PLAYER_INIT);
                if (objD instanceof Map) {
                    Map map = (Map) objD;
                    this.iView.setPlayerSize(((Integer) map.get("gravity")).intValue(), ((Integer) map.get("width")).intValue(), ((Integer) map.get("height")).intValue());
                    return;
                }
                return;
            }
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
        } catch (Exception e) {
            af.b("PlayTemplePresenter", e.getMessage());
        }
    }
}

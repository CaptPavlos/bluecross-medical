package com.mbridge.msdk.newreward.player.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.c.c;
import com.mbridge.msdk.foundation.same.report.d.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.function.h.a;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.iview.IBaseView;
import com.mbridge.msdk.newreward.player.iview.IECTempleView;
import com.mbridge.msdk.newreward.player.model.ECTempleModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.newreward.player.redirect.UrlReDirectController;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.video.dynview.e.h;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ECTemplePresenter extends AbsPresenter {
    public static final int MIN_CLICK_DELAY_TIME = 2000;
    final int END_CARD_BUILD_TYPE;
    private final String TAG;
    Runnable alacRunnable;
    IECModel ecTempleModel;
    IECTempleView iecView;
    private long lastClickTime;
    Handler mHandler;
    Runnable miniCardRunnable;
    int nLogo;

    public ECTemplePresenter(IECTempleView iECTempleView) {
        super(iECTempleView);
        this.TAG = "ECTemplePresenter";
        this.END_CARD_BUILD_TYPE = 1;
        this.nLogo = 1;
        this.lastClickTime = 0L;
        this.iecView = (IECTempleView) Proxy.newProxyInstance(iECTempleView.getClass().getClassLoader(), new Class[]{IECTempleView.class, IBaseView.class}, new e(iECTempleView, this.adapterModel, this.commandManager));
        this.ecTempleModel = (IECModel) Proxy.newProxyInstance(ECTempleModel.class.getClassLoader(), new Class[]{IECModel.class}, new e(new ECTempleModel(this.commandManager, this.rewardVideoListener), this.adapterModel, this.commandManager));
        this.TEMPLATE_MARK_TYPE = 3;
    }

    private void closeViewClick() {
        try {
            this.iecView.removeTempleFromSuperView(this.data.getRootViewGroup());
            if (isIVRewardEnable()) {
                this.rewardVideoListener.onAdCloseWithIVReward(this.mBridgeIds, this.adapterModel.ab(), this.adapterModel.w());
            }
            adClosed();
            this.ecTempleModel.onCloseViewClick(1);
            if (!this.isIV && !this.adapterModel.X() && this.adapterModel.ab()) {
                this.adapterModel.i(true);
                this.ecTempleModel.eventAddReward(this.redirectModel);
            }
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
        finish(true);
    }

    private void doClickJump() {
        try {
            long timeInMillis = Calendar.getInstance().getTimeInMillis();
            if (timeInMillis - this.lastClickTime < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                return;
            }
            this.lastClickTime = timeInMillis;
            new UrlReDirectController().setCommandManager(this.commandManager);
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx != null) {
                campaignEx.setClickTempSource(a.h);
                this.campaignEx.setTriggerClickSource(a.f3808m);
            }
            this.ecTempleModel.eventClickUrl(this.redirectModel);
            this.ecTempleModel.eventTrackingForClick(this.redirectModel);
            this.ecTempleModel.onAdClick(this.mBridgeIds);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void initPrivacyButton() {
        ak.a(2, this.iecView.getNoticeIV(), this.campaignEx, this.context, true, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.2
            @Override // com.mbridge.msdk.foundation.d.a
            public void close() {
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void showed() {
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public void summit(String str) {
            }
        });
    }

    private void loadBigImageAndBlurBG() {
        try {
            b.a(this.context.getApplicationContext()).a(this.campaignEx.getImageUrl(), new c() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.4
                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                        ECTemplePresenter.this.iecView.setImageBitMap(eCTemplePresenter.filterFindViewId(eCTemplePresenter.is_dy, "mbridge_iv_adbanner"), bitmap);
                        com.mbridge.msdk.newreward.function.h.a.a(bitmap, new a.InterfaceC0048a() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.4.1
                            @Override // com.mbridge.msdk.newreward.function.h.a.InterfaceC0048a
                            public void blurSuccessCallBack(Bitmap bitmap2) {
                                ECTemplePresenter.this.iecView.setBlurBackGround(bitmap2);
                            }

                            @Override // com.mbridge.msdk.newreward.function.h.a.InterfaceC0048a
                            public void blurFailCallBack() {
                            }
                        });
                    } catch (Exception e) {
                        af.b("ECTemplePresenter", e.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onFailedLoad(String str, String str2) {
                }
            });
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
    }

    private void loadIconImage() {
        try {
            b.a(this.context.getApplicationContext()).a(this.campaignEx.getIconUrl(), new c() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.3
                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onSuccessLoad(Bitmap bitmap, String str) {
                    try {
                        ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                        ECTemplePresenter.this.iecView.setImageBitMap(eCTemplePresenter.filterFindViewId(eCTemplePresenter.is_dy, "mbridge_iv_icon"), bitmap);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onFailedLoad(String str, String str2) {
                }
            });
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
    }

    private void setNLogo() throws Resources.NotFoundException {
        Drawable drawable;
        String str;
        try {
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                drawable = this.context.getResources().getDrawable(this.context.getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
                str = "AD";
            } else {
                drawable = this.context.getResources().getDrawable(this.context.getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
                str = "广告";
            }
            this.iecView.setNLogo(this.nLogo, str, drawable);
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
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
    public void adShowFail(String str, int i10) {
        if (this.adapterModel.Y()) {
            return;
        }
        super.adShowFail(str, i10);
        this.ecTempleModel.onShowFail(this.mBridgeIds, str, i10);
        finish(true);
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void adShowSuccess() {
        if (this.adapterModel.Y()) {
            return;
        }
        super.adShowSuccess();
        this.adapterModel.j(true);
        this.ecTempleModel.onAdShow(this.mBridgeIds);
        this.ecTempleModel.eventImpression(this.redirectModel);
        this.ecTempleModel.eventOnlyImpression(this.redirectModel);
        this.ecTempleModel.eventPvUrls(this.redirectModel);
        this.ecTempleModel.eventTrackingForImpression(this.redirectModel);
    }

    public void addBaitClickView() {
        try {
            IECTempleView iECTempleView = this.iecView;
            if (iECTempleView == null || iECTempleView.getBaitClickView() == null) {
                return;
            }
            com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
            cVar.e(cVar.a("campaign", this.campaignEx, "template_model", this.ecTempleModel, "template_redirect_model", this.redirectModel, "bait_click_view", this.iecView.getBaitClickView(), "mbridge_ids", this.mBridgeIds), f.ADD_BAIT_CLICK);
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
    }

    public void addShakeView() {
        try {
            com.mbridge.msdk.newreward.function.command.c cVar = this.commandManager;
            Object objE = cVar.e(cVar.a("campaign", this.campaignEx, "template_model", this.ecTempleModel, "template_redirect_model", this.redirectModel, "mbridge_ids", this.mBridgeIds), f.ADD_SHAKE_VIEW);
            if (objE instanceof View) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (this.context.getResources().getConfiguration().orientation != 2) {
                    layoutParams.addRule(2, filterFindViewId(this.is_dy, "mbridge_iv_logo"));
                    layoutParams.addRule(14);
                    ((View) objE).setPadding(0, 0, 0, ak.a(this.context, 20.0f));
                } else {
                    layoutParams.addRule(13);
                }
                ((View) objE).setLayoutParams(layoutParams);
                this.iecView.addShakeView((View) objE);
            }
        } catch (Exception e) {
            af.b("ECTemplePresenter", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_close")) {
            closeViewClick();
            return;
        }
        if (view.getId() == filterFindViewId(this.is_dy, "mbridge_tv_cta")) {
            doClickJump();
            return;
        }
        if (view.getId() != filterFindViewId(this.is_dy, "mbridge_native_ec_layout")) {
            if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_adbanner")) {
                doClickJump();
                return;
            } else {
                if (view.getId() == filterFindViewId(this.is_dy, "mbridge_iv_icon")) {
                    doClickJump();
                    return;
                }
                return;
            }
        }
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getendcard_url()) || !this.campaignEx.getendcard_url().contains("alecfc=1")) {
            return;
        }
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel != null) {
            redirectModel.setClickSenario(1);
        }
        doClickJump();
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void finish(boolean z9) {
        Handler handler = this.mHandler;
        if (handler != null) {
            Runnable runnable = this.alacRunnable;
            if (runnable != null) {
                handler.removeCallbacks(runnable);
            }
            Runnable runnable2 = this.miniCardRunnable;
            if (runnable2 != null) {
                this.mHandler.removeCallbacks(runnable2);
            }
        }
        if (z9) {
            ((Activity) this.context).finish();
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        com.mbridge.msdk.video.dynview.c cVarA = new com.mbridge.msdk.video.dynview.j.c().a(this.context, this.campaignEx, -1, com.mbridge.msdk.e.b.a() ? "cn_" : "en_");
        this.nLogo = cVarA.n();
        com.mbridge.msdk.video.dynview.b.a().a(cVarA, new h() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.1
            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                ECTemplePresenter.this.adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                ECTemplePresenter.this.initDataForView(aVar);
            }
        });
    }

    public void handleInterceptTouchEvent(MotionEvent motionEvent) {
        RedirectModel redirectModel = this.redirectModel;
        if (redirectModel == null || motionEvent == null) {
            return;
        }
        redirectModel.setxInScreen(motionEvent.getRawX());
        this.redirectModel.setyInScreen(motionEvent.getRawY());
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(com.mbridge.msdk.video.dynview.a aVar) {
        try {
            if (aVar == null) {
                adShowFail(com.mbridge.msdk.foundation.c.a.a(890008), 890008);
                closeViewClick();
                return;
            }
            this.iecView.addViewToCurrentViewGroup(aVar.a());
            boolean zC = aVar.c();
            this.is_dy = zC;
            this.adapterModel.g(zC);
            this.campaignEx.setECTemplateRenderSucc(this.is_dy);
            this.iecView.initViews(this.is_dy);
            loadBigImageAndBlurBG();
            loadIconImage();
            initPrivacyButton();
            setNLogo();
            double rating = this.campaignEx.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            this.iecView.setRatingAndUser(rating, this.campaignEx.getNumberRating());
            this.iecView.setHeatCount(this.campaignEx.getNumberRating());
            this.iecView.setCTAText(this.campaignEx.getAdCall());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_apptitle"), this.campaignEx.getAppName());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_appdesc"), this.campaignEx.getAppDesc());
            this.iecView.setTextByID(filterFindViewId(this.is_dy, "mbridge_tv_number"), String.valueOf(this.campaignEx.getNumberRating()));
            adShowSuccess();
        } catch (Exception e) {
            adShowFail(e.getMessage(), -1);
            af.b("ECTemplePresenter", e.getMessage());
        }
    }

    public boolean isHalfScreenOffer() {
        CampaignEx campaignEx = this.campaignEx;
        return campaignEx != null && campaignEx.getAdSpaceT() == 2;
    }

    public void onBackPressed() {
        closeViewClick();
    }

    public void onEndCardShow() {
        if (this.ecTempleModel == null || this.adapterModel.Z()) {
            return;
        }
        this.ecTempleModel.onEndCardShow(this.mBridgeIds, 1);
        this.ecTempleModel.eventTrackingForEndCardShow(this.redirectModel, 1);
        this.adapterModel.k(true);
    }

    public void setAutoRedirect() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null) {
                return;
            }
            String endScreenUrl = campaignEx.getendcard_url();
            if (TextUtils.isEmpty(endScreenUrl)) {
                endScreenUrl = this.campaignEx.getEndScreenUrl();
            }
            String strA = aq.a(endScreenUrl, "alac");
            if (!TextUtils.isEmpty(strA) && strA.equals("1") && this.campaignEx.getAutoShowStoreMiniCard() != 1) {
                if (this.alacRunnable == null) {
                    this.alacRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.5
                        @Override // java.lang.Runnable
                        public void run() {
                            CampaignEx campaignEx2 = ECTemplePresenter.this.campaignEx;
                            if (campaignEx2 != null) {
                                campaignEx2.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                                ECTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3809n);
                                ECTemplePresenter.this.campaignEx.setClickType(com.mbridge.msdk.foundation.same.report.d.a.f3804i);
                            }
                            ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                            eCTemplePresenter.ecTempleModel.eventClickUrl(eCTemplePresenter.redirectModel);
                            ECTemplePresenter eCTemplePresenter2 = ECTemplePresenter.this;
                            eCTemplePresenter2.ecTempleModel.eventTrackingForClick(eCTemplePresenter2.redirectModel);
                            ECTemplePresenter eCTemplePresenter3 = ECTemplePresenter.this;
                            eCTemplePresenter3.ecTempleModel.onAdClick(eCTemplePresenter3.mBridgeIds);
                        }
                    };
                }
                if (this.mHandler == null) {
                    this.mHandler = new Handler();
                }
                this.mHandler.postDelayed(this.alacRunnable, 1000L);
            }
        } catch (Throwable th) {
            af.b("ECTemplePresenter", th.getMessage());
        }
    }

    public void setCloseViewShow() {
        CampaignEx campaignEx = this.campaignEx;
        if (campaignEx == null) {
            this.iecView.setCloseViewBtnDelayShow(1000);
            return;
        }
        boolean zA = ak.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int iC = ak.c(this.campaignEx.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        if (!zA || iC < 0) {
            iC = this.campaignEx.getCbd() > -2 ? this.campaignEx.getCbd() : (this.adapterModel.x() == null || this.adapterModel.x().b() == null) ? 1 : this.adapterModel.x().b().p();
        }
        this.iecView.setCloseViewBtnDelayShow(iC * 1000);
    }

    public void showStoreMiniCard() {
        try {
            CampaignEx campaignEx = this.campaignEx;
            if (campaignEx == null || campaignEx.getAutoShowStoreMiniCard() == 0 || TextUtils.isEmpty(this.campaignEx.getDeepLinkURL())) {
                return;
            }
            long showStoreMiniCardDelayTime = this.campaignEx.getShowStoreMiniCardDelayTime();
            if (showStoreMiniCardDelayTime == 0) {
                showStoreMiniCardDelayTime = 1;
            }
            if (this.miniCardRunnable == null) {
                this.miniCardRunnable = new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.ECTemplePresenter.6
                    @Override // java.lang.Runnable
                    public void run() {
                        CampaignEx campaignEx2 = ECTemplePresenter.this.campaignEx;
                        if (campaignEx2 != null) {
                            campaignEx2.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                            ECTemplePresenter.this.campaignEx.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3809n);
                            ECTemplePresenter.this.campaignEx.setClickType(com.mbridge.msdk.foundation.same.report.d.a.f3804i);
                        }
                        ECTemplePresenter eCTemplePresenter = ECTemplePresenter.this;
                        eCTemplePresenter.ecTempleModel.eventClickUrl(eCTemplePresenter.redirectModel);
                        ECTemplePresenter eCTemplePresenter2 = ECTemplePresenter.this;
                        eCTemplePresenter2.ecTempleModel.eventTrackingForClick(eCTemplePresenter2.redirectModel);
                        ECTemplePresenter eCTemplePresenter3 = ECTemplePresenter.this;
                        eCTemplePresenter3.ecTempleModel.onAdClick(eCTemplePresenter3.mBridgeIds);
                    }
                };
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler();
            }
            this.mHandler.postDelayed(this.miniCardRunnable, showStoreMiniCardDelayTime * 1000);
        } catch (Throwable th) {
            af.b("ECTemplePresenter", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
    }
}

package com.mbridge.msdk.newreward.player.presenter;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.a.b.b;
import com.mbridge.msdk.newreward.function.command.c;
import com.mbridge.msdk.newreward.function.command.f;
import com.mbridge.msdk.newreward.function.g.e;
import com.mbridge.msdk.newreward.player.imodel.IMoreOfferModel;
import com.mbridge.msdk.newreward.player.iview.IMoreOfferTemplateView;
import com.mbridge.msdk.newreward.player.model.MoreOfferModel;
import com.mbridge.msdk.newreward.player.redirect.MoreOfferRedirectModel;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.video.dynview.a;
import com.mbridge.msdk.video.dynview.widget.MBridgeRelativeLayout;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MoreOfferPresenter extends AbsPresenter {
    List<Integer> ImageLoadReadyCountList;
    private final String TAG;
    private int admf;
    private int admftm;
    private b callOutReqCallBack;
    IMoreOfferModel iMoreOfferModel;
    IMoreOfferTemplateView iMoreOfferTemplateView;
    int iconBufferCount;
    private final ImageLoadCountCallBack imageLoadCountCallBack;
    int initCanShowMaxCount;
    boolean isShown;
    LinearLayout linearLayout;
    com.mbridge.msdk.newreward.function.c.a.b moreOfferMBridgeCampaigns;
    MoreOfferModel moreOfferModel;
    MoreOfferRedirectModel moreOfferRedirectModel;
    private int moreOfferType;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface ImageLoadCountCallBack {
        void loadCountCallback();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class MoreOfferBuildCallback implements b {
        private MoreOfferBuildCallback() {
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            if (MoreOfferPresenter.this.callOutReqCallBack == null) {
                return;
            }
            MoreOfferPresenter.this.callOutReqCallBack.reqFailed(bVar);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public void reqSuccessful(Object obj) {
            IMoreOfferTemplateView iMoreOfferTemplateView = MoreOfferPresenter.this.iMoreOfferTemplateView;
            if (iMoreOfferTemplateView == null) {
                return;
            }
            try {
                iMoreOfferTemplateView.addViewToObservableScrollView((View) obj);
                MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                moreOfferPresenter.linearLayout = (LinearLayout) obj;
                moreOfferPresenter.addMoreOfferLikeText();
                MoreOfferPresenter moreOfferPresenter2 = MoreOfferPresenter.this;
                if (moreOfferPresenter2.rootParentView != null) {
                    moreOfferPresenter2.calculateCanShowCount();
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class MoreOfferCampaignRequestCallback implements b {
        private MoreOfferCampaignRequestCallback() {
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public void reqFailed(com.mbridge.msdk.foundation.c.b bVar) {
            IMoreOfferModel iMoreOfferModel = MoreOfferPresenter.this.iMoreOfferModel;
            if (iMoreOfferModel != null) {
                iMoreOfferModel.onMoreOfferRes(bVar.a() + "", "2", "1");
            }
            af.b("", bVar.b());
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public void reqSuccessful(Object obj) {
            try {
                if (obj instanceof com.mbridge.msdk.newreward.function.c.a.b) {
                    com.mbridge.msdk.newreward.function.c.a.b bVar = (com.mbridge.msdk.newreward.function.c.a.b) obj;
                    MoreOfferPresenter.this.moreOfferMBridgeCampaigns = bVar;
                    if (bVar.E() == null || MoreOfferPresenter.this.moreOfferMBridgeCampaigns.E().size() < 5) {
                        IMoreOfferModel iMoreOfferModel = MoreOfferPresenter.this.iMoreOfferModel;
                        if (iMoreOfferModel != null) {
                            iMoreOfferModel.onMoreOfferRes("12930014", "2", "1");
                            return;
                        }
                        return;
                    }
                    IMoreOfferModel iMoreOfferModel2 = MoreOfferPresenter.this.iMoreOfferModel;
                    if (iMoreOfferModel2 != null) {
                        iMoreOfferModel2.onMoreOfferRes("1", "1");
                    }
                    MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                    c cVar = moreOfferPresenter.commandManager;
                    cVar.e(cVar.a("campaign", moreOfferPresenter.campaignEx, "more_offer_campaign", obj, "command_type", f.BUILD_MORE_OFFER), new MoreOfferBuildCallback());
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public MoreOfferPresenter(IMoreOfferTemplateView iMoreOfferTemplateView) {
        super(iMoreOfferTemplateView);
        this.TAG = "MoreOfferTemplatePresenter";
        this.iconBufferCount = 2;
        this.ImageLoadReadyCountList = new ArrayList();
        this.isShown = false;
        this.imageLoadCountCallBack = new ImageLoadCountCallBack() { // from class: com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter.1
            @Override // com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter.ImageLoadCountCallBack
            public void loadCountCallback() {
                MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                if (moreOfferPresenter.isShown) {
                    return;
                }
                int size = moreOfferPresenter.ImageLoadReadyCountList.size();
                MoreOfferPresenter moreOfferPresenter2 = MoreOfferPresenter.this;
                if (size < moreOfferPresenter2.initCanShowMaxCount || moreOfferPresenter2.callOutReqCallBack == null) {
                    return;
                }
                MoreOfferPresenter moreOfferPresenter3 = MoreOfferPresenter.this;
                moreOfferPresenter3.isShown = true;
                if (!moreOfferPresenter3.moreOfferModel.mImpressionId.contains(0)) {
                    MoreOfferPresenter.this.setItemRedirectModel(0);
                    MoreOfferPresenter.this.doMoreOfferOnlyImpression();
                }
                MoreOfferPresenter.this.callOutReqCallBack.reqSuccessful(MoreOfferPresenter.this.rootParentView);
                MoreOfferPresenter.this.linearLayout.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MoreOfferPresenter.this.checkItemVisibleState();
                        MoreOfferPresenter.this.reportAdmfImpression();
                    }
                }, 500L);
                MoreOfferPresenter.this.iMoreOfferModel.onMoreOfferShow(MoreOfferPresenter.this.moreOfferType + "");
            }
        };
        this.iMoreOfferTemplateView = (IMoreOfferTemplateView) Proxy.newProxyInstance(iMoreOfferTemplateView.getClass().getClassLoader(), new Class[]{IMoreOfferTemplateView.class}, new e(iMoreOfferTemplateView, this.adapterModel, this.commandManager));
        this.moreOfferModel = new MoreOfferModel(this.commandManager);
        if (this.adapterModel.E() != null && this.adapterModel.E().f4970a != null) {
            this.moreOfferModel.mImpressionId.addAll(this.adapterModel.E().f4970a);
        }
        this.iMoreOfferModel = (IMoreOfferModel) Proxy.newProxyInstance(this.moreOfferModel.getClass().getClassLoader(), new Class[]{IMoreOfferModel.class}, new e(this.moreOfferModel, this.adapterModel, this.commandManager));
        MoreOfferRedirectModel moreOfferRedirectModel = new MoreOfferRedirectModel();
        this.moreOfferRedirectModel = moreOfferRedirectModel;
        moreOfferRedirectModel.setContext(this.context);
        this.moreOfferRedirectModel.setSettingModel(this.adapterModel.x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMoreOfferLikeText() {
        if (this.iMoreOfferTemplateView == null) {
            return;
        }
        try {
            boolean zContains = ab.t(com.mbridge.msdk.foundation.controller.c.m().c()).contains("zh");
            IMoreOfferTemplateView iMoreOfferTemplateView = this.iMoreOfferTemplateView;
            if (zContains) {
                iMoreOfferTemplateView.addMoreOfferLikeText("猜你喜欢", ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 30.0f));
            } else {
                iMoreOfferTemplateView.addMoreOfferLikeText("Just\nfor\nYou", 0);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateCanShowCount() {
        LinearLayout linearLayout = this.linearLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= 5) {
            return;
        }
        try {
            this.initCanShowMaxCount = ((ak.f(com.mbridge.msdk.foundation.controller.c.m().c()) - ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 40.0f)) / ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 70.0f)) + this.admf;
            if (this.linearLayout.getChildCount() < this.initCanShowMaxCount) {
                this.initCanShowMaxCount = this.linearLayout.getChildCount();
            }
            if (this.linearLayout.getChildCount() >= this.initCanShowMaxCount) {
                for (int i10 = 0; i10 < this.initCanShowMaxCount; i10++) {
                    View childAt = this.linearLayout.getChildAt(i10);
                    if (childAt != null) {
                        loadIconImageUrl(childAt, i10);
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkItemVisibleState() {
        View childAt;
        if (this.linearLayout == null) {
            return;
        }
        for (int i10 = 0; i10 < this.linearLayout.getChildCount(); i10++) {
            try {
                this.moreOfferRedirectModel.setItemPositionId(i10);
                if (!this.moreOfferModel.mImpressionId.contains(Integer.valueOf(i10)) && (childAt = this.linearLayout.getChildAt(i10)) != null) {
                    setItemRedirectModel(i10);
                    setMoreOfferItemClickListener(childAt);
                    doMoreOfferImpression(childAt, i10);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
    }

    private void doMoreOfferImpression(View view, int i10) {
        List<Integer> list;
        if (this.moreOfferModel == null) {
            return;
        }
        try {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z9 = rect.width() > view.getMeasuredWidth() / 5;
            if (!globalVisibleRect || !z9) {
                if (this.iconBufferCount <= 2 && (list = this.ImageLoadReadyCountList) != null && !list.contains(Integer.valueOf(i10))) {
                    loadIconImageUrl(view, i10);
                }
                this.iconBufferCount++;
                return;
            }
            this.iconBufferCount = 1;
            List<Integer> list2 = this.ImageLoadReadyCountList;
            if (list2 != null && !list2.contains(Integer.valueOf(i10))) {
                loadIconImageUrl(view, i10);
            }
            this.moreOfferModel.eventImpression(this.moreOfferRedirectModel);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMoreOfferOnlyImpression() {
        MoreOfferModel moreOfferModel = this.moreOfferModel;
        if (moreOfferModel == null) {
            return;
        }
        moreOfferModel.eventOnlyImpression(this.moreOfferRedirectModel);
    }

    private CampaignEx getCampaignEx(int i10) {
        try {
            if (this.adapterModel.E() == null) {
                return null;
            }
            int i11 = this.moreOfferType;
            if (i11 == 1) {
                if (this.adapterModel.E().a() == null || this.adapterModel.E().a().E() == null || this.adapterModel.E().a().E().isEmpty()) {
                    return null;
                }
                return this.adapterModel.E().a().E().get(i10);
            }
            if (i11 != 2 || this.adapterModel.E().b() == null || this.adapterModel.E().b().E() == null || this.adapterModel.E().b().E().isEmpty()) {
                return null;
            }
            return this.adapterModel.E().b().E().get(i10);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    private void loadIconImageUrl(View view, final int i10) {
        com.mbridge.msdk.newreward.function.c.a.b bVar = this.moreOfferMBridgeCampaigns;
        if (bVar == null) {
            return;
        }
        try {
            List<CampaignEx> listE = bVar.E();
            if (listE == null || listE.size() <= i10) {
                return;
            }
            final RoundImageView roundImageView = (RoundImageView) view.findViewById(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_end_card_item_iv", "id"));
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(listE.get(i10).getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter.2
                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap != null) {
                        try {
                            List<Integer> list = MoreOfferPresenter.this.ImageLoadReadyCountList;
                            if (list != null) {
                                list.add(Integer.valueOf(i10));
                            }
                            roundImageView.setBorderRadius(13);
                            roundImageView.setImageBitmap(bitmap);
                            MoreOfferPresenter.this.imageLoadCountCallBack.loadCountCallback();
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public void onFailedLoad(String str, String str2) {
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAdmfImpression() {
        for (int i10 = 0; i10 < this.initCanShowMaxCount; i10++) {
            try {
                if (!this.moreOfferModel.mImpressionId.contains(Integer.valueOf(i10))) {
                    this.moreOfferRedirectModel.setItemPositionId(i10);
                    setItemRedirectModel(i10);
                    this.moreOfferModel.eventImpression(this.moreOfferRedirectModel);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setItemRedirectModel(int i10) {
        if (this.adapterModel == null || this.moreOfferRedirectModel == null) {
            return;
        }
        try {
            String str = "117361";
            CampaignEx campaignEx = getCampaignEx(i10);
            String strA = "";
            if (campaignEx != null) {
                this.moreOfferRedirectModel.setCampaignEx(campaignEx);
                strA = aq.a(campaignEx.getendcard_url(), "mof_testuid");
                if (TextUtils.isEmpty(strA)) {
                    strA = aq.a(campaignEx.getendcard_url(), "mof_uid");
                }
            }
            if (!TextUtils.isEmpty(strA)) {
                str = strA;
            }
            this.moreOfferRedirectModel.setUnitId(str);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void setMoreOfferItemClickListener(View view) {
        if (view == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.player.presenter.MoreOfferPresenter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MoreOfferPresenter moreOfferPresenter = MoreOfferPresenter.this;
                MoreOfferModel moreOfferModel = moreOfferPresenter.moreOfferModel;
                if (moreOfferModel == null) {
                    return;
                }
                try {
                    moreOfferModel.eventClickUrl(moreOfferPresenter.moreOfferRedirectModel);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void click(View view) {
        if (this.iMoreOfferTemplateView == null || view == null || view.getId() != filterFindViewId(false, "mbridge_reward_end_card_like_tv")) {
            return;
        }
        this.iMoreOfferTemplateView.setObservableScrollViewVisible();
    }

    public void getAdMFTmValue(int i10) {
        try {
            JSONObject jSONObject = new JSONObject(this.campaignEx.getMoreOfferJsonData());
            JSONObject jSONObject2 = i10 != 1 ? i10 != 2 ? null : jSONObject.getJSONObject(CampaignEx.ENDCARD_URL) : jSONObject.getJSONObject("template_url");
            if (jSONObject2 != null) {
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM)) {
                    this.admftm = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMFTM);
                }
                if (jSONObject2.has(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF)) {
                    this.admf = jSONObject2.getInt(MBridgeConstans.DYNAMIC_VIEW_MORE_OFFER_ADMF);
                }
            }
        } catch (Exception e) {
            af.b("MoreOfferTemplatePresenter", e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void getView() {
        if (this.iMoreOfferTemplateView == null) {
            return;
        }
        try {
            MBridgeRelativeLayout mBridgeRelativeLayout = (MBridgeRelativeLayout) LayoutInflater.from(this.context).inflate(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_more_offer_view", TtmlNode.TAG_LAYOUT), (ViewGroup) null, false);
            if (mBridgeRelativeLayout != null) {
                this.iMoreOfferTemplateView.addViewToCurrentViewGroup(mBridgeRelativeLayout);
                mBridgeRelativeLayout.setBackgroundColor(-1);
            }
            this.iMoreOfferTemplateView.initViews(false);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void onTouch(View view) {
        if (view == null || view.getId() != filterFindViewId(false, "mbridge_moreoffer_hls")) {
            return;
        }
        checkItemVisibleState();
    }

    public void setIReqCallBack(b bVar) {
        this.callOutReqCallBack = bVar;
    }

    public void syncLoad(int i10) {
        this.moreOfferType = i10;
        if (this.campaignEx == null) {
            return;
        }
        getAdMFTmValue(i10);
        try {
            if (i10 == 1) {
                this.iMoreOfferModel.onMoreOfferReq("1");
                c cVar = this.commandManager;
                cVar.e(cVar.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 1, "adapter_model", this.adapterModel), new MoreOfferCampaignRequestCallback());
            } else {
                if (i10 != 2) {
                    return;
                }
                if (this.adapterModel.E().b() == null) {
                    this.iMoreOfferModel.onMoreOfferReq("1");
                    c cVar2 = this.commandManager;
                    cVar2.e(cVar2.a("campaign", this.campaignEx, "command_type", f.REQ_MORE_OFFER_CAMPAIGN, "more_offer_type", 2, "adapter_model", this.adapterModel), new MoreOfferCampaignRequestCallback());
                } else {
                    this.moreOfferMBridgeCampaigns = this.adapterModel.E().b();
                    if (this.adapterModel.E().b().E().size() >= 5) {
                        c cVar3 = this.commandManager;
                        cVar3.e(cVar3.a("campaign", this.campaignEx, "more_offer_campaign", this.adapterModel.E().b(), "command_type", f.BUILD_MORE_OFFER), new MoreOfferBuildCallback());
                    }
                }
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void releaseSource() {
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void finish(boolean z9) {
    }

    @Override // com.mbridge.msdk.newreward.player.presenter.AbsPresenter
    public void initDataForView(a aVar) {
    }
}

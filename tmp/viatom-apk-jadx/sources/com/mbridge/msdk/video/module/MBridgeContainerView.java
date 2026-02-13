package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.R;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.g;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView;
import com.mbridge.msdk.video.module.a.a;
import com.mbridge.msdk.video.module.a.a.i;
import com.mbridge.msdk.video.module.a.a.k;
import com.mbridge.msdk.video.module.a.a.l;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.video.signal.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeContainerView extends MBridgeBaseView implements f, h {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private int H;
    private boolean I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private b Q;
    private boolean R;
    private boolean S;
    private List<CampaignEx> T;

    /* renamed from: m, reason: collision with root package name */
    private MBridgePlayableView f5924m;

    /* renamed from: n, reason: collision with root package name */
    private MBridgeClickCTAView f5925n;

    /* renamed from: o, reason: collision with root package name */
    private MBridgeClickMiniCardView f5926o;

    /* renamed from: p, reason: collision with root package name */
    private MBridgeNativeEndCardView f5927p;

    /* renamed from: q, reason: collision with root package name */
    private MBridgeH5EndCardView f5928q;

    /* renamed from: r, reason: collision with root package name */
    private MBridgeVastEndCardView f5929r;

    /* renamed from: s, reason: collision with root package name */
    private MBridgeLandingPageView f5930s;
    private MBridgeVideoEndCoverView t;

    /* renamed from: u, reason: collision with root package name */
    private MBridgeAlertWebview f5931u;

    /* renamed from: v, reason: collision with root package name */
    private MBridgeOrderCampView f5932v;

    /* renamed from: w, reason: collision with root package name */
    private String f5933w;

    /* renamed from: x, reason: collision with root package name */
    private int f5934x;
    private int y;

    /* renamed from: z, reason: collision with root package name */
    private int f5935z;

    public MBridgeContainerView(Context context) {
        super(context);
        this.y = 1;
        this.f5935z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.R = false;
        this.S = false;
        this.T = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Integer num) {
        CampaignEx campaignEx;
        a aVar;
        CampaignEx campaignEx2;
        this.Q = bVar;
        CampaignEx campaignEx3 = this.f5901b;
        if (campaignEx3 != null) {
            Integer numValueOf = num == null ? Integer.valueOf(campaignEx3.getVideo_end_type()) : num;
            if (!isLast()) {
                h();
            }
            int iIntValue = numValueOf.intValue();
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    if (this.f5929r == null) {
                        this.f5929r = new MBridgeVastEndCardView(this.f5900a);
                    }
                    this.f5929r.setCampaign(this.f5901b);
                    this.f5929r.setNotifyListener(new l(this.notifyListener));
                    this.f5929r.preLoadData(bVar);
                    return;
                }
                if (iIntValue == 4) {
                    if (this.f5930s == null) {
                        this.f5930s = new MBridgeLandingPageView(this.f5900a);
                    }
                    this.f5930s.setCampaign(this.f5901b);
                    this.f5930s.setNotifyListener(new i(this.notifyListener));
                    return;
                }
                if (iIntValue != 5) {
                    int i10 = this.y;
                    CampaignEx campaignEx4 = this.f5901b;
                    if (i10 == 2) {
                        boolean zIsDynamicView = campaignEx4.isDynamicView();
                        boolean zL = ak.l(this.f5901b.getendcard_url());
                        if ((zIsDynamicView && !zL && (campaignEx2 = this.f5901b) != null && !campaignEx2.isMraid()) || (campaignEx = this.f5901b) == null || campaignEx.getAdSpaceT() == 2) {
                            return;
                        }
                        if (this.f5928q == null) {
                            this.f5928q = new MBridgeH5EndCardView(this.f5900a);
                            try {
                                e eVar = new e();
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
                                d.a().a("2000154", this.f5901b, eVar);
                            } catch (Throwable th) {
                                af.b(MBridgeBaseView.TAG, th.getMessage());
                            }
                        }
                        if (this.f5901b.getDynamicTempCode() == 5 && (aVar = this.notifyListener) != null && (aVar instanceof k)) {
                            ((k) aVar).a(this.f5901b);
                        }
                        this.f5928q.setCampaign(this.f5901b);
                        this.f5928q.setCloseDelayShowTime(this.f5935z);
                        this.f5928q.setNotifyListener(new i(this.notifyListener));
                        this.f5928q.setUnitId(this.f5933w);
                        this.f5928q.setNotchValue(this.P, this.K, this.L, this.M, this.N);
                        this.f5928q.preLoadData(bVar);
                        if (this.D) {
                            return;
                        }
                        addView(this.f5928q);
                        return;
                    }
                    int iB = (campaignEx4 == null || campaignEx4.getRewardTemplateMode() == null) ? 0 : this.f5901b.getRewardTemplateMode().b();
                    if (this.f5927p == null) {
                        CampaignEx campaignEx5 = this.f5901b;
                        if (campaignEx5 == null || !campaignEx5.isDynamicView()) {
                            Context context = this.f5900a;
                            CampaignEx campaignEx6 = this.f5901b;
                            boolean z9 = campaignEx6 != null && campaignEx6.getAdSpaceT() == 2;
                            CampaignEx campaignEx7 = this.f5901b;
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = new MBridgeNativeEndCardView(context, null, false, -1, z9, iB, campaignEx7 != null ? campaignEx7.getMof_tplid() : 0);
                            this.f5927p = mBridgeNativeEndCardView;
                            mBridgeNativeEndCardView.setCampaign(this.f5901b);
                        } else {
                            i();
                        }
                    }
                    this.f5927p.setLayout();
                    if (this.f5901b.isDynamicView()) {
                        if (com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f5901b.getRequestId() + "_" + this.f5901b.getId())) {
                            try {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f5927p, this.f5901b.getRequestId() + "_" + this.f5901b.getId(), new i(this.notifyListener));
                            } catch (Exception e) {
                                af.b(MBridgeBaseView.TAG, e.getMessage());
                            }
                        } else {
                            try {
                                String strA = aq.a(this.f5901b.getendcard_url(), "mof");
                                if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                    com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f5901b, this.f5927p, new i(this.notifyListener), 2);
                                }
                            } catch (Exception e3) {
                                af.b(MBridgeBaseView.TAG, e3.getMessage());
                            }
                        }
                    }
                    this.f5927p.setUnitId(this.f5933w);
                    this.f5927p.setCloseBtnDelay(this.f5935z);
                    this.f5927p.setNotifyListener(new i(this.notifyListener));
                    this.f5927p.preLoadData(bVar);
                    this.f5927p.setNotchPadding(this.K, this.L, this.M, this.N);
                }
            }
        }
    }

    private void b() {
        if (this.f5928q == null) {
            a(this.Q, 2);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView == null || !mBridgeH5EndCardView.isLoadSuccess()) {
            e();
            MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f5928q;
            if (mBridgeH5EndCardView2 != null) {
                mBridgeH5EndCardView2.reportRenderResult("timeout", 3);
                this.f5928q.setError(true);
            }
        } else {
            this.I = true;
            addView(this.f5928q);
            webviewshow();
            onConfigurationChanged(getResources().getConfiguration());
            this.f5928q.excuteTask();
            this.f5928q.setNotchValue(this.P, this.K, this.L, this.M, this.N);
            n nVar = new n();
            nVar.f(this.f5901b.getRequestId());
            nVar.g(this.f5901b.getRequestIdNotice());
            nVar.e(this.f5901b.getId());
            nVar.d(this.f5901b.isMraid() ? n.f3580a : n.f3581b);
            g.d(nVar, this.f5900a, this.f5933w);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView3 = this.f5928q;
        if (mBridgeH5EndCardView3 != null) {
            mBridgeH5EndCardView3.setUnitId(this.f5933w);
        }
    }

    private void e() {
        this.y = 1;
        if (this.f5927p == null) {
            a(this.Q, 2);
        }
        addView(this.f5927p);
        onConfigurationChanged(getResources().getConfiguration());
        this.f5927p.notifyShowListener();
        this.S = true;
        bringToFront();
    }

    private void f() {
        if (this.f5926o == null) {
            b(-2);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        if (this.D && this.E) {
            this.E = false;
            layoutParams.width = 1;
            layoutParams.height = 1;
        }
        addView(this.f5926o, layoutParams);
    }

    private void g() {
        if (this.f5931u == null) {
            MBridgeAlertWebview mBridgeAlertWebview = new MBridgeAlertWebview(this.f5900a);
            this.f5931u = mBridgeAlertWebview;
            mBridgeAlertWebview.setUnitId(this.f5933w);
            this.f5931u.setCampaign(this.f5901b);
        }
        this.f5931u.preLoadData(this.Q);
    }

    private void h() {
        this.C = false;
        this.S = false;
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            int i10 = 0;
            for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt instanceof MBridgeContainerView) {
                    i10++;
                } else {
                    viewGroup.bringChildToFront(childAt);
                }
            }
        }
    }

    private void i() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getendcard_url();
        boolean zIsEmpty = TextUtils.isEmpty(str);
        int i10 = MBridgeCommon.CampaignState.STATE_LOAD_FAILED_RESOURCE_DOWNLOAD_ERROR;
        if (!zIsEmpty) {
            try {
                i10 = Integer.parseInt(aq.a(str, "ecid"));
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        this.f5927p = new MBridgeNativeEndCardView(this.f5900a, null, true, i10, this.f5901b.getAdSpaceT() == 2, this.f5906k, this.f5901b.getMof_tplid());
        if (this.f5901b.getDynamicTempCode() != 5) {
            this.f5927p.setCampaign(this.f5901b);
            return;
        }
        a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.f5901b);
        }
        this.f5927p.setCampaign(this.f5901b);
    }

    public void addOrderViewData(List<CampaignEx> list) {
        if (list == null) {
            return;
        }
        this.T = list;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view == null) {
            af.b(MBridgeBaseView.TAG, "view is null");
        } else {
            a(view);
            super.addView(view);
        }
    }

    public boolean canBackPress() {
        if (this.f5927p != null) {
            return false;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            return mBridgeH5EndCardView.canBackPress();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f5930s;
        if (mBridgeLandingPageView != null) {
            return mBridgeLandingPageView.canBackPress();
        }
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            return mBridgePlayableView.canBackPress();
        }
        return false;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void configurationChanged(int i10, int i11, int i12) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        if (mBridgeClickMiniCardView == null || mBridgeClickMiniCardView.getVisibility() != 0) {
            return;
        }
        this.f5926o.resizeMiniCard(i10, i11);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean endCardShowing() {
        return this.B;
    }

    public boolean endcardIsPlayable() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        return mBridgeH5EndCardView != null && mBridgeH5EndCardView.isPlayable();
    }

    public MBridgeH5EndCardView getH5EndCardView() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        return mBridgeH5EndCardView == null ? this.f5924m : mBridgeH5EndCardView;
    }

    public CampaignEx getReSetCampaign() {
        if (!this.f5901b.isDynamicView() || !TextUtils.isEmpty(this.f5901b.getendcard_url())) {
            return null;
        }
        int size = this.T.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i11 < size) {
                if (this.T.get(i11) != null && this.T.get(i11).getId() == this.f5901b.getId()) {
                    i10 = i11 - 1;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        if (i10 < 0 || i10 >= size || this.T.get(i10) == null) {
            return null;
        }
        return this.T.get(i10);
    }

    public boolean getShowingTransparent() {
        return this.D;
    }

    public String getUnitID() {
        return this.f5933w;
    }

    public int getVideoInteractiveType() {
        return this.f5934x;
    }

    public int getVideoSkipTime() {
        return this.H;
    }

    public void handlerPlayableException(String str) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.handlerPlayableException(str);
            if (!this.I) {
                return;
            }
        }
        a();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void hideAlertWebview() {
        if (isLast()) {
            return;
        }
        if (this.R && !this.S) {
            h();
            this.R = false;
        }
        MBridgeAlertWebview mBridgeAlertWebview = this.f5931u;
        if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
            return;
        }
        removeView(this.f5931u);
        MBridgeClickCTAView mBridgeClickCTAView = this.f5925n;
        if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
            return;
        }
        setWrapContent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(12, -1);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        setVisibility(0);
    }

    public void install(CampaignEx campaignEx) {
        this.notifyListener.a(105, campaignEx);
    }

    public boolean isLast() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        return viewGroup != null && viewGroup.indexOfChild(this) == 0;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void ivRewardAdsWithoutVideo(String str) {
        this.notifyListener.a(103, str);
    }

    public boolean miniCardLoaded() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        return mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.isLoadSuccess();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean miniCardShowing() {
        return this.C;
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i10) {
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.notifyCloseBtn(i10);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.notifyCloseBtn(i10);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f5924m, this.f5925n, this.f5926o, this.f5927p, this.f5928q, this.f5929r, this.f5930s, this.t};
        for (int i10 = 0; i10 < 8; i10++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i10];
            if (mBridgeBaseView != null && (mBridgeBaseView instanceof MBridgeClickMiniCardView)) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            } else if (mBridgeBaseView != null && mBridgeBaseView.getVisibility() == 0 && mBridgeBaseView.getParent() != null && !isLast()) {
                mBridgeBaseView.onSelfConfigurationChanged(configuration);
            }
        }
    }

    public void onEndcardBackPress() {
        if (this.f5927p != null || this.f5929r != null) {
            this.notifyListener.a(104, "");
            try {
                com.mbridge.msdk.video.dynview.moffer.a.a().b();
                return;
            } catch (Exception e) {
                af.b(MBridgeBaseView.TAG, e.getMessage());
                return;
            }
        }
        if (this.f5930s != null) {
            this.notifyListener.a(103, "");
            return;
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.onBackPress();
        }
    }

    public void onMiniEndcardBackPress() {
        if (this.C) {
            this.notifyListener.a(107, "");
        }
    }

    public void onPlayableBackPress() {
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.onBackPress();
        }
    }

    public void orientation(Configuration configuration) throws JSONException {
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f5924m, this.f5926o, this.f5928q, this.f5931u};
        for (int i10 = 0; i10 < 4; i10++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i10];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0) {
                mBridgeH5EndCardView.orientation(getResources().getConfiguration());
            }
        }
    }

    public void preLoadData(final b bVar) {
        this.Q = bVar;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                if (this.f5924m == null) {
                    this.f5924m = new MBridgePlayableView(this.f5900a);
                }
                this.f5924m.setCloseDelayShowTime(this.f5935z);
                this.f5924m.setPlayCloseBtnTm(this.A);
                this.f5924m.setCampaign(this.f5901b);
                this.f5924m.setNotifyListener(new i(this.notifyListener) { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.4
                    @Override // com.mbridge.msdk.video.module.a.a.i, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
                    public final void a(int i10, Object obj) {
                        super.a(i10, obj);
                        if (i10 == 100) {
                            MBridgeContainerView.this.webviewshow();
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.onConfigurationChanged(mBridgeContainerView.getResources().getConfiguration());
                            n nVar = new n();
                            nVar.f(MBridgeContainerView.this.f5901b.getRequestId());
                            nVar.g(MBridgeContainerView.this.f5901b.getRequestIdNotice());
                            nVar.e(MBridgeContainerView.this.f5901b.getId());
                            nVar.d(MBridgeContainerView.this.f5901b.isMraid() ? n.f3580a : n.f3581b);
                            MBridgeContainerView mBridgeContainerView2 = MBridgeContainerView.this;
                            g.d(nVar, mBridgeContainerView2.f5900a, mBridgeContainerView2.f5933w);
                        }
                    }
                });
                this.f5924m.preLoadData(bVar);
            } else {
                b(this.f5934x);
                if (this.f5901b.isDynamicView()) {
                    try {
                        a(bVar, Integer.valueOf(this.f5901b.getVideo_end_type()));
                    } catch (Throwable th) {
                        af.b(MBridgeBaseView.TAG, th.getMessage());
                        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                                mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f5901b.getVideo_end_type()));
                            }
                        });
                    }
                    if (!ak.l(this.f5901b.getendcard_url())) {
                        try {
                            String strA = aq.a(this.f5901b.getendcard_url(), "mof");
                            if (!TextUtils.isEmpty(strA) && Integer.parseInt(strA) == 1) {
                                com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f5901b, 2);
                            }
                        } catch (Exception e) {
                            af.b(MBridgeBaseView.TAG, e.getMessage());
                        }
                    }
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                            mBridgeContainerView.a(bVar, Integer.valueOf(mBridgeContainerView.f5901b.getVideo_end_type()));
                        }
                    }, getVideoSkipTime());
                }
            }
            g();
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void readyStatus(int i10) {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.readyStatus(i10);
        }
    }

    public void release() {
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.release();
            this.f5928q = null;
        }
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.release();
        }
        MBridgeLandingPageView mBridgeLandingPageView = this.f5930s;
        if (mBridgeLandingPageView != null) {
            mBridgeLandingPageView.release();
        }
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f5927p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.clearMoreOfferBitmap();
            this.f5927p.release();
        }
        if (this.notifyListener != null) {
            this.notifyListener = null;
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void resizeMiniCard(int i10, int i11, int i12) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.resizeMiniCard(i10, i11);
            this.f5926o.setRadius(i12);
            removeAllViews();
            setMatchParent();
            this.S = true;
            bringToFront();
            f();
        }
    }

    public void setCloseDelayTime(int i10) {
        this.f5935z = i10;
    }

    public void setEndscreenType(int i10) {
        this.y = i10;
    }

    public void setJSFactory(b bVar) {
        this.Q = bVar;
    }

    public void setMBridgeClickMiniCardViewTransparent() {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMBridgeClickMiniCardViewTransparent();
            this.f5926o.setMBridgeClickMiniCardViewClickable(false);
        }
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13, int i14) {
        af.b(MBridgeBaseView.TAG, "NOTCH ContainerView ".concat(String.format("%1s-%2s-%3s-%4s-%5s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i10))));
        this.O = i10;
        this.K = i11;
        this.L = i12;
        this.M = i13;
        this.N = i14;
        this.P = s.a(i10, i11, i12, i13, i14);
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f5927p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setNotchPadding(i11, i12, i13, i14);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.f5945p != null) {
            mBridgeH5EndCardView.setNotchValue(this.P, i11, i12, i13, i14);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f5928q.f5945p, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null && mBridgePlayableView.f5945p != null) {
            mBridgePlayableView.setNotchValue(this.P, i11, i12, i13, i14);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) this.f5924m.f5945p, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
        }
        MBridgeOrderCampView mBridgeOrderCampView = this.f5932v;
        if (mBridgeOrderCampView != null) {
            mBridgeOrderCampView.setNotchPadding(i11, i12, i13, i14);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setNotifyListener(a aVar) {
        super.setNotifyListener(aVar);
        MBridgeBaseView[] mBridgeBaseViewArr = {this.f5924m, this.f5925n, this.f5926o, this.f5927p, this.f5928q, this.f5929r, this.f5930s, this.t};
        for (int i10 = 0; i10 < 8; i10++) {
            MBridgeBaseView mBridgeBaseView = mBridgeBaseViewArr[i10];
            if (mBridgeBaseView != null) {
                if (mBridgeBaseView instanceof MBridgeClickMiniCardView) {
                    mBridgeBaseView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(this.f5926o, aVar));
                } else {
                    mBridgeBaseView.setNotifyListener(new i(aVar));
                }
            }
        }
    }

    public void setOnPause() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f5927p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnPause();
        }
    }

    public void setOnResume() {
        MBridgeNativeEndCardView mBridgeNativeEndCardView = this.f5927p;
        if (mBridgeNativeEndCardView != null) {
            mBridgeNativeEndCardView.setOnResume();
        }
    }

    public void setPlayCloseBtnTm(int i10) {
        this.A = i10;
    }

    public void setRewardStatus(boolean z9) {
        this.J = z9;
    }

    public void setShowingTransparent(boolean z9) {
        this.D = z9;
    }

    public void setUnitID(String str) {
        this.f5933w = str;
    }

    public void setVideoInteractiveType(int i10) {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            this.f5934x = i10;
            return;
        }
        int iA = com.mbridge.msdk.video.dynview.i.a.a(this.f5901b);
        if (iA == 100) {
            this.f5934x = i10;
        } else {
            this.f5934x = iA;
        }
    }

    public void setVideoSkipTime(int i10) {
        this.H = i10;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public boolean showAlertWebView() {
        MBridgeAlertWebview mBridgeAlertWebview = this.f5931u;
        if (mBridgeAlertWebview == null || !mBridgeAlertWebview.isLoadSuccess()) {
            return false;
        }
        setMatchParent();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup.indexOfChild(this) != viewGroup.getChildCount() - 1 && !this.S) {
            removeAllViews();
            bringToFront();
            this.R = true;
        }
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
            return false;
        }
        if (this.f5931u == null) {
            g();
        }
        MBridgeAlertWebview mBridgeAlertWebview2 = this.f5931u;
        if (mBridgeAlertWebview2 != null && mBridgeAlertWebview2.getParent() != null) {
            removeView(this.f5931u);
        }
        addView(this.f5931u);
        setBackgroundColor(0);
        this.f5931u.webviewshow();
        return true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showEndcard(int i10) {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            if (i10 == 1) {
                this.notifyListener.a(104, "");
            } else if (i10 == 100) {
                if (campaignEx.getPlayable_ads_without_video() == 2) {
                    this.G = true;
                }
                a(this.f5924m);
                setMatchParent();
                e();
            } else if (i10 == 3) {
                removeAllViews();
                setMatchParent();
                if (this.f5929r == null) {
                    a(this.Q, 3);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(13, -1);
                addView(this.f5929r, layoutParams);
                this.f5929r.notifyShowListener();
                this.S = true;
                bringToFront();
            } else if (i10 == 4) {
                this.notifyListener.a(113, "");
                removeAllViews();
                setMatchParent();
                if (this.f5930s == null) {
                    a(this.Q, 4);
                }
                this.f5930s.setUnitId(this.f5933w);
                this.f5930s.preLoadData(this.Q);
                addView(this.f5930s);
                this.S = true;
                bringToFront();
            } else if (i10 != 5) {
                removeAllViews();
                setMatchParent();
                this.S = true;
                bringToFront();
                a();
                this.notifyListener.a(R.styleable.ConstraintSet_pivotAnchor, "");
            } else {
                this.notifyListener.a(106, "");
            }
        }
        this.B = true;
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showMiniCard(int i10, int i11, int i12, int i13, int i14) {
        MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
        if (mBridgeClickMiniCardView != null) {
            mBridgeClickMiniCardView.setMiniCardLocation(i10, i11, i12, i13);
            this.f5926o.setRadius(i14);
            this.f5926o.setCloseVisible(8);
            this.f5926o.setClickable(false);
            removeAllViews();
            setMatchParent();
            this.S = true;
            bringToFront();
            f();
            if (this.F) {
                return;
            }
            this.F = true;
            this.notifyListener.a(109, "");
            this.notifyListener.a(R.styleable.ConstraintSet_pivotAnchor, "");
        }
    }

    public void showOrderCampView() {
        MBridgeOrderCampView mBridgeOrderCampView = new MBridgeOrderCampView(this.f5900a);
        this.f5932v = mBridgeOrderCampView;
        mBridgeOrderCampView.setCampaignExes(this.T);
        a aVar = this.notifyListener;
        if (aVar != null && (aVar instanceof k)) {
            ((k) aVar).a(this.T);
        }
        this.f5932v.setNotifyListener(new i(this.notifyListener));
        this.f5932v.setRewarded(this.J);
        this.f5932v.setNotchPadding(this.K, this.L, this.M, this.N);
        this.f5932v.setCampOrderViewBuildCallback(new com.mbridge.msdk.video.dynview.e.b() { // from class: com.mbridge.msdk.video.module.MBridgeContainerView.3
            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void a() {
                a aVar2 = MBridgeContainerView.this.notifyListener;
                if (aVar2 != null) {
                    aVar2.a(R.styleable.ConstraintSet_pivotAnchor, "");
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.b
            public final void b() {
                int adSpaceT = MBridgeContainerView.this.f5901b.getAdSpaceT();
                MBridgeContainerView mBridgeContainerView = MBridgeContainerView.this;
                if (adSpaceT == 2) {
                    mBridgeContainerView.showVideoEndCover();
                } else {
                    mBridgeContainerView.showEndcard(mBridgeContainerView.f5901b.getVideo_end_type());
                }
            }
        });
        this.f5932v.createView(this);
    }

    public void showPlayableView() {
        if (this.f5901b == null || this.G) {
            return;
        }
        removeAllViews();
        setMatchParent();
        if (this.f5924m == null) {
            preLoadData(this.Q);
        }
        addView(this.f5924m);
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.setUnitId(this.f5933w);
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null && campaignEx.isMraid() && this.f5901b.getPlayable_ads_without_video() == 2) {
                this.f5924m.setCloseVisible(0);
            }
            this.f5924m.setNotchValue(this.P, this.K, this.L, this.M, this.N);
        }
        this.S = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoClickView(int i10) {
        CampaignEx campaignEx;
        if (this.f5901b != null) {
            if (i10 == -1) {
                if (isLast() || endCardShowing()) {
                    return;
                }
                h();
                return;
            }
            if (i10 == 1) {
                if (this.B) {
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
                if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getParent() != null) {
                    removeView(this.f5928q);
                }
                MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
                if (mBridgeClickMiniCardView != null && mBridgeClickMiniCardView.getParent() != null) {
                    removeView(this.f5926o);
                }
                MBridgeClickCTAView mBridgeClickCTAView = this.f5925n;
                if (mBridgeClickCTAView == null || mBridgeClickCTAView.getParent() == null) {
                    try {
                        CampaignEx campaignEx2 = this.f5901b;
                        if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 1) {
                            this.S = true;
                            if (this.f5925n == null) {
                                b(-1);
                            }
                            if (this.f5925n != null && ((campaignEx = this.f5901b) == null || !campaignEx.isDynamicView())) {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                                layoutParams.addRule(12, -1);
                                addView(this.f5925n, 0, layoutParams);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (isLast()) {
                    bringToFront();
                    return;
                }
                return;
            }
            if (i10 != 2) {
                return;
            }
            MBridgeClickCTAView mBridgeClickCTAView2 = this.f5925n;
            if (mBridgeClickCTAView2 != null && mBridgeClickCTAView2.getParent() != null) {
                removeView(this.f5925n);
            }
            MBridgeAlertWebview mBridgeAlertWebview = this.f5931u;
            if (mBridgeAlertWebview == null || mBridgeAlertWebview.getParent() == null) {
                MBridgeClickMiniCardView mBridgeClickMiniCardView2 = this.f5926o;
                if (mBridgeClickMiniCardView2 == null || mBridgeClickMiniCardView2.getParent() == null) {
                    try {
                        CampaignEx campaignEx3 = this.f5901b;
                        if (campaignEx3 != null && campaignEx3.getPlayable_ads_without_video() == 1) {
                            setMatchParent();
                            f();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (!miniCardLoaded()) {
                    h();
                    return;
                }
                MBridgeH5EndCardView mBridgeH5EndCardView2 = this.f5928q;
                if (mBridgeH5EndCardView2 != null && mBridgeH5EndCardView2.getParent() != null) {
                    removeView(this.f5928q);
                }
                this.notifyListener.a(112, "");
                CampaignEx campaignEx4 = this.f5901b;
                if (campaignEx4 != null && !campaignEx4.isHasReportAdTrackPause()) {
                    this.f5901b.setHasReportAdTrackPause(true);
                    com.mbridge.msdk.video.module.b.b.f(this.f5900a, this.f5901b);
                }
                if (this.D) {
                    this.notifyListener.a(115, "");
                } else {
                    this.S = true;
                    bringToFront();
                    webviewshow();
                    onConfigurationChanged(getResources().getConfiguration());
                }
                this.C = true;
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.f
    public void showVideoEndCover() {
        removeAllViews();
        setMatchParent();
        MBridgeVideoEndCoverView mBridgeVideoEndCoverView = this.t;
        if (mBridgeVideoEndCoverView == null) {
            b bVar = this.Q;
            this.Q = bVar;
            if (mBridgeVideoEndCoverView == null) {
                MBridgeVideoEndCoverView mBridgeVideoEndCoverView2 = new MBridgeVideoEndCoverView(this.f5900a);
                this.t = mBridgeVideoEndCoverView2;
                mBridgeVideoEndCoverView2.setCampaign(this.f5901b);
                this.t.setNotifyListener(new i(this.notifyListener));
                this.t.preLoadData(bVar);
            }
        }
        addView(this.t);
        onConfigurationChanged(getResources().getConfiguration());
        this.S = true;
        bringToFront();
    }

    @Override // com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i10) {
        MBridgePlayableView mBridgePlayableView = this.f5924m;
        if (mBridgePlayableView != null) {
            mBridgePlayableView.toggleCloseBtn(i10);
        }
        MBridgeH5EndCardView mBridgeH5EndCardView = this.f5928q;
        if (mBridgeH5EndCardView != null) {
            mBridgeH5EndCardView.toggleCloseBtn(i10);
        }
    }

    public void triggerCloseBtn(String str) {
        try {
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            d.a().a("2000152", eVar);
            d.a().a("2000134", this.f5901b);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        if (this.f5901b != null) {
            this.notifyListener.a(R.styleable.ConstraintSet_transitionPathRotate, "");
            this.notifyListener.a(104, "");
        }
    }

    public void webviewshow() {
        try {
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 3);
            d.a().a("2000133", this.f5901b, eVar);
        } catch (Exception unused) {
        }
        MBridgeH5EndCardView[] mBridgeH5EndCardViewArr = {this.f5924m, this.f5926o, this.f5928q, this.f5931u};
        for (int i10 = 0; i10 < 4; i10++) {
            MBridgeH5EndCardView mBridgeH5EndCardView = mBridgeH5EndCardViewArr[i10];
            if (mBridgeH5EndCardView != null && mBridgeH5EndCardView.getVisibility() == 0 && mBridgeH5EndCardView.getParent() != null && !isLast()) {
                mBridgeH5EndCardView.webviewshow();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            a(view);
            super.addView(view, layoutParams);
        } else {
            af.b(MBridgeBaseView.TAG, "view is null");
        }
    }

    public MBridgeContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.f5935z = 1;
        this.A = 1;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.I = false;
        this.J = false;
        this.R = false;
        this.S = false;
        this.T = new ArrayList();
    }

    private void b(int i10) {
        if (i10 != -3) {
            if (i10 != -2) {
                if (this.f5925n == null) {
                    this.f5925n = new MBridgeClickCTAView(this.f5900a);
                }
                this.f5925n.setCampaign(this.f5901b);
                this.f5925n.setUnitId(this.f5933w);
                this.f5925n.setNotifyListener(new i(this.notifyListener));
                this.f5925n.preLoadData(this.Q);
                return;
            }
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx == null || campaignEx.getVideo_end_type() != 2) {
                return;
            }
            if (this.f5926o == null) {
                this.f5926o = new MBridgeClickMiniCardView(this.f5900a);
            }
            this.f5926o.setCampaign(this.f5901b);
            MBridgeClickMiniCardView mBridgeClickMiniCardView = this.f5926o;
            mBridgeClickMiniCardView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.g(mBridgeClickMiniCardView, this.notifyListener));
            this.f5926o.preLoadData(this.Q);
            setMatchParent();
            f();
            h();
        }
    }

    private void a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            }
        }
    }

    private void a() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            boolean zIsDynamicView = campaignEx.isDynamicView();
            boolean zL = ak.l(this.f5901b.getendcard_url());
            if (zIsDynamicView && !zL && !this.f5901b.isMraid()) {
                e();
                return;
            }
        }
        if (this.y == 2 && !this.I) {
            b();
        } else {
            e();
        }
    }
}

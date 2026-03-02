package com.mbridge.msdk.video.bt.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.s;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import com.mbridge.msdk.video.bt.module.b.h;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.module.a.a.m;
import com.mbridge.msdk.video.signal.a.a;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.container.AbstractJSContainer;
import com.mbridge.msdk.videocommon.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBTempContainer extends MBTempContainerDiff {

    /* renamed from: x, reason: collision with root package name */
    private static final String f5576x = "MBTempContainer";
    private com.mbridge.msdk.videocommon.download.a A;
    private h B;
    private com.mbridge.msdk.video.bt.module.a.b C;
    private com.mbridge.msdk.video.dynview.e.a D;
    private int E;
    private String F;
    private com.mbridge.msdk.video.signal.factory.b G;
    private int H;
    private int I;
    private boolean J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private String P;
    private String Q;
    private List<CampaignEx> R;
    private int S;
    private com.mbridge.msdk.foundation.same.report.d.c T;
    private LayoutInflater U;
    private int V;
    private int W;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f5577a;
    private View aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private com.mbridge.msdk.mbsignalcommon.mraid.d al;
    private t3.b am;
    private u3.b an;
    private t3.a ao;
    private Runnable ap;
    private boolean aq;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f5578b;

    /* renamed from: c, reason: collision with root package name */
    protected a f5579c;

    /* renamed from: d, reason: collision with root package name */
    protected WindVaneWebView f5580d;
    protected MBridgeContainerView e;
    protected Handler f;
    protected Runnable g;
    protected Runnable h;
    private View y;

    /* renamed from: z, reason: collision with root package name */
    private CampaignEx f5581z;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class b extends AppletSchemeCallBack {

        /* renamed from: a, reason: collision with root package name */
        private CampaignEx f5593a;

        public b(CampaignEx campaignEx) {
            this.f5593a = campaignEx;
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestFailed(int i10, String str, String str2) {
            if (MBridgeConstans.DEBUG) {
                af.a(MBTempContainer.f5576x, "request wx scheme failed: errorCode: " + i10 + " errorMessage: " + str);
            }
            try {
                CampaignEx campaignEx = this.f5593a;
                if (campaignEx != null) {
                    campaignEx.setClickURL(str2);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b(MBTempContainer.f5576x, e.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestStart() {
            if (MBridgeConstans.DEBUG) {
                af.a(MBTempContainer.f5576x, "start request wx scheme");
            }
        }

        @Override // com.mbridge.msdk.scheme.applet.AppletSchemeCallBack
        public final void onRequestSuccess(String str) {
            if (MBridgeConstans.DEBUG) {
                af.a(MBTempContainer.f5576x, "request wx scheme success");
            }
            try {
                CampaignEx campaignEx = this.f5593a;
                if (campaignEx != null) {
                    campaignEx.setDeepLinkUrl(str);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b(MBTempContainer.f5576x, e.getMessage());
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class c extends com.mbridge.msdk.video.module.a.a.a {
        public c(Activity activity, CampaignEx campaignEx) {
            super(activity, campaignEx);
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00d9  */
        @Override // com.mbridge.msdk.video.module.a.a.a, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(int r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 312
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.c.a(int, java.lang.Object):void");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class d extends com.mbridge.msdk.video.module.a.a.f {
        private d() {
        }

        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        public final void a(int i10, Object obj) {
            super.a(i10, obj);
            try {
                String string = obj instanceof JSONObject ? obj.toString() : (String) obj;
                if (((AbstractJSContainer) MBTempContainer.this).f6457q && !TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject(string);
                    int iOptInt = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    int iOptInt2 = jSONObject.optInt(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
                    if (iOptInt != 2) {
                        MBTempContainer mBTempContainer = MBTempContainer.this;
                        if (iOptInt != 3) {
                            mBTempContainer.H = com.mbridge.msdk.foundation.same.a.F;
                        } else {
                            mBTempContainer.H = com.mbridge.msdk.foundation.same.a.E;
                        }
                    } else {
                        MBTempContainer.this.H = com.mbridge.msdk.foundation.same.a.D;
                    }
                    MBTempContainer.this.I = iOptInt2;
                }
            } catch (Exception unused) {
                af.b("NotifyListener", "PlayableResultListener ERROR");
            }
            if (i10 == 120) {
                MBTempContainer.this.B.b(((AbstractJSContainer) MBTempContainer.this).f6451k, ((AbstractJSContainer) MBTempContainer.this).f6450j);
            }
            if (i10 == 131) {
                MBTempContainer.this.getJSCommon().click(4, obj != null ? obj.toString() : "");
                return;
            }
            if (i10 == 126) {
                MBTempContainer.this.B.a(false, ((AbstractJSContainer) MBTempContainer.this).f6451k, ((AbstractJSContainer) MBTempContainer.this).f6450j);
                return;
            }
            if (i10 == 127) {
                MBTempContainer.this.ac = true;
                MBTempContainer.this.B.a(MBTempContainer.this.T);
                MBTempContainer.this.B.b(((AbstractJSContainer) MBTempContainer.this).f6451k, ((AbstractJSContainer) MBTempContainer.this).f6450j);
                MBTempContainer.this.getJSContainerModule().showEndcard(100);
                return;
            }
            switch (i10) {
                case 100:
                    MBTempContainer.this.aj = true;
                    MBTempContainer mBTempContainer2 = MBTempContainer.this;
                    mBTempContainer2.f.postDelayed(mBTempContainer2.ap, 250L);
                    MBTempContainer.this.B.a(MBTempContainer.this.T);
                    break;
                case 101:
                case 102:
                    MBTempContainer.this.getJSCommon().d();
                    break;
                case 103:
                    MBTempContainer.this.ac = true;
                    boolean zIsMraid = MBTempContainer.this.f5581z.isMraid();
                    MBTempContainer mBTempContainer3 = MBTempContainer.this;
                    if (!zIsMraid) {
                        mBTempContainer3.getJSCommon().d();
                        break;
                    } else {
                        MBTempContainer.r(mBTempContainer3);
                        break;
                    }
                case 104:
                    MBTempContainer.r(MBTempContainer.this);
                    break;
                case 105:
                    if (com.mbridge.msdk.e.b.a()) {
                        MBTempContainer.this.setChinaCTACallBack();
                    }
                    MBTempContainer.this.getJSCommon().click(1, obj != null ? obj.toString() : "");
                    break;
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public final class f extends com.mbridge.msdk.video.module.a.a.f {
        private f() {
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01b0  */
        @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(int r7, java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.f.a(int, java.lang.Object):void");
        }
    }

    public MBTempContainer(Context context) {
        super(context);
        this.E = 1;
        this.F = "";
        this.H = com.mbridge.msdk.foundation.same.a.F;
        this.J = false;
        this.P = "";
        this.R = new ArrayList();
        this.S = 0;
        this.f5577a = false;
        this.f5578b = false;
        this.f5579c = new a.C0062a();
        this.f = new Handler();
        this.V = 0;
        this.W = 0;
        this.g = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                int iH = MBTempContainer.this.getActivityProxy().h();
                MBTempContainer mBTempContainer = MBTempContainer.this;
                if (iH == 0) {
                    mBTempContainer.defaultLoad(-1, "WebView load timeout");
                } else {
                    mBTempContainer.V = -3;
                }
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                int iH = MBTempContainer.this.getActivityProxy().h();
                MBTempContainer mBTempContainer = MBTempContainer.this;
                if (iH == 0) {
                    mBTempContainer.defaultLoad(-3, "Signal Communication connect timeout");
                } else {
                    mBTempContainer.V = -4;
                }
            }
        };
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = null;
        this.an = null;
        this.ao = null;
        this.ap = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.6
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.aa != null) {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            }
        };
        this.aq = false;
        init(context);
    }

    public static /* synthetic */ void P(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f6449i.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.10
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.aa.setBackgroundColor(0);
                    MBTempContainer.this.aa.setVisibility(0);
                    MBTempContainer.this.aa.bringToFront();
                }
            });
        }
    }

    public static /* synthetic */ void R(MBTempContainer mBTempContainer) {
        if (mBTempContainer.isLoadSuccess()) {
            mBTempContainer.f6449i.runOnUiThread(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            });
        }
    }

    private void a(int i10, String str) {
        try {
            n nVar = new n();
            nVar.a("2000037");
            nVar.r("code=" + i10 + ",desc=" + str);
            CampaignEx campaignEx = this.f5581z;
            nVar.q((campaignEx == null || campaignEx.getRewardTemplateMode() == null) ? "" : this.f5581z.getRewardTemplateMode().e());
            nVar.c(this.f6450j);
            CampaignEx campaignEx2 = this.f5581z;
            nVar.e(campaignEx2 != null ? campaignEx2.getId() : "");
            CampaignEx campaignEx3 = this.f5581z;
            if (campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getRequestId())) {
                nVar.f(this.f5581z.getRequestId());
            }
            CampaignEx campaignEx4 = this.f5581z;
            if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getRequestIdNotice())) {
                nVar.g(this.f5581z.getRequestIdNotice());
            }
            int iM = ab.m(getContext());
            nVar.a(iM);
            nVar.k(ab.a(getContext(), iM));
            com.mbridge.msdk.foundation.same.report.n.b(nVar);
        } catch (Throwable th) {
            af.b(f5576x, th.getMessage(), th);
        }
    }

    public static /* synthetic */ void b(MBTempContainer mBTempContainer) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            MBridgeVideoView mBridgeVideoView = mBTempContainer.mbridgeVideoView;
            if (mBridgeVideoView == null || mBridgeVideoView.notifyListener == null) {
                eVar.a("notify_listener", 0);
            } else {
                eVar.a("notify_listener", 1);
                com.mbridge.msdk.video.module.a.a aVar = mBTempContainer.mbridgeVideoView.notifyListener;
                if (aVar instanceof com.mbridge.msdk.video.module.a.a.n) {
                    eVar.a("listener_type", 1);
                } else if (aVar instanceof m) {
                    eVar.a("listener_type", 2);
                } else {
                    eVar.a("listener_type", 3);
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar = mBTempContainer.T;
            if (cVar != null) {
                cVar.a("2000130", eVar);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    private int c() {
        k kVarB = b(this.f5581z);
        if (kVarB != null) {
            return kVarB.m();
        }
        return 0;
    }

    private boolean d() {
        k kVarB = b(this.f5581z);
        if (kVarB != null) {
            return kVarB.p();
        }
        return false;
    }

    private boolean e() {
        if (this.mbridgeVideoView == null) {
            return false;
        }
        boolean zA = com.mbridge.msdk.e.b.a();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        return zA ? mBridgeVideoView.isShowingAlertView() || checkChinaShowingAlertViewState() || this.mbridgeVideoView.isRewardPopViewShowing() : mBridgeVideoView.isShowingAlertView() || this.mbridgeVideoView.isRewardPopViewShowing();
    }

    private void f() throws JSONException {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getContext());
        CampaignEx campaignEx = this.f5581z;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.f5581z.getRequestIdNotice(), this.f5581z.getId(), this.f6450j, com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f5581z.getId()), this.f5581z.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.f5581z.getId());
            this.ae = true;
        }
    }

    private void g() {
        t3.b bVar = this.am;
        if (bVar != null) {
            try {
                MBridgeContainerView mBridgeContainerView = this.e;
                t3.e eVar = t3.e.f12778d;
                bVar.a(mBridgeContainerView, eVar);
                View view = this.aa;
                if (view != null) {
                    this.am.a(view, eVar);
                }
                WindVaneWebView windVaneWebView = this.f5580d;
                if (windVaneWebView != null) {
                    this.am.a(windVaneWebView, eVar);
                }
                this.mbridgeVideoView.setVideoEvents(this.an);
                this.am.f();
                if (this.ao != null) {
                    t3.h hVar = new t3.h(4);
                    af.a("omsdk", "bt:   adEvents.loaded");
                    this.ao.c(hVar);
                    this.ao.b();
                }
            } catch (Exception e3) {
                af.a("omsdk", e3.getMessage());
            }
        }
    }

    public static /* synthetic */ void h(MBTempContainer mBTempContainer) {
        try {
            com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
            eVar.a("temp_container", mBTempContainer.getWidth() + "x" + mBTempContainer.getHeight());
            if (mBTempContainer.f5580d != null) {
                eVar.a("web_view", mBTempContainer.f5580d.getWidth() + "x" + mBTempContainer.f5580d.getHeight());
            }
            if (mBTempContainer.mbridgeVideoView != null) {
                eVar.a("mbridge_video_view", mBTempContainer.mbridgeVideoView.getWidth() + "x" + mBTempContainer.mbridgeVideoView.getHeight());
                if (mBTempContainer.mbridgeVideoView.mPlayerView != null) {
                    eVar.a("player_view", mBTempContainer.mbridgeVideoView.mPlayerView.getWidth() + "x" + mBTempContainer.mbridgeVideoView.mPlayerView.getHeight());
                }
            }
            com.mbridge.msdk.foundation.same.report.d.c cVar = mBTempContainer.T;
            if (cVar != null) {
                cVar.a("2000136", eVar);
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
        }
    }

    private int i() {
        CampaignEx campaignEx = this.f5581z;
        if (campaignEx == null) {
            return 1;
        }
        boolean zA = ak.a(MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE, campaignEx.getendcard_url());
        int iC = ak.c(this.f5581z.getendcard_url(), MBridgeConstans.DYNAMIC_VIEW_KEY_CLOSE_BTN_DELATE);
        return (!zA || iC < 0) ? this.f5581z.getCbd() > -2 ? this.f5581z.getCbd() : this.f6452l.p() : iC;
    }

    public static /* synthetic */ void r(MBTempContainer mBTempContainer) {
        int i10;
        try {
            com.mbridge.msdk.video.bt.module.a.b bVar = mBTempContainer.C;
            if (bVar == null) {
                Activity activity = mBTempContainer.f6449i;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            if (mBTempContainer.f6457q && ((i10 = mBTempContainer.f6459s) == com.mbridge.msdk.foundation.same.a.H || i10 == com.mbridge.msdk.foundation.same.a.I)) {
                boolean z9 = true;
                if (mBTempContainer.I != 1) {
                    z9 = false;
                }
                bVar.a(z9, mBTempContainer.H);
            }
            mBTempContainer.C.a(mBTempContainer.F, mBTempContainer.ac, mBTempContainer.f6454n);
        } catch (Exception unused) {
            Activity activity2 = mBTempContainer.f6449i;
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    public boolean canBackPress() {
        MBridgeContainerView mBridgeContainerView = this.e;
        return mBridgeContainerView == null || mBridgeContainerView.canBackPress();
    }

    public void defaultLoad(int i10, String str) {
        int i11;
        superDefaultLoad(i10, str);
        CampaignEx campaignEx = this.f5581z;
        if (campaignEx != null && !campaignEx.isDynamicView()) {
            this.f5581z.setTemplateRenderSucc(false);
        }
        if (!isLoadSuccess()) {
            a(i10, str);
            Activity activity = this.f6449i;
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (this.f5581z.getPlayable_ads_without_video() == 2) {
            this.e.setCampaign(this.f5581z);
            this.e.addOrderViewData(this.R);
            this.e.setUnitID(this.f6450j);
            this.e.setCloseDelayTime(i());
            this.e.setPlayCloseBtnTm(this.f6452l.h());
            this.e.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f5581z, this.A, this.f6454n, b(), this.f6450j, new d(), this.f6452l.y(), this.f6461v));
            this.e.preLoadData(this.G);
            this.e.showPlayableView();
        } else {
            a(i10, str);
            this.aa.setVisibility(8);
            loadModuleDatas();
            int iF = this.f6452l.f();
            int iC = c();
            int i12 = iC != 0 ? iC : iF;
            CampaignEx campaignEx2 = this.f5581z;
            if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                this.mbridgeVideoView.setContainerViewOnNotifyListener(new c(this.f6449i, this.f5581z));
            }
            CampaignEx campaignEx3 = this.f5581z;
            int iE = (campaignEx3 == null || campaignEx3.getVst() <= -2) ? this.f6452l.e() : this.f5581z.getVst();
            CampaignEx campaignEx4 = this.f5581z;
            if (campaignEx4 != null && campaignEx4.getDynamicTempCode() == 5 && (i11 = this.E) > 1) {
                iE = a(iE, i11);
                this.f5581z.setVst(iE);
            }
            int i13 = iE;
            this.mbridgeVideoView.setVideoSkipTime(i13);
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            mBridgeVideoView.setNotifyListener(new m(mBridgeVideoView, this.e, this.f5581z, this.f6454n, this.A, b(), this.f6450j, i12, i13, new f(), this.f6452l.y(), this.f6461v, this.f6452l.C()));
            this.mbridgeVideoView.setAdSession(this.am);
            this.mbridgeVideoView.setVideoEvents(this.an);
            this.mbridgeVideoView.defaultShow();
            MBridgeContainerView mBridgeContainerView = this.e;
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.b(this.mbridgeVideoView, mBridgeContainerView, this.f5581z, this.f6454n, this.A, b(), this.f6450j, new c(this.f6449i, this.f5581z), this.f6452l.y(), this.f6461v));
            this.e.defaultShow();
        }
        g();
    }

    public int findID(String str) {
        return x.a(getContext(), str, "id");
    }

    public int findLayout(String str) {
        return x.a(getContext(), str, TtmlNode.TAG_LAYOUT);
    }

    public MBridgeContainerView findMBridgeContainerView() {
        return (MBridgeContainerView) findViewById(findID("mbridge_video_templete_container"));
    }

    public MBridgeVideoView findMBridgeVideoView() {
        return (MBridgeVideoView) findViewById(findID("mbridge_video_templete_videoview"));
    }

    public WindVaneWebView findWindVaneWebView() {
        try {
            if (!this.f6461v) {
                boolean z9 = this.f6457q;
                CampaignEx campaignEx = this.f5581z;
                a.C0071a c0071aA = z9 ? com.mbridge.msdk.videocommon.a.a(287, campaignEx) : com.mbridge.msdk.videocommon.a.a(94, campaignEx);
                if (c0071aA == null || !c0071aA.c()) {
                    return null;
                }
                boolean z10 = this.f6457q;
                CampaignEx campaignEx2 = this.f5581z;
                if (z10) {
                    com.mbridge.msdk.videocommon.a.b(287, campaignEx2);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, campaignEx2);
                }
                WindVaneWebView windVaneWebViewA = c0071aA.a();
                if (this.af) {
                    windVaneWebViewA.setWebViewTransparent();
                }
                return windVaneWebViewA;
            }
            CampaignEx campaignEx3 = this.f5581z;
            if (campaignEx3 == null || campaignEx3.getRewardTemplateMode() == null) {
                return null;
            }
            a.C0071a c0071aA2 = com.mbridge.msdk.videocommon.a.a(this.f6450j + "_" + this.f5581z.getId() + "_" + this.f5581z.getRequestId() + "_" + this.f5581z.getRewardTemplateMode().e());
            if (c0071aA2 != null) {
                return c0071aA2.a();
            }
            return null;
        } catch (Exception e3) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e3.printStackTrace();
            return null;
        }
    }

    public t3.a getAdEvents() {
        return this.ao;
    }

    public t3.b getAdSession() {
        return this.am;
    }

    public CampaignEx getCampaign() {
        return this.f5581z;
    }

    public String getInstanceId() {
        return this.F;
    }

    public int getLayoutID() {
        return findLayout(this.af ? "mbridge_reward_activity_video_templete_transparent" : "mbridge_reward_activity_video_templete");
    }

    public u3.b getVideoEvents() {
        return this.an;
    }

    public void init(Context context) {
        this.U = LayoutInflater.from(context);
    }

    public boolean initViews() {
        View viewFindViewById = findViewById(findID("mbridge_video_templete_progressbar"));
        this.aa = viewFindViewById;
        return viewFindViewById != null;
    }

    public boolean isLoadSuccess() {
        return this.f5578b;
    }

    public void loadModuleDatas() {
        int i10;
        int i11;
        k kVarB = b(this.f5581z);
        int iN = kVarB != null ? kVarB.n() : 0;
        if (iN != 0) {
            this.f6456p = iN;
        }
        int iF = this.f6452l.f();
        int iC = c();
        int i12 = iC != 0 ? iC : iF;
        this.mbridgeVideoView.setSoundState(this.f6456p);
        this.mbridgeVideoView.setCampaign(this.f5581z);
        this.mbridgeVideoView.setPlayURL(this.A.t());
        CampaignEx campaignEx = this.f5581z;
        int iE = (campaignEx == null || campaignEx.getVst() <= -2) ? this.f6452l.e() : this.f5581z.getVst();
        CampaignEx campaignEx2 = this.f5581z;
        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (i11 = this.E) > 1) {
            iE = a(iE, i11);
            this.f5581z.setVst(iE);
        }
        int i13 = iE;
        this.mbridgeVideoView.setVideoSkipTime(i13);
        this.mbridgeVideoView.setCloseAlert(this.f6452l.i());
        this.mbridgeVideoView.setBufferTimeout(h());
        this.mbridgeVideoView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.n(this.G, this.f5581z, this.f6454n, this.A, b(), this.f6450j, i12, i13, new f(), this.f6452l.y(), this.f6461v, this.f6452l.C()));
        this.mbridgeVideoView.setShowingTransparent(this.af);
        this.mbridgeVideoView.setAdSession(this.am);
        if (this.f6457q && ((i10 = this.f6459s) == com.mbridge.msdk.foundation.same.a.H || i10 == com.mbridge.msdk.foundation.same.a.I)) {
            this.mbridgeVideoView.setIVRewardEnable(i10, this.t, this.f6460u);
            this.mbridgeVideoView.setDialogRole(getJSCommon() != null ? getJSCommon().h() : 1);
        }
        this.e.setCampaign(this.f5581z);
        this.e.addOrderViewData(this.R);
        this.e.setUnitID(this.f6450j);
        this.e.setCloseDelayTime(i());
        this.e.setPlayCloseBtnTm(this.f6452l.h());
        this.e.setVideoInteractiveType(this.f6452l.g());
        this.e.setEndscreenType(this.f6452l.q());
        this.e.setVideoSkipTime(i13);
        this.e.setShowingTransparent(this.af);
        this.e.setJSFactory(this.G);
        int playable_ads_without_video = this.f5581z.getPlayable_ads_without_video();
        MBridgeContainerView mBridgeContainerView = this.e;
        if (playable_ads_without_video == 2) {
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.h(this.f5581z, this.A, this.f6454n, b(), this.f6450j, new d(), this.f6452l.y(), this.f6461v));
            this.e.preLoadData(this.G);
            this.e.showPlayableView();
        } else {
            mBridgeContainerView.setNotifyListener(new com.mbridge.msdk.video.module.a.a.c(this.G, this.f5581z, this.f6454n, this.A, b(), this.f6450j, new c(this.f6449i, this.f5581z), this.f6452l.y(), this.f6461v));
            this.e.preLoadData(this.G);
            this.mbridgeVideoView.preLoadData(this.G);
        }
        if (this.af) {
            this.e.setMBridgeClickMiniCardViewTransparent();
        }
    }

    public void onBackPressed() {
        MBridgeContainerView mBridgeContainerView;
        MBridgeContainerView mBridgeContainerView2;
        MBridgeVideoView mBridgeVideoView;
        MBridgeVideoView mBridgeVideoView2;
        if (this.af && (mBridgeVideoView2 = this.mbridgeVideoView) != null) {
            mBridgeVideoView2.notifyVideoClose();
            return;
        }
        CampaignEx campaignEx = this.f5581z;
        if (((campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f5581z.getRewardTemplateMode().f() == 5002010) || this.ah) && (mBridgeVideoView = this.mbridgeVideoView) != null) {
            if (!mBridgeVideoView.isMiniCardShowing()) {
                this.mbridgeVideoView.onBackPress();
                return;
            }
            MBridgeContainerView mBridgeContainerView3 = this.e;
            if (mBridgeContainerView3 != null) {
                mBridgeContainerView3.onMiniEndcardBackPress();
                return;
            }
            return;
        }
        if (this.aj && (mBridgeContainerView2 = this.e) != null) {
            mBridgeContainerView2.onPlayableBackPress();
            return;
        }
        if (this.ai && (mBridgeContainerView = this.e) != null) {
            mBridgeContainerView.onEndcardBackPress();
        }
        if (getJSCommon().b()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
                return;
            }
            return;
        }
        if (!canBackPress()) {
            af.a(f5576x, "onBackPressed can't excute");
            return;
        }
        Activity activity = this.f6449i;
        if (activity == null || this.f6461v || this.ak) {
            return;
        }
        this.ak = true;
        activity.onBackPressed();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onCreate() {
        ViewGroup viewGroup;
        int iF;
        int iE;
        List<CampaignEx> list;
        AppletsModel appletsModel;
        if (this.f6452l == null) {
            this.f6452l = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f6450j, this.f6457q);
        }
        try {
            if (this.f5581z != null) {
                try {
                    appletsModel = AppletModelManager.getInstance().get(this.f5581z);
                } catch (Exception e3) {
                    if (MBridgeConstans.DEBUG) {
                        e3.printStackTrace();
                    }
                    appletsModel = null;
                }
                if (appletsModel != null) {
                    try {
                        if (appletsModel.can(0)) {
                            appletsModel.setUserClick(false);
                            appletsModel.requestWxAppletsScheme(0, new b(this.f5581z));
                        }
                    } catch (Exception e7) {
                        appletsModel.clearRequestState();
                        if (MBridgeConstans.DEBUG) {
                            e7.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e10) {
            if (MBridgeConstans.DEBUG) {
                e10.printStackTrace();
            }
        }
        this.ak = false;
        try {
            if (this.f6461v) {
                CampaignEx campaignEx = this.f5581z;
                if (campaignEx == null || !campaignEx.isDynamicView()) {
                    this.B = new com.mbridge.msdk.video.bt.module.b.c(this.C, this.F);
                } else {
                    this.B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f6457q, this.f6452l, this.f5581z, this.B, b(), this.f6450j);
                }
            } else {
                this.B = new com.mbridge.msdk.video.bt.module.b.d(getContext(), this.f6457q, this.f6452l, this.f5581z, this.B, b(), this.f6450j);
            }
            registerErrorListener(new com.mbridge.msdk.video.bt.module.b.e(this.T, this.B));
            a(this.f6452l, this.f5581z);
            setShowingTransparent();
            int layoutID = getLayoutID();
            if (layoutID <= 0) {
                a("layoutID not found");
                return;
            }
            View viewInflate = this.U.inflate(layoutID, (ViewGroup) null);
            this.y = viewInflate;
            addView(viewInflate, new RelativeLayout.LayoutParams(-1, -1));
            if (this.f5577a) {
                setMatchParent();
            }
            this.f5580d = findWindVaneWebView();
            MBridgeVideoView mBridgeVideoViewFindMBridgeVideoView = findMBridgeVideoView();
            this.mbridgeVideoView = mBridgeVideoViewFindMBridgeVideoView;
            mBridgeVideoViewFindMBridgeVideoView.setVideoLayout(this.f5581z);
            this.mbridgeVideoView.setIsIV(this.f6457q);
            this.mbridgeVideoView.setUnitId(this.f6450j);
            this.mbridgeVideoView.setCamPlayOrderCallback(this.D, this.R, this.E, this.S);
            if (this.f6461v) {
                this.mbridgeVideoView.setNotchPadding(this.L, this.M, this.N, this.O);
            }
            MBridgeContainerView mBridgeContainerViewFindMBridgeContainerView = findMBridgeContainerView();
            this.e = mBridgeContainerViewFindMBridgeContainerView;
            if (this.f6461v) {
                mBridgeContainerViewFindMBridgeContainerView.setNotchPadding(this.K, this.L, this.M, this.N, this.O);
            }
            if (ah.a().a("i_l_s_t_r_i", false)) {
                this.mbridgeVideoView.setPlayerViewAttachListener(new MBridgeVideoView.a() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.4
                    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
                    @Override // com.mbridge.msdk.video.module.MBridgeVideoView.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void a() {
                        /*
                            r4 = this;
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.a(r0)
                            if (r0 == 0) goto L66
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.video.bt.module.MBTempContainer.b(r0)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.a(r0)
                            boolean r0 = r0.isDynamicView()
                            if (r0 == 0) goto L3c
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            boolean r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.c(r0)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            if (r0 == 0) goto L2e
                            com.mbridge.msdk.foundation.entity.CampaignEx r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.a(r1)
                            boolean r0 = r0.isCampaignIsFiltered()
                            if (r0 == 0) goto L4b
                            goto L3c
                        L2e:
                            com.mbridge.msdk.video.bt.module.b.h r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.e(r1)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.same.report.d.c r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.d(r1)
                            r0.a(r1)
                            goto L4b
                        L3c:
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.video.bt.module.b.h r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.e(r0)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.same.report.d.c r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.d(r1)
                            r0.a(r1)
                        L4b:
                            com.mbridge.msdk.video.bt.module.MBTempContainer r0 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            android.content.Context r0 = r0.getContext()
                            com.mbridge.msdk.video.bt.module.MBTempContainer r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            com.mbridge.msdk.foundation.entity.CampaignEx r1 = com.mbridge.msdk.video.bt.module.MBTempContainer.a(r1)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            java.lang.String r2 = com.mbridge.msdk.video.bt.module.MBTempContainer.f(r2)
                            com.mbridge.msdk.video.bt.module.MBTempContainer r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.this
                            int r3 = com.mbridge.msdk.video.bt.module.MBTempContainer.g(r3)
                            com.mbridge.msdk.video.bt.module.b.f.a(r0, r1, r2, r3)
                        L66:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBTempContainer.AnonymousClass4.a():void");
                    }
                });
            }
            this.mbridgeVideoView.setIPlayVideoViewLayoutCallBack(new com.mbridge.msdk.video.dynview.e.f() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.5
                @Override // com.mbridge.msdk.video.dynview.e.f
                public final void a() {
                    MBTempContainer.h(MBTempContainer.this);
                }
            });
            if (this.mbridgeVideoView == null || this.e == null || !initViews()) {
                this.f5579c.a("not found View IDS");
                Activity activity = this.f6449i;
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            this.f5578b = true;
            WindVaneWebView windVaneWebView = this.f5580d;
            this.G = new com.mbridge.msdk.video.signal.factory.b(this.f6449i, windVaneWebView, this.mbridgeVideoView, this.e, this.f5581z, new e());
            CampaignEx campaignEx2 = this.f5581z;
            if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5 && (list = this.R) != null) {
                this.G.a(list);
            }
            registerJsFactory(this.G);
            com.mbridge.msdk.foundation.d.b.a().a(this.f6450j + "_1", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.8
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f5576x, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f5580d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    String string;
                    MBTempContainer.this.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f5576x, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f5580d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    String string;
                    MBTempContainer.this.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b(MBTempContainer.f5576x, th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) MBTempContainer.this.f5580d, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            g();
            if (windVaneWebView == null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            ViewGroup viewGroup2 = (ViewGroup) this.y.findViewById(x.a(getContext(), "mbridge_video_templete_webview_parent", "id"));
            windVaneWebView.setApiManagerJSFactory(this.G);
            if (windVaneWebView.getParent() != null) {
                defaultLoad(0, "preload template webview is null or load error");
                return;
            }
            if (windVaneWebView.getObject() instanceof k) {
                getJSCommon().a(this.ao);
                getJSCommon().a(this.am);
                getJSCommon().a(this.an);
                getJSCommon().a(this.f6456p);
                getJSCommon().a(this.f6450j);
                getJSCommon().a(this.f6452l);
                getJSCommon().a(new e());
                CampaignEx campaignEx3 = this.f5581z;
                if (campaignEx3 != null && (campaignEx3.isMraid() || this.f5581z.isActiveOm())) {
                    com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(getContext());
                    this.al = dVar;
                    dVar.c();
                    this.al.a();
                    this.al.a(new d.b() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.9
                        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
                        public final void a(double d8) {
                            MBridgeContainerView mBridgeContainerView;
                            af.b(MBTempContainer.f5576x, "volume is : " + d8);
                            try {
                                if (!MBTempContainer.this.f5581z.isMraid() || (mBridgeContainerView = MBTempContainer.this.e) == null || mBridgeContainerView.getH5EndCardView() == null) {
                                    return;
                                }
                                MBTempContainer.this.e.getH5EndCardView().volumeChange(d8);
                            } catch (Exception e11) {
                                af.b(MBTempContainer.f5576x, e11.getMessage());
                            }
                        }
                    });
                }
                getJSContainerModule().readyStatus(((k) windVaneWebView.getObject()).r());
                try {
                    if (this.f5580d != null) {
                        int i10 = getResources().getConfiguration().orientation;
                        if (d()) {
                            iF = ak.h(getContext());
                            iE = ak.g(getContext());
                            if (com.mbridge.msdk.foundation.tools.e.a(getContext())) {
                                int iC = ak.c(getContext());
                                if (i10 == 2) {
                                    iF += iC;
                                } else {
                                    iE += iC;
                                }
                            }
                        } else {
                            iF = ak.f(getContext());
                            iE = ak.e(getContext());
                        }
                        int iB = this.f5581z.getRewardTemplateMode().b();
                        if (c(this.f5581z) == 1) {
                            iB = i10;
                        }
                        getJSNotifyProxy().a(i10, iB, iF, iE);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.f3608l, ak.d(getContext()));
                        try {
                            if (this.f6454n != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(RewardPlus.NAME, this.f6454n.a());
                                jSONObject2.put(RewardPlus.AMOUNT, this.f6454n.b());
                                jSONObject2.put("id", this.f6455o);
                                jSONObject.put("userId", this.f6453m);
                                jSONObject.put("reward", jSONObject2);
                                jSONObject.put("playVideoMute", this.f6456p);
                                jSONObject.put("extra", this.Q);
                            }
                        } catch (JSONException e11) {
                            af.a(f5576x, e11.getMessage());
                        } catch (Exception e12) {
                            af.a(f5576x, e12.getMessage());
                        }
                        String string = jSONObject.toString();
                        com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        com.mbridge.msdk.foundation.same.report.d.d.a().a("2000133", this.f5581z, eVar);
                        getJSNotifyProxy().a(string);
                        g.a().a((WebView) this.f5580d, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
                        getJSCommon().b(true);
                        if (com.mbridge.msdk.e.b.a()) {
                            setChinaCallBackStatus(this.f5580d);
                        }
                        loadModuleDatas();
                        this.f.postDelayed(this.g, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } catch (Exception e13) {
                    if (MBridgeConstans.DEBUG) {
                        e13.printStackTrace();
                    }
                }
                ((k) windVaneWebView.getObject()).f6140m.a();
                if (this.f6461v) {
                    getJSCommon().e(this.W);
                }
            }
            if (getJSCommon().a() == 1 && (viewGroup = (ViewGroup) this.y.findViewById(x.a(getContext(), "mbridge_video_templete_webview_parent", "id"))) != null) {
                ((ViewGroup) this.y).removeView(viewGroup);
                ((ViewGroup) this.y).addView(viewGroup, 1);
            }
            viewGroup2.addView(windVaneWebView, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th) {
            th.printStackTrace();
            a("onCreate error" + th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onDestroy() {
        CampaignEx campaignEx;
        int i10;
        if (this.J) {
            return;
        }
        boolean z9 = true;
        this.J = true;
        super.onDestroy();
        try {
            if (com.mbridge.msdk.e.b.a()) {
                setChinaDestroy();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.releasePlayer();
            }
            WindVaneWebView windVaneWebView = this.f5580d;
            if (windVaneWebView != null) {
                ViewGroup viewGroup = (ViewGroup) windVaneWebView.getParent();
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                }
                this.f5580d.clearWebView();
                this.f5580d.release();
            }
            if (this.C != null) {
                this.C = null;
            }
            this.f.removeCallbacks(this.g);
            this.f.removeCallbacks(this.h);
            getJSCommon().e();
            if (this.f6457q) {
                com.mbridge.msdk.c.h.a().e(this.f6450j);
            }
            if (!this.ab) {
                try {
                    this.ab = true;
                    CampaignEx campaignEx2 = this.f5581z;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() == 2) {
                        this.ac = true;
                    }
                    u3.b bVar = this.an;
                    if (bVar != null && !this.ac) {
                        try {
                            bVar.d();
                        } catch (Exception e3) {
                            af.a("omsdk", e3.getMessage());
                        }
                    }
                    h hVar = this.B;
                    if (hVar != null) {
                        if (this.f6457q && ((i10 = this.f6459s) == com.mbridge.msdk.foundation.same.a.H || i10 == com.mbridge.msdk.foundation.same.a.I)) {
                            if (this.I != 1) {
                                z9 = false;
                            }
                            hVar.a(z9, this.H);
                        }
                        if (!this.ac) {
                            this.f6454n.a(0);
                        }
                        this.T.a(this.f5581z);
                        this.B.a(this.T, this.ac, this.f6454n);
                    }
                    this.f.removeCallbacks(this.ap);
                    if (((!this.f6457q && !this.f6461v) || ((campaignEx = this.f5581z) != null && campaignEx.isDynamicView())) && this.ac && (!com.mbridge.msdk.e.b.a() || !checkChinaSendToServerDiff(this.B))) {
                        af.a(f5576x, "sendToServerRewardInfo");
                        com.mbridge.msdk.video.module.b.b.a(this.f5581z, this.f6454n, this.f6450j, this.f6453m, this.Q);
                    }
                    if (!this.f6461v) {
                        boolean z10 = this.f6457q;
                        CampaignEx campaignEx3 = this.f5581z;
                        if (z10) {
                            com.mbridge.msdk.videocommon.a.b(287, campaignEx3);
                        } else {
                            com.mbridge.msdk.videocommon.a.b(94, campaignEx3);
                        }
                    }
                    MBridgeContainerView mBridgeContainerView = this.e;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.release();
                    }
                } catch (Throwable th) {
                    af.b(f5576x, th.getMessage(), th);
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = this.al;
            if (dVar != null) {
                dVar.d();
            }
            if (this.am != null) {
                af.b("omsdk", "tc onDestroy");
                this.am.e();
                this.am.c();
                this.am = null;
            }
            if (!this.f6461v) {
                if (isLoadSuccess()) {
                    this.f.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (((AbstractJSContainer) MBTempContainer.this).f6449i != null) {
                                ((AbstractJSContainer) MBTempContainer.this).f6449i.finish();
                            }
                        }
                    }, 100L);
                } else {
                    Activity activity = this.f6449i;
                    if (activity != null) {
                        activity.finish();
                    }
                }
            }
            if (!this.ae) {
                f();
            }
            com.mbridge.msdk.video.bt.a.d.c().f(this.F);
        } catch (Throwable th2) {
            af.a(f5576x, th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onPause() {
        super.onPause();
        this.ad = true;
        try {
            getJSVideoModule().videoOperate(2);
            MBridgeContainerView mBridgeContainerView = this.e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnPause();
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityPause();
            }
        } catch (Throwable th) {
            af.b(f5576x, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onResume() {
        Activity activity;
        super.onResume();
        int i10 = this.V;
        Runnable runnable = i10 == -3 ? this.g : i10 == -4 ? this.h : null;
        if (runnable != null) {
            runnable.run();
            this.V = 0;
        }
        try {
            if (this.mbridgeVideoView != null && !e() && !this.mbridgeVideoView.isMiniCardShowing() && !com.mbridge.msdk.foundation.d.b.f3437c) {
                this.mbridgeVideoView.setCover(false);
            }
            MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.onActivityResume();
            }
            MBridgeContainerView mBridgeContainerView = this.e;
            if (mBridgeContainerView != null) {
                mBridgeContainerView.setOnResume();
            }
            if (this.ad && !e() && !com.mbridge.msdk.foundation.d.b.f3437c) {
                getJSVideoModule().videoOperate(1);
            }
            Activity activity2 = this.f6449i;
            if (activity2 != null) {
                ak.a(activity2.getWindow().getDecorView());
            }
            if (this.af && this.ag && (activity = this.f6449i) != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            af.b(f5576x, th.getMessage(), th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public void onStop() {
        super.onStop();
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setCover(true);
            this.mbridgeVideoView.onActivityStop();
        }
    }

    public void receiveSuccess() {
        af.a(f5576x, "receiveSuccess ,start hybrid");
        this.f.removeCallbacks(this.h);
        this.f.postDelayed(this.ap, 250L);
    }

    public void registerErrorListener(a aVar) {
        this.f5579c = aVar;
    }

    public void setAdEvents(t3.a aVar) {
        this.ao = aVar;
        com.mbridge.msdk.video.signal.factory.b bVar = this.G;
        if (bVar == null || bVar.getJSCommon() == null) {
            return;
        }
        this.G.getJSCommon().a(aVar);
    }

    public void setAdSession(t3.b bVar) {
        this.am = bVar;
        com.mbridge.msdk.video.signal.factory.b bVar2 = this.G;
        if (bVar2 != null && bVar2.getJSCommon() != null) {
            this.G.getJSCommon().a(bVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setAdSession(bVar);
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, int i10) {
        this.D = aVar;
        this.E = i10;
    }

    public void setCampOrderViewData(List<CampaignEx> list, int i10) {
        if (list != null) {
            this.R = list;
        }
        this.S = i10;
    }

    public void setCampaign(CampaignEx campaignEx) {
        this.f5581z = campaignEx;
        if (campaignEx != null) {
            com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.foundation.same.report.d.d.a().a(campaignEx.getCurrentLocalRid(), "");
            this.T = cVarA;
            if (cVarA == null) {
                this.T = new com.mbridge.msdk.foundation.same.report.d.c();
            }
            this.T.c(campaignEx.getCurrentLocalRid());
            this.T.a(campaignEx);
            if (TextUtils.isEmpty(campaignEx.getCampaignUnitId()) && !TextUtils.isEmpty(this.f6450j)) {
                campaignEx.setCampaignUnitId(this.f6450j);
            }
            AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
            if (appletsModel != null) {
                this.aq = appletsModel.isSupportWxScheme();
            }
            com.mbridge.msdk.foundation.d.b.a().a(campaignEx.getCampaignUnitId() + "_1", campaignEx);
        }
    }

    public void setCampaignDownLoadTask(com.mbridge.msdk.videocommon.download.a aVar) {
        this.A = aVar;
    }

    public void setCampaignExpired(boolean z9) {
        try {
            CampaignEx campaignEx = this.f5581z;
            if (campaignEx != null) {
                if (!z9) {
                    campaignEx.setSpareOfferFlag(0);
                    this.f5581z.setCbt(0);
                    return;
                }
                campaignEx.setSpareOfferFlag(1);
                if (!com.mbridge.msdk.e.b.a()) {
                    com.mbridge.msdk.videocommon.d.c cVar = this.f6452l;
                    if (cVar != null) {
                        int iY = cVar.y();
                        CampaignEx campaignEx2 = this.f5581z;
                        if (iY == 1) {
                            campaignEx2.setCbt(1);
                            return;
                        } else {
                            campaignEx2.setCbt(0);
                            return;
                        }
                    }
                    return;
                }
                if (this.f6458r) {
                    this.f5581z.setCbt(0);
                    return;
                }
                com.mbridge.msdk.videocommon.d.c cVar2 = this.f6452l;
                if (cVar2 != null) {
                    int iY2 = cVar2.y();
                    CampaignEx campaignEx3 = this.f5581z;
                    if (iY2 == 1) {
                        campaignEx3.setCbt(1);
                    } else {
                        campaignEx3.setCbt(0);
                    }
                }
            }
        } catch (Exception e3) {
            af.b(f5576x, e3.getMessage());
        }
    }

    public void setDeveloperExtraData(String str) {
        this.Q = str;
    }

    public void setInstanceId(String str) {
        this.F = str;
    }

    public void setJSFactory(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.G = bVar;
    }

    public void setMBridgeTempCallback(com.mbridge.msdk.video.bt.module.a.b bVar) {
        this.C = bVar;
    }

    public void setMatchParent() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13, int i14) throws JSONException {
        this.K = i10;
        this.L = i11;
        this.M = i12;
        this.N = i13;
        this.O = i14;
        String strA = s.a(i10, i11, i12, i13, i14);
        this.P = strA;
        af.b(f5576x, strA);
        if (getJSCommon() != null && !TextUtils.isEmpty(this.P)) {
            getJSCommon().b(this.P);
            if (this.f5580d != null && !TextUtils.isEmpty(this.P)) {
                g.a().a((WebView) this.f5580d, "oncutoutfetched", Base64.encodeToString(this.P.getBytes(), 0));
            }
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setNotchPadding(i11, i12, i13, i14);
        }
        MBridgeContainerView mBridgeContainerView = this.e;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.setNotchPadding(i10, i11, i12, i13, i14);
        }
    }

    public void setShowRewardListener(h hVar) {
        this.B = hVar;
    }

    public void setShowingTransparent() {
        int iA;
        Activity activity;
        boolean zD = d();
        this.af = zD;
        if (zD || (iA = x.a(getContext(), "mbridge_reward_theme", TtmlNode.TAG_STYLE)) <= 1 || (activity = this.f6449i) == null) {
            return;
        }
        activity.setTheme(iA);
    }

    public void setVideoEvents(u3.b bVar) {
        this.an = bVar;
        com.mbridge.msdk.video.signal.factory.b bVar2 = this.G;
        if (bVar2 != null && bVar2.getJSCommon() != null) {
            this.G.getJSCommon().a(bVar);
        }
        MBridgeVideoView mBridgeVideoView = this.mbridgeVideoView;
        if (mBridgeVideoView != null) {
            mBridgeVideoView.setVideoEvents(bVar);
        }
    }

    public void setWebViewFront(int i10) {
        this.W = i10;
    }

    public void superDefaultLoad(int i10, String str) {
        this.f.removeCallbacks(this.g);
        this.f.removeCallbacks(this.h);
        this.f5579c.a(true);
        WindVaneWebView windVaneWebView = this.f5580d;
        if (windVaneWebView != null) {
            windVaneWebView.setVisibility(8);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(String str);

        void a(boolean z9);

        /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
        /* renamed from: com.mbridge.msdk.video.bt.module.MBTempContainer$a$a, reason: collision with other inner class name */
        public static class C0062a implements a {

            /* renamed from: a, reason: collision with root package name */
            private boolean f5592a = false;

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public void a(String str) {
                af.b("ActivityErrorListener", str);
                this.f5592a = true;
            }

            @Override // com.mbridge.msdk.video.bt.module.MBTempContainer.a
            public final void a(boolean z9) {
                this.f5592a = z9;
            }
        }
    }

    public void preload() {
    }

    public void setMediaPlayerUrl(String str) {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class e extends a.C0070a {
        private e() {
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(boolean z9) {
            if (MBTempContainer.this.an != null) {
                try {
                    MBTempContainer.this.an.a();
                    af.a("omsdk", "mbtc adUserInteraction click");
                } catch (Exception e) {
                    af.b("omsdk", e.getMessage());
                }
            }
            super.a(z9);
            MBTempContainer.this.B.a(z9, ((AbstractJSContainer) MBTempContainer.this).f6451k, ((AbstractJSContainer) MBTempContainer.this).f6450j);
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void b() {
            super.b();
            MBTempContainer mBTempContainer = MBTempContainer.this;
            Handler handler = mBTempContainer.f;
            if (handler != null) {
                handler.removeCallbacks(mBTempContainer.g);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            super.onFinishRedirection(campaign, str);
            MBTempContainer.this.ag = true;
            MBTempContainer.R(MBTempContainer.this);
            if (campaign != null && (campaign instanceof CampaignEx)) {
                try {
                    CampaignEx campaignEx = (CampaignEx) campaign;
                    String strOptString = new JSONObject(MBTempContainer.this.getJSVideoModule().getCurrentProgress()).optString("progress", "");
                    if (campaignEx.getLinkType() == 3 && campaignEx.getEndcard_click_result() == 2 && strOptString.equals(BuildConfig.VERSION_NAME) && ((AbstractJSContainer) MBTempContainer.this).f6449i != null) {
                        boolean z9 = ((AbstractJSContainer) MBTempContainer.this).f6461v;
                        MBTempContainer mBTempContainer = MBTempContainer.this;
                        if (z9) {
                            MBTempContainer.r(mBTempContainer);
                        } else {
                            ((AbstractJSContainer) mBTempContainer).f6449i.finish();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (MBTempContainer.this.aq) {
                MBTempContainer.this.onResume();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            super.onRedirectionFailed(campaign, str);
            MBTempContainer.R(MBTempContainer.this);
            MBTempContainer.this.ag = true;
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            super.onStartRedirection(campaign, str);
            MBTempContainer.P(MBTempContainer.this);
            if (MBTempContainer.this.aq) {
                MBTempContainer.this.onPause();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a() {
            super.a();
            MBTempContainer.this.receiveSuccess();
        }

        @Override // com.mbridge.msdk.video.signal.a.a.C0070a, com.mbridge.msdk.video.signal.a.InterfaceC0069a
        public final void a(int i10, String str) {
            super.a(i10, str);
            MBTempContainer.this.defaultLoad(i10, str);
        }
    }

    public MBTempContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 1;
        this.F = "";
        this.H = com.mbridge.msdk.foundation.same.a.F;
        this.J = false;
        this.P = "";
        this.R = new ArrayList();
        this.S = 0;
        this.f5577a = false;
        this.f5578b = false;
        this.f5579c = new a.C0062a();
        this.f = new Handler();
        this.V = 0;
        this.W = 0;
        this.g = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.1
            @Override // java.lang.Runnable
            public final void run() {
                int iH = MBTempContainer.this.getActivityProxy().h();
                MBTempContainer mBTempContainer = MBTempContainer.this;
                if (iH == 0) {
                    mBTempContainer.defaultLoad(-1, "WebView load timeout");
                } else {
                    mBTempContainer.V = -3;
                }
            }
        };
        this.h = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.3
            @Override // java.lang.Runnable
            public final void run() {
                int iH = MBTempContainer.this.getActivityProxy().h();
                MBTempContainer mBTempContainer = MBTempContainer.this;
                if (iH == 0) {
                    mBTempContainer.defaultLoad(-3, "Signal Communication connect timeout");
                } else {
                    mBTempContainer.V = -4;
                }
            }
        };
        this.ab = false;
        this.ac = false;
        this.ad = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = null;
        this.an = null;
        this.ao = null;
        this.ap = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBTempContainer.6
            @Override // java.lang.Runnable
            public final void run() {
                if (MBTempContainer.this.aa != null) {
                    MBTempContainer.this.aa.setVisibility(8);
                }
            }
        };
        this.aq = false;
        init(context);
    }

    @Override // com.mbridge.msdk.video.signal.container.AbstractJSContainer
    public final void a(String str) {
        h hVar = this.B;
        if (hVar != null) {
            hVar.a(this.T, str);
        }
        super.a(str);
    }

    private int a(int i10, int i11) {
        List<CampaignEx> list;
        if (i10 < 0 || (list = this.R) == null || list.size() == 0 || i11 <= 1) {
            return i10;
        }
        int videoLength = 0;
        for (int i12 = 0; i12 < i11 - 1; i12++) {
            if (this.R.get(i12) != null) {
                videoLength += this.R.get(i12).getVideoLength();
            }
        }
        if (i10 > videoLength) {
            return i10 - videoLength;
        }
        return 0;
    }

    private int h() {
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (aVarB != null) {
                return (int) aVarB.h();
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }
}

package com.mbridge.msdk.video.module;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.R;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeSegmentsProgressBar;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewParameters;
import com.mbridge.msdk.dycreator.baseview.rewardpopview.MBAcquireRewardPopView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView;
import com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.video.dynview.e.f;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.dialog.MBAlertDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeVideoView extends MBridgeBaseView implements j {
    private static long aQ = 0;

    /* renamed from: m, reason: collision with root package name */
    private static int f6018m = 0;

    /* renamed from: n, reason: collision with root package name */
    private static int f6019n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static int f6020o = 0;

    /* renamed from: p, reason: collision with root package name */
    private static int f6021p = 0;

    /* renamed from: q, reason: collision with root package name */
    private static int f6022q = 0;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f6023r = false;
    private com.mbridge.msdk.video.module.a.a A;
    private a B;
    private boolean C;
    private com.mbridge.msdk.video.dynview.e.a D;
    private f E;
    private int F;
    private boolean G;
    private FrameLayout H;
    private MBridgeClickCTAView I;
    private com.mbridge.msdk.video.signal.factory.b J;
    private int K;
    private int L;
    private RelativeLayout M;
    private boolean N;
    private boolean O;
    private boolean P;
    private String Q;
    private int R;
    private int S;
    private int T;
    private MBAlertDialog U;
    private com.mbridge.msdk.widget.dialog.a V;
    private String W;
    private boolean aA;
    private boolean aB;
    private boolean aC;
    private AlphaAnimation aD;
    private MBridgeBaitClickView aE;
    private int aF;
    private int aG;
    private int aH;
    private int aI;
    private AcquireRewardPopViewParameters aJ;
    private MBAcquireRewardPopView aK;
    private boolean aL;
    private RelativeLayout aM;
    private CollapsibleWebView aN;
    private RelativeLayout aO;
    private boolean aP;
    private int aR;
    private boolean aS;
    private boolean aT;
    private c aU;
    private boolean aV;
    private Runnable aW;
    private final Runnable aX;
    private double aa;
    private double ab;
    private boolean ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private boolean ak;
    private int al;
    private boolean am;
    private int an;
    private t3.b ao;
    private u3.b ap;
    private String aq;
    private int ar;
    private int as;
    private int at;
    private boolean au;
    private boolean av;
    private boolean aw;
    private boolean ax;
    private boolean ay;
    private boolean az;
    public List<CampaignEx> mCampOrderViewData;
    public int mCampaignSize;
    public int mCurrPlayNum;
    public int mCurrentPlayProgressTime;
    public int mMuteSwitch;
    public PlayerView mPlayerView;
    public SoundImageView mSoundImageView;

    /* renamed from: s, reason: collision with root package name */
    private TextView f6024s;
    private View t;
    public TextView tvFlag;

    /* renamed from: u, reason: collision with root package name */
    private RelativeLayout f6025u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f6026v;

    /* renamed from: w, reason: collision with root package name */
    private ProgressBar f6027w;

    /* renamed from: x, reason: collision with root package name */
    private FeedBackButton f6028x;
    private ImageView y;

    /* renamed from: z, reason: collision with root package name */
    private MBridgeSegmentsProgressBar f6029z;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.video.module.MBridgeVideoView$4, reason: invalid class name */
    public class AnonymousClass4 implements com.mbridge.msdk.foundation.same.c.c {
        public AnonymousClass4() {
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            af.b(MBridgeBaseView.TAG, str);
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            if (bitmap != null) {
                try {
                    if (bitmap.isRecycled() || MBridgeVideoView.this.f6026v == null) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                final Bitmap bitmapA = p.a(bitmap, 10);
                                MBridgeVideoView.this.f6026v.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.4.1.1
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        MBridgeVideoView.this.f6026v.setVisibility(0);
                                        MBridgeVideoView.this.f6026v.setImageBitmap(bitmapA);
                                    }
                                });
                            } catch (Exception e) {
                                af.b(MBridgeBaseView.TAG, e.getMessage());
                            }
                        }
                    });
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a();
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f6060a;

        /* renamed from: b, reason: collision with root package name */
        public int f6061b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6062c;

        public final String toString() {
            StringBuilder sb = new StringBuilder("ProgressData{curPlayPosition=");
            sb.append(this.f6060a);
            sb.append(", allDuration=");
            return a3.a.k(sb, this.f6061b, '}');
        }
    }

    public MBridgeVideoView(Context context) {
        super(context);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.C = false;
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = false;
        this.W = "";
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = false;
        this.an = 2;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = true;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aF = 0;
        this.aG = 5;
        this.aH = 5;
        this.aI = 5;
        this.aL = false;
        this.aP = false;
        this.aR = 0;
        this.aS = false;
        this.aT = false;
        this.aU = new c(this);
        this.aV = false;
        this.aW = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.H != null) {
                    MBridgeVideoView.this.H.setVisibility(8);
                }
            }
        };
        this.aX = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.13
            @Override // java.lang.Runnable
            public final void run() {
                int i10 = MBridgeVideoView.this.aG;
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                if (i10 <= 0) {
                    mBridgeVideoView.showRewardPopView();
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.removeCallbacks(mBridgeVideoView2.aX);
                } else {
                    MBridgeVideoView.aa(mBridgeVideoView);
                    MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                    mBridgeVideoView3.postDelayed(mBridgeVideoView3.aX, 1000L);
                }
            }
        };
    }

    public static /* synthetic */ void C(MBridgeVideoView mBridgeVideoView) {
        CollapsibleWebView collapsibleWebView = mBridgeVideoView.aN;
        if (collapsibleWebView == null || mBridgeVideoView.f5901b == null || !TextUtils.isEmpty(collapsibleWebView.getUrl())) {
            return;
        }
        mBridgeVideoView.aN.loadUrl(mBridgeVideoView.f5901b.getClickURL());
        mBridgeVideoView.aN.setToolBarTitle(mBridgeVideoView.f5901b.getAppName());
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        if (gVarS == null) {
            h.a();
            gVarS = i.a();
        }
        mBridgeVideoView.aN.setPageLoadTimtout((int) gVarS.ar());
        mBridgeVideoView.aN.setPageLoadListener(new CollapsibleWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.5
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void a(View view, String str) throws JSONException {
                JSONObject jSONObject;
                if (MBridgeVideoView.this.aP) {
                    return;
                }
                MBridgeVideoView.this.aP = true;
                if (MBridgeVideoView.this.aM != null && MBridgeVideoView.this.aM.getVisibility() != 0) {
                    MBridgeVideoView.this.aM.setVisibility(0);
                }
                Context context = MBridgeVideoView.this.getContext();
                MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                com.mbridge.msdk.click.a.a(context, mBridgeVideoView2.f5901b, mBridgeVideoView2.getUnitId(), MBridgeVideoView.this.f5901b.getNoticeUrl(), true, false, com.mbridge.msdk.click.a.a.f2768i);
                com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c().getApplicationContext(), MBridgeVideoView.this.f5901b);
                e eVar = new e();
                eVar.a("result", 1);
                if (MBridgeVideoView.this.A != null) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, MBridgeVideoView.this.a(0));
                        } catch (JSONException e) {
                            e = e;
                            jSONObject2 = jSONObject;
                            e.printStackTrace();
                            jSONObject = jSONObject2;
                            MBridgeVideoView.this.A.a(131, jSONObject);
                            MBridgeVideoView.this.f5901b.setClickType(1);
                            MBridgeVideoView.this.f5901b.setClickTempSource(1);
                            MBridgeVideoView.this.f5901b.setTriggerClickSource(2);
                            d.a().a("2000149", MBridgeVideoView.this.f5901b);
                            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add("web_view");
                            eVar.a("click_path", arrayList.toString());
                            d.a().a("2000150", MBridgeVideoView.this.f5901b, eVar);
                            eVar.a("url", str);
                            d.a().a("m_webview_render", MBridgeVideoView.this.f5901b, eVar);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                    }
                    MBridgeVideoView.this.A.a(131, jSONObject);
                    MBridgeVideoView.this.f5901b.setClickType(1);
                    MBridgeVideoView.this.f5901b.setClickTempSource(1);
                    MBridgeVideoView.this.f5901b.setTriggerClickSource(2);
                    d.a().a("2000149", MBridgeVideoView.this.f5901b);
                    eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 9);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add("web_view");
                    eVar.a("click_path", arrayList2.toString());
                    d.a().a("2000150", MBridgeVideoView.this.f5901b, eVar);
                }
                eVar.a("url", str);
                d.a().a("m_webview_render", MBridgeVideoView.this.f5901b, eVar);
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void b(View view, String str) {
                a(str, "timeout");
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void b(View view, Map<String, String> map) {
            }

            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CollapsibleWebView.a
            public final void a(View view, Map<String, String> map) {
                String str;
                String str2;
                str = "";
                if (map == null) {
                    str2 = "";
                } else {
                    String str3 = map.get("url");
                    str = str3 != null ? str3 : "";
                    str2 = map.get("description");
                }
                a(str, str2);
            }

            private void a(String str, String str2) {
                if (MBridgeVideoView.this.aP) {
                    return;
                }
                MBridgeVideoView.this.aP = true;
                if (str == null) {
                    str = "";
                }
                if (MBridgeVideoView.this.aM != null && MBridgeVideoView.this.aM.getVisibility() == 0) {
                    MBridgeVideoView.this.aM.setVisibility(8);
                }
                e eVar = new e();
                eVar.a("result", 2);
                eVar.a("url", str);
                eVar.a("reason", str2);
                d.a().a("m_webview_render", MBridgeVideoView.this.f5901b, eVar);
            }
        });
        mBridgeVideoView.aN.setWebViewClient(new WebViewClient() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.6
            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            }
        });
        mBridgeVideoView.aN.setCollapseListener(new CommonWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.7
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.a
            public final void a() {
                if (MBridgeVideoView.this.aO != null) {
                    MBridgeVideoView.this.aO.setVisibility(0);
                    e eVar = new e();
                    eVar.a(NotificationCompat.CATEGORY_STATUS, 1);
                    d.a().a("m_webview_zoom", MBridgeVideoView.this.f5901b, eVar);
                }
                if (MBridgeVideoView.this.aN != null) {
                    MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, 0, 0, 0);
                }
                MBridgeVideoView.this.h();
            }
        });
        mBridgeVideoView.aN.setExpandListener(new CommonWebView.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.8
            @Override // com.mbridge.msdk.mbsignalcommon.commonwebview.CommonWebView.a
            public final void a() {
                if (MBridgeVideoView.this.aO != null) {
                    MBridgeVideoView.this.aO.setVisibility(8);
                    e eVar = new e();
                    eVar.a(NotificationCompat.CATEGORY_STATUS, 2);
                    d.a().a("m_webview_zoom", MBridgeVideoView.this.f5901b, eVar);
                }
                if (MBridgeVideoView.this.aN != null) {
                    MBridgeVideoView.this.aN.setCustomizedToolBarMarginWidthPixel(0, MBridgeVideoView.this.aR, 0, 0);
                }
                MBridgeVideoView.this.g();
            }
        });
        mBridgeVideoView.aN.setExitsClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (MBridgeVideoView.this.aO != null) {
                    MBridgeVideoView.this.aO.setVisibility(0);
                }
                if (MBridgeVideoView.this.aM != null) {
                    MBridgeVideoView.this.aM.setVisibility(8);
                }
                if (MBridgeVideoView.this.ay) {
                    return;
                }
                MBridgeVideoView.this.h();
            }
        });
    }

    public static /* synthetic */ void I(MBridgeVideoView mBridgeVideoView) {
        String strE;
        CampaignEx campaignEx = mBridgeVideoView.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView() || mBridgeVideoView.N) {
            return;
        }
        boolean zIsEmpty = TextUtils.isEmpty(mBridgeVideoView.f5901b.getMof_template_url());
        CampaignEx campaignEx2 = mBridgeVideoView.f5901b;
        if (!zIsEmpty) {
            strE = campaignEx2.getMof_template_url();
        } else if (campaignEx2.getRewardTemplateMode() == null) {
            return;
        } else {
            strE = mBridgeVideoView.f5901b.getRewardTemplateMode().e();
        }
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = aq.a(strE, "guideShow");
            String strA2 = aq.a(strE, "guideDelay");
            String strA3 = aq.a(strE, "guideTime");
            String strA4 = aq.a(strE, "guideRewardTime");
            if (!TextUtils.isEmpty(strA)) {
                mBridgeVideoView.aF = Integer.parseInt(strA);
            }
            if (!TextUtils.isEmpty(strA2)) {
                int i10 = Integer.parseInt(strA2);
                mBridgeVideoView.aG = i10;
                if (i10 > 10 || i10 < 3) {
                    mBridgeVideoView.aG = 5;
                }
            }
            if (!TextUtils.isEmpty(strA3)) {
                int i11 = Integer.parseInt(strA3);
                mBridgeVideoView.aH = i11;
                if (i11 > 10 || i11 < 3) {
                    mBridgeVideoView.aH = 5;
                }
            }
            if (!TextUtils.isEmpty(strA4)) {
                int i12 = Integer.parseInt(strA4);
                mBridgeVideoView.aI = i12;
                if (i12 > 10 || i12 < 5) {
                    mBridgeVideoView.aI = 5;
                }
            }
            int i13 = mBridgeVideoView.aF;
            if (i13 > 0 && i13 <= 2) {
                int iO = mBridgeVideoView.o();
                if (iO == 0 || iO > mBridgeVideoView.aG) {
                    int i14 = iO - mBridgeVideoView.aG;
                    if (i14 >= 0 && mBridgeVideoView.aI > i14) {
                        mBridgeVideoView.aI = i14;
                    }
                    int iP = mBridgeVideoView.p();
                    if (mBridgeVideoView.aI >= iP) {
                        mBridgeVideoView.aI = iP - mBridgeVideoView.aG;
                    }
                    if (mBridgeVideoView.aG >= iP) {
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(mBridgeVideoView.f5901b.getAppName());
                    g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                    mBridgeVideoView.aJ = new AcquireRewardPopViewParameters.Builder("", mBridgeVideoView.W, mBridgeVideoView.aF, gVarA != null ? gVarA.r() : "US").setAutoDismissTime(mBridgeVideoView.aH).setReduceTime(mBridgeVideoView.aI).setBehaviourListener(new AcquireRewardPopViewBehaviourListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.11
                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onOutOfContentClicked(float f, float f10) {
                            if (MBridgeVideoView.this.A != null) {
                                MBridgeVideoView.this.A.a(105, "");
                            }
                        }

                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onReceivedFail(String str) {
                            MBridgeVideoView.this.P = false;
                            if (com.mbridge.msdk.e.b.b()) {
                                MBridgeVideoView.this.setCover(false);
                            }
                            MBridgeVideoView.this.h();
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f5901b, mBridgeVideoView2.W, MBridgeVideoView.this.aF, 2, str);
                        }

                        @Override // com.mbridge.msdk.dycreator.baseview.rewardpopview.AcquireRewardPopViewBehaviourListener
                        public final void onReceivedSuccess(int i15) {
                            MBridgeVideoView.this.P = false;
                            if (com.mbridge.msdk.e.b.b()) {
                                MBridgeVideoView.this.setCover(false);
                            }
                            int iO2 = MBridgeVideoView.this.o() - i15;
                            MBridgeVideoView.this.f5901b.setVideoCompleteTime(iO2);
                            MBridgeVideoView.this.h();
                            com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                            if (aVar != null) {
                                aVar.a(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, Integer.valueOf(iO2));
                            }
                            MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                            com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f5901b, mBridgeVideoView2.W, MBridgeVideoView.this.aF, 1, "");
                        }
                    }).setRightAnswerList(arrayList).build();
                    mBridgeVideoView.postDelayed(mBridgeVideoView.aX, 1000L);
                }
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.video.module.MBridgeVideoView r8, java.lang.String r9) throws org.json.JSONException {
        /*
            com.mbridge.msdk.video.module.a.a r0 = r8.A
            if (r0 == 0) goto L9e
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f5901b
            if (r0 == 0) goto L56
            r1 = 1
            r0.setClickTempSource(r1)
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx$c r0 = r0.getRewardTemplateMode()     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = ""
            if (r0 == 0) goto L29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L2b
            r2.<init>()     // Catch: java.lang.Exception -> L2b
            int r0 = r0.f()     // Catch: java.lang.Exception -> L2b
            r2.append(r0)     // Catch: java.lang.Exception -> L2b
            r2.append(r1)     // Catch: java.lang.Exception -> L2b
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L2b
        L29:
            r7 = r1
            goto L2e
        L2b:
            r0 = move-exception
            r9 = r0
            goto L53
        L2e:
            android.content.Context r0 = r8.f5900a     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            java.lang.String r2 = r1.getCampaignUnitId()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            boolean r3 = r1.isBidCampaign()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            java.lang.String r4 = r1.getRequestId()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            java.lang.String r5 = r1.getRequestIdNotice()     // Catch: java.lang.Exception -> L2b
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r8.f5901b     // Catch: java.lang.Exception -> L2b
            java.lang.String r6 = r1.getId()     // Catch: java.lang.Exception -> L2b
            r1 = r9
            com.mbridge.msdk.foundation.same.report.i.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L2b
            goto L56
        L53:
            r9.printStackTrace()
        L56:
            r9 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L6a
            r1.<init>()     // Catch: org.json.JSONException -> L6a
            java.lang.String r9 = com.mbridge.msdk.foundation.same.a.f3606j     // Catch: org.json.JSONException -> L67
            r0 = 0
            org.json.JSONObject r0 = r8.a(r0)     // Catch: org.json.JSONException -> L67
            r1.put(r9, r0)     // Catch: org.json.JSONException -> L67
            goto L70
        L67:
            r0 = move-exception
        L68:
            r9 = r0
            goto L6d
        L6a:
            r0 = move-exception
            r1 = r9
            goto L68
        L6d:
            r9.printStackTrace()
        L70:
            com.mbridge.msdk.video.module.a.a r9 = r8.A
            r0 = 105(0x69, float:1.47E-43)
            r9.a(r0, r1)
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()
            android.content.Context r9 = r9.c()
            if (r9 == 0) goto L9e
            com.mbridge.msdk.foundation.controller.c r9 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L93
            android.content.Context r9 = r9.c()     // Catch: java.lang.Exception -> L93
            android.content.Context r9 = r9.getApplicationContext()     // Catch: java.lang.Exception -> L93
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r8.f5901b     // Catch: java.lang.Exception -> L93
            com.mbridge.msdk.video.module.b.b.d(r9, r8)     // Catch: java.lang.Exception -> L93
            goto L9e
        L93:
            r0 = move-exception
            r8 = r0
            java.lang.String r9 = "MBridgeBaseView"
            java.lang.String r8 = r8.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r9, r8)
        L9e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.a(com.mbridge.msdk.video.module.MBridgeVideoView, java.lang.String):void");
    }

    public static /* synthetic */ int aa(MBridgeVideoView mBridgeVideoView) {
        int i10 = mBridgeVideoView.aG;
        mBridgeVideoView.aG = i10 - 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(boolean z9) throws JSONException {
        if (!this.am) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!this.au) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.F);
            }
            if (this.aw) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.D);
            }
            if (this.av) {
                jSONObject.put("Alert_window_status", com.mbridge.msdk.foundation.same.a.E);
            }
            jSONObject.put("complete_info", z9 ? 1 : 2);
            return jSONObject.toString();
        } catch (Exception unused) {
            af.b(MBridgeBaseView.TAG, "getIVRewardStatusString ERROR");
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:108:0x014e A[Catch: Exception -> 0x0031, TryCatch #0 {Exception -> 0x0031, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x000c, B:8:0x001b, B:10:0x001f, B:12:0x0023, B:14:0x0027, B:18:0x0034, B:21:0x003c, B:23:0x0042, B:25:0x0046, B:27:0x004a, B:29:0x004e, B:31:0x0052, B:33:0x005e, B:35:0x0062, B:37:0x0066, B:39:0x006a, B:41:0x0076, B:43:0x007a, B:45:0x008a, B:47:0x0097, B:49:0x00a4, B:51:0x00ad, B:53:0x00b1, B:55:0x00b5, B:57:0x00c1, B:59:0x00c5, B:61:0x00c9, B:63:0x00cd, B:65:0x00d9, B:67:0x00dd, B:68:0x00e0, B:70:0x00e6, B:72:0x00ec, B:74:0x00f0, B:76:0x00f7, B:78:0x00fb, B:80:0x00ff, B:82:0x0103, B:84:0x010a, B:46:0x0091, B:86:0x010e, B:88:0x0112, B:90:0x0118, B:92:0x012d, B:110:0x0152, B:112:0x0156, B:102:0x013f, B:104:0x0143, B:106:0x0147, B:108:0x014e, B:114:0x015c, B:116:0x0160), top: B:120:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.e():void");
    }

    private boolean f() {
        try {
            this.mPlayerView = (PlayerView) findViewById(filterFindViewId(this.aC, "mbridge_vfpv"));
            this.mSoundImageView = (SoundImageView) findViewById(filterFindViewId(this.aC, "mbridge_sound_switch"));
            this.f6024s = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_count"));
            View viewFindViewById = findViewById(filterFindViewId(this.aC, "mbridge_rl_playing_close"));
            this.t = viewFindViewById;
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            this.f6025u = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_top_control"));
            this.f6026v = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_videoview_bg"));
            this.f6027w = (ProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_video_progress_bar"));
            this.f6028x = (FeedBackButton) findViewById(filterFindViewId(this.aC, "mbridge_native_endcard_feed_btn"));
            this.y = (ImageView) findViewById(filterFindViewId(this.aC, "mbridge_iv_link"));
            this.aM = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_scale_webview_layout"));
            this.aO = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_header_layout"));
            if (this.aM != null) {
                CollapsibleWebView collapsibleWebView = new CollapsibleWebView(getContext());
                this.aN = collapsibleWebView;
                this.aM.addView(collapsibleWebView, new RelativeLayout.LayoutParams(-1, -1));
            }
            ak.a(1, this.y, this.f5901b, this.f5900a, false, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.20
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    MBridgeVideoView.this.h();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    MBridgeVideoView.this.g();
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    MBridgeVideoView.this.h();
                }
            });
            this.f6029z = (MBridgeSegmentsProgressBar) findViewById(filterFindViewId(this.aC, "mbridge_reward_segment_progressbar"));
            this.H = (FrameLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_cta_layout"));
            this.aE = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aC, "mbridge_animation_click_view"));
            this.M = (RelativeLayout) findViewById(filterFindViewId(this.aC, "mbridge_reward_moreoffer_layout"));
            this.aK = (MBAcquireRewardPopView) findViewById(filterFindViewId(this.aC, "mbridge_reward_popview"));
            this.tvFlag = (TextView) findViewById(filterFindViewId(this.aC, "mbridge_tv_flag"));
            return isNotNULL(this.mPlayerView, this.mSoundImageView, this.f6024s, this.t);
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null) {
                playerView.onPause();
                CampaignEx campaignEx = this.f5901b;
                if (campaignEx != null && !campaignEx.isRewardPopViewShowed) {
                    removeCallbacks(this.aX);
                }
                if (com.mbridge.msdk.e.b.a()) {
                    this.mPlayerView.setIsCovered(this.aL || this.O || this.P);
                }
                CampaignEx campaignEx2 = this.f5901b;
                if (campaignEx2 == null || campaignEx2.getNativeVideoTracking() == null || this.f5901b.isHasReportAdTrackPause()) {
                    return;
                }
                this.f5901b.setHasReportAdTrackPause(true);
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                CampaignEx campaignEx3 = this.f5901b;
                com.mbridge.msdk.click.a.a(contextC, campaignEx3, this.W, campaignEx3.getNativeVideoTracking().m(), false, false);
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        c cVar;
        RelativeLayout relativeLayout;
        try {
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f5901b.getRewardTemplateMode().f() != 5002010 || (relativeLayout = this.aO) == null || relativeLayout.getVisibility() == 0) {
                if (!this.ad) {
                    boolean zPlayVideo = this.mPlayerView.playVideo();
                    CampaignEx campaignEx2 = this.f5901b;
                    if (campaignEx2 != null && campaignEx2.getPlayable_ads_without_video() != 2 && !zPlayVideo && (cVar = this.aU) != null) {
                        cVar.onPlayError("play video failed");
                    }
                    this.ad = true;
                    return;
                }
                MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
                if (mBAcquireRewardPopView != null && this.P) {
                    mBAcquireRewardPopView.onResume();
                }
                if (this.P) {
                    return;
                }
                if (!com.mbridge.msdk.e.b.a()) {
                    i();
                } else {
                    if (this.aL || this.O) {
                        return;
                    }
                    this.mPlayerView.setIsCovered(false);
                    i();
                }
            }
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage(), e);
        }
    }

    private void i() {
        if (this.ay) {
            if (!this.az) {
                this.mPlayerView.seekToEndFrame();
            }
            this.az = true;
        } else {
            this.mPlayerView.onResume();
        }
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || campaignEx.isRewardPopViewShowed) {
            return;
        }
        post(this.aX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.e || this.t.getVisibility() == 0) {
            return;
        }
        if (!this.h || this.G) {
            this.t.setVisibility(0);
        }
        this.ag = true;
    }

    private void k() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
            return;
        }
        l();
    }

    private void l() {
        int iB;
        int iF;
        float f = ak.f(this.f5900a);
        float fE = ak.e(this.f5900a);
        double d8 = this.aa;
        if (d8 > 0.0d) {
            double d10 = this.ab;
            if (d10 > 0.0d && f > 0.0f && fE > 0.0f) {
                double d11 = d8 / d10;
                double d12 = f / fE;
                af.c(MBridgeBaseView.TAG, "videoWHDivide:" + d11 + "  screenWHDivide:" + d12);
                double dA = ak.a(Double.valueOf(d11));
                double dA2 = ak.a(Double.valueOf(d12));
                af.c(MBridgeBaseView.TAG, "videoWHDivideFinal:" + dA + "  screenWHDivideFinal:" + dA2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
                if (dA > dA2) {
                    double d13 = (f * this.ab) / this.aa;
                    layoutParams.width = -1;
                    layoutParams.height = (int) d13;
                    layoutParams.gravity = 17;
                } else if (dA < dA2) {
                    layoutParams.width = (int) (fE * d11);
                    layoutParams.height = -1;
                    layoutParams.gravity = 17;
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                try {
                    CampaignEx campaignEx = this.f5901b;
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        if (this.f5901b.getRewardTemplateMode() != null) {
                            iF = this.f5901b.getRewardTemplateMode().f();
                            iB = this.f5901b.getRewardTemplateMode().b();
                        } else {
                            iB = this.f5900a.getResources().getConfiguration().orientation;
                            iF = TypedValues.Custom.TYPE_BOOLEAN;
                        }
                        if (iF == 102 || iF == 202) {
                            if (iB == 1) {
                                layoutParams.width = -1;
                                layoutParams.gravity = 17;
                                layoutParams.height = (int) (this.ab / (this.aa / f));
                            } else {
                                layoutParams.height = -1;
                                layoutParams.gravity = 17;
                                layoutParams.width = (int) (fE * d11);
                            }
                        }
                        if (iF == 202 && !TextUtils.isEmpty(this.f5901b.getImageUrl())) {
                            a(this.f5901b.getImageUrl());
                        }
                        if (iF == 302 || iF == 802 || iF == 5002010) {
                            double d14 = this.aa;
                            double d15 = this.ab;
                            if (d14 / d15 > 1.0d) {
                                layoutParams.width = -1;
                                layoutParams.height = (int) ((d15 * f) / d14);
                            } else {
                                int iA = ak.a(getContext(), 220.0f);
                                layoutParams.width = (int) ((this.aa * iA) / this.ab);
                                layoutParams.height = iA;
                            }
                        }
                    }
                } catch (Throwable th) {
                    af.b(MBridgeBaseView.TAG, th.getMessage());
                }
                this.mPlayerView.setLayoutParams(layoutParams);
                setMatchParent();
                return;
            }
        }
        m();
    }

    private void m() {
        try {
            setLayoutParam(0, 0, -1, -1);
            if (isLandscape() || !this.e) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
            int iF = ak.f(this.f5900a);
            layoutParams.width = -1;
            layoutParams.height = (iF * 9) / 16;
            layoutParams.gravity = 17;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.W);
            com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), this.W, "_1"), this.f5901b);
        }
        boolean zB = com.mbridge.msdk.foundation.d.b.a().b();
        FeedBackButton feedBackButton = this.f6028x;
        if (zB) {
            if (feedBackButton != null) {
                com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), this.W, "_1"), this.f6028x);
            }
        } else if (feedBackButton != null) {
            feedBackButton.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o() {
        int videoCompleteTime = 0;
        try {
            int iP = p();
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null) {
                videoCompleteTime = campaignEx.getVideoCompleteTime();
                if (this.f5901b.getDynamicTempCode() != 5 && videoCompleteTime > iP) {
                    videoCompleteTime = iP;
                }
                if (videoCompleteTime > 0) {
                    return videoCompleteTime;
                }
            }
            return iP;
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return videoCompleteTime;
        }
    }

    private int p() {
        try {
            c cVar = this.aU;
            int iB = cVar != null ? cVar.b() : 0;
            return iB == 0 ? this.f5901b.getVideoLength() : iB;
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
            return 0;
        }
    }

    public void addCTAView() {
        if (this.H == null) {
            return;
        }
        if (this.I == null) {
            MBridgeClickCTAView mBridgeClickCTAView = new MBridgeClickCTAView(getContext());
            this.I = mBridgeClickCTAView;
            mBridgeClickCTAView.setCampaign(this.f5901b);
            this.I.setUnitId(this.W);
            com.mbridge.msdk.video.module.a.a aVar = this.A;
            if (aVar != null) {
                this.I.setNotifyListener(new com.mbridge.msdk.video.module.a.a.i(aVar));
            }
            this.I.preLoadData(this.J);
        }
        this.H.addView(this.I);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void alertWebViewShowed() {
        this.O = true;
        setShowingAlertViewCover(true);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.e) {
            if (!this.h) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.16
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws JSONException {
                        MBridgeVideoView.this.f5901b.setClickTempSource(1);
                        MBridgeVideoView.this.f5901b.setTriggerClickSource(2);
                        d.a().a("m_player_click", MBridgeVideoView.this.f5901b);
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                    }
                });
            } else if (com.mbridge.msdk.video.dynview.i.a.a(this.f5901b) == -1 || com.mbridge.msdk.video.dynview.i.a.a(this.f5901b) == 100) {
                this.mPlayerView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.15
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) throws JSONException {
                        if (MBridgeVideoView.this.notifyListener != null) {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(com.mbridge.msdk.foundation.same.a.f3606j, MBridgeVideoView.this.mPlayerView.buildH5JsonObject(0));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            MBridgeVideoView.this.f5901b.setClickTempSource(1);
                            MBridgeVideoView.this.f5901b.setTriggerClickSource(2);
                            MBridgeVideoView.this.notifyListener.a(1, jSONObject);
                        }
                        if (MBridgeVideoView.this.ap != null) {
                            try {
                                MBridgeVideoView.this.ap.a();
                                af.a("omsdk", "play video view:  click");
                            } catch (Exception e3) {
                                af.b("omsdk", e3.getMessage());
                            }
                        }
                        MBridgeVideoView.this.setCTALayoutVisibleOrGone();
                    }
                });
            }
            SoundImageView soundImageView = this.mSoundImageView;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.17
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e eVar = new e();
                        Integer num = 2;
                        PlayerView playerView = MBridgeVideoView.this.mPlayerView;
                        if (playerView != null) {
                            eVar.a("mute_state", Boolean.valueOf(playerView.isSilent()));
                            if (MBridgeVideoView.this.mPlayerView.isSilent()) {
                                num = 1;
                            }
                        }
                        int iIntValue = num.intValue();
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        if (iIntValue == 1) {
                            mBridgeVideoView.mMuteSwitch = 2;
                        } else {
                            mBridgeVideoView.mMuteSwitch = 1;
                        }
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                        if (aVar != null) {
                            aVar.a(5, num);
                        }
                        d.a().a("m_sound_click", MBridgeVideoView.this.f5901b, eVar);
                    }
                });
            }
            this.t.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.18
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    try {
                        e eVar = new e();
                        eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                        d.a().a("2000152", eVar);
                        d.a().a("2000148", MBridgeVideoView.this.f5901b, eVar);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                    boolean z9 = MBridgeVideoView.this.am;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    if (!z9) {
                        CampaignEx campaignEx = mBridgeVideoView.f5901b;
                        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || MBridgeVideoView.this.f5901b.getRewardTemplateMode().f() != 5002010 || !MBridgeVideoView.this.ay) {
                            MBridgeVideoView.this.e();
                            return;
                        }
                        MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                        if (mBridgeVideoView2.notifyListener != null) {
                            mBridgeVideoView2.aS = true;
                            MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                            mBridgeVideoView3.notifyListener.a(2, mBridgeVideoView3.b(mBridgeVideoView3.ay));
                            return;
                        }
                        return;
                    }
                    mBridgeVideoView.aB = true;
                    CampaignEx campaignEx2 = MBridgeVideoView.this.f5901b;
                    if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && MBridgeVideoView.this.f5901b.getRewardTemplateMode().f() == 5002010 && MBridgeVideoView.this.ay) {
                        MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                        if (mBridgeVideoView4.notifyListener != null) {
                            mBridgeVideoView4.aS = true;
                            MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
                            mBridgeVideoView5.notifyListener.a(2, mBridgeVideoView5.b(mBridgeVideoView5.ay));
                            return;
                        }
                        return;
                    }
                    boolean z10 = MBridgeVideoView.this.ax;
                    MBridgeVideoView mBridgeVideoView6 = MBridgeVideoView.this;
                    if (z10) {
                        mBridgeVideoView6.e();
                        return;
                    }
                    com.mbridge.msdk.video.module.a.a aVar = mBridgeVideoView6.notifyListener;
                    if (aVar != null) {
                        aVar.a(123, "");
                    }
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void closeVideoOperate(int i10, int i11) {
        if (i10 == 1) {
            this.aB = true;
            if (getVisibility() == 0) {
                e();
            }
            try {
                e eVar = new e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                d.a().a("2000152", eVar);
                d.a().a("2000148", this.f5901b, eVar);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
        if (i11 == 1) {
            gonePlayingCloseView();
        } else if (i11 == 2) {
            if (this.aA && getVisibility() == 0) {
                return;
            }
            j();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
        this.ac = true;
        showVideoLocation(0, 0, ak.f(this.f5900a), ak.e(this.f5900a), 0, 0, 0, 0, 0);
        videoOperate(1);
        if (this.R == 0) {
            closeVideoOperate(-1, 2);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void dismissAllAlert() {
        MBAlertDialog mBAlertDialog = this.U;
        if (mBAlertDialog != null) {
            mBAlertDialog.dismiss();
        }
        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
        if (aVar != null) {
            aVar.a(125, "");
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewHeight() {
        return f6022q;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewLeft() {
        return f6020o;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewRadius() {
        return f6018m;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewTop() {
        return f6019n;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public int getBorderViewWidth() {
        return f6021p;
    }

    public int getCloseAlert() {
        return this.T;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public String getCurrentProgress() {
        try {
            int iA = this.aU.a();
            CampaignEx campaignEx = this.f5901b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("progress", a(iA, videoLength));
            jSONObject.put("time", iA);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, videoLength + "");
            return jSONObject.toString();
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage(), th);
            return "{}";
        }
    }

    public int getMute() {
        return this.an;
    }

    public String getUnitId() {
        return this.W;
    }

    public int getVideoSkipTime() {
        return this.R;
    }

    public void gonePlayingCloseView() {
        if (this.e && this.t.getVisibility() != 8) {
            this.t.setVisibility(8);
            this.ag = false;
        }
        if (this.aV || this.aj || this.ah) {
            return;
        }
        this.aV = true;
        int i10 = this.R;
        if (i10 < 0) {
            return;
        }
        if (i10 == 0) {
            this.aj = true;
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeVideoView.this.aj = true;
                }
            }, this.R * 1000);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void hideAlertView(int i10) {
        if (this.O) {
            this.O = false;
            this.au = true;
            setShowingAlertViewCover(false);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.W, false);
            com.mbridge.msdk.foundation.same.report.i.a(this.f5900a, this.f5901b, com.mbridge.msdk.videocommon.d.c.f6516a, this.W, 1, i10, 1);
            if (i10 == 0) {
                h();
                if (this.am) {
                    int i11 = this.ar;
                    if (i11 == com.mbridge.msdk.foundation.same.a.I || i11 == com.mbridge.msdk.foundation.same.a.H) {
                        this.av = true;
                        com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        CampaignEx campaignEx = this.f5901b;
                        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f5901b.getRewardTemplateMode().f() == 5002010) {
                            j();
                            return;
                        } else {
                            this.aA = true;
                            gonePlayingCloseView();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.aw = true;
            boolean z9 = this.am;
            if (z9 && this.ar == com.mbridge.msdk.foundation.same.a.I) {
                h();
                return;
            }
            if (z9 && this.ar == com.mbridge.msdk.foundation.same.a.H) {
                com.mbridge.msdk.video.module.a.a aVar2 = this.notifyListener;
                if (aVar2 != null) {
                    this.aS = true;
                    aVar2.a(2, b(this.ay));
                    return;
                }
                return;
            }
            com.mbridge.msdk.video.module.a.a aVar3 = this.notifyListener;
            if (aVar3 != null) {
                this.aS = true;
                aVar3.a(2, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public boolean isH5Canvas() {
        return getLayoutParams().height < ak.e(this.f5900a.getApplicationContext());
    }

    public boolean isInstDialogShowing() {
        return this.aL;
    }

    public boolean isMiniCardShowing() {
        return this.af;
    }

    public boolean isRewardPopViewShowing() {
        return this.P;
    }

    public boolean isShowingAlertView() {
        return this.O;
    }

    public boolean isShowingTransparent() {
        return this.ak;
    }

    public boolean isfront() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return false;
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int childCount = viewGroup.getChildCount();
        int i10 = iIndexOfChild + 1;
        boolean z9 = false;
        while (i10 <= childCount - 1) {
            if (viewGroup.getChildAt(i10).getVisibility() == 0 && this.af) {
                return false;
            }
            i10++;
            z9 = true;
        }
        return z9;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void notifyCloseBtn(int i10) {
        if (i10 == 0) {
            this.ah = true;
            this.aj = false;
        } else if (i10 == 1) {
            this.ai = true;
        }
    }

    public void notifyVideoClose() {
        this.aS = true;
        this.notifyListener.a(2, "");
    }

    public void onActivityPause() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onPause();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityResume() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onResume();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onActivityStop() {
        try {
            MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
            if (mBAcquireRewardPopView != null) {
                mBAcquireRewardPopView.onStop();
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void onBackPress() {
        boolean z9;
        if (this.af || this.O || this.av) {
            return;
        }
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx != null && campaignEx.getRewardTemplateMode() != null && this.f5901b.getRewardTemplateMode().f() == 5002010 && (z9 = this.ay)) {
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            if (aVar != null) {
                this.aS = true;
                aVar.a(2, b(z9));
                return;
            }
            return;
        }
        if (this.ag) {
            e();
            return;
        }
        boolean z10 = this.ah;
        if (z10 && this.ai) {
            e();
        } else {
            if (z10 || !this.aj) {
                return;
            }
            e();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f5901b;
        if ((campaignEx == null || !campaignEx.isDynamicView()) && this.e && this.ac) {
            k();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            if (this.aW != null) {
                getHandler().removeCallbacks(this.aW);
            }
            if (this.aF != 0) {
                removeCallbacks(this.aX);
            }
        } catch (Throwable th) {
            af.b(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        this.J = bVar;
        if (!this.e) {
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            if (aVar != null) {
                aVar.a(12, "MBridgeVideoView initSuccess false");
            }
        } else if (!TextUtils.isEmpty(this.Q) && this.f5901b != null) {
            t3.b bVar2 = this.ao;
            if (bVar2 != null) {
                bVar2.d(this.mPlayerView);
                SoundImageView soundImageView = this.mSoundImageView;
                t3.e eVar = t3.e.f12778d;
                if (soundImageView != null) {
                    this.ao.a(soundImageView, eVar);
                }
                this.ao.a(this.f6024s, eVar);
                this.ao.a(this.t, t3.e.f12775a);
            }
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null && ap.b(campaignEx.getVideoResolution())) {
                String videoResolution = this.f5901b.getVideoResolution();
                af.c(MBridgeBaseView.TAG, "MBridgeBaseView videoResolution:" + videoResolution);
                String[] strArrSplit = videoResolution.split("x");
                if (strArrSplit.length == 2) {
                    if (ak.m(strArrSplit[0]) > 0.0d) {
                        this.aa = ak.m(strArrSplit[0]);
                    }
                    if (ak.m(strArrSplit[1]) > 0.0d) {
                        this.ab = ak.m(strArrSplit[1]);
                    }
                    af.c(MBridgeBaseView.TAG, "MBridgeBaseView mVideoW:" + this.aa + "  mVideoH:" + this.ab);
                }
                if (this.aa <= 0.0d) {
                    this.aa = 1280.0d;
                }
                if (this.ab <= 0.0d) {
                    this.ab = 720.0d;
                }
            }
            this.mPlayerView.initBufferIngParam(this.S);
            this.mPlayerView.initVFPData(this.Q, this.f5901b.getVideoUrlEncode(), this.aU);
            soundOperate(this.an, -1, null);
        }
        f6023r = false;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressBarOperate(int i10) {
        ProgressBar progressBar;
        if (this.e) {
            if (i10 == 1) {
                ProgressBar progressBar2 = this.f6027w;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                    return;
                }
                return;
            }
            if (i10 != 2 || (progressBar = this.f6027w) == null) {
                return;
            }
            progressBar.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void progressOperate(int i10, int i11) {
        if (this.e) {
            af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i10);
            CampaignEx campaignEx = this.f5901b;
            int videoLength = campaignEx != null ? campaignEx.getVideoLength() : 0;
            if (i10 > 0 && i10 <= videoLength && this.mPlayerView != null) {
                af.c(MBridgeBaseView.TAG, "progressOperate progress:" + i10);
                this.mPlayerView.seekTo(i10 * 1000);
            }
            if (i11 == 1) {
                this.f6024s.setVisibility(8);
            } else if (i11 == 2) {
                this.f6024s.setVisibility(0);
            }
            if (this.f6024s.getVisibility() == 0) {
                n();
            }
        }
    }

    public void releasePlayer() {
        try {
            PlayerView playerView = this.mPlayerView;
            if (playerView != null && !this.ae) {
                playerView.release();
                e eVar = new e();
                eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                d.a().a("2000146", this.f5901b, eVar);
            }
            c cVar = this.aU;
            if (cVar != null) {
                cVar.c();
            }
            if (this.A != null) {
                this.A = null;
            }
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void setAdSession(t3.b bVar) {
        this.ao = bVar;
    }

    public void setBufferTimeout(int i10) {
        this.S = i10;
    }

    public void setCTALayoutVisibleOrGone() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || this.H == null) {
            return;
        }
        if (campaignEx.getRewardTemplateMode() == null || this.f5901b.getRewardTemplateMode().f() != 902) {
            int i10 = this.L;
            if (i10 != -5) {
                if (i10 == -3) {
                    return;
                }
                if (this.I == null) {
                    addCTAView();
                }
                if (this.L == -1) {
                    int visibility = this.H.getVisibility();
                    FrameLayout frameLayout = this.H;
                    if (visibility != 0) {
                        frameLayout.setVisibility(0);
                        postDelayed(this.aW, 3000L);
                    } else {
                        frameLayout.setVisibility(8);
                        getHandler().removeCallbacks(this.aW);
                    }
                }
                if (this.L >= 0) {
                    this.H.setVisibility(0);
                    return;
                }
                return;
            }
            if (this.K < -1) {
                return;
            }
            if (this.I == null) {
                addCTAView();
            }
            int i11 = this.K;
            if (i11 >= 0) {
                this.H.setVisibility(0);
                return;
            }
            if (i11 == -1) {
                int visibility2 = this.H.getVisibility();
                FrameLayout frameLayout2 = this.H;
                if (visibility2 != 0) {
                    frameLayout2.setVisibility(0);
                    postDelayed(this.aW, 3000L);
                } else {
                    frameLayout2.setVisibility(8);
                    getHandler().removeCallbacks(this.aW);
                }
            }
        }
    }

    public void setCamPlayOrderCallback(com.mbridge.msdk.video.dynview.e.a aVar, List<CampaignEx> list, int i10, int i11) {
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar;
        this.D = aVar;
        this.mCampaignSize = list.size();
        this.mCurrPlayNum = i10;
        this.F = i11;
        this.mCampOrderViewData = list;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || campaignEx.getDynamicTempCode() != 5) {
            CampaignEx campaignEx2 = this.f5901b;
            if (campaignEx2 == null || campaignEx2.getProgressBarShow() != 1 || (mBridgeSegmentsProgressBar = this.f6029z) == null) {
                return;
            }
            mBridgeSegmentsProgressBar.init(1, 3);
            this.f6029z.setVisibility(0);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar2 = this.f6029z;
        if (mBridgeSegmentsProgressBar2 == null || this.mCampOrderViewData == null) {
            return;
        }
        if (this.mCampaignSize > 1) {
            mBridgeSegmentsProgressBar2.setVisibility(0);
            this.f6029z.init(this.mCampaignSize, 2);
            for (int i12 = 0; i12 < this.mCampOrderViewData.size(); i12++) {
                int videoPlayProgress = this.mCampOrderViewData.get(i12).getVideoPlayProgress();
                if (videoPlayProgress > 0) {
                    this.f6029z.setProgress(videoPlayProgress, i12);
                }
                if (this.mCampOrderViewData.get(i12).isRewardPopViewShowed) {
                    this.N = true;
                }
            }
            return;
        }
        CampaignEx campaignEx3 = this.f5901b;
        if (campaignEx3 == null || campaignEx3.getProgressBarShow() != 1) {
            this.f6029z.setVisibility(8);
            return;
        }
        MBridgeSegmentsProgressBar mBridgeSegmentsProgressBar3 = this.f6029z;
        if (mBridgeSegmentsProgressBar3 != null) {
            mBridgeSegmentsProgressBar3.init(1, 3);
            this.f6029z.setVisibility(0);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(campaignEx);
            c cVar2 = this.aU;
            int iR = (campaignEx == null || campaignEx.getReady_rate() == -1) ? com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.W, false).r() : campaignEx.getReady_rate();
            cVar2.a(iR, com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.W, false).s());
        }
    }

    public void setCloseAlert(int i10) {
        this.T = i10;
    }

    public void setContainerViewOnNotifyListener(com.mbridge.msdk.video.module.a.a aVar) {
        this.A = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setCover(boolean z9) {
        if (this.e) {
            this.mPlayerView.setIsCovered(z9);
        }
    }

    public void setDialogRole(int i10) {
        this.ax = i10 == 1;
        af.b(MBridgeBaseView.TAG, i10 + " " + this.ax);
    }

    public void setIPlayVideoViewLayoutCallBack(f fVar) {
        this.E = fVar;
    }

    public void setIVRewardEnable(int i10, int i11, int i12) {
        this.ar = i10;
        this.as = i11;
        this.at = i12;
    }

    public void setInstDialogState(boolean z9) {
        PlayerView playerView;
        this.aL = z9;
        if (!com.mbridge.msdk.e.b.a() || (playerView = this.mPlayerView) == null) {
            return;
        }
        playerView.setIsCovered(z9);
    }

    public void setIsIV(boolean z9) {
        this.am = z9;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(z9);
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setMiniEndCardState(boolean z9) {
        this.af = z9;
    }

    public void setNotchPadding(final int i10, final int i11, final int i12, final int i13) {
        RelativeLayout relativeLayout;
        MBridgeVideoView mBridgeVideoView;
        try {
            af.b(MBridgeBaseView.TAG, "NOTCH VideoView ".concat(String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13))));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            int i14 = layoutParams.leftMargin;
            int i15 = layoutParams.rightMargin;
            int i16 = layoutParams.topMargin;
            int i17 = layoutParams.bottomMargin;
            this.aR = i12;
            if (Math.max(Math.max(i14, i15), Math.max(i16, i17)) <= Math.max(Math.max(i10, i11), Math.max(i12, i13)) && (relativeLayout = this.f6025u) != null) {
                mBridgeVideoView = this;
                try {
                    relativeLayout.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (MBridgeVideoView.this.f6025u == null) {
                                return;
                            }
                            MBridgeVideoView.this.f6025u.setVisibility(0);
                            CampaignEx campaignEx = MBridgeVideoView.this.f5901b;
                            if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
                                return;
                            }
                            MBridgeVideoView.this.f6025u.setPadding(i10, i12, i11, i13);
                            MBridgeVideoView.this.f6025u.startAnimation(MBridgeVideoView.this.aD);
                        }
                    }, 200L);
                } catch (Exception e) {
                    e = e;
                    af.b(MBridgeBaseView.TAG, e.getMessage());
                    return;
                }
            } else {
                mBridgeVideoView = this;
            }
            if (mBridgeVideoView.f6024s.getVisibility() == 0) {
                n();
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public void setPlayURL(String str) {
        this.Q = str;
    }

    public void setPlayerViewAttachListener(a aVar) {
        this.B = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setScaleFitXY(int i10) {
        this.al = i10;
    }

    public void setShowingAlertViewCover(boolean z9) {
        MBAcquireRewardPopView mBAcquireRewardPopView;
        if (z9 && (mBAcquireRewardPopView = this.aK) != null && this.P && this.O) {
            mBAcquireRewardPopView.onPause();
        }
        this.mPlayerView.setIsCovered(z9);
    }

    public void setShowingTransparent(boolean z9) {
        this.ak = z9;
    }

    public void setSoundState(int i10) {
        this.an = i10;
    }

    public void setUnitId(String str) {
        this.W = str;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public void setVideoEvents(u3.b bVar) {
        this.ap = bVar;
        c cVar = this.aU;
        if (cVar != null) {
            cVar.f = bVar;
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            playerView.setVideoEvents(bVar);
        }
    }

    public void setVideoLayout(CampaignEx campaignEx) {
        if (campaignEx != null) {
            this.f5901b = campaignEx;
            this.h = campaignEx.isDynamicView();
        }
        if (this.h) {
            final com.mbridge.msdk.video.dynview.c cVarA = new com.mbridge.msdk.video.dynview.j.c().a(this, campaignEx);
            com.mbridge.msdk.video.dynview.b.a().a(cVarA, new com.mbridge.msdk.video.dynview.e.h() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.12
                @Override // com.mbridge.msdk.video.dynview.e.h
                public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                    af.b(MBridgeBaseView.TAG, "errorMsg：" + aVar.b());
                }

                @Override // com.mbridge.msdk.video.dynview.e.h
                public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                    if (aVar != null) {
                        if (this != null && aVar.a() != null) {
                            aVar.a().setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                            this.addView(aVar.a());
                        }
                        if (aVar.b() != null) {
                            Iterator<View> it = aVar.b().iterator();
                            while (it.hasNext()) {
                                it.next().setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.12.1
                                    @Override // com.mbridge.msdk.widget.a
                                    public final void onNoDoubleClick(View view) throws JSONException {
                                        boolean z9 = view instanceof TextView;
                                        AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                                        if (z9) {
                                            MBridgeVideoView.this.f5901b.setTriggerClickSource(1);
                                        } else {
                                            MBridgeVideoView.this.f5901b.setTriggerClickSource(2);
                                        }
                                        if (MBridgeVideoView.this.f5901b.getRewardTemplateMode() == null || MBridgeVideoView.this.f5901b.getRewardTemplateMode().f() != 902) {
                                            MBridgeVideoView.a(MBridgeVideoView.this, "video_play_click");
                                        } else {
                                            MBridgeVideoView.b(MBridgeVideoView.this);
                                        }
                                    }
                                });
                            }
                        }
                        MBridgeVideoView.this.aC = aVar.c();
                        MBridgeVideoView.this.b();
                        boolean unused = MBridgeVideoView.f6023r = false;
                        MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                        CampaignEx campaignEx2 = mBridgeVideoView.f5901b;
                        if (campaignEx2 != null) {
                            campaignEx2.setTemplateRenderSucc(mBridgeVideoView.aC);
                        }
                        MBridgeVideoView.this.K = cVarA.j();
                        MBridgeVideoView.this.L = cVarA.m();
                    }
                }
            });
            return;
        }
        int iFindLayout = findLayout("mbridge_reward_videoview_item");
        if (iFindLayout > 0) {
            this.f5902c.inflate(iFindLayout, this);
            b();
        }
        f6023r = false;
        CampaignEx campaignEx2 = this.f5901b;
        if (campaignEx2 == null || campaignEx2.getAdSpaceT() != 2 || this.tvFlag == null) {
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.tvFlag.setText("AD");
        } else {
            this.tvFlag.setText("广告");
        }
    }

    public void setVideoSkipTime(int i10) {
        this.R = i10;
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void setVisible(int i10) {
        setVisibility(i10);
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showAlertView() {
        CampaignEx campaignEx;
        if (this.af) {
            return;
        }
        if (this.V == null) {
            this.V = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.19
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    MBridgeVideoView.this.O = false;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.O);
                    if (MBridgeVideoView.this.am && (MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.I || MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.H)) {
                        MBridgeVideoView.this.av = true;
                        com.mbridge.msdk.video.module.a.a aVar = MBridgeVideoView.this.notifyListener;
                        if (aVar != null) {
                            aVar.a(124, "");
                        }
                        MBridgeVideoView.this.aA = true;
                        MBridgeVideoView.this.gonePlayingCloseView();
                    }
                    MBridgeVideoView.this.h();
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f5900a, mBridgeVideoView2.f5901b, mBridgeVideoView2.aq, MBridgeVideoView.this.W, 1, 0, 1);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    MBridgeVideoView.this.O = false;
                    MBridgeVideoView.this.aw = true;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    mBridgeVideoView.setShowingAlertViewCover(mBridgeVideoView.O);
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    com.mbridge.msdk.foundation.same.report.i.a(mBridgeVideoView2.f5900a, mBridgeVideoView2.f5901b, mBridgeVideoView2.aq, MBridgeVideoView.this.W, 1, 1, 1);
                    if (MBridgeVideoView.this.am && MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.H) {
                        MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                        if (mBridgeVideoView3.notifyListener != null) {
                            mBridgeVideoView3.aS = true;
                            MBridgeVideoView mBridgeVideoView4 = MBridgeVideoView.this;
                            mBridgeVideoView4.notifyListener.a(2, mBridgeVideoView4.b(mBridgeVideoView4.ay));
                            return;
                        }
                        return;
                    }
                    if (MBridgeVideoView.this.am && MBridgeVideoView.this.ar == com.mbridge.msdk.foundation.same.a.I) {
                        MBridgeVideoView.this.h();
                        return;
                    }
                    MBridgeVideoView mBridgeVideoView5 = MBridgeVideoView.this;
                    if (mBridgeVideoView5.notifyListener != null) {
                        mBridgeVideoView5.aS = true;
                        MBridgeVideoView.this.notifyListener.a(2, "");
                    }
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                }
            };
        }
        if (this.U == null) {
            MBAlertDialog mBAlertDialog = new MBAlertDialog(getContext(), this.V);
            this.U = mBAlertDialog;
            t3.b bVar = this.ao;
            if (bVar != null) {
                bVar.a(mBAlertDialog.getWindow().getDecorView(), t3.e.f12777c);
            }
        }
        boolean z9 = this.am;
        MBAlertDialog mBAlertDialog2 = this.U;
        if (z9) {
            mBAlertDialog2.makeIVAlertView(this.ar, this.W);
        } else {
            mBAlertDialog2.makeRVAlertView(this.W);
        }
        PlayerView playerView = this.mPlayerView;
        if (playerView != null) {
            if (playerView.isComplete() && ((campaignEx = this.f5901b) == null || campaignEx.getRewardTemplateMode() == null || this.f5901b.getRewardTemplateMode().f() != 5002010)) {
                return;
            }
            this.U.show();
            this.au = true;
            this.O = true;
            setShowingAlertViewCover(true);
            com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.W, false);
            String str = com.mbridge.msdk.videocommon.d.c.f6516a;
            this.aq = str;
            com.mbridge.msdk.foundation.same.report.i.a(this.f5900a, this.f5901b, str, this.W, 1, 1);
        }
    }

    public void showBaitClickView() {
        int i10;
        MBridgeBaitClickView mBridgeBaitClickView;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView() || this.f5901b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.f5901b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = aq.a(strE, "bait_click");
            if (TextUtils.isEmpty(strA) || (i10 = Integer.parseInt(strA)) == 0 || (mBridgeBaitClickView = this.aE) == null) {
                return;
            }
            mBridgeBaitClickView.setVisibility(0);
            this.aE.init(i10);
            this.aE.startAnimation();
            this.aE.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    if (mBridgeVideoView.notifyListener != null) {
                        mBridgeVideoView.f5901b.setTriggerClickSource(2);
                        MBridgeVideoView.a(MBridgeVideoView.this, "bait_click_clicked");
                    }
                }
            });
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showIVRewardAlertView(String str) {
        this.notifyListener.a(8, "");
    }

    public void showMoreOfferInPlayTemplate() {
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || this.M == null || !campaignEx.isDynamicView() || this.f5901b.getRewardTemplateMode() == null) {
            return;
        }
        String strE = this.f5901b.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        try {
            String strA = aq.a(strE, "mof");
            if (TextUtils.isEmpty(strA) || Integer.parseInt(strA) != 1) {
                return;
            }
            com.mbridge.msdk.video.dynview.moffer.a.a().a(this.f5901b, this, new com.mbridge.msdk.video.module.a.a.i(this.A), 1);
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void showRewardPopView() {
        AcquireRewardPopViewParameters acquireRewardPopViewParameters;
        MBAcquireRewardPopView mBAcquireRewardPopView = this.aK;
        if (mBAcquireRewardPopView == null || (acquireRewardPopViewParameters = this.aJ) == null) {
            return;
        }
        try {
            mBAcquireRewardPopView.init(acquireRewardPopViewParameters);
            this.aK.setVisibility(0);
            setCover(true);
            g();
            this.P = true;
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null) {
                campaignEx.isRewardPopViewShowed = true;
            }
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void showVideoLocation(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        float f;
        StringBuilder sbQ = a3.a.q(i10, i11, "showVideoLocation marginTop:", " marginLeft:", " width:");
        sbQ.append(i12);
        sbQ.append("  height:");
        sbQ.append(i13);
        sbQ.append(" radius:");
        sbQ.append(i14);
        sbQ.append(" borderTop:");
        sbQ.append(i15);
        sbQ.append(" borderLeft:");
        sbQ.append(i16);
        sbQ.append(" borderWidth:");
        sbQ.append(i17);
        sbQ.append(" borderHeight:");
        sbQ.append(i18);
        af.c(MBridgeBaseView.TAG, sbQ.toString());
        if (this.e) {
            this.f6025u.setPadding(0, 0, 0, 0);
            setVisibility(0);
            if (this.f6025u.getVisibility() != 0) {
                this.f6025u.setVisibility(0);
            }
            if (this.f6024s.getVisibility() == 0) {
                n();
            }
            int iF = ak.f(this.f5900a);
            int iE = ak.e(this.f5900a);
            if (i12 <= 0 || i13 <= 0 || iF < i12 || iE < i13 || this.ac) {
                k();
                return;
            }
            f6019n = i15;
            f6020o = i16;
            f6021p = i17 + 4;
            f6022q = i18 + 4;
            float f10 = i12 / i13;
            try {
                f = (float) (this.aa / this.ab);
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                f = 0.0f;
            }
            if (i14 > 0) {
                f6018m = i14;
                if (i14 > 0) {
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setCornerRadius(ak.a(getContext(), i14));
                    gradientDrawable.setColor(-1);
                    gradientDrawable.setStroke(1, 0);
                    setBackground(gradientDrawable);
                    this.mPlayerView.setBackground(gradientDrawable);
                    setClipToOutline(true);
                    this.mPlayerView.setClipToOutline(true);
                }
            }
            if (Math.abs(f10 - f) > 0.1f && this.al != 1) {
                k();
                videoOperate(1);
                return;
            }
            k();
            if (!this.ak) {
                setLayoutParam(i11, i10, i12, i13);
                return;
            }
            setLayoutCenter(i12, i13);
            boolean z9 = f6023r;
            com.mbridge.msdk.video.module.a.a aVar = this.notifyListener;
            if (z9) {
                aVar.a(114, "");
            } else {
                aVar.a(R.styleable.ConstraintSet_pathMotionArc, "");
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i10, int i11, String str) {
        com.mbridge.msdk.video.module.a.a aVar;
        SoundImageView soundImageView;
        if (this.e) {
            this.an = i10;
            if (i10 == 1) {
                SoundImageView soundImageView2 = this.mSoundImageView;
                if (soundImageView2 != null) {
                    soundImageView2.setSoundStatus(false);
                }
                this.mPlayerView.closeSound();
                try {
                    u3.b bVar = this.ap;
                    if (bVar != null) {
                        bVar.f(0.0f);
                        af.a("omsdk", "play video view:  mute");
                    }
                } catch (Exception e) {
                    af.a("OMSDK", e.getMessage());
                }
            } else if (i10 == 2) {
                SoundImageView soundImageView3 = this.mSoundImageView;
                if (soundImageView3 != null) {
                    soundImageView3.setSoundStatus(true);
                }
                this.mPlayerView.openSound();
                try {
                    u3.b bVar2 = this.ap;
                    if (bVar2 != null) {
                        bVar2.f(1.0f);
                        af.a("omsdk", "play video view:  unmute");
                    }
                } catch (Exception e3) {
                    af.a("OMSDK", e3.getMessage());
                }
            }
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null && campaignEx.isDynamicView()) {
                SoundImageView soundImageView4 = this.mSoundImageView;
                if (soundImageView4 != null) {
                    soundImageView4.setVisibility(0);
                }
            } else if (i11 == 1) {
                SoundImageView soundImageView5 = this.mSoundImageView;
                if (soundImageView5 != null) {
                    soundImageView5.setVisibility(8);
                }
            } else if (i11 == 2 && (soundImageView = this.mSoundImageView) != null) {
                soundImageView.setVisibility(0);
            }
        }
        if (str == null || !str.equals("2") || (aVar = this.notifyListener) == null) {
            return;
        }
        aVar.a(7, Integer.valueOf(i10));
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void videoOperate(int i10) {
        com.mbridge.msdk.dycreator.baseview.a.m(i10, "VideoView videoOperate:", MBridgeBaseView.TAG);
        if (this.e) {
            if (i10 == 1) {
                if (getVisibility() == 0 && isfront()) {
                    af.a(MBridgeBaseView.TAG, "VideoView videoOperate:play");
                    RelativeLayout relativeLayout = this.aO;
                    if ((relativeLayout != null && relativeLayout.getVisibility() != 0) || this.O || com.mbridge.msdk.foundation.d.b.f3437c) {
                        return;
                    }
                    if (!com.mbridge.msdk.e.b.a()) {
                        h();
                        return;
                    } else {
                        if (this.af || this.aL) {
                            return;
                        }
                        h();
                        return;
                    }
                }
                return;
            }
            if (i10 == 2) {
                if (getVisibility() == 0 && isfront()) {
                    af.a(MBridgeBaseView.TAG, "VideoView videoOperate:pause");
                    g();
                    return;
                }
                return;
            }
            if (i10 == 3) {
                if (this.ae) {
                    return;
                }
                this.mPlayerView.stop();
                CampaignEx campaignEx = this.f5901b;
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || this.f5901b.getRewardTemplateMode().f() != 5002010) {
                    this.mPlayerView.release();
                    this.ae = true;
                    e eVar = new e();
                    eVar.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
                    d.a().a("2000146", this.f5901b, eVar);
                    return;
                }
                return;
            }
            if (i10 == 5) {
                if (com.mbridge.msdk.e.b.a()) {
                    this.aL = true;
                    if (this.ae) {
                        return;
                    }
                    g();
                    return;
                }
                return;
            }
            if (i10 == 4) {
                if (com.mbridge.msdk.e.b.a()) {
                    this.aL = false;
                    if (this.ae || isMiniCardShowing()) {
                        return;
                    }
                    h();
                    return;
                }
                return;
            }
            if (i10 != 6 || this.ae) {
                return;
            }
            this.mPlayerView.release();
            this.ae = true;
            e eVar2 = new e();
            eVar2.a(TypedValues.TransitionType.S_DURATION, Long.valueOf(System.currentTimeMillis() - aQ));
            d.a().a("2000146", this.f5901b, eVar2);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        PlayerView playerView;
        boolean zF = f();
        this.e = zF;
        if (!zF) {
            af.b(MBridgeBaseView.TAG, "MBridgeVideoView init fail");
        }
        if (ah.a().a("i_l_s_t_r_i", false) && (playerView = this.mPlayerView) != null) {
            playerView.setNotifyListener(new PlayerView.OnPlayerViewVisibleListener() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.14
                @Override // com.mbridge.msdk.playercommon.PlayerView.OnPlayerViewVisibleListener
                public final void playerViewVisibleCallback() {
                    if (MBridgeVideoView.this.C) {
                        return;
                    }
                    MBridgeVideoView.this.C = true;
                    MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                    if (mBridgeVideoView.notifyListener == null || mBridgeVideoView.B == null) {
                        return;
                    }
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.notifyListener.a(20, mBridgeVideoView2.B);
                }
            });
        }
        c();
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.aD = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    public static /* synthetic */ void b(MBridgeVideoView mBridgeVideoView) {
        CampaignEx campaignEx = mBridgeVideoView.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView() || mBridgeVideoView.H == null) {
            return;
        }
        if (mBridgeVideoView.I == null) {
            mBridgeVideoView.addCTAView();
        }
        int visibility = mBridgeVideoView.H.getVisibility();
        FrameLayout frameLayout = mBridgeVideoView.H;
        if (visibility != 0) {
            frameLayout.setVisibility(0);
            mBridgeVideoView.postDelayed(mBridgeVideoView.aW, 3000L);
        } else {
            frameLayout.setVisibility(8);
            mBridgeVideoView.getHandler().removeCallbacks(mBridgeVideoView.aW);
        }
    }

    public MBridgeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCampaignSize = 1;
        this.mCurrPlayNum = 1;
        this.mCurrentPlayProgressTime = 0;
        this.mMuteSwitch = 0;
        this.C = false;
        this.F = 0;
        this.N = false;
        this.O = false;
        this.P = false;
        this.W = "";
        this.ac = false;
        this.ad = false;
        this.ae = false;
        this.af = false;
        this.ag = false;
        this.ah = false;
        this.ai = false;
        this.aj = false;
        this.ak = false;
        this.am = false;
        this.an = 2;
        this.au = false;
        this.av = false;
        this.aw = false;
        this.ax = true;
        this.ay = false;
        this.az = false;
        this.aA = false;
        this.aB = false;
        this.aC = false;
        this.aF = 0;
        this.aG = 5;
        this.aH = 5;
        this.aI = 5;
        this.aL = false;
        this.aP = false;
        this.aR = 0;
        this.aS = false;
        this.aT = false;
        this.aU = new c(this);
        this.aV = false;
        this.aW = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.1
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeVideoView.this.H != null) {
                    MBridgeVideoView.this.H.setVisibility(8);
                }
            }
        };
        this.aX = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeVideoView.13
            @Override // java.lang.Runnable
            public final void run() {
                int i10 = MBridgeVideoView.this.aG;
                MBridgeVideoView mBridgeVideoView = MBridgeVideoView.this;
                if (i10 <= 0) {
                    mBridgeVideoView.showRewardPopView();
                    MBridgeVideoView mBridgeVideoView2 = MBridgeVideoView.this;
                    mBridgeVideoView2.removeCallbacks(mBridgeVideoView2.aX);
                } else {
                    MBridgeVideoView.aa(mBridgeVideoView);
                    MBridgeVideoView mBridgeVideoView3 = MBridgeVideoView.this;
                    mBridgeVideoView3.postDelayed(mBridgeVideoView3.aX, 1000L);
                }
            }
        };
    }

    @Override // com.mbridge.msdk.video.signal.j
    public void soundOperate(int i10, int i11) {
        soundOperate(i10, i11, "2");
    }

    private String a(int i10, int i11) {
        if (i11 != 0) {
            try {
                return ak.a(Double.valueOf(i10 / i11)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i11 + "";
    }

    private void a(String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, new AnonymousClass4());
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class c extends DefaultVideoPlayerStatusListener {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeVideoView f6063a;

        /* renamed from: b, reason: collision with root package name */
        private int f6064b;

        /* renamed from: c, reason: collision with root package name */
        private int f6065c;

        /* renamed from: d, reason: collision with root package name */
        private int f6066d;
        private boolean e;
        private u3.b f;

        /* renamed from: k, reason: collision with root package name */
        private boolean f6069k;

        /* renamed from: l, reason: collision with root package name */
        private String f6070l;

        /* renamed from: m, reason: collision with root package name */
        private CampaignEx f6071m;

        /* renamed from: n, reason: collision with root package name */
        private int f6072n;

        /* renamed from: o, reason: collision with root package name */
        private int f6073o;
        private b g = new b();
        private boolean h = false;

        /* renamed from: i, reason: collision with root package name */
        private boolean f6067i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f6068j = false;

        /* renamed from: p, reason: collision with root package name */
        private boolean f6074p = false;

        public c(MBridgeVideoView mBridgeVideoView) {
            this.f6063a = mBridgeVideoView;
            if (mBridgeVideoView != null) {
                this.f6070l = mBridgeVideoView.getUnitId();
                this.f6071m = mBridgeVideoView.getCampaign();
            }
        }

        private void d() {
            MBridgeVideoView mBridgeVideoView = this.f6063a;
            if (mBridgeVideoView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mBridgeVideoView.f6024s.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -2;
                layoutParams.height = com.mbridge.msdk.dycreator.baseview.a.e(25.0f);
                this.f6063a.f6024s.setLayoutParams(layoutParams);
            }
            int iE = com.mbridge.msdk.dycreator.baseview.a.e(5.0f);
            this.f6063a.f6024s.setPadding(iE, 0, iE, 0);
        }

        public final void a(int i10, int i11) {
            int i12;
            CampaignEx campaignEx;
            String str;
            this.f6072n = i10;
            this.f6073o = i11;
            if (!ah.a().a("h_c_r_w_p_c", false) || (i12 = this.f6072n) == 100 || this.f6073o != 0 || this.f6074p || i12 == 0 || (campaignEx = this.f6071m) == null) {
                return;
            }
            try {
                if (campaignEx.getAdType() == 94 || this.f6071m.getAdType() == 287) {
                    str = this.f6071m.getRequestId() + this.f6071m.getId() + this.f6071m.getVideoUrlEncode();
                } else {
                    str = this.f6071m.getId() + this.f6071m.getVideoUrlEncode() + this.f6071m.getBidToken();
                }
                com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f6070l, str);
                if (aVarA != null) {
                    aVarA.p();
                    this.f6074p = true;
                    if (MBridgeConstans.DEBUG) {
                        af.b("DefaultVideoPlayerStatusListener", "CDRate is : 0  and start download when player create!");
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DefaultVideoPlayerStatusListener", e.getMessage());
                }
            }
        }

        public final int b() {
            return this.f6066d;
        }

        public final void c() {
            this.f6063a = null;
            boolean unused = MBridgeVideoView.f6023r = false;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                u3.b bVar = this.f;
                if (bVar != null) {
                    t3.j jVar = bVar.f12887a;
                    t1.d(jVar);
                    jVar.e.a("bufferFinish", null);
                    af.a("omsdk", "play:  videoEvents.bufferFinish()");
                }
                this.f6063a.notifyListener.a(14, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onBufferingStart(String str) {
            try {
                super.onBufferingStart(str);
                if (this.f != null) {
                    af.a("omsdk", "play:  videoEvents.bufferStart()");
                    t3.j jVar = this.f.f12887a;
                    t1.d(jVar);
                    jVar.e.a("bufferStart", null);
                }
                this.f6063a.notifyListener.a(13, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayCompleted() throws JSONException {
            MBridgeVideoView mBridgeVideoView;
            super.onPlayCompleted();
            this.f6063a.ay = true;
            CampaignEx campaignEx = this.f6071m;
            if (campaignEx != null) {
                if (this.f6069k && campaignEx.getRewardTemplateMode() != null && this.f6071m.getRewardTemplateMode().f() == 5002010) {
                    this.f6063a.f6024s.setText("0");
                } else {
                    this.f6063a.f6024s.setText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                }
                this.f6071m.setVideoPlayProgress(100);
                if (this.f6071m.getAdSpaceT() == 2) {
                    this.f6063a.t.setVisibility(4);
                    if (this.f6063a.f6028x != null) {
                        this.f6063a.f6028x.setClickable(false);
                    }
                    SoundImageView soundImageView = this.f6063a.mSoundImageView;
                    if (soundImageView != null) {
                        soundImageView.setClickable(false);
                    }
                }
            } else {
                this.f6063a.f6024s.setText("0");
            }
            u3.b bVar = this.f;
            if (bVar != null) {
                t3.j jVar = bVar.f12887a;
                t1.d(jVar);
                jVar.e.a(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, null);
                af.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f6063a.mPlayerView.setClickable(false);
            String strB = this.f6063a.b(true);
            CampaignEx campaignEx2 = this.f6071m;
            if (campaignEx2 != null && campaignEx2.getRewardTemplateMode() != null && this.f6071m.getRewardTemplateMode().f() == 5002010) {
                this.f6063a.j();
            }
            CampaignEx campaignEx3 = this.f6071m;
            if (campaignEx3 != null && campaignEx3.getDynamicTempCode() == 5 && (mBridgeVideoView = this.f6063a) != null && mBridgeVideoView.D != null) {
                MBridgeVideoView mBridgeVideoView2 = this.f6063a;
                if (mBridgeVideoView2.mCampaignSize > mBridgeVideoView2.mCurrPlayNum) {
                    HashMap map = new HashMap();
                    map.put("position", Integer.valueOf(this.f6063a.mCurrPlayNum));
                    int i10 = this.f6063a.mMuteSwitch;
                    if (i10 != 0) {
                        map.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i10));
                    }
                    this.f6063a.D.a(map);
                    return;
                }
            }
            MBridgeVideoView mBridgeVideoView3 = this.f6063a;
            if (mBridgeVideoView3 != null) {
                mBridgeVideoView3.notifyListener.a(R.styleable.ConstraintSet_transitionEasing, "");
                this.f6063a.notifyListener.a(11, strB);
            }
            int i11 = this.f6065c;
            this.f6064b = i11;
            this.f6063a.mCurrentPlayProgressTime = i11;
            boolean unused = MBridgeVideoView.f6023r = true;
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayError(String str) {
            af.b("DefaultVideoPlayerStatusListener", "errorStr" + str);
            super.onPlayError(str);
            MBridgeVideoView mBridgeVideoView = this.f6063a;
            if (mBridgeVideoView != null) {
                mBridgeVideoView.notifyListener.a(12, str);
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlayProgress(int i10, int i11) {
            int i12;
            String str;
            CampaignEx campaignEx;
            int videoCompleteTime;
            StringBuilder sb;
            String string;
            int i13;
            StringBuilder sb2;
            super.onPlayProgress(i10, i11);
            if (MBridgeVideoView.aQ == 0) {
                long unused = MBridgeVideoView.aQ = System.currentTimeMillis();
            }
            if (!this.f6063a.aT && this.f6063a.E != null) {
                this.f6063a.aT = true;
                this.f6063a.E.a();
            }
            if (this.f6063a.e) {
                CampaignEx campaignEx2 = this.f6071m;
                int i14 = 0;
                if (campaignEx2 != null) {
                    videoCompleteTime = campaignEx2.getVideoCompleteTime();
                    if (videoCompleteTime <= 0) {
                        videoCompleteTime = i11;
                    }
                    com.mbridge.msdk.foundation.d.b.a().b(this.f6071m.getCampaignUnitId() + "_1", i10);
                } else {
                    videoCompleteTime = 0;
                }
                CampaignEx campaignEx3 = this.f6071m;
                String string2 = "0";
                if (campaignEx3 != null && campaignEx3.isDynamicView() && this.f6071m.getDynamicTempCode() == 5) {
                    try {
                        int i15 = this.f6063a.F;
                        MBridgeVideoView mBridgeVideoView = this.f6063a;
                        if (mBridgeVideoView != null) {
                            String string3 = (String) mBridgeVideoView.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                            String str2 = (String) this.f6063a.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left", TypedValues.Custom.S_STRING));
                            if (videoCompleteTime >= 0) {
                                if (this.f6071m.getUseSkipTime() == 1) {
                                    int iMin = Math.min(this.f6063a.R, videoCompleteTime);
                                    if (iMin >= videoCompleteTime || iMin <= 0) {
                                        i13 = videoCompleteTime - i10;
                                        if (this.f6069k) {
                                            MBridgeVideoView mBridgeVideoView2 = this.f6063a;
                                            if (i13 <= 0) {
                                                mBridgeVideoView2.f6024s.setVisibility(4);
                                            } else {
                                                str2 = (String) mBridgeVideoView2.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING));
                                            }
                                        }
                                    } else {
                                        i13 = iMin - i10;
                                        if (i13 <= 0) {
                                            i13 = videoCompleteTime - i10;
                                            if (this.f6069k) {
                                                this.f6063a.f6024s.setVisibility(4);
                                            }
                                        } else {
                                            str2 = (String) this.f6063a.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING));
                                        }
                                    }
                                } else {
                                    i13 = videoCompleteTime - i10;
                                }
                                if (i13 > 0) {
                                    string3 = i13 + str2;
                                }
                            } else {
                                i13 = i15 - i10;
                                if (i13 <= 0) {
                                    if (videoCompleteTime <= 0) {
                                    }
                                    this.g.f6060a = i10;
                                    this.f6063a.f6024s.setText(string2);
                                    if (this.f6063a.f6027w != null && this.f6063a.f6027w.getVisibility() == 0) {
                                        this.f6063a.f6027w.setProgress(i10);
                                    }
                                    if (i13 < this.f6063a.aI && this.f6063a.aK != null && this.f6063a.P) {
                                        this.f6063a.aK.onTimeLessThanReduce(i13);
                                    }
                                } else {
                                    if (videoCompleteTime <= 0) {
                                        sb2 = new StringBuilder();
                                        sb2.append(i13);
                                        sb2.append("");
                                    } else {
                                        sb2 = new StringBuilder();
                                        sb2.append(i13);
                                        sb2.append(str2);
                                    }
                                    string3 = sb2.toString();
                                }
                            }
                            string2 = string3;
                            this.g.f6060a = i10;
                            this.f6063a.f6024s.setText(string2);
                            if (this.f6063a.f6027w != null) {
                                this.f6063a.f6027w.setProgress(i10);
                            }
                            if (i13 < this.f6063a.aI) {
                                this.f6063a.aK.onTimeLessThanReduce(i13);
                            }
                        }
                    } catch (Exception e) {
                        af.b("DefaultVideoPlayerStatusListener", e.getMessage());
                    }
                } else {
                    MBridgeVideoView mBridgeVideoView3 = this.f6063a;
                    if (mBridgeVideoView3 != null) {
                        if (this.f6069k) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(i11 - i10);
                            string = sb3.toString();
                        } else {
                            if (videoCompleteTime > i11) {
                                videoCompleteTime = i11;
                            }
                            int i16 = videoCompleteTime <= 0 ? i11 - i10 : videoCompleteTime - i10;
                            if (i16 > 0) {
                                if (videoCompleteTime <= 0) {
                                    sb = new StringBuilder();
                                    sb.append(i16);
                                    sb.append("");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append(i16);
                                    sb.append((String) this.f6063a.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left", TypedValues.Custom.S_STRING)));
                                }
                                string2 = sb.toString();
                                i14 = i16;
                            } else if (videoCompleteTime > 0) {
                                string2 = (String) mBridgeVideoView3.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_complete", TypedValues.Custom.S_STRING));
                            }
                            if (i14 < this.f6063a.aI && this.f6063a.aK != null && this.f6063a.P) {
                                this.f6063a.aK.onTimeLessThanReduce(i14);
                            }
                            string = string2;
                        }
                        CampaignEx campaignEx4 = this.f6071m;
                        if (campaignEx4 != null && campaignEx4.getUseSkipTime() == 1) {
                            int iMin2 = Math.min(this.f6063a.R, i11);
                            if (iMin2 >= videoCompleteTime || iMin2 < 0) {
                                int i17 = videoCompleteTime - i10;
                                if (this.f6069k) {
                                    if (i17 > 0) {
                                        string = i17 + ((String) this.f6063a.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING)));
                                    } else if (i17 == 0) {
                                        this.f6063a.f6024s.setVisibility(4);
                                    }
                                }
                            } else {
                                int i18 = iMin2 - i10;
                                if (i18 > 0) {
                                    string = i18 + ((String) this.f6063a.getContext().getResources().getText(x.a(com.mbridge.msdk.foundation.controller.c.m().c(), "mbridge_reward_video_view_reward_time_left_skip_time", TypedValues.Custom.S_STRING)));
                                } else if (this.f6069k && i18 == 0) {
                                    this.f6063a.f6024s.setVisibility(4);
                                }
                            }
                        }
                        this.f6063a.f6024s.setText(string);
                        if (this.f6063a.f6027w != null && this.f6063a.f6027w.getVisibility() == 0) {
                            this.f6063a.f6027w.setProgress(i10);
                        }
                    }
                    this.g.f6060a = i10;
                }
            }
            this.f6065c = i11;
            b bVar = this.g;
            bVar.f6061b = i11;
            bVar.f6062c = this.f6063a.aA;
            this.f6064b = i10;
            if (this.f6063a.y != null) {
                this.f6063a.y.setTag("" + this.f6064b);
            }
            MBridgeVideoView mBridgeVideoView4 = this.f6063a;
            mBridgeVideoView4.mCurrentPlayProgressTime = i10;
            mBridgeVideoView4.notifyListener.a(15, this.g);
            u3.b bVar2 = this.f;
            if (bVar2 != null) {
                t3.j jVar = bVar2.f12887a;
                int i19 = (i10 * 100) / i11;
                int i20 = ((i10 + 1) * 100) / i11;
                if (i19 <= 25 && 25 < i20 && !this.h) {
                    this.h = true;
                    t1.d(jVar);
                    jVar.e.a("firstQuartile", null);
                    af.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i19 <= 50 && 50 < i20 && !this.f6067i) {
                    this.f6067i = true;
                    t1.d(jVar);
                    jVar.e.a(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT, null);
                    af.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i19 <= 75 && 75 < i20 && !this.f6068j) {
                    this.f6068j = true;
                    t1.d(jVar);
                    jVar.e.a("thirdQuartile", null);
                    af.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            if (this.f6063a.am && !this.f6063a.au && this.f6063a.ar == com.mbridge.msdk.foundation.same.a.I) {
                this.f6063a.e();
            }
            try {
                MBridgeVideoView mBridgeVideoView5 = this.f6063a;
                if (mBridgeVideoView5 != null && mBridgeVideoView5.f6029z != null) {
                    int i21 = (i10 * 100) / i11;
                    this.f6063a.f6029z.setProgress(i21, this.f6063a.mCurrPlayNum - 1);
                    this.f6071m.setVideoPlayProgress(i21);
                }
                MBridgeVideoView mBridgeVideoView6 = this.f6063a;
                if (mBridgeVideoView6 != null) {
                    int i22 = mBridgeVideoView6.L;
                    MBridgeVideoView mBridgeVideoView7 = this.f6063a;
                    int i23 = i22 != -5 ? mBridgeVideoView7.L : mBridgeVideoView7.K;
                    if (i23 != -1 && i10 == i23 && (campaignEx = this.f6063a.f5901b) != null && campaignEx.isDynamicView()) {
                        this.f6063a.setCTALayoutVisibleOrGone();
                    }
                }
            } catch (Throwable th) {
                af.b("DefaultVideoPlayerStatusListener", th.getMessage());
            }
            int i24 = this.f6072n;
            if (i24 == 100 || this.f6074p || i24 == 0) {
                return;
            }
            if (this.f6073o > i24) {
                this.f6073o = i24 / 2;
            }
            int i25 = this.f6073o;
            if (i25 < 0 || i10 < (i12 = (i11 * i25) / 100)) {
                return;
            }
            if (this.f6071m.getAdType() == 94 || this.f6071m.getAdType() == 287) {
                str = this.f6071m.getRequestId() + this.f6071m.getId() + this.f6071m.getVideoUrlEncode();
            } else {
                str = this.f6071m.getId() + this.f6071m.getVideoUrlEncode() + this.f6071m.getBidToken();
            }
            com.mbridge.msdk.videocommon.download.a aVarA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f6070l, str);
            if (aVarA != null) {
                aVarA.p();
                this.f6074p = true;
                af.b("DefaultVideoPlayerStatusListener", "CDRate is : " + i12 + " and start download !");
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public final void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onPlayStarted(int r11) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeVideoView.c.onPlayStarted(int):void");
        }

        public final void a(CampaignEx campaignEx) {
            this.f6071m = campaignEx;
        }

        public final void a(boolean z9) {
            this.f6069k = z9;
        }

        public final void a(String str) {
            this.f6070l = str;
        }

        public final int a() {
            return this.f6064b;
        }
    }
}

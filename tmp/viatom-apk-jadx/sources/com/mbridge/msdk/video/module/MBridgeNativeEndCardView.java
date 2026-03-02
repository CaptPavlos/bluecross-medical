package com.mbridge.msdk.video.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.MBHeatLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.MBStarLevelLayoutView;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.dynview.widget.MBridgeLevelLayoutView;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeNativeEndCardView extends MBridgeNativeEndCardViewDiff {
    private LinearLayout A;
    private Runnable B;
    private Runnable C;
    private RelativeLayout D;
    private b E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private int J;
    private AlphaAnimation K;
    private int L;
    private int M;
    private int N;
    private int O;
    private Bitmap P;
    private View Q;
    private FeedBackButton R;
    private String S;
    private CampaignUnit T;
    private MBShakeView U;
    private com.mbridge.msdk.shake.b V;
    private MBridgeBaitClickView W;
    private boolean aa;
    private int ab;
    private String ac;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f5972m;

    /* renamed from: n, reason: collision with root package name */
    private ViewGroup f5973n;

    /* renamed from: o, reason: collision with root package name */
    private RelativeLayout f5974o;

    /* renamed from: p, reason: collision with root package name */
    private ImageView f5975p;

    /* renamed from: q, reason: collision with root package name */
    private ImageView f5976q;

    /* renamed from: r, reason: collision with root package name */
    private ImageView f5977r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f5978s;
    private TextView t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f5979u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f5980v;

    /* renamed from: w, reason: collision with root package name */
    private TextView f5981w;

    /* renamed from: x, reason: collision with root package name */
    private TextView f5982x;
    private TextView y;

    /* renamed from: z, reason: collision with root package name */
    private LinearLayout f5983z;

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet, boolean z9, int i10, boolean z10, int i11, int i12) {
        super(context, attributeSet, z9, i10, z10, i11, i12);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.aa = false;
        this.ab = 1;
    }

    public static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, int i10) throws JSONException {
        JSONException jSONException;
        JSONObject jSONObject;
        CampaignEx campaignEx = mBridgeNativeEndCardView.f5901b;
        if (campaignEx != null && campaignEx.isDynamicView()) {
            try {
                CampaignEx.c rewardTemplateMode = mBridgeNativeEndCardView.f5901b.getRewardTemplateMode();
                String str = "";
                if (rewardTemplateMode != null) {
                    str = rewardTemplateMode.f() + "";
                }
                i.a(c.m().c(), "end_card_click", mBridgeNativeEndCardView.f5901b.getCampaignUnitId(), mBridgeNativeEndCardView.f5901b.isBidCampaign(), mBridgeNativeEndCardView.f5901b.getRequestId(), mBridgeNativeEndCardView.f5901b.getRequestIdNotice(), mBridgeNativeEndCardView.f5901b.getId(), str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put(a.f3606j, mBridgeNativeEndCardView.a(i10));
                if (mBridgeNativeEndCardView.f5901b.getDynamicTempCode() == 5) {
                    jSONObject.put("camp_position", 0);
                }
            } catch (JSONException e3) {
                jSONException = e3;
                jSONObject2 = jSONObject;
                jSONException.printStackTrace();
                jSONObject = jSONObject2;
                mBridgeNativeEndCardView.f5901b.setClickTempSource(2);
                mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
            }
        } catch (JSONException e7) {
            jSONException = e7;
        }
        mBridgeNativeEndCardView.f5901b.setClickTempSource(2);
        mBridgeNativeEndCardView.notifyListener.a(105, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(View view) {
        boolean z9;
        try {
            this.f5974o = (RelativeLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_layout"));
            this.f5976q = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner"));
            this.f5977r = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_icon"));
            this.f5978s = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_flag"));
            this.t = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_flag"));
            this.f5979u = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_logo"));
            this.f5980v = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_link"));
            this.f5981w = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_apptitle"));
            this.f5983z = (LinearLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_sv_starlevel"));
            this.A = (LinearLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_sv_heat_count_level"));
            this.Q = view.findViewById(filterFindViewId(this.aa, "mbridge_iv_close"));
            this.ctaView = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_cta"));
            this.R = (FeedBackButton) view.findViewById(filterFindViewId(this.aa, "mbridge_native_endcard_feed_btn"));
            this.D = (RelativeLayout) view.findViewById(filterFindViewId(this.aa, "mbridge_native_ec_controller"));
            this.f5975p = (ImageView) view.findViewById(filterFindViewId(this.aa, "mbridge_iv_adbanner_bg"));
            this.W = (MBridgeBaitClickView) findViewById(filterFindViewId(this.aa, "mbridge_animation_click_view"));
            this.f5982x = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_appdesc"));
            if (!this.h) {
                TextView textView = (TextView) view.findViewById(filterFindViewId(this.aa, "mbridge_tv_number"));
                this.y = textView;
                z9 = false;
                try {
                    return isNotNULL(this.f5976q, this.f5977r, this.f5981w, this.f5982x, textView, this.f5983z, this.Q, this.ctaView);
                } catch (Throwable th) {
                    th = th;
                    af.b(MBridgeBaseView.TAG, th.getMessage(), th);
                    return z9;
                }
            }
            ImageView imageView = this.f5976q;
            if (imageView != null && (imageView instanceof RoundImageView)) {
                ((RoundImageView) imageView).setBorderRadius(10);
            }
            ImageView imageView2 = this.f5977r;
            if (imageView2 != null && (imageView2 instanceof RoundImageView)) {
                ((RoundImageView) imageView2).setBorderRadius(10);
            }
            return isNotNULL(this.f5976q, this.f5977r, this.f5981w, this.f5983z, this.Q, this.ctaView);
        } catch (Throwable th2) {
            th = th2;
            z9 = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int e() {
        /*
            r6 = this;
            int r0 = r6.f5906k
            java.lang.String r1 = "mbridge_reward_endcard_native_land"
            java.lang.String r2 = "mbridge_reward_endcard_native_half_landscape"
            java.lang.String r3 = "mbridge_reward_endcard_native_hor"
            java.lang.String r4 = "mbridge_reward_endcard_native_half_portrait"
            if (r0 != 0) goto L1e
            boolean r0 = r6.f5905j
            if (r0 == 0) goto L11
            r3 = r4
        L11:
            boolean r0 = r6.isLandscape()
            if (r0 == 0) goto L31
            boolean r0 = r6.f5905j
            if (r0 == 0) goto L1c
        L1b:
            r1 = r2
        L1c:
            r3 = r1
            goto L31
        L1e:
            r5 = 1
            if (r0 != r5) goto L27
            boolean r5 = r6.f5905j
            if (r5 == 0) goto L29
            r3 = r4
            goto L29
        L27:
            java.lang.String r3 = ""
        L29:
            r4 = 2
            if (r0 != r4) goto L31
            boolean r0 = r6.f5905j
            if (r0 == 0) goto L1c
            goto L1b
        L31:
            int r0 = r6.findLayout(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.e():int");
    }

    private void f() {
        RelativeLayout relativeLayout;
        if (!this.e || (relativeLayout = this.D) == null) {
            return;
        }
        relativeLayout.postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (MBridgeNativeEndCardView.this.D != null) {
                    CampaignEx campaignEx = MBridgeNativeEndCardView.this.f5901b;
                    if (campaignEx != null && !campaignEx.isDynamicView() && MBridgeNativeEndCardView.this.f5901b.getAdSpaceT() != 2) {
                        MBridgeNativeEndCardView.this.D.setPadding(MBridgeNativeEndCardView.this.L, MBridgeNativeEndCardView.this.N, MBridgeNativeEndCardView.this.M, MBridgeNativeEndCardView.this.O);
                        MBridgeNativeEndCardView.this.D.startAnimation(MBridgeNativeEndCardView.this.K);
                    }
                    MBridgeNativeEndCardView.this.D.setVisibility(0);
                }
                if (MBridgeNativeEndCardView.this.Q != null && MBridgeNativeEndCardView.this.Q.getVisibility() != 0 && MBridgeNativeEndCardView.this.G) {
                    MBridgeNativeEndCardView.this.Q.setVisibility(0);
                }
                MBridgeNativeEndCardView.p(MBridgeNativeEndCardView.this);
            }
        }, 200L);
    }

    public static /* synthetic */ void p(MBridgeNativeEndCardView mBridgeNativeEndCardView) {
        CampaignEx campaignEx = mBridgeNativeEndCardView.f5901b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(mBridgeNativeEndCardView.S);
            com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), mBridgeNativeEndCardView.S, "_2"), mBridgeNativeEndCardView.f5901b);
        }
        if (!com.mbridge.msdk.foundation.d.b.a().b()) {
            FeedBackButton feedBackButton = mBridgeNativeEndCardView.R;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
                return;
            }
            return;
        }
        com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), mBridgeNativeEndCardView.S, "_2"), new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.4
            @Override // com.mbridge.msdk.foundation.d.a
            public final void close() {
                MBridgeNativeEndCardView.this.I = false;
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void showed() {
                MBridgeNativeEndCardView.this.I = true;
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void summit(String str) {
                MBridgeNativeEndCardView.this.I = false;
            }
        });
        com.mbridge.msdk.foundation.d.b.a().c(mBridgeNativeEndCardView.S + "_1");
        if (mBridgeNativeEndCardView.R != null) {
            com.mbridge.msdk.foundation.d.b.a().a(a3.a.o(new StringBuilder(), mBridgeNativeEndCardView.S, "_2"), mBridgeNativeEndCardView.R);
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
            RenderScript renderScriptCreate = RenderScript.create(this.f5900a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(25.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        if (this.e) {
            this.f5974o.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    if (MBridgeNativeEndCardView.this.F) {
                        MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 1);
                    }
                }
            });
            this.Q.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (MBridgeNativeEndCardView.this.h) {
                        try {
                            com.mbridge.msdk.video.dynview.moffer.a.a().b();
                        } catch (Exception e) {
                            af.b(MBridgeBaseView.TAG, e.getMessage());
                        }
                        try {
                            CampaignEx campaignEx = MBridgeNativeEndCardView.this.f5901b;
                            if (campaignEx != null) {
                                String strA = aq.a(campaignEx.getendcard_url(), "ecid");
                                String strA2 = aq.a(MBridgeNativeEndCardView.this.f5901b.getendcard_url(), "mof");
                                e eVar = new e();
                                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "choseFromTwoClose");
                                eVar.a("endcard_id", strA);
                                eVar.a("mof", strA2);
                                com.mbridge.msdk.video.module.b.a.a("2000103", MBridgeNativeEndCardView.this.f5901b, eVar);
                            }
                        } catch (Exception e3) {
                            if (MBridgeConstans.DEBUG) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    try {
                        e eVar2 = new e();
                        eVar2.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
                        d.a().a("2000152", eVar2);
                        d.a().a("2000134", MBridgeNativeEndCardView.this.f5901b);
                    } catch (Throwable th) {
                        if (MBridgeConstans.DEBUG) {
                            th.printStackTrace();
                        }
                    }
                    MBridgeNativeEndCardView.this.notifyListener.a(104, "");
                }
            });
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.16
                    @Override // com.mbridge.msdk.widget.a
                    public final void onNoDoubleClick(View view) throws JSONException {
                        MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(1);
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                    }
                });
            }
            this.f5977r.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.17
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    if (MBridgeNativeEndCardView.this.ctaView != null) {
                        if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                            MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    }
                }
            });
            this.f5976q.setOnClickListener(new com.mbridge.msdk.widget.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.2
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    if (MBridgeNativeEndCardView.this.ctaView != null) {
                        if (!com.mbridge.msdk.e.b.a() || MBridgeNativeEndCardView.this.checkProgressBarIntercepted()) {
                            MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    }
                }
            });
        }
    }

    public boolean canBackPress() {
        View view = this.Q;
        return view != null && view.getVisibility() == 0;
    }

    public void clearMoreOfferBitmap() {
        CampaignUnit campaignUnit;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView() || (campaignUnit = this.T) == null || campaignUnit.getAds() == null || this.T.getAds().size() <= 0) {
            return;
        }
        ArrayList<CampaignEx> ads = this.T.getAds();
        int size = ads.size();
        int i10 = 0;
        while (i10 < size) {
            CampaignEx campaignEx2 = ads.get(i10);
            i10++;
            CampaignEx campaignEx3 = campaignEx2;
            if (!TextUtils.isEmpty(campaignEx3.getIconUrl())) {
                com.mbridge.msdk.foundation.same.c.b.a(c.m().c());
                campaignEx3.getIconUrl();
            }
        }
    }

    public boolean isDyXmlSuccess() {
        return this.aa;
    }

    public void notifyShowListener() {
        this.notifyListener.a(110, "");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i10;
        int i11;
        int i12;
        MBridgeBaitClickView mBridgeBaitClickView;
        super.onAttachedToWindow();
        if (this.B == null) {
            this.B = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeNativeEndCardView.this.G = true;
                    if (MBridgeNativeEndCardView.this.Q != null) {
                        MBridgeNativeEndCardView.this.Q.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.B;
        if (runnable != null) {
            postDelayed(runnable, this.J * 1000);
            if (!this.H) {
                this.H = true;
            }
            try {
                CampaignEx campaignEx = this.f5901b;
                if (campaignEx != null && campaignEx.isDynamicView()) {
                    String endScreenUrl = this.f5901b.getendcard_url();
                    if (TextUtils.isEmpty(endScreenUrl)) {
                        endScreenUrl = this.f5901b.getEndScreenUrl();
                    }
                    String strA = aq.a(endScreenUrl, "alac");
                    if (!TextUtils.isEmpty(strA) && strA.equals("1") && this.f5901b.getAutoShowStoreMiniCard() != 1) {
                        postDelayed(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.8
                            @Override // java.lang.Runnable
                            public final void run() throws JSONException {
                                MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                                MBridgeNativeEndCardView.this.f5901b.setClickType(1);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                            }
                        }, 1000L);
                    }
                }
            } catch (Throwable th) {
                af.b(MBridgeBaseView.TAG, th.getMessage());
            }
        }
        try {
            CampaignEx campaignEx2 = this.f5901b;
            if (campaignEx2 != null && campaignEx2.isDynamicView()) {
                String endScreenUrl2 = this.f5901b.getendcard_url();
                if (TextUtils.isEmpty(endScreenUrl2)) {
                    endScreenUrl2 = this.f5901b.getEndScreenUrl();
                }
                String strA2 = aq.a(endScreenUrl2, "bait_click");
                try {
                    i12 = Integer.parseInt(strA2);
                } catch (Throwable th2) {
                    af.b(MBridgeBaseView.TAG, th2.getMessage());
                    i12 = 1;
                }
                if (!TextUtils.isEmpty(strA2) && i12 != 0 && (mBridgeBaitClickView = this.W) != null) {
                    mBridgeBaitClickView.setVisibility(0);
                    this.W.init(1342177280, i12);
                    if (this.f5901b.getEcTemplateId() == 1302) {
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setShape(0);
                        gradientDrawable.setColor(1342177280);
                        gradientDrawable.setStroke(0, SupportMenu.CATEGORY_MASK);
                        gradientDrawable.setCornerRadius(25.0f);
                        this.W.setBackground(gradientDrawable);
                    }
                    this.W.startAnimation();
                    this.W.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) throws JSONException {
                            MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                        }
                    });
                }
            }
        } catch (Throwable th3) {
            af.b(MBridgeBaseView.TAG, th3.getMessage());
        }
        try {
            CampaignEx campaignEx3 = this.f5901b;
            if (campaignEx3 != null && campaignEx3.isDynamicView()) {
                String endScreenUrl3 = this.f5901b.getendcard_url();
                if (TextUtils.isEmpty(endScreenUrl3)) {
                    endScreenUrl3 = this.f5901b.getEndScreenUrl();
                }
                String strA3 = aq.a(endScreenUrl3, "shake_show");
                String strA4 = aq.a(endScreenUrl3, "shake_strength");
                String strA5 = aq.a(endScreenUrl3, "shake_time");
                if (!TextUtils.isEmpty(strA3) && strA3.equals("1") && this.U == null) {
                    MBridgeBaitClickView mBridgeBaitClickView2 = this.W;
                    if (mBridgeBaitClickView2 != null) {
                        mBridgeBaitClickView2.setVisibility(8);
                    }
                    MBShakeView mBShakeView = new MBShakeView(getContext());
                    this.U = mBShakeView;
                    mBShakeView.initView(this.f5901b.getAdCall(), true);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    if (isLandscape()) {
                        layoutParams.addRule(13);
                    } else {
                        layoutParams.addRule(2, filterFindViewId(this.aa, "mbridge_iv_logo"));
                        layoutParams.addRule(14);
                        this.U.setPadding(0, 0, 0, ak.a(getContext(), 20.0f));
                    }
                    this.U.setLayoutParams(layoutParams);
                    RelativeLayout relativeLayout = this.f5974o;
                    if (relativeLayout != null && relativeLayout.isShown()) {
                        this.f5974o.addView(this.U);
                        TextView textView = this.ctaView;
                        if (textView != null) {
                            textView.setVisibility(4);
                        }
                        this.U.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.5
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) throws JSONException {
                                MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(5);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 0);
                            }
                        });
                        int i13 = 10;
                        if (!TextUtils.isEmpty(strA4) && (i11 = Integer.parseInt(strA4)) > 0) {
                            i13 = i11;
                        }
                        boolean zIsEmpty = TextUtils.isEmpty(strA5);
                        int i14 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
                        if (!zIsEmpty && (i10 = Integer.parseInt(strA5)) > 0) {
                            i14 = i10 * 1000;
                        }
                        this.V = new com.mbridge.msdk.shake.b(i13, i14) { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.6
                            @Override // com.mbridge.msdk.shake.b
                            public final void a() throws JSONException {
                                if ((com.mbridge.msdk.e.b.a() && MBridgeNativeEndCardView.this.checkChinaShakeState()) || MBridgeNativeEndCardView.this.I || !MBridgeNativeEndCardView.this.H) {
                                    return;
                                }
                                MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                                mBridgeNativeEndCardView.f = 0.0f;
                                mBridgeNativeEndCardView.g = 0.0f;
                                mBridgeNativeEndCardView.f5901b.setTriggerClickSource(5);
                                MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 4);
                            }
                        };
                        com.mbridge.msdk.shake.a.a().a(this.V);
                    }
                }
            }
        } catch (Throwable th4) {
            af.b(MBridgeBaseView.TAG, th4.getMessage());
        }
        try {
            CampaignEx campaignEx4 = this.f5901b;
            if (campaignEx4 != null && campaignEx4.getAutoShowStoreMiniCard() != 0 && !TextUtils.isEmpty(this.f5901b.getDeepLinkURL())) {
                long showStoreMiniCardDelayTime = this.f5901b.getShowStoreMiniCardDelayTime();
                if (showStoreMiniCardDelayTime == 0) {
                    showStoreMiniCardDelayTime = 1;
                }
                if (this.C == null) {
                    this.C = new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.9
                        @Override // java.lang.Runnable
                        public final void run() throws JSONException {
                            MBridgeNativeEndCardView.this.f5901b.setTriggerClickSource(2);
                            MBridgeNativeEndCardView.this.f5901b.setClickType(1);
                            MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, 2);
                        }
                    };
                }
                postDelayed(this.C, showStoreMiniCardDelayTime * 1000);
            }
        } catch (Throwable th5) {
            af.b(MBridgeBaseView.TAG, th5.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.B;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.C;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        if (this.V != null) {
            com.mbridge.msdk.shake.a.a().b(this.V);
            this.V = null;
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            RelativeLayout relativeLayout = this.D;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(4);
            }
            int i10 = configuration.orientation;
            this.f5903d = i10;
            if (i10 == 2) {
                removeView(this.f5972m);
                a(this.f5973n);
            } else {
                removeView(this.f5973n);
                a(this.f5972m);
            }
        }
    }

    public void preLoadData(b bVar) {
        this.E = bVar;
        try {
            if (this.f5901b == null || !this.e) {
                return;
            }
            com.mbridge.msdk.foundation.same.c.b.a(this.f5900a.getApplicationContext()).a(this.f5901b.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.11
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap == null || bitmap.isRecycled()) {
                        return;
                    }
                    try {
                        if (MBridgeNativeEndCardView.this.f5976q != null) {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                            if (mBridgeNativeEndCardView.h) {
                                mBridgeNativeEndCardView.f5976q.setBackground(null);
                            }
                            MBridgeNativeEndCardView.this.f5976q.setImageBitmap(bitmap);
                        }
                        MBridgeNativeEndCardView.a(MBridgeNativeEndCardView.this, bitmap);
                    } catch (Throwable unused) {
                        if (MBridgeNativeEndCardView.this.f5975p != null) {
                            MBridgeNativeEndCardView.this.f5975p.setVisibility(4);
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }
            });
            com.mbridge.msdk.foundation.same.c.b.a(this.f5900a.getApplicationContext()).a(this.f5901b.getIconUrl(), new j(this.f5977r, ak.a(c.m().c(), 8.0f)));
            this.f5981w.setText(this.f5901b.getAppName());
            TextView textView = this.ctaView;
            if (textView != null) {
                textView.setText(this.f5901b.getAdCall());
            }
            TextView textView2 = this.f5982x;
            if (textView2 != null) {
                textView2.setText(this.f5901b.getAppDesc());
            }
            TextView textView3 = this.y;
            if (textView3 != null) {
                textView3.setText(this.f5901b.getNumberRating() + ")");
            }
            this.f5983z.removeAllViews();
            double rating = this.f5901b.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            LinearLayout linearLayout = this.f5983z;
            if (linearLayout instanceof StarLevelView) {
                ((StarLevelView) linearLayout).initScore(rating);
            }
            LinearLayout linearLayout2 = this.f5983z;
            if (linearLayout2 instanceof MBridgeLevelLayoutView) {
                ((MBridgeLevelLayoutView) linearLayout2).setRatingAndUser(rating, this.f5901b.getNumberRating());
            }
            LinearLayout linearLayout3 = this.f5983z;
            if (linearLayout3 instanceof MBStarLevelLayoutView) {
                ((MBStarLevelLayoutView) linearLayout3).setRating((int) rating);
            }
            LinearLayout linearLayout4 = this.A;
            if (linearLayout4 != null && (linearLayout4 instanceof MBHeatLevelLayoutView)) {
                ((MBHeatLevelLayoutView) linearLayout4).setHeatCount(this.f5901b.getNumberRating());
            }
            if (!TextUtils.isEmpty(this.f5901b.getendcard_url()) && this.f5901b.getendcard_url().contains("alecfc=1")) {
                this.F = true;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f5978s.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", c.m().g())));
                this.ac = "AD";
            } else {
                this.f5978s.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", c.m().g())));
                this.ac = "广告";
            }
            if (this.ab == 0) {
                ImageView imageView = this.f5978s;
                if (imageView != null) {
                    imageView.setVisibility(4);
                }
                ImageView imageView2 = this.f5979u;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
                TextView textView4 = this.t;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    this.t.setText(this.ac);
                }
            }
            ak.a(2, this.f5980v, this.f5901b, this.f5900a, true, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.12
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    MBridgeNativeEndCardView.this.I = false;
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    MBridgeNativeEndCardView.this.I = true;
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    MBridgeNativeEndCardView.this.I = false;
                }
            });
            if (this.G) {
                return;
            }
            this.Q.setVisibility(8);
        } catch (Throwable th) {
            af.a(MBridgeBaseView.TAG, th.getMessage());
        }
    }

    public void release() {
        try {
            removeAllViews();
            AlphaAnimation alphaAnimation = this.K;
            if (alphaAnimation != null) {
                alphaAnimation.cancel();
            }
            this.B = null;
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    public void setCloseBtnDelay(int i10) {
        this.J = i10;
    }

    public void setLayout() {
        if (!this.h) {
            a();
            return;
        }
        com.mbridge.msdk.video.dynview.c cVarA = new com.mbridge.msdk.video.dynview.j.c().a(getContext(), this.f5901b, this.f5904i, com.mbridge.msdk.e.b.a() ? "cn_" : "en_");
        this.ab = cVarA.n();
        com.mbridge.msdk.video.dynview.b.a().a(cVarA, new h() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.10
            @Override // com.mbridge.msdk.video.dynview.e.h
            public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                af.b(MBridgeBaseView.TAG, "errorMsg:" + aVar.b());
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    MBridgeNativeEndCardView.this.addView(aVar.a());
                    MBridgeNativeEndCardView.this.aa = aVar.c();
                    boolean zCtaViewCanGet = MBridgeNativeEndCardView.this.ctaViewCanGet(aVar.a(), MBridgeNativeEndCardView.this.aa);
                    MBridgeNativeEndCardView mBridgeNativeEndCardView = MBridgeNativeEndCardView.this;
                    if (zCtaViewCanGet) {
                        mBridgeNativeEndCardView.e = mBridgeNativeEndCardView.b(aVar.a());
                        MBridgeNativeEndCardView.this.b();
                    } else {
                        mBridgeNativeEndCardView.aa = false;
                        MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                        mBridgeNativeEndCardView2.h = false;
                        mBridgeNativeEndCardView2.a();
                    }
                    MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                    CampaignEx campaignEx = mBridgeNativeEndCardView3.f5901b;
                    if (campaignEx != null) {
                        campaignEx.setECTemplateRenderSucc(mBridgeNativeEndCardView3.aa);
                    }
                }
            }
        });
    }

    public void setMoreOfferCampaignUnit(CampaignUnit campaignUnit) {
        MBShakeView mBShakeView;
        CampaignEx campaignEx = this.f5901b;
        if (campaignEx == null || !campaignEx.isDynamicView()) {
            return;
        }
        this.T = campaignUnit;
        if (campaignUnit == null || campaignUnit.getAds() == null || this.T.getAds().size() <= 5 || (mBShakeView = this.U) == null) {
            return;
        }
        mBShakeView.setPadding(0, 0, 0, ak.a(getContext(), 5.0f));
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13) {
        af.b(MBridgeBaseView.TAG, "NOTCH NativeEndCard ".concat(String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13))));
        this.L = i10;
        this.M = i11;
        this.N = i12;
        this.O = i13;
        f();
    }

    public void setOnPause() {
        this.H = false;
    }

    public void setOnResume() {
        this.H = true;
    }

    public void setUnitId(String str) {
        this.S = str;
    }

    public MBridgeNativeEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.aa = false;
        this.ab = 1;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
    }

    public MBridgeNativeEndCardView(Context context) {
        super(context);
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = 0;
        this.aa = false;
        this.ab = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int iE = e();
        if (iE > 0) {
            this.e = b(iE);
            b();
            CampaignEx campaignEx = this.f5901b;
            if (campaignEx != null) {
                campaignEx.setECTemplateRenderSucc(false);
            }
        }
    }

    private void a(View view) {
        if (view == null) {
            setLayout();
            preLoadData(this.E);
        } else {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            addView(view);
            b(view);
            c();
        }
        f();
    }

    public static /* synthetic */ void a(MBridgeNativeEndCardView mBridgeNativeEndCardView, final Bitmap bitmap) {
        try {
            com.mbridge.msdk.foundation.same.f.a.d().execute(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.13
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeNativeEndCardView mBridgeNativeEndCardView2 = MBridgeNativeEndCardView.this;
                    mBridgeNativeEndCardView2.P = mBridgeNativeEndCardView2.blurBitmap(bitmap);
                    if (MBridgeNativeEndCardView.this.P == null || MBridgeNativeEndCardView.this.P.isRecycled() || MBridgeNativeEndCardView.this.f5975p == null) {
                        return;
                    }
                    MBridgeNativeEndCardView.this.f5975p.post(new Runnable() { // from class: com.mbridge.msdk.video.module.MBridgeNativeEndCardView.13.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            MBridgeNativeEndCardView mBridgeNativeEndCardView3 = MBridgeNativeEndCardView.this;
                            if (mBridgeNativeEndCardView3.h) {
                                mBridgeNativeEndCardView3.f5975p.setBackground(null);
                            }
                            af.b("async", "执行异步加载图");
                            MBridgeNativeEndCardView.this.f5975p.setImageBitmap(MBridgeNativeEndCardView.this.P);
                        }
                    });
                }
            });
        } catch (Exception e) {
            af.a(MBridgeBaseView.TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        c();
        if (!this.e) {
            this.notifyListener.a(104, "");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 100.0f);
        this.K = alphaAnimation;
        alphaAnimation.setDuration(200L);
    }

    private boolean b(int i10) {
        boolean zIsLandscape = isLandscape();
        LayoutInflater layoutInflater = this.f5902c;
        if (zIsLandscape) {
            ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(i10, (ViewGroup) null);
            this.f5973n = viewGroup;
            addView(viewGroup);
            return b(this.f5973n);
        }
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(i10, (ViewGroup) null);
        this.f5972m = viewGroup2;
        addView(viewGroup2);
        return b(this.f5972m);
    }
}

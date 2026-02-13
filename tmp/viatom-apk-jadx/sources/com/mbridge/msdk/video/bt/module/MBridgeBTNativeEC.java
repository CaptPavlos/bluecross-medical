package com.mbridge.msdk.video.bt.module;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.video.bt.a.d;
import com.mbridge.msdk.video.module.a.a.e;
import com.mbridge.msdk.video.module.a.a.j;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.videocommon.d.c;
import com.mbridge.msdk.videocommon.view.RoundImageView;
import com.mbridge.msdk.videocommon.view.StarLevelView;
import com.mbridge.msdk.widget.a;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeBTNativeEC extends MBridgeBTNativeECDiff {
    private TextView A;
    private StarLevelView B;
    private boolean C;
    private boolean D;
    private int E;
    private Runnable F;
    private boolean G;
    private View H;
    private String I;
    private k J;
    private WebView K;

    /* renamed from: p, reason: collision with root package name */
    private ViewGroup f5614p;

    /* renamed from: q, reason: collision with root package name */
    private ViewGroup f5615q;

    /* renamed from: r, reason: collision with root package name */
    private RelativeLayout f5616r;

    /* renamed from: s, reason: collision with root package name */
    private ImageView f5617s;
    private RoundImageView t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f5618u;

    /* renamed from: v, reason: collision with root package name */
    private ImageView f5619v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView f5620w;

    /* renamed from: x, reason: collision with root package name */
    private ImageView f5621x;
    private TextView y;

    /* renamed from: z, reason: collision with root package name */
    private TextView f5622z;

    public MBridgeBTNativeEC(Context context) {
        super(context);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    public static /* synthetic */ void a(MBridgeBTNativeEC mBridgeBTNativeEC, float f, float f10) throws JSONException {
        if (mBridgeBTNativeEC.K != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("code", BTBaseView.f5565n);
                jSONObject.put("id", mBridgeBTNativeEC.f5570d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", String.valueOf(f));
                jSONObject2.put("y", String.valueOf(f10));
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                g.a().a(mBridgeBTNativeEC.K, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Exception unused) {
                d.c().a(mBridgeBTNativeEC.K, "onClicked", mBridgeBTNativeEC.f5570d);
            }
        }
    }

    private boolean b(View view) {
        try {
            this.f5616r = (RelativeLayout) view.findViewById(findID("mbridge_native_ec_layout"));
            this.f5617s = (ImageView) view.findViewById(findID("mbridge_iv_adbanner_bg"));
            this.t = (RoundImageView) view.findViewById(findID("mbridge_iv_adbanner"));
            this.f5618u = (ImageView) view.findViewById(findID("mbridge_iv_icon"));
            this.f5619v = (ImageView) view.findViewById(findID("mbridge_iv_flag"));
            this.f5620w = (ImageView) view.findViewById(findID("mbridge_iv_link"));
            this.y = (TextView) view.findViewById(findID("mbridge_tv_apptitle"));
            this.f5622z = (TextView) view.findViewById(findID("mbridge_tv_appdesc"));
            this.A = (TextView) view.findViewById(findID("mbridge_tv_number"));
            this.B = (StarLevelView) view.findViewById(findID("mbridge_sv_starlevel"));
            this.H = view.findViewById(findID("mbridge_iv_close"));
            this.ctaView = view.findViewById(findID("mbridge_tv_cta"));
            this.f5621x = (ImageView) view.findViewById(findID("mbridge_iv_logo"));
            return isNotNULL(this.f5617s, this.t, this.f5618u, this.y, this.f5622z, this.A, this.B, this.H, this.ctaView);
        } catch (Throwable th) {
            af.b(BTBaseView.TAG, th.getMessage(), th);
            return false;
        }
    }

    @TargetApi(17)
    public Bitmap blurBitmap(Bitmap bitmap) {
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            RenderScript renderScriptCreate = RenderScript.create(this.f5567a.getApplicationContext());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(10.0f);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            bitmap.recycle();
            renderScriptCreate.destroy();
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        boolean zB;
        int iFindLayout = findLayout(isLandscape() ? "mbridge_reward_endcard_native_land" : "mbridge_reward_endcard_native_hor");
        if (iFindLayout > 0) {
            boolean zIsLandscape = isLandscape();
            LayoutInflater layoutInflater = this.f;
            if (zIsLandscape) {
                ViewGroup viewGroup = (ViewGroup) layoutInflater.inflate(iFindLayout, (ViewGroup) null);
                this.f5615q = viewGroup;
                addView(viewGroup);
                zB = b(this.f5615q);
            } else {
                ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(iFindLayout, (ViewGroup) null);
                this.f5614p = viewGroup2;
                addView(viewGroup2);
                zB = b(this.f5614p);
            }
            this.h = zB;
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws JSONException {
        super.onAttachedToWindow();
        if (this.F == null) {
            this.F = new Runnable() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.1
                @Override // java.lang.Runnable
                public final void run() {
                    MBridgeBTNativeEC.this.D = true;
                    if (MBridgeBTNativeEC.this.H != null) {
                        MBridgeBTNativeEC.this.H.setVisibility(0);
                    }
                }
            };
        }
        Runnable runnable = this.F;
        if (runnable != null) {
            postDelayed(runnable, this.E * 1000);
        }
        if (!this.h && this.K != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f5570d);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.I);
                jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                af.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
            } catch (JSONException e) {
                af.a(BTBaseView.TAG, e.getMessage());
            }
            g.a().a(this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        }
        if (this.K != null) {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", this.f5570d);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, this.I);
                jSONObject3.put(DataSchemeDataSource.SCHEME_DATA, jSONObject4);
                af.a(BTBaseView.TAG, "NativeEC Call H5 onEndCardShow " + jSONObject3.toString());
            } catch (JSONException e3) {
                af.a(BTBaseView.TAG, e3.getMessage());
            }
            g.a().a(this.K, "onNativeECShow", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.F;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        int i10 = configuration.orientation;
        this.g = i10;
        if (i10 == 2) {
            removeView(this.f5614p);
            a(this.f5615q);
        } else {
            removeView(this.f5615q);
            a(this.f5614p);
        }
    }

    public void preLoadData() {
        Bitmap bitmapBlurBitmap;
        try {
            CampaignEx campaignEx = this.f5568b;
            if (campaignEx == null || !this.h) {
                return;
            }
            if (campaignEx.getCbd() > -2) {
                this.E = this.f5568b.getCbd();
            } else {
                c cVar = this.e;
                if (cVar != null) {
                    this.E = cVar.p();
                }
            }
            b.a(this.f5567a.getApplicationContext()).a(this.f5568b.getImageUrl(), new e(this.t, this.f5568b, this.I));
            b.a(this.f5567a.getApplicationContext()).a(this.f5568b.getIconUrl(), new j(this.f5618u, ak.a(com.mbridge.msdk.foundation.controller.c.m().c(), 8.0f)));
            this.y.setText(this.f5568b.getAppName());
            this.f5622z.setText(this.f5568b.getAppDesc());
            this.A.setText(this.f5568b.getNumberRating() + ")");
            this.B.removeAllViews();
            if (com.mbridge.msdk.e.b.a()) {
                setChinaCTAData(this.f5568b);
            }
            double rating = this.f5568b.getRating();
            if (rating <= 0.0d) {
                rating = 5.0d;
            }
            this.B.initScore(rating);
            try {
                Bitmap bitmapA = a(this.t.getDrawable());
                if (bitmapA != null && (bitmapBlurBitmap = blurBitmap(bitmapA)) != null) {
                    this.f5617s.setImageBitmap(bitmapBlurBitmap);
                }
            } catch (Throwable unused) {
                this.f5617s.setVisibility(8);
            }
            if (!TextUtils.isEmpty(this.f5568b.getendcard_url()) && this.f5568b.getendcard_url().contains("alecfc=1")) {
                this.C = true;
            }
            if (!TextUtils.isEmpty(this.f5568b.getendcard_url()) && this.f5568b.getendcard_url().contains("wlgo=1")) {
                this.G = true;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.f5619v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_en", "drawable", com.mbridge.msdk.foundation.controller.c.m().g())));
            } else {
                this.f5619v.setImageDrawable(getResources().getDrawable(getResources().getIdentifier("mbridge_reward_flag_cn", "drawable", com.mbridge.msdk.foundation.controller.c.m().g())));
            }
            if (!this.G) {
                this.f5619v.setVisibility(4);
                this.f5621x.setVisibility(4);
            }
            ak.a(2, this.f5620w, this.f5568b, this.f5567a, true, null);
            if (this.D) {
                return;
            }
            this.H.setVisibility(8);
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
        }
    }

    public void setCreateWebView(WebView webView) {
        this.K = webView;
    }

    public void setJSCommon(k kVar) {
        this.J = kVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setUnitId(String str) {
        this.I = str;
    }

    public MBridgeBTNativeEC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = false;
        this.D = false;
        this.E = 0;
        this.G = false;
    }

    @Override // com.mbridge.msdk.video.bt.module.MBridgeBTNativeECDiff, com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
    }

    private void a(View view) {
        if (view == null) {
            init(this.f5567a);
            preLoadData();
            return;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        addView(view);
        b(view);
        a();
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public final void a() {
        if (this.h) {
            this.f5616r.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    if (MBridgeBTNativeEC.this.C) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 1, view.getContext());
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                    }
                }
            });
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    if (MBridgeBTNativeEC.this.K != null) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("id", MBridgeBTNativeEC.this.f5570d);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, MBridgeBTNativeEC.this.I);
                            jSONObject.put(DataSchemeDataSource.SCHEME_DATA, jSONObject2);
                            af.a(BTBaseView.TAG, "NativeEC Call H5 onCloseBtnClicked " + jSONObject.toString());
                        } catch (JSONException e) {
                            af.a(BTBaseView.TAG, e.getMessage());
                        }
                        g.a().a(MBridgeBTNativeEC.this.K, "onCloseBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    }
                }
            });
            this.ctaView.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.4
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.f5618u.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.5
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    if (!com.mbridge.msdk.e.b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
            this.t.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.6
                @Override // com.mbridge.msdk.widget.a
                public final void onNoDoubleClick(View view) throws JSONException {
                    if (!com.mbridge.msdk.e.b.a() || MBridgeBTNativeEC.this.checkChinaProgressBarStatus()) {
                        MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, 0, view.getContext());
                    }
                    MBridgeBTNativeEC.a(MBridgeBTNativeEC.this, view.getX(), view.getY());
                }
            });
        }
    }

    private Bitmap a(Drawable drawable) {
        try {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            af.a(BTBaseView.TAG, th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001c A[Catch: all -> 0x0037, TryCatch #1 {all -> 0x0037, blocks: (B:3:0x0001, B:4:0x0006, B:10:0x0018, B:12:0x001c, B:14:0x0022, B:15:0x0027, B:17:0x002b, B:19:0x0032, B:9:0x0014), top: B:24:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC r2, int r3, android.content.Context r4) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L13 java.lang.Throwable -> L37
            r1.<init>()     // Catch: org.json.JSONException -> L13 java.lang.Throwable -> L37
            java.lang.String r0 = com.mbridge.msdk.foundation.same.a.f3606j     // Catch: org.json.JSONException -> L10 java.lang.Throwable -> L37
            org.json.JSONObject r3 = r2.a(r3)     // Catch: org.json.JSONException -> L10 java.lang.Throwable -> L37
            r1.put(r0, r3)     // Catch: org.json.JSONException -> L10 java.lang.Throwable -> L37
            goto L18
        L10:
            r3 = move-exception
            r0 = r1
            goto L14
        L13:
            r3 = move-exception
        L14:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L37
            r1 = r0
        L18:
            com.mbridge.msdk.video.signal.a.k r3 = r2.J     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L41
            boolean r3 = com.mbridge.msdk.e.b.a()     // Catch: java.lang.Throwable -> L37
            if (r3 == 0) goto L27
            com.mbridge.msdk.video.signal.a.k r3 = r2.J     // Catch: java.lang.Throwable -> L37
            r2.doChinaJumpClick(r4, r3)     // Catch: java.lang.Throwable -> L37
        L27:
            com.mbridge.msdk.video.signal.a.k r2 = r2.J     // Catch: java.lang.Throwable -> L37
            if (r1 == 0) goto L30
            java.lang.String r3 = r1.toString()     // Catch: java.lang.Throwable -> L37
            goto L32
        L30:
            java.lang.String r3 = ""
        L32:
            r4 = 1
            r2.click(r4, r3)     // Catch: java.lang.Throwable -> L37
            goto L41
        L37:
            r2 = move-exception
            java.lang.String r3 = "BTBaseView"
            java.lang.String r2 = r2.getMessage()
            com.mbridge.msdk.foundation.tools.af.a(r3, r2)
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC.a(com.mbridge.msdk.video.bt.module.MBridgeBTNativeEC, int, android.content.Context):void");
    }
}

package com.mbridge.msdk.mbbanner.common.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbbanner.common.b.e;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbanner.view.MBBannerWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import t3.j;
import w3.i;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class d {
    private t3.b A;
    private t3.a B;
    private float E;
    private float F;

    /* renamed from: a, reason: collision with root package name */
    protected com.mbridge.msdk.mbbanner.common.b.c f4225a;

    /* renamed from: b, reason: collision with root package name */
    protected CampaignEx f4226b;

    /* renamed from: c, reason: collision with root package name */
    protected final MBBannerView f4227c;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f4228d;
    protected final String e;
    com.mbridge.msdk.click.a f;
    private boolean g;
    private ImageView h;

    /* renamed from: i, reason: collision with root package name */
    private MBBannerWebView f4229i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f4230j;

    /* renamed from: k, reason: collision with root package name */
    private ImageView f4231k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4232l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4233m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4234n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4235o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f4236p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4237q;

    /* renamed from: r, reason: collision with root package name */
    private final String f4238r;

    /* renamed from: s, reason: collision with root package name */
    private String f4239s;

    /* renamed from: u, reason: collision with root package name */
    private List<CampaignEx> f4240u;

    /* renamed from: x, reason: collision with root package name */
    private int f4243x;

    /* renamed from: z, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.communication.a f4244z;
    private int t = -1;

    /* renamed from: v, reason: collision with root package name */
    private int f4241v = 1;

    /* renamed from: w, reason: collision with root package name */
    private int f4242w = 1;
    private final long y = 15000;
    private final Handler C = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.mbbanner.common.c.d.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1) {
                return;
            }
            try {
                if (d.this.A != null) {
                    d dVar = d.this;
                    dVar.B = t3.a.a(dVar.A);
                    if (d.this.B != null) {
                        j jVar = d.this.B.f12766a;
                        t1.d(jVar);
                        jVar.f12792b.getClass();
                        if (jVar.f12796j) {
                            throw new IllegalStateException("Loaded event can only be sent once");
                        }
                        y3.a aVar = jVar.e;
                        i.f13511a.a(aVar.f(), "publishLoadedEvent", null, aVar.f13782a);
                        jVar.f12796j = true;
                        d.this.B.b();
                    }
                }
            } catch (Throwable th) {
                af.a("BannerShowManager", th.getMessage());
            }
        }
    };
    private final com.mbridge.msdk.foundation.same.e.a D = new com.mbridge.msdk.foundation.same.e.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.6
        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880045);
            bVar.b(d.this.f4226b.getLocalRequestId());
            d.this.a(bVar);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z9) {
        }
    };
    private final View.OnClickListener G = new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.7
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d dVar = d.this;
            if (dVar.f4228d) {
                dVar.t = 1;
                d.c(d.this);
            }
        }
    };
    private com.mbridge.msdk.mbbanner.common.b.a H = new com.mbridge.msdk.mbbanner.common.b.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.8
        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z9, String str) {
            try {
                if (d.this.f4225a != null) {
                    boolean zIsEmpty = TextUtils.isEmpty(str);
                    d dVar = d.this;
                    if (zIsEmpty) {
                        dVar.f4225a.a();
                        d.this.f4225a.b();
                    } else {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(dVar.f4226b));
                        campaignWithBackData.setClickURL(str);
                        d.this.a(campaignWithBackData, z9, str);
                    }
                }
            } catch (Exception e) {
                af.b("BannerShowManager", e.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void b(int i10) throws JSONException {
            d dVar = d.this;
            if (i10 != 1) {
                dVar.d();
            } else {
                dVar.e();
                d.this.a("", 1);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(String str) {
            d.this.t = 2;
            d.c(d.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a() {
            d.this.t = 2;
            d.c(d.this);
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(CampaignEx campaignEx) {
            d.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(boolean z9) {
            d dVar = d.this;
            if (dVar.f4225a != null) {
                dVar.f4237q = z9;
                d dVar2 = d.this;
                if (z9) {
                    dVar2.f4225a.c();
                } else {
                    dVar2.f4225a.d();
                }
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.b.a
        public final void a(int i10) {
            d dVar = d.this;
            if (i10 == 2) {
                d.d(dVar);
            } else {
                dVar.g();
            }
        }
    };
    private com.mbridge.msdk.mbsignalcommon.b.b I = new com.mbridge.msdk.mbsignalcommon.b.b() { // from class: com.mbridge.msdk.mbbanner.common.c.d.4
        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, int i10, String str, String str2) {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880000);
            bVar.a(i10 + " WebView receive error: " + i10 + "  message : " + str);
            bVar.b(d.this.f4239s);
            d.this.a(bVar);
            d.this.a(str, 2);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView, String str) throws JSONException {
            d.this.f4234n = true;
            af.b("BannerCallJS", "fireOnJSBridgeConnected");
            g.a().a(webView);
            d.this.f4236p = true;
            CampaignEx campaignEx = d.this.f4226b;
            if (campaignEx == null || campaignEx.isHasMBTplMark()) {
                return;
            }
            d.this.e();
            d.this.a("", 1);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.b.b, com.mbridge.msdk.mbsignalcommon.windvane.d
        public final void a(WebView webView) {
            d.this.d();
        }
    };

    public d(MBBannerView mBBannerView, com.mbridge.msdk.mbbanner.common.b.c cVar, String str, String str2, boolean z9, k kVar) {
        this.g = z9;
        this.f4227c = mBBannerView;
        this.e = str2;
        this.f4238r = str;
        this.f4225a = new e(cVar, kVar);
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.h);
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
    }

    private boolean c() {
        String strA = a(this.f4226b);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (this.f4227c != null) {
            if (this.f4229i == null) {
                try {
                    MBBannerWebView mBBannerWebView = new MBBannerWebView(com.mbridge.msdk.foundation.controller.c.m().c());
                    this.f4229i = mBBannerWebView;
                    mBBannerWebView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    this.f4229i.setWebViewClient(new com.mbridge.msdk.mbbanner.view.a(this.e, this.f4240u, this.H));
                } catch (Throwable unused) {
                    a(com.mbridge.msdk.foundation.c.a.a(880029), 1);
                    return false;
                }
            }
            ImageView imageView = this.h;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.f4229i.getVisibility() != 0) {
                this.f4229i.setVisibility(0);
            }
            if (this.f4229i.getParent() == null) {
                this.f4227c.addView(this.f4229i);
                d(this.f4226b.isMraid());
            }
            if (this.f4226b.isMraid()) {
                h();
            }
            g();
            com.mbridge.msdk.mbbanner.common.communication.a aVar = new com.mbridge.msdk.mbbanner.common.communication.a(this.f4227c.getContext(), this.f4238r, this.e);
            this.f4244z = aVar;
            aVar.a(this.f4240u);
            this.f4244z.a(this.H);
            this.f4244z.a(this.f4243x);
            this.f4229i.setWebViewListener(this.I);
            this.f4229i.setObject(this.f4244z);
            this.f4229i.loadUrl(strA);
            MBBannerWebView mBBannerWebView2 = this.f4229i;
            if (mBBannerWebView2 != null) {
                mBBannerWebView2.postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.d.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (d.this.f4229i != null) {
                                String str = d.this.f4241v == 2 ? "false" : "true";
                                d.this.f4229i.evaluateJavascript("(function() {\n    var videos = document.getElementsByTagName('video');\n    for (var i = 0; i < videos.length; i++) {\n    videos[i].muted = " + str + ";\n    }\n    var audios = document.getElementsByTagName('audio');\n    for (var i = 0; i < audios.length; i++) {\n    audios[i].muted = " + str + ";\n    }\n    })()", null);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 1000L);
            }
        } else {
            a(com.mbridge.msdk.foundation.c.a.a(880046), 2);
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880046);
            bVar.b(this.f4239s);
            a(bVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        if (this.f4227c == null) {
            com.mbridge.msdk.foundation.c.b bVar = new com.mbridge.msdk.foundation.c.b(880046);
            bVar.b(this.f4239s);
            a(bVar);
            return;
        }
        MBBannerWebView mBBannerWebView = this.f4229i;
        if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
            this.f4227c.removeView(this.f4229i);
        }
        if (this.h == null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
            this.h = imageView;
            imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.10
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    d.this.E = motionEvent.getRawX();
                    d.this.F = motionEvent.getRawY();
                    af.b("BannerShowManager", d.this.E + "  " + d.this.F);
                    return false;
                }
            });
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.mbbanner.common.c.d.11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws JSONException {
                    d.this.a(BannerUtils.managerCampaignEX(com.mbridge.msdk.mbsignalcommon.communication.d.a(d.this.E, d.this.F), d.this.f4226b), false, "");
                }
            });
        }
        String imageUrl = this.f4226b.getImageUrl();
        if (!TextUtils.isEmpty(imageUrl)) {
            com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(imageUrl, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.mbbanner.common.c.d.12
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880039);
                    bVar2.b(d.this.f4239s);
                    d.this.a(bVar2);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) throws JSONException {
                    if (d.this.h != null) {
                        d.this.h.setImageBitmap(bitmap);
                    }
                    d.this.f4234n = true;
                    d.m(d.this);
                    d.this.g();
                    d.this.h();
                    d dVar = d.this;
                    if (dVar.f4228d) {
                        return;
                    }
                    dVar.e();
                }
            });
            return;
        }
        com.mbridge.msdk.foundation.c.b bVar2 = new com.mbridge.msdk.foundation.c.b(880047);
        bVar2.b(this.f4239s);
        a(bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0207 A[Catch: all -> 0x021d, TRY_LEAVE, TryCatch #4 {all -> 0x021d, blocks: (B:74:0x0203, B:76:0x0207), top: B:156:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0248  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1081
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.d.e():void");
    }

    private synchronized boolean f() {
        boolean zIsReport;
        zIsReport = this.f4226b.isReport();
        if (!zIsReport) {
            this.f4226b.setReport(true);
        }
        return zIsReport;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ImageView imageView;
        if (!this.g || (imageView = this.f4230j) == null) {
            return;
        }
        if (imageView.getVisibility() != 0) {
            this.f4230j.setVisibility(0);
            this.f4230j.setOnClickListener(this.G);
        }
        if (this.f4230j.getParent() != null || this.f4227c == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.dycreator.baseview.a.e(12.0f), com.mbridge.msdk.dycreator.baseview.a.e(12.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        this.f4227c.addView(this.f4230j, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f4227c == null) {
            return;
        }
        CampaignEx campaignEx = this.f4226b;
        if (campaignEx == null || campaignEx.getPrivacyButtonTemplateVisibility() == 1) {
            MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().c());
            mBAdChoice.setCampaign(this.f4226b);
            mBAdChoice.setFeedbackDialogEventListener(new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.2
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    String string;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.dycreator.baseview.a.e(6.0f), com.mbridge.msdk.dycreator.baseview.a.e(6.0f));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            this.f4227c.addView(mBAdChoice, layoutParams);
        }
    }

    private void i() {
        t3.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
            this.A = null;
            af.a("omsdk", " adSession.finish() ");
        }
    }

    public static /* synthetic */ void m(d dVar) {
        if (dVar.h != null) {
            MBBannerWebView mBBannerWebView = dVar.f4229i;
            if (mBBannerWebView != null) {
                mBBannerWebView.setVisibility(8);
            }
            if (dVar.h.getVisibility() != 0) {
                dVar.h.setVisibility(0);
            }
            dVar.f4242w = 2;
            if (dVar.f4227c != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.addRule(10);
                dVar.h.setScaleType(ImageView.ScaleType.FIT_XY);
                if (dVar.h.getParent() == null) {
                    dVar.f4227c.addView(dVar.h, layoutParams);
                }
                dVar.d(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignUnit r5) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbbanner.common.c.d.a(com.mbridge.msdk.foundation.entity.CampaignUnit):void");
    }

    public final void b(boolean z9) throws JSONException {
        this.f4232l = z9;
        e();
    }

    public final int b() {
        return this.f4242w;
    }

    private void d(boolean z9) {
        if (this.f4227c != null) {
            View viewB = com.mbridge.msdk.foundation.d.b.a().b(this.e);
            if (com.mbridge.msdk.foundation.d.b.a().b() && z9 && viewB != null) {
                ViewGroup viewGroup = (ViewGroup) viewB.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(viewB);
                }
                viewB.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f3436b, com.mbridge.msdk.foundation.d.b.f3435a);
                }
                layoutParams.addRule(12);
                viewB.setLayoutParams(layoutParams);
                this.f4227c.addView(viewB);
            }
            com.mbridge.msdk.foundation.d.b.a().a(this.e, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.mbbanner.common.c.d.5
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                    String string;
                    d.this.f4227c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                    String string;
                    d.this.f4227c.onPause();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                    String string;
                    d.this.f4227c.onResume();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                            jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                        }
                        string = jSONObject.toString();
                    } catch (Throwable th) {
                        af.b("BannerShowManager", th.getMessage(), th);
                        string = "";
                    }
                    g.a().a((WebView) d.this.f4229i, "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                }
            });
            this.f4226b.setCampaignUnitId(this.e);
            com.mbridge.msdk.foundation.d.b.a().a(this.e, this.f4226b);
        }
    }

    public static /* synthetic */ void d(d dVar) {
        ImageView imageView;
        if (dVar.g && (imageView = dVar.f4230j) != null && imageView.getVisibility() == 0) {
            dVar.f4230j.setVisibility(8);
            dVar.f4230j.setOnClickListener(null);
            if (dVar.f4227c == null || dVar.f4230j.getParent() == null) {
                return;
            }
            dVar.f4227c.removeView(dVar.f4230j);
        }
    }

    public final void c(boolean z9) throws JSONException {
        this.f4233m = z9;
        e();
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(context)).a(campaignEx.getId());
                    } catch (Exception e) {
                        af.b("BannerShowManager", e.getMessage());
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
    }

    public static /* synthetic */ void c(d dVar) {
        try {
            CampaignEx campaignEx = dVar.f4226b;
            if (campaignEx != null) {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(dVar.e, campaignEx.getLocalRequestId());
                cVarA.g(dVar.f4242w);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("close_click_type", Integer.valueOf(dVar.t));
                eVar.a(CampaignEx.JSON_KEY_CREATIVE_ID, Long.valueOf(dVar.f4226b.getCreativeId()));
                com.mbridge.msdk.mbbanner.common.d.a.a("2000069", cVarA, eVar);
            }
        } catch (Throwable th) {
            af.b("BannerShowManager", th.getMessage());
        }
        MBBannerWebView mBBannerWebView = dVar.f4229i;
        if (mBBannerWebView != null && mBBannerWebView.getParent() != null) {
            dVar.f4227c.removeView(dVar.f4229i);
        }
        ImageView imageView = dVar.h;
        if (imageView != null && imageView.getParent() != null) {
            dVar.h.setVisibility(8);
            dVar.f4227c.removeView(dVar.h);
        }
        ImageView imageView2 = dVar.f4230j;
        if (imageView2 != null && imageView2.getParent() != null) {
            dVar.f4227c.removeView(dVar.f4230j);
            dVar.f4230j.setVisibility(8);
        }
        com.mbridge.msdk.foundation.d.b.a().c(dVar.e);
        ImageView imageView3 = dVar.f4231k;
        if (imageView3 != null && imageView3.getParent() != null) {
            dVar.f4227c.removeView(dVar.f4231k);
            dVar.f4231k.setVisibility(8);
        }
        BannerUtils.inserCloseId(dVar.e, dVar.f4240u);
        try {
            CampaignEx campaignEx2 = dVar.f4226b;
            if (campaignEx2 != null) {
                com.mbridge.msdk.foundation.same.report.d.c cVarA2 = com.mbridge.msdk.mbbanner.common.d.a.a(dVar.e, campaignEx2.getLocalRequestId());
                cVarA2.g(dVar.f4242w);
                cVarA2.c(true);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000152", cVarA2, null);
            }
        } catch (Throwable th2) {
            af.b("BannerShowManager", th2.getMessage());
        }
        com.mbridge.msdk.mbbanner.common.b.c cVar = dVar.f4225a;
        if (cVar != null) {
            cVar.e();
        }
        dVar.i();
    }

    public final void a(boolean z9, int i10) {
        this.f4243x = i10;
        if (i10 == 0) {
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.e);
            if (kVarD == null) {
                return;
            } else {
                z9 = kVarD.f() == 1;
            }
        }
        this.g = z9;
    }

    public final void a(boolean z9) {
        this.g = z9;
    }

    private String a(CampaignEx campaignEx) {
        String bannerUrl = "";
        if (campaignEx != null) {
            try {
                bannerUrl = campaignEx.getBannerUrl();
                if (TextUtils.isEmpty(bannerUrl)) {
                    bannerUrl = campaignEx.getBannerHtml();
                    File file = new File(bannerUrl);
                    if (file.exists() && file.isFile() && file.canRead()) {
                        return "file:////" + bannerUrl;
                    }
                }
                return bannerUrl;
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
        return bannerUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar) {
        if (this.f4226b == null || f()) {
            return;
        }
        this.C.removeCallbacks(this.D);
        com.mbridge.msdk.mbbanner.common.b.c cVar = this.f4225a;
        if (cVar != null) {
            cVar.a(bVar);
        }
    }

    public final void a() {
        LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.d.c> linkedHashMapB;
        i();
        CampaignEx campaignEx = this.f4226b;
        String str = this.e;
        if (campaignEx != null) {
            try {
                String strA = com.mbridge.msdk.mbsignalcommon.mraid.c.a(campaignEx.getId());
                if (!TextUtils.isEmpty(strA)) {
                    new com.mbridge.msdk.foundation.same.report.h(com.mbridge.msdk.foundation.controller.c.m().c()).b(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str, strA, campaignEx.isBidCampaign());
                    com.mbridge.msdk.mbsignalcommon.mraid.c.b(campaignEx.getId());
                }
            } catch (Throwable th) {
                af.b("BannerReport", th.getMessage());
            }
        }
        if (this.f4225a != null) {
            this.f4225a = null;
        }
        MBBannerWebView mBBannerWebView = this.f4229i;
        if (mBBannerWebView != null) {
            mBBannerWebView.setWebViewListener(null);
        }
        if (this.I != null) {
            this.I = null;
        }
        ImageView imageView = this.f4230j;
        if (imageView != null) {
            imageView.setOnClickListener(null);
        }
        ImageView imageView2 = this.h;
        if (imageView2 != null) {
            imageView2.setOnClickListener(null);
        }
        MBBannerView mBBannerView = this.f4227c;
        if (mBBannerView != null) {
            mBBannerView.removeAllViews();
        }
        MBBannerWebView mBBannerWebView2 = this.f4229i;
        if (mBBannerWebView2 != null) {
            mBBannerWebView2.release();
        }
        com.mbridge.msdk.mbbanner.common.communication.a aVar = this.f4244z;
        if (aVar != null) {
            aVar.a();
        }
        if (this.H != null) {
            this.H = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.e);
        String str2 = this.e;
        try {
            if (TextUtils.isEmpty(str2) || (linkedHashMapB = com.mbridge.msdk.foundation.same.report.d.d.a().b()) == null || linkedHashMapB.isEmpty()) {
                return;
            }
            Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.c>> it = linkedHashMapB.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.c> next = it.next();
                if (next != null) {
                    com.mbridge.msdk.foundation.same.report.d.c value = next.getValue();
                    if (value.s()) {
                        it.remove();
                    }
                    if (value.i().equals(str2)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th2) {
            af.b("BannerReport", th2.getMessage());
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    CampaignEx campaignEx2 = campaignEx;
                    Context context2 = context;
                    String str2 = str;
                    com.mbridge.msdk.click.a.a(context2, campaignEx2, str2, it.next(), false, true);
                    context = context2;
                    campaignEx = campaignEx2;
                    str = str2;
                }
            } catch (Throwable th) {
                af.b("BannerShowManager", th.getMessage());
            }
        }
    }

    public final void a(int i10, int i11, int i12, int i13) {
        if (i10 == i12 && i11 == i13) {
            return;
        }
        MBBannerWebView mBBannerWebView = this.f4229i;
        af.b("BannerCallJS", "fireOnBannerViewSizeChange");
        try {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(mBBannerWebView, i10, i11);
        } catch (Throwable th) {
            af.b("BannerCallJS", "fireOnBannerViewSizeChange", th);
        }
    }

    public final void a(String str) {
        this.f4239s = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i10) {
        try {
            CampaignEx campaignEx = this.f4226b;
            if (campaignEx != null) {
                com.mbridge.msdk.foundation.same.report.d.c cVarA = com.mbridge.msdk.mbbanner.common.d.a.a(this.e, campaignEx.getLocalRequestId());
                cVarA.g(this.f4242w);
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a("result", Integer.valueOf(i10));
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                eVar.a("reason", str);
                cVarA.f(TextUtils.isEmpty(this.f4226b.getBannerUrl()) ? 2 : 1);
                com.mbridge.msdk.mbbanner.common.d.a.a("2000068", cVarA, eVar);
            }
        } catch (Throwable th) {
            af.b("BannerShowManager", th.getMessage());
        }
    }

    public void a(CampaignEx campaignEx, boolean z9, String str) {
    }
}

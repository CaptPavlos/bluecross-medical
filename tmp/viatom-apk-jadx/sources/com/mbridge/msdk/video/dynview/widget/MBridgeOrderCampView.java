package com.mbridge.msdk.video.dynview.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.bt.module.b.f;
import com.mbridge.msdk.video.dynview.e.b;
import com.mbridge.msdk.video.dynview.e.c;
import com.mbridge.msdk.video.dynview.e.h;
import com.mbridge.msdk.video.module.MBridgeBaseView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.HashMap;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeOrderCampView extends MBridgeBaseView {

    /* renamed from: m, reason: collision with root package name */
    private MBridgeOrderCampView f5876m;

    /* renamed from: n, reason: collision with root package name */
    private List<CampaignEx> f5877n;

    /* renamed from: o, reason: collision with root package name */
    private int f5878o;

    /* renamed from: p, reason: collision with root package name */
    private int f5879p;

    /* renamed from: q, reason: collision with root package name */
    private int f5880q;

    /* renamed from: r, reason: collision with root package name */
    private int f5881r;

    /* renamed from: s, reason: collision with root package name */
    private String f5882s;
    private FeedBackButton t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f5883u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5884v;

    /* renamed from: w, reason: collision with root package name */
    private c f5885w;

    /* renamed from: x, reason: collision with root package name */
    private b f5886x;
    private boolean y;

    public MBridgeOrderCampView(Context context) {
        super(context);
        this.f5884v = false;
        this.f5885w = new c() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.1
            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a(CampaignEx campaignEx, int i10) {
                if (campaignEx != null) {
                    try {
                        MBridgeOrderCampView.this.setCampaign(campaignEx);
                        campaignEx.setClickTempSource(2);
                        campaignEx.setTriggerClickSource(2);
                        MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i10);
                    } catch (Exception e) {
                        af.b(MBridgeBaseView.TAG, e.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a() {
                MBridgeOrderCampView.a(MBridgeOrderCampView.this);
            }
        };
        this.y = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView r9, com.mbridge.msdk.foundation.entity.CampaignEx r10, int r11, int r12) throws org.json.JSONException {
        /*
            java.lang.String r0 = "order_view_click"
            if (r10 == 0) goto L5a
            boolean r1 = r10.isDynamicView()
            if (r1 == 0) goto L5a
            com.mbridge.msdk.foundation.entity.CampaignEx$c r1 = r10.getRewardTemplateMode()     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = ""
            if (r1 == 0) goto L25
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L27
            r3.<init>()     // Catch: java.lang.Exception -> L27
            int r1 = r1.f()     // Catch: java.lang.Exception -> L27
            r3.append(r1)     // Catch: java.lang.Exception -> L27
            r3.append(r2)     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L27
        L25:
            r7 = r2
            goto L2a
        L27:
            r0 = move-exception
            r10 = r0
            goto L51
        L2a:
            com.mbridge.msdk.foundation.controller.c r1 = com.mbridge.msdk.foundation.controller.c.m()     // Catch: java.lang.Exception -> L27
            android.content.Context r1 = r1.c()     // Catch: java.lang.Exception -> L27
            java.lang.String r0 = r0.concat(r7)     // Catch: java.lang.Exception -> L27
            java.lang.String r2 = r10.getCampaignUnitId()     // Catch: java.lang.Exception -> L27
            boolean r3 = r10.isBidCampaign()     // Catch: java.lang.Exception -> L27
            java.lang.String r4 = r10.getRequestId()     // Catch: java.lang.Exception -> L27
            java.lang.String r5 = r10.getRequestIdNotice()     // Catch: java.lang.Exception -> L27
            java.lang.String r6 = r10.getId()     // Catch: java.lang.Exception -> L27
            r8 = r1
            r1 = r0
            r0 = r8
            com.mbridge.msdk.foundation.same.report.i.a(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L27
            goto L5a
        L51:
            java.lang.String r0 = "MBridgeBaseView"
            java.lang.String r10 = r10.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r10)
        L5a:
            r10 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L72
            r1.<init>()     // Catch: org.json.JSONException -> L72
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.f3606j     // Catch: org.json.JSONException -> L6f
            org.json.JSONObject r11 = r9.a(r11)     // Catch: org.json.JSONException -> L6f
            r1.put(r10, r11)     // Catch: org.json.JSONException -> L6f
            java.lang.String r10 = "camp_position"
            r1.put(r10, r12)     // Catch: org.json.JSONException -> L6f
            goto L79
        L6f:
            r0 = move-exception
            r10 = r0
            goto L76
        L72:
            r0 = move-exception
            r11 = r0
            r1 = r10
            r10 = r11
        L76:
            r10.printStackTrace()
        L79:
            com.mbridge.msdk.video.module.a.a r9 = r9.notifyListener
            if (r9 == 0) goto L82
            r10 = 105(0x69, float:1.47E-43)
            r9.a(r10, r1)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.a(com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView, com.mbridge.msdk.foundation.entity.CampaignEx, int, int):void");
    }

    public void createView(final ViewGroup viewGroup) {
        if (this.f5877n == null) {
            b bVar = this.f5886x;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("order_view_callback", this.f5885w);
        com.mbridge.msdk.video.dynview.b.a().a(new com.mbridge.msdk.video.dynview.j.c().b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f5877n), new h() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.2
            @Override // com.mbridge.msdk.video.dynview.e.h
            public final void viewInflaterFail(com.mbridge.msdk.video.dynview.c.a aVar) {
                try {
                    f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f5877n, ((CampaignEx) MBridgeOrderCampView.this.f5877n.get(0)).getCampaignUnitId(), aVar.b());
                    if (MBridgeOrderCampView.this.f5886x != null) {
                        MBridgeOrderCampView.this.f5886x.b();
                    }
                } catch (Exception e) {
                    af.b(MBridgeBaseView.TAG, e.getMessage());
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.h
            public final void viewInflaterSuccess(com.mbridge.msdk.video.dynview.a aVar) {
                if (aVar != null) {
                    try {
                        MBridgeOrderCampView.this.f5876m.addView(aVar.a());
                        MBridgeOrderCampView.this.f5884v = aVar.c();
                        viewGroup.removeAllViews();
                        viewGroup.addView(MBridgeOrderCampView.this.f5876m);
                        f.a(com.mbridge.msdk.foundation.controller.c.m().c(), (List<CampaignEx>) MBridgeOrderCampView.this.f5877n, ((CampaignEx) MBridgeOrderCampView.this.f5877n.get(0)).getCampaignUnitId());
                        MBridgeOrderCampView.this.setViewStatus();
                        if (MBridgeOrderCampView.this.f5886x != null) {
                            MBridgeOrderCampView.this.f5886x.a();
                        }
                    } catch (Exception e) {
                        af.b(MBridgeBaseView.TAG, e.getMessage());
                    }
                }
            }
        }, map);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        this.f5876m = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x002f A[SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() throws org.json.JSONException {
        /*
            r5 = this;
            super.onAttachedToWindow()
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r5.f5877n
            if (r0 != 0) goto L8
            goto L32
        L8:
            r0 = 0
        L9:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.f5877n
            int r1 = r1.size()
            if (r0 >= r1) goto L32
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: org.json.JSONException -> L1f
            r2.<init>()     // Catch: org.json.JSONException -> L1f
            java.lang.String r1 = "camp_position"
            r2.put(r1, r0)     // Catch: org.json.JSONException -> L1d
            goto L26
        L1d:
            r1 = move-exception
            goto L23
        L1f:
            r2 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
        L23:
            r1.printStackTrace()
        L26:
            com.mbridge.msdk.video.module.a.a r1 = r5.notifyListener
            if (r1 == 0) goto L2f
            r3 = 110(0x6e, float:1.54E-43)
            r1.a(r3, r2)
        L2f:
            int r0 = r0 + 1
            goto L9
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.onAttachedToWindow():void");
    }

    public void setCampOrderViewBuildCallback(b bVar) {
        this.f5886x = bVar;
    }

    public void setCampaignExes(List<CampaignEx> list) {
        this.f5877n = list;
    }

    public void setNotchPadding(int i10, int i11, int i12, int i13) {
        this.f5878o = i10;
        this.f5879p = i11;
        this.f5880q = i12;
        this.f5881r = i13;
        setViewStatus();
    }

    public void setRewarded(boolean z9) {
        this.y = z9;
    }

    public void setViewStatus() {
        MBridgeOrderCampView mBridgeOrderCampView = this.f5876m;
        if (mBridgeOrderCampView == null || !this.y) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) mBridgeOrderCampView.findViewById(filterFindViewId(this.f5884v, "mbridge_native_order_camp_controller"));
        this.t = (FeedBackButton) this.f5876m.findViewById(filterFindViewId(this.f5884v, "mbridge_native_order_camp_feed_btn"));
        this.f5883u = (ImageView) this.f5876m.findViewById(filterFindViewId(this.f5884v, "mbridge_iv_link"));
        if (relativeLayout != null) {
            relativeLayout.setPadding(this.f5878o, this.f5880q, this.f5879p, this.f5881r);
        }
        if (this.t != null) {
            try {
                List<CampaignEx> list = this.f5877n;
                if (list == null || list.get(0) == null) {
                    FeedBackButton feedBackButton = this.t;
                    if (feedBackButton != null) {
                        feedBackButton.setVisibility(8);
                    }
                } else {
                    this.f5882s = this.f5877n.get(0).getCampaignUnitId();
                    this.f5901b = this.f5877n.get(0);
                    com.mbridge.msdk.foundation.d.b.a().a(this.f5882s + "_2", this.f5901b);
                    if (this.t != null) {
                        if (com.mbridge.msdk.foundation.d.b.a().b()) {
                            com.mbridge.msdk.foundation.d.b.a().a(this.f5882s + "_2", new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.3
                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void close() {
                                }

                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void showed() {
                                }

                                @Override // com.mbridge.msdk.foundation.d.a
                                public final void summit(String str) {
                                }
                            });
                            com.mbridge.msdk.foundation.d.b.a().a(this.f5882s + "_2", this.t);
                        } else {
                            this.t.setVisibility(8);
                        }
                    }
                }
            } catch (Exception e) {
                af.b(MBridgeBaseView.TAG, e.getMessage());
            }
        }
        ImageView imageView = this.f5883u;
        if (imageView == null || imageView == null) {
            return;
        }
        try {
            g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB == null) {
                this.f5883u.setVisibility(8);
                return;
            }
            final String strJ = gVarB.j();
            if (TextUtils.isEmpty(strJ)) {
                this.f5883u.setVisibility(8);
            }
            this.f5883u.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    com.mbridge.msdk.click.c.f(((MBridgeBaseView) MBridgeOrderCampView.this).f5900a, strJ);
                }
            });
        } catch (Exception e3) {
            af.b(MBridgeBaseView.TAG, e3.getMessage());
        }
    }

    public void startAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        this.f5876m.startAnimation(alphaAnimation);
    }

    public void startTranslateAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setDuration(500L);
        this.f5876m.startAnimation(translateAnimation);
    }

    public MBridgeOrderCampView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5884v = false;
        this.f5885w = new c() { // from class: com.mbridge.msdk.video.dynview.widget.MBridgeOrderCampView.1
            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a(CampaignEx campaignEx, int i10) {
                if (campaignEx != null) {
                    try {
                        MBridgeOrderCampView.this.setCampaign(campaignEx);
                        campaignEx.setClickTempSource(2);
                        campaignEx.setTriggerClickSource(2);
                        MBridgeOrderCampView.a(MBridgeOrderCampView.this, campaignEx, 0, i10);
                    } catch (Exception e) {
                        af.b(MBridgeBaseView.TAG, e.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.video.dynview.e.c
            public final void a() {
                MBridgeOrderCampView.a(MBridgeOrderCampView.this);
            }
        };
        this.y = false;
    }

    public static /* synthetic */ void a(MBridgeOrderCampView mBridgeOrderCampView) {
        try {
            e eVar = new e();
            eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 2);
            d.a().a("2000152", eVar);
            d.a().a("2000134", mBridgeOrderCampView.f5901b);
        } catch (Throwable th) {
            af.a(MBridgeBaseView.TAG, th.getMessage());
        }
        try {
            com.mbridge.msdk.video.dynview.moffer.a.a().b();
        } catch (Exception e) {
            af.b(MBridgeBaseView.TAG, e.getMessage());
        }
        com.mbridge.msdk.video.module.a.a aVar = mBridgeOrderCampView.notifyListener;
        if (aVar != null) {
            aVar.a(104, "");
        }
    }
}

package com.mbridge.msdk.newreward.function.command.receiver.showreceiver;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.MBridgeBaitClickView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.player.imodel.IECModel;
import com.mbridge.msdk.newreward.player.imodel.IPlayModel;
import com.mbridge.msdk.newreward.player.redirect.RedirectModel;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.shake.MBShakeView;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements com.mbridge.msdk.newreward.function.command.receiver.e {

    /* renamed from: a, reason: collision with root package name */
    CampaignEx f4877a;

    /* renamed from: b, reason: collision with root package name */
    IECModel f4878b;

    /* renamed from: c, reason: collision with root package name */
    IPlayModel f4879c;

    /* renamed from: d, reason: collision with root package name */
    RedirectModel f4880d;
    com.mbridge.msdk.shake.b e;
    com.mbridge.msdk.newreward.function.command.f f;
    MBridgeIds g;
    int h;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4884a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.command.f.values().length];
            f4884a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.command.f.ADD_SHAKE_VIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4884a[com.mbridge.msdk.newreward.function.command.f.ADD_BAIT_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public c(com.mbridge.msdk.newreward.function.command.f fVar) {
        this.f = fVar;
    }

    private View a(Map map) {
        int i10;
        String strA;
        if (this.f4877a == null) {
            return null;
        }
        View view = (View) map.get("bait_click_view");
        try {
            String strE = "";
            int i11 = this.h;
            i10 = 1;
            if (i11 != 1) {
                if (i11 == 2) {
                    strE = this.f4877a.getendcard_url();
                    if (TextUtils.isEmpty(strE)) {
                        strE = this.f4877a.getEndScreenUrl();
                    }
                }
            } else if (this.f4877a.getRewardTemplateMode() != null) {
                strE = this.f4877a.getRewardTemplateMode().e();
            }
            strA = aq.a(strE, "bait_click");
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            i10 = Integer.parseInt(strA);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(strA) && i10 != 0 && view != null) {
            view.setVisibility(0);
            ((MBridgeBaitClickView) view).init(1342177280, i10);
            if (this.f4877a.getEcTemplateId() == 1302) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(1342177280);
                gradientDrawable.setStroke(0, SupportMenu.CATEGORY_MASK);
                gradientDrawable.setCornerRadius(25.0f);
                view.setBackground(gradientDrawable);
            }
            ((MBridgeBaitClickView) view).startAnimation();
            view.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CampaignEx campaignEx = c.this.f4877a;
                    if (campaignEx != null) {
                        campaignEx.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                        c.this.f4877a.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3809n);
                    }
                    c cVar = c.this;
                    if (cVar.h == 2) {
                        cVar.f4878b.eventClickUrl(cVar.f4880d);
                        c cVar2 = c.this;
                        cVar2.f4878b.eventTrackingForClick(cVar2.f4880d);
                        c cVar3 = c.this;
                        cVar3.f4878b.onAdClick(cVar3.g);
                        return;
                    }
                    cVar.f4879c.eventClickUrl(cVar.f4880d);
                    c cVar4 = c.this;
                    cVar4.f4879c.eventTrackingForClick(cVar4.f4880d);
                    c cVar5 = c.this;
                    cVar5.f4879c.onAdClick(cVar5.g);
                }
            });
        }
        return view;
    }

    public final Object a(Object obj) {
        Map map = (Map) obj;
        try {
            this.f4877a = (CampaignEx) map.get("campaign");
            if (map.get("template_model") instanceof IECModel) {
                this.h = 2;
                this.f4878b = (IECModel) map.get("template_model");
            } else if (map.get("template_model") instanceof IPlayModel) {
                this.h = 1;
                this.f4879c = (IPlayModel) map.get("template_model");
            }
            this.f4880d = (RedirectModel) map.get("template_redirect_model");
            this.g = (MBridgeIds) map.get("mbridge_ids");
            int i10 = AnonymousClass4.f4884a[this.f.ordinal()];
            if (i10 == 1) {
                return a();
            }
            if (i10 != 2) {
                return null;
            }
            return a(map);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    private View a() {
        int i10;
        int i11;
        CampaignEx campaignEx = this.f4877a;
        MBShakeView mBShakeView = null;
        if (campaignEx == null) {
            return null;
        }
        try {
            String endScreenUrl = campaignEx.getendcard_url();
            if (TextUtils.isEmpty(endScreenUrl)) {
                endScreenUrl = this.f4877a.getEndScreenUrl();
            }
            String strA = aq.a(endScreenUrl, "shake_show");
            String strA2 = aq.a(endScreenUrl, "shake_strength");
            String strA3 = aq.a(endScreenUrl, "shake_time");
            if (TextUtils.isEmpty(strA) || !strA.equals("1")) {
                return null;
            }
            MBShakeView mBShakeView2 = new MBShakeView(com.mbridge.msdk.foundation.controller.c.m().c());
            try {
                mBShakeView2.initView(this.f4877a.getAdCall(), true);
                mBShakeView2.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CampaignEx campaignEx2 = c.this.f4877a;
                        if (campaignEx2 != null) {
                            campaignEx2.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                            c.this.f4877a.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3810o);
                        }
                        c.this.f4880d.setClickSenario(0);
                        c cVar = c.this;
                        cVar.f4878b.eventClickUrl(cVar.f4880d);
                        c cVar2 = c.this;
                        cVar2.f4878b.eventTrackingForClick(cVar2.f4880d);
                        c cVar3 = c.this;
                        cVar3.f4878b.onAdClick(cVar3.g);
                    }
                });
                int i12 = 10;
                if (!TextUtils.isEmpty(strA2) && (i11 = Integer.parseInt(strA2)) > 0) {
                    i12 = i11;
                }
                boolean zIsEmpty = TextUtils.isEmpty(strA3);
                int i13 = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;
                if (!zIsEmpty && (i10 = Integer.parseInt(strA3)) > 0) {
                    i13 = i10 * 1000;
                }
                this.e = new com.mbridge.msdk.shake.b(i12, i13) { // from class: com.mbridge.msdk.newreward.function.command.receiver.showreceiver.c.3
                    @Override // com.mbridge.msdk.shake.b
                    public final void a() {
                        CampaignEx campaignEx2 = c.this.f4877a;
                        if (campaignEx2 != null) {
                            campaignEx2.setClickTempSource(com.mbridge.msdk.foundation.same.report.d.a.h);
                            c.this.f4877a.setTriggerClickSource(com.mbridge.msdk.foundation.same.report.d.a.f3810o);
                        }
                        c.this.f4880d.setxInScreen(0.0f);
                        c.this.f4880d.setyInScreen(0.0f);
                        c.this.f4880d.setClickSenario(4);
                        c cVar = c.this;
                        cVar.f4878b.eventClickUrl(cVar.f4880d);
                        c cVar2 = c.this;
                        cVar2.f4878b.eventTrackingForClick(cVar2.f4880d);
                        c cVar3 = c.this;
                        cVar3.f4878b.onAdClick(cVar3.g);
                    }
                };
                com.mbridge.msdk.shake.a.a().a(this.e);
                return mBShakeView2;
            } catch (Throwable th) {
                th = th;
                mBShakeView = mBShakeView2;
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
                return mBShakeView;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

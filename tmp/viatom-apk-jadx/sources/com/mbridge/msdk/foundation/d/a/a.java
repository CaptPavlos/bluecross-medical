package com.mbridge.msdk.foundation.d.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.widget.FeedBackButton;
import com.mbridge.msdk.widget.FeedbackRadioGroup;
import com.mbridge.msdk.widget.dialog.MBFeedBackDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static int f3407a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static String f3408b;

    /* renamed from: d, reason: collision with root package name */
    private String f3410d;
    private CampaignEx e;
    private FeedBackButton g;
    private String h;

    /* renamed from: k, reason: collision with root package name */
    private String f3413k;

    /* renamed from: l, reason: collision with root package name */
    private MBFeedBackDialog f3414l;

    /* renamed from: m, reason: collision with root package name */
    private Dialog f3415m;

    /* renamed from: n, reason: collision with root package name */
    private JSONArray f3416n;

    /* renamed from: s, reason: collision with root package name */
    private int f3421s;
    private List<C0027a> t;

    /* renamed from: w, reason: collision with root package name */
    private int f3424w;

    /* renamed from: c, reason: collision with root package name */
    private float f3409c = 1.0f;
    private String f = "";

    /* renamed from: i, reason: collision with root package name */
    private float f3411i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    private int f3412j = -1;

    /* renamed from: o, reason: collision with root package name */
    private int f3417o = -1;

    /* renamed from: p, reason: collision with root package name */
    private int f3418p = -1;

    /* renamed from: q, reason: collision with root package name */
    private int f3419q = -1;

    /* renamed from: r, reason: collision with root package name */
    private int f3420r = -1;

    /* renamed from: u, reason: collision with root package name */
    private int f3422u = com.mbridge.msdk.dycreator.baseview.a.e(20.0f);

    /* renamed from: v, reason: collision with root package name */
    private String f3423v = "";

    /* renamed from: x, reason: collision with root package name */
    private com.mbridge.msdk.widget.dialog.a f3425x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.d.a.a.1
        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            a.a(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            a.b(a.this);
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            a.c(a.this);
        }
    };
    private int y = f3407a;

    /* renamed from: z, reason: collision with root package name */
    private int f3426z = -1;
    private int A = -1;
    private int B = -1;

    public a(String str) {
        this.t = new ArrayList();
        this.f3413k = str;
        if (this.t == null) {
            this.t = new ArrayList();
        }
        k();
        i();
        j();
    }

    public static /* synthetic */ void a(a aVar) {
        b.a().a(aVar.f3413k, 1, 4, f3408b, aVar.f);
        List<C0027a> list = aVar.t;
        if (list != null) {
            for (C0027a c0027a : list) {
                if (c0027a != null) {
                    c0027a.a();
                }
            }
        }
        if (!TextUtils.isEmpty(aVar.f3423v)) {
            try {
                Activity activityA = b.a().a(c.m().c());
                if (activityA != null) {
                    View viewInflate = LayoutInflater.from(activityA).inflate(x.a(activityA, "mbridge_cm_feedback_notice_layout", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
                    Dialog dialog = new Dialog(activityA, 3);
                    aVar.f3415m = dialog;
                    dialog.requestWindowFeature(1);
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                    Window window = aVar.f3415m.getWindow();
                    layoutParams.copyFrom(window.getAttributes());
                    layoutParams.width = -2;
                    layoutParams.height = -2;
                    aVar.f3415m.setContentView(viewInflate);
                    aVar.f3415m.show();
                    window.setAttributes(layoutParams);
                    viewInflate.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.d.a.a.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.f3415m == null || !a.this.f3415m.isShowing()) {
                                    return;
                                }
                                a.this.f3415m.dismiss();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f3408b = "";
    }

    public static /* synthetic */ void b(a aVar) {
        b.a().a(aVar.f3413k, 0, 4, f3408b, aVar.f);
        List<C0027a> list = aVar.t;
        if (list != null) {
            for (C0027a c0027a : list) {
                if (c0027a != null) {
                    c0027a.b();
                }
            }
        }
        f3408b = "";
    }

    public static /* synthetic */ void c(a aVar) {
        b.a().a(aVar.f3413k, 0, 4, f3408b, aVar.f);
        Context contextE = c.m().e();
        if (contextE == null) {
            contextE = c.m().c();
        }
        List<C0027a> list = aVar.t;
        if (list != null) {
            for (C0027a c0027a : list) {
                if (c0027a != null) {
                    c0027a.b();
                }
            }
        }
        aVar.a(contextE);
        f3408b = "";
    }

    private void i() {
        Context contextC = c.m().c();
        if (contextC != null) {
            try {
                FeedBackButton feedBackButton = new FeedBackButton(contextC);
                this.g = feedBackButton;
                int i10 = 8;
                if (this.y != 8) {
                    i10 = 0;
                }
                feedBackButton.setVisibility(i10);
                this.g.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.d.a.a.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.this.e();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void j() {
        try {
            if (b.a().a(c.m().c()) != null) {
                g gVarB = h.a().b(c.m().k());
                if (gVarB == null) {
                    h.a();
                    gVarB = i.a();
                }
                b.C0019b c0019bG = gVarB.G();
                if (c0019bG == null) {
                    af.c("", "feedback fbk is null");
                    return;
                }
                k();
                this.f3414l = new MBFeedBackDialog(com.mbridge.msdk.foundation.d.b.a().a(c.m().c()), this.f3425x);
                FeedbackRadioGroup feedbackRadioGroupA = a(c0019bG);
                this.f3414l.setCancelText(c0019bG.d());
                this.f3414l.setConfirmText(c0019bG.a());
                this.f3414l.setPrivacyText(c0019bG.c());
                this.f3423v = c0019bG.e();
                this.f3414l.setTitle(c0019bG.f());
                this.f3414l.setContent(feedbackRadioGroupA);
                this.f3414l.setCancelButtonClickable(!TextUtils.isEmpty(f3408b));
                a(feedbackRadioGroupA, c0019bG);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void k() {
        if (this.f3425x == null) {
            this.f3425x = new com.mbridge.msdk.widget.dialog.a() { // from class: com.mbridge.msdk.foundation.d.a.a.3
                @Override // com.mbridge.msdk.widget.dialog.a
                public final void a() {
                    a.a(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void b() {
                    a.b(a.this);
                }

                @Override // com.mbridge.msdk.widget.dialog.a
                public final void c() {
                    a.c(a.this);
                }
            };
        }
    }

    private void l() {
        FeedBackButton feedBackButton = this.g;
        if (feedBackButton != null) {
            int i10 = this.A;
            if (i10 > -1) {
                feedBackButton.setX(i10);
            }
            int i11 = this.B;
            if (i11 > -1) {
                this.g.setY(i11);
            }
            float f = this.f3409c;
            if (f >= 0.0f) {
                this.g.setAlpha(f);
                this.g.setEnabled(this.f3409c != 0.0f);
            }
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            int i12 = this.f3426z;
            if (i12 > 0) {
                this.g.setWidth(i12);
                if (layoutParams != null) {
                    layoutParams.width = this.f3426z;
                }
            }
            int i13 = this.f3412j;
            if (i13 > 0) {
                this.g.setHeight(i13);
                if (layoutParams != null) {
                    layoutParams.height = this.f3412j;
                }
            }
            if (layoutParams != null) {
                this.g.setLayoutParams(layoutParams);
            }
            try {
                if (!TextUtils.isEmpty(this.h)) {
                    this.g.setTextColor(Color.parseColor(this.h));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            float f10 = this.f3411i;
            if (f10 > 0.0f) {
                this.g.setTextSize(f10);
            }
            JSONArray jSONArray = this.f3416n;
            if (jSONArray != null && jSONArray.length() == 4) {
                Context contextC = c.m().c();
                this.g.setPadding(ak.a(contextC, (float) this.f3416n.optDouble(0)), ak.a(contextC, (float) this.f3416n.optDouble(1)), ak.a(contextC, (float) this.f3416n.optDouble(2)), ak.a(contextC, (float) this.f3416n.optDouble(3)));
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            int i14 = this.f3422u;
            if (i14 > 0) {
                gradientDrawable.setCornerRadius(i14);
            }
            if (TextUtils.isEmpty(this.f3410d)) {
                gradientDrawable.setColor(Color.parseColor(FeedBackButton.FEEDBACK_BTN_BACKGROUND_COLOR_STR));
            } else {
                gradientDrawable.setColor(Color.parseColor(this.f3410d));
            }
            this.g.setBackground(gradientDrawable);
        }
    }

    public final FeedBackButton d() {
        if (this.g == null) {
            i();
        }
        return this.g;
    }

    public final void e() {
        try {
            com.mbridge.msdk.foundation.d.b.a().a(this.f3413k, 0, 1, f3408b, this.f);
            Activity activityA = com.mbridge.msdk.foundation.d.b.a().a(c.m().c());
            MBFeedBackDialog mBFeedBackDialog = this.f3414l;
            if (mBFeedBackDialog == null || mBFeedBackDialog.getContext() != activityA) {
                j();
            }
            Context contextC = c.m().c();
            FeedBackButton feedBackButton = this.g;
            if (feedBackButton != null) {
                contextC = feedBackButton.getContext();
            }
            boolean zA = com.mbridge.msdk.foundation.d.b.a().a(this.f3413k, contextC, this.f3414l);
            int i10 = zA ? 2 : 3;
            if (i10 == 2) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f3413k, 0, 2, f3408b, this.f);
            } else {
                com.mbridge.msdk.foundation.d.b.a().a(this.f3413k, 0, 3, f3408b, this.f);
            }
            List<C0027a> list = this.t;
            if (list != null) {
                for (C0027a c0027a : list) {
                    if (c0027a != null) {
                        c0027a.a(i10);
                    }
                }
            }
            if (zA) {
                return;
            }
            a(contextC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int f() {
        return this.f3421s;
    }

    public final int g() {
        return this.f3424w;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.d.a.a$a, reason: collision with other inner class name */
    public static class C0027a implements com.mbridge.msdk.widget.dialog.a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.foundation.d.a f3433a;

        /* renamed from: b, reason: collision with root package name */
        private String f3434b;

        public C0027a(String str, com.mbridge.msdk.foundation.d.a aVar) {
            this.f3433a = aVar;
            this.f3434b = str;
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void a() {
            com.mbridge.msdk.foundation.d.b.f3437c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f3433a;
            if (aVar != null) {
                aVar.summit(a.f3408b);
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void b() {
            com.mbridge.msdk.foundation.d.b.f3437c = false;
            com.mbridge.msdk.foundation.d.a aVar = this.f3433a;
            if (aVar != null) {
                aVar.close();
            }
        }

        @Override // com.mbridge.msdk.widget.dialog.a
        public final void c() {
            com.mbridge.msdk.foundation.d.a aVar = this.f3433a;
            if (aVar != null) {
                aVar.close();
            }
        }

        public final void a(int i10) {
            com.mbridge.msdk.foundation.d.b.f3437c = true;
            com.mbridge.msdk.foundation.d.a aVar = this.f3433a;
            if (aVar == null || i10 != 2) {
                return;
            }
            aVar.showed();
        }
    }

    public final void b() {
        MBFeedBackDialog mBFeedBackDialog = this.f3414l;
        if (mBFeedBackDialog == null || !mBFeedBackDialog.isShowing()) {
            return;
        }
        this.f3414l.cancel();
    }

    public final void b(int i10) {
        this.f3424w = i10;
    }

    public final void c(int i10) {
        this.y = i10;
        FeedBackButton feedBackButton = this.g;
        if (feedBackButton != null) {
            feedBackButton.setVisibility(i10);
        }
    }

    public final CampaignEx c() {
        return this.e;
    }

    public final void a() {
        FeedBackButton feedBackButton = this.g;
        if (feedBackButton != null) {
            feedBackButton.setOnClickListener(null);
            this.g.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.g.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.g);
            }
        }
        MBFeedBackDialog mBFeedBackDialog = this.f3414l;
        if (mBFeedBackDialog != null) {
            mBFeedBackDialog.cancel();
            this.f3414l.setListener(null);
        }
        this.f3414l = null;
        this.t = null;
        this.g = null;
        this.f3425x = null;
    }

    public final void a(CampaignEx campaignEx) {
        this.e = campaignEx;
    }

    public final void a(String str) {
        this.f = str;
    }

    private void a(Context context) {
        if (context != null) {
            try {
                com.mbridge.msdk.click.c.f(context, ak.a(this.e));
            } catch (Exception unused) {
                com.mbridge.msdk.click.c.d(context, ak.a(this.e));
            }
        }
    }

    private FeedbackRadioGroup a(b.C0019b c0019b) {
        JSONArray jSONArrayB = c0019b.b();
        Context contextC = c.m().c();
        if (jSONArrayB == null || jSONArrayB.length() <= 0 || contextC == null) {
            return null;
        }
        FeedbackRadioGroup feedbackRadioGroup = new FeedbackRadioGroup(contextC);
        feedbackRadioGroup.setOrientation(0);
        return feedbackRadioGroup;
    }

    private void a(FeedbackRadioGroup feedbackRadioGroup, b.C0019b c0019b) throws Resources.NotFoundException {
        ColorStateList colorStateList;
        JSONArray jSONArrayB = c0019b.b();
        Context contextC = c.m().c();
        if (jSONArrayB == null || jSONArrayB.length() <= 0 || contextC == null) {
            return;
        }
        x.a(contextC, "mbridge_cm_feedback_choice_btn_bg", "drawable");
        Resources resourcesA = x.a(contextC);
        int iA = x.a(contextC, "mbridge_cm_feedback_rb_text_color_color_list", "color");
        if (resourcesA != null) {
            try {
                colorStateList = resourcesA.getColorStateList(iA);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            colorStateList = null;
        }
        int iA2 = ak.a(contextC, 1.0f);
        int iA3 = ak.a(contextC, 1.0f);
        int iA4 = ak.a(contextC, 1.0f);
        for (int i10 = 0; i10 < jSONArrayB.length(); i10++) {
            String strOptString = jSONArrayB.optString(i10);
            RadioButton radioButton = new RadioButton(contextC);
            radioButton.setButtonTintList(colorStateList);
            radioButton.setText(strOptString);
            if (colorStateList != null) {
                radioButton.setTextColor(colorStateList);
            }
            radioButton.setCompoundDrawablePadding(iA2);
            radioButton.setPadding(iA2, iA3, iA2, iA3);
            radioButton.setEllipsize(TextUtils.TruncateAt.END);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, -2);
            int i11 = iA4 / 4;
            layoutParams.setMargins(iA4, i11, iA4, i11);
            a(radioButton);
            feedbackRadioGroup.addView(radioButton, layoutParams);
        }
    }

    private void a(RadioButton radioButton) {
        if (radioButton != null) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mbridge.msdk.foundation.d.a.a.4
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                    if (z9) {
                        String unused = a.f3408b = (String) compoundButton.getText();
                    }
                    if (a.this.f3414l != null) {
                        a.this.f3414l.setCancelButtonClickable(!TextUtils.isEmpty(a.f3408b));
                    }
                }
            });
        }
    }

    public final void a(FeedBackButton feedBackButton) {
        FeedBackButton feedBackButton2 = this.g;
        if (feedBackButton2 != null) {
            feedBackButton2.setVisibility(8);
        }
        if (feedBackButton != null) {
            feedBackButton.setAlpha(this.f3409c);
            feedBackButton.setEnabled(this.f3409c != 0.0f);
            feedBackButton.setVisibility(this.y != 8 ? 0 : 8);
            this.g = feedBackButton;
            CampaignEx campaignEx = this.e;
            if (campaignEx != null && !campaignEx.isDynamicView()) {
                l();
            }
            feedBackButton.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.foundation.d.a.a.6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.this.e();
                }
            });
        }
    }

    public final void a(int i10) {
        this.f3421s = i10;
    }

    public final void a(int i10, int i11, int i12, int i13, int i14, float f, String str, String str2, float f10, JSONArray jSONArray) {
        if (i10 > -1) {
            this.A = i10;
        }
        if (i11 > -1) {
            this.B = i11;
        }
        if (i12 > -1) {
            this.f3426z = i12;
        }
        if (i13 > -1) {
            this.f3412j = i13;
        }
        if (f10 > -1.0f) {
            this.f3411i = f10;
        }
        if (jSONArray != null) {
            this.f3416n = jSONArray;
        }
        this.h = str;
        this.f3410d = str2;
        this.f3409c = f;
        this.f3422u = i14;
        l();
    }

    public final void a(C0027a c0027a) {
        if (this.t == null) {
            this.t = new ArrayList();
        }
        this.t.add(c0027a);
    }
}

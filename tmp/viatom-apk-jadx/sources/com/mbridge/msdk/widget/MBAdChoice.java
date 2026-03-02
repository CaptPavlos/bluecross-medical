package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.same.net.e.d;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.out.Campaign;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBAdChoice extends MBImageView {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6603a;

    /* renamed from: b, reason: collision with root package name */
    private String f6604b;

    /* renamed from: c, reason: collision with root package name */
    private String f6605c;

    /* renamed from: d, reason: collision with root package name */
    private String f6606d;
    private CampaignEx e;
    private com.mbridge.msdk.foundation.d.a f;

    public MBAdChoice(Context context) {
        super(context);
        this.f6604b = "";
        this.f6605c = "";
        this.f6606d = "";
        this.f6603a = context;
        a();
    }

    private void a() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f == null) {
            this.f = new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.widget.MBAdChoice.1
                @Override // com.mbridge.msdk.foundation.d.a
                public final void close() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void showed() {
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void summit(String str) {
                }
            };
        }
        ak.a(this.e, this.f, 4, "");
        return true;
    }

    public void setCampaign(Campaign campaign) {
        if (!(campaign instanceof CampaignEx)) {
            this.e = null;
            return;
        }
        CampaignEx campaignEx = (CampaignEx) campaign;
        this.e = campaignEx;
        g gVarS = androidx.constraintlayout.core.widgets.analyzer.a.s(h.a());
        this.e = campaignEx;
        String privacyUrl = campaignEx.getPrivacyUrl();
        this.f6605c = privacyUrl;
        if (TextUtils.isEmpty(privacyUrl)) {
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                this.f6605c = adchoice.c();
            }
            if (TextUtils.isEmpty(this.f6605c) && gVarS != null) {
                this.f6605c = gVarS.j();
            }
            if (TextUtils.isEmpty(this.f6605c)) {
                this.f6605c = d.f().f;
            }
        }
        this.e = campaignEx;
        CampaignEx.a adchoice2 = campaignEx.getAdchoice();
        if (adchoice2 != null) {
            this.f6604b = adchoice2.b();
        }
        if (TextUtils.isEmpty(this.f6604b) && gVarS != null) {
            this.f6604b = gVarS.i();
        }
        this.e = campaignEx;
        CampaignEx.a adchoice3 = campaignEx.getAdchoice();
        if (adchoice3 != null) {
            this.f6606d = adchoice3.d();
        }
        if (TextUtils.isEmpty(this.f6606d) && gVarS != null) {
            this.f6606d = gVarS.k();
        }
        boolean z9 = (TextUtils.isEmpty(this.f6604b) || TextUtils.isEmpty(this.f6605c) || TextUtils.isEmpty(this.f6606d)) ? false : true;
        setImageUrl(this.f6604b);
        if (!z9 || this.f6603a == null) {
            return;
        }
        b.a(c.m().c()).a(this.f6604b, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.widget.MBAdChoice.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                MBAdChoice.this.setImageBitmap(bitmap);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }
        });
    }

    public void setFeedbackDialogEventListener(com.mbridge.msdk.foundation.d.a aVar) {
        this.f = aVar;
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6604b = "";
        this.f6605c = "";
        this.f6606d = "";
        this.f6603a = context;
        a();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f6604b = "";
        this.f6605c = "";
        this.f6606d = "";
        this.f6603a = context;
        a();
    }
}

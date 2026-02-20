package com.mbridge.msdk.newreward.function.c.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.function.c.c.d;
import com.mbridge.msdk.newreward.function.c.c.f;
import com.mbridge.msdk.newreward.function.c.c.g;
import com.mbridge.msdk.newreward.function.c.c.h;
import com.mbridge.msdk.newreward.function.c.c.j;
import com.mbridge.msdk.newreward.function.c.c.k;
import com.mbridge.msdk.newreward.function.c.c.l;
import com.mbridge.msdk.newreward.function.c.c.m;
import com.mbridge.msdk.newreward.function.c.c.n;
import com.mbridge.msdk.newreward.function.h.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f4658a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f4659b;

    /* renamed from: c, reason: collision with root package name */
    private String f4660c;

    /* renamed from: d, reason: collision with root package name */
    private String f4661d;
    private String e;
    private d<?> f;
    private n g;
    private d<?> h;

    /* renamed from: i, reason: collision with root package name */
    private l f4662i;

    /* renamed from: j, reason: collision with root package name */
    private h f4663j;

    /* renamed from: k, reason: collision with root package name */
    private m f4664k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4665l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4666m = false;

    public a(b bVar) {
        this.f4658a = bVar;
    }

    public final m a() {
        CampaignEx.c rewardTemplateMode;
        m mVar = this.f4664k;
        if (mVar != null) {
            return mVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) {
            return null;
        }
        String strC = rewardTemplateMode.c();
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        if (this.f4664k == null) {
            this.f4664k = new m(this.f4658a, this, strC);
        }
        return this.f4664k;
    }

    public final h b() {
        h hVar = this.f4663j;
        if (hVar != null) {
            return hVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getEndScreenUrl())) {
            return null;
        }
        if (this.f4663j == null) {
            this.f4663j = new h(this.f4658a, this);
        }
        return this.f4663j;
    }

    public final d<?> c() {
        d<?> dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null || campaignEx.getRewardTemplateMode() == null) {
            return null;
        }
        String strE = campaignEx.getRewardTemplateMode().e();
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        if (this.f == null) {
            boolean zB = c.b(strE);
            b bVar = this.f4658a;
            if (zB) {
                this.f = new g(bVar, this);
            } else {
                this.f = new k(bVar, this);
            }
        }
        return this.f;
    }

    public final n d() {
        n nVar = this.g;
        if (nVar != null) {
            return nVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            return null;
        }
        if (this.g == null) {
            this.g = new n(this.f4658a, this);
        }
        return this.g;
    }

    public final l e() {
        l lVar = this.f4662i;
        if (lVar != null) {
            return lVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null || TextUtils.isEmpty(campaignEx.getMraid())) {
            return null;
        }
        if (this.f4662i == null) {
            this.f4662i = new l(this.f4658a, this);
        }
        return this.f4662i;
    }

    public final d<?> f() {
        d<?> dVar = this.h;
        if (dVar != null) {
            return dVar;
        }
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx == null) {
            return null;
        }
        String str = campaignEx.getendcard_url();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.h == null) {
            if (c.b(str)) {
                boolean zL = ak.l(str);
                b bVar = this.f4658a;
                if (zL) {
                    this.h = new j(bVar, this);
                } else {
                    this.h = new f(bVar, this);
                }
            } else {
                this.h = new j(this.f4658a, this);
            }
        }
        return this.h;
    }

    public final String g() {
        return this.e;
    }

    public final CampaignEx h() {
        return this.f4659b;
    }

    public final b i() {
        return this.f4658a;
    }

    public final boolean j() {
        CampaignEx campaignEx = this.f4659b;
        if (campaignEx != null) {
            return campaignEx.isMraid();
        }
        return false;
    }

    public final boolean k() {
        return this.f4665l;
    }

    public final boolean l() {
        return this.f4666m;
    }

    public final void b(String str) {
        this.f4661d = str;
    }

    public final void b(boolean z9) {
        this.f4666m = z9;
    }

    public final void a(String str) {
        this.f4660c = str;
    }

    public final void a(CampaignEx campaignEx) {
        this.f4659b = campaignEx;
    }

    public final void a(boolean z9) {
        this.f4665l = z9;
    }

    public final void c(String str) {
        this.e = str;
    }
}

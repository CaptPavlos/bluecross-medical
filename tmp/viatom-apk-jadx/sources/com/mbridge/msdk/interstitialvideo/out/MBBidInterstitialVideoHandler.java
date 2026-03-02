package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.reward.b.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes3.dex */
public class MBBidInterstitialVideoHandler {

    /* renamed from: a, reason: collision with root package name */
    private a f4128a;

    /* renamed from: b, reason: collision with root package name */
    private String f4129b;

    /* renamed from: c, reason: collision with root package name */
    private String f4130c;

    /* renamed from: d, reason: collision with root package name */
    private String f4131d;
    private String e;
    private String f;
    private String g;
    private d h;

    /* renamed from: j, reason: collision with root package name */
    private InterstitialVideoListener f4133j;

    /* renamed from: p, reason: collision with root package name */
    private int f4139p;

    /* renamed from: q, reason: collision with root package name */
    private int f4140q;

    /* renamed from: r, reason: collision with root package name */
    private int f4141r;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4132i = false;

    /* renamed from: k, reason: collision with root package name */
    private int f4134k = 2;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4135l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4136m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4137n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4138o = false;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.f4129b = str2;
        this.f4130c = str;
    }

    private void a() {
        if (this.f4128a == null) {
            a(this.f4130c, this.f4129b);
        }
        if (this.f4136m) {
            a aVar = this.f4128a;
            if (aVar != null) {
                aVar.a(new com.mbridge.msdk.interstitialvideo.a.a(this.f4133j, this.f4129b, true));
            }
            this.f4136m = false;
        }
        if (this.f4137n) {
            a aVar2 = this.f4128a;
            if (aVar2 != null) {
                aVar2.a(this.f4131d, this.e, this.f, this.g);
            }
            this.f4137n = false;
        }
        a aVar3 = this.f4128a;
        if (aVar3 != null) {
            aVar3.a(this.f4139p, this.f4141r, this.f4140q);
            this.f4128a.a(this.f4134k);
        }
    }

    private void b() {
        if (this.h == null) {
            b(this.f4130c, this.f4129b);
        }
        if (this.f4135l) {
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(new InterstitialVideoListenerWrapper(this.f4133j));
            }
            this.f4135l = false;
        }
        if (this.f4138o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f4129b, this.f4131d, this.e, this.f, this.g);
            this.f4138o = false;
        }
        d dVar2 = this.h;
        if (dVar2 != null) {
            dVar2.a(this.f4139p, this.f4141r, this.f4140q);
            this.h.a(this.f4134k);
        }
    }

    public void clearVideoCache() {
        if (this.f4132i) {
            return;
        }
        try {
            if (this.f4128a != null) {
                ad.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f4132i) {
            d dVar = this.h;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f4128a;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.f4132i) {
            d dVar = this.h;
            return dVar != null ? dVar.b() : "";
        }
        a aVar = this.f4128a;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.f4132i) {
            d dVar = this.h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f4128a;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4132i = zA;
        if (zA) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f4128a != null) {
            this.f4128a.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f4129b, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4132i = zA;
        if (zA) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f4128a != null) {
            this.f4128a.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f4129b, true, 2));
        }
    }

    public void playVideoMute(int i10) {
        this.f4134k = i10;
        if (this.f4132i) {
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(i10);
                return;
            }
            return;
        }
        a aVar = this.f4128a;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f4131d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.f4137n = true;
        this.f4138o = true;
    }

    public void setIVRewardEnable(int i10, double d8) {
        this.f4139p = i10;
        this.f4140q = (int) (d8 * 100.0d);
        this.f4141r = com.mbridge.msdk.foundation.same.a.J;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f4133j = interstitialVideoListener;
        this.f4136m = true;
        this.f4135l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f4133j = interstitialVideoListener;
        this.f4136m = true;
        this.f4135l = true;
    }

    public void showFromBid() {
        if (this.f4132i) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f4128a != null) {
            this.f4128a.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.f4129b, false, -1));
        }
    }

    public void setIVRewardEnable(int i10, int i11) {
        this.f4139p = i10;
        this.f4140q = i11;
        this.f4141r = com.mbridge.msdk.foundation.same.a.K;
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.f4129b = str2;
        this.f4130c = str;
    }

    private void b(String str, String str2) {
        if (this.h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.h = new d(287, str, str2, true);
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f4128a == null) {
                a aVar = new a();
                this.f4128a = aVar;
                aVar.a(true);
                this.f4128a.b(true);
                this.f4128a.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidRewardVideoHandler", th.getMessage(), th);
        }
    }
}

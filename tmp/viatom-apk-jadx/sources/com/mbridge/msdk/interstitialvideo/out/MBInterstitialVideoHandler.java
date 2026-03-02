package com.mbridge.msdk.interstitialvideo.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.h;
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
public class MBInterstitialVideoHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f4142a;

    /* renamed from: b, reason: collision with root package name */
    private a f4143b;

    /* renamed from: c, reason: collision with root package name */
    private String f4144c;

    /* renamed from: d, reason: collision with root package name */
    private String f4145d;
    private String e;
    private String f;
    private String g;
    private d h;

    /* renamed from: j, reason: collision with root package name */
    private InterstitialVideoListener f4147j;

    /* renamed from: p, reason: collision with root package name */
    private int f4153p;

    /* renamed from: q, reason: collision with root package name */
    private int f4154q;

    /* renamed from: r, reason: collision with root package name */
    private int f4155r;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4146i = false;

    /* renamed from: k, reason: collision with root package name */
    private int f4148k = 2;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4149l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4150m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4151n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4152o = false;

    public MBInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.f4142a = str;
        this.f4144c = str2;
    }

    private void a() {
        if (this.f4143b == null) {
            a(this.f4142a, this.f4144c);
        }
        if (this.f4150m) {
            this.f4143b.a(new com.mbridge.msdk.interstitialvideo.a.a(this.f4147j, this.f4144c, false));
            this.f4150m = false;
        }
        if (this.f4151n) {
            this.f4143b.a(this.f4145d, this.e, this.f, this.g);
            this.f4151n = false;
        }
        a aVar = this.f4143b;
        if (aVar != null) {
            aVar.a(this.f4153p, this.f4155r, this.f4154q);
            this.f4143b.a(this.f4148k);
        }
    }

    private void b() {
        if (this.h == null) {
            b(this.f4142a, this.f4144c);
        }
        if (this.f4149l) {
            this.h.a(new InterstitialVideoListenerWrapper(this.f4147j));
            this.f4149l = false;
        }
        if (this.f4152o) {
            MBridgeGlobalCommon.setAlertDialogText(this.f4144c, this.f4145d, this.e, this.f, this.g);
            this.f4152o = false;
        }
        d dVar = this.h;
        if (dVar != null) {
            dVar.a(this.f4153p, this.f4155r, this.f4154q);
            this.h.a(this.f4148k);
        }
    }

    public void clearVideoCache() {
        if (this.f4146i) {
            return;
        }
        try {
            if (this.f4143b != null) {
                ad.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.f4146i) {
            d dVar = this.h;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f4143b;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.f4146i) {
            d dVar = this.h;
            return dVar != null ? dVar.b() : "";
        }
        a aVar = this.f4143b;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isReady() {
        if (this.f4146i) {
            d dVar = this.h;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f4143b;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void load() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4146i = zA;
        if (zA) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(true, "");
                return;
            }
            return;
        }
        a();
        if (this.f4143b != null) {
            this.f4143b.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f4144c, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4146i = zA;
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
        if (this.f4143b != null) {
            this.f4143b.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f4144c, true, 1));
        }
    }

    public void playVideoMute(int i10) {
        this.f4148k = i10;
        if (this.f4146i) {
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(i10);
                return;
            }
            return;
        }
        a aVar = this.f4143b;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f4145d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.f4151n = true;
        this.f4152o = true;
    }

    public void setIVRewardEnable(int i10, double d8) {
        this.f4153p = i10;
        this.f4154q = (int) (d8 * 100.0d);
        this.f4155r = com.mbridge.msdk.foundation.same.a.J;
    }

    public void setInterstitialVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f4147j = interstitialVideoListener;
        this.f4150m = true;
        this.f4149l = true;
    }

    @Deprecated
    public void setRewardVideoListener(InterstitialVideoListener interstitialVideoListener) {
        this.f4147j = interstitialVideoListener;
        this.f4150m = true;
        this.f4149l = true;
    }

    public void show() {
        if (this.f4146i) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f4143b != null) {
            this.f4143b.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.f4144c, false, -1));
        }
    }

    public void setIVRewardEnable(int i10, int i11) {
        this.f4153p = i10;
        this.f4154q = i11;
        this.f4155r = com.mbridge.msdk.foundation.same.a.K;
    }

    public MBInterstitialVideoHandler(String str, String str2) {
        this.f4144c = str2;
        this.f4142a = str;
    }

    private void b(String str, String str2) {
        if (this.h == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.h = new d(287, str, TextUtils.isEmpty(str2) ? "" : str2, false);
            h.a().e(str2);
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f4143b == null) {
                a aVar = new a();
                this.f4143b = aVar;
                aVar.a(true);
                this.f4143b.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }
}

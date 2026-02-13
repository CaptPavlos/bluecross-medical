package com.mbridge.msdk.newinterstitial.out;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.newreward.b.d;
import com.mbridge.msdk.newreward.function.common.MBridgeGlobalCommon;
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes3.dex */
public class MBBidInterstitialVideoHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f4442a;

    /* renamed from: b, reason: collision with root package name */
    private String f4443b;

    /* renamed from: c, reason: collision with root package name */
    private String f4444c;

    /* renamed from: d, reason: collision with root package name */
    private String f4445d;
    private String e;
    private a f;
    private d g;

    /* renamed from: i, reason: collision with root package name */
    private NewInterstitialListener f4446i;
    public String mUnitId;

    /* renamed from: o, reason: collision with root package name */
    private int f4452o;

    /* renamed from: p, reason: collision with root package name */
    private int f4453p;

    /* renamed from: q, reason: collision with root package name */
    private int f4454q;
    private boolean h = false;

    /* renamed from: j, reason: collision with root package name */
    private int f4447j = 2;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4448k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4449l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4450m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4451n = false;

    public MBBidInterstitialVideoHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.mUnitId = str2;
        this.f4442a = str;
    }

    private void a(String str, String str2) {
        try {
            if (this.f == null) {
                a aVar = new a();
                this.f = aVar;
                aVar.a(true);
                this.f.b(true);
                this.f.b(str, str2);
            }
        } catch (Throwable th) {
            af.b("MBBidInterstitialVideoHandler", th.getMessage(), th);
        }
    }

    private void b() {
        if (this.f4449l) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.a(new com.mbridge.msdk.newinterstitial.a.a(this.f4446i));
            }
            this.f4449l = false;
        }
        if (this.f4450m) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(this.f4444c, this.f4443b, this.f4445d, this.e);
            }
            this.f4450m = false;
        }
        a aVar3 = this.f;
        if (aVar3 != null) {
            aVar3.a(this.f4452o, this.f4454q, this.f4453p);
            this.f.a(this.f4447j);
        }
    }

    private void c() {
        if (this.g == null) {
            b(this.f4442a, this.mUnitId);
        }
        d();
    }

    private void d() {
        if (this.f4448k) {
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(new NewInterstitialListenerWrapper(this.f4446i));
            }
            this.f4448k = false;
        }
        if (this.f4451n) {
            MBridgeGlobalCommon.setAlertDialogText(this.mUnitId, this.f4444c, this.f4443b, this.f4445d, this.e);
            this.f4451n = false;
        }
        d dVar2 = this.g;
        if (dVar2 != null) {
            dVar2.a(this.f4452o, this.f4454q, this.f4453p);
            this.g.a(this.f4447j);
        }
    }

    public void clearVideoCache() {
        if (this.h) {
            return;
        }
        try {
            if (this.f != null) {
                ad.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCreativeIdWithUnitId() {
        if (this.h) {
            d dVar = this.g;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.h) {
            d dVar = this.g;
            return dVar != null ? dVar.b() : "";
        }
        a aVar = this.f;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isBidReady() {
        if (this.h) {
            d dVar = this.g;
            if (dVar != null) {
                return dVar.a(true);
            }
            return false;
        }
        a aVar = this.f;
        if (aVar != null) {
            return aVar.d(true);
        }
        return false;
    }

    public void loadFormSelfFilling() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.h = zA;
        if (zA) {
            c();
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(false, "");
                return;
            }
            return;
        }
        a();
        if (this.f != null) {
            this.f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 1));
        }
    }

    public void loadFromBid(String str) {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.h = zA;
        if (zA) {
            c();
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(true, str);
                return;
            }
            return;
        }
        a();
        if (this.f != null) {
            this.f.a(true, str, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, true, 2));
        }
    }

    public void playVideoMute(int i10) {
        this.f4447j = i10;
        if (this.h) {
            d dVar = this.g;
            if (dVar != null) {
                dVar.a(i10);
                return;
            }
            return;
        }
        a aVar = this.f;
        if (aVar != null) {
            aVar.a(i10);
        }
    }

    public void setAlertDialogText(String str, String str2, String str3, String str4) {
        this.f4444c = str;
        this.f4443b = str2;
        this.f4445d = str3;
        this.e = str4;
        this.f4451n = true;
        this.f4450m = true;
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) throws JSONException {
        c.m().a(this.mUnitId, jSONObject);
    }

    public void setIVRewardEnable(int i10, double d8) {
        this.f4452o = i10;
        this.f4453p = (int) (d8 * 100.0d);
        this.f4454q = com.mbridge.msdk.foundation.same.a.J;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f4446i = newInterstitialListener;
        this.f4448k = true;
        this.f4449l = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f4446i = newInterstitialListener;
        this.f4448k = true;
        this.f4449l = true;
    }

    public void showFromBid() {
        if (this.h) {
            c();
            d dVar = this.g;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f != null) {
            this.f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(1, 287, this.mUnitId, false, -1));
        }
    }

    public void setIVRewardEnable(int i10, int i11) {
        this.f4452o = i10;
        this.f4453p = i11;
        this.f4454q = com.mbridge.msdk.foundation.same.a.K;
    }

    private void a() {
        if (this.f == null) {
            a(this.f4442a, this.mUnitId);
        }
        b();
    }

    public MBBidInterstitialVideoHandler(String str, String str2) {
        this.mUnitId = str2;
        this.f4442a = str;
    }

    private void b(String str, String str2) {
        if (this.g == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            this.g = new d(287, str, str2, true);
        }
    }
}

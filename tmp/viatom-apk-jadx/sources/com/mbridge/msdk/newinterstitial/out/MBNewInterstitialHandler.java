package com.mbridge.msdk.newinterstitial.out;

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
import com.mbridge.msdk.out.BaseExtraInterfaceForHandler;
import com.mbridge.msdk.reward.b.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBNewInterstitialHandler implements BaseExtraInterfaceForHandler {

    /* renamed from: a, reason: collision with root package name */
    private String f4469a;

    /* renamed from: b, reason: collision with root package name */
    private String f4470b;

    /* renamed from: c, reason: collision with root package name */
    private String f4471c;

    /* renamed from: d, reason: collision with root package name */
    private String f4472d;
    private String e;
    private a f;
    private String g;
    private d h;

    /* renamed from: j, reason: collision with root package name */
    private NewInterstitialListener f4474j;

    /* renamed from: p, reason: collision with root package name */
    private int f4480p;

    /* renamed from: q, reason: collision with root package name */
    private int f4481q;

    /* renamed from: r, reason: collision with root package name */
    private int f4482r;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4473i = false;

    /* renamed from: k, reason: collision with root package name */
    private int f4475k = 2;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4476l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4477m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4478n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4479o = false;

    public MBNewInterstitialHandler(Context context, String str, String str2) {
        if (c.m().c() == null && context != null) {
            c.m().b(context);
        }
        String strE = ak.e(str2);
        if (!TextUtils.isEmpty(strE)) {
            ak.b(str2, strE);
        }
        this.f4469a = str;
        this.g = str2;
    }

    private void a() {
        if (this.f == null) {
            a(this.f4469a, this.g);
        }
        if (this.f4477m) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.a(new com.mbridge.msdk.newinterstitial.a.a(this.f4474j, this.g, false));
            }
            this.f4477m = false;
        }
        if (this.f4478n) {
            a aVar2 = this.f;
            if (aVar2 != null) {
                aVar2.a(this.f4470b, this.f4471c, this.f4472d, this.e);
            }
            this.f4478n = false;
        }
        a aVar3 = this.f;
        if (aVar3 != null) {
            aVar3.a(this.f4480p, this.f4482r, this.f4481q);
            this.f.a(this.f4475k);
        }
    }

    private void b() {
        if (this.h == null) {
            b(this.f4469a, this.g);
        }
        if (this.f4476l) {
            d dVar = this.h;
            if (dVar != null) {
                dVar.a(new NewInterstitialListenerWrapper(this.f4474j));
            }
            this.f4476l = false;
        }
        if (this.f4479o) {
            MBridgeGlobalCommon.setAlertDialogText(this.g, this.f4470b, this.f4471c, this.f4472d, this.e);
            this.f4479o = false;
        }
        d dVar2 = this.h;
        if (dVar2 != null) {
            dVar2.a(this.f4480p, this.f4482r, this.f4481q);
            this.h.a(this.f4475k);
        }
    }

    public void clearVideoCache() {
        if (this.f4473i) {
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
        if (this.f4473i) {
            d dVar = this.h;
            return dVar != null ? dVar.c() : "";
        }
        a aVar = this.f;
        return aVar != null ? aVar.d() : "";
    }

    public String getRequestId() {
        if (this.f4473i) {
            d dVar = this.h;
            return dVar != null ? dVar.b() : "";
        }
        a aVar = this.f;
        return aVar != null ? aVar.a() : "";
    }

    public boolean isReady() {
        if (this.f4473i) {
            d dVar = this.h;
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

    public void load() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4473i = zA;
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
        if (this.f != null) {
            this.f.a(true, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.g, true, 2));
        }
    }

    public void loadFormSelfFilling() {
        boolean zA = b.a().a("new_bridge_reward_video");
        this.f4473i = zA;
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
        if (this.f != null) {
            this.f.a(false, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.g, true, 1));
        }
    }

    public void playVideoMute(int i10) {
        this.f4475k = i10;
        if (this.f4473i) {
            d dVar = this.h;
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
        this.f4470b = str;
        this.f4471c = str2;
        this.f4472d = str3;
        this.e = str4;
        this.f4478n = true;
        this.f4479o = true;
    }

    @Override // com.mbridge.msdk.out.BaseExtraInterfaceForHandler
    public void setExtraInfo(JSONObject jSONObject) throws JSONException {
        c.m().a(this.g, jSONObject);
    }

    public void setIVRewardEnable(int i10, double d8) {
        this.f4480p = i10;
        this.f4481q = (int) (d8 * 100.0d);
        this.f4482r = com.mbridge.msdk.foundation.same.a.J;
    }

    public void setInterstitialVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f4474j = newInterstitialListener;
        this.f4476l = true;
        this.f4477m = true;
    }

    @Deprecated
    public void setRewardVideoListener(NewInterstitialListener newInterstitialListener) {
        this.f4474j = newInterstitialListener;
        this.f4476l = true;
        this.f4477m = true;
    }

    public void show() {
        if (this.f4473i) {
            b();
            d dVar = this.h;
            if (dVar != null) {
                dVar.a("", "", "");
                return;
            }
            return;
        }
        a();
        if (this.f != null) {
            this.f.a((String) null, (String) null, (String) null, com.mbridge.msdk.foundation.same.report.d.d.a().a(0, 287, this.g, false, -1));
        }
    }

    public void setIVRewardEnable(int i10, int i11) {
        this.f4480p = i10;
        this.f4481q = i11;
        this.f4482r = com.mbridge.msdk.foundation.same.a.K;
    }

    public MBNewInterstitialHandler(String str, String str2) {
        this.f4469a = str;
        this.g = str2;
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
            if (this.f == null) {
                a aVar = new a();
                this.f = aVar;
                aVar.a(true);
                this.f.b(str, str2);
                h.a().e(str2);
            }
        } catch (Throwable th) {
            af.b("MBRewardVideoHandler", th.getMessage(), th);
        }
    }
}

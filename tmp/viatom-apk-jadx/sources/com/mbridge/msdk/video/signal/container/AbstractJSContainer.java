package com.mbridge.msdk.video.signal.container;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.widget.FrameLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.video.signal.a.k;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;
import com.mbridge.msdk.videocommon.a;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class AbstractJSContainer extends FrameLayout implements IJSFactory {

    /* renamed from: a, reason: collision with root package name */
    private int f6447a;

    /* renamed from: b, reason: collision with root package name */
    private int f6448b;

    /* renamed from: i, reason: collision with root package name */
    protected Activity f6449i;

    /* renamed from: j, reason: collision with root package name */
    protected String f6450j;

    /* renamed from: k, reason: collision with root package name */
    protected String f6451k;

    /* renamed from: l, reason: collision with root package name */
    protected c f6452l;

    /* renamed from: m, reason: collision with root package name */
    protected String f6453m;

    /* renamed from: n, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.b.c f6454n;

    /* renamed from: o, reason: collision with root package name */
    protected String f6455o;

    /* renamed from: p, reason: collision with root package name */
    protected int f6456p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f6457q;

    /* renamed from: r, reason: collision with root package name */
    protected boolean f6458r;

    /* renamed from: s, reason: collision with root package name */
    protected int f6459s;
    protected int t;

    /* renamed from: u, reason: collision with root package name */
    protected int f6460u;

    /* renamed from: v, reason: collision with root package name */
    protected boolean f6461v;

    /* renamed from: w, reason: collision with root package name */
    protected IJSFactory f6462w;

    public AbstractJSContainer(Context context) {
        super(context);
        this.f6447a = 0;
        this.f6448b = 1;
        this.f6456p = 2;
        this.f6457q = false;
        this.f6458r = false;
        this.f6461v = false;
        this.f6462w = new a();
    }

    private String a(int i10) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i10);
            String string = jSONObject.toString();
            return !TextUtils.isEmpty(string) ? Base64.encodeToString(string.getBytes(), 2) : "";
        } catch (Throwable unused) {
            af.b("AbstractJSContainer", "code to string is error");
            return "";
        }
    }

    public final k b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return null;
        }
        a.C0071a c0071aA = com.mbridge.msdk.videocommon.a.a(this.f6457q ? 287 : 94, campaignEx);
        if (c0071aA != null && c0071aA.c()) {
            WindVaneWebView windVaneWebViewA = c0071aA.a();
            if (windVaneWebViewA.getObject() instanceof k) {
                return (k) windVaneWebViewA.getObject();
            }
        }
        return null;
    }

    public final int c(CampaignEx campaignEx) {
        k kVarB = b(campaignEx);
        if (kVarB != null) {
            return kVarB.o();
        }
        return 0;
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public b getActivityProxy() {
        return this.f6462w.getActivityProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public i getIJSRewardVideoV1() {
        return this.f6462w.getIJSRewardVideoV1();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public com.mbridge.msdk.video.signal.c getJSBTModule() {
        return this.f6462w.getJSBTModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public d getJSCommon() {
        return this.f6462w.getJSCommon();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public f getJSContainerModule() {
        return this.f6462w.getJSContainerModule();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public g getJSNotifyProxy() {
        return this.f6462w.getJSNotifyProxy();
    }

    @Override // com.mbridge.msdk.video.signal.factory.IJSFactory
    public j getJSVideoModule() {
        return this.f6462w.getJSVideoModule();
    }

    public String getPlacementId() {
        return this.f6451k;
    }

    public String getUnitId() {
        return this.f6450j;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        if (getJSCommon().b()) {
            getActivityProxy().c();
        }
    }

    public void onPause() {
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onRestart() {
        if (getJSCommon().b()) {
            getActivityProxy().f();
        }
        getActivityProxy().a(4);
    }

    public void onResume() {
        if (com.mbridge.msdk.foundation.d.b.f3437c) {
            return;
        }
        if (getJSCommon().b()) {
            getActivityProxy().b();
        }
        getActivityProxy().a(0);
    }

    public void onStart() {
        if (getJSCommon().b()) {
            getActivityProxy().e();
        }
        getActivityProxy().a(2);
    }

    public void onStop() {
        if (getJSCommon().b()) {
            getActivityProxy().d();
        }
        getActivityProxy().a(3);
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.f6462w = iJSFactory;
    }

    public void setActivity(Activity activity) {
        this.f6449i = activity;
    }

    public void setBidCampaign(boolean z9) {
        this.f6458r = z9;
    }

    public void setBigOffer(boolean z9) {
        this.f6461v = z9;
    }

    public void setIV(boolean z9) {
        this.f6457q = z9;
    }

    public void setIVRewardEnable(int i10, int i11, int i12) {
        this.f6459s = i10;
        this.t = i11;
        this.f6460u = i12;
    }

    public void setMute(int i10) {
        this.f6456p = i10;
    }

    public void setPlacementId(String str) {
        this.f6451k = str;
    }

    public void setReward(com.mbridge.msdk.videocommon.b.c cVar) {
        this.f6454n = cVar;
    }

    public void setRewardId(String str) {
        this.f6455o = str;
    }

    public void setRewardUnitSetting(c cVar) {
        this.f6452l = cVar;
    }

    public void setUnitId(String str) {
        this.f6450j = str;
    }

    public void setUserId(String str) {
        this.f6453m = str;
    }

    public AbstractJSContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6447a = 0;
        this.f6448b = 1;
        this.f6456p = 2;
        this.f6457q = false;
        this.f6458r = false;
        this.f6461v = false;
        this.f6462w = new com.mbridge.msdk.video.signal.factory.a();
    }

    public final void a(Object obj, String str) {
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().b(obj, Base64.encodeToString(str.getBytes(), 2));
    }

    public final void a(Object obj) {
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, a(this.f6447a));
    }

    public void a(String str) {
        af.b("AbstractJSContainer", str);
        Activity activity = this.f6449i;
        if (activity != null) {
            activity.finish();
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private boolean b(int i10) {
        try {
            if (i10 == 1) {
                this.f6449i.setRequestedOrientation(12);
                return true;
            }
            if (i10 != 2) {
                return false;
            }
            this.f6449i.setRequestedOrientation(11);
            return true;
        } catch (Throwable th) {
            af.b("AbstractJSContainer", th.getMessage(), th);
            return false;
        }
    }

    public final void a(c cVar, CampaignEx campaignEx) {
        CampaignEx.c rewardTemplateMode;
        if (c(campaignEx) == 1) {
            return;
        }
        if (((campaignEx == null || (rewardTemplateMode = campaignEx.getRewardTemplateMode()) == null) ? false : b(rewardTemplateMode.b())) || cVar == null) {
            return;
        }
        b(this.f6452l.c());
    }

    public final String b() {
        c cVar;
        if (TextUtils.isEmpty(this.f6451k) && (cVar = this.f6452l) != null && !TextUtils.isEmpty(cVar.z())) {
            return this.f6452l.z();
        }
        return this.f6451k;
    }
}

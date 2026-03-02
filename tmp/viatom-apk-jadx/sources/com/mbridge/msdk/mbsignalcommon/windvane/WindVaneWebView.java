package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.mbsignalcommon.base.BaseWebView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class WindVaneWebView extends BaseWebView {

    /* renamed from: b, reason: collision with root package name */
    protected k f4394b;

    /* renamed from: c, reason: collision with root package name */
    protected c f4395c;

    /* renamed from: d, reason: collision with root package name */
    protected f f4396d;
    private Object e;
    private Object f;
    private String g;
    private d h;

    /* renamed from: i, reason: collision with root package name */
    private String f4397i;

    /* renamed from: j, reason: collision with root package name */
    private String f4398j;

    /* renamed from: k, reason: collision with root package name */
    private CampaignEx f4399k;

    /* renamed from: l, reason: collision with root package name */
    private int f4400l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4401m;

    /* renamed from: n, reason: collision with root package name */
    private float f4402n;

    /* renamed from: o, reason: collision with root package name */
    private float f4403o;

    public WindVaneWebView(Context context) {
        super(context);
        this.f4401m = false;
        this.f4402n = 0.0f;
        this.f4403o = 0.0f;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.BaseWebView
    public final void a() {
        super.a();
        getSettings().setSavePassword(false);
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " WindVane/3.0.2");
        if (this.f4394b == null) {
            this.f4394b = new k(this);
        }
        setWebViewChromeClient(this.f4394b);
        l lVar = new l();
        this.mWebViewClient = lVar;
        setWebViewClient(lVar);
        if (this.f4395c == null) {
            c iVar = new i(this.f4313a);
            this.f4395c = iVar;
            setSignalCommunication(iVar);
        }
        this.f4396d = new f(this.f4313a, this);
    }

    public void clearWebView() {
        if (this.f4401m) {
            return;
        }
        loadUrl("about:blank");
    }

    public CampaignEx getCampaignEx() {
        return this.f4399k;
    }

    public String getCampaignId() {
        return this.g;
    }

    public Object getJsObject(String str) {
        f fVar = this.f4396d;
        if (fVar == null) {
            return null;
        }
        return fVar.a(str);
    }

    public String getLocalRequestId() {
        return this.f4398j;
    }

    public Object getMraidObject() {
        return this.f;
    }

    public Object getObject() {
        return this.e;
    }

    public String getRid() {
        return this.f4397i;
    }

    public c getSignalCommunication() {
        return this.f4395c;
    }

    public d getWebViewListener() {
        return this.h;
    }

    public boolean isDestoryed() {
        return this.f4401m;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null && (bVar.b() instanceof IntentFilter)) {
            String url = getUrl();
            if (!TextUtils.isEmpty(url) && url.contains("https://play.google.com")) {
                if (motionEvent.getAction() == 0) {
                    this.f4402n = motionEvent.getRawX();
                    this.f4403o = motionEvent.getRawY();
                } else {
                    float rawX = motionEvent.getRawX() - this.f4402n;
                    float y = motionEvent.getY() - this.f4403o;
                    if ((rawX >= 0.0f || rawX * (-1.0f) <= 48) && ((rawX <= 0.0f || rawX <= 48) && ((y >= 0.0f || (-1.0f) * y <= 48) && (y <= 0.0f || y <= 48)))) {
                        setClickable(false);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void registerWindVanePlugin(Class cls) {
        f fVar = this.f4396d;
        if (fVar == null) {
            return;
        }
        fVar.a(cls.getSimpleName(), cls);
    }

    public void release() {
        try {
            if (!this.f4401m) {
                com.mbridge.msdk.foundation.same.report.d.e eVar = new com.mbridge.msdk.foundation.same.report.d.e();
                eVar.a(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.f4400l));
                com.mbridge.msdk.foundation.same.report.d.d.a().a("2000135", this.f4399k, eVar);
            }
        } catch (Exception unused) {
        }
        try {
            setVisibility(8);
            removeAllViews();
            setDownloadListener(null);
            this.e = null;
            if (ak.b(getContext()) == 0) {
                this.f4401m = true;
                destroy();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WindVaneWebView.this.f4401m = true;
                        WindVaneWebView.this.destroy();
                    }
                }, r0 * 1000);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setApiManagerContext(Context context) {
        f fVar = this.f4396d;
        if (fVar != null) {
            fVar.a(context);
        }
    }

    public void setApiManagerJSFactory(Object obj) {
        f fVar = this.f4396d;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void setCampaignEx(CampaignEx campaignEx) {
        this.f4399k = campaignEx;
    }

    public void setCampaignId(String str) {
        this.g = str;
    }

    public void setLocalRequestId(String str) {
        this.f4398j = str;
    }

    public void setMraidObject(Object obj) {
        this.f = obj;
    }

    public void setObject(Object obj) {
        this.e = obj;
    }

    public void setRid(String str) {
        this.f4397i = str;
    }

    public void setSignalCommunication(c cVar) {
        this.f4395c = cVar;
        cVar.a(this);
    }

    public void setTempTypeForMetrics(int i10) {
        this.f4400l = i10;
    }

    public void setWebViewChromeClient(k kVar) {
        this.f4394b = kVar;
        setWebChromeClient(kVar);
    }

    public void setWebViewListener(d dVar) {
        this.h = dVar;
        k kVar = this.f4394b;
        if (kVar != null) {
            kVar.a(dVar);
        }
        com.mbridge.msdk.mbsignalcommon.base.b bVar = this.mWebViewClient;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void setWebViewTransparent() {
        super.setTransparent();
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4401m = false;
        this.f4402n = 0.0f;
        this.f4403o = 0.0f;
    }

    public WindVaneWebView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f4401m = false;
        this.f4402n = 0.0f;
        this.f4403o = 0.0f;
    }
}

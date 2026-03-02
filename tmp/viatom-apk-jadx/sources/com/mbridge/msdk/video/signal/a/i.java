package com.mbridge.msdk.video.signal.a;

import android.content.res.Configuration;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends b {

    /* renamed from: a, reason: collision with root package name */
    private WebView f6148a;

    /* renamed from: b, reason: collision with root package name */
    private int f6149b = 0;

    public i(WebView webView) {
        this.f6148a = webView;
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void a(Configuration configuration) throws JSONException {
        super.a(configuration);
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", "landscape");
            } else {
                jSONObject.put("orientation", "portrait");
            }
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f6148a, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void b() {
        super.b();
        this.f6149b = 0;
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f6148a, "onSystemResume", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void c() {
        super.c();
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f6148a, "onSystemDestory", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void g() {
        super.g();
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f6148a, "onSystemBackPressed", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final int h() {
        return this.f6149b;
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void a() {
        super.a();
        this.f6149b = 1;
        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(this.f6148a, "onSystemPause", "");
    }

    @Override // com.mbridge.msdk.video.signal.a.b, com.mbridge.msdk.video.signal.b
    public final void a(int i10) {
        super.a(i10);
        this.f6149b = i10;
    }
}

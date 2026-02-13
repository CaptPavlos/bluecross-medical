package y3;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import b9.h;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import j$.util.DesugarCollections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import t3.i;
import t3.j;

/* loaded from: classes3.dex */
public final class d extends a {
    public WebView g;
    public Long h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f13787i;

    /* renamed from: j, reason: collision with root package name */
    public final String f13788j;

    public d(String str, Map map, String str2) {
        super(str);
        this.h = null;
        this.f13787i = map;
        this.f13788j = str2;
    }

    @Override // y3.a
    public final void c(j jVar, h hVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapUnmodifiableMap = DesugarCollections.unmodifiableMap((HashMap) hVar.f884c);
        for (String str : mapUnmodifiableMap.keySet()) {
            i iVar = (i) mapUnmodifiableMap.get(str);
            iVar.getClass();
            JSONObject jSONObject2 = new JSONObject();
            z3.b.b(jSONObject2, "vendorKey", iVar.f12788a);
            z3.b.b(jSONObject2, "resourceUrl", iVar.f12789b.toString());
            z3.b.b(jSONObject2, "verificationParameters", iVar.f12790c);
            z3.b.b(jSONObject, str, jSONObject2);
        }
        d(jVar, hVar, jSONObject);
    }

    @Override // y3.a
    public final void e() {
        super.e();
        new Handler().postDelayed(new a4.a(this), Math.max(4000 - (this.h == null ? 4000L : (System.nanoTime() - this.h.longValue()) / 1000000), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.g = null;
    }

    @Override // y3.a
    public final void g() {
        WebView webView = new WebView(w3.h.f13509b.f13510a);
        this.g = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.g.getSettings().setAllowContentAccess(false);
        this.g.getSettings().setAllowFileAccess(false);
        this.g.setWebViewClient(new c(this));
        this.f13783b = new c4.a(this.g);
        WebView webView2 = this.g;
        if (webView2 != null) {
            String str = this.f13788j;
            if (!TextUtils.isEmpty(str)) {
                try {
                    webView2.evaluateJavascript(str, null);
                } catch (IllegalStateException unused) {
                    webView2.loadUrl("javascript: " + str);
                }
            }
        }
        Map map = this.f13787i;
        for (String str2 : map.keySet()) {
            String externalForm = ((i) map.get(str2)).f12789b.toExternalForm();
            WebView webView3 = this.g;
            if (externalForm != null && !TextUtils.isEmpty(str2)) {
                String strReplace = "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", externalForm).replace("%INJECTION_ID%", str2);
                if (webView3 != null && !TextUtils.isEmpty(strReplace)) {
                    try {
                        webView3.evaluateJavascript(strReplace, null);
                    } catch (IllegalStateException unused2) {
                        webView3.loadUrl("javascript: " + strReplace);
                    }
                }
            }
        }
        this.h = Long.valueOf(System.nanoTime());
    }
}

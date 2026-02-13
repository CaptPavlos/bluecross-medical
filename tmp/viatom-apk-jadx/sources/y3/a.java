package y3;

import android.webkit.WebView;
import b9.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Date;
import org.json.JSONObject;
import t3.j;
import w3.i;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f13782a;

    /* renamed from: c, reason: collision with root package name */
    public t3.a f13784c;

    /* renamed from: d, reason: collision with root package name */
    public u3.b f13785d;
    public long f = System.nanoTime();
    public int e = 1;

    /* renamed from: b, reason: collision with root package name */
    public c4.a f13783b = new c4.a(null);

    public a(String str) {
        this.f13782a = str;
    }

    public final void a(String str, JSONObject jSONObject) {
        i.f13511a.a(f(), "publishMediaEvent", str, jSONObject, this.f13782a);
    }

    public final void b(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        z3.b.b(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(date.getTime()));
        i.f13511a.a(f(), "setLastActivity", jSONObject);
    }

    public void c(j jVar, h hVar) {
        d(jVar, hVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(t3.j r10, b9.h r11, org.json.JSONObject r12) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.a.d(t3.j, b9.h, org.json.JSONObject):void");
    }

    public void e() {
        this.f13783b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView f() {
        return (WebView) this.f13783b.get();
    }

    public void g() {
    }
}

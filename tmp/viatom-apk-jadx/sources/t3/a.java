package t3;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
import z1.t1;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final j f12766a;

    public a(j jVar) {
        this.f12766a = jVar;
    }

    public static a a(b bVar) {
        j jVar = (j) bVar;
        t1.b(bVar, "AdSession is null");
        if (jVar.e.f13784c != null) {
            androidx.window.layout.c.g("AdEvents already exists for AdSession");
            return null;
        }
        t1.i(jVar);
        a aVar = new a(jVar);
        jVar.e.f13784c = aVar;
        return aVar;
    }

    public final void b() {
        j jVar = this.f12766a;
        t1.i(jVar);
        jVar.f12792b.getClass();
        if (!jVar.f || jVar.g) {
            try {
                jVar.f();
            } catch (Exception unused) {
            }
        }
        if (!jVar.f || jVar.g) {
            return;
        }
        if (jVar.f12795i) {
            androidx.window.layout.c.g("Impression event can only be sent once");
            return;
        }
        y3.a aVar = jVar.e;
        w3.i.f13511a.a(aVar.f(), "publishImpressionEvent", aVar.f13782a);
        jVar.f12795i = true;
    }

    public final void c(h hVar) throws JSONException {
        j jVar = this.f12766a;
        t1.d(jVar);
        jVar.f12792b.getClass();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("skippable", false);
            jSONObject.put("autoPlay", true);
            jSONObject.put("position", u3.c.STANDALONE);
        } catch (JSONException e) {
            Log.e("OMIDLIB", "VastProperties: JSON error", e);
        }
        if (jVar.f12796j) {
            androidx.window.layout.c.g("Loaded event can only be sent once");
            return;
        }
        y3.a aVar = jVar.e;
        w3.i.f13511a.a(aVar.f(), "publishLoadedEvent", jSONObject, aVar.f13782a);
        jVar.f12796j = true;
    }
}

package u3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONObject;
import t3.g;
import t3.j;
import z1.t1;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final j f12887a;

    public b(j jVar) {
        this.f12887a = jVar;
    }

    public static b b(t3.b bVar) {
        j jVar = (j) bVar;
        t1.b(bVar, "AdSession is null");
        if (g.NATIVE != ((g) jVar.f12792b.f12751b)) {
            androidx.window.layout.c.g("Cannot create MediaEvents for JavaScript AdSession");
            return null;
        }
        if (jVar.f) {
            androidx.window.layout.c.g("AdSession is started");
            return null;
        }
        t1.i(jVar);
        y3.a aVar = jVar.e;
        if (aVar.f13785d != null) {
            androidx.window.layout.c.g("MediaEvents already exists for AdSession");
            return null;
        }
        b bVar2 = new b(jVar);
        aVar.f13785d = bVar2;
        return bVar2;
    }

    public final void a() {
        j jVar = this.f12887a;
        t1.d(jVar);
        JSONObject jSONObject = new JSONObject();
        z3.b.b(jSONObject, "interactionType", a.CLICK);
        jVar.e.a("adUserInteraction", jSONObject);
    }

    public final void c() {
        j jVar = this.f12887a;
        t1.d(jVar);
        jVar.e.a(CampaignEx.JSON_NATIVE_VIDEO_RESUME, null);
    }

    public final void d() {
        j jVar = this.f12887a;
        t1.d(jVar);
        jVar.e.a("skipped", null);
    }

    public final void e(float f, float f10) {
        if (f <= 0.0f) {
            com.google.gson.internal.a.n("Invalid Media duration");
            return;
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            com.google.gson.internal.a.n("Invalid Media volume");
            return;
        }
        j jVar = this.f12887a;
        t1.d(jVar);
        JSONObject jSONObject = new JSONObject();
        z3.b.b(jSONObject, TypedValues.TransitionType.S_DURATION, Float.valueOf(f));
        z3.b.b(jSONObject, "mediaPlayerVolume", Float.valueOf(f10));
        z3.b.b(jSONObject, "deviceVolume", Float.valueOf(w3.j.b().f13512a));
        jVar.e.a("start", jSONObject);
    }

    public final void f(float f) {
        if (f < 0.0f || f > 1.0f) {
            com.google.gson.internal.a.n("Invalid Media volume");
            return;
        }
        j jVar = this.f12887a;
        t1.d(jVar);
        JSONObject jSONObject = new JSONObject();
        z3.b.b(jSONObject, "mediaPlayerVolume", Float.valueOf(f));
        z3.b.b(jSONObject, "deviceVolume", Float.valueOf(w3.j.b().f13512a));
        jVar.e.a("volumeChange", jSONObject);
    }
}

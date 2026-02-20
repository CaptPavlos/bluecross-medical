package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.tracker.w;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class k {

    /* renamed from: a, reason: collision with root package name */
    private static x f5356a = null;

    /* renamed from: o, reason: collision with root package name */
    private static volatile String f5357o = "";

    /* renamed from: b, reason: collision with root package name */
    private final String f5358b;

    /* renamed from: c, reason: collision with root package name */
    private final m f5359c;

    /* renamed from: d, reason: collision with root package name */
    private Context f5360d;
    private w e;
    private JSONObject f;
    private List<String> g;
    private List<String> h;

    /* renamed from: i, reason: collision with root package name */
    private volatile c f5361i;

    /* renamed from: j, reason: collision with root package name */
    private volatile l f5362j;

    /* renamed from: k, reason: collision with root package name */
    private volatile d f5363k;

    /* renamed from: l, reason: collision with root package name */
    private volatile j f5364l;

    /* renamed from: m, reason: collision with root package name */
    private volatile r f5365m;

    /* renamed from: n, reason: collision with root package name */
    private volatile boolean f5366n = true;

    /* renamed from: p, reason: collision with root package name */
    private volatile n f5367p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f5368q;

    public k(String str, m mVar) {
        this.f5358b = str;
        this.f5359c = mVar;
    }

    public final String a() {
        if (!y.a((Object) this.f5360d) && !y.a(this.e)) {
            try {
                o().a();
                this.f5366n = false;
                this.f5368q = false;
                if (TextUtils.isEmpty(f5357o)) {
                    f5357o = UUID.randomUUID().toString();
                }
                if (!y.a(f5356a)) {
                    try {
                        f5356a.a(b(), this.f5358b, this.f5359c);
                        t.a().b();
                    } catch (Exception e) {
                        if (a.f5328a) {
                            Log.e("TrackManager", "track manager start exception", e);
                        }
                    }
                }
                return f5357o;
            } catch (Exception e3) {
                if (a.f5328a) {
                    Log.e("TrackManager", "start error", e3);
                }
                this.f5366n = true;
            }
        }
        return "";
    }

    public final String b() {
        if (!TextUtils.isEmpty(f5357o)) {
            return f5357o;
        }
        String string = UUID.randomUUID().toString();
        f5357o = string;
        return string;
    }

    public final String c() {
        return this.f5358b;
    }

    public final w d() {
        w wVar = this.e;
        if (wVar != null) {
            return wVar;
        }
        w wVarA = new w.a().a();
        this.e = wVarA;
        return wVarA;
    }

    public final Context e() {
        return this.f5360d;
    }

    public final JSONObject f() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f = jSONObject2;
        return jSONObject2;
    }

    public final c g() {
        String str;
        if (y.a(this.f5361i)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f5361i)) {
                        Context context = this.f5360d;
                        if (TextUtils.isEmpty(this.f5358b)) {
                            str = "track_manager_default.db";
                        } else {
                            str = "track_manager_" + this.f5358b + ".db";
                        }
                        this.f5361i = new c(new b(context, str, "event_table"), "event_table");
                    }
                } finally {
                }
            }
        }
        return this.f5361i;
    }

    public final l h() {
        if (y.a(this.f5362j)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f5362j)) {
                        this.f5362j = new p(new g(g(), o(), i()));
                    }
                } finally {
                }
            }
        }
        return this.f5362j;
    }

    public final j i() {
        if (y.a(this.f5364l)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f5364l)) {
                        this.f5364l = new j();
                    }
                } finally {
                }
            }
        }
        return this.f5364l;
    }

    public final d j() {
        if (y.a(this.f5363k)) {
            this.f5363k = d().h;
        }
        return this.f5363k;
    }

    public final m k() {
        return this.f5359c;
    }

    public final int l() {
        if (d().f5524a < 0) {
            return 50;
        }
        return d().f5524a;
    }

    public final int m() {
        return Math.max(d().f5525b, 0);
    }

    public final int n() {
        return Math.max(d().e, 0);
    }

    public final r o() {
        if (y.a(this.f5365m)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f5365m)) {
                        this.f5365m = new r(this);
                    }
                } finally {
                }
            }
        }
        return this.f5365m;
    }

    public final boolean p() throws IllegalStateException {
        if (y.a(d())) {
            androidx.window.layout.c.g("config can not be null");
            return false;
        }
        if (y.a(j())) {
            androidx.window.layout.c.g("decorate can not be null");
            return false;
        }
        if (y.a(d().f5528i)) {
            androidx.window.layout.c.g("responseHandler can not be null");
            return false;
        }
        if (y.a(d().g) || y.a(d().g.c())) {
            androidx.window.layout.c.g("networkStackConfig or stack can not be null");
            return false;
        }
        if (!TextUtils.isEmpty(d().g.b())) {
            return true;
        }
        androidx.window.layout.c.g("report url is null");
        return false;
    }

    public final n q() {
        if (y.a(this.f5367p)) {
            synchronized (k.class) {
                try {
                    if (y.a(this.f5367p)) {
                        this.f5367p = new n(d().f5527d <= 0 ? 2 : d().f5527d, d().g, d().f5528i, d().f5526c);
                    }
                } finally {
                }
            }
        }
        return this.f5367p;
    }

    public final boolean r() {
        return this.f5366n;
    }

    public final void s() {
        this.f5368q = true;
    }

    public final boolean t() {
        return !this.f5368q;
    }

    public final void a(Context context) {
        this.f5360d = context;
    }

    public final void a(w wVar) {
        this.e = wVar;
    }

    public final void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    public final boolean a(e eVar) {
        if (y.a(eVar)) {
            return false;
        }
        f fVar = d().f5529j;
        if (y.b(fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e) {
                if (a.f5328a) {
                    Log.e("TrackManager", "event filter apply exception", e);
                }
            }
        }
        String strA = eVar.a();
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        if (this.h != null) {
            try {
                return !r0.contains(strA);
            } catch (Exception e3) {
                if (a.f5328a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e3);
                }
            }
        }
        List<String> list = this.g;
        if (list != null) {
            try {
                return list.contains(strA);
            } catch (Exception e7) {
                if (a.f5328a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e7);
                }
            }
        }
        return true;
    }
}

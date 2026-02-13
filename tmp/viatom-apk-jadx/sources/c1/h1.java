package c1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 extends f2 {

    /* renamed from: z, reason: collision with root package name */
    public static final Pair f1243z = new Pair("", 0L);

    /* renamed from: c, reason: collision with root package name */
    public SharedPreferences f1244c;

    /* renamed from: d, reason: collision with root package name */
    public SharedPreferences f1245d;
    public f1 e;
    public final e1 f;
    public final g1 g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1246i;

    /* renamed from: j, reason: collision with root package name */
    public long f1247j;

    /* renamed from: k, reason: collision with root package name */
    public final e1 f1248k;

    /* renamed from: l, reason: collision with root package name */
    public final d1 f1249l;

    /* renamed from: m, reason: collision with root package name */
    public final g1 f1250m;

    /* renamed from: n, reason: collision with root package name */
    public final w2.r f1251n;

    /* renamed from: o, reason: collision with root package name */
    public final d1 f1252o;

    /* renamed from: p, reason: collision with root package name */
    public final e1 f1253p;

    /* renamed from: q, reason: collision with root package name */
    public final e1 f1254q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1255r;

    /* renamed from: s, reason: collision with root package name */
    public final d1 f1256s;
    public final d1 t;

    /* renamed from: u, reason: collision with root package name */
    public final e1 f1257u;

    /* renamed from: v, reason: collision with root package name */
    public final g1 f1258v;

    /* renamed from: w, reason: collision with root package name */
    public final g1 f1259w;

    /* renamed from: x, reason: collision with root package name */
    public final e1 f1260x;
    public final w2.r y;

    public h1(u1 u1Var) {
        super(u1Var);
        this.f1248k = new e1(this, "session_timeout", 1800000L);
        this.f1249l = new d1(this, "start_new_session", true);
        this.f1253p = new e1(this, "last_pause_time", 0L);
        this.f1254q = new e1(this, "session_id", 0L);
        this.f1250m = new g1(this, "non_personalized_ads");
        this.f1251n = new w2.r(this, "last_received_uri_timestamps_by_source");
        this.f1252o = new d1(this, "allow_remote_dynamite", false);
        this.f = new e1(this, "first_open_time", 0L);
        i0.y.d("app_install_time");
        this.g = new g1(this, "app_instance_id");
        this.f1256s = new d1(this, "app_backgrounded", false);
        this.t = new d1(this, "deep_link_retrieval_complete", false);
        this.f1257u = new e1(this, "deep_link_retrieval_attempts", 0L);
        this.f1258v = new g1(this, "firebase_feature_rollouts");
        this.f1259w = new g1(this, "deferred_attribution_cache");
        this.f1260x = new e1(this, "deferred_attribution_cache_timestamp", 0L);
        this.y = new w2.r(this, "default_event_parameters");
    }

    @Override // c1.f2
    public final boolean h() {
        return true;
    }

    public final SharedPreferences k() {
        g();
        i();
        i0.y.g(this.f1244c);
        return this.f1244c;
    }

    public final SharedPreferences l() {
        g();
        i();
        if (this.f1245d == null) {
            u1 u1Var = this.f1149a;
            String strValueOf = String.valueOf(u1Var.f1475a.getPackageName());
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            u0 u0Var = w0Var.f1545n;
            String strConcat = strValueOf.concat("_preferences");
            u0Var.c(strConcat, "Default prefs file");
            this.f1245d = u1Var.f1475a.getSharedPreferences(strConcat, 0);
        }
        return this.f1245d;
    }

    public final SparseArray m() {
        Bundle bundleI = this.f1251n.I();
        int[] intArray = bundleI.getIntArray("uriSources");
        long[] longArray = bundleI.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f.b("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i10 = 0; i10 < intArray.length; i10++) {
            sparseArray.put(intArray[i10], Long.valueOf(longArray[i10]));
        }
        return sparseArray;
    }

    public final k2 n() {
        g();
        return k2.c(k().getInt("consent_source", 100), k().getString("consent_settings", "G1"));
    }

    public final boolean o(h4 h4Var) {
        g();
        String string = k().getString("stored_tcf_param", "");
        String strA = h4Var.a();
        if (strA.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putString("stored_tcf_param", strA);
        editorEdit.apply();
        return true;
    }

    public final void p(boolean z9) {
        g();
        w0 w0Var = this.f1149a.f;
        u1.m(w0Var);
        w0Var.f1545n.c(Boolean.valueOf(z9), "App measurement setting deferred collection");
        SharedPreferences.Editor editorEdit = k().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z9);
        editorEdit.apply();
    }

    public final boolean q(long j10) {
        return j10 - this.f1248k.a() > this.f1253p.a();
    }
}

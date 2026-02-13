package y2;

import a3.d1;
import a3.k1;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;
import c1.a5;
import c1.c3;
import c1.d0;
import c1.g4;
import c1.h1;
import c1.h2;
import c1.k2;
import c1.u1;
import c1.v4;
import c1.w0;
import c1.y0;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.FollowListActivity;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.VirusTotalReport;
import e5.m1;
import g5.i;
import g5.k;
import g5.q;
import g5.w;
import g5.z;
import h0.p;
import h1.d;
import h1.e;
import h1.f;
import h5.e1;
import h5.o0;
import j$.util.DesugarCollections;
import j$.util.concurrent.ConcurrentHashMap;
import j4.l0;
import j4.r;
import j8.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import l4.p1;
import org.json.JSONObject;
import s6.j;
import t3.h;
import u7.m0;
import v5.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements c3.b, d, a5, y0, q, f, e, h1.c, g, SearchView.OnQueryTextListener, i, g5.b, w, z, k {

    /* renamed from: c, reason: collision with root package name */
    public static volatile c f13779c;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13780a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13781b;

    public c(int i10) {
        this.f13780a = i10;
        switch (i10) {
            case 13:
                break;
            case 14:
                this.f13781b = new d0.i(16);
                break;
            case 15:
                this.f13781b = new CountDownLatch(1);
                break;
            case 16:
            default:
                this.f13781b = new HashSet();
                break;
            case 17:
                this.f13781b = new ConcurrentHashMap(16);
                break;
        }
    }

    public static c E(String str) {
        return new c((TextUtils.isEmpty(str) || str.length() > 1) ? h2.UNINITIALIZED : k2.e(str.charAt(0)), 4);
    }

    public e2.d A(JSONObject jSONObject) {
        d0 d0Var;
        int i10 = jSONObject.getInt("settings_version");
        if (i10 != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i10 + ". Using default settings values.", null);
            d0Var = new d0(3);
        } else {
            d0Var = new d0(4);
        }
        h hVar = (h) this.f13781b;
        switch (d0Var.f1103a) {
            case 3:
                return d0.n(hVar);
            default:
                jSONObject.optInt("settings_version", 0);
                int iOptInt = jSONObject.optInt("cache_duration", 3600);
                double dOptDouble = jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d);
                double dOptDouble2 = jSONObject.optDouble("on_demand_backoff_base", 1.2d);
                int iOptInt2 = jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60);
                e2.c cVar = jSONObject.has("session") ? new e2.c(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8)) : new e2.c(new JSONObject().optInt("max_custom_exception_events", 8));
                JSONObject jSONObject2 = jSONObject.getJSONObject("features");
                return new e2.d(jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : System.currentTimeMillis() + (iOptInt * 1000), cVar, new e2.b(jSONObject2.optBoolean("collect_reports", true), jSONObject2.optBoolean("collect_anrs", false), jSONObject2.optBoolean("collect_build_ids", false)), dOptDouble, dOptDouble2, iOptInt2);
        }
    }

    public JSONObject B() throws Throwable {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", null);
        }
        try {
            File file = (File) this.f13781b;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(w1.g.i(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        w1.g.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    w1.g.b(fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", null);
                }
                jSONObject = null;
            }
            w1.g.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            w1.g.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void C() {
        g4 g4Var = (g4) this.f13781b;
        g4Var.g();
        u1 u1Var = g4Var.f1149a;
        h1 h1Var = u1Var.e;
        u1.k(h1Var);
        u1Var.f1481k.getClass();
        if (h1Var.q(System.currentTimeMillis())) {
            h1 h1Var2 = u1Var.e;
            u1.k(h1Var2);
            h1Var2.f1249l.b(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                w0 w0Var = u1Var.f;
                u1.m(w0Var);
                w0Var.f1545n.b("Detected application was in foreground");
                H(System.currentTimeMillis());
            }
        }
    }

    public void D(long j10) {
        g4 g4Var = (g4) this.f13781b;
        g4Var.g();
        g4Var.k();
        u1 u1Var = g4Var.f1149a;
        h1 h1Var = u1Var.e;
        u1.k(h1Var);
        if (h1Var.q(j10)) {
            u1.k(h1Var);
            h1Var.f1249l.b(true);
            u1Var.r().l();
        }
        u1.k(h1Var);
        h1Var.f1253p.b(j10);
        if (h1Var.f1249l.a()) {
            H(j10);
        }
    }

    @Override // g5.q
    public void F() {
        switch (this.f13780a) {
            case 11:
                ((m1) this.f13781b).a().e.setVisibility(8);
                break;
            case 24:
                FeedActivity feedActivity = (FeedActivity) this.f13781b;
                int i10 = FeedActivity.L;
                feedActivity.n0().f7198b.setVisibility(8);
                break;
        }
    }

    public void H(long j10) {
        g4 g4Var = (g4) this.f13781b;
        g4Var.g();
        u1 u1Var = g4Var.f1149a;
        if (u1Var.d()) {
            h1 h1Var = u1Var.e;
            u1.k(h1Var);
            h1Var.f1253p.b(j10);
            u1Var.f1481k.getClass();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1545n.c(Long.valueOf(jElapsedRealtime), "Session started, time");
            long j11 = j10 / 1000;
            Long lValueOf = Long.valueOf(j11);
            c3 c3Var = u1Var.f1483m;
            u1.l(c3Var);
            c3Var.r(j10, lValueOf, "auto", "_sid");
            u1.k(h1Var);
            h1Var.f1254q.b(j11);
            h1Var.f1249l.b(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j11);
            u1.l(c3Var);
            c3Var.o(j10, bundle, "auto", "_s");
            String strN = h1Var.f1258v.n();
            if (TextUtils.isEmpty(strN)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strN);
            u1.l(c3Var);
            c3Var.o(j10, bundle2, "auto", "_ssr");
        }
    }

    @Override // g5.b, g5.p
    public void a(int i10) {
        n4.e eVar;
        h5.f fVar;
        String str;
        FreeUpSpaceActivity freeUpSpaceActivity = (FreeUpSpaceActivity) this.f13781b;
        float f = UptodownApp.E;
        if (!k4.c.s() || (eVar = freeUpSpaceActivity.J) == null || (fVar = (h5.f) eVar.a().get(i10)) == null || (str = fVar.f8526c) == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
        intent.addFlags(268435456);
        freeUpSpaceActivity.startActivity(intent);
    }

    @Override // c1.a5
    public void b(String str, String str2, Bundle bundle) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        c3 c3Var = (c3) this.f13781b;
        if (zIsEmpty) {
            c3Var.f1149a.f1481k.getClass();
            c3Var.l("auto", "_err", bundle, true, true, System.currentTimeMillis());
        } else {
            c3Var.getClass();
            androidx.window.layout.c.g("Unexpected call on client side");
        }
    }

    @Override // c1.y0
    public /* synthetic */ void c(String str, int i10, Throwable th, byte[] bArr, Map map) {
        ((v4) this.f13781b).A(str, i10, th, bArr, map);
    }

    @Override // j8.g
    public void e(m7.c cVar, a3.q qVar) {
        cVar.getClass();
        ((p) this.f13781b).g(cVar, new j8.b(qVar), true);
    }

    @Override // g5.i
    public void f(int i10) {
        switch (this.f13780a) {
            case 22:
                break;
            default:
                l4.w wVar = (l4.w) this.f13781b;
                String string = wVar.getString(R.string.app_detail_not_found);
                string.getClass();
                wVar.C(string);
                break;
        }
    }

    @Override // g5.w
    public void g(ArrayList arrayList, int i10, boolean z9) {
        boolean zIsEmpty = arrayList.isEmpty();
        m0 m0Var = ((p1) this.f13781b).f10708d;
        if (zIsEmpty) {
            l lVar = new l(new l4.m1(new ArrayList(), 0));
            m0Var.getClass();
            m0Var.g(null, lVar);
        } else {
            l lVar2 = new l(new l4.m1(arrayList, i10));
            m0Var.getClass();
            m0Var.g(null, lVar2);
        }
    }

    @Override // p6.a
    public Object get() {
        return new d1((k1) ((c3.c) this.f13781b).get());
    }

    @Override // h1.f
    public void h(Object obj) {
        ((CountDownLatch) this.f13781b).countDown();
    }

    @Override // g5.v
    public void i() {
        m0 m0Var = ((p1) this.f13781b).f10708d;
        l lVar = new l(new l4.m1(new ArrayList(), 0));
        m0Var.getClass();
        m0Var.g(null, lVar);
    }

    @Override // j8.g
    public void j(m7.c cVar, g7.l lVar) {
        ((p) this.f13781b).c(cVar, lVar, true);
    }

    @Override // g5.k
    public void k() {
        float f = UptodownApp.E;
        if (k4.c.s()) {
            MyApps myApps = (MyApps) this.f13781b;
            String string = myApps.getString(R.string.disabled_apps_explanation);
            string.getClass();
            myApps.N(string);
        }
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        h5.k kVar;
        switch (this.f13780a) {
            case 22:
                AppInstalledDetailsActivity appInstalledDetailsActivity = (AppInstalledDetailsActivity) this.f13781b;
                appInstalledDetailsActivity.W = hVar;
                if (!appInstalledDetailsActivity.isFinishing() && (kVar = hVar.f8597x) != null && kVar.g == 1) {
                    appInstalledDetailsActivity.F0().H.setText(appInstalledDetailsActivity.getString(R.string.app_detail_play_button));
                    break;
                }
                break;
            default:
                l4.w wVar = (l4.w) this.f13781b;
                if (!wVar.isFinishing()) {
                    Intent intent = new Intent(wVar, (Class<?>) AppDetailActivity.class);
                    intent.putExtra("appInfo", hVar);
                    float f = UptodownApp.E;
                    wVar.startActivity(intent, k4.c.a(wVar));
                    break;
                }
                break;
        }
    }

    @Override // g5.z
    public void m(o0 o0Var) {
        MoreInfo moreInfo = (MoreInfo) this.f13781b;
        Intent intent = new Intent(moreInfo, (Class<?>) VirusTotalReport.class);
        intent.putExtra("appInfo", moreInfo.K);
        intent.putExtra("appReportVT", o0Var);
        float f = UptodownApp.E;
        moreInfo.startActivity(intent, k4.c.a(moreInfo));
    }

    @Override // h1.c
    public void n() {
        ((CountDownLatch) this.f13781b).countDown();
    }

    @Override // h1.d
    public void o(h1.p pVar) {
        Exception excF = pVar.f();
        if (excF != null) {
            ((r7.g) this.f13781b).resumeWith(new j(excF));
            return;
        }
        boolean z9 = pVar.f8438d;
        r7.g gVar = (r7.g) this.f13781b;
        if (z9) {
            gVar.n(null);
        } else {
            gVar.resumeWith(pVar.g());
        }
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        str.getClass();
        k6.c cVar = (k6.c) this.f13781b;
        c.g gVar = cVar.f10070p;
        if (gVar == null) {
            kotlin.jvm.internal.l.i("switchAdapter");
            throw null;
        }
        k6.d dVar = cVar.f10069o;
        if (dVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        ArrayList arrayListC = dVar.c(str);
        boolean z9 = str.length() > 0;
        gVar.f958a = arrayListC;
        if (!z9) {
            gVar.a();
        }
        gVar.notifyDataSetChanged();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // j8.g
    public void p(m7.c cVar, c8.b bVar) {
        bVar.getClass();
        ((p) this.f13781b).g(cVar, new j8.a(bVar), true);
    }

    @Override // g5.z
    public void q() {
        MoreInfo moreInfo = (MoreInfo) this.f13781b;
        h5.h hVar = moreInfo.K;
        hVar.getClass();
        String str = hVar.g;
        if (str != null && str.length() != 0) {
            h5.h hVar2 = moreInfo.K;
            hVar2.getClass();
            String str2 = hVar2.g;
            str2.getClass();
            if (Long.parseLong(str2) > 650000000) {
                Intent intent = new Intent(moreInfo, (Class<?>) VirusTotalReport.class);
                intent.putExtra("appInfo", moreInfo.K);
                intent.putExtra("isVirusTotalReportAvaialable", false);
                float f = UptodownApp.E;
                moreInfo.startActivity(intent, k4.c.a(moreInfo));
                return;
            }
        }
        h5.h hVar3 = moreInfo.K;
        hVar3.getClass();
        moreInfo.c0(hVar3.G);
    }

    @Override // g5.q
    public void r(e1 e1Var) {
        switch (this.f13780a) {
            case 11:
                m1 m1Var = (m1) this.f13781b;
                m1Var.a().e.setVisibility(8);
                Intent intent = new Intent(m1Var.requireContext(), (Class<?>) PublicProfileActivity.class);
                intent.putExtra("user", e1Var);
                float f = UptodownApp.E;
                FragmentActivity fragmentActivityRequireActivity = m1Var.requireActivity();
                fragmentActivityRequireActivity.getClass();
                m1Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
                break;
            case 24:
                FeedActivity feedActivity = (FeedActivity) this.f13781b;
                int i10 = FeedActivity.L;
                feedActivity.n0().f7198b.setVisibility(8);
                Intent intent2 = new Intent(feedActivity, (Class<?>) PublicProfileActivity.class);
                intent2.putExtra("user", e1Var);
                float f10 = UptodownApp.E;
                feedActivity.startActivity(intent2, k4.c.a(feedActivity));
                break;
            default:
                FollowListActivity followListActivity = (FollowListActivity) this.f13781b;
                Intent intent3 = new Intent(followListActivity, (Class<?>) PublicProfileActivity.class);
                intent3.putExtra("user", e1Var);
                float f11 = UptodownApp.E;
                followListActivity.startActivity(intent3, k4.c.a(followListActivity));
                break;
        }
    }

    @Override // j8.g
    public void s(m7.c cVar, g7.l lVar) {
        ((p) this.f13781b).d(cVar, lVar, true);
    }

    @Override // j8.g
    public void t(m7.c cVar, m7.c cVar2, c8.b bVar) {
        ((p) this.f13781b).f(cVar, cVar2, bVar, true);
    }

    @Override // h1.e
    public void u(Exception exc) {
        ((CountDownLatch) this.f13781b).countDown();
    }

    public boolean v() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f13781b;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
    }

    public String w(Object obj) {
        StringWriter stringWriter = new StringWriter();
        try {
            l2.d dVar = (l2.d) this.f13781b;
            l2.e eVar = new l2.e(stringWriter, dVar.f10194a, dVar.f10195b, dVar.f10196c, dVar.f10197d);
            eVar.h(obj);
            eVar.j();
            eVar.f10199b.flush();
        } catch (IOException unused) {
        }
        return stringWriter.toString();
    }

    public Set x() {
        Set setUnmodifiableSet;
        synchronized (((HashSet) this.f13781b)) {
            setUnmodifiableSet = DesugarCollections.unmodifiableSet((HashSet) this.f13781b);
        }
        return setUnmodifiableSet;
    }

    private final void z() {
    }

    private final void y(int i10) {
    }

    @Override // g5.b, g5.p
    public void d(int i10) {
    }

    public c(Context context) {
        this.f13780a = 18;
        StringBuilder sb = l0.f9987a;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.f13781b = new r((int) ((((context.getApplicationInfo().flags & 1048576) != 0 ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * 1048576) / 7));
    }

    public /* synthetic */ c(Object obj, int i10) {
        this.f13780a = i10;
        this.f13781b = obj;
    }

    public c(c2.d dVar) {
        this.f13780a = 9;
        this.f13781b = new File((File) dVar.f1643d, "com.crashlytics.settings.json");
    }

    public c(android.support.v4.media.session.f fVar) {
        this.f13780a = 2;
        this.f13781b = new WeakReference(fVar);
    }
}

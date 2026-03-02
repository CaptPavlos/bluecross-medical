package r2;

import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.trusted.sharing.ShareTarget;
import h1.p;
import i0.k;
import i0.y;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import q1.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements d {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f12348m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final l1.g f12349a;

    /* renamed from: b, reason: collision with root package name */
    public final t2.c f12350b;

    /* renamed from: c, reason: collision with root package name */
    public final k f12351c;

    /* renamed from: d, reason: collision with root package name */
    public final j f12352d;
    public final m e;
    public final h f;
    public final Object g;
    public final ExecutorService h;

    /* renamed from: i, reason: collision with root package name */
    public final r1.j f12353i;

    /* renamed from: j, reason: collision with root package name */
    public String f12354j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f12355k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f12356l;

    static {
        new AtomicInteger(1);
    }

    public c(l1.g gVar, q2.b bVar, ExecutorService executorService, r1.j jVar) {
        gVar.a();
        t2.c cVar = new t2.c(gVar.f10177a, bVar);
        k kVar = new k(gVar);
        if (t3.h.f12786b == null) {
            t3.h.f12786b = new t3.h(3);
        }
        t3.h hVar = t3.h.f12786b;
        if (j.f12363c == null) {
            j.f12363c = new j(hVar);
        }
        j jVar2 = j.f12363c;
        m mVar = new m(new q1.c(gVar, 2));
        h hVar2 = new h();
        this.g = new Object();
        this.f12355k = new HashSet();
        this.f12356l = new ArrayList();
        this.f12349a = gVar;
        this.f12350b = cVar;
        this.f12351c = kVar;
        this.f12352d = jVar2;
        this.e = mVar;
        this.f = hVar2;
        this.h = executorService;
        this.f12353i = jVar;
    }

    public final void a(i iVar) {
        synchronized (this.g) {
            this.f12356l.add(iVar);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void b() {
        s2.b bVarC;
        synchronized (f12348m) {
            try {
                l1.g gVar = this.f12349a;
                gVar.a();
                k kVarB = k.b(gVar.f10177a);
                try {
                    bVarC = this.f12351c.C();
                    int i10 = bVarC.f12523b;
                    boolean z9 = true;
                    if (i10 != 2 && i10 != 1) {
                        z9 = false;
                    }
                    if (z9) {
                        String strH = h(bVarC);
                        k kVar = this.f12351c;
                        s2.a aVarA = bVarC.a();
                        aVarA.f12518a = strH;
                        aVarA.f12519b = 3;
                        bVarC = aVarA.a();
                        kVar.x(bVarC);
                    }
                    if (kVarB != null) {
                        kVarB.E();
                    }
                } catch (Throwable th) {
                    if (kVarB != null) {
                        kVarB.E();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        k(bVarC);
        this.f12353i.execute(new b(this, 2));
    }

    public final s2.b c(s2.b bVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        int responseCode;
        String str;
        t2.b bVarF;
        l1.g gVar = this.f12349a;
        gVar.a();
        String str2 = gVar.f10179c.f10187a;
        String str3 = bVar.f12522a;
        gVar.a();
        String str4 = gVar.f10179c.g;
        String str5 = bVar.f12525d;
        t2.c cVar = this.f12350b;
        n.b bVar2 = cVar.f12765c;
        if (!bVar2.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = t2.c.a("projects/" + str4 + "/installations/" + str3 + "/authTokens:generate");
        for (int i10 = 0; i10 <= 1; i10++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionC = cVar.c(urlA, str2);
            try {
                try {
                    httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionC.addRequestProperty("Authorization", "FIS_v2 " + str5);
                    httpURLConnectionC.setDoOutput(true);
                    t2.c.h(httpURLConnectionC);
                    responseCode = httpURLConnectionC.getResponseCode();
                    bVar2.d(responseCode);
                } catch (IOException | AssertionError unused) {
                    httpURLConnection = httpURLConnectionC;
                }
                if (responseCode >= 200 && responseCode < 300) {
                    bVarF = t2.c.f(httpURLConnectionC);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    str = null;
                } else {
                    t2.c.b(httpURLConnectionC, null, str2, str4);
                    httpURLConnection = httpURLConnectionC;
                    try {
                        try {
                        } catch (Throwable th) {
                            th = th;
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            throw th;
                        }
                    } catch (IOException | AssertionError unused2) {
                    }
                    if (responseCode == 401 || responseCode == 404) {
                        if (((byte) (0 | 1)) != 1) {
                            throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                        }
                        str = null;
                        t2.b bVar3 = new t2.b(3, 0L, null);
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                        bVarF = bVar3;
                    } else {
                        if (responseCode == 429) {
                            throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                        }
                        if (responseCode < 500 || responseCode >= 600) {
                            Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            if (((byte) (0 | 1)) != 1) {
                                throw new IllegalStateException("Missing required properties: tokenExpirationTimestamp");
                            }
                            t2.b bVar4 = new t2.b(2, 0L, null);
                            httpURLConnection.disconnect();
                            TrafficStats.clearThreadStatsTag();
                            bVarF = bVar4;
                            str = null;
                        }
                        httpURLConnection.disconnect();
                        TrafficStats.clearThreadStatsTag();
                    }
                }
                int iC = c.i.c(bVarF.f12761c);
                if (iC != 0) {
                    if (iC == 1) {
                        s2.a aVarA = bVar.a();
                        aVarA.g = "BAD CONFIG";
                        aVarA.f12519b = 5;
                        return aVarA.a();
                    }
                    if (iC != 2) {
                        throw new e("Firebase Installations Service is unavailable. Please try again later.");
                    }
                    l(str);
                    s2.a aVarA2 = bVar.a();
                    aVarA2.f12519b = 2;
                    return aVarA2.a();
                }
                String str6 = bVarF.f12759a;
                long j10 = bVarF.f12760b;
                this.f12352d.f12364a.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                s2.a aVarA3 = bVar.a();
                aVarA3.f12520c = str6;
                aVarA3.e = j10;
                byte b10 = (byte) (aVarA3.h | 1);
                aVarA3.f = jCurrentTimeMillis;
                aVarA3.h = (byte) (b10 | 2);
                return aVarA3.a();
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnectionC;
            }
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final p d() {
        String str;
        g();
        synchronized (this) {
            str = this.f12354j;
        }
        if (str != null) {
            return r0.f.x(str);
        }
        h1.i iVar = new h1.i();
        a(new g(iVar));
        p pVar = iVar.f8418a;
        this.h.execute(new b(this, 0));
        return pVar;
    }

    public final p e() {
        g();
        h1.i iVar = new h1.i();
        a(new f(this.f12352d, iVar));
        this.h.execute(new b(this, 1));
        return iVar.f8418a;
    }

    /* JADX WARN: Finally extract failed */
    public final void f(s2.b bVar) {
        synchronized (f12348m) {
            try {
                l1.g gVar = this.f12349a;
                gVar.a();
                k kVarB = k.b(gVar.f10177a);
                try {
                    this.f12351c.x(bVar);
                    if (kVarB != null) {
                        kVarB.E();
                    }
                } catch (Throwable th) {
                    if (kVarB != null) {
                        kVarB.E();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        l1.g gVar = this.f12349a;
        gVar.a();
        y.e(gVar.f10179c.f10188b, "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        y.e(gVar.f10179c.g, "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        y.e(gVar.f10179c.f10187a, "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        gVar.a();
        String str = gVar.f10179c.f10188b;
        Pattern pattern = j.f12362b;
        y.a("Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.", str.contains(":"));
        gVar.a();
        y.a("Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.", j.f12362b.matcher(gVar.f10179c.f10187a).matches());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(s2.b r3) {
        /*
            r2 = this;
            l1.g r0 = r2.f12349a
            r0.a()
            java.lang.String r0 = r0.f10178b
            java.lang.String r1 = "CHIME_ANDROID_SDK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1e
            l1.g r0 = r2.f12349a
            java.lang.String r1 = "[DEFAULT]"
            r0.a()
            java.lang.String r0 = r0.f10178b
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L50
        L1e:
            int r3 = r3.f12523b
            r0 = 1
            if (r3 != r0) goto L50
            q1.m r3 = r2.e
            java.lang.Object r3 = r3.get()
            s2.c r3 = (s2.c) r3
            android.content.SharedPreferences r0 = r3.f12527a
            monitor-enter(r0)
            java.lang.String r1 = r3.a()     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L38
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            goto L3d
        L36:
            r3 = move-exception
            goto L4e
        L38:
            java.lang.String r1 = r3.b()     // Catch: java.lang.Throwable -> L36
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L4d
            r2.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = r2.h.a()
            return r3
        L4d:
            return r1
        L4e:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L36
            throw r3
        L50:
            r2.h r3 = r2.f
            r3.getClass()
            java.lang.String r3 = r2.h.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.c.h(s2.b):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [t2.c] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [t2.a] */
    public final s2.b i(s2.b bVar) throws e {
        int responseCode;
        String str = bVar.f12522a;
        String string = null;
        if (str != null && str.length() == 11) {
            s2.c cVar = (s2.c) this.e.get();
            synchronized (cVar.f12527a) {
                try {
                    String[] strArr = s2.c.f12526c;
                    int i10 = 0;
                    while (true) {
                        if (i10 < 4) {
                            String str2 = strArr[i10];
                            String string2 = cVar.f12527a.getString("|T|" + cVar.f12528b + "|" + str2, null);
                            if (string2 == null || string2.isEmpty()) {
                                i10++;
                            } else if (string2.startsWith("{")) {
                                try {
                                    string = new JSONObject(string2).getString("token");
                                } catch (JSONException unused) {
                                }
                            } else {
                                string = string2;
                            }
                        }
                    }
                } finally {
                }
            }
        }
        t2.c cVar2 = this.f12350b;
        l1.g gVar = this.f12349a;
        gVar.a();
        String str3 = gVar.f10179c.f10187a;
        String str4 = bVar.f12522a;
        l1.g gVar2 = this.f12349a;
        gVar2.a();
        String str5 = gVar2.f10179c.g;
        l1.g gVar3 = this.f12349a;
        gVar3.a();
        String str6 = gVar3.f10179c.f10188b;
        n.b bVar2 = cVar2.f12765c;
        if (!bVar2.b()) {
            throw new e("Firebase Installations Service is unavailable. Please try again later.");
        }
        URL urlA = t2.c.a("projects/" + str5 + "/installations");
        int i11 = 0;
        t2.a aVar = cVar2;
        while (i11 <= 1) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionC = aVar.c(urlA, str3);
            try {
                try {
                    httpURLConnectionC.setRequestMethod(ShareTarget.METHOD_POST);
                    httpURLConnectionC.setDoOutput(true);
                    if (string != null) {
                        httpURLConnectionC.addRequestProperty("x-goog-fis-android-iid-migration-auth", string);
                    }
                    t2.c.g(httpURLConnectionC, str4, str6);
                    responseCode = httpURLConnectionC.getResponseCode();
                    bVar2.d(responseCode);
                } finally {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (IOException | AssertionError unused2) {
            }
            if (responseCode >= 200 && responseCode < 300) {
                t2.a aVarE = t2.c.e(httpURLConnectionC);
                httpURLConnectionC.disconnect();
                TrafficStats.clearThreadStatsTag();
                aVar = aVarE;
            } else {
                try {
                    t2.c.b(httpURLConnectionC, str6, str3, str5);
                } catch (IOException | AssertionError unused3) {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i11++;
                    aVar = aVar;
                }
                if (responseCode == 429) {
                    throw new e("Firebase servers have received too many requests from this client in a short period of time. Please try again later.");
                }
                if (responseCode < 500 || responseCode >= 600) {
                    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                    t2.a aVar2 = new t2.a(null, null, null, null, 2);
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    aVar = aVar2;
                } else {
                    httpURLConnectionC.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    i11++;
                    aVar = aVar;
                }
            }
            int iC = c.i.c(aVar.e);
            if (iC != 0) {
                if (iC != 1) {
                    throw new e("Firebase Installations Service is unavailable. Please try again later.");
                }
                s2.a aVarA = bVar.a();
                aVarA.g = "BAD CONFIG";
                aVarA.f12519b = 5;
                return aVarA.a();
            }
            String str7 = aVar.f12756b;
            String str8 = aVar.f12757c;
            this.f12352d.f12364a.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            t2.b bVar3 = aVar.f12758d;
            String str9 = bVar3.f12759a;
            long j10 = bVar3.f12760b;
            s2.a aVarA2 = bVar.a();
            aVarA2.f12518a = str7;
            aVarA2.f12519b = 4;
            aVarA2.f12520c = str9;
            aVarA2.f12521d = str8;
            aVarA2.e = j10;
            byte b10 = (byte) (aVarA2.h | 1);
            aVarA2.f = jCurrentTimeMillis;
            aVarA2.h = (byte) (b10 | 2);
            return aVarA2.a();
        }
        throw new e("Firebase Installations Service is unavailable. Please try again later.");
    }

    public final void j(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.f12356l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k(s2.b bVar) {
        synchronized (this.g) {
            try {
                Iterator it = this.f12356l.iterator();
                while (it.hasNext()) {
                    if (((i) it.next()).b(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void l(String str) {
        this.f12354j = str;
    }

    public final synchronized void m(s2.b bVar, s2.b bVar2) {
        try {
            if (this.f12355k.size() != 0 && !TextUtils.equals(bVar.f12522a, bVar2.f12522a)) {
                Iterator it = this.f12355k.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            }
        } finally {
        }
    }
}

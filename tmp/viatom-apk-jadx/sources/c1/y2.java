package c1;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.inmobi.cmp.ChoiceCmp;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.Objects;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y2 implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1604a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1605b;

    public y2() {
        this.f1604a = 3;
        this.f1605b = new ArrayDeque(10);
    }

    public void a(Intent intent) {
        ArrayDeque arrayDeque = (ArrayDeque) this.f1605b;
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String string = extras.getString("google.message_id");
                if (string == null) {
                    string = extras.getString("message_id");
                }
                if (!TextUtils.isEmpty(string)) {
                    if (arrayDeque.contains(string)) {
                        return;
                    } else {
                        arrayDeque.add(string);
                    }
                }
                bundle = extras.getBundle("gcm.n.analytics_data");
            }
        } catch (RuntimeException e) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e);
        }
        if (bundle == null ? false : "1".equals(bundle.getString("google.c.a.e"))) {
            if (bundle != null) {
                if ("1".equals(bundle.getString("google.c.a.tc"))) {
                    n1.a aVar = (n1.a) l1.g.c().b(n1.a.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (aVar != null) {
                        String string2 = bundle.getString("google.c.a.c_id");
                        n1.b bVar = (n1.b) aVar;
                        if (!o1.a.f11668c.contains("fcm")) {
                            com.google.android.gms.internal.measurement.l1 l1Var = (com.google.android.gms.internal.measurement.l1) bVar.f11279a.f6781b;
                            l1Var.a(new com.google.android.gms.internal.measurement.y0(l1Var, string2, 0));
                        }
                        Bundle bundleC = r1.i.c("source", "Firebase", "medium", "notification");
                        bundleC.putString("campaign", string2);
                        bVar.a("fcm", "_cmp", bundleC);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            w2.z.g(bundle, "_no");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[Catch: all -> 0x0026, RuntimeException -> 0x0029, TryCatch #1 {RuntimeException -> 0x0029, blocks: (B:3:0x0005, B:5:0x0017, B:7:0x001d, B:22:0x0047, B:25:0x004e, B:27:0x0061, B:29:0x0069, B:35:0x0079, B:40:0x0086, B:15:0x002c, B:17:0x0033, B:19:0x003f), top: B:49:0x0005, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(com.google.android.gms.internal.measurement.x0 r9, android.os.Bundle r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f1605b
            r1 = r0
            c1.c3 r1 = (c1.c3) r1
            c1.u1 r0 = r1.f1149a     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.w0 r2 = r0.f     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.u1.m(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.u0 r2 = r2.f1545n     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "onActivityCreated"
            r2.b(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            android.content.Intent r2 = r9.f2256c     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L95
            android.net.Uri r3 = r2.getData()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 == 0) goto L2c
            boolean r4 = r3.isHierarchical()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r4 != 0) goto L24
            goto L2c
        L24:
            r5 = r3
            goto L45
        L26:
            r0 = move-exception
            goto Lb1
        L29:
            r0 = move-exception
            goto La0
        L2c:
            android.os.Bundle r3 = r2.getExtras()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r4 = 0
            if (r3 == 0) goto L44
            java.lang.String r5 = "com.android.vending.referral_url"
            java.lang.String r3 = r3.getString(r5)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r5 != 0) goto L44
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            goto L24
        L44:
            r5 = r4
        L45:
            if (r5 == 0) goto L95
            boolean r3 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L4e
            goto L95
        L4e:
            c1.b5 r3 = r0.f1479i     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.u1.k(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "android.intent.extra.REFERRER_NAME"
            java.lang.String r2 = r2.getStringExtra(r3)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            java.lang.String r3 = "android-app://com.google.android.googlequicksearchbox/https/www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L76
            java.lang.String r3 = "https://www.google.com"
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r3 != 0) goto L76
            java.lang.String r3 = "android-app://com.google.appcrawler"
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r2 == 0) goto L72
            goto L76
        L72:
            java.lang.String r2 = "auto"
        L74:
            r6 = r2
            goto L79
        L76:
            java.lang.String r2 = "gs"
            goto L74
        L79:
            java.lang.String r2 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            if (r10 != 0) goto L84
            r2 = 1
        L82:
            r4 = r2
            goto L86
        L84:
            r2 = 0
            goto L82
        L86:
            c1.r1 r0 = r0.g     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.u1.m(r0)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            c1.s2 r2 = new c1.s2     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            r0.p(r2)     // Catch: java.lang.Throwable -> L26 java.lang.RuntimeException -> L29
            goto Lae
        L95:
            c1.u1 r0 = r1.f1149a
        L97:
            c1.n3 r0 = r0.f1482l
            c1.u1.l(r0)
            r0.o(r9, r10)
            return
        La0:
            c1.u1 r2 = r1.f1149a     // Catch: java.lang.Throwable -> L26
            c1.w0 r2 = r2.f     // Catch: java.lang.Throwable -> L26
            c1.u1.m(r2)     // Catch: java.lang.Throwable -> L26
            c1.u0 r2 = r2.f     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "Throwable caught in onActivityCreated"
            r2.c(r0, r3)     // Catch: java.lang.Throwable -> L26
        Lae:
            c1.u1 r0 = r1.f1149a
            goto L97
        Lb1:
            c1.u1 r1 = r1.f1149a
            c1.n3 r1 = r1.f1482l
            c1.u1.l(r1)
            r1.o(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.y2.j(com.google.android.gms.internal.measurement.x0, android.os.Bundle):void");
    }

    public void k(com.google.android.gms.internal.measurement.x0 x0Var) {
        n3 n3Var = ((c3) this.f1605b).f1149a.f1482l;
        u1.l(n3Var);
        synchronized (n3Var.f1372l) {
            try {
                if (Objects.equals(n3Var.g, x0Var)) {
                    n3Var.g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (n3Var.f1149a.f1478d.u()) {
            n3Var.f.remove(Integer.valueOf(x0Var.f2254a));
        }
    }

    public void l(com.google.android.gms.internal.measurement.x0 x0Var) {
        u1 u1Var = ((c3) this.f1605b).f1149a;
        n3 n3Var = u1Var.f1482l;
        u1.l(n3Var);
        synchronized (n3Var.f1372l) {
            n3Var.f1371k = false;
            n3Var.h = true;
        }
        u1 u1Var2 = n3Var.f1149a;
        u1Var2.f1481k.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (u1Var2.f1478d.u()) {
            k3 k3VarL = n3Var.l(x0Var);
            n3Var.f1368d = n3Var.f1367c;
            n3Var.f1367c = null;
            r1 r1Var = u1Var2.g;
            u1.m(r1Var);
            r1Var.p(new a(n3Var, k3VarL, jElapsedRealtime));
        } else {
            n3Var.f1367c = null;
            r1 r1Var2 = u1Var2.g;
            u1.m(r1Var2);
            r1Var2.p(new x(n3Var, jElapsedRealtime));
        }
        g4 g4Var = u1Var.h;
        u1.l(g4Var);
        u1 u1Var3 = g4Var.f1149a;
        u1Var3.f1481k.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        r1 r1Var3 = u1Var3.g;
        u1.m(r1Var3);
        r1Var3.p(new c4(g4Var, jElapsedRealtime2, 1));
    }

    public void m(com.google.android.gms.internal.measurement.x0 x0Var) {
        u1 u1Var = ((c3) this.f1605b).f1149a;
        g4 g4Var = u1Var.h;
        u1.l(g4Var);
        u1 u1Var2 = g4Var.f1149a;
        u1Var2.f1481k.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        r1 r1Var = u1Var2.g;
        u1.m(r1Var);
        r1Var.p(new c4(g4Var, jElapsedRealtime, 0));
        n3 n3Var = u1Var.f1482l;
        u1.l(n3Var);
        Object obj = n3Var.f1372l;
        synchronized (obj) {
            n3Var.f1371k = true;
            if (!Objects.equals(x0Var, n3Var.g)) {
                synchronized (obj) {
                    n3Var.g = x0Var;
                    n3Var.h = false;
                    u1 u1Var3 = n3Var.f1149a;
                    if (u1Var3.f1478d.u()) {
                        n3Var.f1369i = null;
                        r1 r1Var2 = u1Var3.g;
                        u1.m(r1Var2);
                        r1Var2.p(new m3(n3Var, 1));
                    }
                }
            }
        }
        u1 u1Var4 = n3Var.f1149a;
        if (!u1Var4.f1478d.u()) {
            n3Var.f1367c = n3Var.f1369i;
            r1 r1Var3 = u1Var4.g;
            u1.m(r1Var3);
            r1Var3.p(new m3(n3Var, 0));
            return;
        }
        n3Var.p(x0Var.f2255b, n3Var.l(x0Var), false);
        z zVar = n3Var.f1149a.f1484n;
        u1.j(zVar);
        u1 u1Var5 = zVar.f1149a;
        u1Var5.f1481k.getClass();
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        r1 r1Var4 = u1Var5.g;
        u1.m(r1Var4);
        r1Var4.p(new x(zVar, jElapsedRealtime2));
    }

    public void n(com.google.android.gms.internal.measurement.x0 x0Var, Bundle bundle) {
        k3 k3Var;
        n3 n3Var = ((c3) this.f1605b).f1149a.f1482l;
        u1.l(n3Var);
        if (!n3Var.f1149a.f1478d.u() || bundle == null || (k3Var = (k3) n3Var.f.get(Integer.valueOf(x0Var.f2254a))) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", k3Var.f1306c);
        bundle2.putString(RewardPlus.NAME, k3Var.f1304a);
        bundle2.putString("referrer_name", k3Var.f1305b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        switch (this.f1604a) {
            case 0:
                j(com.google.android.gms.internal.measurement.x0.b(activity), bundle);
                break;
            case 1:
                activity.getClass();
                break;
            case 2:
                activity.getClass();
                if (activity instanceof p4.m0) {
                    int i10 = o4.b.f11714m + 1;
                    o4.b.f11714m = i10;
                    if (i10 == 1) {
                        ((o4.b) this.f1605b).a(activity);
                        break;
                    }
                }
                break;
            default:
                Intent intent = activity.getIntent();
                if (intent != null) {
                    if (Build.VERSION.SDK_INT > 25) {
                        a(intent);
                        break;
                    } else {
                        new Handler(Looper.getMainLooper()).post(new androidx.browser.trusted.c(27, this, intent));
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        NsdManager nsdManager;
        switch (this.f1604a) {
            case 0:
                k(com.google.android.gms.internal.measurement.x0.b(activity));
                break;
            case 1:
                activity.getClass();
                break;
            case 2:
                activity.getClass();
                if (activity instanceof p4.m0) {
                    int i10 = o4.b.f11714m;
                    if (i10 > 0) {
                        o4.b.f11714m = i10 - 1;
                    }
                    if (o4.b.f11714m == 0) {
                        o4.b bVar = (o4.b) this.f1605b;
                        try {
                            v4.f fVar = o4.b.t;
                            if (fVar != null && (nsdManager = fVar.f13135b) != null) {
                                nsdManager.unregisterService(bVar.f);
                            }
                        } catch (Exception unused) {
                        }
                        v4.a aVar = o4.b.f11721u;
                        if (aVar != null) {
                            aVar.e();
                        }
                        v4.f fVar2 = o4.b.t;
                        if (fVar2 != null) {
                            fVar2.c();
                        }
                        o4.b.t = null;
                        o4.b.f11721u = null;
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        switch (this.f1604a) {
            case 0:
                l(com.google.android.gms.internal.measurement.x0.b(activity));
                break;
            case 1:
                activity.getClass();
                break;
            case 2:
                activity.getClass();
                o4.b.g = null;
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        switch (this.f1604a) {
            case 0:
                m(com.google.android.gms.internal.measurement.x0.b(activity));
                break;
            case 1:
                activity.getClass();
                break;
            case 2:
                activity.getClass();
                o4.b.g = activity;
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        switch (this.f1604a) {
            case 0:
                n(com.google.android.gms.internal.measurement.x0.b(activity), bundle);
                break;
            case 1:
                activity.getClass();
                bundle.getClass();
                break;
            case 2:
                activity.getClass();
                bundle.getClass();
                break;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        switch (this.f1604a) {
            case 0:
                return;
            case 1:
                activity.getClass();
                WeakReference weakReference = (WeakReference) this.f1605b;
                if (weakReference == null || !kotlin.jvm.internal.l.a((Activity) weakReference.get(), activity)) {
                    if (!z1.t1.f14361a) {
                        b.o oVar = ChoiceCmp.g;
                        w6.c cVar = null;
                        if (oVar == null) {
                            kotlin.jvm.internal.l.i("viewModel");
                            throw null;
                        }
                        if (!oVar.f813m) {
                            ChoiceCmp.access$startLoadCmpInfo(ChoiceCmp.INSTANCE);
                        } else if (!ChoiceCmp.f2607j) {
                            r7.w wVarA = ChoiceCmp.h;
                            if (wVarA == null) {
                                wVarA = r7.y.a(r7.y.c());
                            }
                            ChoiceCmp.h = wVarA;
                            r7.w wVar = ChoiceCmp.h;
                            if (wVar != null) {
                                r7.y.q(wVar, null, null, new b.l(2, cVar, 0), 3);
                            }
                        }
                        z1.t1.f14361a = true;
                    }
                    this.f1605b = new WeakReference(activity);
                    return;
                }
                return;
            case 2:
                activity.getClass();
                return;
            default:
                return;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        switch (this.f1604a) {
            case 1:
                activity.getClass();
                WeakReference weakReference = (WeakReference) this.f1605b;
                if (kotlin.jvm.internal.l.a(weakReference == null ? null : (Activity) weakReference.get(), activity)) {
                    if (z1.t1.f14361a) {
                        r7.w wVar = ChoiceCmp.h;
                        if (wVar != null) {
                            r7.y.f(wVar);
                        }
                        ChoiceCmp.h = null;
                        z1.t1.f14361a = false;
                    }
                    this.f1605b = null;
                    break;
                }
                break;
            case 2:
                activity.getClass();
                break;
        }
    }

    public y2(o2.e eVar) {
        this.f1604a = 1;
    }

    public /* synthetic */ y2(Object obj, int i10) {
        this.f1604a = i10;
        this.f1605b = obj;
    }

    private final void b(Activity activity) {
    }

    private final void c(Activity activity) {
    }

    private final void d(Activity activity) {
    }

    private final void f(Activity activity) {
    }

    private final void g(Activity activity) {
    }

    private final void h(Activity activity) {
    }

    private final void i(Activity activity) {
    }

    private final void e(Activity activity, Bundle bundle) {
    }
}

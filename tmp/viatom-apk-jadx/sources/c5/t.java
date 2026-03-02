package c5;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.lifecycle.LifecycleCoroutineScope;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1755a;

    /* renamed from: b, reason: collision with root package name */
    public int f1756b;

    /* renamed from: c, reason: collision with root package name */
    public int f1757c;

    /* renamed from: d, reason: collision with root package name */
    public Object f1758d;
    public Object e;

    public t(Context context, g5.h hVar, LifecycleCoroutineScope lifecycleCoroutineScope) {
        hVar.getClass();
        lifecycleCoroutineScope.getClass();
        this.f1755a = context;
        this.f1758d = hVar;
        this.e = lifecycleCoroutineScope;
        this.f1756b = -1;
        r7.y.q(lifecycleCoroutineScope, null, null, new a6.c(this, null, 6), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final h5.x0 a(c5.t r8, h5.k r9, c1.w4 r10, v5.g r11) {
        /*
            boolean r8 = r9.f8635d
            r0 = 4
            r1 = 5
            r2 = 20
            if (r8 == 0) goto L19
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "floating_category_top_"
            r8.<init>(r3)
            int r3 = r9.f8632a
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            goto L45
        L19:
            boolean r8 = r9.e
            int r3 = r9.f8632a
            if (r8 == 0) goto L26
            java.lang.String r8 = "leaf_category_top_"
            java.lang.String r8 = a3.a.f(r3, r8)
            goto L45
        L26:
            java.lang.String r8 = "category_top_"
            java.lang.String r8 = a3.a.f(r3, r8)
            int r1 = r9.f8632a
            r3 = 521(0x209, float:7.3E-43)
            if (r1 == r3) goto L44
            r3 = 523(0x20b, float:7.33E-43)
            if (r1 == r3) goto L3e
            r3 = 524(0x20c, float:7.34E-43)
            if (r1 == r3) goto L44
            r2 = 12
            r1 = 6
            goto L45
        L3e:
            float r1 = com.uptodown.UptodownApp.E
            r2 = 8
            r1 = r0
            goto L45
        L44:
            r1 = 1
        L45:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            h5.q0 r4 = r11.L(r8)
            if (r4 == 0) goto L60
            boolean r5 = r4.a()
            if (r5 == 0) goto L60
            h5.p0 r8 = r4.c()
            java.util.ArrayList r3 = c1.w4.I(r8)
            goto Lda
        L60:
            boolean r4 = r9.f8635d
            int r5 = r9.f8632a
            r6 = 0
            if (r4 == 0) goto L99
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r7 = "page[limit]"
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r4.put(r7, r2)
            java.lang.String r2 = "page[offset]"
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.put(r2, r6)
            java.lang.String r2 = "/eapi/floating-category/"
            java.lang.String r6 = "/apps"
            java.lang.String r2 = a3.a.g(r5, r2, r6)
            java.lang.String r5 = "https://www.uptodown.app:443"
            java.lang.String r5 = r5.concat(r2)
            java.lang.String r6 = "GET"
            h5.p0 r4 = r10.m(r5, r6, r4)
            org.json.JSONObject r10 = r10.k(r4, r2)
            r4.f8699d = r10
            goto L9d
        L99:
            h5.p0 r4 = r10.v(r5, r2, r6)
        L9d:
            boolean r10 = r4.b()
            if (r10 != 0) goto Lda
            org.json.JSONObject r10 = r4.f8699d
            if (r10 == 0) goto Lda
            java.util.ArrayList r3 = c1.w4.I(r4)
            java.lang.String r10 = r4.f8696a
            r10.getClass()
            long r4 = java.lang.System.currentTimeMillis()
            r11.l(r8)
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
            java.lang.String r6 = "type"
            r2.put(r6, r8)
            java.lang.String r8 = "json"
            r2.put(r8, r10)
            java.lang.String r8 = "timestamp"
            java.lang.String r10 = java.lang.String.valueOf(r4)
            r2.put(r8, r10)
            android.database.sqlite.SQLiteDatabase r8 = r11.f13150a
            r8.getClass()
            java.lang.String r10 = "responses"
            r11 = 0
            r8.insert(r10, r11, r2)
        Lda:
            h5.x0 r8 = new h5.x0
            r8.<init>(r9, r3, r0)
            r8.f8790c = r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.t.a(c5.t, h5.k, c1.w4, v5.g):h5.x0");
    }

    public static String d(l1.g gVar) {
        gVar.a();
        l1.i iVar = gVar.f10179c;
        String str = iVar.e;
        if (str != null) {
            return str;
        }
        gVar.a();
        String str2 = iVar.f10188b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String b() {
        try {
            if (((String) this.f1758d) == null) {
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f1758d;
    }

    public synchronized String c() {
        try {
            if (((String) this.e) == null) {
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.e;
    }

    public PackageInfo e(String str) {
        try {
            return this.f1755a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("FirebaseMessaging", "Failed to find package " + e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004a A[Catch: all -> 0x0025, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:15:0x0027, B:17:0x002d, B:19:0x003f, B:21:0x0045, B:24:0x004a, B:26:0x005d, B:28:0x0063, B:31:0x0068, B:33:0x0075, B:35:0x007a, B:34:0x0078), top: B:42:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean f() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f1757c     // Catch: java.lang.Throwable -> L25
            r1 = 1
            r2 = 0
            if (r0 == 0) goto La
            monitor-exit(r5)
            goto L7d
        La:
            android.content.Context r0 = r5.f1755a     // Catch: java.lang.Throwable -> L25
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L25
            java.lang.String r3 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r4 = "com.google.android.gms"
            int r3 = r0.checkPermission(r3, r4)     // Catch: java.lang.Throwable -> L25
            r4 = -1
            if (r3 != r4) goto L27
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r3 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r3)     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r2
            goto L7d
        L25:
            r0 = move-exception
            goto L81
        L27:
            boolean r3 = n0.b.a()     // Catch: java.lang.Throwable -> L25
            if (r3 != 0) goto L4a
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L25
            java.util.List r3 = r0.queryIntentServices(r3, r2)     // Catch: java.lang.Throwable -> L25
            if (r3 == 0) goto L4a
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L25
            if (r3 <= 0) goto L4a
            r5.f1757c = r1     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r1
            goto L7d
        L4a:
            android.content.Intent r3 = new android.content.Intent     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L25
            java.lang.String r4 = "com.google.android.gms"
            r3.setPackage(r4)     // Catch: java.lang.Throwable -> L25
            java.util.List r0 = r0.queryBroadcastReceivers(r3, r2)     // Catch: java.lang.Throwable -> L25
            r3 = 2
            if (r0 == 0) goto L68
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L25
            if (r0 <= 0) goto L68
            r5.f1757c = r3     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
            r0 = r3
            goto L7d
        L68:
            java.lang.String r0 = "FirebaseMessaging"
            java.lang.String r4 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r4)     // Catch: java.lang.Throwable -> L25
            boolean r0 = n0.b.a()     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L78
            r5.f1757c = r3     // Catch: java.lang.Throwable -> L25
            goto L7a
        L78:
            r5.f1757c = r1     // Catch: java.lang.Throwable -> L25
        L7a:
            int r0 = r5.f1757c     // Catch: java.lang.Throwable -> L25
            monitor-exit(r5)
        L7d:
            if (r0 == 0) goto L80
            return r1
        L80:
            return r2
        L81:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L25
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.t.f():boolean");
    }

    public synchronized void g() {
        PackageInfo packageInfoE = e(this.f1755a.getPackageName());
        if (packageInfoE != null) {
            this.f1758d = Integer.toString(packageInfoE.versionCode);
            this.e = packageInfoE.versionName;
        }
    }

    public t(Context context) {
        this.f1757c = 0;
        this.f1755a = context;
    }
}

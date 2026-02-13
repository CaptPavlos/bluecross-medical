package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.net.Uri;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g4 {

    /* renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap f1963i = new ConcurrentHashMap();

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f1964j = {"key", "value"};

    /* renamed from: a, reason: collision with root package name */
    public final ContentResolver f1965a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f1966b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f1967c;
    public volatile Map g;

    /* renamed from: d, reason: collision with root package name */
    public b4 f1968d = null;
    public volatile boolean e = true;
    public final Object f = new Object();
    public final ArrayList h = new ArrayList();

    public g4(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        contentResolver.getClass();
        uri.getClass();
        this.f1965a = contentResolver;
        this.f1966b = uri;
        this.f1967c = runnable;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002b A[PHI: r1
      0x002b: PHI (r1v3 com.google.android.gms.internal.measurement.g4) = (r1v2 com.google.android.gms.internal.measurement.g4), (r1v4 com.google.android.gms.internal.measurement.g4) binds: [B:6:0x001c, B:8:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.measurement.g4 a(final android.content.ContentResolver r2, final android.net.Uri r3, final java.lang.Runnable r4) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L14
            j$.util.concurrent.ConcurrentHashMap r0 = com.google.android.gms.internal.measurement.g4.f1963i
            com.google.android.gms.internal.measurement.f4 r1 = new com.google.android.gms.internal.measurement.f4
            r1.<init>()
            java.lang.Object r2 = j$.util.concurrent.ConcurrentMap$EL.computeIfAbsent(r0, r3, r1)
            com.google.android.gms.internal.measurement.g4 r2 = (com.google.android.gms.internal.measurement.g4) r2
            goto L2c
        L14:
            j$.util.concurrent.ConcurrentHashMap r0 = com.google.android.gms.internal.measurement.g4.f1963i
            java.lang.Object r1 = r0.get(r3)
            com.google.android.gms.internal.measurement.g4 r1 = (com.google.android.gms.internal.measurement.g4) r1
            if (r1 != 0) goto L2b
            com.google.android.gms.internal.measurement.g4 r1 = new com.google.android.gms.internal.measurement.g4
            r1.<init>(r2, r3, r4)
            java.lang.Object r2 = r0.putIfAbsent(r3, r1)
            com.google.android.gms.internal.measurement.g4 r2 = (com.google.android.gms.internal.measurement.g4) r2
            if (r2 != 0) goto L2c
        L2b:
            r2 = r1
        L2c:
            boolean r3 = r2.e     // Catch: java.lang.SecurityException -> L4e
            if (r3 == 0) goto L4d
            monitor-enter(r2)     // Catch: java.lang.SecurityException -> L4e
            boolean r3 = r2.e     // Catch: java.lang.Throwable -> L47
            if (r3 == 0) goto L49
            com.google.android.gms.internal.measurement.b4 r3 = new com.google.android.gms.internal.measurement.b4     // Catch: java.lang.Throwable -> L47
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L47
            android.content.ContentResolver r4 = r2.f1965a     // Catch: java.lang.Throwable -> L47
            android.net.Uri r0 = r2.f1966b     // Catch: java.lang.Throwable -> L47
            r1 = 0
            r4.registerContentObserver(r0, r1, r3)     // Catch: java.lang.Throwable -> L47
            r2.f1968d = r3     // Catch: java.lang.Throwable -> L47
            r2.e = r1     // Catch: java.lang.Throwable -> L47
            goto L49
        L47:
            r3 = move-exception
            goto L4b
        L49:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            return r2
        L4b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L47
            throw r3     // Catch: java.lang.SecurityException -> L4e
        L4d:
            return r2
        L4e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g4.a(android.content.ContentResolver, android.net.Uri, java.lang.Runnable):com.google.android.gms.internal.measurement.g4");
    }

    public static void c() {
        Iterator it = f1963i.values().iterator();
        while (it.hasNext()) {
            g4 g4Var = (g4) it.next();
            synchronized (g4Var) {
                try {
                    if (g4Var.e) {
                        g4Var.e = false;
                    } else {
                        b4 b4Var = g4Var.f1968d;
                        if (b4Var != null) {
                            g4Var.f1965a.unregisterContentObserver(b4Var);
                            g4Var.f1968d = null;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            it.remove();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0052  */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.Map b() {
        /*
            r5 = this;
            java.util.Map r0 = r5.g
            if (r0 != 0) goto L4f
            java.lang.Object r1 = r5.f
            monitor-enter(r1)
            java.util.Map r0 = r5.g     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L4b
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskReads()     // Catch: java.lang.Throwable -> L2a
            com.google.android.gms.internal.measurement.c6 r2 = new com.google.android.gms.internal.measurement.c6     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.c()     // Catch: java.lang.SecurityException -> L19 java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30
            goto L24
        L19:
            long r3 = android.os.Binder.clearCallingIdentity()     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            java.lang.Object r2 = r2.c()     // Catch: java.lang.Throwable -> L34
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L24:
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L26:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2a
            goto L43
        L2a:
            r0 = move-exception
            goto L4d
        L2c:
            r2 = move-exception
            goto L47
        L2e:
            r2 = move-exception
            goto L39
        L30:
            r2 = move-exception
            goto L39
        L32:
            r2 = move-exception
            goto L39
        L34:
            r2 = move-exception
            android.os.Binder.restoreCallingIdentity(r3)     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
            throw r2     // Catch: java.lang.Throwable -> L2c java.lang.IllegalStateException -> L2e android.database.sqlite.SQLiteException -> L30 java.lang.SecurityException -> L32
        L39:
            java.lang.String r3 = "ConfigurationContentLdr"
            java.lang.String r4 = "Unable to query ContentProvider, using default values"
            android.util.Log.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L2c
            java.util.Map r2 = java.util.Collections.EMPTY_MAP     // Catch: java.lang.Throwable -> L2c
            goto L26
        L43:
            r5.g = r2     // Catch: java.lang.Throwable -> L2a
            r0 = r2
            goto L4b
        L47:
            android.os.StrictMode.setThreadPolicy(r0)     // Catch: java.lang.Throwable -> L2a
            throw r2     // Catch: java.lang.Throwable -> L2a
        L4b:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            goto L4f
        L4d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L2a
            throw r0
        L4f:
            if (r0 == 0) goto L52
            return r0
        L52:
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.g4.b():java.util.Map");
    }
}

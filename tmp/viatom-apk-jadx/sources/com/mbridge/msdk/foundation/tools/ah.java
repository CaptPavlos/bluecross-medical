package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ah {

    /* renamed from: a, reason: collision with root package name */
    public volatile JSONObject f3935a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f3936b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f3937c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f3938d;
    private final Object e;
    private String f;
    private volatile ConcurrentHashMap<String, Boolean> g;
    private volatile ConcurrentHashMap<String, Integer> h;

    /* renamed from: i, reason: collision with root package name */
    private volatile com.mbridge.msdk.c.g f3939i;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final ah f3940a = new ah();
    }

    private ah() {
        this.f3936b = new Object();
        this.f3937c = new Object();
        this.f3938d = new Object();
        this.e = new Object();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x003e A[Catch: all -> 0x0014, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:20:0x003a, B:22:0x003e, B:23:0x0046, B:13:0x0016, B:15:0x001e, B:16:0x002a, B:19:0x0038), top: B:33:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.e
            monitor-enter(r0)
            com.mbridge.msdk.c.g r1 = r3.f3939i     // Catch: java.lang.Throwable -> L14
            r2 = 1
            if (r1 == 0) goto L16
            com.mbridge.msdk.c.g r1 = r3.f3939i     // Catch: java.lang.Throwable -> L14
            int r1 = r1.K()     // Catch: java.lang.Throwable -> L14
            if (r1 != r2) goto L11
            goto L16
        L11:
            if (r4 != 0) goto L3a
            goto L16
        L14:
            r4 = move-exception
            goto L52
        L16:
            java.lang.String r4 = r3.f     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            if (r4 == 0) goto L2a
            com.mbridge.msdk.foundation.a.a.a r4 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            java.lang.String r1 = "sdk_app_id"
            java.lang.String r4 = r4.a(r1)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            r3.f = r4     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
        L2a:
            com.mbridge.msdk.c.h r4 = com.mbridge.msdk.c.h.a()     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            java.lang.String r1 = r3.f     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            com.mbridge.msdk.c.g r4 = r4.a(r1)     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            r3.f3939i = r4     // Catch: java.lang.Throwable -> L14 java.lang.Exception -> L37
            goto L3a
        L37:
            r4 = 0
            r3.f3939i = r4     // Catch: java.lang.Throwable -> L14
        L3a:
            com.mbridge.msdk.c.g r4 = r3.f3939i     // Catch: java.lang.Throwable -> L14
            if (r4 == 0) goto L46
            com.mbridge.msdk.c.g r4 = r3.f3939i     // Catch: java.lang.Throwable -> L14
            org.json.JSONObject r4 = r4.am()     // Catch: java.lang.Throwable -> L14
            r3.f3935a = r4     // Catch: java.lang.Throwable -> L14
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            com.mbridge.msdk.c.g r4 = r3.f3939i
            if (r4 == 0) goto L51
            org.json.JSONObject r4 = r3.f3935a
            if (r4 != 0) goto L50
            goto L51
        L50:
            r2 = 0
        L51:
            return r2
        L52:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L14
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ah.a(boolean):boolean");
    }

    private int b(String str, String str2, int i10) {
        if (!a(true)) {
            try {
                String strOptString = this.f3935a.optString(str, "");
                if (!TextUtils.isEmpty(strOptString)) {
                    String strA = z.a(strOptString);
                    if (!TextUtils.isEmpty(strA)) {
                        return new JSONObject(strA).optInt(str2, i10);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return i10;
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.f3938d) {
            try {
                if (this.g == null) {
                    this.g = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.g;
    }

    private int b(String str, int i10) {
        if (!a(true)) {
            try {
                return this.f3935a.optInt(str, i10);
            } catch (Exception unused) {
            }
        }
        return i10;
    }

    private ConcurrentHashMap<String, Integer> b() {
        synchronized (this.f3936b) {
            try {
                if (this.h == null) {
                    this.h = new ConcurrentHashMap<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    private static Boolean b(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean b(String str, boolean z9, boolean z10) {
        if (!a(z10)) {
            try {
                return this.f3935a.optInt(str, z9 ? 1 : 0) != 0;
            } catch (Exception unused) {
            }
        }
        return z9;
    }

    private static Integer a(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final int a(String str, int i10) {
        Integer numValueOf;
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        ConcurrentHashMap<String, Integer> concurrentHashMapB = b();
        Integer numA = a(str, concurrentHashMapB);
        if (numA != null) {
            return numA.intValue();
        }
        try {
            numValueOf = Integer.valueOf(b(str, i10));
        } catch (Exception unused) {
            numValueOf = Integer.valueOf(i10);
        }
        concurrentHashMapB.put(str, numValueOf);
        return numValueOf.intValue();
    }

    public final int a(String str, String str2, int i10) {
        Integer numValueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> concurrentHashMapB = b();
                Integer numA = a(str3, concurrentHashMapB);
                if (numA != null) {
                    return numA.intValue();
                }
                try {
                    numValueOf = Integer.valueOf(b(str, str2, i10));
                } catch (Exception unused) {
                    numValueOf = Integer.valueOf(i10);
                }
                concurrentHashMapB.put(str3, numValueOf);
                return numValueOf.intValue();
            }
            return a(str2, i10);
        } catch (Exception unused2) {
            return i10;
        }
    }

    public final boolean a(String str, boolean z9) {
        try {
            return a(str, z9, true);
        } catch (Exception unused) {
            return z9;
        }
    }

    public final boolean a(String str, boolean z9, boolean z10) {
        Boolean boolValueOf;
        Boolean boolB;
        if (TextUtils.isEmpty(str)) {
            return z9;
        }
        ConcurrentHashMap<String, Boolean> concurrentHashMapC = c();
        if (z10 && (boolB = b(str, concurrentHashMapC)) != null) {
            return boolB.booleanValue();
        }
        try {
            boolValueOf = Boolean.valueOf(b(str, z9, z10));
        } catch (Exception unused) {
            boolValueOf = Boolean.valueOf(z9);
        }
        concurrentHashMapC.put(str, boolValueOf);
        return boolValueOf.booleanValue();
    }

    public static ah a() {
        return a.f3940a;
    }
}

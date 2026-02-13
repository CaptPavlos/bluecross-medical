package com.mbridge.msdk.foundation.same.a;

import androidx.window.layout.c;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, JSONObject> f3621a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3622b;

    /* renamed from: c, reason: collision with root package name */
    private int f3623c;

    public a(int i10) {
        if (i10 <= 0) {
            com.google.gson.internal.a.n("maxSize <= 0");
            throw null;
        }
        this.f3622b = i10;
        this.f3621a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0052, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(com.mbridge.msdk.foundation.same.a.a.class.getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.f3623c     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L53
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f3621a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r2.f3623c     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L53
            goto L14
        L12:
            r3 = move-exception
            goto L70
        L14:
            int r0 = r2.f3623c     // Catch: java.lang.Throwable -> L12
            if (r0 <= r3) goto L51
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f3621a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L51
        L21:
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f3621a     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L35
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            goto L52
        L35:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<java.lang.String, org.json.JSONObject> r0 = r2.f3621a     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> L4f
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch: java.lang.Throwable -> L4f
            int r0 = r2.f3623c     // Catch: java.lang.Throwable -> L4f
            int r0 = r0 + (-1)
            r2.f3623c = r0     // Catch: java.lang.Throwable -> L4f
        L4f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            goto L0
        L51:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
        L52:
            return
        L53:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class<com.mbridge.msdk.foundation.same.a.a> r1 = com.mbridge.msdk.foundation.same.a.a.class
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r3     // Catch: java.lang.Throwable -> L12
        L70:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.a.a.a(int):void");
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f3622b));
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject;
        if (str != null) {
            synchronized (this) {
                jSONObject = this.f3621a.get(str);
            }
            return jSONObject;
        }
        c.k("key == null");
        return null;
    }

    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f3621a.keySet());
        }
        return hashSet;
    }

    public final boolean a(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            synchronized (this) {
                try {
                    this.f3623c++;
                    if (this.f3621a.put(str, jSONObject) != null) {
                        this.f3623c--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            a(this.f3622b);
            return true;
        }
        c.k("key == null || value == null");
        return false;
    }
}

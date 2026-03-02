package com.mbridge.msdk.click.a;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<String, b> f2788a;

    /* renamed from: b, reason: collision with root package name */
    private final int f2789b;

    /* renamed from: c, reason: collision with root package name */
    private int f2790c;

    public c(int i10) {
        if (i10 <= 0) {
            com.google.gson.internal.a.n("maxSize <= 0");
            throw null;
        }
        this.f2789b = i10;
        this.f2788a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006c, code lost:
    
        throw new java.lang.IllegalStateException(com.mbridge.msdk.click.a.c.class.getName() + ".sizeOf() is reporting inconsistent results!");
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
            int r0 = r2.f2790c     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f2788a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r2.f2790c     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L50
            goto L14
        L12:
            r3 = move-exception
            goto L6d
        L14:
            int r0 = r2.f2790c     // Catch: java.lang.Throwable -> L12
            if (r0 <= r3) goto L4e
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f2788a     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L4e
        L21:
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f2788a     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L35
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            goto L4f
        L35:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            com.mbridge.msdk.click.a.b r0 = (com.mbridge.msdk.click.a.b) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<java.lang.String, com.mbridge.msdk.click.a.b> r0 = r2.f2788a     // Catch: java.lang.Throwable -> L4c
            r0.remove(r1)     // Catch: java.lang.Throwable -> L4c
            int r0 = r2.f2790c     // Catch: java.lang.Throwable -> L4c
            int r0 = r0 + (-1)
            r2.f2790c = r0     // Catch: java.lang.Throwable -> L4c
        L4c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            goto L0
        L4e:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
        L4f:
            return
        L50:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class<com.mbridge.msdk.click.a.c> r1 = com.mbridge.msdk.click.a.c.class
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r3     // Catch: java.lang.Throwable -> L12
        L6d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L12
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.c.a(int):void");
    }

    public final void b(String str) {
        if (str == null) {
            androidx.window.layout.c.k("key == null");
            return;
        }
        synchronized (this) {
            try {
                if (this.f2788a.remove(str) != null) {
                    this.f2790c--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.f2789b));
    }

    public final boolean a(String str, b bVar) {
        if (str != null && bVar != null) {
            synchronized (this) {
                try {
                    this.f2790c++;
                    if (this.f2788a.put(str, bVar) != null) {
                        this.f2790c--;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            a(this.f2789b);
            return true;
        }
        androidx.window.layout.c.k("key == null || value == null");
        return false;
    }

    public final b a(String str) {
        if (str != null) {
            synchronized (this) {
                try {
                    b bVar = this.f2788a.get(str);
                    if (bVar != null) {
                        return bVar;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        androidx.window.layout.c.k("key == null");
        return null;
    }

    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f2788a.keySet());
        }
        return hashSet;
    }
}

package androidx.collection;

import androidx.annotation.IntRange;
import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import com.google.gson.internal.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(@IntRange(from = 1, to = Long.MAX_VALUE) int i10) {
        this.maxSize = i10;
        if (i10 <= 0) {
            a.n("maxSize <= 0");
            throw null;
        }
        this.map = new LruHashMap<>(0, 0.75f);
        this.lock = new Lock();
    }

    private final int safeSizeOf(K k10, V v6) {
        int iSizeOf = sizeOf(k10, v6);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k10 + '=' + v6).toString());
    }

    public V create(K k10) {
        k10.getClass();
        return null;
    }

    public final int createCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.createCount;
        }
        return i10;
    }

    public void entryRemoved(boolean z9, K k10, V v6, V v9) {
        k10.getClass();
        v6.getClass();
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.evictionCount;
        }
        return i10;
    }

    public final V get(K k10) {
        V v6;
        k10.getClass();
        synchronized (this.lock) {
            V v9 = this.map.get(k10);
            if (v9 != null) {
                this.hitCount++;
                return v9;
            }
            this.missCount++;
            V vCreate = create(k10);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    v6 = (V) this.map.put(k10, vCreate);
                    if (v6 != null) {
                        this.map.put(k10, v6);
                    } else {
                        this.size += safeSizeOf(k10, vCreate);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v6 != null) {
                entryRemoved(false, k10, vCreate, v6);
                return v6;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final int hitCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.hitCount;
        }
        return i10;
    }

    public final int maxSize() {
        int i10;
        synchronized (this.lock) {
            i10 = this.maxSize;
        }
        return i10;
    }

    public final int missCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.missCount;
        }
        return i10;
    }

    public final V put(K k10, V v6) {
        V vPut;
        k10.getClass();
        v6.getClass();
        synchronized (this.lock) {
            this.putCount++;
            this.size += safeSizeOf(k10, v6);
            vPut = this.map.put(k10, v6);
            if (vPut != null) {
                this.size -= safeSizeOf(k10, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, k10, vPut, v6);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final int putCount() {
        int i10;
        synchronized (this.lock) {
            i10 = this.putCount;
        }
        return i10;
    }

    public final V remove(K k10) {
        V vRemove;
        k10.getClass();
        synchronized (this.lock) {
            vRemove = this.map.remove(k10);
            if (vRemove != null) {
                this.size -= safeSizeOf(k10, vRemove);
            }
        }
        if (vRemove != null) {
            entryRemoved(false, k10, vRemove, null);
        }
        return vRemove;
    }

    public void resize(@IntRange(from = 1, to = Long.MAX_VALUE) int i10) {
        if (i10 <= 0) {
            a.n("maxSize <= 0");
            return;
        }
        synchronized (this.lock) {
            this.maxSize = i10;
        }
        trimToSize(i10);
    }

    public final int size() {
        int i10;
        synchronized (this.lock) {
            i10 = this.size;
        }
        return i10;
    }

    public int sizeOf(K k10, V v6) {
        k10.getClass();
        v6.getClass();
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        synchronized (this.lock) {
            Iterator<T> it = this.map.getEntries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i10 = this.hitCount;
                int i11 = this.missCount + i10;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i11 != 0 ? (i10 * 100) / i11 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        throw new java.lang.IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r7) {
        /*
            r6 = this;
        L0:
            androidx.collection.internal.Lock r0 = r6.lock
            monitor-enter(r0)
            int r1 = r6.size     // Catch: java.lang.Throwable -> L14
            if (r1 < 0) goto L7a
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L17
            int r1 = r6.size     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L7a
            goto L17
        L14:
            r7 = move-exception
            goto L82
        L17:
            int r1 = r6.size     // Catch: java.lang.Throwable -> L14
            if (r1 <= r7) goto L78
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L14
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L24
            goto L78
        L24:
            androidx.collection.internal.LruHashMap<K, V> r1 = r6.map     // Catch: java.lang.Throwable -> L14
            java.util.Set r1 = r1.getEntries()     // Catch: java.lang.Throwable -> L14
            r1.getClass()     // Catch: java.lang.Throwable -> L14
            boolean r2 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L14
            r3 = 0
            if (r2 == 0) goto L42
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L14
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L3c
        L3a:
            r1 = r3
            goto L51
        L3c:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L14
            goto L51
        L42:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L14
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L4d
            goto L3a
        L4d:
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L14
        L51:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L14
            if (r1 != 0) goto L57
            monitor-exit(r0)
            return
        L57:
            java.lang.Object r2 = r1.getKey()     // Catch: java.lang.Throwable -> L14
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L14
            androidx.collection.internal.LruHashMap<K, V> r4 = r6.map     // Catch: java.lang.Throwable -> L14
            r4.remove(r2)     // Catch: java.lang.Throwable -> L14
            int r4 = r6.size     // Catch: java.lang.Throwable -> L14
            int r5 = r6.safeSizeOf(r2, r1)     // Catch: java.lang.Throwable -> L14
            int r4 = r4 - r5
            r6.size = r4     // Catch: java.lang.Throwable -> L14
            int r4 = r6.evictionCount     // Catch: java.lang.Throwable -> L14
            r5 = 1
            int r4 = r4 + r5
            r6.evictionCount = r4     // Catch: java.lang.Throwable -> L14
            monitor-exit(r0)
            r6.entryRemoved(r5, r2, r1, r3)
            goto L0
        L78:
            monitor-exit(r0)
            return
        L7a:
            java.lang.String r7 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L14
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L14
            throw r1     // Catch: java.lang.Throwable -> L14
        L82:
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LruCache.trimToSize(int):void");
    }
}

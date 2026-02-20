package androidx.datastore.core;

import u7.c0;
import u7.h;
import u7.i0;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DataStoreInMemoryCache<T> {
    private final c0 cachedValue;

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.INSTANCE;
        unInitialized.getClass();
        this.cachedValue = i0.a(unInitialized);
    }

    public final State<T> getCurrentState() {
        return (State) ((m0) this.cachedValue).getValue();
    }

    public final h getFlow() {
        return this.cachedValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.datastore.core.State<T> tryUpdate(androidx.datastore.core.State<T> r7) {
        /*
            r6 = this;
            r7.getClass()
            u7.c0 r0 = r6.cachedValue
        L5:
            r1 = r0
            u7.m0 r1 = (u7.m0) r1
            java.lang.Object r2 = r1.getValue()
            r3 = r2
            androidx.datastore.core.State r3 = (androidx.datastore.core.State) r3
            boolean r4 = r3 instanceof androidx.datastore.core.ReadException
            if (r4 == 0) goto L15
            r4 = 1
            goto L1b
        L15:
            androidx.datastore.core.UnInitialized r4 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r4 = kotlin.jvm.internal.l.a(r3, r4)
        L1b:
            if (r4 == 0) goto L1e
            goto L2c
        L1e:
            boolean r4 = r3 instanceof androidx.datastore.core.Data
            if (r4 == 0) goto L2e
            int r4 = r7.getVersion()
            int r5 = r3.getVersion()
            if (r4 <= r5) goto L32
        L2c:
            r3 = r7
            goto L32
        L2e:
            boolean r4 = r3 instanceof androidx.datastore.core.Final
            if (r4 == 0) goto L42
        L32:
            e2.a r4 = v7.c.f13178b
            if (r2 != 0) goto L37
            r2 = r4
        L37:
            if (r3 != 0) goto L3a
            goto L3b
        L3a:
            r4 = r3
        L3b:
            boolean r1 = r1.g(r2, r4)
            if (r1 == 0) goto L5
            return r3
        L42:
            androidx.window.layout.c.b()
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreInMemoryCache.tryUpdate(androidx.datastore.core.State):androidx.datastore.core.State");
    }

    private static /* synthetic */ void getCachedValue$annotations() {
    }
}

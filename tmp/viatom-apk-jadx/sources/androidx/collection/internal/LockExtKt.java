package androidx.collection.internal;

import g7.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LockExtKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m32synchronized(Lock lock, a aVar) {
        T t;
        lock.getClass();
        aVar.getClass();
        synchronized (lock) {
            t = (T) aVar.invoke();
        }
        return t;
    }
}

package androidx.room.concurrent;

import g7.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Synchronized_jvmAndroidKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m85synchronized(Object obj, a aVar) {
        T t;
        obj.getClass();
        aVar.getClass();
        synchronized (obj) {
            t = (T) aVar.invoke();
        }
        return t;
    }
}

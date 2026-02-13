package androidx.lifecycle.viewmodel.internal;

import g7.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SynchronizedObjectKt {
    /* renamed from: synchronized, reason: not valid java name */
    public static final <T> T m81synchronized(SynchronizedObject synchronizedObject, a aVar) {
        T t;
        synchronizedObject.getClass();
        aVar.getClass();
        synchronized (synchronizedObject) {
            t = (T) aVar.invoke();
        }
        return t;
    }
}

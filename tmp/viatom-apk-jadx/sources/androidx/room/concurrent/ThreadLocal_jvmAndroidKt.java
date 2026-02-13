package androidx.room.concurrent;

import w6.f;
import w7.v;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ThreadLocal_jvmAndroidKt {
    public static final <T> f asContextElement(ThreadLocal<T> threadLocal, T t) {
        threadLocal.getClass();
        return new v(threadLocal, t);
    }

    public static final long currentThreadId() {
        return Thread.currentThread().getId();
    }

    public static /* synthetic */ void ThreadLocal$annotations() {
    }
}

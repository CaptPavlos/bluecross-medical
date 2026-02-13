package w1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicLong f13397a;

    public u(AtomicLong atomicLong) {
        this.f13397a = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new t(runnable, 0));
        threadNewThread.setName("awaitEvenIfOnMainThread task continuation executor" + this.f13397a.getAndIncrement());
        return threadNewThread;
    }
}

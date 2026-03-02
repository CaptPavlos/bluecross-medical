package o0;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f11662a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadFactory f11663b = Executors.defaultThreadFactory();

    public a(String str) {
        this.f11662a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f11663b.newThread(new b(0, runnable));
        threadNewThread.setName(this.f11662a);
        return threadNewThread;
    }
}

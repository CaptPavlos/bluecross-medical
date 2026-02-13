package q8;

import java.util.concurrent.ThreadFactory;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f12287a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f12288b;

    public b(String str, boolean z9) {
        this.f12287a = str;
        this.f12288b = z9;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f12287a);
        thread.setDaemon(this.f12288b);
        return thread;
    }
}

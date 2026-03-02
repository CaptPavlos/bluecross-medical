package r1;

import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements ThreadFactory {
    public static final ThreadFactory e = Executors.defaultThreadFactory();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicLong f12314a = new AtomicLong();

    /* renamed from: b, reason: collision with root package name */
    public final String f12315b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12316c;

    /* renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f12317d;

    public a(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        this.f12315b = str;
        this.f12316c = i10;
        this.f12317d = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = e.newThread(new androidx.browser.trusted.c(20, this, runnable));
        Locale locale = Locale.ROOT;
        threadNewThread.setName(this.f12315b + " Thread #" + this.f12314a.getAndIncrement());
        return threadNewThread;
    }
}

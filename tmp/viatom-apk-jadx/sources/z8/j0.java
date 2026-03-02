package z8;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: d, reason: collision with root package name */
    public static final i0 f14480d = new i0();

    /* renamed from: a, reason: collision with root package name */
    public boolean f14481a;

    /* renamed from: b, reason: collision with root package name */
    public long f14482b;

    /* renamed from: c, reason: collision with root package name */
    public long f14483c;

    public j0 a() {
        this.f14481a = false;
        return this;
    }

    public j0 b() {
        this.f14483c = 0L;
        return this;
    }

    public long c() {
        if (this.f14481a) {
            return this.f14482b;
        }
        androidx.window.layout.c.g("No deadline");
        return 0L;
    }

    public j0 d(long j10) {
        this.f14481a = true;
        this.f14482b = j10;
        return this;
    }

    public boolean e() {
        return this.f14481a;
    }

    public void f() throws InterruptedIOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f14481a && this.f14482b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public j0 g(long j10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.getClass();
        if (j10 >= 0) {
            this.f14483c = timeUnit.toNanos(j10);
            return this;
        }
        f.b(a3.a.h(j10, "timeout < 0: "));
        return null;
    }
}

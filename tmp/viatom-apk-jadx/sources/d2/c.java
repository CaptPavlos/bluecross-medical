package d2;

import a3.z0;
import android.os.SystemClock;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import e2.d;
import h1.i;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m.g;
import w1.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final double f6796a;

    /* renamed from: b, reason: collision with root package name */
    public final double f6797b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6798c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6799d;
    public final int e;
    public final ArrayBlockingQueue f;
    public final ThreadPoolExecutor g;
    public final z0 h;

    /* renamed from: i, reason: collision with root package name */
    public final t1.c f6800i;

    /* renamed from: j, reason: collision with root package name */
    public int f6801j;

    /* renamed from: k, reason: collision with root package name */
    public long f6802k;

    public c(z0 z0Var, d dVar, t1.c cVar) {
        double d8 = dVar.f7634d;
        double d10 = dVar.e;
        this.f6796a = d8;
        this.f6797b = d10;
        this.f6798c = dVar.f * 1000;
        this.h = z0Var;
        this.f6800i = cVar;
        this.f6799d = SystemClock.elapsedRealtime();
        int i10 = (int) d8;
        this.e = i10;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i10);
        this.f = arrayBlockingQueue;
        this.g = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f6801j = 0;
        this.f6802k = 0L;
    }

    public final int a() {
        if (this.f6802k == 0) {
            this.f6802k = System.currentTimeMillis();
        }
        int iCurrentTimeMillis = (int) ((System.currentTimeMillis() - this.f6802k) / this.f6798c);
        int size = this.f.size();
        int i10 = this.f6801j;
        int iMin = size == this.e ? Math.min(100, i10 + iCurrentTimeMillis) : Math.max(0, i10 - iCurrentTimeMillis);
        if (this.f6801j != iMin) {
            this.f6801j = iMin;
            this.f6802k = System.currentTimeMillis();
        }
        return iMin;
    }

    public final void b(final w1.b bVar, final i iVar) {
        String str = "Sending report through Google DataTransport: " + bVar.f13322b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
        final boolean z9 = SystemClock.elapsedRealtime() - this.f6799d < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS;
        this.h.n(new m.a(bVar.f13321a, m.d.f11156c, null), new g() { // from class: d2.b
            @Override // m.g
            public final void a(Exception exc) throws Throwable {
                i iVar2 = iVar;
                if (exc != null) {
                    iVar2.b(exc);
                    return;
                }
                if (z9) {
                    boolean z10 = true;
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    new Thread(new androidx.browser.trusted.c(10, this.f6792a, countDownLatch)).start();
                    ExecutorService executorService = y.f13408a;
                    boolean z11 = false;
                    try {
                        long jNanoTime = 2000000000;
                        long jNanoTime2 = System.nanoTime() + 2000000000;
                        while (true) {
                            try {
                                try {
                                    countDownLatch.await(jNanoTime, TimeUnit.NANOSECONDS);
                                    break;
                                } catch (InterruptedException unused) {
                                    jNanoTime = jNanoTime2 - System.nanoTime();
                                    z11 = true;
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (z10) {
                                    Thread.currentThread().interrupt();
                                }
                                throw th;
                            }
                        }
                        if (z11) {
                            Thread.currentThread().interrupt();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = z11;
                    }
                }
                iVar2.c(bVar);
            }
        });
    }
}

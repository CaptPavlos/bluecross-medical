package w1;

import android.os.Looper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final ExecutorService f13408a;

    static {
        u uVar = new u(new AtomicLong(1L));
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), uVar, discardPolicy));
        Runtime.getRuntime().addShutdownHook(new Thread(new t(executorServiceUnconfigurableExecutorService, 1), "Crashlytics Shutdown Hook for awaitEvenIfOnMainThread task continuation executor"));
        f13408a = executorServiceUnconfigurableExecutorService;
    }

    public static void a(h1.p pVar) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        pVar.d(f13408a, new v.e(countDownLatch, 4));
        Looper mainLooper = Looper.getMainLooper();
        Looper looperMyLooper = Looper.myLooper();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (mainLooper == looperMyLooper) {
            countDownLatch.await(3000L, timeUnit);
        } else {
            countDownLatch.await(4000L, timeUnit);
        }
        if (pVar.i()) {
            pVar.g();
        } else {
            if (pVar.f8438d) {
                throw new CancellationException("Task is already canceled");
            }
            if (!pVar.h()) {
                throw new TimeoutException();
            }
            throw new IllegalStateException(pVar.f());
        }
    }
}

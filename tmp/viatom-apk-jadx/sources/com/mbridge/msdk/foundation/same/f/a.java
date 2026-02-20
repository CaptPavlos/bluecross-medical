package com.mbridge.msdk.foundation.same.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f3691a;

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f3692b;

    /* renamed from: c, reason: collision with root package name */
    private static Handler f3693c;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f3694d;
    private static ThreadPoolExecutor e;
    private static ThreadPoolExecutor f;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.foundation.same.f.a$a, reason: collision with other inner class name */
    public static class HandlerC0030a extends Handler {
        public HandlerC0030a() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
        }
    }

    public static ThreadPoolExecutor a() {
        if (f3692b == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.a.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("BitmapThreadPool");
                    return threadNewThread;
                }
            };
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(10), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
            f3692b = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f3692b;
    }

    public static ThreadPoolExecutor b() {
        if (f3691a == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.a.2
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("CommonThreadPool");
                    return threadNewThread;
                }
            };
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 25, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
            f3691a = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f3691a;
    }

    public static Handler c() {
        if (f3693c == null) {
            f3693c = new HandlerC0030a();
        }
        return f3693c;
    }

    public static ThreadPoolExecutor d() {
        if (f3694d == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.a.3
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("NwtThreadPool");
                    return threadNewThread;
                }
            };
            f3694d = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(1), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        }
        return f3694d;
    }

    public static ThreadPoolExecutor e() {
        if (e == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.a.4
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setName("ReportThreadPool");
                    return threadNewThread;
                }
            };
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(100), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
            e = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return e;
    }

    public static ThreadPoolExecutor f() {
        if (f == null) {
            ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.f.a.5
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("rv-load-tread");
                    return thread;
                }
            };
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors * 2, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(30), threadFactory, new ThreadPoolExecutor.DiscardPolicy());
            f = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f;
    }
}

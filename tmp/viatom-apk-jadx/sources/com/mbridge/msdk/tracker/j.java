package com.mbridge.msdk.tracker;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5351a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f5352b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f5355a;

        public a(Runnable runnable) {
            this.f5355a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (y.a(this.f5355a)) {
                return;
            }
            try {
                this.f5355a.run();
            } catch (Exception e) {
                if (com.mbridge.msdk.tracker.a.f5328a) {
                    Log.e("TrackManager", "execute error", e);
                }
            }
        }
    }

    public j() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.mbridge.msdk.tracker.j.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackThread");
            }
        };
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f5351a = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, threadFactory, discardPolicy);
        this.f5352b = new ThreadPoolExecutor(1, 1, 0L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.tracker.j.2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "MBridgeTrackDatabaseThread");
            }
        }, new ThreadPoolExecutor.DiscardPolicy());
    }

    public final void a(Runnable runnable) {
        this.f5351a.execute(new a(runnable));
    }

    public final void b(Runnable runnable) {
        this.f5352b.execute(new a(runnable));
    }
}

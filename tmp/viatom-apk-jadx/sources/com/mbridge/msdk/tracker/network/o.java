package com.mbridge.msdk.tracker.network;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final BlockingQueue<u<?>> f5419a;

    /* renamed from: b, reason: collision with root package name */
    private final n f5420b;

    /* renamed from: c, reason: collision with root package name */
    private final b f5421c;

    /* renamed from: d, reason: collision with root package name */
    private final x f5422d;
    private volatile boolean e = false;

    public o(BlockingQueue<u<?>> blockingQueue, n nVar, b bVar, x xVar) {
        this.f5419a = blockingQueue;
        this.f5420b = nVar;
        this.f5421c = bVar;
        this.f5422d = xVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws InterruptedException, SecurityException, IllegalArgumentException {
        Process.setThreadPriority(10);
        while (true) {
            try {
                u<?> uVarTake = this.f5419a.take();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                uVarTake.b(3);
                try {
                    try {
                        if (uVarTake.n()) {
                            uVarTake.c("network-discard-cancelled");
                            uVarTake.y();
                        } else {
                            TrafficStats.setThreadStatsTag(uVarTake.j());
                            r rVarA = this.f5420b.a(uVarTake);
                            if (rVarA.e && uVarTake.x()) {
                                uVarTake.c("not-modified");
                                uVarTake.y();
                            } else {
                                w<?> wVarA = uVarTake.a(rVarA);
                                if (uVarTake.r() && wVarA.f5495b != null) {
                                    this.f5421c.a(uVarTake.l(), wVarA.f5495b);
                                }
                                uVarTake.w();
                                this.f5422d.a(uVarTake, wVarA);
                                uVarTake.a(wVarA);
                            }
                        }
                    } catch (ad e) {
                        e.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        this.f5422d.a(uVarTake, e);
                        uVarTake.y();
                    } catch (Exception e3) {
                        ae.a(e3, "Unhandled exception %s", e3.toString());
                        ac acVar = new ac(e3);
                        acVar.a(SystemClock.elapsedRealtime() - jElapsedRealtime);
                        this.f5422d.a(uVarTake, acVar);
                        uVarTake.y();
                    }
                    uVarTake.b(4);
                } catch (Throwable th) {
                    uVarTake.b(4);
                    throw th;
                }
            } catch (InterruptedException unused) {
                if (this.e) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ae.c("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}

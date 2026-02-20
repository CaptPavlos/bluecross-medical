package com.mbridge.msdk.foundation.same.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f3690a;

    public static ThreadPoolExecutor a() {
        if (f3690a == null) {
            int iA = a(10, "c_t_l_t_p_c");
            int iA2 = a(50, "c_t_l_t_p_m");
            int iA3 = a(5, "c_t_l_t_p_t");
            int i10 = iA2 < iA ? iA : iA2;
            try {
                if (MBridgeConstans.DEBUG) {
                    af.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + iA + " max " + i10 + " timeout " + iA3);
                }
                long j10 = iA3;
                if (j10 <= 0) {
                    j10 = 1;
                }
                f3690a = new ThreadPoolExecutor(iA, i10, j10, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.e.c.1
                    @Override // java.util.concurrent.ThreadFactory
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("mb-task-loader-thread");
                        return thread;
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());
                f3690a.allowCoreThreadTimeOut(true);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e);
                }
            }
        }
        if (f3690a == null) {
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f3690a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.e.c.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-task-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
            f3690a.allowCoreThreadTimeOut(true);
        }
        return f3690a;
    }

    private static int a(int i10, String str) {
        int iA;
        try {
            iA = ah.a().a(str, i10);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonTaskLoaderThreadPool", e.getMessage());
            }
        }
        return iA <= 0 ? i10 : iA;
    }
}

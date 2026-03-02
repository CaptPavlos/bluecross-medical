package com.mbridge.msdk.newreward.function.common;

import android.os.Handler;
import android.os.HandlerThread;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class MBridgeTaskManager {
    private static final int CAMPAIGN_TABLE_THREAD_POOL_CORE_SIZE = 1;
    private static final int CAMPAIGN_TABLE_THREAD_POOL_MAX_SIZE = 1;
    private static final String TAG = "MBridgeTaskManager";
    private static volatile ThreadPoolExecutor campaignTableExecutor;
    private static volatile ThreadPoolExecutor commonExecutor;
    private static volatile Handler directorHandler;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class TaskWrapper implements Runnable {
        private final Runnable runnable;

        public TaskWrapper(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable = this.runnable;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    if (MBridgeConstans.DEBUG) {
                        af.b(MBridgeTaskManager.TAG, "TaskWrapper", th);
                    }
                }
            }
        }
    }

    private MBridgeTaskManager() {
    }

    public static void campaignTableExecute(Runnable runnable) {
        getCampaignTableExecutor().execute(new TaskWrapper(runnable));
    }

    public static void commonExecute(Runnable runnable) {
        getCommonExecutor().execute(new TaskWrapper(runnable));
    }

    public static void directorExecute(Runnable runnable, long j10) {
        getDirectorHandler().postDelayed(new TaskWrapper(runnable), j10);
    }

    private static Executor getCampaignTableExecutor() {
        if (campaignTableExecutor != null) {
            return campaignTableExecutor;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (campaignTableExecutor == null) {
                    campaignTableExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.newreward.function.common.MBridgeTaskManager.2
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("MBridgeCampaignTableTask");
                            return thread;
                        }
                    }, new ThreadPoolExecutor.DiscardPolicy());
                    campaignTableExecutor.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return campaignTableExecutor;
    }

    private static Executor getCommonExecutor() {
        if (commonExecutor != null) {
            return commonExecutor;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (commonExecutor == null) {
                    commonExecutor = new ThreadPoolExecutor(10, 10, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.mbridge.msdk.newreward.function.common.MBridgeTaskManager.1
                        @Override // java.util.concurrent.ThreadFactory
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("MBridgeCommonTask");
                            return thread;
                        }
                    });
                    commonExecutor.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return commonExecutor;
    }

    private static Handler getDirectorHandler() {
        if (directorHandler != null) {
            return directorHandler;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (directorHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("mb_director_thread");
                    handlerThread.start();
                    directorHandler = new Handler(handlerThread.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return directorHandler;
    }
}

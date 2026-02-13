package androidx.work.impl.background.greedy;

import androidx.browser.trusted.c;
import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class TimeLimiter {
    private final WorkLauncher launcher;
    private final Object lock;
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;
    private final Map<StartStopToken, Runnable> tracked;

    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j10) {
        runnableScheduler.getClass();
        workLauncher.getClass();
        this.runnableScheduler = runnableScheduler;
        this.launcher = workLauncher;
        this.timeoutMs = j10;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(StartStopToken startStopToken) {
        Runnable runnableRemove;
        startStopToken.getClass();
        synchronized (this.lock) {
            runnableRemove = this.tracked.remove(startStopToken);
        }
        if (runnableRemove != null) {
            this.runnableScheduler.cancel(runnableRemove);
        }
    }

    public final void track(StartStopToken startStopToken) {
        startStopToken.getClass();
        c cVar = new c(6, this, startStopToken);
        synchronized (this.lock) {
            this.tracked.put(startStopToken, cVar);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, cVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher) {
        this(runnableScheduler, workLauncher, 0L, 4, null);
        runnableScheduler.getClass();
        workLauncher.getClass();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j10, int i10, g gVar) {
        this(runnableScheduler, workLauncher, (i10 & 4) != 0 ? 5400000L : j10);
    }
}

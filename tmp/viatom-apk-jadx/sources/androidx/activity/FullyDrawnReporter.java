package androidx.activity;

import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FullyDrawnReporter {
    private final Executor executor;
    private final Object lock;

    @GuardedBy("lock")
    private final List<g7.a> onReportCallbacks;
    private final g7.a reportFullyDrawn;

    @GuardedBy("lock")
    private boolean reportPosted;
    private final Runnable reportRunnable;

    @GuardedBy("lock")
    private boolean reportedFullyDrawn;

    @GuardedBy("lock")
    private int reporterCount;

    public FullyDrawnReporter(Executor executor, g7.a aVar) {
        executor.getClass();
        aVar.getClass();
        this.executor = executor;
        this.reportFullyDrawn = aVar;
        this.lock = new Object();
        this.onReportCallbacks = new ArrayList();
        this.reportRunnable = new d(this, 3);
    }

    private final void postWhenReportersAreDone() {
        if (this.reportPosted || this.reporterCount != 0) {
            return;
        }
        this.reportPosted = true;
        this.executor.execute(this.reportRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportRunnable$lambda$2(FullyDrawnReporter fullyDrawnReporter) {
        fullyDrawnReporter.getClass();
        synchronized (fullyDrawnReporter.lock) {
            fullyDrawnReporter.reportPosted = false;
            if (fullyDrawnReporter.reporterCount == 0 && !fullyDrawnReporter.reportedFullyDrawn) {
                fullyDrawnReporter.reportFullyDrawn.invoke();
                fullyDrawnReporter.fullyDrawnReported();
            }
        }
    }

    public final void addOnReportDrawnListener(g7.a aVar) {
        boolean z9;
        aVar.getClass();
        synchronized (this.lock) {
            if (this.reportedFullyDrawn) {
                z9 = true;
            } else {
                this.onReportCallbacks.add(aVar);
                z9 = false;
            }
        }
        if (z9) {
            aVar.invoke();
        }
    }

    public final void addReporter() {
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn) {
                this.reporterCount++;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void fullyDrawnReported() {
        synchronized (this.lock) {
            try {
                this.reportedFullyDrawn = true;
                Iterator<T> it = this.onReportCallbacks.iterator();
                while (it.hasNext()) {
                    ((g7.a) it.next()).invoke();
                }
                this.onReportCallbacks.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isFullyDrawnReported() {
        boolean z9;
        synchronized (this.lock) {
            z9 = this.reportedFullyDrawn;
        }
        return z9;
    }

    public final void removeOnReportDrawnListener(g7.a aVar) {
        aVar.getClass();
        synchronized (this.lock) {
            this.onReportCallbacks.remove(aVar);
        }
    }

    public final void removeReporter() {
        int i10;
        synchronized (this.lock) {
            if (!this.reportedFullyDrawn && (i10 = this.reporterCount) > 0) {
                this.reporterCount = i10 - 1;
                postWhenReportersAreDone();
            }
        }
    }
}

package com.mbridge.msdk.thrid.okio;

import androidx.window.layout.c;
import com.google.gson.internal.a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class Timeout {
    public static final Timeout NONE = new Timeout() { // from class: com.mbridge.msdk.thrid.okio.Timeout.1
        @Override // com.mbridge.msdk.thrid.okio.Timeout
        public void throwIfReached() throws IOException {
        }

        @Override // com.mbridge.msdk.thrid.okio.Timeout
        public Timeout deadlineNanoTime(long j10) {
            return this;
        }

        @Override // com.mbridge.msdk.thrid.okio.Timeout
        public Timeout timeout(long j10, TimeUnit timeUnit) {
            return this;
        }
    };
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final Timeout deadline(long j10, TimeUnit timeUnit) {
        if (j10 <= 0) {
            a.n(a3.a.h(j10, "duration <= 0: "));
            return null;
        }
        if (timeUnit != null) {
            return deadlineNanoTime(timeUnit.toNanos(j10) + System.nanoTime());
        }
        a.n("unit == null");
        return null;
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        c.g("No deadline");
        return 0L;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public Timeout timeout(long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            a.n(a3.a.h(j10, "timeout < 0: "));
            return null;
        }
        if (timeUnit != null) {
            this.timeoutNanos = timeUnit.toNanos(j10);
            return this;
        }
        a.n("unit == null");
        return null;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) throws InterruptedException, InterruptedIOException {
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                obj.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j10 = jTimeoutNanos / 1000000;
                Long.signum(j10);
                obj.wait(j10, (int) (jTimeoutNanos - (1000000 * j10)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public Timeout deadlineNanoTime(long j10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j10;
        return this;
    }
}

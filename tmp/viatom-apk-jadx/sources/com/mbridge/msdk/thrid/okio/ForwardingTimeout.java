package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout timeout) {
        if (timeout != null) {
            this.delegate = timeout;
        } else {
            a.n("delegate == null");
            throw null;
        }
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    public final Timeout delegate() {
        return this.delegate;
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public boolean hasDeadline() {
        return this.delegate.hasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout timeout) {
        if (timeout != null) {
            this.delegate = timeout;
            return this;
        }
        a.n("delegate == null");
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public void throwIfReached() throws IOException {
        this.delegate.throwIfReached();
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public Timeout timeout(long j10, TimeUnit timeUnit) {
        return this.delegate.timeout(j10, timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public long timeoutNanos() {
        return this.delegate.timeoutNanos();
    }

    @Override // com.mbridge.msdk.thrid.okio.Timeout
    public Timeout deadlineNanoTime(long j10) {
        return this.delegate.deadlineNanoTime(j10);
    }
}

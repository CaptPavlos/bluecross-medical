package com.mbridge.msdk.playercommon.exoplayer2.util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ConditionVariable {
    private boolean isOpen;

    public final synchronized boolean block(long j10) throws InterruptedException {
        boolean z9;
        long jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long j11 = j10 + jElapsedRealtime;
        while (true) {
            z9 = this.isOpen;
            if (z9 || jElapsedRealtime >= j11) {
                break;
            }
            wait(j11 - jElapsedRealtime);
            jElapsedRealtime = android.os.SystemClock.elapsedRealtime();
        }
        return z9;
    }

    public final synchronized boolean close() {
        boolean z9;
        z9 = this.isOpen;
        this.isOpen = false;
        return z9;
    }

    public final synchronized boolean open() {
        if (this.isOpen) {
            return false;
        }
        this.isOpen = true;
        notifyAll();
        return true;
    }

    public final synchronized void block() throws InterruptedException {
        while (!this.isOpen) {
            wait();
        }
    }
}

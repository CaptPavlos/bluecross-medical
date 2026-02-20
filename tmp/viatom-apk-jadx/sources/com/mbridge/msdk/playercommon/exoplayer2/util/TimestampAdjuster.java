package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = C.TIME_UNSET;
    private long timestampOffsetUs;

    public TimestampAdjuster(long j10) {
        setFirstSampleTimestampUs(j10);
    }

    public static long ptsToUs(long j10) {
        return (j10 * 1000000) / 90000;
    }

    public static long usToPts(long j10) {
        return (j10 * 90000) / 1000000;
    }

    public final long adjustSampleTimestamp(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            this.lastSampleTimestampUs = j10;
        } else {
            long j11 = this.firstSampleTimestampUs;
            if (j11 != Long.MAX_VALUE) {
                this.timestampOffsetUs = j11 - j10;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = j10;
                notifyAll();
            }
        }
        return j10 + this.timestampOffsetUs;
    }

    public final long adjustTsTimestamp(long j10) {
        if (j10 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            long jUsToPts = usToPts(this.lastSampleTimestampUs);
            long j11 = (4294967296L + jUsToPts) / MAX_PTS_PLUS_ONE;
            long j12 = ((j11 - 1) * MAX_PTS_PLUS_ONE) + j10;
            long j13 = (j11 * MAX_PTS_PLUS_ONE) + j10;
            j10 = Math.abs(j12 - jUsToPts) < Math.abs(j13 - jUsToPts) ? j12 : j13;
        }
        return adjustSampleTimestamp(ptsToUs(j10));
    }

    public final long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public final long getLastAdjustedTimestampUs() {
        if (this.lastSampleTimestampUs != C.TIME_UNSET) {
            return this.lastSampleTimestampUs + this.timestampOffsetUs;
        }
        long j10 = this.firstSampleTimestampUs;
        return j10 != Long.MAX_VALUE ? j10 : C.TIME_UNSET;
    }

    public final long getTimestampOffsetUs() {
        if (this.firstSampleTimestampUs == Long.MAX_VALUE) {
            return 0L;
        }
        return this.lastSampleTimestampUs == C.TIME_UNSET ? C.TIME_UNSET : this.timestampOffsetUs;
    }

    public final void reset() {
        this.lastSampleTimestampUs = C.TIME_UNSET;
    }

    public final synchronized void setFirstSampleTimestampUs(long j10) {
        Assertions.checkState(this.lastSampleTimestampUs == C.TIME_UNSET);
        this.firstSampleTimestampUs = j10;
    }

    public final synchronized void waitUntilInitialized() throws InterruptedException {
        while (this.lastSampleTimestampUs == C.TIME_UNSET) {
            wait();
        }
    }
}

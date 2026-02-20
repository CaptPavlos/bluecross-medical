package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener<Object> {
    private static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final long DEFAULT_INITIAL_BITRATE_ESTIMATE = 1000000;
    public static final int DEFAULT_SLIDING_WINDOW_MAX_WEIGHT = 2000;
    private static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    private long bitrateEstimate;
    private final Clock clock;

    @Nullable
    private final Handler eventHandler;

    @Nullable
    private final BandwidthMeter.EventListener eventListener;
    private long sampleBytesTransferred;
    private long sampleStartTimeMs;
    private final SlidingPercentile slidingPercentile;
    private int streamCount;
    private long totalBytesTransferred;
    private long totalElapsedTimeMs;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {

        @Nullable
        private Handler eventHandler;

        @Nullable
        private BandwidthMeter.EventListener eventListener;
        private long initialBitrateEstimate = 1000000;
        private int slidingWindowMaxWeight = 2000;
        private Clock clock = Clock.DEFAULT;

        public final DefaultBandwidthMeter build() {
            return new DefaultBandwidthMeter(this.eventHandler, this.eventListener, this.initialBitrateEstimate, this.slidingWindowMaxWeight, this.clock);
        }

        public final Builder setClock(Clock clock) {
            this.clock = clock;
            return this;
        }

        public final Builder setEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
            Assertions.checkArgument((handler == null || eventListener == null) ? false : true);
            this.eventHandler = handler;
            this.eventListener = eventListener;
            return this;
        }

        public final Builder setInitialBitrateEstimate(long j10) {
            this.initialBitrateEstimate = j10;
            return this;
        }

        public final Builder setSlidingWindowMaxWeight(int i10) {
            this.slidingWindowMaxWeight = i10;
            return this;
        }
    }

    private DefaultBandwidthMeter(@Nullable Handler handler, @Nullable BandwidthMeter.EventListener eventListener, long j10, int i10, Clock clock) {
        this.eventHandler = handler;
        this.eventListener = eventListener;
        this.slidingPercentile = new SlidingPercentile(i10);
        this.clock = clock;
        this.bitrateEstimate = j10;
    }

    private void notifyBandwidthSample(final int i10, final long j10, final long j11) {
        Handler handler = this.eventHandler;
        if (handler == null || this.eventListener == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultBandwidthMeter.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultBandwidthMeter.this.eventListener.onBandwidthSample(i10, j10, j11);
            }
        });
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter
    public final synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public final synchronized void onBytesTransferred(Object obj, int i10) {
        this.sampleBytesTransferred += i10;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public final synchronized void onTransferEnd(Object obj) throws Throwable {
        Throwable th;
        try {
            try {
                Assertions.checkState(this.streamCount > 0);
                long jElapsedRealtime = this.clock.elapsedRealtime();
                int i10 = (int) (jElapsedRealtime - this.sampleStartTimeMs);
                this.totalElapsedTimeMs += i10;
                long j10 = this.totalBytesTransferred;
                long j11 = this.sampleBytesTransferred;
                this.totalBytesTransferred = j10 + j11;
                if (i10 > 0) {
                    try {
                        this.slidingPercentile.addSample((int) Math.sqrt(j11), (8000 * j11) / r7);
                        if (this.totalElapsedTimeMs >= AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS || this.totalBytesTransferred >= 524288) {
                            this.bitrateEstimate = (long) this.slidingPercentile.getPercentile(0.5f);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                notifyBandwidthSample(i10, this.sampleBytesTransferred, this.bitrateEstimate);
                int i11 = this.streamCount - 1;
                this.streamCount = i11;
                if (i11 > 0) {
                    this.sampleStartTimeMs = jElapsedRealtime;
                }
                this.sampleBytesTransferred = 0L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.TransferListener
    public final synchronized void onTransferStart(Object obj, DataSpec dataSpec) {
        try {
            if (this.streamCount == 0) {
                this.sampleStartTimeMs = this.clock.elapsedRealtime();
            }
            this.streamCount++;
        } catch (Throwable th) {
            throw th;
        }
    }

    public DefaultBandwidthMeter() {
        this(null, null, 1000000L, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener) {
        this(handler, eventListener, 1000000L, 2000, Clock.DEFAULT);
    }

    @Deprecated
    public DefaultBandwidthMeter(Handler handler, BandwidthMeter.EventListener eventListener, int i10) {
        this(handler, eventListener, 1000000L, i10, Clock.DEFAULT);
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.upstream;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface BandwidthMeter {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface EventListener {
        void onBandwidthSample(int i10, long j10, long j11);
    }

    long getBitrateEstimate();
}

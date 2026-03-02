package com.mbridge.msdk.playercommon.exoplayer2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final Timeline timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(Timeline timeline, int i10, long j10) {
        this.timeline = timeline;
        this.windowIndex = i10;
        this.positionMs = j10;
    }
}

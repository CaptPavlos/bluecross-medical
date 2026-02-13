package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class MediaPeriodInfo {
    public final long contentPositionUs;
    public final long durationUs;
    public final long endPositionUs;
    public final MediaSource.MediaPeriodId id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j10, long j11, long j12, long j13, boolean z9, boolean z10) {
        this.id = mediaPeriodId;
        this.startPositionUs = j10;
        this.endPositionUs = j11;
        this.contentPositionUs = j12;
        this.durationUs = j13;
        this.isLastInTimelinePeriod = z9;
        this.isFinal = z10;
    }

    public final MediaPeriodInfo copyWithPeriodIndex(int i10) {
        return new MediaPeriodInfo(this.id.copyWithPeriodIndex(i10), this.startPositionUs, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }

    public final MediaPeriodInfo copyWithStartPositionUs(long j10) {
        return new MediaPeriodInfo(this.id, j10, this.endPositionUs, this.contentPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isFinal);
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j10, long j11, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j11;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j10 == -1) {
            this.dataSize = -1L;
            this.durationUs = C.TIME_UNSET;
        } else {
            this.dataSize = j10 - j11;
            this.durationUs = getTimeUs(j10);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final SeekMap.SeekPoints getSeekPoints(long j10) {
        long j11 = this.dataSize;
        if (j11 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.firstFramePosition));
        }
        int i10 = this.frameSize;
        long jConstrainValue = Util.constrainValue((((this.bitrate * j10) / 8000000) / i10) * i10, 0L, j11 - i10);
        long j12 = this.firstFramePosition + jConstrainValue;
        long timeUs = getTimeUs(j12);
        SeekPoint seekPoint = new SeekPoint(timeUs, j12);
        if (timeUs < j10) {
            long j13 = this.dataSize;
            int i11 = this.frameSize;
            if (jConstrainValue != j13 - i11) {
                long j14 = j12 + i11;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j14), j14));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public final long getTimeUs(long j10) {
        return (Math.max(0L, j10 - this.firstFramePosition) * 8000000) / this.bitrate;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public final boolean isSeekable() {
        return this.dataSize != -1;
    }
}

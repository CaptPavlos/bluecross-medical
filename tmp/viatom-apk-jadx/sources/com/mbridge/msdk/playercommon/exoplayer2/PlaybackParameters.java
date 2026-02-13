package com.mbridge.msdk.playercommon.exoplayer2;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT = new PlaybackParameters(1.0f);
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    public PlaybackParameters(float f, float f10, boolean z9) {
        Assertions.checkArgument(f > 0.0f);
        Assertions.checkArgument(f10 > 0.0f);
        this.speed = f;
        this.pitch = f10;
        this.skipSilence = z9;
        this.scaledUsPerMs = Math.round(f * 1000.0f);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PlaybackParameters.class == obj.getClass()) {
            PlaybackParameters playbackParameters = (PlaybackParameters) obj;
            if (this.speed == playbackParameters.speed && this.pitch == playbackParameters.pitch && this.skipSilence == playbackParameters.skipSilence) {
                return true;
            }
        }
        return false;
    }

    public final long getMediaTimeUsForPlayoutTimeMs(long j10) {
        return j10 * this.scaledUsPerMs;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.pitch) + ((Float.floatToRawIntBits(this.speed) + 527) * 31)) * 31) + (this.skipSilence ? 1 : 0);
    }

    public PlaybackParameters(float f, float f10) {
        this(f, f10, false);
    }

    public PlaybackParameters(float f) {
        this(f, 1.0f, false);
    }
}

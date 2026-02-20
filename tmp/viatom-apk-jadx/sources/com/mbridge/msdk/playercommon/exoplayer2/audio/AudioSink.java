package com.mbridge.msdk.playercommon.exoplayer2.audio;

import a3.a;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        /* JADX WARN: Illegal instructions before constructor call */
        public InitializationException(int i10, int i11, int i12, int i13) {
            StringBuilder sbQ = a.q(i10, i11, "AudioTrack init failed: ", ", Config(", ", ");
            sbQ.append(i12);
            sbQ.append(", ");
            sbQ.append(i13);
            sbQ.append(")");
            super(sbQ.toString());
            this.audioTrackState = i10;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Listener {
        void onAudioSessionId(int i10);

        void onPositionDiscontinuity();

        void onUnderrun(int i10, long j10, long j11);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int i10) {
            super(a.f(i10, "AudioTrack write failed: "));
            this.errorCode = i10;
        }
    }

    void configure(int i10, int i11, int i12, int i13, @Nullable int[] iArr, int i14, int i15) throws ConfigurationException;

    void disableTunneling();

    void enableTunnelingV21(int i10);

    long getCurrentPositionUs(boolean z9);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer byteBuffer, long j10) throws InitializationException, WriteException;

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEncodingSupported(int i10);

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream() throws WriteException;

    void release();

    void reset();

    void setAudioAttributes(AudioAttributes audioAttributes);

    void setAudioSessionId(int i10);

    void setListener(Listener listener);

    PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters);

    void setVolume(float f);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(Throwable th) {
            super(th);
        }

        public ConfigurationException(String str) {
            super(str);
        }
    }
}

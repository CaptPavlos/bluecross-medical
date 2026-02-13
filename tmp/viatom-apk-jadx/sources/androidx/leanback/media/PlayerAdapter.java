package androidx.leanback.media;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class PlayerAdapter {
    Callback mCallback;

    public long getBufferedPosition() {
        return 0L;
    }

    public final Callback getCallback() {
        return this.mCallback;
    }

    public long getCurrentPosition() {
        return 0L;
    }

    public long getDuration() {
        return 0L;
    }

    public long getSupportedActions() {
        return 64L;
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isPrepared() {
        return true;
    }

    public abstract void pause();

    public abstract void play();

    public final void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void fastForward() {
    }

    public void next() {
    }

    public void onDetachedFromHost() {
    }

    public void previous() {
    }

    public void rewind() {
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Callback {
        public void onBufferedPositionChanged(PlayerAdapter playerAdapter) {
        }

        public void onCurrentPositionChanged(PlayerAdapter playerAdapter) {
        }

        public void onDurationChanged(PlayerAdapter playerAdapter) {
        }

        public void onMetadataChanged(PlayerAdapter playerAdapter) {
        }

        public void onPlayCompleted(PlayerAdapter playerAdapter) {
        }

        public void onPlayStateChanged(PlayerAdapter playerAdapter) {
        }

        public void onPreparedStateChanged(PlayerAdapter playerAdapter) {
        }

        public void onBufferingStateChanged(PlayerAdapter playerAdapter, boolean z9) {
        }

        public void onError(PlayerAdapter playerAdapter, int i10, String str) {
        }

        public void onVideoSizeChanged(PlayerAdapter playerAdapter, int i10, int i11) {
        }
    }

    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
    }

    public void seekTo(long j10) {
    }

    public void setProgressUpdatingEnabled(boolean z9) {
    }

    public void setRepeatAction(int i10) {
    }

    public void setShuffleAction(int i10) {
    }
}

package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.f;
import android.support.v4.media.session.k;
import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MediaControllerAdapter extends PlayerAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "MediaControllerAdapter";
    private k mController;
    Handler mHandler = new Handler();
    private final Runnable mPositionUpdaterRunnable = new Runnable() { // from class: androidx.leanback.media.MediaControllerAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            MediaControllerAdapter.this.mHandler.postDelayed(this, r0.getUpdatePeriod());
        }
    };
    boolean mIsBuffering = false;
    f mMediaControllerCallback = new f() { // from class: androidx.leanback.media.MediaControllerAdapter.2
        @Override // android.support.v4.media.session.f
        public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
            MediaControllerAdapter.this.getCallback().onMetadataChanged(MediaControllerAdapter.this);
        }

        @Override // android.support.v4.media.session.f
        public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
            MediaControllerAdapter mediaControllerAdapter = MediaControllerAdapter.this;
            if (mediaControllerAdapter.mIsBuffering && playbackStateCompat.f399a != 6) {
                mediaControllerAdapter.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, false);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.mIsBuffering = false;
            }
            int i10 = playbackStateCompat.f399a;
            int i11 = playbackStateCompat.f;
            CharSequence charSequence = playbackStateCompat.g;
            if (i10 == 0) {
                return;
            }
            if (i10 == 1) {
                MediaControllerAdapter.this.getCallback().onPlayCompleted(MediaControllerAdapter.this);
                return;
            }
            if (i10 == 2) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i10 == 3) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i10 == 6) {
                MediaControllerAdapter mediaControllerAdapter2 = MediaControllerAdapter.this;
                mediaControllerAdapter2.mIsBuffering = true;
                mediaControllerAdapter2.getCallback().onBufferingStateChanged(MediaControllerAdapter.this, true);
                MediaControllerAdapter.this.getCallback().onBufferedPositionChanged(MediaControllerAdapter.this);
                return;
            }
            if (i10 == 7) {
                MediaControllerAdapter mediaControllerAdapter3 = MediaControllerAdapter.this;
                if (charSequence == null) {
                    mediaControllerAdapter3.getCallback().onError(MediaControllerAdapter.this, i11, "");
                    return;
                } else {
                    mediaControllerAdapter3.getCallback().onError(MediaControllerAdapter.this, i11, charSequence.toString());
                    return;
                }
            }
            if (i10 == 4) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            } else if (i10 == 5) {
                MediaControllerAdapter.this.getCallback().onPlayStateChanged(MediaControllerAdapter.this);
                MediaControllerAdapter.this.getCallback().onCurrentPositionChanged(MediaControllerAdapter.this);
            }
        }
    };

    public MediaControllerAdapter(k kVar) {
        c.k("Object of MediaControllerCompat is null");
        throw null;
    }

    private int mapRepeatActionToRepeatMode(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 != 1) {
            return i10 != 2 ? -1 : 1;
        }
        return 2;
    }

    private int mapShuffleActionToShuffleMode(int i10) {
        if (i10 != 0) {
            return i10 != 1 ? -1 : 1;
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void fastForward() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getBufferedPosition() {
        if (this.mController.b() == null) {
            return 0L;
        }
        return this.mController.b().f401c;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        if (this.mController.b() == null) {
            return 0L;
        }
        return this.mController.b().f400b;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        throw null;
    }

    public Drawable getMediaArt(Context context) {
        throw null;
    }

    public k getMediaController() {
        return this.mController;
    }

    public CharSequence getMediaSubtitle() {
        throw null;
    }

    public CharSequence getMediaTitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getSupportedActions() {
        if (this.mController.b() == null) {
            return 0L;
        }
        long j10 = this.mController.b().e;
        long j11 = (j10 & 512) != 0 ? 64L : 0L;
        if ((j10 & 32) != 0) {
            j11 |= 256;
        }
        if ((j10 & 16) != 0) {
            j11 |= 16;
        }
        if ((64 & j10) != 0) {
            j11 |= 128;
        }
        if ((8 & j10) != 0) {
            j11 |= 32;
        }
        if ((262144 & j10) != 0) {
            j11 |= 512;
        }
        return (j10 & CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) != 0 ? 1024 | j11 : j11;
    }

    public int getUpdatePeriod() {
        return 16;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        if (this.mController.b() == null) {
            return false;
        }
        return this.mController.b().f399a == 3 || this.mController.b().f399a == 4 || this.mController.b().f399a == 5;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void next() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        this.mController.c(this.mMediaControllerCallback);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void previous() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void rewind() {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long j10) {
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setProgressUpdatingEnabled(boolean z9) {
        this.mHandler.removeCallbacks(this.mPositionUpdaterRunnable);
        if (z9) {
            this.mHandler.postDelayed(this.mPositionUpdaterRunnable, getUpdatePeriod());
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setRepeatAction(int i10) {
        mapRepeatActionToRepeatMode(i10);
        throw null;
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void setShuffleAction(int i10) {
        mapShuffleActionToShuffleMode(i10);
        throw null;
    }
}

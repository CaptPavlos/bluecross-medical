package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.f;
import android.support.v4.media.session.k;
import androidx.constraintlayout.core.widgets.analyzer.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Deprecated
/* loaded from: classes.dex */
public abstract class MediaControllerGlue extends PlaybackControlGlue {
    static final boolean DEBUG = false;
    static final String TAG = "MediaControllerGlue";
    private final f mCallback;
    k mMediaController;

    public MediaControllerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.mCallback = new f() { // from class: androidx.leanback.media.MediaControllerGlue.1
            @Override // android.support.v4.media.session.f
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat) {
                MediaControllerGlue.this.onMetadataChanged();
            }

            @Override // android.support.v4.media.session.f
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat) {
                MediaControllerGlue.this.onStateChanged();
            }

            @Override // android.support.v4.media.session.f
            public void onSessionDestroyed() {
                MediaControllerGlue.this.mMediaController = null;
            }

            @Override // android.support.v4.media.session.f
            public void onSessionEvent(String str, Bundle bundle) {
            }
        };
    }

    public void detach() {
        this.mMediaController = null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentPosition() {
        return (int) this.mMediaController.b().f400b;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentSpeedId() {
        k kVar = null;
        int i10 = (int) kVar.b().f402d;
        int i11 = 0;
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 > 0) {
            int[] fastForwardSpeeds = getFastForwardSpeeds();
            while (i11 < fastForwardSpeeds.length) {
                if (i10 == fastForwardSpeeds[i11]) {
                    return i11 + 10;
                }
                i11++;
            }
        } else {
            int[] rewindSpeeds = getRewindSpeeds();
            while (i11 < rewindSpeeds.length) {
                if ((-i10) == rewindSpeeds[i11]) {
                    return (-10) - i11;
                }
                i11++;
            }
        }
        a.B(i10, "Couldn't find index for speed ", TAG);
        return -1;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public Drawable getMediaArt() {
        throw null;
    }

    public final k getMediaController() {
        return this.mMediaController;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getMediaDuration() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaSubtitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaTitle() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public long getSupportedActions() {
        long j10 = this.mMediaController.b().e;
        long j11 = (512 & j10) != 0 ? 64L : 0L;
        if ((j10 & 32) != 0) {
            j11 |= 256;
        }
        if ((j10 & 16) != 0) {
            j11 |= 16;
        }
        if ((64 & j10) != 0) {
            j11 |= 128;
        }
        return (j10 & 8) != 0 ? j11 | 32 : j11;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean hasValidMedia() {
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean isMediaPlaying() {
        return this.mMediaController.b().f399a == 3;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void next() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void play(int i10) {
        if (i10 != 1 && i10 <= 0) {
            throw null;
        }
        throw null;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void previous() {
        throw null;
    }

    public void attachToMediaController(k kVar) {
    }
}

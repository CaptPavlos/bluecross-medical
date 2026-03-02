package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ControlButtonPresenterSelector;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class PlaybackBaseControlGlue<T extends PlayerAdapter> extends PlaybackGlue implements OnActionClickedListener, View.OnKeyListener {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REPEAT = 512;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SHUFFLE = 1024;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;
    static final boolean DEBUG = false;
    static final String TAG = "PlaybackTransportGlue";
    final PlayerAdapter.Callback mAdapterCallback;
    boolean mBuffering;
    PlaybackControlsRow mControlsRow;
    PlaybackRowPresenter mControlsRowPresenter;
    Drawable mCover;
    int mErrorCode;
    String mErrorMessage;
    boolean mErrorSet;
    boolean mFadeWhenPlaying;
    boolean mIsPlaying;
    PlaybackControlsRow.PlayPauseAction mPlayPauseAction;
    final T mPlayerAdapter;
    PlaybackGlueHost.PlayerCallback mPlayerCallback;
    CharSequence mSubtitle;
    CharSequence mTitle;
    int mVideoHeight;
    int mVideoWidth;

    public PlaybackBaseControlGlue(Context context, T t) {
        super(context);
        this.mIsPlaying = false;
        this.mFadeWhenPlaying = true;
        this.mBuffering = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mErrorSet = false;
        PlayerAdapter.Callback callback = new PlayerAdapter.Callback() { // from class: androidx.leanback.media.PlaybackBaseControlGlue.1
            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onBufferedPositionChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateBufferedProgress();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onBufferingStateChanged(PlayerAdapter playerAdapter, boolean z9) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mBuffering = z9;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onBufferingStateChanged(z9);
                }
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onCurrentPositionChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateProgress();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onDurationChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onUpdateDuration();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onError(PlayerAdapter playerAdapter, int i10, String str) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mErrorSet = true;
                playbackBaseControlGlue.mErrorCode = i10;
                playbackBaseControlGlue.mErrorMessage = str;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onError(i10, str);
                }
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onMetadataChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onMetadataChanged();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onPlayCompleted(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPlayCompleted();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onPlayStateChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPlayStateChanged();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onPreparedStateChanged(PlayerAdapter playerAdapter) {
                PlaybackBaseControlGlue.this.onPreparedStateChanged();
            }

            @Override // androidx.leanback.media.PlayerAdapter.Callback
            public void onVideoSizeChanged(PlayerAdapter playerAdapter, int i10, int i11) {
                PlaybackBaseControlGlue playbackBaseControlGlue = PlaybackBaseControlGlue.this;
                playbackBaseControlGlue.mVideoWidth = i10;
                playbackBaseControlGlue.mVideoHeight = i11;
                PlaybackGlueHost.PlayerCallback playerCallback = playbackBaseControlGlue.mPlayerCallback;
                if (playerCallback != null) {
                    playerCallback.onVideoSizeChanged(i10, i11);
                }
            }
        };
        this.mAdapterCallback = callback;
        this.mPlayerAdapter = t;
        t.setCallback(callback);
    }

    public static void notifyItemChanged(ArrayObjectAdapter arrayObjectAdapter, Object obj) {
        int iIndexOf = arrayObjectAdapter.indexOf(obj);
        if (iIndexOf >= 0) {
            arrayObjectAdapter.notifyArrayItemRangeChanged(iIndexOf, 1);
        }
    }

    private void updateControlsRow() {
        onMetadataChanged();
    }

    public Drawable getArt() {
        return this.mCover;
    }

    public final long getBufferedPosition() {
        return this.mPlayerAdapter.getBufferedPosition();
    }

    public PlaybackControlsRow getControlsRow() {
        return this.mControlsRow;
    }

    public long getCurrentPosition() {
        return this.mPlayerAdapter.getCurrentPosition();
    }

    public final long getDuration() {
        return this.mPlayerAdapter.getDuration();
    }

    public PlaybackRowPresenter getPlaybackRowPresenter() {
        return this.mControlsRowPresenter;
    }

    public final T getPlayerAdapter() {
        return this.mPlayerAdapter;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public long getSupportedActions() {
        return this.mPlayerAdapter.getSupportedActions();
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean isControlsOverlayAutoHideEnabled() {
        return this.mFadeWhenPlaying;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public final boolean isPlaying() {
        return this.mPlayerAdapter.isPlaying();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public final boolean isPrepared() {
        return this.mPlayerAdapter.isPrepared();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void next() {
        this.mPlayerAdapter.next();
    }

    public abstract void onActionClicked(Action action);

    public void onAttachHostCallback() {
        int i10;
        PlaybackGlueHost.PlayerCallback playerCallback = this.mPlayerCallback;
        if (playerCallback != null) {
            int i11 = this.mVideoWidth;
            if (i11 != 0 && (i10 = this.mVideoHeight) != 0) {
                playerCallback.onVideoSizeChanged(i11, i10);
            }
            if (this.mErrorSet) {
                this.mPlayerCallback.onError(this.mErrorCode, this.mErrorMessage);
            }
            this.mPlayerCallback.onBufferingStateChanged(this.mBuffering);
        }
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        playbackGlueHost.setOnKeyInterceptListener(this);
        playbackGlueHost.setOnActionClickedListener(this);
        onCreateDefaultControlsRow();
        onCreateDefaultRowPresenter();
        playbackGlueHost.setPlaybackRowPresenter(getPlaybackRowPresenter());
        playbackGlueHost.setPlaybackRow(getControlsRow());
        this.mPlayerCallback = playbackGlueHost.getPlayerCallback();
        onAttachHostCallback();
        this.mPlayerAdapter.onAttachedToHost(playbackGlueHost);
    }

    public void onCreateDefaultControlsRow() {
        if (this.mControlsRow == null) {
            setControlsRow(new PlaybackControlsRow(this));
        }
    }

    public void onCreateDefaultRowPresenter() {
        if (this.mControlsRowPresenter == null) {
            setPlaybackRowPresenter(onCreateRowPresenter());
        }
    }

    public abstract PlaybackRowPresenter onCreateRowPresenter();

    public void onDetachHostCallback() {
        this.mErrorSet = false;
        this.mErrorCode = 0;
        this.mErrorMessage = null;
        PlaybackGlueHost.PlayerCallback playerCallback = this.mPlayerCallback;
        if (playerCallback != null) {
            playerCallback.onBufferingStateChanged(false);
        }
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        onDetachHostCallback();
        this.mPlayerCallback = null;
        this.mPlayerAdapter.onDetachedFromHost();
        this.mPlayerAdapter.setProgressUpdatingEnabled(false);
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStart() {
        this.mPlayerAdapter.setProgressUpdatingEnabled(true);
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void onHostStop() {
        this.mPlayerAdapter.setProgressUpdatingEnabled(false);
    }

    public abstract boolean onKey(View view, int i10, KeyEvent keyEvent);

    public void onMetadataChanged() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow == null) {
            return;
        }
        playbackControlsRow.setImageDrawable(getArt());
        this.mControlsRow.setDuration(getDuration());
        this.mControlsRow.setCurrentPosition(getCurrentPosition());
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    @CallSuper
    public void onPlayCompleted() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i10 = 0; i10 < size; i10++) {
                playerCallbacks.get(i10).onPlayCompleted(this);
            }
        }
    }

    @CallSuper
    public void onPlayStateChanged() {
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i10 = 0; i10 < size; i10++) {
                playerCallbacks.get(i10).onPlayStateChanged(this);
            }
        }
    }

    @CallSuper
    public void onPreparedStateChanged() {
        onUpdateDuration();
        List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
        if (playerCallbacks != null) {
            int size = playerCallbacks.size();
            for (int i10 = 0; i10 < size; i10++) {
                playerCallbacks.get(i10).onPreparedStateChanged(this);
            }
        }
    }

    @CallSuper
    public void onUpdateBufferedProgress() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setBufferedPosition(this.mPlayerAdapter.getBufferedPosition());
        }
    }

    @CallSuper
    public void onUpdateDuration() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setDuration(this.mPlayerAdapter.isPrepared() ? this.mPlayerAdapter.getDuration() : -1L);
        }
    }

    @CallSuper
    public void onUpdateProgress() {
        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
        if (playbackControlsRow != null) {
            playbackControlsRow.setCurrentPosition(this.mPlayerAdapter.isPrepared() ? getCurrentPosition() : -1L);
        }
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() {
        this.mPlayerAdapter.pause();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void play() {
        this.mPlayerAdapter.play();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void previous() {
        this.mPlayerAdapter.previous();
    }

    public final void seekTo(long j10) {
        this.mPlayerAdapter.seekTo(j10);
    }

    public void setArt(Drawable drawable) {
        if (this.mCover == drawable) {
            return;
        }
        this.mCover = drawable;
        this.mControlsRow.setImageDrawable(drawable);
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void setControlsOverlayAutoHideEnabled(boolean z9) {
        this.mFadeWhenPlaying = z9;
        if (z9 || getHost() == null) {
            return;
        }
        getHost().setControlsOverlayAutoHideEnabled(false);
    }

    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        this.mControlsRow = playbackControlsRow;
        playbackControlsRow.setCurrentPosition(-1L);
        this.mControlsRow.setDuration(-1L);
        this.mControlsRow.setBufferedPosition(-1L);
        if (this.mControlsRow.getPrimaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new ControlButtonPresenterSelector());
            onCreatePrimaryActions(arrayObjectAdapter);
            this.mControlsRow.setPrimaryActionsAdapter(arrayObjectAdapter);
        }
        if (this.mControlsRow.getSecondaryActionsAdapter() == null) {
            ArrayObjectAdapter arrayObjectAdapter2 = new ArrayObjectAdapter(new ControlButtonPresenterSelector());
            onCreateSecondaryActions(arrayObjectAdapter2);
            getControlsRow().setSecondaryActionsAdapter(arrayObjectAdapter2);
        }
        updateControlsRow();
    }

    public void setPlaybackRowPresenter(PlaybackRowPresenter playbackRowPresenter) {
        this.mControlsRowPresenter = playbackRowPresenter;
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.mSubtitle)) {
            return;
        }
        this.mSubtitle = charSequence;
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.mTitle)) {
            return;
        }
        this.mTitle = charSequence;
        if (getHost() != null) {
            getHost().notifyPlaybackRowChanged();
        }
    }

    public void onCreatePrimaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }

    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
    }
}

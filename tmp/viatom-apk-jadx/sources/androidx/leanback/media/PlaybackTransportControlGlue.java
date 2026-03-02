package androidx.leanback.media;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackSeekUi;
import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.RowPresenter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PlaybackTransportControlGlue<T extends PlayerAdapter> extends PlaybackBaseControlGlue<T> {
    static final boolean DEBUG = false;
    static final int MSG_UPDATE_PLAYBACK_STATE = 100;
    static final String TAG = "PlaybackTransportGlue";
    static final int UPDATE_PLAYBACK_STATE_DELAY_MS = 2000;
    static final Handler sHandler = new UpdatePlaybackStateHandler();
    final WeakReference<PlaybackBaseControlGlue> mGlueWeakReference;
    final PlaybackTransportControlGlue<T>.SeekUiClient mPlaybackSeekUiClient;
    boolean mSeekEnabled;
    PlaybackSeekDataProvider mSeekProvider;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class SeekUiClient extends PlaybackSeekUi.Client {
        boolean mIsSeek;
        long mLastUserPosition;
        boolean mPausedBeforeSeek;
        long mPositionBeforeSeek;

        public SeekUiClient() {
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi.Client
        public PlaybackSeekDataProvider getPlaybackSeekDataProvider() {
            return PlaybackTransportControlGlue.this.mSeekProvider;
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi.Client
        public boolean isSeekEnabled() {
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            return playbackTransportControlGlue.mSeekProvider != null || playbackTransportControlGlue.mSeekEnabled;
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi.Client
        public void onSeekFinished(boolean z9) {
            if (z9) {
                long j10 = this.mPositionBeforeSeek;
                if (j10 >= 0) {
                    PlaybackTransportControlGlue.this.seekTo(j10);
                }
            } else {
                long j11 = this.mLastUserPosition;
                if (j11 >= 0) {
                    PlaybackTransportControlGlue.this.seekTo(j11);
                }
            }
            this.mIsSeek = false;
            boolean z10 = this.mPausedBeforeSeek;
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            if (!z10) {
                playbackTransportControlGlue.play();
            } else {
                playbackTransportControlGlue.mPlayerAdapter.setProgressUpdatingEnabled(false);
                PlaybackTransportControlGlue.this.onUpdateProgress();
            }
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi.Client
        public void onSeekPositionChanged(long j10) {
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            if (playbackTransportControlGlue.mSeekProvider == null) {
                playbackTransportControlGlue.mPlayerAdapter.seekTo(j10);
            } else {
                this.mLastUserPosition = j10;
            }
            PlaybackControlsRow playbackControlsRow = PlaybackTransportControlGlue.this.mControlsRow;
            if (playbackControlsRow != null) {
                playbackControlsRow.setCurrentPosition(j10);
            }
        }

        @Override // androidx.leanback.widget.PlaybackSeekUi.Client
        public void onSeekStarted() {
            this.mIsSeek = true;
            this.mPausedBeforeSeek = !PlaybackTransportControlGlue.this.isPlaying();
            PlaybackTransportControlGlue.this.mPlayerAdapter.setProgressUpdatingEnabled(true);
            PlaybackTransportControlGlue playbackTransportControlGlue = PlaybackTransportControlGlue.this;
            this.mPositionBeforeSeek = playbackTransportControlGlue.mSeekProvider == null ? playbackTransportControlGlue.mPlayerAdapter.getCurrentPosition() : -1L;
            this.mLastUserPosition = -1L;
            PlaybackTransportControlGlue.this.pause();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class UpdatePlaybackStateHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            PlaybackTransportControlGlue playbackTransportControlGlue;
            if (message.what != 100 || (playbackTransportControlGlue = (PlaybackTransportControlGlue) ((WeakReference) message.obj).get()) == null) {
                return;
            }
            playbackTransportControlGlue.onUpdatePlaybackState();
        }
    }

    public PlaybackTransportControlGlue(Context context, T t) {
        super(context, t);
        this.mGlueWeakReference = new WeakReference<>(this);
        this.mPlaybackSeekUiClient = new SeekUiClient();
    }

    private void updatePlaybackState(boolean z9) {
        if (this.mControlsRow == null) {
            return;
        }
        if (z9) {
            this.mPlayerAdapter.setProgressUpdatingEnabled(true);
        } else {
            onUpdateProgress();
            this.mPlayerAdapter.setProgressUpdatingEnabled(this.mPlaybackSeekUiClient.mIsSeek);
        }
        if (this.mFadeWhenPlaying && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(z9);
        }
        PlaybackControlsRow.PlayPauseAction playPauseAction = this.mPlayPauseAction;
        if (playPauseAction == null || playPauseAction.getIndex() == z9) {
            return;
        }
        this.mPlayPauseAction.setIndex(z9 ? 1 : 0);
        PlaybackBaseControlGlue.notifyItemChanged((ArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter(), this.mPlayPauseAction);
    }

    public boolean dispatchAction(Action action, KeyEvent keyEvent) {
        if (!(action instanceof PlaybackControlsRow.PlayPauseAction)) {
            if (action instanceof PlaybackControlsRow.SkipNextAction) {
                next();
                return true;
            }
            if (!(action instanceof PlaybackControlsRow.SkipPreviousAction)) {
                return false;
            }
            previous();
            return true;
        }
        boolean z9 = keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 126;
        if ((keyEvent == null || keyEvent.getKeyCode() == 85 || keyEvent.getKeyCode() == 127) && this.mIsPlaying) {
            this.mIsPlaying = false;
            pause();
        } else if (z9 && !this.mIsPlaying) {
            this.mIsPlaying = true;
            play();
        }
        onUpdatePlaybackStatusAfterUserAction();
        return true;
    }

    public final PlaybackSeekDataProvider getSeekProvider() {
        return this.mSeekProvider;
    }

    public final boolean isSeekEnabled() {
        return this.mSeekEnabled;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        dispatchAction(action, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) playbackGlueHost).setPlaybackSeekUiClient(this.mPlaybackSeekUiClient);
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onCreatePrimaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
        this.mPlayPauseAction = playPauseAction;
        arrayObjectAdapter.add(playPauseAction);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public PlaybackRowPresenter onCreateRowPresenter() {
        AbstractDetailsDescriptionPresenter abstractDetailsDescriptionPresenter = new AbstractDetailsDescriptionPresenter() { // from class: androidx.leanback.media.PlaybackTransportControlGlue.1
            @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
            public void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
                PlaybackBaseControlGlue playbackBaseControlGlue = (PlaybackBaseControlGlue) obj;
                viewHolder.getTitle().setText(playbackBaseControlGlue.getTitle());
                viewHolder.getSubtitle().setText(playbackBaseControlGlue.getSubtitle());
            }
        };
        PlaybackTransportRowPresenter playbackTransportRowPresenter = new PlaybackTransportRowPresenter() { // from class: androidx.leanback.media.PlaybackTransportControlGlue.2
            @Override // androidx.leanback.widget.PlaybackTransportRowPresenter, androidx.leanback.widget.RowPresenter
            public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
                super.onBindRowViewHolder(viewHolder, obj);
                viewHolder.setOnKeyListener(PlaybackTransportControlGlue.this);
            }

            @Override // androidx.leanback.widget.PlaybackTransportRowPresenter, androidx.leanback.widget.RowPresenter
            public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
                super.onUnbindRowViewHolder(viewHolder);
                viewHolder.setOnKeyListener(null);
            }
        };
        playbackTransportRowPresenter.setDescriptionPresenter(abstractDetailsDescriptionPresenter);
        return playbackTransportRowPresenter;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        super.onDetachedFromHost();
        if (getHost() instanceof PlaybackSeekUi) {
            ((PlaybackSeekUi) getHost()).setPlaybackSeekUiClient(null);
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (i10 != 4 && i10 != 111) {
            switch (i10) {
                default:
                    Action actionForKeyCode = this.mControlsRow.getActionForKeyCode(this.mControlsRow.getPrimaryActionsAdapter(), i10);
                    if (actionForKeyCode == null) {
                        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
                        actionForKeyCode = playbackControlsRow.getActionForKeyCode(playbackControlsRow.getSecondaryActionsAdapter(), i10);
                    }
                    if (actionForKeyCode != null) {
                        if (keyEvent.getAction() != 0) {
                            return true;
                        }
                        dispatchAction(actionForKeyCode, keyEvent);
                        return true;
                    }
                case 19:
                case 20:
                case 21:
                case 22:
                    return false;
            }
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayStateChanged() {
        Handler handler = sHandler;
        if (handler.hasMessages(100, this.mGlueWeakReference)) {
            handler.removeMessages(100, this.mGlueWeakReference);
            if (this.mPlayerAdapter.isPlaying() != this.mIsPlaying) {
                handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            } else {
                onUpdatePlaybackState();
            }
        } else {
            onUpdatePlaybackState();
        }
        super.onPlayStateChanged();
    }

    public void onUpdatePlaybackState() {
        boolean zIsPlaying = this.mPlayerAdapter.isPlaying();
        this.mIsPlaying = zIsPlaying;
        updatePlaybackState(zIsPlaying);
    }

    public void onUpdatePlaybackStatusAfterUserAction() {
        updatePlaybackState(this.mIsPlaying);
        Handler handler = sHandler;
        handler.removeMessages(100, this.mGlueWeakReference);
        handler.sendMessageDelayed(handler.obtainMessage(100, this.mGlueWeakReference), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onUpdateProgress() {
        if (this.mPlaybackSeekUiClient.mIsSeek) {
            return;
        }
        super.onUpdateProgress();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        super.setControlsRow(playbackControlsRow);
        sHandler.removeMessages(100, this.mGlueWeakReference);
        onUpdatePlaybackState();
    }

    public final void setSeekEnabled(boolean z9) {
        this.mSeekEnabled = z9;
    }

    public final void setSeekProvider(PlaybackSeekDataProvider playbackSeekDataProvider) {
        this.mSeekProvider = playbackSeekDataProvider;
    }
}

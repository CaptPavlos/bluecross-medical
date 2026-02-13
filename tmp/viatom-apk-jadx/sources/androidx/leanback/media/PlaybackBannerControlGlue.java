package androidx.leanback.media;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlayerAdapter;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.PlaybackRowPresenter;
import androidx.leanback.widget.RowPresenter;
import com.google.gson.internal.a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class PlaybackBannerControlGlue<T extends PlayerAdapter> extends PlaybackBaseControlGlue<T> {
    public static final int ACTION_CUSTOM_LEFT_FIRST = 1;
    public static final int ACTION_CUSTOM_RIGHT_FIRST = 4096;
    public static final int ACTION_FAST_FORWARD = 128;
    public static final int ACTION_PLAY_PAUSE = 64;
    public static final int ACTION_REWIND = 32;
    public static final int ACTION_SKIP_TO_NEXT = 256;
    public static final int ACTION_SKIP_TO_PREVIOUS = 16;
    private static final int NUMBER_OF_SEEK_SPEEDS = 5;
    public static final int PLAYBACK_SPEED_FAST_L0 = 10;
    public static final int PLAYBACK_SPEED_FAST_L1 = 11;
    public static final int PLAYBACK_SPEED_FAST_L2 = 12;
    public static final int PLAYBACK_SPEED_FAST_L3 = 13;
    public static final int PLAYBACK_SPEED_FAST_L4 = 14;
    public static final int PLAYBACK_SPEED_INVALID = -1;
    public static final int PLAYBACK_SPEED_NORMAL = 1;
    public static final int PLAYBACK_SPEED_PAUSED = 0;
    private static final String TAG = "PlaybackBannerControlGlue";
    private PlaybackControlsRow.FastForwardAction mFastForwardAction;
    private final int[] mFastForwardSpeeds;
    private boolean mIsCustomizedFastForwardSupported;
    private boolean mIsCustomizedRewindSupported;
    private int mPlaybackSpeed;
    private PlaybackControlsRow.RewindAction mRewindAction;
    private final int[] mRewindSpeeds;
    private PlaybackControlsRow.SkipNextAction mSkipNextAction;
    private PlaybackControlsRow.SkipPreviousAction mSkipPreviousAction;
    private long mStartPosition;
    private long mStartTime;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ACTION_ {
    }

    public PlaybackBannerControlGlue(Context context, int[] iArr, int[] iArr2, T t) {
        super(context, t);
        this.mPlaybackSpeed = 0;
        this.mStartPosition = 0L;
        if (iArr.length == 0 || iArr.length > 5) {
            a.n("invalid fastForwardSpeeds array size");
            throw null;
        }
        this.mFastForwardSpeeds = iArr;
        if (iArr2.length == 0 || iArr2.length > 5) {
            a.n("invalid rewindSpeeds array size");
            throw null;
        }
        this.mRewindSpeeds = iArr2;
        if ((this.mPlayerAdapter.getSupportedActions() & 128) != 0) {
            this.mIsCustomizedFastForwardSupported = true;
        }
        if ((this.mPlayerAdapter.getSupportedActions() & 32) != 0) {
            this.mIsCustomizedRewindSupported = true;
        }
    }

    @SuppressLint({"WrongConstant"})
    private void decrementRewindPlaybackSpeed() {
        int i10 = this.mPlaybackSpeed;
        switch (i10) {
            case -13:
            case -12:
            case -11:
            case -10:
                this.mPlaybackSpeed = i10 - 1;
                break;
            default:
                this.mPlaybackSpeed = -10;
                break;
        }
    }

    private void fakePause() {
        this.mIsPlaying = true;
        this.mStartPosition = getCurrentPosition();
        this.mStartTime = System.currentTimeMillis();
        super.pause();
        onUpdatePlaybackState();
    }

    private int getMaxForwardSpeedId() {
        return this.mFastForwardSpeeds.length + 9;
    }

    private int getMaxRewindSpeedId() {
        return this.mRewindSpeeds.length + 9;
    }

    private void incrementFastForwardPlaybackSpeed() {
        int i10 = this.mPlaybackSpeed;
        switch (i10) {
            case 10:
            case 11:
            case 12:
            case 13:
                this.mPlaybackSpeed = i10 + 1;
                break;
            default:
                this.mPlaybackSpeed = 10;
                break;
        }
    }

    private void updatePlaybackState(boolean z9) {
        if (this.mControlsRow == null) {
            return;
        }
        if (z9) {
            this.mPlayerAdapter.setProgressUpdatingEnabled(true);
        } else {
            onUpdateProgress();
            this.mPlayerAdapter.setProgressUpdatingEnabled(false);
        }
        if (this.mFadeWhenPlaying && getHost() != null) {
            getHost().setControlsOverlayAutoHideEnabled(z9);
        }
        ArrayObjectAdapter arrayObjectAdapter = (ArrayObjectAdapter) getControlsRow().getPrimaryActionsAdapter();
        PlaybackControlsRow.PlayPauseAction playPauseAction = this.mPlayPauseAction;
        if (playPauseAction != null && playPauseAction.getIndex() != z9) {
            this.mPlayPauseAction.setIndex(z9 ? 1 : 0);
            PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.mPlayPauseAction);
        }
        PlaybackControlsRow.FastForwardAction fastForwardAction = this.mFastForwardAction;
        if (fastForwardAction != null) {
            int i10 = this.mPlaybackSpeed;
            int i11 = i10 >= 10 ? i10 - 9 : 0;
            if (fastForwardAction.getIndex() != i11) {
                this.mFastForwardAction.setIndex(i11);
                PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.mFastForwardAction);
            }
        }
        PlaybackControlsRow.RewindAction rewindAction = this.mRewindAction;
        if (rewindAction != null) {
            int i12 = this.mPlaybackSpeed <= -10 ? (-r2) - 9 : 0;
            if (rewindAction.getIndex() != i12) {
                this.mRewindAction.setIndex(i12);
                PlaybackBaseControlGlue.notifyItemChanged(arrayObjectAdapter, this.mRewindAction);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchAction(androidx.leanback.widget.Action r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            androidx.leanback.widget.PlaybackControlsRow$PlayPauseAction r0 = r4.mPlayPauseAction
            r1 = 1
            r2 = 0
            if (r5 != r0) goto L43
            r5 = 85
            if (r6 == 0) goto L18
            int r0 = r6.getKeyCode()
            if (r0 == r5) goto L18
            int r0 = r6.getKeyCode()
            r3 = 126(0x7e, float:1.77E-43)
            if (r0 != r3) goto L19
        L18:
            r2 = r1
        L19:
            if (r6 == 0) goto L29
            int r0 = r6.getKeyCode()
            if (r0 == r5) goto L29
            int r5 = r6.getKeyCode()
            r6 = 127(0x7f, float:1.78E-43)
            if (r5 != r6) goto L36
        L29:
            int r5 = r4.mPlaybackSpeed
            if (r2 == 0) goto L30
            if (r5 != r1) goto L36
            goto L32
        L30:
            if (r5 == 0) goto L36
        L32:
            r4.pause()
            goto L3f
        L36:
            if (r2 == 0) goto L3f
            int r5 = r4.mPlaybackSpeed
            if (r5 == r1) goto L3f
            r4.play()
        L3f:
            r4.onUpdatePlaybackStatusAfterUserAction()
            return r1
        L43:
            androidx.leanback.widget.PlaybackControlsRow$SkipNextAction r6 = r4.mSkipNextAction
            if (r5 != r6) goto L4b
            r4.next()
            return r1
        L4b:
            androidx.leanback.widget.PlaybackControlsRow$SkipPreviousAction r6 = r4.mSkipPreviousAction
            if (r5 != r6) goto L53
            r4.previous()
            return r1
        L53:
            androidx.leanback.widget.PlaybackControlsRow$FastForwardAction r6 = r4.mFastForwardAction
            if (r5 != r6) goto L7d
            T extends androidx.leanback.media.PlayerAdapter r5 = r4.mPlayerAdapter
            boolean r5 = r5.isPrepared()
            if (r5 == 0) goto L7c
            int r5 = r4.mPlaybackSpeed
            int r6 = r4.getMaxForwardSpeedId()
            if (r5 >= r6) goto L7c
            boolean r5 = r4.mIsCustomizedFastForwardSupported
            if (r5 == 0) goto L73
            r4.mIsPlaying = r1
            T extends androidx.leanback.media.PlayerAdapter r5 = r4.mPlayerAdapter
            r5.fastForward()
            goto L76
        L73:
            r4.fakePause()
        L76:
            r4.incrementFastForwardPlaybackSpeed()
            r4.onUpdatePlaybackStatusAfterUserAction()
        L7c:
            return r1
        L7d:
            androidx.leanback.widget.PlaybackControlsRow$RewindAction r6 = r4.mRewindAction
            if (r5 != r6) goto La8
            T extends androidx.leanback.media.PlayerAdapter r5 = r4.mPlayerAdapter
            boolean r5 = r5.isPrepared()
            if (r5 == 0) goto La7
            int r5 = r4.mPlaybackSpeed
            int r6 = r4.getMaxRewindSpeedId()
            int r6 = -r6
            if (r5 <= r6) goto La7
            boolean r5 = r4.mIsCustomizedFastForwardSupported
            if (r5 == 0) goto L9e
            r4.mIsPlaying = r1
            T extends androidx.leanback.media.PlayerAdapter r5 = r4.mPlayerAdapter
            r5.rewind()
            goto La1
        L9e:
            r4.fakePause()
        La1:
            r4.decrementRewindPlaybackSpeed()
            r4.onUpdatePlaybackStatusAfterUserAction()
        La7:
            return r1
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.media.PlaybackBannerControlGlue.dispatchAction(androidx.leanback.widget.Action, android.view.KeyEvent):boolean");
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public long getCurrentPosition() {
        int i10;
        int i11 = this.mPlaybackSpeed;
        if (i11 == 0 || i11 == 1) {
            return this.mPlayerAdapter.getCurrentPosition();
        }
        if (i11 >= 10) {
            if (this.mIsCustomizedFastForwardSupported) {
                return this.mPlayerAdapter.getCurrentPosition();
            }
            i10 = getFastForwardSpeeds()[i11 - 10];
        } else {
            if (i11 > -10) {
                return -1L;
            }
            if (this.mIsCustomizedRewindSupported) {
                return this.mPlayerAdapter.getCurrentPosition();
            }
            i10 = -getRewindSpeeds()[(-i11) - 10];
        }
        long jCurrentTimeMillis = ((System.currentTimeMillis() - this.mStartTime) * i10) + this.mStartPosition;
        if (jCurrentTimeMillis > getDuration()) {
            this.mPlaybackSpeed = 0;
            long duration = getDuration();
            this.mPlayerAdapter.seekTo(duration);
            this.mStartPosition = 0L;
            pause();
            return duration;
        }
        if (jCurrentTimeMillis >= 0) {
            return jCurrentTimeMillis;
        }
        this.mPlaybackSpeed = 0;
        this.mPlayerAdapter.seekTo(0L);
        this.mStartPosition = 0L;
        pause();
        return 0L;
    }

    public int[] getFastForwardSpeeds() {
        return this.mFastForwardSpeeds;
    }

    public int[] getRewindSpeeds() {
        return this.mRewindSpeeds;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        dispatchAction(action, null);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onCreatePrimaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        long supportedActions = getSupportedActions();
        long j10 = 16 & supportedActions;
        if (j10 != 0 && this.mSkipPreviousAction == null) {
            PlaybackControlsRow.SkipPreviousAction skipPreviousAction = new PlaybackControlsRow.SkipPreviousAction(getContext());
            this.mSkipPreviousAction = skipPreviousAction;
            arrayObjectAdapter.add(skipPreviousAction);
        } else if (j10 == 0 && (obj = this.mSkipPreviousAction) != null) {
            arrayObjectAdapter.remove(obj);
            this.mSkipPreviousAction = null;
        }
        long j11 = 32 & supportedActions;
        if (j11 != 0 && this.mRewindAction == null) {
            PlaybackControlsRow.RewindAction rewindAction = new PlaybackControlsRow.RewindAction(getContext(), this.mRewindSpeeds.length);
            this.mRewindAction = rewindAction;
            arrayObjectAdapter.add(rewindAction);
        } else if (j11 == 0 && (obj2 = this.mRewindAction) != null) {
            arrayObjectAdapter.remove(obj2);
            this.mRewindAction = null;
        }
        long j12 = 64 & supportedActions;
        if (j12 != 0 && this.mPlayPauseAction == null) {
            this.mPlayPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
            PlaybackControlsRow.PlayPauseAction playPauseAction = new PlaybackControlsRow.PlayPauseAction(getContext());
            this.mPlayPauseAction = playPauseAction;
            arrayObjectAdapter.add(playPauseAction);
        } else if (j12 == 0 && (obj3 = this.mPlayPauseAction) != null) {
            arrayObjectAdapter.remove(obj3);
            this.mPlayPauseAction = null;
        }
        long j13 = 128 & supportedActions;
        if (j13 != 0 && this.mFastForwardAction == null) {
            this.mFastForwardAction = new PlaybackControlsRow.FastForwardAction(getContext(), this.mFastForwardSpeeds.length);
            PlaybackControlsRow.FastForwardAction fastForwardAction = new PlaybackControlsRow.FastForwardAction(getContext(), this.mFastForwardSpeeds.length);
            this.mFastForwardAction = fastForwardAction;
            arrayObjectAdapter.add(fastForwardAction);
        } else if (j13 == 0 && (obj4 = this.mFastForwardAction) != null) {
            arrayObjectAdapter.remove(obj4);
            this.mFastForwardAction = null;
        }
        long j14 = supportedActions & 256;
        if (j14 != 0 && this.mSkipNextAction == null) {
            PlaybackControlsRow.SkipNextAction skipNextAction = new PlaybackControlsRow.SkipNextAction(getContext());
            this.mSkipNextAction = skipNextAction;
            arrayObjectAdapter.add(skipNextAction);
        } else {
            if (j14 != 0 || (obj5 = this.mSkipNextAction) == null) {
                return;
            }
            arrayObjectAdapter.remove(obj5);
            this.mSkipNextAction = null;
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public PlaybackRowPresenter onCreateRowPresenter() {
        return new PlaybackControlsRowPresenter(new AbstractDetailsDescriptionPresenter() { // from class: androidx.leanback.media.PlaybackBannerControlGlue.1
            @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
            public void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object obj) {
                PlaybackBannerControlGlue playbackBannerControlGlue = (PlaybackBannerControlGlue) obj;
                viewHolder.getTitle().setText(playbackBannerControlGlue.getTitle());
                viewHolder.getSubtitle().setText(playbackBannerControlGlue.getSubtitle());
            }
        }) { // from class: androidx.leanback.media.PlaybackBannerControlGlue.2
            @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
            public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
                super.onBindRowViewHolder(viewHolder, obj);
                viewHolder.setOnKeyListener(PlaybackBannerControlGlue.this);
            }

            @Override // androidx.leanback.widget.PlaybackControlsRowPresenter, androidx.leanback.widget.RowPresenter
            public void onUnbindRowViewHolder(RowPresenter.ViewHolder viewHolder) {
                super.onUnbindRowViewHolder(viewHolder);
                viewHolder.setOnKeyListener(null);
            }
        };
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (i10 != 4 && i10 != 111) {
            switch (i10) {
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    Action actionForKeyCode = this.mControlsRow.getActionForKeyCode(this.mControlsRow.getPrimaryActionsAdapter(), i10);
                    if (actionForKeyCode == null) {
                        PlaybackControlsRow playbackControlsRow = this.mControlsRow;
                        actionForKeyCode = playbackControlsRow.getActionForKeyCode(playbackControlsRow.getSecondaryActionsAdapter(), i10);
                    }
                    if (actionForKeyCode == null) {
                        return false;
                    }
                    if (keyEvent.getAction() == 0) {
                        dispatchAction(actionForKeyCode, keyEvent);
                    }
                    return true;
            }
        }
        int i11 = this.mPlaybackSpeed;
        if (i11 < 10 && i11 > -10) {
            return false;
        }
        play();
        onUpdatePlaybackStatusAfterUserAction();
        return i10 == 4 || i10 == 111;
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayCompleted() {
        super.onPlayCompleted();
        this.mIsPlaying = false;
        this.mPlaybackSpeed = 0;
        this.mStartPosition = getCurrentPosition();
        this.mStartTime = System.currentTimeMillis();
        onUpdatePlaybackState();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void onPlayStateChanged() {
        onUpdatePlaybackState();
        super.onPlayStateChanged();
    }

    public void onUpdatePlaybackState() {
        updatePlaybackState(this.mIsPlaying);
    }

    public void onUpdatePlaybackStatusAfterUserAction() {
        updatePlaybackState(this.mIsPlaying);
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void pause() {
        this.mIsPlaying = false;
        this.mPlaybackSpeed = 0;
        this.mStartPosition = getCurrentPosition();
        this.mStartTime = System.currentTimeMillis();
        super.pause();
        onUpdatePlaybackState();
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue, androidx.leanback.media.PlaybackGlue
    public void play() {
        if (this.mPlayerAdapter.isPrepared()) {
            if (this.mPlaybackSpeed != 0 || this.mPlayerAdapter.getCurrentPosition() < this.mPlayerAdapter.getDuration()) {
                this.mStartPosition = getCurrentPosition();
            } else {
                this.mStartPosition = 0L;
            }
            this.mStartTime = System.currentTimeMillis();
            this.mIsPlaying = true;
            this.mPlaybackSpeed = 1;
            this.mPlayerAdapter.seekTo(this.mStartPosition);
            super.play();
            onUpdatePlaybackState();
        }
    }

    @Override // androidx.leanback.media.PlaybackBaseControlGlue
    public void setControlsRow(PlaybackControlsRow playbackControlsRow) {
        super.setControlsRow(playbackControlsRow);
        onUpdatePlaybackState();
    }

    public PlaybackBannerControlGlue(Context context, int[] iArr, T t) {
        this(context, iArr, iArr, t);
    }
}

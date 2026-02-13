package androidx.leanback.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.PlaybackControlsRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.gson.internal.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
/* loaded from: classes.dex */
public class MediaPlayerGlue extends PlaybackControlGlue implements OnItemViewSelectedListener {
    public static final int FAST_FORWARD_REWIND_REPEAT_DELAY = 200;
    public static final int FAST_FORWARD_REWIND_STEP = 10000;
    public static final int NO_REPEAT = 0;
    public static final int REPEAT_ALL = 2;
    public static final int REPEAT_ONE = 1;
    private static final String TAG = "MediaPlayerGlue";
    private String mArtist;
    private Drawable mCover;
    Handler mHandler;
    boolean mInitialized;
    private long mLastKeyDownEvent;
    private String mMediaSourcePath;
    private Uri mMediaSourceUri;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    MediaPlayer mPlayer;
    private final PlaybackControlsRow.RepeatAction mRepeatAction;
    private Runnable mRunnable;
    private Action mSelectedAction;
    protected final PlaybackControlsRow.ThumbsDownAction mThumbsDownAction;
    protected final PlaybackControlsRow.ThumbsUpAction mThumbsUpAction;
    private String mTitle;

    public MediaPlayerGlue(Context context, int[] iArr, int[] iArr2) {
        super(context, iArr, iArr2);
        this.mPlayer = new MediaPlayer();
        this.mHandler = new Handler();
        this.mInitialized = false;
        this.mLastKeyDownEvent = 0L;
        this.mMediaSourceUri = null;
        this.mMediaSourcePath = null;
        this.mRepeatAction = new PlaybackControlsRow.RepeatAction(getContext());
        PlaybackControlsRow.ThumbsDownAction thumbsDownAction = new PlaybackControlsRow.ThumbsDownAction(getContext());
        this.mThumbsDownAction = thumbsDownAction;
        PlaybackControlsRow.ThumbsUpAction thumbsUpAction = new PlaybackControlsRow.ThumbsUpAction(getContext());
        this.mThumbsUpAction = thumbsUpAction;
        thumbsDownAction.setIndex(1);
        thumbsUpAction.setIndex(1);
    }

    private void prepareMediaForPlaying() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        reset();
        try {
            if (this.mMediaSourceUri != null) {
                this.mPlayer.setDataSource(getContext(), this.mMediaSourceUri);
            } else {
                String str = this.mMediaSourcePath;
                if (str == null) {
                    return;
                } else {
                    this.mPlayer.setDataSource(str);
                }
            }
            this.mPlayer.setAudioStreamType(3);
            this.mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: androidx.leanback.media.MediaPlayerGlue.4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerGlue mediaPlayerGlue = MediaPlayerGlue.this;
                    mediaPlayerGlue.mInitialized = true;
                    List<PlaybackGlue.PlayerCallback> playerCallbacks = mediaPlayerGlue.getPlayerCallbacks();
                    if (playerCallbacks != null) {
                        Iterator<PlaybackGlue.PlayerCallback> it = playerCallbacks.iterator();
                        while (it.hasNext()) {
                            it.next().onPreparedStateChanged(MediaPlayerGlue.this);
                        }
                    }
                }
            });
            MediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null) {
                this.mPlayer.setOnCompletionListener(onCompletionListener);
            }
            this.mPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() { // from class: androidx.leanback.media.MediaPlayerGlue.5
                @Override // android.media.MediaPlayer.OnBufferingUpdateListener
                public void onBufferingUpdate(MediaPlayer mediaPlayer, int i10) {
                    if (MediaPlayerGlue.this.getControlsRow() == null) {
                        return;
                    }
                    MediaPlayerGlue.this.getControlsRow().setBufferedProgress((int) ((i10 / 100.0f) * mediaPlayer.getDuration()));
                }
            });
            this.mPlayer.prepareAsync();
            onStateChanged();
        } catch (IOException e) {
            e.printStackTrace();
            a.j(e);
        }
    }

    public void changeToUnitialized() {
        if (this.mInitialized) {
            this.mInitialized = false;
            List<PlaybackGlue.PlayerCallback> playerCallbacks = getPlayerCallbacks();
            if (playerCallbacks != null) {
                Iterator<PlaybackGlue.PlayerCallback> it = playerCallbacks.iterator();
                while (it.hasNext()) {
                    it.next().onPreparedStateChanged(this);
                }
            }
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void enableProgressUpdating(boolean z9) {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        if (z9) {
            if (this.mRunnable == null) {
                this.mRunnable = new Runnable() { // from class: androidx.leanback.media.MediaPlayerGlue.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MediaPlayerGlue.this.updateProgress();
                        MediaPlayerGlue.this.mHandler.postDelayed(this, r0.getUpdatePeriod());
                    }
                };
            }
            this.mHandler.postDelayed(this.mRunnable, getUpdatePeriod());
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentPosition() {
        if (this.mInitialized) {
            return this.mPlayer.getCurrentPosition();
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getCurrentSpeedId() {
        return isMediaPlaying() ? 1 : 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public Drawable getMediaArt() {
        return this.mCover;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public int getMediaDuration() {
        if (this.mInitialized) {
            return this.mPlayer.getDuration();
        }
        return 0;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaSubtitle() {
        String str = this.mArtist;
        return str != null ? str : "N/a";
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public CharSequence getMediaTitle() {
        String str = this.mTitle;
        return str != null ? str : "N/a";
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public long getSupportedActions() {
        return 224L;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean hasValidMedia() {
        if (this.mTitle != null) {
            return (this.mMediaSourcePath == null && this.mMediaSourceUri == null) ? false : true;
        }
        return false;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public boolean isMediaPlaying() {
        return this.mInitialized && this.mPlayer.isPlaying();
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public boolean isPlaying() {
        return isMediaPlaying();
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public boolean isPrepared() {
        return this.mInitialized;
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        super.onActionClicked(action);
        if (action instanceof PlaybackControlsRow.RepeatAction) {
            ((PlaybackControlsRow.RepeatAction) action).nextIndex();
        } else {
            PlaybackControlsRow.ThumbsUpAction thumbsUpAction = this.mThumbsUpAction;
            if (action == thumbsUpAction) {
                int index = thumbsUpAction.getIndex();
                PlaybackControlsRow.ThumbsUpAction thumbsUpAction2 = this.mThumbsUpAction;
                if (index == 0) {
                    thumbsUpAction2.setIndex(1);
                } else {
                    thumbsUpAction2.setIndex(0);
                    this.mThumbsDownAction.setIndex(1);
                }
            } else {
                PlaybackControlsRow.ThumbsDownAction thumbsDownAction = this.mThumbsDownAction;
                if (action == thumbsDownAction) {
                    int index2 = thumbsDownAction.getIndex();
                    PlaybackControlsRow.ThumbsDownAction thumbsDownAction2 = this.mThumbsDownAction;
                    if (index2 == 0) {
                        thumbsDownAction2.setIndex(1);
                    } else {
                        thumbsDownAction2.setIndex(0);
                        this.mThumbsUpAction.setIndex(1);
                    }
                }
            }
        }
        onMetadataChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public void onAttachedToHost(PlaybackGlueHost playbackGlueHost) {
        super.onAttachedToHost(playbackGlueHost);
        if (playbackGlueHost instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) playbackGlueHost).setSurfaceHolderCallback(new VideoPlayerSurfaceHolderCallback());
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void onCreateSecondaryActions(ArrayObjectAdapter arrayObjectAdapter) {
        arrayObjectAdapter.add(this.mRepeatAction);
        arrayObjectAdapter.add(this.mThumbsDownAction);
        arrayObjectAdapter.add(this.mThumbsUpAction);
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, androidx.leanback.media.PlaybackGlue
    public void onDetachedFromHost() {
        if (getHost() instanceof SurfaceHolderGlueHost) {
            ((SurfaceHolderGlueHost) getHost()).setSurfaceHolderCallback(null);
        }
        reset();
        release();
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Action) {
            this.mSelectedAction = (Action) obj;
        } else {
            this.mSelectedAction = null;
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue, android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) throws IllegalStateException {
        Action action = this.mSelectedAction;
        if ((!(action instanceof PlaybackControlsRow.RewindAction) && !(action instanceof PlaybackControlsRow.FastForwardAction)) || !this.mInitialized || keyEvent.getKeyCode() != 23 || keyEvent.getAction() != 0 || System.currentTimeMillis() - this.mLastKeyDownEvent <= 200) {
            return super.onKey(view, i10, keyEvent);
        }
        this.mLastKeyDownEvent = System.currentTimeMillis();
        int currentPosition = getCurrentPosition() + 10000;
        if (this.mSelectedAction instanceof PlaybackControlsRow.RewindAction) {
            currentPosition = getCurrentPosition() - 10000;
        }
        if (currentPosition < 0) {
            currentPosition = 0;
        }
        if (currentPosition > getMediaDuration()) {
            currentPosition = getMediaDuration();
        }
        seekTo(currentPosition);
        return true;
    }

    @Override // androidx.leanback.media.PlaybackGlue
    public void pause() throws IllegalStateException {
        if (isMediaPlaying()) {
            this.mPlayer.pause();
            onStateChanged();
        }
    }

    @Override // androidx.leanback.media.PlaybackControlGlue
    public void play(int i10) throws IllegalStateException {
        if (!this.mInitialized || this.mPlayer.isPlaying()) {
            return;
        }
        this.mPlayer.start();
        onMetadataChanged();
        onStateChanged();
        updateProgress();
    }

    public void release() {
        changeToUnitialized();
        this.mPlayer.release();
    }

    public void reset() {
        changeToUnitialized();
        this.mPlayer.reset();
    }

    public void seekTo(int i10) throws IllegalStateException {
        if (this.mInitialized) {
            this.mPlayer.seekTo(i10);
        }
    }

    public void setArtist(String str) {
        this.mArtist = str;
    }

    public void setCover(Drawable drawable) {
        this.mCover = drawable;
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mPlayer.setDisplay(surfaceHolder);
    }

    public boolean setMediaSource(Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        Uri uri2 = this.mMediaSourceUri;
        if (uri2 != null) {
            if (uri2.equals(uri)) {
                return false;
            }
        } else if (uri == null) {
            return false;
        }
        this.mMediaSourceUri = uri;
        this.mMediaSourcePath = null;
        prepareMediaForPlaying();
        return true;
    }

    public void setMode(int i10) {
        if (i10 == 0) {
            this.mOnCompletionListener = null;
        } else if (i10 == 1) {
            this.mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: androidx.leanback.media.MediaPlayerGlue.2
                public boolean mFirstRepeat;

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (!this.mFirstRepeat) {
                        this.mFirstRepeat = true;
                        mediaPlayer.setOnCompletionListener(null);
                    }
                    MediaPlayerGlue.this.play();
                }
            };
        } else {
            if (i10 != 2) {
                return;
            }
            this.mOnCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: androidx.leanback.media.MediaPlayerGlue.3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    MediaPlayerGlue.this.play();
                }
            };
        }
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVideoUrl(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        setMediaSource(str);
        onMetadataChanged();
    }

    public boolean setMediaSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String str2 = this.mMediaSourcePath;
        if (str2 != null) {
            if (str2.equals(str)) {
                return false;
            }
        } else if (str == null) {
            return false;
        }
        this.mMediaSourceUri = null;
        this.mMediaSourcePath = str;
        prepareMediaForPlaying();
        return true;
    }

    public MediaPlayerGlue(Context context) {
        this(context, new int[]{1}, new int[]{1});
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class VideoPlayerSurfaceHolderCallback implements SurfaceHolder.Callback {
        public VideoPlayerSurfaceHolderCallback() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            MediaPlayerGlue.this.setDisplay(surfaceHolder);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            MediaPlayerGlue.this.setDisplay(null);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        }
    }
}

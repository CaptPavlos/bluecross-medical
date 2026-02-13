package com.mbridge.msdk.playercommon;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerFactory;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.SimpleExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.ExtractorMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultDataSourceFactory;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class VideoNativePlayer implements Player.EventListener {
    public static final int INTERVAL_TIME_PLAY_TIME_CD_THREAD = 1000;
    public static final int INTERVAL_TIME_PLAY_TIME_PROGRESS = 100;
    public static final String TAG = "VideoNativePlayer";
    private SimpleExoPlayer exoPlayer;
    private Timer mBufferTimeoutTimer;
    private long mCurrentPosition;
    private VideoPlayerStatusListener mInnerVFPLisener;
    private View mLoadingView;
    private String mNetUrl;
    private VideoPlayerStatusListener mOutterVFListener;
    private String mPlayUrl;
    private Surface mSurfaceHolder;
    private MediaSource mediaSource;
    private boolean mIsComplete = false;
    private boolean mIsPlaying = false;
    private boolean mHasPrepare = false;
    private boolean mIsStartPlay = true;
    private boolean mIsAllowLoopPlay = true;
    private boolean mHasChaoDi = false;
    private boolean mIsBuffering = false;
    private boolean mIsNeedBufferingTimeout = false;
    private boolean mIsFrontDesk = true;
    private int mBufferTime = 5;
    private boolean mIsOpenSound = true;
    private final Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };
    private Runnable playProgressRunnable = new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer == null || !VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                int i10 = (int) (VideoNativePlayer.this.mCurrentPosition / 1000);
                af.c(VideoNativePlayer.TAG, "currentPosition:" + i10 + " mCurrentPosition:" + VideoNativePlayer.this.mCurrentPosition);
                int duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0 : (int) (VideoNativePlayer.this.exoPlayer.getDuration() / 1000);
                if (VideoNativePlayer.this.mIsStartPlay) {
                    VideoNativePlayer.this.postOnPlayStartOnMainThread(duration);
                    af.c(VideoNativePlayer.TAG, "onPlayStarted()");
                    VideoNativePlayer.this.mIsStartPlay = false;
                }
                if (i10 >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer.this.postOnPlayProgressOnMainThread(i10, duration);
                }
                VideoNativePlayer.this.mIsComplete = false;
                if (!VideoNativePlayer.this.mIsBuffering) {
                    VideoNativePlayer.this.hideLoading();
                }
                VideoNativePlayer.this.mHandler.postDelayed(this, 1000L);
            } catch (Exception e) {
                af.b(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };
    private Runnable playProgressMSRunnable = new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (VideoNativePlayer.this.exoPlayer == null || !VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    return;
                }
                VideoNativePlayer videoNativePlayer = VideoNativePlayer.this;
                videoNativePlayer.mCurrentPosition = videoNativePlayer.exoPlayer.getCurrentPosition();
                long j10 = VideoNativePlayer.this.mCurrentPosition / 100;
                long duration = (VideoNativePlayer.this.exoPlayer == null || VideoNativePlayer.this.exoPlayer.getDuration() <= 0) ? 0L : VideoNativePlayer.this.exoPlayer.getDuration() / 100;
                if (j10 >= 0 && duration > 0 && VideoNativePlayer.this.exoPlayerIsPlaying()) {
                    VideoNativePlayer videoNativePlayer2 = VideoNativePlayer.this;
                    videoNativePlayer2.postOnPlayProgressMSOnMainThread(videoNativePlayer2.mCurrentPosition / 100, duration);
                }
                VideoNativePlayer.this.mHandler.postDelayed(this, 100L);
            } catch (Exception e) {
                af.b(VideoNativePlayer.TAG, e.getMessage());
            }
        }
    };

    private void cancelBufferTimeoutTimer() {
        try {
            Timer timer = this.mBufferTimeoutTimer;
            if (timer != null) {
                timer.cancel();
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void cancelPlayProgressTimer() {
        try {
            this.mHandler.removeCallbacks(this.playProgressRunnable);
            this.mHandler.removeCallbacks(this.playProgressMSRunnable);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.6
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoNativePlayer.this.mLoadingView != null) {
                        VideoNativePlayer.this.mLoadingView.setVisibility(8);
                    }
                }
            });
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void postOnBufferinEndOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingEnd();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingEnd();
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnBufferingStarOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onBufferingStart(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onBufferingStart(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void postOnPlayCompletedOnMainThread() {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayCompleted();
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayCompleted();
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void postOnPlayErrorOnMainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayError(str);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayError(str);
                        }
                    }
                });
            }
            i.a(42, this.mPlayUrl, str);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressMSOnMainThread(final long j10, final long j11) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgressMS((int) j10, (int) j11);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgressMS((int) j10, (int) j11);
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayProgressOnMainThread(final int i10, final int i11) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayProgress(i10, i11);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayProgress(i10, i11);
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void postOnPlaySetDataSourceError2MainThread(final String str) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.13
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlaySetDataSourceError(str);
                        }
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlaySetDataSourceError(str);
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnPlayStartOnMainThread(final int i10) {
        try {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.11
                    @Override // java.lang.Runnable
                    public void run() {
                        if (VideoNativePlayer.this.mOutterVFListener != null) {
                            VideoNativePlayer.this.mOutterVFListener.onPlayStarted(i10);
                        }
                        if (VideoNativePlayer.this.mInnerVFPLisener != null) {
                            VideoNativePlayer.this.mInnerVFPLisener.onPlayStarted(i10);
                        }
                    }
                });
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    private void startBufferingTimer(final String str) {
        if (!this.mIsNeedBufferingTimeout) {
            af.b(TAG, "不需要缓冲超时功能");
            return;
        }
        cancelBufferTimeoutTimer();
        Timer timer = new Timer();
        this.mBufferTimeoutTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    if (VideoNativePlayer.this.mHasPrepare && !VideoNativePlayer.this.mIsBuffering) {
                        return;
                    }
                    af.b(VideoNativePlayer.TAG, "缓冲超时");
                    VideoNativePlayer.this.postOnBufferingStarOnMainThread(str);
                } catch (Exception e) {
                    af.b(VideoNativePlayer.TAG, e.getMessage());
                }
            }
        }, this.mBufferTime * 1000);
    }

    private void startPlayProgressTimer() {
        try {
            cancelPlayProgressTimer();
            this.mHandler.post(this.playProgressRunnable);
            this.mHandler.post(this.playProgressMSRunnable);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void closeSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setVolume(0.0f);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public boolean exoPlayerIsPlaying() {
        return this.exoPlayer.getPlaybackState() == 3 && this.exoPlayer.getPlayWhenReady();
    }

    public int getCurPosition() {
        return (int) this.mCurrentPosition;
    }

    public boolean hasPrepare() {
        return this.mHasPrepare;
    }

    public void initBufferIngParam(int i10) {
        if (i10 > 0) {
            this.mBufferTime = i10;
        }
        this.mIsNeedBufferingTimeout = true;
        af.c(TAG, "mIsNeedBufferingTimeout:" + this.mIsNeedBufferingTimeout + "  mMaxBufferTime:" + this.mBufferTime);
    }

    public boolean initParameter(String str, boolean z9, boolean z10, View view, VideoPlayerStatusListener videoPlayerStatusListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                af.c(TAG, "netUrl为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            }
            if (view == null) {
                af.c(TAG, "loadingView为空 return");
                postOnPlayErrorOnMainThread(PlayerErrorConstant.MEDIAPLAYER_INIT_FAILED);
                return false;
            }
            this.mIsOpenSound = z9;
            this.mIsAllowLoopPlay = z10;
            this.mLoadingView = view;
            this.mNetUrl = str;
            this.mOutterVFListener = videoPlayerStatusListener;
            return true;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            postOnPlayErrorOnMainThread(th.toString());
            return false;
        }
    }

    public boolean isComplete() {
        return this.mIsComplete;
    }

    public boolean isPlayIng() {
        try {
            if (this.exoPlayer != null) {
                return exoPlayerIsPlaying();
            }
            return false;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            return false;
        }
    }

    public boolean isPlaying() {
        return exoPlayerIsPlaying();
    }

    public boolean loadingViewIsVisible() {
        try {
            View view = this.mLoadingView;
            if (view != null) {
                return view.getVisibility() == 0;
            }
            return false;
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return false;
        }
    }

    public void onCompletion() {
        try {
            this.mIsComplete = true;
            this.mIsPlaying = false;
            this.mCurrentPosition = 0L;
            hideLoading();
            postOnPlayCompletedOnMainThread();
            af.c(TAG, "======onCompletion");
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public boolean onError(int i10, String str) {
        try {
            af.b(TAG, "onError what:" + i10 + " extra:" + str);
            hideLoading();
            this.mHasPrepare = false;
            this.mIsPlaying = false;
            postOnPlayErrorOnMainThread(str);
            return true;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            return true;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        af.b(TAG, "onPlaybackParametersChanged : " + playbackParameters.speed);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onPlayerError(com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L16
            int r0 = r4.type
            if (r0 == 0) goto L13
            r1 = 1
            if (r0 == r1) goto L10
            r1 = 2
            if (r0 == r1) goto Ld
            goto L16
        Ld:
            java.lang.String r0 = "Play error, because have a UnexpectedException."
            goto L18
        L10:
            java.lang.String r0 = "Play error, because have a RendererException."
            goto L18
        L13:
            java.lang.String r0 = "Play error, because have a SourceException."
            goto L18
        L16:
            java.lang.String r0 = "Play error and ExoPlayer have not message."
        L18:
            java.lang.Throwable r1 = r4.getCause()
            if (r1 == 0) goto L34
            java.lang.Throwable r1 = r4.getCause()
            java.lang.String r1 = r1.getMessage()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L34
            java.lang.Throwable r0 = r4.getCause()
            java.lang.String r0 = r0.getMessage()
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onPlayerError : "
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "VideoNativePlayer"
            com.mbridge.msdk.foundation.tools.af.b(r2, r1)
            int r4 = r4.type
            r3.onError(r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.VideoNativePlayer.onPlayerError(com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException):void");
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPlayerStateChanged(boolean z9, int i10) {
        af.b(TAG, "onPlaybackStateChanged : " + i10);
        if (i10 == 1) {
            af.b(TAG, "onPlaybackStateChanged : IDLE");
            return;
        }
        if (i10 == 2) {
            af.b(TAG, "onPlaybackStateChanged : Buffering");
            this.mIsBuffering = true;
            showLoading();
            startBufferingTimer(PlayerErrorConstant.PLAYERING_TIMEOUT);
            return;
        }
        if (i10 == 3) {
            af.b(TAG, "onPlaybackStateChanged : READY");
            this.mIsBuffering = false;
            hideLoading();
            postOnBufferinEndOnMainThread();
            onPrepared();
            return;
        }
        if (i10 != 4) {
            return;
        }
        af.b(TAG, "onPlaybackStateChanged : Ended : PLAY ENDED");
        cancelPlayProgressTimer();
        onCompletion();
        if (this.mIsAllowLoopPlay) {
            return;
        }
        this.mHasPrepare = false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onPositionDiscontinuity(int i10) {
        af.b(TAG, "onPositionDiscontinuity : " + i10);
        if (i10 == 0) {
            onCompletion();
        }
    }

    public void onPrepared() {
        try {
            af.c(TAG, "onPrepared:" + this.mHasPrepare);
            if (!this.mIsFrontDesk) {
                af.b(TAG, "At background, Do not process");
                return;
            }
            this.mHasPrepare = true;
            postOnBufferinEndOnMainThread();
            startPlayProgressTimer();
            if (this.exoPlayer != null) {
                this.mIsPlaying = true;
            }
            af.c(TAG, "onprepare mCurrentPosition:" + this.mCurrentPosition + " mHasPrepare：" + this.mHasPrepare);
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
        }
    }

    public void openSound() {
        try {
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null) {
                return;
            }
            simpleExoPlayer.setVolume(1.0f);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void pause() {
        try {
            af.c(TAG, "player pause");
            if (!this.mHasPrepare) {
                af.c(TAG, "pause !mHasPrepare retrun");
                return;
            }
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return;
            }
            af.c(TAG, "pause " + this.mIsPlaying);
            hideLoading();
            this.exoPlayer.setPlayWhenReady(false);
            this.mIsPlaying = false;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void play(Context context, String str, int i10) {
        try {
            af.b(TAG, "进来播放 currentionPosition:" + this.mCurrentPosition);
            this.mCurrentPosition = (long) i10;
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            setDataSource(context);
            af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void releasePlayer() {
        try {
            af.c(TAG, "releasePlayer");
            cancelPlayProgressTimer();
            cancelBufferTimeoutTimer();
            if (this.exoPlayer != null) {
                stop();
                this.exoPlayer.removeListener(this);
                this.exoPlayer.release();
                this.exoPlayer = null;
                this.mIsPlaying = false;
            }
            if (this.mOutterVFListener != null) {
                this.mOutterVFListener = null;
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
        hideLoading();
    }

    public void replaySameSource(Context context, String str, Surface surface) {
        MediaSource mediaSource;
        try {
            showLoading();
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            SimpleExoPlayer simpleExoPlayer = this.exoPlayer;
            if (simpleExoPlayer == null || (mediaSource = this.mediaSource) == null) {
                play(context, str, surface);
            } else {
                simpleExoPlayer.prepare(mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
            }
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    public void setDataSource(Context context) {
        try {
            af.c(TAG, "setDataSource begin");
            if (this.exoPlayer != null) {
                try {
                    if (exoPlayerIsPlaying()) {
                        this.exoPlayer.stop();
                    }
                    this.exoPlayer.release();
                } catch (Throwable th) {
                    af.b(TAG, th.getMessage());
                }
            }
            if (!this.mIsOpenSound) {
                closeSound();
            }
            if (!TextUtils.isEmpty(this.mPlayUrl)) {
                this.exoPlayer = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(context), new DefaultTrackSelector(), new DefaultLoadControl());
                Uri uri = Uri.parse(this.mPlayUrl);
                if (this.mPlayUrl.startsWith("http") || this.mPlayUrl.startsWith("https")) {
                    this.mediaSource = new ExtractorMediaSource.Factory(new DefaultHttpDataSourceFactory("MBridge_ExoPlayer")).createMediaSource(uri);
                } else {
                    this.mediaSource = new ExtractorMediaSource.Factory(new DefaultDataSourceFactory(context, "MBridge_ExoPlayer")).createMediaSource(uri);
                }
                this.exoPlayer.setRepeatMode(this.mIsAllowLoopPlay ? 2 : 0);
                this.exoPlayer.prepare(this.mediaSource);
                this.exoPlayer.setPlayWhenReady(true);
                this.exoPlayer.addListener(this);
            }
            Surface surface = this.mSurfaceHolder;
            if (surface != null) {
                this.exoPlayer.setVideoSurface(surface);
            }
            startBufferingTimer(PlayerErrorConstant.PREPARE_TIMEOUT);
            af.c(TAG, "setDataSource done");
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            hideLoading();
            boolean zIsNetworkUrl = URLUtil.isNetworkUrl(this.mPlayUrl);
            String str = this.mNetUrl;
            if (zIsNetworkUrl) {
                af.c(TAG, "setDataSource error : Is Online source : " + str);
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
                postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.SET_DATA_SOURCE_ERROR);
            } else if (TextUtils.isEmpty(str) || this.mHasChaoDi) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
            } else {
                this.mHasChaoDi = true;
                af.c(TAG, "setDataSource error : Will play online source : " + this.mNetUrl);
                this.mPlayUrl = this.mNetUrl;
                showLoading();
                setDataSource(context);
            }
            postOnPlaySetDataSourceError2MainThread(PlayerErrorConstant.SET_DATA_SOURCE_ERROR);
        }
    }

    public void setIsComplete(boolean z9) {
        this.mIsComplete = z9;
    }

    public void setIsFrontDesk(boolean z9) {
        try {
            this.mIsFrontDesk = z9;
            af.b(TAG, "isFrontDesk: ".concat(z9 ? "frontStage" : "backStage"));
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void setSelfVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mInnerVFPLisener = videoPlayerStatusListener;
    }

    public void setVideoFeedsPlayerListener(VideoPlayerStatusListener videoPlayerStatusListener) {
        this.mOutterVFListener = videoPlayerStatusListener;
    }

    public void showLoading() {
        try {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.mbridge.msdk.playercommon.VideoNativePlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoNativePlayer.this.mLoadingView != null) {
                        VideoNativePlayer.this.mLoadingView.setVisibility(0);
                    }
                }
            });
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void start(Surface surface) {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "start !mHasPrepare retrun");
                return;
            }
            boolean z9 = true;
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                StringBuilder sb = new StringBuilder("exoplayer is null : ");
                if (this.exoPlayer != null) {
                    z9 = false;
                }
                sb.append(z9);
                af.c(TAG, sb.toString());
                return;
            }
            showLoading();
            if (surface != null) {
                this.mSurfaceHolder = surface;
                this.exoPlayer.setVideoSurface(surface);
            }
            play();
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void stop() {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "stop !mHasPrepare retrun");
                return;
            }
            if (this.exoPlayer == null || !exoPlayerIsPlaying()) {
                return;
            }
            hideLoading();
            this.exoPlayer.stop();
            cancelPlayProgressTimer();
            this.mIsPlaying = false;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onSeekProcessed() {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onLoadingChanged(boolean z9) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onRepeatModeChanged(int i10) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onShuffleModeEnabledChanged(boolean z9) {
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void start() {
        start((Surface) null);
    }

    public void start(int i10) {
        try {
            if (!this.mHasPrepare) {
                af.c(TAG, "start mHasprepare is false return");
                return;
            }
            if (this.exoPlayer == null || exoPlayerIsPlaying()) {
                return;
            }
            if (i10 > 0) {
                this.exoPlayer.seekTo(i10);
            }
            play();
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }

    public void play(Context context, String str, Surface surface) {
        try {
            if (TextUtils.isEmpty(str)) {
                postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_URL_ILLEGAL);
                return;
            }
            showLoading();
            this.mPlayUrl = str;
            this.mHasPrepare = false;
            this.mIsFrontDesk = true;
            this.mSurfaceHolder = surface;
            setDataSource(context);
            af.c(TAG, "mPlayUrl:" + this.mPlayUrl);
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
            releasePlayer();
            hideLoading();
            postOnPlayErrorOnMainThread(PlayerErrorConstant.PLAY_CANNOT_PALY);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player.EventListener
    public void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i10) {
    }

    public void play() {
        try {
            this.exoPlayer.setPlayWhenReady(true);
            startPlayProgressTimer();
            this.mIsPlaying = true;
        } catch (Exception e) {
            af.b(TAG, e.getMessage());
        }
    }
}

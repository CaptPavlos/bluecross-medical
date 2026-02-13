package com.mbridge.msdk.playercommon.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Player;
import com.mbridge.msdk.playercommon.exoplayer2.PlayerMessage;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectionArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelectorResult;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Clock;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class ExoPlayerImpl implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArraySet<Player.EventListener> listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private int pendingOperationAcks;
    private final ArrayDeque<PlaybackInfoUpdate> pendingPlaybackInfoUpdates;
    private final Timeline.Period period;
    private boolean playWhenReady;

    @Nullable
    private ExoPlaybackException playbackError;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class PlaybackInfoUpdate {
        private final boolean isLoadingChanged;
        private final Set<Player.EventListener> listeners;
        private final boolean playWhenReady;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateOrPlayWhenReadyChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineOrManifestChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, Set<Player.EventListener> set, TrackSelector trackSelector, boolean z9, int i10, int i11, boolean z10, boolean z11, boolean z12) {
            this.playbackInfo = playbackInfo;
            this.listeners = set;
            this.trackSelector = trackSelector;
            this.positionDiscontinuity = z9;
            this.positionDiscontinuityReason = i10;
            this.timelineChangeReason = i11;
            this.seekProcessed = z10;
            this.playWhenReady = z11;
            this.playbackStateOrPlayWhenReadyChanged = z12 || playbackInfo2.playbackState != playbackInfo.playbackState;
            this.timelineOrManifestChanged = (playbackInfo2.timeline == playbackInfo.timeline && playbackInfo2.manifest == playbackInfo.manifest) ? false : true;
            this.isLoadingChanged = playbackInfo2.isLoading != playbackInfo.isLoading;
            this.trackSelectorResultChanged = playbackInfo2.trackSelectorResult != playbackInfo.trackSelectorResult;
        }

        public final void notifyListeners() {
            if (this.timelineOrManifestChanged || this.timelineChangeReason == 0) {
                for (Player.EventListener eventListener : this.listeners) {
                    PlaybackInfo playbackInfo = this.playbackInfo;
                    eventListener.onTimelineChanged(playbackInfo.timeline, playbackInfo.manifest, this.timelineChangeReason);
                }
            }
            if (this.positionDiscontinuity) {
                Iterator<Player.EventListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    it.next().onPositionDiscontinuity(this.positionDiscontinuityReason);
                }
            }
            if (this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                for (Player.EventListener eventListener2 : this.listeners) {
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    eventListener2.onTracksChanged(playbackInfo2.trackGroups, playbackInfo2.trackSelectorResult.selections);
                }
            }
            if (this.isLoadingChanged) {
                Iterator<Player.EventListener> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    it2.next().onLoadingChanged(this.playbackInfo.isLoading);
                }
            }
            if (this.playbackStateOrPlayWhenReadyChanged) {
                Iterator<Player.EventListener> it3 = this.listeners.iterator();
                while (it3.hasNext()) {
                    it3.next().onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
                }
            }
            if (this.seekProcessed) {
                Iterator<Player.EventListener> it4 = this.listeners.iterator();
                while (it4.hasNext()) {
                    it4.next().onSeekProcessed();
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] rendererArr, TrackSelector trackSelector, LoadControl loadControl, Clock clock) {
        Log.i(TAG, "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + Util.DEVICE_DEBUG_INFO + "]");
        Assertions.checkState(rendererArr.length > 0);
        this.renderers = (Renderer[]) Assertions.checkNotNull(rendererArr);
        this.trackSelector = (TrackSelector) Assertions.checkNotNull(trackSelector);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArraySet<>();
        TrackSelectorResult trackSelectorResult = new TrackSelectorResult(new RendererConfiguration[rendererArr.length], new TrackSelection[rendererArr.length], null);
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()) { // from class: com.mbridge.msdk.playercommon.exoplayer2.ExoPlayerImpl.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ExoPlayerImpl.this.handleEvent(message);
            }
        };
        this.eventHandler = handler;
        this.playbackInfo = new PlaybackInfo(Timeline.EMPTY, 0L, TrackGroupArray.EMPTY, trackSelectorResult);
        this.pendingPlaybackInfoUpdates = new ArrayDeque<>();
        ExoPlayerImplInternal exoPlayerImplInternal = new ExoPlayerImplInternal(rendererArr, trackSelector, trackSelectorResult, loadControl, this.playWhenReady, this.repeatMode, this.shuffleModeEnabled, handler, this, clock);
        this.internalPlayer = exoPlayerImplInternal;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal.getPlaybackLooper());
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z9, boolean z10, int i10) {
        if (z9) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0L;
        } else {
            this.maskingWindowIndex = getCurrentWindowIndex();
            this.maskingPeriodIndex = getCurrentPeriodIndex();
            this.maskingWindowPositionMs = getCurrentPosition();
        }
        Timeline timeline = z10 ? Timeline.EMPTY : this.playbackInfo.timeline;
        Object obj = z10 ? null : this.playbackInfo.manifest;
        PlaybackInfo playbackInfo = this.playbackInfo;
        return new PlaybackInfo(timeline, obj, playbackInfo.periodId, playbackInfo.startPositionUs, playbackInfo.contentPositionUs, i10, false, z10 ? TrackGroupArray.EMPTY : playbackInfo.trackGroups, z10 ? this.emptyTrackSelectorResult : playbackInfo.trackSelectorResult);
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo, int i10, boolean z9, int i11) {
        int i12 = this.pendingOperationAcks - i10;
        this.pendingOperationAcks = i12;
        if (i12 == 0) {
            PlaybackInfo playbackInfoFromNewPosition = playbackInfo.startPositionUs == C.TIME_UNSET ? playbackInfo.fromNewPosition(playbackInfo.periodId, 0L, playbackInfo.contentPositionUs) : playbackInfo;
            if ((!this.playbackInfo.timeline.isEmpty() || this.hasPendingPrepare) && playbackInfoFromNewPosition.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            int i13 = this.hasPendingPrepare ? 0 : 2;
            boolean z10 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            updatePlaybackInfo(playbackInfoFromNewPosition, z9, i11, i13, z10, false);
        }
    }

    private long playbackInfoPositionUsToWindowPositionMs(long j10) {
        long jUsToMs = C.usToMs(j10);
        if (this.playbackInfo.periodId.isAd()) {
            return jUsToMs;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
        return this.period.getPositionInWindowMs() + jUsToMs;
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean z9, int i10, int i11, boolean z10, boolean z11) {
        boolean zIsEmpty = this.pendingPlaybackInfoUpdates.isEmpty();
        this.pendingPlaybackInfoUpdates.addLast(new PlaybackInfoUpdate(playbackInfo, this.playbackInfo, this.listeners, this.trackSelector, z9, i10, i11, z10, this.playWhenReady, z11));
        this.playbackInfo = playbackInfo;
        if (zIsEmpty) {
            while (!this.pendingPlaybackInfoUpdates.isEmpty()) {
                this.pendingPlaybackInfoUpdates.peekFirst().notifyListeners();
                this.pendingPlaybackInfoUpdates.removeFirst();
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void addListener(Player.EventListener eventListener) {
        this.listeners.add(eventListener);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final void blockingSendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        ArrayList arrayList = new ArrayList();
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            arrayList.add(createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send());
        }
        int size = arrayList.size();
        boolean z9 = false;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            PlayerMessage playerMessage = (PlayerMessage) obj;
            boolean z10 = true;
            while (z10) {
                try {
                    playerMessage.blockUntilDelivered();
                    z10 = false;
                } catch (InterruptedException unused) {
                    z9 = true;
                } catch (TimeoutException e) {
                    af.b(TAG, e.getMessage());
                }
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final PlayerMessage createMessage(PlayerMessage.Target target) {
        return new PlayerMessage(this.internalPlayer, target, this.playbackInfo.timeline, getCurrentWindowIndex(), this.internalPlayerHandler);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final long getBufferedPosition() {
        return shouldMaskPosition() ? this.maskingWindowPositionMs : playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.bufferedPositionUs);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final long getContentPosition() {
        if (!isPlayingAd()) {
            return getCurrentPosition();
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period);
        return C.usToMs(this.playbackInfo.contentPositionUs) + this.period.getPositionInWindowMs();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getCurrentAdGroupIndex() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adGroupIndex;
        }
        return -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getCurrentAdIndexInAdGroup() {
        if (isPlayingAd()) {
            return this.playbackInfo.periodId.adIndexInAdGroup;
        }
        return -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final Object getCurrentManifest() {
        return this.playbackInfo.manifest;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getCurrentPeriodIndex() {
        return shouldMaskPosition() ? this.maskingPeriodIndex : this.playbackInfo.periodId.periodIndex;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final long getCurrentPosition() {
        return shouldMaskPosition() ? this.maskingWindowPositionMs : playbackInfoPositionUsToWindowPositionMs(this.playbackInfo.positionUs);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    @Nullable
    public final Object getCurrentTag() {
        int currentWindowIndex = getCurrentWindowIndex();
        if (currentWindowIndex > this.playbackInfo.timeline.getWindowCount()) {
            return null;
        }
        return this.playbackInfo.timeline.getWindow(currentWindowIndex, this.window, true).tag;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getCurrentWindowIndex() {
        if (shouldMaskPosition()) {
            return this.maskingWindowIndex;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        return playbackInfo.timeline.getPeriod(playbackInfo.periodId.periodIndex, this.period).windowIndex;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final long getDuration() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return C.TIME_UNSET;
        }
        if (!isPlayingAd()) {
            return timeline.getWindow(getCurrentWindowIndex(), this.window).getDurationMs();
        }
        MediaSource.MediaPeriodId mediaPeriodId = this.playbackInfo.periodId;
        timeline.getPeriod(mediaPeriodId.periodIndex, this.period);
        return C.usToMs(this.period.getAdDurationUs(mediaPeriodId.adGroupIndex, mediaPeriodId.adIndexInAdGroup));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getNextWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getNextWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    @Nullable
    public final ExoPlaybackException getPlaybackError() {
        return this.playbackError;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getPreviousWindowIndex() {
        Timeline timeline = this.playbackInfo.timeline;
        if (timeline.isEmpty()) {
            return -1;
        }
        return timeline.getPreviousWindowIndex(getCurrentWindowIndex(), this.repeatMode, this.shuffleModeEnabled);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getRendererCount() {
        return this.renderers.length;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getRendererType(int i10) {
        return this.renderers[i10].getTrackType();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final int getRepeatMode() {
        return this.repeatMode;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final Player.TextComponent getTextComponent() {
        return null;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final Player.VideoComponent getVideoComponent() {
        return null;
    }

    public final void handleEvent(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            PlaybackInfo playbackInfo = (PlaybackInfo) message.obj;
            int i11 = message.arg1;
            int i12 = message.arg2;
            handlePlaybackInfo(playbackInfo, i11, i12 != -1, i12);
            return;
        }
        if (i10 == 1) {
            PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
            if (this.playbackParameters.equals(playbackParameters)) {
                return;
            }
            this.playbackParameters = playbackParameters;
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onPlaybackParametersChanged(playbackParameters);
            }
            return;
        }
        if (i10 != 2) {
            u.e();
            return;
        }
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
        this.playbackError = exoPlaybackException;
        Iterator<Player.EventListener> it2 = this.listeners.iterator();
        while (it2.hasNext()) {
            it2.next().onPlayerError(exoPlaybackException);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean isCurrentWindowDynamic() {
        Timeline timeline = this.playbackInfo.timeline;
        return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isDynamic;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean isCurrentWindowSeekable() {
        Timeline timeline = this.playbackInfo.timeline;
        return !timeline.isEmpty() && timeline.getWindow(getCurrentWindowIndex(), this.window).isSeekable;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final boolean isPlayingAd() {
        return !shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final void prepare(MediaSource mediaSource, boolean z9, boolean z10) {
        this.playbackError = null;
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z9, z10, 2);
        this.hasPendingPrepare = true;
        this.pendingOperationAcks++;
        this.internalPlayer.prepare(mediaSource, z9, z10);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void release() {
        Log.i(TAG, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.8.4] [" + Util.DEVICE_DEBUG_INFO + "] [" + ExoPlayerLibraryInfo.registeredModules() + "]");
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void removeListener(Player.EventListener eventListener) {
        this.listeners.remove(eventListener);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void seekTo(int i10, long j10) {
        int i11;
        Timeline timeline = this.playbackInfo.timeline;
        if (i10 < 0 || (!timeline.isEmpty() && i10 >= timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(timeline, i10, j10);
        }
        this.hasPendingSeek = true;
        this.pendingOperationAcks++;
        if (isPlayingAd()) {
            Log.w(TAG, "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        this.maskingWindowIndex = i10;
        if (timeline.isEmpty()) {
            this.maskingWindowPositionMs = j10 == C.TIME_UNSET ? 0L : j10;
            this.maskingPeriodIndex = 0;
            i11 = i10;
        } else {
            long defaultPositionUs = j10 == C.TIME_UNSET ? timeline.getWindow(i10, this.window).getDefaultPositionUs() : C.msToUs(j10);
            i11 = i10;
            Pair<Integer, Long> periodPosition = timeline.getPeriodPosition(this.window, this.period, i11, defaultPositionUs);
            this.maskingWindowPositionMs = C.usToMs(defaultPositionUs);
            this.maskingPeriodIndex = ((Integer) periodPosition.first).intValue();
        }
        this.internalPlayer.seekTo(timeline, i11, C.msToUs(j10));
        Iterator<Player.EventListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onPositionDiscontinuity(1);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void seekToDefaultPosition(int i10) {
        seekTo(i10, C.TIME_UNSET);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final void sendMessages(ExoPlayer.ExoPlayerMessage... exoPlayerMessageArr) {
        for (ExoPlayer.ExoPlayerMessage exoPlayerMessage : exoPlayerMessageArr) {
            createMessage(exoPlayerMessage.target).setType(exoPlayerMessage.messageType).setPayload(exoPlayerMessage.message).send();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void setPlayWhenReady(boolean z9) {
        if (this.playWhenReady != z9) {
            this.playWhenReady = z9;
            this.internalPlayer.setPlayWhenReady(z9);
            updatePlaybackInfo(this.playbackInfo, false, 4, 1, false, true);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void setPlaybackParameters(@Nullable PlaybackParameters playbackParameters) {
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        this.internalPlayer.setPlaybackParameters(playbackParameters);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void setRepeatMode(int i10) {
        if (this.repeatMode != i10) {
            this.repeatMode = i10;
            this.internalPlayer.setRepeatMode(i10);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onRepeatModeChanged(i10);
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final void setSeekParameters(@Nullable SeekParameters seekParameters) {
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        this.internalPlayer.setSeekParameters(seekParameters);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void setShuffleModeEnabled(boolean z9) {
        if (this.shuffleModeEnabled != z9) {
            this.shuffleModeEnabled = z9;
            this.internalPlayer.setShuffleModeEnabled(z9);
            Iterator<Player.EventListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().onShuffleModeEnabledChanged(z9);
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void stop(boolean z9) {
        if (z9) {
            this.playbackError = null;
        }
        PlaybackInfo resetPlaybackInfo = getResetPlaybackInfo(z9, z9, 1);
        this.pendingOperationAcks++;
        this.internalPlayer.stop(z9);
        updatePlaybackInfo(resetPlaybackInfo, false, 4, 1, false, false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentWindowIndex());
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void stop() {
        stop(false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer
    public final void prepare(MediaSource mediaSource) {
        prepare(mediaSource, true, true);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Player
    public final void seekTo(long j10) {
        seekTo(getCurrentWindowIndex(), j10);
    }
}

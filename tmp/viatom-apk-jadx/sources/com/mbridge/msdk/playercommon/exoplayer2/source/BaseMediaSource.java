package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlayer;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSourceEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class BaseMediaSource implements MediaSource {
    private Object manifest;
    private ExoPlayer player;
    private Timeline timeline;
    private final ArrayList<MediaSource.SourceInfoRefreshListener> sourceInfoListeners = new ArrayList<>(1);
    private final MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(MediaSource.MediaPeriodId mediaPeriodId, long j10) {
        Assertions.checkArgument(mediaPeriodId != null);
        return this.eventDispatcher.withParameters(0, mediaPeriodId, j10);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void prepareSource(ExoPlayer exoPlayer, boolean z9, MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        ExoPlayer exoPlayer2 = this.player;
        Assertions.checkArgument(exoPlayer2 == null || exoPlayer2 == exoPlayer);
        this.sourceInfoListeners.add(sourceInfoRefreshListener);
        if (this.player == null) {
            this.player = exoPlayer;
            prepareSourceInternal(exoPlayer, z9);
        } else {
            Timeline timeline = this.timeline;
            if (timeline != null) {
                sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline, this.manifest);
            }
        }
    }

    public abstract void prepareSourceInternal(ExoPlayer exoPlayer, boolean z9);

    public final void refreshSourceInfo(Timeline timeline, @Nullable Object obj) {
        this.timeline = timeline;
        this.manifest = obj;
        ArrayList<MediaSource.SourceInfoRefreshListener> arrayList = this.sourceInfoListeners;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener = arrayList.get(i10);
            i10++;
            sourceInfoRefreshListener.onSourceInfoRefreshed(this, timeline, obj);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void releaseSource(MediaSource.SourceInfoRefreshListener sourceInfoRefreshListener) {
        this.sourceInfoListeners.remove(sourceInfoRefreshListener);
        if (this.sourceInfoListeners.isEmpty()) {
            this.player = null;
            this.timeline = null;
            this.manifest = null;
            releaseSourceInternal();
        }
    }

    public abstract void releaseSourceInternal();

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource
    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaPeriodId, 0L);
    }

    public final MediaSourceEventListener.EventDispatcher createEventDispatcher(int i10, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j10) {
        return this.eventDispatcher.withParameters(i10, mediaPeriodId, j10);
    }
}

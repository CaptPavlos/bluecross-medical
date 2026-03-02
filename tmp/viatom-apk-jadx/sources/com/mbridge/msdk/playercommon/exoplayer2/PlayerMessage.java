package com.mbridge.msdk.playercommon.exoplayer2;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PlayerMessage {
    private Handler handler;
    private boolean isCanceled;
    private boolean isDelivered;
    private boolean isProcessed;
    private boolean isSent;
    private Object payload;
    private final Sender sender;
    private final Target target;
    private final Timeline timeline;
    private int type;
    private int windowIndex;
    private long positionMs = C.TIME_UNSET;
    private boolean deleteAfterDelivery = true;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface Target {
        void handleMessage(int i10, Object obj) throws ExoPlaybackException;
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i10, Handler handler) {
        this.sender = sender;
        this.target = target;
        this.timeline = timeline;
        this.handler = handler;
        this.windowIndex = i10;
    }

    public final synchronized boolean blockUntilDelivered() throws InterruptedException, TimeoutException {
        boolean z9;
        try {
            Assertions.checkState(this.isSent);
            Assertions.checkState(this.handler.getLooper().getThread() != Thread.currentThread());
            long jElapsedRealtime = 500;
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() + 500;
            while (true) {
                z9 = this.isProcessed;
                if (z9 || jElapsedRealtime <= 0) {
                    break;
                }
                wait(jElapsedRealtime);
                jElapsedRealtime = jElapsedRealtime2 - SystemClock.elapsedRealtime();
            }
            if (!z9) {
                throw new TimeoutException("Message delivery time out");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.isDelivered;
    }

    public final synchronized PlayerMessage cancel() {
        Assertions.checkState(this.isSent);
        this.isCanceled = true;
        markAsProcessed(false);
        return this;
    }

    public final boolean getDeleteAfterDelivery() {
        return this.deleteAfterDelivery;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final Object getPayload() {
        return this.payload;
    }

    public final long getPositionMs() {
        return this.positionMs;
    }

    public final Target getTarget() {
        return this.target;
    }

    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final int getType() {
        return this.type;
    }

    public final int getWindowIndex() {
        return this.windowIndex;
    }

    public final synchronized boolean isCanceled() {
        return this.isCanceled;
    }

    public final synchronized void markAsProcessed(boolean z9) {
        this.isDelivered = z9 | this.isDelivered;
        this.isProcessed = true;
        notifyAll();
    }

    public final PlayerMessage send() {
        Assertions.checkState(!this.isSent);
        if (this.positionMs == C.TIME_UNSET) {
            Assertions.checkArgument(this.deleteAfterDelivery);
        }
        this.isSent = true;
        this.sender.sendMessage(this);
        return this;
    }

    public final PlayerMessage setDeleteAfterDelivery(boolean z9) {
        Assertions.checkState(!this.isSent);
        this.deleteAfterDelivery = z9;
        return this;
    }

    public final PlayerMessage setHandler(Handler handler) {
        Assertions.checkState(!this.isSent);
        this.handler = handler;
        return this;
    }

    public final PlayerMessage setPayload(@Nullable Object obj) {
        Assertions.checkState(!this.isSent);
        this.payload = obj;
        return this;
    }

    public final PlayerMessage setPosition(int i10, long j10) {
        Assertions.checkState(!this.isSent);
        Assertions.checkArgument(j10 != C.TIME_UNSET);
        if (i10 < 0 || (!this.timeline.isEmpty() && i10 >= this.timeline.getWindowCount())) {
            throw new IllegalSeekPositionException(this.timeline, i10, j10);
        }
        this.windowIndex = i10;
        this.positionMs = j10;
        return this;
    }

    public final PlayerMessage setType(int i10) {
        Assertions.checkState(!this.isSent);
        this.type = i10;
        return this;
    }

    public final PlayerMessage setPosition(long j10) {
        Assertions.checkState(!this.isSent);
        this.positionMs = j10;
        return this;
    }
}

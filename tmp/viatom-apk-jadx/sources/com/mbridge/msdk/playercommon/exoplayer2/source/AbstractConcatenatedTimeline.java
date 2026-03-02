package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.Timeline;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int childCount;
    private final boolean isAtomic;
    private final ShuffleOrder shuffleOrder;

    public AbstractConcatenatedTimeline(boolean z9, ShuffleOrder shuffleOrder) {
        this.isAtomic = z9;
        this.shuffleOrder = shuffleOrder;
        this.childCount = shuffleOrder.getLength();
    }

    private int getNextChildIndex(int i10, boolean z9) {
        if (z9) {
            return this.shuffleOrder.getNextIndex(i10);
        }
        if (i10 < this.childCount - 1) {
            return i10 + 1;
        }
        return -1;
    }

    private int getPreviousChildIndex(int i10, boolean z9) {
        if (z9) {
            return this.shuffleOrder.getPreviousIndex(i10);
        }
        if (i10 > 0) {
            return i10 - 1;
        }
        return -1;
    }

    public abstract int getChildIndexByChildUid(Object obj);

    public abstract int getChildIndexByPeriodIndex(int i10);

    public abstract int getChildIndexByWindowIndex(int i10);

    public abstract Object getChildUidByChildIndex(int i10);

    public abstract int getFirstPeriodIndexByChildIndex(int i10);

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public int getFirstWindowIndex(boolean z9) {
        if (this.childCount == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z9 = false;
        }
        int firstIndex = z9 ? this.shuffleOrder.getFirstIndex() : 0;
        while (getTimelineByChildIndex(firstIndex).isEmpty()) {
            firstIndex = getNextChildIndex(firstIndex, z9);
            if (firstIndex == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(firstIndex).getFirstWindowIndex(z9) + getFirstWindowIndexByChildIndex(firstIndex);
    }

    public abstract int getFirstWindowIndexByChildIndex(int i10);

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final int getIndexOfPeriod(Object obj) {
        int indexOfPeriod;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int childIndexByChildUid = getChildIndexByChildUid(obj2);
        if (childIndexByChildUid == -1 || (indexOfPeriod = getTimelineByChildIndex(childIndexByChildUid).getIndexOfPeriod(obj3)) == -1) {
            return -1;
        }
        return getFirstPeriodIndexByChildIndex(childIndexByChildUid) + indexOfPeriod;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public int getLastWindowIndex(boolean z9) {
        int i10 = this.childCount;
        if (i10 == 0) {
            return -1;
        }
        if (this.isAtomic) {
            z9 = false;
        }
        int lastIndex = z9 ? this.shuffleOrder.getLastIndex() : i10 - 1;
        while (getTimelineByChildIndex(lastIndex).isEmpty()) {
            lastIndex = getPreviousChildIndex(lastIndex, z9);
            if (lastIndex == -1) {
                return -1;
            }
        }
        return getTimelineByChildIndex(lastIndex).getLastWindowIndex(z9) + getFirstWindowIndexByChildIndex(lastIndex);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public int getNextWindowIndex(int i10, int i11, boolean z9) {
        if (this.isAtomic) {
            if (i11 == 1) {
                i11 = 2;
            }
            z9 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int nextWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getNextWindowIndex(i10 - firstWindowIndexByChildIndex, i11 != 2 ? i11 : 0, z9);
        if (nextWindowIndex != -1) {
            return firstWindowIndexByChildIndex + nextWindowIndex;
        }
        int nextChildIndex = getNextChildIndex(childIndexByWindowIndex, z9);
        while (nextChildIndex != -1 && getTimelineByChildIndex(nextChildIndex).isEmpty()) {
            nextChildIndex = getNextChildIndex(nextChildIndex, z9);
        }
        if (nextChildIndex != -1) {
            return getTimelineByChildIndex(nextChildIndex).getFirstWindowIndex(z9) + getFirstWindowIndexByChildIndex(nextChildIndex);
        }
        if (i11 == 2) {
            return getFirstWindowIndex(z9);
        }
        return -1;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final Timeline.Period getPeriod(int i10, Timeline.Period period, boolean z9) {
        int childIndexByPeriodIndex = getChildIndexByPeriodIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByPeriodIndex);
        getTimelineByChildIndex(childIndexByPeriodIndex).getPeriod(i10 - getFirstPeriodIndexByChildIndex(childIndexByPeriodIndex), period, z9);
        period.windowIndex += firstWindowIndexByChildIndex;
        if (z9) {
            period.uid = Pair.create(getChildUidByChildIndex(childIndexByPeriodIndex), period.uid);
        }
        return period;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public int getPreviousWindowIndex(int i10, int i11, boolean z9) {
        if (this.isAtomic) {
            if (i11 == 1) {
                i11 = 2;
            }
            z9 = false;
        }
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int previousWindowIndex = getTimelineByChildIndex(childIndexByWindowIndex).getPreviousWindowIndex(i10 - firstWindowIndexByChildIndex, i11 != 2 ? i11 : 0, z9);
        if (previousWindowIndex != -1) {
            return firstWindowIndexByChildIndex + previousWindowIndex;
        }
        int previousChildIndex = getPreviousChildIndex(childIndexByWindowIndex, z9);
        while (previousChildIndex != -1 && getTimelineByChildIndex(previousChildIndex).isEmpty()) {
            previousChildIndex = getPreviousChildIndex(previousChildIndex, z9);
        }
        if (previousChildIndex != -1) {
            return getTimelineByChildIndex(previousChildIndex).getLastWindowIndex(z9) + getFirstWindowIndexByChildIndex(previousChildIndex);
        }
        if (i11 == 2) {
            return getLastWindowIndex(z9);
        }
        return -1;
    }

    public abstract Timeline getTimelineByChildIndex(int i10);

    @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
    public final Timeline.Window getWindow(int i10, Timeline.Window window, boolean z9, long j10) {
        int childIndexByWindowIndex = getChildIndexByWindowIndex(i10);
        int firstWindowIndexByChildIndex = getFirstWindowIndexByChildIndex(childIndexByWindowIndex);
        int firstPeriodIndexByChildIndex = getFirstPeriodIndexByChildIndex(childIndexByWindowIndex);
        getTimelineByChildIndex(childIndexByWindowIndex).getWindow(i10 - firstWindowIndexByChildIndex, window, z9, j10);
        window.firstPeriodIndex += firstPeriodIndexByChildIndex;
        window.lastPeriodIndex += firstPeriodIndexByChildIndex;
        return window;
    }
}

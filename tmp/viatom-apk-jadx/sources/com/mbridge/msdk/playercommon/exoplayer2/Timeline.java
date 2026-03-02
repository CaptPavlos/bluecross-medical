package com.mbridge.msdk.playercommon.exoplayer2;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.source.ads.AdPlaybackState;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class Timeline {
    public static final Timeline EMPTY = new Timeline() { // from class: com.mbridge.msdk.playercommon.exoplayer2.Timeline.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Period getPeriod(int i10, Period period, boolean z9) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getPeriodCount() {
            return 0;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final Window getWindow(int i10, Window window, boolean z9, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.Timeline
        public final int getWindowCount() {
            return 0;
        }
    };

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Window {
        public long defaultPositionUs;
        public long durationUs;
        public int firstPeriodIndex;
        public boolean isDynamic;
        public boolean isSeekable;
        public int lastPeriodIndex;
        public long positionInFirstPeriodUs;
        public long presentationStartTimeMs;

        @Nullable
        public Object tag;
        public long windowStartTimeMs;

        public final long getDefaultPositionMs() {
            return C.usToMs(this.defaultPositionUs);
        }

        public final long getDefaultPositionUs() {
            return this.defaultPositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final long getPositionInFirstPeriodMs() {
            return C.usToMs(this.positionInFirstPeriodUs);
        }

        public final long getPositionInFirstPeriodUs() {
            return this.positionInFirstPeriodUs;
        }

        public final Window set(@Nullable Object obj, long j10, long j11, boolean z9, boolean z10, long j12, long j13, int i10, int i11, long j14) {
            this.tag = obj;
            this.presentationStartTimeMs = j10;
            this.windowStartTimeMs = j11;
            this.isSeekable = z9;
            this.isDynamic = z10;
            this.defaultPositionUs = j12;
            this.durationUs = j13;
            this.firstPeriodIndex = i10;
            this.lastPeriodIndex = i11;
            this.positionInFirstPeriodUs = j14;
            return this;
        }
    }

    public int getFirstWindowIndex(boolean z9) {
        return isEmpty() ? -1 : 0;
    }

    public abstract int getIndexOfPeriod(Object obj);

    public int getLastWindowIndex(boolean z9) {
        if (isEmpty()) {
            return -1;
        }
        return getWindowCount() - 1;
    }

    public final int getNextPeriodIndex(int i10, Period period, Window window, int i11, boolean z9) {
        int i12 = getPeriod(i10, period).windowIndex;
        if (getWindow(i12, window).lastPeriodIndex != i10) {
            return i10 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i12, i11, z9);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, window).firstPeriodIndex;
    }

    public int getNextWindowIndex(int i10, int i11, boolean z9) {
        if (i11 == 0) {
            if (i10 == getLastWindowIndex(z9)) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == getLastWindowIndex(z9) ? getFirstWindowIndex(z9) : i10 + 1;
        }
        u.e();
        return 0;
    }

    public final Period getPeriod(int i10, Period period) {
        return getPeriod(i10, period, false);
    }

    public abstract Period getPeriod(int i10, Period period, boolean z9);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i10, long j10, long j11) {
        Assertions.checkIndex(i10, 0, getWindowCount());
        getWindow(i10, window, false, j11);
        if (j10 == C.TIME_UNSET) {
            j10 = window.getDefaultPositionUs();
            if (j10 == C.TIME_UNSET) {
                return null;
            }
        }
        int i11 = window.firstPeriodIndex;
        long positionInFirstPeriodUs = window.getPositionInFirstPeriodUs() + j10;
        long durationUs = getPeriod(i11, period).getDurationUs();
        while (durationUs != C.TIME_UNSET && positionInFirstPeriodUs >= durationUs && i11 < window.lastPeriodIndex) {
            positionInFirstPeriodUs -= durationUs;
            i11++;
            durationUs = getPeriod(i11, period).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i11), Long.valueOf(positionInFirstPeriodUs));
    }

    public int getPreviousWindowIndex(int i10, int i11, boolean z9) {
        if (i11 == 0) {
            if (i10 == getFirstWindowIndex(z9)) {
                return -1;
            }
            return i10 - 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 == 2) {
            return i10 == getFirstWindowIndex(z9) ? getLastWindowIndex(z9) : i10 - 1;
        }
        u.e();
        return 0;
    }

    public final Window getWindow(int i10, Window window, boolean z9) {
        return getWindow(i10, window, z9, 0L);
    }

    public abstract Window getWindow(int i10, Window window, boolean z9, long j10);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i10, Period period, Window window, int i11, boolean z9) {
        return getNextPeriodIndex(i10, period, window, i11, z9) == -1;
    }

    public final Window getWindow(int i10, Window window) {
        return getWindow(i10, window, false);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Period {
        private AdPlaybackState adPlaybackState;
        public long durationUs;
        public Object id;
        private long positionInWindowUs;
        public Object uid;
        public int windowIndex;

        public final int getAdCountInAdGroup(int i10) {
            return this.adPlaybackState.adGroups[i10].count;
        }

        public final long getAdDurationUs(int i10, int i11) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i10];
            return adGroup.count != -1 ? adGroup.durationsUs[i11] : C.TIME_UNSET;
        }

        public final int getAdGroupCount() {
            return this.adPlaybackState.adGroupCount;
        }

        public final int getAdGroupIndexAfterPositionUs(long j10) {
            return this.adPlaybackState.getAdGroupIndexAfterPositionUs(j10);
        }

        public final int getAdGroupIndexForPositionUs(long j10) {
            return this.adPlaybackState.getAdGroupIndexForPositionUs(j10);
        }

        public final long getAdGroupTimeUs(int i10) {
            return this.adPlaybackState.adGroupTimesUs[i10];
        }

        public final long getAdResumePositionUs() {
            return this.adPlaybackState.adResumePositionUs;
        }

        public final long getDurationMs() {
            return C.usToMs(this.durationUs);
        }

        public final long getDurationUs() {
            return this.durationUs;
        }

        public final int getFirstAdIndexToPlay(int i10) {
            return this.adPlaybackState.adGroups[i10].getFirstAdIndexToPlay();
        }

        public final int getNextAdIndexToPlay(int i10, int i11) {
            return this.adPlaybackState.adGroups[i10].getNextAdIndexToPlay(i11);
        }

        public final long getPositionInWindowMs() {
            return C.usToMs(this.positionInWindowUs);
        }

        public final long getPositionInWindowUs() {
            return this.positionInWindowUs;
        }

        public final boolean hasPlayedAdGroup(int i10) {
            return !this.adPlaybackState.adGroups[i10].hasUnplayedAds();
        }

        public final boolean isAdAvailable(int i10, int i11) {
            AdPlaybackState.AdGroup adGroup = this.adPlaybackState.adGroups[i10];
            return (adGroup.count == -1 || adGroup.states[i11] == 0) ? false : true;
        }

        public final Period set(Object obj, Object obj2, int i10, long j10, long j11) {
            return set(obj, obj2, i10, j10, j11, AdPlaybackState.NONE);
        }

        public final Period set(Object obj, Object obj2, int i10, long j10, long j11, AdPlaybackState adPlaybackState) {
            this.id = obj;
            this.uid = obj2;
            this.windowIndex = i10;
            this.durationUs = j10;
            this.positionInWindowUs = j11;
            this.adPlaybackState = adPlaybackState;
            return this;
        }
    }

    public final Pair<Integer, Long> getPeriodPosition(Window window, Period period, int i10, long j10) {
        return getPeriodPosition(window, period, i10, j10, 0L);
    }
}

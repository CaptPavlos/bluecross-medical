package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class SampleMetadataQueue {
    private static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private int absoluteFirstIndex;
    private int length;
    private int readPosition;
    private int relativeFirstIndex;
    private Format upstreamFormat;
    private int upstreamSourceId;
    private int capacity = 1000;
    private int[] sourceIds = new int[1000];
    private long[] offsets = new long[1000];
    private long[] timesUs = new long[1000];
    private int[] flags = new int[1000];
    private int[] sizes = new int[1000];
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private Format[] formats = new Format[1000];
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;
    }

    private long discardSamples(int i10) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i10));
        int i11 = this.length - i10;
        this.length = i11;
        this.absoluteFirstIndex += i10;
        int i12 = this.relativeFirstIndex + i10;
        this.relativeFirstIndex = i12;
        int i13 = this.capacity;
        if (i12 >= i13) {
            this.relativeFirstIndex = i12 - i13;
        }
        int i14 = this.readPosition - i10;
        this.readPosition = i14;
        if (i14 < 0) {
            this.readPosition = 0;
        }
        if (i11 != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i15 = this.relativeFirstIndex;
        if (i15 != 0) {
            i13 = i15;
        }
        return this.offsets[i13 - 1] + this.sizes[r2];
    }

    private int findSampleBefore(int i10, int i11, long j10, boolean z9) {
        int i12 = -1;
        for (int i13 = 0; i13 < i11 && this.timesUs[i10] <= j10; i13++) {
            if (!z9 || (this.flags[i10] & 1) != 0) {
                i12 = i13;
            }
            i10++;
            if (i10 == this.capacity) {
                i10 = 0;
            }
        }
        return i12;
    }

    private long getLargestTimestamp(int i10) {
        long jMax = Long.MIN_VALUE;
        if (i10 == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i10 - 1);
        for (int i11 = 0; i11 < i10; i11++) {
            jMax = Math.max(jMax, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                return jMax;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return jMax;
    }

    private int getRelativeIndex(int i10) {
        int i11 = this.relativeFirstIndex + i10;
        int i12 = this.capacity;
        return i11 < i12 ? i11 : i11 - i12;
    }

    public final synchronized int advanceTo(long j10, boolean z9, boolean z10) throws Throwable {
        try {
            try {
                int relativeIndex = getRelativeIndex(this.readPosition);
                if (!hasNextSample() || j10 < this.timesUs[relativeIndex] || (j10 > this.largestQueuedTimestampUs && !z10)) {
                    return -1;
                }
                int iFindSampleBefore = findSampleBefore(relativeIndex, this.length - this.readPosition, j10, z9);
                if (iFindSampleBefore == -1) {
                    return -1;
                }
                this.readPosition += iFindSampleBefore;
                return iFindSampleBefore;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized int advanceToEnd() {
        int i10;
        int i11 = this.length;
        i10 = i11 - this.readPosition;
        this.readPosition = i11;
        return i10;
    }

    public final synchronized boolean attemptSplice(long j10) {
        try {
            int i10 = this.length;
            long j11 = this.largestDiscardedTimestampUs;
            if (i10 == 0) {
                return j10 > j11;
            }
            if (Math.max(j11, getLargestTimestamp(this.readPosition)) >= j10) {
                return false;
            }
            int i11 = this.length;
            int relativeIndex = getRelativeIndex(i11 - 1);
            while (i11 > this.readPosition && this.timesUs[relativeIndex] >= j10) {
                i11--;
                relativeIndex--;
                if (relativeIndex == -1) {
                    relativeIndex = this.capacity - 1;
                }
            }
            discardUpstreamSamples(this.absoluteFirstIndex + i11);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void commitSample(long j10, int i10, long j11, int i11, TrackOutput.CryptoData cryptoData) {
        try {
            if (this.upstreamKeyframeRequired) {
                if ((i10 & 1) == 0) {
                    return;
                } else {
                    this.upstreamKeyframeRequired = false;
                }
            }
            Assertions.checkState(!this.upstreamFormatRequired);
            commitSampleTimestamp(j10);
            int relativeIndex = getRelativeIndex(this.length);
            this.timesUs[relativeIndex] = j10;
            long[] jArr = this.offsets;
            jArr[relativeIndex] = j11;
            this.sizes[relativeIndex] = i11;
            this.flags[relativeIndex] = i10;
            this.cryptoDatas[relativeIndex] = cryptoData;
            this.formats[relativeIndex] = this.upstreamFormat;
            this.sourceIds[relativeIndex] = this.upstreamSourceId;
            int i12 = this.length + 1;
            this.length = i12;
            int i13 = this.capacity;
            if (i12 == i13) {
                int i14 = i13 + 1000;
                int[] iArr = new int[i14];
                long[] jArr2 = new long[i14];
                long[] jArr3 = new long[i14];
                int[] iArr2 = new int[i14];
                int[] iArr3 = new int[i14];
                TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i14];
                Format[] formatArr = new Format[i14];
                int i15 = this.relativeFirstIndex;
                int i16 = i13 - i15;
                System.arraycopy(jArr, i15, jArr2, 0, i16);
                System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr3, 0, i16);
                System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i16);
                System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i16);
                System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i16);
                System.arraycopy(this.formats, this.relativeFirstIndex, formatArr, 0, i16);
                System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i16);
                int i17 = this.relativeFirstIndex;
                System.arraycopy(this.offsets, 0, jArr2, i16, i17);
                System.arraycopy(this.timesUs, 0, jArr3, i16, i17);
                System.arraycopy(this.flags, 0, iArr2, i16, i17);
                System.arraycopy(this.sizes, 0, iArr3, i16, i17);
                System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i16, i17);
                System.arraycopy(this.formats, 0, formatArr, i16, i17);
                System.arraycopy(this.sourceIds, 0, iArr, i16, i17);
                this.offsets = jArr2;
                this.timesUs = jArr3;
                this.flags = iArr2;
                this.sizes = iArr3;
                this.cryptoDatas = cryptoDataArr;
                this.formats = formatArr;
                this.sourceIds = iArr;
                this.relativeFirstIndex = 0;
                this.length = this.capacity;
                this.capacity = i14;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void commitSampleTimestamp(long j10) {
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j10);
    }

    public final synchronized long discardTo(long j10, boolean z9, boolean z10) throws Throwable {
        Throwable th;
        try {
            try {
                int i10 = this.length;
                if (i10 != 0) {
                    long[] jArr = this.timesUs;
                    int i11 = this.relativeFirstIndex;
                    if (j10 >= jArr[i11]) {
                        if (z10) {
                            try {
                                int i12 = this.readPosition;
                                if (i12 != i10) {
                                    i10 = i12 + 1;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        int iFindSampleBefore = findSampleBefore(i11, i10, j10, z9);
                        if (iFindSampleBefore == -1) {
                            return -1L;
                        }
                        return discardSamples(iFindSampleBefore);
                    }
                }
                return -1L;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    public final synchronized long discardToEnd() {
        int i10 = this.length;
        if (i10 == 0) {
            return -1L;
        }
        return discardSamples(i10);
    }

    public final synchronized long discardToRead() {
        int i10 = this.readPosition;
        if (i10 == 0) {
            return -1L;
        }
        return discardSamples(i10);
    }

    public final long discardUpstreamSamples(int i10) {
        int writeIndex = getWriteIndex() - i10;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i11 = this.length - writeIndex;
        this.length = i11;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i11));
        int i12 = this.length;
        if (i12 == 0) {
            return 0L;
        }
        return this.offsets[getRelativeIndex(i12 - 1)] + this.sizes[r6];
    }

    public final synchronized boolean format(Format format) {
        if (format == null) {
            this.upstreamFormatRequired = true;
            return false;
        }
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        this.upstreamFormat = format;
        return true;
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final synchronized boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    public final int peekSourceId() {
        return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
    }

    public final synchronized int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z9, boolean z10, Format format, SampleExtrasHolder sampleExtrasHolder) {
        if (!hasNextSample()) {
            if (z10) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            Format format2 = this.upstreamFormat;
            if (format2 == null || (!z9 && format2 == format)) {
                return -3;
            }
            formatHolder.format = format2;
            return -5;
        }
        int relativeIndex = getRelativeIndex(this.readPosition);
        if (!z9 && this.formats[relativeIndex] == format) {
            if (decoderInputBuffer.isFlagsOnly()) {
                return -3;
            }
            decoderInputBuffer.timeUs = this.timesUs[relativeIndex];
            decoderInputBuffer.setFlags(this.flags[relativeIndex]);
            sampleExtrasHolder.size = this.sizes[relativeIndex];
            sampleExtrasHolder.offset = this.offsets[relativeIndex];
            sampleExtrasHolder.cryptoData = this.cryptoDatas[relativeIndex];
            this.readPosition++;
            return -4;
        }
        formatHolder.format = this.formats[relativeIndex];
        return -5;
    }

    public final void reset(boolean z9) {
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        if (z9) {
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final synchronized void rewind() {
        this.readPosition = 0;
    }

    public final synchronized boolean setReadPosition(int i10) {
        int i11 = this.absoluteFirstIndex;
        if (i11 > i10 || i10 > this.length + i11) {
            return false;
        }
        this.readPosition = i10 - i11;
        return true;
    }

    public final void sourceId(int i10) {
        this.upstreamSourceId = i10;
    }
}

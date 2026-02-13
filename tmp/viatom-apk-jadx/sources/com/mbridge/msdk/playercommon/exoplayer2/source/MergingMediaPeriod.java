package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.window.layout.c;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.SeekParameters;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private SequenceableLoader compositeSequenceableLoader;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private MediaPeriod[] enabledPeriods;
    public final MediaPeriod[] periods;
    private TrackGroupArray trackGroups;
    private final ArrayList<MediaPeriod> childrenPendingPreparation = new ArrayList<>();
    private final IdentityHashMap<SampleStream, Integer> streamPeriodIndices = new IdentityHashMap<>();

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaPeriod... mediaPeriodArr) {
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.periods = mediaPeriodArr;
        this.compositeSequenceableLoader = compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(new SequenceableLoader[0]);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod, com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader
    public final boolean continueLoading(long j10) {
        if (this.childrenPendingPreparation.isEmpty()) {
            return this.compositeSequenceableLoader.continueLoading(j10);
        }
        int size = this.childrenPendingPreparation.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.childrenPendingPreparation.get(i10).continueLoading(j10);
        }
        return false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final void discardBuffer(long j10, boolean z9) {
        for (MediaPeriod mediaPeriod : this.enabledPeriods) {
            mediaPeriod.discardBuffer(j10, z9);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final long getAdjustedSeekPositionUs(long j10, SeekParameters seekParameters) {
        return this.enabledPeriods[0].getAdjustedSeekPositionUs(j10, seekParameters);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod, com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader
    public final long getBufferedPositionUs() {
        return this.compositeSequenceableLoader.getBufferedPositionUs();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod, com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader
    public final long getNextLoadPositionUs() {
        return this.compositeSequenceableLoader.getNextLoadPositionUs();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final TrackGroupArray getTrackGroups() {
        return this.trackGroups;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final void maybeThrowPrepareError() throws IOException {
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.maybeThrowPrepareError();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        this.childrenPendingPreparation.remove(mediaPeriod);
        if (this.childrenPendingPreparation.isEmpty()) {
            int i10 = 0;
            for (MediaPeriod mediaPeriod2 : this.periods) {
                i10 += mediaPeriod2.getTrackGroups().length;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i10];
            int i11 = 0;
            for (MediaPeriod mediaPeriod3 : this.periods) {
                TrackGroupArray trackGroups = mediaPeriod3.getTrackGroups();
                int i12 = trackGroups.length;
                int i13 = 0;
                while (i13 < i12) {
                    trackGroupArr[i11] = trackGroups.get(i13);
                    i13++;
                    i11++;
                }
            }
            this.trackGroups = new TrackGroupArray(trackGroupArr);
            this.callback.onPrepared(this);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final void prepare(MediaPeriod.Callback callback, long j10) {
        this.callback = callback;
        Collections.addAll(this.childrenPendingPreparation, this.periods);
        for (MediaPeriod mediaPeriod : this.periods) {
            mediaPeriod.prepare(this, j10);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final long readDiscontinuity() {
        long discontinuity = this.periods[0].readDiscontinuity();
        int i10 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.periods;
            if (i10 >= mediaPeriodArr.length) {
                if (discontinuity != C.TIME_UNSET) {
                    for (MediaPeriod mediaPeriod : this.enabledPeriods) {
                        if (mediaPeriod != this.periods[0] && mediaPeriod.seekToUs(discontinuity) != discontinuity) {
                            c.g("Unexpected child seekToUs result.");
                            return 0L;
                        }
                    }
                }
                return discontinuity;
            }
            if (mediaPeriodArr[i10].readDiscontinuity() != C.TIME_UNSET) {
                c.g("Child reported discontinuity.");
                return 0L;
            }
            i10++;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod, com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader
    public final void reevaluateBuffer(long j10) {
        this.compositeSequenceableLoader.reevaluateBuffer(j10);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final long seekToUs(long j10) {
        long jSeekToUs = this.enabledPeriods[0].seekToUs(j10);
        int i10 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.enabledPeriods;
            if (i10 >= mediaPeriodArr.length) {
                return jSeekToUs;
            }
            if (mediaPeriodArr[i10].seekToUs(jSeekToUs) != jSeekToUs) {
                c.g("Unexpected child seekToUs result.");
                return 0L;
            }
            i10++;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.MediaPeriod
    public final long selectTracks(TrackSelection[] trackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j10) {
        TrackSelection[] trackSelectionArr2 = trackSelectionArr;
        int[] iArr = new int[trackSelectionArr2.length];
        int[] iArr2 = new int[trackSelectionArr2.length];
        for (int i10 = 0; i10 < trackSelectionArr2.length; i10++) {
            SampleStream sampleStream = sampleStreamArr[i10];
            iArr[i10] = sampleStream == null ? -1 : this.streamPeriodIndices.get(sampleStream).intValue();
            iArr2[i10] = -1;
            TrackSelection trackSelection = trackSelectionArr2[i10];
            if (trackSelection != null) {
                TrackGroup trackGroup = trackSelection.getTrackGroup();
                int i11 = 0;
                while (true) {
                    MediaPeriod[] mediaPeriodArr = this.periods;
                    if (i11 >= mediaPeriodArr.length) {
                        break;
                    }
                    if (mediaPeriodArr[i11].getTrackGroups().indexOf(trackGroup) != -1) {
                        iArr2[i10] = i11;
                        break;
                    }
                    i11++;
                }
            }
        }
        this.streamPeriodIndices.clear();
        int length = trackSelectionArr2.length;
        SampleStream[] sampleStreamArr2 = new SampleStream[length];
        SampleStream[] sampleStreamArr3 = new SampleStream[trackSelectionArr2.length];
        TrackSelection[] trackSelectionArr3 = new TrackSelection[trackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.periods.length);
        long j11 = j10;
        int i12 = 0;
        while (i12 < this.periods.length) {
            for (int i13 = 0; i13 < trackSelectionArr2.length; i13++) {
                TrackSelection trackSelection2 = null;
                sampleStreamArr3[i13] = iArr[i13] == i12 ? sampleStreamArr[i13] : null;
                if (iArr2[i13] == i12) {
                    trackSelection2 = trackSelectionArr2[i13];
                }
                trackSelectionArr3[i13] = trackSelection2;
            }
            int i14 = i12;
            long jSelectTracks = this.periods[i12].selectTracks(trackSelectionArr3, zArr, sampleStreamArr3, zArr2, j11);
            if (i14 == 0) {
                j11 = jSelectTracks;
            } else if (jSelectTracks != j11) {
                c.g("Children enabled at different positions.");
                return 0L;
            }
            int i15 = 0;
            boolean z9 = false;
            while (i15 < trackSelectionArr2.length) {
                if (iArr2[i15] == i14) {
                    Assertions.checkState(sampleStreamArr3[i15] != null);
                    sampleStreamArr2[i15] = sampleStreamArr3[i15];
                    this.streamPeriodIndices.put(sampleStreamArr3[i15], Integer.valueOf(i14));
                    z9 = true;
                } else if (iArr[i15] == i14) {
                    Assertions.checkState(sampleStreamArr3[i15] == null);
                }
                i15++;
                trackSelectionArr2 = trackSelectionArr;
            }
            if (z9) {
                arrayList.add(this.periods[i14]);
            }
            i12 = i14 + 1;
            trackSelectionArr2 = trackSelectionArr;
        }
        System.arraycopy(sampleStreamArr2, 0, sampleStreamArr, 0, length);
        MediaPeriod[] mediaPeriodArr2 = new MediaPeriod[arrayList.size()];
        this.enabledPeriods = mediaPeriodArr2;
        arrayList.toArray(mediaPeriodArr2);
        this.compositeSequenceableLoader = this.compositeSequenceableLoaderFactory.createCompositeSequenceableLoader(this.enabledPeriods);
        return j11;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.callback.onContinueLoadingRequested(this);
    }
}

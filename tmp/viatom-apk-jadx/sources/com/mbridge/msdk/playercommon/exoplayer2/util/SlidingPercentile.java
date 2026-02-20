package com.mbridge.msdk.playercommon.exoplayer2.util;

import androidx.constraintlayout.core.widgets.analyzer.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class SlidingPercentile {
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private int totalWeight;
    private static final Comparator<Sample> INDEX_COMPARATOR = new Comparator<Sample>() { // from class: com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile.1
        @Override // java.util.Comparator
        public final int compare(Sample sample, Sample sample2) {
            return sample.index - sample2.index;
        }
    };
    private static final Comparator<Sample> VALUE_COMPARATOR = new Comparator<Sample>() { // from class: com.mbridge.msdk.playercommon.exoplayer2.util.SlidingPercentile.2
        @Override // java.util.Comparator
        public final int compare(Sample sample, Sample sample2) {
            float f = sample.value;
            float f10 = sample2.value;
            if (f < f10) {
                return -1;
            }
            return f10 < f ? 1 : 0;
        }
    };
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int currentSortOrder = -1;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }

    public SlidingPercentile(int i10) {
        this.maxWeight = i10;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    public void addSample(int i10, float f) {
        Sample sample;
        ensureSortedByIndex();
        int i11 = this.recycledSampleCount;
        if (i11 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i12 = i11 - 1;
            this.recycledSampleCount = i12;
            sample = sampleArr[i12];
        } else {
            sample = new Sample();
        }
        int i13 = this.nextSampleIndex;
        this.nextSampleIndex = i13 + 1;
        sample.index = i13;
        sample.weight = i10;
        sample.value = f;
        this.samples.add(sample);
        this.totalWeight += i10;
        while (true) {
            int i14 = this.totalWeight;
            int i15 = this.maxWeight;
            if (i14 <= i15) {
                return;
            }
            int i16 = i14 - i15;
            Sample sample2 = this.samples.get(0);
            int i17 = sample2.weight;
            if (i17 <= i16) {
                this.totalWeight -= i17;
                this.samples.remove(0);
                int i18 = this.recycledSampleCount;
                if (i18 < 5) {
                    Sample[] sampleArr2 = this.recycledSamples;
                    this.recycledSampleCount = i18 + 1;
                    sampleArr2[i18] = sample2;
                }
            } else {
                sample2.weight = i17 - i16;
                this.totalWeight -= i16;
            }
        }
    }

    public float getPercentile(float f) {
        ensureSortedByValue();
        float f10 = f * this.totalWeight;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int size = this.samples.size();
            ArrayList<Sample> arrayList = this.samples;
            if (i10 >= size) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((Sample) a.t(this.samples, 1)).value;
            }
            Sample sample = arrayList.get(i10);
            i11 += sample.weight;
            if (i11 >= f10) {
                return sample.value;
            }
            i10++;
        }
    }
}

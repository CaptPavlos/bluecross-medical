package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public int[] sampleCompositionTimeOffsetTable;
    public int sampleCount;
    public long[] sampleDecodingTimeTable;
    public ParsableByteArray sampleEncryptionData;
    public int sampleEncryptionDataLength;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    public final void fillEncryptionData(ExtractorInput extractorInput) throws InterruptedException, IOException {
        extractorInput.readFully(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public final long getSamplePresentationTime(int i10) {
        return this.sampleDecodingTimeTable[i10] + this.sampleCompositionTimeOffsetTable[i10];
    }

    public final void initEncryptionData(int i10) {
        ParsableByteArray parsableByteArray = this.sampleEncryptionData;
        if (parsableByteArray == null || parsableByteArray.limit() < i10) {
            this.sampleEncryptionData = new ParsableByteArray(i10);
        }
        this.sampleEncryptionDataLength = i10;
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public final void initTables(int i10, int i11) {
        this.trunCount = i10;
        this.sampleCount = i11;
        int[] iArr = this.trunLength;
        if (iArr == null || iArr.length < i10) {
            this.trunDataPosition = new long[i10];
            this.trunLength = new int[i10];
        }
        int[] iArr2 = this.sampleSizeTable;
        if (iArr2 == null || iArr2.length < i11) {
            int i12 = (i11 * 125) / 100;
            this.sampleSizeTable = new int[i12];
            this.sampleCompositionTimeOffsetTable = new int[i12];
            this.sampleDecodingTimeTable = new long[i12];
            this.sampleIsSyncFrameTable = new boolean[i12];
            this.sampleHasSubsampleEncryptionTable = new boolean[i12];
        }
    }

    public final void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public final void fillEncryptionData(ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.data, 0, this.sampleEncryptionDataLength);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.source;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.CryptoInfo;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class AllocationNode {

        @Nullable
        public Allocation allocation;
        public final long endPosition;

        @Nullable
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j10, int i10) {
            this.startPosition = j10;
            this.endPosition = j10 + i10;
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public final void initialize(Allocation allocation, AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j10) {
            return ((int) (j10 - this.startPosition)) + this.allocation.offset;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        this.allocator = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        this.metadataQueue = new SampleMetadataQueue();
        this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j10) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j10 < allocationNode.endPosition) {
                return;
            } else {
                this.readAllocationNode = allocationNode.next;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            int i10 = (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength) + (allocationNode2.wasInitialized ? 1 : 0);
            Allocation[] allocationArr = new Allocation[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                allocationArr[i11] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j10) {
        AllocationNode allocationNode;
        if (j10 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j10 < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j10) {
        if (format == null) {
            return null;
        }
        if (j10 == 0) {
            return format;
        }
        long j11 = format.subsampleOffsetUs;
        return j11 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j11 + j10) : format;
    }

    private void postAppend(int i10) {
        long j10 = this.totalBytesWritten + i10;
        this.totalBytesWritten = j10;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j10 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i10) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i10, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j10, byte[] bArr, int i10) {
        advanceReadTo(j10);
        int i11 = i10;
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (this.readAllocationNode.endPosition - j10));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j10), bArr, i10 - i11, iMin);
            i11 -= iMin;
            j10 += iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j10 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        long j10 = sampleExtrasHolder.offset;
        int unsignedShort = 1;
        this.scratch.reset(1);
        readData(j10, this.scratch.data, 1);
        long j11 = j10 + 1;
        byte b10 = this.scratch.data[0];
        boolean z9 = (b10 & 128) != 0;
        int i10 = b10 & 127;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        }
        readData(j11, cryptoInfo.iv, i10);
        long j12 = j11 + i10;
        if (z9) {
            this.scratch.reset(2);
            readData(j12, this.scratch.data, 2);
            j12 += 2;
            unsignedShort = this.scratch.readUnsignedShort();
        }
        int i11 = unsignedShort;
        CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < i11) {
            iArr = new int[i11];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i11) {
            iArr3 = new int[i11];
        }
        int[] iArr4 = iArr3;
        if (z9) {
            int i12 = i11 * 6;
            this.scratch.reset(i12);
            readData(j12, this.scratch.data, i12);
            j12 += i12;
            this.scratch.setPosition(0);
            for (int i13 = 0; i13 < i11; i13++) {
                iArr2[i13] = this.scratch.readUnsignedShort();
                iArr4[i13] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.size - ((int) (j12 - sampleExtrasHolder.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer.cryptoInfo;
        cryptoInfo3.set(i11, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j13 = sampleExtrasHolder.offset;
        int i14 = (int) (j12 - j13);
        sampleExtrasHolder.offset = j13 + i14;
        sampleExtrasHolder.size -= i14;
    }

    public final int advanceTo(long j10, boolean z9, boolean z10) {
        return this.metadataQueue.advanceTo(j10, z9, z10);
    }

    public final int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public final void discardTo(long j10, boolean z9, boolean z10) {
        discardDownstreamTo(this.metadataQueue.discardTo(j10, z9, z10));
    }

    public final void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public final void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public final void discardUpstreamSamples(int i10) {
        AllocationNode allocationNode;
        long jDiscardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i10);
        this.totalBytesWritten = jDiscardUpstreamSamples;
        if (jDiscardUpstreamSamples != 0) {
            AllocationNode allocationNode2 = this.firstAllocationNode;
            if (jDiscardUpstreamSamples != allocationNode2.startPosition) {
                while (true) {
                    long j10 = this.totalBytesWritten;
                    long j11 = allocationNode2.endPosition;
                    allocationNode = allocationNode2.next;
                    if (j10 <= j11) {
                        break;
                    } else {
                        allocationNode2 = allocationNode;
                    }
                }
                clearAllocationNodes(allocationNode);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode2.endPosition, this.allocationLength);
                allocationNode2.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode2.endPosition) {
                    allocationNode2 = allocationNode3;
                }
                this.writeAllocationNode = allocationNode2;
                if (this.readAllocationNode == allocationNode) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean z9 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !z9) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
    }

    public final int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public final long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public final long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public final int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public final Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public final int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public final boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public final int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public final int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z9, boolean z10, long j10) throws IllegalStateException {
        int i10 = this.metadataQueue.read(formatHolder, decoderInputBuffer, z9, z10, this.downstreamFormat, this.extrasHolder);
        if (i10 == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        }
        if (i10 != -4) {
            if (i10 == -3) {
                return -3;
            }
            u.e();
            return 0;
        }
        if (!decoderInputBuffer.isEndOfStream()) {
            if (decoderInputBuffer.timeUs < j10) {
                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.isEncrypted()) {
                readEncryptionData(decoderInputBuffer, this.extrasHolder);
            }
            decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
            SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
            readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
        }
        return -4;
    }

    public final void reset(boolean z9) {
        this.metadataQueue.reset(z9);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public final void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final int sampleData(ExtractorInput extractorInput, int i10, boolean z9) throws InterruptedException, IOException {
        int iPreAppend = preAppend(i10);
        AllocationNode allocationNode = this.writeAllocationNode;
        int i11 = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
        if (i11 != -1) {
            postAppend(i11);
            return i11;
        }
        if (z9) {
            return -1;
        }
        u.q();
        return 0;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void sampleMetadata(long j10, int i10, int i11, int i12, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i10 & 1) == 0 || !this.metadataQueue.attemptSplice(j10)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        this.metadataQueue.commitSample(j10 + this.sampleOffsetUs, i10, (this.totalBytesWritten - i11) - i12, i11, cryptoData);
    }

    public final boolean setReadPosition(int i10) {
        return this.metadataQueue.setReadPosition(i10);
    }

    public final void setSampleOffsetUs(long j10) {
        if (this.sampleOffsetUs != j10) {
            this.sampleOffsetUs = j10;
            this.pendingFormatAdjustment = true;
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void sourceId(int i10) {
        this.metadataQueue.sourceId(i10);
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final void reset() {
        reset(false);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i10) {
        while (i10 > 0) {
            int iPreAppend = preAppend(i10);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
            i10 -= iPreAppend;
            postAppend(iPreAppend);
        }
    }

    private void readData(long j10, ByteBuffer byteBuffer, int i10) {
        advanceReadTo(j10);
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (this.readAllocationNode.endPosition - j10));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j10), iMin);
            i10 -= iMin;
            j10 += iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j10 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }
}

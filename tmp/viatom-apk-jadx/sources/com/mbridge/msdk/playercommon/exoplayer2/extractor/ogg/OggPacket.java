package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class OggPacket {
    private boolean populated;
    private int segmentCount;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private final ParsableByteArray packetArray = new ParsableByteArray(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);
    private int currentSegmentIndex = -1;

    private int calculatePacketSize(int i10) {
        int i11;
        int i12 = 0;
        this.segmentCount = 0;
        do {
            int i13 = this.segmentCount;
            int i14 = i10 + i13;
            OggPageHeader oggPageHeader = this.pageHeader;
            if (i14 >= oggPageHeader.pageSegmentCount) {
                break;
            }
            int[] iArr = oggPageHeader.laces;
            this.segmentCount = i13 + 1;
            i11 = iArr[i13 + i10];
            i12 += i11;
        } while (i11 == 255);
        return i12;
    }

    public final OggPageHeader getPageHeader() {
        return this.pageHeader;
    }

    public final ParsableByteArray getPayload() {
        return this.packetArray;
    }

    public final boolean populate(ExtractorInput extractorInput) throws InterruptedException, IOException {
        int i10;
        Assertions.checkState(extractorInput != null);
        if (this.populated) {
            this.populated = false;
            this.packetArray.reset();
        }
        while (!this.populated) {
            if (this.currentSegmentIndex < 0) {
                if (!this.pageHeader.populate(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.pageHeader;
                int iCalculatePacketSize = oggPageHeader.headerSize;
                if ((oggPageHeader.type & 1) == 1 && this.packetArray.limit() == 0) {
                    iCalculatePacketSize += calculatePacketSize(0);
                    i10 = this.segmentCount;
                } else {
                    i10 = 0;
                }
                extractorInput.skipFully(iCalculatePacketSize);
                this.currentSegmentIndex = i10;
            }
            int iCalculatePacketSize2 = calculatePacketSize(this.currentSegmentIndex);
            int i11 = this.currentSegmentIndex + this.segmentCount;
            if (iCalculatePacketSize2 > 0) {
                if (this.packetArray.capacity() < this.packetArray.limit() + iCalculatePacketSize2) {
                    ParsableByteArray parsableByteArray = this.packetArray;
                    parsableByteArray.data = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit() + iCalculatePacketSize2);
                }
                ParsableByteArray parsableByteArray2 = this.packetArray;
                extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), iCalculatePacketSize2);
                ParsableByteArray parsableByteArray3 = this.packetArray;
                parsableByteArray3.setLimit(parsableByteArray3.limit() + iCalculatePacketSize2);
                this.populated = this.pageHeader.laces[i11 + (-1)] != 255;
            }
            if (i11 == this.pageHeader.pageSegmentCount) {
                i11 = -1;
            }
            this.currentSegmentIndex = i11;
        }
        return true;
    }

    public final void reset() {
        this.pageHeader.reset();
        this.packetArray.reset();
        this.currentSegmentIndex = -1;
        this.populated = false;
    }

    public final void trimPayload() {
        ParsableByteArray parsableByteArray = this.packetArray;
        byte[] bArr = parsableByteArray.data;
        if (bArr.length == 65025) {
            return;
        }
        parsableByteArray.data = Arrays.copyOf(bArr, Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, parsableByteArray.limit()));
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class OggPageHeader {
    public static final int EMPTY_PAGE_HEADER_SIZE = 27;
    public static final int MAX_PAGE_PAYLOAD = 65025;
    public static final int MAX_PAGE_SIZE = 65307;
    public static final int MAX_SEGMENT_COUNT = 255;
    private static final int TYPE_OGGS = Util.getIntegerCodeForString("OggS");
    public int bodySize;
    public long granulePosition;
    public int headerSize;
    public long pageChecksum;
    public int pageSegmentCount;
    public long pageSequenceNumber;
    public int revision;
    public long streamSerialNumber;
    public int type;
    public final int[] laces = new int[255];
    private final ParsableByteArray scratch = new ParsableByteArray(255);

    public final boolean populate(ExtractorInput extractorInput, boolean z9) throws InterruptedException, IOException {
        this.scratch.reset();
        reset();
        if ((extractorInput.getLength() != -1 && extractorInput.getLength() - extractorInput.getPeekPosition() < 27) || !extractorInput.peekFully(this.scratch.data, 0, 27, true)) {
            if (z9) {
                return false;
            }
            u.q();
            return false;
        }
        if (this.scratch.readUnsignedInt() != TYPE_OGGS) {
            if (z9) {
                return false;
            }
            a.i("expected OggS capture pattern at begin of page");
            return false;
        }
        int unsignedByte = this.scratch.readUnsignedByte();
        this.revision = unsignedByte;
        if (unsignedByte != 0) {
            if (z9) {
                return false;
            }
            a.i("unsupported bit stream revision");
            return false;
        }
        this.type = this.scratch.readUnsignedByte();
        this.granulePosition = this.scratch.readLittleEndianLong();
        this.streamSerialNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageSequenceNumber = this.scratch.readLittleEndianUnsignedInt();
        this.pageChecksum = this.scratch.readLittleEndianUnsignedInt();
        int unsignedByte2 = this.scratch.readUnsignedByte();
        this.pageSegmentCount = unsignedByte2;
        this.headerSize = unsignedByte2 + 27;
        this.scratch.reset();
        extractorInput.peekFully(this.scratch.data, 0, this.pageSegmentCount);
        for (int i10 = 0; i10 < this.pageSegmentCount; i10++) {
            this.laces[i10] = this.scratch.readUnsignedByte();
            this.bodySize += this.laces[i10];
        }
        return true;
    }

    public final void reset() {
        this.revision = 0;
        this.type = 0;
        this.granulePosition = 0L;
        this.streamSerialNumber = 0L;
        this.pageSequenceNumber = 0L;
        this.pageChecksum = 0L;
        this.pageSegmentCount = 0;
        this.headerSize = 0;
        this.bodySize = 0;
    }
}

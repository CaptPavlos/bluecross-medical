package com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg;

import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class EventMessageDecoder implements MetadataDecoder {
    @Override // com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder
    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArrArray, iLimit);
        String nullTerminatedString = parsableByteArray.readNullTerminatedString();
        String nullTerminatedString2 = parsableByteArray.readNullTerminatedString();
        long unsignedInt = parsableByteArray.readUnsignedInt();
        return new Metadata(new EventMessage(nullTerminatedString, nullTerminatedString2, Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000L, unsignedInt), parsableByteArray.readUnsignedInt(), Arrays.copyOfRange(bArrArray, parsableByteArray.getPosition(), iLimit), Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000L, unsignedInt)));
    }
}

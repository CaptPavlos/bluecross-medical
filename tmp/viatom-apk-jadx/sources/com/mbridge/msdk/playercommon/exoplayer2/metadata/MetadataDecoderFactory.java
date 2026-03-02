package com.mbridge.msdk.playercommon.exoplayer2.metadata;

import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35.SpliceInfoDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT = new MetadataDecoderFactory() { // from class: com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoderFactory.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoderFactory
        public final MetadataDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            str.getClass();
            switch (str) {
                case "application/id3":
                    return new Id3Decoder();
                case "application/x-emsg":
                    return new EventMessageDecoder();
                case "application/x-scte35":
                    return new SpliceInfoDecoder();
                default:
                    a.n("Attempted to create decoder for unsupported format");
                    return null;
            }
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoderFactory
        public final boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str);
        }
    };

    MetadataDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}

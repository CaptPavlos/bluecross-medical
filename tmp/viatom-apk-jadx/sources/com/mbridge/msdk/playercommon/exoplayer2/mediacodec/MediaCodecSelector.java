package com.mbridge.msdk.playercommon.exoplayer2.mediacodec;

import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecUtil;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = new MediaCodecSelector() { // from class: com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector.1
        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector
        public final MediaCodecInfo getDecoderInfo(String str, boolean z9) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getDecoderInfo(str, z9);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector
        public final MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.getPassthroughDecoderInfo();
        }
    };

    MediaCodecInfo getDecoderInfo(String str, boolean z9) throws MediaCodecUtil.DecoderQueryException;

    MediaCodecInfo getPassthroughDecoderInfo() throws MediaCodecUtil.DecoderQueryException;
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class OpusReader extends StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int OPUS_CODE = Util.getIntegerCodeForString("Opus");
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    private long getPacketDurationUs(byte[] bArr) {
        int i10;
        byte b10 = bArr[0];
        int i11 = b10 & 255;
        int i12 = b10 & 3;
        if (i12 != 0) {
            i10 = 2;
            if (i12 != 1 && i12 != 2) {
                i10 = bArr[1] & 63;
            }
        } else {
            i10 = 1;
        }
        int i13 = i11 >> 3;
        return i10 * (i13 >= 16 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << r0 : i13 >= 12 ? 10000 << (i13 & 1) : (i13 & 3) == 3 ? MBridgeCommon.DEFAULT_LOAD_TIMEOUT : 10000 << r0);
    }

    private void putNativeOrderLong(List<byte[]> list, int i10) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((i10 * C.NANOS_PER_SECOND) / 48000).array());
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int iBytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (iBytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader
    public final long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.data));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader
    public final boolean readHeaders(ParsableByteArray parsableByteArray, long j10, StreamReader.SetupData setupData) throws InterruptedException, IOException {
        if (this.headerRead) {
            boolean z9 = parsableByteArray.readInt() == OPUS_CODE;
            parsableByteArray.setPosition(0);
            return z9;
        }
        byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit());
        int i10 = bArrCopyOf[9] & 255;
        int i11 = ((bArrCopyOf[11] & 255) << 8) | (bArrCopyOf[10] & 255);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArrCopyOf);
        putNativeOrderLong(arrayList, i11);
        putNativeOrderLong(arrayList, DEFAULT_SEEK_PRE_ROLL_SAMPLES);
        setupData.format = Format.createAudioSampleFormat(null, MimeTypes.AUDIO_OPUS, null, -1, -1, i10, SAMPLE_RATE, arrayList, null, 0, null);
        this.headerRead = true;
        return true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.StreamReader
    public final void reset(boolean z9) {
        super.reset(z9);
        if (z9) {
            this.headerRead = false;
        }
    }
}

package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import android.util.Log;
import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";
    private static final int TYPE_FLOAT = 3;
    private static final int TYPE_PCM = 1;
    private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;
        public final int id;
        public final long size;

        private ChunkHeader(int i10, long j10) {
            this.id = i10;
            this.size = j10;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws InterruptedException, IOException {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    private WavHeaderReader() {
    }

    public static WavHeader peek(ExtractorInput extractorInput) throws InterruptedException, IOException {
        ChunkHeader chunkHeaderPeek;
        long j10;
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).id != Util.getIntegerCodeForString("RIFF")) {
            return null;
        }
        int pcmEncoding = 0;
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int i10 = parsableByteArray.readInt();
        if (i10 != Util.getIntegerCodeForString("WAVE")) {
            Log.e(TAG, "Unsupported RIFF format: " + i10);
            return null;
        }
        while (true) {
            chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
            int i11 = chunkHeaderPeek.id;
            int integerCodeForString = Util.getIntegerCodeForString("fmt ");
            j10 = chunkHeaderPeek.size;
            if (i11 == integerCodeForString) {
                break;
            }
            extractorInput.advancePeekPosition((int) j10);
        }
        Assertions.checkState(j10 >= 16);
        extractorInput.peekFully(parsableByteArray.data, 0, 16);
        parsableByteArray.setPosition(0);
        int littleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int littleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int littleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i12 = (littleEndianUnsignedShort2 * littleEndianUnsignedShort4) / 8;
        if (littleEndianUnsignedShort3 != i12) {
            a.i(androidx.constraintlayout.core.widgets.analyzer.a.u(i12, littleEndianUnsignedShort3, "Expected block alignment: ", "; got: "));
            return null;
        }
        if (littleEndianUnsignedShort == 1) {
            pcmEncoding = Util.getPcmEncoding(littleEndianUnsignedShort4);
        } else if (littleEndianUnsignedShort != 3) {
            if (littleEndianUnsignedShort != TYPE_WAVE_FORMAT_EXTENSIBLE) {
                Log.e(TAG, "Unsupported WAV format type: " + littleEndianUnsignedShort);
                return null;
            }
            pcmEncoding = Util.getPcmEncoding(littleEndianUnsignedShort4);
        } else if (littleEndianUnsignedShort4 == 32) {
            pcmEncoding = 4;
        }
        int i13 = pcmEncoding;
        if (i13 != 0) {
            extractorInput.advancePeekPosition(((int) chunkHeaderPeek.size) - 16);
            return new WavHeader(littleEndianUnsignedShort2, littleEndianUnsignedIntToInt, littleEndianUnsignedIntToInt2, littleEndianUnsignedShort3, littleEndianUnsignedShort4, i13);
        }
        Log.e(TAG, "Unsupported WAV bit depth " + littleEndianUnsignedShort4 + " for type " + littleEndianUnsignedShort);
        return null;
    }

    public static void skipToData(ExtractorInput extractorInput, WavHeader wavHeader) throws InterruptedException, IOException {
        Assertions.checkNotNull(extractorInput);
        Assertions.checkNotNull(wavHeader);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (chunkHeaderPeek.id != Util.getIntegerCodeForString(DataSchemeDataSource.SCHEME_DATA)) {
            Log.w(TAG, "Ignoring unknown WAV chunk: " + chunkHeaderPeek.id);
            long j10 = chunkHeaderPeek.size + 8;
            if (chunkHeaderPeek.id == Util.getIntegerCodeForString("RIFF")) {
                j10 = 12;
            }
            if (j10 > 2147483647L) {
                a.e(chunkHeaderPeek.id, "Chunk is too large (~2GB+) to skip; id: ");
                return;
            } else {
                extractorInput.skipFully((int) j10);
                chunkHeaderPeek = ChunkHeader.peek(extractorInput, parsableByteArray);
            }
        }
        extractorInput.skipFully(8);
        wavHeader.setDataBounds(extractorInput.getPosition(), chunkHeaderPeek.size);
    }
}

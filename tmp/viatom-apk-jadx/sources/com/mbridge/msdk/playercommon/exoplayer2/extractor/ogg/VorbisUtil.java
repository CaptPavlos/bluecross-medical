package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import android.util.Log;
import com.google.gson.internal.a;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class VorbisUtil {
    private static final String TAG = "VorbisUtil";

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int i10, int i11, long[] jArr, int i12, boolean z9) {
            this.dimensions = i10;
            this.entries = i11;
            this.lengthMap = jArr;
            this.lookupType = i12;
            this.isOrdered = z9;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String str, String[] strArr, int i10) {
            this.vendor = str;
            this.comments = strArr;
            this.length = i10;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z9, int i10, int i11, int i12) {
            this.blockFlag = z9;
            this.windowType = i10;
            this.transformType = i11;
            this.mapping = i12;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long j10, int i10, long j11, int i11, int i12, int i13, int i14, int i15, boolean z9, byte[] bArr) {
            this.version = j10;
            this.channels = i10;
            this.sampleRate = j11;
            this.bitrateMax = i11;
            this.bitrateNominal = i12;
            this.bitrateMin = i13;
            this.blockSize0 = i14;
            this.blockSize1 = i15;
            this.framingFlag = z9;
            this.data = bArr;
        }

        public final int getApproximateBitrate() {
            int i10 = this.bitrateNominal;
            return i10 == 0 ? (this.bitrateMin + this.bitrateMax) / 2 : i10;
        }
    }

    private VorbisUtil() {
    }

    public static int iLog(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    private static long mapType1QuantValues(long j10, long j11) {
        return (long) Math.floor(Math.pow(j10, 1.0d / j11));
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray) throws ParserException {
        if (vorbisBitArray.readBits(24) != 5653314) {
            a.e(vorbisBitArray.getPosition(), "expected code book to start with [0x56, 0x43, 0x42] at ");
            return null;
        }
        int bits = vorbisBitArray.readBits(16);
        int bits2 = vorbisBitArray.readBits(24);
        long[] jArr = new long[bits2];
        boolean bit = vorbisBitArray.readBit();
        long jMapType1QuantValues = 0;
        if (bit) {
            int bits3 = vorbisBitArray.readBits(5) + 1;
            int i10 = 0;
            while (i10 < bits2) {
                int bits4 = vorbisBitArray.readBits(iLog(bits2 - i10));
                for (int i11 = 0; i11 < bits4 && i10 < bits2; i11++) {
                    jArr[i10] = bits3;
                    i10++;
                }
                bits3++;
            }
        } else {
            boolean bit2 = vorbisBitArray.readBit();
            for (int i12 = 0; i12 < bits2; i12++) {
                if (!bit2 || vorbisBitArray.readBit()) {
                    jArr[i12] = vorbisBitArray.readBits(5) + 1;
                } else {
                    jArr[i12] = 0;
                }
            }
        }
        int bits5 = vorbisBitArray.readBits(4);
        if (bits5 > 2) {
            a.i(a3.a.f(bits5, "lookup type greater than 2 not decodable: "));
            return null;
        }
        if (bits5 == 1 || bits5 == 2) {
            vorbisBitArray.skipBits(32);
            vorbisBitArray.skipBits(32);
            int bits6 = vorbisBitArray.readBits(4) + 1;
            vorbisBitArray.skipBits(1);
            if (bits5 != 1) {
                jMapType1QuantValues = bits2 * bits;
            } else if (bits != 0) {
                jMapType1QuantValues = mapType1QuantValues(bits2, bits);
            }
            vorbisBitArray.skipBits((int) (jMapType1QuantValues * bits6));
        }
        return new CodeBook(bits, bits2, jArr, bits5, bit);
    }

    private static void readFloors(VorbisBitArray vorbisBitArray) throws ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i10 = 0; i10 < bits; i10++) {
            int bits2 = vorbisBitArray.readBits(16);
            if (bits2 == 0) {
                vorbisBitArray.skipBits(8);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(16);
                vorbisBitArray.skipBits(6);
                vorbisBitArray.skipBits(8);
                int bits3 = vorbisBitArray.readBits(4) + 1;
                for (int i11 = 0; i11 < bits3; i11++) {
                    vorbisBitArray.skipBits(8);
                }
            } else {
                if (bits2 != 1) {
                    a.i(a3.a.f(bits2, "floor type greater than 1 not decodable: "));
                    return;
                }
                int bits4 = vorbisBitArray.readBits(5);
                int[] iArr = new int[bits4];
                int i12 = -1;
                for (int i13 = 0; i13 < bits4; i13++) {
                    int bits5 = vorbisBitArray.readBits(4);
                    iArr[i13] = bits5;
                    if (bits5 > i12) {
                        i12 = bits5;
                    }
                }
                int i14 = i12 + 1;
                int[] iArr2 = new int[i14];
                for (int i15 = 0; i15 < i14; i15++) {
                    iArr2[i15] = vorbisBitArray.readBits(3) + 1;
                    int bits6 = vorbisBitArray.readBits(2);
                    if (bits6 > 0) {
                        vorbisBitArray.skipBits(8);
                    }
                    for (int i16 = 0; i16 < (1 << bits6); i16++) {
                        vorbisBitArray.skipBits(8);
                    }
                }
                vorbisBitArray.skipBits(2);
                int bits7 = vorbisBitArray.readBits(4);
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < bits4; i19++) {
                    i17 += iArr2[iArr[i19]];
                    while (i18 < i17) {
                        vorbisBitArray.skipBits(bits7);
                        i18++;
                    }
                }
            }
        }
    }

    private static void readMappings(int i10, VorbisBitArray vorbisBitArray) throws ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i11 = 0; i11 < bits; i11++) {
            int bits2 = vorbisBitArray.readBits(16);
            if (bits2 != 0) {
                Log.e(TAG, "mapping type other than 0 not supported: " + bits2);
            } else {
                int bits3 = vorbisBitArray.readBit() ? vorbisBitArray.readBits(4) + 1 : 1;
                if (vorbisBitArray.readBit()) {
                    int bits4 = vorbisBitArray.readBits(8) + 1;
                    for (int i12 = 0; i12 < bits4; i12++) {
                        int i13 = i10 - 1;
                        vorbisBitArray.skipBits(iLog(i13));
                        vorbisBitArray.skipBits(iLog(i13));
                    }
                }
                if (vorbisBitArray.readBits(2) != 0) {
                    a.i("to reserved bits must be zero after mapping coupling steps");
                    return;
                }
                if (bits3 > 1) {
                    for (int i14 = 0; i14 < i10; i14++) {
                        vorbisBitArray.skipBits(4);
                    }
                }
                for (int i15 = 0; i15 < bits3; i15++) {
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                    vorbisBitArray.skipBits(8);
                }
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray) {
        int bits = vorbisBitArray.readBits(6) + 1;
        Mode[] modeArr = new Mode[bits];
        for (int i10 = 0; i10 < bits; i10++) {
            modeArr[i10] = new Mode(vorbisBitArray.readBit(), vorbisBitArray.readBits(16), vorbisBitArray.readBits(16), vorbisBitArray.readBits(8));
        }
        return modeArr;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray) throws ParserException {
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i10 = 0; i10 < bits; i10++) {
            if (vorbisBitArray.readBits(16) > 2) {
                a.i("residueType greater than 2 is not decodable");
                return;
            }
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            vorbisBitArray.skipBits(24);
            int bits2 = vorbisBitArray.readBits(6) + 1;
            vorbisBitArray.skipBits(8);
            int[] iArr = new int[bits2];
            for (int i11 = 0; i11 < bits2; i11++) {
                iArr[i11] = ((vorbisBitArray.readBit() ? vorbisBitArray.readBits(5) : 0) * 8) + vorbisBitArray.readBits(3);
            }
            for (int i12 = 0; i12 < bits2; i12++) {
                for (int i13 = 0; i13 < 8; i13++) {
                    if ((iArr[i12] & (1 << i13)) != 0) {
                        vorbisBitArray.skipBits(8);
                    }
                }
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(3, parsableByteArray, false);
        String string = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
        int length = string.length();
        long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        String[] strArr = new String[(int) littleEndianUnsignedInt];
        int length2 = length + 15;
        for (int i10 = 0; i10 < littleEndianUnsignedInt; i10++) {
            String string2 = parsableByteArray.readString((int) parsableByteArray.readLittleEndianUnsignedInt());
            strArr[i10] = string2;
            length2 = length2 + 4 + string2.length();
        }
        if ((parsableByteArray.readUnsignedByte() & 1) != 0) {
            return new CommentHeader(string, strArr, length2 + 1);
        }
        a.i("framing bit expected to be set");
        return null;
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray) throws ParserException {
        verifyVorbisHeaderCapturePattern(1, parsableByteArray, false);
        long littleEndianUnsignedInt = parsableByteArray.readLittleEndianUnsignedInt();
        int unsignedByte = parsableByteArray.readUnsignedByte();
        long littleEndianUnsignedInt2 = parsableByteArray.readLittleEndianUnsignedInt();
        int littleEndianInt = parsableByteArray.readLittleEndianInt();
        int littleEndianInt2 = parsableByteArray.readLittleEndianInt();
        int littleEndianInt3 = parsableByteArray.readLittleEndianInt();
        int unsignedByte2 = parsableByteArray.readUnsignedByte();
        return new VorbisIdHeader(littleEndianUnsignedInt, unsignedByte, littleEndianUnsignedInt2, littleEndianInt, littleEndianInt2, littleEndianInt3, (int) Math.pow(2.0d, unsignedByte2 & 15), (int) Math.pow(2.0d, (unsignedByte2 & PsExtractor.VIDEO_STREAM_MASK) >> 4), (parsableByteArray.readUnsignedByte() & 1) > 0, Arrays.copyOf(parsableByteArray.data, parsableByteArray.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray, int i10) throws ParserException {
        verifyVorbisHeaderCapturePattern(5, parsableByteArray, false);
        int unsignedByte = parsableByteArray.readUnsignedByte() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.data);
        vorbisBitArray.skipBits(parsableByteArray.getPosition() * 8);
        for (int i11 = 0; i11 < unsignedByte; i11++) {
            readBook(vorbisBitArray);
        }
        int bits = vorbisBitArray.readBits(6) + 1;
        for (int i12 = 0; i12 < bits; i12++) {
            if (vorbisBitArray.readBits(16) != 0) {
                a.i("placeholder of time domain transforms not zeroed out");
                return null;
            }
        }
        readFloors(vorbisBitArray);
        readResidues(vorbisBitArray);
        readMappings(i10, vorbisBitArray);
        Mode[] modes = readModes(vorbisBitArray);
        if (vorbisBitArray.readBit()) {
            return modes;
        }
        a.i("framing bit after modes not set as expected");
        return null;
    }

    public static boolean verifyVorbisHeaderCapturePattern(int i10, ParsableByteArray parsableByteArray, boolean z9) throws ParserException {
        if (parsableByteArray.bytesLeft() < 7) {
            if (z9) {
                return false;
            }
            a.e(parsableByteArray.bytesLeft(), "too short header: ");
            return false;
        }
        if (parsableByteArray.readUnsignedByte() != i10) {
            if (z9) {
                return false;
            }
            throw new ParserException("expected header type " + Integer.toHexString(i10));
        }
        if (parsableByteArray.readUnsignedByte() == 118 && parsableByteArray.readUnsignedByte() == 111 && parsableByteArray.readUnsignedByte() == 114 && parsableByteArray.readUnsignedByte() == 98 && parsableByteArray.readUnsignedByte() == 105 && parsableByteArray.readUnsignedByte() == 115) {
            return true;
        }
        if (z9) {
            return false;
        }
        a.i("expected characters 'vorbis'");
        return false;
    }
}

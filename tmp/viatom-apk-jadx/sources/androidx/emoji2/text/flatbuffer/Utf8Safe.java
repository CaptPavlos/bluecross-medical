package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Utf8Safe extends Utf8 {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i10, int i11) {
            super(androidx.constraintlayout.core.widgets.analyzer.a.u(i10, i11, "Unpaired surrogate at index ", " of "));
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i10 < length) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i10);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (iEncodedLengthGeneral + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i10, int i11) throws IllegalArgumentException {
        if ((i10 | i11 | ((bArr.length - i10) - i11)) < 0) {
            androidx.core.view.accessibility.a.o("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i10), Integer.valueOf(i11)});
            return null;
        }
        int i12 = i10 + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if (!Utf8.DecodeUtil.isOneByte(b10)) {
                break;
            }
            i10++;
            Utf8.DecodeUtil.handleOneByte(b10, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte b11 = bArr[i10];
            if (Utf8.DecodeUtil.isOneByte(b11)) {
                int i16 = i14 + 1;
                Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                while (i15 < i12) {
                    byte b12 = bArr[i15];
                    if (!Utf8.DecodeUtil.isOneByte(b12)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b12, cArr, i16);
                    i16++;
                }
                i14 = i16;
                i10 = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b11)) {
                if (i15 >= i12) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                i10 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b11, bArr[i15], cArr, i14);
                i14++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b11)) {
                if (i15 >= i12 - 1) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                int i17 = i10 + 2;
                i10 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b11, bArr[i15], bArr[i17], cArr, i14);
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                byte b13 = bArr[i15];
                int i18 = i10 + 3;
                byte b14 = bArr[i10 + 2];
                i10 += 4;
                Utf8.DecodeUtil.handleFourBytes(b11, b13, b14, bArr[i18], cArr, i14);
                i14 += 2;
            }
        }
        return new String(cArr, 0, i14);
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i10, int i11) throws IllegalArgumentException {
        if ((i10 | i11 | ((byteBuffer.limit() - i10) - i11)) < 0) {
            androidx.core.view.accessibility.a.o("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i10), Integer.valueOf(i11)});
            return null;
        }
        int i12 = i10 + i11;
        char[] cArr = new char[i11];
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = byteBuffer.get(i10);
            if (!Utf8.DecodeUtil.isOneByte(b10)) {
                break;
            }
            i10++;
            Utf8.DecodeUtil.handleOneByte(b10, cArr, i13);
            i13++;
        }
        int i14 = i13;
        while (i10 < i12) {
            int i15 = i10 + 1;
            byte b11 = byteBuffer.get(i10);
            if (Utf8.DecodeUtil.isOneByte(b11)) {
                int i16 = i14 + 1;
                Utf8.DecodeUtil.handleOneByte(b11, cArr, i14);
                while (i15 < i12) {
                    byte b12 = byteBuffer.get(i15);
                    if (!Utf8.DecodeUtil.isOneByte(b12)) {
                        break;
                    }
                    i15++;
                    Utf8.DecodeUtil.handleOneByte(b12, cArr, i16);
                    i16++;
                }
                i14 = i16;
                i10 = i15;
            } else if (Utf8.DecodeUtil.isTwoBytes(b11)) {
                if (i15 >= i12) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                i10 += 2;
                Utf8.DecodeUtil.handleTwoBytes(b11, byteBuffer.get(i15), cArr, i14);
                i14++;
            } else if (Utf8.DecodeUtil.isThreeBytes(b11)) {
                if (i15 >= i12 - 1) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                int i17 = i10 + 2;
                i10 += 3;
                Utf8.DecodeUtil.handleThreeBytes(b11, byteBuffer.get(i15), byteBuffer.get(i17), cArr, i14);
                i14++;
            } else {
                if (i15 >= i12 - 2) {
                    com.google.gson.internal.a.n("Invalid UTF-8");
                    return null;
                }
                byte b13 = byteBuffer.get(i15);
                int i18 = i10 + 3;
                byte b14 = byteBuffer.get(i10 + 2);
                i10 += 4;
                Utf8.DecodeUtil.handleFourBytes(b11, b13, b14, byteBuffer.get(i18), cArr, i14);
                i14 += 2;
            }
        }
        return new String(cArr, 0, i14);
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char cCharAt;
        int length = charSequence.length();
        int i14 = i11 + i10;
        int i15 = 0;
        while (i15 < length && (i13 = i15 + i10) < i14 && (cCharAt = charSequence.charAt(i15)) < 128) {
            bArr[i13] = (byte) cCharAt;
            i15++;
        }
        if (i15 == length) {
            return i10 + length;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char cCharAt2 = charSequence.charAt(i15);
            if (cCharAt2 < 128 && i16 < i14) {
                bArr[i16] = (byte) cCharAt2;
                i16++;
            } else if (cCharAt2 < 2048 && i16 <= i14 - 2) {
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((cCharAt2 >>> 6) | 960);
                i16 += 2;
                bArr[i17] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i16 > i14 - 3) {
                    if (i16 > i14 - 4) {
                        if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i12 = i15 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i12)))) {
                            throw new UnpairedSurrogateException(i15, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i16);
                    }
                    int i18 = i15 + 1;
                    if (i18 != charSequence.length()) {
                        char cCharAt3 = charSequence.charAt(i18);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i16] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                            bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i19 = i16 + 3;
                            bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i16 += 4;
                            bArr[i19] = (byte) ((codePoint & 63) | 128);
                            i15 = i18;
                        } else {
                            i15 = i18;
                        }
                    }
                    throw new UnpairedSurrogateException(i15 - 1, length);
                }
                bArr[i16] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i20 = i16 + 2;
                bArr[i16 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i16 += 3;
                bArr[i20] = (byte) ((cCharAt2 & '?') | 128);
            }
            i15++;
        }
        return i16;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i10;
        int length = charSequence.length();
        int iPosition = byteBuffer.position();
        int i11 = 0;
        while (i11 < length) {
            try {
                char cCharAt = charSequence.charAt(i11);
                if (cCharAt >= 128) {
                    break;
                }
                byteBuffer.put(iPosition + i11, (byte) cCharAt);
                i11++;
            } catch (IndexOutOfBoundsException unused) {
                androidx.core.view.accessibility.a.d(charSequence.charAt(i11), Math.max(i11, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                return;
            }
        }
        if (i11 == length) {
            byteBuffer.position(iPosition + i11);
            return;
        }
        iPosition += i11;
        while (i11 < length) {
            char cCharAt2 = charSequence.charAt(i11);
            if (cCharAt2 < 128) {
                byteBuffer.put(iPosition, (byte) cCharAt2);
            } else if (cCharAt2 < 2048) {
                int i12 = iPosition + 1;
                try {
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i12, (byte) ((cCharAt2 & '?') | 128));
                    iPosition = i12;
                } catch (IndexOutOfBoundsException unused2) {
                    iPosition = i12;
                    androidx.core.view.accessibility.a.d(charSequence.charAt(i11), Math.max(i11, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                    return;
                }
            } else {
                if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                    int i13 = i11 + 1;
                    if (i13 != length) {
                        try {
                            char cCharAt3 = charSequence.charAt(i13);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                int i14 = iPosition + 1;
                                try {
                                    byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                    i10 = iPosition + 2;
                                } catch (IndexOutOfBoundsException unused3) {
                                    iPosition = i14;
                                    i11 = i13;
                                    androidx.core.view.accessibility.a.d(charSequence.charAt(i11), Math.max(i11, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                                    return;
                                }
                                try {
                                    byteBuffer.put(i14, (byte) (((codePoint >>> 12) & 63) | 128));
                                    iPosition += 3;
                                    byteBuffer.put(i10, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                    i11 = i13;
                                } catch (IndexOutOfBoundsException unused4) {
                                    i11 = i13;
                                    iPosition = i10;
                                    androidx.core.view.accessibility.a.d(charSequence.charAt(i11), Math.max(i11, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position());
                                    return;
                                }
                            } else {
                                i11 = i13;
                            }
                        } catch (IndexOutOfBoundsException unused5) {
                        }
                    }
                    throw new UnpairedSurrogateException(i11, length);
                }
                int i15 = iPosition + 1;
                byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | 224));
                iPosition += 2;
                byteBuffer.put(i15, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
            }
            i11++;
            iPosition++;
        }
        byteBuffer.position(iPosition);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt < 2048) {
                i11 += (127 - cCharAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) < 65536) {
                        throw new UnpairedSurrogateException(i10, length);
                    }
                    i10++;
                }
            }
            i10++;
        }
        return i11;
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public String decodeUtf8(ByteBuffer byteBuffer, int i10, int i11) throws IllegalArgumentException {
        return byteBuffer.hasArray() ? decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i10, i11) : decodeUtf8Buffer(byteBuffer, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            encodeUtf8Buffer(charSequence, byteBuffer);
        } else {
            int iArrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}

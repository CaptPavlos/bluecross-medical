package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.charset.StandardCharsets;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f4026a;

    /* renamed from: b, reason: collision with root package name */
    public int f4027b;

    /* renamed from: c, reason: collision with root package name */
    private char[] f4028c;

    public q(byte[] bArr, int i10) {
        this.f4028c = null;
        this.f4026a = bArr;
        this.f4027b = i10;
    }

    private long c(int i10) {
        byte[] bArr = this.f4026a;
        return (bArr[i10 + 7] << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((255 & bArr[i10 + 6]) << 48);
    }

    public final String a(int i10) {
        String str;
        if (i10 < 0) {
            return null;
        }
        if (i10 == 0) {
            return "";
        }
        if (i10 > 2048) {
            str = new String(this.f4026a, this.f4027b, i10, StandardCharsets.UTF_8);
        } else {
            char[] cArr = this.f4028c;
            if (cArr == null) {
                if (i10 <= 256) {
                    this.f4028c = new char[256];
                } else {
                    this.f4028c = new char[2048];
                }
            } else if (cArr.length < i10) {
                this.f4028c = new char[2048];
            }
            char[] cArr2 = this.f4028c;
            byte[] bArr = this.f4026a;
            int i11 = this.f4027b;
            int i12 = i11 + i10;
            int i13 = 0;
            while (i11 < i12) {
                int i14 = i11 + 1;
                byte b10 = bArr[i11];
                if (b10 > 0) {
                    cArr2[i13] = (char) b10;
                    i13++;
                    i11 = i14;
                } else if (b10 < -32) {
                    i11 += 2;
                    cArr2[i13] = (char) ((bArr[i14] & 63) | ((b10 & 31) << 6));
                    i13++;
                } else if (b10 < -16) {
                    int i15 = i11 + 2;
                    i11 += 3;
                    cArr2[i13] = (char) (((bArr[i14] & 63) << 6) | ((b10 & 15) << 12) | (bArr[i15] & 63));
                    i13++;
                } else {
                    byte b11 = bArr[i14];
                    int i16 = i11 + 3;
                    byte b12 = bArr[i11 + 2];
                    i11 += 4;
                    int i17 = ((b11 & 63) << 12) | ((b10 & 7) << 18) | ((b12 & 63) << 6) | (bArr[i16] & 63);
                    int i18 = i13 + 1;
                    cArr2[i13] = (char) ((i17 >>> 10) + 55232);
                    i13 += 2;
                    cArr2[i18] = (char) ((i17 & 1023) + 56320);
                }
            }
            if (i11 > i12) {
                com.google.gson.internal.a.n("Invalid String");
                return null;
            }
            str = new String(cArr2, 0, i13);
        }
        this.f4027b += i10;
        return str;
    }

    public final void b(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 + 1;
            char cCharAt = str.charAt(i11);
            if (cCharAt < 128) {
                bArr[i10] = (byte) cCharAt;
                i10++;
            } else if (cCharAt < 2048) {
                int i13 = i10 + 1;
                bArr[i10] = (byte) ((cCharAt >>> 6) | PsExtractor.AUDIO_STREAM);
                i10 += 2;
                bArr[i13] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i10] = (byte) ((cCharAt >>> '\f') | 224);
                int i14 = i10 + 2;
                bArr[i10 + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i10 += 3;
                bArr[i14] = (byte) ((cCharAt & '?') | 128);
            } else {
                i11 += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i12)) - 56613888;
                bArr[i10] = (byte) ((iCharAt >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                bArr[i10 + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i15 = i10 + 3;
                bArr[i10 + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i10 += 4;
                bArr[i15] = (byte) ((iCharAt & 63) | 128);
            }
            i11 = i12;
        }
        this.f4027b = i10;
    }

    public final short d() {
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        int i11 = i10 + 1;
        this.f4027b = i11;
        int i12 = bArr[i10] & 255;
        this.f4027b = i10 + 2;
        return (short) ((bArr[i11] << 8) | i12);
    }

    public q(int i10) {
        this(new byte[i10], 0);
    }

    public q(byte[] bArr) {
        this(bArr, 0);
    }

    public final int c() {
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        int i11 = i10 + 1;
        this.f4027b = i11;
        int i12 = bArr[i10] & 255;
        int i13 = i10 + 2;
        this.f4027b = i13;
        int i14 = ((bArr[i11] & 255) << 8) | i12;
        int i15 = i10 + 3;
        this.f4027b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 16);
        this.f4027b = i10 + 4;
        return (bArr[i15] << 24) | i16;
    }

    public final void b(int i10) {
        byte[] bArr = this.f4026a;
        int i11 = this.f4027b;
        int i12 = i11 + 1;
        this.f4027b = i12;
        bArr[i11] = (byte) i10;
        int i13 = i11 + 2;
        this.f4027b = i13;
        bArr[i12] = (byte) (i10 >> 8);
        int i14 = i11 + 3;
        this.f4027b = i14;
        bArr[i13] = (byte) (i10 >> 16);
        this.f4027b = i11 + 4;
        bArr[i14] = (byte) (i10 >> 24);
    }

    public final void b(int i10, int i11) {
        byte[] bArr = this.f4026a;
        bArr[i10] = (byte) i11;
        bArr[i10 + 1] = (byte) (i11 >> 8);
        bArr[i10 + 2] = (byte) (i11 >> 16);
        bArr[i10 + 3] = (byte) (i11 >> 24);
    }

    public final long b() {
        long jC = c(this.f4027b);
        this.f4027b += 8;
        return jC;
    }

    public final byte a() {
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        this.f4027b = i10 + 1;
        return bArr[i10];
    }

    public final long a(int i10, int i11) {
        long jC = 0;
        if (i11 <= 0) {
            return 0L;
        }
        int i12 = i11 >> 3;
        int i13 = i11 & 7;
        int i14 = 0;
        int i15 = i10;
        for (int i16 = 0; i16 < i12; i16++) {
            jC ^= c(i15);
            i15 += 8;
        }
        while (i14 < (i13 << 3)) {
            jC ^= (this.f4026a[i15] & 255) << i14;
            i14 += 8;
            i15++;
        }
        int i17 = (i10 & 7) << 3;
        return (jC >>> (64 - i17)) | (jC << i17);
    }

    public static int a(String str) {
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                i11++;
            } else if (cCharAt < 2048) {
                i11 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i11 += 3;
            } else {
                i10 += 2;
                i11 += 4;
            }
            i10 = i12;
        }
        return i11;
    }

    public final void a(byte b10) {
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        this.f4027b = i10 + 1;
        bArr[i10] = b10;
    }

    public final void a(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, this.f4026a, this.f4027b, length);
            this.f4027b += length;
        }
    }

    public final void a(long j10) {
        a(this.f4027b, j10);
        this.f4027b += 8;
    }

    public final void a(int i10, long j10) {
        byte[] bArr = this.f4026a;
        bArr[i10] = (byte) j10;
        bArr[i10 + 1] = (byte) (j10 >> 8);
        bArr[i10 + 2] = (byte) (j10 >> 16);
        bArr[i10 + 3] = (byte) (j10 >> 24);
        bArr[i10 + 4] = (byte) (j10 >> 32);
        bArr[i10 + 5] = (byte) (j10 >> 40);
        bArr[i10 + 6] = (byte) (j10 >> 48);
        bArr[i10 + 7] = (byte) (j10 >> 56);
    }

    public final void a(short s9) {
        byte[] bArr = this.f4026a;
        int i10 = this.f4027b;
        int i11 = i10 + 1;
        this.f4027b = i11;
        bArr[i10] = (byte) s9;
        this.f4027b = i10 + 2;
        bArr[i11] = (byte) (s9 >> 8);
    }
}

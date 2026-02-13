package com.mbridge.msdk.thrid.okio;

import a3.a;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
final class Util {
    public static final Charset UTF_8 = Charset.forName(C.UTF8_NAME);

    private Util() {
    }

    public static boolean arrayRangeEquals(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            if (bArr[i13 + i10] != bArr2[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            StringBuilder sbX = a.x("size=", " offset=", j10);
            sbX.append(j11);
            sbX.append(" byteCount=");
            sbX.append(j12);
            throw new ArrayIndexOutOfBoundsException(sbX.toString());
        }
    }

    public static int reverseBytesInt(int i10) {
        return ((i10 & 255) << 24) | (((-16777216) & i10) >>> 24) | ((16711680 & i10) >>> 8) | ((65280 & i10) << 8);
    }

    public static long reverseBytesLong(long j10) {
        return ((j10 & 255) << 56) | (((-72057594037927936L) & j10) >>> 56) | ((71776119061217280L & j10) >>> 40) | ((280375465082880L & j10) >>> 24) | ((1095216660480L & j10) >>> 8) | ((4278190080L & j10) << 8) | ((16711680 & j10) << 24) | ((65280 & j10) << 40);
    }

    public static short reverseBytesShort(short s9) {
        return (short) (((s9 & 255) << 8) | ((65280 & s9) >>> 8));
    }

    public static void sneakyRethrow(Throwable th) throws Throwable {
        sneakyThrow2(th);
    }

    private static <T extends Throwable> void sneakyThrow2(Throwable th) throws Throwable {
        throw th;
    }
}

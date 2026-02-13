package okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import q8.c;
import z1.t1;
import z8.b0;
import z8.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {
    public static final byte[] e = {42};
    public static final String[] f = new String[0];
    public static final String[] g = {"*"};
    public static final PublicSuffixDatabase h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f11826a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f11827b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f11828c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f11829d;

    public static String a(byte[] bArr, byte[][] bArr2, int i10) {
        int i11;
        boolean z9;
        int i12;
        int i13;
        int length = bArr.length;
        int i14 = 0;
        while (i14 < length) {
            int i15 = (i14 + length) / 2;
            while (i15 > -1 && bArr[i15] != 10) {
                i15--;
            }
            int i16 = i15 + 1;
            int i17 = 1;
            while (true) {
                i11 = i16 + i17;
                if (bArr[i11] == 10) {
                    break;
                }
                i17++;
            }
            int i18 = i11 - i16;
            int i19 = i10;
            boolean z10 = false;
            int i20 = 0;
            int i21 = 0;
            while (true) {
                if (z10) {
                    i12 = 46;
                    z9 = false;
                } else {
                    z9 = z10;
                    i12 = bArr2[i19][i20] & 255;
                }
                i13 = i12 - (bArr[i16 + i21] & 255);
                if (i13 == 0) {
                    i21++;
                    i20++;
                    if (i21 == i18) {
                        break;
                    }
                    if (bArr2[i19].length != i20) {
                        z10 = z9;
                    } else {
                        if (i19 == bArr2.length - 1) {
                            break;
                        }
                        i19++;
                        i20 = -1;
                        z10 = true;
                    }
                } else {
                    break;
                }
            }
            if (i13 >= 0) {
                if (i13 <= 0) {
                    int i22 = i18 - i21;
                    int length2 = bArr2[i19].length - i20;
                    while (true) {
                        i19++;
                        if (i19 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i19].length;
                    }
                    if (length2 >= i22) {
                        if (length2 <= i22) {
                            return new String(bArr, i16, i18, c.f12292d);
                        }
                    }
                }
                i14 = i11 + 1;
            }
            length = i15;
        }
        return null;
    }

    public final void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        b0 b0Var = new b0(new t(t1.T(resourceAsStream)));
        try {
            byte[] bArr = new byte[b0Var.readInt()];
            b0Var.readFully(bArr);
            byte[] bArr2 = new byte[b0Var.readInt()];
            b0Var.readFully(bArr2);
            synchronized (this) {
                this.f11828c = bArr;
                this.f11829d = bArr2;
            }
            this.f11827b.countDown();
        } finally {
            c.c(b0Var);
        }
    }
}

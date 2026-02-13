package com.mbridge.msdk.thrid.okio;

import com.google.gson.internal.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str, int i10, int i11) {
        long j10;
        if (str == null) {
            a.n("string == null");
            return 0L;
        }
        if (i10 < 0) {
            a.n(a3.a.f(i10, "beginIndex < 0: "));
            return 0L;
        }
        if (i11 < i10) {
            a.n(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "endIndex < beginIndex: ", " < "));
            return 0L;
        }
        if (i11 > str.length()) {
            StringBuilder sbR = a3.a.r(i11, "endIndex > string.length: ", " > ");
            sbR.append(str.length());
            throw new IllegalArgumentException(sbR.toString());
        }
        long j11 = 0;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                j11++;
            } else {
                if (cCharAt < 2048) {
                    j10 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    j10 = 3;
                } else {
                    int i12 = i10 + 1;
                    char cCharAt2 = i12 < i11 ? str.charAt(i12) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j11++;
                        i10 = i12;
                    } else {
                        j11 += 4;
                        i10 += 2;
                    }
                }
                j11 += j10;
            }
            i10++;
        }
        return j11;
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }
}

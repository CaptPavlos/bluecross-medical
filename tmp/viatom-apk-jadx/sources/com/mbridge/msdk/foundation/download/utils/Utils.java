package com.mbridge.msdk.foundation.download.utils;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Utils {
    private Utils() {
    }

    public static int getDownloadRate(long j10, long j11) {
        if (j10 == 0 || j11 == 0) {
            return 0;
        }
        if (j10 == j11) {
            return 100;
        }
        return (int) (((j11 * 1.0d) / (j10 * 1.0d)) * 100.0d);
    }
}

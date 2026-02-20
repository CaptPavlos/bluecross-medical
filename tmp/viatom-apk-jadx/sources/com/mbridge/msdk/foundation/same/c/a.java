package com.mbridge.msdk.foundation.same.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0025: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:38), block:B:13:0x0025 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.io.InputStream a(android.graphics.Bitmap r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r1.<init>()     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            byte[] r2 = r1.toByteArray()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L27
            r1.close()     // Catch: java.lang.Exception -> L1a
            goto L22
        L1a:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L22
            r0.printStackTrace()
        L22:
            r0 = r4
            goto L42
        L24:
            r4 = move-exception
            r0 = r1
            goto L43
        L27:
            r4 = move-exception
            goto L2d
        L29:
            r4 = move-exception
            goto L43
        L2b:
            r4 = move-exception
            r1 = r0
        L2d:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L34
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L24
        L34:
            if (r1 == 0) goto L42
            r1.close()     // Catch: java.lang.Exception -> L3a
            goto L42
        L3a:
            r4 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L42
            r4.printStackTrace()
        L42:
            return r0
        L43:
            if (r0 == 0) goto L51
            r0.close()     // Catch: java.lang.Exception -> L49
            goto L51
        L49:
            r0 = move-exception
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r1 == 0) goto L51
            r0.printStackTrace()
        L51:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.c.a.a(android.graphics.Bitmap):java.io.InputStream");
    }
}

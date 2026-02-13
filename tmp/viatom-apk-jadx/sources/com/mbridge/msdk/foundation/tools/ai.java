package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.util.UUID;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ai {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f3941a = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', 'r'};

    /* renamed from: b, reason: collision with root package name */
    static String f3942b = "";

    /* renamed from: c, reason: collision with root package name */
    static boolean f3943c = false;

    /* renamed from: d, reason: collision with root package name */
    private static int f3944d = -1;
    private static int e = -1;
    private static boolean f = false;
    private static int g = -1;
    private static int h = -1;

    public static int a() {
        try {
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            long jLongValue = ((Long) an.a(contextC, "freeExternalSize", 0L)).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - jLongValue > 1800000 || e == -1) {
                e = Long.valueOf((c() / 1000) / 1000).intValue();
                an.b(contextC, "freeExternalSize", Long.valueOf(jCurrentTimeMillis));
            }
        } catch (Throwable th) {
            af.b("SameSDCardTool", th.getMessage(), th);
        }
        return e;
    }

    public static int b() {
        if (h == -1) {
            try {
                h = new Long((e() / 1000) / 1000).intValue();
            } catch (Throwable th) {
                af.b("SameSDCardTool", th.getMessage(), th);
            }
        }
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f A[PHI: r1
      0x005f: PHI (r1v3 java.io.File) = (r1v2 java.io.File), (r1v5 java.io.File) binds: [B:11:0x0017, B:15:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String c(android.content.Context r6) {
        /*
            r0 = 0
            java.io.File r1 = r6.getExternalFilesDir(r0)     // Catch: java.lang.Throwable -> Lc
            if (r1 == 0) goto L14
            java.io.File r1 = a(r1)     // Catch: java.lang.Throwable -> Lc
            goto L15
        Lc:
            r1 = move-exception
            java.lang.String r2 = "common-exception"
            java.lang.String r3 = "hasSDCard is failed"
            com.mbridge.msdk.foundation.tools.af.b(r2, r3, r1)
        L14:
            r1 = r0
        L15:
            boolean r2 = com.mbridge.msdk.foundation.tools.ai.f3943c
            if (r2 == 0) goto L5f
            if (r1 != 0) goto L54
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.File r2 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r2 = r2.getPath()
            r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            r1.append(r2)
            java.lang.String r3 = "Android"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = "data"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r2 = r6.getPackageName()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.io.File r2 = new java.io.File
            r2.<init>(r1)
            java.io.File r1 = a(r2)
        L54:
            long r2 = c()
            r4 = 31457280(0x1e00000, double:1.55419614E-316)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L60
        L5f:
            r0 = r1
        L60:
            if (r0 == 0) goto L68
            boolean r1 = r0.exists()
            if (r1 != 0) goto L70
        L68:
            java.io.File r6 = r6.getFilesDir()
            java.io.File r0 = r6.getAbsoluteFile()
        L70:
            java.lang.String r6 = r0.getAbsolutePath()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ai.c(android.content.Context):java.lang.String");
    }

    private static boolean d() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Exception unused) {
            af.b("", "hasSDCard is failed");
            return false;
        }
    }

    private static long e() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return 0L;
    }

    private static void b(Context context) {
        com.mbridge.msdk.foundation.same.b.e.a(new com.mbridge.msdk.foundation.same.b.d(c(context)));
        com.mbridge.msdk.foundation.same.b.e.a().b();
    }

    public static void a(Context context) {
        if (context == null || f) {
            return;
        }
        try {
            try {
                f3942b = context.getFilesDir().getAbsolutePath() + File.separator;
                f3943c = false;
                b(context);
            } catch (Exception unused) {
                f3942b = context.getFilesDir().getAbsolutePath() + File.separator;
                b(context);
            }
        } catch (Exception unused2) {
        }
        f = true;
    }

    private static File a(File file) {
        File file2 = new File(file, UUID.randomUUID() + "");
        if (file2.exists()) {
            file2.delete();
        }
        if (!file2.mkdirs()) {
            return null;
        }
        file2.delete();
        return file.getAbsoluteFile();
    }

    private static long c() {
        if (d()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return 0L;
    }
}

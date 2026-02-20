package d1;

import android.content.Context;
import android.util.Log;
import e0.m;
import f0.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final f f6784a = f.f8003b;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6785b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static Method f6786c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f6787d = false;

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8 A[Catch: all -> 0x0024, TryCatch #0 {, blocks: (B:4:0x0014, B:7:0x0019, B:14:0x003e, B:15:0x0043, B:17:0x0045, B:19:0x004a, B:25:0x0056, B:27:0x005a, B:30:0x0096, B:33:0x00a8, B:34:0x00ad, B:36:0x00af, B:37:0x00bb, B:12:0x0028), top: B:40:0x0014, inners: #2, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af A[Catch: all -> 0x0024, TryCatch #0 {, blocks: (B:4:0x0014, B:7:0x0019, B:14:0x003e, B:15:0x0043, B:17:0x0045, B:19:0x004a, B:25:0x0056, B:27:0x005a, B:30:0x0096, B:33:0x00a8, B:34:0x00ad, B:36:0x00af, B:37:0x00bb, B:12:0x0028), top: B:40:0x0014, inners: #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r13) throws e0.m, android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "Context must not be null"
            i0.y.h(r13, r0)
            f0.f r0 = d1.a.f6784a
            r0.getClass()
            f0.f.c(r13)
            long r0 = android.os.SystemClock.uptimeMillis()
            java.lang.Object r2 = d1.a.f6785b
            monitor-enter(r2)
            boolean r3 = d1.a.f6787d     // Catch: java.lang.Throwable -> L24
            r4 = 0
            if (r3 != 0) goto L45
            c1.d0 r3 = r0.e.f12301d     // Catch: java.lang.Throwable -> L24 r0.b -> L27
            java.lang.String r5 = "com.google.android.gms.providerinstaller.dynamite"
            r0.e r3 = r0.e.c(r13, r3, r5)     // Catch: java.lang.Throwable -> L24 r0.b -> L27
            android.content.Context r3 = r3.f12308a     // Catch: java.lang.Throwable -> L24 r0.b -> L27
            goto L3c
        L24:
            r13 = move-exception
            goto Lbc
        L27:
            r3 = move-exception
            java.lang.String r5 = "ProviderInstaller"
            java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L24
            java.lang.String r6 = "Failed to load providerinstaller module: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L24
            java.lang.String r3 = r6.concat(r3)     // Catch: java.lang.Throwable -> L24
            android.util.Log.w(r5, r3)     // Catch: java.lang.Throwable -> L24
            r3 = r4
        L3c:
            if (r3 == 0) goto L45
            java.lang.String r13 = "com.google.android.gms.providerinstaller.ProviderInstallerImpl"
            b(r3, r13)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            goto Lae
        L45:
            boolean r3 = d1.a.f6787d     // Catch: java.lang.Throwable -> L24
            int r5 = f0.g.e     // Catch: java.lang.Throwable -> L24
            r5 = 3
            java.lang.String r6 = "com.google.android.gms"
            android.content.Context r6 = r13.createPackageContext(r6, r5)     // Catch: java.lang.Throwable -> L24 android.content.pm.PackageManager.NameNotFoundException -> L51
            goto L52
        L51:
            r6 = r4
        L52:
            if (r6 != 0) goto L55
            goto La6
        L55:
            r4 = 1
            d1.a.f6787d = r4     // Catch: java.lang.Throwable -> L24
            if (r3 != 0) goto La5
            long r7 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.ClassLoader r3 = r6.getClassLoader()     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.Class<android.content.Context> r9 = android.content.Context.class
            t1.c r10 = new t1.c     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r11 = 10
            r12 = 0
            r10.<init>(r9, r13, r11, r12)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            x0.b r13 = new x0.b     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r13.<init>(r9, r0, r11, r12)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            x0.b r0 = new x0.b     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.Long r1 = java.lang.Long.valueOf(r7)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r0.<init>(r9, r1, r11, r12)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            t1.c[] r1 = new t1.c[r5]     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r1[r12] = r10     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r1[r4] = r13     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            r13 = 2
            r1[r13] = r0     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.String r13 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.Class r13 = r3.loadClass(r13)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            java.lang.String r0 = "reportRequestStats2"
            com.google.android.gms.internal.measurement.a4.N(r13, r0, r1)     // Catch: java.lang.Throwable -> L24 java.lang.Exception -> L95
            goto La5
        L95:
            r13 = move-exception
            java.lang.String r0 = "ProviderInstaller"
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> L24
            java.lang.String r1 = "Failed to report request stats: "
            java.lang.String r13 = r1.concat(r13)     // Catch: java.lang.Throwable -> L24
            android.util.Log.w(r0, r13)     // Catch: java.lang.Throwable -> L24
        La5:
            r4 = r6
        La6:
            if (r4 == 0) goto Laf
            java.lang.String r13 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            b(r4, r13)     // Catch: java.lang.Throwable -> L24
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
        Lae:
            return
        Laf:
            java.lang.String r13 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r13, r0)     // Catch: java.lang.Throwable -> L24
            e0.m r13 = new e0.m     // Catch: java.lang.Throwable -> L24
            r13.<init>()     // Catch: java.lang.Throwable -> L24
            throw r13     // Catch: java.lang.Throwable -> L24
        Lbc:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L24
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.a.a(android.content.Context):void");
    }

    public static void b(Context context, String str) throws IllegalAccessException, m, IllegalArgumentException, InvocationTargetException {
        try {
            if (f6786c == null) {
                f6786c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            f6786c.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e.toString() : cause.toString())));
            }
            throw new m();
        }
    }
}

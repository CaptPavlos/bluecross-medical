package e0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public int f7620a;

    /* renamed from: b, reason: collision with root package name */
    public int f7621b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7622c;

    public o(int i10, int i11) {
        this.f7622c = null;
        this.f7620a = i10;
        int i12 = i11 & 7;
        this.f7621b = i12 == 0 ? 8 : i12;
    }

    public synchronized int a() {
        PackageInfo packageInfoB;
        if (this.f7620a == 0) {
            try {
                packageInfoB = p0.c.a((Context) this.f7622c).b(0, "com.google.android.gms");
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("Metadata", "Failed to find package ".concat(e.toString()));
                packageInfoB = null;
            }
            if (packageInfoB != null) {
                this.f7620a = packageInfoB.versionCode;
            }
        }
        return this.f7620a;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0050 A[Catch: all -> 0x002e, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0007, B:9:0x0025, B:14:0x0030, B:16:0x0037, B:18:0x0049, B:26:0x006a, B:21:0x0050, B:23:0x0063, B:29:0x006e, B:33:0x007d), top: B:38:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int b() {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.f7621b     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L7
            monitor-exit(r5)
            return r0
        L7:
            java.lang.Object r0 = r5.f7622c     // Catch: java.lang.Throwable -> L2e
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Throwable -> L2e
            android.content.pm.PackageManager r1 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            p0.b r0 = p0.c.a(r0)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "com.google.android.c2dm.permission.SEND"
            java.lang.String r3 = "com.google.android.gms"
            android.content.Context r0 = r0.f11875a     // Catch: java.lang.Throwable -> L2e
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L2e
            int r0 = r0.checkPermission(r2, r3)     // Catch: java.lang.Throwable -> L2e
            r2 = -1
            r3 = 0
            if (r0 != r2) goto L30
            java.lang.String r0 = "Metadata"
            java.lang.String r1 = "Google Play services missing or without correct permission."
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r3
        L2e:
            r0 = move-exception
            goto L81
        L30:
            boolean r0 = n0.b.a()     // Catch: java.lang.Throwable -> L2e
            r2 = 1
            if (r0 != 0) goto L50
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.c2dm.intent.REGISTER"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.gms"
            r0.setPackage(r4)     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r1.queryIntentServices(r0, r3)     // Catch: java.lang.Throwable -> L2e
            if (r0 == 0) goto L50
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L50
            goto L6a
        L50:
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.iid.TOKEN_REQUEST"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "com.google.android.gms"
            r0.setPackage(r4)     // Catch: java.lang.Throwable -> L2e
            java.util.List r0 = r1.queryBroadcastReceivers(r0, r3)     // Catch: java.lang.Throwable -> L2e
            r1 = 2
            if (r0 == 0) goto L6e
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L2e
            if (r0 != 0) goto L6e
            r2 = r1
        L6a:
            r5.f7621b = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L6e:
            java.lang.String r0 = "Metadata"
            java.lang.String r3 = "Failed to resolve IID implementation package, falling back"
            android.util.Log.w(r0, r3)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = n0.b.a()     // Catch: java.lang.Throwable -> L2e
            if (r2 == r0) goto L7c
            goto L7d
        L7c:
            r2 = r1
        L7d:
            r5.f7621b = r2     // Catch: java.lang.Throwable -> L2e
            monitor-exit(r5)
            return r2
        L81:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2e
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e0.o.b():int");
    }

    public o() {
        this.f7622c = new o[256];
        this.f7620a = 0;
        this.f7621b = 0;
    }

    public o(Context context) {
        this.f7621b = 0;
        this.f7622c = context;
    }
}

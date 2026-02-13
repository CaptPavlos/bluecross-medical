package c1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x3 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public final w3 f1571c;

    /* renamed from: d, reason: collision with root package name */
    public i0 f1572d;
    public volatile Boolean e;
    public final t3 f;
    public ScheduledExecutorService g;
    public final s0 h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1573i;

    /* renamed from: j, reason: collision with root package name */
    public final t3 f1574j;

    public x3(u1 u1Var) {
        super(u1Var);
        this.f1573i = new ArrayList();
        this.h = new s0(u1Var.f1481k);
        this.f1571c = new w3(this);
        this.f = new t3(this, u1Var, 0);
        this.f1574j = new t3(this, u1Var, 1);
    }

    @Override // c1.h0
    public final boolean j() {
        return false;
    }

    public final void k(AtomicReference atomicReference) {
        g();
        h();
        u(new y1(this, atomicReference, w(false)));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.os.Bundle r8) {
        /*
            r7 = this;
            r7.g()
            r7.h()
            c1.u r4 = new c1.u
            r4.<init>(r8)
            r7.s()
            c1.u1 r0 = r7.f1149a
            c1.g r1 = r0.f1478d
            r2 = 0
            c1.e0 r3 = c1.f0.f1161c1
            boolean r1 = r1.q(r2, r3)
            r2 = 0
            if (r1 == 0) goto L55
            c1.p0 r0 = r0.o()
            c1.u1 r1 = r0.f1149a
            c1.b5 r3 = r1.f1479i
            c1.w0 r1 = r1.f
            c1.u1.k(r3)
            byte[] r3 = c1.b5.L(r4)
            if (r3 != 0) goto L3b
            c1.u1.m(r1)
            c1.u0 r0 = r1.g
            java.lang.String r1 = "Null default event parameters; not writing to database"
            r0.b(r1)
        L39:
            r0 = r2
            goto L50
        L3b:
            int r5 = r3.length
            r6 = 131072(0x20000, float:1.83671E-40)
            if (r5 <= r6) goto L4b
            c1.u1.m(r1)
            c1.u0 r0 = r1.g
            java.lang.String r1 = "Default event parameters too long for local database. Sending directly to service"
            r0.b(r1)
            goto L39
        L4b:
            r1 = 4
            boolean r0 = r0.n(r1, r3)
        L50:
            if (r0 == 0) goto L55
            r0 = 1
            r3 = r0
            goto L56
        L55:
            r3 = r2
        L56:
            c1.d5 r2 = r7.w(r2)
            c1.s2 r0 = new c1.s2
            r1 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r7.u(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x3.l(android.os.Bundle):void");
    }

    public final void m() {
        g();
        h();
        if (x()) {
            return;
        }
        if (n()) {
            this.f1571c.b();
            return;
        }
        u1 u1Var = this.f1149a;
        if (u1Var.f1478d.j()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = u1Var.f1475a.getPackageManager().queryIntentServices(new Intent().setClassName(u1Var.f1475a, "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(u1Var.f1475a, "com.google.android.gms.measurement.AppMeasurementService"));
        w3 w3Var = this.f1571c;
        x3 x3Var = w3Var.f1554c;
        x3Var.g();
        Context context = x3Var.f1149a.f1475a;
        m0.a aVarB = m0.a.b();
        synchronized (w3Var) {
            try {
                boolean z9 = w3Var.f1552a;
                x3 x3Var2 = w3Var.f1554c;
                if (z9) {
                    w0 w0Var2 = x3Var2.f1149a.f;
                    u1.m(w0Var2);
                    w0Var2.f1545n.b("Connection attempt already in progress");
                } else {
                    w0 w0Var3 = x3Var2.f1149a.f;
                    u1.m(w0Var3);
                    w0Var3.f1545n.b("Using local app measurement service");
                    w3Var.f1552a = true;
                    aVarB.a(context, intent, x3Var2.f1571c, TsExtractor.TS_STREAM_TYPE_AC3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n() throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x3.n():boolean");
    }

    public final void o() {
        g();
        h();
        w3 w3Var = this.f1571c;
        if (w3Var.f1553b != null && (w3Var.f1553b.h() || w3Var.f1553b.e())) {
            w3Var.f1553b.o();
        }
        w3Var.f1553b = null;
        try {
            m0.a.b().c(this.f1149a.f1475a, w3Var);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f1572d = null;
    }

    public final boolean p() {
        g();
        h();
        if (!n()) {
            return true;
        }
        b5 b5Var = this.f1149a.f1479i;
        u1.k(b5Var);
        return b5Var.N() >= ((Integer) f0.K0.a(null)).intValue();
    }

    public final boolean q() {
        g();
        h();
        if (!n()) {
            return true;
        }
        b5 b5Var = this.f1149a.f1479i;
        u1.k(b5Var);
        return b5Var.N() >= 241200;
    }

    public final void r(ComponentName componentName) {
        g();
        if (this.f1572d != null) {
            this.f1572d = null;
            w0 w0Var = this.f1149a.f;
            u1.m(w0Var);
            w0Var.f1545n.c(componentName, "Disconnected from device MeasurementService");
            g();
            m();
        }
    }

    public final void s() {
        this.f1149a.getClass();
    }

    public final void t() {
        g();
        s0 s0Var = this.h;
        ((n0.a) s0Var.f1448b).getClass();
        s0Var.f1447a = SystemClock.elapsedRealtime();
        this.f1149a.getClass();
        this.f.b(((Long) f0.Z.a(null)).longValue());
    }

    public final void u(Runnable runnable) {
        g();
        if (x()) {
            runnable.run();
            return;
        }
        ArrayList arrayList = this.f1573i;
        long size = arrayList.size();
        u1 u1Var = this.f1149a;
        u1Var.getClass();
        if (size >= 1000) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Discarding data. Max runnable queue size reached");
        } else {
            arrayList.add(runnable);
            this.f1574j.b(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
            m();
        }
    }

    public final void v() {
        g();
        u1 u1Var = this.f1149a;
        w0 w0Var = u1Var.f;
        u1.m(w0Var);
        u0 u0Var = w0Var.f1545n;
        ArrayList arrayList = this.f1573i;
        u0Var.c(Integer.valueOf(arrayList.size()), "Processing queued up service tasks");
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            try {
                ((Runnable) obj).run();
            } catch (RuntimeException e) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f.c(e, "Task exception while flushing queue");
            }
        }
        arrayList.clear();
        this.f1574j.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final c1.d5 w(boolean r11) {
        /*
            r10 = this;
            c1.u1 r0 = r10.f1149a
            r0.getClass()
            c1.n0 r1 = r0.r()
            r2 = 0
            if (r11 == 0) goto Lc4
            c1.w0 r11 = r0.f
            c1.u1.m(r11)
            c1.u1 r11 = r11.f1149a
            c1.h1 r0 = r11.e
            c1.u1.k(r0)
            c1.f1 r0 = r0.e
            if (r0 != 0) goto L1e
            goto Lc4
        L1e:
            c1.h1 r11 = r11.e
            c1.u1.k(r11)
            c1.f1 r11 = r11.e
            c1.g2 r0 = r11.e
            c1.h1 r0 = (c1.h1) r0
            r0.g()
            r0.g()
            c1.g2 r3 = r11.e
            c1.h1 r3 = (c1.h1) r3
            android.content.SharedPreferences r3 = r3.k()
            java.lang.Object r4 = r11.f1210b
            java.lang.String r4 = (java.lang.String) r4
            r5 = 0
            long r3 = r3.getLong(r4, r5)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L4a
            r11.b()
            r3 = r5
            goto L5a
        L4a:
            c1.u1 r7 = r0.f1149a
            n0.a r7 = r7.f1481k
            r7.getClass()
            long r7 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r7
            long r3 = java.lang.Math.abs(r3)
        L5a:
            long r7 = r11.f1209a
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L62
        L60:
            r11 = r2
            goto L99
        L62:
            long r7 = r7 + r7
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 <= 0) goto L6b
            r11.b()
            goto L60
        L6b:
            java.io.Serializable r3 = r11.f1212d
            java.lang.String r3 = (java.lang.String) r3
            android.content.SharedPreferences r4 = r0.k()
            java.lang.String r3 = r4.getString(r3, r2)
            java.io.Serializable r4 = r11.f1211c
            java.lang.String r4 = (java.lang.String) r4
            android.content.SharedPreferences r0 = r0.k()
            long r7 = r0.getLong(r4, r5)
            r11.b()
            if (r3 == 0) goto L97
            int r11 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r11 > 0) goto L8d
            goto L97
        L8d:
            android.util.Pair r11 = new android.util.Pair
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            r11.<init>(r3, r0)
            goto L99
        L97:
            android.util.Pair r11 = c1.h1.f1243z
        L99:
            if (r11 == 0) goto Lc4
            android.util.Pair r0 = c1.h1.f1243z
            if (r11 != r0) goto La0
            goto Lc4
        La0:
            java.lang.Object r0 = r11.second
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.Object r11 = r11.first
            java.lang.String r11 = (java.lang.String) r11
            int r2 = r0.length()
            java.lang.String r3 = java.lang.String.valueOf(r11)
            int r2 = r2 + 1
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r2 = r2 + r3
            r4.<init>(r2)
            java.lang.String r2 = ":"
            java.lang.String r2 = androidx.constraintlayout.core.widgets.analyzer.a.y(r4, r0, r2, r11)
        Lc4:
            c1.d5 r11 = r1.k(r2)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x3.w(boolean):c1.d5");
    }

    public final boolean x() {
        g();
        h();
        return this.f1572d != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x02d2 A[Catch: all -> 0x01fa, SQLiteException -> 0x02ac, SQLiteDatabaseLockedException -> 0x02b1, SQLiteFullException -> 0x02b5, TryCatch #57 {all -> 0x01fa, blocks: (B:102:0x01d5, B:104:0x01e9, B:106:0x01ee, B:119:0x0212, B:120:0x0215, B:118:0x020e, B:123:0x021b, B:125:0x022f, B:132:0x0247, B:133:0x0250, B:134:0x0253, B:130:0x0241, B:137:0x0257, B:139:0x026b, B:146:0x0283, B:147:0x028d, B:148:0x0290, B:144:0x027d, B:151:0x0294, B:155:0x02a8, B:170:0x02d2, B:171:0x02dc, B:172:0x02df, B:168:0x02cc, B:180:0x02ee, B:181:0x02f9, B:206:0x035c), top: B:420:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x043a A[Catch: all -> 0x0476, TRY_ENTER, TryCatch #54 {all -> 0x0476, blocks: (B:269:0x0466, B:259:0x043a, B:261:0x0440, B:262:0x0443, B:279:0x0487, B:208:0x0371, B:210:0x037b, B:215:0x038c), top: B:416:0x0466 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0472 A[PHI: r5 r6 r24 r25 r27 r37 r38
      0x0472: PHI (r5v15 android.database.sqlite.SQLiteDatabase) = 
      (r5v12 android.database.sqlite.SQLiteDatabase)
      (r5v13 android.database.sqlite.SQLiteDatabase)
      (r5v16 android.database.sqlite.SQLiteDatabase)
     binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r6v5 int) = (r6v3 int), (r6v3 int), (r6v6 int) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r24v9 int) = (r24v6 int), (r24v7 int), (r24v10 int) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r25v9 java.lang.String) = (r25v6 java.lang.String), (r25v7 java.lang.String), (r25v10 java.lang.String) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r27v9 java.lang.String) = (r27v6 java.lang.String), (r27v7 java.lang.String), (r27v10 java.lang.String) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r37v9 int) = (r37v6 int), (r37v7 int), (r37v10 int) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]
      0x0472: PHI (r38v9 java.lang.String) = (r38v6 java.lang.String), (r38v7 java.lang.String), (r38v10 java.lang.String) binds: [B:265:0x0455, B:282:0x0499, B:273:0x0470] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:476:0x049c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x049c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(c1.i0 r67, j0.a r68, c1.d5 r69) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.x3.y(c1.i0, j0.a, c1.d5):void");
    }

    public final void z(e eVar) {
        boolean zN;
        g();
        h();
        u1 u1Var = this.f1149a;
        u1Var.getClass();
        p0 p0VarO = u1Var.o();
        u1 u1Var2 = p0VarO.f1149a;
        u1.k(u1Var2.f1479i);
        byte[] bArrL = b5.L(eVar);
        if (bArrL.length > 131072) {
            w0 w0Var = u1Var2.f;
            u1.m(w0Var);
            w0Var.g.b("Conditional user property too long for local database. Sending directly to service");
            zN = false;
        } else {
            zN = p0VarO.n(2, bArrL);
        }
        u(new r3(this, w(true), zN, new e(eVar)));
    }
}

package c1;

import android.content.SharedPreferences;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public long f1209a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1210b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f1211c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f1212d;
    public final /* synthetic */ g2 e;

    public /* synthetic */ f1(h1 h1Var, long j10) {
        this.e = h1Var;
        i0.y.d("health_monitor");
        i0.y.b(j10 > 0);
        this.f1210b = "health_monitor:start";
        this.f1211c = "health_monitor:count";
        this.f1212d = "health_monitor:value";
        this.f1209a = j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(long r11, com.google.android.gms.internal.measurement.c3 r13) {
        /*
            r10 = this;
            java.io.Serializable r0 = r10.f1212d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto Ld
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f1212d = r0
        Ld:
            java.io.Serializable r0 = r10.f1211c
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto L1a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.f1211c = r0
        L1a:
            java.io.Serializable r0 = r10.f1212d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L45
            java.io.Serializable r0 = r10.f1212d
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.c3 r0 = (com.google.android.gms.internal.measurement.c3) r0
            long r2 = r0.u()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r6 = 60
            long r2 = r2 / r6
            long r2 = r2 / r6
            long r8 = r13.u()
            long r8 = r8 / r4
            long r8 = r8 / r6
            long r8 = r8 / r6
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 != 0) goto Lcc
        L45:
            long r2 = r10.f1209a
            int r0 = r13.k()
            long r4 = (long) r0
            long r2 = r2 + r4
            c1.g2 r0 = r10.e
            c1.v4 r0 = (c1.v4) r0
            c1.g r4 = r0.e0()
            c1.e0 r5 = c1.f0.f1166e1
            r6 = 0
            boolean r4 = r4.q(r6, r5)
            if (r4 == 0) goto L81
            java.io.Serializable r4 = r10.f1212d
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L9a
            r0.e0()
            c1.e0 r4 = c1.f0.f1176j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto Lcc
            goto L9a
        L81:
            r0.e0()
            c1.e0 r4 = c1.f0.f1176j
            java.lang.Object r4 = r4.a(r6)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            int r4 = java.lang.Math.max(r1, r4)
            long r4 = (long) r4
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L9a
            goto Lcc
        L9a:
            r10.f1209a = r2
            java.io.Serializable r2 = r10.f1212d
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.add(r13)
            java.io.Serializable r13 = r10.f1211c
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Long r11 = java.lang.Long.valueOf(r11)
            r13.add(r11)
            java.io.Serializable r11 = r10.f1212d
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            int r11 = r11.size()
            r0.e0()
            c1.e0 r12 = c1.f0.f1179k
            java.lang.Object r12 = r12.a(r6)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r13 = 1
            int r12 = java.lang.Math.max(r13, r12)
            if (r11 < r12) goto Lcd
        Lcc:
            return r1
        Lcd:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.f1.a(long, com.google.android.gms.internal.measurement.c3):boolean");
    }

    public void b() {
        h1 h1Var = (h1) this.e;
        h1Var.g();
        h1Var.f1149a.f1481k.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = h1Var.k().edit();
        editorEdit.remove((String) this.f1211c);
        editorEdit.remove((String) this.f1212d);
        editorEdit.putLong((String) this.f1210b, jCurrentTimeMillis);
        editorEdit.apply();
    }
}

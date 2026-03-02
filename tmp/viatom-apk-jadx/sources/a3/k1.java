package a3;

import android.util.Log;
import androidx.datastore.core.DataStore;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k1 {

    /* renamed from: a, reason: collision with root package name */
    public final d3.j f122a;

    /* renamed from: b, reason: collision with root package name */
    public final a1 f123b;

    /* renamed from: c, reason: collision with root package name */
    public final y0 f124c;

    /* renamed from: d, reason: collision with root package name */
    public final o1 f125d;
    public final DataStore e;
    public final j0 f;
    public final w6.h g;
    public o0 h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f126i;

    /* renamed from: j, reason: collision with root package name */
    public String f127j;

    public k1(d3.j jVar, a1 a1Var, y0 y0Var, o1 o1Var, DataStore dataStore, j0 j0Var, w6.h hVar) {
        jVar.getClass();
        a1Var.getClass();
        y0Var.getClass();
        o1Var.getClass();
        dataStore.getClass();
        j0Var.getClass();
        hVar.getClass();
        this.f122a = jVar;
        this.f123b = a1Var;
        this.f124c = y0Var;
        this.f125d = o1Var;
        this.e = dataStore;
        this.f = j0Var;
        this.g = hVar;
        this.f127j = "";
        r7.y.q(r7.y.a(hVar), null, null, new g1(this, null, 0), 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(a3.k1 r4, java.lang.String r5, a3.h1 r6, w6.c r7) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.k1.a(a3.k1, java.lang.String, a3.h1, w6.c):java.lang.Object");
    }

    public final void b() {
        this.f126i = false;
        if (this.h == null) {
            Log.d("FirebaseSessions", "App backgrounded, but local SessionData not initialized");
            return;
        }
        Log.d("FirebaseSessions", "App backgrounded on " + this.f.a());
        r7.y.q(r7.y.a(this.g), null, null, new g1(this, null, 1), 3);
    }

    public final boolean c(o0 o0Var) {
        Map map = o0Var.f147c;
        boolean z9 = true;
        j0 j0Var = this.f;
        if (map == null) {
            Log.d("FirebaseSessions", "No process data for " + j0Var.a());
            return true;
        }
        j0Var.getClass();
        g0 g0Var = (g0) map.get(j0Var.a());
        if (g0Var != null && g0Var.f71a == j0Var.f108c && kotlin.jvm.internal.l.a(g0Var.f72b, (String) j0Var.f109d.getValue())) {
            z9 = false;
        }
        if (z9) {
            Log.d("FirebaseSessions", "Process " + j0Var.a() + " is stale");
        }
        return z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(a3.o0 r12) {
        /*
            r11 = this;
            a3.n1 r0 = r12.f146b
            a3.t0 r12 = r12.f145a
            java.lang.String r1 = "Session "
            java.lang.String r2 = "FirebaseSessions"
            r3 = 0
            if (r0 == 0) goto L77
            a3.o1 r4 = r11.f125d
            r4.getClass()
            a3.n1 r4 = a3.o1.a()
            int r5 = p7.a.f12038d
            long r4 = r4.f137a
            long r6 = r0.f137a
            long r4 = r4 - r6
            p7.c r0 = p7.c.MILLISECONDS
            long r4 = l1.b.P(r4, r0)
            d3.j r0 = r11.f122a
            d3.o r6 = r0.f6825a
            p7.a r6 = r6.b()
            r7 = 0
            if (r6 == 0) goto L3a
            long r9 = r6.f12039a
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 <= 0) goto L3a
            boolean r6 = p7.a.e(r9)
            if (r6 != 0) goto L3a
            goto L57
        L3a:
            d3.o r0 = r0.f6826b
            p7.a r0 = r0.b()
            if (r0 == 0) goto L4f
            long r9 = r0.f12039a
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 <= 0) goto L4f
            boolean r0 = p7.a.e(r9)
            if (r0 != 0) goto L4f
            goto L57
        L4f:
            r0 = 30
            p7.c r6 = p7.c.MINUTES
            long r9 = l1.b.O(r0, r6)
        L57:
            int r0 = p7.a.c(r4, r9)
            if (r0 <= 0) goto L5e
            r3 = 1
        L5e:
            if (r3 == 0) goto L76
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f161a
            r0.append(r12)
            java.lang.String r12 = " is expired"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
        L76:
            return r3
        L77:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r12 = r12.f161a
            r0.append(r12)
            java.lang.String r12 = " has not backgrounded yet"
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            android.util.Log.d(r2, r12)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.k1.d(a3.o0):boolean");
    }
}

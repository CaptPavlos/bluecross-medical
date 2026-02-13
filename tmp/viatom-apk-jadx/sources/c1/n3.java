package c1;

import android.os.Bundle;
import android.os.SystemClock;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n3 extends h0 {

    /* renamed from: c, reason: collision with root package name */
    public volatile k3 f1367c;

    /* renamed from: d, reason: collision with root package name */
    public volatile k3 f1368d;
    public k3 e;
    public final ConcurrentHashMap f;
    public com.google.android.gms.internal.measurement.x0 g;
    public volatile boolean h;

    /* renamed from: i, reason: collision with root package name */
    public volatile k3 f1369i;

    /* renamed from: j, reason: collision with root package name */
    public k3 f1370j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1371k;

    /* renamed from: l, reason: collision with root package name */
    public final Object f1372l;

    public n3(u1 u1Var) {
        super(u1Var);
        this.f1372l = new Object();
        this.f = new ConcurrentHashMap();
    }

    @Override // c1.h0
    public final boolean j() {
        return false;
    }

    public final void k(k3 k3Var, boolean z9, long j10) {
        u1 u1Var = this.f1149a;
        z zVar = u1Var.f1484n;
        u1.j(zVar);
        u1Var.f1481k.getClass();
        zVar.j(SystemClock.elapsedRealtime());
        boolean z10 = k3Var != null && k3Var.f1307d;
        g4 g4Var = u1Var.h;
        u1.l(g4Var);
        if (!g4Var.f.a(j10, z10, z9) || k3Var == null) {
            return;
        }
        k3Var.f1307d = false;
    }

    public final k3 l(com.google.android.gms.internal.measurement.x0 x0Var) {
        i0.y.g(x0Var);
        Integer numValueOf = Integer.valueOf(x0Var.f2254a);
        ConcurrentHashMap concurrentHashMap = this.f;
        k3 k3Var = (k3) concurrentHashMap.get(numValueOf);
        if (k3Var == null) {
            String strN = n(x0Var.f2255b);
            b5 b5Var = this.f1149a.f1479i;
            u1.k(b5Var);
            k3 k3Var2 = new k3(null, strN, b5Var.d0());
            concurrentHashMap.put(numValueOf, k3Var2);
            k3Var = k3Var2;
        }
        return this.f1369i != null ? this.f1369i : k3Var;
    }

    public final k3 m(boolean z9) {
        h();
        g();
        k3 k3Var = this.e;
        return (z9 && k3Var == null) ? this.f1370j : k3Var;
    }

    public final String n(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] strArrSplit = str.split("\\.");
        int length = strArrSplit.length;
        String str2 = length > 0 ? strArrSplit[length - 1] : "";
        int length2 = str2.length();
        u1 u1Var = this.f1149a;
        u1Var.f1478d.getClass();
        if (length2 <= 500) {
            return str2;
        }
        u1Var.f1478d.getClass();
        return str2.substring(0, 500);
    }

    public final void o(com.google.android.gms.internal.measurement.x0 x0Var, Bundle bundle) {
        Bundle bundle2;
        if (!this.f1149a.f1478d.u() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f.put(Integer.valueOf(x0Var.f2254a), new k3(bundle2.getString(RewardPlus.NAME), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void p(String str, k3 k3Var, boolean z9) {
        k3 k3Var2;
        k3 k3Var3 = this.f1367c == null ? this.f1368d : this.f1367c;
        if (k3Var.f1305b == null) {
            k3Var2 = new k3(k3Var.f1304a, str != null ? n(str) : null, k3Var.f1306c, k3Var.e, k3Var.f);
        } else {
            k3Var2 = k3Var;
        }
        this.f1368d = this.f1367c;
        this.f1367c = k3Var2;
        u1 u1Var = this.f1149a;
        u1Var.f1481k.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        r1 r1Var = u1Var.g;
        u1.m(r1Var);
        r1Var.p(new l3(this, k3Var2, k3Var3, jElapsedRealtime, z9));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(c1.k3 r18, c1.k3 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.n3.q(c1.k3, c1.k3, long, boolean, android.os.Bundle):void");
    }
}

package c1;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f1613b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f1614c;

    /* renamed from: d, reason: collision with root package name */
    public long f1615d;

    public z(u1 u1Var) {
        super(u1Var);
        this.f1614c = new ArrayMap();
        this.f1613b = new ArrayMap();
    }

    public final void h(long j10, String str) {
        u1 u1Var = this.f1149a;
        if (str == null || str.length() == 0) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Ad unit id must be a non-empty string");
        } else {
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.p(new a(this, str, j10, 0));
        }
    }

    public final void i(long j10, String str) {
        u1 u1Var = this.f1149a;
        if (str == null || str.length() == 0) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f.b("Ad unit id must be a non-empty string");
        } else {
            r1 r1Var = u1Var.g;
            u1.m(r1Var);
            r1Var.p(new a(this, str, j10, 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(long j10) {
        n3 n3Var = this.f1149a.f1482l;
        u1.l(n3Var);
        k3 k3VarM = n3Var.m(false);
        ArrayMap arrayMap = this.f1613b;
        for (K k10 : arrayMap.keySet()) {
            l(k10, j10 - ((Long) arrayMap.get(k10)).longValue(), k3VarM);
        }
        if (!arrayMap.isEmpty()) {
            k(j10 - this.f1615d, k3VarM);
        }
        m(j10);
    }

    public final void k(long j10, k3 k3Var) {
        u1 u1Var = this.f1149a;
        if (k3Var == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1545n.b("Not logging ad exposure. No active activity");
        } else if (j10 < 1000) {
            w0 w0Var2 = u1Var.f;
            u1.m(w0Var2);
            w0Var2.f1545n.c(Long.valueOf(j10), "Not logging ad exposure. Less than 1000 ms. exposure");
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j10);
            b5.Y(k3Var, bundle, true);
            c3 c3Var = u1Var.f1483m;
            u1.l(c3Var);
            c3Var.n("am", "_xa", bundle);
        }
    }

    public final void l(String str, long j10, k3 k3Var) {
        u1 u1Var = this.f1149a;
        if (k3Var == null) {
            w0 w0Var = u1Var.f;
            u1.m(w0Var);
            w0Var.f1545n.b("Not logging ad unit exposure. No active activity");
        } else {
            if (j10 < 1000) {
                w0 w0Var2 = u1Var.f;
                u1.m(w0Var2);
                w0Var2.f1545n.c(Long.valueOf(j10), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j10);
            b5.Y(k3Var, bundle, true);
            c3 c3Var = u1Var.f1483m;
            u1.l(c3Var);
            c3Var.n("am", "_xu", bundle);
        }
    }

    public final void m(long j10) {
        ArrayMap arrayMap = this.f1613b;
        Iterator it = arrayMap.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j10));
        }
        if (arrayMap.isEmpty()) {
            return;
        }
        this.f1615d = j10;
    }
}

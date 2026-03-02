package a1;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import c1.b5;
import c1.c2;
import c1.c3;
import c1.k3;
import c1.n3;
import c1.r1;
import c1.s2;
import c1.u1;
import c1.w0;
import c1.y4;
import c1.z;
import i0.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import o2.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final u1 f17a;

    /* renamed from: b, reason: collision with root package name */
    public final c3 f18b;

    public a(u1 u1Var) {
        y.g(u1Var);
        this.f17a = u1Var;
        c3 c3Var = u1Var.f1483m;
        u1.l(c3Var);
        this.f18b = c3Var;
    }

    @Override // c1.d3
    public final void b(String str, String str2, Bundle bundle) {
        c3 c3Var = this.f18b;
        c3Var.f1149a.f1481k.getClass();
        c3Var.l(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // c1.d3
    public final String c() {
        n3 n3Var = this.f18b.f1149a.f1482l;
        u1.l(n3Var);
        k3 k3Var = n3Var.f1367c;
        if (k3Var != null) {
            return k3Var.f1304a;
        }
        return null;
    }

    @Override // c1.d3
    public final String d() {
        n3 n3Var = this.f18b.f1149a.f1482l;
        u1.l(n3Var);
        k3 k3Var = n3Var.f1367c;
        if (k3Var != null) {
            return k3Var.f1305b;
        }
        return null;
    }

    @Override // c1.d3
    public final void e(Bundle bundle) {
        c3 c3Var = this.f18b;
        c3Var.f1149a.f1481k.getClass();
        c3Var.t(bundle, System.currentTimeMillis());
    }

    @Override // c1.d3
    public final void f(String str) {
        u1 u1Var = this.f17a;
        z zVar = u1Var.f1484n;
        u1.j(zVar);
        u1Var.f1481k.getClass();
        zVar.i(SystemClock.elapsedRealtime(), str);
    }

    @Override // c1.d3
    public final void g(String str) {
        u1 u1Var = this.f17a;
        z zVar = u1Var.f1484n;
        u1.j(zVar);
        u1Var.f1481k.getClass();
        zVar.h(SystemClock.elapsedRealtime(), str);
    }

    @Override // c1.d3
    public final long h() {
        b5 b5Var = this.f17a.f1479i;
        u1.k(b5Var);
        return b5Var.d0();
    }

    @Override // c1.d3
    public final void i(String str, String str2, Bundle bundle) {
        c3 c3Var = this.f17a.f1483m;
        u1.l(c3Var);
        c3Var.u(str, str2, bundle);
    }

    @Override // c1.d3
    public final List j(String str, String str2) {
        c3 c3Var = this.f18b;
        u1 u1Var = c3Var.f1149a;
        r1 r1Var = u1Var.g;
        w0 w0Var = u1Var.f;
        u1.m(r1Var);
        if (r1Var.m()) {
            u1.m(w0Var);
            w0Var.f.b("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (e.c()) {
            u1.m(w0Var);
            w0Var.f.b("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.q(atomicReference, 5000L, "get conditional user properties", new c2(c3Var, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return b5.W(list);
        }
        u1.m(w0Var);
        w0Var.f.c(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // c1.d3
    public final int k(String str) {
        c3 c3Var = this.f18b;
        c3Var.getClass();
        y.d(str);
        c3Var.f1149a.getClass();
        return 25;
    }

    @Override // c1.d3
    public final String l() {
        return (String) this.f18b.g.get();
    }

    @Override // c1.d3
    public final String m() {
        return this.f18b.v();
    }

    @Override // c1.d3
    public final Map n(String str, String str2, boolean z9) {
        c3 c3Var = this.f18b;
        u1 u1Var = c3Var.f1149a;
        r1 r1Var = u1Var.g;
        w0 w0Var = u1Var.f;
        u1.m(r1Var);
        if (r1Var.m()) {
            u1.m(w0Var);
            w0Var.f.b("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (e.c()) {
            u1.m(w0Var);
            w0Var.f.b("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        r1 r1Var2 = u1Var.g;
        u1.m(r1Var2);
        r1Var2.q(atomicReference, 5000L, "get user properties", new s2(c3Var, atomicReference, str, str2, z9));
        List<y4> list = (List) atomicReference.get();
        if (list == null) {
            u1.m(w0Var);
            w0Var.f.c(Boolean.valueOf(z9), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (y4 y4Var : list) {
            Object objB = y4Var.b();
            if (objB != null) {
                arrayMap.put(y4Var.f1610b, objB);
            }
        }
        return arrayMap;
    }
}

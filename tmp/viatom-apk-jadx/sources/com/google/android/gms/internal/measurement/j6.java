package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j6 implements p6 {

    /* renamed from: a, reason: collision with root package name */
    public final u4 f2014a;

    /* renamed from: b, reason: collision with root package name */
    public final m5 f2015b;

    public j6(m5 m5Var, u4 u4Var) {
        m5 m5Var2 = h5.f1981a;
        this.f2015b = m5Var;
        this.f2014a = u4Var;
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final o5 a() {
        u4 u4Var = this.f2014a;
        if (u4Var instanceof o5) {
            return (o5) ((o5) u4Var).o(4);
        }
        n5 n5Var = (n5) ((o5) u4Var).o(5);
        boolean zE = n5Var.f2102b.e();
        o5 o5Var = n5Var.f2102b;
        if (!zE) {
            return o5Var;
        }
        o5Var.g();
        return n5Var.f2102b;
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void b(Object obj, Object obj2) {
        q6.b(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final int c(u4 u4Var) {
        v6 v6Var = ((o5) u4Var).zzc;
        int i10 = v6Var.f2208d;
        if (i10 != -1) {
            return i10;
        }
        int iM = 0;
        for (int i11 = 0; i11 < v6Var.f2205a; i11++) {
            int i12 = v6Var.f2206b[i11] >>> 3;
            c5 c5Var = (c5) v6Var.f2207c[i11];
            int iS = d5.s(8);
            int iS2 = d5.s(i12) + d5.s(16);
            int iS3 = d5.s(24);
            int iD = c5Var.d();
            iM += iS + iS + iS2 + androidx.constraintlayout.core.widgets.analyzer.a.m(iD, iD, iS3);
        }
        v6Var.f2208d = iM;
        return iM;
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void d(Object obj, c6 c6Var) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final boolean e(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final boolean f(o5 o5Var, o5 o5Var2) {
        return o5Var.zzc.equals(o5Var2.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void g(Object obj) {
        this.f2015b.getClass();
        v6 v6Var = ((o5) obj).zzc;
        if (v6Var.e) {
            v6Var.e = false;
        }
        m5 m5Var = h5.f1981a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final void h(Object obj, byte[] bArr, int i10, int i11, x4 x4Var) {
        o5 o5Var = (o5) obj;
        if (o5Var.zzc == v6.f) {
            o5Var.zzc = v6.a();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.p6
    public final int i(o5 o5Var) {
        return o5Var.zzc.hashCode();
    }
}

package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n1 extends o5 {
    private static final n1 zzi;
    private int zzb;
    private int zzd;
    private t5 zze;
    private t5 zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        n1 n1Var = new n1();
        zzi = n1Var;
        o5.m(n1.class, n1Var);
    }

    public n1() {
        n6 n6Var = n6.e;
        this.zze = n6Var;
        this.zzf = n6Var;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", w1.class, "zzf", p1.class, "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new n1();
        }
        if (i11 == 4) {
            return new m1(zzi);
        }
        if (i11 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final List r() {
        return this.zze;
    }

    public final int s() {
        return this.zze.size();
    }

    public final w1 t(int i10) {
        return (w1) this.zze.get(i10);
    }

    public final t5 u() {
        return this.zzf;
    }

    public final int v() {
        return this.zzf.size();
    }

    public final p1 w(int i10) {
        return (p1) this.zzf.get(i10);
    }

    public final void x(int i10, w1 w1Var) {
        t5 t5Var = this.zze;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zze = t5Var.k(size + size);
        }
        this.zze.set(i10, w1Var);
    }

    public final void y(int i10, p1 p1Var) {
        t5 t5Var = this.zzf;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zzf = t5Var.k(size + size);
        }
        this.zzf.set(i10, p1Var);
    }
}

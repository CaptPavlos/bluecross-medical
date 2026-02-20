package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 extends o5 {
    private static final p1 zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private t5 zzf = n6.e;
    private boolean zzg;
    private u1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        p1 p1Var = new p1();
        zzl = p1Var;
        o5.m(p1.class, p1Var);
    }

    public static o1 B() {
        return (o1) zzl.h();
    }

    public final boolean A() {
        return this.zzk;
    }

    public final /* synthetic */ void C(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final void D(int i10, r1 r1Var) {
        t5 t5Var = this.zzf;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zzf = t5Var.k(size + size);
        }
        this.zzf.set(i10, r1Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", r1.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i11 == 3) {
            return new p1();
        }
        if (i11 == 4) {
            return new o1(zzl);
        }
        if (i11 == 5) {
            return zzl;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final String r() {
        return this.zze;
    }

    public final List s() {
        return this.zzf;
    }

    public final int t() {
        return this.zzf.size();
    }

    public final r1 u(int i10) {
        return (r1) this.zzf.get(i10);
    }

    public final boolean v() {
        return (this.zzb & 8) != 0;
    }

    public final u1 w() {
        u1 u1Var = this.zzh;
        return u1Var == null ? u1.y() : u1Var;
    }

    public final boolean x() {
        return this.zzi;
    }

    public final boolean y() {
        return this.zzj;
    }

    public final boolean z() {
        return (this.zzb & 64) != 0;
    }
}

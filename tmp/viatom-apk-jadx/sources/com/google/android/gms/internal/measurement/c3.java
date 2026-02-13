package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c3 extends o5 {
    private static final c3 zzj;
    private int zzb;
    private t5 zzd = n6.e;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        c3 c3Var = new c3();
        zzj = c3Var;
        o5.m(c3.class, c3Var);
    }

    public static b3 z() {
        return (b3) zzj.h();
    }

    public final /* synthetic */ void A(int i10, f3 f3Var) {
        J();
        this.zzd.set(i10, f3Var);
    }

    public final /* synthetic */ void B(f3 f3Var) {
        f3Var.getClass();
        J();
        this.zzd.add(f3Var);
    }

    public final /* synthetic */ void C(Iterable iterable) {
        J();
        u4.c(iterable, this.zzd);
    }

    public final void D() {
        this.zzd = n6.e;
    }

    public final /* synthetic */ void E(int i10) {
        J();
        this.zzd.remove(i10);
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void G(long j10) {
        this.zzb |= 2;
        this.zzf = j10;
    }

    public final /* synthetic */ void H(long j10) {
        this.zzb |= 4;
        this.zzg = j10;
    }

    public final /* synthetic */ void I(long j10) {
        this.zzb |= 16;
        this.zzi = j10;
    }

    public final void J() {
        t5 t5Var = this.zzd;
        if (((v4) t5Var).f2204a) {
            return;
        }
        int size = t5Var.size();
        this.zzd = t5Var.k(size + size);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", f3.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i11 == 3) {
            return new c3();
        }
        if (i11 == 4) {
            return new b3(zzj);
        }
        if (i11 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final int q() {
        return this.zzd.size();
    }

    public final f3 r(int i10) {
        return (f3) this.zzd.get(i10);
    }

    public final String s() {
        return this.zze;
    }

    public final boolean t() {
        return (this.zzb & 2) != 0;
    }

    public final long u() {
        return this.zzf;
    }

    public final boolean v() {
        return (this.zzb & 4) != 0;
    }

    public final long w() {
        return this.zzg;
    }

    public final boolean x() {
        return (this.zzb & 8) != 0;
    }

    public final int y() {
        return this.zzh;
    }
}

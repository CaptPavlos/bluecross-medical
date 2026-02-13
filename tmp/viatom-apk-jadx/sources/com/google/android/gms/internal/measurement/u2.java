package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u2 extends o5 {
    private static final u2 zzh;
    private int zzb;
    private int zzd;
    private n3 zze;
    private n3 zzf;
    private boolean zzg;

    static {
        u2 u2Var = new u2();
        zzh = u2Var;
        o5.m(u2.class, u2Var);
    }

    public static t2 w() {
        return (t2) zzh.h();
    }

    public final /* synthetic */ void A(boolean z9) {
        this.zzb |= 8;
        this.zzg = z9;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new u2();
        }
        if (i11 == 4) {
            return new t2(zzh);
        }
        if (i11 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final n3 r() {
        n3 n3Var = this.zze;
        return n3Var == null ? n3.y() : n3Var;
    }

    public final boolean s() {
        return (this.zzb & 4) != 0;
    }

    public final n3 t() {
        n3 n3Var = this.zzf;
        return n3Var == null ? n3.y() : n3Var;
    }

    public final boolean u() {
        return (this.zzb & 8) != 0;
    }

    public final boolean v() {
        return this.zzg;
    }

    public final /* synthetic */ void x(int i10) {
        this.zzb |= 1;
        this.zzd = i10;
    }

    public final /* synthetic */ void y(n3 n3Var) {
        this.zze = n3Var;
        this.zzb |= 2;
    }

    public final /* synthetic */ void z(n3 n3Var) {
        this.zzf = n3Var;
        this.zzb |= 4;
    }
}

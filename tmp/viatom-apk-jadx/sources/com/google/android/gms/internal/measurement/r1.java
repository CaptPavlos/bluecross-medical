package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r1 extends o5 {
    private static final r1 zzh;
    private int zzb;
    private x1 zzd;
    private u1 zze;
    private boolean zzf;
    private String zzg = "";

    static {
        r1 r1Var = new r1();
        zzh = r1Var;
        o5.m(r1.class, r1Var);
    }

    public static r1 x() {
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i11 == 3) {
            return new r1();
        }
        if (i11 == 4) {
            return new q1(zzh);
        }
        if (i11 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final x1 q() {
        x1 x1Var = this.zzd;
        return x1Var == null ? x1.w() : x1Var;
    }

    public final boolean r() {
        return (this.zzb & 2) != 0;
    }

    public final u1 s() {
        u1 u1Var = this.zze;
        return u1Var == null ? u1.y() : u1Var;
    }

    public final boolean t() {
        return (this.zzb & 4) != 0;
    }

    public final boolean u() {
        return this.zzf;
    }

    public final boolean v() {
        return (this.zzb & 8) != 0;
    }

    public final String w() {
        return this.zzg;
    }

    public final /* synthetic */ void y(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }
}

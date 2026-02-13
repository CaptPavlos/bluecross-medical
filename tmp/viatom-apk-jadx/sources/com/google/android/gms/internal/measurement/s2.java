package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s2 extends o5 {
    private static final s2 zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        s2 s2Var = new s2();
        zzk = s2Var;
        o5.m(s2.class, s2Var);
    }

    public static r2 w() {
        return (r2) zzk.h();
    }

    public static s2 x() {
        return zzk;
    }

    public final /* synthetic */ void A(boolean z9) {
        this.zzb |= 4;
        this.zzf = z9;
    }

    public final /* synthetic */ void B(boolean z9) {
        this.zzb |= 8;
        this.zzg = z9;
    }

    public final /* synthetic */ void C(boolean z9) {
        this.zzb |= 16;
        this.zzh = z9;
    }

    public final /* synthetic */ void D(boolean z9) {
        this.zzb |= 32;
        this.zzi = z9;
    }

    public final /* synthetic */ void E(boolean z9) {
        this.zzb |= 64;
        this.zzj = z9;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i11 == 3) {
            return new s2();
        }
        if (i11 == 4) {
            return new r2(zzk);
        }
        if (i11 == 5) {
            return zzk;
        }
        throw null;
    }

    public final boolean p() {
        return this.zzd;
    }

    public final boolean q() {
        return this.zze;
    }

    public final boolean r() {
        return this.zzf;
    }

    public final boolean s() {
        return this.zzg;
    }

    public final boolean t() {
        return this.zzh;
    }

    public final boolean u() {
        return this.zzi;
    }

    public final boolean v() {
        return this.zzj;
    }

    public final /* synthetic */ void y(boolean z9) {
        this.zzb |= 1;
        this.zzd = z9;
    }

    public final /* synthetic */ void z(boolean z9) {
        this.zzb |= 2;
        this.zze = z9;
    }
}

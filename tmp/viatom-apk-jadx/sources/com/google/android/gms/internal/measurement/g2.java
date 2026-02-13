package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g2 extends o5 {
    private static final g2 zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private t5 zzg;
    private t5 zzh;
    private t5 zzi;
    private String zzj;
    private boolean zzk;
    private t5 zzl;
    private t5 zzm;
    private String zzn;
    private String zzo;
    private b2 zzp;
    private i2 zzq;
    private l2 zzr;
    private j2 zzs;
    private h2 zzt;

    static {
        g2 g2Var = new g2();
        zzu = g2Var;
        o5.m(g2.class, g2Var);
    }

    public g2() {
        n6 n6Var = n6.e;
        this.zzg = n6Var;
        this.zzh = n6Var;
        this.zzi = n6Var;
        this.zzj = "";
        this.zzl = n6Var;
        this.zzm = n6Var;
        this.zzn = "";
        this.zzo = "";
    }

    public static f2 F() {
        return (f2) zzu.h();
    }

    public static g2 G() {
        return zzu;
    }

    public final String A() {
        return this.zzn;
    }

    public final boolean B() {
        return (this.zzb & 128) != 0;
    }

    public final b2 C() {
        b2 b2Var = this.zzp;
        return b2Var == null ? b2.v() : b2Var;
    }

    public final boolean D() {
        return (this.zzb & 512) != 0;
    }

    public final l2 E() {
        l2 l2Var = this.zzr;
        return l2Var == null ? l2.r() : l2Var;
    }

    public final void H(int i10, e2 e2Var) {
        t5 t5Var = this.zzh;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zzh = t5Var.k(size + size);
        }
        this.zzh.set(i10, e2Var);
    }

    public final void I() {
        this.zzi = n6.e;
    }

    public final void J() {
        this.zzl = n6.e;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", k2.class, "zzh", e2.class, "zzi", n1.class, "zzj", "zzk", "zzl", w3.class, "zzm", c2.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i11 == 3) {
            return new g2();
        }
        if (i11 == 4) {
            return new f2(zzu);
        }
        if (i11 == 5) {
            return zzu;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final long q() {
        return this.zzd;
    }

    public final boolean r() {
        return (this.zzb & 2) != 0;
    }

    public final String s() {
        return this.zze;
    }

    public final t5 t() {
        return this.zzg;
    }

    public final int u() {
        return this.zzh.size();
    }

    public final e2 v(int i10) {
        return (e2) this.zzh.get(i10);
    }

    public final t5 w() {
        return this.zzi;
    }

    public final t5 x() {
        return this.zzl;
    }

    public final int y() {
        return this.zzl.size();
    }

    public final List z() {
        return this.zzm;
    }
}

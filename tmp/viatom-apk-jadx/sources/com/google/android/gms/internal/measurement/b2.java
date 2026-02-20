package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b2 extends o5 {
    private static final b2 zzi;
    private int zzb;
    private t5 zzd;
    private t5 zze;
    private t5 zzf;
    private boolean zzg;
    private t5 zzh;

    static {
        b2 b2Var = new b2();
        zzi = b2Var;
        o5.m(b2.class, b2Var);
    }

    public b2() {
        n6 n6Var = n6.e;
        this.zzd = n6Var;
        this.zze = n6Var;
        this.zzf = n6Var;
        this.zzh = n6Var;
    }

    public static b2 v() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", y1.class, "zze", z1.class, "zzf", a2.class, "zzg", "zzh", y1.class});
        }
        if (i11 == 3) {
            return new b2();
        }
        if (i11 == 4) {
            return new s1(zzi);
        }
        if (i11 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final List q() {
        return this.zze;
    }

    public final List r() {
        return this.zzf;
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final boolean t() {
        return this.zzg;
    }

    public final t5 u() {
        return this.zzh;
    }
}

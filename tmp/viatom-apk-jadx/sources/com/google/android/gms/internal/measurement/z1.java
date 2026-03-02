package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class z1 extends o5 {
    private static final z1 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        z1 z1Var = new z1();
        zzf = z1Var;
        o5.m(z1.class, z1Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            t1 t1Var = t1.e;
            return new o6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", t1Var, "zze", t1Var});
        }
        if (i11 == 3) {
            return new z1();
        }
        if (i11 == 4) {
            return new s1(zzf);
        }
        if (i11 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int p() {
        int iV = z1.t1.V(this.zzd);
        if (iV == 0) {
            return 1;
        }
        return iV;
    }

    public final int q() {
        int iV = z1.t1.V(this.zze);
        if (iV == 0) {
            return 1;
        }
        return iV;
    }
}

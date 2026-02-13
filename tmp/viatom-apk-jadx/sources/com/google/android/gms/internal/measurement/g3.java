package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g3 extends o5 {
    private static final g3 zzg;
    private int zzb;
    private String zzd = "";
    private String zze = "";
    private q2 zzf;

    static {
        g3 g3Var = new g3();
        zzg = g3Var;
        o5.m(g3.class, g3Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zzd", "zze", "zzf"});
        }
        if (i11 == 3) {
            return new g3();
        }
        if (i11 == 4) {
            return new s1(zzg);
        }
        if (i11 == 5) {
            return zzg;
        }
        throw null;
    }
}

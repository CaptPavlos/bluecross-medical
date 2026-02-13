package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c2 extends o5 {
    private static final c2 zzg;
    private int zzb;
    private String zzd = "";
    private t5 zze = n6.e;
    private boolean zzf;

    static {
        c2 c2Var = new c2();
        zzg = c2Var;
        o5.m(c2.class, c2Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", j2.class, "zzf"});
        }
        if (i11 == 3) {
            return new c2();
        }
        if (i11 == 4) {
            return new s1(zzg);
        }
        if (i11 == 5) {
            return zzg;
        }
        throw null;
    }

    public final String p() {
        return this.zzd;
    }
}

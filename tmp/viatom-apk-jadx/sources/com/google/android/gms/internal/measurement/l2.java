package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l2 extends o5 {
    private static final l2 zzi;
    private int zzb;
    private int zzg;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        l2 l2Var = new l2();
        zzi = l2Var;
        o5.m(l2.class, l2Var);
    }

    public static l2 r() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i11 == 3) {
            return new l2();
        }
        if (i11 == 4) {
            return new s1(zzi);
        }
        if (i11 == 5) {
            return zzi;
        }
        throw null;
    }

    public final int p() {
        return this.zzg;
    }

    public final String q() {
        return this.zzh;
    }
}

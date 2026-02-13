package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v3 extends o5 {
    private static final v3 zzf;
    private int zzb;
    private String zzd = "";
    private t5 zze = n6.e;

    static {
        v3 v3Var = new v3();
        zzf = v3Var;
        o5.m(v3.class, v3Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzb", "zzd", "zze", x3.class});
        }
        if (i11 == 3) {
            return new v3();
        }
        if (i11 == 4) {
            return new s1(zzf);
        }
        if (i11 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String p() {
        return this.zzd;
    }

    public final List q() {
        return this.zze;
    }
}

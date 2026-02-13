package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w3 extends o5 {
    private static final w3 zzf;
    private int zzb;
    private t5 zzd = n6.e;
    private u3 zze;

    static {
        w3 w3Var = new w3();
        zzf = w3Var;
        o5.m(w3.class, w3Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", x3.class, "zze"});
        }
        if (i11 == 3) {
            return new w3();
        }
        if (i11 == 4) {
            return new s1(zzf);
        }
        if (i11 == 5) {
            return zzf;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final u3 q() {
        u3 u3Var = this.zze;
        return u3Var == null ? u3.r() : u3Var;
    }
}

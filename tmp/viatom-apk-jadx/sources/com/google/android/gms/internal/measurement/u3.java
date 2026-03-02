package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u3 extends o5 {
    private static final u3 zzd;
    private t5 zzb = n6.e;

    static {
        u3 u3Var = new u3();
        zzd = u3Var;
        o5.m(u3.class, u3Var);
    }

    public static u3 r() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", v3.class});
        }
        if (i11 == 3) {
            return new u3();
        }
        if (i11 == 4) {
            return new s1(zzd);
        }
        if (i11 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List p() {
        return this.zzb;
    }

    public final int q() {
        return this.zzb.size();
    }
}

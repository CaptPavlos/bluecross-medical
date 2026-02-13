package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y1 extends o5 {
    private static final y1 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        y1 y1Var = new y1();
        zzg = y1Var;
        o5.m(y1.class, y1Var);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", t1.e, "zze", t1.f2169d, "zzf", t1.f});
        }
        if (i11 == 3) {
            return new y1();
        }
        if (i11 == 4) {
            return new s1(zzg);
        }
        if (i11 == 5) {
            return zzg;
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
        int i10;
        int i11 = this.zze;
        if (i11 != 0) {
            i10 = 2;
            if (i11 != 1) {
                i10 = i11 != 2 ? 0 : 3;
            }
        } else {
            i10 = 1;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public final int r() {
        int i10;
        int i11 = this.zzf;
        if (i11 != 0) {
            i10 = 2;
            if (i11 != 1) {
                i10 = i11 != 2 ? 0 : 3;
            }
        } else {
            i10 = 1;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }
}

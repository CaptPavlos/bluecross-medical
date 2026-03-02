package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r3 extends o5 {
    private static final r3 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        r3 r3Var = new r3();
        zzg = r3Var;
        o5.m(r3.class, r3Var);
    }

    public static q3 q() {
        return (q3) zzg.h();
    }

    public static r3 r() {
        return zzg;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", t1.f2175n, "zze", t1.f2173l, "zzf", t1.f2174m});
        }
        if (i11 == 3) {
            return new r3();
        }
        if (i11 == 4) {
            return new q3(zzg);
        }
        if (i11 == 5) {
            return zzg;
        }
        throw null;
    }

    public final int p() {
        int iJ = androidx.constraintlayout.core.widgets.analyzer.a.j(this.zze);
        if (iJ == 0) {
            return 1;
        }
        return iJ;
    }

    public final void s(int i10) {
        this.zze = androidx.constraintlayout.core.widgets.analyzer.a.l(i10);
        this.zzb |= 2;
    }

    public final int t() {
        int i10;
        int i11 = this.zzd;
        if (i11 != 0) {
            i10 = 2;
            if (i11 != 1) {
                if (i11 != 2) {
                    i10 = 4;
                    if (i11 != 3) {
                        i10 = i11 != 4 ? 0 : 5;
                    }
                } else {
                    i10 = 3;
                }
            }
        } else {
            i10 = 1;
        }
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[PHI: r3
      0x0017: PHI (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:7:0x0009, B:11:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int u() {
        /*
            r4 = this;
            int r0 = r4.zzf
            r1 = 1
            if (r0 == 0) goto L19
            r2 = 2
            if (r0 == r1) goto L1a
            r3 = 3
            if (r0 == r2) goto L17
            r2 = 4
            if (r0 == r3) goto L1a
            r3 = 5
            if (r0 == r2) goto L17
            if (r0 == r3) goto L15
            r2 = 0
            goto L1a
        L15:
            r2 = 6
            goto L1a
        L17:
            r2 = r3
            goto L1a
        L19:
            r2 = r1
        L1a:
            if (r2 != 0) goto L1d
            return r1
        L1d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.r3.u():int");
    }

    public final /* synthetic */ void v(int i10) {
        this.zzd = i10 - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void w(int i10) {
        this.zzf = i10 - 1;
        this.zzb |= 4;
    }
}

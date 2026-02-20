package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y2 extends o5 {
    private static final y2 zzd;
    private t5 zzb = n6.e;

    static {
        y2 y2Var = new y2();
        zzd = y2Var;
        o5.m(y2.class, y2Var);
    }

    public static v2 q() {
        return (v2) zzd.h();
    }

    public static y2 r() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", x2.class});
        }
        if (i11 == 3) {
            return new y2();
        }
        if (i11 == 4) {
            return new v2(zzd);
        }
        if (i11 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List p() {
        return this.zzb;
    }

    public final void s(ArrayList arrayList) {
        t5 t5Var = this.zzb;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zzb = t5Var.k(size + size);
        }
        u4.c(arrayList, this.zzb);
    }
}

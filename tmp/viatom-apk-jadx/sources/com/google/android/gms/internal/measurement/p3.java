package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p3 extends o5 {
    private static final p3 zzf;
    private int zzb;
    private int zzd;
    private s5 zze = b6.e;

    static {
        p3 p3Var = new p3();
        zzf = p3Var;
        o5.m(p3.class, p3Var);
    }

    public static o3 u() {
        return (o3) zzf.h();
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i11 == 3) {
            return new p3();
        }
        if (i11 == 4) {
            return new o3(zzf);
        }
        if (i11 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean p() {
        return (this.zzb & 1) != 0;
    }

    public final int q() {
        return this.zzd;
    }

    public final List r() {
        return this.zze;
    }

    public final int s() {
        return this.zze.size();
    }

    public final long t(int i10) {
        return ((b6) this.zze).c(i10);
    }

    public final /* synthetic */ void v(int i10) {
        this.zzb |= 1;
        this.zzd = i10;
    }

    public final void w(List list) {
        List list2 = this.zze;
        if (!((v4) list2).f2204a) {
            int size = list2.size();
            this.zze = ((b6) list2).k(size + size);
        }
        u4.c(list, this.zze);
    }
}

package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n3 extends o5 {
    private static final n3 zzg;
    private s5 zzb;
    private s5 zzd;
    private t5 zze;
    private t5 zzf;

    static {
        n3 n3Var = new n3();
        zzg = n3Var;
        o5.m(n3.class, n3Var);
    }

    public n3() {
        b6 b6Var = b6.e;
        this.zzb = b6Var;
        this.zzd = b6Var;
        n6 n6Var = n6.e;
        this.zze = n6Var;
        this.zzf = n6Var;
    }

    public static m3 x() {
        return (m3) zzg.h();
    }

    public static n3 y() {
        return zzg;
    }

    public final void A() {
        this.zzb = b6.e;
    }

    public final void B(List list) {
        List list2 = this.zzd;
        if (!((v4) list2).f2204a) {
            int size = list2.size();
            this.zzd = ((b6) list2).k(size + size);
        }
        u4.c(list, this.zzd);
    }

    public final void C() {
        this.zzd = b6.e;
    }

    public final void D(ArrayList arrayList) {
        t5 t5Var = this.zze;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zze = t5Var.k(size + size);
        }
        u4.c(arrayList, this.zze);
    }

    public final void E() {
        this.zze = n6.e;
    }

    public final void F(Iterable iterable) {
        t5 t5Var = this.zzf;
        if (!((v4) t5Var).f2204a) {
            int size = t5Var.size();
            this.zzf = t5Var.k(size + size);
        }
        u4.c(iterable, this.zzf);
    }

    public final void G() {
        this.zzf = n6.e;
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", a3.class, "zzf", p3.class});
        }
        if (i11 == 3) {
            return new n3();
        }
        if (i11 == 4) {
            return new m3(zzg);
        }
        if (i11 == 5) {
            return zzg;
        }
        throw null;
    }

    public final List p() {
        return this.zzb;
    }

    public final int q() {
        return this.zzb.size();
    }

    public final List r() {
        return this.zzd;
    }

    public final int s() {
        return this.zzd.size();
    }

    public final t5 t() {
        return this.zze;
    }

    public final int u() {
        return this.zze.size();
    }

    public final List v() {
        return this.zzf;
    }

    public final int w() {
        return this.zzf.size();
    }

    public final void z(Iterable iterable) {
        List list = this.zzb;
        if (!((v4) list).f2204a) {
            int size = list.size();
            this.zzb = ((b6) list).k(size + size);
        }
        u4.c(iterable, this.zzb);
    }
}

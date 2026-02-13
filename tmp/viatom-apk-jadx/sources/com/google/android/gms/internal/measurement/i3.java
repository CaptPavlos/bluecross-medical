package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i3 extends o5 {
    private static final i3 zzh;
    private int zzb;
    private t5 zzd = n6.e;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        i3 i3Var = new i3();
        zzh = i3Var;
        o5.m(i3.class, i3Var);
    }

    public static h3 w() {
        return (h3) zzh.h();
    }

    public static h3 x(i3 i3Var) {
        n5 n5VarH = zzh.h();
        n5VarH.e(i3Var);
        return (h3) n5VarH;
    }

    public final /* synthetic */ void A(ArrayList arrayList) {
        E();
        u4.c(arrayList, this.zzd);
    }

    public final void B() {
        this.zzd = n6.e;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    public final void E() {
        t5 t5Var = this.zzd;
        if (((v4) t5Var).f2204a) {
            return;
        }
        int size = t5Var.size();
        this.zzd = t5Var.k(size + size);
    }

    @Override // com.google.android.gms.internal.measurement.o5
    public final Object o(int i10) {
        int i11 = i10 - 1;
        if (i11 == 0) {
            return (byte) 1;
        }
        if (i11 == 2) {
            return new o6(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", k3.class, "zze", "zzf", "zzg", t1.f2171j});
        }
        if (i11 == 3) {
            return new i3();
        }
        if (i11 == 4) {
            return new h3(zzh);
        }
        if (i11 == 5) {
            return zzh;
        }
        throw null;
    }

    public final List p() {
        return this.zzd;
    }

    public final int q() {
        return this.zzd.size();
    }

    public final k3 r(int i10) {
        return (k3) this.zzd.get(i10);
    }

    public final boolean s() {
        return (this.zzb & 1) != 0;
    }

    public final String t() {
        return this.zze;
    }

    public final boolean u() {
        return (this.zzb & 2) != 0;
    }

    public final String v() {
        return this.zzf;
    }

    public final /* synthetic */ void y(int i10, k3 k3Var) {
        E();
        this.zzd.set(i10, k3Var);
    }

    public final /* synthetic */ void z(k3 k3Var) {
        E();
        this.zzd.add(k3Var);
    }
}

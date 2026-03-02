package c1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 extends com.google.android.gms.internal.measurement.x implements i0 {
    public g0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 0);
    }

    @Override // c1.i0
    public final void A(d5 d5Var, d dVar) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        com.google.android.gms.internal.measurement.z.b(parcelG, dVar);
        H(parcelG, 30);
    }

    @Override // c1.i0
    public final void C(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 4);
    }

    @Override // c1.i0
    public final i D(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        Parcel parcelD = d(parcelG, 21);
        i iVar = (i) com.google.android.gms.internal.measurement.z.a(parcelD, i.CREATOR);
        parcelD.recycle();
        return iVar;
    }

    @Override // c1.i0
    public final byte[] F(v vVar, String str) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, vVar);
        parcelG.writeString(str);
        Parcel parcelD = d(parcelG, 9);
        byte[] bArrCreateByteArray = parcelD.createByteArray();
        parcelD.recycle();
        return bArrCreateByteArray;
    }

    @Override // c1.i0
    public final List f(String str, String str2, String str3, boolean z9) {
        Parcel parcelG = G();
        parcelG.writeString(null);
        parcelG.writeString(str2);
        parcelG.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2275a;
        parcelG.writeInt(z9 ? 1 : 0);
        Parcel parcelD = d(parcelG, 15);
        ArrayList arrayListCreateTypedArrayList = parcelD.createTypedArrayList(y4.CREATOR);
        parcelD.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // c1.i0
    public final void g(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 6);
    }

    @Override // c1.i0
    public final void h(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 26);
    }

    @Override // c1.i0
    public final List i(String str, String str2, boolean z9, d5 d5Var) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2275a;
        parcelG.writeInt(z9 ? 1 : 0);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        Parcel parcelD = d(parcelG, 14);
        ArrayList arrayListCreateTypedArrayList = parcelD.createTypedArrayList(y4.CREATOR);
        parcelD.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // c1.i0
    public final void j(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 25);
    }

    @Override // c1.i0
    public final void k(long j10, String str, String str2, String str3) {
        Parcel parcelG = G();
        parcelG.writeLong(j10);
        parcelG.writeString(str);
        parcelG.writeString(str2);
        parcelG.writeString(str3);
        H(parcelG, 10);
    }

    @Override // c1.i0
    public final List m(String str, String str2, String str3) {
        Parcel parcelG = G();
        parcelG.writeString(null);
        parcelG.writeString(str2);
        parcelG.writeString(str3);
        Parcel parcelD = d(parcelG, 17);
        ArrayList arrayListCreateTypedArrayList = parcelD.createTypedArrayList(e.CREATOR);
        parcelD.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // c1.i0
    public final void o(v vVar, d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, vVar);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 1);
    }

    @Override // c1.i0
    public final void p(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 18);
    }

    @Override // c1.i0
    public final void q(e eVar, d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, eVar);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 12);
    }

    @Override // c1.i0
    public final String r(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        Parcel parcelD = d(parcelG, 11);
        String string = parcelD.readString();
        parcelD.recycle();
        return string;
    }

    @Override // c1.i0
    public final List s(String str, String str2, d5 d5Var) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        Parcel parcelD = d(parcelG, 16);
        ArrayList arrayListCreateTypedArrayList = parcelD.createTypedArrayList(e.CREATOR);
        parcelD.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // c1.i0
    public final void t(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 20);
    }

    @Override // c1.i0
    public final void v(d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 27);
    }

    @Override // c1.i0
    public final void w(d5 d5Var, Bundle bundle, k0 k0Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        com.google.android.gms.internal.measurement.z.b(parcelG, bundle);
        com.google.android.gms.internal.measurement.z.c(parcelG, k0Var);
        H(parcelG, 31);
    }

    @Override // c1.i0
    public final void x(Bundle bundle, d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, bundle);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 19);
    }

    @Override // c1.i0
    public final void y(y4 y4Var, d5 d5Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, y4Var);
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        H(parcelG, 2);
    }

    @Override // c1.i0
    public final void z(d5 d5Var, o4 o4Var, m0 m0Var) {
        Parcel parcelG = G();
        com.google.android.gms.internal.measurement.z.b(parcelG, d5Var);
        com.google.android.gms.internal.measurement.z.b(parcelG, o4Var);
        com.google.android.gms.internal.measurement.z.c(parcelG, m0Var);
        H(parcelG, 29);
    }
}

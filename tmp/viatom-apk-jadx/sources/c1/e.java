package c1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends j0.a {
    public static final Parcelable.Creator<e> CREATOR = new android.support.v4.media.f(10);

    /* renamed from: a, reason: collision with root package name */
    public String f1134a;

    /* renamed from: b, reason: collision with root package name */
    public String f1135b;

    /* renamed from: c, reason: collision with root package name */
    public y4 f1136c;

    /* renamed from: d, reason: collision with root package name */
    public long f1137d;
    public boolean e;
    public String f;
    public final v g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public v f1138i;

    /* renamed from: j, reason: collision with root package name */
    public final long f1139j;

    /* renamed from: k, reason: collision with root package name */
    public final v f1140k;

    public e(e eVar) {
        i0.y.g(eVar);
        this.f1134a = eVar.f1134a;
        this.f1135b = eVar.f1135b;
        this.f1136c = eVar.f1136c;
        this.f1137d = eVar.f1137d;
        this.e = eVar.e;
        this.f = eVar.f;
        this.g = eVar.g;
        this.h = eVar.h;
        this.f1138i = eVar.f1138i;
        this.f1139j = eVar.f1139j;
        this.f1140k = eVar.f1140k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.F(parcel, 2, this.f1134a);
        com.google.android.gms.internal.measurement.a4.F(parcel, 3, this.f1135b);
        com.google.android.gms.internal.measurement.a4.E(parcel, 4, this.f1136c, i10);
        long j10 = this.f1137d;
        com.google.android.gms.internal.measurement.a4.O(parcel, 5, 8);
        parcel.writeLong(j10);
        boolean z9 = this.e;
        com.google.android.gms.internal.measurement.a4.O(parcel, 6, 4);
        parcel.writeInt(z9 ? 1 : 0);
        com.google.android.gms.internal.measurement.a4.F(parcel, 7, this.f);
        com.google.android.gms.internal.measurement.a4.E(parcel, 8, this.g, i10);
        long j11 = this.h;
        com.google.android.gms.internal.measurement.a4.O(parcel, 9, 8);
        parcel.writeLong(j11);
        com.google.android.gms.internal.measurement.a4.E(parcel, 10, this.f1138i, i10);
        com.google.android.gms.internal.measurement.a4.O(parcel, 11, 8);
        parcel.writeLong(this.f1139j);
        com.google.android.gms.internal.measurement.a4.E(parcel, 12, this.f1140k, i10);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }

    public e(String str, String str2, y4 y4Var, long j10, boolean z9, String str3, v vVar, long j11, v vVar2, long j12, v vVar3) {
        this.f1134a = str;
        this.f1135b = str2;
        this.f1136c = y4Var;
        this.f1137d = j10;
        this.e = z9;
        this.f = str3;
        this.g = vVar;
        this.h = j11;
        this.f1138i = vVar2;
        this.f1139j = j12;
        this.f1140k = vVar3;
    }
}

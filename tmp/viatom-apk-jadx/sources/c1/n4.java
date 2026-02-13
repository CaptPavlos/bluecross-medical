package c1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n4 extends j0.a {
    public static final Parcelable.Creator<n4> CREATOR = new android.support.v4.media.f(15);

    /* renamed from: a, reason: collision with root package name */
    public final long f1373a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f1374b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1375c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f1376d;
    public final int e;
    public final long f;
    public String g;

    public n4(long j10, byte[] bArr, String str, Bundle bundle, int i10, long j11, String str2) {
        this.f1373a = j10;
        this.f1374b = bArr;
        this.f1375c = str;
        this.f1376d = bundle;
        this.e = i10;
        this.f = j11;
        this.g = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.O(parcel, 1, 8);
        parcel.writeLong(this.f1373a);
        byte[] bArr = this.f1374b;
        if (bArr != null) {
            int I2 = com.google.android.gms.internal.measurement.a4.I(parcel, 2);
            parcel.writeByteArray(bArr);
            com.google.android.gms.internal.measurement.a4.M(parcel, I2);
        }
        com.google.android.gms.internal.measurement.a4.F(parcel, 3, this.f1375c);
        com.google.android.gms.internal.measurement.a4.C(4, this.f1376d, parcel);
        com.google.android.gms.internal.measurement.a4.O(parcel, 5, 4);
        parcel.writeInt(this.e);
        com.google.android.gms.internal.measurement.a4.O(parcel, 6, 8);
        parcel.writeLong(this.f);
        com.google.android.gms.internal.measurement.a4.F(parcel, 7, this.g);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

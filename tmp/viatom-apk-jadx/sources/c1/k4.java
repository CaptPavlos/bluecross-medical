package c1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k4 extends j0.a {
    public static final Parcelable.Creator<k4> CREATOR = new android.support.v4.media.f(14);

    /* renamed from: a, reason: collision with root package name */
    public final String f1308a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1309b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1310c;

    public k4(int i10, long j10, String str) {
        this.f1308a = str;
        this.f1309b = j10;
        this.f1310c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.F(parcel, 1, this.f1308a);
        com.google.android.gms.internal.measurement.a4.O(parcel, 2, 8);
        parcel.writeLong(this.f1309b);
        com.google.android.gms.internal.measurement.a4.O(parcel, 3, 4);
        parcel.writeInt(this.f1310c);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

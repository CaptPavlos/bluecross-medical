package c1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends j0.a {
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.f(9);

    /* renamed from: a, reason: collision with root package name */
    public final long f1097a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1098b;

    /* renamed from: c, reason: collision with root package name */
    public final long f1099c;

    public d(long j10, int i10, long j11) {
        this.f1097a = j10;
        this.f1098b = i10;
        this.f1099c = j11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.O(parcel, 1, 8);
        parcel.writeLong(this.f1097a);
        com.google.android.gms.internal.measurement.a4.O(parcel, 2, 4);
        parcel.writeInt(this.f1098b);
        com.google.android.gms.internal.measurement.a4.O(parcel, 3, 8);
        parcel.writeLong(this.f1099c);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

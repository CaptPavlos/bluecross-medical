package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j1 implements Parcelable {
    public static Parcelable.Creator<j1> CREATOR = new g0.l(17);

    /* renamed from: a, reason: collision with root package name */
    public long f8628a;

    /* renamed from: b, reason: collision with root package name */
    public String f8629b;

    /* renamed from: c, reason: collision with root package name */
    public int f8630c;

    /* renamed from: d, reason: collision with root package name */
    public int f8631d;
    public int e;
    public int f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8628a);
        parcel.writeString(this.f8629b);
        parcel.writeInt(this.f8631d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f8630c);
        parcel.writeInt(this.f);
    }
}

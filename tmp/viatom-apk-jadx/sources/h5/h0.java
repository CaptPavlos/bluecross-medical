package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 implements Parcelable {
    public static Parcelable.Creator<h0> CREATOR = new g0.l(9);

    /* renamed from: a, reason: collision with root package name */
    public String f8601a;

    /* renamed from: d, reason: collision with root package name */
    public String f8604d;

    /* renamed from: b, reason: collision with root package name */
    public int f8602b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f8603c = -1;
    public int e = -1;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8601a);
        parcel.writeInt(this.f8602b);
        parcel.writeInt(this.f8603c);
        parcel.writeString(this.f8604d);
        parcel.writeInt(this.e);
    }
}

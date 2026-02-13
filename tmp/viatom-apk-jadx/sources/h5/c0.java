package h5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 implements Parcelable {
    public static Parcelable.Creator<c0> CREATOR = new g0.l(8);

    /* renamed from: a, reason: collision with root package name */
    public String f8485a;

    /* renamed from: b, reason: collision with root package name */
    public long f8486b;

    /* renamed from: c, reason: collision with root package name */
    public String f8487c;

    /* renamed from: d, reason: collision with root package name */
    public long f8488d;
    public String e;
    public String f;
    public String g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f8489i;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8485a);
        parcel.writeString(this.f8487c);
        parcel.writeLong(this.f8488d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.f8486b);
    }
}

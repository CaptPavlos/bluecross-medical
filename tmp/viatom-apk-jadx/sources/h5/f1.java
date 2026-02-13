package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f1 implements Parcelable {
    public static Parcelable.Creator<f1> CREATOR = new g0.l(15);

    /* renamed from: a, reason: collision with root package name */
    public String f8546a;

    /* renamed from: b, reason: collision with root package name */
    public int f8547b;

    /* renamed from: c, reason: collision with root package name */
    public int f8548c;

    /* renamed from: d, reason: collision with root package name */
    public int f8549d;
    public int e;
    public int f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8550i;

    /* renamed from: j, reason: collision with root package name */
    public int f8551j;

    /* renamed from: k, reason: collision with root package name */
    public int f8552k;

    /* renamed from: l, reason: collision with root package name */
    public long f8553l;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8546a);
        parcel.writeInt(this.f8547b);
        parcel.writeInt(this.f8548c);
        parcel.writeInt(this.f8549d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
    }
}

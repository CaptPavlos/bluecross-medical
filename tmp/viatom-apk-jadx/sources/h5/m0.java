package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public long f8657a;

    /* renamed from: b, reason: collision with root package name */
    public String f8658b;

    /* renamed from: c, reason: collision with root package name */
    public String f8659c;

    /* renamed from: d, reason: collision with root package name */
    public String f8660d;
    public long e;
    public String f;
    public String g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8661i;

    /* renamed from: j, reason: collision with root package name */
    public int f8662j;

    /* renamed from: k, reason: collision with root package name */
    public String f8663k;

    /* renamed from: l, reason: collision with root package name */
    public int f8664l;

    /* renamed from: m, reason: collision with root package name */
    public static final c1.d0 f8656m = new c1.d0(15);
    public static Parcelable.Creator<m0> CREATOR = new g0.l(10);

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8657a);
        parcel.writeLong(this.e);
        parcel.writeString(this.f8658b);
        parcel.writeString(this.f8659c);
        parcel.writeString(this.f8660d);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.f8661i);
        parcel.writeInt(this.f8662j);
        parcel.writeString(this.f8663k);
        parcel.writeInt(this.f8664l);
    }
}

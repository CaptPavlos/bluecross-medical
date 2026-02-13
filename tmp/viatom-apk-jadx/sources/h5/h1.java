package h5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h1 implements Parcelable {
    public static Parcelable.Creator<h1> CREATOR = new g0.l(16);

    /* renamed from: a, reason: collision with root package name */
    public long f8605a;

    /* renamed from: b, reason: collision with root package name */
    public String f8606b;

    /* renamed from: c, reason: collision with root package name */
    public String f8607c;

    /* renamed from: d, reason: collision with root package name */
    public String f8608d;
    public String e;
    public int f;
    public String g;
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public int f8609i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f8610j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f8611k = new ArrayList();

    public h1(Parcel parcel) {
        this.f8605a = parcel.readLong();
        this.f8606b = parcel.readString();
        this.f8607c = parcel.readString();
        this.f8608d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readLong();
        this.f8609i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8605a);
        parcel.writeString(this.f8606b);
        parcel.writeString(this.f8607c);
        parcel.writeString(this.f8608d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeLong(this.h);
        parcel.writeInt(this.f8609i);
    }

    public h1() {
    }
}

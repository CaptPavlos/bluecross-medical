package h5;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Spanned;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t0 implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public long f8739a;

    /* renamed from: b, reason: collision with root package name */
    public String f8740b;

    /* renamed from: c, reason: collision with root package name */
    public String f8741c;

    /* renamed from: d, reason: collision with root package name */
    public String f8742d;
    public long e;
    public String f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public String f8743i;

    /* renamed from: j, reason: collision with root package name */
    public int f8744j;

    /* renamed from: k, reason: collision with root package name */
    public int f8745k;

    /* renamed from: l, reason: collision with root package name */
    public String f8746l;

    /* renamed from: m, reason: collision with root package name */
    public int f8747m;

    /* renamed from: n, reason: collision with root package name */
    public String f8748n;

    /* renamed from: o, reason: collision with root package name */
    public int f8749o;

    /* renamed from: p, reason: collision with root package name */
    public static final c1.d0 f8738p = new c1.d0(16);
    public static Parcelable.Creator<t0> CREATOR = new g0.l(11);

    public final Spanned a() {
        String str = this.f;
        if (str == null) {
            return null;
        }
        ConcurrentHashMap concurrentHashMap = v5.n.f13169a;
        return v5.n.a(o7.u.b0(str, "\n", "<br />", false));
    }

    public final boolean b() {
        return this.f8747m == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8739a);
        parcel.writeLong(this.e);
        parcel.writeString(this.f8741c);
        parcel.writeString(this.f8740b);
        parcel.writeString(this.f8742d);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.f8743i);
        parcel.writeInt(this.f8744j);
        parcel.writeInt(this.f8745k);
        parcel.writeString(this.f8746l);
        parcel.writeInt(this.f8747m);
        parcel.writeString(this.f8748n);
        parcel.writeInt(this.f8749o);
    }
}

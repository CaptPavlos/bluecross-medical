package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r implements Parcelable {
    public static Parcelable.Creator<r> CREATOR = new g0.l(5);

    /* renamed from: d, reason: collision with root package name */
    public String f8723d;
    public long f;
    public String g;
    public String h;

    /* renamed from: i, reason: collision with root package name */
    public int f8724i;

    /* renamed from: j, reason: collision with root package name */
    public long f8725j;

    /* renamed from: a, reason: collision with root package name */
    public long f8720a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f8721b = -1;

    /* renamed from: c, reason: collision with root package name */
    public long f8722c = -1;
    public long e = -1;

    public final long a() {
        return this.e;
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void c(long j10) {
        this.e = j10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String toString() {
        return "{id='" + this.f8720a + "', downloadId='" + this.f8721b + "', fileId='" + this.f8722c + "', type=" + this.f8723d + ", sizeExpected='" + this.e + "', sizeDownloaded='" + this.f + "', filehashExpected='" + this.g + "', absolutePath='" + this.h + "', attempts=" + this.f8724i + ", nextAttemptTimeStamp=" + this.f8725j + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8720a);
        parcel.writeLong(this.f8721b);
        parcel.writeLong(this.f8722c);
        parcel.writeString(this.f8723d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.f8724i);
        parcel.writeLong(this.f8725j);
    }
}

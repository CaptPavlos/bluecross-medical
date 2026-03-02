package h5;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u0 implements Parcelable {
    public static Parcelable.Creator<u0> CREATOR = new g0.l(12);

    /* renamed from: a, reason: collision with root package name */
    public String f8754a;

    /* renamed from: b, reason: collision with root package name */
    public int f8755b;

    /* renamed from: c, reason: collision with root package name */
    public int f8756c;

    /* renamed from: d, reason: collision with root package name */
    public int f8757d;

    public final String a() {
        if (this.f8754a == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8754a);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.K, ":webp");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8754a);
        parcel.writeInt(this.f8755b);
        parcel.writeInt(this.f8756c);
        parcel.writeInt(this.f8757d);
    }
}

package h5;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l1 implements Parcelable {
    public static Parcelable.Creator<l1> CREATOR = new g0.l(18);

    /* renamed from: a, reason: collision with root package name */
    public String f8650a;

    /* renamed from: b, reason: collision with root package name */
    public String f8651b;

    public final String a() {
        if (this.f8651b == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8651b);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.H, ":webp");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8650a);
        parcel.writeString(this.f8651b);
    }
}

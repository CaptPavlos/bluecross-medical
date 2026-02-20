package h5;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import c1.w4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements Parcelable {
    public static Parcelable.Creator<s> CREATOR = new g0.l(6);

    /* renamed from: a, reason: collision with root package name */
    public int f8730a;

    /* renamed from: b, reason: collision with root package name */
    public long f8731b;

    /* renamed from: c, reason: collision with root package name */
    public String f8732c;

    public final void a(Context context, String str) {
        context.getClass();
        String str2 = this.f8732c;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        w4 w4Var = new w4(context, 4, false);
        long j10 = this.f8731b;
        String str3 = this.f8732c;
        str3.getClass();
        w4Var.G(str, str3, j10);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id='");
        sb.append(this.f8730a);
        sb.append("'appID='");
        sb.append(this.f8731b);
        sb.append("'categoryType='");
        return a3.a.o(sb, this.f8732c, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeInt(this.f8730a);
        parcel.writeLong(this.f8731b);
        parcel.writeString(this.f8732c);
    }
}

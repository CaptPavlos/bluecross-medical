package c1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends j0.a {
    public static final Parcelable.Creator<v> CREATOR = new android.support.v4.media.f(13);

    /* renamed from: a, reason: collision with root package name */
    public final String f1505a;

    /* renamed from: b, reason: collision with root package name */
    public final u f1506b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1507c;

    /* renamed from: d, reason: collision with root package name */
    public final long f1508d;

    public v(v vVar, long j10) {
        i0.y.g(vVar);
        this.f1505a = vVar.f1505a;
        this.f1506b = vVar.f1506b;
        this.f1507c = vVar.f1507c;
        this.f1508d = j10;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f1506b);
        String str = this.f1507c;
        int length = String.valueOf(str).length();
        String str2 = this.f1505a;
        StringBuilder sb = new StringBuilder(length + 13 + String.valueOf(str2).length() + 8 + strValueOf.length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        return a3.a.o(sb, ",params=", strValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        android.support.v4.media.f.a(this, parcel, i10);
    }

    public v(String str, u uVar, String str2, long j10) {
        this.f1505a = str;
        this.f1506b = uVar;
        this.f1507c = str2;
        this.f1508d = j10;
    }
}

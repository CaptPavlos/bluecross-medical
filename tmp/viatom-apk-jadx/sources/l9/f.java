package l9;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements Parcelable {
    public static final e CREATOR = new e();

    /* renamed from: a, reason: collision with root package name */
    public final String f11108a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11109b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11110c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11111d;
    public final String e;

    public f(String str, String str2, String str3, String str4, String str5) {
        str3.getClass();
        this.f11108a = str;
        this.f11109b = str2;
        this.f11110c = str3;
        this.f11111d = str4;
        this.e = str5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f11108a.equals(fVar.f11108a) && this.f11109b.equals(fVar.f11109b) && kotlin.jvm.internal.l.a(this.f11110c, fVar.f11110c) && this.f11111d.equals(fVar.f11111d) && this.e.equals(fVar.e);
    }

    public final int hashCode() {
        return this.e.hashCode() + androidx.constraintlayout.core.widgets.analyzer.a.o(a.a.b(this.f11110c, androidx.constraintlayout.core.widgets.analyzer.a.o(this.f11108a.hashCode() * 31, 31, this.f11109b)), 31, this.f11111d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DisclosureInfo(name=");
        sb.append(this.f11108a);
        sb.append(", type=");
        sb.append(this.f11109b);
        sb.append(", maxAge=");
        sb.append(this.f11110c);
        sb.append(", domain=");
        sb.append(this.f11111d);
        sb.append(", purposes=");
        return a3.a.m(sb, this.e, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f11108a);
        parcel.writeString(this.f11109b);
        parcel.writeString(this.f11110c);
        parcel.writeString(this.f11111d);
        parcel.writeString(this.e);
    }
}

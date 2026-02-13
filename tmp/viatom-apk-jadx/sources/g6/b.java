package g6;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.l;
import l9.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final List f8231a;

    public b(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 33) {
            parcel.readList(arrayList, f.class.getClassLoader(), f.class);
        } else {
            parcel.readList(arrayList, f.class.getClassLoader());
        }
        this.f8231a = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && l.a(this.f8231a, ((b) obj).f8231a);
    }

    public final int hashCode() {
        return this.f8231a.hashCode();
    }

    public final String toString() {
        return "PartnersDisclosureArgs(disclosures=" + this.f8231a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeList(new ArrayList());
    }

    public b(ArrayList arrayList) {
        arrayList.getClass();
        this.f8231a = arrayList;
    }
}

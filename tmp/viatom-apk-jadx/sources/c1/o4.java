package c1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o4 extends j0.a {
    public static final Parcelable.Creator<o4> CREATOR = new android.support.v4.media.f(16);

    /* renamed from: a, reason: collision with root package name */
    public final List f1392a;

    public o4(ArrayList arrayList) {
        this.f1392a = arrayList;
    }

    public static o4 b(j3... j3VarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(j3VarArr[0].f1294a));
        return new o4(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        List list = this.f1392a;
        if (list != null) {
            int I2 = com.google.android.gms.internal.measurement.a4.I(parcel, 1);
            int size = list.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                parcel.writeInt(((Integer) list.get(i11)).intValue());
            }
            com.google.android.gms.internal.measurement.a4.M(parcel, I2);
        }
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

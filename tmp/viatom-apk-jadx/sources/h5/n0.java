package h5;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        parcel.getClass();
        o0 o0Var = new o0();
        o0Var.f8675a = parcel.readString();
        o0Var.f8676b = parcel.readInt();
        o0Var.f8677c = parcel.readInt();
        o0Var.f8678d = parcel.readString();
        ArrayList arrayList = o0Var.e;
        if (arrayList != null && !arrayList.isEmpty()) {
            return o0Var;
        }
        ArrayList arrayList2 = new ArrayList();
        o0Var.e = arrayList2;
        parcel.readList(arrayList2, y.class.getClassLoader());
        return o0Var;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        return new o0[i10];
    }
}

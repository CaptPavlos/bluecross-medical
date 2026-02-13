package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        parcel.getClass();
        y yVar = new y();
        yVar.f8792a = parcel.readString();
        yVar.f8793b = parcel.readString();
        return yVar;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        return new y[i10];
    }
}

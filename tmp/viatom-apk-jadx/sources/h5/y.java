package h5;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class y implements Parcelable {
    public static final x CREATOR = new x();

    /* renamed from: a, reason: collision with root package name */
    public String f8792a;

    /* renamed from: b, reason: collision with root package name */
    public String f8793b;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeString(this.f8792a);
        parcel.writeString(this.f8793b);
    }
}

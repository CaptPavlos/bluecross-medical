package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new android.support.v4.media.f(7);

    /* renamed from: a, reason: collision with root package name */
    public int f395a;

    /* renamed from: b, reason: collision with root package name */
    public int f396b;

    /* renamed from: c, reason: collision with root package name */
    public int f397c;

    /* renamed from: d, reason: collision with root package name */
    public int f398d;
    public int e;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f395a);
        parcel.writeInt(this.f397c);
        parcel.writeInt(this.f398d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f396b);
    }
}

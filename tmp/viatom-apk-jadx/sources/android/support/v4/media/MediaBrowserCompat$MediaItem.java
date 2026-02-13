package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new f(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f368a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f369b;

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f368a = parcel.readInt();
        this.f369b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f368a + ", mDescription=" + this.f369b + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f368a);
        this.f369b.writeToParcel(parcel, i10);
    }
}

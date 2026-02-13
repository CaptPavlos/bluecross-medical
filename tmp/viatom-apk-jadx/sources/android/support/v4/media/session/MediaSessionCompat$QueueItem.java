package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new android.support.v4.media.f(4);

    /* renamed from: a, reason: collision with root package name */
    public final MediaDescriptionCompat f389a;

    /* renamed from: b, reason: collision with root package name */
    public final long f390b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f391c;

    public MediaSessionCompat$QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
        if (mediaDescriptionCompat == null) {
            com.google.gson.internal.a.n("Description cannot be null.");
            throw null;
        }
        if (j10 == -1) {
            com.google.gson.internal.a.n("Id cannot be QueueItem.UNKNOWN_ID");
            throw null;
        }
        this.f389a = mediaDescriptionCompat;
        this.f390b = j10;
        this.f391c = obj;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
        sb.append(this.f389a);
        sb.append(", Id=");
        return a3.a.l(sb, this.f390b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        this.f389a.writeToParcel(parcel, i10);
        parcel.writeLong(this.f390b);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f389a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f390b = parcel.readLong();
    }
}

package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new android.support.v4.media.f(6);

    /* renamed from: a, reason: collision with root package name */
    public final Object f393a;

    /* renamed from: b, reason: collision with root package name */
    public d f394b;

    public MediaSessionCompat$Token(Object obj, d dVar) {
        this.f393a = obj;
        this.f394b = dVar;
    }

    public static MediaSessionCompat$Token a(Parcelable parcelable, d dVar) {
        if (parcelable == null) {
            return null;
        }
        if (parcelable instanceof MediaSession.Token) {
            return new MediaSessionCompat$Token(parcelable, dVar);
        }
        com.google.gson.internal.a.n("token is not a valid MediaSession.Token object");
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        Object obj2 = ((MediaSessionCompat$Token) obj).f393a;
        Object obj3 = this.f393a;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f393a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable((Parcelable) this.f393a, i10);
    }
}

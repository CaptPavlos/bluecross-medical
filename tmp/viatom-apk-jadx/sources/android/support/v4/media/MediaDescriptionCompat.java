package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new f(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f370a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f371b;

    /* renamed from: c, reason: collision with root package name */
    public final CharSequence f372c;

    /* renamed from: d, reason: collision with root package name */
    public final CharSequence f373d;
    public final Bitmap e;
    public final Uri f;
    public final Bundle g;
    public final Uri h;

    /* renamed from: i, reason: collision with root package name */
    public Object f374i;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f370a = str;
        this.f371b = charSequence;
        this.f372c = charSequence2;
        this.f373d = charSequence3;
        this.e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Uri mediaUri;
        Bundle bundle;
        if (obj == null) {
            return null;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        String mediaId = mediaDescription.getMediaId();
        CharSequence title = mediaDescription.getTitle();
        CharSequence subtitle = mediaDescription.getSubtitle();
        CharSequence description = mediaDescription.getDescription();
        Bitmap iconBitmap = mediaDescription.getIconBitmap();
        Uri iconUri = mediaDescription.getIconUri();
        Bundle extras = mediaDescription.getExtras();
        if (extras != null) {
            m.a(extras);
            mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            mediaUri = null;
        }
        if (mediaUri == null) {
            bundle = extras;
        } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
            bundle = null;
        } else {
            extras.remove("android.support.v4.media.description.MEDIA_URI");
            extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = extras;
        }
        if (mediaUri == null) {
            mediaUri = mediaDescription.getMediaUri();
        }
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
        mediaDescriptionCompat.f374i = obj;
        return mediaDescriptionCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f371b) + ", " + ((Object) this.f372c) + ", " + ((Object) this.f373d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        Object objBuild = this.f374i;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f370a);
            builder.setTitle(this.f371b);
            builder.setSubtitle(this.f372c);
            builder.setDescription(this.f373d);
            builder.setIconBitmap(this.e);
            builder.setIconUri(this.f);
            builder.setExtras(this.g);
            builder.setMediaUri(this.h);
            objBuild = builder.build();
            this.f374i = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i10);
    }
}

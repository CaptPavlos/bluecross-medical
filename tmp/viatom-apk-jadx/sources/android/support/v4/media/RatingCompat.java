package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new f(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f376a;

    /* renamed from: b, reason: collision with root package name */
    public final float f377b;

    public RatingCompat(int i10, float f) {
        this.f376a = i10;
        this.f377b = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f376a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f376a);
        sb.append(" rating=");
        float f = this.f377b;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f376a);
        parcel.writeFloat(this.f377b);
    }
}

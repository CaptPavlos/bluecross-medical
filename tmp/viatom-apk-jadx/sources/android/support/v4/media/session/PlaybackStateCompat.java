package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new android.support.v4.media.f(8);

    /* renamed from: a, reason: collision with root package name */
    public final int f399a;

    /* renamed from: b, reason: collision with root package name */
    public final long f400b;

    /* renamed from: c, reason: collision with root package name */
    public final long f401c;

    /* renamed from: d, reason: collision with root package name */
    public final float f402d;
    public final long e;
    public final int f;
    public final CharSequence g;
    public final long h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f403i;

    /* renamed from: j, reason: collision with root package name */
    public final long f404j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f405k;

    public PlaybackStateCompat(Parcel parcel) {
        this.f399a = parcel.readInt();
        this.f400b = parcel.readLong();
        this.f402d = parcel.readFloat();
        this.h = parcel.readLong();
        this.f401c = parcel.readLong();
        this.e = parcel.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f403i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f404j = parcel.readLong();
        this.f405k = parcel.readBundle(m.class.getClassLoader());
        this.f = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f399a);
        sb.append(", position=");
        sb.append(this.f400b);
        sb.append(", buffered position=");
        sb.append(this.f401c);
        sb.append(", speed=");
        sb.append(this.f402d);
        sb.append(", updated=");
        sb.append(this.h);
        sb.append(", actions=");
        sb.append(this.e);
        sb.append(", error code=");
        sb.append(this.f);
        sb.append(", error message=");
        sb.append(this.g);
        sb.append(", custom actions=");
        sb.append(this.f403i);
        sb.append(", active item id=");
        return a3.a.l(sb, this.f404j, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f399a);
        parcel.writeLong(this.f400b);
        parcel.writeFloat(this.f402d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.f401c);
        parcel.writeLong(this.e);
        TextUtils.writeToParcel(this.g, parcel, i10);
        parcel.writeTypedList(this.f403i);
        parcel.writeLong(this.f404j);
        parcel.writeBundle(this.f405k);
        parcel.writeInt(this.f);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new n();

        /* renamed from: a, reason: collision with root package name */
        public final String f406a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f407b;

        /* renamed from: c, reason: collision with root package name */
        public final int f408c;

        /* renamed from: d, reason: collision with root package name */
        public final Bundle f409d;
        public Object e;

        public CustomAction(Parcel parcel) {
            this.f406a = parcel.readString();
            this.f407b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f408c = parcel.readInt();
            this.f409d = parcel.readBundle(m.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f407b) + ", mIcon=" + this.f408c + ", mExtras=" + this.f409d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f406a);
            TextUtils.writeToParcel(this.f407b, parcel, i10);
            parcel.writeInt(this.f408c);
            parcel.writeBundle(this.f409d);
        }

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f406a = str;
            this.f407b = charSequence;
            this.f408c = i10;
            this.f409d = bundle;
        }
    }

    public PlaybackStateCompat(int i10, long j10, long j11, float f, long j12, CharSequence charSequence, long j13, ArrayList arrayList, long j14, Bundle bundle) {
        this.f399a = i10;
        this.f400b = j10;
        this.f401c = j11;
        this.f402d = f;
        this.e = j12;
        this.f = 0;
        this.g = charSequence;
        this.h = j13;
        this.f403i = new ArrayList(arrayList);
        this.f404j = j14;
        this.f405k = bundle;
    }
}

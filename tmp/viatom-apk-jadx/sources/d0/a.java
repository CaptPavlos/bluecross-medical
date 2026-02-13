package d0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends j0.a {

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.f(21);

    /* renamed from: a, reason: collision with root package name */
    public final int f6762a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6763b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f6764c;

    public a(int i10, int i11, Bundle bundle) {
        this.f6762a = i10;
        this.f6763b = i11;
        this.f6764c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f6762a);
        a4.O(parcel, 2, 4);
        parcel.writeInt(this.f6763b);
        a4.C(3, this.f6764c, parcel);
        a4.M(parcel, I);
    }
}

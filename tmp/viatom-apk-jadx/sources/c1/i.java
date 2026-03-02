package c1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends j0.a {
    public static final Parcelable.Creator<i> CREATOR = new android.support.v4.media.f(11);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f1267a;

    public i(Bundle bundle) {
        this.f1267a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.C(1, this.f1267a, parcel);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

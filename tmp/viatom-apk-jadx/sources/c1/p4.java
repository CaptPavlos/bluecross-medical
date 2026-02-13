package c1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p4 extends j0.a {
    public static final Parcelable.Creator<p4> CREATOR = new android.support.v4.media.f(17);

    /* renamed from: a, reason: collision with root package name */
    public final List f1404a;

    public p4(ArrayList arrayList) {
        this.f1404a = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.H(parcel, 1, this.f1404a);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

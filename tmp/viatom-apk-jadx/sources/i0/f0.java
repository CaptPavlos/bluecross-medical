package i0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends j0.a {
    public static final Parcelable.Creator<f0> CREATOR = new g0.l(24);

    /* renamed from: a, reason: collision with root package name */
    public Bundle f8887a;

    /* renamed from: b, reason: collision with root package name */
    public f0.d[] f8888b;

    /* renamed from: c, reason: collision with root package name */
    public int f8889c;

    /* renamed from: d, reason: collision with root package name */
    public f f8890d;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.C(1, this.f8887a, parcel);
        a4.G(parcel, 2, this.f8888b, i10);
        int i11 = this.f8889c;
        a4.O(parcel, 3, 4);
        parcel.writeInt(i11);
        a4.E(parcel, 4, this.f8890d, i10);
        a4.M(parcel, I);
    }
}

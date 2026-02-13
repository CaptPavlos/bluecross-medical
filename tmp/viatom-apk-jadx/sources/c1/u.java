package c1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends j0.a implements Iterable {
    public static final Parcelable.Creator<u> CREATOR = new android.support.v4.media.f(12);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f1470a;

    public u(Bundle bundle) {
        this.f1470a = bundle;
    }

    public final Object b(String str) {
        return this.f1470a.get(str);
    }

    public final Double c() {
        return Double.valueOf(this.f1470a.getDouble("value"));
    }

    public final String d() {
        return this.f1470a.getString("currency");
    }

    public final Bundle e() {
        return new Bundle(this.f1470a);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new t(this);
    }

    public final String toString() {
        return this.f1470a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = com.google.android.gms.internal.measurement.a4.I(parcel, 20293);
        com.google.android.gms.internal.measurement.a4.C(2, e(), parcel);
        com.google.android.gms.internal.measurement.a4.M(parcel, I);
    }
}

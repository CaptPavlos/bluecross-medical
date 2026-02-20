package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.measurement.a4;
import i0.y;
import j0.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Scope extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new f(29);

    /* renamed from: a, reason: collision with root package name */
    public final int f1855a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1856b;

    public Scope(int i10, String str) {
        y.e(str, "scopeUri must not be null or empty");
        this.f1855a = i10;
        this.f1856b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1856b.equals(((Scope) obj).f1856b);
    }

    public final int hashCode() {
        return this.f1856b.hashCode();
    }

    public final String toString() {
        return this.f1856b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f1855a);
        a4.F(parcel, 2, this.f1856b);
        a4.M(parcel, I);
    }
}

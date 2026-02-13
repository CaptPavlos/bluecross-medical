package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class x0 extends j0.a {
    public static final Parcelable.Creator<x0> CREATOR = new w0(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f2254a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2255b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f2256c;

    public x0(int i10, String str, Intent intent) {
        this.f2254a = i10;
        this.f2255b = str;
        this.f2256c = intent;
    }

    public static x0 b(Activity activity) {
        return new x0(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.f2254a == x0Var.f2254a && Objects.equals(this.f2255b, x0Var.f2255b) && Objects.equals(this.f2256c, x0Var.f2256c);
    }

    public final int hashCode() {
        return this.f2254a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f2254a);
        a4.F(parcel, 2, this.f2255b);
        a4.E(parcel, 3, this.f2256c, i10);
        a4.M(parcel, I);
    }
}

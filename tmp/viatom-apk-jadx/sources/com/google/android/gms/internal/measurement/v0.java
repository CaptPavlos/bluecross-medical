package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v0 extends j0.a {
    public static final Parcelable.Creator<v0> CREATOR = new w0(0);

    /* renamed from: a, reason: collision with root package name */
    public final long f2200a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2201b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2202c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f2203d;
    public final String e;

    public v0(long j10, long j11, boolean z9, Bundle bundle, String str) {
        this.f2200a = j10;
        this.f2201b = j11;
        this.f2202c = z9;
        this.f2203d = bundle;
        this.e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 8);
        parcel.writeLong(this.f2200a);
        a4.O(parcel, 2, 8);
        parcel.writeLong(this.f2201b);
        a4.O(parcel, 3, 4);
        parcel.writeInt(this.f2202c ? 1 : 0);
        a4.C(7, this.f2203d, parcel);
        a4.F(parcel, 8, this.e);
        a4.M(parcel, I);
    }
}

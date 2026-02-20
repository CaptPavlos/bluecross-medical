package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 extends y implements s0 {

    /* renamed from: a, reason: collision with root package name */
    public final o1.b f1990a;

    public i1(o1.b bVar) {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        this.f1990a = bVar;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 != 1) {
            if (i10 != 2) {
                return false;
            }
            int iIdentityHashCode = System.identityHashCode(this.f1990a);
            parcel2.writeNoException();
            parcel2.writeInt(iIdentityHashCode);
            return true;
        }
        String string = parcel.readString();
        String string2 = parcel.readString();
        Bundle bundle = (Bundle) z.a(parcel, Bundle.CREATOR);
        long j10 = parcel.readLong();
        z.d(parcel);
        l(j10, bundle, string, string2);
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final int b() {
        return System.identityHashCode(this.f1990a);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void l(long j10, Bundle bundle, String str, String str2) {
        this.f1990a.a(j10, bundle, str, str2);
    }
}

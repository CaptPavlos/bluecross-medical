package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 extends x implements s0 {
    public q0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy", 0);
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final int b() {
        Parcel parcelD = d(G(), 2);
        int i10 = parcelD.readInt();
        parcelD.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.s0
    public final void l(long j10, Bundle bundle, String str, String str2) {
        Parcel parcelG = G();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        z.b(parcelG, bundle);
        parcelG.writeLong(j10);
        H(parcelG, 1);
    }
}

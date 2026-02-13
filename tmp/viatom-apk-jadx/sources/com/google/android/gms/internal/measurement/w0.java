package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w0 implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2245a;

    public /* synthetic */ w0(int i10) {
        this.f2245a = i10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2245a) {
            case 0:
                int iQ = a.a.Q(parcel);
                Bundle bundleR = null;
                String strT = null;
                boolean zI = false;
                long jM = 0;
                long jM2 = 0;
                while (parcel.dataPosition() < iQ) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        jM = a.a.M(parcel, i10);
                    } else if (c10 == 2) {
                        jM2 = a.a.M(parcel, i10);
                    } else if (c10 == 3) {
                        zI = a.a.I(parcel, i10);
                    } else if (c10 == 7) {
                        bundleR = a.a.r(parcel, i10);
                    } else if (c10 != '\b') {
                        a.a.O(parcel, i10);
                    } else {
                        strT = a.a.t(parcel, i10);
                    }
                }
                a.a.y(parcel, iQ);
                return new v0(jM, jM2, zI, bundleR, strT);
            default:
                int iQ2 = a.a.Q(parcel);
                String strT2 = null;
                int iL = 0;
                Intent intent = null;
                while (parcel.dataPosition() < iQ2) {
                    int i11 = parcel.readInt();
                    char c11 = (char) i11;
                    if (c11 == 1) {
                        iL = a.a.L(parcel, i11);
                    } else if (c11 == 2) {
                        strT2 = a.a.t(parcel, i11);
                    } else if (c11 != 3) {
                        a.a.O(parcel, i11);
                    } else {
                        intent = (Intent) a.a.s(parcel, i11, Intent.CREATOR);
                    }
                }
                a.a.y(parcel, iQ2);
                return new x0(iL, strT2, intent);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        switch (this.f2245a) {
            case 0:
                return new v0[i10];
            default:
                return new x0[i10];
        }
    }
}

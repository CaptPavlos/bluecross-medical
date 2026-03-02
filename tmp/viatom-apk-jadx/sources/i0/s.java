package i0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.a4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends j0.a {
    public static final Parcelable.Creator<s> CREATOR = new g0.l(22);

    /* renamed from: a, reason: collision with root package name */
    public final int f8946a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f8947b;

    /* renamed from: c, reason: collision with root package name */
    public final f0.b f8948c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8949d;
    public final boolean e;

    public s(int i10, IBinder iBinder, f0.b bVar, boolean z9, boolean z10) {
        this.f8946a = i10;
        this.f8947b = iBinder;
        this.f8948c = bVar;
        this.f8949d = z9;
        this.e = z10;
    }

    public final boolean equals(Object obj) {
        Object l0Var;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        if (!this.f8948c.equals(sVar.f8948c)) {
            return false;
        }
        Object l0Var2 = null;
        IBinder iBinder = this.f8947b;
        if (iBinder == null) {
            l0Var = null;
        } else {
            int i10 = a.f8858b;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            l0Var = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new l0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 3);
        }
        IBinder iBinder2 = sVar.f8947b;
        if (iBinder2 != null) {
            int i11 = a.f8858b;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            l0Var2 = iInterfaceQueryLocalInterface2 instanceof i ? (i) iInterfaceQueryLocalInterface2 : new l0(iBinder2, "com.google.android.gms.common.internal.IAccountAccessor", 3);
        }
        return y.j(l0Var, l0Var2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int I = a4.I(parcel, 20293);
        a4.O(parcel, 1, 4);
        parcel.writeInt(this.f8946a);
        a4.D(parcel, 2, this.f8947b);
        a4.E(parcel, 3, this.f8948c, i10);
        a4.O(parcel, 4, 4);
        parcel.writeInt(this.f8949d ? 1 : 0);
        a4.O(parcel, 5, 4);
        parcel.writeInt(this.e ? 1 : 0);
        a4.M(parcel, I);
    }
}

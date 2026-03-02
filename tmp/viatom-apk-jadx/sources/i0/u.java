package i0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final IBinder f8954a;

    public u(IBinder iBinder) {
        this.f8954a = iBinder;
    }

    public final void a(b0 b0Var, g gVar) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(b0Var);
            parcelObtain.writeInt(1);
            g0.l.a(gVar, parcelObtain, 0);
            this.f8954a.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8954a;
    }
}

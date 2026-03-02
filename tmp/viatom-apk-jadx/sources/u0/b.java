package u0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import h0.v;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b extends Binder implements IInterface {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12881a;

    public b(String str, int i10) {
        this.f12881a = i10;
        switch (i10) {
            case 2:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    public abstract boolean G(int i10, Parcel parcel, Parcel parcel2);

    public boolean H(int i10, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i10 = this.f12881a;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        switch (this.f12881a) {
            case 0:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                return G(i10, parcel, parcel2);
            case 1:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                v vVar = (v) this;
                switch (i10) {
                    case 3:
                        v0.a.b(parcel);
                        break;
                    case 4:
                        v0.a.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        v0.a.b(parcel);
                        break;
                    case 7:
                        v0.a.b(parcel);
                        break;
                    case 8:
                        f1.e eVar = (f1.e) v0.a.a(parcel, f1.e.CREATOR);
                        v0.a.b(parcel);
                        vVar.f8406k.post(new k1.a(vVar, eVar, 18, false));
                        break;
                    case 9:
                        v0.a.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
            default:
                if (i10 <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i10, parcel, parcel2, i11)) {
                    return true;
                }
                return H(i10, parcel, parcel2);
        }
    }
}

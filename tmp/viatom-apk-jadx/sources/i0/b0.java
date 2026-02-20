package i0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 extends u0.b {

    /* renamed from: b, reason: collision with root package name */
    public e f8860b;

    /* renamed from: k, reason: collision with root package name */
    public final int f8861k;

    public b0(e eVar, int i10) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 2);
        this.f8860b = eVar;
        this.f8861k = i10;
    }

    @Override // u0.b
    public final boolean H(int i10, Parcel parcel, Parcel parcel2) {
        if (i10 == 1) {
            int i11 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) x0.a.a(parcel, Bundle.CREATOR);
            x0.a.b(parcel);
            y.h(this.f8860b, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar = this.f8860b;
            int i12 = this.f8861k;
            eVar.getClass();
            d0 d0Var = new d0(eVar, i11, strongBinder, bundle);
            a0 a0Var = eVar.f;
            a0Var.sendMessage(a0Var.obtainMessage(1, i12, -1, d0Var));
            this.f8860b = null;
        } else if (i10 == 2) {
            parcel.readInt();
            x0.a.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i10 != 3) {
                return false;
            }
            int i13 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            f0 f0Var = (f0) x0.a.a(parcel, f0.CREATOR);
            x0.a.b(parcel);
            e eVar2 = this.f8860b;
            y.h(eVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            y.g(f0Var);
            eVar2.f8881v = f0Var;
            if (eVar2 instanceof t0.a) {
                f fVar = f0Var.f8890d;
                l lVarE = l.e();
                m mVar = fVar == null ? null : fVar.f8883a;
                synchronized (lVarE) {
                    if (mVar == null) {
                        mVar = l.f8927c;
                    } else {
                        m mVar2 = (m) lVarE.f8928a;
                        if (mVar2 == null || mVar2.f8929a < mVar.f8929a) {
                        }
                    }
                    lVarE.f8928a = mVar;
                }
            }
            Bundle bundle2 = f0Var.f8887a;
            y.h(this.f8860b, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar3 = this.f8860b;
            int i14 = this.f8861k;
            eVar3.getClass();
            d0 d0Var2 = new d0(eVar3, i13, strongBinder2, bundle2);
            a0 a0Var2 = eVar3.f;
            a0Var2.sendMessage(a0Var2.obtainMessage(1, i14, -1, d0Var2));
            this.f8860b = null;
        }
        parcel2.writeNoException();
        return true;
    }
}

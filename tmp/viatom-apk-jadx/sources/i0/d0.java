package i0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d0 extends t {
    public final IBinder g;
    public final /* synthetic */ e h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(e eVar, int i10, IBinder iBinder, Bundle bundle) {
        super(eVar, i10, bundle);
        this.h = eVar;
        this.g = iBinder;
    }

    @Override // i0.t
    public final void a(f0.b bVar) {
        c cVar = this.h.f8876p;
        if (cVar != null) {
            cVar.a(bVar);
        }
        System.currentTimeMillis();
    }

    @Override // i0.t
    public final boolean b() throws RemoteException {
        IBinder iBinder = this.g;
        try {
            y.g(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            e eVar = this.h;
            if (!eVar.u().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + eVar.u() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceN = eVar.n(iBinder);
            if (iInterfaceN == null || !(e.y(eVar, 2, 4, iInterfaceN) || e.y(eVar, 3, 4, iInterfaceN))) {
                return false;
            }
            eVar.t = null;
            b bVar = eVar.f8875o;
            if (bVar == null) {
                return true;
            }
            bVar.d();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}

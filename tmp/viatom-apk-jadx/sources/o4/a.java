package o4;

import android.app.Activity;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import r0.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements NsdManager.RegistrationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f11709a;

    public a(b bVar) {
        this.f11709a = bVar;
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        nsdServiceInfo.getClass();
        this.f11709a.b();
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        Activity activity = b.g;
        String serviceName = nsdServiceInfo.getServiceName();
        serviceName.getClass();
        b.f11715n = serviceName;
        this.f11709a.f11729d.set(true);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        b bVar = this.f11709a;
        AtomicBoolean atomicBoolean = bVar.f11727b;
        if (atomicBoolean.get()) {
            bVar.f11729d.set(false);
        }
        if (bVar.f11728c.get() || !atomicBoolean.compareAndSet(true, false)) {
            return;
        }
        Activity activity = b.g;
        bVar.a(f.z());
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        nsdServiceInfo.getClass();
    }
}

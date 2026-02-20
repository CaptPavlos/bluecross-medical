package v4;

import android.app.Activity;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements NsdManager.DiscoveryListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f13131a;

    public c(f fVar) {
        this.f13131a = fVar;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStarted(String str) {
        str.getClass();
        ((o4.b) this.f13131a.f13134a.f10654b).f11728c.set(true);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onDiscoveryStopped(String str) {
        str.getClass();
        o4.b bVar = (o4.b) this.f13131a.f13134a.f10654b;
        bVar.f11728c.set(false);
        if (bVar.f11729d.get() || !bVar.f11727b.compareAndSet(true, false)) {
            return;
        }
        Activity activity = o4.b.g;
        bVar.a(r0.f.z());
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceFound(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        String serviceName = nsdServiceInfo.getServiceName();
        if (!l.a(nsdServiceInfo.getServiceType(), "_nsduptodown._tcp.") || serviceName == null || serviceName.length() == 0) {
            return;
        }
        String str = o4.b.f11715n;
        if (str == null) {
            l.i("myNsdServiceName");
            throw null;
        }
        if (serviceName.equalsIgnoreCase(str)) {
            return;
        }
        this.f13131a.g.add(nsdServiceInfo);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onServiceLost(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        ArrayList arrayList = this.f13131a.g;
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            it.getClass();
            int i10 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                if (l.a(((NsdServiceInfo) next).getServiceName(), nsdServiceInfo.getServiceName())) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 < arrayList.size()) {
                arrayList.remove(i10);
            }
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStartDiscoveryFailed(String str, int i10) {
        str.getClass();
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public final void onStopDiscoveryFailed(String str, int i10) {
        str.getClass();
    }
}

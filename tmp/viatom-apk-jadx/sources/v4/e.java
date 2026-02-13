package v4;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements NsdManager.ResolveListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f13133a;

    public e(f fVar) {
        this.f13133a = fVar;
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onResolveFailed(NsdServiceInfo nsdServiceInfo, int i10) {
        nsdServiceInfo.getClass();
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public final void onServiceResolved(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        f.a(this.f13133a, nsdServiceInfo);
    }
}

package v4;

import android.net.nsd.NsdManager$ServiceInfoCallback;
import android.net.nsd.NsdServiceInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements NsdManager$ServiceInfoCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f13132a;

    public d(f fVar) {
        this.f13132a = fVar;
    }

    public final void onServiceUpdated(NsdServiceInfo nsdServiceInfo) {
        nsdServiceInfo.getClass();
        f.a(this.f13132a, nsdServiceInfo);
    }

    public final void onServiceInfoCallbackUnregistered() {
    }

    public final void onServiceLost() {
    }

    public final void onServiceInfoCallbackRegistrationFailed(int i10) {
    }
}

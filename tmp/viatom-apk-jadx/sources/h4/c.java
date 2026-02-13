package h4;

import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Handler;
import android.os.Looper;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f8447a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f8448b;

    public c(d dVar) {
        this.f8448b = dVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        network.getClass();
        this.f8447a.post(new b(this.f8448b, 0));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        network.getClass();
        this.f8447a.post(new b(this.f8448b, 1));
    }
}

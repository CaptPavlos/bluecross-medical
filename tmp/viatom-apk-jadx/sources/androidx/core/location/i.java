package androidx.core.location;

import androidx.core.location.LocationManagerCompat;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f497b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f498c;

    public /* synthetic */ i(LocationManagerCompat.LocationListenerTransport locationListenerTransport, String str, int i10) {
        this.f496a = i10;
        this.f497b = locationListenerTransport;
        this.f498c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f496a) {
            case 0:
                this.f497b.lambda$onProviderEnabled$4(this.f498c);
                break;
            default:
                this.f497b.lambda$onProviderDisabled$5(this.f498c);
                break;
        }
    }
}

package androidx.core.location;

import android.location.Location;
import androidx.core.location.LocationManagerCompat;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f499a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.LocationListenerTransport f500b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f501c;

    public /* synthetic */ j(LocationManagerCompat.LocationListenerTransport locationListenerTransport, Object obj, int i10) {
        this.f499a = i10;
        this.f500b = locationListenerTransport;
        this.f501c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f499a) {
            case 0:
                this.f500b.lambda$onLocationChanged$1((List) this.f501c);
                break;
            default:
                this.f500b.lambda$onLocationChanged$0((Location) this.f501c);
                break;
        }
    }
}

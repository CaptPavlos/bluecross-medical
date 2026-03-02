package androidx.core.location;

import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f486b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f487c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f488d;

    public /* synthetic */ f(Object obj, Executor executor, Object obj2, int i10) {
        this.f485a = i10;
        this.f487c = obj;
        this.f486b = executor;
        this.f488d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f485a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f487c).lambda$onGnssMeasurementsReceived$0(this.f486b, (GnssMeasurementsEvent) this.f488d);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f487c).lambda$onGpsStatusChanged$3(this.f486b, (GnssStatusCompat) this.f488d);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f487c).lambda$onSatelliteStatusChanged$3(this.f486b, (GnssStatus) this.f488d);
                break;
        }
    }
}

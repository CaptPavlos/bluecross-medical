package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f489a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Executor f490b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f491c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f492d;

    public /* synthetic */ g(Object obj, Executor executor, int i10, int i11) {
        this.f489a = i11;
        this.f492d = obj;
        this.f490b = executor;
        this.f491c = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f489a) {
            case 0:
                ((LocationManagerCompat.GnssMeasurementsTransport) this.f492d).lambda$onStatusChanged$1(this.f490b, this.f491c);
                break;
            case 1:
                ((LocationManagerCompat.GpsStatusTransport) this.f492d).lambda$onGpsStatusChanged$2(this.f490b, this.f491c);
                break;
            default:
                ((LocationManagerCompat.PreRGnssStatusTransport) this.f492d).lambda$onFirstFix$2(this.f490b, this.f491c);
                break;
        }
    }
}

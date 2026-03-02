package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f508a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LocationManagerCompat.PreRGnssStatusTransport f509b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Executor f510c;

    public /* synthetic */ m(LocationManagerCompat.PreRGnssStatusTransport preRGnssStatusTransport, Executor executor, int i10) {
        this.f508a = i10;
        this.f509b = preRGnssStatusTransport;
        this.f510c = executor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f508a) {
            case 0:
                this.f509b.lambda$onStopped$1(this.f510c);
                break;
            default:
                this.f509b.lambda$onStarted$0(this.f510c);
                break;
        }
    }
}

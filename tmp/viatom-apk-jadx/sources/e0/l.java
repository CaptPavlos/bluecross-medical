package e0;

import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f7612a;

    /* renamed from: b, reason: collision with root package name */
    public final h1.i f7613b = new h1.i();

    /* renamed from: c, reason: collision with root package name */
    public final int f7614c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f7615d;
    public final /* synthetic */ int e;

    public l(int i10, int i11, Bundle bundle, int i12) {
        this.e = i12;
        this.f7612a = i10;
        this.f7614c = i11;
        this.f7615d = bundle;
    }

    public final boolean a() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void b(m mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + mVar.toString());
        }
        this.f7613b.f8418a.k(mVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f7613b.a(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f7614c + " id=" + this.f7612a + " oneWay=" + a() + "}";
    }
}

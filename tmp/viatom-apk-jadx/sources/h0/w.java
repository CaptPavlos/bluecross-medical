package h0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w extends z {

    /* renamed from: b, reason: collision with root package name */
    public final d0.g f8412b;

    public w(d0.g gVar) {
        super(1);
        this.f8412b = gVar;
    }

    @Override // h0.z
    public final void a(Status status) {
        try {
            this.f8412b.g(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // h0.z
    public final void b(Exception exc) {
        try {
            this.f8412b.g(new Status(10, a3.a.j(exc.getClass().getSimpleName(), ": ", exc.getLocalizedMessage()), null, null));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // h0.z
    public final void c(n nVar) throws DeadObjectException {
        try {
            d0.g gVar = this.f8412b;
            g0.b bVar = nVar.f8381b;
            gVar.getClass();
            try {
                gVar.f(bVar);
            } catch (DeadObjectException e) {
                gVar.g(new Status(8, e.getLocalizedMessage(), null, null));
                throw e;
            } catch (RemoteException e3) {
                gVar.g(new Status(8, e3.getLocalizedMessage(), null, null));
            }
        } catch (RuntimeException e7) {
            b(e7);
        }
    }

    @Override // h0.z
    public final void d(a4.f fVar, boolean z9) {
        Boolean boolValueOf = Boolean.valueOf(z9);
        Map map = (Map) fVar.f218b;
        d0.g gVar = this.f8412b;
        map.put(gVar, boolValueOf);
        gVar.a(new j(fVar, gVar));
    }
}

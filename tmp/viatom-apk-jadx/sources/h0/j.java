package h0;

import c1.d0;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8373a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f8374b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f8375c;

    public j(a4.f fVar, BasePendingResult basePendingResult) {
        this.f8375c = fVar;
        this.f8374b = basePendingResult;
    }

    public final void a(Status status) {
        g0.i iVar;
        switch (this.f8373a) {
            case 0:
                ((Map) ((a4.f) this.f8375c).f218b).remove(this.f8374b);
                return;
            default:
                if (status.f1858a > 0) {
                    ((h1.i) this.f8375c).f8418a.k(status.f1860c != null ? new g0.h(status) : new e0.m(status));
                    return;
                }
                BasePendingResult basePendingResult = this.f8374b;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                i0.y.i(!basePendingResult.g, "Result has already been consumed.");
                try {
                    if (!basePendingResult.f1864b.await(0L, timeUnit)) {
                        basePendingResult.c(Status.h);
                    }
                } catch (InterruptedException unused) {
                    basePendingResult.c(Status.f);
                }
                i0.y.i(basePendingResult.d(), "Result is not ready.");
                synchronized (basePendingResult.f1863a) {
                    i0.y.i(!basePendingResult.g, "Result has already been consumed.");
                    i0.y.i(basePendingResult.d(), "Result is not ready.");
                    iVar = basePendingResult.e;
                    basePendingResult.e = null;
                    basePendingResult.g = true;
                }
                if (basePendingResult.f1866d.getAndSet(null) != null) {
                    com.google.gson.internal.a.k();
                    return;
                } else {
                    i0.y.g(iVar);
                    ((h1.i) this.f8375c).a(null);
                    return;
                }
        }
    }

    public j(BasePendingResult basePendingResult, h1.i iVar, d0 d0Var) {
        this.f8374b = basePendingResult;
        this.f8375c = iVar;
    }
}

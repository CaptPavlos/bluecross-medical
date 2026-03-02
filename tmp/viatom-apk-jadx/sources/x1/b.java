package x1;

import h1.p;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import r0.f;
import w1.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f13571a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13572b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public p f13573c = f.x(null);

    public b(ExecutorService executorService) {
        this.f13571a = executorService;
    }

    public final p a(Runnable runnable) {
        p pVarE;
        synchronized (this.f13572b) {
            pVarE = this.f13573c.e(this.f13571a, new v.e(runnable, 9));
            this.f13573c = pVarE;
        }
        return pVarE;
    }

    public final p b(j jVar) {
        p pVarE;
        synchronized (this.f13572b) {
            pVarE = this.f13573c.e(this.f13571a, new v.e(jVar, 8));
            this.f13573c = pVarE;
        }
        return pVarE;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f13571a.execute(runnable);
    }
}

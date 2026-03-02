package y7;

import java.util.concurrent.Executor;
import r7.s;
import r7.t0;
import w7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends t0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final d f14116a = new d();

    /* renamed from: b, reason: collision with root package name */
    public static final s f14117b;

    static {
        k kVar = k.f14128a;
        int i10 = u.f13557a;
        if (64 >= i10) {
            i10 = 64;
        }
        f14117b = s.limitedParallelism$default(kVar, w7.a.j(i10, 12, "kotlinx.coroutines.io.parallelism"), null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        f14117b.dispatch(hVar, runnable);
    }

    @Override // r7.s
    public final void dispatchYield(w6.h hVar, Runnable runnable) {
        f14117b.dispatchYield(hVar, runnable);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        dispatch(w6.i.f13523a, runnable);
    }

    @Override // r7.s
    public final s limitedParallelism(int i10, String str) {
        return k.f14128a.limitedParallelism(i10, str);
    }

    @Override // r7.s
    public final String toString() {
        return "Dispatchers.IO";
    }

    @Override // r7.t0
    public final Executor l() {
        return this;
    }
}

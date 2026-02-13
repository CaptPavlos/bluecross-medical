package y7;

import java.util.concurrent.Executor;
import r7.s;
import r7.t0;
import w7.o;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends t0 {

    /* renamed from: b, reason: collision with root package name */
    public static final e f14118b;

    /* renamed from: a, reason: collision with root package name */
    public c f14119a;

    static {
        int i10 = j.f14126c;
        int i11 = j.f14127d;
        long j10 = j.e;
        String str = j.f14124a;
        e eVar = new e();
        eVar.f14119a = new c(i10, j10, str, i11);
        f14118b = eVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        c.d(this.f14119a, runnable, 6);
    }

    @Override // r7.s
    public final void dispatchYield(w6.h hVar, Runnable runnable) {
        c.d(this.f14119a, runnable, 2);
    }

    @Override // r7.t0
    public final Executor l() {
        return this.f14119a;
    }

    @Override // r7.s
    public final s limitedParallelism(int i10, String str) {
        w7.a.a(i10);
        return i10 >= j.f14126c ? str != null ? new o(this, str) : this : super.limitedParallelism(i10, str);
    }

    @Override // r7.s
    public final String toString() {
        return "Dispatchers.Default";
    }
}

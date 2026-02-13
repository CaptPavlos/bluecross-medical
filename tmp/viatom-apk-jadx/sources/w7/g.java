package w7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import r7.a0;
import r7.d0;
import r7.k0;
import r7.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g extends r7.s implements d0 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(g.class, "runningWorkers$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f13534a;

    /* renamed from: b, reason: collision with root package name */
    public final r7.s f13535b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13536c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13537d;
    public final k e;
    public final Object f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX WARN: Multi-variable type inference failed */
    public g(r7.s sVar, int i10, String str) {
        d0 d0Var = sVar instanceof d0 ? (d0) sVar : null;
        this.f13534a = d0Var == null ? a0.f12388a : d0Var;
        this.f13535b = sVar;
        this.f13536c = i10;
        this.f13537d = str;
        this.e = new k();
        this.f = new Object();
    }

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        Runnable runnableL;
        this.e.a(runnable);
        if (g.get(this) >= this.f13536c || !n() || (runnableL = l()) == null) {
            return;
        }
        this.f13535b.dispatch(this, new r5.a(7, this, runnableL));
    }

    @Override // r7.s
    public final void dispatchYield(w6.h hVar, Runnable runnable) {
        Runnable runnableL;
        this.e.a(runnable);
        if (g.get(this) >= this.f13536c || !n() || (runnableL = l()) == null) {
            return;
        }
        this.f13535b.dispatchYield(this, new r5.a(7, this, runnableL));
    }

    @Override // r7.d0
    public final void f(long j10, r7.g gVar) {
        this.f13534a.f(j10, gVar);
    }

    @Override // r7.d0
    public final k0 k(long j10, t1 t1Var, w6.h hVar) {
        return this.f13534a.k(j10, t1Var, hVar);
    }

    public final Runnable l() {
        while (true) {
            Runnable runnable = (Runnable) this.e.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.e.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    @Override // r7.s
    public final r7.s limitedParallelism(int i10, String str) {
        a.a(i10);
        return i10 >= this.f13536c ? str != null ? new o(this, str) : this : super.limitedParallelism(i10, str);
    }

    public final boolean n() {
        synchronized (this.f) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = g;
            if (atomicIntegerFieldUpdater.get(this) >= this.f13536c) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // r7.s
    public final String toString() {
        String str = this.f13537d;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13535b);
        sb.append(".limitedParallelism(");
        return a3.a.k(sb, this.f13536c, ')');
    }
}

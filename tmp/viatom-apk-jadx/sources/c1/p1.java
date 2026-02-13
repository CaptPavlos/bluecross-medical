package c1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p1 extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final long f1399a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1400b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1401c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ r1 f1402d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(r1 r1Var, Callable callable, boolean z9) {
        super(callable);
        this.f1402d = r1Var;
        long andIncrement = r1.f1424k.getAndIncrement();
        this.f1399a = andIncrement;
        this.f1401c = "Task exception on worker thread";
        this.f1400b = z9;
        if (andIncrement == Long.MAX_VALUE) {
            w0 w0Var = r1Var.f1149a.f;
            u1.m(w0Var);
            w0Var.f.b("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        p1 p1Var = (p1) obj;
        boolean z9 = p1Var.f1400b;
        boolean z10 = this.f1400b;
        if (z10 != z9) {
            return !z10 ? 1 : -1;
        }
        long j10 = p1Var.f1399a;
        long j11 = this.f1399a;
        if (j11 < j10) {
            return -1;
        }
        if (j11 > j10) {
            return 1;
        }
        w0 w0Var = this.f1402d.f1149a.f;
        u1.m(w0Var);
        w0Var.g.c(Long.valueOf(j11), "Two tasks share the same index. index");
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        w0 w0Var = this.f1402d.f1149a.f;
        u1.m(w0Var);
        w0Var.f.c(th, this.f1401c);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(r1 r1Var, Runnable runnable, boolean z9, String str) {
        super(runnable, null);
        this.f1402d = r1Var;
        long andIncrement = r1.f1424k.getAndIncrement();
        this.f1399a = andIncrement;
        this.f1401c = str;
        this.f1400b = z9;
        if (andIncrement == Long.MAX_VALUE) {
            w0 w0Var = r1Var.f1149a.f;
            u1.m(w0Var);
            w0Var.f.b("Tasks index overflow");
        }
    }
}

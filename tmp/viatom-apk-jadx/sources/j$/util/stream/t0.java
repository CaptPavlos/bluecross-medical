package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
public final class t0 extends CountedCompleter {

    /* renamed from: a, reason: collision with root package name */
    public Spliterator f9740a;

    /* renamed from: b, reason: collision with root package name */
    public final m5 f9741b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9742c;

    /* renamed from: d, reason: collision with root package name */
    public long f9743d;

    public t0(a aVar, Spliterator spliterator, m5 m5Var) {
        super(null);
        this.f9741b = m5Var;
        this.f9742c = aVar;
        this.f9740a = spliterator;
        this.f9743d = 0L;
    }

    public t0(t0 t0Var, Spliterator spliterator) {
        super(t0Var);
        this.f9740a = spliterator;
        this.f9741b = t0Var.f9741b;
        this.f9743d = t0Var.f9743d;
        this.f9742c = t0Var.f9742c;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f9740a;
        long jEstimateSize = spliterator.estimateSize();
        long jE = this.f9743d;
        if (jE == 0) {
            jE = d.e(jEstimateSize);
            this.f9743d = jE;
        }
        boolean zJ = z6.SHORT_CIRCUIT.j(this.f9742c.f);
        m5 m5Var = this.f9741b;
        boolean z9 = false;
        t0 t0Var = this;
        while (true) {
            if (zJ && m5Var.e()) {
                break;
            }
            if (jEstimateSize <= jE || (spliteratorTrySplit = spliterator.trySplit()) == null) {
                break;
            }
            t0 t0Var2 = new t0(t0Var, spliteratorTrySplit);
            t0Var.addToPendingCount(1);
            if (z9) {
                spliterator = spliteratorTrySplit;
            } else {
                t0 t0Var3 = t0Var;
                t0Var = t0Var2;
                t0Var2 = t0Var3;
            }
            z9 = !z9;
            t0Var.fork();
            t0Var = t0Var2;
            jEstimateSize = spliterator.estimateSize();
        }
        t0Var.f9742c.z(spliterator, m5Var);
        t0Var.f9740a = null;
        t0Var.propagateCompletion();
    }
}

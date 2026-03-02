package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* loaded from: classes2.dex */
public abstract class d extends CountedCompleter {
    public static final int g = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* renamed from: a, reason: collision with root package name */
    public final a f9549a;

    /* renamed from: b, reason: collision with root package name */
    public Spliterator f9550b;

    /* renamed from: c, reason: collision with root package name */
    public long f9551c;

    /* renamed from: d, reason: collision with root package name */
    public d f9552d;
    public d e;
    public Object f;

    public abstract Object a();

    public abstract d c(Spliterator spliterator);

    public d(a aVar, Spliterator spliterator) {
        super(null);
        this.f9549a = aVar;
        this.f9550b = spliterator;
        this.f9551c = 0L;
    }

    public d(d dVar, Spliterator spliterator) {
        super(dVar);
        this.f9550b = spliterator;
        this.f9549a = dVar.f9549a;
        this.f9551c = dVar.f9551c;
    }

    public static long e(long j10) {
        long j11 = j10 / g;
        if (j11 > 0) {
            return j11;
        }
        return 1L;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public void d(Object obj) {
        this.f = obj;
    }

    public final boolean b() {
        return ((d) getCompleter()) == null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f9550b;
        long jEstimateSize = spliterator.estimateSize();
        long jE = this.f9551c;
        if (jE == 0) {
            jE = e(jEstimateSize);
            this.f9551c = jE;
        }
        boolean z9 = false;
        d dVar = this;
        while (jEstimateSize > jE && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            d dVarC = dVar.c(spliteratorTrySplit);
            dVar.f9552d = dVarC;
            d dVarC2 = dVar.c(spliterator);
            dVar.e = dVarC2;
            dVar.setPendingCount(1);
            if (z9) {
                spliterator = spliteratorTrySplit;
                dVar = dVarC;
                dVarC = dVarC2;
            } else {
                dVar = dVarC2;
            }
            z9 = !z9;
            dVarC.fork();
            jEstimateSize = spliterator.estimateSize();
        }
        dVar.d(dVar.a());
        dVar.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f9550b = null;
        this.e = null;
        this.f9552d = null;
    }
}

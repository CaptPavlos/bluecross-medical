package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* loaded from: classes2.dex */
public final class s0 extends CountedCompleter {

    /* renamed from: a, reason: collision with root package name */
    public final a f9724a;

    /* renamed from: b, reason: collision with root package name */
    public Spliterator f9725b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9726c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f9727d;
    public final r0 e;
    public final s0 f;
    public h2 g;

    public s0(a aVar, Spliterator spliterator, r0 r0Var) {
        super(null);
        this.f9724a = aVar;
        this.f9725b = spliterator;
        this.f9726c = d.e(spliterator.estimateSize());
        this.f9727d = new ConcurrentHashMap(Math.max(16, d.g << 1));
        this.e = r0Var;
        this.f = null;
    }

    public s0(s0 s0Var, Spliterator spliterator, s0 s0Var2) {
        super(s0Var);
        this.f9724a = s0Var.f9724a;
        this.f9725b = spliterator;
        this.f9726c = s0Var.f9726c;
        this.f9727d = s0Var.f9727d;
        this.e = s0Var.e;
        this.f = s0Var2;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator spliteratorTrySplit;
        Spliterator spliterator = this.f9725b;
        long j10 = this.f9726c;
        boolean z9 = false;
        s0 s0Var = this;
        while (spliterator.estimateSize() > j10 && (spliteratorTrySplit = spliterator.trySplit()) != null) {
            s0 s0Var2 = new s0(s0Var, spliteratorTrySplit, s0Var.f);
            s0 s0Var3 = new s0(s0Var, spliterator, s0Var2);
            s0Var.addToPendingCount(1);
            s0Var3.addToPendingCount(1);
            s0Var.f9727d.put(s0Var2, s0Var3);
            if (s0Var.f != null) {
                s0Var2.addToPendingCount(1);
                if (s0Var.f9727d.replace(s0Var.f, s0Var, s0Var2)) {
                    s0Var.addToPendingCount(-1);
                } else {
                    s0Var2.addToPendingCount(-1);
                }
            }
            if (z9) {
                spliterator = spliteratorTrySplit;
                s0Var = s0Var2;
                s0Var2 = s0Var3;
            } else {
                s0Var = s0Var3;
            }
            z9 = !z9;
            s0Var2.fork();
        }
        if (s0Var.getPendingCount() > 0) {
            q qVar = new q(15);
            a aVar = s0Var.f9724a;
            z1 z1VarI = aVar.I(aVar.F(spliterator), qVar);
            s0Var.f9724a.Q(spliterator, z1VarI);
            s0Var.g = z1VarI.build();
            s0Var.f9725b = null;
        }
        s0Var.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        h2 h2Var = this.g;
        if (h2Var != null) {
            h2Var.forEach(this.e);
            this.g = null;
        } else {
            Spliterator spliterator = this.f9725b;
            if (spliterator != null) {
                this.f9724a.Q(spliterator, this.e);
                this.f9725b = null;
            }
        }
        s0 s0Var = (s0) this.f9727d.remove(this);
        if (s0Var != null) {
            s0Var.tryComplete();
        }
    }
}

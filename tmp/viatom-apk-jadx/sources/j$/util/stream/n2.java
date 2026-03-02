package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

/* loaded from: classes2.dex */
public class n2 extends d {
    public final a h;

    /* renamed from: i, reason: collision with root package name */
    public final LongFunction f9674i;

    /* renamed from: j, reason: collision with root package name */
    public final BinaryOperator f9675j;

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.f9552d;
        if (dVar != null) {
            this.f = (h2) this.f9675j.apply((h2) ((n2) dVar).f, (h2) ((n2) this.e).f);
        }
        super.onCompletion(countedCompleter);
    }

    public n2(a aVar, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(aVar, spliterator);
        this.h = aVar;
        this.f9674i = longFunction;
        this.f9675j = binaryOperator;
    }

    public n2(n2 n2Var, Spliterator spliterator) {
        super(n2Var, spliterator);
        this.h = n2Var.h;
        this.f9674i = n2Var.f9674i;
        this.f9675j = n2Var.f9675j;
    }

    @Override // j$.util.stream.d
    public d c(Spliterator spliterator) {
        return new n2(this, spliterator);
    }

    @Override // j$.util.stream.d
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final h2 a() {
        z1 z1Var = (z1) this.f9674i.apply(this.h.F(this.f9550b));
        this.h.Q(this.f9550b, z1Var);
        return z1Var.build();
    }
}

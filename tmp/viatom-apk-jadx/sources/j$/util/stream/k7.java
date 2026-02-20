package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class k7 extends b7 implements j$.util.v0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new k7(this.f9524b, spliterator, this.f9523a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        p6 p6Var = new p6();
        this.h = p6Var;
        Objects.requireNonNull(p6Var);
        this.e = this.f9524b.R(new j7(p6Var, 1));
        this.f = new j$.util.q(10, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.v0 trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        double d8;
        Objects.requireNonNull(doubleConsumer);
        boolean zA = a();
        if (zA) {
            p6 p6Var = (p6) this.h;
            long j10 = this.g;
            int iR = p6Var.r(j10);
            if (p6Var.f9534c == 0 && iR == 0) {
                d8 = ((double[]) p6Var.e)[(int) j10];
            } else {
                d8 = ((double[][]) p6Var.f)[iR][(int) (j10 - p6Var.f9535d[iR])];
            }
            doubleConsumer.accept(d8);
        }
        return zA;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.h == null && !this.f9527i) {
            Objects.requireNonNull(doubleConsumer);
            c();
            Objects.requireNonNull(doubleConsumer);
            j7 j7Var = new j7(doubleConsumer, 0);
            this.f9524b.Q(this.f9526d, j7Var);
            this.f9527i = true;
            return;
        }
        while (tryAdvance(doubleConsumer)) {
        }
    }
}

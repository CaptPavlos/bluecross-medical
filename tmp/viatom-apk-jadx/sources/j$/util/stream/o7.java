package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class o7 extends b7 implements j$.util.b1 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new o7(this.f9524b, spliterator, this.f9523a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        t6 t6Var = new t6();
        this.h = t6Var;
        Objects.requireNonNull(t6Var);
        this.e = this.f9524b.R(new n7(t6Var, 1));
        this.f = new j$.util.q(12, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.b1 trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        long j10;
        Objects.requireNonNull(longConsumer);
        boolean zA = a();
        if (zA) {
            t6 t6Var = (t6) this.h;
            long j11 = this.g;
            int iR = t6Var.r(j11);
            if (t6Var.f9534c == 0 && iR == 0) {
                j10 = ((long[]) t6Var.e)[(int) j11];
            } else {
                j10 = ((long[][]) t6Var.f)[iR][(int) (j11 - t6Var.f9535d[iR])];
            }
            longConsumer.accept(j10);
        }
        return zA;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.h == null && !this.f9527i) {
            Objects.requireNonNull(longConsumer);
            c();
            Objects.requireNonNull(longConsumer);
            n7 n7Var = new n7(longConsumer, 0);
            this.f9524b.Q(this.f9526d, n7Var);
            this.f9527i = true;
            return;
        }
        while (tryAdvance(longConsumer)) {
        }
    }
}

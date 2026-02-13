package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class m7 extends b7 implements j$.util.y0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new m7(this.f9524b, spliterator, this.f9523a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        r6 r6Var = new r6();
        this.h = r6Var;
        Objects.requireNonNull(r6Var);
        this.e = this.f9524b.R(new l7(r6Var, 1));
        this.f = new j$.util.q(11, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.y0 trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i10;
        Objects.requireNonNull(intConsumer);
        boolean zA = a();
        if (zA) {
            r6 r6Var = (r6) this.h;
            long j10 = this.g;
            int iR = r6Var.r(j10);
            if (r6Var.f9534c == 0 && iR == 0) {
                i10 = ((int[]) r6Var.e)[(int) j10];
            } else {
                i10 = ((int[][]) r6Var.f)[iR][(int) (j10 - r6Var.f9535d[iR])];
            }
            intConsumer.accept(i10);
        }
        return zA;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.h == null && !this.f9527i) {
            Objects.requireNonNull(intConsumer);
            c();
            Objects.requireNonNull(intConsumer);
            l7 l7Var = new l7(intConsumer, 0);
            this.f9524b.Q(this.f9526d, l7Var);
            this.f9527i = true;
            return;
        }
        while (tryAdvance(intConsumer)) {
        }
    }
}

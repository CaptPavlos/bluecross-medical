package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class d8 extends b7 {
    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new d8(this.f9524b, spliterator, this.f9523a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        w6 w6Var = new w6();
        this.h = w6Var;
        Objects.requireNonNull(w6Var);
        this.e = this.f9524b.R(new c8(w6Var, 0));
        this.f = new j$.util.q(13, this);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean zA = a();
        if (!zA) {
            return zA;
        }
        w6 w6Var = (w6) this.h;
        long j10 = this.g;
        if (w6Var.f9534c != 0) {
            if (j10 >= w6Var.count()) {
                throw new IndexOutOfBoundsException(Long.toString(j10));
            }
            for (int i10 = 0; i10 <= w6Var.f9534c; i10++) {
                long j11 = w6Var.f9535d[i10];
                Object[] objArr = w6Var.f[i10];
                if (j10 < objArr.length + j11) {
                    obj = objArr[(int) (j10 - j11)];
                }
            }
            throw new IndexOutOfBoundsException(Long.toString(j10));
        }
        if (j10 < w6Var.f9533b) {
            obj = w6Var.e[(int) j10];
        } else {
            throw new IndexOutOfBoundsException(Long.toString(j10));
        }
        consumer.n(obj);
        return zA;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.h == null && !this.f9527i) {
            Objects.requireNonNull(consumer);
            c();
            Objects.requireNonNull(consumer);
            c8 c8Var = new c8(consumer, 1);
            this.f9524b.Q(this.f9526d, c8Var);
            this.f9527i = true;
            return;
        }
        while (tryAdvance(consumer)) {
        }
    }
}

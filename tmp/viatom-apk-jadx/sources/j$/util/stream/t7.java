package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class t7 extends u7 implements Spliterator {
    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public t7(Spliterator spliterator, long j10, long j11) {
        super(spliterator, j10, j11, 0L, Math.min(spliterator.estimateSize(), j11));
    }

    @Override // j$.util.stream.u7
    public final Spliterator a(Spliterator spliterator, long j10, long j11, long j12, long j13) {
        return new t7(spliterator, j10, j11, j12, j13);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        long j10;
        Objects.requireNonNull(consumer);
        long j11 = this.e;
        long j12 = this.f9769a;
        if (j12 >= j11) {
            return false;
        }
        while (true) {
            j10 = this.f9772d;
            if (j12 <= j10) {
                break;
            }
            this.f9771c.tryAdvance(new d1(21));
            this.f9772d++;
        }
        if (j10 >= this.e) {
            return false;
        }
        this.f9772d = j10 + 1;
        return this.f9771c.tryAdvance(consumer);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        long j10 = this.e;
        long j11 = this.f9769a;
        if (j11 >= j10) {
            return;
        }
        long j12 = this.f9772d;
        if (j12 >= j10) {
            return;
        }
        if (j12 >= j11 && this.f9771c.estimateSize() + j12 <= this.f9770b) {
            this.f9771c.forEachRemaining(consumer);
            this.f9772d = this.e;
            return;
        }
        while (j11 > this.f9772d) {
            this.f9771c.tryAdvance(new d1(22));
            this.f9772d++;
        }
        while (this.f9772d < this.e) {
            this.f9771c.tryAdvance(consumer);
            this.f9772d++;
        }
    }
}

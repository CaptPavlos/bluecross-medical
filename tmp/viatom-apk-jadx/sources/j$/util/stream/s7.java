package j$.util.stream;

import j$.util.Objects;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public abstract class s7 extends u7 implements j$.util.e1 {
    public abstract Object b();

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

    public s7(j$.util.e1 e1Var, long j10, long j11) {
        super(e1Var, j10, j11, 0L, Math.min(e1Var.estimateSize(), j11));
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(Object obj) {
        long j10;
        Objects.requireNonNull(obj);
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
            ((j$.util.e1) this.f9771c).tryAdvance(b());
            this.f9772d++;
        }
        if (j10 >= this.e) {
            return false;
        }
        this.f9772d = j10 + 1;
        return ((j$.util.e1) this.f9771c).tryAdvance(obj);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        long j10 = this.e;
        long j11 = this.f9769a;
        if (j11 >= j10) {
            return;
        }
        long j12 = this.f9772d;
        if (j12 >= j10) {
            return;
        }
        if (j12 >= j11 && ((j$.util.e1) this.f9771c).estimateSize() + j12 <= this.f9770b) {
            ((j$.util.e1) this.f9771c).forEachRemaining(obj);
            this.f9772d = this.e;
            return;
        }
        while (j11 > this.f9772d) {
            ((j$.util.e1) this.f9771c).tryAdvance(b());
            this.f9772d++;
        }
        while (this.f9772d < this.e) {
            ((j$.util.e1) this.f9771c).tryAdvance(obj);
            this.f9772d++;
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}

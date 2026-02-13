package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public abstract class y7 extends b8 implements j$.util.e1 {
    public abstract void g(Object obj);

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    public abstract f7 j(int i10);

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (f() != a8.NO_MORE && ((j$.util.e1) this.f9528a).tryAdvance(this)) {
            if (a(1L) == 1) {
                g(obj);
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        f7 f7VarJ = null;
        while (true) {
            a8 a8VarF = f();
            if (a8VarF == a8.NO_MORE) {
                return;
            }
            a8 a8Var = a8.MAYBE_MORE;
            Spliterator spliterator = this.f9528a;
            if (a8VarF == a8Var) {
                int i10 = this.f9530c;
                if (f7VarJ == null) {
                    f7VarJ = j(i10);
                } else {
                    f7VarJ.f9578b = 0;
                }
                long j10 = 0;
                while (((j$.util.e1) spliterator).tryAdvance(f7VarJ)) {
                    j10++;
                    if (j10 >= i10) {
                        break;
                    }
                }
                if (j10 == 0) {
                    return;
                } else {
                    f7VarJ.a(obj, a(j10));
                }
            } else {
                ((j$.util.e1) spliterator).forEachRemaining(obj);
                return;
            }
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

package j$.util.concurrent;

import j$.util.b1;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class x implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public long f9406a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9407b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9408c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9409d;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return j$.util.c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public x(long j10, long j11, long j12, long j13) {
        this.f9406a = j10;
        this.f9407b = j11;
        this.f9408c = j12;
        this.f9409d = j13;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final x trySplit() {
        long j10 = this.f9406a;
        long j11 = (this.f9407b + j10) >>> 1;
        if (j11 <= j10) {
            return null;
        }
        this.f9406a = j11;
        return new x(j10, j11, this.f9408c, this.f9409d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9407b - this.f9406a;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j10 = this.f9406a;
        if (j10 >= this.f9407b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().c(this.f9408c, this.f9409d));
        this.f9406a = j10 + 1;
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j10 = this.f9406a;
        long j11 = this.f9407b;
        if (j10 < j11) {
            this.f9406a = j11;
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            do {
                longConsumer.accept(threadLocalRandomCurrent.c(this.f9408c, this.f9409d));
                j10++;
            } while (j10 < j11);
        }
    }
}

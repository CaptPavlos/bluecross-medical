package j$.util.concurrent;

import j$.util.v0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class v implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public long f9398a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9399b;

    /* renamed from: c, reason: collision with root package name */
    public final double f9400c;

    /* renamed from: d, reason: collision with root package name */
    public final double f9401d;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
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
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public v(long j10, long j11, double d8, double d10) {
        this.f9398a = j10;
        this.f9399b = j11;
        this.f9400c = d8;
        this.f9401d = d10;
    }

    @Override // j$.util.v0, j$.util.e1, j$.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final v trySplit() {
        long j10 = this.f9398a;
        long j11 = (this.f9399b + j10) >>> 1;
        if (j11 <= j10) {
            return null;
        }
        this.f9398a = j11;
        return new v(j10, j11, this.f9400c, this.f9401d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9399b - this.f9398a;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j10 = this.f9398a;
        if (j10 >= this.f9399b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().a(this.f9400c, this.f9401d));
        this.f9398a = j10 + 1;
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j10 = this.f9398a;
        long j11 = this.f9399b;
        if (j10 < j11) {
            this.f9398a = j11;
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(threadLocalRandomCurrent.a(this.f9400c, this.f9401d));
                j10++;
            } while (j10 < j11);
        }
    }
}

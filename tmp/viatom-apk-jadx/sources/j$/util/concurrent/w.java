package j$.util.concurrent;

import j$.util.y0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class w implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public long f9402a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9403b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9404c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9405d;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
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
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public w(long j10, long j11, int i10, int i11) {
        this.f9402a = j10;
        this.f9403b = j11;
        this.f9404c = i10;
        this.f9405d = i11;
    }

    @Override // j$.util.y0, j$.util.e1, j$.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final w trySplit() {
        long j10 = this.f9402a;
        long j11 = (this.f9403b + j10) >>> 1;
        if (j11 <= j10) {
            return null;
        }
        this.f9402a = j11;
        return new w(j10, j11, this.f9404c, this.f9405d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9403b - this.f9402a;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j10 = this.f9402a;
        if (j10 >= this.f9403b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().b(this.f9404c, this.f9405d));
        this.f9402a = j10 + 1;
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j10 = this.f9402a;
        long j11 = this.f9403b;
        if (j10 < j11) {
            this.f9402a = j11;
            ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
            do {
                intConsumer.accept(threadLocalRandomCurrent.b(this.f9404c, this.f9405d));
                j10++;
            } while (j10 < j11);
        }
    }
}

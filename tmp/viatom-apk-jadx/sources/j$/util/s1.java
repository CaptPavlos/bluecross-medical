package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class s1 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f9494a;

    /* renamed from: b, reason: collision with root package name */
    public int f9495b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9496c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9497d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return c.e(this, i10);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return c.h(this, consumer);
    }

    public s1(long[] jArr, int i10, int i11, int i12) {
        this.f9494a = jArr;
        this.f9495b = i10;
        this.f9496c = i11;
        this.f9497d = i12 | 16448;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final b1 trySplit() {
        int i10 = this.f9495b;
        int i11 = (this.f9496c + i10) >>> 1;
        if (i10 >= i11) {
            return null;
        }
        this.f9495b = i11;
        return new s1(this.f9494a, i10, i11, this.f9497d);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        int i10;
        longConsumer.getClass();
        long[] jArr = this.f9494a;
        int length = jArr.length;
        int i11 = this.f9496c;
        if (length < i11 || (i10 = this.f9495b) < 0) {
            return;
        }
        this.f9495b = i11;
        if (i10 < i11) {
            do {
                longConsumer.accept(jArr[i10]);
                i10++;
            } while (i10 < i11);
        }
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        int i10 = this.f9495b;
        if (i10 < 0 || i10 >= this.f9496c) {
            return false;
        }
        this.f9495b = i10 + 1;
        longConsumer.accept(this.f9494a[i10]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9496c - this.f9495b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9497d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}

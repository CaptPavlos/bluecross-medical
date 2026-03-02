package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class q1 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9484a;

    /* renamed from: b, reason: collision with root package name */
    public int f9485b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9486c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9487d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        c.b(this, consumer);
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
        return c.g(this, consumer);
    }

    public q1(int[] iArr, int i10, int i11, int i12) {
        this.f9484a = iArr;
        this.f9485b = i10;
        this.f9486c = i11;
        this.f9487d = i12 | 16448;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final y0 trySplit() {
        int i10 = this.f9485b;
        int i11 = (this.f9486c + i10) >>> 1;
        if (i10 >= i11) {
            return null;
        }
        this.f9485b = i11;
        return new q1(this.f9484a, i10, i11, this.f9487d);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        int i10;
        intConsumer.getClass();
        int[] iArr = this.f9484a;
        int length = iArr.length;
        int i11 = this.f9486c;
        if (length < i11 || (i10 = this.f9485b) < 0) {
            return;
        }
        this.f9485b = i11;
        if (i10 < i11) {
            do {
                intConsumer.accept(iArr[i10]);
                i10++;
            } while (i10 < i11);
        }
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        int i10 = this.f9485b;
        if (i10 < 0 || i10 >= this.f9486c) {
            return false;
        }
        this.f9485b = i10 + 1;
        intConsumer.accept(this.f9484a[i10]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9486c - this.f9485b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9487d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}

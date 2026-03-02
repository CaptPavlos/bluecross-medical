package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class l1 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f9469a;

    /* renamed from: b, reason: collision with root package name */
    public int f9470b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9471c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9472d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        c.a(this, consumer);
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
        return c.f(this, consumer);
    }

    public l1(double[] dArr, int i10, int i11, int i12) {
        this.f9469a = dArr;
        this.f9470b = i10;
        this.f9471c = i11;
        this.f9472d = i12 | 16448;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final v0 trySplit() {
        int i10 = this.f9470b;
        int i11 = (this.f9471c + i10) >>> 1;
        if (i10 >= i11) {
            return null;
        }
        this.f9470b = i11;
        return new l1(this.f9469a, i10, i11, this.f9472d);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i10;
        doubleConsumer.getClass();
        double[] dArr = this.f9469a;
        int length = dArr.length;
        int i11 = this.f9471c;
        if (length < i11 || (i10 = this.f9470b) < 0) {
            return;
        }
        this.f9470b = i11;
        if (i10 < i11) {
            do {
                doubleConsumer.accept(dArr[i10]);
                i10++;
            } while (i10 < i11);
        }
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        int i10 = this.f9470b;
        if (i10 < 0 || i10 >= this.f9471c) {
            return false;
        }
        this.f9470b = i10 + 1;
        doubleConsumer.accept(this.f9469a[i10]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9471c - this.f9470b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9472d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}

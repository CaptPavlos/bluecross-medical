package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class k1 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f9464a;

    /* renamed from: b, reason: collision with root package name */
    public int f9465b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9466c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9467d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return c.e(this, i10);
    }

    public k1(Object[] objArr, int i10, int i11, int i12) {
        this.f9464a = objArr;
        this.f9465b = i10;
        this.f9466c = i11;
        this.f9467d = i12 | 16448;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i10 = this.f9465b;
        int i11 = (this.f9466c + i10) >>> 1;
        if (i10 >= i11) {
            return null;
        }
        this.f9465b = i11;
        return new k1(this.f9464a, i10, i11, this.f9467d);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i10;
        consumer.getClass();
        Object[] objArr = this.f9464a;
        int length = objArr.length;
        int i11 = this.f9466c;
        if (length < i11 || (i10 = this.f9465b) < 0) {
            return;
        }
        this.f9465b = i11;
        if (i10 < i11) {
            do {
                consumer.accept(objArr[i10]);
                i10++;
            } while (i10 < i11);
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i10 = this.f9465b;
        if (i10 < 0 || i10 >= this.f9466c) {
            return false;
        }
        this.f9465b = i10 + 1;
        consumer.accept(this.f9464a[i10]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f9466c - this.f9465b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9467d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}

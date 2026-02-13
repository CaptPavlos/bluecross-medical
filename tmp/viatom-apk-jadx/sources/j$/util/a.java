package j$.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class a implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final java.util.List f9345a;

    /* renamed from: b, reason: collision with root package name */
    public int f9346b;

    /* renamed from: c, reason: collision with root package name */
    public int f9347c;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
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
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public a(java.util.List list) {
        this.f9345a = list;
        this.f9346b = 0;
        this.f9347c = -1;
    }

    public a(a aVar, int i10, int i11) {
        this.f9345a = aVar.f9345a;
        this.f9346b = i10;
        this.f9347c = i11;
    }

    public final int a() {
        java.util.List list = this.f9345a;
        int i10 = this.f9347c;
        if (i10 >= 0) {
            return i10;
        }
        int size = list.size();
        this.f9347c = size;
        return size;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int iA = a();
        int i10 = this.f9346b;
        int i11 = (iA + i10) >>> 1;
        if (i10 >= i11) {
            return null;
        }
        this.f9346b = i11;
        return new a(this, i10, i11);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int iA = a();
        int i10 = this.f9346b;
        if (i10 >= iA) {
            return false;
        }
        this.f9346b = i10 + 1;
        try {
            consumer.accept(this.f9345a.get(i10));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        java.util.List list = this.f9345a;
        int iA = a();
        this.f9346b = iA;
        for (int i10 = this.f9346b; i10 < iA; i10++) {
            try {
                consumer.accept(list.get(i10));
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return a() - this.f9346b;
    }
}

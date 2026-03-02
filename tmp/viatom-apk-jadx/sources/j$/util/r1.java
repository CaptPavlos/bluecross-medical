package j$.util;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class r1 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Collection f9489a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f9490b = null;

    /* renamed from: c, reason: collision with root package name */
    public final int f9491c;

    /* renamed from: d, reason: collision with root package name */
    public long f9492d;
    public int e;

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i10) {
        return c.e(this, i10);
    }

    public r1(int i10, java.util.Collection collection) {
        this.f9489a = collection;
        this.f9491c = i10 | 16448;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        long size;
        Iterator it = this.f9490b;
        if (it == null) {
            it = this.f9489a.iterator();
            this.f9490b = it;
            size = this.f9489a.size();
            this.f9492d = size;
        } else {
            size = this.f9492d;
        }
        if (size <= 1 || !it.hasNext()) {
            return null;
        }
        int i10 = this.e + 1024;
        if (i10 > size) {
            i10 = (int) size;
        }
        if (i10 > 33554432) {
            i10 = 33554432;
        }
        Object[] objArr = new Object[i10];
        int i11 = 0;
        do {
            objArr[i11] = it.next();
            i11++;
            if (i11 >= i10) {
                break;
            }
        } while (it.hasNext());
        this.e = i11;
        long j10 = this.f9492d;
        if (j10 != Long.MAX_VALUE) {
            this.f9492d = j10 - i11;
        }
        return new k1(objArr, 0, i11, this.f9491c);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.f9490b;
        if (it == null) {
            it = this.f9489a.iterator();
            this.f9490b = it;
            this.f9492d = this.f9489a.size();
        }
        c.r(it, consumer);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        if (this.f9490b == null) {
            this.f9490b = this.f9489a.iterator();
            this.f9492d = this.f9489a.size();
        }
        if (!this.f9490b.hasNext()) {
            return false;
        }
        consumer.accept(this.f9490b.next());
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        if (this.f9490b == null) {
            this.f9490b = this.f9489a.iterator();
            long size = this.f9489a.size();
            this.f9492d = size;
            return size;
        }
        return this.f9492d;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f9491c;
    }

    @Override // j$.util.Spliterator
    public Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}

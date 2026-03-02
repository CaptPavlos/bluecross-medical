package j$.util;

import java.util.ListIterator;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class o implements ListIterator, z {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f9478a;

    public o(p pVar, int i10) {
        this.f9478a = pVar.f9480b.listIterator(i10);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f9478a.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.f9478a.next();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9478a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.f9478a.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9478a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9478a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        c.r(this.f9478a, consumer);
    }
}

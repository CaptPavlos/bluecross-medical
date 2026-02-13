package j1;

import java.util.ListIterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends q implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final int f9881a;

    /* renamed from: b, reason: collision with root package name */
    public int f9882b;

    /* renamed from: c, reason: collision with root package name */
    public final d f9883c;

    public b(d dVar, int i10) {
        int size = dVar.size();
        l1.b.s(i10, size);
        this.f9881a = size;
        this.f9882b = i10;
        this.f9883c = dVar;
    }

    public final Object a(int i10) {
        return this.f9883c.get(i10);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f9882b < this.f9881a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f9882b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        int i10 = this.f9882b;
        this.f9882b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f9882b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            com.google.gson.internal.a.b();
            return null;
        }
        int i10 = this.f9882b - 1;
        this.f9882b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f9882b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}

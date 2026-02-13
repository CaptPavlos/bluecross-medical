package j1;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p extends g {

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f9908d;

    public p(Object obj) {
        this.f9908d = obj;
    }

    @Override // j1.a
    public final int b(Object[] objArr) {
        objArr[0] = this.f9908d;
        return 1;
    }

    @Override // j1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9908d.equals(obj);
    }

    @Override // j1.g, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f9908d.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new h(this.f9908d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.f9908d.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }
}

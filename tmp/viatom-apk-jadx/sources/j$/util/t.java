package j$.util;

import j$.util.Collection;
import j$.util.stream.Stream;
import j$.util.stream.w3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class t extends w {
    private static final long serialVersionUID = 7854390611657943733L;

    @Override // j$.util.n, java.lang.Iterable, j$.util.Collection
    public final void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        Collection.EL.a(this.f9475a, new q(0, consumer));
    }

    @Override // j$.util.n, java.util.Collection, java.lang.Iterable, j$.util.Collection
    public final Spliterator spliterator() {
        return new s(Collection.EL.c(this.f9475a));
    }

    @Override // j$.util.n, java.util.Collection, j$.util.Collection
    public final Stream stream() {
        return w3.a0(spliterator(), false);
    }

    @Override // j$.util.n, java.util.Collection, j$.util.Collection
    public final Stream parallelStream() {
        return w3.a0(spliterator(), true);
    }

    @Override // j$.util.n, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new m(this);
    }

    @Override // j$.util.n, java.util.Collection
    public final Object[] toArray() {
        Object[] array = this.f9475a.toArray();
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = new r((Map.Entry) array[i10]);
        }
        return array;
    }

    @Override // j$.util.n, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array = this.f9475a.toArray(objArr.length == 0 ? objArr : Arrays.copyOf(objArr, 0));
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = new r((Map.Entry) array[i10]);
        }
        if (array.length > objArr.length) {
            return array;
        }
        System.arraycopy(array, 0, objArr, 0, array.length);
        if (objArr.length > array.length) {
            objArr[array.length] = null;
        }
        return objArr;
    }

    @Override // j$.util.n, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            return this.f9475a.contains(new r((Map.Entry) obj));
        }
        return false;
    }

    @Override // j$.util.n, java.util.Collection
    public final boolean containsAll(java.util.Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // j$.util.w, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() != this.f9475a.size()) {
            return false;
        }
        return containsAll(set);
    }
}

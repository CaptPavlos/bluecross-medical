package j$.util;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public class h implements java.util.Collection, Serializable, Collection {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Collection f9444a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9445b;

    @Override // java.util.Collection, j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return toArray((Object[]) intFunction.apply(0));
    }

    public h(java.util.Collection collection) {
        this.f9444a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f9445b = this;
    }

    public h(java.util.Collection collection, Object obj) {
        this.f9444a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f9445b = Objects.requireNonNull(obj);
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.f9445b) {
            size = this.f9444a.size();
        }
        return size;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.f9445b) {
            zIsEmpty = this.f9444a.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.f9445b) {
            zContains = this.f9444a.contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f9445b) {
            array = this.f9444a.toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f9445b) {
            array = this.f9444a.toArray(objArr);
        }
        return array;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f9444a.iterator();
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean zAdd;
        synchronized (this.f9445b) {
            zAdd = this.f9444a.add(obj);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.f9445b) {
            zRemove = this.f9444a.remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public final boolean containsAll(java.util.Collection collection) {
        boolean zContainsAll;
        synchronized (this.f9445b) {
            zContainsAll = this.f9444a.containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.util.Collection
    public final boolean addAll(java.util.Collection collection) {
        boolean zAddAll;
        synchronized (this.f9445b) {
            zAddAll = this.f9444a.addAll(collection);
        }
        return zAddAll;
    }

    @Override // java.util.Collection
    public final boolean removeAll(java.util.Collection collection) {
        boolean zRemoveAll;
        synchronized (this.f9445b) {
            zRemoveAll = this.f9444a.removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public final boolean retainAll(java.util.Collection collection) {
        boolean zRetainAll;
        synchronized (this.f9445b) {
            zRetainAll = this.f9444a.retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.f9445b) {
            this.f9444a.clear();
        }
    }

    public final String toString() {
        String string;
        synchronized (this.f9445b) {
            string = this.f9444a.toString();
        }
        return string;
    }

    @Override // java.lang.Iterable, j$.util.Collection
    public final void forEach(Consumer consumer) {
        synchronized (this.f9445b) {
            Collection.EL.a(this.f9444a, consumer);
        }
    }

    @Override // java.util.Collection, j$.util.Collection
    public final boolean removeIf(Predicate predicate) {
        boolean zRemoveIf;
        synchronized (this.f9445b) {
            java.util.Collection collection = this.f9444a;
            zRemoveIf = collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : Collection.CC.$default$removeIf(collection, predicate);
        }
        return zRemoveIf;
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection
    public final Spliterator spliterator() {
        return Collection.EL.c(this.f9444a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(Collection.EL.c(this.f9444a));
    }

    @Override // java.util.Collection, j$.util.Collection
    public final Stream stream() {
        return Collection.EL.stream(this.f9444a);
    }

    @Override // java.util.Collection
    public final java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(Collection.EL.stream(this.f9444a));
    }

    @Override // java.util.Collection, j$.util.Collection
    public final Stream parallelStream() {
        return Collection.EL.b(this.f9444a);
    }

    @Override // java.util.Collection
    public final java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(Collection.EL.b(this.f9444a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f9445b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}

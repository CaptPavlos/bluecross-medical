package j$.util;

import java.io.Serializable;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes2.dex */
public final class u implements java.util.Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Map f9843a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f9844b;

    /* renamed from: c, reason: collision with root package name */
    public transient t f9845c;

    /* renamed from: d, reason: collision with root package name */
    public transient java.util.Collection f9846d;

    public u(java.util.Map map) {
        map.getClass();
        this.f9843a = map;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f9843a.size();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f9843a.isEmpty();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f9843a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f9843a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f9843a.get(obj);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f9844b == null) {
            this.f9844b = DesugarCollections.unmodifiableSet(this.f9843a.keySet());
        }
        return this.f9844b;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f9845c == null) {
            this.f9845c = new t(this.f9843a.entrySet());
        }
        return this.f9845c;
    }

    @Override // java.util.Map
    public final java.util.Collection values() {
        if (this.f9846d == null) {
            this.f9846d = DesugarCollections.unmodifiableCollection(this.f9843a.values());
        }
        return this.f9846d;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.f9843a.equals(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f9843a.hashCode();
    }

    public final String toString() {
        return this.f9843a.toString();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        return c.s(this.f9843a, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        c.q(this.f9843a, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }
}

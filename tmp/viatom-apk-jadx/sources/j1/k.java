package j1;

import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends g {

    /* renamed from: d, reason: collision with root package name */
    public final transient f f9900d;
    public final transient Object[] e;
    public final transient int f;

    public k(f fVar, Object[] objArr, int i10) {
        this.f9900d = fVar;
        this.e = objArr;
        this.f = i10;
    }

    @Override // j1.a
    public final int b(Object[] objArr) {
        return g().b(objArr);
    }

    @Override // j1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f9900d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // j1.g
    public final d l() {
        return new j(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final q iterator() {
        return g().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f;
    }
}

package j1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l extends g {

    /* renamed from: d, reason: collision with root package name */
    public final transient f f9901d;
    public final transient m e;

    public l(f fVar, m mVar) {
        this.f9901d = fVar;
        this.e = mVar;
    }

    @Override // j1.a
    public final int b(Object[] objArr) {
        return this.e.b(objArr);
    }

    @Override // j1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9901d.get(obj) != null;
    }

    @Override // j1.g
    public final d g() {
        throw null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final q iterator() {
        return this.e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return ((n) this.f9901d).f;
    }
}

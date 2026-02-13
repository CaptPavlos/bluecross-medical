package j1;

import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends d {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f9902c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9903d;
    public final transient int e;

    public m(Object[] objArr, int i10, int i11) {
        this.f9902c = objArr;
        this.f9903d = i10;
        this.e = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        l1.b.q(i10, this.e);
        Object obj = this.f9902c[(i10 * 2) + this.f9903d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}

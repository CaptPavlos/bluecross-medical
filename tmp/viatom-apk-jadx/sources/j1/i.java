package j1;

import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends d {
    public static final i e = new i(0, new Object[0]);

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f9897c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9898d;

    public i(int i10, Object[] objArr) {
        this.f9897c = objArr;
        this.f9898d = i10;
    }

    @Override // j1.d, j1.a
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f9897c;
        int i10 = this.f9898d;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // j1.a
    public final Object[] c() {
        return this.f9897c;
    }

    @Override // j1.a
    public final int d() {
        return this.f9898d;
    }

    @Override // j1.a
    public final int e() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        l1.b.q(i10, this.f9898d);
        Object obj = this.f9897c[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9898d;
    }
}

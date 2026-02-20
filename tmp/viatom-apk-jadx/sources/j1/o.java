package j1;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends g {

    /* renamed from: i, reason: collision with root package name */
    public static final Object[] f9905i;

    /* renamed from: j, reason: collision with root package name */
    public static final o f9906j;

    /* renamed from: d, reason: collision with root package name */
    public final transient Object[] f9907d;
    public final transient int e;
    public final transient Object[] f;
    public final transient int g;
    public final transient int h;

    static {
        Object[] objArr = new Object[0];
        f9905i = objArr;
        f9906j = new o(0, 0, 0, objArr, objArr);
    }

    public o(int i10, int i11, int i12, Object[] objArr, Object[] objArr2) {
        this.f9907d = objArr;
        this.e = i10;
        this.f = objArr2;
        this.g = i11;
        this.h = i12;
    }

    @Override // j1.a
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f9907d;
        int i10 = this.h;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // j1.a
    public final Object[] c() {
        return this.f9907d;
    }

    @Override // j1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f;
            if (objArr.length != 0) {
                int iN = l1.b.N(obj.hashCode());
                while (true) {
                    int i10 = iN & this.g;
                    Object obj2 = objArr[i10];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iN = i10 + 1;
                }
            }
        }
        return false;
    }

    @Override // j1.a
    public final int d() {
        return this.h;
    }

    @Override // j1.a
    public final int e() {
        return 0;
    }

    @Override // j1.g, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return g().listIterator(0);
    }

    @Override // j1.g
    public final d l() {
        return d.g(this.h, this.f9907d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.h;
    }
}

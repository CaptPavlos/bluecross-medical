package u6;

import com.google.android.gms.internal.measurement.a4;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.l;
import p8.u;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends t6.f implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f12940a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12941b;

    /* renamed from: c, reason: collision with root package name */
    public int f12942c;

    /* renamed from: d, reason: collision with root package name */
    public final b f12943d;
    public final c e;

    public b(Object[] objArr, int i10, int i11, b bVar, c cVar) {
        objArr.getClass();
        cVar.getClass();
        this.f12940a = objArr;
        this.f12941b = i10;
        this.f12942c = i11;
        this.f12943d = bVar;
        this.e = cVar;
        ((AbstractList) this).modCount = ((AbstractList) cVar).modCount;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        l();
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.c(i10, i11);
        h(this.f12941b + i10, obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        collection.getClass();
        l();
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.c(i10, i11);
        int size = collection.size();
        g(this.f12941b + i10, collection, size);
        return size > 0;
    }

    @Override // t6.f
    public final int c() {
        i();
        return this.f12942c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        l();
        i();
        n(this.f12941b, this.f12942c);
    }

    @Override // t6.f
    public final Object d(int i10) {
        l();
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.b(i10, i11);
        return m(this.f12941b + i10);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        i();
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f12940a;
            int i10 = this.f12942c;
            if (i10 == list.size()) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (l.a(objArr[this.f12941b + i11], list.get(i11))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void g(int i10, Collection collection, int i11) {
        ((AbstractList) this).modCount++;
        c cVar = this.e;
        b bVar = this.f12943d;
        if (bVar != null) {
            bVar.g(i10, collection, i11);
        } else {
            c cVar2 = c.f12944d;
            cVar.g(i10, collection, i11);
        }
        this.f12940a = cVar.f12945a;
        this.f12942c += i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.b(i10, i11);
        return this.f12940a[this.f12941b + i10];
    }

    public final void h(int i10, Object obj) {
        ((AbstractList) this).modCount++;
        c cVar = this.e;
        b bVar = this.f12943d;
        if (bVar != null) {
            bVar.h(i10, obj);
        } else {
            c cVar2 = c.f12944d;
            cVar.h(i10, obj);
        }
        this.f12940a = cVar.f12945a;
        this.f12942c++;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        i();
        Object[] objArr = this.f12940a;
        int i10 = this.f12942c;
        int iHashCode = 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[this.f12941b + i11];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (((AbstractList) this.e).modCount == ((AbstractList) this).modCount) {
            return;
        }
        a2.a.e();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        i();
        for (int i10 = 0; i10 < this.f12942c; i10++) {
            if (l.a(this.f12940a[this.f12941b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        i();
        return this.f12942c == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void l() {
        if (this.e.f12947c) {
            u.p();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        i();
        for (int i10 = this.f12942c - 1; i10 >= 0; i10--) {
            if (l.a(this.f12940a[this.f12941b + i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.c(i10, i11);
        return new a(this, i10);
    }

    public final Object m(int i10) {
        Object objM;
        ((AbstractList) this).modCount++;
        b bVar = this.f12943d;
        if (bVar != null) {
            objM = bVar.m(i10);
        } else {
            c cVar = c.f12944d;
            objM = this.e.m(i10);
        }
        this.f12942c--;
        return objM;
    }

    public final void n(int i10, int i11) {
        if (i11 > 0) {
            ((AbstractList) this).modCount++;
        }
        b bVar = this.f12943d;
        if (bVar != null) {
            bVar.n(i10, i11);
        } else {
            c cVar = c.f12944d;
            this.e.n(i10, i11);
        }
        this.f12942c -= i11;
    }

    public final int o(int i10, int i11, Collection collection, boolean z9) {
        int iO;
        b bVar = this.f12943d;
        if (bVar != null) {
            iO = bVar.o(i10, i11, collection, z9);
        } else {
            c cVar = c.f12944d;
            iO = this.e.o(i10, i11, collection, z9);
        }
        if (iO > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f12942c -= iO;
        return iO;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        l();
        i();
        int iIndexOf = indexOf(obj);
        if (iIndexOf >= 0) {
            d(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        collection.getClass();
        l();
        i();
        return o(this.f12941b, this.f12942c, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        l();
        i();
        return o(this.f12941b, this.f12942c, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        l();
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12942c;
        bVar.getClass();
        t6.b.b(i10, i11);
        Object[] objArr = this.f12940a;
        int i12 = this.f12941b + i10;
        Object obj2 = objArr[i12];
        objArr[i12] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        t6.b bVar = t6.e.Companion;
        int i12 = this.f12942c;
        bVar.getClass();
        t6.b.d(i10, i11, i12);
        return new b(this.f12940a, this.f12941b + i10, i11 - i10, this, this.e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        i();
        int length = objArr.length;
        int i10 = this.f12942c;
        Object[] objArr2 = this.f12940a;
        int i11 = this.f12941b;
        if (length < i10) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, i11, i10 + i11, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        j.i0(0, i11, i10 + i11, objArr2, objArr);
        int i12 = this.f12942c;
        if (i12 < objArr.length) {
            objArr[i12] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        i();
        return a4.f(this.f12940a, this.f12941b, this.f12942c, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        l();
        i();
        h(this.f12941b + this.f12942c, obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        l();
        i();
        int size = collection.size();
        g(this.f12941b + this.f12942c, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        i();
        Object[] objArr = this.f12940a;
        int i10 = this.f12942c;
        int i11 = this.f12941b;
        return j.p0(objArr, i11, i10 + i11);
    }
}

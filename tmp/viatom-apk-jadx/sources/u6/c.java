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
public final class c extends t6.f implements RandomAccess, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final c f12944d;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f12945a;

    /* renamed from: b, reason: collision with root package name */
    public int f12946b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12947c;

    static {
        c cVar = new c(0);
        cVar.f12947c = true;
        f12944d = cVar;
    }

    public c(int i10) {
        if (i10 >= 0) {
            this.f12945a = new Object[i10];
        } else {
            com.google.gson.internal.a.n("capacity must be non-negative.");
            throw null;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.c(i10, i11);
        ((AbstractList) this).modCount++;
        l(i10, 1);
        this.f12945a[i10] = obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        collection.getClass();
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.c(i10, i11);
        int size = collection.size();
        g(i10, collection, size);
        return size > 0;
    }

    @Override // t6.f
    public final int c() {
        return this.f12946b;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        i();
        n(0, this.f12946b);
    }

    @Override // t6.f
    public final Object d(int i10) {
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.b(i10, i11);
        return m(i10);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            Object[] objArr = this.f12945a;
            int i10 = this.f12946b;
            if (i10 == list.size()) {
                for (int i11 = 0; i11 < i10; i11++) {
                    if (l.a(objArr[i11], list.get(i11))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void g(int i10, Collection collection, int i11) {
        ((AbstractList) this).modCount++;
        l(i10, i11);
        Iterator it = collection.iterator();
        for (int i12 = 0; i12 < i11; i12++) {
            this.f12945a[i10 + i12] = it.next();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.b(i10, i11);
        return this.f12945a[i10];
    }

    public final void h(int i10, Object obj) {
        ((AbstractList) this).modCount++;
        l(i10, 1);
        this.f12945a[i10] = obj;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        Object[] objArr = this.f12945a;
        int i10 = this.f12946b;
        int iHashCode = 1;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final void i() {
        if (this.f12947c) {
            u.p();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        for (int i10 = 0; i10 < this.f12946b; i10++) {
            if (l.a(this.f12945a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.f12946b == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    public final void l(int i10, int i11) {
        int i12 = this.f12946b + i11;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        Object[] objArr = this.f12945a;
        if (i12 > objArr.length) {
            t6.b bVar = t6.e.Companion;
            int length = objArr.length;
            bVar.getClass();
            int iE = t6.b.e(length, i12);
            Object[] objArr2 = this.f12945a;
            objArr2.getClass();
            this.f12945a = Arrays.copyOf(objArr2, iE);
        }
        Object[] objArr3 = this.f12945a;
        j.i0(i10 + i11, i10, this.f12946b, objArr3, objArr3);
        this.f12946b += i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        for (int i10 = this.f12946b - 1; i10 >= 0; i10--) {
            if (l.a(this.f12945a[i10], obj)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i10) {
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.c(i10, i11);
        return new a(this, i10);
    }

    public final Object m(int i10) {
        ((AbstractList) this).modCount++;
        Object[] objArr = this.f12945a;
        Object obj = objArr[i10];
        j.i0(i10, i10 + 1, this.f12946b, objArr, objArr);
        Object[] objArr2 = this.f12945a;
        int i11 = this.f12946b - 1;
        objArr2.getClass();
        objArr2[i11] = null;
        this.f12946b--;
        return obj;
    }

    public final void n(int i10, int i11) {
        if (i11 > 0) {
            ((AbstractList) this).modCount++;
        }
        Object[] objArr = this.f12945a;
        j.i0(i10, i10 + i11, this.f12946b, objArr, objArr);
        Object[] objArr2 = this.f12945a;
        int i12 = this.f12946b;
        a4.A(objArr2, i12 - i11, i12);
        this.f12946b -= i11;
    }

    public final int o(int i10, int i11, Collection collection, boolean z9) {
        Object[] objArr;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            objArr = this.f12945a;
            if (i12 >= i11) {
                break;
            }
            int i14 = i10 + i12;
            if (collection.contains(objArr[i14]) == z9) {
                Object[] objArr2 = this.f12945a;
                i12++;
                objArr2[i13 + i10] = objArr2[i14];
                i13++;
            } else {
                i12++;
            }
        }
        int i15 = i11 - i13;
        j.i0(i10 + i13, i11 + i10, this.f12946b, objArr, objArr);
        Object[] objArr3 = this.f12945a;
        int i16 = this.f12946b;
        a4.A(objArr3, i16 - i15, i16);
        if (i15 > 0) {
            ((AbstractList) this).modCount++;
        }
        this.f12946b -= i15;
        return i15;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
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
        i();
        return o(0, this.f12946b, collection, false) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        i();
        return o(0, this.f12946b, collection, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        i();
        t6.b bVar = t6.e.Companion;
        int i11 = this.f12946b;
        bVar.getClass();
        t6.b.b(i10, i11);
        Object[] objArr = this.f12945a;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i10, int i11) {
        t6.b bVar = t6.e.Companion;
        int i12 = this.f12946b;
        bVar.getClass();
        t6.b.d(i10, i11, i12);
        return new b(this.f12945a, i10, i11 - i10, null, this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i10 = this.f12946b;
        Object[] objArr2 = this.f12945a;
        if (length < i10) {
            Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr2, 0, i10, objArr.getClass());
            objArrCopyOfRange.getClass();
            return objArrCopyOfRange;
        }
        j.i0(0, 0, i10, objArr2, objArr);
        int i11 = this.f12946b;
        if (i11 < objArr.length) {
            objArr[i11] = null;
        }
        return objArr;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return a4.f(this.f12945a, 0, this.f12946b, this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        i();
        int i10 = this.f12946b;
        ((AbstractList) this).modCount++;
        l(i10, 1);
        this.f12945a[i10] = obj;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        i();
        int size = collection.size();
        g(this.f12946b, collection, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return j.p0(this.f12945a, 0, this.f12946b);
    }
}

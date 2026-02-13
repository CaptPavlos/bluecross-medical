package t6;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends f {

    /* renamed from: d, reason: collision with root package name */
    public static final Object[] f12803d = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f12804a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f12805b = f12803d;

    /* renamed from: c, reason: collision with root package name */
    public int f12806c;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i10, Object obj) {
        int length;
        b bVar = e.Companion;
        int i11 = this.f12806c;
        bVar.getClass();
        b.c(i10, i11);
        if (i10 == this.f12806c) {
            addLast(obj);
            return;
        }
        if (i10 == 0) {
            addFirst(obj);
            return;
        }
        n();
        g(this.f12806c + 1);
        int iM = m(this.f12804a + i10);
        int i12 = this.f12806c;
        if (i10 < ((i12 + 1) >> 1)) {
            if (iM == 0) {
                Object[] objArr = this.f12805b;
                objArr.getClass();
                length = objArr.length - 1;
            } else {
                length = iM - 1;
            }
            int length2 = this.f12804a;
            if (length2 == 0) {
                Object[] objArr2 = this.f12805b;
                objArr2.getClass();
                length2 = objArr2.length;
            }
            int i13 = length2 - 1;
            int i14 = this.f12804a;
            Object[] objArr3 = this.f12805b;
            if (length >= i14) {
                objArr3[i13] = objArr3[i14];
                j.i0(i14, i14 + 1, length + 1, objArr3, objArr3);
            } else {
                j.i0(i14 - 1, i14, objArr3.length, objArr3, objArr3);
                Object[] objArr4 = this.f12805b;
                objArr4[objArr4.length - 1] = objArr4[0];
                j.i0(0, 1, length + 1, objArr4, objArr4);
            }
            this.f12805b[length] = obj;
            this.f12804a = i13;
        } else {
            int iM2 = m(i12 + this.f12804a);
            Object[] objArr5 = this.f12805b;
            if (iM < iM2) {
                j.i0(iM + 1, iM, iM2, objArr5, objArr5);
            } else {
                j.i0(1, 0, iM2, objArr5, objArr5);
                Object[] objArr6 = this.f12805b;
                objArr6[0] = objArr6[objArr6.length - 1];
                j.i0(iM + 1, iM, objArr6.length - 1, objArr6, objArr6);
            }
            this.f12805b[iM] = obj;
        }
        this.f12806c++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        collection.getClass();
        b bVar = e.Companion;
        int i11 = this.f12806c;
        bVar.getClass();
        b.c(i10, i11);
        if (collection.isEmpty()) {
            return false;
        }
        if (i10 == this.f12806c) {
            return addAll(collection);
        }
        n();
        g(collection.size() + this.f12806c);
        int iM = m(this.f12806c + this.f12804a);
        int iM2 = m(this.f12804a + i10);
        int size = collection.size();
        if (i10 >= ((this.f12806c + 1) >> 1)) {
            int i12 = iM2 + size;
            Object[] objArr = this.f12805b;
            if (iM2 < iM) {
                int i13 = size + iM;
                if (i13 <= objArr.length) {
                    j.i0(i12, iM2, iM, objArr, objArr);
                } else if (i12 >= objArr.length) {
                    j.i0(i12 - objArr.length, iM2, iM, objArr, objArr);
                } else {
                    int length = iM - (i13 - objArr.length);
                    j.i0(0, length, iM, objArr, objArr);
                    Object[] objArr2 = this.f12805b;
                    j.i0(i12, iM2, length, objArr2, objArr2);
                }
            } else {
                j.i0(size, 0, iM, objArr, objArr);
                Object[] objArr3 = this.f12805b;
                if (i12 >= objArr3.length) {
                    j.i0(i12 - objArr3.length, iM2, objArr3.length, objArr3, objArr3);
                } else {
                    j.i0(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.f12805b;
                    j.i0(i12, iM2, objArr4.length - size, objArr4, objArr4);
                }
            }
            e(iM2, collection);
            return true;
        }
        int i14 = this.f12804a;
        int length2 = i14 - size;
        Object[] objArr5 = this.f12805b;
        if (iM2 < i14) {
            j.i0(length2, i14, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.f12805b;
            if (size >= iM2) {
                j.i0(objArr6.length - size, 0, iM2, objArr6, objArr6);
            } else {
                j.i0(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.f12805b;
                j.i0(0, size, iM2, objArr7, objArr7);
            }
        } else if (length2 >= 0) {
            j.i0(length2, i14, iM2, objArr5, objArr5);
        } else {
            length2 += objArr5.length;
            int i15 = iM2 - i14;
            int length3 = objArr5.length - length2;
            if (length3 >= i15) {
                j.i0(length2, i14, iM2, objArr5, objArr5);
            } else {
                j.i0(length2, i14, i14 + length3, objArr5, objArr5);
                Object[] objArr8 = this.f12805b;
                j.i0(0, this.f12804a + length3, iM2, objArr8, objArr8);
            }
        }
        this.f12804a = length2;
        e(i(iM2 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        g(this.f12806c + 1);
        int length = this.f12804a;
        if (length == 0) {
            Object[] objArr = this.f12805b;
            objArr.getClass();
            length = objArr.length;
        }
        int i10 = length - 1;
        this.f12804a = i10;
        this.f12805b[i10] = obj;
        this.f12806c++;
    }

    public final void addLast(Object obj) {
        n();
        g(c() + 1);
        this.f12805b[m(c() + this.f12804a)] = obj;
        this.f12806c = c() + 1;
    }

    @Override // t6.f
    public final int c() {
        return this.f12806c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.f12804a, m(c() + this.f12804a));
        }
        this.f12804a = 0;
        this.f12806c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // t6.f
    public final Object d(int i10) {
        b bVar = e.Companion;
        int i11 = this.f12806c;
        bVar.getClass();
        b.b(i10, i11);
        if (i10 == c() - 1) {
            return removeLast();
        }
        if (i10 == 0) {
            return removeFirst();
        }
        n();
        int iM = m(this.f12804a + i10);
        Object[] objArr = this.f12805b;
        Object obj = objArr[iM];
        int i12 = this.f12806c >> 1;
        int i13 = this.f12804a;
        if (i10 < i12) {
            if (iM >= i13) {
                j.i0(i13 + 1, i13, iM, objArr, objArr);
            } else {
                j.i0(1, 0, iM, objArr, objArr);
                Object[] objArr2 = this.f12805b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i14 = this.f12804a;
                j.i0(i14 + 1, i14, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f12805b;
            int i15 = this.f12804a;
            objArr3[i15] = null;
            this.f12804a = h(i15);
        } else {
            int iM2 = m((c() - 1) + i13);
            Object[] objArr4 = this.f12805b;
            if (iM <= iM2) {
                j.i0(iM, iM + 1, iM2 + 1, objArr4, objArr4);
            } else {
                j.i0(iM, iM + 1, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f12805b;
                objArr5[objArr5.length - 1] = objArr5[0];
                j.i0(0, 1, iM2 + 1, objArr5, objArr5);
            }
            this.f12805b[iM2] = null;
        }
        this.f12806c--;
        return obj;
    }

    public final void e(int i10, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f12805b.length;
        while (i10 < length && it.hasNext()) {
            this.f12805b[i10] = it.next();
            i10++;
        }
        int i11 = this.f12804a;
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            this.f12805b[i12] = it.next();
        }
        this.f12806c = collection.size() + this.f12806c;
    }

    public final void g(int i10) {
        if (i10 < 0) {
            androidx.window.layout.c.g("Deque is too big.");
            return;
        }
        Object[] objArr = this.f12805b;
        if (i10 <= objArr.length) {
            return;
        }
        if (objArr == f12803d) {
            if (i10 < 10) {
                i10 = 10;
            }
            this.f12805b = new Object[i10];
            return;
        }
        b bVar = e.Companion;
        int length = objArr.length;
        bVar.getClass();
        Object[] objArr2 = new Object[b.e(length, i10)];
        Object[] objArr3 = this.f12805b;
        j.i0(0, this.f12804a, objArr3.length, objArr3, objArr2);
        Object[] objArr4 = this.f12805b;
        int length2 = objArr4.length;
        int i11 = this.f12804a;
        j.i0(length2 - i11, 0, i11, objArr4, objArr2);
        this.f12804a = 0;
        this.f12805b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i10) {
        b bVar = e.Companion;
        int i11 = this.f12806c;
        bVar.getClass();
        b.b(i10, i11);
        return this.f12805b[m(this.f12804a + i10)];
    }

    public final int h(int i10) {
        this.f12805b.getClass();
        if (i10 == r0.length - 1) {
            return 0;
        }
        return i10 + 1;
    }

    public final int i(int i10) {
        return i10 < 0 ? i10 + this.f12805b.length : i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i10;
        int iM = m(c() + this.f12804a);
        int length = this.f12804a;
        if (length < iM) {
            while (length < iM) {
                if (kotlin.jvm.internal.l.a(obj, this.f12805b[length])) {
                    i10 = this.f12804a;
                } else {
                    length++;
                }
            }
            return -1;
        }
        if (length < iM) {
            return -1;
        }
        int length2 = this.f12805b.length;
        while (true) {
            if (length >= length2) {
                for (int i11 = 0; i11 < iM; i11++) {
                    if (kotlin.jvm.internal.l.a(obj, this.f12805b[i11])) {
                        length = i11 + this.f12805b.length;
                        i10 = this.f12804a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.l.a(obj, this.f12805b[length])) {
                i10 = this.f12804a;
                break;
            }
            length++;
        }
        return length - i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return c() == 0;
    }

    public final void l(int i10, int i11) {
        Object[] objArr = this.f12805b;
        if (i10 < i11) {
            j.q0(null, objArr, i10, i11);
        } else {
            j.q0(null, objArr, i10, objArr.length);
            j.q0(null, this.f12805b, 0, i11);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i10;
        int iM = m(this.f12806c + this.f12804a);
        int i11 = this.f12804a;
        if (i11 < iM) {
            length = iM - 1;
            if (i11 <= length) {
                while (!kotlin.jvm.internal.l.a(obj, this.f12805b[length])) {
                    if (length != i11) {
                        length--;
                    }
                }
                i10 = this.f12804a;
                return length - i10;
            }
            return -1;
        }
        if (i11 > iM) {
            while (true) {
                iM--;
                Object[] objArr = this.f12805b;
                if (-1 >= iM) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i12 = this.f12804a;
                    if (i12 <= length) {
                        while (!kotlin.jvm.internal.l.a(obj, this.f12805b[length])) {
                            if (length != i12) {
                                length--;
                            }
                        }
                        i10 = this.f12804a;
                    }
                } else if (kotlin.jvm.internal.l.a(obj, objArr[iM])) {
                    length = iM + this.f12805b.length;
                    i10 = this.f12804a;
                    break;
                }
            }
            return length - i10;
        }
        return -1;
    }

    public final int m(int i10) {
        Object[] objArr = this.f12805b;
        return i10 >= objArr.length ? i10 - objArr.length : i10;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        d(iIndexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int iM;
        Object[] objArr;
        collection.getClass();
        boolean z9 = false;
        z9 = false;
        z9 = false;
        if (!isEmpty() && this.f12805b.length != 0) {
            int iM2 = m(c() + this.f12804a);
            int i10 = this.f12804a;
            if (i10 < iM2) {
                iM = i10;
                while (true) {
                    objArr = this.f12805b;
                    if (i10 >= iM2) {
                        break;
                    }
                    Object obj = objArr[i10];
                    if (collection.contains(obj)) {
                        z9 = true;
                    } else {
                        this.f12805b[iM] = obj;
                        iM++;
                    }
                    i10++;
                }
                j.q0(null, objArr, iM, iM2);
            } else {
                int length = this.f12805b.length;
                boolean z10 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr2 = this.f12805b;
                    Object obj2 = objArr2[i10];
                    objArr2[i10] = null;
                    if (collection.contains(obj2)) {
                        z10 = true;
                    } else {
                        this.f12805b[i11] = obj2;
                        i11++;
                    }
                    i10++;
                }
                iM = m(i11);
                for (int i12 = 0; i12 < iM2; i12++) {
                    Object[] objArr3 = this.f12805b;
                    Object obj3 = objArr3[i12];
                    objArr3[i12] = null;
                    if (collection.contains(obj3)) {
                        z10 = true;
                    } else {
                        this.f12805b[iM] = obj3;
                        iM = h(iM);
                    }
                }
                z9 = z10;
            }
            if (z9) {
                n();
                this.f12806c = i(iM - this.f12804a);
            }
        }
        return z9;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            com.google.gson.internal.a.o("ArrayDeque is empty.");
            return null;
        }
        n();
        Object[] objArr = this.f12805b;
        int i10 = this.f12804a;
        Object obj = objArr[i10];
        objArr[i10] = null;
        this.f12804a = h(i10);
        this.f12806c = c() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            com.google.gson.internal.a.o("ArrayDeque is empty.");
            return null;
        }
        n();
        int iM = m((size() - 1) + this.f12804a);
        Object[] objArr = this.f12805b;
        Object obj = objArr[iM];
        objArr[iM] = null;
        this.f12806c = c() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i10, int i11) {
        b bVar = e.Companion;
        int i12 = this.f12806c;
        bVar.getClass();
        b.d(i10, i11, i12);
        int i13 = i11 - i10;
        if (i13 == 0) {
            return;
        }
        if (i13 == this.f12806c) {
            clear();
            return;
        }
        if (i13 == 1) {
            d(i10);
            return;
        }
        n();
        int i14 = this.f12806c - i11;
        int i15 = this.f12804a;
        if (i10 < i14) {
            int iM = m((i10 - 1) + i15);
            int iM2 = m(this.f12804a + (i11 - 1));
            while (i10 > 0) {
                int i16 = iM + 1;
                int iMin = Math.min(i10, Math.min(i16, iM2 + 1));
                Object[] objArr = this.f12805b;
                int i17 = iM2 - iMin;
                int i18 = iM - iMin;
                j.i0(i17 + 1, i18 + 1, i16, objArr, objArr);
                iM = i(i18);
                iM2 = i(i17);
                i10 -= iMin;
            }
            int iM3 = m(this.f12804a + i13);
            l(this.f12804a, iM3);
            this.f12804a = iM3;
        } else {
            int iM4 = m(i15 + i11);
            int iM5 = m(this.f12804a + i10);
            int i19 = this.f12806c;
            while (true) {
                i19 -= i11;
                if (i19 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f12805b;
                i11 = Math.min(i19, Math.min(objArr2.length - iM4, objArr2.length - iM5));
                Object[] objArr3 = this.f12805b;
                int i20 = iM4 + i11;
                j.i0(iM5, iM4, i20, objArr3, objArr3);
                iM4 = m(i20);
                iM5 = m(iM5 + i11);
            }
            int iM6 = m(this.f12806c + this.f12804a);
            l(i(iM6 - i13), iM6);
        }
        this.f12806c -= i13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int iM;
        Object[] objArr;
        collection.getClass();
        boolean z9 = false;
        z9 = false;
        z9 = false;
        if (!isEmpty() && this.f12805b.length != 0) {
            int iM2 = m(c() + this.f12804a);
            int i10 = this.f12804a;
            if (i10 < iM2) {
                iM = i10;
                while (true) {
                    objArr = this.f12805b;
                    if (i10 >= iM2) {
                        break;
                    }
                    Object obj = objArr[i10];
                    if (collection.contains(obj)) {
                        this.f12805b[iM] = obj;
                        iM++;
                    } else {
                        z9 = true;
                    }
                    i10++;
                }
                j.q0(null, objArr, iM, iM2);
            } else {
                int length = this.f12805b.length;
                boolean z10 = false;
                int i11 = i10;
                while (i10 < length) {
                    Object[] objArr2 = this.f12805b;
                    Object obj2 = objArr2[i10];
                    objArr2[i10] = null;
                    if (collection.contains(obj2)) {
                        this.f12805b[i11] = obj2;
                        i11++;
                    } else {
                        z10 = true;
                    }
                    i10++;
                }
                iM = m(i11);
                for (int i12 = 0; i12 < iM2; i12++) {
                    Object[] objArr3 = this.f12805b;
                    Object obj3 = objArr3[i12];
                    objArr3[i12] = null;
                    if (collection.contains(obj3)) {
                        this.f12805b[iM] = obj3;
                        iM = h(iM);
                    } else {
                        z10 = true;
                    }
                }
                z9 = z10;
            }
            if (z9) {
                n();
                this.f12806c = i(iM - this.f12804a);
            }
        }
        return z9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        b bVar = e.Companion;
        int i11 = this.f12806c;
        bVar.getClass();
        b.b(i10, i11);
        int iM = m(this.f12804a + i10);
        Object[] objArr = this.f12805b;
        Object obj2 = objArr[iM];
        objArr[iM] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) throws NegativeArraySizeException {
        objArr.getClass();
        int length = objArr.length;
        int i10 = this.f12806c;
        if (length < i10) {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), i10);
            objNewInstance.getClass();
            objArr = (Object[]) objNewInstance;
        }
        Object[] objArr2 = objArr;
        int iM = m(this.f12806c + this.f12804a);
        int i11 = this.f12804a;
        if (i11 < iM) {
            j.o0(this.f12805b, objArr2, 0, i11, iM, 2);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.f12805b;
            j.i0(0, this.f12804a, objArr3.length, objArr3, objArr2);
            Object[] objArr4 = this.f12805b;
            j.i0(objArr4.length - this.f12804a, 0, iM, objArr4, objArr2);
        }
        int i12 = this.f12806c;
        if (i12 < objArr2.length) {
            objArr2[i12] = null;
        }
        return objArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[c()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        n();
        g(collection.size() + c());
        e(m(c() + this.f12804a), collection);
        return true;
    }
}

package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class b implements Collection, Serializable {
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9372a;

    @Override // java.util.Collection
    public abstract boolean contains(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    public b(ConcurrentHashMap concurrentHashMap) {
        this.f9372a = concurrentHashMap;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f9372a.clear();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f9372a.size();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f9372a.isEmpty();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        long j10 = this.f9372a.j();
        if (j10 < 0) {
            j10 = 0;
        }
        if (j10 > 2147483639) {
            throw new OutOfMemoryError("Required array size too large");
        }
        int i10 = (int) j10;
        Object[] objArrCopyOf = new Object[i10];
        Iterator it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (i11 == i10) {
                if (i10 >= 2147483639) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                int i12 = i10 < 1073741819 ? (i10 >>> 1) + 1 + i10 : 2147483639;
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
                i10 = i12;
            }
            objArrCopyOf[i11] = next;
            i11++;
        }
        return i11 == i10 ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i11);
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        long j10 = this.f9372a.j();
        if (j10 < 0) {
            j10 = 0;
        }
        if (j10 > 2147483639) {
            throw new OutOfMemoryError("Required array size too large");
        }
        int i10 = (int) j10;
        Object[] objArrCopyOf = objArr.length >= i10 ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i10);
        int length = objArrCopyOf.length;
        Iterator it = iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (i11 == length) {
                if (length >= 2147483639) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                int i12 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
                length = i12;
            }
            objArrCopyOf[i11] = next;
            i11++;
        }
        if (objArr != objArrCopyOf || i11 >= length) {
            return i11 == length ? objArrCopyOf : Arrays.copyOf(objArrCopyOf, i11);
        }
        objArrCopyOf[i11] = null;
        return objArrCopyOf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        if (collection == this) {
            return true;
        }
        for (Object obj : collection) {
            if (obj == null || !contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        collection.getClass();
        l[] lVarArr = this.f9372a.f9362a;
        boolean zRemove = false;
        if (lVarArr == null) {
            return false;
        }
        if ((collection instanceof Set) && collection.size() > lVarArr.length) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    zRemove = true;
                }
            }
            return zRemove;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            zRemove |= remove(it2.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z9 = true;
            }
        }
        return z9;
    }
}

package androidx.collection;

import androidx.annotation.IntRange;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import g7.l;
import h7.a;
import h7.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.g;
import l7.d;
import n7.f;
import t6.j;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list, int i10) {
            list.getClass();
            this.list = list;
            this.prevIndex = i10 - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t) {
            List<T> list = this.list;
            int i10 = this.prevIndex + 1;
            this.prevIndex = i10;
            list.add(i10, t);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i10 = this.prevIndex + 1;
            this.prevIndex = i10;
            return list.get(i10);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i10 = this.prevIndex;
            this.prevIndex = i10 - 1;
            return list.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t) {
            this.list.set(this.prevIndex, t);
        }
    }

    public /* synthetic */ MutableObjectList(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = mutableObjectList._size;
        }
        mutableObjectList.trim(i10);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, E e) {
        int i11;
        if (i10 < 0 || i10 > (i11 = this._size)) {
            com.google.gson.internal.a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i11 + 1);
        Object[] objArr = this.content;
        int i12 = this._size;
        if (i10 != i12) {
            j.i0(i10 + 1, i10, i12, objArr, objArr);
        }
        objArr[i10] = e;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, Collection<? extends E> collection) {
        collection.getClass();
        if (i10 < 0 || i10 > this._size) {
            com.google.gson.internal.a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return false;
        }
        int i11 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(collection.size() + this._size);
        Object[] objArr = this.content;
        if (i10 != this._size) {
            j.i0(collection.size() + i10, i10, this._size, objArr, objArr);
        }
        for (Object obj : collection) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                m.U();
                throw null;
            }
            objArr[i11 + i10] = obj;
            i11 = i12;
        }
        this._size = collection.size() + this._size;
        return true;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        j.q0(null, this.content, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i10) {
        Object[] objArr = this.content;
        if (objArr.length < i10) {
            this.content = Arrays.copyOf(objArr, Math.max(i10, (objArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        remove(objArr[(i10 << 3) + i12]);
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        if (scatterSet.isEmpty()) {
            return;
        }
        ensureCapacity(scatterSet.getSize() + this._size);
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        add(objArr[(i10 << 3) + i12]);
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return;
                }
            }
            if (i10 == length) {
                return;
            } else {
                i10++;
            }
        }
    }

    public final boolean remove(E e) {
        int iIndexOf = indexOf(e);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(E[] eArr) {
        eArr.getClass();
        int i10 = this._size;
        for (E e : eArr) {
            remove(e);
        }
        return i10 != this._size;
    }

    public final E removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this._size)) {
            com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
            return null;
        }
        Object[] objArr = this.content;
        E e = (E) objArr[i10];
        if (i10 != i11 - 1) {
            j.i0(i10, i10 + 1, i11, objArr, objArr);
        }
        int i12 = this._size - 1;
        this._size = i12;
        objArr[i12] = null;
        return e;
    }

    public final void removeIf(l lVar) {
        lVar.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        int i11 = 0;
        d dVarN = l5.N(0, i10);
        int i12 = dVarN.f11084a;
        int i13 = dVarN.f11085b;
        if (i12 <= i13) {
            while (true) {
                objArr[i12 - i11] = objArr[i12];
                if (((Boolean) lVar.invoke(objArr[i12])).booleanValue()) {
                    i11++;
                }
                if (i12 == i13) {
                    break;
                } else {
                    i12++;
                }
            }
        }
        j.q0(null, objArr, i10 - i11, i10);
        this._size -= i11;
    }

    public final void removeRange(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i11) {
        int i12;
        if (i10 < 0 || i10 > (i12 = this._size) || i11 < 0 || i11 > i12) {
            com.google.gson.internal.a.f(this._size, a3.a.q(i10, i11, "Start (", ") and end (", ") must be in 0.."));
            return;
        }
        if (i11 < i10) {
            a2.a.f(i10, i11);
            return;
        }
        if (i11 != i10) {
            if (i11 < i12) {
                Object[] objArr = this.content;
                j.i0(i10, i11, i12, objArr, objArr);
            }
            int i13 = this._size;
            int i14 = i13 - (i11 - i10);
            j.q0(null, this.content, i14, i13);
            this._size = i14;
        }
    }

    public final boolean retainAll(f fVar) {
        fVar.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        int i11 = i10 - 1;
        while (true) {
            int i12 = -1;
            if (-1 >= i11) {
                return i10 != this._size;
            }
            Object obj = objArr[i11];
            Iterator it = fVar.iterator();
            int i13 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (i13 < 0) {
                    m.U();
                    throw null;
                }
                if (kotlin.jvm.internal.l.a(obj, next)) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
            if (!(i12 >= 0)) {
                removeAt(i11);
            }
            i11--;
        }
    }

    public final E set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, E e) {
        if (i10 < 0 || i10 >= this._size) {
            com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "set index ", " must be between 0 .. "));
            return null;
        }
        Object[] objArr = this.content;
        E e3 = (E) objArr[i10];
        objArr[i10] = e;
        return e3;
    }

    public final void trim(int i10) {
        int iMax = Math.max(i10, this._size);
        Object[] objArr = this.content;
        if (objArr.length > iMax) {
            this.content = Arrays.copyOf(objArr, iMax);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ObjectListMutableList<T> implements List<T>, b {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> mutableObjectList) {
            mutableObjectList.getClass();
            this.objectList = mutableObjectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t) {
            return this.objectList.add(t);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            collection.getClass();
            return this.objectList.addAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.containsAll(collection);
        }

        @Override // java.util.List
        public T get(int i10) {
            ObjectListKt.checkIndex(this, i10);
            return this.objectList.get(i10);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.removeAll(collection);
        }

        public T removeAt(int i10) {
            ObjectListKt.checkIndex(this, i10);
            return this.objectList.removeAt(i10);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.retainAll((Collection<? extends T>) collection);
        }

        @Override // java.util.List
        public T set(int i10, T t) {
            ObjectListKt.checkIndex(this, i10);
            return this.objectList.set(i10, t);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i10, int i11) {
            ObjectListKt.checkSubIndex(this, i10, i11);
            return new SubList(this, i10, i11);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            tArr.getClass();
            return (T[]) kotlin.jvm.internal.l.k(this, tArr);
        }

        @Override // java.util.List
        public void add(int i10, T t) {
            this.objectList.add(i10, t);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new MutableObjectListIterator(this, i10);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i10) {
            return removeAt(i10);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.l.j(this);
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends T> collection) {
            collection.getClass();
            return this.objectList.addAll(i10, collection);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SubList<T> implements List<T>, b {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i10, int i11) {
            list.getClass();
            this.list = list;
            this.start = i10;
            this.end = i11;
        }

        @Override // java.util.List
        public void add(int i10, T t) {
            this.list.add(i10 + this.start, t);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends T> collection) {
            collection.getClass();
            this.list.addAll(i10 + this.start, collection);
            this.end = collection.size() + this.end;
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i10 = this.end - 1;
            int i11 = this.start;
            if (i11 <= i10) {
                while (true) {
                    this.list.remove(i10);
                    if (i10 == i11) {
                        break;
                    } else {
                        i10--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i11), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            collection.getClass();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i10) {
            ObjectListKt.checkIndex(this, i10);
            return this.list.get(i10 + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i11), obj)) {
                    return i11 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i10 = this.end - 1;
            int i11 = this.start;
            if (i11 > i10) {
                return -1;
            }
            while (!kotlin.jvm.internal.l.a(this.list.get(i10), obj)) {
                if (i10 == i11) {
                    return -1;
                }
                i10--;
            }
            return i10 - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i10 = this.end;
            for (int i11 = this.start; i11 < i10; i11++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i11), obj)) {
                    this.list.remove(i11);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            collection.getClass();
            int i10 = this.end;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i10 != this.end;
        }

        public T removeAt(int i10) {
            ObjectListKt.checkIndex(this, i10);
            this.end--;
            return this.list.remove(i10 + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            collection.getClass();
            int i10 = this.end;
            int i11 = i10 - 1;
            int i12 = this.start;
            if (i12 <= i11) {
                while (true) {
                    if (!collection.contains(this.list.get(i11))) {
                        this.list.remove(i11);
                        this.end--;
                    }
                    if (i11 == i12) {
                        break;
                    }
                    i11--;
                }
            }
            return i10 != this.end;
        }

        @Override // java.util.List
        public T set(int i10, T t) {
            ObjectListKt.checkIndex(this, i10);
            return this.list.set(i10 + this.start, t);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i10, int i11) {
            ObjectListKt.checkSubIndex(this, i10, i11);
            return new SubList(this, i10, i11);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            tArr.getClass();
            return (T[]) kotlin.jvm.internal.l.k(this, tArr);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new MutableObjectListIterator(this, i10);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.l.j(this);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t) {
            List<T> list = this.list;
            int i10 = this.end;
            this.end = i10 + 1;
            list.add(i10, t);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            collection.getClass();
            this.list.addAll(this.end, collection);
            this.end = collection.size() + this.end;
            return collection.size() > 0;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i10) {
            return removeAt(i10);
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public MutableObjectList(int i10) {
        super(i10, null);
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i10 = this._size;
        minusAssign((ObjectList) objectList);
        return i10 != this._size;
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int i10 = this._size;
        minusAssign((ScatterSet) scatterSet);
        return i10 != this._size;
    }

    public final boolean removeAll(List<? extends E> list) {
        list.getClass();
        int i10 = this._size;
        minusAssign((List) list);
        return i10 != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i10 = this._size;
        minusAssign((Iterable) iterable);
        return i10 != this._size;
    }

    public final boolean removeAll(f fVar) {
        fVar.getClass();
        int i10 = this._size;
        minusAssign(fVar);
        return i10 != this._size;
    }

    public final boolean add(E e) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i10 = this._size;
        objArr[i10] = e;
        this._size = i10 + 1;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!objectList.contains(objArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final void minusAssign(List<? extends E> list) {
        list.getClass();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            remove(list.get(i10));
        }
    }

    public final boolean retainAll(Collection<? extends E> collection) {
        collection.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!collection.contains(objArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final void minusAssign(E[] eArr) {
        eArr.getClass();
        for (E e : eArr) {
            remove(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i10 = objectList._size;
        for (int i11 = 0; i11 < i10; i11++) {
            remove(objArr[i11]);
        }
    }

    public final boolean retainAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!t6.l.a0(iterable, objArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final void minusAssign(E e) {
        remove(e);
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(E[] eArr) {
        eArr.getClass();
        int i10 = this._size;
        Object[] objArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (j.v0(eArr, objArr[i11]) < 0) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final void plusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        if (objectList.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + objectList._size);
        j.i0(this._size, 0, objectList._size, objectList.content, this.content);
        this._size += objectList._size;
    }

    public final void plusAssign(E[] eArr) {
        eArr.getClass();
        if (eArr.length == 0) {
            return;
        }
        ensureCapacity(this._size + eArr.length);
        j.o0(eArr, this.content, this._size, 0, 0, 12);
        this._size += eArr.length;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, E[] eArr) {
        int i11;
        eArr.getClass();
        if (i10 >= 0 && i10 <= (i11 = this._size)) {
            if (eArr.length == 0) {
                return false;
            }
            ensureCapacity(i11 + eArr.length);
            Object[] objArr = this.content;
            int i12 = this._size;
            if (i10 != i12) {
                j.i0(eArr.length + i10, i10, i12, objArr, objArr);
            }
            j.o0(eArr, objArr, i10, 0, 0, 12);
            this._size += eArr.length;
            return true;
        }
        com.google.gson.internal.a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
        return false;
    }

    public final void plusAssign(List<? extends E> list) {
        list.getClass();
        if (list.isEmpty()) {
            return;
        }
        int i10 = this._size;
        ensureCapacity(list.size() + i10);
        Object[] objArr = this.content;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i11 + i10] = list.get(i11);
        }
        this._size = list.size() + this._size;
    }

    public final void plusAssign(E e) {
        add(e);
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, ObjectList<E> objectList) {
        objectList.getClass();
        if (i10 >= 0 && i10 <= this._size) {
            if (objectList.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + objectList._size);
            Object[] objArr = this.content;
            int i11 = this._size;
            if (i10 != i11) {
                j.i0(objectList._size + i10, i10, i11, objArr, objArr);
            }
            j.i0(i10, 0, objectList._size, objectList.content, objArr);
            this._size += objectList._size;
            return true;
        }
        com.google.gson.internal.a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i10 = this._size;
        plusAssign((ObjectList) objectList);
        return i10 != this._size;
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int i10 = this._size;
        plusAssign((ScatterSet) scatterSet);
        return i10 != this._size;
    }

    public final boolean addAll(E[] eArr) {
        eArr.getClass();
        int i10 = this._size;
        plusAssign((Object[]) eArr);
        return i10 != this._size;
    }

    public final boolean addAll(List<? extends E> list) {
        list.getClass();
        int i10 = this._size;
        plusAssign((List) list);
        return i10 != this._size;
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i10 = this._size;
        plusAssign((Iterable) iterable);
        return i10 != this._size;
    }

    public final boolean addAll(f fVar) {
        fVar.getClass();
        int i10 = this._size;
        plusAssign(fVar);
        return i10 != this._size;
    }
}

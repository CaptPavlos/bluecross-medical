package androidx.collection;

import a3.a;
import java.util.List;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ObjectListKt {
    private static final Object[] EmptyArray = new Object[0];
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i10) {
        int size = list.size();
        if (i10 < 0 || i10 >= size) {
            throw new IndexOutOfBoundsException("Index " + i10 + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i10, int i11) {
        int size = list.size();
        if (i10 > i11) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i10 + ") is greater than toIndex (" + i11 + ").");
        }
        if (i10 < 0) {
            u.k(a.g(i10, "fromIndex (", ") is less than 0."));
            return;
        }
        if (i11 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i11 + ") is more than than the list size (" + size + ')');
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        objectList.getClass();
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e3, E e7) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e);
        mutableObjectList.add(e3);
        mutableObjectList.add(e7);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E... eArr) {
        eArr.getClass();
        MutableObjectList mutableObjectList = new MutableObjectList(eArr.length);
        mutableObjectList.plusAssign((Object[]) eArr);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e) {
        return mutableObjectListOf(e);
    }

    public static final <E> ObjectList<E> objectListOf(E e, E e3) {
        return mutableObjectListOf(e, e3);
    }

    public static final <E> ObjectList<E> objectListOf(E e, E e3, E e7) {
        return mutableObjectListOf(e, e3, e7);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        objectList.getClass();
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e, E e3) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e);
        mutableObjectList.add(e3);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, null);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... eArr) {
        eArr.getClass();
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(eArr.length);
        mutableObjectList.plusAssign((Object[]) eArr);
        return mutableObjectList;
    }
}

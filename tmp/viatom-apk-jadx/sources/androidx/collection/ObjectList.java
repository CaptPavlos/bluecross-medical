package androidx.collection;

import a2.a;
import androidx.annotation.IntRange;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import g7.l;
import g7.p;
import g7.q;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import l7.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    private ObjectList(int i10) {
        this.content = i10 == 0 ? ObjectListKt.EmptyArray : new Object[i10];
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
        if (obj != null) {
            a.m("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i11 & 2) != 0) {
            charSequence2 = "";
        }
        if ((i11 & 4) != 0) {
            charSequence3 = "";
        }
        if ((i11 & 8) != 0) {
            i10 = -1;
        }
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        CharSequence charSequence5 = charSequence4;
        l lVar2 = lVar;
        return objectList.joinToString(charSequence, charSequence2, charSequence3, i10, charSequence5, lVar2);
    }

    public final boolean any(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (((Boolean) lVar.invoke(objArr[i11])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public abstract List<E> asList();

    public final boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public final boolean containsAll(List<? extends E> list) {
        list.getClass();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!contains(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public final int count(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (((Boolean) lVar.invoke(objArr[i12])).booleanValue()) {
                i11++;
            }
        }
        return i11;
    }

    public final E elementAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        if (i10 >= 0 && i10 < this._size) {
            return (E) this.content[i10];
        }
        com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
        return null;
    }

    public final E elementAtOrElse(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, l lVar) {
        lVar.getClass();
        return (i10 < 0 || i10 >= this._size) ? (E) lVar.invoke(Integer.valueOf(i10)) : (E) this.content[i10];
    }

    public boolean equals(Object obj) {
        if (obj instanceof ObjectList) {
            ObjectList objectList = (ObjectList) obj;
            int i10 = objectList._size;
            int i11 = this._size;
            if (i10 == i11) {
                Object[] objArr = this.content;
                Object[] objArr2 = objectList.content;
                d dVarN = l5.N(0, i11);
                int i12 = dVarN.f11084a;
                int i13 = dVarN.f11085b;
                if (i12 > i13) {
                    return true;
                }
                while (kotlin.jvm.internal.l.a(objArr[i12], objArr2[i12])) {
                    if (i12 == i13) {
                        return true;
                    }
                    i12++;
                }
                return false;
            }
        }
        return false;
    }

    public final E first(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            E e = (E) objArr[i11];
            if (((Boolean) lVar.invoke(e)).booleanValue()) {
                return e;
            }
        }
        com.google.gson.internal.a.o("ObjectList contains no element matching the predicate.");
        return null;
    }

    public final E firstOrNull(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            E e = (E) objArr[i11];
            if (((Boolean) lVar.invoke(e)).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    public final <R> R fold(R r6, p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            r6 = (R) pVar.invoke(r6, objArr[i11]);
        }
        return r6;
    }

    public final <R> R foldIndexed(R r6, q qVar) {
        qVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            r6 = (R) qVar.invoke(Integer.valueOf(i11), r6, objArr[i11]);
        }
        return r6;
    }

    public final <R> R foldRight(R r6, p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return r6;
            }
            r6 = (R) pVar.invoke(objArr[i10], r6);
        }
    }

    public final <R> R foldRightIndexed(R r6, q qVar) {
        qVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return r6;
            }
            r6 = (R) qVar.invoke(Integer.valueOf(i10), objArr[i10], r6);
        }
    }

    public final void forEach(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            lVar.invoke(objArr[i11]);
        }
    }

    public final void forEachIndexed(p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            pVar.invoke(Integer.valueOf(i11), objArr[i11]);
        }
    }

    public final void forEachReversed(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                lVar.invoke(objArr[i10]);
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        pVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                pVar.invoke(Integer.valueOf(i10), objArr[i10]);
            }
        }
    }

    public final E get(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        if (i10 >= 0 && i10 < this._size) {
            return (E) this.content[i10];
        }
        com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
        return null;
    }

    public final d getIndices() {
        return l5.N(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i10 = this._size;
        int iHashCode = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final int indexOf(E e) {
        Object[] objArr = this.content;
        int i10 = 0;
        if (e == null) {
            int i11 = this._size;
            while (i10 < i11) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int i12 = this._size;
        while (i10 < i12) {
            if (e.equals(objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (((Boolean) lVar.invoke(objArr[i11])).booleanValue()) {
                return i11;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return -1;
            }
        } while (!((Boolean) lVar.invoke(objArr[i10])).booleanValue());
        return i10;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar) {
        StringBuilder sbU = a3.a.u(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        Object[] objArr = this.content;
        int i11 = this._size;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                sbU.append(charSequence3);
                break;
            }
            Object obj = objArr[i12];
            if (i12 == i10) {
                sbU.append(charSequence4);
                break;
            }
            if (i12 != 0) {
                sbU.append(charSequence);
            }
            if (lVar == null) {
                sbU.append(obj);
            } else {
                sbU.append((CharSequence) lVar.invoke(obj));
            }
            i12++;
        }
        return sbU.toString();
    }

    public final E last(l lVar) {
        E e;
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                com.google.gson.internal.a.o("ObjectList contains no element matching the predicate.");
                return null;
            }
            e = (E) objArr[i10];
        } while (!((Boolean) lVar.invoke(e)).booleanValue());
        return e;
    }

    public final int lastIndexOf(E e) {
        Object[] objArr = this.content;
        if (e == null) {
            for (int i10 = this._size - 1; -1 < i10; i10--) {
                if (objArr[i10] == null) {
                    return i10;
                }
            }
        } else {
            for (int i11 = this._size - 1; -1 < i11; i11--) {
                if (e.equals(objArr[i11])) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public final E lastOrNull(l lVar) {
        E e;
        lVar.getClass();
        Object[] objArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return null;
            }
            e = (E) objArr[i10];
        } while (!((Boolean) lVar.invoke(e)).booleanValue());
        return e;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        lVar.getClass();
        Object[] objArr = this.content;
        for (int i10 = this._size - 1; -1 < i10; i10--) {
            if (((Boolean) lVar.invoke(objArr[i10])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, new AnonymousClass1(this), 25, null);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.collection.ObjectList$toString$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements l {
        final /* synthetic */ ObjectList<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ObjectList<E> objectList) {
            super(1);
            this.this$0 = objectList;
        }

        @Override // g7.l
        public final CharSequence invoke(E e) {
            return e == this.this$0 ? "(this)" : String.valueOf(e);
        }

        @Override // g7.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke((AnonymousClass1) obj);
        }
    }

    public /* synthetic */ ObjectList(int i10, g gVar) {
        this(i10);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final boolean containsAll(E[] eArr) {
        eArr.getClass();
        for (E e : eArr) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final boolean any() {
        return isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i10 = objectList._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (!contains(objArr[i11])) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return (E) this.content[this._size - 1];
    }

    public final E first() {
        if (!isEmpty()) {
            return (E) this.content[0];
        }
        com.google.gson.internal.a.o("ObjectList is empty.");
        return null;
    }

    public final E last() {
        if (!isEmpty()) {
            return (E) this.content[this._size - 1];
        }
        com.google.gson.internal.a.o("ObjectList is empty.");
        return null;
    }

    public final String joinToString(CharSequence charSequence) {
        charSequence.getClass();
        return joinToString$default(this, charSequence, null, null, 0, null, null, 62, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        return joinToString$default(this, charSequence, charSequence2, null, 0, null, null, 60, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        a3.a.B(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, null, null, 56, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10) {
        a3.a.B(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i10, null, null, 48, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i10, charSequence4, null, 32, null);
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, null, 63, null);
    }
}

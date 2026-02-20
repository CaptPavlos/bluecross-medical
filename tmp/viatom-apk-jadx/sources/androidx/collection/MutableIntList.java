package androidx.collection;

import androidx.annotation.IntRange;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import com.google.gson.internal.a;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import t6.b;
import t6.e;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableIntList extends IntList {
    public /* synthetic */ MutableIntList(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = mutableIntList._size;
        }
        mutableIntList.trim(i10);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > (i12 = this._size)) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i12 + 1);
        int[] iArr = this.content;
        int i13 = this._size;
        if (i10 != i13) {
            j.j0(i10 + 1, i10, iArr, iArr, i13);
        }
        iArr[i10] = i11;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, IntList intList) {
        intList.getClass();
        if (i10 < 0 || i10 > this._size) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return false;
        }
        if (intList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + intList._size);
        int[] iArr = this.content;
        int i11 = this._size;
        if (i10 != i11) {
            j.j0(intList._size + i10, i10, iArr, iArr, i11);
        }
        j.j0(i10, 0, intList.content, iArr, intList._size);
        this._size += intList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i10) {
        int[] iArr = this.content;
        if (iArr.length < i10) {
            this.content = Arrays.copyOf(iArr, Math.max(i10, (iArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(IntList intList) {
        intList.getClass();
        int[] iArr = intList.content;
        int i10 = intList._size;
        for (int i11 = 0; i11 < i10; i11++) {
            remove(iArr[i11]);
        }
    }

    public final void plusAssign(IntList intList) {
        intList.getClass();
        addAll(this._size, intList);
    }

    public final boolean remove(int i10) {
        int iIndexOf = indexOf(i10);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(IntList intList) {
        intList.getClass();
        int i10 = this._size;
        int i11 = intList._size - 1;
        if (i11 >= 0) {
            int i12 = 0;
            while (true) {
                remove(intList.get(i12));
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        return i10 != this._size;
    }

    public final int removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this._size)) {
            a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
            return 0;
        }
        int[] iArr = this.content;
        int i12 = iArr[i10];
        if (i10 != i11 - 1) {
            j.j0(i10, i10 + 1, iArr, iArr, i11);
        }
        this._size--;
        return i12;
    }

    public final void removeRange(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i11) {
        int i12;
        if (i10 < 0 || i10 > (i12 = this._size) || i11 < 0 || i11 > i12) {
            a.f(this._size, a3.a.q(i10, i11, "Start (", ") and end (", ") must be in 0.."));
            return;
        }
        if (i11 < i10) {
            a2.a.f(i10, i11);
        } else if (i11 != i10) {
            if (i11 < i12) {
                int[] iArr = this.content;
                j.j0(i10, i11, iArr, iArr, i12);
            }
            this._size -= i11 - i10;
        }
    }

    public final boolean retainAll(int[] iArr) {
        iArr.getClass();
        int i10 = this._size;
        int[] iArr2 = this.content;
        int i11 = i10 - 1;
        while (true) {
            int i12 = 0;
            int i13 = -1;
            if (-1 >= i11) {
                break;
            }
            int i14 = iArr2[i11];
            int length = iArr.length;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (iArr[i12] == i14) {
                    i13 = i12;
                    break;
                }
                i12++;
            }
            if (i13 < 0) {
                removeAt(i11);
            }
            i11--;
        }
        return i10 != this._size;
    }

    public final int set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, int i11) {
        if (i10 < 0 || i10 >= this._size) {
            a.f(this._size - 1, a3.a.r(i10, "set index ", " must be between 0 .. "));
            return 0;
        }
        int[] iArr = this.content;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    public final void sort() {
        int[] iArr = this.content;
        int i10 = this._size;
        iArr.getClass();
        Arrays.sort(iArr, 0, i10);
    }

    public final void sortDescending() {
        int[] iArr = this.content;
        int i10 = this._size;
        iArr.getClass();
        Arrays.sort(iArr, 0, i10);
        b bVar = e.Companion;
        int length = iArr.length;
        bVar.getClass();
        b.d(0, i10, length);
        int i11 = i10 / 2;
        if (i11 == 0) {
            return;
        }
        int i12 = i10 - 1;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = iArr[i13];
            iArr[i13] = iArr[i12];
            iArr[i12] = i14;
            i12--;
        }
    }

    public final void trim(int i10) {
        int iMax = Math.max(i10, this._size);
        int[] iArr = this.content;
        if (iArr.length > iMax) {
            this.content = Arrays.copyOf(iArr, iMax);
        }
    }

    public final void plusAssign(int[] iArr) {
        iArr.getClass();
        addAll(this._size, iArr);
    }

    public MutableIntList() {
        this(0, 1, null);
    }

    public final void plusAssign(int i10) {
        add(i10);
    }

    public MutableIntList(int i10) {
        super(i10, null);
    }

    public final void minusAssign(int[] iArr) {
        iArr.getClass();
        for (int i10 : iArr) {
            remove(i10);
        }
    }

    public final void minusAssign(int i10) {
        remove(i10);
    }

    public final boolean removeAll(int[] iArr) {
        iArr.getClass();
        int i10 = this._size;
        for (int i11 : iArr) {
            remove(i11);
        }
        return i10 != this._size;
    }

    public final boolean retainAll(IntList intList) {
        intList.getClass();
        int i10 = this._size;
        int[] iArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!intList.contains(iArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final boolean add(int i10) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i11 = this._size;
        iArr[i11] = i10;
        this._size = i11 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, int[] iArr) {
        int i11;
        iArr.getClass();
        if (i10 >= 0 && i10 <= (i11 = this._size)) {
            if (iArr.length == 0) {
                return false;
            }
            ensureCapacity(i11 + iArr.length);
            int[] iArr2 = this.content;
            int i12 = this._size;
            if (i10 != i12) {
                j.j0(iArr.length + i10, i10, iArr2, iArr2, i12);
            }
            j.n0(i10, 0, iArr, iArr2, 12);
            this._size += iArr.length;
            return true;
        }
        a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(IntList intList) {
        intList.getClass();
        return addAll(this._size, intList);
    }

    public final boolean addAll(int[] iArr) {
        iArr.getClass();
        return addAll(this._size, iArr);
    }
}

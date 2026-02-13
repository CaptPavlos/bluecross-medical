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
public final class MutableLongList extends LongList {
    public /* synthetic */ MutableLongList(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = mutableLongList._size;
        }
        mutableLongList.trim(i10);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, long j10) {
        int i11;
        if (i10 < 0 || i10 > (i11 = this._size)) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i11 + 1);
        long[] jArr = this.content;
        int i12 = this._size;
        if (i10 != i12) {
            j.m0(jArr, jArr, i10 + 1, i10, i12);
        }
        jArr[i10] = j10;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, LongList longList) {
        longList.getClass();
        if (i10 < 0 || i10 > this._size) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return false;
        }
        if (longList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + longList._size);
        long[] jArr = this.content;
        int i11 = this._size;
        if (i10 != i11) {
            j.m0(jArr, jArr, longList._size + i10, i10, i11);
        }
        j.m0(longList.content, jArr, i10, 0, longList._size);
        this._size += longList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i10) {
        long[] jArr = this.content;
        if (jArr.length < i10) {
            this.content = Arrays.copyOf(jArr, Math.max(i10, (jArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(LongList longList) {
        longList.getClass();
        long[] jArr = longList.content;
        int i10 = longList._size;
        for (int i11 = 0; i11 < i10; i11++) {
            remove(jArr[i11]);
        }
    }

    public final void plusAssign(LongList longList) {
        longList.getClass();
        addAll(this._size, longList);
    }

    public final boolean remove(long j10) {
        int iIndexOf = indexOf(j10);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(LongList longList) {
        longList.getClass();
        int i10 = this._size;
        int i11 = longList._size - 1;
        if (i11 >= 0) {
            int i12 = 0;
            while (true) {
                remove(longList.get(i12));
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        return i10 != this._size;
    }

    public final long removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this._size)) {
            a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
            return 0L;
        }
        long[] jArr = this.content;
        long j10 = jArr[i10];
        if (i10 != i11 - 1) {
            j.m0(jArr, jArr, i10, i10 + 1, i11);
        }
        this._size--;
        return j10;
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
                long[] jArr = this.content;
                j.m0(jArr, jArr, i10, i11, i12);
            }
            this._size -= i11 - i10;
        }
    }

    public final boolean retainAll(long[] jArr) {
        jArr.getClass();
        int i10 = this._size;
        long[] jArr2 = this.content;
        int i11 = i10 - 1;
        while (true) {
            int i12 = 0;
            int i13 = -1;
            if (-1 >= i11) {
                break;
            }
            long j10 = jArr2[i11];
            int length = jArr.length;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (jArr[i12] == j10) {
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

    public final long set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, long j10) {
        if (i10 < 0 || i10 >= this._size) {
            a.f(this._size - 1, a3.a.r(i10, "set index ", " must be between 0 .. "));
            return 0L;
        }
        long[] jArr = this.content;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    public final void sort() {
        long[] jArr = this.content;
        int i10 = this._size;
        jArr.getClass();
        Arrays.sort(jArr, 0, i10);
    }

    public final void sortDescending() {
        long[] jArr = this.content;
        int i10 = this._size;
        jArr.getClass();
        Arrays.sort(jArr, 0, i10);
        b bVar = e.Companion;
        int length = jArr.length;
        bVar.getClass();
        b.d(0, i10, length);
        int i11 = i10 / 2;
        if (i11 == 0) {
            return;
        }
        int i12 = i10 - 1;
        for (int i13 = 0; i13 < i11; i13++) {
            long j10 = jArr[i13];
            jArr[i13] = jArr[i12];
            jArr[i12] = j10;
            i12--;
        }
    }

    public final void trim(int i10) {
        int iMax = Math.max(i10, this._size);
        long[] jArr = this.content;
        if (jArr.length > iMax) {
            this.content = Arrays.copyOf(jArr, iMax);
        }
    }

    public final void plusAssign(long[] jArr) {
        jArr.getClass();
        addAll(this._size, jArr);
    }

    public MutableLongList() {
        this(0, 1, null);
    }

    public final void plusAssign(long j10) {
        add(j10);
    }

    public MutableLongList(int i10) {
        super(i10, null);
    }

    public final void minusAssign(long[] jArr) {
        jArr.getClass();
        for (long j10 : jArr) {
            remove(j10);
        }
    }

    public final void minusAssign(long j10) {
        remove(j10);
    }

    public final boolean removeAll(long[] jArr) {
        jArr.getClass();
        int i10 = this._size;
        for (long j10 : jArr) {
            remove(j10);
        }
        return i10 != this._size;
    }

    public final boolean retainAll(LongList longList) {
        longList.getClass();
        int i10 = this._size;
        long[] jArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!longList.contains(jArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final boolean add(long j10) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i10 = this._size;
        jArr[i10] = j10;
        this._size = i10 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, long[] jArr) {
        int i11;
        jArr.getClass();
        if (i10 >= 0 && i10 <= (i11 = this._size)) {
            if (jArr.length == 0) {
                return false;
            }
            ensureCapacity(i11 + jArr.length);
            long[] jArr2 = this.content;
            int i12 = this._size;
            if (i10 != i12) {
                j.m0(jArr2, jArr2, jArr.length + i10, i10, i12);
            }
            j.m0(jArr, jArr2, i10, 0, jArr.length);
            this._size += jArr.length;
            return true;
        }
        a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(LongList longList) {
        longList.getClass();
        return addAll(this._size, longList);
    }

    public final boolean addAll(long[] jArr) {
        jArr.getClass();
        return addAll(this._size, jArr);
    }
}

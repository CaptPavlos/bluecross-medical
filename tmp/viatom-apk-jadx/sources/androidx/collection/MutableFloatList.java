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
public final class MutableFloatList extends FloatList {
    public /* synthetic */ MutableFloatList(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = mutableFloatList._size;
        }
        mutableFloatList.trim(i10);
    }

    public final void add(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, float f) {
        int i11;
        if (i10 < 0 || i10 > (i11 = this._size)) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i11 + 1);
        float[] fArr = this.content;
        int i12 = this._size;
        if (i10 != i12) {
            j.l0(fArr, i10 + 1, fArr, i10, i12);
        }
        fArr[i10] = f;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, FloatList floatList) {
        floatList.getClass();
        if (i10 < 0 || i10 > this._size) {
            a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
            return false;
        }
        if (floatList.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + floatList._size);
        float[] fArr = this.content;
        int i11 = this._size;
        if (i10 != i11) {
            j.l0(fArr, floatList._size + i10, fArr, i10, i11);
        }
        j.l0(floatList.content, i10, fArr, 0, floatList._size);
        this._size += floatList._size;
        return true;
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i10) {
        float[] fArr = this.content;
        if (fArr.length < i10) {
            this.content = Arrays.copyOf(fArr, Math.max(i10, (fArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(FloatList floatList) {
        floatList.getClass();
        float[] fArr = floatList.content;
        int i10 = floatList._size;
        for (int i11 = 0; i11 < i10; i11++) {
            remove(fArr[i11]);
        }
    }

    public final void plusAssign(FloatList floatList) {
        floatList.getClass();
        addAll(this._size, floatList);
    }

    public final boolean remove(float f) {
        int iIndexOf = indexOf(f);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final boolean removeAll(FloatList floatList) {
        floatList.getClass();
        int i10 = this._size;
        int i11 = floatList._size - 1;
        if (i11 >= 0) {
            int i12 = 0;
            while (true) {
                remove(floatList.get(i12));
                if (i12 == i11) {
                    break;
                }
                i12++;
            }
        }
        return i10 != this._size;
    }

    public final float removeAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this._size)) {
            a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
            return 0.0f;
        }
        float[] fArr = this.content;
        float f = fArr[i10];
        if (i10 != i11 - 1) {
            j.l0(fArr, i10, fArr, i10 + 1, i11);
        }
        this._size--;
        return f;
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
                float[] fArr = this.content;
                j.l0(fArr, i10, fArr, i11, i12);
            }
            this._size -= i11 - i10;
        }
    }

    public final boolean retainAll(float[] fArr) {
        fArr.getClass();
        int i10 = this._size;
        float[] fArr2 = this.content;
        int i11 = i10 - 1;
        while (true) {
            int i12 = 0;
            int i13 = -1;
            if (-1 >= i11) {
                break;
            }
            float f = fArr2[i11];
            int length = fArr.length;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                if (fArr[i12] == f) {
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

    public final float set(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, float f) {
        if (i10 < 0 || i10 >= this._size) {
            a.f(this._size - 1, a3.a.r(i10, "set index ", " must be between 0 .. "));
            return 0.0f;
        }
        float[] fArr = this.content;
        float f10 = fArr[i10];
        fArr[i10] = f;
        return f10;
    }

    public final void sort() {
        float[] fArr = this.content;
        int i10 = this._size;
        fArr.getClass();
        Arrays.sort(fArr, 0, i10);
    }

    public final void sortDescending() {
        float[] fArr = this.content;
        int i10 = this._size;
        fArr.getClass();
        Arrays.sort(fArr, 0, i10);
        b bVar = e.Companion;
        int length = fArr.length;
        bVar.getClass();
        b.d(0, i10, length);
        int i11 = i10 / 2;
        if (i11 == 0) {
            return;
        }
        int i12 = i10 - 1;
        for (int i13 = 0; i13 < i11; i13++) {
            float f = fArr[i13];
            fArr[i13] = fArr[i12];
            fArr[i12] = f;
            i12--;
        }
    }

    public final void trim(int i10) {
        int iMax = Math.max(i10, this._size);
        float[] fArr = this.content;
        if (fArr.length > iMax) {
            this.content = Arrays.copyOf(fArr, iMax);
        }
    }

    public final void plusAssign(float[] fArr) {
        fArr.getClass();
        addAll(this._size, fArr);
    }

    public MutableFloatList() {
        this(0, 1, null);
    }

    public final void plusAssign(float f) {
        add(f);
    }

    public MutableFloatList(int i10) {
        super(i10, null);
    }

    public final void minusAssign(float[] fArr) {
        fArr.getClass();
        for (float f : fArr) {
            remove(f);
        }
    }

    public final void minusAssign(float f) {
        remove(f);
    }

    public final boolean removeAll(float[] fArr) {
        fArr.getClass();
        int i10 = this._size;
        for (float f : fArr) {
            remove(f);
        }
        return i10 != this._size;
    }

    public final boolean retainAll(FloatList floatList) {
        floatList.getClass();
        int i10 = this._size;
        float[] fArr = this.content;
        for (int i11 = i10 - 1; -1 < i11; i11--) {
            if (!floatList.contains(fArr[i11])) {
                removeAt(i11);
            }
        }
        return i10 != this._size;
    }

    public final boolean add(float f) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i10 = this._size;
        fArr[i10] = f;
        this._size = i10 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, float[] fArr) {
        int i11;
        fArr.getClass();
        if (i10 >= 0 && i10 <= (i11 = this._size)) {
            if (fArr.length == 0) {
                return false;
            }
            ensureCapacity(i11 + fArr.length);
            float[] fArr2 = this.content;
            int i12 = this._size;
            if (i10 != i12) {
                j.l0(fArr2, fArr.length + i10, fArr2, i10, i12);
            }
            j.l0(fArr, i10, fArr2, 0, fArr.length);
            this._size += fArr.length;
            return true;
        }
        a.f(this._size, a3.a.r(i10, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(FloatList floatList) {
        floatList.getClass();
        return addAll(this._size, floatList);
    }

    public final boolean addAll(float[] fArr) {
        fArr.getClass();
        return addAll(this._size, fArr);
    }
}

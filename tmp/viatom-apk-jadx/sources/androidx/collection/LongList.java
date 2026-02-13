package androidx.collection;

import a2.a;
import androidx.annotation.IntRange;
import com.google.android.gms.internal.measurement.l5;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import g7.l;
import g7.p;
import g7.q;
import kotlin.jvm.internal.g;
import l7.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class LongList {
    public int _size;
    public long[] content;

    private LongList(int i10) {
        this.content = i10 == 0 ? LongSetKt.getEmptyLongArray() : new long[i10];
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar, int i11, Object obj) {
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
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = longList.content;
        int i12 = longList._size;
        int i13 = 0;
        while (true) {
            if (i13 >= i12) {
                sb.append(charSequence3);
                break;
            }
            long j10 = jArr[i13];
            if (i13 == i10) {
                sb.append(charSequence4);
                break;
            }
            if (i13 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
            i13++;
        }
        return sb.toString();
    }

    public final boolean any(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i11]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(long j10) {
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (jArr[i11] == j10) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(LongList longList) {
        longList.getClass();
        d dVarN = l5.N(0, longList._size);
        int i10 = dVarN.f11084a;
        int i11 = dVarN.f11085b;
        if (i10 > i11) {
            return true;
        }
        while (contains(longList.get(i10))) {
            if (i10 == i11) {
                return true;
            }
            i10++;
        }
        return false;
    }

    public final int count(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i12]))).booleanValue()) {
                i11++;
            }
        }
        return i11;
    }

    public final long elementAt(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        if (i10 >= 0 && i10 < this._size) {
            return this.content[i10];
        }
        com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
        return 0L;
    }

    public final long elementAtOrElse(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10, l lVar) {
        lVar.getClass();
        return (i10 < 0 || i10 >= this._size) ? ((Number) lVar.invoke(Integer.valueOf(i10))).longValue() : this.content[i10];
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongList) {
            LongList longList = (LongList) obj;
            int i10 = longList._size;
            int i11 = this._size;
            if (i10 == i11) {
                long[] jArr = this.content;
                long[] jArr2 = longList.content;
                d dVarN = l5.N(0, i11);
                int i12 = dVarN.f11084a;
                int i13 = dVarN.f11085b;
                if (i12 > i13) {
                    return true;
                }
                while (jArr[i12] == jArr2[i12]) {
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

    public final long first(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            long j10 = jArr[i11];
            if (((Boolean) lVar.invoke(Long.valueOf(j10))).booleanValue()) {
                return j10;
            }
        }
        com.google.gson.internal.a.o("LongList contains no element matching the predicate.");
        return 0L;
    }

    public final <R> R fold(R r6, p pVar) {
        pVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            r6 = (R) pVar.invoke(r6, Long.valueOf(jArr[i11]));
        }
        return r6;
    }

    public final <R> R foldIndexed(R r6, q qVar) {
        qVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            R r9 = r6;
            r6 = (R) qVar.invoke(Integer.valueOf(i11), r9, Long.valueOf(jArr[i11]));
        }
        return r6;
    }

    public final <R> R foldRight(R r6, p pVar) {
        pVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return r6;
            }
            r6 = (R) pVar.invoke(Long.valueOf(jArr[i10]), r6);
        }
    }

    public final <R> R foldRightIndexed(R r6, q qVar) {
        qVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return r6;
            }
            r6 = (R) qVar.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]), r6);
        }
    }

    public final void forEach(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            lVar.invoke(Long.valueOf(jArr[i11]));
        }
    }

    public final void forEachIndexed(p pVar) {
        pVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            pVar.invoke(Integer.valueOf(i11), Long.valueOf(jArr[i11]));
        }
    }

    public final void forEachReversed(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                lVar.invoke(Long.valueOf(jArr[i10]));
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        pVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        while (true) {
            i10--;
            if (-1 >= i10) {
                return;
            } else {
                pVar.invoke(Integer.valueOf(i10), Long.valueOf(jArr[i10]));
            }
        }
    }

    public final long get(@IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY) int i10) {
        if (i10 >= 0 && i10 < this._size) {
            return this.content[i10];
        }
        com.google.gson.internal.a.f(this._size - 1, a3.a.r(i10, "Index ", " must be in 0.."));
        return 0L;
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
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = jArr[i12];
            i11 += ((int) (j10 ^ (j10 >>> 32))) * 31;
        }
        return i11;
    }

    public final int indexOf(long j10) {
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (j10 == jArr[i11]) {
                return i11;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i11]))).booleanValue()) {
                return i11;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return -1;
            }
        } while (!((Boolean) lVar.invoke(Long.valueOf(jArr[i10]))).booleanValue());
        return i10;
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        charSequence4.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i11 = this._size;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                sb.append(charSequence3);
                break;
            }
            long j10 = jArr[i12];
            if (i12 == i10) {
                sb.append(charSequence4);
                break;
            }
            if (i12 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
            i12++;
        }
        return sb.toString();
    }

    public final long last(l lVar) {
        long j10;
        lVar.getClass();
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                com.google.gson.internal.a.o("LongList contains no element matching the predicate.");
                return 0L;
            }
            j10 = jArr[i10];
        } while (!((Boolean) lVar.invoke(Long.valueOf(j10))).booleanValue());
        return j10;
    }

    public final int lastIndexOf(long j10) {
        long[] jArr = this.content;
        int i10 = this._size;
        do {
            i10--;
            if (-1 >= i10) {
                return -1;
            }
        } while (jArr[i10] != j10);
        return i10;
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        lVar.getClass();
        long[] jArr = this.content;
        for (int i10 = this._size - 1; -1 < i10; i10--) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i10]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, null, "[", "]", 0, null, 25, null);
    }

    public /* synthetic */ LongList(int i10, g gVar) {
        this(i10);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final int count() {
        return this._size;
    }

    public final long first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        com.google.gson.internal.a.o("LongList is empty.");
        return 0L;
    }

    public final long last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        com.google.gson.internal.a.o("LongList is empty.");
        return 0L;
    }

    public final String joinToString(CharSequence charSequence) {
        charSequence.getClass();
        return joinToString$default(this, charSequence, null, null, 0, null, 30, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        charSequence.getClass();
        charSequence2.getClass();
        return joinToString$default(this, charSequence, charSequence2, null, 0, null, 28, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        a3.a.B(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, null, 24, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10) {
        a3.a.B(charSequence, charSequence2, charSequence3);
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i10, null, 16, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4) {
        StringBuilder sbU = a3.a.u(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        long[] jArr = this.content;
        int i11 = this._size;
        int i12 = 0;
        while (true) {
            if (i12 < i11) {
                long j10 = jArr[i12];
                if (i12 == i10) {
                    sbU.append(charSequence4);
                    break;
                }
                if (i12 != 0) {
                    sbU.append(charSequence);
                }
                sbU.append(j10);
                i12++;
            } else {
                sbU.append(charSequence3);
                break;
            }
        }
        return sbU.toString();
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i11 = this._size;
        int i12 = 0;
        while (true) {
            if (i12 < i11) {
                long j10 = jArr[i12];
                if (i12 == i10) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i12 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
                i12++;
            } else {
                sb.append(charSequence3);
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        charSequence3.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        while (true) {
            if (i11 < i10) {
                long j10 = jArr[i11];
                if (i11 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i11 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
                i11++;
            } else {
                sb.append(charSequence3);
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, l lVar) {
        charSequence.getClass();
        charSequence2.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        while (true) {
            if (i11 < i10) {
                long j10 = jArr[i11];
                if (i11 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i11 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
                i11++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
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
        CharSequence charSequence5 = charSequence4;
        CharSequence charSequence6 = charSequence3;
        return longList.joinToString(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    public final String joinToString(CharSequence charSequence, l lVar) {
        charSequence.getClass();
        lVar.getClass();
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        while (true) {
            if (i11 < i10) {
                long j10 = jArr[i11];
                if (i11 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i11 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
                i11++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }

    public final String joinToString(l lVar) {
        lVar.getClass();
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.content;
        int i10 = this._size;
        int i11 = 0;
        while (true) {
            if (i11 < i10) {
                long j10 = jArr[i11];
                if (i11 == -1) {
                    sb.append((CharSequence) "...");
                    break;
                }
                if (i11 != 0) {
                    sb.append((CharSequence) ", ");
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j10)));
                i11++;
            } else {
                sb.append((CharSequence) "");
                break;
            }
        }
        return sb.toString();
    }
}

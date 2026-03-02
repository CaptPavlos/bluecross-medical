package androidx.collection;

import a2.a;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import t6.j;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap(int i10) {
        this.hashes = i10 == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i10];
        this.array = i10 == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i10 << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (T) this.array[(iIndexOfKey << 1) + 1] : t;
    }

    private final int indexOf(K k10, int i10) {
        int i11 = this.size;
        if (i11 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i11, i10);
        if (iBinarySearch < 0 || l.a(k10, this.array[iBinarySearch << 1])) {
            return iBinarySearch;
        }
        int i12 = iBinarySearch + 1;
        while (i12 < i11 && this.hashes[i12] == i10) {
            if (l.a(k10, this.array[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iBinarySearch - 1; i13 >= 0 && this.hashes[i13] == i10; i13--) {
            if (l.a(k10, this.array[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    private final int indexOfNull() {
        int i10 = this.size;
        if (i10 == 0) {
            return -1;
        }
        int iBinarySearch = ContainerHelpersKt.binarySearch(this.hashes, i10, 0);
        if (iBinarySearch < 0 || this.array[iBinarySearch << 1] == null) {
            return iBinarySearch;
        }
        int i11 = iBinarySearch + 1;
        while (i11 < i10 && this.hashes[i11] == 0) {
            if (this.array[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iBinarySearch - 1; i12 >= 0 && this.hashes[i12] == 0; i12--) {
            if (this.array[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public final int __restricted$indexOfValue(V v6) {
        int i10 = this.size * 2;
        Object[] objArr = this.array;
        if (v6 == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (v6.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size <= 0) {
            return;
        }
        a.e();
    }

    public boolean containsKey(K k10) {
        return indexOfKey(k10) >= 0;
    }

    public boolean containsValue(V v6) {
        return __restricted$indexOfValue(v6) >= 0;
    }

    public void ensureCapacity(int i10) {
        int i11 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i10) {
            this.hashes = Arrays.copyOf(iArr, i10);
            this.array = Arrays.copyOf(this.array, i10 * 2);
        }
        if (this.size == i11) {
            return;
        }
        a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i10 = this.size;
                for (int i11 = 0; i11 < i10; i11++) {
                    K kKeyAt = keyAt(i11);
                    V vValueAt = valueAt(i11);
                    Object obj2 = simpleArrayMap.get(kKeyAt);
                    if (vValueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(kKeyAt)) {
                            return false;
                        }
                    } else if (!vValueAt.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i12 = this.size;
            for (int i13 = 0; i13 < i12; i13++) {
                K kKeyAt2 = keyAt(i13);
                V vValueAt2 = valueAt(i13);
                Object obj3 = ((Map) obj).get(kKeyAt2);
                if (vValueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kKeyAt2)) {
                        return false;
                    }
                } else if (!vValueAt2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return (V) this.array[(iIndexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v6) {
        int iIndexOfKey = indexOfKey(obj);
        return iIndexOfKey >= 0 ? (V) this.array[(iIndexOfKey << 1) + 1] : v6;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i10 = this.size;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public int indexOfKey(K k10) {
        return k10 == null ? indexOfNull() : indexOf(k10, k10.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i10) {
        if (i10 >= 0 && i10 < this.size) {
            return (K) this.array[i10 << 1];
        }
        f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public V put(K k10, V v6) {
        int i10 = this.size;
        int iHashCode = k10 != null ? k10.hashCode() : 0;
        int iIndexOf = k10 != null ? indexOf(k10, iHashCode) : indexOfNull();
        if (iIndexOf >= 0) {
            int i11 = (iIndexOf << 1) + 1;
            Object[] objArr = this.array;
            V v9 = (V) objArr[i11];
            objArr[i11] = v6;
            return v9;
        }
        int i12 = ~iIndexOf;
        int[] iArr = this.hashes;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            this.hashes = Arrays.copyOf(iArr, i13);
            this.array = Arrays.copyOf(this.array, i13 << 1);
            if (i10 != this.size) {
                a.e();
                return null;
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.hashes;
            int i14 = i12 + 1;
            j.j0(i14, i12, iArr2, iArr2, i10);
            Object[] objArr2 = this.array;
            j.i0(i14 << 1, i12 << 1, this.size << 1, objArr2, objArr2);
        }
        int i15 = this.size;
        if (i10 == i15) {
            int[] iArr3 = this.hashes;
            if (i12 < iArr3.length) {
                iArr3[i12] = iHashCode;
                Object[] objArr3 = this.array;
                int i16 = i12 << 1;
                objArr3[i16] = k10;
                objArr3[i16 + 1] = v6;
                this.size = i15 + 1;
                return null;
            }
        }
        a.e();
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        simpleArrayMap.getClass();
        int i10 = simpleArrayMap.size;
        ensureCapacity(this.size + i10);
        if (this.size != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(simpleArrayMap.keyAt(i11), simpleArrayMap.valueAt(i11));
            }
        } else if (i10 > 0) {
            j.j0(0, 0, simpleArrayMap.hashes, this.hashes, i10);
            j.i0(0, 0, i10 << 1, simpleArrayMap.array, this.array);
            this.size = i10;
        }
    }

    public V putIfAbsent(K k10, V v6) {
        V v9 = get(k10);
        return v9 == null ? put(k10, v6) : v9;
    }

    public boolean remove(K k10, V v6) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey < 0 || !l.a(v6, valueAt(iIndexOfKey))) {
            return false;
        }
        removeAt(iIndexOfKey);
        return true;
    }

    public V removeAt(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.size)) {
            f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        Object[] objArr = this.array;
        int i12 = i10 << 1;
        V v6 = (V) objArr[i12 + 1];
        if (i11 <= 1) {
            clear();
            return v6;
        }
        int i13 = i11 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                j.j0(i10, i14, iArr, iArr, i11);
                Object[] objArr2 = this.array;
                j.i0(i12, i14 << 1, i11 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.array;
            int i15 = i13 << 1;
            objArr3[i15] = null;
            objArr3[i15 + 1] = null;
        } else {
            int i16 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            this.hashes = Arrays.copyOf(iArr, i16);
            this.array = Arrays.copyOf(this.array, i16 << 1);
            if (i11 != this.size) {
                a.e();
                return null;
            }
            if (i10 > 0) {
                j.j0(0, 0, iArr, this.hashes, i10);
                j.i0(0, 0, i12, objArr, this.array);
            }
            if (i10 < i13) {
                int i17 = i10 + 1;
                j.j0(i10, i17, iArr, this.hashes, i11);
                j.i0(i12, i17 << 1, i11 << 1, objArr, this.array);
            }
        }
        if (i11 == this.size) {
            this.size = i13;
            return v6;
        }
        a.e();
        return null;
    }

    public boolean replace(K k10, V v6, V v9) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey < 0 || !l.a(v6, valueAt(iIndexOfKey))) {
            return false;
        }
        setValueAt(iIndexOfKey, v9);
        return true;
    }

    public V setValueAt(int i10, V v6) {
        if (i10 < 0 || i10 >= this.size) {
            f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.array;
        V v9 = (V) objArr[i11];
        objArr[i11] = v6;
        return v9;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i10 = this.size;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb.append(", ");
            }
            K kKeyAt = keyAt(i11);
            if (kKeyAt != sb) {
                sb.append(kKeyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vValueAt = valueAt(i11);
            if (vValueAt != sb) {
                sb.append(vValueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i10) {
        if (i10 >= 0 && i10 < this.size) {
            return (V) this.array[(i10 << 1) + 1];
        }
        f.b(a3.a.f(i10, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public V remove(K k10) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return removeAt(iIndexOfKey);
        }
        return null;
    }

    public V replace(K k10, V v6) {
        int iIndexOfKey = indexOfKey(k10);
        if (iIndexOfKey >= 0) {
            return setValueAt(iIndexOfKey, v6);
        }
        return null;
    }

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public /* synthetic */ SimpleArrayMap(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}

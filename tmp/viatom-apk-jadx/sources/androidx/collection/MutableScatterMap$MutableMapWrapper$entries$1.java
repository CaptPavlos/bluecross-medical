package androidx.collection;

import h7.a;
import h7.b;
import h7.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.l;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableScatterMap$MutableMapWrapper$entries$1<K, V> implements Set<Map.Entry<K, V>>, b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Map.Entry<K, V> entry) {
        entry.getClass();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        collection.getClass();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    public boolean contains(Map.Entry<K, V> entry) {
        entry.getClass();
        return l.a(this.this$0.get(entry.getKey()), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        collection.getClass();
        Collection<? extends Object> collection2 = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!l.a(mutableScatterMap.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(this.this$0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0070, code lost:
    
        r18 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0079, code lost:
    
        if (((r8 & ((~r8) << 6)) & (-9187201950435737472L)) == 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007b, code lost:
    
        r12 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.util.Map.Entry<K, V> r20) {
        /*
            r19 = this;
            r0 = r19
            r20.getClass()
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object r2 = r20.getKey()
            if (r2 == 0) goto L12
            int r4 = r2.hashCode()
            goto L13
        L12:
            r4 = 0
        L13:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r5 = r4 & 127(0x7f, float:1.78E-43)
            int r6 = r1._capacity
            int r4 = r4 >>> 7
            r4 = r4 & r6
            r7 = 0
        L22:
            long[] r8 = r1.metadata
            int r9 = r4 >> 3
            r10 = r4 & 7
            int r10 = r10 << 3
            r11 = r8[r9]
            long r11 = r11 >>> r10
            r13 = 1
            int r9 = r9 + r13
            r14 = r8[r9]
            int r8 = 64 - r10
            long r8 = r14 << r8
            long r14 = (long) r10
            long r14 = -r14
            r10 = 63
            long r14 = r14 >> r10
            long r8 = r8 & r14
            long r8 = r8 | r11
            long r10 = (long) r5
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L4e:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L70
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r4
            r12 = r12 & r6
            r18 = 0
            java.lang.Object[] r3 = r1.keys
            r3 = r3[r12]
            boolean r3 = kotlin.jvm.internal.l.a(r3, r2)
            if (r3 == 0) goto L69
            goto L7c
        L69:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L4e
        L70:
            r18 = 0
            long r10 = ~r8
            r3 = 6
            long r10 = r10 << r3
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 == 0) goto L95
            r12 = -1
        L7c:
            if (r12 < 0) goto L94
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            java.lang.Object[] r1 = r1.values
            r1 = r1[r12]
            java.lang.Object r2 = r20.getValue()
            boolean r1 = kotlin.jvm.internal.l.a(r1, r2)
            if (r1 == 0) goto L94
            androidx.collection.MutableScatterMap<K, V> r1 = r0.this$0
            r1.removeValueAt(r12)
            return r13
        L94:
            return r18
        L95:
            int r7 = r7 + 8
            int r4 = r4 + r7
            r4 = r4 & r6
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1.remove(java.util.Map$Entry):boolean");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        collection.getClass();
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i10 = 0;
        boolean z9 = false;
        while (true) {
            long j10 = jArr[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        Iterator<? extends Object> it = collection.iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            if (l.a(entry.getKey(), mutableScatterMap.keys[i13]) && l.a(entry.getValue(), mutableScatterMap.values[i13])) {
                                mutableScatterMap.removeValueAt(i13);
                                z9 = true;
                                break;
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return z9;
                }
            }
            if (i10 == length) {
                return z9;
            }
            i10++;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        collection.getClass();
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i10 = 0;
        boolean z9 = false;
        while (true) {
            long j10 = jArr[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        Iterator<? extends Object> it = collection.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                mutableScatterMap.removeValueAt(i13);
                                z9 = true;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (!l.a(entry.getKey(), mutableScatterMap.keys[i13]) || !l.a(entry.getValue(), mutableScatterMap.values[i13])) {
                            }
                        }
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return z9;
                }
            }
            if (i10 == length) {
                return z9;
            }
            i10++;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        return (T[]) l.k(this, tArr);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return l.j(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (!(obj instanceof a) || (obj instanceof c)) {
            return contains((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        if (!(obj instanceof a) || (obj instanceof c)) {
            return remove((Map.Entry) obj);
        }
        return false;
    }
}

package androidx.collection;

import androidx.annotation.IntRange;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import t6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableIntSet extends IntSet {
    private int growthLimit;

    public MutableIntSet(int i10) {
        super(null);
        if (i10 >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i10));
        } else {
            a.n("Capacity must be a positive value.");
            throw null;
        }
    }

    private final void adjustStorage() {
        int i10 = this._capacity;
        if (i10 <= 8 || Long.compare((this._size * 32) ^ Long.MIN_VALUE, (i10 * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findAbsoluteInsertIndex(int i10) {
        int i11 = ScatterMapKt.MurmurHashC1 * i10;
        int i12 = i11 ^ (i11 << 16);
        int i13 = i12 >>> 7;
        int i14 = i12 & 127;
        int i15 = this._capacity;
        int i16 = i13 & i15;
        int i17 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i18 = i16 >> 3;
            int i19 = (i16 & 7) << 3;
            long j10 = ((jArr[i18 + 1] << (64 - i19)) & ((-i19) >> 63)) | (jArr[i18] >>> i19);
            long j11 = i14;
            int i20 = i17;
            long j12 = j10 ^ (j11 * ScatterMapKt.BitmaskLsb);
            for (long j13 = (~j12) & (j12 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int iNumberOfTrailingZeros = (i16 + (Long.numberOfTrailingZeros(j13) >> 3)) & i15;
                if (this.elements[iNumberOfTrailingZeros] == i10) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j10) << 6) & j10 & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i13);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i13);
                }
                this._size++;
                int i21 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i22 = iFindFirstAvailableSlot >> 3;
                long j14 = jArr2[i22];
                int i23 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i21 - (((j14 >> i23) & 255) == 128 ? 1 : 0);
                jArr2[i22] = (j14 & (~(255 << i23))) | (j11 << i23);
                int i24 = this._capacity;
                int i25 = ((iFindFirstAvailableSlot - 7) & i24) + (i24 & 7);
                int i26 = i25 >> 3;
                int i27 = (i25 & 7) << 3;
                jArr2[i26] = ((~(255 << i27)) & jArr2[i26]) | (j11 << i27);
                return iFindFirstAvailableSlot;
            }
            i17 = i20 + 8;
            i16 = (i16 + i17) & i15;
        }
    }

    private final int findFirstAvailableSlot(int i10) {
        int i11 = this._capacity;
        int i12 = i10 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j10 = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j11 = j10 & ((~j10) << 7) & (-9187201950435737472L);
            if (j11 != 0) {
                return (i12 + (Long.numberOfTrailingZeros(j11) >> 3)) & i11;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i10) {
        long[] jArr;
        if (i10 == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((i10 + 15) & (-8)) >> 3];
            j.r0(jArr);
        }
        this.metadata = jArr;
        int i11 = i10 >> 3;
        long j10 = 255 << ((i10 & 7) << 3);
        jArr[i11] = (jArr[i11] & (~j10)) | j10;
        initializeGrowth();
    }

    private final void initializeStorage(int i10) {
        int iMax = i10 > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i10)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.elements = new int[iMax];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i10 = this._capacity;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 >> 3;
            int i14 = (i12 & 7) << 3;
            if (((jArr[i13] >> i14) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i13] = (128 << i14) | (jArr2[i13] & (~(255 << i14)));
                int i15 = this._capacity;
                int i16 = ((i12 - 7) & i15) + (i15 & 7);
                int i17 = i16 >> 3;
                int i18 = (i16 & 7) << 3;
                jArr2[i17] = ((~(255 << i18)) & jArr2[i17]) | (128 << i18);
                i11++;
            }
        }
        this.growthLimit += i11;
    }

    private final void removeElementAt(int i10) {
        this._size--;
        long[] jArr = this.metadata;
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        jArr[i11] = (jArr[i11] & (~(255 << i12))) | (254 << i12);
        int i13 = this._capacity;
        int i14 = ((i10 - 7) & i13) + (i13 & 7);
        int i15 = i14 >> 3;
        int i16 = (i14 & 7) << 3;
        jArr[i15] = (jArr[i15] & (~(255 << i16))) | (254 << i16);
    }

    private final void resizeStorage(int i10) {
        long[] jArr;
        MutableIntSet mutableIntSet = this;
        long[] jArr2 = mutableIntSet.metadata;
        int[] iArr = mutableIntSet.elements;
        int i11 = mutableIntSet._capacity;
        initializeStorage(i10);
        int[] iArr2 = mutableIntSet.elements;
        int i12 = 0;
        while (i12 < i11) {
            if (((jArr2[i12 >> 3] >> ((i12 & 7) << 3)) & 255) < 128) {
                int i13 = iArr[i12];
                int i14 = ScatterMapKt.MurmurHashC1 * i13;
                int i15 = i14 ^ (i14 << 16);
                int iFindFirstAvailableSlot = mutableIntSet.findFirstAvailableSlot(i15 >>> 7);
                long j10 = i15 & 127;
                long[] jArr3 = mutableIntSet.metadata;
                int i16 = iFindFirstAvailableSlot >> 3;
                int i17 = (iFindFirstAvailableSlot & 7) << 3;
                jArr3[i16] = ((~(255 << i17)) & jArr3[i16]) | (j10 << i17);
                int i18 = mutableIntSet._capacity;
                int i19 = ((iFindFirstAvailableSlot - 7) & i18) + (i18 & 7);
                int i20 = i19 >> 3;
                int i21 = (i19 & 7) << 3;
                jArr = jArr2;
                jArr3[i20] = ((~(255 << i21)) & jArr3[i20]) | (j10 << i21);
                iArr2[iFindFirstAvailableSlot] = i13;
            } else {
                jArr = jArr2;
            }
            i12++;
            mutableIntSet = this;
            jArr2 = jArr;
        }
    }

    private final void writeMetadata(int i10, long j10) {
        long[] jArr = this.metadata;
        int i11 = i10 >> 3;
        int i12 = (i10 & 7) << 3;
        jArr[i11] = (jArr[i11] & (~(255 << i12))) | (j10 << i12);
        int i13 = this._capacity;
        int i14 = ((i10 - 7) & i13) + (i13 & 7);
        int i15 = i14 >> 3;
        int i16 = (i14 & 7) << 3;
        jArr[i15] = (j10 << i16) | (jArr[i15] & (~(255 << i16)));
    }

    public final boolean add(int i10) {
        int i11 = this._size;
        this.elements[findAbsoluteInsertIndex(i10)] = i10;
        return this._size != i11;
    }

    public final boolean addAll(int[] iArr) {
        iArr.getClass();
        int i10 = this._size;
        plusAssign(iArr);
        return i10 != this._size;
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            j.r0(jArr);
            long[] jArr2 = this.metadata;
            int i10 = this._capacity;
            int i11 = i10 >> 3;
            long j10 = 255 << ((i10 & 7) << 3);
            jArr2[i11] = (jArr2[i11] & (~j10)) | j10;
        }
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005f, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void minusAssign(int r14) {
        /*
            r13 = this;
            r0 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r0 = r0 * r14
            int r1 = r0 << 16
            r0 = r0 ^ r1
            r1 = r0 & 127(0x7f, float:1.78E-43)
            int r2 = r13._capacity
            int r0 = r0 >>> 7
            r0 = r0 & r2
            r3 = 0
        Lf:
            long[] r4 = r13.metadata
            int r5 = r0 >> 3
            r6 = r0 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r1
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L3b:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L56
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r0
            r10 = r10 & r2
            int[] r11 = r13.elements
            r11 = r11[r10]
            if (r11 != r14) goto L50
            goto L60
        L50:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L3b
        L56:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L66
            r10 = -1
        L60:
            if (r10 < 0) goto L65
            r13.removeElementAt(r10)
        L65:
            return
        L66:
            int r3 = r3 + 8
            int r0 = r0 + r3
            r0 = r0 & r2
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.minusAssign(int):void");
    }

    public final void plusAssign(IntSet intSet) {
        intSet.getClass();
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
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
                        plusAssign(iArr[(i10 << 3) + i12]);
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0064, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r2 = r2 * r1
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L14:
            long[] r7 = r0.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L40:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L5b
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            int[] r15 = r0.elements
            r15 = r15[r11]
            if (r15 != r1) goto L55
            goto L65
        L55:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L40
        L5b:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L6e
            r11 = -1
        L65:
            if (r11 < 0) goto L68
            r5 = r12
        L68:
            if (r5 == 0) goto L6d
            r0.removeElementAt(r11)
        L6d:
            return r5
        L6e:
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.remove(int):boolean");
    }

    public final boolean removeAll(int[] iArr) {
        iArr.getClass();
        int i10 = this._size;
        minusAssign(iArr);
        return i10 != this._size;
    }

    @IntRange(from = FabTransformationScrimBehavior.COLLAPSE_DELAY)
    public final int trim() {
        int i10 = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i10) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i10 - this._capacity;
    }

    public final boolean addAll(IntSet intSet) {
        intSet.getClass();
        int i10 = this._size;
        plusAssign(intSet);
        return i10 != this._size;
    }

    public final boolean removeAll(IntSet intSet) {
        intSet.getClass();
        int i10 = this._size;
        minusAssign(intSet);
        return i10 != this._size;
    }

    public /* synthetic */ MutableIntSet(int i10, int i11, g gVar) {
        this((i11 & 1) != 0 ? 6 : i10);
    }

    public MutableIntSet() {
        this(0, 1, null);
    }

    public final void plusAssign(int[] iArr) {
        iArr.getClass();
        for (int i10 : iArr) {
            plusAssign(i10);
        }
    }

    public final void plusAssign(int i10) {
        this.elements[findAbsoluteInsertIndex(i10)] = i10;
    }

    public final void minusAssign(int[] iArr) {
        iArr.getClass();
        for (int i10 : iArr) {
            minusAssign(i10);
        }
    }

    public final void minusAssign(IntSet intSet) {
        intSet.getClass();
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
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
                        minusAssign(iArr[(i10 << 3) + i12]);
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
}

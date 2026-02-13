package androidx.collection;

import a2.a;
import g7.l;
import g7.p;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class LongLongMap {
    public int _capacity;
    public int _size;
    public long[] keys;
    public long[] metadata;
    public long[] values;

    private LongLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = LongSetKt.getEmptyLongArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, p pVar, int i11, Object obj) {
        long[] jArr;
        long[] jArr2;
        int i12;
        if (obj != null) {
            a.m("Super calls with default arguments not supported in this target, function: joinToString");
            return null;
        }
        CharSequence charSequence5 = (i11 & 1) != 0 ? ", " : charSequence;
        CharSequence charSequence6 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence7 = (i11 & 4) == 0 ? charSequence3 : "";
        int i13 = (i11 & 8) != 0 ? -1 : i10;
        CharSequence charSequence8 = (i11 & 16) != 0 ? "..." : charSequence4;
        StringBuilder sbT = a3.a.t(charSequence5, charSequence6, charSequence7, charSequence8, pVar);
        sbT.append(charSequence6);
        long[] jArr3 = longLongMap.keys;
        long[] jArr4 = longLongMap.values;
        long[] jArr5 = longLongMap.metadata;
        int length = jArr5.length - 2;
        if (length >= 0) {
            int i14 = 0;
            int i15 = 0;
            loop0: while (true) {
                long j10 = jArr5[i14];
                int i16 = i14;
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8;
                    int i18 = 8 - ((~(i16 - length)) >>> 31);
                    int i19 = 0;
                    while (i19 < i18) {
                        if ((j10 & 255) < 128) {
                            int i20 = (i16 << 3) + i19;
                            long j11 = jArr3[i20];
                            long j12 = jArr4[i20];
                            if (i15 == i13) {
                                sbT.append(charSequence8);
                                break loop0;
                            }
                            if (i15 != 0) {
                                sbT.append(charSequence5);
                            }
                            i12 = i17;
                            jArr2 = jArr5;
                            sbT.append((CharSequence) pVar.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                            i15++;
                        } else {
                            jArr2 = jArr5;
                            i12 = i17;
                        }
                        j10 >>= i12;
                        i19++;
                        i17 = i12;
                        jArr5 = jArr2;
                    }
                    jArr = jArr5;
                    if (i18 != i17) {
                        break;
                    }
                } else {
                    jArr = jArr5;
                }
                if (i16 == length) {
                    break;
                }
                i14 = i16 + 1;
                jArr5 = jArr;
            }
            sbT.append(charSequence7);
        } else {
            sbT.append(charSequence7);
        }
        return sbT.toString();
    }

    public final boolean all(p pVar) {
        pVar.getClass();
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return true;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        if (!((Boolean) pVar.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13]))).booleanValue()) {
                            return false;
                        }
                    }
                    j10 >>= 8;
                }
                if (i11 != 8) {
                    return true;
                }
            }
            if (i10 == length) {
                return true;
            }
            i10++;
        }
    }

    public final boolean any(p pVar) {
        pVar.getClass();
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j10 = jArr3[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j10) < 128) {
                            int i13 = (i10 << 3) + i12;
                            if (((Boolean) pVar.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13]))).booleanValue()) {
                                return true;
                            }
                        }
                        j10 >>= 8;
                    }
                    if (i11 != 8) {
                        break;
                    }
                }
                if (i10 == length) {
                    break;
                }
                i10++;
            }
        }
        return false;
    }

    public final boolean contains(long j10) {
        return findKeyIndex(j10) >= 0;
    }

    public final boolean containsKey(long j10) {
        return findKeyIndex(j10) >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean containsValue(long r15) {
        /*
            r14 = this;
            long[] r0 = r14.values
            long[] r1 = r14.metadata
            int r2 = r1.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L46
            r4 = r3
        Lb:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L41
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L25:
            if (r9 >= r7) goto L3f
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3b
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r0[r10]
            int r10 = (r15 > r10 ? 1 : (r15 == r10 ? 0 : -1))
            if (r10 != 0) goto L3b
            r0 = 1
            return r0
        L3b:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L25
        L3f:
            if (r7 != r8) goto L46
        L41:
            if (r4 == r2) goto L46
            int r4 = r4 + 1
            goto Lb
        L46:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongLongMap.containsValue(long):boolean");
    }

    public final int count(p pVar) {
        pVar.getClass();
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j10) < 128) {
                        int i14 = (i10 << 3) + i13;
                        if (((Boolean) pVar.invoke(Long.valueOf(jArr[i14]), Long.valueOf(jArr2[i14]))).booleanValue()) {
                            i11++;
                        }
                    }
                    j10 >>= 8;
                }
                if (i12 != 8) {
                    return i11;
                }
            }
            if (i10 == length) {
                return i11;
            }
            i10++;
        }
    }

    public boolean equals(Object obj) {
        boolean z9;
        long[] jArr;
        boolean z10;
        long[] jArr2;
        boolean z11 = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LongLongMap)) {
            return false;
        }
        LongLongMap longLongMap = (LongLongMap) obj;
        if (longLongMap.getSize() != getSize()) {
            return false;
        }
        long[] jArr3 = this.keys;
        long[] jArr4 = this.values;
        long[] jArr5 = this.metadata;
        int length = jArr5.length - 2;
        if (length < 0) {
            return true;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr5[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                int i12 = 0;
                while (i12 < i11) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        z10 = z11;
                        jArr2 = jArr3;
                        if (jArr4[i13] != longLongMap.get(jArr2[i13])) {
                            return false;
                        }
                    } else {
                        z10 = z11;
                        jArr2 = jArr3;
                    }
                    j10 >>= 8;
                    i12++;
                    z11 = z10;
                    jArr3 = jArr2;
                }
                z9 = z11;
                jArr = jArr3;
                if (i11 != 8) {
                    return z9;
                }
            } else {
                z9 = z11;
                jArr = jArr3;
            }
            if (i10 == length) {
                return z9;
            }
            i10++;
            z11 = z9;
            jArr3 = jArr;
        }
    }

    public final int findKeyIndex(long j10) {
        int i10 = ((int) ((j10 >>> 32) ^ j10)) * ScatterMapKt.MurmurHashC1;
        int i11 = i10 ^ (i10 << 16);
        int i12 = i11 & 127;
        int i13 = this._capacity;
        int i14 = (i11 >>> 7) & i13;
        int i15 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j11 = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j12 = (i12 * ScatterMapKt.BitmaskLsb) ^ j11;
            for (long j13 = (~j12) & (j12 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j13 != 0; j13 &= j13 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j13) >> 3) + i14) & i13;
                if (this.keys[iNumberOfTrailingZeros] == j10) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j11 & ((~j11) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i15 += 8;
            i14 = (i14 + i15) & i13;
        }
    }

    public final void forEach(p pVar) {
        pVar.getClass();
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr3[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        pVar.invoke(Long.valueOf(jArr[i13]), Long.valueOf(jArr2[i13]));
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

    public final void forEachIndexed(l lVar) {
        lVar.getClass();
        long[] jArr = this.metadata;
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
                        a3.a.z(i10 << 3, i12, lVar);
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

    public final void forEachKey(l lVar) {
        lVar.getClass();
        long[] jArr = this.keys;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        lVar.invoke(Long.valueOf(jArr[(i10 << 3) + i12]));
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

    public final void forEachValue(l lVar) {
        lVar.getClass();
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        lVar.invoke(Long.valueOf(jArr[(i10 << 3) + i12]));
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

    public final long get(long j10) {
        int iFindKeyIndex = findKeyIndex(j10);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        com.google.gson.internal.a.o(a3.a.h(j10, "Cannot find value for key "));
        return 0L;
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(long j10, long j11) {
        int iFindKeyIndex = findKeyIndex(j10);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : j11;
    }

    public final long getOrElse(long j10, g7.a aVar) {
        aVar.getClass();
        int iFindKeyIndex = findKeyIndex(j10);
        return iFindKeyIndex < 0 ? ((Number) aVar.invoke()).longValue() : this.values[iFindKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i10;
        int i11;
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            long j10 = jArr3[i12];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i12 - length)) >>> 31);
                int i15 = 0;
                while (i15 < i14) {
                    if ((255 & j10) < 128) {
                        int i16 = (i12 << 3) + i15;
                        long j11 = jArr[i16];
                        long j12 = jArr2[i16];
                        i11 = i12;
                        i13 += ((int) (j12 ^ (j12 >>> 32))) ^ ((int) (j11 ^ (j11 >>> 32)));
                    } else {
                        i11 = i12;
                    }
                    j10 >>= 8;
                    i15++;
                    i12 = i11;
                }
                i10 = i12;
                if (i14 != 8) {
                    return i13;
                }
            } else {
                i10 = i12;
            }
            if (i10 == length) {
                return i13;
            }
            i12 = i10 + 1;
        }
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        long j10;
        int i11;
        StringBuilder sbU = a3.a.u(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        long[] jArr5 = this.keys;
        long[] jArr6 = this.values;
        long[] jArr7 = this.metadata;
        int length = jArr7.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j11 = jArr7[i12];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8;
                    int i15 = 8 - ((~(i12 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j11 & 255) < 128) {
                            int i17 = (i12 << 3) + i16;
                            jArr3 = jArr6;
                            jArr4 = jArr7;
                            long j12 = jArr5[i17];
                            j10 = j11;
                            long j13 = jArr3[i17];
                            i11 = i14;
                            if (i13 == i10) {
                                sbU.append(charSequence4);
                                break loop0;
                            }
                            if (i13 != 0) {
                                sbU.append(charSequence);
                            }
                            sbU.append(j12);
                            sbU.append('=');
                            sbU.append(j13);
                            i13++;
                        } else {
                            jArr3 = jArr6;
                            jArr4 = jArr7;
                            j10 = j11;
                            i11 = i14;
                        }
                        j11 = j10 >> i11;
                        i16++;
                        i14 = i11;
                        jArr6 = jArr3;
                        jArr7 = jArr4;
                    }
                    jArr = jArr6;
                    jArr2 = jArr7;
                    if (i15 != i14) {
                        break;
                    }
                } else {
                    jArr = jArr6;
                    jArr2 = jArr7;
                }
                if (i12 == length) {
                    break;
                }
                i12++;
                jArr6 = jArr;
                jArr7 = jArr2;
            }
            sbU.append(charSequence3);
        } else {
            sbU.append(charSequence3);
        }
        return sbU.toString();
    }

    public final boolean none() {
        return this._size == 0;
    }

    public String toString() {
        int i10;
        int i11;
        int i12;
        int i13;
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i14 = 0;
            int i15 = 0;
            while (true) {
                long j10 = jArr3[i14];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i16 = 8;
                    int i17 = 8 - ((~(i14 - length)) >>> 31);
                    int i18 = 0;
                    while (i18 < i17) {
                        if ((255 & j10) < 128) {
                            int i19 = (i14 << 3) + i18;
                            i11 = i14;
                            long j11 = jArr[i19];
                            i12 = i16;
                            i13 = i18;
                            long j12 = jArr2[i19];
                            sb.append(j11);
                            sb.append("=");
                            sb.append(j12);
                            i15++;
                            if (i15 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i11 = i14;
                            i12 = i16;
                            i13 = i18;
                        }
                        j10 >>= i12;
                        i18 = i13 + 1;
                        i14 = i11;
                        i16 = i12;
                    }
                    int i20 = i14;
                    if (i17 != i16) {
                        break;
                    }
                    i10 = i20;
                } else {
                    i10 = i14;
                }
                if (i10 == length) {
                    break;
                }
                i14 = i10 + 1;
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static /* synthetic */ void getKeys$annotations() {
    }

    public static /* synthetic */ void getMetadata$annotations() {
    }

    public static /* synthetic */ void getValues$annotations() {
    }

    public static /* synthetic */ void get_capacity$collection$annotations() {
    }

    public static /* synthetic */ void get_size$collection$annotations() {
    }

    public /* synthetic */ LongLongMap(g gVar) {
        this();
    }

    public final boolean any() {
        return this._size != 0;
    }

    public final int count() {
        return getSize();
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

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, p pVar) {
        int i11;
        CharSequence charSequence4 = charSequence;
        StringBuilder sbS = a3.a.s(charSequence4, charSequence2, charSequence3, pVar, charSequence2);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j10 = jArr3[i12];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8;
                    int i15 = 8 - ((~(i12 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j10 & 255) < 128) {
                            int i17 = (i12 << 3) + i16;
                            long j11 = jArr[i17];
                            long j12 = jArr2[i17];
                            i11 = i14;
                            if (i13 == i10) {
                                sbS.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i13 != 0) {
                                sbS.append(charSequence4);
                            }
                            sbS.append((CharSequence) pVar.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                            i13++;
                        } else {
                            i11 = i14;
                        }
                        j10 >>= i11;
                        i16++;
                        charSequence4 = charSequence;
                        i14 = i11;
                    }
                    if (i15 != i14) {
                        break;
                    }
                }
                if (i12 == length) {
                    break;
                }
                i12++;
                charSequence4 = charSequence;
            }
            sbS.append(charSequence3);
        } else {
            sbS.append(charSequence3);
        }
        return sbS.toString();
    }

    public final String joinToString() {
        return joinToString$default(this, null, null, null, 0, null, 31, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081 A[PHI: r12
      0x0081: PHI (r12v2 int) = (r12v1 int), (r12v3 int) binds: [B:6:0x0032, B:19:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r23, java.lang.CharSequence r24, java.lang.CharSequence r25, int r26, java.lang.CharSequence r27, g7.p r28) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r27
            r5 = r28
            java.lang.StringBuilder r6 = a3.a.t(r1, r2, r3, r4, r5)
            r6.append(r2)
            long[] r2 = r0.keys
            long[] r7 = r0.values
            long[] r8 = r0.metadata
            int r9 = r8.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L8a
            r11 = 0
            r12 = 0
        L20:
            r13 = r8[r11]
            r15 = r11
            long r10 = ~r13
            r16 = 7
            long r10 = r10 << r16
            long r10 = r10 & r13
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r16
            int r10 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r10 == 0) goto L81
            int r11 = r15 - r9
            int r10 = ~r11
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r16 = r11
            r11 = 0
        L40:
            if (r11 >= r10) goto L7d
            r17 = 255(0xff, double:1.26E-321)
            long r17 = r13 & r17
            r19 = 128(0x80, double:6.3E-322)
            int r17 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r17 >= 0) goto L74
            int r17 = r15 << 3
            int r17 = r17 + r11
            r18 = r2[r17]
            r20 = r7[r17]
            r0 = r26
            if (r12 != r0) goto L5c
            r6.append(r4)
            goto L8d
        L5c:
            if (r12 == 0) goto L61
            r6.append(r1)
        L61:
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
            java.lang.Long r1 = java.lang.Long.valueOf(r20)
            java.lang.Object r0 = r5.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L74:
            long r13 = r13 >> r16
            int r11 = r11 + 1
            r0 = r22
            r1 = r23
            goto L40
        L7d:
            r0 = r16
            if (r10 != r0) goto L8a
        L81:
            if (r15 == r9) goto L8a
            int r11 = r15 + 1
            r0 = r22
            r1 = r23
            goto L20
        L8a:
            r6.append(r3)
        L8d:
            java.lang.String r0 = r6.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, g7.p):java.lang.String");
    }

    public static /* synthetic */ String joinToString$default(LongLongMap longLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
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
        return longLongMap.joinToString(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[PHI: r11
      0x007e: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x002c, B:20:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, g7.p r25) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            r3 = r23
            r4 = r25
            java.lang.StringBuilder r3 = a3.a.s(r1, r3, r2, r4, r3)
            long[] r5 = r0.keys
            long[] r6 = r0.values
            long[] r7 = r0.metadata
            int r8 = r7.length
            int r8 = r8 + (-2)
            if (r8 < 0) goto L85
            r10 = 0
            r11 = 0
        L1b:
            r12 = r7[r10]
            long r14 = ~r12
            r16 = 7
            long r14 = r14 << r16
            long r14 = r14 & r12
            r16 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r14 = r14 & r16
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 == 0) goto L7e
            int r14 = r10 - r8
            int r14 = ~r14
            int r14 = r14 >>> 31
            r15 = 8
            int r14 = 8 - r14
            r9 = 0
        L38:
            if (r9 >= r14) goto L7b
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r12 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L70
            int r16 = r10 << 3
            int r16 = r16 + r9
            r17 = r5[r16]
            r19 = r6[r16]
            r16 = r15
            r15 = -1
            if (r11 != r15) goto L57
            java.lang.String r1 = "..."
            r3.append(r1)
            goto L88
        L57:
            if (r11 == 0) goto L5c
            r3.append(r1)
        L5c:
            java.lang.Long r15 = java.lang.Long.valueOf(r17)
            java.lang.Long r0 = java.lang.Long.valueOf(r19)
            java.lang.Object r0 = r4.invoke(r15, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3.append(r0)
            int r11 = r11 + 1
            goto L72
        L70:
            r16 = r15
        L72:
            long r12 = r12 >> r16
            int r9 = r9 + 1
            r0 = r21
            r15 = r16
            goto L38
        L7b:
            r0 = r15
            if (r14 != r0) goto L85
        L7e:
            if (r10 == r8) goto L85
            int r10 = r10 + 1
            r0 = r21
            goto L1b
        L85:
            r3.append(r2)
        L88:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, g7.p):java.lang.String");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i10;
        charSequence.getClass();
        charSequence2.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr3[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            long j11 = jArr[i16];
                            long j12 = jArr2[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append(charSequence);
                            }
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                            i12++;
                        } else {
                            i10 = i13;
                        }
                        j10 >>= i10;
                        i15++;
                        i13 = i10;
                    }
                    if (i14 != i13) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        return sb.toString();
    }

    public final String joinToString(CharSequence charSequence, p pVar) {
        int i10;
        charSequence.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr3[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            long j11 = jArr[i16];
                            long j12 = jArr2[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append(charSequence);
                            }
                            Long lValueOf = Long.valueOf(j11);
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(lValueOf, Long.valueOf(j12)));
                            i12++;
                        } else {
                            i10 = i13;
                        }
                        j10 >>= i10;
                        i15++;
                        i13 = i10;
                    }
                    if (i14 != i13) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        return sb.toString();
    }

    public final String joinToString(p pVar) {
        int i10;
        pVar.getClass();
        StringBuilder sb = new StringBuilder("");
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        long[] jArr3 = this.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr3[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            long j11 = jArr[i16];
                            long j12 = jArr2[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(Long.valueOf(j11), Long.valueOf(j12)));
                            i12++;
                        } else {
                            i10 = i13;
                        }
                        j10 >>= i10;
                        i15++;
                        i13 = i10;
                    }
                    if (i14 != i13) {
                        break;
                    }
                }
                if (i11 == length) {
                    break;
                }
                i11++;
            }
            sb.append((CharSequence) "");
        } else {
            sb.append((CharSequence) "");
        }
        return sb.toString();
    }
}

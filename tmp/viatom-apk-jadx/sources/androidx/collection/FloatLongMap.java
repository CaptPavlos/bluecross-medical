package androidx.collection;

import a2.a;
import g7.l;
import g7.p;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class FloatLongMap {
    public int _capacity;
    public int _size;
    public float[] keys;
    public long[] metadata;
    public long[] values;

    private FloatLongMap() {
        this.metadata = ScatterMapKt.EmptyGroup;
        this.keys = FloatSetKt.getEmptyFloatArray();
        this.values = LongSetKt.getEmptyLongArray();
    }

    public static /* synthetic */ String joinToString$default(FloatLongMap floatLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, p pVar, int i11, Object obj) {
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
        float[] fArr = floatLongMap.keys;
        long[] jArr3 = floatLongMap.values;
        long[] jArr4 = floatLongMap.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i14 = 0;
            int i15 = 0;
            loop0: while (true) {
                long j10 = jArr4[i14];
                int i16 = i14;
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8;
                    int i18 = 8 - ((~(i16 - length)) >>> 31);
                    int i19 = 0;
                    while (i19 < i18) {
                        if ((j10 & 255) < 128) {
                            int i20 = (i16 << 3) + i19;
                            float f = fArr[i20];
                            long j11 = jArr3[i20];
                            if (i15 == i13) {
                                sbT.append(charSequence8);
                                break loop0;
                            }
                            if (i15 != 0) {
                                sbT.append(charSequence5);
                            }
                            i12 = i17;
                            jArr2 = jArr4;
                            sbT.append((CharSequence) pVar.invoke(Float.valueOf(f), Long.valueOf(j11)));
                            i15++;
                        } else {
                            jArr2 = jArr4;
                            i12 = i17;
                        }
                        j10 >>= i12;
                        i19++;
                        i17 = i12;
                        jArr4 = jArr2;
                    }
                    jArr = jArr4;
                    if (i18 != i17) {
                        break;
                    }
                } else {
                    jArr = jArr4;
                }
                if (i16 == length) {
                    break;
                }
                i14 = i16 + 1;
                jArr4 = jArr;
            }
            sbT.append(charSequence7);
        } else {
            sbT.append(charSequence7);
        }
        return sbT.toString();
    }

    public final boolean all(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return true;
        }
        int i10 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i11 = 8 - ((~(i10 - length)) >>> 31);
                for (int i12 = 0; i12 < i11; i12++) {
                    if ((255 & j10) < 128) {
                        int i13 = (i10 << 3) + i12;
                        if (!((Boolean) pVar.invoke(Float.valueOf(fArr[i13]), Long.valueOf(jArr[i13]))).booleanValue()) {
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
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j10 = jArr2[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    for (int i12 = 0; i12 < i11; i12++) {
                        if ((255 & j10) < 128) {
                            int i13 = (i10 << 3) + i12;
                            if (((Boolean) pVar.invoke(Float.valueOf(fArr[i13]), Long.valueOf(jArr[i13]))).booleanValue()) {
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

    public final boolean contains(float f) {
        return findKeyIndex(f) >= 0;
    }

    public final boolean containsKey(float f) {
        return findKeyIndex(f) >= 0;
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatLongMap.containsValue(long):boolean");
    }

    public final int count(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            long j10 = jArr2[i10];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i12 = 8 - ((~(i10 - length)) >>> 31);
                for (int i13 = 0; i13 < i12; i13++) {
                    if ((255 & j10) < 128) {
                        int i14 = (i10 << 3) + i13;
                        if (((Boolean) pVar.invoke(Float.valueOf(fArr[i14]), Long.valueOf(jArr[i14]))).booleanValue()) {
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

    /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = 1
            if (r1 != r0) goto L8
            return r2
        L8:
            boolean r3 = r1 instanceof androidx.collection.FloatLongMap
            r4 = 0
            if (r3 != 0) goto Le
            return r4
        Le:
            androidx.collection.FloatLongMap r1 = (androidx.collection.FloatLongMap) r1
            int r3 = r1.getSize()
            int r5 = r0.getSize()
            if (r3 == r5) goto L1b
            return r4
        L1b:
            float[] r3 = r0.keys
            long[] r5 = r0.values
            long[] r6 = r0.metadata
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L67
            r8 = r4
        L27:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L62
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            r12 = 8
            int r11 = 8 - r11
            r13 = r4
        L41:
            if (r13 >= r11) goto L60
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r9
            r16 = 128(0x80, double:6.3E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L5c
            int r14 = r8 << 3
            int r14 = r14 + r13
            r15 = r3[r14]
            r16 = r5[r14]
            long r14 = r1.get(r15)
            int r14 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r14 == 0) goto L5c
            return r4
        L5c:
            long r9 = r9 >> r12
            int r13 = r13 + 1
            goto L41
        L60:
            if (r11 != r12) goto L67
        L62:
            if (r8 == r7) goto L67
            int r8 = r8 + 1
            goto L27
        L67:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatLongMap.equals(java.lang.Object):boolean");
    }

    public final int findKeyIndex(float f) {
        int iFloatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i10 = iFloatToIntBits ^ (iFloatToIntBits << 16);
        int i11 = i10 & 127;
        int i12 = this._capacity;
        int i13 = (i10 >>> 7) & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j10 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j11 = (i11 * ScatterMapKt.BitmaskLsb) ^ j10;
            for (long j12 = (~j11) & (j11 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j12 != 0; j12 &= j12 - 1) {
                int iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j12) >> 3) + i13) & i12;
                if (this.keys[iNumberOfTrailingZeros] == f) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((j10 & ((~j10) << 6) & (-9187201950435737472L)) != 0) {
                return -1;
            }
            i14 += 8;
            i13 = (i13 + i14) & i12;
        }
    }

    public final void forEach(p pVar) {
        pVar.getClass();
        float[] fArr = this.keys;
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
                        int i13 = (i10 << 3) + i12;
                        pVar.invoke(Float.valueOf(fArr[i13]), Long.valueOf(jArr[i13]));
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
        float[] fArr = this.keys;
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
                        lVar.invoke(Float.valueOf(fArr[(i10 << 3) + i12]));
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

    public final long get(float f) {
        int iFindKeyIndex = findKeyIndex(f);
        if (iFindKeyIndex >= 0) {
            return this.values[iFindKeyIndex];
        }
        throw new NoSuchElementException("Cannot find value for key " + f);
    }

    public final int getCapacity() {
        return this._capacity;
    }

    public final long getOrDefault(float f, long j10) {
        int iFindKeyIndex = findKeyIndex(f);
        return iFindKeyIndex >= 0 ? this.values[iFindKeyIndex] : j10;
    }

    public final long getOrElse(float f, g7.a aVar) {
        aVar.getClass();
        int iFindKeyIndex = findKeyIndex(f);
        return iFindKeyIndex < 0 ? ((Number) aVar.invoke()).longValue() : this.values[iFindKeyIndex];
    }

    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        int i10;
        int i11;
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return 0;
        }
        int i12 = 0;
        int iFloatToIntBits = 0;
        while (true) {
            long j10 = jArr2[i12];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i13 = 8 - ((~(i12 - length)) >>> 31);
                int i14 = 0;
                while (i14 < i13) {
                    if ((255 & j10) < 128) {
                        int i15 = (i12 << 3) + i14;
                        float f = fArr[i15];
                        long j11 = jArr[i15];
                        i11 = i12;
                        iFloatToIntBits += ((int) (j11 ^ (j11 >>> 32))) ^ Float.floatToIntBits(f);
                    } else {
                        i11 = i12;
                    }
                    j10 >>= 8;
                    i14++;
                    i12 = i11;
                }
                int i16 = i12;
                if (i13 != 8) {
                    return iFloatToIntBits;
                }
                i10 = i16;
            } else {
                i10 = i12;
            }
            if (i10 == length) {
                return iFloatToIntBits;
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
        float[] fArr;
        long[] jArr;
        float[] fArr2;
        long[] jArr2;
        int i11;
        StringBuilder sbU = a3.a.u(charSequence, charSequence2, charSequence3, charSequence4, charSequence2);
        float[] fArr3 = this.keys;
        long[] jArr3 = this.values;
        long[] jArr4 = this.metadata;
        int length = jArr4.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j10 = jArr4[i12];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8;
                    int i15 = 8 - ((~(i12 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j10 & 255) < 128) {
                            int i17 = (i12 << 3) + i16;
                            i11 = i14;
                            float f = fArr3[i17];
                            fArr2 = fArr3;
                            jArr2 = jArr3;
                            long j11 = jArr2[i17];
                            if (i13 == i10) {
                                sbU.append(charSequence4);
                                break loop0;
                            }
                            if (i13 != 0) {
                                sbU.append(charSequence);
                            }
                            sbU.append(f);
                            sbU.append('=');
                            sbU.append(j11);
                            i13++;
                        } else {
                            fArr2 = fArr3;
                            jArr2 = jArr3;
                            i11 = i14;
                        }
                        j10 >>= i11;
                        i16++;
                        i14 = i11;
                        fArr3 = fArr2;
                        jArr3 = jArr2;
                    }
                    fArr = fArr3;
                    jArr = jArr3;
                    if (i15 != i14) {
                        break;
                    }
                } else {
                    fArr = fArr3;
                    jArr = jArr3;
                }
                if (i12 == length) {
                    break;
                }
                i12++;
                fArr3 = fArr;
                jArr3 = jArr;
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
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            while (true) {
                long j10 = jArr2[i12];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8 - ((~(i12 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i12 << 3) + i15;
                            float f = fArr[i16];
                            i11 = i12;
                            long j11 = jArr[i16];
                            sb.append(f);
                            sb.append("=");
                            sb.append(j11);
                            i13++;
                            if (i13 < this._size) {
                                sb.append(", ");
                            }
                        } else {
                            i11 = i12;
                        }
                        j10 >>= 8;
                        i15++;
                        i12 = i11;
                    }
                    int i17 = i12;
                    if (i14 != 8) {
                        break;
                    }
                    i10 = i17;
                } else {
                    i10 = i12;
                }
                if (i10 == length) {
                    break;
                }
                i12 = i10 + 1;
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

    public /* synthetic */ FloatLongMap(g gVar) {
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
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i12 = 0;
            int i13 = 0;
            loop0: while (true) {
                long j10 = jArr2[i12];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i14 = 8;
                    int i15 = 8 - ((~(i12 - length)) >>> 31);
                    int i16 = 0;
                    while (i16 < i15) {
                        if ((j10 & 255) < 128) {
                            int i17 = (i12 << 3) + i16;
                            float f = fArr[i17];
                            long j11 = jArr[i17];
                            i11 = i14;
                            if (i13 == i10) {
                                sbS.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i13 != 0) {
                                sbS.append(charSequence4);
                            }
                            sbS.append((CharSequence) pVar.invoke(Float.valueOf(f), Long.valueOf(j11)));
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
    public final java.lang.String joinToString(java.lang.CharSequence r22, java.lang.CharSequence r23, java.lang.CharSequence r24, int r25, java.lang.CharSequence r26, g7.p r27) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r26
            r5 = r27
            java.lang.StringBuilder r6 = a3.a.t(r1, r2, r3, r4, r5)
            r6.append(r2)
            float[] r2 = r0.keys
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
            r19 = r7[r17]
            r0 = r25
            if (r12 != r0) goto L5c
            r6.append(r4)
            goto L8d
        L5c:
            if (r12 == 0) goto L61
            r6.append(r1)
        L61:
            java.lang.Float r0 = java.lang.Float.valueOf(r18)
            java.lang.Long r1 = java.lang.Long.valueOf(r19)
            java.lang.Object r0 = r5.invoke(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.append(r0)
            int r12 = r12 + 1
        L74:
            long r13 = r13 >> r16
            int r11 = r11 + 1
            r0 = r21
            r1 = r22
            goto L40
        L7d:
            r0 = r16
            if (r10 != r0) goto L8a
        L81:
            if (r15 == r9) goto L8a
            int r11 = r15 + 1
            r0 = r21
            r1 = r22
            goto L20
        L8a:
            r6.append(r3)
        L8d:
            java.lang.String r0 = r6.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, g7.p):java.lang.String");
    }

    public static /* synthetic */ String joinToString$default(FloatLongMap floatLongMap, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, int i11, Object obj) {
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
        return floatLongMap.joinToString(charSequence, charSequence2, charSequence6, i10, charSequence5);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007e A[PHI: r11
      0x007e: PHI (r11v2 int) = (r11v1 int), (r11v3 int) binds: [B:6:0x002c, B:20:0x007c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String joinToString(java.lang.CharSequence r21, java.lang.CharSequence r22, java.lang.CharSequence r23, g7.p r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            r3 = r22
            r4 = r24
            java.lang.StringBuilder r3 = a3.a.s(r1, r3, r2, r4, r3)
            float[] r5 = r0.keys
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
            r18 = r6[r16]
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
            java.lang.Float r15 = java.lang.Float.valueOf(r17)
            java.lang.Long r0 = java.lang.Long.valueOf(r18)
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
            r0 = r20
            r15 = r16
            goto L38
        L7b:
            r0 = r15
            if (r14 != r0) goto L85
        L7e:
            if (r10 == r8) goto L85
            int r10 = r10 + 1
            r0 = r20
            goto L1b
        L85:
            r3.append(r2)
        L88:
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatLongMap.joinToString(java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, g7.p):java.lang.String");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, p pVar) {
        int i10;
        charSequence.getClass();
        charSequence2.getClass();
        pVar.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr2[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            float f = fArr[i16];
                            long j11 = jArr[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append(charSequence);
                            }
                            Float fValueOf = Float.valueOf(f);
                            Long lValueOf = Long.valueOf(j11);
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(fValueOf, lValueOf));
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
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr2[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            float f = fArr[i16];
                            long j11 = jArr[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append(charSequence);
                            }
                            Float fValueOf = Float.valueOf(f);
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(fValueOf, Long.valueOf(j11)));
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
        float[] fArr = this.keys;
        long[] jArr = this.values;
        long[] jArr2 = this.metadata;
        int length = jArr2.length - 2;
        if (length >= 0) {
            int i11 = 0;
            int i12 = 0;
            loop0: while (true) {
                long j10 = jArr2[i11];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i13 = 8;
                    int i14 = 8 - ((~(i11 - length)) >>> 31);
                    int i15 = 0;
                    while (i15 < i14) {
                        if ((255 & j10) < 128) {
                            int i16 = (i11 << 3) + i15;
                            float f = fArr[i16];
                            long j11 = jArr[i16];
                            if (i12 == -1) {
                                sb.append((CharSequence) "...");
                                break loop0;
                            }
                            if (i12 != 0) {
                                sb.append((CharSequence) ", ");
                            }
                            Float fValueOf = Float.valueOf(f);
                            Long lValueOf = Long.valueOf(j11);
                            i10 = i13;
                            sb.append((CharSequence) pVar.invoke(fValueOf, lValueOf));
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

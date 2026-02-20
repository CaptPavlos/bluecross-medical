package i8;

import h0.a0;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends f8.a implements h8.i {

    /* renamed from: a, reason: collision with root package name */
    public final h8.b f9089a;

    /* renamed from: b, reason: collision with root package name */
    public final x f9090b;

    /* renamed from: c, reason: collision with root package name */
    public final a6.f f9091c;

    /* renamed from: d, reason: collision with root package name */
    public final j8.f f9092d;
    public int e;
    public e2.a f;
    public final h8.h g;
    public final j h;

    public t(h8.b bVar, x xVar, a6.f fVar, e8.e eVar, e2.a aVar) {
        eVar.getClass();
        this.f9089a = bVar;
        this.f9090b = xVar;
        this.f9091c = fVar;
        this.f9092d = bVar.f8827b;
        this.e = -1;
        this.f = aVar;
        h8.h hVar = bVar.f8826a;
        this.g = hVar;
        this.h = hVar.f8835a ? null : new j(eVar);
    }

    @Override // h8.i
    public final h8.k a() {
        return new a0(this.f9089a.f8826a, this.f9091c).d();
    }

    @Override // f8.a, f8.e
    public final f8.c beginStructure(e8.e eVar) {
        eVar.getClass();
        h8.b bVar = this.f9089a;
        x xVarN = l.n(eVar, bVar);
        a6.f fVar = this.f9091c;
        a6.o oVar = (a6.o) fVar.f257c;
        int i10 = oVar.f277b + 1;
        oVar.f277b = i10;
        Object[] objArr = (Object[]) oVar.f278c;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            oVar.f278c = Arrays.copyOf(objArr, i11);
            oVar.f279d = Arrays.copyOf((int[]) oVar.f279d, i11);
        }
        ((Object[]) oVar.f278c)[i10] = eVar;
        fVar.j(xVarN.f9103a);
        if (fVar.t() != 4) {
            int iOrdinal = xVarN.ordinal();
            return (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) ? new t(bVar, xVarN, fVar, eVar, this.f) : (this.f9090b == xVarN && bVar.f8826a.f8835a) ? this : new t(bVar, xVarN, fVar, eVar, this.f);
        }
        a6.f.o(fVar, "Unexpected leading comma", 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final boolean decodeBoolean() {
        boolean z9;
        boolean z10;
        a6.f fVar = this.f9091c;
        int iW = fVar.w();
        String str = (String) fVar.f;
        if (iW == str.length()) {
            a6.f.o(fVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iW) == '\"') {
            iW++;
            z9 = true;
        } else {
            z9 = false;
        }
        int iV = fVar.v(iW);
        if (iV >= str.length() || iV == -1) {
            a6.f.o(fVar, "EOF", 0, null, 6);
            throw null;
        }
        int i10 = iV + 1;
        int iCharAt = str.charAt(iV) | ' ';
        if (iCharAt == 102) {
            fVar.f(i10, "alse");
            z10 = false;
        } else {
            if (iCharAt != 116) {
                a6.f.o(fVar, "Expected valid boolean literal prefix, but had '" + fVar.m() + '\'', 0, null, 6);
                throw null;
            }
            fVar.f(i10, "rue");
            z10 = true;
        }
        if (!z9) {
            return z10;
        }
        if (fVar.f256b == str.length()) {
            a6.f.o(fVar, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(fVar.f256b) == '\"') {
            fVar.f256b++;
            return z10;
        }
        a6.f.o(fVar, "Expected closing quotation mark", 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final byte decodeByte() {
        a6.f fVar = this.f9091c;
        long jK = fVar.k();
        byte b10 = (byte) jK;
        if (jK == b10) {
            return b10;
        }
        a6.f.o(fVar, "Failed to parse byte for input '" + jK + '\'', 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final char decodeChar() {
        a6.f fVar = this.f9091c;
        String strM = fVar.m();
        if (strM.length() == 1) {
            return strM.charAt(0);
        }
        a6.f.o(fVar, "Expected single char, but got '" + strM + '\'', 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final double decodeDouble() throws NumberFormatException {
        a6.f fVar = this.f9091c;
        String strM = fVar.m();
        try {
            double d8 = Double.parseDouble(strM);
            this.f9089a.f8826a.getClass();
            if (!Double.isInfinite(d8) && !Double.isNaN(d8)) {
                return d8;
            }
            l.o(fVar, Double.valueOf(d8));
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'double' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.c
    public final int decodeElementIndex(e8.e eVar) {
        String strG;
        h8.b bVar = this.f9089a;
        h8.h hVar = bVar.f8826a;
        a6.f fVar = this.f9091c;
        a6.o oVar = (a6.o) fVar.f257c;
        String str = (String) fVar.f;
        eVar.getClass();
        x xVar = this.f9090b;
        int iOrdinal = xVar.ordinal();
        char c10 = ':';
        boolean zX = false;
        byte b10 = 1;
        int i10 = -1;
        if (iOrdinal == 0) {
            boolean zX2 = fVar.x();
            while (true) {
                boolean zC = fVar.c();
                j jVar = this.h;
                if (zC) {
                    this.g.getClass();
                    strG = fVar.g();
                    fVar.j(c10);
                    int i11 = l.i(eVar, bVar, strG);
                    byte b11 = b10;
                    if (i11 != -3) {
                        if (jVar != null) {
                            g8.t tVar = jVar.f9073a;
                            if (i11 < 64) {
                                tVar.f8328c |= 1 << i11;
                            } else {
                                int i12 = (i11 >>> 6) - 1;
                                long[] jArr = tVar.f8329d;
                                jArr[i12] = jArr[i12] | (1 << (i11 & 63));
                            }
                        }
                        i10 = i11;
                    } else {
                        e2.a aVar = this.f;
                        if (aVar == null || !kotlin.jvm.internal.l.a(aVar.f7626b, strG)) {
                            break;
                        }
                        aVar.f7626b = null;
                        ArrayList arrayList = new ArrayList();
                        byte bT = fVar.t();
                        if (bT == 8 || bT == 6) {
                            while (true) {
                                byte bT2 = fVar.t();
                                b10 = b11;
                                if (bT2 == b10) {
                                    fVar.g();
                                } else {
                                    if (bT2 == 8 || bT2 == 6) {
                                        arrayList.add(Byte.valueOf(bT2));
                                    } else if (bT2 == 9) {
                                        if (((Number) t6.l.i0(arrayList)).byteValue() != 8) {
                                            throw l.e("found ] instead of } at path: " + oVar, str, fVar.f256b);
                                        }
                                        t6.r.Z(arrayList);
                                    } else if (bT2 == 7) {
                                        if (((Number) t6.l.i0(arrayList)).byteValue() != 6) {
                                            throw l.e("found } instead of ] at path: " + oVar, str, fVar.f256b);
                                        }
                                        t6.r.Z(arrayList);
                                    } else if (bT2 == 10) {
                                        a6.f.o(fVar, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6);
                                        throw null;
                                    }
                                    fVar.h();
                                    if (arrayList.size() == 0) {
                                        break;
                                    }
                                }
                                b11 = b10;
                            }
                        } else {
                            fVar.m();
                            b10 = b11;
                        }
                        zX2 = fVar.x();
                        c10 = ':';
                    }
                } else {
                    int i13 = 0;
                    if (zX2) {
                        hVar.getClass();
                        l.j(fVar, "object");
                        throw null;
                    }
                    if (jVar != null) {
                        g8.t tVar2 = jVar.f9073a;
                        i iVar = tVar2.f8327b;
                        e8.e eVar2 = tVar2.f8326a;
                        int iE = eVar2.e();
                        while (true) {
                            long j10 = tVar2.f8328c;
                            long j11 = -1;
                            if (j10 != -1) {
                                int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(~j10);
                                tVar2.f8328c |= 1 << iNumberOfTrailingZeros;
                                if (((Boolean) iVar.invoke(eVar2, Integer.valueOf(iNumberOfTrailingZeros))).booleanValue()) {
                                    i10 = iNumberOfTrailingZeros;
                                    break;
                                }
                            } else if (iE > 64) {
                                long[] jArr2 = tVar2.f8329d;
                                int length = jArr2.length;
                                loop3: while (i13 < length) {
                                    int i14 = i13 + 1;
                                    int i15 = i14 * 64;
                                    long j12 = jArr2[i13];
                                    while (j12 != j11) {
                                        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(~j12);
                                        j12 |= 1 << iNumberOfTrailingZeros2;
                                        int i16 = iNumberOfTrailingZeros2 + i15;
                                        if (((Boolean) iVar.invoke(eVar2, Integer.valueOf(i16))).booleanValue()) {
                                            jArr2[i13] = j12;
                                            i10 = i16;
                                            break loop3;
                                        }
                                        j11 = -1;
                                    }
                                    jArr2[i13] = j12;
                                    i13 = i14;
                                    j11 = -1;
                                }
                            }
                        }
                    } else {
                        i10 = -1;
                    }
                }
            }
            fVar.n(o7.m.m0(strG, str.subSequence(0, fVar.f256b).toString(), 6), "Encountered an unknown key '" + strG + '\'', "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
            throw null;
        }
        if (iOrdinal != 2) {
            boolean zX3 = fVar.x();
            if (fVar.c()) {
                int i17 = this.e;
                if (i17 != -1 && !zX3) {
                    a6.f.o(fVar, "Expected end of the array or comma", 0, null, 6);
                    throw null;
                }
                i10 = i17 + 1;
                this.e = i10;
            } else if (zX3) {
                hVar.getClass();
                l.j(fVar, "array");
                throw null;
            }
        } else {
            int i18 = this.e;
            boolean z9 = i18 % 2 != 0;
            if (!z9) {
                fVar.j(':');
            } else if (i18 != -1) {
                zX = fVar.x();
            }
            if (fVar.c()) {
                if (z9) {
                    int i19 = this.e;
                    int i20 = fVar.f256b;
                    if (i19 == -1) {
                        if (zX) {
                            a6.f.o(fVar, "Unexpected leading comma", i20, null, 4);
                            throw null;
                        }
                    } else if (!zX) {
                        a6.f.o(fVar, "Expected comma after the key-value pair", i20, null, 4);
                        throw null;
                    }
                }
                i10 = this.e + 1;
                this.e = i10;
            } else if (zX) {
                hVar.getClass();
                l.j(fVar, "object");
                throw null;
            }
        }
        if (xVar != x.e) {
            ((int[]) oVar.f279d)[oVar.f277b] = i10;
        }
        return i10;
    }

    @Override // f8.a
    public final int decodeEnum(e8.e eVar) {
        eVar.getClass();
        String strDecodeString = decodeString();
        String strConcat = " at path ".concat(((a6.o) this.f9091c.f257c).c());
        eVar.getClass();
        h8.b bVar = this.f9089a;
        bVar.getClass();
        strDecodeString.getClass();
        int i10 = l.i(eVar, bVar, strDecodeString);
        if (i10 != -3) {
            return i10;
        }
        throw new c8.f(eVar.a() + " does not contain element with name '" + strDecodeString + '\'' + strConcat);
    }

    @Override // f8.a, f8.e
    public final float decodeFloat() throws NumberFormatException {
        a6.f fVar = this.f9091c;
        String strM = fVar.m();
        try {
            float f = Float.parseFloat(strM);
            this.f9089a.f8826a.getClass();
            if (!Float.isInfinite(f) && !Float.isNaN(f)) {
                return f;
            }
            l.o(fVar, Float.valueOf(f));
            throw null;
        } catch (IllegalArgumentException unused) {
            a6.f.o(fVar, "Failed to parse type 'float' for input '" + strM + '\'', 0, null, 6);
            throw null;
        }
    }

    @Override // f8.a, f8.e
    public final f8.e decodeInline(e8.e eVar) {
        eVar.getClass();
        return v.a(eVar) ? new g(this.f9091c, this.f9089a) : super.decodeInline(eVar);
    }

    @Override // f8.a, f8.e
    public final int decodeInt() {
        a6.f fVar = this.f9091c;
        long jK = fVar.k();
        int i10 = (int) jK;
        if (jK == i10) {
            return i10;
        }
        a6.f.o(fVar, "Failed to parse int for input '" + jK + '\'', 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final long decodeLong() {
        return this.f9091c.k();
    }

    @Override // f8.a, f8.e
    public final boolean decodeNotNullMark() {
        j jVar = this.h;
        if (!(jVar != null ? jVar.f9074b : false)) {
            a6.f fVar = this.f9091c;
            int iV = fVar.v(fVar.w());
            String str = (String) fVar.f;
            int length = str.length() - iV;
            boolean z9 = false;
            if (length >= 4 && iV != -1) {
                int i10 = 0;
                while (true) {
                    if (i10 < 4) {
                        if ("null".charAt(i10) != str.charAt(iV + i10)) {
                            break;
                        }
                        i10++;
                    } else if (length <= 4 || l.g(str.charAt(iV + 4)) != 0) {
                        z9 = true;
                        fVar.f256b = iV + 4;
                    }
                }
            }
            if (!z9) {
                return true;
            }
        }
        return false;
    }

    @Override // f8.a, f8.e
    public final Void decodeNull() {
        return null;
    }

    @Override // f8.a, f8.c
    public final Object decodeSerializableElement(e8.e eVar, int i10, c8.a aVar, Object obj) {
        a6.o oVar = (a6.o) this.f9091c.f257c;
        eVar.getClass();
        aVar.getClass();
        boolean z9 = this.f9090b == x.e && (i10 & 1) == 0;
        if (z9) {
            int[] iArr = (int[]) oVar.f279d;
            int i11 = oVar.f277b;
            if (iArr[i11] == -2) {
                ((Object[]) oVar.f278c)[i11] = m.f9076a;
            }
        }
        Object objDecodeSerializableElement = super.decodeSerializableElement(eVar, i10, aVar, obj);
        if (z9) {
            int[] iArr2 = (int[]) oVar.f279d;
            int i12 = oVar.f277b;
            if (iArr2[i12] != -2) {
                int i13 = i12 + 1;
                oVar.f277b = i13;
                Object[] objArr = (Object[]) oVar.f278c;
                if (i13 == objArr.length) {
                    int i14 = i13 * 2;
                    oVar.f278c = Arrays.copyOf(objArr, i14);
                    oVar.f279d = Arrays.copyOf((int[]) oVar.f279d, i14);
                }
            }
            Object[] objArr2 = (Object[]) oVar.f278c;
            int i15 = oVar.f277b;
            objArr2[i15] = objDecodeSerializableElement;
            ((int[]) oVar.f279d)[i15] = -2;
        }
        return objDecodeSerializableElement;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0150  */
    @Override // f8.a, f8.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object decodeSerializableValue(c8.a r11) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i8.t.decodeSerializableValue(c8.a):java.lang.Object");
    }

    @Override // f8.a, f8.e
    public final short decodeShort() {
        a6.f fVar = this.f9091c;
        long jK = fVar.k();
        short s9 = (short) jK;
        if (jK == s9) {
            return s9;
        }
        a6.f.o(fVar, "Failed to parse short for input '" + jK + '\'', 0, null, 6);
        throw null;
    }

    @Override // f8.a, f8.e
    public final String decodeString() {
        this.g.getClass();
        return this.f9091c.l();
    }

    @Override // f8.a, f8.c
    public final void endStructure(e8.e eVar) {
        eVar.getClass();
        h8.h hVar = this.f9089a.f8826a;
        hVar.getClass();
        a6.f fVar = this.f9091c;
        if (fVar.x()) {
            hVar.getClass();
            l.j(fVar, "");
            throw null;
        }
        fVar.j(this.f9090b.f9104b);
        a6.o oVar = (a6.o) fVar.f257c;
        int i10 = oVar.f277b;
        int[] iArr = (int[]) oVar.f279d;
        if (iArr[i10] == -2) {
            iArr[i10] = -1;
            oVar.f277b = i10 - 1;
        }
        int i11 = oVar.f277b;
        if (i11 != -1) {
            oVar.f277b = i11 - 1;
        }
    }

    @Override // f8.c
    public final j8.f getSerializersModule() {
        return this.f9092d;
    }
}

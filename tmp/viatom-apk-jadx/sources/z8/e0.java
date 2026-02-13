package z8;

import com.google.android.gms.internal.measurement.l5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e0 extends l {
    public final transient byte[][] e;
    public final transient int[] f;

    public e0(byte[][] bArr, int[] iArr) {
        super(l.f14487d.f14488a);
        this.e = bArr;
        this.f = iArr;
    }

    @Override // z8.l
    public final String a() {
        throw null;
    }

    @Override // z8.l
    public final int e() {
        return this.f[this.e.length - 1];
    }

    @Override // z8.l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.e() == e() && m(0, lVar, e())) {
                return true;
            }
        }
        return false;
    }

    @Override // z8.l
    public final String f() {
        return u().f();
    }

    @Override // z8.l
    public final int g(byte[] bArr, int i10) {
        bArr.getClass();
        return u().g(bArr, i10);
    }

    @Override // z8.l
    public final int hashCode() {
        int i10 = this.f14489b;
        if (i10 != 0) {
            return i10;
        }
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int[] iArr = this.f;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            byte[] bArr2 = bArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr2[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.f14489b = i12;
        return i12;
    }

    @Override // z8.l
    public final byte[] i() {
        return t();
    }

    @Override // z8.l
    public final byte j(int i10) {
        byte[][] bArr = this.e;
        int length = bArr.length - 1;
        int[] iArr = this.f;
        l5.k(iArr[length], i10, 1L);
        int iG = a9.b.g(this, i10);
        return bArr[iG][(i10 - (iG == 0 ? 0 : iArr[iG - 1])) + iArr[bArr.length + iG]];
    }

    @Override // z8.l
    public final int k(byte[] bArr) {
        bArr.getClass();
        return u().k(bArr);
    }

    @Override // z8.l
    public final boolean m(int i10, l lVar, int i11) {
        lVar.getClass();
        if (i10 >= 0 && i10 <= e() - i11) {
            int i12 = i11 + i10;
            int iG = a9.b.g(this, i10);
            int i13 = 0;
            while (i10 < i12) {
                int[] iArr = this.f;
                int i14 = iG == 0 ? 0 : iArr[iG - 1];
                int i15 = iArr[iG] - i14;
                byte[][] bArr = this.e;
                int i16 = iArr[bArr.length + iG];
                int iMin = Math.min(i12, i15 + i14) - i10;
                if (lVar.n(i13, bArr[iG], (i10 - i14) + i16, iMin)) {
                    i13 += iMin;
                    i10 += iMin;
                    iG++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // z8.l
    public final boolean n(int i10, byte[] bArr, int i11, int i12) {
        bArr.getClass();
        if (i10 < 0 || i10 > e() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iG = a9.b.g(this, i10);
        while (i10 < i13) {
            int[] iArr = this.f;
            int i14 = iG == 0 ? 0 : iArr[iG - 1];
            int i15 = iArr[iG] - i14;
            byte[][] bArr2 = this.e;
            int i16 = iArr[bArr2.length + iG];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!l5.f(bArr2[iG], (i10 - i14) + i16, bArr, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iG++;
        }
        return true;
    }

    @Override // z8.l
    public final l o(int i10, int i11) {
        if (i11 == -1234567890) {
            i11 = e();
        }
        if (i10 < 0) {
            f.b(a3.a.g(i10, "beginIndex=", " < 0"));
            return null;
        }
        if (i11 > e()) {
            StringBuilder sbR = a3.a.r(i11, "endIndex=", " > length(");
            sbR.append(e());
            sbR.append(')');
            throw new IllegalArgumentException(sbR.toString().toString());
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            f.b(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "endIndex=", " < beginIndex="));
            return null;
        }
        if (i10 == 0 && i11 == e()) {
            return this;
        }
        if (i10 == i11) {
            return l.f14487d;
        }
        int iG = a9.b.g(this, i10);
        int iG2 = a9.b.g(this, i11 - 1);
        byte[][] bArr = this.e;
        byte[][] bArr2 = (byte[][]) t6.j.p0(bArr, iG, iG2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f;
        if (iG <= iG2) {
            int i13 = iG;
            int i14 = 0;
            while (true) {
                iArr[i14] = Math.min(iArr2[i13] - i10, i12);
                int i15 = i14 + 1;
                iArr[i14 + bArr2.length] = iArr2[bArr.length + i13];
                if (i13 == iG2) {
                    break;
                }
                i13++;
                i14 = i15;
            }
        }
        int i16 = iG != 0 ? iArr2[iG - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i10 - i16) + iArr[length];
        return new e0(bArr2, iArr);
    }

    @Override // z8.l
    public final l q() {
        return u().q();
    }

    @Override // z8.l
    public final void s(i iVar, int i10) {
        int iG = a9.b.g(this, 0);
        int i11 = 0;
        while (i11 < i10) {
            int[] iArr = this.f;
            int i12 = iG == 0 ? 0 : iArr[iG - 1];
            int i13 = iArr[iG] - i12;
            byte[][] bArr = this.e;
            int i14 = iArr[bArr.length + iG];
            int iMin = Math.min(i10, i13 + i12) - i11;
            int i15 = (i11 - i12) + i14;
            c0 c0Var = new c0(bArr[iG], i15, i15 + iMin, true);
            c0 c0Var2 = iVar.f14478a;
            if (c0Var2 == null) {
                c0Var.g = c0Var;
                c0Var.f = c0Var;
                iVar.f14478a = c0Var;
            } else {
                c0 c0Var3 = c0Var2.g;
                c0Var3.getClass();
                c0Var3.b(c0Var);
            }
            i11 += iMin;
            iG++;
        }
        iVar.f14479b += i10;
    }

    public final byte[] t() {
        byte[] bArr = new byte[e()];
        byte[][] bArr2 = this.e;
        int length = bArr2.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.f;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            int i15 = i14 - i11;
            t6.j.k0(bArr2[i10], i12, i13, bArr, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // z8.l
    public final String toString() {
        return u().toString();
    }

    public final l u() {
        return new l(t());
    }
}

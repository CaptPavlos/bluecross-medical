package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v6 {
    public static final v6 f = new v6(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f2205a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f2206b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f2207c;

    /* renamed from: d, reason: collision with root package name */
    public int f2208d = -1;
    public boolean e;

    public v6(int i10, int[] iArr, Object[] objArr, boolean z9) {
        this.f2205a = i10;
        this.f2206b = iArr;
        this.f2207c = objArr;
        this.e = z9;
    }

    public static v6 a() {
        return new v6(0, new int[8], new Object[8], true);
    }

    public final void b(c6 c6Var) {
        if (this.f2205a != 0) {
            for (int i10 = 0; i10 < this.f2205a; i10++) {
                int i11 = this.f2206b[i10];
                Object obj = this.f2207c[i10];
                int i12 = i11 & 7;
                int i13 = i11 >>> 3;
                if (i12 == 0) {
                    ((d5) c6Var.f1904a).g(i13, ((Long) obj).longValue());
                } else if (i12 == 1) {
                    ((d5) c6Var.f1904a).h(i13, ((Long) obj).longValue());
                } else if (i12 == 2) {
                    ((d5) c6Var.f1904a).i(i13, (c5) obj);
                } else if (i12 == 3) {
                    ((d5) c6Var.f1904a).c(i13, 3);
                    ((v6) obj).b(c6Var);
                    ((d5) c6Var.f1904a).c(i13, 4);
                } else {
                    if (i12 != 5) {
                        com.google.gson.internal.a.j(new v5());
                        return;
                    }
                    ((d5) c6Var.f1904a).f(i13, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int iS;
        int iA;
        int iS2;
        int i10 = this.f2208d;
        if (i10 != -1) {
            return i10;
        }
        int iN = 0;
        for (int i11 = 0; i11 < this.f2205a; i11++) {
            int i12 = this.f2206b[i11];
            int i13 = i12 >>> 3;
            int i14 = i12 & 7;
            if (i14 != 0) {
                if (i14 == 1) {
                    ((Long) this.f2207c[i11]).getClass();
                    iS2 = d5.s(i13 << 3) + 8;
                } else if (i14 == 2) {
                    int i15 = i13 << 3;
                    c5 c5Var = (c5) this.f2207c[i11];
                    int iS3 = d5.s(i15);
                    int iD = c5Var.d();
                    iN = androidx.constraintlayout.core.widgets.analyzer.a.n(iD, iD, iS3, iN);
                } else if (i14 == 3) {
                    int iS4 = d5.s(i13 << 3);
                    iS = iS4 + iS4;
                    iA = ((v6) this.f2207c[i11]).c();
                } else {
                    if (i14 != 5) {
                        throw new IllegalStateException(new v5());
                    }
                    ((Integer) this.f2207c[i11]).getClass();
                    iS2 = d5.s(i13 << 3) + 4;
                }
                iN = iS2 + iN;
            } else {
                int i16 = i13 << 3;
                long jLongValue = ((Long) this.f2207c[i11]).longValue();
                iS = d5.s(i16);
                iA = d5.a(jLongValue);
            }
            iN = iA + iS + iN;
        }
        this.f2208d = iN;
        return iN;
    }

    public final void d(int i10, Object obj) {
        if (!this.e) {
            p8.u.p();
            return;
        }
        e(this.f2205a + 1);
        int[] iArr = this.f2206b;
        int i11 = this.f2205a;
        iArr[i11] = i10;
        this.f2207c[i11] = obj;
        this.f2205a = i11 + 1;
    }

    public final void e(int i10) {
        int[] iArr = this.f2206b;
        if (i10 > iArr.length) {
            int i11 = this.f2205a;
            int i12 = (i11 / 2) + i11;
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f2206b = Arrays.copyOf(iArr, i10);
            this.f2207c = Arrays.copyOf(this.f2207c, i10);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof v6)) {
            v6 v6Var = (v6) obj;
            int i10 = this.f2205a;
            if (i10 == v6Var.f2205a) {
                int[] iArr = this.f2206b;
                int[] iArr2 = v6Var.f2206b;
                int i11 = 0;
                while (true) {
                    if (i11 >= i10) {
                        Object[] objArr = this.f2207c;
                        Object[] objArr2 = v6Var.f2207c;
                        int i12 = this.f2205a;
                        for (int i13 = 0; i13 < i12; i13++) {
                            if (objArr[i13].equals(objArr2[i13])) {
                            }
                        }
                        return true;
                    }
                    if (iArr[i11] != iArr2[i11]) {
                        break;
                    }
                    i11++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f2205a;
        int i11 = i10 + 527;
        int[] iArr = this.f2206b;
        int iHashCode = 17;
        int i12 = 17;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 = (i12 * 31) + iArr[i13];
        }
        int i14 = ((i11 * 31) + i12) * 31;
        Object[] objArr = this.f2207c;
        int i15 = this.f2205a;
        for (int i16 = 0; i16 < i15; i16++) {
            iHashCode = (iHashCode * 31) + objArr[i16].hashCode();
        }
        return i14 + iHashCode;
    }
}

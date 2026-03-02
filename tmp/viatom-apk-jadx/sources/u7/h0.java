package u7;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class h0 extends v7.b implements b0, h, v7.i {

    /* renamed from: d, reason: collision with root package name */
    public final int f13003d;
    public Object[] e;
    public long f;
    public long g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f13004i;

    public h0(int i10) {
        this.f13003d = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007f A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #0 {all -> 0x0036, blocks: (B:15:0x002f, B:32:0x0075, B:35:0x007f, B:39:0x0092, B:42:0x0099, B:43:0x009d, B:44:0x009e, B:22:0x0047), top: B:51:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v1, types: [v7.b] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [u7.h0] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [u7.i] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [v7.d] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [u7.j0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [u7.j0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00ac -> B:16:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(u7.h0 r8, u7.i r9, w6.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof u7.g0
            if (r0 == 0) goto L13
            r0 = r10
            u7.g0 r0 = (u7.g0) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.g = r1
            goto L18
        L13:
            u7.g0 r0 = new u7.g0
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.e
            int r1 = r0.g
            r2 = 3
            r3 = 2
            if (r1 == 0) goto L5a
            r8 = 1
            if (r1 == r8) goto L4b
            if (r1 == r3) goto L3f
            if (r1 != r2) goto L39
            r7.a1 r8 = r0.f13002d
            u7.j0 r9 = r0.f13001c
            u7.i r1 = r0.f13000b
            u7.h0 r4 = r0.f12999a
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L36
        L32:
            r10 = r1
            r1 = r8
            r8 = r4
            goto L72
        L36:
            r8 = move-exception
            goto Lb2
        L39:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            return
        L3f:
            r7.a1 r8 = r0.f13002d
            u7.j0 r9 = r0.f13001c
            u7.i r1 = r0.f13000b
            u7.h0 r4 = r0.f12999a
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L36
            goto L75
        L4b:
            u7.j0 r9 = r0.f13001c
            u7.i r8 = r0.f13000b
            u7.h0 r1 = r0.f12999a
            s6.a.e(r10)     // Catch: java.lang.Throwable -> L57
            r10 = r8
            r8 = r1
            goto L66
        L57:
            r8 = move-exception
            r4 = r1
            goto Lb2
        L5a:
            s6.a.e(r10)
            v7.d r10 = r8.b()
            u7.j0 r10 = (u7.j0) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L66:
            w6.h r1 = r0.getContext()     // Catch: java.lang.Throwable -> Laf
            r7.t r4 = r7.t.f12437b     // Catch: java.lang.Throwable -> Laf
            w6.f r1 = r1.get(r4)     // Catch: java.lang.Throwable -> Laf
            r7.a1 r1 = (r7.a1) r1     // Catch: java.lang.Throwable -> Laf
        L72:
            r4 = r8
            r8 = r1
            r1 = r10
        L75:
            java.lang.Object r10 = r4.p(r9)     // Catch: java.lang.Throwable -> L36
            e2.a r5 = u7.i0.f13005a     // Catch: java.lang.Throwable -> L36
            x6.a r6 = x6.a.f13718a
            if (r10 != r5) goto L90
            r0.f12999a = r4     // Catch: java.lang.Throwable -> L36
            r0.f13000b = r1     // Catch: java.lang.Throwable -> L36
            r0.f13001c = r9     // Catch: java.lang.Throwable -> L36
            r0.f13002d = r8     // Catch: java.lang.Throwable -> L36
            r0.g = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r4.f(r9, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L75
            goto Lae
        L90:
            if (r8 == 0) goto L9e
            boolean r5 = r8.isActive()     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L99
            goto L9e
        L99:
            java.util.concurrent.CancellationException r8 = r8.e()     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L9e:
            r0.f12999a = r4     // Catch: java.lang.Throwable -> L36
            r0.f13000b = r1     // Catch: java.lang.Throwable -> L36
            r0.f13001c = r9     // Catch: java.lang.Throwable -> L36
            r0.f13002d = r8     // Catch: java.lang.Throwable -> L36
            r0.g = r2     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L32
        Lae:
            return
        Laf:
            r10 = move-exception
            r4 = r8
            r8 = r10
        Lb2:
            r4.e(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: u7.h0.h(u7.h0, u7.i, w6.c):void");
    }

    @Override // v7.i
    public final h a(w6.h hVar, int i10, t7.a aVar) {
        return ((i10 == 0 || i10 == -3) && aVar == t7.a.f12813a) ? this : new d((Object) this, hVar, i10, aVar, 1);
    }

    @Override // v7.b
    public final v7.d c() {
        j0 j0Var = new j0();
        j0Var.f13012a = -1L;
        return j0Var;
    }

    @Override // u7.h
    public final Object collect(i iVar, w6.c cVar) throws Throwable {
        h(this, iVar, cVar);
        return x6.a.f13718a;
    }

    @Override // v7.b
    public final v7.d[] d() {
        return new j0[2];
    }

    @Override // u7.b0, u7.i
    public final Object emit(Object obj, w6.c cVar) throws Throwable {
        int i10;
        boolean z9;
        w6.c[] cVarArrK = v7.c.f13177a;
        synchronized (this) {
            if (n(obj)) {
                cVarArrK = k(cVarArrK);
                z9 = true;
            } else {
                z9 = false;
            }
        }
        for (w6.c cVar2 : cVarArrK) {
            if (cVar2 != null) {
                cVar2.resumeWith(s6.w.f12711a);
            }
        }
        if (z9) {
            return s6.w.f12711a;
        }
        Object objI = i(obj, cVar);
        return objI == x6.a.f13718a ? objI : s6.w.f12711a;
    }

    public final Object f(j0 j0Var, g0 g0Var) {
        r7.g gVar = new r7.g(1, r0.f.F(g0Var));
        gVar.s();
        synchronized (this) {
            try {
                if (o(j0Var) < 0) {
                    j0Var.f13013b = gVar;
                } else {
                    gVar.resumeWith(s6.w.f12711a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
    }

    public final void g() {
        if (this.f13003d != 0 || this.f13004i > 1) {
            Object[] objArr = this.e;
            objArr.getClass();
            while (this.f13004i > 0) {
                long jL = l();
                int i10 = this.h;
                int i11 = this.f13004i;
                if (objArr[((int) ((jL + (i10 + i11)) - 1)) & (objArr.length - 1)] != i0.f13005a) {
                    return;
                }
                this.f13004i = i11 - 1;
                i0.c(objArr, l() + this.h + this.f13004i, null);
            }
        }
    }

    public final Object i(Object obj, w6.c cVar) throws Throwable {
        Throwable th;
        w6.c[] cVarArrK;
        f0 f0Var;
        r7.g gVar = new r7.g(1, r0.f.F(cVar));
        gVar.s();
        w6.c[] cVarArrK2 = v7.c.f13177a;
        synchronized (this) {
            try {
                if (n(obj)) {
                    try {
                        gVar.resumeWith(s6.w.f12711a);
                        cVarArrK = k(cVarArrK2);
                        f0Var = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        f0 f0Var2 = new f0(this, l() + this.h + this.f13004i, obj, gVar);
                        j(f0Var2);
                        this.f13004i++;
                        if (this.f13003d == 0) {
                            cVarArrK2 = k(cVarArrK2);
                        }
                        cVarArrK = cVarArrK2;
                        f0Var = f0Var2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (f0Var != null) {
                    gVar.v(new r7.e(f0Var, 2));
                }
                for (w6.c cVar2 : cVarArrK) {
                    if (cVar2 != null) {
                        cVar2.resumeWith(s6.w.f12711a);
                    }
                }
                Object objQ = gVar.q();
                return objQ == x6.a.f13718a ? objQ : s6.w.f12711a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final void j(Object obj) {
        int i10 = this.h + this.f13004i;
        Object[] objArrM = this.e;
        if (objArrM == null) {
            objArrM = m(null, 0, 2);
        } else if (i10 >= objArrM.length) {
            objArrM = m(objArrM, i10, objArrM.length * 2);
        }
        i0.c(objArrM, l() + i10, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final w6.c[] k(w6.c[] cVarArr) {
        v7.d[] dVarArr;
        j0 j0Var;
        r7.g gVar;
        int length = cVarArr.length;
        if (this.f13175b != 0 && (dVarArr = this.f13174a) != null) {
            int length2 = dVarArr.length;
            int i10 = 0;
            cVarArr = cVarArr;
            while (i10 < length2) {
                v7.d dVar = dVarArr[i10];
                if (dVar != null && (gVar = (j0Var = (j0) dVar).f13013b) != null && o(j0Var) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        cVarArr = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                    }
                    cVarArr[length] = gVar;
                    j0Var.f13013b = null;
                    length++;
                }
                i10++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    public final long l() {
        return Math.min(this.g, this.f);
    }

    public final Object[] m(Object[] objArr, int i10, int i11) {
        if (i11 <= 0) {
            androidx.window.layout.c.g("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i11];
        this.e = objArr2;
        if (objArr != null) {
            long jL = l();
            for (int i12 = 0; i12 < i10; i12++) {
                long j10 = i12 + jL;
                i0.c(objArr2, j10, objArr[((int) j10) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean n(Object obj) {
        v7.d[] dVarArr;
        if (this.f13175b != 0) {
            int i10 = this.h;
            int i11 = this.f13003d;
            if (i10 >= i11 && this.g <= this.f) {
                return false;
            }
            j(obj);
            int i12 = this.h + 1;
            this.h = i12;
            if (i12 > i11) {
                Object[] objArr = this.e;
                objArr.getClass();
                i0.c(objArr, l(), null);
                this.h--;
                long jL = l() + 1;
                if (this.f < jL) {
                    this.f = jL;
                }
                if (this.g < jL) {
                    if (this.f13175b != 0 && (dVarArr = this.f13174a) != null) {
                        for (v7.d dVar : dVarArr) {
                            if (dVar != null) {
                                j0 j0Var = (j0) dVar;
                                long j10 = j0Var.f13012a;
                                if (j10 >= 0 && j10 < jL) {
                                    j0Var.f13012a = jL;
                                }
                            }
                        }
                    }
                    this.g = jL;
                }
            }
            long jL2 = l() + this.h;
            long j11 = this.f;
            if (((int) (jL2 - j11)) > 0) {
                q(1 + j11, this.g, l() + this.h, l() + this.h + this.f13004i);
            }
        }
        return true;
    }

    public final long o(j0 j0Var) {
        long j10 = j0Var.f13012a;
        if (j10 < l() + this.h) {
            return j10;
        }
        if (this.f13003d <= 0 && j10 <= l() && this.f13004i != 0) {
            return j10;
        }
        return -1L;
    }

    public final Object p(j0 j0Var) {
        Object obj;
        w6.c[] cVarArrR = v7.c.f13177a;
        synchronized (this) {
            try {
                long jO = o(j0Var);
                if (jO < 0) {
                    obj = i0.f13005a;
                } else {
                    long j10 = j0Var.f13012a;
                    Object[] objArr = this.e;
                    objArr.getClass();
                    Object obj2 = objArr[((int) jO) & (objArr.length - 1)];
                    if (obj2 instanceof f0) {
                        obj2 = ((f0) obj2).f12996c;
                    }
                    j0Var.f13012a = jO + 1;
                    Object obj3 = obj2;
                    cVarArrR = r(j10);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (w6.c cVar : cVarArrR) {
            if (cVar != null) {
                cVar.resumeWith(s6.w.f12711a);
            }
        }
        return obj;
    }

    public final void q(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jL = l(); jL < jMin; jL++) {
            Object[] objArr = this.e;
            objArr.getClass();
            i0.c(objArr, jL, null);
        }
        this.f = j10;
        this.g = j11;
        this.h = (int) (j12 - jMin);
        this.f13004i = (int) (j13 - j12);
    }

    public final w6.c[] r(long j10) {
        long j11;
        long j12;
        w6.c[] cVarArr;
        w6.c[] cVarArr2;
        long j13;
        v7.d[] dVarArr;
        e2.a aVar = i0.f13005a;
        w6.c[] cVarArr3 = v7.c.f13177a;
        if (j10 <= this.g) {
            long jL = l();
            long j14 = this.h + jL;
            int i10 = this.f13003d;
            if (i10 == 0 && this.f13004i > 0) {
                j14++;
            }
            if (this.f13175b != 0 && (dVarArr = this.f13174a) != null) {
                for (v7.d dVar : dVarArr) {
                    if (dVar != null) {
                        long j15 = ((j0) dVar).f13012a;
                        if (j15 >= 0 && j15 < j14) {
                            j14 = j15;
                        }
                    }
                }
            }
            if (j14 > this.g) {
                long jL2 = l() + this.h;
                int i11 = this.f13175b;
                int iMin = this.f13004i;
                if (i11 > 0) {
                    j11 = 1;
                    iMin = Math.min(iMin, i10 - ((int) (jL2 - j14)));
                } else {
                    j11 = 1;
                }
                long j16 = this.f13004i + jL2;
                if (iMin > 0) {
                    w6.c[] cVarArr4 = new w6.c[iMin];
                    Object[] objArr = this.e;
                    objArr.getClass();
                    long j17 = jL2;
                    int i12 = 0;
                    while (true) {
                        if (jL2 >= j16) {
                            cVarArr2 = cVarArr4;
                            j12 = jL;
                            j13 = j17;
                            break;
                        }
                        cVarArr2 = cVarArr4;
                        Object obj = objArr[(objArr.length - 1) & ((int) jL2)];
                        if (obj != aVar) {
                            obj.getClass();
                            f0 f0Var = (f0) obj;
                            int i13 = i12 + 1;
                            j12 = jL;
                            cVarArr2[i12] = f0Var.f12997d;
                            i0.c(objArr, jL2, aVar);
                            long j18 = j17;
                            i0.c(objArr, j18, f0Var.f12996c);
                            j13 = j18 + j11;
                            if (i13 >= iMin) {
                                break;
                            }
                            i12 = i13;
                            j17 = j13;
                        } else {
                            j12 = jL;
                        }
                        jL2 += j11;
                        cVarArr4 = cVarArr2;
                        jL = j12;
                    }
                    jL2 = j13;
                    cVarArr = cVarArr2;
                } else {
                    j12 = jL;
                    cVarArr = cVarArr3;
                }
                int i14 = (int) (jL2 - j12);
                long j19 = this.f13175b == 0 ? jL2 : j14;
                long jMax = Math.max(this.f, jL2 - Math.min(0, i14));
                if (i10 == 0 && jMax < j16) {
                    Object[] objArr2 = this.e;
                    objArr2.getClass();
                    if (kotlin.jvm.internal.l.a(objArr2[((int) jMax) & (objArr2.length - 1)], aVar)) {
                        jL2 += j11;
                        jMax += j11;
                    }
                }
                q(jMax, j19, jL2, j16);
                g();
                return cVarArr.length == 0 ? cVarArr : k(cVarArr);
            }
        }
        return cVarArr3;
    }
}

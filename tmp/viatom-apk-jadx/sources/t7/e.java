package t7;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.a0;
import r7.x1;
import r7.y;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class e implements i {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f12826b = AtomicLongFieldUpdater.newUpdater(e.class, "sendersAndCloseStatus$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f12827c = AtomicLongFieldUpdater.newUpdater(e.class, "receivers$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f12828d = AtomicLongFieldUpdater.newUpdater(e.class, "bufferEnd$volatile");
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(e.class, "completedExpandBuffersAndPauseFlag$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "sendSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "receiveSegment$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "bufferEndSegment$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12829i = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_closeCause$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12830j = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "closeHandler$volatile");
    private volatile /* synthetic */ Object _closeCause$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f12831a;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;

    public e(int i10) {
        this.f12831a = i10;
        if (i10 < 0) {
            z8.f.b(a3.a.g(i10, "Invalid channel capacity: ", ", should be >=0"));
            throw null;
        }
        m mVar = g.f12833a;
        this.bufferEnd$volatile = i10 != 0 ? i10 != Integer.MAX_VALUE ? i10 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag$volatile = f12828d.get(this);
        m mVar2 = new m(0L, null, this, 3);
        this.sendSegment$volatile = mVar2;
        this.receiveSegment$volatile = mVar2;
        if (z()) {
            mVar2 = g.f12833a;
            mVar2.getClass();
        }
        this.bufferEndSegment$volatile = mVar2;
        this._closeCause$volatile = g.f12847s;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object C(t7.e r13, y6.c r14) {
        /*
            boolean r0 = r14 instanceof t7.c
            if (r0 == 0) goto L14
            r0 = r14
            t7.c r0 = (t7.c) r0
            int r1 = r0.f12822c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f12822c = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            t7.c r0 = new t7.c
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.f12820a
            int r0 = r6.f12822c
            r1 = 1
            if (r0 == 0) goto L32
            if (r0 != r1) goto L2b
            s6.a.e(r14)
            t7.l r14 = (t7.l) r14
            java.lang.Object r13 = r14.f12853a
            return r13
        L2b:
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r13)
            r13 = 0
            return r13
        L32:
            s6.a.e(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = t7.e.g
            java.lang.Object r14 = r14.get(r13)
            t7.m r14 = (t7.m) r14
        L3d:
            boolean r0 = r13.w()
            if (r0 == 0) goto L4d
            java.lang.Throwable r13 = r13.n()
            t7.j r14 = new t7.j
            r14.<init>(r13)
            return r14
        L4d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = t7.e.f12827c
            long r4 = r0.getAndIncrement(r13)
            int r0 = t7.g.f12834b
            long r2 = (long) r0
            long r7 = r4 / r2
            long r2 = r4 % r2
            int r3 = (int) r2
            long r9 = r14.f13555c
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 == 0) goto L6a
            t7.m r0 = r13.m(r7, r14)
            if (r0 != 0) goto L68
            goto L3d
        L68:
            r2 = r0
            goto L6b
        L6a:
            r2 = r14
        L6b:
            r12 = 0
            r7 = r13
            r8 = r2
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.H(r8, r9, r10, r12)
            e2.a r14 = t7.g.f12841m
            if (r13 == r14) goto L9f
            e2.a r14 = t7.g.f12843o
            if (r13 != r14) goto L8a
            long r13 = r7.t()
            int r13 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r13 >= 0) goto L87
            r2.a()
        L87:
            r14 = r2
            r13 = r7
            goto L3d
        L8a:
            e2.a r14 = t7.g.f12842n
            if (r13 != r14) goto L9b
            r6.f12822c = r1
            r1 = r7
            java.lang.Object r13 = r1.D(r2, r3, r4, r6)
            x6.a r14 = x6.a.f13718a
            if (r13 != r14) goto L9a
            return r14
        L9a:
            return r13
        L9b:
            r2.a()
            return r13
        L9f:
            java.lang.String r13 = "unexpected"
            androidx.window.layout.c.g(r13)
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.C(t7.e, y6.c):java.lang.Object");
    }

    public static boolean G(Object obj) {
        if (obj instanceof r7.f) {
            return g.a((r7.f) obj, w.f12711a, null);
        }
        if (obj instanceof a8.f) {
            com.google.gson.internal.a.k();
            return false;
        }
        p8.u.i(obj, "Unexpected waiter: ");
        return false;
    }

    public static final m b(e eVar, long j10, m mVar) {
        Object objB;
        e eVar2;
        m mVar2 = g.f12833a;
        f fVar = f.f12832a;
        loop0: while (true) {
            objB = w7.a.b(mVar, j10, fVar);
            if (!w7.a.e(objB)) {
                w7.s sVarC = w7.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
                    w7.s sVar = (w7.s) atomicReferenceFieldUpdater.get(eVar);
                    if (sVar.f13555c >= sVarC.f13555c) {
                        break loop0;
                    }
                    if (!sVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(eVar, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(eVar) != sVar) {
                            if (sVarC.e()) {
                                sVarC.d();
                            }
                        }
                    }
                    if (sVar.e()) {
                        sVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zE = w7.a.e(objB);
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12827c;
        if (zE) {
            eVar.x();
            if (mVar.f13555c * g.f12834b < atomicLongFieldUpdater.get(eVar)) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) w7.a.c(objB);
            long j11 = mVar3.f13555c;
            if (j11 <= j10) {
                return mVar3;
            }
            long j12 = g.f12834b * j11;
            while (true) {
                long j13 = f12826b.get(eVar);
                long j14 = 1152921504606846975L & j13;
                if (j14 >= j12) {
                    eVar2 = eVar;
                    break;
                }
                eVar2 = eVar;
                if (f12826b.compareAndSet(eVar2, j13, (((int) (j13 >> 60)) << 60) + j14)) {
                    break;
                }
                eVar = eVar2;
            }
            if (j11 * g.f12834b < atomicLongFieldUpdater.get(eVar2)) {
                mVar3.a();
            }
        }
        return null;
    }

    public static final void c(e eVar, Object obj, r7.g gVar) {
        gVar.resumeWith(new s6.j(eVar.s()));
    }

    public static final int d(e eVar, m mVar, int i10, Object obj, long j10, Object obj2, boolean z9) {
        mVar.m(i10, obj);
        if (z9) {
            return eVar.I(mVar, i10, obj, j10, obj2, z9);
        }
        Object objK = mVar.k(i10);
        if (objK == null) {
            if (eVar.e(j10)) {
                if (mVar.j(i10, null, g.f12836d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (mVar.j(i10, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof x1) {
            mVar.m(i10, null);
            if (eVar.F(objK, obj)) {
                mVar.n(i10, g.f12837i);
                return 0;
            }
            e2.a aVar = g.f12839k;
            if (mVar.f.getAndSet((i10 * 2) + 1, aVar) == aVar) {
                return 5;
            }
            mVar.l(i10, true);
            return 5;
        }
        return eVar.I(mVar, i10, obj, j10, obj2, z9);
    }

    public static void u(e eVar) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = e;
        if ((atomicLongFieldUpdater.addAndGet(eVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(eVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(long r5, t7.m r7) {
        /*
            r4 = this;
        L0:
            long r0 = r7.f13555c
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L11
            w7.b r0 = r7.b()
            t7.m r0 = (t7.m) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r7 = r0
            goto L0
        L11:
            boolean r5 = r7.c()
            if (r5 == 0) goto L22
            w7.b r5 = r7.b()
            t7.m r5 = (t7.m) r5
            if (r5 != 0) goto L20
            goto L22
        L20:
            r7 = r5
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = t7.e.h
            java.lang.Object r6 = r5.get(r4)
            w7.s r6 = (w7.s) r6
            long r0 = r6.f13555c
            long r2 = r7.f13555c
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r7.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r5.compareAndSet(r4, r6, r7)
            if (r0 == 0) goto L4a
            boolean r5 = r6.e()
            if (r5 == 0) goto L49
            r6.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r5.get(r4)
            if (r0 == r6) goto L3a
            boolean r5 = r7.e()
            if (r5 == 0) goto L22
            r7.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.A(long, t7.m):void");
    }

    public final Object B(Object obj, w6.c cVar) {
        r7.g gVar = new r7.g(1, r0.f.F(cVar));
        gVar.s();
        gVar.resumeWith(new s6.j(s()));
        Object objQ = gVar.q();
        return objQ == x6.a.f13718a ? objQ : w.f12711a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object D(t7.m r14, int r15, long r16, y6.c r18) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.D(t7.m, int, long, y6.c):java.lang.Object");
    }

    public final void E(x1 x1Var, boolean z9) {
        if (x1Var instanceof r7.f) {
            ((w6.c) x1Var).resumeWith(new s6.j(z9 ? r() : s()));
            return;
        }
        if (x1Var instanceof t) {
            ((t) x1Var).f12860a.resumeWith(new l(new j(n())));
            return;
        }
        if (!(x1Var instanceof b)) {
            if (x1Var instanceof a8.f) {
                ((a8.f) x1Var).c(this, g.f12840l);
                return;
            } else {
                p8.u.i(x1Var, "Unexpected waiter: ");
                return;
            }
        }
        b bVar = (b) x1Var;
        r7.g gVar = bVar.f12818b;
        gVar.getClass();
        bVar.f12818b = null;
        bVar.f12817a = g.f12840l;
        Throwable thN = bVar.f12819c.n();
        if (thN == null) {
            gVar.resumeWith(Boolean.FALSE);
        } else {
            gVar.resumeWith(new s6.j(thN));
        }
    }

    public final boolean F(Object obj, Object obj2) {
        if (obj instanceof a8.f) {
            return ((a8.f) obj).c(this, obj2);
        }
        if (obj instanceof t) {
            return g.a(((t) obj).f12860a, new l(obj2), null);
        }
        if (!(obj instanceof b)) {
            if (obj instanceof r7.f) {
                return g.a((r7.f) obj, obj2, null);
            }
            p8.u.i(obj, "Unexpected receiver type: ");
            return false;
        }
        b bVar = (b) obj;
        r7.g gVar = bVar.f12818b;
        gVar.getClass();
        bVar.f12818b = null;
        bVar.f12817a = obj2;
        return g.a(gVar, Boolean.TRUE, null);
    }

    public final Object H(m mVar, int i10, long j10, Object obj) {
        Object objK = mVar.k(i10);
        AtomicReferenceArray atomicReferenceArray = mVar.f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12826b;
        if (objK == null) {
            if (j10 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return g.f12842n;
                }
                if (mVar.j(i10, objK, obj)) {
                    j();
                    return g.f12841m;
                }
            }
        } else if (objK == g.f12836d && mVar.j(i10, objK, g.f12837i)) {
            j();
            Object obj2 = atomicReferenceArray.get(i10 * 2);
            mVar.m(i10, null);
            return obj2;
        }
        while (true) {
            Object objK2 = mVar.k(i10);
            if (objK2 == null || objK2 == g.e) {
                if (j10 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (mVar.j(i10, objK2, g.h)) {
                        j();
                        return g.f12843o;
                    }
                } else {
                    if (obj == null) {
                        return g.f12842n;
                    }
                    if (mVar.j(i10, objK2, obj)) {
                        j();
                        return g.f12841m;
                    }
                }
            } else if (objK2 != g.f12836d) {
                e2.a aVar = g.f12838j;
                if (objK2 == aVar) {
                    return g.f12843o;
                }
                if (objK2 == g.h) {
                    return g.f12843o;
                }
                if (objK2 == g.f12840l) {
                    j();
                    return g.f12843o;
                }
                if (objK2 != g.g && mVar.j(i10, objK2, g.f)) {
                    boolean z9 = objK2 instanceof v;
                    if (z9) {
                        objK2 = ((v) objK2).f12861a;
                    }
                    if (G(objK2)) {
                        mVar.n(i10, g.f12837i);
                        j();
                        Object obj3 = atomicReferenceArray.get(i10 * 2);
                        mVar.m(i10, null);
                        return obj3;
                    }
                    mVar.n(i10, aVar);
                    mVar.h();
                    if (z9) {
                        j();
                    }
                    return g.f12843o;
                }
            } else if (mVar.j(i10, objK2, g.f12837i)) {
                j();
                Object obj4 = atomicReferenceArray.get(i10 * 2);
                mVar.m(i10, null);
                return obj4;
            }
        }
    }

    public final int I(m mVar, int i10, Object obj, long j10, Object obj2, boolean z9) {
        while (true) {
            Object objK = mVar.k(i10);
            if (objK == null) {
                if (!e(j10) || z9) {
                    if (z9) {
                        if (mVar.j(i10, null, g.f12838j)) {
                            mVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (mVar.j(i10, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (mVar.j(i10, null, g.f12836d)) {
                    break;
                }
            } else {
                if (objK != g.e) {
                    e2.a aVar = g.f12839k;
                    if (objK == aVar) {
                        mVar.m(i10, null);
                        return 5;
                    }
                    if (objK == g.h) {
                        mVar.m(i10, null);
                        return 5;
                    }
                    if (objK == g.f12840l) {
                        mVar.m(i10, null);
                        x();
                        return 4;
                    }
                    mVar.m(i10, null);
                    if (objK instanceof v) {
                        objK = ((v) objK).f12861a;
                    }
                    if (F(objK, obj)) {
                        mVar.n(i10, g.f12837i);
                        return 0;
                    }
                    if (mVar.f.getAndSet((i10 * 2) + 1, aVar) != aVar) {
                        mVar.l(i10, true);
                    }
                    return 5;
                }
                if (mVar.j(i10, objK, g.f12836d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void J(long j10) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        e eVar = this;
        if (eVar.z()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = f12828d;
            if (atomicLongFieldUpdater.get(eVar) > j10) {
                break;
            } else {
                eVar = this;
            }
        }
        int i10 = g.f12835c;
        int i11 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = e;
            if (i11 < i10) {
                long j11 = atomicLongFieldUpdater.get(eVar);
                if (j11 == (4611686018427387903L & atomicLongFieldUpdater2.get(eVar)) && j11 == atomicLongFieldUpdater.get(eVar)) {
                    return;
                } else {
                    i11++;
                }
            } else {
                while (true) {
                    long j12 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j12, (j12 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        eVar = this;
                    }
                }
                while (true) {
                    long j13 = atomicLongFieldUpdater.get(eVar);
                    long j14 = atomicLongFieldUpdater2.get(eVar);
                    long j15 = j14 & 4611686018427387903L;
                    boolean z9 = (j14 & 4611686018427387904L) != 0;
                    if (j13 == j15 && j13 == atomicLongFieldUpdater.get(eVar)) {
                        break;
                    }
                    if (z9) {
                        eVar = this;
                    } else {
                        eVar = this;
                        atomicLongFieldUpdater2.compareAndSet(eVar, j14, 4611686018427387904L + j15);
                    }
                }
                while (true) {
                    long j16 = atomicLongFieldUpdater2.get(eVar);
                    if (atomicLongFieldUpdater2.compareAndSet(eVar, j16, j16 & 4611686018427387903L)) {
                        return;
                    } else {
                        eVar = this;
                    }
                }
            }
        }
    }

    @Override // t7.i
    public final void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        f(true, cancellationException);
    }

    public final boolean e(long j10) {
        return j10 < f12828d.get(this) || j10 < f12827c.get(this) + ((long) this.f12831a);
    }

    public final boolean f(boolean z9, Throwable th) {
        e eVar;
        boolean z10;
        long j10;
        long j11;
        long j12;
        Object obj;
        long j13;
        long j14;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12826b;
        if (!z9) {
            eVar = this;
            break;
        }
        do {
            j14 = atomicLongFieldUpdater.get(this);
            if (((int) (j14 >> 60)) != 0) {
                eVar = this;
                break;
            }
            m mVar = g.f12833a;
            eVar = this;
        } while (!atomicLongFieldUpdater.compareAndSet(eVar, j14, (j14 & 1152921504606846975L) + (1 << 60)));
        e2.a aVar = g.f12847s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f12829i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, aVar, th)) {
                z10 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != aVar) {
                z10 = false;
                break;
            }
        }
        if (z9) {
            do {
                j13 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(eVar, j13, (3 << 60) + (j13 & 1152921504606846975L)));
        } else {
            do {
                j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 >> 60);
                if (i10 == 0) {
                    j11 = j10 & 1152921504606846975L;
                    j12 = 2;
                } else {
                    if (i10 != 1) {
                        break;
                    }
                    j11 = j10 & 1152921504606846975L;
                    j12 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(eVar, j10, (j12 << 60) + j11));
        }
        x();
        if (z10) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f12830j;
                obj = atomicReferenceFieldUpdater2.get(this);
                e2.a aVar2 = obj == null ? g.f12845q : g.f12846r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, aVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                a0.b(1, obj);
                ((g7.l) obj).invoke(n());
                return z10;
            }
        }
        return z10;
    }

    @Override // t7.i
    public final Object g() {
        m mVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f12827c;
        long j10 = atomicLongFieldUpdater.get(this);
        long j11 = f12826b.get(this);
        if (v(j11, true)) {
            return new j(n());
        }
        long j12 = j11 & 1152921504606846975L;
        k kVar = l.f12852b;
        if (j10 >= j12) {
            return kVar;
        }
        Object obj = g.f12839k;
        m mVar2 = (m) g.get(this);
        while (!w()) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j13 = g.f12834b;
            long j14 = andIncrement / j13;
            int i10 = (int) (andIncrement % j13);
            if (mVar2.f13555c != j14) {
                m mVarM = m(j14, mVar2);
                if (mVarM == null) {
                    continue;
                } else {
                    mVar = mVarM;
                }
            } else {
                mVar = mVar2;
            }
            Object objH = H(mVar, i10, andIncrement, obj);
            m mVar3 = mVar;
            if (objH == g.f12841m) {
                x1 x1Var = obj instanceof x1 ? (x1) obj : null;
                if (x1Var != null) {
                    x1Var.a(mVar3, i10);
                }
                J(andIncrement);
                mVar3.h();
                return kVar;
            }
            if (objH != g.f12843o) {
                if (objH != g.f12842n) {
                    mVar3.a();
                    return objH;
                }
                androidx.window.layout.c.g("unexpected");
                return null;
            }
            if (andIncrement < t()) {
                mVar3.a();
            }
            mVar2 = mVar3;
        }
        return new j(n());
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x008d, code lost:
    
        r1 = (t7.m) ((w7.b) w7.b.f13529b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t7.m h(long r13) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.h(long):t7.m");
    }

    public final void i(long j10) {
        m mVar = (m) g.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f12827c;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(this.f12831a + j11, f12828d.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, 1 + j11)) {
                long j12 = g.f12834b;
                long j13 = j11 / j12;
                int i10 = (int) (j11 % j12);
                if (mVar.f13555c != j13) {
                    m mVarM = m(j13, mVar);
                    if (mVarM != null) {
                        mVar = mVarM;
                    }
                }
                m mVar2 = mVar;
                if (H(mVar2, i10, j11, null) != g.f12843o || j11 < t()) {
                    mVar2.a();
                }
                mVar = mVar2;
            }
        }
    }

    @Override // t7.i
    public final b iterator() {
        return new b(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x017b, code lost:
    
        u(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x017e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.j():void");
    }

    @Override // t7.u
    public final boolean k(Throwable th) {
        return f(false, th);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0177, code lost:
    
        return r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c2, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163 A[RETURN] */
    @Override // t7.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object l(java.lang.Object r23, w6.c r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 381
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.l(java.lang.Object, w6.c):java.lang.Object");
    }

    public final m m(long j10, m mVar) {
        Object objB;
        long j11;
        m mVar2 = g.f12833a;
        f fVar = f.f12832a;
        loop0: while (true) {
            objB = w7.a.b(mVar, j10, fVar);
            if (!w7.a.e(objB)) {
                w7.s sVarC = w7.a.c(objB);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
                    w7.s sVar = (w7.s) atomicReferenceFieldUpdater.get(this);
                    if (sVar.f13555c >= sVarC.f13555c) {
                        break loop0;
                    }
                    if (!sVarC.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, sVar, sVarC)) {
                        if (atomicReferenceFieldUpdater.get(this) != sVar) {
                            if (sVarC.e()) {
                                sVarC.d();
                            }
                        }
                    }
                    if (sVar.e()) {
                        sVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (w7.a.e(objB)) {
            x();
            if (mVar.f13555c * g.f12834b < t()) {
                mVar.a();
                return null;
            }
        } else {
            m mVar3 = (m) w7.a.c(objB);
            long j12 = mVar3.f13555c;
            if (!z() && j10 <= f12828d.get(this) / g.f12834b) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = h;
                    w7.s sVar2 = (w7.s) atomicReferenceFieldUpdater2.get(this);
                    if (sVar2.f13555c >= j12 || !mVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, sVar2, mVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != sVar2) {
                            if (mVar3.e()) {
                                mVar3.d();
                            }
                        }
                    }
                    if (sVar2.e()) {
                        sVar2.d();
                    }
                }
            }
            if (j12 <= j10) {
                return mVar3;
            }
            long j13 = j12 * g.f12834b;
            do {
                j11 = f12827c.get(this);
                if (j11 >= j13) {
                    break;
                }
            } while (!f12827c.compareAndSet(this, j11, j13));
            if (j12 * g.f12834b < t()) {
                mVar3.a();
            }
        }
        return null;
    }

    public final Throwable n() {
        return (Throwable) f12829i.get(this);
    }

    @Override // t7.i
    public final Object o(v7.g gVar) {
        return C(this, gVar);
    }

    @Override // t7.i
    public final Object p(w6.c cVar) throws Throwable {
        m mVar;
        Throwable th;
        m mVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
        m mVar3 = (m) atomicReferenceFieldUpdater.get(this);
        while (!w()) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f12827c;
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j10 = g.f12834b;
            long j11 = andIncrement / j10;
            int i10 = (int) (andIncrement % j10);
            if (mVar3.f13555c != j11) {
                m mVarM = m(j11, mVar3);
                if (mVarM == null) {
                    continue;
                } else {
                    mVar = mVarM;
                }
            } else {
                mVar = mVar3;
            }
            Object objH = H(mVar, i10, andIncrement, null);
            e2.a aVar = g.f12841m;
            if (objH == aVar) {
                androidx.window.layout.c.g("unexpected");
                return null;
            }
            e2.a aVar2 = g.f12843o;
            if (objH == aVar2) {
                if (andIncrement < t()) {
                    mVar.a();
                }
                mVar3 = mVar;
            } else {
                if (objH != g.f12842n) {
                    mVar.a();
                    return objH;
                }
                r7.g gVarN = y.n(r0.f.F(cVar));
                e eVar = this;
                try {
                    Object objH2 = eVar.H(mVar, i10, andIncrement, gVarN);
                    if (objH2 == aVar) {
                        gVarN.a(mVar, i10);
                    } else {
                        if (objH2 == aVar2) {
                            if (andIncrement < t()) {
                                mVar.a();
                            }
                            m mVar4 = (m) atomicReferenceFieldUpdater.get(this);
                            while (true) {
                                if (w()) {
                                    gVarN.resumeWith(new s6.j(r()));
                                    break;
                                }
                                r7.g gVar = gVarN;
                                try {
                                    long andIncrement2 = atomicLongFieldUpdater.getAndIncrement(this);
                                    long j12 = g.f12834b;
                                    long j13 = andIncrement2 / j12;
                                    int i11 = (int) (andIncrement2 % j12);
                                    if (mVar4.f13555c != j13) {
                                        try {
                                            m mVarM2 = m(j13, mVar4);
                                            if (mVarM2 == null) {
                                                gVarN = gVar;
                                            } else {
                                                mVar2 = mVarM2;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            gVarN = gVar;
                                            gVarN.z();
                                            throw th;
                                        }
                                    } else {
                                        mVar2 = mVar4;
                                    }
                                    objH2 = eVar.H(mVar2, i11, andIncrement2, gVar);
                                    m mVar5 = mVar2;
                                    gVarN = gVar;
                                    if (objH2 == g.f12841m) {
                                        gVarN.a(mVar5, i11);
                                        break;
                                    }
                                    if (objH2 == g.f12843o) {
                                        if (andIncrement2 < t()) {
                                            mVar5.a();
                                        }
                                        eVar = this;
                                        mVar4 = mVar5;
                                    } else {
                                        if (objH2 == g.f12842n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        mVar5.a();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    gVarN = gVar;
                                    th = th;
                                    gVarN.z();
                                    throw th;
                                }
                            }
                        } else {
                            mVar.a();
                        }
                        gVarN.c(objH2, null);
                    }
                    return gVarN.q();
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        Throwable thR = r();
        int i12 = w7.t.f13556a;
        throw thR;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bd A[SYNTHETIC] */
    @Override // t7.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object q(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = t7.e.f12826b
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.v(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = r9
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.e(r1)
            r1 = r1 ^ r10
        L1b:
            t7.k r13 = t7.l.f12852b
            if (r1 == 0) goto L20
            return r13
        L20:
            e2.a r6 = t7.g.f12838j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = t7.e.f
            java.lang.Object r1 = r1.get(r15)
            t7.m r1 = (t7.m) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.v(r2, r9)
            int r14 = t7.g.f12834b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.f13555c
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            t7.m r3 = b(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        L54:
            r9 = 0
            r10 = 1
        L56:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r9 = d(r0, r1, r2, r3, r4, r6, r7)
            s6.w r3 = s6.w.f12711a
            if (r9 == 0) goto Lbd
            r10 = 1
            if (r9 == r10) goto Lbc
            r3 = 2
            if (r9 == r3) goto L9b
            r2 = 3
            if (r9 == r2) goto L94
            r2 = 4
            if (r9 == r2) goto L7d
            r2 = 5
            if (r9 == r2) goto L78
            goto L7b
        L78:
            r1.a()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = t7.e.f12827c
            long r2 = r2.get(r15)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r1.a()
        L8a:
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        L94:
            java.lang.String r1 = "unexpected"
            androidx.window.layout.c.g(r1)
            r1 = 0
            return r1
        L9b:
            if (r7 == 0) goto Laa
            r1.h()
            java.lang.Throwable r1 = r15.s()
            t7.j r2 = new t7.j
            r2.<init>(r1)
            return r2
        Laa:
            boolean r3 = r6 instanceof r7.x1
            if (r3 == 0) goto Lb1
            r7.x1 r6 = (r7.x1) r6
            goto Lb2
        Lb1:
            r6 = 0
        Lb2:
            if (r6 == 0) goto Lb8
            int r2 = r2 + r14
            r6.a(r1, r2)
        Lb8:
            r1.h()
            return r13
        Lbc:
            return r3
        Lbd:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.q(java.lang.Object):java.lang.Object");
    }

    public final Throwable r() {
        Throwable thN = n();
        return thN == null ? new n("Channel was closed") : thN;
    }

    public final Throwable s() {
        Throwable thN = n();
        return thN == null ? new h1.b("Channel was closed") : thN;
    }

    public final long t() {
        return f12826b.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x01b9, code lost:
    
        r16 = r7;
        r3 = (t7.m) r3.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c2, code lost:
    
        if (r3 != null) goto L96;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.toString():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a2, code lost:
    
        r0 = (t7.m) ((w7.b) w7.b.f13529b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(long r14, boolean r16) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.e.v(long, boolean):boolean");
    }

    public final boolean w() {
        return v(f12826b.get(this), true);
    }

    public final boolean x() {
        return v(f12826b.get(this), false);
    }

    public boolean y() {
        return false;
    }

    public final boolean z() {
        long j10 = f12828d.get(this);
        return j10 == 0 || j10 == Long.MAX_VALUE;
    }
}

package r7;

import androidx.room.coroutines.ConnectionPoolImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final e2.a f12449a = new e2.a("RESUME_TOKEN");

    /* renamed from: b, reason: collision with root package name */
    public static final e2.a f12450b = new e2.a("REMOVED_TASK");

    /* renamed from: c, reason: collision with root package name */
    public static final e2.a f12451c = new e2.a("CLOSED_EMPTY");

    /* renamed from: d, reason: collision with root package name */
    public static final e2.a f12452d = new e2.a("COMPLETING_ALREADY");
    public static final e2.a e = new e2.a("COMPLETING_WAITING_CHILDREN");
    public static final e2.a f = new e2.a("COMPLETING_RETRY");
    public static final e2.a g = new e2.a("TOO_LATE_TO_CANCEL");
    public static final e2.a h = new e2.a("SEALED");

    /* renamed from: i, reason: collision with root package name */
    public static final m0 f12453i = new m0(false);

    /* renamed from: j, reason: collision with root package name */
    public static final m0 f12454j = new m0(true);

    public static final Object A(long j10, ConnectionPoolImpl.AnonymousClass2 anonymousClass2, w6.c cVar) throws Throwable {
        long jG;
        Object pVar;
        Object objQ;
        int i10 = p7.a.f12038d;
        int i11 = 0;
        boolean z9 = j10 > 0;
        if (z9) {
            long jF = p7.a.f(j10, l1.b.P(999999L, p7.c.NANOSECONDS));
            jG = ((((int) jF) & 1) != 1 || p7.a.e(jF)) ? p7.a.g(jF, p7.c.MILLISECONDS) : jF >> 1;
        } else {
            if (z9) {
                androidx.window.layout.c.b();
                return null;
            }
            jG = 0;
        }
        if (jG <= 0) {
            throw new s1("Timed out immediately", null);
        }
        t1 t1Var = new t1(jG, cVar);
        p(t1Var, true, new l0(l(t1Var.f13553d.getContext()).k(t1Var.e, t1Var, t1Var.f12387c), i11));
        try {
            kotlin.jvm.internal.a0.b(2, anonymousClass2);
            pVar = anonymousClass2.invoke((Object) t1Var, (Object) t1Var);
        } catch (Throwable th) {
            pVar = new p(false, th);
        }
        Object obj = x6.a.f13718a;
        if (pVar == obj || (objQ = t1Var.Q(pVar)) == e) {
            return obj;
        }
        if (objQ instanceof p) {
            Throwable th2 = ((p) objQ).f12426a;
            if (!(th2 instanceof s1) || ((s1) th2).f12435a != t1Var) {
                throw th2;
            }
            if (pVar instanceof p) {
                throw ((p) pVar).f12426a;
            }
        } else {
            pVar = x(objQ);
        }
        return pVar;
    }

    public static final w7.c a(w6.h hVar) {
        if (hVar.get(t.f12437b) == null) {
            hVar = hVar.plus(b());
        }
        return new w7.c(hVar);
    }

    public static c1 b() {
        return new c1(null);
    }

    public static q1 c() {
        return new q1(null);
    }

    public static c0 d(w wVar, g7.p pVar) {
        c0 c0Var = new c0(r(wVar, w6.i.f13523a), true);
        c0Var.e0(x.f12445a, c0Var, pVar);
        return c0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(y6.c r4) {
        /*
            boolean r0 = r4 instanceof r7.e0
            if (r0 == 0) goto L13
            r0 = r4
            r7.e0 r0 = (r7.e0) r0
            int r1 = r0.f12396b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12396b = r1
            goto L18
        L13:
            r7.e0 r0 = new r7.e0
            r0.<init>(r4)
        L18:
            java.lang.Object r4 = r0.f12395a
            int r1 = r0.f12396b
            r2 = 1
            if (r1 == 0) goto L2b
            if (r1 == r2) goto L27
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r4)
            return
        L27:
            s6.a.e(r4)
            goto L45
        L2b:
            s6.a.e(r4)
            r0.f12396b = r2
            r7.g r4 = new r7.g
            w6.c r0 = r0.f.F(r0)
            r4.<init>(r2, r0)
            r4.s()
            java.lang.Object r4 = r4.q()
            x6.a r0 = x6.a.f13718a
            if (r4 != r0) goto L45
            return
        L45:
            com.google.android.gms.internal.measurement.u6 r4 = new com.google.android.gms.internal.measurement.u6
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.y.e(y6.c):void");
    }

    public static void f(w wVar) {
        a1 a1Var = (a1) wVar.getCoroutineContext().get(t.f12437b);
        if (a1Var != null) {
            a1Var.a(null);
        } else {
            p8.u.i(wVar, "Scope cannot be cancelled because it does not have a job: ");
        }
    }

    public static final Object g(g7.p pVar, w6.c cVar) {
        w7.r rVar = new w7.r(cVar, cVar.getContext());
        return z1.t1.U(rVar, rVar, pVar);
    }

    public static final Object h(long j10, w6.c cVar) {
        if (j10 > 0) {
            g gVar = new g(1, r0.f.F(cVar));
            gVar.s();
            if (j10 < Long.MAX_VALUE) {
                l(gVar.e).f(j10, gVar);
            }
            Object objQ = gVar.q();
            if (objQ == x6.a.f13718a) {
                return objQ;
            }
        }
        return s6.w.f12711a;
    }

    public static final void i(w6.h hVar) {
        a1 a1Var = (a1) hVar.get(t.f12437b);
        if (a1Var != null && !a1Var.isActive()) {
            throw a1Var.e();
        }
    }

    public static final w6.h j(w6.h hVar, w6.h hVar2, boolean z9) {
        Boolean bool = Boolean.FALSE;
        boolean zBooleanValue = ((Boolean) hVar.fold(bool, new e5.u0(2))).booleanValue();
        boolean zBooleanValue2 = ((Boolean) hVar2.fold(bool, new e5.u0(2))).booleanValue();
        if (!zBooleanValue && !zBooleanValue2) {
            return hVar.plus(hVar2);
        }
        e5.u0 u0Var = new e5.u0(3);
        w6.i iVar = w6.i.f13523a;
        w6.h hVar3 = (w6.h) hVar.fold(iVar, u0Var);
        Object objFold = hVar2;
        if (zBooleanValue2) {
            objFold = hVar2.fold(iVar, new e5.u0(4));
        }
        return hVar3.plus((w6.h) objFold);
    }

    public static final s k(Executor executor) {
        h0 h0Var = executor instanceof h0 ? (h0) executor : null;
        return h0Var != null ? h0Var.f12402a : new u0(executor);
    }

    public static final d0 l(w6.h hVar) {
        w6.f fVar = hVar.get(w6.d.f13522a);
        d0 d0Var = fVar instanceof d0 ? (d0) fVar : null;
        return d0Var == null ? a0.f12388a : d0Var;
    }

    public static final String m(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final g n(w6.c cVar) {
        g gVar;
        g gVar2;
        if (!(cVar instanceof w7.f)) {
            return new g(1, cVar);
        }
        w7.f fVar = (w7.f) cVar;
        e2.a aVar = w7.a.f13526c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w7.f.h;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            gVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(fVar, aVar);
                gVar2 = null;
                break;
            }
            if (obj instanceof g) {
                while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, aVar)) {
                    if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                        break;
                    }
                }
                gVar2 = (g) obj;
                break loop0;
            }
            if (obj != aVar && !(obj instanceof Throwable)) {
                p8.u.i(obj, "Inconsistent state ");
                return null;
            }
        }
        if (gVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = g.g;
            Object obj2 = atomicReferenceFieldUpdater2.get(gVar2);
            if (!(obj2 instanceof o) || ((o) obj2).f12422d == null) {
                g.f.set(gVar2, 536870911);
                atomicReferenceFieldUpdater2.set(gVar2, b.f12389a);
                gVar = gVar2;
            } else {
                gVar2.m();
            }
            if (gVar != null) {
                return gVar;
            }
        }
        return new g(2, cVar);
    }

    public static final void o(Throwable th, w6.h hVar) {
        try {
            u uVar = (u) hVar.get(t.f12436a);
            if (uVar != null) {
                uVar.h(th);
            } else {
                w7.a.d(th, hVar);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                s6.a.a(runtimeException, th);
                th = runtimeException;
            }
            w7.a.d(th, hVar);
        }
    }

    public static final k0 p(a1 a1Var, boolean z9, e1 e1Var) {
        return a1Var instanceof i1 ? ((i1) a1Var).M(z9, e1Var) : a1Var.m(e1Var.i(), z9, new d1(1, e1Var, e1.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0));
    }

    public static o1 q(w wVar, w6.h hVar, x xVar, g7.p pVar, int i10) {
        if ((i10 & 1) != 0) {
            hVar = w6.i.f13523a;
        }
        if ((i10 & 2) != 0) {
            xVar = x.f12445a;
        }
        w6.h hVarR = r(wVar, hVar);
        xVar.getClass();
        o1 j1Var = xVar == x.f12446b ? new j1(hVarR, pVar) : new o1(hVarR, true);
        j1Var.e0(xVar, j1Var, pVar);
        return j1Var;
    }

    public static final w6.h r(w wVar, w6.h hVar) {
        w6.h hVarJ = j(wVar.getCoroutineContext(), hVar, true);
        y7.e eVar = i0.f12407a;
        return (hVarJ == eVar || hVarJ.get(w6.d.f13522a) != null) ? hVarJ : hVarJ.plus(eVar);
    }

    public static final Object s(Object obj) {
        return obj instanceof p ? s6.a.b(((p) obj).f12426a) : obj;
    }

    public static final void t(g gVar, w6.c cVar, boolean z9) {
        Object obj = g.g.get(gVar);
        Throwable thE = gVar.e(obj);
        Object jVar = thE != null ? new s6.j(thE) : gVar.g(obj);
        if (!z9) {
            cVar.resumeWith(jVar);
            return;
        }
        cVar.getClass();
        w7.f fVar = (w7.f) cVar;
        w6.c cVar2 = fVar.e;
        Object obj2 = fVar.g;
        w6.h context = cVar2.getContext();
        Object objL = w7.a.l(context, obj2);
        v1 v1VarY = objL != w7.a.f13527d ? y(cVar2, context, objL) : null;
        try {
            cVar2.resumeWith(jVar);
            if (v1VarY == null || v1VarY.f0()) {
                w7.a.g(context, objL);
            }
        } catch (Throwable th) {
            if (v1VarY == null || v1VarY.f0()) {
                w7.a.g(context, objL);
            }
            throw th;
        }
    }

    public static final Object u(w6.h hVar, g7.p pVar) throws Throwable {
        n0 n0VarA;
        w6.h hVarJ;
        Thread threadCurrentThread = Thread.currentThread();
        w6.g gVar = w6.d.f13522a;
        w6.e eVar = (w6.e) hVar.get(gVar);
        w6.i iVar = w6.i.f13523a;
        if (eVar == null) {
            n0VarA = r1.a();
            hVarJ = j(iVar, hVar.plus(n0VarA), true);
            y7.e eVar2 = i0.f12407a;
            if (hVarJ != eVar2 && hVarJ.get(gVar) == null) {
                hVarJ = hVarJ.plus(eVar2);
            }
        } else {
            if (eVar instanceof n0) {
            }
            n0VarA = (n0) r1.f12434a.get();
            hVarJ = j(iVar, hVar, true);
            y7.e eVar3 = i0.f12407a;
            if (hVarJ != eVar3 && hVarJ.get(gVar) == null) {
                hVarJ = hVarJ.plus(eVar3);
            }
        }
        c cVar = new c(hVarJ, threadCurrentThread, n0VarA);
        cVar.e0(x.f12445a, cVar, pVar);
        n0 n0Var = cVar.e;
        if (n0Var != null) {
            int i10 = n0.f12415d;
            n0Var.o(false);
        }
        while (!Thread.interrupted()) {
            try {
                long jP = n0Var != null ? n0Var.p() : Long.MAX_VALUE;
                if (cVar.N()) {
                    if (n0Var != null) {
                        int i11 = n0.f12415d;
                        n0Var.l(false);
                    }
                    Object objX = x(i1.f12408a.get(cVar));
                    p pVar2 = objX instanceof p ? (p) objX : null;
                    if (pVar2 == null) {
                        return objX;
                    }
                    throw pVar2.f12426a;
                }
                LockSupport.parkNanos(cVar, jP);
            } catch (Throwable th) {
                if (n0Var != null) {
                    int i12 = n0.f12415d;
                    n0Var.l(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        cVar.w(interruptedException);
        throw interruptedException;
    }

    public static final String w(w6.c cVar) {
        Object jVar;
        if (cVar instanceof w7.f) {
            return ((w7.f) cVar).toString();
        }
        try {
            jVar = cVar + '@' + m(cVar);
        } catch (Throwable th) {
            jVar = new s6.j(th);
        }
        if (s6.k.a(jVar) != null) {
            jVar = cVar.getClass().getName() + '@' + m(cVar);
        }
        return (String) jVar;
    }

    public static final Object x(Object obj) {
        x0 x0Var;
        y0 y0Var = obj instanceof y0 ? (y0) obj : null;
        return (y0Var == null || (x0Var = y0Var.f12455a) == null) ? obj : x0Var;
    }

    public static final v1 y(w6.c cVar, w6.h hVar, Object obj) {
        v1 v1Var = null;
        if ((cVar instanceof y6.d) && hVar.get(w1.f12444a) != null) {
            y6.d callerFrame = (y6.d) cVar;
            while (true) {
                if ((callerFrame instanceof f0) || (callerFrame = callerFrame.getCallerFrame()) == null) {
                    break;
                }
                if (callerFrame instanceof v1) {
                    v1Var = (v1) callerFrame;
                    break;
                }
            }
            if (v1Var != null) {
                v1Var.g0(hVar, obj);
            }
        }
        return v1Var;
    }

    public static final Object z(g7.p pVar, w6.h hVar, w6.c cVar) throws Throwable {
        w6.h context = cVar.getContext();
        w6.h hVarPlus = !((Boolean) hVar.fold(Boolean.FALSE, new e5.u0(2))).booleanValue() ? context.plus(hVar) : j(context, hVar, false);
        i(hVarPlus);
        if (hVarPlus == context) {
            w7.r rVar = new w7.r(cVar, hVarPlus);
            return z1.t1.U(rVar, rVar, pVar);
        }
        w6.d dVar = w6.d.f13522a;
        if (kotlin.jvm.internal.l.a(hVarPlus.get(dVar), context.get(dVar))) {
            v1 v1Var = new v1(cVar, hVarPlus);
            w6.h hVar2 = v1Var.f12387c;
            Object objL = w7.a.l(hVar2, null);
            try {
                return z1.t1.U(v1Var, v1Var, pVar);
            } finally {
                w7.a.g(hVar2, objL);
            }
        }
        f0 f0Var = new f0(cVar, hVarPlus);
        try {
            w7.a.h(s6.w.f12711a, r0.f.F(r0.f.s(pVar, f0Var, f0Var)));
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f0.e;
            do {
                int i10 = atomicIntegerFieldUpdater.get(f0Var);
                if (i10 != 0) {
                    if (i10 != 2) {
                        androidx.window.layout.c.g("Already suspended");
                        return null;
                    }
                    Object objX = x(i1.f12408a.get(f0Var));
                    if (objX instanceof p) {
                        throw ((p) objX).f12426a;
                    }
                    return objX;
                }
            } while (!atomicIntegerFieldUpdater.compareAndSet(f0Var, 0, 1));
            return x6.a.f13718a;
        } catch (Throwable th) {
            f0Var.resumeWith(new s6.j(th));
            throw th;
        }
    }
}

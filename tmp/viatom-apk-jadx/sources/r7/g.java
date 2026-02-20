package r7;

import com.google.android.gms.internal.measurement.u6;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class g extends g0 implements f, y6.d, x1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(g.class, "_decisionAndIndex$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_state$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_parentHandle$volatile");
    private volatile /* synthetic */ int _decisionAndIndex$volatile;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final w6.c f12399d;
    public final w6.h e;

    public g(int i10, w6.c cVar) {
        super(i10);
        this.f12399d = cVar;
        this.e = cVar.getContext();
        this._decisionAndIndex$volatile = 536870911;
        this._state$volatile = b.f12389a;
    }

    public static Object C(n1 n1Var, Object obj, int i10, g7.q qVar) {
        if (obj instanceof p) {
            return obj;
        }
        if (i10 != 1 && i10 != 2) {
            return obj;
        }
        if (qVar != null || (n1Var instanceof e)) {
            return new o(obj, n1Var instanceof e ? (e) n1Var : null, qVar, (Throwable) null, 16);
        }
        return obj;
    }

    public static void x(Object obj, Object obj2) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + obj + ", already has " + obj2).toString());
    }

    public final void A(Object obj, int i10, g7.q qVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof n1) {
                Object objC = C((n1) obj2, obj, i10, qVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!w()) {
                    m();
                }
                o(i10);
                return;
            }
            if (obj2 instanceof h) {
                h hVar = (h) obj2;
                if (h.f12401c.compareAndSet(hVar, 0, 1)) {
                    if (qVar != null) {
                        k(qVar, hVar.f12426a, obj);
                        return;
                    }
                    return;
                }
            }
            p8.u.i(obj, "Already resumed, but proposed with update ");
            return;
        }
    }

    public final void B(s sVar) {
        w6.c cVar = this.f12399d;
        w7.f fVar = cVar instanceof w7.f ? (w7.f) cVar : null;
        A(s6.w.f12711a, (fVar != null ? fVar.f13533d : null) == sVar ? 4 : this.f12400c, null);
    }

    @Override // r7.x1
    public final void a(w7.s sVar, int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f;
            i11 = atomicIntegerFieldUpdater.get(this);
            if ((i11 & 536870911) != 536870911) {
                androidx.window.layout.c.g("invokeOnCancellation should be called at most once");
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, ((i11 >> 29) << 29) + i10));
        v(sVar);
    }

    @Override // r7.g0
    public final void b(CancellationException cancellationException) {
        CancellationException cancellationException2;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof n1) {
                androidx.window.layout.c.g("Not completed");
                return;
            }
            if (obj instanceof p) {
                return;
            }
            if (!(obj instanceof o)) {
                cancellationException2 = cancellationException;
                o oVar = new o(obj, (e) null, (g7.q) null, cancellationException2, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, oVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            o oVar2 = (o) obj;
            if (oVar2.e != null) {
                androidx.window.layout.c.g("Must be called at most once");
                return;
            }
            o oVarA = o.a(oVar2, null, cancellationException, 15);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, oVarA)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    cancellationException2 = cancellationException;
                }
            }
            e eVar = oVar2.f12420b;
            if (eVar != null) {
                j(eVar, cancellationException);
            }
            g7.q qVar = oVar2.f12421c;
            if (qVar != null) {
                k(qVar, cancellationException, oVar2.f12419a);
                return;
            }
            return;
            cancellationException = cancellationException2;
        }
    }

    @Override // r7.f
    public final void c(Object obj, g7.q qVar) {
        A(obj, this.f12400c, qVar);
    }

    @Override // r7.g0
    public final w6.c d() {
        return this.f12399d;
    }

    @Override // r7.g0
    public final Throwable e(Object obj) {
        Throwable thE = super.e(obj);
        if (thE != null) {
            return thE;
        }
        return null;
    }

    @Override // r7.f
    public final e2.a f(Object obj, g7.q qVar) {
        e2.a aVar = y.f12449a;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof n1)) {
                return null;
            }
            Object objC = C((n1) obj2, obj, this.f12400c, qVar);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, objC)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            if (!w()) {
                m();
            }
            return aVar;
        }
    }

    @Override // r7.g0
    public final Object g(Object obj) {
        return obj instanceof o ? ((o) obj).f12419a : obj;
    }

    @Override // y6.d
    public final y6.d getCallerFrame() {
        w6.c cVar = this.f12399d;
        if (cVar instanceof y6.d) {
            return (y6.d) cVar;
        }
        return null;
    }

    @Override // w6.c
    public final w6.h getContext() {
        return this.e;
    }

    @Override // r7.g0
    public final Object i() {
        return g.get(this);
    }

    public final void j(e eVar, Throwable th) {
        try {
            switch (eVar.f12393a) {
                case 0:
                    ((ScheduledFuture) eVar.f12394b).cancel(false);
                    break;
                case 1:
                    ((g7.l) eVar.f12394b).invoke(th);
                    break;
                default:
                    ((k0) eVar.f12394b).dispose();
                    break;
            }
        } catch (Throwable th2) {
            y.o(new u6("Exception in invokeOnCancellation handler for " + this, th2), this.e);
        }
    }

    public final void k(g7.q qVar, Throwable th, Object obj) {
        w6.h hVar = this.e;
        try {
            qVar.invoke(th, obj, hVar);
        } catch (Throwable th2) {
            y.o(new u6("Exception in resume onCancellation handler for " + this, th2), hVar);
        }
    }

    public final void l(w7.s sVar, Throwable th) {
        w6.h hVar = this.e;
        int i10 = f.get(this) & 536870911;
        if (i10 == 536870911) {
            androidx.window.layout.c.g("The index for Segment.onCancellation(..) is broken");
            return;
        }
        try {
            sVar.g(i10, hVar);
        } catch (Throwable th2) {
            y.o(new u6("Exception in invokeOnCancellation handler for " + this, th2), hVar);
        }
    }

    public final void m() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
        k0 k0Var = (k0) atomicReferenceFieldUpdater.get(this);
        if (k0Var == null) {
            return;
        }
        k0Var.dispose();
        atomicReferenceFieldUpdater.set(this, m1.f12414a);
    }

    @Override // r7.f
    public final boolean n(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof n1)) {
                return false;
            }
            h hVar = new h(this, th, (obj instanceof e) || (obj instanceof w7.s));
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, hVar)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            n1 n1Var = (n1) obj;
            if (n1Var instanceof e) {
                j((e) obj, th);
            } else if (n1Var instanceof w7.s) {
                l((w7.s) obj, th);
            }
            if (!w()) {
                m();
            }
            o(this.f12400c);
            return true;
        }
    }

    public final void o(int i10) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i11;
        do {
            atomicIntegerFieldUpdater = f;
            i11 = atomicIntegerFieldUpdater.get(this);
            int i12 = i11 >> 29;
            if (i12 != 0) {
                if (i12 != 1) {
                    androidx.window.layout.c.g("Already resumed");
                    return;
                }
                boolean z9 = i10 == 4;
                w6.c cVar = this.f12399d;
                if (!z9 && (cVar instanceof w7.f)) {
                    boolean z10 = i10 == 1 || i10 == 2;
                    int i13 = this.f12400c;
                    if (z10 == (i13 == 1 || i13 == 2)) {
                        w7.f fVar = (w7.f) cVar;
                        s sVar = fVar.f13533d;
                        w6.h context = fVar.e.getContext();
                        if (sVar.isDispatchNeeded(context)) {
                            sVar.dispatch(context, this);
                            return;
                        }
                        n0 n0VarA = r1.a();
                        if (n0VarA.f12416a >= 4294967296L) {
                            n0VarA.n(this);
                            return;
                        }
                        n0VarA.o(true);
                        try {
                            y.t(this, cVar, true);
                            do {
                            } while (n0VarA.q());
                        } finally {
                            try {
                                return;
                            } finally {
                            }
                        }
                        return;
                    }
                }
                y.t(this, cVar, z9);
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, 1073741824 + (536870911 & i11)));
    }

    public Throwable p(i1 i1Var) {
        return i1Var.e();
    }

    public final Object q() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        a1 a1Var;
        boolean zW = w();
        do {
            atomicIntegerFieldUpdater = f;
            i10 = atomicIntegerFieldUpdater.get(this);
            int i11 = i10 >> 29;
            if (i11 != 0) {
                if (i11 != 2) {
                    androidx.window.layout.c.g("Already suspended");
                    return null;
                }
                if (zW) {
                    z();
                }
                Object obj = g.get(this);
                if (obj instanceof p) {
                    throw ((p) obj).f12426a;
                }
                int i12 = this.f12400c;
                if ((i12 != 1 && i12 != 2) || (a1Var = (a1) this.e.get(t.f12437b)) == null || a1Var.isActive()) {
                    return g(obj);
                }
                CancellationException cancellationExceptionE = a1Var.e();
                b(cancellationExceptionE);
                throw cancellationExceptionE;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 536870912 + (536870911 & i10)));
        if (((k0) h.get(this)) == null) {
            t();
        }
        if (zW) {
            z();
        }
        return x6.a.f13718a;
    }

    @Override // r7.f
    public final void r(Object obj) {
        o(this.f12400c);
    }

    @Override // w6.c
    public final void resumeWith(Object obj) {
        Throwable thA = s6.k.a(obj);
        if (thA != null) {
            obj = new p(false, thA);
        }
        A(obj, this.f12400c, null);
    }

    public final void s() {
        k0 k0VarT = t();
        if (k0VarT == null || (g.get(this) instanceof n1)) {
            return;
        }
        k0VarT.dispose();
        h.set(this, m1.f12414a);
    }

    public final k0 t() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        a1 a1Var = (a1) this.e.get(t.f12437b);
        if (a1Var == null) {
            return null;
        }
        k0 k0VarP = y.p(a1Var, true, new i(this, 0));
        do {
            atomicReferenceFieldUpdater = h;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, k0VarP)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return k0VarP;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(y());
        sb.append('(');
        sb.append(y.w(this.f12399d));
        sb.append("){");
        Object obj = g.get(this);
        sb.append(obj instanceof n1 ? "Active" : obj instanceof h ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(y.m(this));
        return sb.toString();
    }

    public final void u(g7.l lVar) {
        v(new e(lVar, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00aa, code lost:
    
        x(r8, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ad, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(r7.n1 r8) {
        /*
            r7 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r7.g.g
            java.lang.Object r2 = r0.get(r7)
            boolean r1 = r2 instanceof r7.b
            if (r1 == 0) goto L19
        La:
            boolean r1 = r0.compareAndSet(r7, r2, r8)
            if (r1 == 0) goto L12
            goto La1
        L12:
            java.lang.Object r1 = r0.get(r7)
            if (r1 == r2) goto La
            goto L0
        L19:
            boolean r1 = r2 instanceof r7.e
            r3 = 0
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof w7.s
            if (r1 != 0) goto Laa
            boolean r1 = r2 instanceof r7.p
            if (r1 == 0) goto L50
            r0 = r2
            r7.p r0 = (r7.p) r0
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = r7.p.f12425b
            r4 = 0
            r5 = 1
            boolean r1 = r1.compareAndSet(r0, r4, r5)
            if (r1 == 0) goto L4c
            boolean r1 = r2 instanceof r7.h
            if (r1 == 0) goto La1
            java.lang.Throwable r0 = r0.f12426a
            boolean r1 = r8 instanceof r7.e
            if (r1 == 0) goto L43
            r7.e r8 = (r7.e) r8
            r7.j(r8, r0)
            return
        L43:
            r8.getClass()
            w7.s r8 = (w7.s) r8
            r7.l(r8, r0)
            return
        L4c:
            x(r8, r2)
            throw r3
        L50:
            boolean r1 = r2 instanceof r7.o
            if (r1 == 0) goto L87
            r1 = r2
            r7.o r1 = (r7.o) r1
            r7.e r4 = r1.f12420b
            if (r4 != 0) goto L83
            boolean r4 = r8 instanceof w7.s
            if (r4 == 0) goto L60
            return
        L60:
            r8.getClass()
            r4 = r8
            r7.e r4 = (r7.e) r4
            java.lang.Throwable r5 = r1.e
            if (r5 == 0) goto L6e
            r7.j(r4, r5)
            return
        L6e:
            r5 = 29
            r7.o r1 = r7.o.a(r1, r4, r3, r5)
        L74:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto L7b
            goto La1
        L7b:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L74
            goto L0
        L83:
            x(r8, r2)
            throw r3
        L87:
            boolean r1 = r8 instanceof w7.s
            if (r1 == 0) goto L8c
            return
        L8c:
            r8.getClass()
            r3 = r8
            r7.e r3 = (r7.e) r3
            r7.o r1 = new r7.o
            r5 = 0
            r6 = 28
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L9b:
            boolean r3 = r0.compareAndSet(r7, r2, r1)
            if (r3 == 0) goto La2
        La1:
            return
        La2:
            java.lang.Object r3 = r0.get(r7)
            if (r3 == r2) goto L9b
            goto L0
        Laa:
            x(r8, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.g.v(r7.n1):void");
    }

    public final boolean w() {
        if (this.f12400c == 2) {
            return w7.f.h.get((w7.f) this.f12399d) != null;
        }
        return false;
    }

    public String y() {
        return "CancellableContinuation";
    }

    public final void z() {
        w6.c cVar = this.f12399d;
        Throwable th = null;
        w7.f fVar = cVar instanceof w7.f ? (w7.f) cVar : null;
        if (fVar != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = w7.f.h;
            loop0: while (true) {
                Object obj = atomicReferenceFieldUpdater.get(fVar);
                e2.a aVar = w7.a.f13526c;
                if (obj == aVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, aVar, this)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != aVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        p8.u.i(obj, "Inconsistent state ");
                        return;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(fVar) != obj) {
                            com.google.gson.internal.a.n("Failed requirement.");
                            return;
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            m();
            n(th);
        }
    }
}

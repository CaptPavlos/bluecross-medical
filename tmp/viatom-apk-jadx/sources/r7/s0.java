package r7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class s0 extends n0 implements d0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(s0.class, Object.class, "_queue$volatile");
    public static final /* synthetic */ AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(s0.class, Object.class, "_delayed$volatile");
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(s0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    @Override // r7.s
    public final void dispatch(w6.h hVar, Runnable runnable) {
        r(runnable);
    }

    @Override // r7.d0
    public final void f(long j10, g gVar) {
        long j11 = j10 > 0 ? j10 >= 9223372036854L ? Long.MAX_VALUE : 1000000 * j10 : 0L;
        if (j11 < 4611686018427387903L) {
            long jNanoTime = System.nanoTime();
            o0 o0Var = new o0(this, j11 + jNanoTime, gVar);
            y(jNanoTime, o0Var);
            gVar.v(new e(o0Var, 2));
        }
    }

    @Override // r7.d0
    public k0 k(long j10, t1 t1Var, w6.h hVar) {
        return a0.f12388a.k(j10, t1Var, hVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
    
        r7 = null;
     */
    @Override // r7.n0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long p() {
        /*
            r10 = this;
            e2.a r0 = r7.y.f12451c
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = r7.s0.e
            boolean r2 = r10.q()
            r3 = 0
            if (r2 == 0) goto Le
            goto Lb4
        Le:
            r10.t()
        L11:
            java.lang.Object r2 = r1.get(r10)
            r5 = 0
            if (r2 != 0) goto L1a
        L18:
            r7 = r5
            goto L4a
        L1a:
            boolean r6 = r2 instanceof w7.m
            if (r6 == 0) goto L3e
            r6 = r2
            w7.m r6 = (w7.m) r6
            java.lang.Object r7 = r6.d()
            e2.a r8 = w7.m.g
            if (r7 == r8) goto L2c
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            goto L4a
        L2c:
            w7.m r6 = r6.c()
        L30:
            boolean r5 = r1.compareAndSet(r10, r2, r6)
            if (r5 == 0) goto L37
            goto L11
        L37:
            java.lang.Object r5 = r1.get(r10)
            if (r5 == r2) goto L30
            goto L11
        L3e:
            if (r2 != r0) goto L41
            goto L18
        L41:
            boolean r6 = r1.compareAndSet(r10, r2, r5)
            if (r6 == 0) goto Lb9
            r7 = r2
            java.lang.Runnable r7 = (java.lang.Runnable) r7
        L4a:
            if (r7 == 0) goto L50
            r7.run()
            return r3
        L50:
            t6.i r2 = r10.f12418c
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != 0) goto L5b
        L59:
            r8 = r6
            goto L63
        L5b:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L62
            goto L59
        L62:
            r8 = r3
        L63:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 != 0) goto L68
            goto Lb4
        L68:
            java.lang.Object r1 = r1.get(r10)
            if (r1 == 0) goto L90
            boolean r2 = r1 instanceof w7.m
            if (r2 == 0) goto L8d
            w7.m r1 = (w7.m) r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = w7.m.f
            long r0 = r0.get(r1)
            r8 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r8 = r8 & r0
            int r2 = (int) r8
            r8 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r0 = r0 & r8
            r8 = 30
            long r0 = r0 >> r8
            int r0 = (int) r0
            if (r2 != r0) goto L8c
            goto L90
        L8c:
            return r3
        L8d:
            if (r1 != r0) goto Lb4
            goto Lb8
        L90:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r7.s0.f
            java.lang.Object r0 = r0.get(r10)
            r7.r0 r0 = (r7.r0) r0
            if (r0 == 0) goto Lb8
            monitor-enter(r0)
            r7.q0[] r1 = r0.f13563a     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto La5
            r2 = 0
            r5 = r1[r2]     // Catch: java.lang.Throwable -> La3
            goto La5
        La3:
            r1 = move-exception
            goto Lb6
        La5:
            monitor-exit(r0)
            if (r5 != 0) goto La9
            goto Lb8
        La9:
            long r0 = r5.f12429a
            long r5 = java.lang.System.nanoTime()
            long r0 = r0 - r5
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto Lb5
        Lb4:
            return r3
        Lb5:
            return r0
        Lb6:
            monitor-exit(r0)
            throw r1
        Lb8:
            return r6
        Lb9:
            java.lang.Object r6 = r1.get(r10)
            if (r6 == r2) goto L41
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.s0.p():long");
    }

    public void r(Runnable runnable) {
        t();
        if (!u(runnable)) {
            z.h.r(runnable);
            return;
        }
        Thread threadV = v();
        if (Thread.currentThread() != threadV) {
            LockSupport.unpark(threadV);
        }
    }

    @Override // r7.n0
    public void shutdown() {
        q0 q0VarC;
        r1.f12434a.set(null);
        g.set(this, 1);
        e2.a aVar = y.f12451c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
        loop0: while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null) {
                if (!(obj instanceof w7.m)) {
                    if (obj != aVar) {
                        w7.m mVar = new w7.m(8, true);
                        mVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, mVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((w7.m) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, aVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (p() <= 0) {
        }
        long jNanoTime = System.nanoTime();
        while (true) {
            r0 r0Var = (r0) f.get(this);
            if (r0Var == null) {
                return;
            }
            synchronized (r0Var) {
                q0VarC = w7.x.f13562b.get(r0Var) > 0 ? r0Var.c(0) : null;
            }
            if (q0VarC == null) {
                return;
            } else {
                x(jNanoTime, q0VarC);
            }
        }
    }

    public final void t() {
        q0 q0VarC;
        r0 r0Var = (r0) f.get(this);
        if (r0Var == null || w7.x.f13562b.get(r0Var) == 0) {
            return;
        }
        long jNanoTime = System.nanoTime();
        do {
            synchronized (r0Var) {
                try {
                    q0[] q0VarArr = r0Var.f13563a;
                    q0 q0Var = q0VarArr != null ? q0VarArr[0] : null;
                    if (q0Var != null) {
                        q0VarC = ((jNanoTime - q0Var.f12429a) > 0L ? 1 : ((jNanoTime - q0Var.f12429a) == 0L ? 0 : -1)) >= 0 ? u(q0Var) : false ? r0Var.c(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (q0VarC != null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004b, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean u(java.lang.Runnable r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r7.s0.e
            java.lang.Object r1 = r0.get(r6)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = r7.s0.g
            int r2 = r2.get(r6)
            r3 = 0
            if (r2 == 0) goto L10
            return r3
        L10:
            r2 = 1
            if (r1 != 0) goto L22
        L13:
            r1 = 0
            boolean r1 = r0.compareAndSet(r6, r1, r7)
            if (r1 == 0) goto L1b
            goto L62
        L1b:
            java.lang.Object r1 = r0.get(r6)
            if (r1 == 0) goto L13
            goto L0
        L22:
            boolean r4 = r1 instanceof w7.m
            if (r4 == 0) goto L47
            r4 = r1
            w7.m r4 = (w7.m) r4
            int r5 = r4.a(r7)
            if (r5 == 0) goto L62
            if (r5 == r2) goto L35
            r0 = 2
            if (r5 == r0) goto L4b
            goto L0
        L35:
            w7.m r3 = r4.c()
        L39:
            boolean r2 = r0.compareAndSet(r6, r1, r3)
            if (r2 == 0) goto L40
            goto L0
        L40:
            java.lang.Object r2 = r0.get(r6)
            if (r2 == r1) goto L39
            goto L0
        L47:
            e2.a r4 = r7.y.f12451c
            if (r1 != r4) goto L4c
        L4b:
            return r3
        L4c:
            w7.m r3 = new w7.m
            r4 = 8
            r3.<init>(r4, r2)
            r4 = r1
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r3.a(r4)
            r3.a(r7)
        L5c:
            boolean r4 = r0.compareAndSet(r6, r1, r3)
            if (r4 == 0) goto L63
        L62:
            return r2
        L63:
            java.lang.Object r4 = r0.get(r6)
            if (r4 == r1) goto L5c
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.s0.u(java.lang.Runnable):boolean");
    }

    public abstract Thread v();

    /* JADX WARN: Removed duplicated region for block: B:17:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean w() {
        /*
            r7 = this;
            t6.i r0 = r7.f12418c
            r1 = 1
            if (r0 == 0) goto La
            boolean r0 = r0.isEmpty()
            goto Lb
        La:
            r0 = r1
        Lb:
            r2 = 0
            if (r0 != 0) goto Lf
            goto L54
        Lf:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r7.s0.f
            java.lang.Object r0 = r0.get(r7)
            r7.r0 r0 = (r7.r0) r0
            if (r0 == 0) goto L27
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = w7.x.f13562b
            int r0 = r3.get(r0)
            if (r0 != 0) goto L23
            r0 = r1
            goto L24
        L23:
            r0 = r2
        L24:
            if (r0 != 0) goto L27
            goto L54
        L27:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = r7.s0.e
            java.lang.Object r0 = r0.get(r7)
            if (r0 != 0) goto L30
            goto L53
        L30:
            boolean r3 = r0 instanceof w7.m
            if (r3 == 0) goto L4f
            w7.m r0 = (w7.m) r0
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = w7.m.f
            long r3 = r3.get(r0)
            r5 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r5 = r5 & r3
            int r0 = (int) r5
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r3 = r3 & r5
            r5 = 30
            long r3 = r3 >> r5
            int r3 = (int) r3
            if (r0 != r3) goto L4e
            return r1
        L4e:
            return r2
        L4f:
            e2.a r3 = r7.y.f12451c
            if (r0 != r3) goto L54
        L53:
            return r1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.s0.w():boolean");
    }

    public void x(long j10, q0 q0Var) {
        z.h.y(j10, q0Var);
    }

    public final void y(long j10, q0 q0Var) {
        int iC;
        Thread threadV;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
        if (g.get(this) != 0) {
            iC = 1;
        } else {
            r0 r0Var = (r0) atomicReferenceFieldUpdater.get(this);
            if (r0Var == null) {
                r0 r0Var2 = new r0();
                r0Var2.f12433c = j10;
                while (!atomicReferenceFieldUpdater.compareAndSet(this, null, r0Var2) && atomicReferenceFieldUpdater.get(this) == null) {
                }
                Object obj = atomicReferenceFieldUpdater.get(this);
                obj.getClass();
                r0Var = (r0) obj;
            }
            iC = q0Var.c(j10, r0Var, this);
        }
        if (iC != 0) {
            if (iC == 1) {
                x(j10, q0Var);
                return;
            } else {
                if (iC == 2) {
                    return;
                }
                androidx.window.layout.c.g("unexpected result");
                return;
            }
        }
        r0 r0Var3 = (r0) atomicReferenceFieldUpdater.get(this);
        if (r0Var3 != null) {
            synchronized (r0Var3) {
                q0[] q0VarArr = r0Var3.f13563a;
                q0Var = q0VarArr != null ? q0VarArr[0] : null;
            }
        }
        if (q0Var != q0Var || Thread.currentThread() == (threadV = v())) {
            return;
        }
        LockSupport.unpark(threadV);
    }
}

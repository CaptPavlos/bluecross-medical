package y7;

import com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSource;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import r7.y;
import w7.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f14109i = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f14110j = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final e2.a f14111k = new e2.a("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f14112a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14113b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14114c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final String f14115d;
    public final f e;
    public final f f;
    public final q g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i10, long j10, String str, int i11) {
        this.f14112a = i10;
        this.f14113b = i11;
        this.f14114c = j10;
        this.f14115d = str;
        if (i10 < 1) {
            z8.f.b(a3.a.g(i10, "Core pool size ", " should be at least 1"));
            throw null;
        }
        if (i11 < i10) {
            z8.f.b(androidx.constraintlayout.core.widgets.analyzer.a.u(i11, i10, "Max pool size ", " should be greater than or equals to core pool size "));
            throw null;
        }
        if (i11 > 2097150) {
            z8.f.b(a3.a.g(i11, "Max pool size ", " should not exceed maximal supported number of threads 2097150"));
            throw null;
        }
        if (j10 <= 0) {
            z8.f.b(r1.i.d("Idle worker keep alive time ", " must be positive", j10));
            throw null;
        }
        this.e = new f();
        this.f = new f();
        this.g = new q((i10 + 1) * 2);
        this.controlState$volatile = i10 << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void d(c cVar, Runnable runnable, int i10) {
        cVar.b(runnable, false, (i10 & 4) == 0);
    }

    public final int a() {
        synchronized (this.g) {
            try {
                if (f14110j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f14109i;
                long j10 = atomicLongFieldUpdater.get(this);
                int i10 = (int) (j10 & 2097151);
                int i11 = i10 - ((int) ((j10 & 4398044413952L) >> 21));
                if (i11 < 0) {
                    i11 = 0;
                }
                if (i11 >= this.f14112a) {
                    return 0;
                }
                if (i10 >= this.f14113b) {
                    return 0;
                }
                int i12 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i12 <= 0 || this.g.b(i12) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i12);
                this.g.c(i12, aVar);
                if (i12 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i13 = i11 + 1;
                aVar.start();
                return i13;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z9, boolean z10) {
        h iVar;
        b bVar;
        j.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof h) {
            iVar = (h) runnable;
            iVar.f14121a = jNanoTime;
            iVar.f14122b = z9;
        } else {
            iVar = new i(runnable, jNanoTime, z9);
        }
        boolean z11 = iVar.f14122b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14109i;
        long jAddAndGet = z11 ? atomicLongFieldUpdater.addAndGet(this, CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !aVar.h.equals(this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f14103c) != b.e && (iVar.f14122b || bVar != b.f14106b)) {
            aVar.g = true;
            l lVar = aVar.f14101a;
            if (z10) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                h hVar = (h) l.f14129b.getAndSet(lVar, iVar);
                iVar = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.f14122b ? this.f.a(iVar) : this.e.a(iVar))) {
                throw new RejectedExecutionException(a3.a.o(new StringBuilder(), this.f14115d, " was terminated"));
            }
        }
        boolean z12 = z10 && aVar != null;
        if (z11) {
            if (z12 || h() || f(jAddAndGet)) {
                return;
            }
            h();
            return;
        }
        if (z12 || h() || f(atomicLongFieldUpdater.get(this))) {
            return;
        }
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = y7.c.f14110j
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof y7.a
            r3 = 0
            if (r1 == 0) goto L17
            y7.a r0 = (y7.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            y7.c r1 = r0.h
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            w7.q r1 = r8.g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = y7.c.f14109i     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            w7.q r5 = r8.g
            java.lang.Object r5 = r5.b(r1)
            r5.getClass()
            y7.a r5 = (y7.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            y7.l r5 = r5.f14101a
            y7.f r6 = r8.f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = y7.l.f14129b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            y7.h r7 = (y7.h) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            y7.h r7 = r5.b()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            y7.f r1 = r8.f
            r1.b()
            y7.f r1 = r8.e
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            y7.h r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            y7.f r1 = r8.e
            java.lang.Object r1 = r1.d()
            y7.h r1 = (y7.h) r1
            if (r1 != 0) goto Lb2
            y7.f r1 = r8.f
            java.lang.Object r1 = r1.d()
            y7.h r1 = (y7.h) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            y7.b r1 = y7.b.e
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = y7.c.h
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = y7.c.f14109i
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y7.c.close():void");
    }

    public final void e(a aVar, int i10, int i11) {
        while (true) {
            long j10 = h.get(this);
            int i12 = (int) (2097151 & j10);
            long j11 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j10) & (-2097152);
            if (i12 == i10) {
                if (i11 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f14111k) {
                            i12 = -1;
                            break;
                        }
                        if (objC == null) {
                            i12 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i12 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i12 = i11;
                }
            }
            if (i12 >= 0) {
                if (h.compareAndSet(this, j10, i12 | j11)) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        d(this, runnable, 6);
    }

    public final boolean f(long j10) {
        int i10 = ((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21));
        if (i10 < 0) {
            i10 = 0;
        }
        int i11 = this.f14112a;
        if (i10 < i11) {
            int iA = a();
            if (iA == 1 && i11 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        e2.a aVar;
        int iB;
        while (true) {
            long j10 = h.get(this);
            a aVar2 = (a) this.g.b((int) (2097151 & j10));
            if (aVar2 == null) {
                aVar2 = null;
            } else {
                long j11 = (CacheDataSource.DEFAULT_MAX_CACHE_FILE_SIZE + j10) & (-2097152);
                Object objC = aVar2.c();
                while (true) {
                    aVar = f14111k;
                    if (objC == aVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar3 = (a) objC;
                    iB = aVar3.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar3.c();
                }
                if (iB >= 0) {
                    if (h.compareAndSet(this, j10, iB | j11)) {
                        aVar2.g(aVar);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (aVar2 == null) {
                return false;
            }
            if (a.f14100i.compareAndSet(aVar2, -1, 0)) {
                LockSupport.unpark(aVar2);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        q qVar = this.g;
        int iA = qVar.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            a aVar = (a) qVar.b(i15);
            if (aVar != null) {
                l lVar = aVar.f14101a;
                lVar.getClass();
                int i16 = l.f14129b.get(lVar) != null ? (l.f14130c.get(lVar) - l.f14131d.get(lVar)) + 1 : l.f14130c.get(lVar) - l.f14131d.get(lVar);
                int iOrdinal = aVar.f14103c.ordinal();
                if (iOrdinal == 0) {
                    i10++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i16);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i16);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i12++;
                } else if (iOrdinal == 3) {
                    i13++;
                    if (i16 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i16);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        androidx.window.layout.c.b();
                        return null;
                    }
                    i14++;
                }
            }
        }
        long j10 = f14109i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f14115d);
        sb4.append('@');
        sb4.append(y.m(this));
        sb4.append("[Pool Size {core = ");
        int i17 = this.f14112a;
        sb4.append(i17);
        sb4.append(", max = ");
        sb4.append(this.f14113b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i10);
        sb4.append(", blocking = ");
        sb4.append(i11);
        sb4.append(", parked = ");
        sb4.append(i12);
        sb4.append(", dormant = ");
        sb4.append(i13);
        sb4.append(", terminated = ");
        sb4.append(i14);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j10));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j10) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i17 - ((int) ((j10 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}

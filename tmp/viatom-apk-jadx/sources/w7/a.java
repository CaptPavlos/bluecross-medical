package w7;

import e5.u0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final e2.a f13524a = new e2.a("CLOSED");

    /* renamed from: b, reason: collision with root package name */
    public static final e2.a f13525b = new e2.a("UNDEFINED");

    /* renamed from: c, reason: collision with root package name */
    public static final e2.a f13526c = new e2.a("REUSABLE_CLAIMED");

    /* renamed from: d, reason: collision with root package name */
    public static final e2.a f13527d = new e2.a("NO_THREAD_ELEMENTS");
    public static final u0 e = new u0(14);
    public static final u0 f = new u0(15);
    public static final u0 g = new u0(16);

    public static final void a(int i10) {
        if (i10 >= 1) {
            return;
        }
        z8.f.b(a3.a.f(i10, "Expected positive parallelism level, but got "));
    }

    public static final Object b(s sVar, long j10, g7.p pVar) {
        while (true) {
            if (sVar.f13555c >= j10 && !sVar.c()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f13528a;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            e2.a aVar = f13524a;
            if (obj == aVar) {
                return aVar;
            }
            s sVar2 = (s) ((b) obj);
            if (sVar2 == null) {
                sVar2 = (s) pVar.invoke(Long.valueOf(sVar.f13555c + 1), sVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                    if (atomicReferenceFieldUpdater.get(sVar) != null) {
                        break;
                    }
                }
                if (sVar.c()) {
                    sVar.d();
                }
            }
            sVar = sVar2;
        }
    }

    public static final s c(Object obj) {
        if (obj != f13524a) {
            return (s) obj;
        }
        androidx.window.layout.c.g("Does not contain segment");
        return null;
    }

    public static final void d(Throwable th, w6.h hVar) {
        Throwable runtimeException;
        Iterator it = d.f13531a.iterator();
        while (it.hasNext()) {
            try {
                ((r7.u) it.next()).h(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    s6.a.a(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            s6.a.a(th, new e(hVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f13524a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(w6.h hVar, Object obj) {
        if (obj == f13527d) {
            return;
        }
        if (!(obj instanceof y)) {
            Object objFold = hVar.fold(null, f);
            objFold.getClass();
            ((v) objFold).f13559b.set(obj);
            return;
        }
        y yVar = (y) obj;
        v[] vVarArr = yVar.f13566c;
        int length = vVarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            v vVar = vVarArr[length];
            vVar.getClass();
            vVar.f13559b.set(yVar.f13565b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(java.lang.Object r9, w6.c r10) {
        /*
            boolean r0 = r10 instanceof w7.f
            if (r0 == 0) goto Lae
            w7.f r10 = (w7.f) r10
            r7.s r0 = r10.f13533d
            w6.c r1 = r10.e
            java.lang.Throwable r2 = s6.k.a(r9)
            if (r2 != 0) goto L12
            r3 = r9
            goto L18
        L12:
            r7.p r3 = new r7.p
            r4 = 0
            r3.<init>(r4, r2)
        L18:
            w6.h r2 = r1.getContext()
            boolean r2 = r0.isDispatchNeeded(r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r10.f = r3
            r10.f12400c = r4
            w6.h r9 = r1.getContext()
            r0.dispatch(r9, r10)
            return
        L2f:
            r7.n0 r0 = r7.r1.a()
            long r5 = r0.f12416a
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r10.f = r3
            r10.f12400c = r4
            r0.n(r10)
            goto La8
        L46:
            r0.o(r4)
            w6.h r2 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            r7.t r3 = r7.t.f12437b     // Catch: java.lang.Throwable -> L69
            w6.f r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L69
            r7.a1 r2 = (r7.a1) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.isActive()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r9 = r2.e()     // Catch: java.lang.Throwable -> L69
            s6.j r9 = s6.a.b(r9)     // Catch: java.lang.Throwable -> L69
            r10.resumeWith(r9)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r9 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r10.g     // Catch: java.lang.Throwable -> L69
            w6.h r3 = r1.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = l(r3, r2)     // Catch: java.lang.Throwable -> L69
            e2.a r5 = w7.a.f13527d     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            r7.v1 r5 = r7.y.y(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.resumeWith(r9)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r9 = r5.f0()     // Catch: java.lang.Throwable -> L69
            if (r9 == 0) goto L8d
        L8a:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r9 = r0.q()     // Catch: java.lang.Throwable -> L69
            if (r9 != 0) goto L8d
        L93:
            r0.l(r4)
            goto La8
        L97:
            r9 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.f0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            g(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r9     // Catch: java.lang.Throwable -> L69
        La4:
            r10.h(r9)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.l(r4)
            throw r9
        Lae:
            r10.resumeWith(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.a.h(java.lang.Object, w6.c):void");
    }

    public static final long i(long j10, long j11, long j12, String str) {
        String property;
        int i10 = u.f13557a;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return j10;
        }
        Long lV = o7.t.V(property);
        if (lV == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + property + '\'').toString());
        }
        long jLongValue = lV.longValue();
        if (j11 <= jLongValue && jLongValue <= j12) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + jLongValue + '\'').toString());
    }

    public static int j(int i10, int i11, String str) {
        return (int) i(i10, 1, (i11 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static final Object k(w6.h hVar) {
        Object objFold = hVar.fold(0, e);
        objFold.getClass();
        return objFold;
    }

    public static final Object l(w6.h hVar, Object obj) {
        if (obj == null) {
            obj = k(hVar);
        }
        if (obj == 0) {
            return f13527d;
        }
        if (obj instanceof Integer) {
            return hVar.fold(new y(((Number) obj).intValue(), hVar), g);
        }
        v vVar = (v) obj;
        ThreadLocal threadLocal = vVar.f13559b;
        Object obj2 = threadLocal.get();
        threadLocal.set(vVar.f13558a);
        return obj2;
    }
}

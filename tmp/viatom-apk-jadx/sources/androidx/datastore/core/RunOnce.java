package androidx.datastore.core;

import a8.j;
import r7.l;
import r7.m;
import s6.w;
import y6.c;
import y6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class RunOnce {
    private final l didRun;
    private final a8.a runMutex = j.a();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {544, 497}, m = "runIfNeeded")
    /* renamed from: androidx.datastore.core.RunOnce$runIfNeeded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(w6.c cVar) {
            super(cVar);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RunOnce.this.runIfNeeded(this);
        }
    }

    public RunOnce() {
        m mVar = new m(true);
        mVar.L(null);
        this.didRun = mVar;
    }

    public final Object awaitComplete(w6.c cVar) throws Throwable {
        Object objV = ((m) this.didRun).v(cVar);
        return objV == x6.a.f13718a ? objV : w.f12711a;
    }

    public abstract Object doRun(w6.c cVar);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [a8.a] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5, types: [a8.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runIfNeeded(w6.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.RunOnce.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = (androidx.datastore.core.RunOnce.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.RunOnce$runIfNeeded$1 r0 = new androidx.datastore.core.RunOnce$runIfNeeded$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            int r1 = r0.label
            r2 = 2
            r3 = 1
            s6.w r4 = s6.w.f12711a
            r5 = 0
            x6.a r6 = x6.a.f13718a
            if (r1 == 0) goto L4a
            if (r1 == r3) goto L3e
            if (r1 != r2) goto L37
            java.lang.Object r1 = r0.L$1
            a8.a r1 = (a8.a) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.RunOnce r0 = (androidx.datastore.core.RunOnce) r0
            s6.a.e(r8)     // Catch: java.lang.Throwable -> L35
            goto L85
        L35:
            r8 = move-exception
            goto L90
        L37:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r8)
            r8 = 0
            return r8
        L3e:
            java.lang.Object r1 = r0.L$1
            a8.a r1 = (a8.a) r1
            java.lang.Object r3 = r0.L$0
            androidx.datastore.core.RunOnce r3 = (androidx.datastore.core.RunOnce) r3
            s6.a.e(r8)
            goto L69
        L4a:
            s6.a.e(r8)
            r7.l r8 = r7.didRun
            r7.i1 r8 = (r7.i1) r8
            boolean r8 = r8.N()
            if (r8 == 0) goto L58
            return r4
        L58:
            a8.a r8 = r7.runMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r1 = r8.lock(r5, r0)
            if (r1 != r6) goto L67
            goto L83
        L67:
            r3 = r7
            r1 = r8
        L69:
            r7.l r8 = r3.didRun     // Catch: java.lang.Throwable -> L35
            r7.i1 r8 = (r7.i1) r8     // Catch: java.lang.Throwable -> L35
            boolean r8 = r8.N()     // Catch: java.lang.Throwable -> L35
            if (r8 == 0) goto L77
            r1.unlock(r5)
            return r4
        L77:
            r0.L$0 = r3     // Catch: java.lang.Throwable -> L35
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L35
            r0.label = r2     // Catch: java.lang.Throwable -> L35
            java.lang.Object r8 = r3.doRun(r0)     // Catch: java.lang.Throwable -> L35
            if (r8 != r6) goto L84
        L83:
            return r6
        L84:
            r0 = r3
        L85:
            r7.l r8 = r0.didRun     // Catch: java.lang.Throwable -> L35
            r7.m r8 = (r7.m) r8     // Catch: java.lang.Throwable -> L35
            r8.P(r4)     // Catch: java.lang.Throwable -> L35
            r1.unlock(r5)
            return r4
        L90:
            r1.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.RunOnce.runIfNeeded(w6.c):java.lang.Object");
    }
}

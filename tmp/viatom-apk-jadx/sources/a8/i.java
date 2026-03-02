package a8;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.a0;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends n implements a {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(i.class, Object.class, "owner$volatile");
    private volatile /* synthetic */ Object owner$volatile;

    public i(boolean z9) {
        super(1, z9 ? 1 : 0);
        this.owner$volatile = z9 ? null : j.f317a;
        new b(this, 0);
    }

    @Override // a8.a
    public final z7.a getOnLock() {
        a0.b(3, g.f315a);
        a0.b(3, h.f316a);
        return new t3.h(20);
    }

    @Override // a8.a
    public final boolean holdsLock(Object obj) {
        char c10;
        while (true) {
            if (!isLocked()) {
                c10 = 0;
                break;
            }
            Object obj2 = h.get(this);
            if (obj2 != j.f317a) {
                c10 = obj2 == obj ? (char) 1 : (char) 2;
            }
        }
        return c10 == 1;
    }

    @Override // a8.a
    public final boolean isLocked() {
        return Math.max(n.g.get(this), 0) == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
    
        r6 = a8.i.h;
        r2 = r0.f311c;
        r6.set(r2, r0.f310b);
        r6 = r0.f309a;
        r6.A(r1, r6.f12400c, new a8.b(new a8.d(0, r2, r0), 2));
     */
    @Override // a8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object lock(java.lang.Object r6, w6.c r7) {
        /*
            r5 = this;
            boolean r0 = r5.tryLock(r6)
            s6.w r1 = s6.w.f12711a
            if (r0 == 0) goto L9
            goto L52
        L9:
            w6.c r7 = r0.f.F(r7)
            r7.g r7 = r7.y.n(r7)
            a8.e r0 = new a8.e     // Catch: java.lang.Throwable -> L53
            r0.<init>(r5, r7, r6)     // Catch: java.lang.Throwable -> L53
        L16:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r6 = a8.n.g     // Catch: java.lang.Throwable -> L53
            int r6 = r6.getAndDecrement(r5)     // Catch: java.lang.Throwable -> L53
            int r2 = r5.f323a     // Catch: java.lang.Throwable -> L53
            if (r6 > r2) goto L16
            if (r6 <= 0) goto L3f
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = a8.i.h     // Catch: java.lang.Throwable -> L53
            a8.i r2 = r0.f311c     // Catch: java.lang.Throwable -> L53
            java.lang.Object r3 = r0.f310b     // Catch: java.lang.Throwable -> L53
            r6.set(r2, r3)     // Catch: java.lang.Throwable -> L53
            r7.g r6 = r0.f309a     // Catch: java.lang.Throwable -> L53
            a8.d r3 = new a8.d     // Catch: java.lang.Throwable -> L53
            r4 = 0
            r3.<init>(r4, r2, r0)     // Catch: java.lang.Throwable -> L53
            int r0 = r6.f12400c     // Catch: java.lang.Throwable -> L53
            a8.b r2 = new a8.b     // Catch: java.lang.Throwable -> L53
            r4 = 2
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L53
            r6.A(r1, r0, r2)     // Catch: java.lang.Throwable -> L53
            goto L45
        L3f:
            boolean r6 = r5.a(r0)     // Catch: java.lang.Throwable -> L53
            if (r6 == 0) goto L16
        L45:
            java.lang.Object r6 = r7.q()
            x6.a r7 = x6.a.f13718a
            if (r6 != r7) goto L4e
            goto L4f
        L4e:
            r6 = r1
        L4f:
            if (r6 != r7) goto L52
            return r6
        L52:
            return r1
        L53:
            r6 = move-exception
            r7.z()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.i.lock(java.lang.Object, w6.c):java.lang.Object");
    }

    public final String toString() {
        return "Mutex@" + y.m(this) + "[isLocked=" + isLocked() + ",owner=" + h.get(this) + ']';
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        return false;
     */
    @Override // a8.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean tryLock(java.lang.Object r7) {
        /*
            r6 = this;
        L0:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = a8.n.g
            int r1 = r0.get(r6)
            int r2 = r6.f323a
            if (r1 <= r2) goto L17
        La:
            int r1 = r0.get(r6)
            if (r1 <= r2) goto L0
            boolean r1 = r0.compareAndSet(r6, r1, r2)
            if (r1 == 0) goto La
            goto L0
        L17:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = a8.i.h
            r3 = 1
            if (r1 > 0) goto L43
            r4 = 0
            if (r7 != 0) goto L20
            goto L3b
        L20:
            boolean r0 = r6.isLocked()
            r1 = 2
            if (r0 != 0) goto L29
            r0 = r4
            goto L36
        L29:
            java.lang.Object r0 = r2.get(r6)
            e2.a r5 = a8.j.f317a
            if (r0 == r5) goto L20
            if (r0 != r7) goto L35
            r0 = r3
            goto L36
        L35:
            r0 = r1
        L36:
            if (r0 == r3) goto L3c
            if (r0 == r1) goto L3b
            goto L0
        L3b:
            return r4
        L3c:
            java.lang.String r0 = "This mutex is already locked by the specified owner: "
            p8.u.i(r7, r0)
            r7 = 0
            return r7
        L43:
            int r4 = r1 + (-1)
            boolean r0 = r0.compareAndSet(r6, r1, r4)
            if (r0 == 0) goto L0
            r2.set(r6, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a8.i.tryLock(java.lang.Object):boolean");
    }

    @Override // a8.a
    public final void unlock(Object obj) {
        while (isLocked()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            e2.a aVar = j.f317a;
            if (obj2 != aVar) {
                if (obj2 == obj || obj == null) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, aVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj2) {
                            break;
                        }
                    }
                    b();
                    return;
                }
                throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
            }
        }
        androidx.window.layout.c.g("This mutex is not locked");
    }
}

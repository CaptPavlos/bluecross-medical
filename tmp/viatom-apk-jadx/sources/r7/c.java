package r7;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name */
    public final Thread f12391d;
    public final n0 e;

    public c(w6.h hVar, Thread thread, n0 n0Var) {
        super(hVar, true);
        this.f12391d = thread;
        this.e = n0Var;
    }

    @Override // r7.i1
    public final void t(Object obj) {
        Thread threadCurrentThread = Thread.currentThread();
        Thread thread = this.f12391d;
        if (kotlin.jvm.internal.l.a(threadCurrentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}

package r7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f0 extends w7.r {
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(f0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // w7.r, r7.i1
    public final void t(Object obj) {
        u(obj);
    }

    @Override // w7.r, r7.i1
    public final void u(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = e;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 1) {
                    androidx.window.layout.c.g("Already resumed");
                    return;
                } else {
                    w7.a.h(y.s(obj), r0.f.F(this.f13553d));
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}

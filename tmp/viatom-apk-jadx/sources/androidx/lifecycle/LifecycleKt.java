package androidx.lifecycle;

import r7.i0;
import r7.q1;
import r7.y;
import w7.n;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class LifecycleKt {
    public static final LifecycleCoroutineScope getCoroutineScope(Lifecycle lifecycle) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        lifecycle.getClass();
        do {
            LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl2 = (LifecycleCoroutineScopeImpl) lifecycle.getInternalScopeRef().get();
            if (lifecycleCoroutineScopeImpl2 != null) {
                return lifecycleCoroutineScopeImpl2;
            }
            q1 q1VarC = y.c();
            y7.e eVar = i0.f12407a;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, t1.M(q1VarC, n.f13548a.f12716c));
        } while (!lifecycle.getInternalScopeRef().compareAndSet(null, lifecycleCoroutineScopeImpl));
        lifecycleCoroutineScopeImpl.register();
        return lifecycleCoroutineScopeImpl;
    }

    public static final u7.h getEventFlow(Lifecycle lifecycle) {
        lifecycle.getClass();
        u7.c cVarD = u7.i0.d(new LifecycleKt$eventFlow$1(lifecycle, null));
        y7.e eVar = i0.f12407a;
        return u7.i0.k(cVarD, n.f13548a.f12716c);
    }
}

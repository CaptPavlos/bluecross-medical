package androidx.lifecycle;

import r7.i0;
import r7.s;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class PausingDispatcher extends s {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // r7.s
    public void dispatch(w6.h hVar, Runnable runnable) {
        hVar.getClass();
        runnable.getClass();
        this.dispatchQueue.dispatchAndEnqueue(hVar, runnable);
    }

    @Override // r7.s
    public boolean isDispatchNeeded(w6.h hVar) {
        hVar.getClass();
        y7.e eVar = i0.f12407a;
        if (n.f13548a.f12716c.isDispatchNeeded(hVar)) {
            return true;
        }
        return !this.dispatchQueue.canRun();
    }
}

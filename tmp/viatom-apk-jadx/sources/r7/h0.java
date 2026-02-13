package r7;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final s f12402a;

    public h0(s sVar) {
        this.f12402a = sVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        s sVar = this.f12402a;
        w6.i iVar = w6.i.f13523a;
        if (sVar.isDispatchNeeded(iVar)) {
            sVar.dispatch(iVar, runnable);
        } else {
            runnable.run();
        }
    }

    public final String toString() {
        return this.f12402a.toString();
    }
}

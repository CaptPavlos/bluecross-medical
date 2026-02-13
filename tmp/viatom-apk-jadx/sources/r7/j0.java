package r7;

import java.util.concurrent.ScheduledFuture;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledFuture f12410a;

    public j0(ScheduledFuture scheduledFuture) {
        this.f12410a = scheduledFuture;
    }

    @Override // r7.k0
    public final void dispose() {
        this.f12410a.cancel(false);
    }

    public final String toString() {
        return "DisposableFutureHandle[" + this.f12410a + ']';
    }
}

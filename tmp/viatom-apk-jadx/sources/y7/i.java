package y7;

import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f14123c;

    public i(Runnable runnable, long j10, boolean z9) {
        super(j10, z9);
        this.f14123c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f14123c.run();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f14123c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(y.m(runnable));
        sb.append(", ");
        sb.append(this.f14121a);
        sb.append(", ");
        return a3.a.m(sb, this.f14122b ? "Blocking" : "Non-blocking", ']');
    }
}

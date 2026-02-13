package z8;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class q implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f14502a;

    public q(f0 f0Var) {
        f0Var.getClass();
        this.f14502a = f0Var;
    }

    @Override // z8.f0
    public void c(i iVar, long j10) {
        this.f14502a.c(iVar, j10);
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14502a.close();
    }

    @Override // z8.f0, java.io.Flushable
    public void flush() {
        this.f14502a.flush();
    }

    @Override // z8.f0
    public final j0 timeout() {
        return this.f14502a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f14502a + ')';
    }
}

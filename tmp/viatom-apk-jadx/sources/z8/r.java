package z8;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class r implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final h0 f14503a;

    public r(h0 h0Var) {
        h0Var.getClass();
        this.f14503a = h0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f14503a.close();
    }

    @Override // z8.h0
    public long g(i iVar, long j10) {
        iVar.getClass();
        return this.f14503a.g(iVar, j10);
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f14503a.timeout();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f14503a + ')';
    }
}

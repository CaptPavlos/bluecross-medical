package z8;

import java.io.EOFException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements f0 {
    @Override // z8.f0
    public final void c(i iVar, long j10) throws EOFException {
        iVar.skip(j10);
    }

    @Override // z8.f0
    public final j0 timeout() {
        return j0.f14480d;
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // z8.f0, java.io.Flushable
    public final void flush() {
    }
}

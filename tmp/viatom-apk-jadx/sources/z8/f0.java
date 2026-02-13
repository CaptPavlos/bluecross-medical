package z8;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface f0 extends Closeable, Flushable {
    void c(i iVar, long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void flush();

    j0 timeout();
}

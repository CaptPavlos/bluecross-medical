package p8;

import java.io.Closeable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d0 implements Closeable {
    public abstract long a();

    public abstract z8.k b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q8.c.c(b());
    }
}

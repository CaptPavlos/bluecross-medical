package u8;

import java.io.IOException;
import z8.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends a {
    public boolean e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.f13076b) {
            return;
        }
        if (!this.e) {
            a(false, null);
        }
        this.f13076b = true;
    }

    @Override // u8.a, z8.h0
    public final long g(i iVar, long j10) throws IOException {
        if (j10 < 0) {
            com.google.gson.internal.a.n(a3.a.h(j10, "byteCount < 0: "));
            return 0L;
        }
        if (this.f13076b) {
            androidx.window.layout.c.g("closed");
            return 0L;
        }
        if (this.e) {
            return -1L;
        }
        long jG = super.g(iVar, j10);
        if (jG != -1) {
            return jG;
        }
        this.e = true;
        a(true, null);
        return -1L;
    }
}

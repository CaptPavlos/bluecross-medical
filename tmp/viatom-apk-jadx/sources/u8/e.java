package u8;

import java.io.IOException;
import java.net.ProtocolException;
import z8.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends a {
    public long e;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zP;
        if (this.f13076b) {
            return;
        }
        if (this.e != 0) {
            try {
                zP = q8.c.p(this, 100);
            } catch (IOException unused) {
                zP = false;
            }
            if (!zP) {
                a(false, null);
            }
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
        long j11 = this.e;
        if (j11 == 0) {
            return -1L;
        }
        long jG = super.g(iVar, Math.min(j11, j10));
        if (jG == -1) {
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            a(false, protocolException);
            throw protocolException;
        }
        long j12 = this.e - jG;
        this.e = j12;
        if (j12 == 0) {
            a(true, null);
        }
        return jG;
    }
}

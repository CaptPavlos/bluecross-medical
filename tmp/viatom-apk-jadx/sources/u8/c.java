package u8;

import java.io.IOException;
import p8.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends a {
    public final s e;
    public long f;
    public boolean g;
    public final /* synthetic */ g h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(g gVar, s sVar) {
        super(gVar);
        this.h = gVar;
        this.f = -1L;
        this.g = true;
        this.e = sVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        boolean zP;
        if (this.f13076b) {
            return;
        }
        if (this.g) {
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

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
    
        if (r16.g == false) goto L34;
     */
    @Override // u8.a, z8.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long g(z8.i r17, long r18) throws java.lang.InterruptedException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u8.c.g(z8.i, long):long");
    }
}

package u8;

import z8.f0;
import z8.i;
import z8.j;
import z8.j0;
import z8.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final s f13079a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13080b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f13081c;

    public b(g gVar) {
        this.f13081c = gVar;
        this.f13079a = new s(gVar.f13089d.timeout());
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) {
        j jVar = this.f13081c.f13089d;
        if (this.f13080b) {
            androidx.window.layout.c.g("closed");
        } else {
            if (j10 == 0) {
                return;
            }
            jVar.writeHexadecimalUnsignedLong(j10);
            jVar.writeUtf8("\r\n");
            jVar.c(iVar, j10);
            jVar.writeUtf8("\r\n");
        }
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.f13080b) {
            return;
        }
        this.f13080b = true;
        this.f13081c.f13089d.writeUtf8("0\r\n\r\n");
        s sVar = this.f13079a;
        j0 j0Var = sVar.e;
        sVar.e = j0.f14480d;
        j0Var.a();
        j0Var.b();
        this.f13081c.e = 3;
    }

    @Override // z8.f0, java.io.Flushable
    public final synchronized void flush() {
        if (this.f13080b) {
            return;
        }
        this.f13081c.f13089d.flush();
    }

    @Override // z8.f0
    public final j0 timeout() {
        return this.f13079a;
    }
}

package u8;

import java.net.ProtocolException;
import z8.f0;
import z8.i;
import z8.j0;
import z8.s;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements f0 {

    /* renamed from: a, reason: collision with root package name */
    public final s f13082a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13083b;

    /* renamed from: c, reason: collision with root package name */
    public long f13084c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f13085d;

    public d(g gVar, long j10) {
        this.f13085d = gVar;
        this.f13082a = new s(gVar.f13089d.timeout());
        this.f13084c = j10;
    }

    @Override // z8.f0
    public final void c(i iVar, long j10) throws ProtocolException {
        if (this.f13083b) {
            androidx.window.layout.c.g("closed");
            return;
        }
        long j11 = iVar.f14479b;
        byte[] bArr = q8.c.f12289a;
        if (j10 < 0 || 0 > j11 || j11 < j10) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (j10 <= this.f13084c) {
            this.f13085d.f13089d.c(iVar, j10);
            this.f13084c -= j10;
            return;
        }
        throw new ProtocolException("expected " + this.f13084c + " bytes but received " + j10);
    }

    @Override // z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws ProtocolException {
        if (this.f13083b) {
            return;
        }
        this.f13083b = true;
        if (this.f13084c > 0) {
            throw new ProtocolException("unexpected end of stream");
        }
        s sVar = this.f13082a;
        j0 j0Var = sVar.e;
        sVar.e = j0.f14480d;
        j0Var.a();
        j0Var.b();
        this.f13085d.e = 3;
    }

    @Override // z8.f0, java.io.Flushable
    public final void flush() {
        if (this.f13083b) {
            return;
        }
        this.f13085d.f13089d.flush();
    }

    @Override // z8.f0
    public final j0 timeout() {
        return this.f13082a;
    }
}

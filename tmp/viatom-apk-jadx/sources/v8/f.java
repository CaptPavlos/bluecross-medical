package v8;

import java.io.IOException;
import z8.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f extends z8.r {

    /* renamed from: b, reason: collision with root package name */
    public boolean f13220b;

    /* renamed from: c, reason: collision with root package name */
    public long f13221c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f13222d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(g gVar, h0 h0Var) {
        super(h0Var);
        this.f13222d = gVar;
        this.f13220b = false;
        this.f13221c = 0L;
    }

    @Override // z8.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        if (this.f13220b) {
            return;
        }
        this.f13220b = true;
        g gVar = this.f13222d;
        gVar.f13224b.h(false, gVar, null);
    }

    @Override // z8.r, z8.h0
    public final long g(z8.i iVar, long j10) throws IOException {
        try {
            long jG = this.f14503a.g(iVar, j10);
            if (jG <= 0) {
                return jG;
            }
            this.f13221c += jG;
            return jG;
        } catch (IOException e) {
            if (!this.f13220b) {
                this.f13220b = true;
                g gVar = this.f13222d;
                gVar.f13224b.h(false, gVar, e);
            }
            throw e;
        }
    }
}

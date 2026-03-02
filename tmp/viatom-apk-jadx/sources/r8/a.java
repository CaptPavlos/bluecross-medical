package r8;

import java.io.IOException;
import z8.a0;
import z8.h0;
import z8.i;
import z8.j0;
import z8.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f12458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f12459b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b9.b f12460c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a0 f12461d;

    public a(k kVar, b9.b bVar, a0 a0Var) {
        this.f12459b = kVar;
        this.f12460c = bVar;
        this.f12461d = a0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        boolean zP;
        if (!this.f12458a) {
            try {
                zP = q8.c.p(this, 100);
            } catch (IOException unused) {
                zP = false;
            }
            if (!zP) {
                this.f12458a = true;
                this.f12460c.b();
            }
        }
        this.f12459b.close();
    }

    @Override // z8.h0
    public final long g(i iVar, long j10) throws IOException {
        try {
            long jG = this.f12459b.g(iVar, j10);
            a0 a0Var = this.f12461d;
            if (jG != -1) {
                iVar.a(a0Var.f14451b, iVar.f14479b - jG, jG);
                a0Var.a();
                return jG;
            }
            if (!this.f12458a) {
                this.f12458a = true;
                a0Var.close();
            }
            return -1L;
        } catch (IOException e) {
            if (this.f12458a) {
                throw e;
            }
            this.f12458a = true;
            this.f12460c.b();
            throw e;
        }
    }

    @Override // z8.h0
    public final j0 timeout() {
        return this.f12459b.timeout();
    }
}

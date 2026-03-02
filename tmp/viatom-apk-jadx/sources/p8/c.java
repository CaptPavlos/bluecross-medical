package p8;

import c1.g1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends z8.q {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g1 f12072b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b9.b f12073c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b9.b bVar, z8.f0 f0Var, g1 g1Var) {
        super(f0Var);
        this.f12073c = bVar;
        this.f12072b = g1Var;
    }

    @Override // z8.q, z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (((g) this.f12073c.e)) {
            try {
                b9.b bVar = this.f12073c;
                if (bVar.f859b) {
                    return;
                }
                bVar.f859b = true;
                super.close();
                this.f12072b.c();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

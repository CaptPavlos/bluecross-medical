package z8;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s extends j0 {
    public j0 e;

    public s(j0 j0Var) {
        j0Var.getClass();
        this.e = j0Var;
    }

    @Override // z8.j0
    public final j0 a() {
        return this.e.a();
    }

    @Override // z8.j0
    public final j0 b() {
        return this.e.b();
    }

    @Override // z8.j0
    public final long c() {
        return this.e.c();
    }

    @Override // z8.j0
    public final j0 d(long j10) {
        return this.e.d(j10);
    }

    @Override // z8.j0
    public final boolean e() {
        return this.e.e();
    }

    @Override // z8.j0
    public final void f() throws InterruptedIOException {
        this.e.f();
    }

    @Override // z8.j0
    public final j0 g(long j10) {
        TimeUnit.MILLISECONDS.getClass();
        return this.e.g(j10);
    }
}

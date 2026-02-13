package j$.util.stream;

import java.util.function.DoublePredicate;

/* loaded from: classes2.dex */
public final class o8 extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9698b;

    public o8(e6 e6Var, m5 m5Var) {
        super(m5Var);
        this.f9698b = true;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9576a.c(-1L);
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        if (this.f9698b) {
            DoublePredicate doublePredicate = null;
            doublePredicate.test(d8);
            throw null;
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final boolean e() {
        return !this.f9698b || this.f9576a.e();
    }
}

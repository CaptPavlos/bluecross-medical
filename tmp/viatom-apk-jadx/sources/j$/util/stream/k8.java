package j$.util.stream;

import java.util.function.IntPredicate;

/* loaded from: classes2.dex */
public final class k8 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9648b;

    public k8(f6 f6Var, m5 m5Var) {
        super(m5Var);
        this.f9648b = true;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9586a.c(-1L);
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        if (this.f9648b) {
            IntPredicate intPredicate = null;
            intPredicate.test(i10);
            throw null;
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        return !this.f9648b || this.f9586a.e();
    }
}

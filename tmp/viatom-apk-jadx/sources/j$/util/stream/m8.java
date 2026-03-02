package j$.util.stream;

import java.util.function.LongPredicate;

/* loaded from: classes2.dex */
public final class m8 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9672b;

    public m8(g6 g6Var, m5 m5Var) {
        super(m5Var);
        this.f9672b = true;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9595a.c(-1L);
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        if (this.f9672b) {
            LongPredicate longPredicate = null;
            longPredicate.test(j10);
            throw null;
        }
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final boolean e() {
        return !this.f9672b || this.f9595a.e();
    }
}

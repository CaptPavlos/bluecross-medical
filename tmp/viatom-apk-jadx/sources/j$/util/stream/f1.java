package j$.util.stream;

import j$.util.Objects;
import java.util.function.LongConsumer;

/* loaded from: classes2.dex */
public final class f1 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f9572b;

    /* renamed from: c, reason: collision with root package name */
    public final j$.util.n0 f9573c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g1 f9574d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(g1 g1Var, m5 m5Var) {
        super(m5Var);
        this.f9574d = g1Var;
        m5 m5Var2 = this.f9595a;
        Objects.requireNonNull(m5Var2);
        this.f9573c = new j$.util.n0(m5Var2, 1);
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9595a.c(-1L);
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) throws Exception {
        n1 n1Var = (n1) ((j$.util.q) this.f9574d.f9582m).apply(j10);
        if (n1Var != null) {
            try {
                boolean z9 = this.f9572b;
                j$.util.n0 n0Var = this.f9573c;
                if (!z9) {
                    n1Var.sequential().forEach(n0Var);
                } else {
                    j$.util.b1 b1VarSpliterator = n1Var.sequential().spliterator();
                    while (!this.f9595a.e() && b1VarSpliterator.tryAdvance((LongConsumer) n0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    n1Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (n1Var != null) {
            n1Var.close();
        }
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final boolean e() {
        this.f9572b = true;
        return this.f9595a.e();
    }
}

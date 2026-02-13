package j$.util.stream;

import j$.util.Objects;
import java.util.function.IntConsumer;

/* loaded from: classes2.dex */
public final class x0 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f9798b;

    /* renamed from: c, reason: collision with root package name */
    public final j$.util.j0 f9799c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v0 f9800d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(v0 v0Var, m5 m5Var) {
        super(m5Var);
        this.f9800d = v0Var;
        m5 m5Var2 = this.f9586a;
        Objects.requireNonNull(m5Var2);
        this.f9799c = new j$.util.j0(m5Var2, 1);
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9586a.c(-1L);
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) throws Exception {
        IntStream intStream = (IntStream) ((m0) this.f9800d.f9775m).apply(i10);
        if (intStream != null) {
            try {
                boolean z9 = this.f9798b;
                j$.util.j0 j0Var = this.f9799c;
                if (!z9) {
                    intStream.sequential().forEach(j0Var);
                } else {
                    j$.util.y0 y0VarSpliterator = intStream.sequential().spliterator();
                    while (!this.f9586a.e() && y0VarSpliterator.tryAdvance((IntConsumer) j0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        this.f9798b = true;
        return this.f9586a.e();
    }
}

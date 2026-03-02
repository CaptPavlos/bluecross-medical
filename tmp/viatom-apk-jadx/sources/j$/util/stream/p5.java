package j$.util.stream;

/* loaded from: classes2.dex */
public final class p5 extends g5 {

    /* renamed from: b, reason: collision with root package name */
    public long f9707b;

    /* renamed from: c, reason: collision with root package name */
    public long f9708c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q5 f9709d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p5(q5 q5Var, m5 m5Var) {
        super(m5Var);
        this.f9709d = q5Var;
        this.f9707b = q5Var.f9715l;
        long j10 = q5Var.f9716m;
        this.f9708c = j10 < 0 ? Long.MAX_VALUE : j10;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9586a.c(w3.x(j10, this.f9709d.f9715l, this.f9708c));
    }

    @Override // j$.util.stream.k5, j$.util.stream.m5
    public final void accept(int i10) {
        long j10 = this.f9707b;
        if (j10 == 0) {
            long j11 = this.f9708c;
            if (j11 > 0) {
                this.f9708c = j11 - 1;
                this.f9586a.accept(i10);
                return;
            }
            return;
        }
        this.f9707b = j10 - 1;
    }

    @Override // j$.util.stream.g5, j$.util.stream.m5
    public final boolean e() {
        return this.f9708c == 0 || this.f9586a.e();
    }
}

package j$.util.stream;

/* loaded from: classes2.dex */
public final class t5 extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public long f9748b;

    /* renamed from: c, reason: collision with root package name */
    public long f9749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ u5 f9750d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t5(u5 u5Var, m5 m5Var) {
        super(m5Var);
        this.f9750d = u5Var;
        this.f9748b = u5Var.f9763l;
        long j10 = u5Var.f9764m;
        this.f9749c = j10 < 0 ? Long.MAX_VALUE : j10;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9576a.c(w3.x(j10, this.f9750d.f9763l, this.f9749c));
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d8) {
        long j10 = this.f9748b;
        if (j10 == 0) {
            long j11 = this.f9749c;
            if (j11 > 0) {
                this.f9749c = j11 - 1;
                this.f9576a.accept(d8);
                return;
            }
            return;
        }
        this.f9748b = j10 - 1;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public final boolean e() {
        return this.f9749c == 0 || this.f9576a.e();
    }
}

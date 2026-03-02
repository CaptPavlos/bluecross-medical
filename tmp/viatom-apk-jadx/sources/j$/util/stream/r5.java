package j$.util.stream;

/* loaded from: classes2.dex */
public final class r5 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public long f9720b;

    /* renamed from: c, reason: collision with root package name */
    public long f9721c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ s5 f9722d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r5(s5 s5Var, m5 m5Var) {
        super(m5Var);
        this.f9722d = s5Var;
        this.f9720b = s5Var.f9733l;
        long j10 = s5Var.f9734m;
        this.f9721c = j10 < 0 ? Long.MAX_VALUE : j10;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9595a.c(w3.x(j10, this.f9722d.f9733l, this.f9721c));
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j10) {
        long j11 = this.f9720b;
        if (j11 == 0) {
            long j12 = this.f9721c;
            if (j12 > 0) {
                this.f9721c = j12 - 1;
                this.f9595a.accept(j10);
                return;
            }
            return;
        }
        this.f9720b = j11 - 1;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public final boolean e() {
        return this.f9721c == 0 || this.f9595a.e();
    }
}

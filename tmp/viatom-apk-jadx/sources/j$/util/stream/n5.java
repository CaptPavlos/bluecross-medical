package j$.util.stream;

/* loaded from: classes2.dex */
public final class n5 extends i5 {

    /* renamed from: b, reason: collision with root package name */
    public long f9679b;

    /* renamed from: c, reason: collision with root package name */
    public long f9680c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ o5 f9681d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(o5 o5Var, m5 m5Var) {
        super(m5Var);
        this.f9681d = o5Var;
        this.f9679b = o5Var.f9696l;
        long j10 = o5Var.f9697m;
        this.f9680c = j10 < 0 ? Long.MAX_VALUE : j10;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final void c(long j10) {
        this.f9607a.c(w3.x(j10, this.f9681d.f9696l, this.f9680c));
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        long j10 = this.f9679b;
        if (j10 == 0) {
            long j11 = this.f9680c;
            if (j11 > 0) {
                this.f9680c = j11 - 1;
                this.f9607a.n((m5) obj);
                return;
            }
            return;
        }
        this.f9679b = j10 - 1;
    }

    @Override // j$.util.stream.i5, j$.util.stream.m5
    public final boolean e() {
        return this.f9680c == 0 || this.f9607a.e();
    }
}

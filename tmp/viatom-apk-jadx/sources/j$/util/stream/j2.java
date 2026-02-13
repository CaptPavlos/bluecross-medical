package j$.util.stream;

/* loaded from: classes2.dex */
public abstract class j2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final h2 f9618a;

    /* renamed from: b, reason: collision with root package name */
    public final h2 f9619b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9620c;

    @Override // j$.util.stream.h2
    public final int o() {
        return 2;
    }

    public j2(h2 h2Var, h2 h2Var2) {
        this.f9618a = h2Var;
        this.f9619b = h2Var2;
        this.f9620c = h2Var2.count() + h2Var.count();
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i10) {
        if (i10 == 0) {
            return this.f9618a;
        }
        if (i10 == 1) {
            return this.f9619b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f9620c;
    }

    @Override // j$.util.stream.h2
    public /* bridge */ /* synthetic */ g2 a(int i10) {
        return (g2) a(i10);
    }
}

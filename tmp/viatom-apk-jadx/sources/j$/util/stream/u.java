package j$.util.stream;

/* loaded from: classes2.dex */
public final class u extends a1 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9757l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(a aVar, int i10, int i11) {
        super(aVar, i10);
        this.f9757l = i11;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        switch (this.f9757l) {
            case 0:
                return new s(this, m5Var, 1);
            case 1:
                return new w0(this, m5Var, 2);
            case 2:
                return m5Var;
            case 3:
                return new w0(this, m5Var, 5);
            default:
                return new e1(this, m5Var, 2);
        }
    }
}

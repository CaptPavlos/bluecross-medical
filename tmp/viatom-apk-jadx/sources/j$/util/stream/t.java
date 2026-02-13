package j$.util.stream;

/* loaded from: classes2.dex */
public final class t extends a0 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9739l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(a aVar, int i10, int i11) {
        super(aVar, i10);
        this.f9739l = i11;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        switch (this.f9739l) {
            case 0:
                return new s(this, m5Var, 0);
            case 1:
                return m5Var;
            case 2:
                return new s(this, m5Var, 3);
            case 3:
                return new w0(1, m5Var);
            case 4:
                return new w0(this, m5Var, 4);
            case 5:
                return new e1(m5Var);
            default:
                return new e1(this, m5Var, 3);
        }
    }
}

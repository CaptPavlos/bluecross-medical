package j$.util.stream;

import java.util.function.DoubleConsumer;

/* loaded from: classes2.dex */
public final class x extends a0 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9796l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f9797m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(a aVar, int i10, Object obj, int i11) {
        super(aVar, i10);
        this.f9796l = i11;
        this.f9797m = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b0 b0Var, DoubleConsumer doubleConsumer) {
        super(b0Var, 0);
        this.f9796l = 1;
        this.f9797m = doubleConsumer;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        switch (this.f9796l) {
            case 0:
                return new w(this, m5Var);
            case 1:
                return new o(this, m5Var, 1);
            case 2:
                return new m(this, m5Var, 6);
            default:
                return new z4(this, m5Var);
        }
    }
}

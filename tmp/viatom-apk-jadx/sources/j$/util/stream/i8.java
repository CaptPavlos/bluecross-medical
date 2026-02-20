package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: classes2.dex */
public final class i8 extends c5 implements q8 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9613l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Predicate f9614m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i8(e5 e5Var, int i10, Predicate predicate, int i11) {
        super(e5Var, i10);
        this.f9613l = i11;
        this.f9614m = predicate;
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        switch (this.f9613l) {
            case 0:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(9)).spliterator() : new x8(aVar.S(spliterator), this.f9614m, 1);
            default:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(9)).spliterator() : new x8(aVar.S(spliterator), this.f9614m, 0);
        }
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f9613l) {
            case 0:
                return (h2) new t8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (h2) new s8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        switch (this.f9613l) {
            case 0:
                return new l(this, m5Var);
            default:
                return new j8(this, m5Var, false);
        }
    }

    @Override // j$.util.stream.q8
    public r8 g(z1 z1Var, boolean z9) {
        return new j8(this, z1Var, z9);
    }
}

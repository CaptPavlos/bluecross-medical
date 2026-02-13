package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class f6 extends z0 implements q8 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f9577l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f6(a aVar, int i10, int i11) {
        super(aVar, i10);
        this.f9577l = i11;
    }

    @Override // j$.util.stream.a
    public Spliterator K(a aVar, Spliterator spliterator) {
        switch (this.f9577l) {
            case 1:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(23)).spliterator() : new v8((j$.util.y0) aVar.S(spliterator), 1);
            case 2:
                return z6.ORDERED.j(aVar.f) ? J(aVar, spliterator, new d1(24)).spliterator() : new v8((j$.util.y0) aVar.S(spliterator), 0);
            default:
                return super.K(aVar, spliterator);
        }
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f9577l) {
            case 0:
                if (z6.SORTED.j(aVar.f)) {
                    return aVar.B(spliterator, false, intFunction);
                }
                int[] iArr = (int[]) ((d2) aVar.B(spliterator, true, intFunction)).b();
                Arrays.sort(iArr);
                return new c3(iArr);
            case 1:
                return (h2) new t8(this, aVar, spliterator, intFunction).invoke();
            default:
                return (h2) new s8(this, aVar, spliterator, intFunction).invoke();
        }
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        switch (this.f9577l) {
            case 0:
                Objects.requireNonNull(m5Var);
                if (z6.SORTED.j(i10)) {
                    return m5Var;
                }
                return z6.SIZED.j(i10) ? new k6(m5Var) : new c6(m5Var);
            case 1:
                return new k8(this, m5Var);
            default:
                return new l8(this, m5Var, false);
        }
    }

    @Override // j$.util.stream.q8
    public r8 g(z1 z1Var, boolean z9) {
        return new l8(this, z1Var, z9);
    }
}

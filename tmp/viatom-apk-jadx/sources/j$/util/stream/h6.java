package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

/* loaded from: classes2.dex */
public final class h6 extends c5 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f9596l;

    /* renamed from: m, reason: collision with root package name */
    public final Comparator f9597m;

    public h6(e5 e5Var) {
        super(e5Var, z6.f9827q | z6.f9825o);
        this.f9596l = true;
        this.f9597m = j$.util.f.INSTANCE;
    }

    public h6(e5 e5Var, Comparator comparator) {
        super(e5Var, z6.f9827q | z6.f9826p);
        this.f9596l = false;
        this.f9597m = (Comparator) Objects.requireNonNull(comparator);
    }

    @Override // j$.util.stream.a
    public final m5 M(int i10, m5 m5Var) {
        Objects.requireNonNull(m5Var);
        if (z6.SORTED.j(i10) && this.f9596l) {
            return m5Var;
        }
        boolean zJ = z6.SIZED.j(i10);
        Comparator comparator = this.f9597m;
        if (zJ) {
            return new m6(m5Var, comparator);
        }
        return new i6(m5Var, comparator);
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        if (z6.SORTED.j(aVar.f) && this.f9596l) {
            return aVar.B(spliterator, false, intFunction);
        }
        Object[] objArrM = aVar.B(spliterator, true, intFunction).m(intFunction);
        Arrays.sort(objArrM, this.f9597m);
        return new k2(objArrM);
    }
}

package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public final class f0 implements f8 {

    /* renamed from: a, reason: collision with root package name */
    public final int f9568a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f9569b;

    /* renamed from: c, reason: collision with root package name */
    public final Predicate f9570c;

    /* renamed from: d, reason: collision with root package name */
    public final Supplier f9571d;

    public f0(boolean z9, a7 a7Var, Object obj, Predicate predicate, Supplier supplier) {
        this.f9568a = (z9 ? 0 : z6.f9828r) | z6.f9830u;
        this.f9569b = obj;
        this.f9570c = predicate;
        this.f9571d = supplier;
    }

    @Override // j$.util.stream.f8
    public final int f() {
        return this.f9568a;
    }

    @Override // j$.util.stream.f8
    public final Object a(a aVar, Spliterator spliterator) {
        g8 g8Var = (g8) this.f9571d.get();
        aVar.Q(spliterator, g8Var);
        Object obj = g8Var.get();
        return obj != null ? obj : this.f9569b;
    }

    @Override // j$.util.stream.f8
    public final Object b(a aVar, Spliterator spliterator) {
        return new l0(this, z6.ORDERED.j(aVar.f), aVar, spliterator).invoke();
    }
}

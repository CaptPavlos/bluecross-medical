package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public abstract class k1 extends a implements n1 {
    @Override // j$.util.stream.n1
    public final j$.util.e0 findAny() {
        return (j$.util.e0) C(i0.f9602d);
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 findFirst() {
        return (j$.util.e0) C(i0.f9601c);
    }

    @Override // j$.util.stream.n1
    public final n1 sorted() {
        return new g6(this, z6.f9827q | z6.f9825o, 0);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new p0(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        C(new p0(longConsumer, true));
    }

    public static j$.util.b1 T(Spliterator spliterator) {
        if (spliterator instanceof j$.util.b1) {
            return (j$.util.b1) spliterator;
        }
        if (h8.f9599a) {
            h8.a(a.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // j$.util.stream.a
    public final a7 H() {
        return a7.LONG_VALUE;
    }

    @Override // j$.util.stream.a
    public final h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        return w3.E(aVar, spliterator, z9);
    }

    @Override // j$.util.stream.a
    public final Spliterator P(a aVar, Supplier supplier, boolean z9) {
        return new o7(aVar, supplier, z9);
    }

    @Override // j$.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        LongConsumer n0Var;
        boolean zE;
        j$.util.b1 b1VarT = T(spliterator);
        if (m5Var instanceof LongConsumer) {
            n0Var = (LongConsumer) m5Var;
        } else {
            if (h8.f9599a) {
                h8.a(a.class, "using LongStream.adapt(Sink<Long> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            n0Var = new j$.util.n0(m5Var, 1);
        }
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (b1VarT.tryAdvance(n0Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final z1 I(long j10, IntFunction intFunction) {
        return w3.Q(j10);
    }

    @Override // j$.util.stream.g
    public final j$.util.q0 iterator() {
        j$.util.b1 b1VarSpliterator = spliterator();
        Objects.requireNonNull(b1VarSpliterator);
        return new j$.util.i1(b1VarSpliterator);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final j$.util.b1 spliterator() {
        return T(super.spliterator());
    }

    @Override // j$.util.stream.n1
    public final e0 asDoubleStream() {
        return new t(this, z6.f9824n, 5);
    }

    @Override // j$.util.stream.n1
    public final Stream boxed() {
        return new r(this, 0, new d1(0), 2);
    }

    @Override // j$.util.stream.n1
    public final n1 e() {
        Objects.requireNonNull(null);
        return new v(this, z6.f9826p | z6.f9824n, 3);
    }

    @Override // j$.util.stream.n1
    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new r(this, z6.f9826p | z6.f9824n, longFunction, 2);
    }

    @Override // j$.util.stream.n1
    public final IntStream x() {
        Objects.requireNonNull(null);
        return new u(this, z6.f9826p | z6.f9824n, 4);
    }

    @Override // j$.util.stream.n1
    public final e0 h() {
        Objects.requireNonNull(null);
        return new t(this, z6.f9826p | z6.f9824n, 6);
    }

    @Override // j$.util.stream.n1
    public final n1 b(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new g1(this, z6.f9826p | z6.f9824n | z6.t, qVar, 0);
    }

    @Override // j$.util.stream.n1
    public final n1 c() {
        Objects.requireNonNull(null);
        return new v(this, z6.t, 5);
    }

    @Override // j$.util.stream.n1
    public final n1 peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new g1(this, longConsumer);
    }

    @Override // j$.util.stream.n1
    public final n1 limit(long j10) {
        if (j10 < 0) {
            j$.time.g.c(Long.toString(j10));
            return null;
        }
        return w3.W(this, 0L, j10);
    }

    @Override // j$.util.stream.n1
    public final n1 skip(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? this : w3.W(this, j10, -1L);
        }
        j$.time.g.c(Long.toString(j10));
        return null;
    }

    @Override // j$.util.stream.n1
    public final n1 a() {
        int i10 = z8.f9836a;
        Objects.requireNonNull(null);
        return new g6(this, z8.f9836a, 1);
    }

    @Override // j$.util.stream.n1
    public final n1 d() {
        int i10 = z8.f9836a;
        Objects.requireNonNull(null);
        return new g6(this, z8.f9837b, 2);
    }

    @Override // j$.util.stream.n1
    public final n1 distinct() {
        return ((e5) boxed()).distinct().mapToLong(new d1(7));
    }

    @Override // j$.util.stream.n1
    public final long sum() {
        return reduce(0L, new d1(5));
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 min() {
        return reduce(new d1(6));
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 max() {
        return reduce(new d1(4));
    }

    @Override // j$.util.stream.n1
    public final j$.util.c0 average() {
        long j10 = ((long[]) collect(new d1(1), new d1(2), new d1(3)))[0];
        return j10 > 0 ? new j$.util.c0(r0[1] / j10) : j$.util.c0.f9351c;
    }

    @Override // j$.util.stream.n1
    public final long reduce(long j10, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) C(new x3(a7.LONG_VALUE, longBinaryOperator, j10))).longValue();
    }

    @Override // j$.util.stream.n1
    public final j$.util.a0 summaryStatistics() {
        return (j$.util.a0) collect(new j$.time.format.a(14), new q(27), new q(28));
    }

    @Override // j$.util.stream.n1
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(pVar);
        return C(new b4(a7.LONG_VALUE, pVar, objLongConsumer, supplier, 0));
    }

    @Override // j$.util.stream.n1
    public final boolean n() {
        return ((Boolean) C(w3.V(u1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final j$.util.e0 reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (j$.util.e0) C(new z3(a7.LONG_VALUE, longBinaryOperator, 0));
    }

    @Override // j$.util.stream.n1
    public final boolean u() {
        return ((Boolean) C(w3.V(u1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final boolean j() {
        return ((Boolean) C(w3.V(u1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.n1
    public final long[] toArray() {
        return (long[]) w3.M((f2) D(new q(29))).b();
    }

    @Override // j$.util.stream.n1
    public final long count() {
        return ((Long) C(new d4(0))).longValue();
    }
}

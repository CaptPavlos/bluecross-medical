package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public abstract class b0 extends a implements e0 {
    @Override // j$.util.stream.e0
    public final j$.util.c0 findAny() {
        return (j$.util.c0) C(g0.f9580d);
    }

    @Override // j$.util.stream.e0
    public final j$.util.c0 findFirst() {
        return (j$.util.c0) C(g0.f9579c);
    }

    @Override // j$.util.stream.e0
    public final e0 sorted() {
        return new e6(this, z6.f9827q | z6.f9825o, 0);
    }

    public static j$.util.v0 T(Spliterator spliterator) {
        if (spliterator instanceof j$.util.v0) {
            return (j$.util.v0) spliterator;
        }
        if (h8.f9599a) {
            h8.a(a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // j$.util.stream.e0
    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        C(new n0(doubleConsumer, false));
    }

    @Override // j$.util.stream.e0
    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        C(new n0(doubleConsumer, true));
    }

    @Override // j$.util.stream.a
    public final a7 H() {
        return a7.DOUBLE_VALUE;
    }

    @Override // j$.util.stream.a
    public final h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        return w3.C(aVar, spliterator, z9);
    }

    @Override // j$.util.stream.a
    public final Spliterator P(a aVar, Supplier supplier, boolean z9) {
        return new k7(aVar, supplier, z9);
    }

    @Override // j$.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        DoubleConsumer f0Var;
        boolean zE;
        j$.util.v0 v0VarT = T(spliterator);
        if (m5Var instanceof DoubleConsumer) {
            f0Var = (DoubleConsumer) m5Var;
        } else {
            if (h8.f9599a) {
                h8.a(a.class, "using DoubleStream.adapt(Sink<Double> s)");
                throw null;
            }
            Objects.requireNonNull(m5Var);
            f0Var = new j$.util.f0(m5Var, 1);
        }
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (v0VarT.tryAdvance(f0Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final z1 I(long j10, IntFunction intFunction) {
        return w3.G(j10);
    }

    @Override // j$.util.stream.g
    public final j$.util.i0 iterator() {
        j$.util.v0 v0VarSpliterator = spliterator();
        Objects.requireNonNull(v0VarSpliterator);
        return new j$.util.j1(v0VarSpliterator);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final j$.util.v0 spliterator() {
        return T(super.spliterator());
    }

    @Override // j$.util.stream.e0
    public final Stream boxed() {
        return new r(this, 0, new j$.time.format.a(25), 0);
    }

    @Override // j$.util.stream.e0
    public final e0 e() {
        Objects.requireNonNull(null);
        return new t(this, z6.f9826p | z6.f9824n, 0);
    }

    @Override // j$.util.stream.e0
    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new r(this, z6.f9826p | z6.f9824n, doubleFunction, 0);
    }

    @Override // j$.util.stream.e0
    public final IntStream w() {
        Objects.requireNonNull(null);
        return new u(this, z6.f9826p | z6.f9824n, 0);
    }

    @Override // j$.util.stream.e0
    public final n1 t() {
        Objects.requireNonNull(null);
        return new v(this, z6.f9826p | z6.f9824n, 0);
    }

    @Override // j$.util.stream.e0
    public final e0 b(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new x(this, z6.f9826p | z6.f9824n | z6.t, qVar, 0);
    }

    @Override // j$.util.stream.e0
    public final e0 c() {
        Objects.requireNonNull(null);
        return new t(this, z6.t, 2);
    }

    @Override // j$.util.stream.e0
    public final e0 peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new x(this, doubleConsumer);
    }

    @Override // j$.util.stream.e0
    public final e0 limit(long j10) {
        if (j10 < 0) {
            j$.time.g.c(Long.toString(j10));
            return null;
        }
        return w3.S(this, 0L, j10);
    }

    @Override // j$.util.stream.e0
    public final e0 skip(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? this : w3.S(this, j10, -1L);
        }
        j$.time.g.c(Long.toString(j10));
        return null;
    }

    @Override // j$.util.stream.e0
    public final e0 a() {
        int i10 = z8.f9836a;
        Objects.requireNonNull(null);
        return new e6(this, z8.f9836a, 1);
    }

    @Override // j$.util.stream.e0
    public final e0 d() {
        int i10 = z8.f9836a;
        Objects.requireNonNull(null);
        return new e6(this, z8.f9837b, 2);
    }

    @Override // j$.util.stream.e0
    public final e0 distinct() {
        return ((e5) boxed()).distinct().mapToDouble(new j$.time.format.a(26));
    }

    @Override // j$.util.stream.e0
    public final double sum() {
        double[] dArr = (double[]) collect(new j$.time.format.a(29), new q(0), new q(1));
        Set set = Collectors.f9498a;
        double d8 = dArr[0] + dArr[1];
        double d10 = dArr[dArr.length - 1];
        return (Double.isNaN(d8) && Double.isInfinite(d10)) ? d10 : d8;
    }

    @Override // j$.util.stream.e0
    public final j$.util.c0 min() {
        return reduce(new q(2));
    }

    @Override // j$.util.stream.e0
    public final j$.util.c0 max() {
        return reduce(new j$.time.format.a(28));
    }

    @Override // j$.util.stream.e0
    public final j$.util.c0 average() {
        double[] dArr = (double[]) collect(new q(3), new q(4), new q(5));
        if (dArr[2] <= 0.0d) {
            return j$.util.c0.f9351c;
        }
        Set set = Collectors.f9498a;
        double d8 = dArr[0] + dArr[1];
        double d10 = dArr[dArr.length - 1];
        if (Double.isNaN(d8) && Double.isInfinite(d10)) {
            d8 = d10;
        }
        return new j$.util.c0(d8 / dArr[2]);
    }

    @Override // j$.util.stream.e0
    public final j$.util.x summaryStatistics() {
        return (j$.util.x) collect(new j$.time.format.a(10), new q(6), new j$.time.format.a(24));
    }

    @Override // j$.util.stream.e0
    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        p pVar = new p(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(pVar);
        return C(new b4(a7.DOUBLE_VALUE, pVar, objDoubleConsumer, supplier, 1));
    }

    @Override // j$.util.stream.e0
    public final boolean k() {
        return ((Boolean) C(w3.R(u1.ANY))).booleanValue();
    }

    @Override // j$.util.stream.e0
    public final boolean s() {
        return ((Boolean) C(w3.R(u1.ALL))).booleanValue();
    }

    @Override // j$.util.stream.e0
    public final boolean y() {
        return ((Boolean) C(w3.R(u1.NONE))).booleanValue();
    }

    @Override // j$.util.stream.e0
    public final double[] toArray() {
        return (double[]) w3.K((b2) D(new j$.time.format.a(27))).b();
    }

    @Override // j$.util.stream.e0
    public final double reduce(double d8, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) C(new f4(a7.DOUBLE_VALUE, doubleBinaryOperator, d8))).doubleValue();
    }

    @Override // j$.util.stream.e0
    public final j$.util.c0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (j$.util.c0) C(new z3(a7.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }

    @Override // j$.util.stream.e0
    public final long count() {
        return ((Long) C(new d4(1))).longValue();
    }
}

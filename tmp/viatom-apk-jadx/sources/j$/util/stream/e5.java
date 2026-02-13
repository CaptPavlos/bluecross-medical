package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: classes2.dex */
public abstract class e5 extends a implements Stream {
    @Override // j$.util.stream.Stream
    public final Stream sorted() {
        return new h6(this);
    }

    @Override // j$.util.stream.Stream
    public final Stream distinct() {
        return new n(this, z6.f9823m | z6.t);
    }

    @Override // j$.util.stream.Stream
    public final j$.util.b0 min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new j$.util.function.a(comparator, 1));
    }

    @Override // j$.util.stream.Stream
    public final j$.util.b0 findAny() {
        return (j$.util.b0) C(j0.f9617d);
    }

    @Override // j$.util.stream.Stream
    public final j$.util.b0 findFirst() {
        return (j$.util.b0) C(j0.f9616c);
    }

    @Override // j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new h6(this, comparator);
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return C(new b4(a7.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    @Override // j$.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return C(new b4(a7.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C(new q0(consumer, false));
    }

    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        C(new q0(consumer, true));
    }

    @Override // j$.util.stream.Stream
    public final j$.util.b0 max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new j$.util.function.a(comparator, 0));
    }

    @Override // j$.util.stream.a
    public final a7 H() {
        return a7.REFERENCE;
    }

    @Override // j$.util.stream.Stream
    public final j$.util.b0 reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (j$.util.b0) C(new z3(a7.REFERENCE, binaryOperator, 2));
    }

    @Override // j$.util.stream.a
    public final h2 E(a aVar, Spliterator spliterator, boolean z9, IntFunction intFunction) {
        return w3.B(aVar, spliterator, z9, intFunction);
    }

    @Override // j$.util.stream.a
    public final Spliterator P(a aVar, Supplier supplier, boolean z9) {
        return new d8(aVar, supplier, z9);
    }

    @Override // j$.util.stream.a
    public final boolean G(Spliterator spliterator, m5 m5Var) {
        boolean zE;
        do {
            zE = m5Var.e();
            if (zE) {
                break;
            }
        } while (spliterator.tryAdvance(m5Var));
        return zE;
    }

    @Override // j$.util.stream.a
    public final z1 I(long j10, IntFunction intFunction) {
        return w3.z(j10, intFunction);
    }

    @Override // j$.util.stream.g
    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j$.util.g1(spliterator);
    }

    @Override // j$.util.stream.Stream
    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new r(this, z6.t, predicate, 4);
    }

    @Override // j$.util.stream.Stream
    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new r(this, z6.f9826p | z6.f9824n, function, 5);
    }

    @Override // j$.util.stream.Stream
    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new v0(this, z6.f9826p | z6.f9824n, toIntFunction, 2);
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return C(new b4(a7.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }

    @Override // j$.util.stream.Stream
    public final n1 mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new g1(this, z6.f9826p | z6.f9824n, toLongFunction, 3);
    }

    @Override // j$.util.stream.Stream
    public final e0 mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new x(this, z6.f9826p | z6.f9824n, toDoubleFunction, 2);
    }

    @Override // j$.util.stream.Stream
    public final long count() {
        return ((Long) C(new d4(2))).longValue();
    }

    @Override // j$.util.stream.Stream
    public final Stream b(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new r(this, z6.f9826p | z6.f9824n | z6.t, qVar, 6);
    }

    @Override // j$.util.stream.Stream
    public final IntStream r(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new v0(this, z6.f9826p | z6.f9824n | z6.t, qVar, 3);
    }

    @Override // j$.util.stream.Stream
    public final e0 p(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new x(this, z6.f9826p | z6.f9824n | z6.t, qVar, 3);
    }

    @Override // j$.util.stream.Stream
    public final Object collect(Collector collector) {
        Collector collector2;
        Object objC;
        if (!this.f9503a.f9509k || !collector.characteristics().contains(h.CONCURRENT) || (z6.ORDERED.j(this.f) && !collector.characteristics().contains(h.UNORDERED))) {
            Supplier supplier = ((Collector) Objects.requireNonNull(collector)).supplier();
            collector2 = collector;
            objC = C(new i4(a7.REFERENCE, collector.combiner(), collector.accumulator(), supplier, collector2));
        } else {
            objC = collector.supplier().get();
            forEach(new j$.util.concurrent.t(7, collector.accumulator(), objC));
            collector2 = collector;
        }
        return collector2.characteristics().contains(h.IDENTITY_FINISH) ? objC : collector2.finisher().apply(objC);
    }

    @Override // j$.util.stream.Stream
    public final n1 l(j$.util.q qVar) {
        Objects.requireNonNull(qVar);
        return new g1(this, z6.f9826p | z6.f9824n | z6.t, qVar, 2);
    }

    @Override // j$.util.stream.Stream
    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new r(this, consumer);
    }

    @Override // j$.util.stream.Stream
    public final Stream limit(long j10) {
        if (j10 < 0) {
            j$.time.g.c(Long.toString(j10));
            return null;
        }
        return w3.Y(this, 0L, j10);
    }

    @Override // j$.util.stream.Stream
    public final Stream skip(long j10) {
        if (j10 >= 0) {
            return j10 == 0 ? this : w3.Y(this, j10, -1L);
        }
        j$.time.g.c(Long.toString(j10));
        return null;
    }

    @Override // j$.util.stream.Stream
    public final Stream takeWhile(Predicate predicate) {
        int i10 = z8.f9836a;
        Objects.requireNonNull(predicate);
        return new i8(this, z8.f9836a, predicate, 0);
    }

    @Override // j$.util.stream.Stream
    public final Stream dropWhile(Predicate predicate) {
        int i10 = z8.f9836a;
        Objects.requireNonNull(predicate);
        return new i8(this, z8.f9837b, predicate, 1);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return w3.J(D(intFunction), intFunction).m(intFunction);
    }

    @Override // j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new d1(17));
    }

    @Override // j$.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) C(w3.X(u1.ANY, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) C(w3.X(u1.ALL, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) C(w3.X(u1.NONE, predicate))).booleanValue();
    }

    @Override // j$.util.stream.Stream
    public final List toList() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(toArray())));
    }
}

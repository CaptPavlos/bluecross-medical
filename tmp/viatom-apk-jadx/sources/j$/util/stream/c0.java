package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

/* loaded from: classes2.dex */
public final /* synthetic */ class c0 implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoubleStream f9536a;

    public /* synthetic */ c0(DoubleStream doubleStream) {
        this.f9536a = doubleStream;
    }

    public static /* synthetic */ e0 g(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof d0 ? ((d0) doubleStream).f9553a : new c0(doubleStream);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 a() {
        return g(this.f9536a.takeWhile(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 average() {
        return j$.util.c.j(this.f9536a.average());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Stream boxed() {
        return x6.g(this.f9536a.boxed());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 c() {
        return g(this.f9536a.filter(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f9536a.close();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f9536a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ long count() {
        return this.f9536a.count();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 d() {
        return g(this.f9536a.dropWhile(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 distinct() {
        return g(this.f9536a.distinct());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 e() {
        return g(this.f9536a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f9536a;
        if (obj instanceof c0) {
            obj = ((c0) obj).f9536a;
        }
        return doubleStream.equals(obj);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 findAny() {
        return j$.util.c.j(this.f9536a.findAny());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 findFirst() {
        return j$.util.c.j(this.f9536a.findFirst());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f9536a.forEach(doubleConsumer);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f9536a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9536a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f9536a.isParallel();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.PrimitiveIterator$OfDouble] */
    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ j$.util.i0 iterator() {
        ?? it = this.f9536a.iterator();
        if (it == 0) {
            return null;
        }
        return it instanceof j$.util.h0 ? ((j$.util.h0) it).f9446a : new j$.util.g0(it);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f9536a.iterator();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean k() {
        return this.f9536a.anyMatch(null);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 limit(long j10) {
        return g(this.f9536a.limit(j10));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return x6.g(this.f9536a.mapToObj(doubleFunction));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 max() {
        return j$.util.c.j(this.f9536a.max());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 min() {
        return j$.util.c.j(this.f9536a.min());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return e.g(this.f9536a.onClose(runnable));
    }

    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ e0 parallel() {
        return g(this.f9536a.parallel());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return e.g(this.f9536a.parallel());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 peek(DoubleConsumer doubleConsumer) {
        return g(this.f9536a.peek(doubleConsumer));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double reduce(double d8, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f9536a.reduce(d8, doubleBinaryOperator);
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ j$.util.c0 reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return j$.util.c.j(this.f9536a.reduce(doubleBinaryOperator));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean s() {
        return this.f9536a.allMatch(null);
    }

    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ e0 sequential() {
        return g(this.f9536a.sequential());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return e.g(this.f9536a.sequential());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 skip(long j10) {
        return g(this.f9536a.skip(j10));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ e0 sorted() {
        return g(this.f9536a.sorted());
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f9536a.spliterator());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Spliterator$OfDouble] */
    @Override // j$.util.stream.e0, j$.util.stream.g
    public final /* synthetic */ j$.util.v0 spliterator() {
        return j$.util.t0.a(this.f9536a.spliterator());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double sum() {
        return this.f9536a.sum();
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ n1 t() {
        return l1.g(this.f9536a.mapToLong(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ double[] toArray() {
        return this.f9536a.toArray();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return e.g(this.f9536a.unordered());
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ IntStream w() {
        return IntStream.VivifiedWrapper.convert(this.f9536a.mapToInt(null));
    }

    @Override // j$.util.stream.e0
    public final /* synthetic */ boolean y() {
        return this.f9536a.noneMatch(null);
    }

    @Override // j$.util.stream.e0
    public final j$.util.x summaryStatistics() {
        this.f9536a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // j$.util.stream.e0
    public final e0 b(j$.util.q qVar) {
        DoubleStream doubleStream = this.f9536a;
        j$.util.q qVar2 = new j$.util.q(5);
        qVar2.f9483b = qVar;
        return g(doubleStream.flatMap(qVar2));
    }
}

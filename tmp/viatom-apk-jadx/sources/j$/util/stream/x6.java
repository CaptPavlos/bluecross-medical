package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
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
public final /* synthetic */ class x6 implements Stream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ java.util.stream.Stream f9804a;

    public /* synthetic */ x6(java.util.stream.Stream stream) {
        this.f9804a = stream;
    }

    public static /* synthetic */ Stream g(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new x6(stream);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f9804a.allMatch(predicate);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f9804a.anyMatch(predicate);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream b(j$.util.q qVar) {
        return g(this.f9804a.flatMap(w3.O(qVar)));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f9804a.close();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object collect(Collector collector) {
        return this.f9804a.collect(collector == null ? null : collector instanceof i ? ((i) collector).f9600a : new j(collector));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f9804a.collect(supplier, biConsumer, biConsumer2);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ long count() {
        return this.f9804a.count();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return g(this.f9804a.distinct());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return g(this.f9804a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.f9804a;
        if (obj instanceof x6) {
            obj = ((x6) obj).f9804a;
        }
        return stream.equals(obj);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream filter(Predicate predicate) {
        return g(this.f9804a.filter(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 findAny() {
        return j$.util.c.i(this.f9804a.findAny());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 findFirst() {
        return j$.util.c.i(this.f9804a.findFirst());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f9804a.forEach(consumer);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f9804a.forEachOrdered(consumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f9804a.hashCode();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ boolean isParallel() {
        return this.f9804a.isParallel();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Iterator iterator() {
        return this.f9804a.iterator();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ n1 l(j$.util.q qVar) {
        return l1.g(this.f9804a.flatMapToLong(w3.O(qVar)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream limit(long j10) {
        return g(this.f9804a.limit(j10));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream map(Function function) {
        return g(this.f9804a.map(function));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ e0 mapToDouble(ToDoubleFunction toDoubleFunction) {
        return c0.g(this.f9804a.mapToDouble(toDoubleFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f9804a.mapToInt(toIntFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ n1 mapToLong(ToLongFunction toLongFunction) {
        return l1.g(this.f9804a.mapToLong(toLongFunction));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 max(Comparator comparator) {
        return j$.util.c.i(this.f9804a.max(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 min(Comparator comparator) {
        return j$.util.c.i(this.f9804a.min(comparator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f9804a.noneMatch(predicate);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g onClose(Runnable runnable) {
        return e.g(this.f9804a.onClose(runnable));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ e0 p(j$.util.q qVar) {
        return c0.g(this.f9804a.flatMapToDouble(w3.O(qVar)));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g parallel() {
        return e.g(this.f9804a.parallel());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream peek(Consumer consumer) {
        return g(this.f9804a.peek(consumer));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ IntStream r(j$.util.q qVar) {
        return IntStream.VivifiedWrapper.convert(this.f9804a.flatMapToInt(w3.O(qVar)));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ j$.util.b0 reduce(BinaryOperator binaryOperator) {
        return j$.util.c.i(this.f9804a.reduce(binaryOperator));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f9804a.reduce(obj, biFunction, binaryOperator);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f9804a.reduce(obj, binaryOperator);
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g sequential() {
        return e.g(this.f9804a.sequential());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream skip(long j10) {
        return g(this.f9804a.skip(j10));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted() {
        return g(this.f9804a.sorted());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return g(this.f9804a.sorted(comparator));
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.f1.a(this.f9804a.spliterator());
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return g(this.f9804a.takeWhile(predicate));
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray() {
        return this.f9804a.toArray();
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f9804a.toArray(intFunction);
    }

    @Override // j$.util.stream.Stream
    public final /* synthetic */ List toList() {
        return this.f9804a.toList();
    }

    @Override // j$.util.stream.g
    public final /* synthetic */ g unordered() {
        return e.g(this.f9804a.unordered());
    }
}

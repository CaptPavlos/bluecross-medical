package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public interface n1 extends g {
    n1 a();

    e0 asDoubleStream();

    j$.util.c0 average();

    n1 b(j$.util.q qVar);

    Stream boxed();

    n1 c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    n1 d();

    n1 distinct();

    n1 e();

    j$.util.e0 findAny();

    j$.util.e0 findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    e0 h();

    @Override // j$.util.stream.g
    j$.util.q0 iterator();

    boolean j();

    n1 limit(long j10);

    Stream mapToObj(LongFunction longFunction);

    j$.util.e0 max();

    j$.util.e0 min();

    boolean n();

    @Override // j$.util.stream.g
    n1 parallel();

    n1 peek(LongConsumer longConsumer);

    long reduce(long j10, LongBinaryOperator longBinaryOperator);

    j$.util.e0 reduce(LongBinaryOperator longBinaryOperator);

    @Override // j$.util.stream.g
    n1 sequential();

    n1 skip(long j10);

    n1 sorted();

    @Override // j$.util.stream.g
    j$.util.b1 spliterator();

    long sum();

    j$.util.a0 summaryStatistics();

    long[] toArray();

    boolean u();

    IntStream x();
}

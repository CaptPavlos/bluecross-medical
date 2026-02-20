package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* loaded from: classes2.dex */
public interface e0 extends g {
    e0 a();

    j$.util.c0 average();

    e0 b(j$.util.q qVar);

    Stream boxed();

    e0 c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    e0 d();

    e0 distinct();

    e0 e();

    j$.util.c0 findAny();

    j$.util.c0 findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // j$.util.stream.g
    j$.util.i0 iterator();

    boolean k();

    e0 limit(long j10);

    Stream mapToObj(DoubleFunction doubleFunction);

    j$.util.c0 max();

    j$.util.c0 min();

    @Override // j$.util.stream.g
    e0 parallel();

    e0 peek(DoubleConsumer doubleConsumer);

    double reduce(double d8, DoubleBinaryOperator doubleBinaryOperator);

    j$.util.c0 reduce(DoubleBinaryOperator doubleBinaryOperator);

    boolean s();

    @Override // j$.util.stream.g
    e0 sequential();

    e0 skip(long j10);

    e0 sorted();

    @Override // j$.util.stream.g
    j$.util.v0 spliterator();

    double sum();

    j$.util.x summaryStatistics();

    n1 t();

    double[] toArray();

    IntStream w();

    boolean y();
}
